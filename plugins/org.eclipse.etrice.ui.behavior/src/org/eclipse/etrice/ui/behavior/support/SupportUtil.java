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
import org.eclipse.etrice.core.room.EntryPoint;
import org.eclipse.etrice.core.room.ExitPoint;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;

/**
 * @author Henrik Rentz-Reichert - Initial contribution and API
 *
 */
public class SupportUtil {
	
	public static boolean isInherited(StateGraphItem cp, ContainerShape cs) {
		EObject container = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(cs);
		if (container instanceof StateGraph) {
			StateGraph sg = (StateGraph) container;
			return cp.eContainer()!=sg;
		}
		else if (container instanceof State) {
			assert(cp instanceof EntryPoint || cp instanceof ExitPoint): "this MUST be an entry or exit point";
			
			// have to check whether the State is inherited
			State s = (State) container;
			ContainerShape sCont = cs.getContainer();
			EObject cls = sCont.getLink().getBusinessObjects().get(0);
			return s.eContainer()!=cls;
		}

		return false;
	}
	
	public static boolean isInherited(Diagram diag, EObject obj) {
		ActorClass parent = getActorClass(diag);
		while (obj!=null) {
			if (obj instanceof ActorClass)
				return obj!=parent;
			
			obj = obj.eContainer();
		}
		assert(false): "no parent actor class found";
		return false;
	}

	public static ActorClass getActorClass(Diagram diag) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diag);
		if (bo instanceof ActorClass)
			return (ActorClass) bo;
		return null;
	}

}
