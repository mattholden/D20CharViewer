package com.darkenedsky.gemini.d20fantasy.classes;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.Progression;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Alignment;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20Race;
import com.darkenedsky.gemini.d20system.D20SpellcasterClass;

public class Bard extends D20Class implements D20SpellcasterClass, D20Fantasy {

	/**
	 * DONE
	 */
	private static final long serialVersionUID = 7483831801072618500L;

	public Bard() {
		super("Bard", "http://www.d20srd.org/srd/classes/bard.htm");
		ageClass = (D20Race.AGE_MOD_ADULT);
		hitDice = new Dice(1,6);
		skillPoints = 6;
		babProgression = BAB_AVERAGE;
		fortSaveProgression = SAVE_BONUS_LOW;
		reflexSaveProgression = SAVE_BONUS_HIGH;
		willSaveProgression = SAVE_BONUS_HIGH;
		
		// bards can't be lawful
		deniedAlignments.add(D20Alignment.LAWFUL_EVIL);
		deniedAlignments.add(D20Alignment.LAWFUL_NEUTRAL);
		deniedAlignments.add(D20Alignment.LAWFUL_GOOD);
		
		addClassSkill(D20SRD.Skills.APPRAISE);
		addClassSkill(D20SRD.Skills.BALANCE);
		addClassSkill(D20SRD.Skills.BLUFF);
		addClassSkill(D20SRD.Skills.CLIMB);
		addClassSkill(D20SRD.Skills.CONCENTRATION);
		addClassSkill(D20SRD.Skills.CRAFT,"*");
		addClassSkill(D20SRD.Skills.DECIPHER_SCRIPT);
		addClassSkill(D20SRD.Skills.DIPLOMACY);
		addClassSkill(D20SRD.Skills.DISGUISE);
		addClassSkill(D20SRD.Skills.ESCAPE_ARTIST);
		addClassSkill(D20SRD.Skills.GATHER_INFORMATION);
		addClassSkill(D20SRD.Skills.HIDE);
		addClassSkill(D20SRD.Skills.JUMP);
		addClassSkill(D20SRD.Skills.KNOWLEDGE,"*");
		addClassSkill(D20SRD.Skills.LISTEN);
		addClassSkill(D20SRD.Skills.MOVE_SILENTLY);
		addClassSkill(D20SRD.Skills.PERFORM);
		addClassSkill(D20SRD.Skills.PROFESSION,"*");
		addClassSkill(D20SRD.Skills.SENSE_MOTIVE);
		addClassSkill(D20SRD.Skills.SLEIGHT_OF_HAND); 
		addClassSkill(D20SRD.Skills.SPEAK_LANGUAGE,"*");
		addClassSkill(D20SRD.Skills.SPELLCRAFT);
		addClassSkill(D20SRD.Skills.SWIM);
		addClassSkill(D20SRD.Skills.TUMBLE);
		addClassSkill(D20SRD.Skills.USE_MAGIC_DEVICE);
		
		spellsPerDay[0] = new Progression(2,3,3,3,3,3,3,3,3,3,3,3,3,4);
		spellsPerDay[1] = new Progression(null,0,1,2,2,3,3,3,3,3,3,3,3,4);
		spellsPerDay[2] = new Progression(null,null,null,0,1,2,2,3,3,3,3,3,3,3,3,3,4);
		spellsPerDay[3] = new Progression(null,null,null,null,null,null,0,1,2,2,3,3,3,3,3,3,4);
		spellsPerDay[4] = new Progression(null,null,null,null,null,null,null,null,null,0,1,2,2,3,3,3,3,4);
		spellsPerDay[5] = new Progression(null,null,null,null,null,null,null,null,null,null,null,null,0,1,2,2,3,3,4);
		spellsPerDay[6] = new Progression(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,0,1,2,3,4);
		spellsKnown[0] = new Progression(4,5,6);
		spellsKnown[1] = new Progression(null,2,3,3,4,4,4,4,4,4,4,4,4,4,4,5);
		spellsKnown[2] = new Progression(null,null,null,2,3,3,4,4,4,4,4,4,4,4,4,4,4,5);
		spellsKnown[3] = new Progression(null,null,null,null,null,null,2,3,3,4,4,4,4,4,4,4,4,5);
		spellsKnown[4] = new Progression(null,null,null,null,null,null,null,null,null,2,3,3,4,4,4,4,4,4,5);
		spellsKnown[5] = new Progression(null,null,null,null,null,null,null,null,null,null,null,null,2,3,3,4,4,4,4,5);
		spellsKnown[6] = new Progression(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,2,3,3,4);
	
	}
	
	
	@Override
	public void onGain(D20Character character) { 
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelOfClass(this);
		
		switch (classLevel) { 
		case 1: { 
				character.addFeat(D20SRD.Feats.SIMPLE_WEAPON_PROFICIENCY, null, true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "longsword", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "rapier", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "sap", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "short sword", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "shortbow", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "whip", true);
				character.addFeat(D20SRD.Feats.LIGHT_ARMOR_PROFICIENCY, null, true);
				character.addFeat(D20SRD.Feats.SHIELD_PROFICIENCY, null, true);
					
				character.addAbility(D20SRD.Abilities.BARDIC_KNOWLEDGE, null);
				character.addAbility(D20SRD.Abilities.COUNTERSONG, null);
				character.addAbility(D20SRD.Abilities.FASCINATE, null);
				character.addAbility(D20SRD.Abilities.INSPIRE_COURAGE, null);
				
				break;
			}
			
		case 3:
			character.addAbility(D20SRD.Abilities.INSPIRE_COMPETENCE, null);
			break;
			
		case 6:
			character.addAbility(D20SRD.Abilities.SUGGESTION, null);
			break;
		case 8:
			character.addAbility(D20SRD.Abilities.INSPIRE_COURAGE, null);
			break;
		case 9:
			character.addAbility(D20SRD.Abilities.INSPIRE_GREATNESS, null);
			break;		
		case 12:
			character.addAbility(D20SRD.Abilities.SONG_OF_FREEDOM, null);
			break;
		case 14:
			character.addAbility(D20SRD.Abilities.INSPIRE_COURAGE, null);
			break;
		case 15:
			character.addAbility(D20SRD.Abilities.INSPIRE_HEROICS, null);
			break;
		case 18:
			character.addAbility(D20SRD.Abilities.MASS_SUGGESTION, null);
			break;
		case 20:
			character.addAbility(D20SRD.Abilities.INSPIRE_COURAGE, null);
			break;
			
		}
	}

}
