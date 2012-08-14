package com.darkenedsky.gemini.d20system;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class D20Spell extends D20Object {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2450456727301335219L;

	protected Map<D20SpellcasterClass, Integer> spellcasterLevels = new HashMap<D20SpellcasterClass, Integer>();
	protected List<D20SpellCategory> spellCategories = new ArrayList<D20SpellCategory>();
	
	public D20Spell(String name, String sRDURL) {
		super(name, sRDURL);
	}
	

}
