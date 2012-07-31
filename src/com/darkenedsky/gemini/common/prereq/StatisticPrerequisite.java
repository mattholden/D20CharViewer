package com.darkenedsky.gemini.common.prereq;

import org.jdom.Element;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.XMLTools;

public class StatisticPrerequisite implements Prerequisite { 
	
	protected int score, value;
	public StatisticPrerequisite(int score, int value) { 
		this.score = score;
		this.value = value;
	}
	
	@Override
	public boolean satisfies(GameCharacter character) { 
		return (character.getStat(score).getBaseValue() >= value);
	}

	public StatisticPrerequisite(Element e) { 
		score = XMLTools.getInt(e,"score");
		value = XMLTools.getInt(e, "value");
	}
	
	@Override
	public Element toXML(String root) { 
		Element e = new Element(root);		
		e.addContent(XMLTools.xml("class", getClass().getName()));
		e.addContent(XMLTools.xml("score", score));
		e.addContent(XMLTools.xml("value", value));
		return e;
	}
	
}
