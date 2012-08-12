package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class DeftHands extends D20Feat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5293646937786423523L;

	public DeftHands() {
		super("Deft Hands", "http://www.d20srd.org/srd/feats.htm#deftHands");
	}

	@Override
	public void onGain(GameCharacter character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getSkill(D20SRD.Skills.SLEIGHT_OF_HAND).addBonus(this, new Plus(2), null);
		c.getSkill(D20SRD.Skills.USE_ROPE).addBonus(this, new Plus(2), null);
	} 
	
}
