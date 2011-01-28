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

package org.eclipse.etrice.ui.behavior.support;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

public class ContextSwitcher {

	public static void goUp(Diagram diagram, StateGraph sg) {
		if (sg.eContainer() instanceof State) {
			State s = (State) sg.eContainer();
			
			// we follow the chain of base states
			while (s instanceof RefinedState)
				s = ((RefinedState)s).getBase();
			
			// and finally go up
			StateGraph superSG = (StateGraph) s.eContainer();
			ContextSwitcher.switchTo(diagram, superSG);
		}
	}
	
	public static void switchTo(Diagram diagram, StateGraph sg) {
		for (Shape ctxShape : diagram.getChildren()) {
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(ctxShape);
			assert(bo instanceof StateGraph): "expected state graph";
			
			if (bo instanceof StateGraph && bo==sg)
				activateContext(ctxShape, true);
			else
				activateContext(ctxShape, false);
		}
		
		activateTransitions(diagram);
	}

	public static ContainerShape getContext(Diagram diagram, StateGraph sg) {
		for (Shape ctxShape : diagram.getChildren()) {
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(ctxShape);
			assert(bo instanceof StateGraph): "expected state graph";
			
			if (bo instanceof StateGraph && bo==sg)
				return (ContainerShape) ctxShape;
		}
		return null;
	}
	
	private static void activateTransitions(Diagram diagram) {
		for (Connection conn : diagram.getConnections()) {
			boolean visible = conn.getStart().getParent().isVisible();
			conn.setVisible(visible);
			for (ConnectionDecorator dec : conn.getConnectionDecorators()) {
				dec.setVisible(visible);
			}
		}
	}

	private static void activateContext(Shape ctxShape, boolean activate) {
		ctxShape.setVisible(activate);
		TreeIterator<EObject> it = ctxShape.eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof Shape) {
				((Shape) obj).setVisible(activate);
			}
		}
	}
}
