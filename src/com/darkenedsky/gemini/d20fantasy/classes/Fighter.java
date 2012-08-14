package com.darkenedsky.gemini.d20fantasy.classes;

import java.util.ArrayList;

import com.darkenedsky.gemini.common.Dice;

import com.darkenedsky.gemini.common.event.ChooseObjectEvent;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.D20Race;
import com.darkenedsky.gemini.d20system.D20UIEvents;

public class Fighter extends D20Class implements D20Fantasy {

	/**
	 * DONE
	 */
	private static final long serialVersionUID = -7233516754646135330L;

	public Fighter() {
		super("Fighter", "http://www.d20srd.org/srd/classes/fighter.htm");
		ageClass = (D20Race.AGE_MOD_ADULT);
		hitDice = new Dice(1,10);
		skillPoints = 2;
		babProgression = BAB_HIGH;
		this.fortSaveProgression = SAVE_BONUS_HIGH;
		this.reflexSaveProgression = SAVE_BONUS_LOW;
		this.willSaveProgression = SAVE_BONUS_LOW;		
				
		addClassSkill(D20SRD.Skills.CLIMB);
		addClassSkill(D20SRD.Skills.CRAFT);
		addClassSkill(D20SRD.Skills.HANDLE_ANIMAL);
		addClassSkill(D20SRD.Skills.INTIMIDATE);
		addClassSkill(D20SRD.Skills.JUMP);
		addClassSkill(D20SRD.Skills.RIDE);
		addClassSkill(D20SRD.Skills.SWIM);
		
		bonusEligibleFeats.add(D20SRD.Feats.BLIND_FIGHT);
		bonusEligibleFeats.add(D20SRD.Feats.COMBAT_EXPERTISE);
		bonusEligibleFeats.add(D20SRD.Feats.IMPROVED_DISARM);
		bonusEligibleFeats.add(D20SRD.Feats.IMPROVED_FEINT);
		bonusEligibleFeats.add(D20SRD.Feats.IMPROVED_TRIP);
		bonusEligibleFeats.add(D20SRD.Feats.WHIRLWIND_ATTACK);
		bonusEligibleFeats.add(D20SRD.Feats.COMBAT_REFLEXES);
		bonusEligibleFeats.add(D20SRD.Feats.DODGE);
		bonusEligibleFeats.add(D20SRD.Feats.MOBILITY);
		bonusEligibleFeats.add(D20SRD.Feats.SPRING_ATTACK);
		bonusEligibleFeats.add(D20SRD.Feats.EXOTIC_WEAPON_PROFICIENCY);
		bonusEligibleFeats.add(D20SRD.Feats.IMPROVED_CRITICAL);
		bonusEligibleFeats.add(D20SRD.Feats.IMPROVED_INITIATIVE);
		bonusEligibleFeats.add(D20SRD.Feats.IMPROVED_SHIELD_BASH);
		bonusEligibleFeats.add(D20SRD.Feats.IMPROVED_UNARMED_STRIKE);
		bonusEligibleFeats.add(D20SRD.Feats.DEFLECT_ARROWS);
		bonusEligibleFeats.add(D20SRD.Feats.IMPROVED_GRAPPLE);
		bonusEligibleFeats.add(D20SRD.Feats.SNATCH_ARROWS);
		bonusEligibleFeats.add(D20SRD.Feats.STUNNING_FIST);
		bonusEligibleFeats.add(D20SRD.Feats.MOUNTED_COMBAT);
		bonusEligibleFeats.add(D20SRD.Feats.RIDE_BY_ATTACK);
		bonusEligibleFeats.add(D20SRD.Feats.SPIRITED_CHARGE);
		bonusEligibleFeats.add(D20SRD.Feats.TRAMPLE);
		bonusEligibleFeats.add(D20SRD.Feats.POINT_BLANK_SHOT);
		bonusEligibleFeats.add(D20SRD.Feats.FAR_SHOT);
		bonusEligibleFeats.add(D20SRD.Feats.PRECISE_SHOT);
		bonusEligibleFeats.add(D20SRD.Feats.RAPID_SHOT);
		bonusEligibleFeats.add(D20SRD.Feats.MANYSHOT);
		bonusEligibleFeats.add(D20SRD.Feats.SHOT_ON_THE_RUN);
		bonusEligibleFeats.add(D20SRD.Feats.IMPROVED_PRECISE_SHOT);
		bonusEligibleFeats.add(D20SRD.Feats.POWER_ATTACK);
		bonusEligibleFeats.add(D20SRD.Feats.CLEAVE);
		bonusEligibleFeats.add(D20SRD.Feats.GREAT_CLEAVE);
		bonusEligibleFeats.add(D20SRD.Feats.IMPROVED_BULL_RUSH);
		bonusEligibleFeats.add(D20SRD.Feats.IMPROVED_SUNDER);
		bonusEligibleFeats.add(D20SRD.Feats.QUICK_DRAW);
		bonusEligibleFeats.add(D20SRD.Feats.RAPID_RELOAD);
		bonusEligibleFeats.add(D20SRD.Feats.TWO_WEAPON_FIGHTING);
		bonusEligibleFeats.add(D20SRD.Feats.TWO_WEAPON_DEFENSE);
		bonusEligibleFeats.add(D20SRD.Feats.IMPROVED_TWO_WEAPON_FIGHTING);
		bonusEligibleFeats.add(D20SRD.Feats.GREATER_TWO_WEAPON_FIGHTING);
		bonusEligibleFeats.add(D20SRD.Feats.WEAPON_FINESSE);
		bonusEligibleFeats.add(D20SRD.Feats.WEAPON_FOCUS);
		bonusEligibleFeats.add(D20SRD.Feats.WEAPON_SPECIALIZATION);
		bonusEligibleFeats.add(D20SRD.Feats.GREATER_WEAPON_FOCUS);
		bonusEligibleFeats.add(D20SRD.Feats.GREATER_WEAPON_SPECIALIZATION);
		
		bonusEligibleFeats.add(D20SRD.Feats.GREATER_MANYSHOT);
		bonusEligibleFeats.add(D20SRD.Feats.POWER_CRITICAL);
		bonusEligibleFeats.add(D20SRD.Feats.SHARP_SHOOTING);
		
	}
	
