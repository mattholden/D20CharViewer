package com.darkenedsky.gemini.android.charviewer;

import java.io.Serializable;

import com.darkenedsky.gemini.common.GameCharacter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public abstract class WizardPageActivity<T extends GameCharacter> extends Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1042089086684522382L;
	protected Wizard<? extends GameCharacter> wizard;	 
	
	@SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wizard = (Wizard<T>)this.getIntent().getSerializableExtra("WIZARD");
        doCreate();
    }

	public abstract void doCreate();
	public abstract boolean validate(View v);
	public abstract void saveToCharacter();
	
	 public void next(View v) {
		if (!validate(v))
			return;
		
		saveToCharacter();
		wizard.writeFile();
		
		if (wizard.getNext() == null)
			wizard.finish();
		
	  	Intent intent = new Intent(this, wizard.getNext());
    	intent.putExtra("WIZARD", wizard);
    	startActivity(intent);	
    }
	 
	 public void back(View view) {
		
		if (wizard.getPrev() == null) { 
			wizard.cancel();
			return;
		}
		
	  	Intent intent = new Intent(this, wizard.getPrev());
    	intent.putExtra("WIZARD", wizard);
    	startActivity(intent);
    }
	 
	 
}
