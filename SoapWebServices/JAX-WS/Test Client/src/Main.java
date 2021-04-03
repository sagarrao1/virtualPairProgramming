import com.employemgmt.service.Employee;
import com.employemgmt.service.EmployeeServiceImpl;
import com.employemgmt.service.EmployeeServiceImplService;

public class Main {

	public static void main(String[] args) {
		// call Test server soap web service
		
		//http://localhost:8080/any/thing/you/like/employeeService?wsdl
		
		EmployeeServiceImpl webservice = new EmployeeServiceImplService().getEmployeeServiceImplPort();

		Employee employee = webservice.getEmployeeById("1");
		
		System.out.println(employee.getName());
		
	}

}
