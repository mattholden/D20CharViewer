package com.darkenedsky.d20charviewer.d20objects;
import java.util.ArrayList;

import com.darkenedsky.d20charviewer.common.Dice;
import com.darkenedsky.d20charviewer.common.RuleObject;

public class D20Race extends RuleObject implements D20Stats {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5209098136499821609L;

	public D20Race(String name, String sRDURL) {
		super(name, sRDURL);
	}
	
	protected ArrayList<String> bonusLanguages = new ArrayList<String>();
	
	protected int baseSpeed = 30;
	protected D20Size size = D20Size.MEDIUM;
	protected D20Class favoredClass = null;
	
	// for monster races. SRD stuff will mostly ignore.	
	protected int eCL = 1;
	
	protected int[] mods = new int[6];
	protected int[] ageRanges = new int[5];
	protected int baseHeightM, baseHeightF, baseWeightM, baseWeightF;
	protected Dice modHeightM, modHeightF, modWeightM, modWeightF;
	protected Dice[] ageModsByClass = new Dice[3];
	protected Dice maxAge;
	
	protected final int ht(int ft, int in) { return (ft*12)+in; }
	
	D20Size getSize() {
		return size;
	}
	public void setSize(D20Size size) {
		this.size = size;
	}
	public int getECL() {
		return eCL;
	}
	
	public int getAbilityMod(int stat) {
		return (stat < 0 || stat > 5) ? -1 : mods[stat];
	}
	
	// Constants to index which age modifier we want based on class.
	// looks a little goofy to do it this way, but there's really nowhere good for this info to live.
	public static final int
		AGE_MOD_BARBARIAN = 0,
		AGE_MOD_ROGUE = 0,
		AGE_MOD_SORCERER = 0,
		AGE_MOD_BARD = 1,
		AGE_MOD_FIGHTER = 1,
		AGE_MOD_PALADIN = 1,
		AGE_MOD_RANGER = 1,
		AGE_MOD_CLERIC = 2,
		AGE_MOD_DRUID = 2,
		AGE_MOD_MONK = 2,
		AGE_MOD_WIZARD = 2;
	
	/** 
	 * Roll height, weight, and age for a character
	 * @param character
	 * @param desiredAgeRange 
	 */
	public void rollVitals(D20Character character, int desiredAgeRange) { 
		
		boolean male = character.isMale();
		Dice modH = null, modW = null;
		int baseH = 0, baseW = 0;
		
		if (male) { 
			baseH = baseHeightM;
			modH = modHeightM;
			baseW = baseWeightM;
			modW = modWeightM;
		}
		else { 
			baseH = baseHeightF;
			modH = modHeightF;
			baseW = baseWeightF;
			modW = modWeightF;		
		}
		
		int hRoll = modH.roll();
		int wRoll = modW.roll();
		character.setHeight(baseH + hRoll);
		character.setWeight(baseW + (wRoll * hRoll));
		
		// if invalid, assume the most common.
		if (desiredAgeRange < YOUTH || desiredAgeRange > VENERABLE)
			desiredAgeRange = ADULTHOOD;
		
		int baseA = ageRanges[desiredAgeRange];
		
		D20Class ageC = character.getClassForLevel(1);
		int ageClass = AGE_MOD_RANGER;
		
		if (ageC != null)
			ageClass = ageC.getAgeClass();
		
		// if invalid, split the difference
		if (ageClass < AGE_MOD_BARBARIAN || ageClass > AGE_MOD_WIZARD) { 
			ageClass = AGE_MOD_RANGER;
		}
		
		Dice ageMod = ageModsByClass[ageClass];
		character.setAge(baseA + ageMod.roll());
		
		// apply aging modifiers to ability scores
		// these are deliberately cumulative
		if (desiredAgeRange >= MIDDLEAGE) { 
			character.setAbilityScore(STR, character.getAbilityScore(STR) -1);
			character.setAbilityScore(DEX, character.getAbilityScore(DEX) -1);
			character.setAbilityScore(CON, character.getAbilityScore(CON) -1);
			character.setAbilityScore(INT, character.getAbilityScore(INT) +1);
			character.setAbilityScore(WIS, character.getAbilityScore(WIS) +1);
			character.setAbilityScore(CHA, character.getAbilityScore(CHA) +1);
		}
		if (desiredAgeRange >= OLD) { 
			character.setAbilityScore(STR, character.getAbilityScore(STR) -2);
			character.setAbilityScore(DEX, character.getAbilityScore(DEX) -2);
			character.setAbilityScore(CON, character.getAbilityScore(CON) -2);
			character.setAbilityScore(INT, character.getAbilityScore(INT) +1);
			character.setAbilityScore(WIS, character.getAbilityScore(WIS) +1);
			character.setAbilityScore(CHA, character.getAbilityScore(CHA) +1);			
		}
		if (desiredAgeRange >= VENERABLE) { 
			character.setAbilityScore(STR, character.getAbilityScore(STR) -3);
			character.setAbilityScore(DEX, character.getAbilityScore(DEX) -3);
			character.setAbilityScore(CON, character.getAbilityScore(CON) -3);
			character.setAbilityScore(INT, character.getAbilityScore(INT) +1);
			character.setAbilityScore(WIS, character.getAbilityScore(WIS) +1);
			character.setAbilityScore(CHA, character.getAbilityScore(CHA) +1);
		}
		
	}
	
	@Override
	public void onGain(D20Character character) { 
		
		// take on the size. (might be some special stuffs there)
		character.setSize(this.size);
		size.onGain(character);
		
		character.setBaseSpeed(this.baseSpeed);
		
		// ability score mods.
		for (int i = STR; i < CHA; i++) { 
			character.setAbilityScore(i, character.getAbilityScore(i) + this.mods[i]);
		}
		
		
	}
		
}
