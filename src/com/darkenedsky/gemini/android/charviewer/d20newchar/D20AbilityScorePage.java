package com.darkenedsky.gemini.android.charviewer.d20newchar;

import com.darkenedsky.gemini.android.charviewer.R;
import com.darkenedsky.gemini.android.charviewer.WizardPageActivity;
import com.darkenedsky.gemini.d20system.D20Character;


public class D20AbilityScorePage extends WizardPageActivity<D20Character> {
	 	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3988486134069140001L;

	@Override
	public void doCreate() {
		
	    setContentView(R.layout.abilityscore);
	}

	@Override
	public boolean validate() {
		return false;
	}

	@Override
	public void saveToCharacter() {
		
	}
	 
	 	
	    
}
