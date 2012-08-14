package com.darkenedsky.gemini.d20fantasy.feats;
import com.darkenedsky.gemini.d20system.D20Character;

import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class ImprovedBullRush extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4646415943077697830L;

	public ImprovedBullRush() { 
		super("Improved Bull Rush", "http://www.d20srd.org/srd/feats.htm#improvedBullRush");
	}

	@Override
	public boolean hasPrerequisites(D20Character character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(STR, 13).satisfies(character))
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.POWER_ATTACK).satisfies(character);
		
	}
	

}
