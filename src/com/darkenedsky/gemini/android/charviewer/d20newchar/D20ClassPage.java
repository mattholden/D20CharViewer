package com.darkenedsky.gemini.android.charviewer.d20newchar;
import java.util.List;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.darkenedsky.gemini.android.charviewer.R;
import com.darkenedsky.gemini.android.charviewer.WizardPageActivity;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.RuleObject;
import com.darkenedsky.gemini.d20system.D20Character;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20Object;


public class D20ClassPage extends WizardPageActivity<D20Character> {
	 	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3988486134069140001L;

	@Override
	public void doCreate() {
		
		setContentView(R.layout.choose_one_object);
			
		Spinner spinner = (Spinner) findViewById(R.id.choose1_spinner);
		List<RuleObject> stuff = wizard.getCharacter().getLibrary().getSection(Library.CLASSES).getAll(); 
		ArrayAdapter<RuleObject> choices = new ArrayAdapter<RuleObject>(this, android.R.layout.simple_spinner_item, stuff);
		spinner.setAdapter(choices);
		spinner.setSelection(-1);		
		
		TextView inst = (TextView)findViewById(R.id.choose1_instructions);
		inst.setText("Your character will now gain a level. Please choose a class.");
	  }

	@Override
	public void next(View v) { super.next(v); }
	
	@Override
	public void back(View v) { super.back(v); }
	
	public void choose1_srdLookup(View v) { 
		Spinner spinner1 = (Spinner) findViewById(R.id.choose1_spinner);
		if (spinner1.getSelectedItemPosition() == -1) return;		
		D20Object thing = (D20Object)spinner1.getSelectedItem();
		launchBrowser(thing.getURL());
	}	
	
	@Override
	public boolean validate(View v) {
		
		Spinner spinner1 = (Spinner) findViewById(R.id.choose1_spinner);
		if (spinner1.getSelectedItemPosition() == -1) return false;		
		D20Object race = (D20Object)spinner1.getSelectedItem();
		return race.hasPrerequisites(wizard.getCharacter());
		
	}
	
	@Override
	public void saveToCharacter() {
		Spinner spinner1 = (Spinner) findViewById(R.id.choose1_spinner);
		D20Class clasz = (D20Class)spinner1.getSelectedItem();
		((D20Character)wizard.getCharacter()).addLevel(clasz.getNewLevel());
	}
	 
}
