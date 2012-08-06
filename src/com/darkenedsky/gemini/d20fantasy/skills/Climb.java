package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Climb extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4627985973480686475L;

	public Climb() { 
		super(
				"Climb", 
				"http://www.d20srd.org/srd/skills/climb.htm", 
				false,		// specialized 
				true, 		// use untrained
				STR, 		// key ability
				true);		// armor check penalty
			   	 
	}
}
