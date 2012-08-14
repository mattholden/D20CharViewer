package com.darkenedsky.gemini.d20fantasy.feats;
import com.darkenedsky.gemini.d20system.D20Character;

import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class ImprovedGrapple extends D20Feat { 

	/**
	 * 
	 */
	private static final long serialVersionUID = -5201842399606125628L;

	public ImprovedGrapple() { 
		super("Improved Grapple", "http://www.d20srd.org/srd/feats.htm#improvedGrapple");
	}

	@Override
	public boolean hasPrerequisites(D20Character character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(DEX, 13).satisfies(character))
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.IMPROVED_UNARMED_STRIKE).satisfies(character);
		
	}
	

}
