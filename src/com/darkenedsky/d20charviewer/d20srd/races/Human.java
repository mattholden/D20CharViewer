package com.darkenedsky.d20charviewer.d20srd.races;

import com.darkenedsky.d20charviewer.d20objects.D20Character;
import com.darkenedsky.d20charviewer.d20objects.D20Race;

public class Human extends D20Race {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2263752600490997243L;

	public Human() {
		super("Human", "http://www.d20srd.org/srd/races.htm#humans");		
	}
	
	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		
		// bonus skills and feats
		character.setSkillsAvailable(character.getSkillsAvailable() + 4);
		character.setFeatsAvailable(character.getFeatsAvailable() + 1);
	}

}
