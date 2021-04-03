import java.io.IOException;

import org.springframework.web.client.RestTemplate;


public class RestClient 
{
	public static void main(String[] args) throws IOException
	{
		RestTemplate template = new RestTemplate();
		String response = template.getForObject("http://localhost:8080/mywebapp/customer/100029", String.class);
			
		System.out.println(response);
		
		CustomerClientVersion customer = template.getForObject("http://localhost:8080/mywebapp/customer/100029", CustomerClientVersion.class);
		
		System.out.println("Customer: " +customer.getCustomerId());		
	}
}
