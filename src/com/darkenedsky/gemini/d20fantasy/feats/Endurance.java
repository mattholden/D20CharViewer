package com.darkenedsky.gemini.d20fantasy.feats;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class Endurance extends D20Feat {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7602067548141276325L;

	public Endurance() {
		super("Endurance", "http://www.d20srd.org/srd/feats.htm#endurance");
	}

	@Override
	public void onGain(GameCharacter character) {
		super.onGain(character);
		
		D20Character c = (D20Character)character;
		c.getSkill(D20SRD.Skills.SWIM).addBonus(this, new Plus(4), "resist nonlethal damage");
		c.getStat(CON).addBonus(this, new Plus(4), "continue running");
		c.getStat(CON).addBonus(this, new Plus(4), "forced march");
		c.getStat(CON).addBonus(this, new Plus(4), "starvation or thirst");
		c.getStat(CON).addBonus(this, new Plus(4), "holding breath");
		c.getStat(FORT).addBonus(this, new Plus(4), "hot or cold environments");
		c.getStat(FORT).addBonus(this, new Plus(4), "suffocation");
		
	} 
	
}
