package com.darkenedsky.gemini.d20fantasy.classes;
import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.RuleObject;
import com.darkenedsky.gemini.common.event.ChooseObjectEvent;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20NPCClass;
import com.darkenedsky.gemini.d20system.D20Skill;
import com.darkenedsky.gemini.d20system.D20UIEvents;

public class Expert extends D20NPCClass implements D20Fantasy {
 
	/**
	 * DONE
	 */
	private static final long serialVersionUID = -7233516754646135330L;

	public Expert() {
		super("Expert", "http://www.d20srd.org/srd/npcClasses/expert.htm");
		hitDice = new Dice(1,6);
		skillPoints = 6;
		babProgression = BAB_AVERAGE;
		this.fortSaveProgression = SAVE_BONUS_LOW;
		this.reflexSaveProgression = SAVE_BONUS_LOW;
		this.willSaveProgression = SAVE_BONUS_HIGH;		
						
	}

	/** Ask for the first class skill */
	@Override
	public void onGain(GameCharacter chara) { 
		D20Character character = (D20Character)chara;
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelOfClass(this);
				
		// if we need to pick class skills
		if (classLevel == 1) {
			character.addFeat(D20SRD.Feats.SIMPLE_WEAPON_PROFICIENCY, null, true);
			character.addFeat(D20SRD.Feats.LIGHT_ARMOR_PROFICIENCY, null, true);
			
			ChooseObjectEvent e= new ChooseObjectEvent(D20UIEvents.CHOOSE_CLASS_SKILL, "Choose your class skills.");
			e.setQtyToPick(10);
			for (RuleObject s : character.getLibrary().getSection(Library.SKILLS).getAll()) {
				if (s instanceof D20Skill) {			
					e.addChoice(s);
				}
			}
			character.fireCharGenEvent(e);
		}		
	}
	
	
}