package com.darkenedsky.gemini.d20fantasy.feats;
import com.darkenedsky.gemini.d20system.D20Character;

import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.prereq.FeatPrerequisite;

public class ArmorProficiency_Medium extends D20Feat { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 419656016944408653L;

	public ArmorProficiency_Medium() { 
		super("Armor Proficiency (medium)", "http://www.d20srd.org/srd/feats.htm#armorProficiencyMedium");
	}

	@Override
	public boolean hasPrerequisites(D20Character character) {
		if (!super.hasPrerequisites(character)) 
			return false;
		
		return new FeatPrerequisite(D20SRD.Feats.LIGHT_ARMOR_PROFICIENCY).satisfies(character);
	}

	
}
