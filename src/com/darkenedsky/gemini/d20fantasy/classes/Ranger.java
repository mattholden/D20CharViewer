package com.darkenedsky.gemini.d20fantasy.classes;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.Progression;
import com.darkenedsky.gemini.common.modifier.Times;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20Race;
import com.darkenedsky.gemini.d20system.D20SpellcasterClass;

// NOT DONE!
public class Ranger extends D20Class implements D20SpellcasterClass, D20Fantasy  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7233516754646135330L;

	public Ranger() {
		super("Ranger", "");
		ageClass = (D20Race.AGE_MOD_RANGER);
		hitDice = new Dice(1,8);
		skillPoints = 4;
		babProgression = Progression.FIGHTER_BAB;
		startingGold = new Dice(6,4);
		startingGold.addModifier(new Times(10));
		
	}
	
	@Override
	public void onGain(D20Character character) { 		
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelMap().get(this);
	//	int totalLevel = character.getCharacterLevel();
		
		if (classLevel == 1) { 
					
		}
		
	}

}
