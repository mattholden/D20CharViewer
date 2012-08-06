package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Diplomacy extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4791674855252837847L;

	public Diplomacy() { 
		super(
				"Diplomacy", 
				"http://www.d20srd.org/srd/skills/diplomacy.htm", 
				false,		// specialized 
				true, 		// use untrained
				CHA, 		// key ability
				false);		// armor check penalty
			   	 
	}
}
