package com.darkenedsky.gemini.d20system;

import com.darkenedsky.gemini.common.Gainable;
import com.darkenedsky.gemini.common.RuleObject;
import com.darkenedsky.gemini.common.prereq.HasPrerequisites;

public class D20Object extends RuleObject implements D20, Gainable<D20Character>, HasPrerequisites<D20Character> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4513533158741533890L;

	public D20Object(String name, String srdURL) {
		super(name);
		this.srdURL = srdURL;
	} 
	
	private String srdURL;
	
	public String getURL() {
		return srdURL;
	}
	public void setURL(String sRDURL) {
		this.srdURL = sRDURL;
	}
	
	@Override
	public boolean hasPrerequisites(D20Character character) {
		return true;
	}
	
	@Override
	public void onGain(D20Character character) {		
	}
	

}
