package com.darkenedsky.gemini.common;

import java.util.HashMap;
import java.util.Map;

public class Library {

	// Constants for stuff we're going to use a lot
	public static final String
		RACES = "races",
		CLASSES = "classes",
		SPELLS = "spells",
		ABILITIES = "abilities",
		SKILLS = "skills",
		SPELL_CATEGORIES = "spellcategories";
		
	public Library() { 
		addSection(RACES);
		addSection(CLASSES);
		addSection(SPELLS);
		addSection(ABILITIES);
		addSection(SPELL_CATEGORIES);
	}
	
	private HashMap<String, LibrarySection> sections = 
		new HashMap<String, LibrarySection>();
	
	public LibrarySection getSection(String name) { 
		return sections.get(name);
	}

	public LibrarySection addSection(String name) { 
		return sections.put(name, new LibrarySection());
	}
	
	public LibrarySection addSection(String name, RuleObject[] stuff) {
		return sections.put(name, new LibrarySection(stuff));
	}
	
	public void merge(Library other) { 
		for (Map.Entry<String, LibrarySection> e : other.sections.entrySet()) {
			
			LibrarySection mine = sections.get(e.getKey());
			if (mine == null) { 
				sections.put(e.getKey(), e.getValue());
			}
			else { 
				mine.merge(e.getValue());
			}
		}
	}
}


