package com.darkenedsky.gemini.d20fantasy.classes;

import com.darkenedsky.gemini.common.Dice;

import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20Race;

public class Rogue extends D20Class implements D20Fantasy {
	
	// TODO: abilities
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2060955820553860621L;

	public Rogue() { 
		super("Rogue","http://www.d20srd.org/srd/classes/rogue.htm");
		ageClass = (D20Race.AGE_MOD_YOUNG);
		hitDice = new Dice(1,6);
		skillPoints = 8;
		babProgression = BAB_AVERAGE;
		fortSaveProgression = SAVE_BONUS_LOW;
		reflexSaveProgression = SAVE_BONUS_HIGH;
		willSaveProgression = SAVE_BONUS_LOW;
		
		
		addClassSkill(D20SRD.Skills.APPRAISE);
		addClassSkill(D20SRD.Skills.BALANCE);
		addClassSkill(D20SRD.Skills.BLUFF);
		addClassSkill(D20SRD.Skills.CLIMB);
		addClassSkill(D20SRD.Skills.CRAFT);
		addClassSkill(D20SRD.Skills.DECIPHER_SCRIPT);
		addClassSkill(D20SRD.Skills.DIPLOMACY);
		addClassSkill(D20SRD.Skills.DISABLE_DEVICE);
		addClassSkill(D20SRD.Skills.DISGUISE);
		addClassSkill(D20SRD.Skills.ESCAPE_ARTIST);
		addClassSkill(D20SRD.Skills.FORGERY);
		addClassSkill(D20SRD.Skills.GATHER_INFORMATION);
		addClassSkill(D20SRD.Skills.HIDE);
		addClassSkill(D20SRD.Skills.INTIMIDATE);
		addClassSkill(D20SRD.Skills.JUMP);
		addClassSkill(D20SRD.Skills.KNOWLEDGE,"local");
		addClassSkill(D20SRD.Skills.LISTEN);
		addClassSkill(D20SRD.Skills.MOVE_SILENTLY);
		addClassSkill(D20SRD.Skills.OPEN_LOCK);
		addClassSkill(D20SRD.Skills.PERFORM);
		addClassSkill(D20SRD.Skills.PROFESSION);
		addClassSkill(D20SRD.Skills.SEARCH);
		addClassSkill(D20SRD.Skills.SENSE_MOTIVE);
		addClassSkill(D20SRD.Skills.SLEIGHT_OF_HAND);
		addClassSkill(D20SRD.Skills.SPOT);
		addClassSkill(D20SRD.Skills.SWIM);
		addClassSkill(D20SRD.Skills.TUMBLE);
		addClassSkill(D20SRD.Skills.USE_MAGIC_DEVICE);
		addClassSkill(D20SRD.Skills.USE_ROPE);
		
	}


	@Override
	public void onGain(D20Character chara) { 
		D20Character character = (D20Character)chara;
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelOfClass(this);		
		switch (classLevel) { 
		case 1: { 
				character.addFeat(D20SRD.Feats.SIMPLE_WEAPON_PROFICIENCY, null, true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "hand crossbow", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "sap", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "rapier", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "shortbow", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "short sword", true);
				character.addFeat(D20SRD.Feats.LIGHT_ARMOR_PROFICIENCY, null, true);
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
