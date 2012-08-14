package com.darkenedsky.gemini.d20system;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.Progression;

public class D20CreatureType extends D20Object  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1450384241688269993L;

	public D20CreatureType(String name, String sRDURL) {
		super(name, sRDURL);
		
	}
	
	protected Dice hitDice = null;
	protected Progression
		baseAttack = D20Class.BAB_LOW,
		fortitude = D20Class.SAVE_BONUS_LOW,
		reflex = D20Class.SAVE_BONUS_LOW,
		will = D20Class.SAVE_BONUS_LOW;
	protected int skillPoints;
	protected boolean breathes = true, eats = true, sleeps = true;

	public Dice getHitDice() {
		return hitDice;
	}
	public Progression getBaseAttack() {
		return baseAttack;
	}
	public Progression getFortitude() {
		return fortitude;
	}
	public Progression getReflex() {
		return reflex;
	}
	public Progression getWill() {
		return will;
	}
	public int getSkillPoints() {
		return skillPoints;
	}
	public boolean breathes() {
		return breathes;
	}
	public boolean eats() {
		return eats;
	}
	public boolean sleeps() {
		return sleeps;
	}
	
	
}
