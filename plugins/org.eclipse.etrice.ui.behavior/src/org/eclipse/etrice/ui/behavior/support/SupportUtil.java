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
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.ChoicepointTerminal;
import org.eclipse.etrice.core.room.EntryPoint;
import org.eclipse.etrice.core.room.ExitPoint;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StateTerminal;
import org.eclipse.etrice.core.room.SubStateTrPointTerminal;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.TrPointTerminal;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionTerminal;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.validation.ValidationUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
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
	
	/**
	 * This method exploits the fact that the immediate children of the diagram are
	 * associated with the state graphs.
	 * 
	 * @param shape
	 * @return the container shape that is associated with the state graph of the diagram
	 */
	public static ContainerShape getStateGraphContainer(ContainerShape shape) {
		while (shape!=null) {
			ContainerShape parent = shape.getContainer();
			if (parent instanceof Diagram)
				return shape;
			shape = parent;
		}
		return null;
	}
	
	public static StateGraph getStateGraph(ContainerShape cs, IFeatureProvider fp) {
		ContainerShape shape = getStateGraphContainer(cs);
		Object bo = fp.getBusinessObjectForPictogramElement(shape);
		if (bo instanceof StateGraph)
			return (StateGraph) bo;
		else
			assert(false): "state graph expected";
			
		return null;
	}
	
	public static TransitionTerminal getTransitionTerminal(Anchor anchor, IFeatureProvider fp) {
		if (anchor != null) {
			Object obj = fp.getBusinessObjectForPictogramElement(anchor.getParent());
			if (obj instanceof TrPoint) {
				Object parent = fp.getBusinessObjectForPictogramElement((ContainerShape) anchor.getParent().eContainer());
				if (parent instanceof State) {
					BaseState state = (parent instanceof RefinedState)? ((RefinedState)parent).getBase() : (BaseState)parent;
					SubStateTrPointTerminal sstpt = RoomFactory.eINSTANCE.createSubStateTrPointTerminal();
					sstpt.setState(state);
					sstpt.setTrPoint((TrPoint) obj);
					return sstpt;
				}
				else {
					TrPointTerminal tpt = RoomFactory.eINSTANCE.createTrPointTerminal();
					tpt.setTrPoint((TrPoint) obj);
					return tpt;
				}
			}
			else if (obj instanceof State) {
				BaseState state = (obj instanceof RefinedState)? ((RefinedState)obj).getBase() : (BaseState)obj;
				StateTerminal st = RoomFactory.eINSTANCE.createStateTerminal();
				st.setState(state);
				return st;
			}
			else if (obj instanceof ChoicePoint) {
				ChoicepointTerminal ct = RoomFactory.eINSTANCE.createChoicepointTerminal();
				ct.setCp((ChoicePoint) obj);
				return ct;
			}
		}
		return null;
	}

	public static boolean isInitialPoint(Anchor anchor, IFeatureProvider fp) {
		if (anchor!=null) {
			Object obj = fp.getBusinessObjectForPictogramElement(anchor.getParent());
			if (obj instanceof StateGraph) {
				Object parent = fp.getBusinessObjectForPictogramElement((ContainerShape) anchor.getParent().eContainer());
				if (parent instanceof StateGraph)
					return true;
			}
		}
		return false;
	}

	public static boolean canConnect(Anchor asrc, Anchor atgt, ContainerShape cs, IFeatureProvider fp) {
		return canConnect(asrc, atgt, null, cs, fp);
	}
	
	public static boolean canConnect(Anchor asrc, Anchor atgt, Transition trans, ContainerShape cs, IFeatureProvider fp) {
		TransitionTerminal src = SupportUtil.getTransitionTerminal(asrc, fp);
		TransitionTerminal tgt = SupportUtil.getTransitionTerminal(atgt, fp);
		
		if (src==null && !isInitialPoint(asrc, fp))
			return false;
		if (tgt==null)
			return false;
		
		StateGraph sg = SupportUtil.getStateGraph(cs, fp);
		if (sg==null)
			return false;
		
		return ValidationUtil.isConnectable(src, tgt, trans, sg).isOk();
	}

}
