package com.darkenedsky.gemini.d20system;

import com.darkenedsky.gemini.common.Statistic;

public class SkillRank extends Statistic { 
	
	private boolean hasHalfRank;
	
	public void addHalfRank() { 
		if (!hasHalfRank)
			hasHalfRank = true;
		else { 
			hasHalfRank = false;
			baseValue++;
		}
	}
		 
}
