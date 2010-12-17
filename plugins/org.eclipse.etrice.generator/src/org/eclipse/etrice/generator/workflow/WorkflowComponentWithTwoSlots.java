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

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;

public abstract class WorkflowComponentWithTwoSlots implements IWorkflowComponent {

	private String inSlot = "model";
	private String outSlot = "outmodel";

	public void setInSlot(String slot) {
		this.inSlot = slot;
	}

	public String getInSlot() {
		return inSlot;
	}

	public String getOutSlot() {
		return outSlot;
	}

	public void setOutSlot(String outSlot) {
		this.outSlot = outSlot;
	}

	public void postInvoke() {
	}

	public void preInvoke() {
	}

}
