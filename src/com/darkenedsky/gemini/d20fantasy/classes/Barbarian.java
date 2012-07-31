package com.darkenedsky.gemini.d20fantasy.classes;
import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.Frequency;
import com.darkenedsky.gemini.common.TimeUnit;
import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.common.modifier.Times;
import com.darkenedsky.gemini.common.prereq.TransientPrerequisite;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Alignment;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20Race;

public class Barbarian extends D20Class implements D20Fantasy {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3826764620082335808L;

	public Barbarian() { 
		super("Barbarian","http://www.d20srd.org/srd/classes/barbarian.htm");
		ageClass = (D20Race.AGE_MOD_YOUNG);
		hitDice = new Dice(1,12);
		skillPoints = 4;
		babProgression = BAB_HIGH;
		fortSaveProgression = SAVE_BONUS_HIGH;
		reflexSaveProgression = SAVE_BONUS_LOW;
		willSaveProgression = SAVE_BONUS_LOW;
		startingGold = new Dice(4,4);
		startingGold.addModifier(new Times(10));
		
		// gotta be weird, don't ya, barbarians?
		setIlliterate();
		
		// barbs can't be lawful
		TransientPrerequisite notLawful = new TransientPrerequisite() { 
		
			@Override
			public boolean satisfies(D20Character character) { 
				D20Alignment a = character.getAlignment();
				return !(a.getLawAxis().equals(D20Alignment.LAWFUL));
			}
		};
		addPrerequisite(notLawful);
	}
		
	@Override
	public void onGain(D20Character character) { 		
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelOfClass(getClass());
		Frequency once = new Frequency(1, TimeUnit.DAY);
		
		switch (classLevel) { 
		case 1: { 
				character.addFeat(D20SRD.Feats.SIMPLE_WEAPON_PROFICIENCY, "*", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "*", true);
				character.addFeat(D20SRD.Feats.LIGHT_ARMOR_PROFICIENCY, "*", true);
				character.addFeat(D20SRD.Feats.MEDIUM_ARMOR_PROFICIENCY, "*", true);
				character.addFeat(D20SRD.Feats.SHIELD_PROFICIENCY, null, true);
					
				character.addAbility(D20SRD.Abilities.FAST_MOVEMENT, null, Frequency.MODIFIER);
				character.addAbility(D20SRD.Abilities.RAGE, null, once);
				break;
			}
		case 2:
			if (character.getAbilityFrequency(D20SRD.Abilities.UNCANNY_DODGE, null) != null) {
				character.addAbility(D20SRD.Abilities.IMPROVED_UNCANNY_DODGE, null, Frequency.MODIFIER);								
			}
			else {
				character.addAbility(D20SRD.Abilities.UNCANNY_DODGE, null);
			}
			break;
		case 3:
			// trapsense
			character.getStat(DODGE).addBonus(this, new Plus(1), "traps");
			character.getStat(REFLEX).addBonus(this, new Plus(1), "traps");
			break;
		case 4:
			character.addAbility(D20SRD.Abilities.RAGE, null,once);
			
			break;
		case 5:	
			if (character.getAbilityFrequency(D20SRD.Abilities.IMPROVED_UNCANNY_DODGE, null) != null) {
				character.addAbility(D20SRD.Abilities.IMPROVED_UNCANNY_DODGE, null, Frequency.MODIFIER);								
			}
			break;
		case 6:
			// trapsense
			character.getStat(DODGE).addBonus(this, new Plus(1), "traps");
			character.getStat(REFLEX).addBonus(this, new Plus(1), "traps");
			break;
		case 7:
			character.getStat(DAMAGE_REDUCTION).addBonus(this, new Plus(-1), "weapons or natural attacks");
			break;
		case 8:
			character.addAbility(D20SRD.Abilities.RAGE, null,once);
			break;
		case 9:
			// trapsense
			character.getStat(DODGE).addBonus(this, new Plus(1), "traps");
			character.getStat(REFLEX).addBonus(this, new Plus(1), "traps");
			break;
		case 10:
			character.getStat(DAMAGE_REDUCTION).addBonus(this, new Plus(-1), "weapons or natural attacks");
			break;
		case 11:
			character.addAbility(D20SRD.Abilities.GREATER_RAGE, null, Frequency.MODIFIER);
			break;
		case 12:
			// trapsense
			character.getStat(DODGE).addBonus(this, new Plus(1), "traps");
			character.getStat(REFLEX).addBonus(this, new Plus(1), "traps");
			character.addAbility(D20SRD.Abilities.RAGE, null,once);
			break;
		case 13:
			character.getStat(DAMAGE_REDUCTION).addBonus(this, new Plus(-1), "weapons or natural attacks");
			break;
		case 14:
			character.addAbility(D20SRD.Abilities.INDOMITABLE_WILL, null, Frequency.MODIFIER);
			break;
		case 15:
			// trapsense
			character.getStat(DODGE).addBonus(this, new Plus(1), "traps");
			character.getStat(REFLEX).addBonus(this, new Plus(1), "traps");
			break;
		case 16:
			character.addAbility(D20SRD.Abilities.RAGE, null,once);
			character.getStat(DAMAGE_REDUCTION).addBonus(this, new Plus(-1), "weapons or natural attacks");
			
			break;
		case 17:
			character.addAbility(D20SRD.Abilities.TIRELESS_RAGE, null, Frequency.MODIFIER);
			break;
		case 18:
			// trapsense
			character.getStat(DODGE).addBonus(this, new Plus(1), "traps");
			character.getStat(REFLEX).addBonus(this, new Plus(1), "traps");
			break;
		case 19:
			character.getStat(DAMAGE_REDUCTION).addBonus(this, new Plus(-1), "weapons or natural attacks");
			break;
		case 20:
			character.addAbility(D20SRD.Abilities.MIGHTY_RAGE, null, Frequency.MODIFIER);
			character.addAbility(D20SRD.Abilities.RAGE, null,once);
			break;
		
		// TODO: Epic levels
		case 21: break;
		case 22: break;
		case 23: break;
		case 24: break;
		case 25: break;
		case 26: break;
		case 27: break;
		case 28: break;
		case 29: break;
		case 30: break;

		
		}
	}



}
