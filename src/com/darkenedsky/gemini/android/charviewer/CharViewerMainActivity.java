package com.darkenedsky.gemini.android.charviewer;
import java.io.Serializable;

import com.darkenedsky.gemini.android.charviewer.R;
import com.darkenedsky.gemini.android.charviewer.d20newchar.D20NewCharWizard;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;


/*
import java.util.regex.Pattern;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.util.Patterns;
 */

public class CharViewerMainActivity extends Activity implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 7792643794772678181L;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            
        setContentView(R.layout.main);
    }

    public void newD20(View view) {
    	System.out.println("Doing new D20character!");
    	D20NewCharWizard wiz = new D20NewCharWizard(this);
    	wiz.begin();	
    }
    
    /*
    private String getGoogleAccount() { 
    	Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
    	Account[] accounts = AccountManager.get(this).getAccounts();
    	for (Account account : accounts) {
    	    if (emailPattern.matcher(account.name).matches()) {
    	        String possibleEmail = account.name;
    	        return possibleEmail;
    	    }
    	}
    	return null;
    }
    */
    
        
}