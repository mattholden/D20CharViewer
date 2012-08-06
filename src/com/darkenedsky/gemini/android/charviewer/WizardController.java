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
import com.darkenedsky.gemini.common.XMLTools;

public abstract class WizardController<T extends GameCharacter> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7337447940795947866L;

	protected ArrayList<Class<? extends WizardPageActivity<T>>> pages = new ArrayList<Class<? extends WizardPageActivity<T>>>(10);	
	protected int pageIndex = 0;
	protected T character;
	protected Context context;
	
	public Context getContext() { 
		return context;
	}
	
	public WizardController(Context cont) { 
		context = cont;
	}
	
	public void addPage(Class<? extends WizardPageActivity<T>> clz) { 
		pages.add(clz);
	}
	
	public boolean writeFile() { 
		try {
			
			String file = character.getName() + ".xml";
			String extStorage = Environment.getExternalStorageDirectory().toString()+ "/gemini";
			File dir = new File(extStorage);
			if (!dir.exists())
				dir.mkdirs();
			File theFile = new File(extStorage + "/" + file);
			BufferedWriter write = new BufferedWriter(new FileWriter(theFile), 8096);
			write.write(XMLTools.xmlToString(character.toXML("character")));
			write.flush();
			write.close();
			return true;
		} catch (IOException e) {		
			e.printStackTrace();
			Toast.makeText(context, "Error saving character file to SD card. Please try again.", Toast.LENGTH_LONG).show();
			return false;
			
		}
	}
	
	public T getCharacter() { 
		return character;
	}
	
	public boolean finish() { 
		/*
		Intent intent = new Intent(context, CharViewerMainActivity.class);	  	    	
    	context.startActivity(intent);
    	*/
    	return true;
	}
	
	public void begin() { 
		System.out.println("there are " + pages.size());
	  	Intent intent = new Intent(context, pages.get(0));
	  	intent.putExtra("WIZARD", this);
	  	intent.putExtra("CHARACTER", this);
    	context.startActivity(intent);	  	
	}
	

	public Class<? extends WizardPageActivity<T>> prev() { 
		if (pageIndex == 0) return null;
		pageIndex--;
		return pages.get(pageIndex);
	}
	
	public Class<? extends WizardPageActivity<T>> next() { 
		if (pageIndex == (pages.size()-1)) return null;
		pageIndex++;
		return pages.get(pageIndex);
	}
	
	public void cancel() {
	  	Intent intent = new Intent(context, CharViewerMainActivity.class);	  	    	
    	context.startActivity(intent);	
	}
	
}
