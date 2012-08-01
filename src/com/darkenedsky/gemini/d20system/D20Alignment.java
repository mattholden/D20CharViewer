package com.darkenedsky.gemini.d20system;

import com.darkenedsky.gemini.common.RuleObject;


public class D20Alignment extends RuleObject implements D20 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3998902722018534294L;

	public String lawAxis, moralityAxis;
	
	private D20Alignment(String law, String morality, String srdUrl) { 
		super((law.equals(NEUTRAL) && morality.equals(NEUTRAL)) ? "True Neutral" : 
			(law + " " + morality), srdUrl);
		
		lawAxis = law;
		moralityAxis = morality;
	}

	public String getLawAxis() {
		return lawAxis;
	}

	public String getMoralityAxis() {
		return moralityAxis;
	}
	
	public static final String GOOD = "Good", NEUTRAL = "Neutral", EVIL = "Evil", CHAOTIC = "Chaotic", LAWFUL = "Lawful";
	
	public static final D20Alignment
		LAWFUL_GOOD = new D20Alignment(LAWFUL,GOOD,"http://www.d20srd.org/srd/description.htm#theNineAlignments"),
		LAWFUL_NEUTRAL = new D20Alignment(LAWFUL,NEUTRAL,"http://www.d20srd.org/srd/description.htm#theNineAlignments"),
		LAWFUL_EVIL = new D20Alignment(LAWFUL,EVIL,"http://www.d20srd.org/srd/description.htm#theNineAlignments"),
		NEUTRAL_GOOD = new D20Alignment(NEUTRAL,GOOD,"http://www.d20srd.org/srd/description.htm#theNineAlignments"),
		TRUE_NEUTRAL = new D20Alignment(NEUTRAL,NEUTRAL,"http://www.d20srd.org/srd/description.htm#theNineAlignments"),
		NEUTRAL_EVIL = new D20Alignment(NEUTRAL,EVIL,"http://www.d20srd.org/srd/description.htm#theNineAlignments"),
		CHAOTIC_GOOD = new D20Alignment(CHAOTIC,GOOD,"http://www.d20srd.org/srd/description.htm#theNineAlignments"),
		CHAOTIC_NEUTRAL = new D20Alignment(CHAOTIC,NEUTRAL,"http://www.d20srd.org/srd/description.htm#theNineAlignments"),
		CHAOTIC_EVIL = new D20Alignment(CHAOTIC,EVIL,"http://www.d20srd.org/srd/description.htm#theNineAlignments");
		
	public static final D20Alignment[] buildArray() { 
		return new D20Alignment[] {
				LAWFUL_GOOD, LAWFUL_NEUTRAL, LAWFUL_EVIL,
				NEUTRAL_GOOD, TRUE_NEUTRAL, NEUTRAL_EVIL,
				CHAOTIC_GOOD, CHAOTIC_NEUTRAL, CHAOTIC_EVIL
		};
	}
	
	public static final D20Alignment load(String text) {
		
		if (text.equals("Lawful Good")) return LAWFUL_GOOD;
		if (text.equals("Lawful Neutral")) return LAWFUL_NEUTRAL;
		if (text.equals("Lawful Evil")) return LAWFUL_EVIL; 
		if (text.equals("Neutral Good")) return NEUTRAL_GOOD;
		if (text.equals("True Neutral")) return TRUE_NEUTRAL;
		if (text.equals("Neutral Evil")) return NEUTRAL_EVIL;
		if (text.equals("Chaotic Good")) return CHAOTIC_GOOD;
		if (text.equals("Chaotic Neutral")) return CHAOTIC_NEUTRAL;
		if (text.equals("Chaotic Evil")) return CHAOTIC_EVIL;
		return null;
	}
	
}
