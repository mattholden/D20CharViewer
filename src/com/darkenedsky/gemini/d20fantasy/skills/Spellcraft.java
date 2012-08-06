package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Spellcraft extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 402692455469371500L;

	public Spellcraft() { 
		super(
				"Spellcraft", 
				"http://www.d20srd.org/srd/skills/spellcraft.htm", 
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