package com.darkenedsky.gemini.d20system;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

import com.darkenedsky.gemini.common.Statistic;
import com.darkenedsky.gemini.common.XMLTools;
import com.darkenedsky.gemini.common.modifier.Bonus;
import com.darkenedsky.gemini.d20system.bonus.AbilityModifier;
import com.darkenedsky.gemini.d20system.bonus.ArmorCheckPenalty;

public class D20SkillRank extends Statistic { 

	/**
	 * 
	 */
	private static final long serialVersionUID = -2929112341253114312L;
	private D20Skill skill;
	private D20Character character;
	
	public D20SkillRank(Element e) throws Exception { 
		super(e);
		hasHalfRank = XMLTools.getBoolean(e, "halfrank");
	}
	
	@Override
	public Element toXML(String root) { 
		Element e= super.toXML(root);
		e.addContent(XMLTools.xml("halfrank",hasHalfRank));
		return e;
	}
	
	public D20SkillRank(D20Skill sk, D20Character character) { 
		this.skill = sk;
		this.character = character;
		
		if (sk.getKeyStat() != null) { 
			addBonus(sk, new AbilityModifier(character, sk.getKeyStat()), null);
		}
		if (sk.applyArmorCheckPenalty()) { 
			addBonus(sk, new ArmorCheckPenalty(character), null);
		}			
	}
		
	@Override
	public List<Bonus> getBonuses() { 
		List<Bonus> bon = new ArrayList<Bonus>(super.getBonuses().size());
		bon.addAll(super.getBonuses());
		
		// add universal bonuses for the skill that applies to ALL skill checks, regardless of specialization
		if (skill.isSpecialized()) { 
			bon.addAll(character.getSkill(skill, null).getBonuses());
		}
		return bon;
	}
	
	private boolean hasHalfRank;
	
	public void addHalfRank() { 
		if (!hasHalfRank)
			hasHalfRank = true;
		else { 
			hasHalfRank = false;
			baseValue++;
		}
	}
		 
}
