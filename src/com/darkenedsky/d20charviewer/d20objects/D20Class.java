package com.darkenedsky.d20charviewer.d20objects;

import java.util.ArrayList;
import java.util.Map;

import com.darkenedsky.d20charviewer.Dice;

public class D20Class extends RuleObject implements D20Stats {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8981668795309213519L;
	
	protected D20Progression fortSaveProgression, reflexSaveProgression, willSaveProgression, babProgression;
	protected D20Progression spellProgression = D20Progression.ZERO;
	
	protected ArrayList<D20Skill> classSkills = new ArrayList<D20Skill>();
	protected ArrayList<D20Skill> forbiddenSkills = new ArrayList<D20Skill>();
		
	protected Dice hitDice;
	protected int ageClass;	
	protected int skillPoints;
	
	
	public D20Class(String name, String sRDURL) {
		super(name, sRDURL);
	}

	public ArrayList<D20Skill> getClassSkills() { return classSkills; }
	public ArrayList<D20Skill> getForbiddenSkills() { return forbiddenSkills; }

	public D20Progression getFortSaveProgression() {
		return fortSaveProgression;
	}

	public D20Progression getReflexSaveProgression() {
		return reflexSaveProgression;
	}

	public D20Progression getWillSaveProgression() {
		return willSaveProgression;
	}

	public D20Progression getBABProgression() {
		return babProgression;
	}

	public D20Progression getSpellProgression() {
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
	
	public void onGain(D20Character character) { 
			
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
