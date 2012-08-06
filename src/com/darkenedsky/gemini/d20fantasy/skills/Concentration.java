package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Concentration extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8658368598182298292L;

	public Concentration() { 
		super(
				"Concentration", 
				"http://www.d20srd.org/srd/skills/concentration.htm", 
				false,		// specialized 
				true, 		// use untrained
				CON, 		// key ability
				false);		// armor check penalty
			   	 
	}
}
