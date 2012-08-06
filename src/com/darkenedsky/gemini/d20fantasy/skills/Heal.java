package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Heal extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1673809839022621125L;

	public Heal() { 
		super(
				"Heal", 
				"http://www.d20srd.org/srd/skills/heal.htm", 
				false,		// specialized 
				true, 		// use untrained
				WIS, 		// key ability
				false);		// armor check penalty
			   	 
	}
}