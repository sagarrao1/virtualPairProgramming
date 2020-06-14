package com.virtualpair.services;

import javax.jws.WebService;

import com.virtualpair.domain.Employee;

@WebService
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public Employee getEmployeeById(String id) {		
		return new Employee("1","Sagar rao");
	}

}
