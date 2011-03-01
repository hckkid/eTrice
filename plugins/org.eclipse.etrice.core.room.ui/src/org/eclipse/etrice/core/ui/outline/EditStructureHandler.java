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

package org.eclipse.etrice.core.ui.outline;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import org.eclipse.etrice.core.naming.RoomFragmentProvider;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.structure.DiagramAccess;

/**
 * Handler for outline menu item to open structure editor.
 * The handler will ask to save unsaved editor before opening the diagram.
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class EditStructureHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) selection;
			Object sel = ss.getFirstElement();
			if (sel instanceof EObjectNode) {
				final EObjectNode node = (EObjectNode) sel;
				XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor(event);
				if (xtextEditor.isDirty()) {
					if (!MessageDialog.openQuestion(xtextEditor.getSite().getShell(), "Save model file", "The editor will be saved before opening the diagram editor.\nProceed?"))
						return null;
					xtextEditor.doSave(new NullProgressMonitor());
				}
				xtextEditor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						if (resource != null) {
							EObject object = resource.getEObject(node.getEObjectURI().fragment());
							if (object instanceof StructureClass) {
								DiagramAccess diagramAccess = new DiagramAccess();
								diagramAccess.openDiagramEditor((StructureClass) object);
							}
						}
					}
				});
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IWorkbenchPart part = page.getActivePart();
		if (part instanceof ContentOutline) {
			ISelection selection = ((ContentOutline)part).getSelection();
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection ss = (IStructuredSelection) selection;
				Object sel = ss.getFirstElement();
				if (sel instanceof EObjectNode) {
					EObjectNode node = (EObjectNode) sel;
					String fragment = node.getEObjectURI().fragment();
					return RoomFragmentProvider.isStructureClass(fragment);
				}
			}
		}

		return false;
	}

}
