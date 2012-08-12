package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20system.D20Feat;

public class ExoticWeaponProficiency extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2620370924943624237L;

	public ExoticWeaponProficiency() { 
		super("Exotic Weapon Proficiency", "http://www.d20srd.org/srd/feats.htm#exoticWeaponProficiency", D20Feat.FEAT_GENERAL, true);		
	}
	
	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(ATTACK, 1).satisfies(character))
			return false;
		
		return true;
	}
	
	
}
