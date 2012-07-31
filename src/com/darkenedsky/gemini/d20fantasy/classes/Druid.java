package com.darkenedsky.gemini.d20fantasy.classes;
import com.darkenedsky.gemini.common.prereq.TransientPrerequisite;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Alignment;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20SpellcasterClass;

public class Druid extends D20Class implements D20SpellcasterClass, D20Fantasy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3770457620699209564L;

	public Druid() {
		super("Druid","");
		//old
		
		addPrerequisite(neutral);
	}


	// druids must have some kind of neutral
	private TransientPrerequisite neutral = new TransientPrerequisite() { 
	
		@Override
		public boolean satisfies(D20Character character) { 
			D20Alignment a = character.getAlignment();
			return (a.getLawAxis().equals(D20Alignment.NEUTRAL) || 
					a.getMoralityAxis().equals(D20Alignment.NEUTRAL));
		}
	};
	
	@Override
	public void onGain(D20Character character) { 		
		super.onGain(character);
		
		// it's already been added to the object, so this should never be below 1
		Integer classLevel = character.getLevelOfClass(getClass());		
		switch (classLevel) { 
		case 1: { 
				character.addFeat(D20SRD.Feats.SIMPLE_WEAPON_PROFICIENCY, "*", true);
				character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "*", true);
				character.addFeat(D20SRD.Feats.LIGHT_ARMOR_PROFICIENCY, "*", true);
				character.addFeat(D20SRD.Feats.MEDIUM_ARMOR_PROFICIENCY, "*", true);
				character.addFeat(D20SRD.Feats.SHIELD_PROFICIENCY, null, true);
				break;
			}
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:	
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			break;
		case 16:
			break;
		case 17:
			break;
		case 18:
			break;
		case 19:
			break;
		case 20:
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
