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

package org.eclipse.etrice.generator.workflow;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.xtend.util.stdlib.IOExtensions;


public class XtendStdlibLogger implements ILogger {

	private boolean verbose = false;
	private int errorCount = 0;
	
	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	@Override
	public void logInfo(String text) {
		if (isVerbose())
			IOExtensions.info(text);
	}

	@Override
	public void logError(String text, EObject obj) {
		errorCount++;
    	IOExtensions.error(text);
	}

	public int getErrorCount() {
		return errorCount;
	}

}
