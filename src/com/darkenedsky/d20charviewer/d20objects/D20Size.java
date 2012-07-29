package com.darkenedsky.d20charviewer.d20objects;

import com.darkenedsky.d20charviewer.common.RuleObject;
import com.darkenedsky.d20charviewer.common.modifier.Plus;
import com.darkenedsky.d20charviewer.d20srd.D20SRD;

public class D20Size extends RuleObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4119767266520339661L;
	private int attackModifier;
	private int grappleModifier;
	
	
	public int getHideModifier() {
		return grappleModifier * -1;
	}
	public int getAttackModifier() {
		return attackModifier;
	}
	private D20Size(String name, String sRDURL, int attack, int grapple) {
		super(name, sRDURL);
		this.attackModifier = attack;
		this.grappleModifier = grapple;
	}
	
	
	public int getGrappleModifier() {
		return grappleModifier;
	}

	public static final D20Size FINE = new D20Size("Fine", "http://www.d20srd.org/srd/combat/movementPositionAndDistance.htm#tableCreatureSizeAndScale", 8, -16);
	public static final D20Size DIMINUTIVE = new D20Size("Diminutive", "http://www.d20srd.org/srd/combat/movementPositionAndDistance.htm#tableCreatureSizeAndScale", 4, -12);
	public static final D20Size TINY = new D20Size("Tiny", "http://www.d20srd.org/srd/combat/movementPositionAndDistance.htm#tableCreatureSizeAndScale", 2, -8);
	public static final D20Size SMALL = new D20Size("Small", "http://www.d20srd.org/srd/combat/movementPositionAndDistance.htm#tableCreatureSizeAndScale", 1, -4);
	public static final D20Size MEDIUM = new D20Size("Medium", "http://www.d20srd.org/srd/combat/movementPositionAndDistance.htm#tableCreatureSizeAndScale", 0,0);
	public static final D20Size LARGE = new D20Size("Large", "http://www.d20srd.org/srd/combat/movementPositionAndDistance.htm#tableCreatureSizeAndScale", -1, 4);
	public static final D20Size HUGE = new D20Size("Huge", "http://www.d20srd.org/srd/combat/movementPositionAndDistance.htm#tableCreatureSizeAndScale", -2, 8);
	public static final D20Size GARGANTUAN = new D20Size("Gargantuan", "http://www.d20srd.org/srd/combat/movementPositionAndDistance.htm#tableCreatureSizeAndScale", -4, 12);
	public static final D20Size COLOSSAL = new D20Size("Colossal", "http://www.d20srd.org/srd/combat/movementPositionAndDistance.htm#tableCreatureSizeAndScale", -8, 16);
	
	@Override
	public void onGain(D20Character character) { 
		character.addDodgeBonus(this, new Plus(attackModifier),null);
		character.addAttackBonus(this, new Plus(attackModifier),null);
		character.addSkillBonus(D20SRD.Skills.HIDE, this, new Plus(getHideModifier()), null);
	}
	
	public static final D20Size load(String sz) {				
		if (sz.equals("Fine")) return FINE;
		if (sz.equals("Diminutive")) return DIMINUTIVE;
		if (sz.equals("Tiny")) return TINY;
		if (sz.equals("Small")) return SMALL;
		if (sz.equals("Medium")) return MEDIUM;
		if (sz.equals("Large")) return LARGE;
		if (sz.equals("Huge")) return HUGE;
		if (sz.equals("Gargantuan")) return GARGANTUAN;
		if (sz.equals("Colossal")) return COLOSSAL;
		return null;
	}
	
}
