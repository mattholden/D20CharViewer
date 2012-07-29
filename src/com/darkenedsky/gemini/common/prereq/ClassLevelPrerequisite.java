package com.darkenedsky.gemini.common.prereq;

import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;

public class ClassLevelPrerequisite implements Prerequisite {
	
	private D20Class clazz;
	private int level;
	
	public ClassLevelPrerequisite(D20Class clazz, int level) { 
		this.clazz = clazz;
		this.level = level;
	}
	
	public boolean satisfies(D20Character character) { 
		Integer i = character.getLevelMap().get(clazz);
		if (i == null) return false;
		return i >= level;
	}

}
