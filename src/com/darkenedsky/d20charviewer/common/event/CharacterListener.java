package com.darkenedsky.d20charviewer.common.event;

import com.darkenedsky.d20charviewer.common.RuleObject;

public interface CharacterListener<T extends RuleObject> {

	void actionPerformed(CharacterEvent<T> uiEvent);
	
	
}
