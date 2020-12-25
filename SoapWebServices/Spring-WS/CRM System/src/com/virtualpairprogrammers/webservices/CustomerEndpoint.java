package com.virtualpairprogrammers.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;
import com.virtualpairprogrammers.xml.GetCustomerByIdRequest;
import com.virtualpairprogrammers.xml.GetCustomerByIdResponse;

@Endpoint
public class CustomerEndpoint
{
	private static final String NAMESPACE = "http://www.virtualpairprogrammers.com/crm";
	
	
	
	@Autowired
	private CustomerManagementService service;
	
//	JAX-B approach

	@PayloadRoot(namespace=NAMESPACE,
		     localPart="getCustomerByIdRequest")
    @ResponsePayload
	public GetCustomerByIdResponse fetchTheCustomerDetailsJaxBVersion(@RequestPayload GetCustomerByIdRequest request) throws CustomerNotFoundException
	{
		String id = request.getId();
		
		Customer customerDomain = service.findCustomerById(id);
		
		GetCustomerByIdResponse response = new GetCustomerByIdResponse(customerDomain);
		return response;
	}
	
	
	
	// JDOM Approach
	

//	@PayloadRoot(namespace =NAMESPACE
//			, localPart = "getCustomerByIdRequest")
//	@ResponsePayload	
////	@org.springframework.ws.server.endpoint.annotation.Namespace(prefix = "s", uri = "http://www.virtualpairprogrammers.com/crm")
////	public Element fetchTheCustomerDetailsJDomVersion(@XPathParam("/s:getCustomerByIdRequest/id")String id,	
//	public Element fetchTheCustomerDetailsJDomVersion(@XPathParam("//id")String id,
//	
////	@RequestPayload Element incoming)	throws CustomerNotFoundException 
////	{				
////		Customer found = service.findCustomerById(id);
////		
////		System.out.println();
////		System.out.println();
////		
////		try {
////			new XMLOutputter(Format.getPrettyFormat()).output(incoming, System.out);
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		System.out.println();
////		System.out.println();
//		
////		Element idElement =  incoming.getChild("id");
////		String id1 = idElement.getText();
//		
//		
//		Element outgoing = new Element("getCustomerByIdResponse");
//		outgoing.addNamespaceDeclaration(Namespace.getNamespace("tns",NAMESPACE));
//		
//		Element customer = new Element("customer");
//		
//		customer.addContent(new Element("customerId").setText(found.getCustomerId()));
//		customer.addContent(new Element("companyName").setText(found.getCompanyName()));
//		customer.addContent(new Element("email").setText(found.getEmail()));
//		
//		if (found.getTelephone() != null) customer.addContent(new Element("telephone").setText(found.getTelephone()));
//		if (found.getNotes() != null) customer.addContent(new Element("notes").setText(found.getNotes()));
//		
//		outgoing.addContent(customer);
//		
//		return outgoing;
//	}

}
