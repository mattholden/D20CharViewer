package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class GreatCleave extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5870781578563627501L;

	public GreatCleave() { 
		super("Great Cleave", "http://www.d20srd.org/srd/feats.htm#greatCleave");
	}

	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(STR, 13).satisfies(character))
			return false;

		if (!new StatisticPrerequisite(ATTACK, 4).satisfies(character))
			return false;
		
		if (!new FeatPrerequisite(D20SRD.Feats.POWER_ATTACK).satisfies(character))
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.CLEAVE).satisfies(character);
		
	}
	

}
