package com.darkenedsky.gemini.d20fantasy.classes;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.Frequency;
import com.darkenedsky.gemini.common.Progression;
import com.darkenedsky.gemini.common.TimeUnit;
import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.common.modifier.Times;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20Race;
import com.darkenedsky.gemini.d20system.D20SpellCategory;
import com.darkenedsky.gemini.d20system.D20SpellcasterClass;

public class Cleric extends D20Class implements D20SpellcasterClass, D20Fantasy {

	/** 
	 * TODO:
	 * Clerics must be within 1 alignment step from their diety.
	 * Guess we need to do something about deities, huh? 
	 * Blegggh.
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7483831801072618500L;

	protected D20SpellCategory domain = null;
	
	public Cleric() {
		super("Cleric", "http://www.d20srd.org/srd/classes/cleric.htm");
		
		ageClass = (D20Race.AGE_MOD_OLD);
		hitDice = new Dice(1,8);
		skillPoints = 2;
		babProgression = BAB_AVERAGE;
		fortSaveProgression = SAVE_BONUS_HIGH;
		reflexSaveProgression = SAVE_BONUS_LOW;
		willSaveProgression = SAVE_BONUS_HIGH;
	
		startingGold = new Dice(5,4);
		startingGold.addModifier(new Times(10));
		
		spellsPerDay[0] = new Progression(3,4,4,5,5,5,6);
		spellsPerDay[1] = new Progression(1,2,2,3,3,3,4,4,4,4,5);
		spellsPerDay[2] = new Progression(0,0,1,2,2,3,3,3,4,4,4,4,5);
		spellsPerDay[3] = new Progression(0,0,0,0,1,2,2,3,3,3,4,4,4,4,5);
		spellsPerDay[4] = new Progression(0,0,0,0,0,0,1,2,2,3,3,3,4,4,4,4,5);
		spellsPerDay[5] = new Progression(0,0,0,0,0,0,0,0,1,2,2,3,3,3,4,4,4,4,5);
		spellsPerDay[6] = new Progression(0,0,0,0,0,0,0,0,0,0,1,2,2,3,3,3,4);
		spellsPerDay[7] = new Progression(0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,3,3,3,4);
		spellsPerDay[8] = new Progression(0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,3,3,3,4);
		spellsPerDay[9] = new Progression(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,4);
				
	}
	
	@Override
	public void onGain(D20Character character) { 		
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelOfClass(getClass());		
		switch (classLevel) { 
		case 1: { 
				character.addFeat(D20SRD.Feats.SIMPLE_WEAPON_PROFICIENCY, "*", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "*", true);
				character.addFeat(D20SRD.Feats.LIGHT_ARMOR_PROFICIENCY, "*", true);
				character.addFeat(D20SRD.Feats.MEDIUM_ARMOR_PROFICIENCY, "*", true);
				character.addFeat(D20SRD.Feats.SHIELD_PROFICIENCY, null, true);
				break;
			}
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:	
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			break;
		case 16:
			break;
		case 17:
			break;
		case 18:
			break;
		case 19:
			break;
		case 20:
			break;
		
		// TODO: Epic levels
		case 21: break;
		case 22: break;
		case 23: break;
		case 24: break;
		case 25: break;
		case 26: break;
		case 27: break;
		case 28: break;
		case 29: break;
		case 30: break;

		
		}
	}


}
