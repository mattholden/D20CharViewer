package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Profession extends D20Skill  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1855002269435080768L;

	public Profession() { 
		super(
				"Profession", 
				"http://www.d20srd.org/srd/skills/profession.htm", 
				true,		// specialized 
				false, 		// use untrained
				WIS, 		// key ability
				false);		// armor check penalty
			   	 
	}
}