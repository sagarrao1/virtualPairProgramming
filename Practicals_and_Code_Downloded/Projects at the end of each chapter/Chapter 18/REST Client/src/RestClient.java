import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


public class RestClient 
{
	public static void main(String[] args) throws IOException
	{
		RestTemplate template = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.IMAGE_JPEG);
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);		
		headers.setAccept(acceptableMediaTypes);
		
		HttpEntity requestEntity = new HttpEntity(headers);
		
		HttpEntity response = template.exchange("http://localhost:8080/mywebapp/customer/100029",
											HttpMethod.GET, requestEntity, String.class);
			
		System.out.println(response.getBody());
				
		CustomerClientVersion customer = template.getForObject("http://localhost:8080/mywebapp/customer/100029", CustomerClientVersion.class);		
		System.out.println("Customer: " +customer.getCustomerId());
				
	}
}
