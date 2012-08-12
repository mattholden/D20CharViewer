package com.darkenedsky.gemini.common;

import java.io.Serializable;

import org.jdom.Element;

public class Frequency implements Serializable, XMLSerializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8881193749718610871L;
	private TimeUnit unit;
	private int uses;
	
	public String toString() { 
		return "(" + uses + " times/" + unit + ")";
	}
	
	public Frequency(int use, TimeUnit tUnit) { 
		uses = use;
		unit = tUnit;
	}

	public TimeUnit getUnit() {
		return unit;
	}

	public void setUnit(TimeUnit unit) {
		this.unit = unit;
	}

	public int getUses() {
		return uses;
	}

	public void setUses(int uses) {
		this.uses = uses;
	}
	
	public static final Frequency AT_WILL = new Frequency(100, TimeUnit.SECOND) { 
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 4079001379853109926L;

		@Override
		public String toString() { 
			return "(at will)";
		}
	};
	
	public static final Frequency MODIFIER = new Frequency(0, TimeUnit.SECOND) { 
		/**
		 * 
		 */
		private static final long serialVersionUID = 1008021732211170498L;

		@Override
		public String toString() { 
			return "(ability modifier)";
		}
	};
	
	@Override
	public Element toXML(String root) { 
		Element e= new Element(root);
		e.addContent(XMLTools.xml("class", getClass().getName()));
		e.addContent(XMLTools.xml("uses", uses));
		e.addContent(XMLTools.xml("unit", unit.toString()));
		return e;
	}
	
	public Frequency(Element e) { 
		String u = e.getChild("unit").getText();
		String times = e.getChild("uses").getText();
		uses = Integer.parseInt(times);
		unit = TimeUnit.stringToUnit(u);
	}
	
}
