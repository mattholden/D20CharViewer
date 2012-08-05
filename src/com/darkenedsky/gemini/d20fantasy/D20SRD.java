package com.darkenedsky.gemini.d20fantasy;
import java.lang.reflect.Field;
import java.util.ArrayList;

import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.LibrarySection;
import com.darkenedsky.gemini.d20fantasy.classes.*;
import com.darkenedsky.gemini.d20fantasy.races.*;
import com.darkenedsky.gemini.d20system.D20Alignment;
import com.darkenedsky.gemini.d20system.D20Class;
import com.darkenedsky.gemini.d20system.D20Feat;
import com.darkenedsky.gemini.d20system.D20Race;
import com.darkenedsky.gemini.d20system.D20Size;
import com.darkenedsky.gemini.d20system.D20Skill;
import com.darkenedsky.gemini.d20system.D20Spell;
import com.darkenedsky.gemini.d20system.D20SpellcasterClass;

public abstract class D20SRD implements D20Fantasy {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5788567498841621924L;

	public static class Classes { 
		public static final D20Class
			BARBARIAN = null,
			BARD = null,
			CLERIC = null,
			DRUID = null,
			FIGHTER = null,
			MONK = null,
			PALADIN = null,
			RANGER = new Ranger(),
			ROGUE = null,
			SORCERER = null,
			WIZARD = null,
			
			// SPECIALTY WIZARDS
			ILLUSIONIST = null,
			ABJURER = null,
			CONJURER = null,
			DIVINER = null,
			ENCHANTER = null,
			EVOKER = null,
			NECROMANCER = null,
			TRANSMUTER = null,
			
			// PRESTIGE CLASSES
			ARCANE_ARCHER = null,
			ARCANE_TRICKSTER = null,
			ARCHMAGE = null,
			ASSASSIN = null,
			BLACKGUARD = null,
			DRAGON_DISCIPLE = null,
			DUELIST = null,
			DWARVEN_DEFENDER = null,
			ELDRITCH_KNIGHT = null,
			HIEROPHANT = null,
			HORIZON_WALKER = null,
			LOREMASTER = null,
			MYSTIC_THEURGE = null,
			SHADOWDANCER = null,
			THAUMATURGIST  = null,
			
			// NPC CLASSES
			ADEPT = null,
			ARISTOCRAT = null,
			COMMONER = null,
			EXPERT = null,
			WARRIOR = null,
		
			// EPIC PRESTIGE
			AGENT_RETRIEVER = null,
			COSMIC_DESCRYER = null,
			DIVINE_EMISSARY = null,
			EPIC_INFILTRATOR = null,
			GUARDIAN_PARAMOUR = null,
			HIGH_PROSELYTIZER = null,
			LEGENDARY_DREADNOUGHT = null,
			PERFECT_WIGHT = null,
			UNION_SENTINEL = null,
			
			// psionic classes
			PSION = null,
			PSYCHIC_WARRIOR = null,
			SOULKNIFE = null,
			WILDER = null,
			
			// psionic prestige classes
			CEREBREMANCER = null,
			ELOCATER = null,
			METAMIND = null,
			PSION_UNCARNATE = null,
			PSIONIC_FIST = null,
			PYROKINETICIST = null,
			SLAYER = null,
			THRALLHERD = null,
			WAR_MIND = null;
			
		public static final D20Class[] buildArray() throws IllegalArgumentException, IllegalAccessException {
			ArrayList<D20Class> feet = new ArrayList<D20Class>();
			for (Field f : Classes.class.getFields()) {
				if (f.getType().isAssignableFrom(D20Class.class)) {
					D20Class thing = (D20Class)f.get(null);
					if (thing != null)
						feet.add(thing);
				}
			}
			D20Class[] arr = new D20Class[feet.size()];
			for (int i = 0; i < feet.size(); i++) 
				arr[i] = feet.get(i);
			return arr;
		}
		
	}
	
	
	
	public static class Races { 
		public static final D20Race 
			HUMAN = new Human(),
			HALFELF = new HalfElf(),
			ELF = new Elf(),
			DWARF = new Dwarf(),
			GNOME = new Gnome(),
			HALFORC = new HalfOrc(),
			HALFLING = new Halfling(),
			
			// PSONIC RACES
			DROMITE = null,
			DUERGAR = null,
			ELAN = null,
			HALFGIANT = null,
			MAENAD = null,
			XEPH = null;
		
