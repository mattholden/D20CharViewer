package com.darkenedsky.gemini.d20fantasy.feats;
import com.darkenedsky.gemini.d20system.D20Character;

import com.darkenedsky.gemini.common.modifier.Bonus;
import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20system.D20Feat;

public class ImprovedInitiative extends D20Feat {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4376866623081297095L;

	public ImprovedInitiative() {
		super("Improved Initiative", "http://www.d20srd.org/srd/feats.htm#improvedInitiative");
	}

	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		character.addBonus(INITIATIVE, new Bonus(this, new Plus(4), null));
	} 
	
}
