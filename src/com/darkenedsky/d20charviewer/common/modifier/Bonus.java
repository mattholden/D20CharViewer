package com.darkenedsky.d20charviewer.common.modifier;

import com.darkenedsky.d20charviewer.common.RuleObject;

public class Bonus {

	private RuleObject source;
	private Modifier modifier;
	private String conditional;
	
	
	public Bonus(RuleObject source, Modifier modifier, String conditional) {
		super();
		this.source = source;
		this.modifier = modifier;
		this.conditional = conditional;
	}


	public RuleObject getSource() {
		return source;
	}


	public Modifier getModifier() {
		return modifier;
	}


	public String getConditional() {
		return conditional;
	}


	public boolean isConditional() { 
		return conditional != null;
	}
}
