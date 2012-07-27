package com.darkenedsky.d20charviewer.d20srd.classes;

import com.darkenedsky.d20charviewer.Dice;
import com.darkenedsky.d20charviewer.d20objects.D20Character;
import com.darkenedsky.d20charviewer.d20objects.D20Class;
import com.darkenedsky.d20charviewer.d20objects.D20Progression;
import com.darkenedsky.d20charviewer.d20objects.D20Race;
import com.darkenedsky.d20charviewer.d20srd.D20SRD;

public class Ranger extends D20Class {

	public Ranger() {
		super("Ranger", "");
		ageClass = (D20Race.AGE_MOD_RANGER);
		hitDice = new Dice(1,8);
		skillPoints = 4;
		babProgression = D20Progression.FIGHTER_BAB;
	}
	
	@Override
	public void onGain(D20Character character) { 		
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelMap().get(this);
		int totalLevel = character.getCharacterLevel();
		
		if (classLevel == 1) { 
			
			// everything that isn't a barbarian can read and write
			if (character.getSkillRanks(D20SRD.Skills.READING_WRITING, null) == 0)
				character.addSkillRank(D20SRD.Skills.READING_WRITING, null, false, true);
			
			
		}
		
	}

}
