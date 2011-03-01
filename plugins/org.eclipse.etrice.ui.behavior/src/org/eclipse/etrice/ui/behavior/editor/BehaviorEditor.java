/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.editor;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.etrice.ui.behavior.commands.AddMssingTransitionNamesCommand;
import org.eclipse.etrice.ui.behavior.support.ContextSwitcher;
import org.eclipse.emf.common.command.Command;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.swt.graphics.Image;


public class BehaviorEditor extends DiagramEditor {

	public static final String BEHAVIOR_EDITOR_ID = "org.eclipse.etrice.ui.behavior.editor.BehaviorEditor";
	
	public BehaviorEditor() {
		super();
	}
	
	@Override
	public Image getDefaultImage() {
		return Activator.getImage("icons/Behavior.gif");
	}

	@SuppressWarnings("restriction")
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		
		ResourceSet rs = getEditingDomain().getResourceSet();
		if (rs.getResources().size()>1)
			rs.getResources().get(1).setTrackingModification(true);
		
		Command cmd = new RecordingCommand(getEditingDomain()) {
			@Override
			protected void doExecute() {
				ContextSwitcher.switchTop(getDiagramTypeProvider().getDiagram());
			}
		};
		getEditingDomain().getCommandStack().execute(cmd);

		cmd = new AddMssingTransitionNamesCommand(getDiagramTypeProvider().getDiagram(), getEditingDomain());
		getEditingDomain().getCommandStack().execute(cmd);
	}

}
