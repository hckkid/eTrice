/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.core.room.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;

/**
 * description
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class RoomHelpers {
	
	public static List<InterfaceItem> getInterfaceItems(StructureClass sc) {
		ArrayList<InterfaceItem> result = new ArrayList<InterfaceItem>();
		
		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getIfSPPs());
				result.addAll(ac.getIfPorts());
				ac = ac.getBase();
			}
			while (ac!=null);
		}
		else if (sc instanceof SubSystemClass) {
			result.addAll(((SubSystemClass) sc).getIfSPPs());
			result.addAll(((SubSystemClass) sc).getRelayPorts());
		}
		else if (sc instanceof LogicalSystem) {
			// has no interface items
		}
		else {
			assert(false): "unexpected sub type";
		}
		
		return result;
	}

	public static List<ActorContainerRef> getRefs(StructureClass sc) {
		ArrayList<ActorContainerRef> result = new ArrayList<ActorContainerRef>();

		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getActorRefs());
				ac = ac.getBase();
			}
			while (ac!=null);
		}
		else if (sc instanceof SubSystemClass) {
			result.addAll(((SubSystemClass) sc).getActorRefs());
		}
		else if (sc instanceof LogicalSystem) {
			result.addAll(((LogicalSystem) sc).getSubSystems());
		}
		else {
			assert(false): "unexpected sub type";
		}

		return result;
	}
	
	public static List<Binding> getBindings(StructureClass sc) {
		ArrayList<Binding> result = new ArrayList<Binding>();

		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getBindings());
				ac = ac.getBase();
			}
			while (ac!=null);
		}
		else if (sc instanceof SubSystemClass) {
			result.addAll(((SubSystemClass) sc).getBindings());
		}
		else if (sc instanceof LogicalSystem) {
			result.addAll(((LogicalSystem) sc).getBindings());
		}
		else {
			assert(false): "unexpected sub type";
		}

		return result;
	}
	
	public static List<LayerConnection> getConnections(StructureClass sc) {
		ArrayList<LayerConnection> result = new ArrayList<LayerConnection>();

		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getConnections());
				ac = ac.getBase();
			}
			while (ac!=null);
		}
		else if (sc instanceof SubSystemClass) {
			result.addAll(((SubSystemClass) sc).getConnections());
		}
		else if (sc instanceof LogicalSystem) {
			result.addAll(((LogicalSystem) sc).getConnections());
		}
		else {
			assert(false): "unexpected sub type";
		}

		return result;
	}
}
