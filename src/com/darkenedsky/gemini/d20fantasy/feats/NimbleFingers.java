package com.darkenedsky.gemini.d20fantasy.feats;


import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class NimbleFingers extends D20Feat {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5456521033464786307L;

	public NimbleFingers() {
		super("Nimble Fingers", "http://www.d20srd.org/srd/feats.htm#nimbleFingers");
	}

	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getSkill(D20SRD.Skills.DISABLE_DEVICE).addBonus(this, new Plus(2), null);
		c.getSkill(D20SRD.Skills.OPEN_LOCK).addBonus(this, new Plus(2), null);
	} 
	
}
