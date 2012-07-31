package com.darkenedsky.gemini.common.prereq;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.XMLSerializable;

/** 
 * Interface for a type of prerequisite
 * @author Matt Holden
 *
 */
public interface Prerequisite extends XMLSerializable {

	public boolean satisfies(GameCharacter character);
	
}
