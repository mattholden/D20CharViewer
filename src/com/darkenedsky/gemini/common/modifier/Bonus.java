package com.darkenedsky.gemini.common.modifier;

import java.util.ArrayList;

import com.darkenedsky.gemini.common.RuleObject;
import com.darkenedsky.gemini.common.prereq.HasPrerequisites;
import com.darkenedsky.gemini.common.prereq.Prerequisite;
import com.darkenedsky.gemini.d20system.D20Character;

public class Bonus implements HasPrerequisites {

	private RuleObject source;
	private Modifier modifier;
	private String conditional;
	
	private ArrayList<Prerequisite> prerequisites;
	
	@Override
	public void addPrerequisite(Prerequisite pre) { 
		if (prerequisites == null) { 
			prerequisites = new ArrayList<Prerequisite>();
		}
		prerequisites.add(pre);
	}
	
	@Override
	public boolean hasPrerequisites(D20Character d20) { 
		if (prerequisites == null) return true;
		for (Prerequisite p : prerequisites) { 
			if (!p.satisfies(d20)) return false;
		}
		return true;
	}
	
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
