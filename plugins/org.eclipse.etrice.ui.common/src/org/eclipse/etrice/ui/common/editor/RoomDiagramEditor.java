/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.common.editor;

import org.eclipse.graphiti.ui.editor.DiagramEditor;

/**
 * description
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class RoomDiagramEditor extends DiagramEditor {

	private ModificationTrackingEnabler mte = new ModificationTrackingEnabler();
	
	@SuppressWarnings("restriction")
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		
		mte.setTarget(getEditingDomain());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.internal.editor.DiagramEditorInternal#dispose()
	 */
	@SuppressWarnings("restriction")
	@Override
	public void dispose() {
		mte.unsetTarget(getEditingDomain());
		
		super.dispose();
	}
}
