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


package org.eclipse.etrice.core.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.BaseState;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;


public class RoomQualifiedNameProvider extends
		DefaultDeclarativeQualifiedNameProvider {

    public QualifiedName qualifiedName(RefinedState rs) {
    	QualifiedName fqn = QualifiedName.create();
		BaseState base = rs.getBase();
		if (base!=null)
		{
			fqn = QualifiedName.create(base.getName());
			EObject parent = base.eContainer();
			while (parent instanceof BaseState) {
				fqn = QualifiedName.create(((BaseState)parent).getName()).append(fqn);
				parent = parent.eContainer();
			}
		}
		return fqn;
    }

    public QualifiedName qualifiedName(Message m) {
    	ProtocolClass pc = (ProtocolClass) m.eContainer();
    	String list;
    	if (pc.getIncomingMessages().contains(m))
    		list = "in";
    	else
    		list = "out";
    	
    	return getFullyQualifiedName(pc).append(list).append(m.getName());
    }
}
