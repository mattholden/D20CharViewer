package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class SleightOfHand extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9075752258547292767L;

	public SleightOfHand() { 
		super(
				"Sleight of Hand", 
				"http://www.d20srd.org/srd/skills/sleightOfHand.htm", 
				false,		// specialized 
				false, 		// use untrained
				DEX, 		// key ability
				true);		// armor check penalty
			   	 
	}
}