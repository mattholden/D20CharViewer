package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class DisableDevice extends D20Skill  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2386754208921395507L;

	public DisableDevice() { 
		super(
				"DisableDevice", 
				"http://www.d20srd.org/srd/skills/disableDevice.htm", 
				false,		// specialized 
				false, 		// use untrained
				INT, 		// key ability
				false);		// armor check penalty
			   	 
	}
}