package com.darkenedsky.gemini.d20fantasy.abilities;
import com.darkenedsky.gemini.d20fantasy.D20Fantasy;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.D20Spell;

public class SpellLikeAbility extends D20Feat implements D20Fantasy {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4750935759602470568L;
	public SpellLikeAbility(D20Spell spell) { 
		this(spell, spell.getName(), 1);
	}
	
	private int casterLevel;
	
	public SpellLikeAbility(D20Spell spell, String name, int castLvl) {
		super(name, spell.getSRD_URL());
		type = ABILITY_SPELL_LIKE;
		stacks = false;
		casterLevel = castLvl;
	} 
	
	/**
	 * Get the effective caster level of this spell like ability
	 * @param c The character. Not used in the base class, but can be used if the caster level for this
	 * SLA is dynamically generated by the character
	 * @return the caster level.
	 */
	public int getCasterLevel(D20Character c) { 
		return casterLevel;
	}

}