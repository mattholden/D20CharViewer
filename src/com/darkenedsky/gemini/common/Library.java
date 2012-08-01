package com.darkenedsky.gemini.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7355704229580479818L;

	// Constants for stuff we're going to use a lot
	public static final String
		RACES = "races",
		CLASSES = "classes",
		SPELLS = "spells",
		ABILITIES = "abilities",
		SKILLS = "skills",
		SPELL_CATEGORIES = "spellcategories";
		
	public Library() { 
		instance = this;
		addSection(RACES);
		addSection(CLASSES);
		addSection(SPELLS);
		addSection(SKILLS);
		addSection(ABILITIES);
		addSection(SPELL_CATEGORIES);
	}
	
	public static Library instance;
	
	private HashMap<String, RuleObject> byUnique = new HashMap<String, RuleObject>();
	
	public void refreshUniqueMap() { 
		byUnique.clear();
		compileUniqueMap();
	}
	
	private void compileUniqueMap() { 
		if (byUnique.size() != 0) return;
		
		for (LibrarySection section : sections.values()) { 
			for (RuleObject ro : section.getAll()) { 
				byUnique.put(ro.getUniqueID(), ro);
			}
		}
	}
	
	public RuleObject getByID(String id) { 
		compileUniqueMap();
		return byUnique.get(id);
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


