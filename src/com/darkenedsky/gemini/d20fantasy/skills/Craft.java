package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Craft extends D20Skill  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6140017114948161915L;

	public Craft() { 
		super("Craft", "http://www.d20srd.org/srd/skills/craft.htm", true, true, INT, false);		
			 
	}
	
	@Override
	public void buildSynergy() { 
		this.addSynergyBonus(null, D20SRD.Skills.APPRAISE, null, 2, "similar items");
		   
			
	}
}