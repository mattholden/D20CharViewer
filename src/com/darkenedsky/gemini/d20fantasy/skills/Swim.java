package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Swim extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4855717033114286512L;

	public Swim() { 
		super(
				"Swim", 
				"http://www.d20srd.org/srd/skills/swim.htm", 
				false,		// specialized 
				true, 		// use untrained
				STR, 		// key ability
				true);		// armor check penalty
			   	 
		
	}
}