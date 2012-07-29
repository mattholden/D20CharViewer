package com.darkenedsky.gemini.common.prereq;

import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class FeatPrerequisite implements Prerequisite {
	
	private D20Feat feat;
	private String special;
	
	public FeatPrerequisite(D20Feat feet, String specialize) { 
		feat = feet;
		special = specialize;
	}
	
	public boolean satisfies(D20Character character) { 
		return character.getFeatRanks(feat, special) >= 1;
	}

}
