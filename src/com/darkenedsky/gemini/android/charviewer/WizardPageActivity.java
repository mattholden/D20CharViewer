package com.darkenedsky.gemini.android.charviewer;

import java.io.Serializable;

import com.darkenedsky.gemini.common.GameCharacter;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public abstract class WizardPageActivity<T extends GameCharacter> extends Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1042089086684522382L;
	protected WizardController<? extends GameCharacter> wizard;	 
	
	@SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wizard = (WizardController<T>)this.getIntent().getSerializableExtra("WIZARD");
        doCreate();
    }

	protected void launchBrowser(String url) { 
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		startActivity(browserIntent);
	}
	
	public abstract void doCreate();
	public abstract boolean validate(View v);
	public abstract void saveToCharacter();
	
	 public void next(View v) {
		if (!validate(v))
			return;
		
		saveToCharacter();
		wizard.writeFile();
		
		Class<? extends WizardPageActivity<? extends GameCharacter>> next  = wizard.next();
		if (next == null) {
			wizard.finish();
		}
		else { 
		  	Intent intent = new Intent(wizard.context, next);
	    	intent.putExtra("WIZARD", wizard);
	    	intent.putExtra("CHARACTER", wizard.getCharacter());
	    	startActivity(intent);
		}
    }
	 
	 public void back(View view) {
		
		Class<? extends WizardPageActivity<? extends GameCharacter>> prev  = wizard.prev();
			 
		if (prev == null) { 
			wizard.cancel();
			return;
		}
		
	  	Intent intent = new Intent(wizard.context, prev);
    	intent.putExtra("WIZARD", wizard);
    	intent.putExtra("CHARACTER", wizard.getCharacter());
    	startActivity(intent);
    }
	 
	 protected boolean error(String text) { 
		 Toast.makeText(this, text, Toast.LENGTH_LONG).show();
		 return false;
	 }
}
