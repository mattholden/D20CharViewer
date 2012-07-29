package com.darkenedsky.gemini.d20system;

import com.darkenedsky.gemini.common.RuleObject;



public class D20Feat extends RuleObject implements D20 {

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
