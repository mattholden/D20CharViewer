package com.darkenedsky.gemini.common.prereq;

import com.darkenedsky.gemini.d20system.D20Character;

/** 
 * Interface for a type of prerequisite
 * @author Matt Holden
 *
 */
public interface Prerequisite {

	public boolean satisfies(D20Character character);
	
}
