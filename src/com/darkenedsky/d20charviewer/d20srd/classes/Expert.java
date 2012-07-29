package com.darkenedsky.d20charviewer.d20srd.classes;
import java.util.Map;

import com.darkenedsky.d20charviewer.common.Dice;
import com.darkenedsky.d20charviewer.common.Progression;
import com.darkenedsky.d20charviewer.common.event.CharacterEvent;
import com.darkenedsky.d20charviewer.common.event.CharacterListener;
import com.darkenedsky.d20charviewer.common.modifier.Times;
import com.darkenedsky.d20charviewer.d20objects.D20Character;
import com.darkenedsky.d20charviewer.d20objects.D20Class;
import com.darkenedsky.d20charviewer.d20objects.D20Race;
import com.darkenedsky.d20charviewer.d20objects.D20Skill;
import com.darkenedsky.d20charviewer.d20objects.D20UIEvents;
import com.darkenedsky.d20charviewer.d20srd.D20SRD;

public class Expert extends D20Class implements CharacterListener<D20Skill> {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -7233516754646135330L;

	public Expert() {
		super("Expert", "http://www.d20srd.org/srd/classes/expert");
		ageClass = (D20Race.AGE_MOD_ROGUE);
		hitDice = new Dice(1,6);
		skillPoints = 6;
		babProgression = Progression.CLERIC_BAB;
		this.fortSaveProgression = Progression.SAVE_BONUS_LOW;
		this.reflexSaveProgression = Progression.SAVE_BONUS_LOW;
		this.willSaveProgression = Progression.SAVE_BONUS_HIGH;		
		
		startingGold = new Dice(5,4);
		startingGold.addModifier(new Times(10));				
	}

	/** Ask for the first class skill */
	@Override
	public void onGain(D20Character character) { 		
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelMap().get(this);
				
		// if we need to pick class skills
		if (classLevel == 1) {
			character.addFeat(D20SRD.Feats.SIMPLE_WEAPON_PROFICIENCY, "*", true);
			character.addFeat(D20SRD.Feats.LIGHT_ARMOR_PROFICIENCY, "*", true);
			
			CharacterEvent<D20Skill> e= new CharacterEvent<D20Skill>(character, D20UIEvents.CHOOSE_CLASS_SKILL, this);
			for (D20Skill s : D20SRD.Skills.getSkills())				
				e.addInObject(s,null);
		}
		// if we already have a level of Expert, keep the same class skills
		else { 
			for (Map.Entry<D20Class, Integer> e : character.getLevelMap().entrySet()) { 
				if (e.getKey().equals(this)) { 
					addClassSkills(e.getKey());
					return;
				}
			}
		}
		
	}
	
	/** Ask for more class skills until we have 10. 	 
	 */
	@Override
	public void actionPerformed(CharacterEvent<D20Skill> event) { 
		this.addClassSkill(event.getOutObjects().get(0).ability);
		if (this.getClassSkillCount() < 10) { 
			CharacterEvent<D20Skill> e= new CharacterEvent<D20Skill>(event.getCharacter(), D20UIEvents.CHOOSE_CLASS_SKILL, this);
			for (D20Skill s : D20SRD.Skills.getSkills())				
				e.addInObject(s,null);		
		}
	}

}