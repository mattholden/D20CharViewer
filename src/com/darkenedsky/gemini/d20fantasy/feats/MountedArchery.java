package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;
import com.darkenedsky.gemini.d20system.prereq.SkillRankPrerequisite;

public class MountedArchery extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2649560210059811381L;

	public MountedArchery() { 
		super("Mounted Archery", "http://www.d20srd.org/srd/feats.htm#mountedArchery");
	}

	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new SkillRankPrerequisite(D20SRD.Skills.RIDE, null, 1).satisfies(character))
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.MOUNTED_COMBAT).satisfies(character);
		
	}
	

}
