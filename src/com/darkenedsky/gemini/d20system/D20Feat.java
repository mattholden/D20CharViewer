package com.darkenedsky.gemini.d20system;




public class D20Feat extends D20Object {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6048690368418290937L;
	
	protected boolean specialized = false;	
	protected int type = FEAT_GENERAL;
	
	public D20Feat(String name, String srdURL) { 
		this(name, srdURL, FEAT_GENERAL, false);
	}
	
	public D20Feat(String name, String srdURL, int typ) { 
		this(name, srdURL, typ, false);
	}
	
	public D20Feat(String name, String sRDURL, int typ, boolean spec) {
		super(name, sRDURL);
		type = typ;
		specialized = spec;
	}

	public int getType() {
		return type;
	}

	public boolean isSpecialized() {
		return specialized;
	}
	
}
