package com.darkenedsky.gemini.android.charviewer.d20newchar;
import android.content.Context;
import android.widget.Toast;

import com.darkenedsky.gemini.android.charviewer.WizardController;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;

public class D20NewCharWizard extends WizardController<D20Character> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8120980177315703182L;

	public D20NewCharWizard(Context cont) {
		super(cont);
		
		try {
			// build the library 
			Library lib = D20SRD.getLibrary();
			
			// set up the character
			character = new D20Character(lib);
			
			// set listeners so the character can call the steps involved in leveling up		
		}
		catch (Exception x) { 
			x.printStackTrace();
			Toast.makeText(cont, "Error loading D20 Library.", Toast.LENGTH_LONG).show();
			return;
		}
		
		addPage(NameAndGenderPage.class);
		addPage(D20AbilityScorePage.class);
		addPage(D20RacePage.class);
		addPage(D20ClassPage.class);
		
	} 

	
	
}
