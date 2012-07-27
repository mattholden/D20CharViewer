package com.darkenedsky.d20charviewer.d20objects.prereq;

import com.darkenedsky.d20charviewer.d20objects.D20Character;

public class TotalLevelPrerequisite implements Prerequisite {
	
	public TotalLevelPrerequisite(int level) { 
		this.level = level;
	}

	private int level = 0;
	
	public boolean satisfies(D20Character character) { 
		return character.getCharacterLevel() >= level;
	}
}
