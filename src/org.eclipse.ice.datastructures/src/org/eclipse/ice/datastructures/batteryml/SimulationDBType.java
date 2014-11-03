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
 * 	Main instance of battery simulation type. Contains all the hierarchical
 * 	components of the simulation instance.
 *       
 * 
 * <p>Java class for SimulationDBType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimulationDBType">
 *   &lt;complexContent>
 *     &lt;restriction base="{BatteryML:2.0}SimulationAbstractType">
 *       &lt;sequence>
 *         &lt;element name="Control" type="{BatteryML:2.0}CategoryNoIdType" minOccurs="0"/>
 *         &lt;element name="Mesh" type="{BatteryML:2.0}CategoryNoIdType" minOccurs="0"/>
 *         &lt;element name="Operating_Conditions" type="{BatteryML:2.0}CategoryNoIdType" minOccurs="0"/>
 *         &lt;element name="Initial_Conditions" type="{BatteryML:2.0}CategoryNoIdType" minOccurs="0"/>
 *         &lt;element name="Scenario" type="{BatteryML:2.0}CategoryNoIdType" minOccurs="0"/>
 *         &lt;element name="Solution_Strategy" type="{BatteryML:2.0}CategoryNoIdType" minOccurs="0"/>
 *         &lt;element name="Device" type="{BatteryML:2.0}DeviceRefType" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}Parameters" minOccurs="0"/>
 *         &lt;group ref="{BatteryML:2.0}ElementInfoGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{BatteryML:2.0}ShortTokenType" />
 *       &lt;attribute name="type" type="{BatteryML:2.0}ShortStringType" />
 *       &lt;attribute name="id" use="required" type="{BatteryML:2.0}ShortNameType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimulationDBType")
public class SimulationDBType
    extends SimulationAbstractType
{


}