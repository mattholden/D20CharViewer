package com.darkenedsky.gemini.common;

import java.util.ArrayList;
import java.util.List;

import com.darkenedsky.gemini.common.modifier.Bonus;

public class Roll {

	private List<Bonus> bonusesApplied = new ArrayList<Bonus>();
	private List<Bonus> bonusesPotential = new ArrayList<Bonus>();
	
	private int diceRoll = 0;
	private int totalRoll = 0;
	private int baseValue = 0;
	
	public Roll(int baseValue, Dice toRoll, List<Bonus> bonuses) { 
		diceRoll = toRoll.roll();
		totalRoll =  diceRoll + baseValue;		
		this.baseValue = baseValue;
		
		for (Bonus b : bonuses) { 
			if (b.isConditional())
				bonusesPotential.add(b);
			else { 
				totalRoll = b.getModifier().modify(totalRoll);
				bonusesApplied.add(b);
			}
		}
	}

	public int check(int target) { 
		return totalRoll - target;
	}
	
	public List<Bonus> getBonusesApplied() {
		return bonusesApplied;
	}

	public List<Bonus> getBonusesPotential() {
		return bonusesPotential;
	}

	public int getValueRolled() {
		return diceRoll;
	}

	public int getTotal() {
		return totalRoll;
	}
	
	public int getBaseValue() { 
		return baseValue;
	}
	
	public int activateBonus(Bonus b) { 
		if (bonusesPotential.contains(b)) {
			bonusesPotential.remove(b);
			bonusesApplied.add(b);
			totalRoll = recalculateBonuses();
		}
		return totalRoll;		
	}
	public int deactivateBonus(Bonus b) { 
		if (bonusesApplied.contains(b)) {
			bonusesPotential.add(b);
			bonusesApplied.remove(b);
			totalRoll = recalculateBonuses();
		}
		return totalRoll;		
	}
	
	private int recalculateBonuses() { 
		int modified = baseValue + diceRoll;
		for (Bonus b: bonusesApplied)
			modified = b.getModifier().modify(modified);
		return modified;
	}
}
