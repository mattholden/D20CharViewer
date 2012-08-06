package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Search extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7343927961528440780L;

	public Search() { 
		super(
				"Search", 
				"http://www.d20srd.org/srd/skills/search.htm", 
				false,		// specialized 
				true, 		// use untrained
				INT, 		// key ability
				false);		// armor check penalty
			   	 
	}
	
	@Override
	public void buildSynergy() { 
		addSynergyBonus(D20SRD.Skills.SURVIVAL, "following tracks");
			
	}
}