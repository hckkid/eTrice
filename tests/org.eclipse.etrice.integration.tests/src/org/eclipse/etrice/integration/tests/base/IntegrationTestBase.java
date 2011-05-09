package org.eclipse.etrice.integration.tests.base;

import java.util.concurrent.Semaphore;

public class IntegrationTestBase {

	protected Semaphore testSem = new Semaphore(0);

	public IntegrationTestBase() {
		super();
	}

	// TODO: is this the right place here? -> the functionality is scattered between IntegrationTestBase and SubSystemClassBase
	protected synchronized void waitForTestcase() {
		try{
			this.testSem.acquire(1);
		}catch(InterruptedException e){
			System.out.println("Semaphore fault !");
		}
	}

}