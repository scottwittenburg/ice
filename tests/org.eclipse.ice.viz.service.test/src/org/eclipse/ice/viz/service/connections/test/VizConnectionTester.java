/*******************************************************************************
 * Copyright (c) 2015 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Jordan Deyton (UT-Battelle, LLC.) - Initial API and implementation and/or 
 *     initial documentation
 *******************************************************************************/
package org.eclipse.ice.viz.service.connections.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.ice.viz.service.connections.ConnectionState;
import org.eclipse.ice.viz.service.connections.IVizConnection;
import org.eclipse.ice.viz.service.connections.IVizConnectionListener;
import org.eclipse.ice.viz.service.connections.VizConnection;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test the basic implementation of {@link IVizConnection}
 * provided by {@link VizConnection} as well as its added functionality.
 * 
 * @author Jordan Deyton
 *
 */
public class VizConnectionTester {

	/**
	 * The main connection that will be tested in each test method.
	 */
	private VizConnection<FakeClient> connection;
	/**
	 * The main test {@link #connection} conveniently cast as its original type.
	 */
	private FakeVizConnection fakeConnection;

	/**
	 * A fake listener. This will already be added to the {@link #connection} at
	 * the start of each test.
	 */
	private FakeVizConnectionListener fakeListener1;
	/**
	 * A fake listener. This will <i>not</i> have been added to the
	 * {@link #connection}.
	 */
	private FakeVizConnectionListener fakeListener2;

	/**
	 * A queue containing the arguments posted to
	 * {@link IVizConnectionListener#connectionStateChanged(IVizConnection, ConnectionState, String)}
	 * for the {@link #fakeListener1}. .
	 */
	private Queue<Object> notificationQueue;
	/**
	 * A lock used to control access to the {@link #notificationQueue} from
	 * multiple threads.
	 */
	private Lock notificationLock;

	/**
	 * Initializes the viz connection that is tested as well as any other class
	 * variables frequently used to test the connection.
	 */
	@Before
	public void beforeEachTest() {

		// Set up the test connection.
		fakeConnection = new FakeVizConnection();
		connection = fakeConnection;

		// Set up the queue and lock for notifications.
		notificationQueue = new LinkedList<Object>();
		notificationLock = new ReentrantLock(true);

		// Customize the first fake listener to post its notification content to
		// the queue.
		fakeListener1 = new FakeVizConnectionListener() {
			@Override
			public void connectionStateChanged(
					IVizConnection<FakeClient> connection,
					ConnectionState state, String message) {
				notificationLock.lock();
				try {
					notificationQueue.add(connection);
					notificationQueue.add(state);
					notificationQueue.add(message);
				} finally {
					notificationLock.unlock();
				}
				super.connectionStateChanged(connection, state, message);
			}
		};

		// For the second fake listener, just create a plain one. We aren't
		// interested in its notification content.
		fakeListener2 = new FakeVizConnectionListener();

		// Add only the first listener.
		connection.addListener(fakeListener1);

		return;
	}

	/**
	 * Checks all of the default values for {@link IVizConnection} getters.
	 */
	@Test
	public void checkDefaults() {

		// Check the default getters.
		assertEquals(ConnectionState.Disconnected, connection.getState());
		assertEquals("The connection has not been configured.",
				connection.getStatusMessage());
		assertNull(connection.getWidget());
		// Check the convenient getters.
		assertEquals("Connection1", connection.getName());
		assertEquals("", connection.getDescription());
		assertEquals("localhost", connection.getHost());
		assertEquals("50000", connection.getPort());
		assertEquals("", connection.getPath());

		// Check the property map.
		Map<String, String> properties = connection.getProperties();
		assertNotNull(connection.getProperties());
		assertEquals(5, connection.getProperties().size());
		// Check the property map contents. These should match the convenient
		// getter values.
		assertEquals("Connection1", properties.get("Name"));
		assertEquals("", properties.get("Description"));
		assertEquals("localhost", properties.get("Host"));
		assertEquals("50000", properties.get("Port"));
		assertEquals("", properties.get("Path"));

		return;
	}

	/**
	 * Checks that supported properties can be set.
	 */
	@Test
	public void checkSetProperty() {
		fail("Not implemented");
	}

