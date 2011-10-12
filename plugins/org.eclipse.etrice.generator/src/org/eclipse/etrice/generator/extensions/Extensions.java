/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.extensions;

import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraphNode;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.generator.etricegen.TransitionChain;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class Extensions {

	// public static interface used by Xtend
	
	public static String getActionCodeOperationName(Transition t) {
		return "action_"+RoomNameProvider.getFullPath(t);
	}
	
	public static String getEntryCodeOperationName(State s) {
		return "entry_"+getStatePathName(s);
	}
	
	public static String getExitCodeOperationName(State s) {
		return "exit_"+getStatePathName(s);
	}
	
	public static String getChainId(TransitionChain tc) {
		return "CHAIN_"+RoomNameProvider.getFullPath(tc.getTransition());
	}
	
	public static boolean isTopLevel(StateGraphNode s) {
		return !(s.eContainer().eContainer() instanceof State);
	}
	
	public static State getParentState(StateGraphNode s) {
		if (isTopLevel(s))
			return null;
		else
			return (State) s.eContainer().eContainer();
	}
	
	public static String getStatePathName(State s) {
		return RoomNameProvider.getFullPath(s);
	}
	
	public static String getStateId(State s) {
		if (s==null)
			return "STATE_"+RoomNameProvider.getStateName(s);
		else
			return "STATE_"+RoomNameProvider.getFullPath(s);
	}
	
	public static String getParentStateId(State s) {
		return getStateId(getParentState(s));
	}

}
