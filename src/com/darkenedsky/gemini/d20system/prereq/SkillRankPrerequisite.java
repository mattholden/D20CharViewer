package com.darkenedsky.gemini.d20system.prereq;

import org.jdom.Element;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.XMLTools;
import com.darkenedsky.gemini.common.prereq.Prerequisite;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Skill;

public class SkillRankPrerequisite implements Prerequisite {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -34272352729622040L;
	private D20Skill skill;
	private String special;
	private int ranks = 1;
	
	public SkillRankPrerequisite(D20Skill skil, String specialize) { 
		this(skil, specialize, 1);
	}
	
	public SkillRankPrerequisite(D20Skill skil) { 
		this(skil, null, 1);
	}
	
	public SkillRankPrerequisite(D20Skill skil, String specialize, int ranx) {	
		skill = skil;
		special = specialize;
		ranks = ranx;
	}
	
	public SkillRankPrerequisite(Element e) { 
		special = XMLTools.getString(e,"specialization");
		ranks = XMLTools.getInt(e, "ranks");
		skill = (D20Skill)Library.instance.getByID(XMLTools.getString(e, "skill"));
	}
	
	@Override
	public Element toXML(String root) { 
		Element e = new Element(root);		
		e.addContent(XMLTools.xml("class", getClass().getName()));
		e.addContent(XMLTools.xml("skill", skill.getUniqueID()));
		e.addContent(XMLTools.xml("specialization", special));
		e.addContent(XMLTools.xml("ranks", ranks));
		return e;
	}
	
	public boolean satisfies(GameCharacter charactr) {
		D20Character character = (D20Character)charactr;
		return character.getSkill(skill, special).getBaseValue() >= ranks;
	}

}
