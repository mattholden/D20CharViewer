package com.darkenedsky.gemini.d20system;

import java.io.Serializable;

import com.darkenedsky.gemini.common.modifier.Plus;

/**
 * Constants for indexing arrays. Just easier this way. 
 * @author Matt Holden
 *
 */
public interface D20 extends Serializable {

	// LIBRARY CONSTANTS
	public static final String
		FEATS = "feats",
		SIZE = "size",
		ALIGNMENT = "alignment",
		SPELLCASTER_TYPES = "spellcaster_types";
	
	// for bonuses
	public static final int ALL_SAVES = -1;
	public static final int ALL_ABILITY_SCORES = -2;
	
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
		FORT = 10,
		REFLEX = 11,
		WILL = 12;
	
	// other things there might be bonuses to
	public static final int
		ATTACK = 20,
		DODGE = 21,
		DAMAGE = 22,
		DAMAGE_REDUCTION = 23,
		ARMOR_CLASS = 24,
		INITIATIVE = 25,
		BASE_SPEED = 26,
		RANGED_ATTACK = 27,
		RANGED_DAMAGE = 28,
		GRAPPLE_ATTACK = 29;
	
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

	/*
	bard,barb 4d4x10
	cleric,rog 5d4x10
	dru 2d4x10
	fight,pal, rgr 6d4x10
	mnk 5d4
	wiz,src 3d4x10
	*/
	
}
