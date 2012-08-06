package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Perform extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2001503900086360456L;

	public Perform() { 
		super(
				"Perform", 
				"http://www.d20srd.org/srd/skills/perform.htm", 
				true,		// specialized 
				true, 		// use untrained
				CHA, 		// key ability
				false);		// armor check penalty
			   	 
	}
}