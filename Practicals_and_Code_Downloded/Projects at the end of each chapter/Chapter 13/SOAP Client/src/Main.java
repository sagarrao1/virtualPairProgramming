import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.virtualpairprogrammers.crm.domain.Action;
import com.virtualpairprogrammers.crm.domain.Call;
import com.virtualpairprogrammers.crm.domain.Customer;
import com.virtualpairprogrammers.webservices.CustomerNotFoundException_Exception;
import com.virtualpairprogrammers.webservices.CustomerService;



public class Main {

	public static void main(String[] args) throws DatatypeConfigurationException 
	{
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("client.xml");

		CustomerService service = factory.getBean(CustomerService.class);
	
		try 
		{
			service.deleteCustomer("23897329872982");
		} 
		catch (CustomerNotFoundException_Exception e) {
			// no action needed.
		}
		
		Customer newCustomer = new Customer();
		newCustomer.setCompanyName("VirtualPairProgrammers");
		newCustomer.setNotes("My company");
		newCustomer.setCustomerId("23897329872982");
		service.newCustomer(newCustomer);
		
		List<Customer> allCustomers = service.getAllCustomers();
		for (Customer next: allCustomers)
		{
			System.out.println(next.getCustomerId());
		}
		
		Call call = new Call();
		call.setNotes("Larry from Google called");
		GregorianCalendar c = new GregorianCalendar();		
		XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		call.setTimeAndDate(now);
		
		Action action = new Action();
		action.setDetails("Call Larry back on the 20th");
		action.setOwningUser("rac");
		
		GregorianCalendar future = new GregorianCalendar(2016, 0, 0);
		XMLGregorianCalendar futureXml = DatatypeFactory.newInstance().newXMLGregorianCalendar(future);		
		action.setRequiredBy(futureXml);
		
		List<Action> allActions = new ArrayList<Action>();
		allActions.add(action);
		
		
		try 
		{
			service.recordCall("23897329872982", call , allActions);
			Customer theCustomer = service.getFullCustomerDetail("23897329872982");
			System.out.println("This customer has " + theCustomer.getCalls().size() + " calls");
			for (Call next : theCustomer.getCalls())
			{
				System.out.println(next.getNotes() + " at " + next.getTimeAndDate());
			}
		} 
		catch (CustomerNotFoundException_Exception e) 
		{
			System.out.println("Sorry, the customer wasn't found....");
		}
		
		List<Action> actionsForRac = service.getAllIncompleteActions("rac");
		System.out.println("Actions for rac:");
		for (Action nextAction: actionsForRac)
		{
			System.out.println(nextAction.getDetails() + " due by " + nextAction.getRequiredBy());
		}
		
		
	}

}
