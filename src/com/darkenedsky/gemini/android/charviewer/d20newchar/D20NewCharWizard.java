package com.darkenedsky.gemini.android.charviewer.d20newchar;
import android.content.Context;

import com.darkenedsky.gemini.android.charviewer.Wizard;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.d20system.D20Character;

public class D20NewCharWizard extends Wizard<D20Character> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8120980177315703182L;

	public D20NewCharWizard(Context cont, D20Character chr, Library lib) {
		super(cont, chr, lib);
		addPage(D20AbilityScorePage.class);
		
	} 

	
	
}
