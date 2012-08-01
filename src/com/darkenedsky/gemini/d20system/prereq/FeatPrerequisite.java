package com.darkenedsky.gemini.d20system.prereq;

import org.jdom.Element;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.XMLTools;
import com.darkenedsky.gemini.common.prereq.Prerequisite;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;

public class FeatPrerequisite implements Prerequisite {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4679813522050434883L;
	private D20Feat feat;
	private String special;
	private int timesTaken = 1;
	
	public FeatPrerequisite(D20Feat feet, String specialize) { 
		this(feet, specialize, 1);
	}
	
	public FeatPrerequisite(D20Feat feet) { 
		this(feet, null, 1);
	}
	
	public FeatPrerequisite(D20Feat feet, String specialize, int times) {	
		feat = feet;
		special = specialize;
		timesTaken = times;
	}
	
	public FeatPrerequisite(Element e) { 
		special = XMLTools.getString(e,"specialization");
		timesTaken = XMLTools.getInt(e, "timesTaken");
		feat = (D20Feat)Library.instance.getByID(XMLTools.getString(e, "feat"));
	}
	
	@Override
	public Element toXML(String root) { 
		Element e = new Element(root);		
		e.addContent(XMLTools.xml("class", getClass().getName()));
		e.addContent(XMLTools.xml("feat", feat.getUniqueID()));
		e.addContent(XMLTools.xml("specialization", special));
		e.addContent(XMLTools.xml("timesTaken", timesTaken));
		return e;
	}
	
	public boolean satisfies(GameCharacter charactr) {
		D20Character character = (D20Character)charactr;
		return character.getFeatRanks(feat, special) >= timesTaken;
	}

}
