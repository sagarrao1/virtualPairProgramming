
package com.virtualpairprogrammers.webservices;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.virtualpairprogrammers.crm.domain.Call;
import com.virtualpairprogrammers.crm.domain.Customer;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CustomerService", targetNamespace = "http://webservices.virtualpairprogrammers.com/")
@XmlSeeAlso({
    com.virtualpairprogrammers.crm.domain.ObjectFactory.class,
    com.virtualpairprogrammers.webservices.ObjectFactory.class
})
public interface CustomerService {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "newCustomer", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.NewCustomer")
    @ResponseWrapper(localName = "newCustomerResponse", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.NewCustomerResponse")
    @javax.xml.ws.Action(input = "http://webservices.virtualpairprogrammers.com/CustomerService/newCustomerRequest", output = "http://webservices.virtualpairprogrammers.com/CustomerService/newCustomerResponse")
    public void newCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        Customer arg0);

    /**
     * 
     * @return
     *     returns java.util.List<com.virtualpairprogrammers.crm.domain.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllCustomers", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.GetAllCustomers")
    @ResponseWrapper(localName = "getAllCustomersResponse", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.GetAllCustomersResponse")
    @javax.xml.ws.Action(input = "http://webservices.virtualpairprogrammers.com/CustomerService/getAllCustomersRequest", output = "http://webservices.virtualpairprogrammers.com/CustomerService/getAllCustomersResponse")
    public List<Customer> getAllCustomers();

    /**
     * 
     * @param arg0
     * @throws CustomerNotFoundException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteCustomer", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.DeleteCustomer")
    @ResponseWrapper(localName = "deleteCustomerResponse", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.DeleteCustomerResponse")
    @javax.xml.ws.Action(input = "http://webservices.virtualpairprogrammers.com/CustomerService/deleteCustomerRequest", output = "http://webservices.virtualpairprogrammers.com/CustomerService/deleteCustomerResponse", fault = {
        @FaultAction(className = CustomerNotFoundException_Exception.class, value = "http://webservices.virtualpairprogrammers.com/CustomerService/deleteCustomer/Fault/CustomerNotFoundException")
    })
    public void deleteCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws CustomerNotFoundException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns com.virtualpairprogrammers.crm.domain.Customer
     * @throws CustomerNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findCustomerById", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.FindCustomerById")
    @ResponseWrapper(localName = "findCustomerByIdResponse", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.FindCustomerByIdResponse")
    @javax.xml.ws.Action(input = "http://webservices.virtualpairprogrammers.com/CustomerService/findCustomerByIdRequest", output = "http://webservices.virtualpairprogrammers.com/CustomerService/findCustomerByIdResponse", fault = {
        @FaultAction(className = CustomerNotFoundException_Exception.class, value = "http://webservices.virtualpairprogrammers.com/CustomerService/findCustomerById/Fault/CustomerNotFoundException")
    })
    public Customer findCustomerById(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws CustomerNotFoundException_Exception
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws CustomerNotFoundException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "recordCall", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.RecordCall")
    @ResponseWrapper(localName = "recordCallResponse", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.RecordCallResponse")
    @javax.xml.ws.Action(input = "http://webservices.virtualpairprogrammers.com/CustomerService/recordCallRequest", output = "http://webservices.virtualpairprogrammers.com/CustomerService/recordCallResponse", fault = {
        @FaultAction(className = CustomerNotFoundException_Exception.class, value = "http://webservices.virtualpairprogrammers.com/CustomerService/recordCall/Fault/CustomerNotFoundException")
    })
    public void recordCall(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Call arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        List<com.virtualpairprogrammers.crm.domain.Action> arg2)
        throws CustomerNotFoundException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns com.virtualpairprogrammers.crm.domain.Customer
     * @throws CustomerNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getFullCustomerDetail", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.GetFullCustomerDetail")
    @ResponseWrapper(localName = "getFullCustomerDetailResponse", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.GetFullCustomerDetailResponse")
    @javax.xml.ws.Action(input = "http://webservices.virtualpairprogrammers.com/CustomerService/getFullCustomerDetailRequest", output = "http://webservices.virtualpairprogrammers.com/CustomerService/getFullCustomerDetailResponse", fault = {
        @FaultAction(className = CustomerNotFoundException_Exception.class, value = "http://webservices.virtualpairprogrammers.com/CustomerService/getFullCustomerDetail/Fault/CustomerNotFoundException")
    })
    public Customer getFullCustomerDetail(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws CustomerNotFoundException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.virtualpairprogrammers.crm.domain.Action>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllIncompleteActions", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.GetAllIncompleteActions")
    @ResponseWrapper(localName = "getAllIncompleteActionsResponse", targetNamespace = "http://webservices.virtualpairprogrammers.com/", className = "com.virtualpairprogrammers.webservices.GetAllIncompleteActionsResponse")
    @javax.xml.ws.Action(input = "http://webservices.virtualpairprogrammers.com/CustomerService/getAllIncompleteActionsRequest", output = "http://webservices.virtualpairprogrammers.com/CustomerService/getAllIncompleteActionsResponse")
    public List<com.virtualpairprogrammers.crm.domain.Action> getAllIncompleteActions(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}