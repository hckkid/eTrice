/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

import junit.framework.TestCase;



public class ActorClassBaseTest extends TestCase {

	public class TestActor extends ActorClassBase {
		public TestActor(IRTObject parent, String name) {
			super(parent, name, null);
		}
		public void receive(Message msg) {
			
		}
		public Address getAddress() {
			return null;
		}
		public void receiveEvent(InterfaceItemBase ifitem, int evt, Object... data) {
		}
		
		@Override
		public void init() {}
		@Override
		public void start() {}
		@Override
		public void stop() {}
		@Override
		public void destroy() {}
	}

	
	public void testActorClassBase() {
		ActorClassBase actor = new TestActor(null, "Actor1");
		assertEquals("/Actor1", actor.getInstancePath());
	}

	public void testToString() {
		ActorClassBase actor = new TestActor(null, "Actor1");
		actor.setClassName("ActorClassBase");
		assertEquals("ActorClass(className=ActorClassBase, instancePath=/Actor1)", actor.toString());
	}

	public void testSetGetClassName() {
		ActorClassBase actor = new TestActor(null, "Actor1");
		actor.setClassName("ActorClassBase");
		assertEquals("ActorClassBase", actor.getClassName());
	}
}
