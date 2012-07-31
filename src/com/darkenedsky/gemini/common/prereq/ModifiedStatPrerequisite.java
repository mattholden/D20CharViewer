package com.darkenedsky.gemini.common.prereq;
import org.jdom.Element;
import com.darkenedsky.gemini.common.GameCharacter;

public class ModifiedStatPrerequisite extends StatisticPrerequisite {

	public ModifiedStatPrerequisite(int score, int value) {
		super(score, value);
	} 
	
	@Override
	public boolean satisfies(GameCharacter character) { 
		return (character.getStat(score).getValueWithPermanentBonuses(character) >= value);
	}

	public ModifiedStatPrerequisite(Element e) { 
		super(e);
	}
	
}
