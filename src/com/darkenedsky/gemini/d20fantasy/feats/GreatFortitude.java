package com.darkenedsky.gemini.d20fantasy.feats;


import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class GreatFortitude extends D20Feat {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7629683337843904331L;

	public GreatFortitude() {
		super("Great Fortitude", "http://www.d20srd.org/srd/feats.htm#greatFortitude");
	}

	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getStat(FORT).addBonus(this, new Plus(2),null);
	} 
	
}
