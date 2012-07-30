package com.darkenedsky.gemini.d20system;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.modifier.Times;

public class D20NPCClass extends D20Class {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6825877838289000960L;

	public D20NPCClass(String name, String sRDURL) {
		super(name, sRDURL);
		ageClass = (D20Race.AGE_MOD_ADULT);
		startingGold = new Dice(4,4);
		startingGold.addModifier(new Times(10));
		
	}
		
}
