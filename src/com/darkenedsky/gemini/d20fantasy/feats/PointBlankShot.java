package com.darkenedsky.gemini.d20fantasy.feats;


import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class PointBlankShot extends D20Feat {


	/**
	 * 
	 */
	private static final long serialVersionUID = 966842769113705947L;

	public PointBlankShot() {
		super("Point Blank Shot", "http://www.d20srd.org/srd/feats.htm#pointBlankShot");
	}

	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getStat(RANGED_ATTACK).addBonus(this, new Plus(1),null);
	} 
	
}
