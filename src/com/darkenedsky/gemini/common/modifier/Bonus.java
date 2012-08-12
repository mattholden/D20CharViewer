package com.darkenedsky.gemini.common.modifier;
import java.io.Serializable;
import org.jdom.Element;
import com.darkenedsky.gemini.common.GameCharacter;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.RuleObject;
import com.darkenedsky.gemini.common.XMLSerializable;
import com.darkenedsky.gemini.common.XMLTools;
import com.darkenedsky.gemini.common.prereq.HasPrerequisites;

public class Bonus implements HasPrerequisites, Serializable, XMLSerializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6915785852300090440L;
	private RuleObject source;
	private Modifier modifier;
	private String conditional;
	
	
	@Override
	public boolean hasPrerequisites(GameCharacter d20) { 
		return true;
	}
	
	public Bonus(RuleObject source, Modifier modifier, String conditional) {
		super();
		this.source = source;
		this.modifier = modifier;
		this.conditional = conditional;
	}

	public int modify(GameCharacter character, int value) {
		if (!hasPrerequisites(character)) 
			return value;
		return modifier.modify(value);
	}

	public RuleObject getSource() {
		return source;
	}

 
	public String getConditional() {
		return conditional;
	}


	public boolean isConditional() { 
		return conditional != null;
	}
	
	public Element toXML(String root) { 
		Element e= new Element(root);
		e.addContent(XMLTools.xml("class", getClass().getName()));
		e.addContent(XMLTools.xml("conditional", conditional));
		e.addContent(XMLTools.xml("source", source.getUniqueID()));
		e.addContent(modifier.toXML("modifier"));
		
		return e;
	}
	
	public Bonus(Element e) throws Exception {
		conditional = e.getChildText("conditional");		
		source = Library.instance.getByID(XMLTools.getString(e,"source"));
		modifier = (Modifier)XMLTools.dynamicLoad(e.getChild("modifier"));
		
	}
}
