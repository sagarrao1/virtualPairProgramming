package com.virtualpairprogrammers.restcontrollers;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;

@RestController
public class CustomerRestController 
{
	@Autowired
	private CustomerManagementService customerService;
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ClientErrorInformation> rulesForCustomerNotFound(HttpServletRequest req, Exception e) 
	{
		ClientErrorInformation error = new ClientErrorInformation(e.toString(), req.getRequestURI());
		return new ResponseEntity<ClientErrorInformation>(error, HttpStatus.NOT_FOUND);
		
		// spring will pick up the return and CONVERT IT!
	}
	
	@ExceptionHandler(javax.persistence.OptimisticLockException.class)
	@ResponseStatus(value=HttpStatus.CONFLICT)
	public void handleConflicts() {}

	// we want to support GETs to /customer/373737
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET)
	public Customer findCustomerById(@PathVariable String id) throws CustomerNotFoundException
	{
		return customerService.getFullCustomerDetail(id);
	}
	
	/**
	 * Requirement: ONLY return customers.
	 * @return
	 */
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public CustomerCollectionRepresentation returnAllCustomers(@RequestParam(required=false) Integer first, 
			 												   @RequestParam(required=false) Integer last)
	{		
		List<Customer> allCustomers = customerService.getAllCustomers();
		for (Customer next: allCustomers)
		{
			next.setCalls(null);
		}
		
		if (first != null && last != null)
		{
			return new CustomerCollectionRepresentation(allCustomers.subList(first-1, last));
		}
		else
		{
			return new CustomerCollectionRepresentation(allCustomers);
		}
		// sent to the message converter
	}
	
	@RequestMapping(value="/customers", method=RequestMethod.POST)
	public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer newCustomer) throws CustomerNotFoundException
	{		
		Customer createdCustomer = customerService.newCustomer(newCustomer);		
		HttpHeaders headers = new HttpHeaders();
		
		URI uri = MvcUriComponentsBuilder.fromMethodName(CustomerRestController.class, 
														 "findCustomerById", 
														 createdCustomer.getCustomerId()).build().toUri();
		headers.setLocation(uri);
	
		return new ResponseEntity<Customer>(createdCustomer, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable String id) throws CustomerNotFoundException
	{
		Customer oldCustomer = customerService.findCustomerById(id);
		customerService.deleteCustomer(oldCustomer);
	}
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.PATCH)
	public void partiallyUpdateCustomer(@RequestBody Customer customerToUpdate,
			 				   @PathVariable String id) throws CustomerNotFoundException
	{
		Customer existingCustomer = customerService.findCustomerById(id);
		
		// check every field, if it's null, go with the value the customer had before....
		if (customerToUpdate.getCustomerId() == null)
		{
			customerToUpdate.setCustomerId(id);
		}
		
		if (customerToUpdate.getNotes() == null)
		{
			customerToUpdate.setNotes(existingCustomer.getNotes());
		}
		
		customerService.updateCustomer(customerToUpdate);
	}
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.PUT)
	public void updateCustomer(@RequestBody Customer customerToUpdate) throws CustomerNotFoundException
	{
		customerService.updateCustomer(customerToUpdate);
	}
		
}
