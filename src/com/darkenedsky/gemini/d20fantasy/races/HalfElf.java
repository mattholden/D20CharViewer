package com.darkenedsky.gemini.d20fantasy.races;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Race;

public class HalfElf extends D20Race implements D20Fantasy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4119146793467917364L;

	public HalfElf() {
		super("HalfElf", "http://www.d20srd.org/srd/races.htm#halfElves");
		bonusLanguages.add("*");
		
		ageRanges= new int[] {10,20,62,93,125};
		maxAge = new Dice(3,20);
		baseHeightM = ht(4,7);
		modHeightM = new Dice(2,8);
		baseWeightM = 100;
		modWeightM = new Dice(2,4);
		baseHeightF = ht(4,5);
		modHeightF = new Dice(2,8);
		baseWeightF = 80;
		modWeightF = new Dice(2,4);
		this.ageModsByClass = new Dice[] {
			new Dice(1,6), new Dice(2,6), new Dice(3,6)
		};
	
	}

	@Override
	public void onGain(D20Character character) {		
		super.onGain(character);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Elven", false, true);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Common", false, true);
		character.addAbility(D20SRD.Abilities.ELF_BLOOD, null);
		character.addAbility(D20SRD.Abilities.LOWLIGHTVISION, null);
		character.addSaveBonus(ALL, this, IMMUNITY, "sleep spells or effects");
		character.addSaveBonus(ALL, this, new Plus(2), "enchantment spells or effects");
		character.addSkillBonus(D20SRD.Skills.DIPLOMACY, this, new Plus(2), null);
		character.addSkillBonus(D20SRD.Skills.GATHER_INFORMATION, this, new Plus(2), null);
		character.addSkillBonus(D20SRD.Skills.LISTEN, this, new Plus(1), null);
		character.addSkillBonus(D20SRD.Skills.SEARCH, this, new Plus(1), null);
		character.addSkillBonus(D20SRD.Skills.SPOT, this, new Plus(1), null);
		
			
	}
	
	

}