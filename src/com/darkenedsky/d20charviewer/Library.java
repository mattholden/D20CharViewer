package com.darkenedsky.d20charviewer;

import java.util.HashMap;
import java.util.Map;

import com.darkenedsky.d20charviewer.d20objects.D20Class;
import com.darkenedsky.d20charviewer.d20objects.D20Feat;
import com.darkenedsky.d20charviewer.d20objects.D20Race;
import com.darkenedsky.d20charviewer.d20objects.D20Skill;

public class Library {

	private static Library instance = new Library();
	public static Library getLibrary() { return instance; }
	
	public Map<String, D20Class> classes = new HashMap<String, D20Class>(40);
	public Map<String, D20Skill> skills = new HashMap<String, D20Skill>(40);
	public Map<String, D20Feat> feats = new HashMap<String, D20Feat>(40);
	public Map<String, D20Race> races = new HashMap<String, D20Race>(40);
	
	public void loadRaces(D20Race[] racez) { 
		for (D20Race r : racez)
			races.put(r.getName(), r);
	}
	public void loadClasses(D20Class[] classez) { 
		for (D20Class c : classez)
			classes.put(c.getName(), c);
	}
	public void loadSkills(D20Skill[] classez) { 
		for (D20Skill c : classez)
			skills.put(c.getName(), c);
	}
	public void loadFeats(D20Feat[] classez) { 
		for (D20Feat c : classez)
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
