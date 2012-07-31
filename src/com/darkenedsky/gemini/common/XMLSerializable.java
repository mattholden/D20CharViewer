package com.darkenedsky.gemini.common;

import org.jdom.Element;

public interface XMLSerializable {

	public Element toXML(String root);
}
