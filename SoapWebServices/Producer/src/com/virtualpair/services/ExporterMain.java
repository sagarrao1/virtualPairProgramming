package com.virtualpair.services;

import javax.xml.ws.Endpoint;

public class ExporterMain {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:4848/soap/TestServer", 
				new EmployeeServiceImpl());

	}

}
