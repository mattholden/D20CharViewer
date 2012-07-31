package com.darkenedsky.gemini.common.prereq;

import org.jdom.Element;

import com.darkenedsky.gemini.d20system.D20Character;

public class ModifiedStatPrerequisite extends StatisticPrerequisite {

	public ModifiedStatPrerequisite(int score, int value) {
		super(score, value);
	} 
	
	@Override
	public boolean satisfies(D20Character character) { 
		return (character.getStat(score).getValueWithPermanentBonuses(character) >= value);
	}

	public ModifiedStatPrerequisite(Element e) { 
		super(e);
	}
	
}
