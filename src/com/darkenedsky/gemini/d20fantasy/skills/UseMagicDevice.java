package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class UseMagicDevice extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4662626128906056588L;

	public UseMagicDevice() { 
		super(
				"Use Magic Device", 
				"http://www.d20srd.org/srd/skills/useMagicDevice.htm", 
				false,		// specialized 
				false, 		// use untrained
				CHA, 		// key ability
				false);		// armor check penalty
			   	 
	}
	
	@Override
	public void buildSynergy() { 
		addSynergyBonus(null, D20SRD.Skills.SPELLCRAFT, null, 2, "scrolls");
			
	}
}