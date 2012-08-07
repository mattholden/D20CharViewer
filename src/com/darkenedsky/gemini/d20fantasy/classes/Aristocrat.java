package com.darkenedsky.gemini.d20fantasy.classes;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20NPCClass;

public class Aristocrat extends D20NPCClass implements D20Fantasy{

	/**
	 * DONE
	 */
	private static final long serialVersionUID = -7233516754646135330L;

	public Aristocrat() {
		super("Aristocrat", "http://www.d20srd.org/srd/npcClasses/aristocrat.htm");
		hitDice = new Dice(1,8);
		skillPoints = 4;
		babProgression = BAB_AVERAGE;
		this.fortSaveProgression = SAVE_BONUS_LOW;
		this.reflexSaveProgression = SAVE_BONUS_LOW;
		this.willSaveProgression = SAVE_BONUS_HIGH;		
	
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
		addClassSkill(D20SRD.Skills.SPEAK_LANGUAGE,null);
		addClassSkill(D20SRD.Skills.SPOT);
		addClassSkill(D20SRD.Skills.SURVIVAL);
	}
	
	@Override
	public void onGain(GameCharacter chara) { 
		D20Character character = (D20Character)chara;
 		
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelOfClass(this);
				
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