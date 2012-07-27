package com.darkenedsky.d20charviewer.common;

public class Progression {

	private int[] progression = new int[31];
	
	public Progression(int... progress) {
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
	
	public int getProgression(int level) { 
		if (level < 0 || level > 30) return -1;
		return progression[level];
	}
	
	public static final Progression
		SAVE_BONUS_LOW = new Progression(0,0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6),
		SAVE_BONUS_HIGH = new Progression(2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12),
		FIGHTER_BAB = new Progression(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20),
		CLERIC_BAB = new Progression(0,1,2,3,3,4,5,6,6,7,8,9,9,10,11,12,12,13,14,15),
		WIZARD_BAB = new Progression(0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10),
		ZERO = new Progression(0);
		
		
}
