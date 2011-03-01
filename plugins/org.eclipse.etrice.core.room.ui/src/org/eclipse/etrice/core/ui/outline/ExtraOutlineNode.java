/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.core.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.ui.internal.RoomActivator;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

/**
 * description
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class ExtraOutlineNode extends EObjectNode {

	public ExtraOutlineNode(EObject obj, IOutlineNode parent, Object text) {
		super(obj, parent, RoomActivator.getInstance().getImageRegistry().get("defaultoutlinenode.gif"), text, false);
	}

}
