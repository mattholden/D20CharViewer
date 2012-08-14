package com.darkenedsky.gemini.d20fantasy.feats;
import com.darkenedsky.gemini.d20system.D20Character;

import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class ImprovedFeint extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1543698702041406126L;

	public ImprovedFeint() { 
		super("Improved Feint", "http://www.d20srd.org/srd/feats.htm#improvedFeint");
	}

	@Override
	public boolean hasPrerequisites(D20Character character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(INT, 13).satisfies(character))
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.COMBAT_EXPERTISE).satisfies(character);
		
	}
	

}
