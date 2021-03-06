//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.28 at 12:36:41 PM IST 
//


package com.virtualpairprogrammers.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.virtualpairprogrammers.domain.Customer;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customer" type="{http://www.virtualpairprogrammers.com/crm}customer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "customer"
})
@XmlRootElement(name = "getCustomerByIdResponse")
public class GetCustomerByIdResponse {

    @XmlElement(required = true)
    protected CustomerXML customer;

    public GetCustomerByIdResponse() {
    	
    }
    
    public GetCustomerByIdResponse(Customer customerDomain) {
    	this.customer=  new CustomerXML();
    	customer.setCustomerId(customerDomain.getCustomerId());
    	customer.setCompanyName(customerDomain.getCompanyName());
    	customer.setEmail(customerDomain.getEmail());
    	customer.setNotes(customerDomain.getNotes());
    	customer.setPhone(customerDomain.getTelephone());
	}

	/**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerXML }
     *     
     */
    public CustomerXML getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerXML }
     *     
     */
    public void setCustomer(CustomerXML value) {
        this.customer = value;
    }

}
