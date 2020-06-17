package com.virtualpair.motd;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MessageConfigurableInXmlImpl implements MessageOfTheDayService {

	private String[] messageList;
	
	public String[] getMessageList() {
		return messageList;
	}
	
	public void setMessageList(String[] messageList) {
		this.messageList = messageList;
	}

	@Override
	public String getTodaysMessage() {
//		what day it is 
		int day = new GregorianCalendar().get(Calendar.DAY_OF_WEEK);
		
//		days are 1 in java
		String message = messageList[day-1];
		
		return message;
	}

}
