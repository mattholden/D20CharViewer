package com.darkenedsky.gemini.common;

public abstract class RuleObject implements java.io.Serializable, HasUID, Comparable<RuleObject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1298599492403350149L;
	
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() { 
		return name;		
	}
	
	public boolean equals(Object other) { 
		if (other instanceof RuleObject)
			return (((RuleObject) other).getUniqueID().equals(getUniqueID()));
		else return false;
	}
	
	public RuleObject(String name) {
		super();
		this.name = name;
	}
	
	
	@Override
	public String getUniqueID() { 
		return getClass().getName() + "&" + getName();
	}
	
	public int compareTo(RuleObject other) { 
		return getUniqueID().compareToIgnoreCase(other.getUniqueID());
	}
}
