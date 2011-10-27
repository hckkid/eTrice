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
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.util.RoomHelpers;

class StateGraphContext {
	private ArrayList<StateGraphContext> children = new ArrayList<StateGraphContext>();
	
	private StateGraph stateGraph;
	private ArrayList<State> states = new ArrayList<State>();
	private ArrayList<ChoicePoint> chPoints = new ArrayList<ChoicePoint>();
	private ArrayList<TrPoint> trPoints = new ArrayList<TrPoint>();
	private ArrayList<Transition> transitions = new ArrayList<Transition>();
	
	static HashMap<EObject, StateGraphContext> obj2ctx = new HashMap<EObject, StateGraphContext>();
	
	static StateGraphContext createContextTree(ActorClass ac) {
		
		// the top level state graph is always the one of our actor class
		if (ac.getStateMachine()==null || ac.getStateMachine().eIsProxy()) {
			ac.setStateMachine(RoomFactory.eINSTANCE.createStateMachine());
		}
		
		// base classes in reverse order
		ArrayList<ActorClass> classes = new ArrayList<ActorClass>();
		{
			ActorClass a = ac;
			while (a!=null) {
				classes.add(0, a);
				a = a.getBase();
			}
		}
		
		// build and merge contexts from base classes to derived classes
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

	private void merge(StateGraphContext derived) {
		for (State s : derived.getStates()) {
			states.add(s);
			obj2ctx.put(s, this);
		}
		for (ChoicePoint cp : derived.getChPoints()) {
			chPoints.add(cp);
			obj2ctx.put(cp, this);
		}
		for (TrPoint tp : derived.getTrPoints()) {
			trPoints.add(tp);
			obj2ctx.put(tp, this);
		}
		for (Transition t : derived.getTransitions()) {
			transitions.add(t);
			obj2ctx.put(t, this);
		}
	}

	private void merge(StateGraph derived) {
		stateGraph = derived;
		
		// add derived contents up to refined states
		for (State s : derived.getStates()) {
			if (s instanceof BaseState) {
				states.add(s);
				obj2ctx.put(s, this);
			}
		}
		for (ChoicePoint cp : derived.getChPoints()) {
			chPoints.add(cp);
			obj2ctx.put(cp, this);
		}
		for (TrPoint tp : derived.getTrPoints()) {
			trPoints.add(tp);
			obj2ctx.put(tp, this);
		}
		for (Transition t : derived.getTransitions()) {
			transitions.add(t);
			obj2ctx.put(t, this);
		}

		// recurse for non-refined states
		for (State s : derived.getStates()) {
			if (s instanceof BaseState)
				if (s.getSubgraph()!=null)
					children.add(new StateGraphContext(s.getSubgraph()));
		}
		
		// refined states (need no recursion since refined states can only occur on the top level)
		for (State refined : derived.getStates()) {
			if (refined instanceof RefinedState) {
				State base = ((RefinedState) refined).getBase();
				StateGraphContext ctx = obj2ctx.get(base);
				assert(ctx!=null): "should have visited base state already";
				
				// remove base and put refined in place
				ctx.getStates().remove(base);
				ctx.getStates().add(refined);
				
				// merge sub contexts
				StateGraphContext sub = null;
				if (RoomHelpers.hasDirectSubStructure(refined)) {
					sub = new StateGraphContext(refined.getSubgraph());
					ctx.getChildren().add(sub);
				}
				if (RoomHelpers.hasDirectSubStructure(base)) {
					StateGraphContext basesub = null;
					for (StateGraphContext bs : ctx.getChildren()) {
						if (bs.getParentState()==base) {
							basesub = bs;
							break;
						}
					}
					if (basesub!=null) {
						if (sub!=null) {
							ctx.getChildren().remove(basesub);
							sub.merge(basesub);
						}
					}
					else {
						assert(false): "context not found";
					}
				}
			}
		}
	}

	public State getParentState() {
		if (stateGraph.eContainer() instanceof State)
			return (State) stateGraph.eContainer();
		
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return dump("");
	}
	
	/**
	 * @param indent
	 * @return context tree in human readable form
	 */
	private String dump(String indent) {
		StringBuilder result = new StringBuilder();
		result.append(indent+">>> "+getText(stateGraph)+"\n");
		indent += "  ";
		for (State s : states) {
			result.append(indent+getText(s)+"\n");
		}
		
		for (StateGraphContext child : children) {
			result.append(child.dump(indent));
		}
		return result.toString();
	}

	private String getText(StateGraph sg) {
		ActorClass parent = getActorClass(sg);
		return "state graph of "+(parent==null? "?":parent.getName());
	}

	private String getText(StateGraphItem sg) {
		ActorClass parent = getActorClass(sg);
		String name = "?";
		if (sg instanceof State)
			name = "st "+((State) sg).getName();
		else if (sg instanceof TrPoint)
			name = "tp "+((TrPoint) sg).getName();
		return name+" of "+(parent==null? "?":parent.getName());
	}

	private ActorClass getActorClass(EObject obj) {
		EObject parent = obj.eContainer();
		while (parent!=null) {
			if (parent instanceof ActorClass)
				return (ActorClass) parent;
			parent = parent.eContainer();
		}
		return null;
	}
}