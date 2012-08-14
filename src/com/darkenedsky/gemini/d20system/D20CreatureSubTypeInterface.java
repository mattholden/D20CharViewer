package com.darkenedsky.gemini.d20system;
import com.darkenedsky.gemini.common.HasUID;

public interface D20CreatureSubTypeInterface extends D20, HasUID {

	public void onGain(D20Character character);
	
}
