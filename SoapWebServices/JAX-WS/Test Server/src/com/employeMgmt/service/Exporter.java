package com.employeMgmt.service;

import javax.xml.ws.Endpoint;

public class Exporter {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/any/thing/you/like/employeeService", 
				new EmployeeServiceImpl());
	}
}
