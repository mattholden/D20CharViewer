package com.darkenedsky.gemini.common;

import java.util.HashMap;
import java.util.Map;

public class TimeUnit {
	
	private String unit;
	private TimeUnit(String time) { 
		unit = time;
	}
	public String toString() { 
		return unit;
	}
	
	public static final TimeUnit
		SECOND = new TimeUnit("second"),
		MINUTE = new TimeUnit("minute"),
		HOUR = new TimeUnit("hour"),
		DAY = new TimeUnit("day"),
		WEEK = new TimeUnit("week"),
		MONTH = new TimeUnit("month"),
		YEAR = new TimeUnit("year");
	
	public static Map<String,TimeUnit> timeUnits;
	static { 
		timeUnits  = new HashMap<String, TimeUnit>(7);
		timeUnits.put("day", DAY);
		timeUnits.put("week", WEEK);
		timeUnits.put("month", MONTH);
		timeUnits.put("year", YEAR);
		timeUnits.put("hour", HOUR);
		timeUnits.put("minute", MINUTE);
		timeUnits.put("second", SECOND);
	}
	
	public static final TimeUnit stringToUnit(String tu) { 
		return timeUnits.get(tu);
	}
}
