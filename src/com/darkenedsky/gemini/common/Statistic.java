package com.darkenedsky.gemini.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

import com.darkenedsky.gemini.common.modifier.Bonus;
import com.darkenedsky.gemini.common.modifier.Modifier;


public class Statistic implements Serializable, XMLSerializable { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1929381674148057599L;

	public Statistic() { } 
	
	public int getValueWithPermanentBonuses(GameCharacter c) { 
		int total = baseValue;
		for (Bonus b : getBonuses()) { 
			if (!b.isConditional())
				total = b.modify(c,total);
		}
		return total;
	}

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
	
	private List<Bonus> bonuses = new ArrayList<Bonus>();
	
	public void addBonus(RuleObject source, Modifier mod, String conditional) { 
		bonuses.add(new Bonus(source, mod, conditional));
	}
	public void addBonus(Bonus b) { 
		bonuses.add(b);
	}
	
	public void dropBonuses(RuleObject ro) { 
		for (Bonus b : getBonuses()) { 
			if (b.getSource().equals(ro)) { 
				bonuses.remove(b);
			}
		}
	}
	
	public List<Bonus> getBonuses() { 
		return bonuses;
	}
	
	public Statistic (Element e) throws Exception { 
		baseValue = XMLTools.getInt(e,"basevalue");
		diceCheck = new Dice(e.getChild("dicecheck"));
		
		List<?> modz = e.getChildren("bonus");
		for (int i = 0; i < modz.size(); i++) { 
			Element m = (Element)modz.get(i);
			bonuses.add((Bonus)XMLTools.dynamicLoad(m));
		}
	}
	
	
	@Override
	public Element toXML(String root) {
		Element e = new Element(root);
		e.addContent(XMLTools.xml("class", getClass().getName()));
		e.addContent(XMLTools.xml("basevalue", baseValue));
		e.addContent(diceCheck.toXML("dicecheck"));
		
		for (Bonus b : bonuses) { 
			e.addContent(b.toXML("bonus"));
		}
		
		return e;
	}
	 
}
