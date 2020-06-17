package com.virtualpair.motd;

public class MessageOfTheDayServiceImpl implements MessageOfTheDayService {

	private String message;
	
	@Override
	public String getTodaysMessage() {
		return this.message;
	}

	public MessageOfTheDayServiceImpl() {
		super();
	}
	
	public MessageOfTheDayServiceImpl(String message) {
		super();
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("MessageOfTheDayServiceImpl [message=%s]", message);
	}

	
}
