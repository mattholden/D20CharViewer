package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Ride extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -462525262564719008L;

	public Ride() { 
		super(
				"Ride", 
				"http://www.d20srd.org/srd/skills/ride.htm", 
				false,		// specialized 
				true, 		// use untrained
				DEX, 		// key ability
				false);		// armor check penalty
			   	 
	}
}