	private ArrayList<D20Feat> bonusEligibleFeats = new ArrayList<D20Feat>();
	
	public ArrayList<D20Feat> getBonusEligibleFeats() { 
		return bonusEligibleFeats;
	}
	
	public void addBonusEligibleFeat(D20Feat feat) { 
		bonusEligibleFeats.add(feat);
	}
	
	@Override
	public void onGain(D20Character chara) { 
		D20Character character = (D20Character)chara;
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelOfClass(this);
		
		if (classLevel == 1 || classLevel %2 == 0) { 

			// bonus fighter feats!
			ChooseObjectEvent bonusFeat = new ChooseObjectEvent(D20UIEvents.CHOOSE_FEAT, "Choose a fighter bonus feat.");
			bonusFeat.setQtyToPick(1);
			
			for (D20Feat f : bonusEligibleFeats) { 
				if (f != null)
					bonusFeat.addChoice(f);
			}
			
			character.fireCharGenEvent(bonusFeat);
		}
	
		
		if (classLevel == 1) { 
			
			character.addFeat(D20SRD.Feats.SIMPLE_WEAPON_PROFICIENCY, null, true);
			character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, null, true);
			character.addFeat(D20SRD.Feats.LIGHT_ARMOR_PROFICIENCY, null, true);
			character.addFeat(D20SRD.Feats.MEDIUM_ARMOR_PROFICIENCY, null, true);
			character.addFeat(D20SRD.Feats.HEAVY_ARMOR_PROFICIENCY, null, true);
			character.addFeat(D20SRD.Feats.SHIELD_PROFICIENCY, null, true);
			character.addFeat(D20SRD.Feats.TOWER_SHIELD_PROFICIENCY, null, true);
			
			
		}
		
	}

}
