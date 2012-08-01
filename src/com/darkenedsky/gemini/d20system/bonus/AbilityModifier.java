package com.darkenedsky.gemini.d20system.bonus;
import org.jdom.Element;

import com.darkenedsky.gemini.common.modifier.Modifier;
import com.darkenedsky.gemini.d20system.D20Character;

public class AbilityModifier extends Modifier {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5078238555649225999L;
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
