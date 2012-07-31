package com.darkenedsky.gemini.common.prereq;

import com.darkenedsky.gemini.common.GameCharacter;

public interface HasPrerequisites {

	public boolean hasPrerequisites(GameCharacter character);
	
	public void addPrerequisite(Prerequisite pre);
	
}
