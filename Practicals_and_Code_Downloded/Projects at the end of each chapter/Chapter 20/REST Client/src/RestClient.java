import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
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

		HttpEntity requestEntity = new HttpEntity(headers);

		try
		{
			HttpEntity response = template.exchange("http://localhost:8080/mywebapp/customer/100029dfskjhskjdhkdsjfh",
					HttpMethod.GET, requestEntity, String.class);
			System.out.println("Successfully found customer " + response.getBody());
		}
		catch (ResourceNotFoundException e) // definitely a 404
		{
			System.out.println("Sorry, the customer was not found ");
			System.out.println("The message returned back was " + e.getErrorObject().getMessage());
		}

	}
}
