package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Balance extends D20Skill  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6652956491497350348L;

	public Balance() { 
		super(
				"Balance", 
				"http://www.d20srd.org/srd/skills/balance.htm", 
				false,		// specialized 
				true, 		// use untrained
				DEX, 		// key ability
				true);		// armor check penalty
	   	 
	}
}
