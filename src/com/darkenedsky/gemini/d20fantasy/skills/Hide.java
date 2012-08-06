package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Hide extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5451255624490270355L;

	public Hide() { 
		super(
				"Hide", 
				"http://www.d20srd.org/srd/skills/hide.htm", 
				false,		// specialized 
				true, 		// use untrained
				DEX, 		// key ability
				true);		// armor check penalty
			   	 
	}
}