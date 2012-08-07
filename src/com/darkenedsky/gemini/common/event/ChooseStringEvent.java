package com.darkenedsky.gemini.common.event;

import java.util.ArrayList;

public class ChooseStringEvent extends CharacterGeneratorEvent {
	
	private ArrayList<String> choices = new ArrayList<String>();
	
	private boolean allowOther = true;
	public void setAllowOther(boolean allow) { allowOther = allow; }
	public boolean isAllowOther() { return allowOther; }
	
	public void addChoice(String c) { choices.add(c); }
	
	public ArrayList<String> getChoices() { 
		return choices;
	}
	
	public ChooseStringEvent(String code, String instruct) { 
		super(code);
		instructions = instruct;
	}

	private String instructions;
	public String getInstructions() { return instructions; }
	
	private int qtyToPick = 1;	
	public void setQtyToPick(int q) { qtyToPick = q; }
	public int getQtyToPick() { return qtyToPick; }
	
}
