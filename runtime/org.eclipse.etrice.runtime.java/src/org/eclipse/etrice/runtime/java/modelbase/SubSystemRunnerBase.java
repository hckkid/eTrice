package org.eclipse.etrice.runtime.java.modelbase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The base class for running components.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class SubSystemRunnerBase {

	/**
	 * blocks until the String "quit" is entered on the console
	 */
	protected static void waitForQuit() {
		// waiting for command line input
		BufferedReader bk = new BufferedReader(new InputStreamReader(System.in));
		String token = new String("");
		System.out.println("type 'quit' to exit");
		while (!token.equals("quit")) {
			try {
				token = bk.readLine();
				System.out.println("echo: " + token);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
