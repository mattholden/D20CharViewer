package com.darkenedsky.d20charviewer.common.event;
import java.util.ArrayList;

import com.darkenedsky.d20charviewer.common.RuleObject;
import com.darkenedsky.d20charviewer.common.Specialized;
import com.darkenedsky.d20charviewer.d20objects.D20Character;

public class CharacterEvent<T extends RuleObject> {
	
	public CharacterEvent(D20Character charr, String eCode, CharacterListener<T> callBack) { 
		character = charr;
		eventCode = eCode;
		callback = callBack;
	}
		
	private ArrayList<Specialized<T>> inObjects = new ArrayList<Specialized<T>>();
	private ArrayList<Specialized<T>> outObjects = new ArrayList<Specialized<T>>();
	
	private CharacterListener<T> callback;
	
	private D20Character character;
	private String eventCode;
	
	public void setCharacter(D20Character character) {
		this.character = character;
	}
	public D20Character getCharacter() {
		return character;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public String getEventCode() {
		return eventCode;
	}
	
	public void executeCallback(D20Character cha) { 
		if (callback != null)
			callback.actionPerformed(this);		
	}

	public void addInObject(T object, String spec) { 
		inObjects.add(new Specialized<T>(object,spec));
	}
	public void addOutObject(T object, String spec) { 
		outObjects.add(new Specialized<T>(object,spec));
	}
	public ArrayList<Specialized<T>> getInObjects() { 
		return inObjects;
	}
	public ArrayList<Specialized<T>> getOutObjects() { 
		return outObjects;
	}
	
	
}
