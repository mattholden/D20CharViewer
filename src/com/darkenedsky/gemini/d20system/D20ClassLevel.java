package com.darkenedsky.gemini.d20system;

import java.io.Serializable;
import java.util.ArrayList;

import org.jdom.Element;

import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.Specialized;
import com.darkenedsky.gemini.common.XMLSerializable;
import com.darkenedsky.gemini.common.XMLTools;
import com.darkenedsky.gemini.d20system.prereq.RestrictsAlignment;

public class D20ClassLevel implements D20, XMLSerializable, Serializable, RestrictsAlignment {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8278296635971049131L;

	private D20Class classLeveled;
	
	public D20Class getClassLeveled() { return classLeveled; }
	
	public D20ClassLevel(D20Class claz) { 
		classLeveled = claz;
	}
	
	public Element toXML(String root) { 
		Element e = new Element(root);
		e.addContent(XMLTools.xml("class", getClass().getName()));
		e.addContent(XMLTools.xml("d20class", classLeveled.getUniqueID()));
		return e;
	}
	
	public D20ClassLevel(Element e) { 
		classLeveled = (D20Class)Library.instance.getByID(XMLTools.getString(e,"d20class"));
		
		
	}
	
	public ArrayList<Specialized<D20Skill>> getClassSkills() { 
		return classLeveled.getClassSkills();
	}
	
	public ArrayList<Specialized<D20Skill>> getForbiddenSkills() { 
		return classLeveled.getForbiddenSkills();		
	}
	
	@Override
	public ArrayList<D20Alignment> getForbiddenAlignments() { 
		return classLeveled.getForbiddenAlignments();
	}

	@Override
	public String getUniqueID() {
		return classLeveled.getUniqueID() + "||" + hashCode(); 
	}
}
