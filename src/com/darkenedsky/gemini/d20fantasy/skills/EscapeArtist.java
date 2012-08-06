package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class EscapeArtist extends D20Skill  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 928140847606866328L;

	public EscapeArtist() { 
		super(
				"Escape Artist", 
				"http://www.d20srd.org/srd/skills/escapeArtist.htm", 
				false,		// specialized 
				true, 		// use untrained
				DEX, 		// key ability
				true);		// armor check penalty
			 
		
	}
	
	@Override
	public void buildSynergy() { 
		addSynergyBonus(D20SRD.Skills.USE_ROPE, "bindings");
			
	}
}