package com.darkenedsky.gemini.d20fantasy.classes;
import com.darkenedsky.gemini.common.Dice;

import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Alignment;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20Race;

public class Monk extends D20Class implements D20Fantasy {

	/**
	 * TODO: abilities
	 */
	private static final long serialVersionUID = 440354437067389355L;

	public Monk() { 
		super("Monk","http://www.d20srd.org/srd/classes/monk.htm");
		ageClass = (D20Race.AGE_MOD_OLD);
		hitDice = new Dice(1,8);
		skillPoints = 4;
		babProgression = BAB_AVERAGE;
		fortSaveProgression = SAVE_BONUS_HIGH;
		reflexSaveProgression = SAVE_BONUS_HIGH;
		willSaveProgression = SAVE_BONUS_HIGH;
		
		addClassSkill(D20SRD.Skills.BALANCE);
		addClassSkill(D20SRD.Skills.CLIMB);
		addClassSkill(D20SRD.Skills.CONCENTRATION);
		addClassSkill(D20SRD.Skills.CRAFT);
		addClassSkill(D20SRD.Skills.DIPLOMACY);
		addClassSkill(D20SRD.Skills.ESCAPE_ARTIST);
		addClassSkill(D20SRD.Skills.HIDE);
		addClassSkill(D20SRD.Skills.JUMP);		
		addClassSkill(D20SRD.Skills.KNOWLEDGE, "arcana");		
		addClassSkill(D20SRD.Skills.KNOWLEDGE, "religion");
		addClassSkill(D20SRD.Skills.LISTEN);
		addClassSkill(D20SRD.Skills.MOVE_SILENTLY);
		addClassSkill(D20SRD.Skills.PERFORM);		
		addClassSkill(D20SRD.Skills.PROFESSION);
		addClassSkill(D20SRD.Skills.SENSE_MOTIVE);
		addClassSkill(D20SRD.Skills.SPOT);
		addClassSkill(D20SRD.Skills.SWIM);
		addClassSkill(D20SRD.Skills.TUMBLE);
		
		allowSplitMulticlass = false;
			
		// monks must be lawful
		deniedAlignments.add(D20Alignment.CHAOTIC_EVIL);
		deniedAlignments.add(D20Alignment.CHAOTIC_GOOD);
		deniedAlignments.add(D20Alignment.CHAOTIC_NEUTRAL);
		deniedAlignments.add(D20Alignment.NEUTRAL_EVIL);
		deniedAlignments.add(D20Alignment.NEUTRAL_GOOD);
		deniedAlignments.add(D20Alignment.TRUE_NEUTRAL);
	}
	

		
	@Override
	public void onGain(D20Character chara) { 
		D20Character character = (D20Character)chara;
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelOfClass(this);		
		switch (classLevel) { 
		case 1: { 
				character.addFeat(D20SRD.Feats.SIMPLE_WEAPON_PROFICIENCY, "club", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "light crossbow", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "heavy crossbow", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "dagger", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "handaxe", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "javelin", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "kama", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "nunchaku", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "quarterstaff", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "sai", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "shuriken", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "siangham", true);
				character.addFeat(D20SRD.Feats.SIMPLE_WEAPON_PROFICIENCY, "sling", true);
								
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
