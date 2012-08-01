package com.darkenedsky.gemini.android.charviewer.d20newchar;

import java.util.ArrayList;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.darkenedsky.gemini.android.charviewer.R;
import com.darkenedsky.gemini.android.charviewer.WizardPageActivity;
import com.darkenedsky.gemini.common.Dice;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.d20system.D20;
import com.darkenedsky.gemini.d20system.D20Character;


public class D20AbilityScorePage extends WizardPageActivity<D20Character> {
	 	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3988486134069140001L;

	@Override
	public void doCreate() {
		
		setContentView(R.layout.abilityscore);
			
		Spinner spinner = (Spinner) findViewById(R.id.assign1);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.d20_ascore_names, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		Spinner spinner2 = (Spinner) findViewById(R.id.assign2);
		spinner2.setAdapter(adapter);
		Spinner spinner3 = (Spinner) findViewById(R.id.assign3);
		spinner3.setAdapter(adapter);
		Spinner spinner4 = (Spinner) findViewById(R.id.assign4);
		spinner4.setAdapter(adapter);
		Spinner spinner5 = (Spinner) findViewById(R.id.assign5);
		spinner5.setAdapter(adapter);
		Spinner spinner6 = (Spinner) findViewById(R.id.assign6);
		spinner6.setAdapter(adapter);
		
		reroll(null);
		
	  }

	@Override
	public void next(View v) { super.next(v); }
	
	@Override
	public void back(View v) { super.back(v); }
	
	public void reroll(View v) { 
	
		resetSpinners();
		
		Dice d1 = new Dice(4,6);		
		((TextView)findViewById(R.id.ascore1)).setText(Integer.toString(d1.roll(0,1)));
		((TextView)findViewById(R.id.ascore2)).setText(Integer.toString(d1.roll(0,1)));
		((TextView)findViewById(R.id.ascore3)).setText(Integer.toString(d1.roll(0,1)));
		((TextView)findViewById(R.id.ascore4)).setText(Integer.toString(d1.roll(0,1)));
		((TextView)findViewById(R.id.ascore5)).setText(Integer.toString(d1.roll(0,1)));
		((TextView)findViewById(R.id.ascore6)).setText(Integer.toString(d1.roll(0,1)));
	}
	
	private void resetSpinners() { 
		Spinner spinner1 = (Spinner) findViewById(R.id.assign1);
		spinner1.setSelection(0);
		Spinner spinner2 = (Spinner) findViewById(R.id.assign2);
		spinner2.setSelection(1);
		Spinner spinner3 = (Spinner) findViewById(R.id.assign3);
		spinner3.setSelection(2);
		Spinner spinner4 = (Spinner) findViewById(R.id.assign4);
		spinner4.setSelection(3);
		Spinner spinner5 = (Spinner) findViewById(R.id.assign5);
		spinner5.setSelection(4);
		Spinner spinner6 = (Spinner) findViewById(R.id.assign6);
		spinner6.setSelection(5);
	}
	
