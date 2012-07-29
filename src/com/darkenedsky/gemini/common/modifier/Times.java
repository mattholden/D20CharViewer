package com.darkenedsky.gemini.common.modifier;


public class Times extends Modifier {
	public Times(int amt) { super(amt); 	}
	public int modify(int value) { 	return value * amount; 	}
	public String toString() { 	return " * " + amount; }
}
