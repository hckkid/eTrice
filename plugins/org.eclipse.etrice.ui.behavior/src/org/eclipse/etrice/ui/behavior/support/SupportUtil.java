/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.support;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.BaseState;
import org.eclipse.etrice.core.room.EntryPoint;
import org.eclipse.etrice.core.room.ExitPoint;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

/**
 * @author Henrik Rentz-Reichert - Initial contribution and API
 *
 */
public class SupportUtil {
	
	public static boolean isInherited(StateGraphItem item, ContainerShape cs) {
		EObject container = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(cs);
		if (container instanceof StateGraph) {
			StateGraph sg = (StateGraph) container;
			return item.eContainer()!=sg;
		}
		else if (container instanceof State) {
			assert(item instanceof EntryPoint || item instanceof ExitPoint): "this MUST be an entry or exit point";
			
			// have to check whether the State is inherited
			State s = (State) container;
			ContainerShape sCont = cs.getContainer();
			EObject cls = sCont.getLink().getBusinessObjects().get(0);
			return s.eContainer()!=cls;
		}

		return false;
	}
	
	public static boolean isInherited(Diagram diag, EObject obj) {
		if (obj instanceof RefinedState)
			return true;

		ActorClass parent = getActorClass(diag);
		while (obj!=null) {
			if (obj instanceof ActorClass)
				return obj!=parent;
			
			obj = obj.eContainer();
		}
		assert(false): "no parent actor class found";
		return false;
	}

	public static Diagram getDiagram(GraphicsAlgorithm ga) {
		if (ga.eContainer() instanceof GraphicsAlgorithm)
			return getDiagram((GraphicsAlgorithm)ga.eContainer());
		return getDiagram(ga.getPictogramElement());
	}
	
	/**
	 * @param pictogramElement
	 * @return
	 */
	public static Diagram getDiagram(PictogramElement pe) {
		while (pe.eContainer()!=null) {
			if (pe.eContainer() instanceof Diagram)
				return (Diagram) pe.eContainer();
			pe = (PictogramElement) pe.eContainer();
		}
		return null;
	}

	public static ActorClass getActorClass(Diagram diag) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diag);
		if (bo instanceof ActorClass)
			return (ActorClass) bo;
		return null;
	}

	/**
	 * @param sg
	 * @param ac
	 * @param targetContainer
	 * @param fp
	 * @return
	 */
	public static StateGraph insertRefinedState(StateGraph sg, ActorClass ac,
			ContainerShape targetContainer, IFeatureProvider fp) {

		BaseState base = (BaseState) sg.eContainer();
		
		RefinedState rs = null;
		for (State s : ac.getStateMachine().getStates()) {
			if (s instanceof RefinedState)
				if (((RefinedState) s).getBase()==base) {
					rs = (RefinedState) s;
					break;
				}
		}
		if (rs==null) {
			// we have to insert a refined state first
			rs = RoomFactory.eINSTANCE.createRefinedState();
			rs.setBase(base);
			ac.getStateMachine().getStates().add(rs);
		}
		
		// now we create a state graph and change the context
		sg = RoomFactory.eINSTANCE.createStateGraph();
		rs.setSubgraph(sg);
		fp.link(targetContainer, sg);
		return sg;
	}
	
	/**
	 * @param sg
	 * @param ac
	 * @param targetContainer
	 */
	public static void undoInsertRefinedState(StateGraph sg, ActorClass ac,
			ContainerShape targetContainer, IFeatureProvider fp) {
		RefinedState rs = (RefinedState) sg.eContainer();
		fp.link(targetContainer, rs.getBase().getSubgraph());
		
		if (!(RoomHelpers.hasDetailCode(rs.getEntryCode()) || RoomHelpers.hasDetailCode(rs.getExitCode()))) {
			ac.getStateMachine().getStates().remove(rs);
		}
	}

	/**
	 * @param state
	 * @param diagram
	 * @return
	 */
	public static State getTargettingState(State state, Diagram diagram) {
		ActorClass ac = SupportUtil.getActorClass(diagram);
		return RoomHelpers.getTargettingState(state, ac);
	}

}
