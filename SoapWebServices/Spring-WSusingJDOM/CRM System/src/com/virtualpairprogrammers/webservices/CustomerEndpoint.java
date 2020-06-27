package com.virtualpairprogrammers.webservices;

import org.jdom2.Element;
import org.jdom2.Namespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;

@Endpoint
public class CustomerEndpoint {

	private static final String NAMESPACE = "http://www.virtualpairprogrammers.com/crm";
	@Autowired
	CustomerManagementService service;
	
	@PayloadRoot(namespace = NAMESPACE,
			localPart = "getCustomerByIdRequest")	
	@ResponsePayload
	public Element fetchCustomerDetailsJDomVersion(@RequestPayload Element incoming) throws CustomerNotFoundException {
		
		Element idElement= incoming.getChild("id");
		String id = idElement.getText();
		System.out.println(id);
		System.out.println("fetchCustomerDetailsJDomVersion ....");
		Customer found = service.findCustomerById(id);
		System.out.println("found:  "+found.getCustomerId() +"  "+found.getCompanyName());
		
		Element outgoing= new Element("getCustomerByIdResponse");
		outgoing.addNamespaceDeclaration(Namespace.getNamespace("tns", NAMESPACE));
		
		Element customer= new Element("customer");
		
		customer.addContent(new Element("customerId").setText(found.getCustomerId()));
		customer.addContent(new Element("companyName").setText(found.getCompanyName()));
		customer.addContent(new Element("email").setText(found.getEmail()));
		
		if (found.getNotes() != null) customer.addContent(new Element("notes").setText(found.getNotes()));
		if (found.getTelephone() != null) customer.addContent(new Element("phone").setText(found.getTelephone()));
		
		outgoing.addContent(customer);		
		return outgoing;
		
		/*
		 * Element customerId= new Element("customerId");
		 * customerId.setText(found.getCustomerId());
		 * 
		 * Element companyName= new Element("companyName");
		 * companyName.setText(found.getCompanyName());
		 * 
		 * Element email= new Element("email"); email.setText(found.getEmail());
		 * 
		 * Element notes= new Element("notes"); if (found.getNotes() != null) {
		 * notes.setText(found.getNotes()); }
		 * 
		 * Element phone= new Element("phone"); if (found.getTelephone() != null) {
		 * phone.setText(found.getTelephone()); }
		 * 
		 * customer.addContent(customerId); customer.addContent(companyName);
		 * customer.addContent(email); customer.addContent(notes);
		 * customer.addContent(phone);
		 */
	}


}
