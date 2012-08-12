package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20system.D20Feat;

public class CombatExpertise extends D20Feat { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6700746487016808444L;


	public CombatExpertise() { 
		super("Combat Expertise", "http://www.d20srd.org/srd/feats.htm#combatExpertise");		
	}

	
	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(INT, 13).satisfies(character))
			return false;
		
		return true;
	}
}
