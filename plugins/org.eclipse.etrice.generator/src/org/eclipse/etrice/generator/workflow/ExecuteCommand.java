/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.workflow;

import java.io.IOException;

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.etrice.generator.workflow.XtendStdlibLogger;

/**
 * class ExecuteCommand implements a workflow component to call a shell command
 * 
 * @author Thomas Schuetz
 * 
 */
public class ExecuteCommand implements IWorkflowComponent {

	private String commandString = "";

	public void setCommandString(String commandString) {
		this.commandString = commandString;
	}

	@Override
	public void invoke(IWorkflowContext ctx) {
		XtendStdlibLogger logger = new XtendStdlibLogger();

		Runtime rt = Runtime.getRuntime();
		Process proc;
		int exitVal;
		try {
			proc = rt.exec(commandString);
			exitVal = proc.waitFor();
			if (exitVal==0){
		    	logger.logInfo("Workflow ExecuteCommand: successfully called command :"+commandString);
			}
			else {
				logError();
			}
		} catch (IOException e) {
			logError();
			e.printStackTrace();
		} catch (InterruptedException e) {
			logError();
			e.printStackTrace();
		}

	}
	
	void logError(){
		XtendStdlibLogger logger = new XtendStdlibLogger();
    	logger.logError("Workflow GeneratorCallDot: error while calling command :"+commandString, null);
	}

	@Override
	public void preInvoke() {
	}

	@Override
	public void postInvoke() {
	}
}
