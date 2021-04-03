package com.virtualpairprogrammers.webservices;

import java.util.Collection;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.virtualpairprogrammers.domain.Action;
import com.virtualpairprogrammers.domain.Call;
import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.services.calls.CallHandlingService;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;
import com.virtualpairprogrammers.services.diary.DiaryManagementService;

@WebService(serviceName="customerService", name="CustomerService")
public class CRMServiceEndpoint 
{
	private CustomerManagementService customerService;
	private DiaryManagementService diaryService;
	private CallHandlingService callService;

	@WebMethod(exclude=true)
	public void setCustomerService(CustomerManagementService service) {
		this.customerService = service;
	}
	
	@WebMethod(exclude=true)
	public void setDiaryService(DiaryManagementService diaryService) {
		this.diaryService = diaryService;
	}

	@WebMethod(exclude=true)
	public void setCallService(CallHandlingService callService) {
		this.callService = callService;
	}

	public void newCustomer(Customer newCustomer) {
		customerService.newCustomer(newCustomer);
	}

	public void deleteCustomer(String oldCustomerId)
			throws CustomerNotFoundException 
	{
		Customer oldCustomer = customerService.findCustomerById(oldCustomerId);
		customerService.deleteCustomer(oldCustomer);
	}

	public Customer findCustomerById(String customerId)
			throws CustomerNotFoundException {
		Customer customer= customerService.findCustomerById(customerId);
		customer.setCalls(null);
		return customer;
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customers =  customerService.getAllCustomers();
		for (Customer next: customers)
		{
			next.setCalls(null);
		}
		return customers;
	}

	public Customer getFullCustomerDetail(String customerId)
			throws CustomerNotFoundException {
		return customerService.getFullCustomerDetail(customerId);
	}

	public void recordCall(String customerId, Call callDetails, Collection<Action> actions)
			throws CustomerNotFoundException {

		callService.recordCall(customerId, callDetails, actions);
	}
	
	public List<Action> getAllIncompleteActions(String userName)
	{
		return diaryService.getAllIncompleteActions(userName);
	}

}
