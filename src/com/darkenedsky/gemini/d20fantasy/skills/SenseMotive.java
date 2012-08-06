package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class SenseMotive extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1181384414822207995L;

	public SenseMotive() { 
		super(
				"Sense Motive", 
				"http://www.d20srd.org/srd/skills/senseMotive.htm", 
				false,		// specialized 
				true, 		// use untrained
				WIS, 		// key ability
				false);		// armor check penalty
		
			   	 
	}
	
	@Override
	public void buildSynergy() { 
		addSynergyBonus(D20SRD.Skills.DIPLOMACY,null);
			
	}
}