/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.java;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.generator.builder.ILogger;

/**
 * @author hrentz
 *
 */
public class Logger implements ILogger {

	public void logInfo(String text) {
		System.out.println("Info: " + text);
	}

	public void logError(String text, EObject obj) {
		System.out.println("Error: " + text + " " + obj.toString());
	}

}
