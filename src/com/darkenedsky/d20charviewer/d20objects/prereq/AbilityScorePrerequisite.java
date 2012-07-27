package com.darkenedsky.d20charviewer.d20objects.prereq;

import com.darkenedsky.d20charviewer.d20objects.D20Character;

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