		public static final D20Race[] buildArray() throws IllegalArgumentException, IllegalAccessException {
			ArrayList<D20Race> feet = new ArrayList<D20Race>();
			for (Field f : Races.class.getFields()) {
				if (f.getType().isAssignableFrom(D20Race.class)) {
					D20Race r = (D20Race)f.get(null);
					if (r != null) feet.add(r);
				}
			}
			D20Race[] arr = new D20Race[feet.size()];
			for (int i = 0; i < feet.size(); i++) 
				arr[i] = feet.get(i);
			return arr;
		}
	};
	
	public static class Skills { 
		public static final D20Skill
			ALCHEMY = null,
			ANIMAL_EMPATHY = null,
			APPRAISE = null,
			BALANCE = null,
			BLUFF = null,
			CLIMB = null,
			CONCENTRATION = null,
			CRAFT = null,
			DECIPHER_SCRIPT = null,
			DIPLOMACY = null,
			DISABLE_DEVICE = null,
			DISGUISE = null,
			ESCAPE_ARTIST = null,
			FORGERY = null,
			GATHER_INFORMATION = null,
			HANDLE_ANIMAL = null,
			HEAL = null,
			HIDE = null,
			INNUENDO = null,
			INTIMIDATE = null,
			INTUIT_DIRECTION = null,
			JUMP = null,
			KNOWLEDGE = null,
			LISTEN = null,
			MOVE_SILENTLY = null,
			OPEN_LOCK = null,
			PERFORM = null,
			PICK_POCKET = null,
			PROFESSION = null,
			READ_LIPS = null,
			RIDE = null,
			SCRY = null,
			READING_WRITING = null,
			SEARCH = null,
			SENSE_MOTIVE = null,
			SLEIGHT_OF_HAND = null,
			SPEAK_LANGUAGE = null,
			SPELLCRAFT = null,
			SPOT = null,
			SURVIVAL = null,
			SWIM = null,
			TUMBLE = null,
			USE_MAGIC_DEVICE = null,
			USE_ROPE = null,
			WILDERNESS_LORE = null,
			
			// psionics
			AUTOHYPNOSIS = null,
			PSICRAFT = null,
			USE_PSIONIC_DEVICE = null;
			
		public static final D20Skill[] buildArray() throws IllegalArgumentException, IllegalAccessException {
			ArrayList<D20Skill> feet = new ArrayList<D20Skill>();
			for (Field f : Skills.class.getFields()) {
				if (f.getType().isAssignableFrom(D20Skill.class)) {
					D20Skill thing = (D20Skill)f.get(null);
					if (thing != null)
						feet.add(thing);
				}
			}
			D20Skill[] arr = new D20Skill[feet.size()];
			for (int i = 0; i < feet.size(); i++) 
				arr[i] = feet.get(i);
			return arr;
		}	
		
	}
	
	public static final class Abilities { 
		
		public static final D20Feat 
			
			// RACIAL ABILITIES
			DARKVISION60 = null,
			LOWLIGHTVISION = null,
			FULL_MOVE_SPEED_MEDIUM_LOAD = null,
			FULL_MOVE_SPEED_HEAVY_LOAD = null,
			INTUIT_DEPTH = null,
			
			// bloodlines (for identifying half- and variant- races)
			ELF_BLOOD = null,
			ORC_BLOOD = null,
			DWARF_BLOOD = null,
		
			// BARBARIAN ABILITIES
			FAST_MOVEMENT = null,
			UNCANNY_DODGE = null,
			IMPROVED_UNCANNY_DODGE = null,
			RAGE = null,
			GREATER_RAGE = null,
			TIRELESS_RAGE = null,
			MIGHTY_RAGE = null,
			INDOMITABLE_WILL = null,
					
			// BARD ABILITIES
			BARDIC_KNOWLEDGE = null,
			COUNTERSONG = null,
			FASCINATE = null,
			INSPIRE_COURAGE = null,
			INSPIRE_COMPETENCE = null,
			INSPIRE_GREATNESS = null,
			INSPIRE_HEROICS = null,
			SONG_OF_FREEDOM = null,
			MASS_SUGGESTION = null,
			SUGGESTION = null,
		
			// CLERIC ABILITIES
			TURN_CREATURE = null,
			REBUKE_CREATURE = null,
			AURA = null,
			
