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
import com.darkenedsky.gemini.d20fantasy.abilities.*;
import com.darkenedsky.gemini.d20fantasy.feats.*;

public abstract class D20SRD implements D20Fantasy {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5788567498841621924L;

	
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
			DARKVISION = new Darkvision(),
			LOWLIGHTVISION = null,
			FULL_MOVE_SPEED_MEDIUM_LOAD = null,
			FULL_MOVE_SPEED_HEAVY_LOAD = null,
			INTUIT_DEPTH = new IntuitDepth(),
			
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
			BARDIC_MUSIC = null,
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
			
			// DRUID
			TRACKLESS_STEP = null,
			WILD_SHAPE = null,
			A_THOUSAND_FACES = null,
			
			// MONK
			FLURRY_OF_BLOWS = null,
			KI_STRIKE = null,
			WHOLENESS_OF_BODY = null,
			SLOW_FALL = null,
			IMPROVED_EVASION = null,
			GREATER_FLURRY = null,
			ABUNDANT_STEP = null,
			DIAMOND_SOUL = null,
			QUIVERING_PALM = null,
			TIMELESS_BODY = null,
			TONGUE_OF_THE_SUN_AND_MOON = null,
			EMPTY_BODY = null,
			PERFECT_SELF = null,
			
			// PALADIN
			AURA_OF_GOOD = null,
			LAY_ON_HANDS = null,
			SMITE_EVIL = null,
			
			// ranger
			WILD_EMPATHY = null,
			ANIMAL_COMPANION = null,
			CAMOUFLAGE = null,
			WOODLAND_STRIDE = null,
			SWIFT_TRACKER = null,
			EVASION = null,
			HIDE_IN_PLAIN_SIGHT = null,
			
			// rogue
			SNEAK_ATTACK = null,
			TRAPFINDING = null,			
			CRIPPLING_STRIKE = null,
			DEFENSIVE_ROLL = null,
			OPPORTUNIST = null,
			SLIPPERY_MIND = null,
			
