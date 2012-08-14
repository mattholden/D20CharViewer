package com.darkenedsky.gemini.d20fantasy.feats;
import com.darkenedsky.gemini.d20system.D20Character;

import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class AugmentSummoning extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1562683623155719915L;


	public AugmentSummoning() { 
		super("Augment Summoning", "http://www.d20srd.org/srd/feats.htm#augmentSummoning");
		
	}
	

	@Override
	public boolean hasPrerequisites(D20Character character) {
		if (!super.hasPrerequisites(character)) 
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.SPELL_FOCUS, "conjuration").satisfies(character);
	}


}
