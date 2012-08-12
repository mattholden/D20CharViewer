package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class Diehard extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6167038373859432628L;

	public Diehard() { 
		super("Diehard", "http://www.d20srd.org/srd/feats.htm#diehard");
	}

	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;
				
		return new FeatPrerequisite(D20SRD.Feats.ENDURANCE).satisfies(character);
		
	}
	

}
