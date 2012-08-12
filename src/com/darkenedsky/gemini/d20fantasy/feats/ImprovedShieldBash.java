package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class ImprovedShieldBash extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6201640400754178819L;

	public ImprovedShieldBash() { 
		super("Improved Shield Bash", "http://www.d20srd.org/srd/feats.htm#improvedShieldBash");
	}

	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		
		return new FeatPrerequisite(D20SRD.Feats.SHIELD_PROFICIENCY).satisfies(character);
		
	}
	

}
