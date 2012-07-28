package com.darkenedsky.d20charviewer.d20srd.races;
import com.darkenedsky.d20charviewer.common.Dice;
import com.darkenedsky.d20charviewer.d20objects.D20Character;
import com.darkenedsky.d20charviewer.d20objects.D20Race;
import com.darkenedsky.d20charviewer.d20srd.D20SRD;

public class Elf extends D20Race {

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
	public void onGain(D20Character character) {		
		super.onGain(character);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Elven", false, true);
		character.addSkillRank(D20SRD.Skills.SPEAK_LANGUAGE, "Common", false, true);
		character.addAbility(D20SRD.Abilities.ELF_BLOOD, null);
	
	}
	
	

}