			// THESE WILL NEVER BE ADDED TO THE CHARACTER BUT THEY 
			// NEED TO BE ABILITIES SO THEY CAN BE CHOSEN
			SKILL_MASTERY = null,
			EXTRA_ROGUE_FEAT = null,
			
			
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
			EXOTIC_WEAPON_PROFICIENCY = new ExoticWeaponProficiency(),
			LIGHT_ARMOR_PROFICIENCY = new ArmorProficiency_Light(),
			MEDIUM_ARMOR_PROFICIENCY = new ArmorProficiency_Medium(),
			HEAVY_ARMOR_PROFICIENCY = new ArmorProficiency_Heavy(),
			SHIELD_PROFICIENCY = new ShieldProficiency(),
			TOWER_SHIELD_PROFICIENCY = null,
			SCRIBE_SCROLL = null,
			SPELL_MASTERY = null,
			TRACK = null,
			ENDURANCE = new Endurance(),
			TWO_WEAPON_FIGHTING = null,
			RAPID_SHOT = null,
			ACROBATIC = new Acrobatic(),
			AGILE = new Agile(),
			ALERTNESS = new Alertness(),
			ANIMAL_AFFINITY = new AnimalAffinity(),
			ATHLETIC = new Athletic(),
			AUGMENT_SUMMONING = new AugmentSummoning(),
			BLIND_FIGHT = new BlindFight(),
			COMBAT_CASTING = new CombatCasting(),
			COMBAT_EXPERTISE = new CombatExpertise(),
			IMPROVED_DISARM = new ImprovedDisarm(),
			IMPROVED_FEINT = new ImprovedFeint(),
			IMPROVED_TRIP = new ImprovedTrip(),
			WHIRLWIND_ATTACK = null,
			COMBAT_REFLEXES = new CombatReflexes(),
			DECEITFUL = new Deceitful(),
			DEFT_HANDS = new DeftHands(),
			DILIGENT = new Diligent(),
			DODGE = new Dodge(),
			MOBILITY = null,
			SPRING_ATTACK = null,
			ESCHEW_MATERIALS = new EschewMaterials(),
			DIEHARD = new Diehard(),
			EXTRA_TURNING = null,
			GREAT_FORTITUDE = new GreatFortitude(),
			IMPROVED_COUNTERSPELL = new ImprovedCounterspell(),
			IMPROVED_CRITICAL = null,
			IMPROVED_FAMILIAR = null,
			IMPROVED_INITIATIVE = new ImprovedInitiative(),
			IMPROVED_TURNING = null,
			IMPROVED_UNARMED_STRIKE = new ImprovedUnarmedStrike(),
			DEFLECT_ARROWS = new DeflectArrows(),
			IMPROVED_GRAPPLE = new ImprovedGrapple(),
			SNATCH_ARROWS = null,
			STUNNING_FIST = null,
			INVESTIGATOR = null,
			IRON_WILL = null,
			LEADERSHIP = null,
			LIGHTNING_REFLEXES = null,
			MAGICAL_APTITUDE = null,
			MOUNTED_COMBAT = null,
			MOUNTED_ARCHERY = null,
			RIDE_BY_ATTACK = null,
			SPIRITED_CHARGE = null,
			TRAMPLE = null,
			NATURAL_SPELL = null,
			NEGOTIATOR = null,
			NIMBLE_FINGERS = null,
			PERSUASIVE = null,
			POINT_BLANK_SHOT = null,
			FAR_SHOT = new FarShot(),
			PRECISE_SHOT = null,
			IMPROVED_PRECISE_SHOT = new ImprovedPreciseShot(),
			MANYSHOT = null,
			SHOT_ON_THE_RUN = null,
			POWER_ATTACK = null,
			CLEAVE = new Cleave(),
			GREAT_CLEAVE = new GreatCleave(),
			IMPROVED_BULL_RUSH = new ImprovedBullRush(),
			IMPROVED_OVERRUN = new ImprovedOverrun(),
			IMPROVED_SUNDER = new ImprovedSunder(),
			QUICK_DRAW = null,
			RAPID_RELOAD = null,
			RUN = null,
			SELF_SUFFICIENT = null,
			IMPROVED_SHIELD_BASH = new ImprovedShieldBash(),
			SKILL_FOCUS = null,
			SPELL_FOCUS = null,
			GREATER_SPELL_FOCUS = null,
			SPELL_PENETRATION = null,
			GREATER_SPELL_PENETRATION = new GreaterSpellPenetration(),
			STEALTHY = null,
			TOUGHNESS = null,
			TWO_WEAPON_DEFENSE = null,
			IMPROVED_TWO_WEAPON_FIGHTING = new ImprovedTwoWeaponFighting(),
			GREATER_TWO_WEAPON_FIGHTING = new GreaterTwoWeaponFighting(),
			WEAPON_FINESSE = null,
			WEAPON_FOCUS = null,
			WEAPON_SPECIALIZATION = null,
			GREATER_WEAPON_FOCUS = null,
			GREATER_WEAPON_SPECIALIZATION = null,
			BREW_POTION  = null,
			CRAFT_MAGIC_ARMS_AND_ARMOR = null,
			CRAFT_ROD = null,
			CRAFT_STAFF = null,
			CRAFT_WAND = null,
			CRAFT_WONDROUS_ITEM = null,
			FORGE_RING = null,
			EMPOWER_SPELL = null,
			ENLARGE_SPELL = null,
			EXTEND_SPELL = null,
			HEIGHTEN_SPELL = null,
			MAXIMIZE_SPELL = null,
			QUICKEN_SPELL = null,
			SILENT_SPELL = null,
			STILL_SPELL = null,
			WIDEN_SPELL = null,
		
			
			// PSIONIC
			GREATER_MANYSHOT = null,
			
			// DIVINE
			POWER_CRITICAL = null,
			SHARP_SHOOTING = null;
			
	
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
	
	/*
	 * TIMING:
	 * CLASSES NEED SKILLS FOR CLASS SKILLS.
	 * FIGHTER NEEDS FEATS FIRST FOR HIS LIST OF BONUS FEATS.
	 */
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
	
	
	/* TIMING:
	 * RACES NEED CLASSES FIRST BECAUSE OF FAVORED CLASSES.	 
	 * RACES NEED CREATURE TYPES FIRST.
	 */
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
