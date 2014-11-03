//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.22 at 11:59:10 AM EDT 
//


package oasis.names.tc.unitsml.schema.xsd.unitsmlschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Type of the quantity represented by a counted item, e.g., electron
 * 
 * <p>Java class for ItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema-1.0}powerRational"/>
 *       &lt;attribute name="itemURL" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="itemSymbol" type="{http://www.w3.org/2001/XMLSchema}token" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemType")
public class ItemType {

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String itemURL;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String itemSymbol;
    @XmlAttribute
    protected Byte powerNumerator;
    @XmlAttribute
    protected Byte powerDenominator;

    /**
     * Gets the value of the itemURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemURL() {
        return itemURL;
    }

    /**
     * Sets the value of the itemURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemURL(String value) {
        this.itemURL = value;
    }

    /**
     * Gets the value of the itemSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemSymbol() {
        return itemSymbol;
    }

    /**
     * Sets the value of the itemSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemSymbol(String value) {
        this.itemSymbol = value;
    }

    /**
     * Gets the value of the powerNumerator property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public byte getPowerNumerator() {
        if (powerNumerator == null) {
            return ((byte) 1);
        } else {
            return powerNumerator;
        }
    }

    /**
     * Sets the value of the powerNumerator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setPowerNumerator(Byte value) {
        this.powerNumerator = value;
    }

    /**
     * Gets the value of the powerDenominator property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public byte getPowerDenominator() {
        if (powerDenominator == null) {
            return ((byte) 1);
        } else {
            return powerDenominator;
        }
    }

    /**
     * Sets the value of the powerDenominator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setPowerDenominator(Byte value) {
        this.powerDenominator = value;
    }

}
