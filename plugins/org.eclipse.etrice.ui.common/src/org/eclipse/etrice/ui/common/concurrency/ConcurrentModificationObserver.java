/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Jan Koehnlein (Itemis, initially from org.eclipse.xtext.gmf.glue)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.concurrency;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * Detects concurrent modifications of Graphiti (eTrice structure and behavior)
 * and Xtext editors based on Xtext's dirty state management.
 * 
 * @author Jan Koehnlein
 * @author Henrik Rentz-Reichert
 * 
 */
public class ConcurrentModificationObserver implements IPartListener {

	private EditingDomainAdapter.Factory factory;

	public ConcurrentModificationObserver(IWorkbenchPage activePage) {
		factory = new EditingDomainAdapter.Factory();
		for (IEditorReference editorRef : activePage.getEditorReferences()) {
			IEditorPart editor = editorRef.getEditor(false);
			if (editor != null) {
				partOpened(editor);
			}
		}
	}

	public void partOpened(IWorkbenchPart part) {
		Object adapter = part.getAdapter(IEditingDomainProvider.class);
		if (adapter instanceof IEditingDomainProvider) {
			EditingDomain editingDomain = ((IEditingDomainProvider) adapter).getEditingDomain();
			if (editingDomain instanceof TransactionalEditingDomain)
				factory.adapt(editingDomain, EditingDomainAdapter.class);
		}
	}

	public void partClosed(IWorkbenchPart part) {
		Object adapter = part.getAdapter(IEditingDomainProvider.class);
		if (adapter instanceof IEditingDomainProvider) {
			EditingDomain editingDomain = ((IEditingDomainProvider) adapter).getEditingDomain();
			if (editingDomain instanceof TransactionalEditingDomain) {
				EditingDomainAdapter editingDomainAdapter = (EditingDomainAdapter) factory.adapt(editingDomain,
						EditingDomainAdapter.class);
				if (editingDomainAdapter != null) {
					editingDomainAdapter.dispose();
				}
			}
		}
	}

	public void partActivated(IWorkbenchPart part) {
		// do nothing
	}

	public void partDeactivated(IWorkbenchPart part) {
		// do nothing
	}

	public void partBroughtToTop(IWorkbenchPart part) {
		// do nothing
	}

	public static class Initializer implements IStartup {
		public void earlyStartup() {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					activePage.addPartListener(new ConcurrentModificationObserver(activePage));
				}
			});
		}
	}

}
