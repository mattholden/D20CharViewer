package com.darkenedsky.d20charviewer.d20srd.races;
import com.darkenedsky.d20charviewer.common.Dice;
import com.darkenedsky.d20charviewer.common.modifier.Plus;
import com.darkenedsky.d20charviewer.d20objects.D20Character;
import com.darkenedsky.d20charviewer.d20objects.D20Race;
import com.darkenedsky.d20charviewer.d20srd.D20SRD;

public class Dwarf extends D20Race {

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
	public void onGain(D20Character character) {		
		super.onGain(character);
		// Dwarves can treat dwarven waraxes and dwarven urgroshes as martial weapons rather than exotic
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Dwarven", false, true);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Common", false, true);
		character.addAbility(D20SRD.Abilities.DARKVISION60, null);
		character.addAbility(D20SRD.Abilities.INTUIT_DEPTH, null);
		character.addAbility(D20SRD.Abilities.FULL_MOVE_SPEED_MEDIUM_LOAD, null);
		character.addAbility(D20SRD.Abilities.FULL_MOVE_SPEED_HEAVY_LOAD, null);
		character.addAbilityBonus(ALL, this, new Plus(4), "resist bull rush when standing");
		character.addAbilityBonus(ALL, this, new Plus(4), "resist trip when standing");		
		character.addSkillBonus(D20SRD.Skills.SEARCH, this, new Plus(2), "unusual stonework");
		character.addSkillBonus(D20SRD.Skills.APPRAISE, this, new Plus(2), "stone");
		character.addSkillBonus(D20SRD.Skills.APPRAISE, this, new Plus(2), "metal");
		character.addSkillBonus(D20SRD.Skills.CRAFT, this, new Plus(2), "stone");
		character.addSkillBonus(D20SRD.Skills.CRAFT, this, new Plus(2), "metal");
		character.addSaveBonus(-1, this, new Plus(2), "poison");
		character.addSaveBonus(-1, this, new Plus(2), "spells");
		character.addSaveBonus(-1, this, new Plus(2), "spell-like effects");
		character.addAttackBonus(this, new Plus(1), "orcs");
		character.addAttackBonus(this, new Plus(1), "half-orcs");		
		character.addAttackBonus(this, new Plus(1), "goblins");
		character.addAttackBonus(this, new Plus(1), "bugbears");
		character.addAttackBonus(this, new Plus(1), "hobgoblins");
		character.addDodgeBonus(this, new Plus(4), "giants");
		character.addDodgeBonus(this, new Plus(4), "ogres");
		character.addDodgeBonus(this, new Plus(4), "trolls");
		
	}
	
	

}