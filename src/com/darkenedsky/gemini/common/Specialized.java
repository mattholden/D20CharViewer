package com.darkenedsky.gemini.common;

import java.io.Serializable;

import org.jdom.Element;

public class Specialized<T extends RuleObject> implements Serializable, XMLSerializable { 
	
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
	
	@SuppressWarnings("unchecked")
	public Specialized(Element e) { 
		ability = (T)Library.instance.getByID(XMLTools.getString(e,"ability"));
		specialization = XMLTools.getString(e, "specialization");
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
	
	@Override
	public Element toXML(String root) { 
		Element e = new Element(root);
		e.addContent(XMLTools.xml("ability", ability.getUniqueID()));
		
		if (specialization != null) { 
			Element sp = new Element("specialization");
			sp.setText(specialization);
			e.addContent(sp);
		}
		
		return e;
	}
		
}
