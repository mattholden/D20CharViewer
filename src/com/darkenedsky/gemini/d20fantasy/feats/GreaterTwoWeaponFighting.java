package com.darkenedsky.gemini.d20fantasy.feats;
import com.darkenedsky.gemini.d20system.D20Character;

import com.darkenedsky.gemini.common.prereq.StatisticPrerequisite;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class GreaterTwoWeaponFighting extends D20Feat { 
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 7870932990827181637L;

	public GreaterTwoWeaponFighting() { 
		super("Greater Two-Weapon Fighting", "http://www.d20srd.org/srd/feats.htm#greaterTwoWeaponFighting");
	}

	@Override
	public boolean hasPrerequisites(D20Character character) {
		if (!super.hasPrerequisites(character))
			return false;
		
		if (!new StatisticPrerequisite(DEX, 19).satisfies(character))
			return false;

		if (!new StatisticPrerequisite(ATTACK, 11).satisfies(character))
			return false;
		
		if (!new FeatPrerequisite(D20SRD.Feats.IMPROVED_TWO_WEAPON_FIGHTING).satisfies(character))
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.TWO_WEAPON_FIGHTING).satisfies(character);
		
	}
	

}
