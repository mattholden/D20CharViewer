package com.darkenedsky.gemini.d20fantasy.feats;


import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class Investigator extends D20Feat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5839416294801598589L;

	public Investigator() {
		super("Investigator", "http://www.d20srd.org/srd/feats.htm#investigator");
	}

	@Override
	public void onGain(D20Character character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getSkill(D20SRD.Skills.GATHER_INFORMATION).addBonus(this, new Plus(2), null);
		c.getSkill(D20SRD.Skills.SEARCH).addBonus(this, new Plus(2), null);
	} 
	
}
