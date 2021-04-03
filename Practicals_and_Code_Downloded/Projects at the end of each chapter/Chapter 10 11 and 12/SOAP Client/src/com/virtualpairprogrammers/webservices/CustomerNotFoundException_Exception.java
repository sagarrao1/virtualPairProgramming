
package com.virtualpairprogrammers.webservices;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "CustomerNotFoundException", targetNamespace = "http://webservices.virtualpairprogrammers.com/")
public class CustomerNotFoundException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private CustomerNotFoundException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public CustomerNotFoundException_Exception(String message, CustomerNotFoundException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public CustomerNotFoundException_Exception(String message, CustomerNotFoundException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.virtualpairprogrammers.webservices.CustomerNotFoundException
     */
    public CustomerNotFoundException getFaultInfo() {
        return faultInfo;
    }

}