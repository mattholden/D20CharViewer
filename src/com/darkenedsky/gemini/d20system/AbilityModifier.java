package com.darkenedsky.gemini.d20system;
import org.jdom.Element;

import com.darkenedsky.gemini.common.modifier.Modifier;

public class AbilityModifier extends Modifier {

	private D20Character character;
	private int scoreToUse;
	
	public AbilityModifier(D20Character character, int score) {
		super(0);
		scoreToUse = score;
		this.character = character;
	}

	@Override
	public int modify(int value) {
		return value + character.getAbilityScoreModifier(scoreToUse);
	}
	
	public AbilityModifier(Element e) { super(e); }
	
}
