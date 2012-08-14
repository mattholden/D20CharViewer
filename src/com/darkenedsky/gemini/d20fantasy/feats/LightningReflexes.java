package com.darkenedsky.gemini.d20fantasy.feats;


import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class LightningReflexes extends D20Feat {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1907900408205178821L;

	public LightningReflexes() {
		super("Lightning Reflexes", "http://www.d20srd.org/srd/feats.htm#lightningReflexes");
	}

	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getStat(REFLEX).addBonus(this, new Plus(2),null);
	} 
	
}
