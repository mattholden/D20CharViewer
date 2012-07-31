package com.darkenedsky.gemini.d20system;

import java.util.ArrayList;
import java.util.Map;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.Progression;
import com.darkenedsky.gemini.common.RuleObject;
import com.darkenedsky.gemini.common.Specialized;
import com.darkenedsky.gemini.d20fantasy.D20SRD;

public class D20Class extends RuleObject implements D20, D20ClassInterface {

	public static final Progression
	SAVE_BONUS_LOW = new Progression(0,0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6),
	SAVE_BONUS_HIGH = new Progression(2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12),
	BAB_HIGH = new Progression(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20),
	BAB_AVERAGE = new Progression(0,1,2,3,3,4,5,6,6,7,8,9,9,10,11,12,12,13,14,15),
	BAB_LOW = new Progression(0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10);

	/**
	 * 
	 */
	private static final long serialVersionUID = -8981668795309213519L;
	
	protected Progression fortSaveProgression, reflexSaveProgression, willSaveProgression, babProgression;
	protected Progression spellsPerDay[] = new Progression[10];
	protected Progression spellsKnown[] = new Progression[10];
		
	private ArrayList<Specialized<D20Skill>> classSkills = new ArrayList<Specialized<D20Skill>>();
	private ArrayList<Specialized<D20Skill>> forbiddenSkills = new ArrayList<Specialized<D20Skill>>();
	private boolean literacy = true;
	protected Dice hitDice;
	protected int ageClass;	
	protected int skillPoints;
	protected Integer skillPointsAfter1 = null;
	protected Dice startingGold = new Dice(0,1);
		
	public D20Class(String name, String sRDURL) {
		super(name, sRDURL);
		for (int i = 0; i < 10; i++) { 
			spellsPerDay[i] = Progression.ZERO;
			spellsKnown[i] = Progression.ZERO;
		}
	}

