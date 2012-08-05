package com.darkenedsky.gemini.android.charviewer.d20newchar;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import com.darkenedsky.gemini.android.charviewer.R;
import com.darkenedsky.gemini.android.charviewer.WizardPageActivity;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.d20system.D20Character;

public class NameAndGenderPage extends WizardPageActivity<D20Character> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2314101162751268516L;

	private RadioButton male, female;
	private EditText playerName, characterName;
	
	@Override
	public void doCreate() {
		setContentView(R.layout.nameandgender);
		
		male = (RadioButton)findViewById(R.id.nAndG_male);
		female = (RadioButton)findViewById(R.id.nAndG_female);
		male.setChecked(true);
		female.setChecked(false);
		playerName = (EditText)findViewById(R.id.nAndG_playerName);
		characterName = (EditText)findViewById(R.id.nAndG_charName);		
	}


	@Override
	public void next(View v) { super.next(v); }
	
	@Override
	public void back(View v) { super.back(v); }
	
	@Override
	public boolean validate(View v) {
		
		if (characterName.getText().length() == 0) { 
			return error("Please enter your character's name in the Character Name field.");
		}		
		if (playerName.getText().length() == 0) { 
			return error("Please enter your name in the Player Name field.");
		}
		if (!male.isChecked() && !female.isChecked()) {
			return error("Please select a gender for your character.");
		}
		
		return true;
		
	}

	@Override
	public void saveToCharacter() {
		GameCharacter ch = wizard.getCharacter();
		if (ch == null) throw new RuntimeException("character null!");
		ch.setName(characterName.getText().toString());
		ch.setPlayer(playerName.getText().toString());
		ch.setMale(male.isSelected());	
	}

	
}
