package com.darkenedsky.d20charviewer.d20objects;

import com.darkenedsky.d20charviewer.common.RuleObject;

public class D20Skill extends RuleObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 259408351714456236L;
	
	private boolean specialized = false;
	private boolean untrained = true;
	private int keyStat;
	private boolean armorCheckPenalty = false;
	
	public int getKeyStat() { return keyStat; }
	public boolean useUntrained() { return untrained; }
	public boolean isSpecialized() { return specialized; }
	
	public D20Skill(String name, String sRDURL, boolean specialized,
			boolean untrained, int keyStat, boolean armorCheck) {
		super(name, sRDURL);
		this.specialized = specialized;
		this.untrained = untrained;
		this.keyStat = keyStat;
		armorCheckPenalty = armorCheck;
	}
	
	public boolean applyArmorCheckPenalty() {
		return armorCheckPenalty;
	}
	
	
}
