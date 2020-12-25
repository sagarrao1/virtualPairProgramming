import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.virtualpairprogrammers.webservices.Customer;
import com.virtualpairprogrammers.webservices.CustomerEndpoint;
import com.virtualpairprogrammers.webservices.CustomerNotFoundException_Exception;
import com.virtualpairprogrammers.webservices.CustomerService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CustomerEndpoint service = new CustomerService().getCustomerEndpointPort();
		
//		using spring
		
		try (ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("client.xml")) {
			CustomerEndpoint service = factory.getBean(CustomerEndpoint.class);
			
//		try {
//			Customer customer = service.getFullCustomerDetail("100029");
//			System.out.println(customer.getCompanyName());
//			
//		} catch (CustomerNotFoundException_Exception e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			System.out.println("Customer not foun");
//		}

			
			List<Customer> customers = service.getAllCustomers();
			for (Customer customer : customers) {
				System.out.println(customer.getCustomerId());
			}
		}
		
	}

}
