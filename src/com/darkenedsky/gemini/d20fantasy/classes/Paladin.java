package com.darkenedsky.gemini.d20fantasy.classes;
import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Alignment;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20Race;
import com.darkenedsky.gemini.d20system.D20SpellcasterClass;

public class Paladin extends D20Class implements D20SpellcasterClass, D20Fantasy  {

	/**
	 * TODO: abilities, spells
	 */
	private static final long serialVersionUID = 2116561924435594739L;

	public Paladin() {
		super("Paladin","http://www.d20srd.org/srd/classes/paladin.htm");
		ageClass = (D20Race.AGE_MOD_ADULT);
		hitDice = new Dice(1,10);
		skillPoints = 2;
		babProgression = BAB_HIGH;
		fortSaveProgression = SAVE_BONUS_HIGH;
		reflexSaveProgression = SAVE_BONUS_LOW;
		willSaveProgression = SAVE_BONUS_LOW;
		
		addClassSkill(D20SRD.Skills.CONCENTRATION);
		addClassSkill(D20SRD.Skills.CRAFT);
		addClassSkill(D20SRD.Skills.DIPLOMACY);
		addClassSkill(D20SRD.Skills.HANDLE_ANIMAL);
		addClassSkill(D20SRD.Skills.HEAL);
		addClassSkill(D20SRD.Skills.KNOWLEDGE, "nobility and royalty");		
		addClassSkill(D20SRD.Skills.KNOWLEDGE, "religion");
		addClassSkill(D20SRD.Skills.PROFESSION);
		addClassSkill(D20SRD.Skills.RIDE);
		addClassSkill(D20SRD.Skills.SENSE_MOTIVE);

		allowSplitMulticlass = false;
		
		// paladins must be LG
		deniedAlignments.add(D20Alignment.CHAOTIC_EVIL);
		deniedAlignments.add(D20Alignment.CHAOTIC_GOOD);
		deniedAlignments.add(D20Alignment.CHAOTIC_NEUTRAL);
		deniedAlignments.add(D20Alignment.NEUTRAL_EVIL);
		deniedAlignments.add(D20Alignment.NEUTRAL_GOOD);
		deniedAlignments.add(D20Alignment.TRUE_NEUTRAL);
		deniedAlignments.add(D20Alignment.LAWFUL_EVIL);
		deniedAlignments.add(D20Alignment.LAWFUL_NEUTRAL);
	}
	
	@Override
	public void onGain(GameCharacter chara) { 
		D20Character character = (D20Character)chara;
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelOfClass(this);		
		switch (classLevel) { 
		case 1: { 
				character.addFeat(D20SRD.Feats.SIMPLE_WEAPON_PROFICIENCY, null, true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, null, true);
				character.addFeat(D20SRD.Feats.LIGHT_ARMOR_PROFICIENCY, null, true);
				character.addFeat(D20SRD.Feats.MEDIUM_ARMOR_PROFICIENCY, null, true);
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
