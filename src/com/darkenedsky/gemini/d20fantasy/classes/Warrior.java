package com.darkenedsky.gemini.d20fantasy.classes;
import com.darkenedsky.gemini.common.Dice;

import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20NPCClass;

public class Warrior extends D20NPCClass implements D20Fantasy {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6491417231354862627L;

	public Warrior() {
		super("Warrior", "http://www.d20srd.org/srd/npcClasses/warrior.htm");
		hitDice = new Dice(1,8);
		skillPoints = 2;
		babProgression = BAB_HIGH;
		this.fortSaveProgression = SAVE_BONUS_HIGH;
		this.reflexSaveProgression = SAVE_BONUS_LOW;
		this.willSaveProgression = SAVE_BONUS_LOW;		
	
		addClassSkill(D20SRD.Skills.CLIMB);
		addClassSkill(D20SRD.Skills.HANDLE_ANIMAL);
		addClassSkill(D20SRD.Skills.INTIMIDATE);
		addClassSkill(D20SRD.Skills.JUMP);
		addClassSkill(D20SRD.Skills.RIDE);
		addClassSkill(D20SRD.Skills.SWIM);
		
	}

	@Override
	public void onGain(D20Character chara) { 
		D20Character character = (D20Character)chara;
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelOfClass(this);
		
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
