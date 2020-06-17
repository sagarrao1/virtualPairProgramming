package com.virtualpair.motd;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MessageOfDailyDynamicImpl implements MessageOfTheDayService {

	private String[] messages_array= new String[]
			{
			"Sunnday morning",
			"Boring Monday",
			"Tue Tuesday",
			"It's a Wednessday",
			"Thursday Fasting",
			"Friday laxmi day",
			"Late Saturday"
			};	
	
	@Override
	public String getTodaysMessage() {
//		what day it is 
		int day = new GregorianCalendar().get(Calendar.DAY_OF_WEEK);
		
//		days are 1 in java
		String message = messages_array[day-1];
		
		return message;
	}

}
