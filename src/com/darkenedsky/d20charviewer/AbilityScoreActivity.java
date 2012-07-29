package com.darkenedsky.d20charviewer;

import com.darkenedsky.d20charviewer.R;
import com.darkenedsky.gemini.d20system.D20Character;

import android.app.Activity;
import android.os.Bundle;

public class AbilityScoreActivity extends Activity {

	 private D20Character character;
	   
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        character = (D20Character)this.getIntent().getSerializableExtra("Character");
	        setContentView(R.layout.abilityscore);
	    }
	 
	 	
	    
}
