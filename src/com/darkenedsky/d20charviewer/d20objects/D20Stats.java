package com.darkenedsky.d20charviewer.d20objects;

import com.darkenedsky.d20charviewer.common.modifier.Plus;

/**
 * Constants for indexing arrays. Just easier this way. 
 * @author Matt Holden
 *
 */
public interface D20Stats {

	// for bonuses
	public static final int ALL = -1;
	
	// a bonus so big, you're immune
	public static final int IMMUNE = 999999;
	public static final Plus IMMUNITY = new Plus(IMMUNE);
	
	// ability scores
	public static final int
		STR = 0,
		DEX = 1,
		CON = 2,
		INT = 3,
		WIS = 4,
		CHA = 5;
	
	// saves
	public static final int
		FORT = 0,
		REFLEX = 1,
		WILL = 2;
	
	// age ranges
	public static final int
		YOUTH = 0,
		ADULTHOOD = 1,
		MIDDLEAGE = 2,
		OLD = 3,
		VENERABLE = 4;
			
	// feat categories
	public static final int
		FEAT_GENERAL = 0,
		FEAT_METAMAGIC = 1,
		FEAT_ITEMCREATION = 2,
		FEAT_SPECIAL = 3;

	// ability types
	public static final int
		ABILITY_EXTRAORDINARY = 4,
		ABILITY_SUPERNATURAL = 5,
		ABILITY_SPELL_LIKE = 6,
		ABILITY_NATURAL = 7;

}
