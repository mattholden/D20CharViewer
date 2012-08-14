package com.darkenedsky.gemini.d20fantasy.feats;


import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class AnimalAffinity extends D20Feat {

	/**
	 * 
	 */
	private static final long serialVersionUID = -309727199350284328L;

	public AnimalAffinity() {
		super("Animal Affinity", "http://www.d20srd.org/srd/feats.htm#animalAffinity");
	}

	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getSkill(D20SRD.Skills.HANDLE_ANIMAL).addBonus(this, new Plus(2), null);
		c.getSkill(D20SRD.Skills.RIDE).addBonus(this, new Plus(2), null);
	} 
	
}
