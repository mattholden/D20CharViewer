package com.darkenedsky.gemini.d20system;

import java.util.ArrayList;

import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.Progression;
import com.darkenedsky.gemini.common.Specialized;
import com.darkenedsky.gemini.d20system.prereq.RestrictsAlignment;

public interface D20ClassInterface extends D20, RestrictsAlignment {

	public abstract D20ClassLevel getNewLevel();
	
	public abstract ArrayList<Specialized<D20Skill>> getClassSkills();

	public abstract ArrayList<Specialized<D20Skill>> getForbiddenSkills();

	public abstract void addClassSkill(D20Skill skill, String spec);

	public abstract void addClassSkill(D20Skill skill);

	public abstract void addForbiddenSkill(D20Skill skill, String spec);

	public abstract void addForbiddenSkill(D20Skill skill);

	public abstract Progression getFortSaveProgression();

	public abstract Progression getReflexSaveProgression();

	public abstract Progression getWillSaveProgression();

	public abstract Progression getBABProgression();

	public abstract Progression getSpellProgression(int level);

	public abstract int getAgeClass();

	public abstract void setHitDice(Dice hitDice);

	public abstract Dice getHitDice();

	public abstract void setSkillPoints(int skillPoints);

	public abstract int getSkillPoints();

	public abstract void onGain(GameCharacter character);
	
	public abstract String getName();
	
	public abstract String getSRD_URL();

}