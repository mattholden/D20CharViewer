package com.darkenedsky.gemini.common.modifier;

import java.util.ArrayList;

import org.jdom.Element;

import com.darkenedsky.gemini.common.RuleObject;
import com.darkenedsky.gemini.common.XMLSerializable;
import com.darkenedsky.gemini.common.XMLTools;
import com.darkenedsky.gemini.common.prereq.HasPrerequisites;
import com.darkenedsky.gemini.common.prereq.Prerequisite;
import com.darkenedsky.gemini.d20system.D20Character;

public class Bonus implements HasPrerequisites, XMLSerializable {

	private RuleObject source;
	private Modifier modifier;
	private String conditional;
	
	private ArrayList<Prerequisite> prerequisites;
	
	@Override
	public void addPrerequisite(Prerequisite pre) { 
		if (prerequisites == null) { 
			prerequisites = new ArrayList<Prerequisite>();
		}
		prerequisites.add(pre);
	}
	
	@Override
	public boolean hasPrerequisites(D20Character d20) { 
		if (prerequisites == null) return true;
		for (Prerequisite p : prerequisites) { 
			if (!p.satisfies(d20)) return false;
		}
		return true;
	}
	
	public Bonus(RuleObject source, Modifier modifier, String conditional) {
		super();
		this.source = source;
		this.modifier = modifier;
		this.conditional = conditional;
	}

	public int modify(D20Character character, int value) {
		if (!hasPrerequisites(character)) 
			return value;
		return modifier.modify(value);
	}

	public RuleObject getSource() {
		return source;
	}

 
	public String getConditional() {
		return conditional;
	}


	public boolean isConditional() { 
		return conditional != null;
	}
	
	public Element toXML(String root) { 
		Element e= new Element(root);
		e.addContent(XMLTools.xml("class", getClass().getName()));
		e.addContent(XMLTools.xml("conditional", conditional));
		e.addContent(XMLTools.xml("source", source.getUniqueID()));
		e.addContent(modifier.toXML("modifier"));
		for (Prerequisite p : prerequisites) { 
			e.addContent(p.toXML("prerequisite"));
		}
		return e;
	}
	
	public Bonus(Element e) {
		conditional = e.getChildText("conditional");
		
	}
}
