package com.darkenedsky.gemini.d20fantasy.classes;
import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Alignment;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20Race;
import com.darkenedsky.gemini.d20system.D20SpellcasterClass;

public class Druid extends D20Class implements D20SpellcasterClass, D20Fantasy {

	// TODO: spell progression, abilities 
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3770457620699209564L;

	public Druid() {
		super("Druid","http://www.d20srd.org/srd/classes/druid.htm");
		
		ageClass = (D20Race.AGE_MOD_OLD);
		hitDice = new Dice(1,8);
		skillPoints = 4;
		babProgression = BAB_AVERAGE;
		fortSaveProgression = SAVE_BONUS_HIGH;
		reflexSaveProgression = SAVE_BONUS_LOW;
		willSaveProgression = SAVE_BONUS_HIGH;
		
		addClassSkill(D20SRD.Skills.CONCENTRATION);
		addClassSkill(D20SRD.Skills.CRAFT);
		addClassSkill(D20SRD.Skills.DIPLOMACY);
		addClassSkill(D20SRD.Skills.HANDLE_ANIMAL);
		addClassSkill(D20SRD.Skills.HEAL);
		addClassSkill(D20SRD.Skills.KNOWLEDGE,"nature");
		addClassSkill(D20SRD.Skills.LISTEN);
		addClassSkill(D20SRD.Skills.PROFESSION);
		addClassSkill(D20SRD.Skills.RIDE);
		addClassSkill(D20SRD.Skills.SPELLCRAFT);
		addClassSkill(D20SRD.Skills.SPOT);
		addClassSkill(D20SRD.Skills.SURVIVAL);
		addClassSkill(D20SRD.Skills.SWIM);
		
		
		// druids must have some kind of neutral
		deniedAlignments.add(D20Alignment.LAWFUL_EVIL);
		deniedAlignments.add(D20Alignment.LAWFUL_GOOD);
		deniedAlignments.add(D20Alignment.CHAOTIC_GOOD);
		deniedAlignments.add(D20Alignment.CHAOTIC_EVIL);
	}


	
	
	@Override
	public void onGain(D20Character character) { 
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelOfClass(this);		
		switch (classLevel) { 
		case 1: { 
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "club", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "dagger", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "dart", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "quarterstaff", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "scimitar", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "sickle", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "shortspear", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "sling", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "spear", true);				
				character.addFeat(D20SRD.Feats.LIGHT_ARMOR_PROFICIENCY, null, true);
				character.addFeat(D20SRD.Feats.MEDIUM_ARMOR_PROFICIENCY, null, true);
				character.addFeat(D20SRD.Feats.SHIELD_PROFICIENCY, null, true);
				character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Druidic", false, true);
				character.getSkill(D20SRD.Skills.KNOWLEDGE,"nature").addBonus(this, new Plus(2),null);
				character.getSkill(D20SRD.Skills.SURVIVAL).addBonus(this, new Plus(2),null);
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
