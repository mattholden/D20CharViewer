package com.darkenedsky.gemini.d20system.prereq;

import java.util.ArrayList;

import com.darkenedsky.gemini.d20system.D20Alignment;

public interface RestrictsAlignment {

	public ArrayList<D20Alignment> getForbiddenAlignments();
	
	public String getUniqueID();
}
