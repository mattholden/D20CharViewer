package com.darkenedsky.gemini.common.event;

public class CharacterGeneratorEvent {
	

	public CharacterGeneratorEvent(String eCode) {
		eventCode = eCode;		
	}
		
	private String eventCode;
	
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public String getEventCode() {
		return eventCode;
	}
	
	
	
	
}
