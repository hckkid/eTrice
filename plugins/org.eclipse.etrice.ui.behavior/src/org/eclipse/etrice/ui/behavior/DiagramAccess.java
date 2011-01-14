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

package org.eclipse.etrice.ui.behavior;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.etrice.ui.behavior.commands.PopulateDiagramCommand;
import org.eclipse.etrice.ui.behavior.editor.BehaviorEditor;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.RoomModel;

public class DiagramAccess {

	private static final String DIAGRAMS_FOLDER_NAME = "diagrams";

	public static Diagram getDiagram(ActorClass ac) {
		Resource resource = ac.eResource();
		if (resource==null)
			return null;
		
		URI uri = resource.getURI();
		if (!uri.isPlatformResource())
			return null;
		
		uri = uri.trimSegments(1);
		IFolder parentFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(uri.toPlatformString(true)));

		IFolder diagramFolder = parentFolder.getFolder(DIAGRAMS_FOLDER_NAME);
		
		RoomModel model = (RoomModel) ac.eContainer();
		
		IFile diagramFile = diagramFolder.getFile(model.getName()+"."+ac.getName()+".behavior");
		URI diagURI = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);

		ResourceSet rs = new ResourceSetImpl();
		if (diagramFile.exists()) {
			Resource diagRes = rs.getResource(diagURI, true);
			if (diagRes.getContents().isEmpty())
				return null;
			if (diagRes.getContents().get(0) instanceof Diagram)
				return (Diagram) diagRes.getContents().get(0);
		}
		else {
			Resource diagRes = rs.createResource(diagURI);
			
			Diagram diagram = Graphiti.getPeCreateService().createDiagram("room.behavior", "Behavior of "+ac.getName(), true);
			diagRes.getContents().add(diagram);
			
			populatediagram(ac, diagram);
			
			try {
				diagRes.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return diagram;
		}
		
		return null;
	}
	
	private static void populatediagram(ActorClass ac, Diagram diagram) {
		ResourceSet rs = diagram.eResource().getResourceSet();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(rs);
		if (editingDomain == null) {
			// Not yet existing, create one
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);
		}

		// IMPORTANT STEP: this resolves the object and creates a new resource in the resource set
		URI boUri = EcoreUtil.getURI(ac);
		ac = (ActorClass) editingDomain.getResourceSet().getEObject(boUri, true);
		ac.eResource().setTrackingModification(true);
		
		editingDomain.getCommandStack().execute(new PopulateDiagramCommand(diagram, ac, editingDomain));
		editingDomain.dispose();
	}

	public static void openDiagramEditor(ActorClass ac) {
		Diagram diagram = getDiagram(ac);
		
		String platformString = diagram.eResource().getURI().toPlatformString(true);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
		IFileEditorInput input = new FileEditorInput(file);

		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, BehaviorEditor.BEHAVIOR_EDITOR_ID);
		} catch (PartInitException e) {
			String error = "Error while opening diagram editor";
			System.err.println(error);
		}
	}
}