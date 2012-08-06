package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Jump extends D20Skill  {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2278399009895721157L;

	public Jump() { 
		super(
				"Jump", 
				"http://www.d20srd.org/srd/skills/jump.htm", 
				false,		// specialized 
				true, 		// use untrained
				STR, 		// key ability
				true);		// armor check penalty
		
			   	 
		
	}
	
	@Override
	public void buildSynergy() { 
		addSynergyBonus(D20SRD.Skills.TUMBLE,null);
			
	}
}