package com.darkenedsky.d20charviewer.d20objects;

import com.darkenedsky.d20charviewer.common.RuleObject;



public class D20Feat extends RuleObject implements D20Stats {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6048690368418290937L;

	private boolean stacks = false;	
	private int type = FEAT_GENERAL;
	
	public D20Feat(String name, String sRDURL) {
		super(name, sRDURL);
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setStacks(boolean stacks) {
		this.stacks = stacks;
	}

	public boolean isStacks() {
		return stacks;
	}
}
