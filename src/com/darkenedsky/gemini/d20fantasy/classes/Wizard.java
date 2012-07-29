package com.darkenedsky.gemini.d20fantasy.classes;

import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20SpellCategory;
import com.darkenedsky.gemini.d20system.D20SpellcasterClass;

public class Wizard extends D20Class implements D20SpellcasterClass, D20Fantasy  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4966860919383285064L;
	
	protected D20SpellCategory specializedSchool = null;
	
	public Wizard() { 
		this(null);		
	}
	
	public Wizard(D20SpellCategory specialized) { 
		super("Wizard","");
		this.specializedSchool = specialized;
		
		 
	}
}
