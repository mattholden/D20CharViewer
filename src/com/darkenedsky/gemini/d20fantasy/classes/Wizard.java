package com.darkenedsky.gemini.d20fantasy.classes;

import com.darkenedsky.gemini.common.Dice;

import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.RuleObject;
import com.darkenedsky.gemini.common.event.ChooseObjectEvent;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.D20Race;
import com.darkenedsky.gemini.d20system.D20SpellcasterClass;
import com.darkenedsky.gemini.d20system.D20UIEvents;

public class Wizard extends D20Class implements D20SpellcasterClass, D20Fantasy  {

	/**
	 * TODO: spell progression
	 */
	
	private static final long serialVersionUID = 4966860919383285064L;
	
	public Wizard() { 
		super("Wizard","http://www.d20srd.org/srd/classes/sorcererWizard.htm");

		ageClass = (D20Race.AGE_MOD_OLD);
		hitDice = new Dice(1,4);
		skillPoints = 2;
		babProgression = BAB_LOW;
		fortSaveProgression = SAVE_BONUS_LOW;
		reflexSaveProgression = SAVE_BONUS_LOW;
		willSaveProgression = SAVE_BONUS_HIGH;
		
		addClassSkill(D20SRD.Skills.CONCENTRATION);
		addClassSkill(D20SRD.Skills.CRAFT);
		addClassSkill(D20SRD.Skills.DECIPHER_SCRIPT);
		addClassSkill(D20SRD.Skills.KNOWLEDGE);
		addClassSkill(D20SRD.Skills.PROFESSION);
		addClassSkill(D20SRD.Skills.SPELLCRAFT);
		
		bonusLanguages.add("Draconic");
	}
	

	private void fireBonusFeats(D20Character character) { 
		// bonus feats!
		ChooseObjectEvent bonusFeat = new ChooseObjectEvent(D20UIEvents.CHOOSE_FEAT, "Choose a wizard bonus feat.");
		bonusFeat.setQtyToPick(1);
			
			for (RuleObject f : Library.instance.getSection(FEATS).getAll()) { 
				D20Feat feet = (D20Feat)f;
				
				if (feet.getType() == D20.FEAT_ITEMCREATION || feet.getType() == D20.FEAT_METAMAGIC || feet.equals(D20SRD.Feats.SPELL_MASTERY))
					bonusFeat.addChoice(feet);
			}
			
		character.fireCharGenEvent(bonusFeat);
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
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "dagger", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "heavy crossbow", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "light crossbow", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "quarterstaff", true);
				character.addFeat(D20SRD.Feats.SCRIBE_SCROLL, null, true);
				break;
			}
		case 2:
			character.addAbility(D20SRD.Abilities.SUMMON_FAMILIAR, null);			
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:	
			fireBonusFeats(character);
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
			fireBonusFeats(character);
			
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
			fireBonusFeats(character);
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
			fireBonusFeats(character);
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
