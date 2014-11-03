//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.22 at 11:59:10 AM EDT 
//


package org.eclipse.ice.datastructures.batteryml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3c.dom.Element;


/**
 * 
 * 	Main instance of device type. Contains all the hierarchical
 * 	devices of the device instance.
 *       
 * 
 * <p>Java class for DeviceAbstractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceAbstractType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Part" type="{BatteryML:2.0}PartRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}PartSet" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Pack" type="{BatteryML:2.0}PackRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}PackSet" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Module" type="{BatteryML:2.0}ModuleRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}ModuleSet" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Cell" type="{BatteryML:2.0}CellRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}CellSet" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CellSandwich" type="{BatteryML:2.0}CellSandwichRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{BatteryML:2.0}CellSandwichSet" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="Model" type="{BatteryML:2.0}ModelType" minOccurs="0"/>
 *           &lt;element name="ModelDefinition" type="{BatteryML:2.0}DefinitionType" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element ref="{BatteryML:2.0}Parameters" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{BatteryML:2.0}ElementInfoGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{BatteryML:2.0}ShortTokenType" />
 *       &lt;attribute name="id" type="{BatteryML:2.0}ShortNameType" />
 *       &lt;attribute name="type" type="{BatteryML:2.0}DeviceTypeType" />
 *       &lt;attribute name="idref" type="{BatteryML:2.0}ShortNameType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceAbstractType", propOrder = {
    "part",
    "partSet",
    "pack",
    "packSet",
    "module",
    "moduleSet",
    "cell",
    "cellSet",
    "cellSandwich",
    "cellSandwichSet",
    "model",
    "modelDefinition",
    "parameters",
    "any",
    "description",
    "comment",
    "documentation"
})
@XmlSeeAlso({
    DeviceDBEntryType.class,
    DeviceRefType.class
})
public abstract class DeviceAbstractType {

    @XmlElement(name = "Part")
    protected List<PartRefType> part;
    @XmlElement(name = "PartSet")
    protected List<PartSet> partSet;
    @XmlElement(name = "Pack")
    protected List<PackRefType> pack;
    @XmlElement(name = "PackSet")
    protected List<PackSet> packSet;
    @XmlElement(name = "Module")
    protected List<ModuleRefType> module;
    @XmlElement(name = "ModuleSet")
    protected List<ModuleSet> moduleSet;
    @XmlElement(name = "Cell")
    protected List<CellRefType> cell;
    @XmlElement(name = "CellSet")
    protected List<CellSet> cellSet;
    @XmlElement(name = "CellSandwich")
    protected List<CellSandwichRefType> cellSandwich;
    @XmlElement(name = "CellSandwichSet")
    protected List<CellSandwichSet> cellSandwichSet;
    @XmlElement(name = "Model")
    protected ModelType model;
    @XmlElement(name = "ModelDefinition")
    protected DefinitionType modelDefinition;
    @XmlElement(name = "Parameters")
    protected Parameters parameters;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Comment")
    protected String comment;
    @XmlElement(name = "Documentation")
    protected String documentation;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String name;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String idref;

    /**
     * Gets the value of the part property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the part property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartRefType }
     * 
     * 
     */
    public List<PartRefType> getPart() {
        if (part == null) {
            part = new ArrayList<PartRefType>();
        }
        return this.part;
    }

    /**
     * Gets the value of the partSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartSet }
     * 
     * 
     */
    public List<PartSet> getPartSet() {
        if (partSet == null) {
            partSet = new ArrayList<PartSet>();
        }
        return this.partSet;
    }

    /**
     * Gets the value of the pack property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pack property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PackRefType }
     * 
     * 
     */
    public List<PackRefType> getPack() {
        if (pack == null) {
            pack = new ArrayList<PackRefType>();
        }
        return this.pack;
    }

    /**
     * Gets the value of the packSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the packSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PackSet }
     * 
     * 
     */
    public List<PackSet> getPackSet() {
        if (packSet == null) {
            packSet = new ArrayList<PackSet>();
        }
        return this.packSet;
    }

    /**
     * Gets the value of the module property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the module property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModuleRefType }
     * 
     * 
     */
    public List<ModuleRefType> getModule() {
        if (module == null) {
            module = new ArrayList<ModuleRefType>();
        }
        return this.module;
    }

    /**
     * Gets the value of the moduleSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the moduleSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModuleSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModuleSet }
     * 
     * 
     */
    public List<ModuleSet> getModuleSet() {
        if (moduleSet == null) {
            moduleSet = new ArrayList<ModuleSet>();
        }
        return this.moduleSet;
    }

    /**
     * Gets the value of the cell property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cell property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCell().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CellRefType }
     * 
     * 
     */
    public List<CellRefType> getCell() {
        if (cell == null) {
            cell = new ArrayList<CellRefType>();
        }
        return this.cell;
    }

    /**
     * Gets the value of the cellSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cellSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCellSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CellSet }
     * 
     * 
     */
    public List<CellSet> getCellSet() {
        if (cellSet == null) {
            cellSet = new ArrayList<CellSet>();
        }
        return this.cellSet;
    }

    /**
     * Gets the value of the cellSandwich property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cellSandwich property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCellSandwich().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CellSandwichRefType }
     * 
     * 
     */
    public List<CellSandwichRefType> getCellSandwich() {
        if (cellSandwich == null) {
            cellSandwich = new ArrayList<CellSandwichRefType>();
        }
        return this.cellSandwich;
    }

    /**
     * Gets the value of the cellSandwichSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cellSandwichSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCellSandwichSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CellSandwichSet }
     * 
     * 
     */
    public List<CellSandwichSet> getCellSandwichSet() {
        if (cellSandwichSet == null) {
            cellSandwichSet = new ArrayList<CellSandwichSet>();
        }
        return this.cellSandwichSet;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link ModelType }
     *     
     */
    public ModelType getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelType }
     *     
     */
    public void setModel(ModelType value) {
        this.model = value;
    }

    /**
     * Gets the value of the modelDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link DefinitionType }
     *     
     */
    public DefinitionType getModelDefinition() {
        return modelDefinition;
    }

    /**
     * Sets the value of the modelDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefinitionType }
     *     
     */
    public void setModelDefinition(DefinitionType value) {
        this.modelDefinition = value;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link Parameters }
     *     
     */
    public Parameters getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parameters }
     *     
     */
    public void setParameters(Parameters value) {
        this.parameters = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
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

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the idref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdref() {
        return idref;
    }

    /**
     * Sets the value of the idref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdref(String value) {
        this.idref = value;
    }

}
