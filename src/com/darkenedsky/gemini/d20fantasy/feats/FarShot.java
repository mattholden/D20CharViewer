package com.darkenedsky.gemini.d20fantasy.feats;


import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;
import com.darkenedsky.gemini.d20system.D20Character;


public class FarShot extends D20Feat { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 4601162108823315922L;

	public FarShot() { 
		super("Far Shot", "http://www.d20srd.org/srd/feats.htm#farShot");
	}

	@Override
	public boolean hasPrerequisites(D20Character character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.POINT_BLANK_SHOT).satisfies(character);
		
	}
	

}
