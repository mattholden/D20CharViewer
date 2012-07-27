package com.darkenedsky.d20charviewer.common;

import java.util.ArrayList;

import org.jdom.Element;

import com.darkenedsky.d20charviewer.common.prereq.Prerequisite;
import com.darkenedsky.d20charviewer.d20objects.D20Character;

public abstract class RuleObject implements java.io.Serializable, Comparable<RuleObject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1298599492403350149L;
	private String name;
	private String sRDURL;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSRD_URL() {
		return sRDURL;
	}
	public void setSRD_URL(String sRDURL) {
		this.sRDURL = sRDURL;
	}
	
	public String toString() { 
		return name;		
	}
	
	public boolean equals(Object other) { 
		if (other instanceof RuleObject)
			return ((RuleObject)other).sRDURL.equalsIgnoreCase(sRDURL);
		else return false;
	}
	public RuleObject(String name, String sRDURL) {
		super();
		this.name = name;
		this.sRDURL = sRDURL;
	}
	
	public void onGain(D20Character character) {		
	}
	
	private ArrayList<Prerequisite> prerequisites = new ArrayList<Prerequisite>();
	
	public final boolean hasPrerequisites(D20Character character) { 
		for (Prerequisite req : prerequisites) { 
			if (!req.satisfies(character)) return false;
		}
		return true;
	}
	
	public Element toXML(String root) { 
		Element e = new Element(root);
		e.setText(getName());
		return e;
	}
	
	public int compareTo(RuleObject other) { 
		return name.compareToIgnoreCase(other.name);
	}
}
