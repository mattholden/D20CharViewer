package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class GatherInformation extends D20Skill  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9192958833432303819L;

	public GatherInformation() { 
		super(
				"Gather Information", 
				"http://www.d20srd.org/srd/skills/gatherInformation.htm", 
				false,		// specialized 
				true, 		// use untrained
				CHA, 		// key ability
				false);		// armor check penalty
			   	 
	}
}