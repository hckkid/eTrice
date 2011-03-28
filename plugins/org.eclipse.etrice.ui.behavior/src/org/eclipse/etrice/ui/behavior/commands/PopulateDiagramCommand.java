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

package org.eclipse.etrice.ui.behavior.commands;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.ChoicepointTerminal;
import org.eclipse.etrice.core.room.EntryPoint;
import org.eclipse.etrice.core.room.ExitPoint;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.NonInitialTransition;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateTerminal;
import org.eclipse.etrice.core.room.SubStateTrPointTerminal;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.TrPointTerminal;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionTerminal;
import org.eclipse.etrice.ui.behavior.support.ChoicePointSupport;
import org.eclipse.etrice.ui.behavior.support.ContextSwitcher;
import org.eclipse.etrice.ui.behavior.support.StateGraphSupport;
import org.eclipse.etrice.ui.behavior.support.StateSupport;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;


public class PopulateDiagramCommand extends RecordingCommand {

	private static final String INITIAL = "init";
	private static final String STATE = "state:";
	private static final String TP = "tp:";
	private static final String CP = "cp:";
	private static final String SEP = ".";

	private ActorClass ac;
	private Diagram diagram;
	private IFeatureProvider fp;

	public PopulateDiagramCommand(Diagram diag, ActorClass ac, TransactionalEditingDomain domain) {
		super(domain);
		this.diagram = diag;
		this.ac = ac;

		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram, "org.eclipse.etrice.ui.behavior.diagramTypeProvider"); //$NON-NLS-1$
		fp = dtp.getFeatureProvider();
	}

	@Override
	protected void doExecute() {
		
		fp.link(diagram, ac);
		
		// we use a temporary structure to create the whole tree
		StateGraphContext tree = StateGraphContext.createContextTree(ac);
		
		addStateGraph(tree, diagram);
		
		ContextSwitcher.switchTop(diagram);
	}

	private void addStateGraph(StateGraphContext ctx, ContainerShape parent) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(ctx.getStateGraph());
		addContext.setTargetContainer(parent);
		addContext.setX(StateGraphSupport.MARGIN);
		addContext.setY(StateGraphSupport.MARGIN);
		
		ContainerShape sgShape = (ContainerShape) fp.addIfPossible(addContext);
		if (sgShape==null)
			return;
		
		final HashMap<String, Anchor> node2anchor = new HashMap<String, Anchor>();
		
		addInitialPointIff(ctx.getStateGraph(), sgShape, node2anchor);
		addTransitionPoints(ctx.getStateGraph(), sgShape, node2anchor);
		addStates(ctx.getStateGraph(), sgShape, node2anchor);
		addChoicePoints(ctx.getStateGraph(), sgShape, node2anchor);

		for (StateGraphContext sub : ctx.getChildren()) {
			addStateGraph(sub, parent);
		}
		
		getSubTpAnchors(sgShape, node2anchor);
		
		addTransitions(ctx.getStateGraph(), sgShape, node2anchor);
	}

	/**
	 * @param sgShape
	 * @param node2anchor
	 */
	private void getSubTpAnchors(ContainerShape sgShape, HashMap<String, Anchor> node2anchor) {
		for (Shape childShape : sgShape.getChildren()) {
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(childShape);
			if (bo instanceof State)
				getAnchors((State) bo, childShape, node2anchor);
		}
	}

	private void addTransitions(StateGraph ctx, ContainerShape sgShape,
			HashMap<String, Anchor> node2anchor) {

		for (Transition trans : ctx.getTransitions()) {
			String from = (trans instanceof InitialTransition)? INITIAL:getKey(((NonInitialTransition)trans).getFrom(), ctx);
			String to = getKey(trans.getTo(), ctx);
			Anchor src = node2anchor.get(from);
			Anchor dst = node2anchor.get(to);

			assert(src!=null && dst!=null): "transition endpoints must be present";
			
			AddConnectionContext context = new AddConnectionContext(src, dst);
			context.setNewObject(trans);
			PictogramElement pe = fp.addIfPossible(context);
			if (src==dst && pe instanceof FreeFormConnection) {
				FreeFormConnection conn = (FreeFormConnection) pe;
				ILocation begin = Graphiti.getPeService().getLocationRelativeToDiagram(conn.getStart());
				Point pt = Graphiti.getGaService().createPoint(begin.getX(), begin.getY()+StateGraphSupport.MARGIN*3);
				conn.getBendpoints().add(pt);
			}
		}
	}

	private void addTransitionPoints(StateGraph ctx, ContainerShape sgShape,
			HashMap<String, Anchor> node2anchor) {
		
		int width = sgShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0).getWidth();
		int n = ctx.getTrPoints().size();
		int delta = width/(n+1);
		
		int pos = delta;
		for (TrPoint tp : ctx.getTrPoints()) {
			addTrPoint(tp, ctx, sgShape, pos+StateSupport.MARGIN, node2anchor);
			pos += delta;
		}
	}

	private void addTrPoint(TrPoint tp, StateGraph sg, ContainerShape sgShape,
			int pos, HashMap<String, Anchor> node2anchor) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(tp);
		addContext.setTargetContainer(sgShape);
		addContext.setX(pos);
		addContext.setY(0);
		
		ContainerShape pe = (ContainerShape) fp.addIfPossible(addContext);
		assert(!pe.getAnchors().isEmpty()): "transition point should have an anchor";
		node2anchor.put(getKey(tp, sg), pe.getAnchors().get(0));
	}

	private void addStates(StateGraph sg, ContainerShape sgShape,
			HashMap<String, Anchor> node2anchor) {
		
		int width = sgShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0).getWidth();
		int n = sg.getStates().size();
		int delta = width/(n+1);
		
		int pos = delta;
		for (State s : sg.getStates()) {
			addState(s, sg, sgShape, pos+StateSupport.MARGIN, node2anchor);
			pos += delta;
		}
	}

	private void addState(State s, StateGraph sg, ContainerShape sgShape,
			int pos, HashMap<String, Anchor> node2anchor) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(s);
		addContext.setTargetContainer(sgShape);
		addContext.setX(pos);
		addContext.setY(StateGraphSupport.DEFAULT_SIZE_Y/4);
		
		ContainerShape pe = (ContainerShape) fp.addIfPossible(addContext);
		assert(pe!=null): "state should have been created";
		assert(!pe.getAnchors().isEmpty()): "state should have an anchor";
	}

	private void addChoicePoints(StateGraph sg, ContainerShape sgShape,
			HashMap<String, Anchor> node2anchor) {
		
		int width = sgShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0).getWidth();
		int n = sg.getChPoints().size();
		int delta = width/(n+1);
		
		int pos = delta;
		for (ChoicePoint cp : sg.getChPoints()) {
			addChoicePoint(cp, sg, sgShape, pos+ChoicePointSupport.ITEM_SIZE, node2anchor);
			pos += delta;
		}
	}

	private void addChoicePoint(ChoicePoint cp, StateGraph sg, ContainerShape sgShape,
			int pos, HashMap<String, Anchor> node2anchor) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(cp);
		addContext.setTargetContainer(sgShape);
		addContext.setX(pos);
		addContext.setY(StateGraphSupport.DEFAULT_SIZE_Y/2);
		
		ContainerShape pe = (ContainerShape) fp.addIfPossible(addContext);
		assert(pe!=null): "choice point should have been created";
		assert(!pe.getAnchors().isEmpty()): "choice point should have an anchor";
		node2anchor.put(getKey(cp, sg), pe.getAnchors().get(0));
	}

	private void addInitialPointIff(StateGraph sg, ContainerShape sgShape,
			HashMap<String, Anchor> node2anchor) {

		boolean hasInitialTransition = false;
		for (Transition t : sg.getTransitions()) {
			if (t instanceof InitialTransition) {
				hasInitialTransition = true;
				break;
			}
		}
		if (!hasInitialTransition)
			return;
		
		AddContext addContext = new AddContext();
		addContext.setNewObject(sg);
		addContext.setTargetContainer(sgShape);
		addContext.setX(3*StateGraphSupport.MARGIN);
		addContext.setY(3*StateGraphSupport.MARGIN);
		
		ContainerShape pe = (ContainerShape) fp.addIfPossible(addContext);
		assert(pe!=null): "initial point should have been created";
		assert(!pe.getAnchors().isEmpty()): "initial point should have an anchor";
		node2anchor.put(INITIAL, pe.getAnchors().get(0));
	}

	private void getAnchors(State state, PictogramElement stateShape,
			final HashMap<String, Anchor> node2anchor) {
		
		if (stateShape instanceof ContainerShape) {
			node2anchor.put(getKey(state, null), ((ContainerShape)stateShape).getAnchors().get(0));
			for (Shape child : ((ContainerShape) stateShape).getChildren()) {
				if (child instanceof ContainerShape) {
					ContainerShape childShape = (ContainerShape) child;
					if (!childShape.getAnchors().isEmpty()) {
						if (!childShape.getLink().getBusinessObjects().isEmpty()) {
							EObject obj = childShape.getLink().getBusinessObjects().get(0);
							if (obj instanceof EntryPoint || obj instanceof ExitPoint) {
								node2anchor.put(getKey(obj, null), childShape.getAnchors().get(0));
							}
						}
					}
				}
			}
		}
	}

	private static String getKey(EObject obj, StateGraph sg) {
		if (obj instanceof TrPoint) {
			TrPoint tp = (TrPoint) obj;
			if (tp.eContainer()==sg)
				return TP+tp.getName();
			else {
				if (tp.eContainer().eContainer() instanceof State) {
					State s = (State) tp.eContainer().eContainer();
					return TP+tp.getName()+SEP+s.getName();
				}
				else {
					assert(false): "State expected";
				}
			}
		}
		else if (obj instanceof State) {
			return STATE+((State)obj).getName();
		}
		else if (obj instanceof ChoicePoint) {
			return CP+((ChoicePoint)obj).getName();
		}
		else if (obj instanceof TransitionTerminal) {
			TransitionTerminal tt = (TransitionTerminal) obj;
			if (tt instanceof ChoicepointTerminal) {
				return CP+((ChoicepointTerminal)tt).getCp().getName();
			}
			else if (tt instanceof StateTerminal) {
				return STATE+((StateTerminal)tt).getState().getName();
			}
			else if (tt instanceof SubStateTrPointTerminal) {
				SubStateTrPointTerminal sstt = (SubStateTrPointTerminal) tt;
				return TP+sstt.getTrPoint().getName()+SEP+sstt.getState().getName();
			}
			else if (tt instanceof TrPointTerminal) {
				return TP+((TrPointTerminal)tt).getTrPoint().getName();
			}
			else {
				assert(false): "unexpected sub type";
			}
		}
		assert(false): "unexpected type";
		return null;
	}
}
