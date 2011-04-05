package org.eclipse.etrice.integration.tests.base;

import java.util.concurrent.Semaphore;

public class IntegrationTestBase {

	protected Semaphore testSem = new Semaphore(0);

	public IntegrationTestBase() {
		super();
	}

	protected synchronized void waitForTestcase() {
		try{
			this.testSem.acquire(1);
		}catch(InterruptedException e){
			System.out.println("Semaphore fault !");
		}
	}

}