	/**
	 * Checks the name setter properly sets the name property.
	 */
	@Test
	public void checkSetName() {
		fail("Not implemented");
	}

	/**
	 * Checks the description setter properly sets the description property.
	 */
	@Test
	public void checkSetDescription() {
		fail("Not implemented");
	}

	/**
	 * Checks the host setter properly sets the host property.
	 */
	@Test
	public void checkSetHost() {
		fail("Not implemented");
	}

	/**
	 * Checks the port setter properly sets the port property.
	 */
	@Test
	public void checkSetPort() {
		fail("Not implemented");
	}

	/**
	 * Checks the path setter properly sets the path property.
	 */
	@Test
	public void checkSetPath() {
		fail("Not implemented");
	}

	/**
	 * Checks the return value for the connect operation.
	 */
	@Test
	public void checkConnect() {

		ConnectionState state = null;

		// Try to connect, but fail. This should return the "failed" state.
		fakeConnection.failOperation = true;
		try {
			state = connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// The state should be "failed" and the widget should still be null.
		assertEquals(ConnectionState.Failed, state);
		assertNull(connection.getWidget());

		// Try to connect, this time successfully.
		fakeConnection.failOperation = false;
		try {
			state = connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// The state should be "connected" and the widget should be set.
		assertEquals(ConnectionState.Connected, state);
		assertSame(fakeConnection.connectionWidget.get(),
				connection.getWidget());

		// Trying to connect again should just return the "connected" state.
		try {
			state = connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// The state should *still* be "connected" and the widget should be set.
		assertEquals(ConnectionState.Connected, state);
		assertSame(fakeConnection.connectionWidget.get(),
				connection.getWidget());

		return;
	}

	/**
	 * Checks that the sub-class implementation is called when connecting.
	 */
	@Test
	public void checkConnectToWidget() {

		// Try to connect. This should call the widget implementation but still
		// fail to connect.
		fakeConnection.failOperation = true;
		try {
			connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// Check that the client's implementation was called and that the
		// connection's widget was set to null.
		assertTrue(fakeConnection.connectToWidgetCalled());
		assertNull(connection.getWidget());

		// Try to connect, this time successfully.
		fakeConnection.failOperation = false;
		try {
			connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// Check that the client's implementation was called and that the
		// connection's widget was set to the returned widget.
		assertTrue(fakeConnection.connectToWidgetCalled());
		assertSame(fakeConnection.connectionWidget.get(),
				connection.getWidget());

		// Trying to connect shouldn't call the sub-class operation because the
		// connection was already connected.
		try {
			connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// Check that the client's implementation was *not* called and that the
		// connection's widget is the same as the returned widget.
		assertFalse(fakeConnection.connectToWidgetCalled());
		assertSame(fakeConnection.connectionWidget.get(),
				connection.getWidget());

		return;
	}

	/**
	 * Checks the return value for the disconnect operation.
	 */
	@Test
	public void checkDisconnect() {

		ConnectionState state = null;

		// Trying to disconnect when not connected should just return the
		// "disconnected" state.
		try {
			state = connection.disconnect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// The state returned should be "disconnected" and the widget should
		// still be unset.
		assertEquals(ConnectionState.Disconnected, state);
		assertNull(connection.getWidget());

		// Connect.
		try {
			state = connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// The state should be "connected".
		assertEquals(ConnectionState.Connected, state);

		// Try to disconnect, but fail.
		fakeConnection.failOperation = true;
		try {
			state = connection.disconnect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// The state returned should be "failed", and the widget should remain
		// the same.
		assertEquals(ConnectionState.Failed, state);
		assertSame(fakeConnection.connectionWidget.get(),
				connection.getWidget());

		// Disconnect successfully.
		fakeConnection.failOperation = false;
		try {
			state = connection.disconnect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// The state returned should be "disconnected", and the widget should be
		// unset.
		assertEquals(ConnectionState.Disconnected, state);
		assertNull(connection.getWidget());

		// Trying to disconnect when not connected should just return the
		// "disconnected" state.
		try {
			state = connection.disconnect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// The state returned should be "disconnected" and the widget should
		// still be unset.
		assertEquals(ConnectionState.Disconnected, state);
		assertNull(connection.getWidget());

		return;
	}

	/**
	 * Checks that the sub-class implementation is called when disconnecting.
	 */
	@Test
	public void checkDisconnectFromWidget() {

		// Trying to disconnect when not connected shouldn't call the sub-class
		// implementation.
		try {
			connection.disconnect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// Check that the client's implementation was *not* called and that the
		// connection's widget is still null.
		assertFalse(fakeConnection.disconnectFromWidgetCalled());
		assertNull(connection.getWidget());

		// Connect.
		try {
			connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// The connection's widget should not be null.
		assertNotNull(connection.getWidget());

		// Try to disconnect, but fail.
		fakeConnection.failOperation = true;
		try {
			connection.disconnect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// Check that the client's implementation was called but the connection
		// widget was not unset (for diagnostic purposes).
		assertTrue(fakeConnection.disconnectFromWidgetCalled());
		assertSame(fakeConnection.connectionWidget.get(),
				connection.getWidget());

		// Disconnect successfully.
		fakeConnection.failOperation = false;
		try {
			connection.disconnect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// Check that the client's implementation was called and the connection
		// widget was unset.
		assertTrue(fakeConnection.disconnectFromWidgetCalled());
		assertNull(connection.getWidget());

		// Trying to disconnect when not connected shouldn't call the sub-class
		// implementation.
		try {
			connection.disconnect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// Check that the client's implementation was *not* called and that the
		// connection's widget is still null.
		assertFalse(fakeConnection.disconnectFromWidgetCalled());
		assertNull(connection.getWidget());

		return;
	}

	/**
	 * Checks that listeners can be added and removed, as well as checking that
	 * they are actually notified.
	 */
	@Test
	public void checkListeners() {

		// Connect the connection.
		try {
			connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// Only the first listener will be notified.
		assertFalse(fakeListener2.wasNotified());
		assertTrue(fakeListener1.wasNotified());

		// Register a new listener.
		assertTrue(connection.addListener(fakeListener2));
		// We can't add the same listener twice.
		assertFalse(connection.addListener(fakeListener2));

		// Disconnect the connection.
		try {
			connection.disconnect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// Both listeners should be notified.
		assertTrue(fakeListener1.wasNotified());
		assertTrue(fakeListener2.wasNotified());

		// Check the messages sent to the notified listeners.

		// Remove the listener.
		assertTrue(connection.removeListener(fakeListener2));
		// We can't remove the same listener twice.
		assertFalse(connection.removeListener(fakeListener2));

		// Connect the connection.
		try {
			connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// Only the first listener will be notified.
		assertFalse(fakeListener2.wasNotified());
		assertTrue(fakeListener1.wasNotified());

		return;
	}

	/**
	 * Checks that the proper sequence of notifications are posted to registered
	 * listeners when the {@link VizConnection#connect()} operation is
	 * successful.
	 */
	@Test
	public void checkNotificationsForSuccessfulConnect() {

		int size;
		fakeConnection.failOperation = false;

		// With a successful connection, we expect the following state changes:
		// disconnected > connecting > connected
		// resulting in 2 notifications

		// Connect.
		try {
			connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// Check the "connecting" status update.
		assertTrue(fakeListener1.wasNotified());
		notificationLock.lock();
		try {
			assertSame(connection, notificationQueue.poll());
			assertEquals(ConnectionState.Connecting, notificationQueue.poll());
			assertEquals("The connection is being established.",
					notificationQueue.poll());
			size = notificationQueue.size();
		} finally {
			notificationLock.unlock();
		}

		// If the second notification wasn't received yet, wait for it.
		if (size != 0) {
			assertTrue(fakeListener1.wasNotified());
		}

		// Check the "connected" status update.
		notificationLock.lock();
		try {
			assertSame(connection, notificationQueue.poll());
			assertEquals(ConnectionState.Connected, notificationQueue.poll());
			assertEquals("The connection is established.",
					notificationQueue.poll());
			assertTrue(notificationQueue.isEmpty());
		} finally {
			notificationLock.unlock();
		}

		return;
	}

	/**
	 * Checks that the proper sequence of notifications are posted to registered
	 * listeners when the {@link VizConnection#connect()} operation
	 * <i>fails</i>.
	 */
	@Test
	public void checkNotificationsForFailedConnect() {

		int size;
		fakeConnection.failOperation = true;

		// With a failed connection, we expect the following state changes:
		// disconnected > connecting > failed
		// resulting in 2 notifications

		// Connect.
		try {
			connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// Check the "connecting" status update.
		assertTrue(fakeListener1.wasNotified());
		notificationLock.lock();
		try {
			assertSame(connection, notificationQueue.poll());
			assertEquals(ConnectionState.Connecting, notificationQueue.poll());
			assertEquals("The connection is being established.",
					notificationQueue.poll());
			size = notificationQueue.size();
		} finally {
			notificationLock.unlock();
		}

		// If the second notification wasn't received yet, wait for it.
		if (size != 0) {
			assertTrue(fakeListener1.wasNotified());
		}

		// Check the "failed" status update.
		notificationLock.lock();
		try {
			assertSame(connection, notificationQueue.poll());
			assertEquals(ConnectionState.Failed, notificationQueue.poll());
			assertEquals("The connection failed to connect.",
					notificationQueue.poll());
			assertTrue(notificationQueue.isEmpty());
		} finally {
			notificationLock.unlock();
		}

		return;
	}

	/**
	 * Checks that the proper sequence of notifications are posted to registered
	 * listeners when the {@link VizConnection#disconnect()} operation is
	 * successful.
	 */
	@Test
	public void checkNotificationsForSuccessfulDisconnect() {

		int size;
		fakeConnection.failOperation = false;

		// With a successful disconnect, we expect the following state changes:
		// connected > disconnected
		// resulting in 1 notification

		// Connect.
		try {
			connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// ---- Ignore the Connecting and Connected notifications. ---- //
		assertTrue(fakeListener1.wasNotified());
		notificationLock.lock();
		try {
			size = notificationQueue.size();
		} finally {
			notificationLock.unlock();
		}
		// If the second notification wasn't received yet, wait for it.
		if (size != 6) {
			assertTrue(fakeListener1.wasNotified());
		}
		notificationLock.lock();
		try {
			assertEquals(6, notificationQueue.size());
			notificationQueue.clear();
		} finally {
			notificationLock.unlock();
		}
		// ------------------------------------------------------------ //

		// Disconnect.
		try {
			connection.disconnect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// Check the "disconnected" status update.
		notificationLock.lock();
		try {
			assertSame(connection, notificationQueue.poll());
			assertEquals(ConnectionState.Disconnected, notificationQueue.poll());
			assertEquals("The connection is closed.", notificationQueue.poll());
			assertTrue(notificationQueue.isEmpty());
		} finally {
			notificationLock.unlock();
		}

		return;
	}

	/**
	 * Checks that the proper sequence of notifications are posted to registered
	 * listeners when the {@link VizConnection#disconnect()} operation fails.
	 */
	@Test
	public void checkNotificationsForFailedDisconnect() {

		int size;
		fakeConnection.failOperation = false;

		// With a failed disconnect, we expect the following state changes:
		// connected > failed
		// resulting in 1 notification

		// Connect.
		try {
			connection.connect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// ---- Ignore the Connecting and Connected notifications. ---- //
		assertTrue(fakeListener1.wasNotified());
		notificationLock.lock();
		try {
			size = notificationQueue.size();
		} finally {
			notificationLock.unlock();
		}
		// If the second notification wasn't received yet, wait for it.
		if (size != 6) {
			assertTrue(fakeListener1.wasNotified());
		}
		notificationLock.lock();
		try {
			assertEquals(6, notificationQueue.size());
			notificationQueue.clear();
		} finally {
			notificationLock.unlock();
		}
		// ------------------------------------------------------------ //

		// Set the disconnect operation to fail.
		fakeConnection.failOperation = true;

		// Disconnect.
		try {
			connection.disconnect().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// Check the "failed" status update.
		notificationLock.lock();
		try {
			assertSame(connection, notificationQueue.poll());
			assertEquals(ConnectionState.Failed, notificationQueue.poll());
			assertEquals("The connection failed while disconnecting.",
					notificationQueue.poll());
			assertTrue(notificationQueue.isEmpty());
		} finally {
			notificationLock.unlock();
		}

		return;
	}

	/**
	 * This class provides a fake client of some sort as a type .
	 * 
	 * @author Jordan
	 *
	 */
	private class FakeClient {

	}

	/**
	 * A fake viz connection for testing the {@link VizConnection}'s base
	 * implementation.
	 * 
	 * @author Jordan
	 *
	 */
	private class FakeVizConnection extends VizConnection<FakeClient> {

		/**
		 * If true, then {@link #connectToWidget(FakeClient)} and
		 * {@link #disconnectFromWidget(FakeClient)} will return false as if
		 * they failed to connect/disconnect.
		 */
		public boolean failOperation = false;

		/**
		 * Whether the sub-class' implementation for connecting to the actual
		 * client was called.
		 */
		private final AtomicBoolean connectToWidgetCalled = new AtomicBoolean();

		/**
		 * Whether the sub-class' implementation for disconnecting from the
		 * actual client was called.
		 */
		private final AtomicBoolean disconnectFromWidgetCalled = new AtomicBoolean();

		private final AtomicReference<FakeClient> connectionWidget = new AtomicReference<FakeClient>();

		/**
		 * Sets {@link #connectToWidgetCalled} to {@code true} and either
		 * initializes or unsets {@link #connectionWidget} depending on whether
		 * {@link #failOperation} is true.
		 */
		@Override
		protected FakeClient connectToWidget() {
			connectToWidgetCalled.set(true);
			connectionWidget.set(failOperation ? null : new FakeClient());
			return connectionWidget.get();
		}

		/**
		 * Sets {@link #disconnectFromWidgetCalled} to {@code true} and returns
		 * {@link #failOperation}.
		 */
		@Override
		protected boolean disconnectFromWidget(FakeClient widget) {
			disconnectFromWidgetCalled.set(true);
			return !failOperation;
		}

		/**
		 * Gets whether the sub-class' implementation of
		 * {@link #connectToWidget(FakeClient)} was called.
		 * 
		 * @return True if the sub-class implementation was called, false
		 *         otherwise.
		 */
		public boolean connectToWidgetCalled() {
			return connectToWidgetCalled.getAndSet(false);
		}

		/**
		 * Gets whether the sub-class' implementation of
		 * {@link #disconnectFromWidget(FakeClient)} was called.
		 * 
		 * @return True if the sub-class implementation was called, false
		 *         otherwise.
		 */
		public boolean disconnectFromWidgetCalled() {
			return disconnectFromWidgetCalled.getAndSet(false);
		}
	}

	/**
	 * A fake viz connection listener for testing the listener methods provided
	 * by {@link VizConnection}.
	 * 
	 * @author Jordan
	 *
	 */
	private class FakeVizConnectionListener implements
			IVizConnectionListener<FakeClient> {

		/**
		 * True if the client's
		 * {@link #connectionStateChanged(IVizConnection, ConnectionState, String)}
		 * method was notified, false otherwise.
		 */
		private final AtomicBoolean wasNotified = new AtomicBoolean();

		/*
		 * Implements a method from IVizConnectionListener.
		 */
		@Override
		public void connectionStateChanged(
				IVizConnection<FakeClient> connection, ConnectionState state,
				String message) {
			wasNotified.set(true);
		}

		/**
		 * Determines if the listener was notified of a connection state change
		 * since the last call to this method.
		 * <p>
		 * This will wait for a certain amount of time until either the flag is
		 * true or a timeout occurs.
		 * </p>
		 * 
		 * @return True if the listener was notified, false otherwise.
		 */
		public boolean wasNotified() {
			boolean notified;

			long threshold = 3000; // The timeout.
			long interval = 50; // The time between checks.
			long time = 0; // The time spent asleep.
			while (!(notified = wasNotified.getAndSet(false))
					&& time < threshold) {
				try {
					Thread.sleep(interval);
					time += threshold;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return notified;
		}
	}
}