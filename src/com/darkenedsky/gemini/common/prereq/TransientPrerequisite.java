package com.darkenedsky.gemini.common.prereq;

import org.jdom.Element;

public abstract class TransientPrerequisite implements Prerequisite {

	public TransientPrerequisite() { }
	
	@Override
	public Element toXML(String root) {
		return new Element(root);
	}
	
}
