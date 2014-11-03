/*******************************************************************************
 * Copyright (c) 2013, 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay Billings,
 *   Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson,
 *   Claire Saunders, Matthew Wang, Anna Wojtowicz
 *******************************************************************************/
package org.eclipse.ice.datastructures.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import org.junit.Test;

import org.eclipse.ice.datastructures.form.AllowedValueType;
import org.eclipse.ice.datastructures.form.Entry;
import org.eclipse.ice.datastructures.form.TimeDataComponent;

/**
 * <!-- begin-UML-doc -->
 * <p>
 * A class that tests the TimeDataComponent.
 * </p>
 * <!-- end-UML-doc -->
 * 
 * @author s4h
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TimeDataComponentTester {
	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Checks the construction operations.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkConstruction() {

		// begin-user-code

		// Local Declarations
		String defaultName = "TimeDataComponent 1";
		int defaultId = 1;
		String defaultDescription = "TimeDataComponent 1's Description";
		Entry entry1, entry2, entry3, entry4, entry5;
		TimeDataComponent timeComponent;
		int entryCount = 0;
		ArrayList<Entry> entryList = new ArrayList<Entry>();

		// Setup Entries for comparison
		entry1 = new Entry() {
			protected void setup() {
				this.setName("Enable Regular Mode");
				this.tag = "MODE";
				this.setDescription("Time loop's mode.  Can be Regular (true) or Explicit (false)");
				this.defaultValue = "True";
				this.value = this.defaultValue;
				this.allowedValues = new ArrayList<String>();
				this.allowedValues.add("True");
				this.allowedValues.add("False");
				this.allowedValueType = AllowedValueType.Discrete;
			}
		};
		entryCount++;
		entry1.setId(entryCount);
		entryList.add(entry1);

		// Entry: START
		entry2 = new Entry() {
			protected void setup() {
				this.setName("Start");
				this.tag = "START";
				this.setDescription("Time loop's start time. Can start between allowed values.");
				this.defaultValue = "0";
				this.value = this.defaultValue;
				this.allowedValues = new ArrayList<String>();
				this.allowedValues.add("0");
				this.allowedValues.add("99999999");
				this.allowedValueType = AllowedValueType.Continuous;
				this.parent = "Enable Regular Mode";
			}
		};
		entryCount++;
		entry2.setId(entryCount);
		entryList.add(entry2);

		// Entry: FINISH
		entry3 = new Entry() {
			protected void setup() {
				this.setName("Finish");
				this.tag = "FINISH";
				this.setDescription("Time loop's finish time. Can finish between allowed values.");
				this.defaultValue = "30";
				this.value = this.defaultValue;
				this.allowedValues = new ArrayList<String>();
				this.allowedValues.add("1");
				this.allowedValues.add("999999");
				this.allowedValueType = AllowedValueType.Continuous;
				this.parent = "Enable Regular Mode";
			}
		};
		entryCount++;
		entry3.setId(entryCount);
		entryList.add(entry3);

		// Entry: NSTEP
		entry4 = new Entry() {
			protected void setup() {
				this.setName("The number to step");
				this.tag = "NSTEP";
				this.setDescription("Time loop's number to step.  Can be set between allowed values.");
				this.defaultValue = "1";
				this.value = this.defaultValue;
				this.allowedValues = new ArrayList<String>();
				this.allowedValues.add("1");
				this.allowedValues.add("99999999");
				this.allowedValueType = AllowedValueType.Continuous;
				this.parent = "Enable Regular Mode";
			}
		};
		entryCount++;
		entry4.setId(entryCount);
		entryList.add(entry4);

		// Entry: VALUES
		entry5 = new Entry() {
			protected void setup() {
				this.setName("VALUES");
				this.tag = "VALUES";
				this.setDescription("Time loop's values.");
				this.defaultValue = "4.4, 3.5, 3.6, 3.7";
				this.value = this.defaultValue;
				this.allowedValueType = AllowedValueType.Undefined;
			}
		};
		entryCount++;
		entry5.setId(entryCount);
		entryList.add(entry5);

		// Create a nullary timeComponent
		timeComponent = new TimeDataComponent();
		// Check values
		assertEquals(defaultName, timeComponent.getName());
		assertEquals(defaultId, timeComponent.getId());
		assertEquals(defaultDescription, timeComponent.getDescription());
		assertTrue(entryList.equals(timeComponent.retrieveAllEntries()));

		// Create a non-nullary timeComponent - REGULAR
		timeComponent = new TimeDataComponent("REGULAR");
		// Check values
		assertEquals(defaultName, timeComponent.getName());
		assertEquals(defaultId, timeComponent.getId());
		assertEquals(defaultDescription, timeComponent.getDescription());
		assertTrue(entryList.equals(timeComponent.retrieveAllEntries()));

		// Create a non-nullary timeComponent - badValue
		timeComponent = new TimeDataComponent("1@#BADVALUE");
		// Check values - defaults
		assertEquals(defaultName, timeComponent.getName());
		assertEquals(defaultId, timeComponent.getId());
		assertEquals(defaultDescription, timeComponent.getDescription());
		assertTrue(entryList.equals(timeComponent.retrieveAllEntries()));

		// Create a non-nullary timeComponent - null
		timeComponent = new TimeDataComponent(null);
		// Check values
		assertEquals(defaultName, timeComponent.getName());
		assertEquals(defaultId, timeComponent.getId());
		assertEquals(defaultDescription, timeComponent.getDescription());
		assertTrue(entryList.equals(timeComponent.retrieveAllEntries()));

		// Reset values here for ready state
		entry1.setValue("False");
		entry2.setReady(false);
		entry3.setReady(false);
		entry4.setReady(false);

		// Create a nullary timeComponent
		timeComponent = new TimeDataComponent("EXPLICIT");
		// Check values
		assertEquals(defaultName, timeComponent.getName());
		assertEquals(defaultId, timeComponent.getId());
		assertEquals(defaultDescription, timeComponent.getDescription());
		assertTrue(entryList.equals(timeComponent.retrieveAllEntries())); // Set
																			// to
																			// the
																			// new
																			// entry
																			// list
																			// of
																			// ready
																			// values

		// end-user-code

	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Checks the overridden operations concerning entry manipulation on
	 * TimeDataComponent.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkEntryOperations() {

		// begin-user-code

		// Local Declarations
		int size = 5;

		// Show that certain Entry modification operations will not work as
		// intended as on DataComponent
		TimeDataComponent timeComponent = new TimeDataComponent();

		// Show that there are 5 entries
		assertEquals(size, timeComponent.retrieveAllEntries().size());

		// Try to delete, add, or otherwise modify the contents of entries on
		// TimeDataComponent numerical count

		// Add entry
		timeComponent.addEntry(new Entry());
		// Show that there are 5 entries
		assertEquals(size, timeComponent.retrieveAllEntries().size());

		// Add entry with parents
		timeComponent.addEntry(new Entry(), "Foo");
		// Show that there are 5 entries
		assertEquals(size, timeComponent.retrieveAllEntries().size());

		// Clear or delete
		timeComponent.clearEntries();
		timeComponent.deleteEntry(timeComponent.retrieveAllEntries().get(0)
				.getName());
		// Show that there are 5 entries
		assertEquals(size, timeComponent.retrieveAllEntries().size());

		// Try to retrieve entries, edit the list, and see if it changes
		// anything
		timeComponent.retrieveAllEntries().remove(0);
		// Show that there are 5 entries
		assertEquals(size, timeComponent.retrieveAllEntries().size());

		// Keep in mind you can CHANGE content ON an entry
		String nameChanged = "BobbyLEEJONES";

		timeComponent.retrieveAllEntries().get(0).setName(nameChanged);
		assertEquals(nameChanged, timeComponent.retrieveAllEntries().get(0)
				.getName());

		// end-user-code

	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Checks loading and persisting to XML.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkXMLPersistence() {

		// begin-user-code

		// Local declarations
		int id = 20110901;
		String name = "September 1st 2011";
		String description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";

		// Create the DataComponent
		TimeDataComponent dataComponent = new TimeDataComponent();
		TimeDataComponent loadDataComponent = new TimeDataComponent();

		// Set the id, name and description
		dataComponent.setId(id);
		dataComponent.setDescription(description);
		dataComponent.setName(name);

		// Demonstrate a basic "write" to file. Should not fail

		// persist to an output stream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		dataComponent.persistToXML(outputStream);

		// Initialize object and pass inputStream to read()
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());

		// create a new instance of a different variable to compare
		loadDataComponent = new TimeDataComponent();

		// load into TimeDataComponent();
		loadDataComponent.loadFromXML(inputStream);

		// check contents
		assertTrue(dataComponent.equals(loadDataComponent));

		// The next following tests demonstrate behavior for when you pass null
		// args for read()

		// test for read - null args
		loadDataComponent.loadFromXML(null);

		// check contents - nothing has changed the previously set data
		assertTrue(dataComponent.equals(loadDataComponent));

		// args for write() - null args
		outputStream = null;
		loadDataComponent.persistToXML(outputStream);

		// checkContents - nothing has changed
		assertNull(outputStream);

		// end-user-code

	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Checks copying and clone routines.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkCopying() {

		// begin-user-code

		// Local declarations
		int id = 20110901;
		String name = "September 1st 2011";
		String description = "The 1st day of the ninth month in the year of "
				+ "our Lord 2011";
		TimeDataComponent cloneData = new TimeDataComponent();
		TimeDataComponent copyData = new TimeDataComponent();
		TestComponentListener listener = new TestComponentListener();

		// Create the TimeDataComponent
		TimeDataComponent dataComponent = new TimeDataComponent();

		// Set the id, name and description and listener
		dataComponent.setId(id);
		dataComponent.setDescription(description);
		dataComponent.setName(name);
		dataComponent.register(listener);

		// Test to show valid usage of clone

		// Run clone operation
		cloneData = (TimeDataComponent) dataComponent.clone();

		// check Contents
		assertTrue(dataComponent.equals(cloneData));

		// Test to show valid usage of copy
		// Use dataComponent from above

		// run copy operation
		copyData.copy(dataComponent);

		// check Contents
		assertTrue(dataComponent.equals(copyData));

		/*----- Test to show an invalid use of copy - null args -----*/

		// Call copy with null, which should not change anything
		copyData.copy(null);

		// check contents, nothing has changed1's
		// check Contents
		assertTrue(dataComponent.equals(copyData));

		return;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * An operation that checks the equality operations.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkEquality() {

		// begin-user-code

		// Create TimeDataComponents to test
		TimeDataComponent component = new TimeDataComponent();
		TimeDataComponent equalComponent = new TimeDataComponent();
		TimeDataComponent unEqualComponent = new TimeDataComponent();
		TimeDataComponent transitiveComponent = new TimeDataComponent();

		// Change name on unEqualComponent
		unEqualComponent.retrieveAllEntries()
				.get(unEqualComponent.retrieveAllEntries().size() - 1)
				.setName("DifferentFoo");

		// Assert two equal TimeDataComponents return true
		assertTrue(component.equals(equalComponent));

		// Assert two unequal TimeDataComponents return false
		assertFalse(component.equals(unEqualComponent));

		// Assert equals() is reflexive
		assertTrue(component.equals(component));

		// Assert the equals() is Symmetric
		assertTrue(component.equals(equalComponent)
				&& equalComponent.equals(component));

		// Assert equals() is transitive
		if (component.equals(equalComponent)
				&& equalComponent.equals(transitiveComponent)) {
			assertTrue(component.equals(transitiveComponent));
		} else {
			fail();
		}

		// Assert equals is consistent
		assertTrue(component.equals(equalComponent)
				&& component.equals(equalComponent)
				&& component.equals(equalComponent));
		assertTrue(!component.equals(unEqualComponent)
				&& !component.equals(unEqualComponent)
				&& !component.equals(unEqualComponent));

		// Assert checking equality with null is false
		assertFalse(component==null);

		// Assert that two equal objects return same hashcode
		assertTrue(component.equals(equalComponent)
				&& component.hashCode() == equalComponent.hashCode());

		// Assert that hashcode is consistent
		assertTrue(component.hashCode() == component.hashCode());

		// Assert that hashcodes from unequal objects are different
		assertTrue(component.hashCode() != unEqualComponent.hashCode());

		// end-user-code

	}
}