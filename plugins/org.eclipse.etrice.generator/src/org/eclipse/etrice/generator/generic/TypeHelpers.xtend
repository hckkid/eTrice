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

/*
	collection of convenience functions for code generation
*/


package org.eclipse.etrice.generator.generic

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.DataType
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.generator.generic.LanguageGenerator


@Singleton
class TypeHelpers {

	@Inject LanguageGenerator languageGen

	
	def String defaultValue(DataType dt) {
		if (dt instanceof PrimitiveType) {
			return (dt as PrimitiveType).getDefaultValueLiteral
		}
		else
			return "new "+dt.name+"()"
	}

	def String defaultValue(VarDecl a) {
		return defaultValue(a.type)
	}

	def String getTypedDataDefinition(Message m) {
		return languageGen.getTypedData(m)
	}
}