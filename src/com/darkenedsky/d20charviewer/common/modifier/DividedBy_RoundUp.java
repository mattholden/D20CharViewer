package com.darkenedsky.d20charviewer.common.modifier;


public class DividedBy_RoundUp extends Modifier {
	public DividedBy_RoundUp(int amt) { super(amt); 	}
	public int modify(int value) {
		if (amount == 0) return value;			
		return (value / amount) + (value % 2);
	}
	public String toString() { 	return " / " + amount; }
}
