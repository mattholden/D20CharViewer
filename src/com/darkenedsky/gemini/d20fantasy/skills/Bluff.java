package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Bluff extends D20Skill  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2866976008447541771L;

	public Bluff() { 
		super(
				"Bluff", 
				"http://www.d20srd.org/srd/skills/bluff.htm", 
				false,		// specialized 
				true, 		// use untrained
				CHA, 		// key ability
				false);		// armor check penalty
		
	   	 
	}
	
	@Override
	public void buildSynergy() { 
		   this.addSynergyBonus(null, D20SRD.Skills.DISGUISE, null, 2, "acting in character");
		    this.addSynergyBonus(null, D20SRD.Skills.INTIMIDATE, null, 2, null);
		    this.addSynergyBonus(null, D20SRD.Skills.DIPLOMACY, null, 2, null);
		    this.addSynergyBonus(null, D20SRD.Skills.SLEIGHT_OF_HAND, null, 2, null);
		 	
	}
}
