
package com.virtualpairprogrammers.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.virtualpairprogrammers.crm.domain.Action;
import com.virtualpairprogrammers.crm.domain.Call;


/**
 * <p>Java class for recordCall complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recordCall">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://virtualpairprogrammers.com/crm/domain}call" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://virtualpairprogrammers.com/crm/domain}action" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recordCall", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class RecordCall {

    protected String arg0;
    protected Call arg1;
    protected List<Action> arg2;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg0(String value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     * @return
     *     possible object is
     *     {@link Call }
     *     
     */
    public Call getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Call }
     *     
     */
    public void setArg1(Call value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Action }
     * 
     * 
     */
    public List<Action> getArg2() {
        if (arg2 == null) {
            arg2 = new ArrayList<Action>();
        }
        return this.arg2;
    }

}