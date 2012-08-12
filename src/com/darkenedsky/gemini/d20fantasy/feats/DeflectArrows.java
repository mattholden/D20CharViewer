package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class DeflectArrows extends D20Feat { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 8208712391980633897L;

	public DeflectArrows() { 
		super("Deflect Arrows", "http://www.d20srd.org/srd/feats.htm#deflectArrows");
	}

	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(DEX, 13).satisfies(character))
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.IMPROVED_UNARMED_STRIKE).satisfies(character);
		
	}
	

}
