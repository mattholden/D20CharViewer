package com.darkenedsky.gemini.d20fantasy.races;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.Frequency;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.TimeUnit;
import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20fantasy.abilities.SpellLikeAbility;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Race;
import com.darkenedsky.gemini.d20system.D20Size;

public class Gnome extends D20Race implements D20Fantasy {

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
	public void onGain(GameCharacter chara) { 
		D20Character character = (D20Character)chara;
		super.onGain(character);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Gnome", false, true);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Common", false, true);
		character.addAbility(D20SRD.Abilities.LOWLIGHTVISION, null);
		character.addBonus(ALL_SAVES, this, new Plus(2), "illusions");
		character.getSkill(D20SRD.Skills.LISTEN).addBonus(this, new Plus(2), null);
		character.getSkill(D20SRD.Skills.CRAFT,"alchemy").addBonus(this, new Plus(2), null);
		character.addBonus(ATTACK, this, new Plus(1), "kobolds");
		character.addBonus(ATTACK, this, new Plus(1), "goblins");
		character.addBonus(ATTACK, this, new Plus(1), "bugbears");
		character.addBonus(ATTACK, this, new Plus(1), "hobgoblins");
		character.addBonus(DODGE, this, new Plus(4), "giants");
		character.addBonus(DODGE, this, new Plus(4), "ogres");
		character.addBonus(DODGE, this, new Plus(4), "trolls");
		character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "gnome hooked hammer", true);

		
		// TODO +1 to illusion spell efficacy - not sure how to do this.
		
		
		// spell like abilities
		Frequency once = new Frequency(1,TimeUnit.DAY);
		character.addAbility(new SpellLikeAbility(D20SRD.Spells.SPEAK_WITH_ANIMALS), "burrowing mammal", 
				once);
		
		if (character.getStat(CHA).getValueWithPermanentBonuses(character) > 10) { 
			character.addAbility(new SpellLikeAbility(D20SRD.Spells.DANCING_LIGHTS), null, once);
			character.addAbility(new SpellLikeAbility(D20SRD.Spells.GHOST_SOUND), null, once);
			character.addAbility(new SpellLikeAbility(D20SRD.Spells.PRESTIDIGITATION), null, once);
				
		}
		
	
	}
	
	

}