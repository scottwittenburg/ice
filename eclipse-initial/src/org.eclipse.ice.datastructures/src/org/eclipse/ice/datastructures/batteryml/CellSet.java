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
 *       &lt;sequence>
 *         &lt;element name="Cell" type="{BatteryML:2.0}CellRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="Model" type="{BatteryML:2.0}ModelType" minOccurs="0"/>
 *           &lt;element name="ModelDefinition" type="{BatteryML:2.0}DefinitionType" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element ref="{BatteryML:2.0}Parameters" minOccurs="0"/>
 *         &lt;group ref="{BatteryML:2.0}ElementInfoGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{BatteryML:2.0}ShortTokenType" />
 *       &lt;attribute name="id" use="required" type="{BatteryML:2.0}ShortNameType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cell",
    "model",
    "modelDefinition",
    "parameters",
    "description",
    "comment",
    "documentation"
})
@XmlRootElement(name = "CellSet")
public class CellSet {

    @XmlElement(name = "Cell")
    protected List<CellRefType> cell;
    @XmlElement(name = "Model")
    protected ModelType model;
    @XmlElement(name = "ModelDefinition")
    protected DefinitionType modelDefinition;
    @XmlElement(name = "Parameters")
    protected Parameters parameters;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Comment")
    protected String comment;
    @XmlElement(name = "Documentation")
    protected String documentation;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String name;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;

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

}
