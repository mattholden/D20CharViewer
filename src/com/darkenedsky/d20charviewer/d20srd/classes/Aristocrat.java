package com.darkenedsky.d20charviewer.d20srd.classes;

import com.darkenedsky.d20charviewer.common.Dice;
import com.darkenedsky.d20charviewer.common.Progression;
import com.darkenedsky.d20charviewer.common.modifier.Times;
import com.darkenedsky.d20charviewer.d20objects.D20Character;
import com.darkenedsky.d20charviewer.d20objects.D20Class;
import com.darkenedsky.d20charviewer.d20objects.D20Race;
import com.darkenedsky.d20charviewer.d20srd.D20SRD;

public class Aristocrat extends D20Class {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7233516754646135330L;

	public Aristocrat() {
		super("Aristocrat", "http://www.d20srd.org/srd/classes/aristocrat.htm");
		ageClass = (D20Race.AGE_MOD_FIGHTER);
		hitDice = new Dice(1,8);
		skillPoints = 4;
		babProgression = Progression.CLERIC_BAB;
		this.fortSaveProgression = Progression.SAVE_BONUS_LOW;
		this.reflexSaveProgression = Progression.SAVE_BONUS_LOW;
		this.willSaveProgression = Progression.SAVE_BONUS_HIGH;		
	
		startingGold = new Dice(6,4);
		startingGold.addModifier(new Times(10));
		
		addClassSkill(D20SRD.Skills.APPRAISE);
		addClassSkill(D20SRD.Skills.BLUFF);
		addClassSkill(D20SRD.Skills.DIPLOMACY);
		addClassSkill(D20SRD.Skills.DISGUISE);
		addClassSkill(D20SRD.Skills.FORGERY);
		addClassSkill(D20SRD.Skills.GATHER_INFORMATION);
		addClassSkill(D20SRD.Skills.HANDLE_ANIMAL);
		addClassSkill(D20SRD.Skills.INTIMIDATE);
		addClassSkill(D20SRD.Skills.KNOWLEDGE,"*");
		addClassSkill(D20SRD.Skills.LISTEN);
		addClassSkill(D20SRD.Skills.PERFORM,"*");
		addClassSkill(D20SRD.Skills.RIDE);
		addClassSkill(D20SRD.Skills.SENSE_MOTIVE);
		addClassSkill(D20SRD.Skills.SPEAK_LANGUAGE,"*");
		addClassSkill(D20SRD.Skills.SPOT);
		addClassSkill(D20SRD.Skills.SURVIVAL);
	}
	
	@Override
	public void onGain(D20Character character) { 		
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelMap().get(this);
				
		if (classLevel == 1) { 
			
			character.addFeat(D20SRD.Feats.SIMPLE_WEAPON_PROFICIENCY, "*", true);
			character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "*", true);
			character.addFeat(D20SRD.Feats.LIGHT_ARMOR_PROFICIENCY, "*", true);
			character.addFeat(D20SRD.Feats.MEDIUM_ARMOR_PROFICIENCY, "*", true);
			character.addFeat(D20SRD.Feats.HEAVY_ARMOR_PROFICIENCY, "*", true);
			character.addFeat(D20SRD.Feats.SHIELD_PROFICIENCY, null, true);
			character.addFeat(D20SRD.Feats.TOWER_SHIELD_PROFICIENCY, null, true);
			
			
		}
		
	}

}