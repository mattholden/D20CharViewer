package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20system.D20Feat;

public class QuickDraw extends D20Feat { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 2417766540599317070L;

	public QuickDraw() { 
		super("Quick Draw", "http://www.d20srd.org/srd/feats.htm#quickDraw");
	}

	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		return (new StatisticPrerequisite(ATTACK, 1).satisfies(character));			
		
	}
	

}
