package com.darkenedsky.d20charviewer.d20objects;

import java.util.ArrayList;
import java.util.Map;

import com.darkenedsky.d20charviewer.common.Dice;
import com.darkenedsky.d20charviewer.common.Progression;
import com.darkenedsky.d20charviewer.common.RuleObject;
import com.darkenedsky.d20charviewer.common.Specialized;
import com.darkenedsky.d20charviewer.d20srd.D20SRD;

public class D20Class extends RuleObject implements D20Stats {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8981668795309213519L;
	
	protected Progression fortSaveProgression, reflexSaveProgression, willSaveProgression, babProgression;
	protected Progression spellProgression = Progression.ZERO;
	
	private ArrayList<Specialized<D20Skill>> classSkills = new ArrayList<Specialized<D20Skill>>();
	private ArrayList<Specialized<D20Skill>> forbiddenSkills = new ArrayList<Specialized<D20Skill>>();
	private boolean literacy = true;
	protected Dice hitDice;
	protected int ageClass;	
	protected int skillPoints;
	protected Integer skillPointsAfter1 = null;
	protected Dice startingGold = null;
		
	public D20Class(String name, String sRDURL) {
		super(name, sRDURL);
	}

	public ArrayList<Specialized<D20Skill>> getClassSkills() { return classSkills; }
	public ArrayList<Specialized<D20Skill>> getForbiddenSkills() { return forbiddenSkills; }

	public void addClassSkill(D20Skill skill, String spec) { 
		classSkills.add(new Specialized<D20Skill>(skill,spec));
	}
	public void addClassSkill(D20Skill skill) { 
		addClassSkill(skill,null);
	}
	public void addForbiddenSkill(D20Skill skill, String spec) { 
		forbiddenSkills.add(new Specialized<D20Skill>(skill,spec));
	}
	public void addForbiddenSkill(D20Skill skill) { 
		addForbiddenSkill(skill,null);
	}
	
	public Progression getFortSaveProgression() {
		return fortSaveProgression;
	}

	public Progression getReflexSaveProgression() {
		return reflexSaveProgression;
	}

	public Progression getWillSaveProgression() {
		return willSaveProgression;
	}

	public Progression getBABProgression() {
		return babProgression;
	}

	public Progression getSpellProgression() {
		return spellProgression;
	}
	
	public int getAgeClass() { return ageClass; }
	
	
	public void setHitDice(Dice hitDice) {
		this.hitDice = hitDice;
	}

	public Dice getHitDice() {
		return hitDice;
	}

	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints;
	}

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
	
	public void onGain(D20Character character) { 
			
		// don't want to add reading and writing as a skill to EVERYTHING not a barbarian
		if (literacy) { 			
			if (character.getSkillRanks(D20SRD.Skills.READING_WRITING, null) == 0) {
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
		character.setBAB(bab);
		character.setSave(FORT, fort);
		character.setSave(REFLEX, ref);
		character.setSave(WILL, ref);
						
		// add skill points
		int totalLevel = character.getCharacterLevel();
			
		int skills = this.skillPoints;
		
		// a tiny handful of classes have different values for skills after 1.. use them if appropriate
		if (this.skillPointsAfter1 != null && totalLevel > 1)
			skills = skillPointsAfter1.intValue();
		
		skills += character.getModifier(INT);
		
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
		
		hp += character.getModifier(CON);
		character.setHp(character.getHp() + hp);
		character.setMaxHp(character.getMaxHp() + hp);
		
		// Spell progressions?
		
	}
	
}
