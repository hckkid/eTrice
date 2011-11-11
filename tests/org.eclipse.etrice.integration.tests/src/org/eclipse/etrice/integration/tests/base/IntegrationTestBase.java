package org.eclipse.etrice.integration.tests.base;

import java.util.concurrent.Semaphore;

import org.eclipse.etrice.runtime.java.modelbase.TestSemaphore;

public class IntegrationTestBase {

	protected TestSemaphore testSem = new TestSemaphore(0);

	public IntegrationTestBase() {
		super();
	}

	// TODO: is this the right place here? -> the functionality is scattered between IntegrationTestBase and SubSystemClassBase
	protected void waitForTestcase() {
		try{
			System.out.println("=== waitForTestcase: before acq. semaphore, thread "+Thread.currentThread().getName());
			this.testSem.acquire(1);
			System.out.println("=== waitForTestcase: after acq. semaphore, thread "+Thread.currentThread().getName());
		}catch(InterruptedException e){
			System.out.println("Semaphore fault !");
		}
	}

}