			// sorcerer
			SUMMON_FAMILIAR = null;
			
		
			
		public static final D20Feat[] buildArray() throws IllegalArgumentException, IllegalAccessException {
			ArrayList<D20Feat> feet = new ArrayList<D20Feat>();
			for (Field f : Abilities.class.getFields()) {
				if (f.getType().isAssignableFrom(D20Feat.class)) {
					D20Feat x = (D20Feat)f.get(null);
					if (x != null)
						feet.add(x);
				}
			}
			D20Feat[] arr = new D20Feat[feet.size()];
			for (int i = 0; i < feet.size(); i++) 
				arr[i] = feet.get(i);
			return arr;
		}
	}
	
	public static final class Feats { 
		
		public static final D20Feat
			SIMPLE_WEAPON_PROFICIENCY = null,
			MARTIAL_WEAPON_PROFICIENCY = null,
			EXOTIC_WEAPON_PROFICIENCY = null,
			LIGHT_ARMOR_PROFICIENCY = null,
			MEDIUM_ARMOR_PROFICIENCY = null,
			HEAVY_ARMOR_PROFICIENCY = null,
			SHIELD_PROFICIENCY = null,
			TOWER_SHIELD_PROFICIENCY = null;
		
		public static final D20Feat[] buildArray() throws IllegalArgumentException, IllegalAccessException {
			ArrayList<D20Feat> feet = new ArrayList<D20Feat>();
			for (Field f : Feats.class.getFields()) {
				if (f.getType().isAssignableFrom(D20Feat.class)) {
					D20Feat x = (D20Feat)f.get(null);
					if (x != null)
						feet.add(x);
				}
			}
			D20Feat[] arr = new D20Feat[feet.size()];
			for (int i = 0; i < feet.size(); i++) 
				arr[i] = feet.get(i);
			return arr;
		}
		
	}
	
	public static final class Spells { 
		
		public static final D20Spell 
			SPEAK_WITH_ANIMALS = null,
			DANCING_LIGHTS = null,
			PRESTIDIGITATION = null,
			GHOST_SOUND = null;
		
		public static final D20Spell[] buildArray() throws IllegalArgumentException, IllegalAccessException {
			ArrayList<D20Spell> feet = new ArrayList<D20Spell>();
			for (Field f : Spells.class.getFields()) {
				if (f.getType().isAssignableFrom(D20Spell.class)) {
					D20Spell x = (D20Spell)f.get(null);
					if (x != null)
						feet.add(x);
				}
			}
			D20Spell[] arr = new D20Spell[feet.size()];
			for (int i = 0; i < feet.size(); i++) 
				arr[i] = feet.get(i);
			return arr;
		}
	}
	
	public static final class Size { 
		public static final D20Size 
			FINE = D20Size.FINE,
			TINY = D20Size.TINY,
			DIMINUTIVE = D20Size.DIMINUTIVE,
			SMALL = D20Size.SMALL,
			MEDIUM = D20Size.MEDIUM,
			LARGE = D20Size.LARGE,
			HUGE = D20Size.HUGE,
			GARGANTUAN = D20Size.GARGANTUAN,
			COLOSSAL = D20Size.COLOSSAL;
		
		public static final D20Size[] buildArray() { 
			return new D20Size[] { FINE, TINY, DIMINUTIVE, SMALL, MEDIUM, LARGE, HUGE, GARGANTUAN, COLOSSAL };
		}
	}
	
	public static final Library getLibrary() throws IllegalArgumentException, IllegalAccessException { 
		
		Library l = new Library();
		l.getSection(Library.ABILITIES).add(Abilities.buildArray());
		l.getSection(Library.SPELLS).add(Spells.buildArray());
		l.getSection(Library.RACES).add(Races.buildArray());		
		l.addSection(Library.SKILLS, Skills.buildArray());
		l.addSection(ALIGNMENT, D20Alignment.buildArray());
		l.addSection(SIZE, Size.buildArray());		
		l.addSection(FEATS, Feats.buildArray());
		
		D20Class[] classes = Classes.buildArray();
		l.getSection(Library.CLASSES).add(classes);
		LibrarySection castertype = l.addSection(SPELLCASTER_TYPES);
		for (D20Class c: classes) { 
			if (c != null && c instanceof D20SpellcasterClass) { 
				castertype.add(c);
			}
		}
				
		return l;
	}
	
}
