package com.darkenedsky.gemini.android.charviewer;

import java.io.Serializable;

import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.Library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public abstract class WizardPageActivity<T extends GameCharacter> extends Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1042089086684522382L;
	protected T character;
	protected Library library;
	protected Wizard<? extends GameCharacter> wizard;
	
	public T getCharacter() { 
		return character;
	}	  
	
	@SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        character = (T)this.getIntent().getSerializableExtra("CHARACTER");
        library = (Library)this.getIntent().getSerializableExtra("LIBRARY");
        wizard = (Wizard<T>)this.getIntent().getSerializableExtra("WIZARD");
        doCreate();
    }

	public abstract void doCreate();
	public abstract boolean validate();
	public abstract void saveToCharacter();
	
	 public boolean next() {
		if (!validate())
			return false;
		saveToCharacter();
		
		if (wizard.getNext() == null)
			return wizard.finish();
		
	  	Intent intent = new Intent(this, wizard.getNext());
    	intent.putExtra("CHARACTER", character); 
    	intent.putExtra("LIBRARY", library);
    	intent.putExtra("WIZARD", wizard);
    	startActivity(intent);	
    	return true;
	 }
	 
	 public boolean back() {
		
		if (wizard.getPrev() == null) { 
			wizard.cancel();
			return false;
		}
		
	  	Intent intent = new Intent(this, wizard.getPrev());
    	intent.putExtra("CHARACTER", character); 
    	intent.putExtra("LIBRARY", library);
    	intent.putExtra("WIZARD", wizard);
    	startActivity(intent);
    	return true;
	 }
	 
	 
}
