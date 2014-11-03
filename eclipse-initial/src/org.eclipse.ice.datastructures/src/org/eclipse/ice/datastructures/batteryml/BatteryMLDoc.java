//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.22 at 11:59:10 AM EDT 
//


package org.eclipse.ice.datastructures.batteryml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all minOccurs="0">
 *         &lt;element ref="{BatteryML:2.0}BuildingBlockDB" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}CellSandwichDB" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}CellDB" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}ModuleDB" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}PackDB" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}PartDB" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}DeviceDB" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}ModelDB" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}UnitsDB" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}SimulationDB" minOccurs="0"/>
 *         &lt;element name="Description" type="{BatteryML:2.0}StringType" minOccurs="0"/>
 *         &lt;element name="Comment" type="{BatteryML:2.0}StringType" minOccurs="0"/>
 *         &lt;element name="Documentation" type="{BatteryML:2.0}EmbeddedXMLType" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attGroup ref="{BatteryML:2.0}OptionalNameGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "BatteryML_Doc")
public class BatteryMLDoc {

    @XmlElement(name = "BuildingBlockDB")
    protected BuildingBlockDB buildingBlockDB;
    @XmlElement(name = "CellSandwichDB")
    protected CellSandwichDB cellSandwichDB;
    @XmlElement(name = "CellDB")
    protected CellDB cellDB;
    @XmlElement(name = "ModuleDB")
    protected ModuleDB moduleDB;
    @XmlElement(name = "PackDB")
    protected PackDB packDB;
    @XmlElement(name = "PartDB")
    protected PartDB partDB;
    @XmlElement(name = "DeviceDB")
    protected DeviceDB deviceDB;
    @XmlElement(name = "ModelDB")
    protected ModelDB modelDB;
    @XmlElement(name = "UnitsDB")
    protected UnitsDB unitsDB;
    @XmlElement(name = "SimulationDB")
    protected SimulationDB simulationDB;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Comment")
    protected String comment;
    @XmlElement(name = "Documentation")
    protected String documentation;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String name;

    /**
     * Gets the value of the buildingBlockDB property.
     * 
     * @return
     *     possible object is
     *     {@link BuildingBlockDB }
     *     
     */
    public BuildingBlockDB getBuildingBlockDB() {
        return buildingBlockDB;
    }

    /**
     * Sets the value of the buildingBlockDB property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuildingBlockDB }
     *     
     */
    public void setBuildingBlockDB(BuildingBlockDB value) {
        this.buildingBlockDB = value;
    }

    /**
     * Gets the value of the cellSandwichDB property.
     * 
     * @return
     *     possible object is
     *     {@link CellSandwichDB }
     *     
     */
    public CellSandwichDB getCellSandwichDB() {
        return cellSandwichDB;
    }

    /**
     * Sets the value of the cellSandwichDB property.
     * 
     * @param value
     *     allowed object is
     *     {@link CellSandwichDB }
     *     
     */
    public void setCellSandwichDB(CellSandwichDB value) {
        this.cellSandwichDB = value;
    }

    /**
     * Gets the value of the cellDB property.
     * 
     * @return
     *     possible object is
     *     {@link CellDB }
     *     
     */
    public CellDB getCellDB() {
        return cellDB;
    }

    /**
     * Sets the value of the cellDB property.
     * 
     * @param value
     *     allowed object is
     *     {@link CellDB }
     *     
     */
    public void setCellDB(CellDB value) {
        this.cellDB = value;
    }

    /**
     * Gets the value of the moduleDB property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleDB }
     *     
     */
    public ModuleDB getModuleDB() {
        return moduleDB;
    }

    /**
     * Sets the value of the moduleDB property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleDB }
     *     
     */
    public void setModuleDB(ModuleDB value) {
        this.moduleDB = value;
    }

    /**
     * Gets the value of the packDB property.
     * 
     * @return
     *     possible object is
     *     {@link PackDB }
     *     
     */
    public PackDB getPackDB() {
        return packDB;
    }

    /**
     * Sets the value of the packDB property.
     * 
     * @param value
     *     allowed object is
     *     {@link PackDB }
     *     
     */
    public void setPackDB(PackDB value) {
        this.packDB = value;
    }

    /**
     * Gets the value of the partDB property.
     * 
     * @return
     *     possible object is
     *     {@link PartDB }
     *     
     */
    public PartDB getPartDB() {
        return partDB;
    }

    /**
     * Sets the value of the partDB property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartDB }
     *     
     */
    public void setPartDB(PartDB value) {
        this.partDB = value;
    }

    /**
     * Gets the value of the deviceDB property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceDB }
     *     
     */
    public DeviceDB getDeviceDB() {
        return deviceDB;
    }

    /**
     * Sets the value of the deviceDB property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceDB }
     *     
     */
    public void setDeviceDB(DeviceDB value) {
        this.deviceDB = value;
    }

    /**
     * Gets the value of the modelDB property.
     * 
     * @return
     *     possible object is
     *     {@link ModelDB }
     *     
     */
    public ModelDB getModelDB() {
        return modelDB;
    }

    /**
     * Sets the value of the modelDB property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelDB }
     *     
     */
    public void setModelDB(ModelDB value) {
        this.modelDB = value;
    }

    /**
     * Gets the value of the unitsDB property.
     * 
     * @return
     *     possible object is
     *     {@link UnitsDB }
     *     
     */
    public UnitsDB getUnitsDB() {
        return unitsDB;
    }

    /**
     * Sets the value of the unitsDB property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitsDB }
     *     
     */
    public void setUnitsDB(UnitsDB value) {
        this.unitsDB = value;
    }

    /**
     * Gets the value of the simulationDB property.
     * 
     * @return
     *     possible object is
     *     {@link SimulationDB }
     *     
     */
    public SimulationDB getSimulationDB() {
        return simulationDB;
    }

    /**
     * Sets the value of the simulationDB property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimulationDB }
     *     
     */
    public void setSimulationDB(SimulationDB value) {
        this.simulationDB = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the documentation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentation() {
        return documentation;
    }

    /**
     * Sets the value of the documentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentation(String value) {
        this.documentation = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
