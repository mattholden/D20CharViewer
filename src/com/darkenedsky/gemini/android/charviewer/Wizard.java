package com.darkenedsky.gemini.android.charviewer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import android.content.Intent;
import android.content.Context;
import android.os.Environment;
import android.widget.Toast;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.XMLTools;

public abstract class Wizard<T extends GameCharacter> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7337447940795947866L;

	private ArrayList<Class<? extends WizardPageActivity<T>>> pages = new ArrayList<Class<? extends WizardPageActivity<T>>>(10);
	
	int pageIndex = 0;

	private T character;
	private Library library;
	private Context context;
	
	public Wizard(Context cont, T chr, Library lib) { 
		character = chr;
		library = lib;
		context = cont;
	}
	
	public void addPage(Class<? extends WizardPageActivity<T>> clz) { 
		pages.add(clz);
	}
	
	public Class<? extends WizardPageActivity<T>> getPrev() { 
		if (pageIndex == 0) return null;
		pageIndex--;
		return pages.get(pageIndex);
	}
	
	public Class<? extends WizardPageActivity<T>> getNext() { 
		if (pageIndex == (pages.size()-1)) return null;
		pageIndex++;
		return pages.get(pageIndex);
	}
	
	public boolean finish() { 
	
		try {
			String file = character.getName() + ".xml";
			String extStorage = Environment.getExternalStorageDirectory().toString() + "/gemini/";
			File dir = new File(extStorage);
			if (!dir.exists())
				dir.mkdir();
			File theFile = new File(extStorage + file);
			BufferedWriter write = new BufferedWriter(new FileWriter(theFile));
			write.write(XMLTools.xmlToString(character.toXML("character")));
			write.flush();
			write.close();
		} catch (IOException e) {		
			e.printStackTrace();
			Toast.makeText(context, "Error saving file. Please try again.", Toast.LENGTH_LONG);
			return false;
		}
		
		Intent intent = new Intent(context, CharViewerMainActivity.class);	  	    	
    	context.startActivity(intent);
    	return true;
	}
	
	public void begin() { 
	  	Intent intent = new Intent(context, pages.get(0));
	  	intent.putExtra("CHARACTER", character);
	  	intent.putExtra("LIBRARY", library);
	  	intent.putExtra("WIZARD", this);
    	context.startActivity(intent);	  	
	}
	
	public void cancel() {
	  	Intent intent = new Intent(context, CharViewerMainActivity.class);	  	    	
    	context.startActivity(intent);	
  
	}
	
}
