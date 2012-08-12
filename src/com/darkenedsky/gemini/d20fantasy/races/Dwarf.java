package com.darkenedsky.gemini.d20fantasy.races;
import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.modifier.Plus;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Race;

public class Dwarf extends D20Race implements D20Fantasy {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6484870265890256476L;

	public Dwarf() {
		super("Dwarf", "http://www.d20srd.org/srd/races.htm#dwarves");
		this.favoredClass = D20SRD.Classes.FIGHTER;
		mods[CON] = 2;
		mods[CHA] = -2;
		baseSpeed = 20;
		bonusLanguages.add("Giant");
		bonusLanguages.add("Gnome");
		bonusLanguages.add("Goblin");
		bonusLanguages.add("Orc");
		bonusLanguages.add("Terran");
		bonusLanguages.add("Undercommon");
		ageRanges= new int[] {20,40,125,188,250};
		baseHeightM = ht(3,9);
		modHeightM = new Dice(2,4);
		baseWeightM = 130;
		modWeightM = new Dice(2,6);
		baseHeightF = ht(3,7);
		modHeightF = new Dice(2,4);
		baseWeightF = 100;
		modWeightF = new Dice(2,6);
		this.ageModsByClass = new Dice[] {
			new Dice(3,6), new Dice(5,6), new Dice(7,6)
		};
		maxAge = new Dice(2,100);
	}

	@Override
	public void onGain(GameCharacter chara) { 
		D20Character character = (D20Character)chara;
		super.onGain(character);
		
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Dwarven", false, true);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Common", false, true);
		character.addAbility(D20SRD.Abilities.DWARF_BLOOD, null);
		character.addAbility(D20SRD.Abilities.DARKVISION, null);
		character.addAbility(D20SRD.Abilities.INTUIT_DEPTH, null);
		character.addAbility(D20SRD.Abilities.FULL_MOVE_SPEED_MEDIUM_LOAD, null);
		character.addAbility(D20SRD.Abilities.FULL_MOVE_SPEED_HEAVY_LOAD, null);
		character.addBonus(ALL_ABILITY_SCORES, this, new Plus(4), "resist bull rush when standing");
		character.addBonus(ALL_ABILITY_SCORES, this, new Plus(4), "resist trip when standing");		
		character.getSkill(D20SRD.Skills.SEARCH).addBonus(this, new Plus(2), "unusual stonework");
		character.getSkill(D20SRD.Skills.APPRAISE).addBonus(this, new Plus(2), "stone");
		character.getSkill(D20SRD.Skills.APPRAISE).addBonus(this, new Plus(2), "metal");
		character.getSkill(D20SRD.Skills.CRAFT).addBonus(this, new Plus(2), "stone");
		character.getSkill(D20SRD.Skills.CRAFT).addBonus(this, new Plus(2), "metal");
		character.addBonus(ALL_SAVES, this, new Plus(2), "poison");
		character.addBonus(ALL_SAVES, this, new Plus(2), "spells");
		character.addBonus(ALL_SAVES, this, new Plus(2), "spell-like effects");
		character.addBonus(ATTACK, this, new Plus(1), "orcs");
		character.addBonus(ATTACK, this, new Plus(1), "half-orcs");		
		character.addBonus(ATTACK, this, new Plus(1), "goblins");
		character.addBonus(ATTACK, this, new Plus(1), "bugbears");
		character.addBonus(ATTACK, this, new Plus(1), "hobgoblins");
		character.addBonus(DODGE, this, new Plus(4), "giants");
		character.addBonus(DODGE, this, new Plus(4), "ogres");
		character.addBonus(DODGE, this, new Plus(4), "trolls");
		character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "dwarven waraxe", true);
		character.addFeat(D20SRD.Feats.MARTIAL_WEAPON_PROFICIENCY, "dwarven urgrosh", true);
		
	}

}