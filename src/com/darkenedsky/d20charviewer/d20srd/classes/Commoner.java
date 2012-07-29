package com.darkenedsky.d20charviewer.d20srd.classes;
import com.darkenedsky.d20charviewer.common.Dice;
import com.darkenedsky.d20charviewer.common.Progression;
import com.darkenedsky.d20charviewer.common.event.CharacterEvent;
import com.darkenedsky.d20charviewer.common.event.CharacterListener;
import com.darkenedsky.d20charviewer.d20objects.D20Character;
import com.darkenedsky.d20charviewer.d20objects.D20Class;
import com.darkenedsky.d20charviewer.d20objects.D20Feat;
import com.darkenedsky.d20charviewer.d20objects.D20Race;
import com.darkenedsky.d20charviewer.d20objects.D20UIEvents;
import com.darkenedsky.d20charviewer.d20srd.D20SRD;

public class Commoner extends D20Class implements CharacterListener<D20Feat> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7233516754646135330L;

	public Commoner() {
		super("Commoner", "http://www.d20srd.org/srd/classes/commoner.htm");
		ageClass = (D20Race.AGE_MOD_FIGHTER);
		hitDice = new Dice(1,4);
		skillPoints = 2;
		babProgression = Progression.WIZARD_BAB;
		this.fortSaveProgression = Progression.SAVE_BONUS_LOW;
		this.reflexSaveProgression = Progression.SAVE_BONUS_LOW;
		this.willSaveProgression = Progression.SAVE_BONUS_LOW;		
		startingGold = new Dice(5,4);
		
		addClassSkill(D20SRD.Skills.CLIMB);
		addClassSkill(D20SRD.Skills.CRAFT,"*");
		addClassSkill(D20SRD.Skills.HANDLE_ANIMAL);
		addClassSkill(D20SRD.Skills.INTIMIDATE);
		addClassSkill(D20SRD.Skills.JUMP);
		addClassSkill(D20SRD.Skills.PROFESSION,"*");
		addClassSkill(D20SRD.Skills.RIDE);
		addClassSkill(D20SRD.Skills.LISTEN);
		addClassSkill(D20SRD.Skills.USE_ROPE);
		addClassSkill(D20SRD.Skills.SPOT);
		addClassSkill(D20SRD.Skills.SWIM);
	}
	
	@Override
	public void onGain(D20Character character) { 		
		super.onGain(character);
		character.fireUIEvent(new CharacterEvent<D20Feat>(character, D20UIEvents.CHOOSE_SIMPLE_WEAPON, this));					
	}

	@Override
	public void actionPerformed(CharacterEvent<D20Feat> evt) { 
		
	}
}