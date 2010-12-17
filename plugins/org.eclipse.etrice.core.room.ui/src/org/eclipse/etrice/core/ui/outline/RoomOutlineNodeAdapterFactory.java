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

import org.eclipse.xtext.ui.editor.outline.actions.DefaultContentOutlineNodeAdapterFactory;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.LogicalSystem;

public class RoomOutlineNodeAdapterFactory extends DefaultContentOutlineNodeAdapterFactory {

	private static final Class<?>[] types = { 
		// provide list of classes to adapt to, e.g.:
		// Entity.class
		// Service.class
		ActorClass.class,
		SubSystemClass.class,
		LogicalSystem.class
	};

	@Override
	public Class<?>[] getAdapterList() {
		return types;
	}

}

