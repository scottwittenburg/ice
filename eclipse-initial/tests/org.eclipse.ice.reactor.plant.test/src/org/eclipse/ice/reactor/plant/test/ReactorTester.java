/*******************************************************************************
* Copyright (c) 2014 UT-Battelle, LLC.
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
package org.eclipse.ice.reactor.plant.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;
import org.eclipse.ice.datastructures.componentVisitor.IReactorComponent;
import org.eclipse.ice.datastructures.form.AdaptiveTreeComposite;
import org.eclipse.ice.datastructures.form.BatteryComponent;
import org.eclipse.ice.datastructures.form.DataComponent;
import org.eclipse.ice.datastructures.form.MasterDetailsComponent;
import org.eclipse.ice.datastructures.form.MatrixComponent;
import org.eclipse.ice.datastructures.form.ResourceComponent;
import org.eclipse.ice.datastructures.form.TableComponent;
import org.eclipse.ice.datastructures.form.TimeDataComponent;
import org.eclipse.ice.datastructures.form.TreeComposite;
import org.eclipse.ice.datastructures.form.geometry.GeometryComponent;
import org.eclipse.ice.datastructures.form.geometry.IShape;
import org.eclipse.ice.datastructures.form.mesh.MeshComponent;
import org.eclipse.ice.datastructures.updateableComposite.Component;
import org.eclipse.ice.reactor.plant.CoreChannel;
import org.eclipse.ice.reactor.plant.Reactor;

import java.util.ArrayList;

import org.junit.Test;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author w5q
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ReactorTester {
	/** 
	 * <!-- begin-UML-doc -->
	 * <p>Boolean flag to mark if the PlantComponent was successfully visited.</p>
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private boolean wasVisited = false;

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Checks the construction of the component.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkConstruction() {
		// begin-user-code
		ArrayList<CoreChannel> channels = new ArrayList<CoreChannel>();
		channels.add(new CoreChannel());
		channels.add(new CoreChannel());
		Reactor reactor = new Reactor(channels);
		
		assertNotNull(reactor.getCoreChannels());
		assertTrue(reactor.getCoreChannels().size() == 2);
		
		reactor = new Reactor();
		assertNotNull(reactor.getCoreChannels());
		assertTrue(reactor.getCoreChannels().isEmpty());
		
		reactor.setCoreChannels(channels);
		assertNotNull(reactor.getCoreChannels());
		assertTrue(reactor.getCoreChannels().size() == 2);
		
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Checks the getting and setting of the component's attributes.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	//public void checkProperties() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	//}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Checks the hashCode and equality methods of the component.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkEquality() {
		// begin-user-code
		// Create two equal Reactor with
		// nullary constructor
		Reactor b = new Reactor();
		b.setName("b");
		b.setDescription("Description");

		Reactor equalB = new Reactor();
		equalB.setName("b");
		equalB.setDescription("Description");

		// Check reflexivity
		assertTrue(b.equals(b));

		// Check equality and symmetry
		assertTrue(b.equals(equalB));
		assertTrue(equalB.equals(b));

		// Since equal, hashcodes should be equal
		assertTrue(b.hashCode() == equalB.hashCode());
		assertTrue(b.hashCode() == b.hashCode());

		// Make them unequal
		b.setName("b_newName");

		// Check inequality and symmetry
		assertFalse(b.equals(equalB));
		assertFalse(equalB.equals(b));
		
		ArrayList<CoreChannel> channels1 = new ArrayList<CoreChannel>();
		channels1.add(new CoreChannel());
		channels1.add(new CoreChannel());
		ArrayList<CoreChannel> channels2 = new ArrayList<CoreChannel>();
		channels2.add(new CoreChannel());
		channels2.add(new CoreChannel());
		b = new Reactor(channels1);
		equalB = new Reactor(channels2);
		
		assertTrue(b.equals(equalB));
		assertTrue(b.equals(b));
		assertTrue(equalB.equals(b));
		
		channels1.remove(0);
		assertFalse(b.equals(equalB));
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Checks the copy and clone methods of the component.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkCopying() {
		// begin-user-code
		ArrayList<CoreChannel> channels = new ArrayList<CoreChannel>();
		channels.add(new CoreChannel());
		channels.add(new CoreChannel());
		// Create a Outlet to copy
		Reactor reactor = new Reactor(channels);
		reactor.setName("Name");
		reactor.setDescription("desc");

		// Create a copy Reactor
		Reactor copy = new Reactor();

		// Assert they are not the same to begin with
		assertFalse(copy.equals(reactor));

		// Copy Reactor
		copy.copy(reactor);

		// Check the copy succeeded
		assertTrue("Name".equals(copy.getName()));
		assertTrue("desc".equals(copy.getDescription()));
		assertFalse(copy == reactor);

		// Get a clone to verify the clone() method
		Object clone = reactor.clone();

		assertNotNull(clone);
		assertFalse(clone == reactor);
		assertTrue(clone.equals(reactor));

		assertTrue(clone instanceof Reactor);

		Reactor casted = (Reactor) clone;

		assertFalse(casted == reactor);
		assertTrue(casted.equals(reactor));

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Checks for persistence in the component.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void checkPersistence() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Checks the visitation routine of the component.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Test
	public void checkVisitation() {
		// begin-user-code
		// Create a new component to visit.
		Reactor reactor = new Reactor();

		// Create an invalid visitor, and try to visit the component.
		FakeComponentVisitor visitor = null;
		reactor.accept(visitor);

		// Check that the component wasn't visited yet.
		assertFalse(wasVisited);

		// Create a valid visitor, and try to visit the component.
		visitor = new FakeComponentVisitor();
		reactor.accept(visitor);

		// Check that the component was visited.
		assertTrue(wasVisited);

		// Grab the visitor's visited component.
		Component visitorComponent = visitor.component;

		// Check that the visitor's component is the same component we initially
		// created.
		assertTrue(reactor == visitorComponent);
		assertTrue(reactor.equals(visitorComponent));

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc -->
	 * <p>
	 * Fake class to test the visitation routine of the component.
	 * </p>
	 * <!-- end-UML-doc -->
	 * 
	 * @author w5q
	 */
	private class FakeComponentVisitor implements IComponentVisitor {

		// The fake visitor's visited component.
		private IReactorComponent component = null;

		public void visit(IReactorComponent component) {

			// Set the IComponentVisitor component (if valid), and flag the
			// component as having been visited.
			if (component != null) {
				this.component = component;
				wasVisited = true;
			}
			return;
		}

		public void visit(DataComponent component) {
		}

		public void visit(ResourceComponent component) {
		}

		public void visit(TableComponent component) {
		}

		public void visit(MatrixComponent component) {
		}

		public void visit(IShape component) {
		}

		public void visit(GeometryComponent component) {
		}

		public void visit(MasterDetailsComponent component) {
		}

		public void visit(TreeComposite component) {
		}

		public void visit(TimeDataComponent component) {
		}

		public void visit(MeshComponent component) {
		}

		public void visit(BatteryComponent component) {
		}

		public void visit(AdaptiveTreeComposite component) {
		}
	};
	
	
}