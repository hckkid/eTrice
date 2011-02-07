/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class AddMssingTransitionNamesCommand extends RecordingCommand {

	private Diagram diagram;

	/**
	 * @param domain
	 * @param label
	 * @param description
	 */
	public AddMssingTransitionNamesCommand(Diagram diag, TransactionalEditingDomain domain) {
		super(domain);
		diagram = diag;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected void doExecute() {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		if (bo instanceof ActorClass) {
			ActorClass ac = (ActorClass) bo;
			addMssingTransitionNames(ac.getStateMachine());
		}
	}

	/**
	 * recursively set transition names where missing
	 * 
	 * @param sg
	 */
	private void addMssingTransitionNames(StateGraph sg) {
		for (Transition trans : sg.getTransitions()) {
			if (trans.getName()==null || trans.getName().isEmpty()) {
				String name = RoomNameProvider.getUniqueTransitionName(sg);
				trans.setName(name);
			}
		}
		
		for (State s : sg.getStates()) {
			if (s.getSubgraph()!=null)
				addMssingTransitionNames(s.getSubgraph());
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.transaction.RecordingCommand#canUndo()
	 */
	@Override
	public boolean canUndo() {
		// it should not be allowed to undo this command
		return false;
	}
}
