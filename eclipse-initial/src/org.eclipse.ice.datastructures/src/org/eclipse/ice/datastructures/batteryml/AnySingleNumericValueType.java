//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.22 at 11:59:10 AM EDT 
//


package org.eclipse.ice.datastructures.batteryml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Elements for numeric single values.
 * 
 * <p>Java class for AnySingleNumericValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnySingleNumericValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{BatteryML:2.0}AnyNumericValueType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{BatteryML:2.0}Int32"/>
 *           &lt;element ref="{BatteryML:2.0}Int64"/>
 *           &lt;element ref="{BatteryML:2.0}PositiveInt"/>
 *           &lt;element ref="{BatteryML:2.0}NonNegativeInt"/>
 *           &lt;element ref="{BatteryML:2.0}NonNegativeInt32"/>
 *           &lt;element ref="{BatteryML:2.0}NonNegativeInt64"/>
 *           &lt;element ref="{BatteryML:2.0}Float32"/>
 *           &lt;element ref="{BatteryML:2.0}Float64"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnySingleNumericValueType")
public class AnySingleNumericValueType
    extends AnyNumericValueType
{


}
