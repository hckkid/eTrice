/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.core.ui.outline;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

/**
 * description
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class StructureClassNode extends EObjectNode implements IAdaptable {

	private StructureClass sc;

	/**
	 * @param sc
	 * @param parent
	 * @param image
	 * @param text
	 * @param isLeaf
	 */
	public StructureClassNode(StructureClass sc, IOutlineNode parent,
			Image image, Object text, boolean isLeaf) {
		super(sc, parent, image, text, isLeaf);
		this.sc = sc;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.outline.impl.EObjectNode#getAdapter(java.lang.Class)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapterType) {
		if (adapterType==StructureClass.class
				|| adapterType==ActorClass.class
				|| adapterType==SubSystemClass.class
				|| adapterType==LogicalSystem.class) {
			return sc;
		}
		return super.getAdapter(adapterType);
	}
}
