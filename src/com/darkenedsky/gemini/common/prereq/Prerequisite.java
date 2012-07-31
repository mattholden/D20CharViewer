package com.darkenedsky.gemini.common.prereq;

import com.darkenedsky.gemini.common.XMLSerializable;
import com.darkenedsky.gemini.d20system.D20Character;

/** 
 * Interface for a type of prerequisite
 * @author Matt Holden
 *
 */
public interface Prerequisite extends XMLSerializable {

	public boolean satisfies(D20Character character);
	
}
