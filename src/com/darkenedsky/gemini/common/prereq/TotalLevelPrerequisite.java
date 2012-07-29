package com.darkenedsky.gemini.common.prereq;

import com.darkenedsky.gemini.d20system.D20Character;

public class TotalLevelPrerequisite implements Prerequisite {
	
	public TotalLevelPrerequisite(int level) { 
		this.level = level;
	}

	private int level = 0;
	
	@Override
	public boolean satisfies(D20Character character) { 
		return character.getCharacterLevel() >= level;
	}
	
}
