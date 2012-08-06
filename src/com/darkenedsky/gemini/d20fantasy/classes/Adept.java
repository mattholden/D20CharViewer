package com.darkenedsky.gemini.d20fantasy.classes;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.Progression;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20NPCClass;
import com.darkenedsky.gemini.d20system.D20SpellcasterClass;

public class Adept extends D20NPCClass implements D20SpellcasterClass, D20Fantasy {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1041503408684533949L;

	public Adept() {
		super("Adept", "http://www.d20srd.org/srd/npcClasses/adept.htm");
		babProgression = BAB_LOW;
		fortSaveProgression = SAVE_BONUS_LOW;
		reflexSaveProgression = SAVE_BONUS_LOW;
		willSaveProgression = SAVE_BONUS_HIGH;
		skillPoints = 2;
		hitDice = new Dice(1,6);
		
		this.spellsPerDay[0] = new Progression(3);
		this.spellsPerDay[1] = new Progression(1,1,2,2,2,2,3);
		this.spellsPerDay[2] = new Progression(null,null,null,0,1,1,2,2,2,2,3);
		this.spellsPerDay[3] = new Progression(null,null,null,null,null,null,null,0,1,1,2,2,2,2,3);
		this.spellsPerDay[4] = new Progression(null,null,null,null,null,null,null,null,null,null,null,0,1,1,2);
		this.spellsPerDay[5] = new Progression(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,0,1,1,2);
		// 6-9 are already 0
		
		addClassSkill(D20SRD.Skills.CONCENTRATION);
		addClassSkill(D20SRD.Skills.CRAFT);
		addClassSkill(D20SRD.Skills.HANDLE_ANIMAL);
		addClassSkill(D20SRD.Skills.HEAL);
		addClassSkill(D20SRD.Skills.KNOWLEDGE);
		addClassSkill(D20SRD.Skills.PROFESSION);
		addClassSkill(D20SRD.Skills.SPELLCRAFT);
		addClassSkill(D20SRD.Skills.SURVIVAL);
		
	}
	
	@Override
	public void onGain(GameCharacter chara) { 
		D20Character character = (D20Character)chara;
	
		int classLevel = character.getLevelOfClass(this);
		if (classLevel == 1) {
			character.addFeat(D20SRD.Feats.SIMPLE_WEAPON_PROFICIENCY, "*", true);			
		}
		else if (classLevel == 2) { 
			character.addAbility(D20SRD.Abilities.SUMMON_FAMILIAR, null);
		}
		
		
	}

}
