package com.darkenedsky.gemini.d20system.prereq;

import org.jdom.Element;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.XMLTools;
import com.darkenedsky.gemini.common.prereq.Prerequisite;
import com.darkenedsky.gemini.d20system.D20Character;

public class TotalLevelPrerequisite implements Prerequisite {
	
	public TotalLevelPrerequisite(int level) { 
		this.level = level;
	}

	private int level = 0;
	
	@Override
	public boolean satisfies(GameCharacter character) { 
		return ((D20Character)character).getCharacterLevel() >= level;
	}
	
	public TotalLevelPrerequisite(Element e) { 
		level = XMLTools.getInt(e,"level");
	}
	
	@Override
	public Element toXML(String root) { 
		Element e = new Element(root);		
		e.addContent(XMLTools.xml("class", getClass().getName()));
		e.addContent(XMLTools.xml("level", level));
		return e;
	}
	
}
