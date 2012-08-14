package com.darkenedsky.gemini.common;

public interface Gainable<T extends GameCharacter> {

	public void onGain(T character);
	
}
