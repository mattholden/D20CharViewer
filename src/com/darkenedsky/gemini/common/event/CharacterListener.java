package com.darkenedsky.gemini.common.event;

import com.darkenedsky.gemini.common.RuleObject;

public interface CharacterListener<T extends RuleObject> {

	void actionPerformed(CharacterEvent<T> uiEvent);
	
	
}
