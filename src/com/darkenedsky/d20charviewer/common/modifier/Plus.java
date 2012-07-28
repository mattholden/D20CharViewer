package com.darkenedsky.d20charviewer.common.modifier;


public class Plus extends Modifier {
	public Plus(int amt) { super(amt); 	}
	public int modify(int value) { 	return value + amount; 	}
	public String toString() { 	return " + " + amount; }
}