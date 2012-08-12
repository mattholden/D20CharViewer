package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.SkillRankPrerequisite;

public class MountedCombat extends D20Feat { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3866077883061004574L;

	public MountedCombat() { 
		super("Mounted Combat", "http://www.d20srd.org/srd/feats.htm#mountedCombat");
	}

	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new SkillRankPrerequisite(D20SRD.Skills.RIDE, null, 1).satisfies(character))
			return false;
		return true;
		
	}
	

}
