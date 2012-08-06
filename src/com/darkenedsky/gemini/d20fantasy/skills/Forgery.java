package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Forgery extends D20Skill  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8431955039316472728L;

	public Forgery() { 
		super(
				"Forgery", 
				"http://www.d20srd.org/srd/skills/forgery.htm", 
				false,		// specialized 
				true, 		// use untrained
				INT, 		// key ability
				false);		// armor check penalty
			   	 
	}
}