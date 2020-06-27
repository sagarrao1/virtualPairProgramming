import com.virtualpairprogrammers.crm.CustomerService;
import com.virtualpairprogrammers.crm.CustomerServiceService;
import com.virtualpairprogrammers.crm.GetCustomerByIdRequest;
import com.virtualpairprogrammers.crm.GetCustomerByIdResponse;


public class MainApp {

	public static void main(String[] args) {
		
		CustomerService service= new CustomerServiceService().getCustomerServiceSoap11();
		
		GetCustomerByIdRequest getCustomerByIdRequest =  new GetCustomerByIdRequest();
		getCustomerByIdRequest.setId("100029");	
		
		GetCustomerByIdResponse response = service.getCustomerById(getCustomerByIdRequest);
		System.out.println(response.getCustomer().getCompanyName());
		
	}

}
