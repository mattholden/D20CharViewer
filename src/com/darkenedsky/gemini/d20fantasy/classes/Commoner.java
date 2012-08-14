package com.darkenedsky.gemini.d20fantasy.classes;
import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.event.ChooseStringEvent;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;

import com.darkenedsky.gemini.d20system.D20NPCClass;
import com.darkenedsky.gemini.d20system.D20UIEvents;

public class Commoner extends D20NPCClass implements D20Fantasy {

	/**
	 * TODO: Weapon list
	 */
	private static final long serialVersionUID = -7233516754646135330L;

	public Commoner() {
		super("Commoner", "http://www.d20srd.org/srd/npcClasses/commoner.htm");
		hitDice = new Dice(1,4);
		skillPoints = 2;
		babProgression = BAB_LOW;
		this.fortSaveProgression = SAVE_BONUS_LOW;
		this.reflexSaveProgression = SAVE_BONUS_LOW;
		this.willSaveProgression = SAVE_BONUS_LOW;		
		
		addClassSkill(D20SRD.Skills.CLIMB);
		addClassSkill(D20SRD.Skills.CRAFT);
		addClassSkill(D20SRD.Skills.HANDLE_ANIMAL);
		addClassSkill(D20SRD.Skills.INTIMIDATE);
		addClassSkill(D20SRD.Skills.JUMP);
		addClassSkill(D20SRD.Skills.PROFESSION);
		addClassSkill(D20SRD.Skills.RIDE);
		addClassSkill(D20SRD.Skills.LISTEN);
		addClassSkill(D20SRD.Skills.USE_ROPE);
		addClassSkill(D20SRD.Skills.SPOT);
		addClassSkill(D20SRD.Skills.SWIM);
	}
	
	@Override
	public void onGain(D20Character character) { 
		super.onGain(character);
		
		int classLevel = character.getLevelOfClass(this);
		if (classLevel == 1) { 
			ChooseStringEvent weapon = new ChooseStringEvent(D20UIEvents.CHOOSE_SIMPLE_WEAPON, "Select a weapon to become proficient with.");
			weapon.setAllowOther(false);
			
			// TODO: add list of simple weapons
			
			character.fireCharGenEvent(weapon);
		}
	}

	
	
}