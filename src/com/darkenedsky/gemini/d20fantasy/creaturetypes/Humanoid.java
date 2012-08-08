package com.darkenedsky.gemini.d20fantasy.creaturetypes;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20CreatureType;

public class Humanoid extends D20CreatureType implements D20Fantasy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 609931875089792810L;

	public Humanoid() {
		super("Humanoid", "http://www.d20srd.org/srd/typesSubtypes.htm#humanoidType");
		baseAttack = D20Class.BAB_AVERAGE;
		reflex = D20Class.SAVE_BONUS_HIGH;
		skillPoints = 2;
		hitDice = new Dice(1,8);		
	} 
	

}