	@Override
	public boolean validate(View v) {
		
		Spinner spinner1 = (Spinner) findViewById(R.id.assign1);
		Spinner spinner2 = (Spinner) findViewById(R.id.assign2);
		Spinner spinner3 = (Spinner) findViewById(R.id.assign3);
		Spinner spinner4 = (Spinner) findViewById(R.id.assign4);
		Spinner spinner5 = (Spinner) findViewById(R.id.assign5);
		Spinner spinner6 = (Spinner) findViewById(R.id.assign6);
	
		ArrayList<Integer> selections = new ArrayList<Integer>();
		selections.add(spinner1.getSelectedItemPosition());
		
		if (selections.contains(spinner2.getSelectedItemPosition())) { 
			Toast.makeText(this, "Select each ability score only once.", Toast.LENGTH_LONG).show();
			resetSpinners();
			return false;
		}
		else { selections.add(spinner2.getSelectedItemPosition()); }
		
		if (selections.contains(spinner3.getSelectedItemPosition())) { 
			Toast.makeText(this, "Select each ability score only once.", Toast.LENGTH_LONG).show();
			resetSpinners();
			return false;
		}
		else { selections.add(spinner3.getSelectedItemPosition()); }
		
		if (selections.contains(spinner4.getSelectedItemPosition())) { 
			Toast.makeText(this, "Select each ability score only once.", Toast.LENGTH_LONG).show();
			resetSpinners();
			return false;
		}
		else { selections.add(spinner4.getSelectedItemPosition()); }
		
		if (selections.contains(spinner5.getSelectedItemPosition())) { 
			Toast.makeText(this, "Select each ability score only once.", Toast.LENGTH_LONG).show();
			resetSpinners();
			return false;
		}
		else { selections.add(spinner5.getSelectedItemPosition()); }
		
		if (selections.contains(spinner6.getSelectedItemPosition())) { 
			Toast.makeText(this, "Select each ability score only once.", Toast.LENGTH_LONG).show();
			resetSpinners();
			return false;
		}
		else { selections.add(spinner6.getSelectedItemPosition()); }
		
		// be extra safe - make sure all six are chosen
		if (!selections.contains(0) || !selections.contains(1) || !selections.contains(2) || !selections.contains(3) || !selections.contains(4) || !selections.contains(5)) { 
			Toast.makeText(this, "You must assign values to all six ability scores.", Toast.LENGTH_LONG).show();
			resetSpinners();
			return false;
		}
		
		return true;
	}

	@Override
	public void saveToCharacter() {
		Spinner spinner1 = (Spinner) findViewById(R.id.assign1);
		Spinner spinner2 = (Spinner) findViewById(R.id.assign2);
		Spinner spinner3 = (Spinner) findViewById(R.id.assign3);
		Spinner spinner4 = (Spinner) findViewById(R.id.assign4);
		Spinner spinner5 = (Spinner) findViewById(R.id.assign5);
		Spinner spinner6 = (Spinner) findViewById(R.id.assign6);
		TextView tv1 = (TextView)findViewById(R.id.ascore1);
		TextView tv2 = (TextView)findViewById(R.id.ascore2);
		TextView tv3 = (TextView)findViewById(R.id.ascore3);
		TextView tv4 = (TextView)findViewById(R.id.ascore4);
		TextView tv5 = (TextView)findViewById(R.id.ascore5);
		TextView tv6 = (TextView)findViewById(R.id.ascore6);
		
		// for some reason these ints kept going out of scope, as if getting passed by reference,
		// and not saving in the setBaseValue functions below. So, be extra-anal about it.
		Integer i1 = new Integer(Integer.parseInt((String)tv1.getText()));
		Integer i2 = new Integer(Integer.parseInt((String)tv2.getText()));
		Integer i3 = new Integer(Integer.parseInt((String)tv3.getText()));
		Integer i4 = new Integer(Integer.parseInt((String)tv4.getText()));
		Integer i5 = new Integer(Integer.parseInt((String)tv5.getText()));
		Integer i6 = new Integer(Integer.parseInt((String)tv6.getText()));
		
		GameCharacter character = wizard.getCharacter();
		character.getStat(spinner1.getSelectedItemPosition()).setBaseValue(i1);
		character.getStat(spinner2.getSelectedItemPosition()).setBaseValue(i2);
		character.getStat(spinner3.getSelectedItemPosition()).setBaseValue(i3);
		character.getStat(spinner4.getSelectedItemPosition()).setBaseValue(i4);
		character.getStat(spinner5.getSelectedItemPosition()).setBaseValue(i5);
		character.getStat(spinner6.getSelectedItemPosition()).setBaseValue(i6);
		
		System.out.println("STR: " + character.getStat(D20.STR));
		System.out.println("Dex: " + character.getStat(D20.DEX));
		System.out.println("Con: " + character.getStat(D20.CON));
		System.out.println("int: " + character.getStat(D20.INT));
		System.out.println("Wis: " + character.getStat(D20.WIS));
		System.out.println("Cha: " + character.getStat(D20.CHA));
		
		
	}
	 
	 	
	    
}
