import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


public class RestClient 
{
	public static void main(String[] args) throws IOException
	{
		RestTemplate template = new RestTemplate();		
		template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		template.setErrorHandler(new CustomExceptionHandler(template));

		CustomerClientVersion customer = template.getForObject("http://localhost:8080/mywebapp/customer/100029", 
				CustomerClientVersion.class);

		System.out.println("Found the customer with id " + customer.getCustomerId() + " and the company name is " + customer.getCompanyName());

		// THINKING TIME!!!!!!!!		
		// this client thought they were changing the name from Apple to VMWare
		// actually, they changing SpringSource to VMWare.

		customer.setCompanyName("VMWare");

		try
		{
			template.put("http://localhost:8080/mywebapp/customer/100029", customer);
		}
		catch (EditingConflictException e)
		{
			System.out.println("Sorry, someone else got in first, please try again.");
		}

		// Final step
		customer = template.getForObject("http://localhost:8080/mywebapp/customer/100029", 
				CustomerClientVersion.class);		
		
		System.out.println("To confirm, the customers company is now " + customer.getCompanyName());

		// patch
		CustomerClientVersion partCustomer = new CustomerClientVersion();
		partCustomer.setCompanyName("Ramsden International");

		HttpEntity<CustomerClientVersion> requestEntity = new HttpEntity<CustomerClientVersion> (partCustomer);

		template.exchange("http://localhost:8080/mywebapp/customer/100029", HttpMethod.PATCH, 
				requestEntity, Void.class);

			
		

	}
}
