package com.darkenedsky.gemini.common.event;

import java.util.ArrayList;

import com.darkenedsky.gemini.common.RuleObject;
import com.darkenedsky.gemini.common.Specialized;

public class ChooseObjectEvent extends CharacterGeneratorEvent {
	
	private ArrayList<Specialized<RuleObject>> choices = new ArrayList<Specialized<RuleObject>>();
	
	private int qtyToPick = 1;	
	public void setQtyToPick(int q) { qtyToPick = q; }
	public int getQtyToPick() { return qtyToPick; }
	
	public void addChoice(RuleObject ro) { addChoice(ro,null); }
	public void addChoice(RuleObject ro,String spec) { choices.add(new Specialized<RuleObject>(ro,spec)); }
	
	private String instructions;
	
	public ArrayList<Specialized<RuleObject>> getChoices() { 
		return choices;
	}
	
	public ChooseObjectEvent(String code, String instruct) { 
		super(code);
		instructions = instruct;
	}
	public String getInstructions() { return instructions; }
	

	
}
