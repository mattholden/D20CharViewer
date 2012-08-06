package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Intimidate extends D20Skill  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8293248185551591243L;

	public Intimidate() { 
		super(
				"Intimidate", 
				"http://www.d20srd.org/srd/skills/intimidate.htm", 
				false,		// specialized 
				true, 		// use untrained
				CHA, 		// key ability
				false);		// armor check penalty
			   	 
	}
}