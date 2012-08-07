package com.darkenedsky.gemini.d20fantasy.classes;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.event.ChooseObjectEvent;
import com.darkenedsky.gemini.common.event.ChooseStringEvent;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20Race;
import com.darkenedsky.gemini.d20system.D20SpellcasterClass;
import com.darkenedsky.gemini.d20system.D20UIEvents;

public class Ranger extends D20Class implements D20SpellcasterClass, D20Fantasy  {

	/**
	 * TODO abilities, spell progression
	 */
	private static final long serialVersionUID = -7233516754646135330L;

	public Ranger() {
		super("Ranger","http://www.d20srd.org/srd/classes/ranger.htm");
		ageClass = (D20Race.AGE_MOD_ADULT);
		hitDice = new Dice(1,8);
		skillPoints = 6;
		babProgression = BAB_HIGH;
		fortSaveProgression = SAVE_BONUS_HIGH;
		reflexSaveProgression = SAVE_BONUS_HIGH;
		willSaveProgression = SAVE_BONUS_LOW;
		
		addClassSkill(D20SRD.Skills.CLIMB);
		addClassSkill(D20SRD.Skills.CRAFT);
		addClassSkill(D20SRD.Skills.HANDLE_ANIMAL);
		addClassSkill(D20SRD.Skills.INTIMIDATE);
		addClassSkill(D20SRD.Skills.JUMP);
		addClassSkill(D20SRD.Skills.LISTEN);
		addClassSkill(D20SRD.Skills.RIDE);
		addClassSkill(D20SRD.Skills.SURVIVAL);
		addClassSkill(D20SRD.Skills.SWIM);
		
	}
	

	private void doFavoredEnemy(D20Character character) { 
		ChooseStringEvent weapon = new ChooseStringEvent(D20UIEvents.CHOOSE_FAVORED_ENEMY, "Choose a favored enemy.");
		weapon.setAllowOther(false);
		weapon.addChoice("Aberration");
		weapon.addChoice("Animal");
		weapon.addChoice("Construct");
		weapon.addChoice("Dragon");
		weapon.addChoice("Elemental");
		weapon.addChoice("Fey");
		weapon.addChoice("Giant");
		weapon.addChoice("Humanoid (aquatic)");
		weapon.addChoice("Humanoid (dwarf");
		weapon.addChoice("Humanoid (elf");
		weapon.addChoice("Humanoid (goblinoid)");
		weapon.addChoice("Humanoid (gnoll)");
		weapon.addChoice("Humanoid (gnome)");
		weapon.addChoice("Humanoid (halfling)");
		weapon.addChoice("Humanoid (human)");
		weapon.addChoice("Humanoid (orc)");
		weapon.addChoice("Humanoid (reptilian)");
		weapon.addChoice("Magical Beast");
		weapon.addChoice("Monstrous Humanoid");
		weapon.addChoice("Ooze");
		weapon.addChoice("Outsider (air)");
		weapon.addChoice("Outsider (chaotic)");
		weapon.addChoice("Outsider (earth)");
		weapon.addChoice("Outsider (evil)");
		weapon.addChoice("Outsider (fire)");
		weapon.addChoice("Outsider (good)");
		weapon.addChoice("Outsider (lawful)");
		weapon.addChoice("Outsider (native)");
		weapon.addChoice("Outsider (water)");
		weapon.addChoice("Plant");
		weapon.addChoice("Undead");
		weapon.addChoice("Vermin");
		weapon.setAllowOther(true);
		
		character.fireCharGenEvent(weapon);
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
				character.addFeat(D20SRD.Feats.TRACK, null, true);
				
				doFavoredEnemy(character);
				break;
			}
		case 2:
			// bonus ranger feats!
			ChooseObjectEvent bonusFeat = new ChooseObjectEvent(D20UIEvents.CHOOSE_FEAT, "Choose a fighter bonus feat.");
			bonusFeat.setQtyToPick(1);
			bonusFeat.addChoice(D20SRD.Feats.TWO_WEAPON_FIGHTING);
			bonusFeat.addChoice(D20SRD.Feats.RAPID_SHOT);				
			character.fireCharGenEvent(bonusFeat);
			break;
			
		case 3:
			character.addFeat(D20SRD.Feats.ENDURANCE, null, true);			
			break;
		case 4:
			break;
		case 5:	
			doFavoredEnemy(character);
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
			doFavoredEnemy(character);
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
			doFavoredEnemy(character);
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
			doFavoredEnemy(character);
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
