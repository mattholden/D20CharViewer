package com.darkenedsky.gemini.d20system;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

import com.darkenedsky.gemini.common.Specialized;
import com.darkenedsky.gemini.common.XMLTools;

public class D20ClassLevelWithSkills extends D20ClassLevel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7464567361029857169L;

	public D20ClassLevelWithSkills(D20Class claz) {
		super(claz);		
	}
	
	@SuppressWarnings("unchecked")
	public D20ClassLevelWithSkills(Element e) throws Exception { 
		super(e);
		
		List<?> csk = e.getChildren("classSkill");
		for (int i = 0; i < csk.size(); i++) { 
			Element c = (Element)csk.get(i);
			classSkills.add((Specialized<D20Skill>)XMLTools.dynamicLoad(c));
		}
		
	}

	@Override
	public Element toXML(String root) { 
		Element e = super.toXML(root);
		for (Specialized<D20Skill> sk : classSkills) { 
			e.addContent(sk.toXML("classSkill"));
		}
		return e;
	}
	
	private ArrayList<Specialized<D20Skill>> classSkills = new ArrayList<Specialized<D20Skill>>();
	
	public void addClassSkill(D20Skill sk, String spec) { classSkills.add(new Specialized<D20Skill>(sk,spec)); }
	
	@Override
	public ArrayList<Specialized<D20Skill>> getClassSkills() { 
		return classSkills;
	}
	
}
