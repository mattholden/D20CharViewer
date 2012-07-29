package com.darkenedsky.gemini.common;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.darkenedsky.gemini.common.modifier.Modifier;

public class Dice {
	
  /** Make a Random object to get random numbers from. 
    * We only need one...    */ 
	public static Random rand = new Random();
  
	private int dice, sides;
	private ArrayList<Modifier> modifiers = new ArrayList<Modifier>();
	
	public void addModifier(Modifier mod) { 
		modifiers.add(mod);		
	}
	
	public Dice(int die, int side) { 
		dice = die;
		sides = side;
	}
	public Dice(int die, int side, Modifier... mods) { 
		this(die, side);
		
		if (mods != null) { 
			for (Modifier m : mods)
				modifiers.add(m);
		}
	}

	private int modify(int value) { 
		int val = value;
		
		for (Modifier m : modifiers)
			val = m.modify(val);
		
		return val;
	}
	
	private void addToStringModifier(StringBuffer current, Modifier newMod) {
		String cur = current.toString();
		current.delete(0, current.length());
		current.append("(");
		current.append(cur);
		current.append(")");
		current.append(newMod.toString());
	}
	
	public String toString() { 
		
		StringBuffer buff = new StringBuffer();
		buff.append(dice);
		buff.append("d");
		buff.append(sides);
		
		// don't put parenthesis around the first modifier unless there are multiple.
		if (modifiers.size() >= 1)
			buff.append(modifiers.get(0).toString());
		for (int i = 1; i < modifiers.size(); i++)
			addToStringModifier(buff, modifiers.get(i));
		
		return buff.toString();
	}
	
	public int roll() { return roll(0,0); }
	
	public int getMinimum() { 
		return modify(dice);
	}
	public int getMaximum() { 
		return modify(dice*sides);
	}
	public String getRange() { 
		return "[" + getMinimum() + " - " + getMaximum() + "]";
	}
	
	public int roll(int dropThreshhold, int dropCount) { 
			
        int total = 0;
        int roll;
        
        // Only waste the memory if we're going to use it.
        ArrayList<Integer> rolls = null;
        if (dropCount != 0)
        	rolls = new ArrayList<Integer>(dice);
        
        for (int i =0; i < dice; i++)
        {
           // roll...
           roll = (rand.nextInt() % sides);           
           
           // Java's random number generator can give negatives...
           roll = 1 + ((roll < 0) ? (roll * -1) : (roll));
           
           // if we should drop this roll, do so
           if (roll <= dropThreshhold) {
        	   i--;
        	   continue;
           }
           
           // if we're going to drop some number of rolls, keep them in a list 
           // so we can sort them later
           if (dropCount != 0) {
        	   //System.out.print(roll + " ");
        	   rolls.add(roll);
           }
           else
        	   total += roll;
        }
        
        if (dropCount != 0) {
        	Collections.sort(rolls);
        	for (int i = rolls.size()-1; i >= dropCount; i--)
        		total += rolls.get(i);
        }
            
        return modify(total);
    }

	 public static boolean flipCoin() { 
		 
		 // for better randomness than rand(0,1)
		 long val = numberBetween(1, 100000);
		 return (val % 1 == 1);
	 }
	 
	 /** Pick a number between iLow and iHigh.
	 * @param iLow Minimum number to allow
	 * @param iHigh Maximum number to allow
	 * @return a random value between iLow and iHigh, inclusive.    
	 */ 
	 public static long numberBetween(long iLow, long iHigh)
	 {
	      long iRandom = rand.nextLong() % (iHigh - iLow + 1);
	      if (iRandom < 0) iRandom *= -1;
	      return iLow + iRandom;
	 }
	 
}
