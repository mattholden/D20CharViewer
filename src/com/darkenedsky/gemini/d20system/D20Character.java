package com.darkenedsky.gemini.d20system;
import java.util.*;
import org.jdom.Element;
import com.darkenedsky.gemini.common.Frequency;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.RuleObject;
import com.darkenedsky.gemini.common.Specialized;
import com.darkenedsky.gemini.common.Statistic;
import com.darkenedsky.gemini.common.XMLTools;
import com.darkenedsky.gemini.common.modifier.Bonus;

public class D20Character extends GameCharacter implements D20 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2435348998743374460L;
	
	private D20Size size;
	private D20Alignment alignment;
	private ArrayList<D20ClassLevel> levels = new ArrayList<D20ClassLevel>();
	private Map<Specialized<D20Feat>, Integer> feats = new HashMap<Specialized<D20Feat>, Integer>();
	private Map<Specialized<D20Feat>, Frequency> abilities = new HashMap<Specialized<D20Feat>, Frequency>();
	private Map<Specialized<D20Skill>, D20SkillRank> skills = new HashMap<Specialized<D20Skill>, D20SkillRank>(20);
	
	private D20CreatureType creatureType;
	private D20CreatureSubTypeInterface creatureSubType;
	
	// temp variables used during chargen/levelup
	private int skillsAvailable, featsAvailable;
	private int ageClass;
	private int levelsToGain = 1;
	
	
	public D20SkillRank getSkill(D20Skill skill) { return getSkill(skill,null);}
	
	public D20SkillRank getSkill(D20Skill skill, String spec) { 
		Specialized<D20Skill> key = new Specialized<D20Skill>(skill, spec);
		D20SkillRank rank = skills.get(key);
		
		// if there's no rank, add it with 0 ranks.
		// do this so we can record bonuses even if we have no rank
		// we dont do this in the constructor because we never know what specializations we'll see
		if (rank == null) { 
			rank = new D20SkillRank(skill, this);						
			skills.put(key, rank);			
		}
		return rank;
	}
	
	public D20CreatureType getCreatureType() { return creatureType; }
	public D20CreatureSubTypeInterface getCreatureSubType() { return creatureSubType; }
	
	public boolean addSkillRank(D20Skill skill, String spec, boolean crossClass, boolean free) { 
				
		D20SkillRank existing = getSkill(skill,spec);
		
		// can't add if we're at max.
		int max = this.getCharacterLevel() + 3;
		if (crossClass)
			max /= 2;
		if (existing != null && existing.getBaseValue() >= max)
			return false;

		// need points?
		if (!free) {
			if (skillsAvailable <= 0)
				return false;
			skillsAvailable--;
		}

		if (existing == null) { 
			existing = new D20SkillRank(skill, this);
			Specialized<D20Skill> key = new Specialized<D20Skill>(skill, spec);
			skills.put(key, existing);
		}
				
		if (crossClass)
			existing.addHalfRank();
		else
			existing.setBaseValue(existing.getBaseValue()+1);
		
		skill.onGain(this);

		// gain synergy bonuses
		if (existing.getBaseValue() == 5) { 
			skill.applySynergy(spec, this);
		}

		return true;
	}
	
	@Override
	public void dropBonuses(RuleObject source) { 
		super.dropBonuses(source);
		for (Statistic rank : skills.values())
			rank.dropBonuses(source);
	}

	@Override
	public void addBonus(int stat, Bonus b) { 
			
		if (stat == ALL_SAVES) { 
			getStat(FORT).addBonus(b);
			getStat(REFLEX).addBonus(b);
			getStat(WILL).addBonus(b);
		}
		else if (stat == ALL_ABILITY_SCORES) { 
			getStat(STR).addBonus(b);
			getStat(DEX).addBonus(b);
			getStat(CON).addBonus(b);
			getStat(INT).addBonus(b);
			getStat(WIS).addBonus(b);
			getStat(CHA).addBonus(b);
		}
		else {
			super.addBonus(stat, b);
		}
	}
	
	public int getFeatRanks(D20Feat feat, String spec) { 
		int ranks = 0;
		for (Map.Entry<Specialized<D20Feat>, Integer> entry : feats.entrySet()) { 
			if (entry.getKey().ability.equals(feat)) { 
				if (spec == null || (spec.equalsIgnoreCase(entry.getKey().specialization))) { 
					ranks += entry.getValue();
				}
			}
		}
		return ranks;
	}
	
	
	public boolean addFeat(D20Feat feat, String spec, boolean free) { 
		boolean added = false;
		
		// see if i can even do it
		if (!free && !feat.hasPrerequisites(this))
			return false;
		// can't take more than once.
		if (feat.isSpecialized() && getFeatRanks(feat,spec) > 0)
			return false;
		
		// need points?
		if (!free) {
			featsAvailable--;
		}
		for (Map.Entry<Specialized<D20Feat>, Integer> entry : feats.entrySet()) { 
			if (entry.getKey().ability.equals(feat)) { 
				if (spec == null && entry.getKey().specialization == null) { 
					feats.put(entry.getKey(), entry.getValue() + 1);
					added = true;
					break;
				}
				else if (spec != null && spec.equalsIgnoreCase(entry.getKey().specialization)) {
					feats.put(entry.getKey(), entry.getValue() + 1);
					added = true;
					break;
				}						
			}	
		}
		
		if (!added) { 
			Specialized<D20Feat> rank = new Specialized<D20Feat>(feat, spec);
			feats.put(rank, 1);
		}
		
		feat.onGain(this);
		return true;
	}
	
	public Frequency getAbilityFrequency(D20Feat feat, String spec) { 
		for (Map.Entry<Specialized<D20Feat>, Frequency> entry : abilities.entrySet()) { 
			if (entry.getKey().ability.equals(feat)) { 
				if ((spec == null && entry.getKey().specialization == null)
						|| (spec.equalsIgnoreCase(entry.getKey().specialization))) {
					return entry.getValue();
					
				}
			}
		}
		return null;
	}
	
	public boolean addAbility(D20Feat feat, String spec) { return addAbility(feat,spec,Frequency.AT_WILL); }

	public boolean addAbility(D20Feat feat, String spec, Frequency freq) { 
		
		// see if i can even do it
		if (!feat.hasPrerequisites(this))
			return false;
		
		// can't take more than once.
		Frequency freqNow = getAbilityFrequency(feat, spec);
		if (feat.isSpecialized() && freqNow != null)
			return false;
		
		if (freqNow != null) { 
			if (freqNow.getUnit().toString().equals(freq.getUnit().toString())) { 
				freqNow.setUses(freqNow.getUses() + freq.getUses());
			}
			else 
				freqNow = freq;			
		}
		else freqNow = freq;
		
		this.abilities.put(new Specialized<D20Feat>(feat,spec), freqNow);
		feat.onGain(this);
		return true;
	}
	

	/** 
	 * Get the modifier for an ability score
	 * @param score the ability score to check
	 */
	public int getAbilityScoreModifier(int score) { 
		if (score < 0 || score > 5) return 0;
		return ((statistics.get(score).getBaseValue())/2) - 5;
	}
	
	
	public ArrayList<D20ClassLevel> getLevelList() { 
		ArrayList<D20ClassLevel> copy = new ArrayList<D20ClassLevel>(levels.size());
		copy.addAll(levels);
		return copy;
	}
	
	public int getCharacterLevel() { 
		return levels.size();
	}
	
	public boolean addLevel(D20ClassLevel level) { 
		try {
			
			if (!level.getClassLeveled().hasPrerequisites(this)) return false;
			levels.add(level);
			level.getClassLeveled().onGain(this);
			return true;
		}
		catch (Exception x) { 
			x.printStackTrace();
			return false;
		}
	}
	
	public int getLevelOfClass(D20Class claz) { 
		int i = 0;
		for (D20ClassLevel c : levels) { 
			
			if (claz.equals(c.getClassLeveled()))
				i++;			
		}
		return i;
	}
	
	public Map<D20Class, Integer> getLevelMap() { 		
		Map<D20Class,Integer> lvl = new HashMap<D20Class, Integer>();
		
		for (D20ClassLevel c : levels) { 
			Integer i = lvl.get(c.getClassLeveled());
			if (i == null)
				i = 0;
			i++;
			lvl.put(c.getClassLeveled(),i);
		}
		return lvl;
	}
	
	public D20Class getClassForLevel(int lvl) { 
		int level = lvl - 1;
		if (level < 0 || level >= levels.size()) return null;		
		return levels.get(level).getClassLeveled();
	}
	
	public D20Race getRace() {
		return race;
	}

	public boolean setRace(D20Race race) {
		if (!race.hasPrerequisites(this)) return false;
				
		creatureType = race.getCreatureType();
		creatureType.onGain(this);
		
		creatureSubType = race;
		creatureSubType.onGain(this);

		this.race = race;		
		return true;
	}


	public D20Alignment getAlignment() {
		return alignment;
	}

	public boolean setAlignment(D20Alignment alignment) {
		if (!alignment.hasPrerequisites(this)) return false;
		this.alignment = alignment;
		alignment.onGain(this);
		return true;
	}

	public int getSkillsAvailable() {
		return skillsAvailable;
	}

	public void setSkillsAvailable(int skillsAvailable) {
		this.skillsAvailable = skillsAvailable;
	}

	public int getFeatsAvailable() {
		return featsAvailable;
	}

	public void setFeatsAvailable(int featsAvailable) {
		this.featsAvailable = featsAvailable;
	}

	public boolean setSize(D20Size size) {
		if (!size.hasPrerequisites(this)) return false;
		this.size = size;
		size.onGain(this);
		return true;
	}

	public D20Size getSize() {
		return size;
	}

	public void setAgeClass(int desiredAgeClass) {
		this.ageClass = desiredAgeClass;
	}

	public int getAgeClass() {
		return ageClass;
	}
	
	
	
	public void setLevelsToGain(int levelsToGain) {
		this.levelsToGain = levelsToGain;
	}

	public int getLevelsToGain() {
		return levelsToGain;
	}



	@Override
	public Element toXML(String root) { 
		Element e = super.toXML(root);
		
		e.addContent(XMLTools.xml("skillsavailable", skillsAvailable));
		e.addContent(XMLTools.xml("featsavailable", featsAvailable));
		e.addContent(XMLTools.xml("levelstogain", levelsToGain));
		e.addContent(XMLTools.xml("ageclass", ageClass));
		if (race != null)
			e.addContent(XMLTools.xml("race", race.getUniqueID()));
		if (size != null)
			e.addContent(XMLTools.xml("size", size.getUniqueID()));
		if (alignment != null)
			e.addContent(XMLTools.xml("alignment", alignment.getUniqueID()));
		if (creatureType != null)
			e.addContent(XMLTools.xml("creatureType", creatureType.getUniqueID()));
		if (creatureSubType != null)
			e.addContent(XMLTools.xml("creatureSubType", creatureSubType.getUniqueID()));
		
		
		for (int ilevel = 0; ilevel < levels.size(); ilevel++) { 
			Element elevel = levels.get(ilevel).toXML("classlevel");
			elevel.addContent(XMLTools.xml("levelorder", ilevel));			
			e.addContent(elevel);
		}
		
		for (Map.Entry<Specialized<D20Skill>, D20SkillRank> skill : skills.entrySet()) { 
			Element s = new Element("skillrank");
			s.addContent(XMLTools.xml("skill", skill.getKey().ability.getUniqueID()));
			s.addContent(XMLTools.xml("specialization", skill.getKey().specialization));
			s.addContent(skill.getValue().toXML("statistic"));
		}
		for (Map.Entry<Specialized<D20Feat>, Integer> entry : feats.entrySet()) { 
			Element f = (entry.getKey().toXML("feat"));
			f.addContent(XMLTools.xml("ranks", entry.getValue()));
			e.addContent(f);
		}
		for (Map.Entry<Specialized<D20Feat>, Frequency> entry : abilities.entrySet())  {
			Element a = (entry.getKey().toXML("ability"));
			a.addContent(entry.getValue().toXML("frequency"));
			e.addContent(a);
		}
			
		return e;
	}

	@SuppressWarnings("rawtypes")
	public D20Character(Element e) throws Exception {
		super(e);
		
		ageClass = XMLTools.getInt(e,"ageclass");
		skillsAvailable = XMLTools.getInt(e,"skillsavailable");
		featsAvailable = XMLTools.getInt(e,"featsavailable");
		levelsToGain = XMLTools.getInt(e,"levelstogain");
		race = (D20Race)library.getByID(XMLTools.getString(e,"race"));
		size = D20Size.load(XMLTools.getString(e,"size"));
		alignment = D20Alignment.load(XMLTools.getString(e,"alignment"));
		creatureType = (D20CreatureType)library.getByID(XMLTools.getString(e,"creatureType"));
		creatureSubType = (D20CreatureSubTypeInterface)library.getByID(XMLTools.getString(e,"creatureSubType"));
		
		
		List lv = e.getChildren("level");
		for (int i = 0; i < lv.size(); i++) { 
			Element lvl = (Element)lv.get(i);
			
			levels.add((D20ClassLevel)XMLTools.dynamicLoad(lvl));
		}
		
		List sk = e.getChildren("skill");
		for (int i = 0; i < sk.size(); i++) { 
			Element skyll = (Element)sk.get(i);
			Element a = skyll.getChild("skill");
			D20Skill skill = (D20Skill)library.getByID(a.getText());			
			Element spec = skyll.getChild("specialization");
			String special = null;
			if (spec != null)
				special = spec.getText();
			Specialized<D20Skill> key = new Specialized<D20Skill>(skill, special);
			skills.put(key, (D20SkillRank)XMLTools.dynamicLoad(skyll.getChild("statistic")));					
		}
		
		List fe = e.getChildren("feat");
		for (int i = 0; i < fe.size(); i++) { 
			Element skyll = (Element)sk.get(i);
			Element a = skyll.getChild("ability");
			D20Feat skill = (D20Feat)library.getSection(FEATS).get(a.getText());
			Element spec = skyll.getChild("specialization");
			String special = null;
			if (spec != null)
				special = spec.getText();
			int ranks = Integer.parseInt(skyll.getChild("ranks").getText());
			Specialized<D20Feat> rank = new Specialized<D20Feat>(skill, special);
			feats.put(rank, ranks);			
		}
		
		List ab = e.getChildren("ability");
		for (int i = 0; i < fe.size(); i++) { 
			Element skyll = (Element)ab.get(i);
			Element a = skyll.getChild("ability");
			D20Feat skill = (D20Feat)library.getSection("abilities").get(a.getText());
			Element spec = skyll.getChild("specialization");
			String special = null;
			if (spec != null)
				special = spec.getText();
			Frequency f = new Frequency(skyll.getChild("frequency"));
			Specialized<D20Feat> rank = new Specialized<D20Feat>(skill, special);
			abilities.put(rank, f);			
		}
		
		
	}
	
	public D20Character(Library lib) {
		library = lib;
		
		// CORE STATS
		statistics.put(STR,new Statistic());
		statistics.put(DEX,new Statistic());
		statistics.put(CON,new Statistic());
		statistics.put(INT,new Statistic());
		statistics.put(WIS,new Statistic());
		statistics.put(CHA,new Statistic());
		statistics.put(FORT,new Statistic());
		statistics.put(REFLEX,new Statistic());
		statistics.put(WILL,new Statistic());
		statistics.put(ATTACK,new Statistic());
		statistics.put(DODGE,new Statistic());
		statistics.put(DAMAGE,new Statistic());
		statistics.put(DAMAGE_REDUCTION,new Statistic());
		statistics.put(INITIATIVE,new Statistic());
		statistics.put(BASE_SPEED,new Statistic());
		statistics.put(ARMOR_CLASS,new Statistic());
		statistics.put(RANGED_ATTACK, new Statistic());
		statistics.put(GRAPPLE_ATTACK, new Statistic());
		
	}
	
}
