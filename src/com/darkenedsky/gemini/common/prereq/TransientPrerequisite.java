package com.darkenedsky.gemini.common.prereq;

import org.jdom.Element;

public abstract class TransientPrerequisite implements Prerequisite {

	/**
	 * 
	 */
	private static final long serialVersionUID = 750452699543738673L;

	public TransientPrerequisite() { }
	
	@Override
	public Element toXML(String root) {
		return new Element(root);
	}
	
}