	public boolean isClassSkill(D20Skill skill, String spec) { 
		
		for (Specialized<D20Skill> s : getClassSkills()) { 
			if (s.equals(skill)) { 				
				if (s.specialization == null && spec == null) return true;
				if (spec != null && spec.equalsIgnoreCase(s.specialization)) return true;				
			}
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#getClassSkills()
	 */
	@Override
	public ArrayList<Specialized<D20Skill>> getClassSkills() { return classSkills; }
	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#getForbiddenSkills()
	 */
	@Override
	public ArrayList<Specialized<D20Skill>> getForbiddenSkills() { return forbiddenSkills; }

	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#addClassSkill(com.darkenedsky.d20charviewer.d20objects.D20Skill, java.lang.String)
	 */
	@Override
	public void addClassSkill(D20Skill skill, String spec) { 
		classSkills.add(new Specialized<D20Skill>(skill,spec));
	}
	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#addClassSkill(com.darkenedsky.d20charviewer.d20objects.D20Skill)
	 */
	@Override
	public void addClassSkill(D20Skill skill) { 
		addClassSkill(skill,null);
	}
	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#addForbiddenSkill(com.darkenedsky.d20charviewer.d20objects.D20Skill, java.lang.String)
	 */
	@Override
	public void addForbiddenSkill(D20Skill skill, String spec) { 
		forbiddenSkills.add(new Specialized<D20Skill>(skill,spec));
	}
	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#addForbiddenSkill(com.darkenedsky.d20charviewer.d20objects.D20Skill)
	 */
	@Override
	public void addForbiddenSkill(D20Skill skill) { 
		addForbiddenSkill(skill,null);
	}
	
	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#getFortSaveProgression()
	 */
	@Override
	public Progression getFortSaveProgression() {
		return fortSaveProgression;
	}

	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#getReflexSaveProgression()
	 */
	@Override
	public Progression getReflexSaveProgression() {
		return reflexSaveProgression;
	}

	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#getWillSaveProgression()
	 */
	@Override
	public Progression getWillSaveProgression() {
		return willSaveProgression;
	}

	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#getBABProgression()
	 */
	@Override
	public Progression getBABProgression() {
		return babProgression;
	}

	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#getSpellProgression(int)
	 */
	@Override
	public Progression getSpellProgression(int level) {
		if (level < 0 || level > 9) return null;
		return spellsPerDay[level];
	}
	
	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#getAgeClass()
	 */
	@Override
	public int getAgeClass() { return ageClass; }
	
	
	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#setHitDice(com.darkenedsky.d20charviewer.common.Dice)
	 */
	@Override
	public void setHitDice(Dice hitDice) {
		this.hitDice = hitDice;
	}

	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#getHitDice()
	 */
	@Override
	public Dice getHitDice() {
		return hitDice;
	}

	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#setSkillPoints(int)
	 */
	@Override
	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints;
	}

	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#getSkillPoints()
	 */
	@Override
	public int getSkillPoints() {
		return skillPoints;
	}
	
	protected int getClassSkillCount() { 
		return classSkills.size();
	}
	protected void addClassSkills(D20Class other) { 
		classSkills.addAll(other.classSkills);
	}
	
	protected void setIlliterate() { 
		literacy = false;
		
		// allow reading/writing to be taken as a skill
		for (Specialized<D20Skill> sk : forbiddenSkills) { 
			if (sk.ability.equals(D20SRD.Skills.READING_WRITING)) { 
				forbiddenSkills.remove(sk);
				return;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.darkenedsky.d20charviewer.d20objects.D20ClassInterface#onGain(com.darkenedsky.d20charviewer.d20objects.D20Character)
	 */
	@Override
	public void onGain(D20Character character) { 
			
		// don't want to add reading and writing as a skill to EVERYTHING not a barbarian
		if (literacy) { 			
			if (character.getSkill(D20SRD.Skills.READING_WRITING, null).getBaseValue() == 0) {
				character.addSkillRank(D20SRD.Skills.READING_WRITING, null, false, true);
			}
		}
		
		// better have already checked for ability score gain, because if they pick int, 
		// the extra point of int goes to skill points, and if they pick con, it goes to HP
		
		// recalculate saves and BAB
		int bab = 0, fort = 0, ref = 0, will = 0;
		for (Map.Entry<D20Class, Integer> levels : character.getLevelMap().entrySet()) { 
			bab += levels.getKey().getBABProgression().getProgression(levels.getValue());
			fort += levels.getKey().getFortSaveProgression().getProgression(levels.getValue());
			ref += levels.getKey().getReflexSaveProgression().getProgression(levels.getValue());
			will += levels.getKey().getWillSaveProgression().getProgression(levels.getValue());			
		}
		character.getStat(ATTACK).setBaseValue(bab);
		character.getStat(RANGED_ATTACK).setBaseValue(bab);
		character.getStat(GRAPPLE_ATTACK).setBaseValue(bab);
		character.getStat(FORT).setBaseValue(fort);
		character.getStat(REFLEX).setBaseValue(ref);
		character.getStat(WILL).setBaseValue(ref);
						
		// add skill points
		int totalLevel = character.getCharacterLevel();
			
		int skills = this.skillPoints;
		
		// a tiny handful of classes have different values for skills after 1.. use them if appropriate
		if (this.skillPointsAfter1 != null && totalLevel > 1)
			skills = skillPointsAfter1.intValue();
		
		// intelligence bonus
		skills += character.getAbilityScoreModifier(INT);
		
		// bonus skill points for your race
		if (totalLevel == 1)
			skills += character.getRace().getBonusSkillPointsLevel1();
		else
			skills += character.getRace().getBonusSkillPointsAfter1();
		
		
		// 1st levels get *4 skills
		if (totalLevel == 1)
			skills *= 4;
		
		character.setSkillsAvailable(skills);
		
		// if your level is a multiple of 4, gain a feat
		if (totalLevel != 0 && (totalLevel == 1 || totalLevel % 4 == 0)) {
			character.setFeatsAvailable(character.getFeatsAvailable() + 1);
		}
		
		// Gain some hit dice
		int hp = 0;
		if (totalLevel == 1)
			hp = this.getHitDice().getMaximum();
		else
			hp = this.getHitDice().roll();
		
		hp += character.getAbilityScoreModifier(CON);
		character.setHp(character.getHp() + hp);
		character.setMaxHp(character.getMaxHp() + hp);
		
		// Spell progressions?
		
	}
	
}
