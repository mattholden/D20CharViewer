package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class UseRope extends D20Skill  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2078728223504692653L;

	public UseRope() { 
		super(
				"Use Rope", 
				"http://www.d20srd.org/srd/skills/useRope.htm", 
				false,		// specialized 
				true, 		// use untrained
				DEX, 		// key ability
				false);		// armor check penalty
			   	 		
	}
	
	@Override
	public void buildSynergy() { 
		addSynergyBonus(D20SRD.Skills.ESCAPE_ARTIST, "ropes");
		addSynergyBonus(D20SRD.Skills.CLIMB, "ropes");
	}
}