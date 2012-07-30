package com.darkenedsky.gemini.common.prereq;

import com.darkenedsky.gemini.d20system.D20Character;

public interface HasPrerequisites {

	public boolean hasPrerequisites(D20Character character);
	
	public void addPrerequisite(Prerequisite pre);
	
}
