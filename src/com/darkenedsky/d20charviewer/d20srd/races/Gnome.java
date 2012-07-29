package com.darkenedsky.d20charviewer.d20srd.races;

import com.darkenedsky.d20charviewer.common.Dice;
import com.darkenedsky.d20charviewer.common.Frequency;
import com.darkenedsky.d20charviewer.common.TimeUnit;
import com.darkenedsky.d20charviewer.common.modifier.Plus;
import com.darkenedsky.d20charviewer.d20objects.D20Character;
import com.darkenedsky.d20charviewer.d20objects.D20Race;
import com.darkenedsky.d20charviewer.d20objects.D20Size;
import com.darkenedsky.d20charviewer.d20srd.D20SRD;
import com.darkenedsky.d20charviewer.d20srd.abilities.SpellLikeAbility;

public class Gnome extends D20Race {

	/**
	 * 
	 */
	private static final long serialVersionUID = -488111960128437009L;

	public Gnome() {
		super("Gnome", "http://www.d20srd.org/srd/races.htm#gnomes");
		this.favoredClass = D20SRD.Classes.BARD;
		mods[CON] = 2;
		mods[STR] = -2;
		size = D20Size.SMALL;
		baseSpeed = 20;
		bonusLanguages.add("Draconic");
		bonusLanguages.add("Dwarven");
		bonusLanguages.add("Elven");
		bonusLanguages.add("Giant");
		bonusLanguages.add("Goblin");
		bonusLanguages.add("Orc");
		
		ageRanges= new int[] {20,40,100,150,200};
		maxAge = new Dice(3,100);
		baseHeightM = ht(3,0);
		modHeightM = new Dice(2,4);
		baseWeightM = 40;
		modWeightM = new Dice(1,1);
		baseHeightF = ht(2,10);
		modHeightF = new Dice(2,4);
		baseWeightF = 35;
		modWeightF = new Dice(1,1);
		this.ageModsByClass = new Dice[] {
			new Dice(4,6), new Dice(6,6), new Dice(9,6)
		};
	
	}

	@Override
	public void onGain(D20Character character) {		
		super.onGain(character);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Gnome", false, true);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Common", false, true);
		character.addAbility(D20SRD.Abilities.LOWLIGHTVISION, null);
		character.addSaveBonus(ALL, this, new Plus(2), "illusions");
		character.addSkillBonus(D20SRD.Skills.LISTEN, this, new Plus(2), null);
		character.addSkillBonus(D20SRD.Skills.CRAFT, this, new Plus(2), "alchemy");
		character.addAttackBonus(this, new Plus(1), "kobolds");
		character.addAttackBonus(this, new Plus(1), "goblins");
		character.addAttackBonus(this, new Plus(1), "bugbears");
		character.addAttackBonus(this, new Plus(1), "hobgoblins");
		character.addDodgeBonus(this, new Plus(4), "giants");
		character.addDodgeBonus(this, new Plus(4), "ogres");
		character.addDodgeBonus(this, new Plus(4), "trolls");
		
		// gnomes can treat gnome hooked hammers as martial weapons rather than exotic
		// this will be a special case in the onGain for martial weapon proficiency feat
		
		// +1 to illusion spell efficacy - not sure how to do this.
		
		
		// spell like abilities
		Frequency once = new Frequency(1,TimeUnit.DAY);
		character.addAbility(new SpellLikeAbility(D20SRD.Spells.SPEAK_WITH_ANIMALS), "burrowing mammal", 
				once);
		
		if (character.getAbilityScore(CHA) > 10) { 
			character.addAbility(new SpellLikeAbility(D20SRD.Spells.DANCING_LIGHTS), null, once);
			character.addAbility(new SpellLikeAbility(D20SRD.Spells.GHOST_SOUND), null, once);
			character.addAbility(new SpellLikeAbility(D20SRD.Spells.PRESTIDIGITATION), null, once);
				
		}
		
	
	}
	
	

}