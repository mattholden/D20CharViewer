package com.darkenedsky.gemini.common;

public class Progression {

	private Integer[] progression = new Integer[31];
	
	public Progression(Integer... progress) {
		int j = 1;
		progression[0] = 0;
		for (int i : progress) { 
			if (j > 30) break;
			progression[j] = i;
			j++;
		}
		for (; j < 30; j++) {
			progression[j] = progress[progress.length-1];
		}
	}
	
	public Integer getProgression(int level) { 
		if (level < 0 || level > 30) return null;
		return progression[level];
	}
	
	public static final Progression	ZERO = new Progression(0);
		
		
}
