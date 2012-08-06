package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20system.D20Skill;

public class SpeakLanguage extends D20Skill  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8602847581891380069L;

	public SpeakLanguage() { 
		super(
				"Speak Language", 
				"http://www.d20srd.org/srd/skills/speakLanguage.htm", 
				true,		// specialized 
				false, 		// use untrained
				null, 		// key ability
				false);		// armor check penalty
			   	 
	}
}