package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Tumble extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4320719975920793231L;

	public Tumble() { 
		super(
				"Tumble", 
				"http://www.d20srd.org/srd/skills/tumble.htm", 
				false,		// specialized 
				false, 		// use untrained
				DEX, 		// key ability
				true);		// armor check penalty
		
	}
	
	@Override
	public void buildSynergy() { 
		addSynergyBonus(D20SRD.Skills.JUMP,null);
		addSynergyBonus(D20SRD.Skills.BALANCE,null);	   	 
		
	}
}
