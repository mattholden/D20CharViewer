package com.darkenedsky.gemini.d20fantasy.feats;
import com.darkenedsky.gemini.d20system.D20Character;

import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class ImprovedTwoWeaponFighting extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3050201138621525570L;

	public ImprovedTwoWeaponFighting() { 
		super("Improved Two-Weapon Fighting", "http://www.d20srd.org/srd/feats.htm#improvedTwoWeaponFighting");
	}

	@Override
	public boolean hasPrerequisites(D20Character character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(DEX, 17).satisfies(character))
			return false;

		if (!new StatisticPrerequisite(ATTACK, 6).satisfies(character))
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.TWO_WEAPON_FIGHTING).satisfies(character);
		
	}
	

}
