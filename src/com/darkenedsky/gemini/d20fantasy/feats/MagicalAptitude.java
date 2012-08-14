package com.darkenedsky.gemini.d20fantasy.feats;


import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class MagicalAptitude extends D20Feat {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8950592101703796703L;

	public MagicalAptitude() {
		super("Magical Aptitude", "http://www.d20srd.org/srd/feats.htm#magicalAptitude");
	}

	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getSkill(D20SRD.Skills.SPELLCRAFT).addBonus(this, new Plus(2), null);
		c.getSkill(D20SRD.Skills.USE_MAGIC_DEVICE).addBonus(this, new Plus(2), null);
	} 
	
}
