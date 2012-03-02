/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.commands.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.ui.behavior.editor.BehaviorExporter;
import org.eclipse.etrice.ui.structure.editor.StructureExporter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class ExportDiagramsHandler extends AbstractHandler {

	@Inject
	protected IResourceValidator resourceValidator;

	public ExportDiagramsHandler() {
		super();
		
		Injector injector = RoomUiModule.getInjector();
		injector.injectMembers(this);
	}

	// TODO: code copied from org.eclipse.etrice.ui.commands.handlers.AbstractEditHandler - refactor
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final IEditorPart editor = window.getActivePage().getActiveEditor();
		if (editor instanceof XtextEditor) {
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			if (selection instanceof IStructuredSelection) {
				// event from the xtext editor's outline view
				IStructuredSelection ss = (IStructuredSelection) selection;
				Object sel = ss.getFirstElement();
				if (sel instanceof EObjectNode) {
					XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor(event);
					IXtextDocument document = xtextEditor.getDocument();
					final String fragment = ((EObjectNode) sel).getEObjectURI().fragment();
					if (checkPrerequisites(xtextEditor, document, fragment)) {
						document.readOnly(new IUnitOfWork.Void<XtextResource>() {
							@Override
							public void process(XtextResource resource) throws Exception {
								if (resource != null) {
									EObject object = resource.getEObject(fragment);
									
									if (object instanceof RoomModel)
										exportDiagrams((RoomModel)object, editor.getSite().getShell());
								}
							}
						});
					}
				}
			}
		}
		return null;
	}

	protected void exportDiagrams(RoomModel model, Shell shell) {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(shell,
				ResourcesPlugin.getWorkspace().getRoot(),
				false,
				"Select a destination folder:");
		dialog.showClosedProjects(false);
		dialog.open();
		Object[] results = dialog.getResult();	
		if ((results != null) && (results.length > 0) && (results[0] instanceof IPath)) {
			IPath path = (IPath)results[0];
			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			IFolder file = workspaceRoot.getFolder(path);
			String folder = file.getLocation().toOSString();
		
			for (ActorClass ac : model.getActorClasses()) {
				if (ac.getStateMachine()!=null)
					BehaviorExporter.export(ac, folder);
				
				StructureExporter.export(ac, folder);
			}
			
			for (SubSystemClass ssc : model.getSubSystemClasses()) {
				StructureExporter.export(ssc, folder);
			}
		}
	}

	// TODO: code copied from org.eclipse.etrice.ui.commands.handlers.AbstractEditHandler - refactor
	protected boolean checkPrerequisites(XtextEditor xtextEditor,
			IXtextDocument document, final String fragment) {
		if (hasIssues(document, new NullProgressMonitor())) {
			MessageDialog.openError(xtextEditor.getSite().getShell(), "Validation Errors", "The editor has validation errors.\nCannot open diagram!");
			return false;
		}
		if (xtextEditor.isDirty()) {
			if (!MessageDialog.openQuestion(xtextEditor.getSite().getShell(), "Save model file", "The editor will be saved before opening the diagram editor.\nProceed?"))
				return false;
			// postpone save to avoid doing it twice
		}
		if (xtextEditor.isDirty()) {
			xtextEditor.doSave(new NullProgressMonitor());
		}
		return true;
	}

	// TODO: code copied from org.eclipse.etrice.ui.commands.handlers.AbstractEditHandler - refactor
	public boolean hasIssues(IXtextDocument xtextDocument, final IProgressMonitor monitor) {
		final boolean issues = xtextDocument
				.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
					public Boolean exec(XtextResource resource) throws Exception {
						if (resource == null)
							return false;
						List<Issue> issueList = resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, new CancelIndicator() {
							public boolean isCanceled() {
								return monitor.isCanceled();
							}
						});
						for (Issue issue : issueList) {
							if (issue.getSeverity()==Severity.ERROR)
								return true;
						}
						return false;
					}
				});
		return issues;
	}

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
					return fragment.equals("/");
				}
			}
		}
		return false;
	}

}
