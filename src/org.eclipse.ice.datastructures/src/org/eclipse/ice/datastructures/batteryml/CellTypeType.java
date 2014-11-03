//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.22 at 11:59:10 AM EDT 
//


package org.eclipse.ice.datastructures.batteryml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CellTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CellTypeType">
 *   &lt;restriction base="{BatteryML:2.0}ShortTokenType">
 *     &lt;enumeration value="Cylindrical"/>
 *     &lt;enumeration value="Prismatic"/>
 *     &lt;enumeration value="Stacked"/>
 *     &lt;enumeration value="CellOther"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CellTypeType")
@XmlEnum
public enum CellTypeType {


    /**
     * Dual foil model.
     * 
     */
    @XmlEnumValue("Cylindrical")
    CYLINDRICAL("Cylindrical"),

    /**
     * RC.
     * 
     */
    @XmlEnumValue("Prismatic")
    PRISMATIC("Prismatic"),

    /**
     * NTG.
     * 
     */
    @XmlEnumValue("Stacked")
    STACKED("Stacked"),

    /**
     * Other cell type.
     * 
     */
    @XmlEnumValue("CellOther")
    CELL_OTHER("CellOther");
    private final String value;

    CellTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CellTypeType fromValue(String v) {
        for (CellTypeType c: CellTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}