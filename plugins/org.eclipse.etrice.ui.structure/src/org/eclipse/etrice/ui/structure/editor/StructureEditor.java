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

package org.eclipse.etrice.ui.structure.editor;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.ui.structure.Activator;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.swt.graphics.Image;


public class StructureEditor extends DiagramEditor {

	public static final String STRUCTURE_EDITOR_ID = "org.eclipse.etrice.ui.structure.editor.StructureEditor";
	
	public StructureEditor() {
		super();
	}
	
	@Override
	public Image getDefaultImage() {
		return Activator.getImage("icons/Structure.gif");
	}

	@SuppressWarnings("restriction")
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		
		ResourceSet rs = getEditingDomain().getResourceSet();
		if (rs.getResources().size()>1)
			rs.getResources().get(1).setTrackingModification(true);
	}
}
