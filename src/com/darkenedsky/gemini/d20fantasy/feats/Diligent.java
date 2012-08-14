package com.darkenedsky.gemini.d20fantasy.feats;


import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class Diligent extends D20Feat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7154067051389424163L;

	public Diligent() {
		super("Diligent", "http://www.d20srd.org/srd/feats.htm#diligent");
	}

	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getSkill(D20SRD.Skills.APPRAISE).addBonus(this, new Plus(2), null);
		c.getSkill(D20SRD.Skills.DECIPHER_SCRIPT).addBonus(this, new Plus(2), null);
	} 
	
}
