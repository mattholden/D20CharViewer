package com.darkenedsky.d20charviewer.d20objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class D20Library {

	private static D20Library instance = new D20Library();
	public static D20Library getLibrary() { return instance; }
	
	public Map<String, D20Class> classes = new HashMap<String, D20Class>(40);
	public Map<String, D20Skill> skills = new HashMap<String, D20Skill>(40);
	public Map<String, D20Feat> feats = new HashMap<String, D20Feat>(40);
	public Map<String, D20Race> races = new HashMap<String, D20Race>(40);
	
	public List<D20Class> getClasses() { 
		ArrayList<D20Class> set = new ArrayList<D20Class>(classes.size());
		set.addAll(classes.values());
		Collections.sort(set);
		return set;
	}
	public List<D20Race> getRaces() { 
		ArrayList<D20Race> set = new ArrayList<D20Race>(races.size());
		set.addAll(races.values());
		Collections.sort(set);
		return set;
	}
	public List<D20Skill> getSkills() { 
		ArrayList<D20Skill> set = new ArrayList<D20Skill>(skills.size());
		set.addAll(skills.values());
		Collections.sort(set);
		return set;
	}
	public List<D20Feat> getFeats() { 
		ArrayList<D20Feat> set = new ArrayList<D20Feat>(feats.size());
		set.addAll(feats.values());
		Collections.sort(set);
		return set;
	}
	
	public void loadRaces(D20Race[] racez) { 
		for (D20Race r : racez)
			if (r != null)
				races.put(r.getName(), r);
	}
	public void loadClasses(D20Class[] classez) { 
		for (D20Class c : classez)
			if (c != null)
				classes.put(c.getName(), c);
	}
	public void loadSkills(D20Skill[] classez) { 
		for (D20Skill c : classez)
			if (c != null)
				skills.put(c.getName(), c);
	}
	public void loadFeats(D20Feat[] classez) { 
		for (D20Feat c : classez)
			if (c != null)
				feats.put(c.getName(), c);
	}
	
	public D20Class lookupClass(String name) { 
		return classes.get(name);
	}
	public D20Race lookupRace(String name) { 
		return races.get(name);
	}
	public D20Skill lookupSkill(String name) { 
		return skills.get(name);
	}
	public D20Feat lookupFeat(String name) { 
		return feats.get(name);
	}
	
	
	
}
