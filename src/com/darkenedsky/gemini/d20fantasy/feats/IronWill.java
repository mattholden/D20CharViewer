package com.darkenedsky.gemini.d20fantasy.feats;


import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class IronWill extends D20Feat {


	/**
	 * 
	 */
	private static final long serialVersionUID = -9198570863404423777L;

	public IronWill() {
		super("Iron Will", "http://www.d20srd.org/srd/feats.htm#ironWill");
	}

	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getStat(WILL).addBonus(this, new Plus(2),null);
	} 
	
}
