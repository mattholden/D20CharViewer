package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class OpenLock extends D20Skill  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1083701733832401414L;

	public OpenLock() { 
		super(
				"Open Lock", 
				"http://www.d20srd.org/srd/skills/openLock.htm", 
				false,		// specialized 
				false, 		// use untrained
				DEX, 		// key ability
				false);		// armor check penalty
			   	 
	}
}