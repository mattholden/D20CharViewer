package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class PreciseShot extends D20Feat { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 267766011969492437L;

	public PreciseShot() { 
		super("Precise Shot", "http://www.d20srd.org/srd/feats.htm#preciseShot");
	}

	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;

		if (!new FeatPrerequisite(D20SRD.Feats.POINT_BLANK_SHOT).satisfies(character))
			return false;
		
		return true;
		
	}
	

}
