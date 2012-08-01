package com.darkenedsky.gemini.common.modifier;


public class DividedBy extends Modifier {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6258029684417016209L;
	public DividedBy(int amt) { super(amt); 	}
	public int modify(int value) {
		if (amount == 0) return value;
		return value / amount; 	
	}
	public String toString() { 	return " / " + amount; }
}
