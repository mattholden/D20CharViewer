package com.darkenedsky.d20charviewer.d20srd.races;
import com.darkenedsky.d20charviewer.common.Dice;
import com.darkenedsky.d20charviewer.d20objects.D20Character;
import com.darkenedsky.d20charviewer.d20objects.D20Race;
import com.darkenedsky.d20charviewer.d20srd.D20SRD;

public class HalfOrc extends D20Race {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8477449609986282790L;

	public HalfOrc() {
		super("HalfOrc", "http://www.d20srd.org/srd/races.htm#halfOrcs");
		favoredClass = D20SRD.Classes.BARBARIAN;
		mods[STR] = 2;
		mods[INT] = -2;
		mods[CHA] = -2;
		bonusLanguages.add("Abyssal");
		bonusLanguages.add("Draconic");
		bonusLanguages.add("Giant");
		bonusLanguages.add("Gnoll");
		bonusLanguages.add("Goblin");
		ageRanges= new int[] {7,14,30,45,60};
		maxAge = new Dice(2,10);
		baseHeightM = ht(4,10);
		modHeightM = new Dice(2,12);
		baseWeightM = 150;
		modWeightM = new Dice(2,6);
		baseHeightF = ht(4,5);
		modHeightF = new Dice(2,12);
		baseWeightF = 110;
		modWeightF = new Dice(2,6);
		this.ageModsByClass = new Dice[] {
			new Dice(1,4), new Dice(1,6), new Dice(2,6)
		};
	
	}

	@Override
	public void onGain(D20Character character) {		
		super.onGain(character);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Orc", false, true);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Common", false, true);
		character.addAbility(D20SRD.Abilities.ORC_BLOOD, null);
	}
	
	

}