package com.darkenedsky.d20charviewer.common.prereq;

import com.darkenedsky.d20charviewer.d20objects.D20Character;

/** 
 * Interface for a type of prerequisite
 * @author Matt Holden
 *
 */
public interface Prerequisite {

	public boolean satisfies(D20Character character);
	
}
