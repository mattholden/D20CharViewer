package com.darkenedsky.gemini.common.modifier;


public class DividedBy_RoundUp extends Modifier {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7796389228051214851L;
	public DividedBy_RoundUp(int amt) { super(amt); 	}
	public int modify(int value) {
		if (amount == 0) return value;			
		return (value / amount) + (value % 2);
	}
	public String toString() { 	return " / " + amount; }
}
