package com.darkenedsky.gemini.d20fantasy.feats;
import com.darkenedsky.gemini.d20system.D20Character;

import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20system.D20Feat;


public class Dodge extends D20Feat { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 4103939762394269224L;

	public Dodge() { 
		super("Dodge", "http://www.d20srd.org/srd/feats.htm#dodge");
	}

	@Override
	public boolean hasPrerequisites(D20Character character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(DEX, 13).satisfies(character))
			return false;
		
		return true;
	}
	

}
