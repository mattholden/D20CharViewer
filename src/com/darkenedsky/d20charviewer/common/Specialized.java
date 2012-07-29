package com.darkenedsky.d20charviewer.common;

import org.jdom.Element;

public class Specialized<T extends RuleObject> { 
	
	public T ability;
	public String specialization;
	public Specialized(T f, String spec) { 
		ability = f;
		specialization = spec;
	}
	

	public Element toXML(String root, Frequency freq) { 
		Element e = new Element(root);
		e.addContent(ability.toXML("ability"));
		
		if (specialization != null) { 
			Element sp = new Element("specialization");
			sp.setText(specialization);
			e.addContent(sp);
		}
		
		e.addContent(freq.toXML());
		return e;
	}
	
	public Element toXML(String root, Integer ranks) { 
		Element e = new Element(root);
		e.addContent(ability.toXML("ability"));
		
		if (specialization != null) { 
			Element sp = new Element("specialization");
			sp.setText(specialization);
			e.addContent(sp);
		}
		
		e.addContent(XMLTools.xml("ranks", ranks));
		return e;
	}
	public Element toXML(String root, Float ranks) { 
		Element e = new Element(root);
		e.addContent(ability.toXML("ability"));
		
		if (specialization != null) { 
			Element sp = new Element("specialization");
			sp.setText(specialization);
			e.addContent(sp);
		}
		
		e.addContent(XMLTools.xml("ranks", NumberTools.trimFloat(ranks, 1,1,true)));
		return e;
	}
	
}
