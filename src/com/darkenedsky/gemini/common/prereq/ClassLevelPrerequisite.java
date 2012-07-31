package com.darkenedsky.gemini.common.prereq;

import org.jdom.Element;

import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.XMLTools;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;

public class ClassLevelPrerequisite implements Prerequisite {
	
	private D20Class clazz;
	private int level;
	
	public ClassLevelPrerequisite(D20Class clazz, int level) { 
		this.clazz = clazz;
		this.level = level;
	}
	
	public boolean satisfies(D20Character character) { 
		Integer i = character.getLevelMap().get(clazz);
		if (i == null) return false;
		return i >= level;
	}

	@Override
	public Element toXML(String root) {
		Element e = new Element(root);
		e.addContent(XMLTools.xml("classrequired", clazz.getUniqueID()));
		e.addContent(XMLTools.xml("class", getClass().getName()));
		e.addContent(XMLTools.xml("level", level));
		return e;
	}
	
	public ClassLevelPrerequisite(Element e) { 
		clazz = (D20Class)Library.instance.getByID(e.getChildText("classrequired"));
		level = XMLTools.getInt(e, "level");
	}
	

}
