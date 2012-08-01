package com.darkenedsky.gemini.common.modifier;

import java.io.Serializable;

import org.jdom.Element;

import com.darkenedsky.gemini.common.XMLSerializable;
import com.darkenedsky.gemini.common.XMLTools;


public abstract class Modifier implements Serializable, XMLSerializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5256111165566238072L;
	protected int amount;
	
	public abstract int modify(int value);

	public Modifier(int amt) { 
		this.amount = amt;
	}

	@Override
	public Element toXML(String string) {
		Element e = new Element(string);
		e.addContent(XMLTools.xml("amount", amount));
		e.addContent(XMLTools.xml("class", getClass().getName()));
		return e;
	}
	
	public Modifier(Element e) { 
		amount = XMLTools.getInt(e,"amount");
	}
	
}




