import com.virtualpair.services.Employee;
import com.virtualpair.services.EmployeeServiceImpl;
import com.virtualpair.services.EmployeeServiceImplService;

public class Main {

	public static void main(String[] args) {
		// call web service
		// URL: http://localhost:4848/soap/TestServer?wsdl
		EmployeeServiceImpl webservice = new EmployeeServiceImplService().getEmployeeServiceImplPort();
		Employee employee = webservice.getEmployeeById("1");
		
		System.out.println(employee.getName());
	}

}
