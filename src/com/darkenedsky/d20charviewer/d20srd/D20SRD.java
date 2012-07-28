package com.darkenedsky.d20charviewer.d20srd;
import com.darkenedsky.d20charviewer.d20srd.classes.*;
import com.darkenedsky.d20charviewer.d20srd.races.*;
import com.darkenedsky.d20charviewer.d20srd.feats.*;
import com.darkenedsky.d20charviewer.d20srd.skills.*;
import com.darkenedsky.d20charviewer.d20srd.abilities.*;

import com.darkenedsky.d20charviewer.d20objects.D20Class;
import com.darkenedsky.d20charviewer.d20objects.D20Feat;
import com.darkenedsky.d20charviewer.d20objects.D20Race;
import com.darkenedsky.d20charviewer.d20objects.D20Skill;

public abstract class D20SRD {

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
			WARRIOR = null;
		
			
		
		public static final D20Class[] getClasses() { 
			return new D20Class[] { 
					BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WIZARD, 
					ABJURER, CONJURER, DIVINER, ENCHANTER, EVOKER, ILLUSIONIST, NECROMANCER, TRANSMUTER
			};
		}
	}
	public static class Races { 
		public static final D20Race 
			HUMAN = new Human(),
			HALFELF = null,
			ELF = null,
			DWARF = null,
			GNOME = null,
			HALFORC = null,
			HALFLING = null;
		
		public static final D20Race[] getRaces() { 
			return new D20Race[] { DWARF, ELF, GNOME, HALFELF, HALFLING, HALFORC, HUMAN };
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
			SPEAK_LANGUAGE = null,
			SPELLCRAFT = null,
			SPOT = null,
			SWIM = null,
			TUMBLE = null,
			USE_MAGIC_DEVICE = null,
			USE_ROPE = null,
			WILDERNESS_LORE = null;
		
		public static final D20Skill[] getSkills() { 
			return new D20Skill[] {
					ALCHEMY,
					ANIMAL_EMPATHY,
					APPRAISE,
					BALANCE,
					BLUFF,
					CLIMB,
					CONCENTRATION,
					CRAFT,
					DECIPHER_SCRIPT,
					DIPLOMACY,
					DISABLE_DEVICE,
					DISGUISE,
					ESCAPE_ARTIST,
					FORGERY,
					GATHER_INFORMATION,
					HANDLE_ANIMAL,
					HEAL,
					HIDE,
					INNUENDO,
					INTIMIDATE,
					INTUIT_DIRECTION,
					JUMP,
					KNOWLEDGE,
					LISTEN,
					MOVE_SILENTLY,
					OPEN_LOCK,
					PERFORM,
					PICK_POCKET,
					PROFESSION,
					READ_LIPS,
					RIDE,
					SCRY,
					READING_WRITING,
					SEARCH,
					SENSE_MOTIVE,
					SPEAK_LANGUAGE,
					SPELLCRAFT,
					SPOT,
					SWIM,
					TUMBLE,
					USE_MAGIC_DEVICE,
					USE_ROPE,
					WILDERNESS_LORE
			};
		};				
	}
	
	public static final class Abilities { 
		
		public static final D20Feat 
			DARKVISION60 = null,
			LOWLIGHTVISION = null,
			FULL_MOVE_SPEED_MEDIUM_LOAD = null,
			FULL_MOVE_SPEED_HEAVY_LOAD = null,
			INTUIT_DEPTH = null,
			SLEEP_IMMUNITY = null,
			ELF_BLOOD = null,
			ORC_BLOOD = null;
		
	}
}
