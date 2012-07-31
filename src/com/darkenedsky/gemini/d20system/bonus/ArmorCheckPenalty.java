package com.darkenedsky.gemini.d20system.bonus;

import org.jdom.Element;

import com.darkenedsky.gemini.common.modifier.Modifier;
import com.darkenedsky.gemini.d20system.D20Character;

public class ArmorCheckPenalty extends Modifier {
	
	private D20Character character;
	
	public ArmorCheckPenalty(D20Character character) {
		super(0);
		this.character = character;
	}

	@Override
	public int modify(int value) {
		return value;
	}
	
	public ArmorCheckPenalty(Element e) { super(e); }
	
}
