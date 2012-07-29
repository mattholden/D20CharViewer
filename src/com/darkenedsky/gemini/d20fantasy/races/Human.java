package com.darkenedsky.gemini.d20fantasy.races;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Race;

public class Human extends D20Race implements D20Fantasy {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2263752600490997243L;

	public Human() {
		super("Human", "http://www.d20srd.org/srd/races.htm#humans");
		

		ageRanges= new int[] {8,15,35,53,70};
		maxAge = new Dice(2,20);
		baseHeightM = ht(4,10);
		modHeightM = new Dice(2,10);
		baseWeightM = 120;
		modWeightM = new Dice(2,4);
		baseHeightF = ht(4,5);
		modHeightF = new Dice(2,10);
		baseWeightF = 85;
		modWeightF = new Dice(2,4);
		this.ageModsByClass = new Dice[] {
			new Dice(1,4), new Dice(1,6), new Dice(2,6)
		};
		bonusLanguages.add("*");
	}
	
	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		
		// bonus skills and feats
		character.setSkillsAvailable(character.getSkillsAvailable() + 4);
		character.setFeatsAvailable(character.getFeatsAvailable() + 1);
	}

}
