package com.darkenedsky.gemini.common;

import java.io.Serializable;

import org.jdom.Element;

public class Specialized<T extends RuleObject> implements Serializable { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7196397511460453460L;
	public T ability;
	public String specialization;
	
	public Specialized(T f, String spec) { 
		ability = f;
		specialization = spec;
	}
	

	public boolean equals(Object another) { 
		if ((another instanceof Specialized<?>) == false)
			return false;
		
		Specialized<?> other = (Specialized<?>)another;
		boolean specCheck = false;
		if (specialization != null)
			specCheck = specialization.equalsIgnoreCase(other.specialization);
		else
			specCheck = (other.specialization == null);
				
		return (ability.equals(other.ability) && specCheck); 
	}
	
	public Element toXML(String root, Frequency freq) { 
		Element e = new Element(root);
		e.addContent(XMLTools.xml("ability", ability.getUniqueID()));
		
		if (specialization != null) { 
			Element sp = new Element("specialization");
			sp.setText(specialization);
			e.addContent(sp);
		}
		
		e.addContent(freq.toXML("frequency"));
		return e;
	}
	
	public Element toXML(String root, Integer ranks) { 
		Element e = new Element(root);
		e.addContent(XMLTools.xml("ability", ability.getUniqueID()));
		
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
		e.addContent(XMLTools.xml("ability", ability.getUniqueID()));
		
		if (specialization != null) { 
			Element sp = new Element("specialization");
			sp.setText(specialization);
			e.addContent(sp);
		}
		
		e.addContent(XMLTools.xml("ranks", NumberTools.trimFloat(ranks, 1,1,true)));
		return e;
	}
	
}
