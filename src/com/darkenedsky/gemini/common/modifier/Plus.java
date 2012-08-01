package com.darkenedsky.gemini.common.modifier;


public class Plus extends Modifier {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7253603754906263801L;
	public Plus(int amt) { super(amt); 	}
	public int modify(int value) { 	return value + amount; 	}
	public String toString() { 	return " + " + amount; }
}