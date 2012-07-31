package com.darkenedsky.gemini.d20fantasy.races;
import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Race;

public class Elf extends D20Race implements D20Fantasy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6218602741820598760L;

	public Elf() {
		super("Elf", "http://www.d20srd.org/srd/races.htm#elves");
		this.favoredClass = D20SRD.Classes.WIZARD;
		mods[DEX] = 2;
		mods[CON] = -2;
		baseSpeed = 30;
		bonusLanguages.add("Draconic");
		bonusLanguages.add("Gnoll");
		bonusLanguages.add("Gnome");
		bonusLanguages.add("Goblin");
		bonusLanguages.add("Orc");
		bonusLanguages.add("Sylvan");
		
		ageRanges= new int[] {55,110,175,263,350};
		maxAge = new Dice(4,100);
		baseHeightM = ht(4,5);
		modHeightM = new Dice(2,6);
		baseWeightM = 85;
		modWeightM = new Dice(1,6);
		baseHeightF = ht(4,5);
		modHeightF = new Dice(2,6);
		baseWeightF = 80;
		modWeightF = new Dice(1,6);
		this.ageModsByClass = new Dice[] {
			new Dice(4,6), new Dice(6,6), new Dice(10,6)
		};
		
	}

	@Override
	public void onGain(GameCharacter chara) { 
		D20Character character = (D20Character)chara;
		super.onGain(character);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Elven", false, true);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Common", false, true);
		character.addAbility(D20SRD.Abilities.ELF_BLOOD, null);
		character.addAbility(D20SRD.Abilities.LOWLIGHTVISION, null);
		character.addBonus(ALL_SAVES, this, IMMUNITY, "sleep spells or effects");
		character.addBonus(ALL_SAVES, this, new Plus(2), "enchantment spells or effects");
		character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "longsword", true);
		character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "rapier", true);
		character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "longbow", true);
		character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "composite longbow", true);
		character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "shortbow", true);
		character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "composite shortbow", true);			
		character.getSkill(D20SRD.Skills.LISTEN).addBonus(this, new Plus(2), null);
		character.getSkill(D20SRD.Skills.SEARCH).addBonus(this, new Plus(2), null);
		character.getSkill(D20SRD.Skills.SPOT).addBonus(this, new Plus(2), null);
	
	
	}
	
	

}