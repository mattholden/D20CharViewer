package com.darkenedsky.gemini.d20fantasy.feats;


import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class Agile extends D20Feat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1903357152927510172L;

	public Agile() {
		super("Agile", "http://www.d20srd.org/srd/feats.htm#agile");
	}

	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getSkill(D20SRD.Skills.BALANCE).addBonus(this, new Plus(2), null);
		c.getSkill(D20SRD.Skills.ESCAPE_ARTIST).addBonus(this, new Plus(2), null);
	} 
	
}
