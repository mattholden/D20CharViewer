package com.darkenedsky.gemini.common.prereq;

import com.darkenedsky.gemini.d20system.D20Character;

public class AbilityScorePrerequisite implements Prerequisite { 
	
	public int score, value;
	public AbilityScorePrerequisite(int score, int value) { 
		this.score = score;
		this.value = value;
	}
	
	public boolean satisfies(D20Character character) { 
		return (character.getAbilityScore(score) >= value);
	}

}
