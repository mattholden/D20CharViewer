package com.darkenedsky.gemini.common;

import java.util.ArrayList;
import java.util.List;
import com.darkenedsky.gemini.common.modifier.Bonus;


public abstract class Statistic {


	public int getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(int baseValue) {
		this.baseValue = baseValue;
	}

	public Dice getDiceCheck() {
		return diceCheck;
	}

	public void setDiceCheck(Dice diceCheck) {
		this.diceCheck = diceCheck;
	}

	protected int baseValue = 0;

	private Dice diceCheck = new Dice(1,20);
	
	protected List<Bonus> bonuses = new ArrayList<Bonus>();
	
	public void addBonus(Bonus b) { 
		bonuses.add(b);
	}
	
	public void removeBonusesFromSource(RuleObject ro) { 
		for (Bonus b : bonuses) { 
			if (b.getSource().equals(ro)) { 
				bonuses.remove(b);
			}
		}
	}
	
	public List<Bonus> getBonuses() { 
		return bonuses;
	}
	
	public Roll roll() { 
		return new Roll(baseValue, diceCheck, bonuses);
	}
	 
}
