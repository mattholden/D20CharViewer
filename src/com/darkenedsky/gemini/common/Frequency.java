package com.darkenedsky.gemini.common;

import org.jdom.Element;

public class Frequency {

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
		@Override
		public String toString() { 
			return "(at will)";
		}
	};
	
	public static final Frequency MODIFIER = new Frequency(0, TimeUnit.SECOND) { 
		@Override
		public String toString() { 
			return "(ability modifier)";
		}
	};
	
	public Element toXML() { 
		Element e= new Element("frequency");
		e.addContent(XMLTools.xml("uses", uses));
		e.addContent(XMLTools.xml("unit", unit.toString()));
		return e;
	}
	
	public static Frequency load(Element e) { 
		String u = e.getChild("unit").getText();
		String times = e.getChild("uses").getText();
		int x = Integer.parseInt(times);
				
		if (u.equals("second"))
			return new Frequency(x, TimeUnit.SECOND);
		else if (u.equals("minute"))
			return new Frequency(x, TimeUnit.MINUTE);
		else if (u.equals("hour"))
			return new Frequency(x, TimeUnit.HOUR);
		else if (u.equals("day"))
			return new Frequency(x, TimeUnit.DAY);
		else if (u.equals("week"))
			return new Frequency(x, TimeUnit.WEEK);
		else if (u.equals("month"))
			return new Frequency(x, TimeUnit.MONTH);
		else if (u.equals("year"))
			return new Frequency(x, TimeUnit.YEAR);
		else if (u.equals("at will"))
			return Frequency.AT_WILL;
		else 
			return null;
		
	}
	
}
