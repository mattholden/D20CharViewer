package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Appraise extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2955869145115580468L;

	public Appraise() { 
		super(
				"Appraise", 
				"http://www.d20srd.org/srd/skills/appraise.htm", 
				false,		// specialized 
				true, 		// use untrained
				INT, 		// key ability
				false);		// armor check penalty
			   	 
	}
}
