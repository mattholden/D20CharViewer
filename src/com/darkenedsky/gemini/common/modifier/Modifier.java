package com.darkenedsky.gemini.common.modifier;


public abstract class Modifier {
	protected int amount;
	
	public abstract int modify(int value);

	public Modifier(int amt) { 
		this.amount = amt;
	}
}




