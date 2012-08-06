package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Listen extends D20Skill  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1301211904571876797L;

	public Listen() { 
		super(
				"Listen", 
				"http://www.d20srd.org/srd/skills/listen.htm", 
				false,		// specialized 
				true, 		// use untrained
				WIS, 		// key ability
				false);		// armor check penalty
			   	 
	}
}