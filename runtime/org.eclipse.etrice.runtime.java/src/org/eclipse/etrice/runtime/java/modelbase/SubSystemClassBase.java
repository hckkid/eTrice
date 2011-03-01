/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.RTObject;
import org.eclipse.etrice.runtime.java.messaging.RTServices;

/**
 * The base class for all SubSystems.
 * It and its derived classes take care of the instantiation, binding (connection) and complete lifecycle of all Actor Classes of a SubSystem
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class SubSystemClassBase extends RTObject {

	private static SubSystemClassBase instance = null;
	
	private boolean running = false;
	protected ActorClassBase[] instances = null;

	public static SubSystemClassBase getInstance() {
		return instance;
	}
	
	public SubSystemClassBase(IRTObject parent, String name) {
		super(parent, name);

		if (instance!=null)
			throw new RuntimeException("ComponentClassBase is a singleton!");
		
		instance = this;
		
		DebuggingService.getInstance().getAsyncLogger()
				.setMSC(name + "_Async", "");
		DebuggingService.getInstance().getAsyncLogger().open();
		DebuggingService.getInstance().getSyncLogger()
				.setMSC(name + "_Sync", "");
		DebuggingService.getInstance().getSyncLogger().open();
	}

	public void init() {

		System.out.println("*** MainComponent "+getInstancePath()+"::init ***");

		// MessageService
		instantiateMessageServices();
		
		// this is the place to connect the message services if necessary
		// normaly the ports will address the correct target message service directly
		// it is just for test purposes 
		// RTServices.getInstance().getMsgSvcCtrl().connectAll();
		
		instantiateActors();

		// initialize all actor instances
		if (instances!=null)
			for (int i = 0; i < instances.length; i++) {
				instances[i].init();
			}
	}

	public abstract void instantiateMessageServices();
	public abstract void instantiateActors();
	
	
	public void start() {
		// start all actor instances
		if (instances!=null)
			for (int i = 0; i < instances.length; i++) {
				instances[i].start();
			}

		// start all message services
		RTServices.getInstance().getMsgSvcCtrl().start();
		
		running = true;
	}
	
	public void stop() {
		RTServices.getInstance().getMsgSvcCtrl().stop();

		// stop all actor instances
		if (instances!=null)
			for (int i = 0; i < instances.length; i++) {
				instances[i].stop();
			}
	}
	
	public void destroy() {
		if (instances!=null)
			for (int i = 0; i < instances.length; i++) {
				instances[i].destroy();
			}

		DebuggingService.getInstance().getAsyncLogger().close();
		DebuggingService.getInstance().getSyncLogger().close();

		System.out.println("*** MainComponent "+getInstancePath()+"::destroy ***");
	}
	
	public MessageService getMsgService(int idx) {
		return RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(idx);
	}
	
	public ActorClassBase getInstance(int i) {
		if (instances==null || i<0 || i>= instances.length)
			return null;
		
		return instances[i];
	}
	
	public ActorClassBase getInstance(String path) {
		if (instances!=null)
			for (int i = 0; i < instances.length; i++) {
				if (instances[i].getInstancePath().equals(path))
					return instances[i];
			}
		
		return null;
	}
}
