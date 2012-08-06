package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Disguise extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5798091869506725072L;

	public Disguise() { 
		super(
				"Disguise", 
				"http://www.d20srd.org/srd/skills/disguise.htm", 
				false,		// specialized 
				true, 		// use untrained
				CHA, 		// key ability
				false);		// armor check penalty
			   	 
	}
}