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

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.BaseState;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;

class StateGraphContext {
	private ArrayList<StateGraphContext> children = new ArrayList<StateGraphContext>();
	
	private StateGraph stateGraph;
	private ArrayList<State> states = new ArrayList<State>();
	private ArrayList<ChoicePoint> chPoints = new ArrayList<ChoicePoint>();
	private ArrayList<TrPoint> trPoints = new ArrayList<TrPoint>();
	private ArrayList<Transition> transitions = new ArrayList<Transition>();
	
	static HashMap<EObject, StateGraphContext> obj2ctx = new HashMap<EObject, StateGraphContext>();
	
	static StateGraphContext createContextTree(ActorClass ac) {
		
		// TODOHRR: should we have the top level state graph always be the one of our actor class?

		ArrayList<ActorClass> classes = new ArrayList<ActorClass>();
		{
			ActorClass a = ac;
			while (a!=null) {
				classes.add(0, a);
				a = a.getBase();
			}
		}
		
		obj2ctx.clear();
		StateGraphContext tree = null;
		for (ActorClass cls : classes) {
			if (cls.getStateMachine()!=null) {
				if (tree==null)
					tree = new StateGraphContext(cls.getStateMachine());
				else
					tree.merge(cls.getStateMachine());
			}
		}
		
		if (tree==null) {
			// this is the case if no state machine was defined yet
			if (ac.getStateMachine()==null)
				ac.setStateMachine(RoomFactory.eINSTANCE.createStateGraph());
			tree = new StateGraphContext(ac.getStateMachine());
		}
		
		return tree;
	}

	private StateGraphContext(StateGraph sg) {
		this.stateGraph = sg;
		
		init(sg);
	}

	private void init(StateGraph sg) {
		for (State s : sg.getStates()) {
			states.add(s);
			obj2ctx.put(s, this);
		}
		for (ChoicePoint cp : sg.getChPoints()) {
			chPoints.add(cp);
			obj2ctx.put(cp, this);
		}
		for (TrPoint tp : sg.getTrPoints()) {
			trPoints.add(tp);
			obj2ctx.put(tp, this);
		}
		for (Transition t : sg.getTransitions()) {
			transitions.add(t);
			obj2ctx.put(t, this);
		}

		// recurse
		for (State s : sg.getStates()) {
			if (s.getSubgraph()!=null)
				children.add(new StateGraphContext(s.getSubgraph()));
		}
	}

	private void merge(StateGraphContext other) {
		for (State s : other.getStates()) {
			states.add(s);
			obj2ctx.put(s, this);
		}
		for (ChoicePoint cp : other.getChPoints()) {
			chPoints.add(cp);
			obj2ctx.put(cp, this);
		}
		for (TrPoint tp : other.getTrPoints()) {
			trPoints.add(tp);
			obj2ctx.put(tp, this);
		}
		for (Transition t : other.getTransitions()) {
			transitions.add(t);
			obj2ctx.put(t, this);
		}
	}

	private void merge(StateGraph other) {
		// add other contents up to refined states
		for (State s : other.getStates()) {
			if (s instanceof BaseState) {
				states.add(s);
				obj2ctx.put(s, this);
			}
		}
		for (ChoicePoint cp : other.getChPoints()) {
			chPoints.add(cp);
			obj2ctx.put(cp, this);
		}
		for (TrPoint tp : other.getTrPoints()) {
			trPoints.add(tp);
			obj2ctx.put(tp, this);
		}
		for (Transition t : other.getTransitions()) {
			transitions.add(t);
			obj2ctx.put(t, this);
		}

		// recurse
		for (State s : other.getStates()) {
			if (s instanceof BaseState)
				if (s.getSubgraph()!=null)
					children.add(new StateGraphContext(s.getSubgraph()));
		}
		
		// refined states (need no recursion since refined states can only occur on the top level)
		for (State s : other.getStates()) {
			if (s instanceof RefinedState) {
				State base = ((RefinedState) s).getBase();
				StateGraphContext ctx = obj2ctx.get(base);
				assert(ctx!=null): "should have visited base state already";
				
				// remove base and put refined in place
				ctx.getStates().remove(base);
				ctx.getStates().add(s);
				
				// merge contexts
				StateGraphContext sub = null;
				if (base.getSubgraph()!=null || s.getSubgraph()!=null) {
					sub = new StateGraphContext(s.getSubgraph());
					ctx.getChildren().add(sub);
				}
				if (base.getSubgraph()!=null) {
					StateGraphContext basesub = null;
					for (StateGraphContext bs : ctx.getChildren()) {
						if (bs.getParentState()==base) {
							basesub = bs;
							break;
						}
					}
					if (basesub!=null) {
						ctx.getChildren().remove(basesub);
						sub.merge(basesub);
					}
					else {
						assert(false): "context not found";
					}
				}
			}
		}
	}

	public State getParentState() {
		if (stateGraph.eContainer().eContainer() instanceof State)
			return (State) stateGraph.eContainer().eContainer();
		
		return null;
	}

	public ArrayList<StateGraphContext> getChildren() {
		return children;
	}

	public ArrayList<State> getStates() {
		return states;
	}

	public ArrayList<ChoicePoint> getChPoints() {
		return chPoints;
	}

	public StateGraph getStateGraph() {
		return stateGraph;
	}

	public ArrayList<TrPoint> getTrPoints() {
		return trPoints;
	}

	public ArrayList<Transition> getTransitions() {
		return transitions;
	}
}