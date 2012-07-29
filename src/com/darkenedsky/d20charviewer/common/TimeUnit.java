package com.darkenedsky.d20charviewer.common;

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
	
}
