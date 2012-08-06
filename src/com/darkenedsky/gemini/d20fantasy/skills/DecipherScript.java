package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class DecipherScript extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3080808710111450695L;

	public DecipherScript() { 
		super(
				"DecipherScript", 
				"http://www.d20srd.org/srd/skills/decipherScript.htm", 
				false,		// specialized 
				false, 		// use untrained
				INT, 		// key ability
				false);		// armor check penalty
		
	}
	
	@Override
	public void buildSynergy() { 
		addSynergyBonus(null, D20SRD.Skills.USE_MAGIC_DEVICE, null, 2, "scrolls");
		
	   	 
			
	}
}