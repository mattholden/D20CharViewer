package com.darkenedsky.gemini.d20fantasy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import com.darkenedsky.gemini.common.Library;
import com.darkenedsky.gemini.common.LibrarySection;
import com.darkenedsky.gemini.d20fantasy.classes.*;
import com.darkenedsky.gemini.d20fantasy.creaturetypes.*;
import com.darkenedsky.gemini.d20fantasy.races.*;
import com.darkenedsky.gemini.d20fantasy.skills.*;
import com.darkenedsky.gemini.d20system.*;


public abstract class D20SRD implements D20Fantasy {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5788567498841621924L;

	public static class Classes { 
		public static final D20Class
			BARBARIAN = new Barbarian(),
			BARD = new Bard(),
			CLERIC = new Cleric(),
			DRUID = new Druid(),
			FIGHTER = new Fighter(),
			MONK = new Monk(),
			PALADIN = new Paladin(),
			RANGER = new Ranger(),
			ROGUE = new Rogue(),
			SORCERER = new Sorcerer(),
			WIZARD = new Wizard(),
			
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
			ADEPT = new Adept(),
			ARISTOCRAT = new Aristocrat(),
			COMMONER = new Commoner(),
			EXPERT = new Expert(),
			WARRIOR = new Warrior(),
		
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
			
		static final D20Class[] buildArray() throws IllegalArgumentException, IllegalAccessException {
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
		
		 static final D20Race[] buildArray() throws IllegalArgumentException, IllegalAccessException {
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
		
			// D20Skill: Name, SRD, Specialized, UseUntrained, Key, ArmorCheck
			APPRAISE = 				new Appraise(),
			BALANCE = 				new Balance(),
			BLUFF = 				new Bluff(),
			CLIMB = 				new Climb(),
			CONCENTRATION = 		new Concentration(),
			CRAFT = 				new Craft(),
			DECIPHER_SCRIPT = 		new DecipherScript(),
			DIPLOMACY = 			new Diplomacy(),
			DISABLE_DEVICE = 		new DisableDevice(),
			DISGUISE = 				new Disguise(),
			ESCAPE_ARTIST = 		new EscapeArtist(),
			FORGERY = 				new Forgery(),
			GATHER_INFORMATION = 	new GatherInformation(),
			HANDLE_ANIMAL =			new HandleAnimal(),
			HEAL = 					new Heal(),
			HIDE = 					new Hide(),
			INTIMIDATE = 			new Intimidate(),
			JUMP = 					new Jump(),
			KNOWLEDGE = 			new Knowledge(),
			LISTEN = 				new Listen(),
			MOVE_SILENTLY = 		new MoveSilently(),
			OPEN_LOCK = 			new OpenLock(),
			PERFORM = 				new Perform(),
			PROFESSION = 			new Profession(),
			RIDE = 					new Ride(),
			READING_WRITING = 		new ReadingAndWriting(),
			SEARCH = 				new Search(),
			SENSE_MOTIVE = 			new SenseMotive(),
			SLEIGHT_OF_HAND = 		new SleightOfHand(),
			SPEAK_LANGUAGE = 		new SpeakLanguage(),
			SPELLCRAFT = 			new Spellcraft(),
			SPOT = 					new Spot(),
			SURVIVAL = 				new Survival(),
			SWIM = 					new Swim(),
			TUMBLE = 				new Tumble(),
			USE_MAGIC_DEVICE = 		new UseMagicDevice(),
			USE_ROPE = 				new UseRope(),
			
			// psionics
			AUTOHYPNOSIS = 			null,
			PSICRAFT = 				null,
			USE_PSIONIC_DEVICE = 	null;
			
		static final D20Skill[] buildArray() throws IllegalArgumentException, IllegalAccessException {
			ArrayList<D20Skill> feet = new ArrayList<D20Skill>();
			for (Field f : Skills.class.getFields()) {
				if (f.getType().isAssignableFrom(D20Skill.class)) {
					D20Skill thing = (D20Skill)f.get(null);
					if (thing != null)
						feet.add(thing);
				}
			}
					
			D20Skill[] arr = new D20Skill[feet.size()];
			for (int i = 0; i < feet.size(); i++) {
				arr[i] = feet.get(i);
				
				// add synergy as a second op because the referenced skills might not exist
				// when you call the constructor, if skill A gives a synergy bonus to skill B
				// but the static instance of B is not yet created
				arr[i].buildSynergy(); 
			}
			return arr;
		}	
		
	}
	
	public static final class CreatureTypes { 
		
		public static final D20CreatureType
			ABERRATION = null,
			ANIMAL = null,			
			CONSTRUCT = null,
			DRAGON = null,
			ELEMENTAL = null,
			FEY = null,
			GIANT = null,
			HUMANOID = new Humanoid(),
			MAGICAL_BEAST = null,
			MONSTROUS_HUMANOID = null,
			OOZE = null,
			OUTSIDER = null,
			PLANT = null,
			UNDEAD = null,
			VERMIN = null;
		
		 static final D20CreatureType[] buildArray() throws IllegalArgumentException, IllegalAccessException {
				ArrayList<D20CreatureType> feet = new ArrayList<D20CreatureType>();
				for (Field f : CreatureTypes.class.getFields()) {
					if (f.getType().isAssignableFrom(D20CreatureType.class)) {
						D20CreatureType x = (D20CreatureType)f.get(null);
						if (x != null)
							feet.add(x);
					}
				}
				D20CreatureType[] arr = new D20CreatureType[feet.size()];
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
			
		
			
		 static final D20Feat[] buildArray() throws IllegalArgumentException, IllegalAccessException {
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
			TOWER_SHIELD_PROFICIENCY = null,
			SCRIBE_SCROLL = null,
			SPELL_MASTERY = null,
			TRACK = null,
			ENDURANCE = null,
			TWO_WEAPON_FIGHTING = null,
			RAPID_SHOT = null;
		
		 static final D20Feat[] buildArray() throws IllegalArgumentException, IllegalAccessException {
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
		
		 static final D20Spell[] buildArray() throws IllegalArgumentException, IllegalAccessException {
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
		
		 static final D20Size[] buildArray() { 
			return new D20Size[] { FINE, TINY, DIMINUTIVE, SMALL, MEDIUM, LARGE, HUGE, GARGANTUAN, COLOSSAL };
		}
	}
	
	public static final Library getLibrary() throws IllegalArgumentException, IllegalAccessException { 
		
		Library l = new Library();
		l.getSection(Library.ABILITIES).add(Abilities.buildArray());
		l.getSection(Library.SPELLS).add(Spells.buildArray());
		l.addSection(CREATURE_TYPES, CreatureTypes.buildArray());
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
