package com.darkenedsky.gemini.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySection implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2501811380943848238L;
	private Map<String, RuleObject> objects = new HashMap<String, RuleObject>();
	
	public List<RuleObject> getAll() { 
		ArrayList<RuleObject> list = new ArrayList<RuleObject>();
		for (RuleObject thing : objects.values()) { 
			if (thing != null)
				list.add(thing);
		}
		Collections.sort(list);
		return list;
	}

	public LibrarySection() { 
		
	}
	
	public void add(RuleObject[] objs) { 
		for (RuleObject thing : objs)
			objects.put(thing.getName(), thing);
	}
	
	public LibrarySection(RuleObject[] stuff) { 
		for (RuleObject thing : stuff) { 
			if (thing != null)
				objects.put(thing.getName(), thing);
		}
	}
	
	public RuleObject get(String name) { 
		return objects.get(name);
	}
	
	public void merge(LibrarySection other) { 
		objects.putAll(other.objects);
	}
	
	public void add(RuleObject o) { 
		objects.put(o.getName(), o);
	}
	
}
