package com.darkenedsky.d20charviewer.common.modifier;


public class DividedBy extends Modifier {
	public DividedBy(int amt) { super(amt); 	}
	public int modify(int value) {
		if (amount == 0) return value;
		return value / amount; 	
	}
	public String toString() { 	return " / " + amount; }
}
