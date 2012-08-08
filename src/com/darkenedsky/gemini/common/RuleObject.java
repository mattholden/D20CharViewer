package com.darkenedsky.gemini.common;
import java.util.ArrayList;
import com.darkenedsky.gemini.common.prereq.HasPrerequisites;
import com.darkenedsky.gemini.common.prereq.Prerequisite;

public abstract class RuleObject implements java.io.Serializable, HasPrerequisites, HasUID, Comparable<RuleObject> {

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
			return (((RuleObject) other).getUniqueID().equals(getUniqueID()));
		else return false;
	}
	
	public RuleObject(String name, String sRDURL) {
		super();
		this.name = name;
		this.sRDURL = sRDURL;
	}
	
	public void onGain(GameCharacter character) {		
	}
	
	private ArrayList<Prerequisite> prerequisites;
	
	@Override
	public final void addPrerequisite(Prerequisite pre) { 
		if (prerequisites == null)
			prerequisites = new ArrayList<Prerequisite>();
		prerequisites.add(pre);
	}
	
	@Override
	public final boolean hasPrerequisites(GameCharacter character) {
		if (prerequisites == null) return true;
		for (Prerequisite req : prerequisites) { 
			if (!req.satisfies(character)) return false;
		}
		return true;
	}
	
	@Override
	public String getUniqueID() { 
		return getClass().getName() + "&" + getName();
	}
	
	public int compareTo(RuleObject other) { 
		return name.compareToIgnoreCase(other.name);
	}
}
