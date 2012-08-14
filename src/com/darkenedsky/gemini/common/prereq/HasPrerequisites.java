package com.darkenedsky.gemini.common.prereq;

import com.darkenedsky.gemini.common.GameCharacter;

public interface HasPrerequisites<T extends GameCharacter> {

	public boolean hasPrerequisites(T character);
	
}
