package com.darkenedsky.gemini.android.charviewer;
import java.io.Serializable;

import com.darkenedsky.gemini.android.charviewer.R;
import com.darkenedsky.gemini.android.charviewer.d20newchar.D20NewCharWizard;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;
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
	private Library library;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // load up the SRD
        try {
        	library = D20SRD.getLibrary();
        }
        catch (Exception x) { 
        	x.printStackTrace();
        }
        
        setContentView(R.layout.main);
    }

    public void newD20(View view) {
    	System.out.println("Doing new D20character!");
    	new D20NewCharWizard(this, new D20Character(library), library).begin();	
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