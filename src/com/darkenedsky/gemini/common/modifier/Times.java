package com.darkenedsky.gemini.common.modifier;


public class Times extends Modifier {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3207964267214317921L;
	public Times(int amt) { super(amt); 	}
	public int modify(int value) { 	return value * amount; 	}
	public String toString() { 	return " * " + amount; }
}
