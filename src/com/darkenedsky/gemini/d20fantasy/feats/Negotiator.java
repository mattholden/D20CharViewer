package com.darkenedsky.gemini.d20fantasy.feats;


import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class Negotiator extends D20Feat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4938760099893652209L;

	public Negotiator() {
		super("Negotiator", "http://www.d20srd.org/srd/feats.htm#negotiator");
	}

	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getSkill(D20SRD.Skills.DIPLOMACY).addBonus(this, new Plus(2), null);
		c.getSkill(D20SRD.Skills.SENSE_MOTIVE).addBonus(this, new Plus(2), null);
	} 
	
}
