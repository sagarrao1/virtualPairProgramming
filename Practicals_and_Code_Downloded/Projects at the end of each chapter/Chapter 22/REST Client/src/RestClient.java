import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class RestClient 
{
	public static void main(String[] args) throws IOException
	{
		RestTemplate template = new RestTemplate();
		template.setErrorHandler(new CustomExceptionHandler(template));

		HttpHeaders headers = new HttpHeaders();
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.IMAGE_JPEG);
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);		
		headers.setAccept(acceptableMediaTypes);

		// a new customer
		CustomerClientVersion customer = new CustomerClientVersion();
		customer.setCompanyName("Symbol-LIS");
		customer.setNotes("Even more notes");
		
		ResponseEntity<CustomerClientVersion> customerEntity = template.postForEntity("http://localhost:8080/mywebapp/customers", 
				               customer, CustomerClientVersion.class);
		
		customer = customerEntity.getBody();
		System.out.println(customerEntity.getStatusCode());
		
		System.out.println("The new customer has been given an id of " + customer.getCustomerId());
		
		// update the customer
		customer.setCompanyName("Red Prarie");
		
		template.put("http://localhost:8080/mywebapp/customer/" + customer.getCustomerId(), customer);
		
		HttpEntity requestEntity = new HttpEntity(headers);
		
		HttpEntity<CustomerCollectionRepresentation> response = template.exchange("http://localhost:8080/mywebapp/customers",
				HttpMethod.GET, requestEntity, CustomerCollectionRepresentation.class);
	
		CustomerCollectionRepresentation results = response.getBody();
		
		System.out.println(results);

	}
}
