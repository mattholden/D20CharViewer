package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20system.D20Feat;

public class PowerAttack extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -9051568275006470065L;

	public PowerAttack() { 
		super("Power Attack", "http://www.d20srd.org/srd/feats.htm#powerAttack");
	}

	@Override
	public boolean hasPrerequisites(D20Character character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(STR, 13).satisfies(character))
			return false;
		
		return true;
	}
	

}
