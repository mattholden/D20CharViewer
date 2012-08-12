package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class ImprovedPreciseShot extends D20Feat { 

	/**
	 * 
	 */
	private static final long serialVersionUID = -5347209099374497839L;

	public ImprovedPreciseShot() { 
		super("Improved Precise Shot", "http://www.d20srd.org/srd/feats.htm#improvedPreciseShot");
	}

	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(DEX, 13).satisfies(character))
			return false;

		if (!new StatisticPrerequisite(ATTACK, 11).satisfies(character))
			return false;
		
		if (!new FeatPrerequisite(D20SRD.Feats.POINT_BLANK_SHOT).satisfies(character))
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.PRECISE_SHOT).satisfies(character);
		
	}
	

}
