import java.io.IOException;
import java.net.URI;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


public class RestClient 
{
	public static void main(String[] args) throws IOException
	{
		RestTemplate template = new RestTemplate();		
		template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		template.setErrorHandler(new CustomExceptionHandler(template));


		CustomerClientVersion customer = new CustomerClientVersion();
		customer.setCompanyName("Apple");
		customer.setNotes("something");
		
		URI finalLocation = template.postForLocation("http://localhost:8080//mywebapp//customers", customer);
		System.out.println(finalLocation);
		
		// rest of the code, we do something with the URI
		CustomerClientVersion foundCustomer = template.getForObject(finalLocation, CustomerClientVersion.class);
		System.out.println(foundCustomer);
	}
}
