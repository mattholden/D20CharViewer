package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class ArmorProficiency_Heavy extends D20Feat { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 3580009515325680483L;

	public ArmorProficiency_Heavy() { 
		super("Armor Proficiency (heavy)", "http://www.d20srd.org/srd/feats.htm#armorProficiencyHeavy");
	}

	@Override
	public boolean hasPrerequisites(GameCharacter character) {
		if (!super.hasPrerequisites(character)) 
			return false;
		
		if (!new FeatPrerequisite(D20SRD.Feats.LIGHT_ARMOR_PROFICIENCY).satisfies(character)) 
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.MEDIUM_ARMOR_PROFICIENCY).satisfies(character);
	}

	
}
