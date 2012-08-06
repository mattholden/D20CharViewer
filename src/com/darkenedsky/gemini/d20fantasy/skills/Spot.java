package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Spot extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6893782643945885505L;

	public Spot() { 
		super(
				"Spot", 
				"http://www.d20srd.org/srd/skills/spot.htm", 
				false,		// specialized 
				true, 		// use untrained
				WIS, 		// key ability
				false);		// armor check penalty
			   	 
	}
}