package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class Acrobatic extends D20Feat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2908315553677513063L;

	public Acrobatic() {
		super("Acrobatic", "http://www.d20srd.org/srd/feats.htm#acrobatic");
	}

	@Override
	public void onGain(GameCharacter character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getSkill(D20SRD.Skills.JUMP).addBonus(this, new Plus(2), null);
		c.getSkill(D20SRD.Skills.TUMBLE).addBonus(this, new Plus(2), null);
	} 
	
}
