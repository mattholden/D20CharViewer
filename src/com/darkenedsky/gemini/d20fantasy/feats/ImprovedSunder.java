package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class ImprovedSunder extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8166145570379861738L;

	public ImprovedSunder() { 
		super("Improved Sunder", "http://www.d20srd.org/srd/feats.htm#improvedSunder");
	}

	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(STR, 13).satisfies(character))
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.POWER_ATTACK).satisfies(character);
		
	}
	

}