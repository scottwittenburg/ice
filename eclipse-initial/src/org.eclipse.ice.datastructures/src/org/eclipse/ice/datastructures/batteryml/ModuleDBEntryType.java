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
 * 
 * 	Main instance of module type. Contains all the hierarchical
 * 	modules of the module instance.
 *       
 * 
 * <p>Java class for ModuleDBEntryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModuleDBEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{BatteryML:2.0}ModuleAbstractType">
 *       &lt;sequence>
 *         &lt;element name="Cell" type="{BatteryML:2.0}CellRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}CellSet" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="Model" type="{BatteryML:2.0}ModelType" minOccurs="0"/>
 *           &lt;element name="ModelDefinition" type="{BatteryML:2.0}DefinitionType" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element ref="{BatteryML:2.0}Parameters" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{BatteryML:2.0}ElementInfoGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{BatteryML:2.0}ShortTokenType" />
 *       &lt;attribute name="id" use="required" type="{BatteryML:2.0}ShortNameType" />
 *       &lt;attribute name="type" type="{BatteryML:2.0}ModuleTypeType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModuleDBEntryType")
public class ModuleDBEntryType
    extends ModuleAbstractType
{


}
