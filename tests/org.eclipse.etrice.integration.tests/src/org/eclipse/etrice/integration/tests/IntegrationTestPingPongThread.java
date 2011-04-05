/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.integration.tests;


import static org.junit.Assert.assertEquals;

import org.eclipse.etrice.integration.PingPongThreadTest.SubSystem_PingPong;
import org.eclipse.etrice.integration.tests.base.IntegrationTestBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class IntegrationTestPingPongThread extends IntegrationTestBase {
	@Before
	public void setUp() throws Exception {
		// we have to launch a JUnit Plugin test since for the build we need an Eclipse environment
		// in this context the Mwe2Launcher suffers from https://bugs.eclipse.org/bugs/show_bug.cgi?id=318721
		/*
		Mwe2Launcher.main(new String[]{"/org.eclipse.etrice.integration.tests/src/de/protos/etrice/integration/test/IntegrationTestFSMGenerator.mwe2"});
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final IProject project = workspace.getRoot().getProject("/org.eclipse.etrice.integration.tests");
		project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, null);
		*/
	}
	
	@Test (timeout=10000)
	public void testHFSM(){
		SubSystem_PingPong main_component = new SubSystem_PingPong(null,"MainComponent");
		
		// hand over the semaphore to the subsystem
		main_component.setTestSemaphore(this.testSem);

		main_component.init(); // lifecycle init
		main_component.start(); // lifecycle start
		
		waitForTestcase();
		
		assertEquals(0,main_component.getTestErrorCode());

		// end the lifecycle
		main_component.stop(); // lifecycle stop
		main_component.destroy(); // lifecycle destroy
	}

	@After
	public void tearDown() throws Exception {
	}

	
}
