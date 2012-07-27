package com.darkenedsky.d20charviewer;

import java.util.regex.Pattern;

import com.darkenedsky.d20charviewer.d20objects.D20Character;
import com.darkenedsky.d20charviewer.d20objects.D20Library;
import com.darkenedsky.d20charviewer.d20srd.D20SRD;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

public class D20CharViewerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // load up the SRD
        D20Library.getLibrary().loadClasses(D20SRD.Classes.getClasses());
        D20Library.getLibrary().loadRaces(D20SRD.Races.getRaces());
        D20Library.getLibrary().loadSkills(D20SRD.Skills.getSkills());
        
        setContentView(R.layout.main);
    }
    
    private D20Character character;
    
    public void doNewCharacter(View view) {
    	System.out.println("Doing new character!");
    	character = new D20Character("jjj");
    	Intent intent = new Intent(this, AbilityScoreActivity.class);
    	intent.putExtra("CHARACTER", character);    			
    	startActivity(intent);	
    }
    
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
    
        
}