package com.darkenedsky.gemini.d20fantasy.feats;
import com.darkenedsky.gemini.d20system.D20Character;

import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class Manyshot extends D20Feat { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4601633713856342370L;

	public Manyshot() { 
		super("Manyshot", "http://www.d20srd.org/srd/feats.htm#manyshot");
	}

	@Override
	public boolean hasPrerequisites(D20Character character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(DEX, 17).satisfies(character))
			return false;

		if (!new StatisticPrerequisite(ATTACK, 6).satisfies(character))
			return false;
		
		if (!new FeatPrerequisite(D20SRD.Feats.POINT_BLANK_SHOT).satisfies(character))
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.RAPID_SHOT).satisfies(character);
		
	}
	

}
