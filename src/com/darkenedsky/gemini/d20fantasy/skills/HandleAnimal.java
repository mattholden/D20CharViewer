package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class HandleAnimal extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2236196393257199581L;

	public HandleAnimal() { 
		super("Handle Animal", "http://www.d20srd.org/srd/skills/handleAnimal.htm", false, false, CHA, false);			
	 	}
	
	@Override
	public void buildSynergy() { 
		   this.addSynergyBonus(null, D20SRD.Skills.RIDE, null, 2, null);

		   // druid ability: wild empathy	 
	
	}
}
