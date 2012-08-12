package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class ImprovedTrip extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2842670016783689227L;

	public ImprovedTrip() { 
		super("Improved Trip", "http://www.d20srd.org/srd/feats.htm#improvedTrip");
	}

	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(INT, 13).satisfies(character))
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.COMBAT_EXPERTISE).satisfies(character);
		
	}
	

}
