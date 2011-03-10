/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.core.ui.outline;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.ui.internal.RoomActivator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * description
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public abstract class AbstractEditHandler extends AbstractHandler {

	@Inject
	protected IResourceValidator resourceValidator;
	
	public AbstractEditHandler() {
		super();
		
		Injector injector = RoomActivator.getInstance().getInjector("org.eclipse.etrice.core.Room");
		injector.injectMembers(this);
	}

	abstract protected boolean prepare(XtextEditor xtextEditor, final String fragment);
	abstract protected void openEditor(EObject object);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) selection;
			Object sel = ss.getFirstElement();
			if (sel instanceof ContentOutlineNode) {
				XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor(event);
				IXtextDocument document = xtextEditor.getDocument();
				if (hasIssues(document, new NullProgressMonitor())) {
					MessageDialog.openError(xtextEditor.getSite().getShell(), "Validation Errors", "The editor has validation errors.\nCannot open diagram!");
					return null;
				}
				if (xtextEditor.isDirty()) {
					if (!MessageDialog.openQuestion(xtextEditor.getSite().getShell(), "Save model file", "The editor will be saved before opening the diagram editor.\nProceed?"))
						return null;
					// postpone save to avoid doing it twice
				}
				final String fragment = ((ContentOutlineNode) sel).getURI().fragment();
				if (!prepare(xtextEditor, fragment))
					return null;
				if (xtextEditor.isDirty()) {
					xtextEditor.doSave(new NullProgressMonitor());
				}
				document.readOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						if (resource != null) {
							EObject object = resource.getEObject(fragment);
							openEditor(object);
						}
					}
				});
			}
		}
		return null;
	}

	public boolean hasIssues(IXtextDocument xtextDocument, final IProgressMonitor monitor) {
		final boolean issues = xtextDocument
				.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
					public Boolean exec(XtextResource resource) throws Exception {
						if (resource == null)
							return false;
						return !resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, new CancelIndicator() {
							public boolean isCanceled() {
								return monitor.isCanceled();
							}
						}).isEmpty();
					}
				});
		return issues;
	}
}
