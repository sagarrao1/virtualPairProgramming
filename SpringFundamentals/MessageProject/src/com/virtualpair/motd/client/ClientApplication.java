package com.virtualpair.motd.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.virtualpair.motd.MessageOfTheDayService;

public class ClientApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext container = 
				new ClassPathXmlApplicationContext("application.xml");

		MessageOfTheDayService service = 
				container.getBean("motdService", MessageOfTheDayService.class);
		
		System.out.println(service.getTodaysMessage());
		
		container.close();
	}

}
