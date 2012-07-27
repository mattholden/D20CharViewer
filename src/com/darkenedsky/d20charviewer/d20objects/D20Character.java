package com.darkenedsky.d20charviewer.d20objects;
import java.io.Serializable;
import java.util.*;
import org.jdom.Element;

import com.darkenedsky.d20charviewer.NumberTools;
import com.darkenedsky.d20charviewer.XMLTools;

public class D20Character implements D20Stats, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2435348998743374460L;
	private int[] abilityScores = new int[6];
	private int[] saves = new int[3];
	private int hp, maxHp, bab;
	private String name, hair, eyes, player;
	private boolean male;
	private D20Race race;
	private D20Size size;
	private D20Alignment alignment;
	private int height, weight, age, baseSpeed;
	private int xp = 0;
	
	private ArrayList<D20Class> levels = new ArrayList<D20Class>();
	private Map<SpecializableRank<D20Skill>, Float> skillRanks = new HashMap<SpecializableRank<D20Skill>, Float>();
	private Map<SpecializableRank<D20Feat>, Integer> feats = new HashMap<SpecializableRank<D20Feat>, Integer>();
	private Map<SpecializableRank<D20Feat>, Integer> abilities = new HashMap<SpecializableRank<D20Feat>, Integer>();
	
	// temp variables used during chargen/levelup
	private int skillsAvailable, featsAvailable;
	private int ageClass;
	private int levelsToGain = 1;
	
	public float getSkillRanks(D20Skill skill, String spec) { 
		
		float ranks = 0;
		for (Map.Entry<SpecializableRank<D20Skill>, Float> entry : skillRanks.entrySet()) { 
			if (entry.getKey().ability.equals(skill)) { 
				if (spec == null || (spec.equalsIgnoreCase(entry.getKey().specialization))) { 
					ranks += entry.getValue();
				}
			}
		}
		return ranks;
	}
	
	public boolean addSkillRank(D20Skill skill, String spec, boolean crossClass, boolean free) { 
		float toAdd = (crossClass)? 0.5f : 1f;
		boolean added = false;
		
		// need points?
		if (!free) {
			if (skillsAvailable <= 0)
				return false;
			skillsAvailable--;
		}
				
		// can't add if we're at max.
		float max = this.getCharacterLevel() + 3.0f;
		if (crossClass)
			max /= 2;
		if (getSkillRanks(skill,spec) >= max)
			return false;
		
		for (Map.Entry<SpecializableRank<D20Skill>, Float> entry : skillRanks.entrySet()) { 
			if (entry.getKey().ability.equals(skill)) { 
				if (spec == null && entry.getKey().specialization == null) { 
					skillRanks.put(entry.getKey(), entry.getValue() + toAdd);
					added = true;
					break;
				}
				else if (spec != null && spec.equalsIgnoreCase(entry.getKey().specialization)) {
					skillRanks.put(entry.getKey(), entry.getValue() + toAdd);
					added = true;
					break;
				}						
			}	
		}
		
		if (!added) { 
			SpecializableRank<D20Skill> rank = new SpecializableRank<D20Skill>(skill, spec);
			skillRanks.put(rank, toAdd);
		}
		
		skill.onGain(this);
		return true;
	}
	
	public int getFeatRanks(D20Feat feat, String spec) { 
		int ranks = 0;
		for (Map.Entry<SpecializableRank<D20Feat>, Integer> entry : feats.entrySet()) { 
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
		
		// need points?
		if (!free) {
			if (featsAvailable <= 0)
				return false;
			featsAvailable--;
		}
		
		// see if i can even do it
		if (!feat.hasPrerequisites(this))
			return false;
		// can't take more than once.
		if (!feat.isStacks() && getFeatRanks(feat,spec) > 0)
			return false;
		
		for (Map.Entry<SpecializableRank<D20Feat>, Integer> entry : feats.entrySet()) { 
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
			SpecializableRank<D20Feat> rank = new SpecializableRank<D20Feat>(feat, spec);
			feats.put(rank, 1);
		}
		
		feat.onGain(this);
		return true;
	}
	
	public int getAbilityRanks(D20Feat feat, String spec) { 
		int ranks = 0;
		for (Map.Entry<SpecializableRank<D20Feat>, Integer> entry : abilities.entrySet()) { 
			if (entry.getKey().ability.equals(feat)) { 
				if (spec == null || (spec.equalsIgnoreCase(entry.getKey().specialization))) { 
					ranks += entry.getValue();
				}
			}
		}
		return ranks;
	}
	
	public boolean addAbility(D20Feat feat, String spec) { 
		boolean added = false;
		
		// see if i can even do it
		if (!feat.hasPrerequisites(this))
			return false;
		// can't take more than once.
		if (!feat.isStacks() && getFeatRanks(feat,spec) > 0)
			return false;
		
		for (Map.Entry<SpecializableRank<D20Feat>, Integer> entry : feats.entrySet()) { 
			if (entry.getKey().ability.equals(feat)) { 
				if (spec == null && entry.getKey().specialization == null) { 
					abilities.put(entry.getKey(), entry.getValue() + 1);
					added = true;
					break;
				}
				else if (spec != null && spec.equalsIgnoreCase(entry.getKey().specialization)) {
					abilities.put(entry.getKey(), entry.getValue() + 1);
					added = true;
					break;
				}						
			}	
		}
		
		if (!added) { 
			SpecializableRank<D20Feat> rank = new SpecializableRank<D20Feat>(feat, spec);
			abilities.put(rank, 1);
		}
		
		feat.onGain(this);
		return true;
	}
	
	/** 
	 * Calculate the modifier for a score
	 * @param score
	 * @return
	 */
	private static int calculateModifier(int score) { 
		return ((score/2) - 5);
	}

	public int getAbilityScore(int score) { 
		if (score < 0 || score > 5) return -1;
		return abilityScores[score];
	}
	
	public void setAbilityScore(int score, int value) { 
		if (score < 0 || score > 5) return;
		abilityScores[score] = value;
	}
	
	/** 
	 * Get the modifier for an ability score
	 * @param score the ability score to check
	 */
	public int getModifier(int score) { 
		if (score < 0 || score > 5) return 0;
		return calculateModifier(abilityScores[score]);
	}
	
	public D20Character(String player) {
		this.player = player;
	}
	
	public int getCharacterLevel() { 
		return levels.size();
	}
	
	public boolean addLevel(D20Class level) { 
		if (!level.hasPrerequisites(this)) return false;
		
		levels.add(level);
		level.onGain(this);
		return true;
	}
	
	public Map<D20Class, Integer> getLevelMap() { 		
		Map<D20Class,Integer> lvl = new HashMap<D20Class, Integer>();
		for (D20Class c : levels) { 
			Integer i = lvl.get(c);
			if (i == null)
				i = 0;
			i++;
			lvl.put(c,i);
		}
		return lvl;
	}
	
	public D20Class getClassForLevel(int lvl) { 
		int level = lvl - 1;
		if (level < 0 || level >= levels.size()) return null;		
		return levels.get(level);
	}
	
	public int getModifiedSave(int save) { 
		if (save == FORT)
			return saves[save] + getModifier(CON);
		else if (save == REFLEX)
			return saves[save] + getModifier(DEX);
		else if (save == WILL)
			return saves[save] + getModifier(WIS);
		else
			return -1;
	}
	
	
	public int getSave(int save) { 
		if (save < 0 || save > 3) return -1;
		return this.saves[save];
	}
	
	public void setSave(int save, int value) { 
		if (save < 0 || save > 3) return;
		saves[save] = value;
	}
	
	public boolean isMale() { 
		return male;		
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHair() {
		return hair;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}

	public String getEyes() {
		return eyes;
	}

	public void setEyes(String eyes) {
		this.eyes = eyes;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public D20Race getRace() {
		return race;
	}

	public boolean setRace(D20Race race) {
		if (!race.hasPrerequisites(this)) return false;
		
		this.race = race;
		race.onGain(this);
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public void setBAB(int bab) {
		this.bab = bab;
	}

	public int getBAB() {
		return bab;
	}

	public void setBaseSpeed(int baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

	public int getBaseSpeed() {
		return baseSpeed;
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



	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getXp() {
		return xp;
	}


	private static class SpecializableRank<T extends RuleObject> { 
		public T ability;
		public String specialization;
		public SpecializableRank(T f, String spec) { 
			ability = f;
			specialization = spec;
		}
		public Element toXML(String root, Integer ranks) { 
			Element e = new Element(root);
			e.addContent(ability.toXML("ability"));
			
			if (specialization != null) { 
				Element sp = new Element("specialization");
				sp.setText(specialization);
				e.addContent(sp);
			}
			
			e.addContent(XMLTools.xml("ranks", ranks));
			return e;
		}
		public Element toXML(String root, Float ranks) { 
			Element e = new Element(root);
			e.addContent(ability.toXML("ability"));
			
			if (specialization != null) { 
				Element sp = new Element("specialization");
				sp.setText(specialization);
				e.addContent(sp);
			}
			
			e.addContent(XMLTools.xml("ranks", NumberTools.trimFloat(ranks, 1,1,true)));
			return e;
		}
		
	}
	
	
	
	
	public Element toXML() { 
		Element e = new Element("character");
		e.addContent(XMLTools.xml("player", player));
		e.addContent(XMLTools.xml("name", name));
		e.addContent(XMLTools.xml("hair", hair));
		e.addContent(XMLTools.xml("eyes", eyes));
		e.addContent(XMLTools.xml("height", height));
		e.addContent(XMLTools.xml("weight",weight));
		e.addContent(XMLTools.xml("age", age));
		e.addContent(XMLTools.xml("male", male));
		e.addContent(XMLTools.xml("skillsavailable", skillsAvailable));
		e.addContent(XMLTools.xml("featsavailable", featsAvailable));
		e.addContent(XMLTools.xml("levelstogain", levelsToGain));
		e.addContent(XMLTools.xml("ageclass", ageClass));
		e.addContent(XMLTools.xml("strength", abilityScores[0]));
		e.addContent(XMLTools.xml("dexterity", abilityScores[1]));
		e.addContent(XMLTools.xml("constitution", abilityScores[2]));
		e.addContent(XMLTools.xml("intelligence", abilityScores[3]));
		e.addContent(XMLTools.xml("wisdom", abilityScores[4]));
		e.addContent(XMLTools.xml("charisma", abilityScores[5]));
		e.addContent(XMLTools.xml("fortitude", saves[0]));
		e.addContent(XMLTools.xml("reflex", saves[1]));
		e.addContent(XMLTools.xml("willpower", saves[2]));
		e.addContent(XMLTools.xml("bab", bab));
		e.addContent(XMLTools.xml("basespeed", baseSpeed));
		e.addContent(XMLTools.xml("hp", hp));
		e.addContent(XMLTools.xml("maxhp", maxHp));
		e.addContent(XMLTools.xml("xp", xp));
		
		e.addContent(race.toXML("race"));
		e.addContent(size.toXML("size"));
		e.addContent(alignment.toXML("alignment"));
		
		for (D20Class lvl : levels) 
			e.addContent(lvl.toXML("level"));
		
		for (Map.Entry<SpecializableRank<D20Skill>, Float> entry : skillRanks.entrySet()) 
			e.addContent(entry.getKey().toXML("skill", entry.getValue()));
		for (Map.Entry<SpecializableRank<D20Feat>, Integer> entry : feats.entrySet()) 
			e.addContent(entry.getKey().toXML("feat", entry.getValue()));
		for (Map.Entry<SpecializableRank<D20Feat>, Integer> entry : abilities.entrySet())  
			e.addContent(entry.getKey().toXML("ability", entry.getValue()));
			
		return e;
	}

	public D20Character(Element e) { 
		
	}
}
