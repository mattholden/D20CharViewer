package com.darkenedsky.gemini.d20fantasy.races;

import com.darkenedsky.gemini.common.Dice;

import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Race;
import com.darkenedsky.gemini.d20system.D20Size;

public class Halfling extends D20Race implements D20Fantasy {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2676287456344903606L;

	public Halfling() {
		super("Halfling", "http://www.d20srd.org/srd/races.htm#halflings");
		this.favoredClass = D20SRD.Classes.ROGUE;
		mods[DEX] = 2;
		mods[STR] = -2;
		size = D20Size.SMALL;
		baseSpeed = 20;
		bonusLanguages.add("Dwarven");
		bonusLanguages.add("Elven");
		bonusLanguages.add("Gnome");
		bonusLanguages.add("Goblin");
		bonusLanguages.add("Orc");

		ageRanges= new int[] {10,20,50,75,100};
		maxAge = new Dice(5,20);
		baseHeightM = ht(2,8);
		modHeightM = new Dice(2,4);
		baseWeightM = 30;
		modWeightM = new Dice(1,1);
		baseHeightF = ht(2,6);
		modHeightF = new Dice(2,4);
		baseWeightF = 25;
		modWeightF = new Dice(1,1);
		this.ageModsByClass = new Dice[] {
			new Dice(2,4), new Dice(3,6), new Dice(4,6)
		};
	
	}

	@Override
	public void onGain(D20Character character) { 
		
		super.onGain(character);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Halfling", false, true);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Common", false, true);
		character.addBonus(ALL_SAVES, this, new Plus(1), null);
		character.addBonus(ALL_SAVES, this, new Plus(2), "fear");
		character.addBonus(RANGED_ATTACK, this, new Plus(1), "slings");
		character.addBonus(RANGED_ATTACK, this, new Plus(1), "thrown weapons");
		character.getSkill(D20SRD.Skills.CLIMB).addBonus(this, new Plus(2), null);
		character.getSkill(D20SRD.Skills.JUMP).addBonus(this, new Plus(2), null);
		character.getSkill(D20SRD.Skills.LISTEN).addBonus(this, new Plus(2), null);	
		character.getSkill(D20SRD.Skills.MOVE_SILENTLY).addBonus(this, new Plus(2), null);
		
	}
	
	

}
