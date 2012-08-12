package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.TotalLevelPrerequisite;

public class Leadership extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4616413369107420592L;

	public Leadership() { 
		super("Leadership", "http://www.d20srd.org/srd/feats.htm#leader");
	}

	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		return (new TotalLevelPrerequisite(6).satisfies(character));
		
	}
	

}
