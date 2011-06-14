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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.common.editor.RoomDiagramEditor;
import org.eclipse.etrice.ui.structure.Activator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;


public class StructureEditor extends RoomDiagramEditor {

	public static final String STRUCTURE_EDITOR_ID = "org.eclipse.etrice.ui.structure.editor.StructureEditor";
	
	public StructureEditor() {
		super();
	}
	
	@Override
	public Image getDefaultImage() {
		return Activator.getImage("icons/Structure.gif");
	}

	/**
	 * @return the actor class of this editor
	 */
	public StructureClass getStructureClass() {
		Diagram diagram = ((DiagramEditorInput)getEditorInput()).getDiagram();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		if (bo instanceof StructureClass)
			return (StructureClass) bo;
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.internal.editor.DiagramEditorInternal#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@SuppressWarnings("restriction")
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		super.createPartControl(parent);
		
		/* we have to save here whether changes have been done or not to get rid of the dirty state
		 * CAUTION: save in
		 * init(IEditorSite site, IEditorInput input)
		 * or
		 * setInput(IEditorInput input)
		 * did not work correctly
		 */
//		if (AutoUpdateFeature.isLastDoneChanges())
			doSave(null);
	}
}
