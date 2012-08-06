package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Survival extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4898469516011848927L;

	public Survival() { 
		super(
				"Survival", 
				"http://www.d20srd.org/srd/skills/survival.htm", 
				false,		// specialized 
				true, 		// use untrained
				WIS, 		// key ability
				false);		// armor check penalty

	}
	
	@Override
	public void buildSynergy() { 
		addSynergyBonus(null, D20SRD.Skills.KNOWLEDGE, "nature", 2, null);
			
	}
}
