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

package org.eclipse.etrice.generator.java.gen;

import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.Type;
import org.eclipse.etrice.core.room.TypedID;
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass;
import org.eclipse.etrice.generator.etricegen.TransitionChain;

public class JavaGenerator {

	public String getExecuteChain(ExpandedActorClass ac, TransitionChain tc) {
		JavaTransitionChainVisitor tcv = new JavaTransitionChainVisitor(ac, tc);
		return tc.genExecuteChain(tcv);
	}

	public String getArgumentList(ExpandedActorClass xpac, Transition t) {
		if (t instanceof InitialTransition)
			// actually is InitialTransition
			return "";
		
		TransitionChain chain = xpac.getChain(t);
		if (!(chain.getTransition() instanceof TriggeredTransition))
			return "";
		
		Trigger trigger = ((TriggeredTransition)chain.getTransition()).getTriggers().get(0);
		MessageFromIf mif = trigger.getMsgFromIfPairs().get(0);
		
		return getTypedArgumentList(mif.getMessage());
	}

	public String getArgumentList(Message m) {
		return getArglistAndTypedData(m.getData())[0];
	}

	public String getTypedData(Message m) {
		return getArglistAndTypedData(m.getData())[1];
	}

	public String getTypedArgumentList(Message m) {
		return getArglistAndTypedData(m.getData())[2];
	}
	
	public String[] getArglistAndTypedData(TypedID data) {
		if (data==null)
			return new String[] {"", "", ""};
		
		String t;
		String ct;
		Type type = data.getType();
		if (type.getType()==null) {
			switch (type.getPrim()) {
			case BOOLEAN: t = "boolean"; ct = "Boolean"; break;
			case CHAR: t = "char"; ct = "Char"; break;
			case FLOAT32: t = "float"; ct = "Float"; break;
			case FLOAT64: t = "double"; ct = "Double"; break;
			case INT32: t = "int"; ct = "Integer"; break;
			case STRING: t="String"; ct="String"; break;
			case INT8: t="byte"; ct="Byte"; break;
			case INT16: t="short"; ct="Short"; break;
			default: t = "invalid Java data type"; ct = ""; assert(false): "Java doesn't support type "+type.getPrim().name()+"!";
			}
		}
		else {
			t = type.getType().getName();
			ct = t;
		}
		String typedData = t+" "+data.getName() + " = ("+ct+") generic_data;\n";
		String dataArg = ", "+data.getName();
		String typedArgList = ", "+t+" "+data.getName();
		
		return new String[]{dataArg, typedData, typedArgList};
	}
}
