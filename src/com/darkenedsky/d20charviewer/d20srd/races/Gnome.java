package com.darkenedsky.d20charviewer.d20srd.races;

import com.darkenedsky.d20charviewer.common.Dice;
import com.darkenedsky.d20charviewer.d20objects.D20Character;
import com.darkenedsky.d20charviewer.d20objects.D20Race;
import com.darkenedsky.d20charviewer.d20objects.D20Size;
import com.darkenedsky.d20charviewer.d20srd.D20SRD;

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
	
	}
	
	

}