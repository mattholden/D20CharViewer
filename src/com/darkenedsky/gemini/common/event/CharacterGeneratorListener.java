package com.darkenedsky.gemini.common.event;


public interface CharacterGeneratorListener {

	void receiveEvent(CharacterGeneratorEvent e);
	String getEventCode();
	
}
