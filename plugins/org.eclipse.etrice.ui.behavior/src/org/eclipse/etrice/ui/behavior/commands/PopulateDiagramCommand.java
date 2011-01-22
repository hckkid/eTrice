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
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.NonInitialTransition;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateTerminal;
import org.eclipse.etrice.core.room.SubStateTrPointTerminal;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.TrPointTerminal;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionTerminal;
import org.eclipse.etrice.ui.behavior.support.StateGraphSupport;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
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

	public PopulateDiagramCommand(Diagram diag, ActorClass ac, TransactionalEditingDomain domain) {
		super(domain);
		this.diagram = diag;
		this.ac = ac;
	}

	@Override
	protected void doExecute() {
		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram, "org.eclipse.etrice.ui.behavior.diagramTypeProvider"); //$NON-NLS-1$
		IFeatureProvider fp = dtp.getFeatureProvider();
		
		if (ac.getStateMachine()==null)
			ac.setStateMachine(RoomFactory.eINSTANCE.createStateGraph());
		
		addStateGraph(ac.getStateMachine(), fp);
	}

	private void addStateGraph(StateGraph sg, IFeatureProvider fp) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(sg);
		addContext.setTargetContainer(diagram);
		addContext.setX(StateGraphSupport.MARGIN);
		addContext.setY(StateGraphSupport.MARGIN);
		
		ContainerShape sgShape = (ContainerShape) fp.addIfPossible(addContext);
		if (sgShape!=null) {
			final HashMap<String, Anchor> node2anchor = new HashMap<String, Anchor>();
			
			addInitialPointIff(sg, sgShape, fp, node2anchor);
			addTransitionPoints(sg, sgShape, fp, node2anchor);
			addStates(sg, sgShape, fp, node2anchor);
			addChoicePoints(sg, sgShape, fp, node2anchor);
			
			addTransitions(sg, sgShape, fp, node2anchor);
		}
	}

	private void addTransitions(StateGraph sg, ContainerShape sgShape,
			IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {

		for (Transition trans : sg.getTransitions()) {
			String from = (trans instanceof InitialTransition)? INITIAL:getKey(((NonInitialTransition)trans).getFrom(), sg);
			String to = getKey(trans.getTo(), sg);
			Anchor src = node2anchor.get(from);
			Anchor dst = node2anchor.get(to);

			assert(src!=null && dst!=null): "transition enpoints must be present";
			
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

	private void addTransitionPoints(StateGraph sg, ContainerShape sgShape,
			IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
		
		int width = sgShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0).getWidth();
		int n = sg.getTrPoints().size();
		int delta = width/(n+1);
		
		int pos = delta;
		for (TrPoint tp : sg.getTrPoints()) {
			addTrPoint(tp, sg, sgShape, pos, fp, node2anchor);
			pos += delta;
		}
	}

	private void addTrPoint(TrPoint tp, StateGraph sg, ContainerShape sgShape,
			int pos, IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
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
			IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
		
		int width = sgShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0).getWidth();
		int n = sg.getStates().size();
		int delta = width/(n+1);
		
		int pos = delta;
		for (State s : sg.getStates()) {
			addState(s, sg, sgShape, pos, fp, node2anchor);
			pos += delta;
		}
	}

	private void addState(State s, StateGraph sg, ContainerShape sgShape,
			int pos, IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(s);
		addContext.setTargetContainer(sgShape);
		addContext.setX(pos);
		addContext.setY(StateGraphSupport.DEFAULT_SIZE_Y/4);
		
		ContainerShape pe = (ContainerShape) fp.addIfPossible(addContext);
		assert(!pe.getAnchors().isEmpty()): "state should have an anchor";
		node2anchor.put(getKey(s, sg), pe.getAnchors().get(0));
	}

	private void addChoicePoints(StateGraph sg, ContainerShape sgShape,
			IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
		
		int width = sgShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0).getWidth();
		int n = sg.getChPoints().size();
		int delta = width/(n+1);
		
		int pos = delta;
		for (ChoicePoint cp : sg.getChPoints()) {
			addChoicePoint(cp, sg, sgShape, pos, fp, node2anchor);
			pos += delta;
		}
	}

	private void addChoicePoint(ChoicePoint cp, StateGraph sg, ContainerShape sgShape,
			int pos, IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(cp);
		addContext.setTargetContainer(sgShape);
		addContext.setX(pos);
		addContext.setY(StateGraphSupport.DEFAULT_SIZE_Y/2);
		
		ContainerShape pe = (ContainerShape) fp.addIfPossible(addContext);
		assert(!pe.getAnchors().isEmpty()): "choice point should have an anchor";
		node2anchor.put(getKey(cp, sg), pe.getAnchors().get(0));
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

	private void addInitialPointIff(StateGraph sg, ContainerShape sgShape,
			IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {

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
		assert(!pe.getAnchors().isEmpty()): "initial point should have an anchor";
		node2anchor.put(INITIAL, pe.getAnchors().get(0));
	}
}
