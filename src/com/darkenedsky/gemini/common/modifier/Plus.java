package com.darkenedsky.gemini.common.modifier;


public class Plus extends Modifier {
	public Plus(int amt) { super(amt); 	}
	public int modify(int value) { 	return value + amount; 	}
	public String toString() { 	return " + " + amount; }
}