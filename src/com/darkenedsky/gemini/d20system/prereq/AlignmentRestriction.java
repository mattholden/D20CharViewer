package com.darkenedsky.gemini.d20system.prereq;

import org.jdom.Element;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.XMLTools;
import com.darkenedsky.gemini.common.prereq.Prerequisite;
import com.darkenedsky.gemini.d20system.D20Character;

public class AlignmentRestriction implements Prerequisite {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2207330427467933486L;

	public AlignmentRestriction(RestrictsAlignment restrictor) { 
		this.restrictor = restrictor;
	}
	
	private RestrictsAlignment restrictor;
	
	public AlignmentRestriction(Element e) { 
		restrictor = (RestrictsAlignment)Library.instance.getByID(XMLTools.getString(e, "restrictor"));
	}
	
	@Override
	public Element toXML(String root) {
		Element e = new Element(root);
		e.addContent(XMLTools.xml("class", getClass().getName()));
		e.addContent(XMLTools.xml("restrictor", restrictor.getUniqueID()));
		return e;
	}

	@Override
	public boolean satisfies(GameCharacter character) {
		D20Character c = (D20Character)character;
		
		if (c.getAlignment() == null) return true;
		return !(restrictor.getForbiddenAlignments().contains(c.getAlignment()));
	} 
	
	

}
