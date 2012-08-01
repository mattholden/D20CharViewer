package com.darkenedsky.gemini.common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Element;

import com.darkenedsky.gemini.common.event.CharacterEvent;
import com.darkenedsky.gemini.common.event.CharacterListener;
import com.darkenedsky.gemini.common.modifier.Bonus;
import com.darkenedsky.gemini.common.modifier.Modifier;
import com.darkenedsky.gemini.d20system.D20Race;

public class GameCharacter implements XMLSerializable, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8851137714908121840L;
	
	protected int hp;
	protected int maxHp;
	protected String name = "New Character";
	protected String hair;
	protected String eyes;
	protected String player;
	protected boolean male = true;
	protected D20Race race;
	protected int height;
	protected int weight;
	protected int age;
	protected int xp = 0;
	protected Library library;
	private ArrayList<CharacterListener<?>> uiListeners = new ArrayList<CharacterListener<?>>();
	protected Map<Integer, Statistic> statistics = new HashMap<Integer, Statistic>(20);

	public GameCharacter() {
		super();
	}

	public void fireUIEvent(CharacterEvent uiEvent) { 
		for (CharacterListener<?> ui : uiListeners) {
			ui.actionPerformed(uiEvent);
		}
	}

	public Library getLibrary() { return library; }

	public Statistic getStat(int stat) { 
		return statistics.get(stat);
	}

	public Map<Integer,Statistic> getStats() { 
		return statistics;
	}

	public void dropBonuses(RuleObject source) { 
		for (Statistic e : statistics.values()) 
			e.dropBonuses(source);
	}

	public void addBonus(int stat, Bonus b) { 
			
		Statistic s = statistics.get(stat);
		if (s != null)
			s.addBonus(b);
	}

	public void addBonus(int stat, RuleObject source, Modifier mod, String conditional) { 
		addBonus(stat, new Bonus(source, mod, conditional));
	}

	public boolean isMale() { 
		return male;		
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHair() {
		return hair;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}

	public String getEyes() {
		return eyes;
	}

	public void setEyes(String eyes) {
		this.eyes = eyes;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getXp() {
		return xp;
	}

	public GameCharacter(Element e) throws Exception {
		library = Library.instance;
		player = XMLTools.getString(e, "player");		
		name = XMLTools.getString(e, "name");
		hair = XMLTools.getString(e, "hair");
		eyes = XMLTools.getString(e, "eyes");
		height = XMLTools.getInt(e,"height");
		weight = XMLTools.getInt(e,"weight");
		age = XMLTools.getInt(e,"age");
		male = XMLTools.getBoolean(e,"male");
		hp = XMLTools.getInt(e,"hp");
		maxHp = XMLTools.getInt(e,"maxhp");
		xp = XMLTools.getInt(e,"xp");
		
		List<?> stats = e.getChildren("statistic");
		for (int i = 0; i < stats.size(); i++) {
			Element stat = (Element)stats.get(i);
			statistics.put(XMLTools.getInt(stat, "score"), (Statistic)XMLTools.dynamicLoad(stat));
		}		
	}
	
	@Override
	public Element toXML(String root) { 
		Element e = new Element(root);
		
		e.addContent(XMLTools.xml("class", getClass().getName()));
		e.addContent(XMLTools.xml("player", player));
		e.addContent(XMLTools.xml("name", name));
		e.addContent(XMLTools.xml("hair", hair));
		e.addContent(XMLTools.xml("eyes", eyes));
		e.addContent(XMLTools.xml("height", height));
		e.addContent(XMLTools.xml("weight",weight));
		e.addContent(XMLTools.xml("age", age));
		e.addContent(XMLTools.xml("male", male));
		
		e.addContent(XMLTools.xml("hp", hp));
		e.addContent(XMLTools.xml("maxhp", maxHp));
		e.addContent(XMLTools.xml("xp", xp));
		
		for (Map.Entry<Integer, Statistic> stat : statistics.entrySet()) { 
			Element s = (stat.getValue().toXML("statistic"));
			s.addContent(XMLTools.xml("score", stat.getKey()));
			e.addContent(s);
		}
		
		return e;
		
	}
}