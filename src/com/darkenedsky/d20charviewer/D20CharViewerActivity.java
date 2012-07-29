package com.darkenedsky.d20charviewer;


import com.darkenedsky.d20charviewer.R;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.d20fantasy.D20SRD;
import com.darkenedsky.gemini.d20system.D20Character;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/*
import java.util.regex.Pattern;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.util.Patterns;
 */

public class D20CharViewerActivity extends Activity {
    
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
    
    private D20Character character;
    
    public void doNewCharacter(View view) {
    	System.out.println("Doing new character!");
    	character = new D20Character("jjj", library);
    	Intent intent = new Intent(this, AbilityScoreActivity.class);
    	intent.putExtra("CHARACTER", character);    			
    	startActivity(intent);	
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