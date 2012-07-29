package com.darkenedsky.gemini.d20fantasy.classes;

import com.darkenedsky.gemini.common.Progression;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20SpellCategory;
import com.darkenedsky.gemini.d20system.D20SpellcasterClass;

public class Cleric extends D20Class implements D20SpellcasterClass, D20Fantasy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7483831801072618500L;

	protected D20SpellCategory domain = null;
	
	public Cleric() {
		super("Cleric", "");
		
		spellProgression[0] = new Progression(3,4,4,5,5,5,6);
		spellProgression[1] = new Progression(1,2,2,3,3,3,4,4,4,4,5);
		spellProgression[2] = new Progression(0,0,1,2,2,3,3,3,4,4,4,4,5);
		spellProgression[3] = new Progression(0,0,0,0,1,2,2,3,3,3,4,4,4,4,5);
		spellProgression[4] = new Progression(0,0,0,0,0,0,1,2,2,3,3,3,4,4,4,4,5);
		spellProgression[5] = new Progression(0,0,0,0,0,0,0,0,1,2,2,3,3,3,4,4,4,4,5);
		spellProgression[6] = new Progression(0,0,0,0,0,0,0,0,0,0,1,2,2,3,3,3,4);
		spellProgression[7] = new Progression(0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,3,3,3,4);
		spellProgression[8] = new Progression(0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,3,3,3,4);
		spellProgression[9] = new Progression(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,4);
		
		
	}

}
