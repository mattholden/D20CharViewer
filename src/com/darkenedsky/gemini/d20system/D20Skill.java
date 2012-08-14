package com.darkenedsky.gemini.d20system;

import java.util.ArrayList;
import java.util.HashMap;
import com.darkenedsky.gemini.common.modifier.Bonus;
import com.darkenedsky.gemini.common.modifier.Plus;

public class D20Skill extends D20Object {

	/**
	 * 
	 */
	private static final long serialVersionUID = 259408351714456236L;
	
	private boolean specialized = false;
	private boolean untrained = true;
	private Integer keyStat;
	private boolean armorCheckPenalty = false;
	
	public Integer getKeyStat() { return keyStat; }
	public boolean useUntrained() { return untrained; }
	public boolean isSpecialized() { return specialized; }
	
	
	private HashMap<String, ArrayList<SynergySkill>> synergy = new HashMap<String, ArrayList<SynergySkill>>();
	
	private static class SynergySkill { 
		private String bonusSpecialization, condition;
		private D20Skill bonusSkill, grantingSkill;
		private int amount;
		
		public SynergySkill(D20Skill myskill, D20Skill skill, String yours, String when, int amount) { 			
			bonusSpecialization = yours;
			bonusSkill = skill;
			grantingSkill = myskill;
			condition = when;
			this.amount = amount;
		}
		
		public void apply(D20Character character) { 
			character.getSkill(bonusSkill, bonusSpecialization).addBonus(
					new Bonus(grantingSkill, new Plus(amount), condition));
		}
		
	}
	
	public void addSynergyBonus(D20Skill skill, String cond) { addSynergyBonus(null, skill, null, 2, cond); }
	
	public void addSynergyBonus(String mySpecialization, D20Skill skill, String skillSpec, int amount, String condition) {
		ArrayList<SynergySkill> list = synergy.get(mySpecialization);
		if (list == null) { 
			list = new ArrayList<SynergySkill>();
			synergy.put(mySpecialization, list);
		}
		list.add(new SynergySkill(this, skill, skillSpec, condition, amount));
	}
	
	public void applySynergy(String spec, D20Character chr) { 
		ArrayList<SynergySkill> syn = synergy.get(spec);
		if (syn == null || syn.size() == 0) return;
		
		for (SynergySkill s : syn) 
			s.apply(chr);
	}
	
	public D20Skill(String name, String sRDURL, boolean specialized,
			boolean untrained, Integer keyStat, boolean armorCheck) {
		super(name, sRDURL);
		this.specialized = specialized;
		this.untrained = untrained;
		this.keyStat = keyStat;
		armorCheckPenalty = armorCheck;
	}
	
	public boolean applyArmorCheckPenalty() {
		return armorCheckPenalty;
	}
	
	
	public void buildSynergy() { 
		
	}
	
}
