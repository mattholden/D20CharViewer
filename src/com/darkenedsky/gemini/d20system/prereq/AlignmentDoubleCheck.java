package com.darkenedsky.gemini.d20system.prereq;
import org.jdom.Element;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.XMLTools;
import com.darkenedsky.gemini.common.prereq.Prerequisite;
import com.darkenedsky.gemini.d20system.D20Alignment;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20ClassLevel;

public class AlignmentDoubleCheck implements Prerequisite {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2721547391230270783L;
	private D20Alignment align;
	
	public AlignmentDoubleCheck(D20Alignment a) {
		align = a;
	}
	
	
	public AlignmentDoubleCheck(Element e) { 
		align = (D20Alignment)Library.instance.getByID(XMLTools.getString(e, "alignment"));
	}
	
	
	@Override
	public Element toXML(String root) {
		Element e = new Element(root);
		e.addContent(XMLTools.xml("class", getClass().getName()));
		e.addContent(XMLTools.xml("alignment", align.getUniqueID()));
		return e;
	}

	@Override
	public boolean satisfies(GameCharacter character) {
		D20Character c = (D20Character)character;
		
		if (!c.getRace().getDeniedAlignments().contains(align))
			return false;
		
		for (D20ClassLevel level : c.getLevelList()) { 
			if (level.getDeniedAlignments().contains(align)) 
				return false;
		}
		return true;
	} 
		
	
}
