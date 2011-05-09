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

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.ui.common.editor.RoomDiagramEditor;
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
		if (part instanceof RoomDiagramEditor) {
			@SuppressWarnings("restriction")
			TransactionalEditingDomain editingDomain = ((RoomDiagramEditor) part).getEditingDomain();
			factory.adapt(editingDomain, EditingDomainAdapter.class);
		}
	}

	public void partClosed(IWorkbenchPart part) {
		if (part instanceof RoomDiagramEditor) {
			// as long as bug 299920 is not fixed, we have to dispose the adapter manually
			@SuppressWarnings("restriction")
			TransactionalEditingDomain editingDomain = ((RoomDiagramEditor) part).getEditingDomain();
			if (editingDomain != null) {
				EditingDomainAdapter adapter = (EditingDomainAdapter) factory.adapt(editingDomain,
						EditingDomainAdapter.class);
				if (adapter != null) {
					adapter.dispose();
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
