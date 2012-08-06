package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

/** Used to buy literacy for the barbarian. Given free to everyone else. */
public class ReadingAndWriting extends D20Skill  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7566925076457223678L;

	public ReadingAndWriting() { 
		super(
				"Reading/Writing", 
				"http://www.d20srd.org/srd/skills/speakLanguage.htm", 
				false,		// specialized 
				false, 		// use untrained
				null, 		// key ability
				false);		// armor check penalty
			   	 
	}
}