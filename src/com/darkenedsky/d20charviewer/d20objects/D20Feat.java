package com.darkenedsky.d20charviewer.d20objects;

import com.darkenedsky.d20charviewer.common.RuleObject;



public class D20Feat extends RuleObject implements D20Stats {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6048690368418290937L;
	
	protected boolean fighterBonusFeat = false;	
	protected boolean stacks = false;	
	protected int type = FEAT_GENERAL;
	
	public D20Feat(String name, String sRDURL) {
		super(name, sRDURL);
	}

	public int getType() {
		return type;
	}

	public boolean isStacks() {
		return stacks;
	}
	
	public boolean isFighterBonusFeat() { 
		return fighterBonusFeat;
	}
	
}
