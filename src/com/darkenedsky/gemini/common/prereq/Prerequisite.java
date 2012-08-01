package com.darkenedsky.gemini.common.prereq;

import java.io.Serializable;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.XMLSerializable;

/** 
 * Interface for a type of prerequisite
 * @author Matt Holden
 *
 */
public interface Prerequisite extends Serializable, XMLSerializable {

	public boolean satisfies(GameCharacter character);
	
}
