package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class MoveSilently extends D20Skill  {


	/**
	 * 
	 */
	private static final long serialVersionUID = -160382968492042080L;

	public MoveSilently() { 
		super(
				"Move Silently", 
				"http://www.d20srd.org/srd/skills/moveSilently.htm", 
				false,		// specialized 
				true, 		// use untrained
				DEX, 		// key ability
				true);		// armor check penalty
			   	 
		
	}
}