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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.editor.outline.transformer.AbstractDeclarativeSemanticModelTransformer;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.State;

/**
 * customization of the default outline structure
 * 
 */
public class RoomTransformer extends AbstractDeclarativeSemanticModelTransformer {
	// cf. org.eclipse.xtext.example.ui.outline.FowlerDslTransformer

	// transform actor class
	
	public boolean consumeNode(ActorClass ac) {
		return true;
	}

	public ContentOutlineNode createNode(ActorClass ac, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode result = super.createNode(ac, outlineParentNode);
		if (ac.getIfPorts().size()>0 || ac.getIfSPPs().size()>0) {
			ContentOutlineNode iface = new ContentOutlineNode("Interface");
			result.getChildren().add(iface);
			for (Port port : ac.getIfPorts())
				transformSemanticNode(port, iface);
			for (SPPRef spp : ac.getIfSPPs())
				transformSemanticNode(spp, iface);
		}
		if (ac.getIntPorts().size()>0 || ac.getServiceImplementations().size()>0 ||
				ac.getStrSAPs().size()>0 || ac.getAttributes().size()>0 ||
				ac.getActorRefs().size()>0) {
			ContentOutlineNode structure = new ContentOutlineNode("Structure");
			result.getChildren().add(structure);
			for (Port port : ac.getIntPorts())
				transformSemanticNode(port, structure);
			for (ServiceImplementation svc : ac.getServiceImplementations())
				transformSemanticNode(svc, structure);
			for (SAPRef sap : ac.getStrSAPs())
				transformSemanticNode(sap, structure);
			for (Attribute attr : ac.getAttributes())
				transformSemanticNode(attr, structure);
			for (ActorRef ar : ac.getActorRefs())
				transformSemanticNode(ar, structure);
		}
		if (ac.getOperations().size()>0 || ac.getStateMachine()!=null) {
			ContentOutlineNode behavior = new ContentOutlineNode("Behavior");
			result.getChildren().add(behavior);
			for (Operation op : ac.getOperations())
				transformSemanticNode(op, behavior);
			if (ac.getStateMachine()!=null) {
				ContentOutlineNode sm = new ContentOutlineNode("StateMachine");
				behavior.getChildren().add(sm);
				for (State s : ac.getStateMachine().getStates()) {
					transformSemanticNode(s, sm);
				}
			}
		}
		return result;
	}

	public List<EObject> getChildren(ActorClass ac) {
		return Collections.emptyList();
	}

	// transform state
	
	public boolean consumeNode(State state) {
		return true;
	}

	public ContentOutlineNode createNode(State state, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode result = super.createNode(state, outlineParentNode);
		
		if (state.getSubgraph()!=null)
			for (State s : state.getSubgraph().getStates()) {
				transformSemanticNode(s, result);
			}
		
		return result;
	}

	public List<EObject> getChildren(State state) {
		return Collections.emptyList();
	}
	
	// transform protocol
	
	public boolean consumeNode(ProtocolClass pc) {
		return true;
	}

	public ContentOutlineNode createNode(ProtocolClass pc, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode result = super.createNode(pc, outlineParentNode);
		
		if (pc.getIncomingMessages().size()>0) {
			ContentOutlineNode msgs = new ContentOutlineNode("incoming");
			result.getChildren().add(msgs);
			for (Message m : pc.getIncomingMessages())
				transformSemanticNode(m, msgs);
		}
		
		if (pc.getOutgoingMessages().size()>0) {
			ContentOutlineNode msgs = new ContentOutlineNode("outgoing");
			result.getChildren().add(msgs);
			for (Message m : pc.getOutgoingMessages())
				transformSemanticNode(m, msgs);
		}
		
		return result;
	}

	public List<EObject> getChildren(ProtocolClass pc) {
		return Collections.emptyList();
	}
	
	public boolean consumeNode(Message m) {
		return true;
	}

	public List<EObject> getChildren(Message m) {
		return Collections.emptyList();
	}
	
	public boolean consumeNode(Operation op) {
		return true;
	}

	public List<EObject> getChildren(Operation op) {
		return Collections.emptyList();
	}
}
