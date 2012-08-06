package com.darkenedsky.gemini.d20fantasy.skills;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Skill;

public class Knowledge extends D20Skill  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2236196393257199581L;

	public Knowledge() { 
		super("Knowledge", "", true, false, INT, false);
		   
			 
	}
	
	@Override
	public void buildSynergy() { 
		
		// knowledge has a ton of synergy		 
		   this.addSynergyBonus("arcana", D20SRD.Skills.SPELLCRAFT, null, 2,null);
		   this.addSynergyBonus("architecture", D20SRD.Skills.SEARCH, null, 2, "secret doors and compartments");
		   this.addSynergyBonus("engineering", D20SRD.Skills.SEARCH, null, 2, "secret doors and compartments");
		   this.addSynergyBonus("dungeoneering", D20SRD.Skills.SURVIVAL, null, 2, "underground");
		   this.addSynergyBonus("geography", D20SRD.Skills.SURVIVAL, null, 2, "Avoid hazards and getting lost");
		   
		   // this one might be an issue - it's not likely to be on the character sheet as Knowledge (local), 
		   // but knowledge (some area).
		   this.addSynergyBonus("local", D20SRD.Skills.GATHER_INFORMATION, null, 2, "When in the local area");
		   
		   this.addSynergyBonus("nature", D20SRD.Skills.SURVIVAL, null, 2, "above-ground natural environment");
		   this.addSynergyBonus("nobility", D20SRD.Skills.DIPLOMACY, null, 2, null);
		   this.addSynergyBonus("royalty", D20SRD.Skills.DIPLOMACY, null, 2, null);
		   this.addSynergyBonus("the planes", D20SRD.Skills.SURVIVAL, null, 2, "on other planes");
		   
		   // history = bardic knowledge (gotta do this as a bonus on that ability somehow)
		   // religion = turn undead
		
	}
}
