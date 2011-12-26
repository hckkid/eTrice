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


package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.FreeType
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.Type
import org.eclipse.etrice.core.room.TypedID
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.etricegen.TransitionChain
import org.eclipse.etrice.generator.generic.ILanguageExtension


@Singleton
class JavaExtensions implements ILanguageExtension {

	@Inject org.eclipse.etrice.generator.generic.LanguageGenerator languageGen
	


	//-------------------------------------------------------
	// Java types
	
	// type names for Type class (distinguish Primitive and DataClass)
	override String toType(PrimitiveType prim) {
		return switch(prim.toString()) {
			case 'uint8': 'undefined_type'
			case 'uint16': 'undefined_type'
			case 'uint32': 'undefined_type'
			case 'int8': 'byte'
			case 'int16': 'short'
			case 'int32': 'int'
			case 'float32': 'float'
			case 'float64': 'double'
			case 'string' : 'String'
			default: prim.toString()
		}
	}
	override String typeName(Type type) {
		if (type.type!=null)
			return type.type.name
		else
			type.prim.toType
	}
	override String freeTypeName(FreeType type) {
		if (type.type!=null)
			return type.type
		else
			type.prim.toType
	}

	// default values for data
	override String defaultValue(PrimitiveType prim) {
		return switch(prim.toString()) {
			case 'uint8': '0'
			case 'uint16': '0'
			case 'uint32': '0'
			case 'int8': '0'
			case 'int16': '0'
			case 'int32': '0'
			case 'float32': '0.0'
			case 'float64': '0.0'
			case 'string': '""'
			default: prim.toString()
		};
	}
	override String defaultValue(TypedID a) {
		if (a.type.type!=null)
			return "new "+a.type.type.name+"()"
		else
			return a.type.prim.defaultValue
	}

	override String getTypedDataDefinition(Message m) {
		return languageGen.getTypedData(m)
	}

	override String accessLevelPrivate(){"private "}
	override String accessLevelProtected(){"protected "}
	override String accessLevelPublic(){"public "}

	override String memberAccess(){"this."}
	override String selfPointer(String classname, int argumentCount){""} 

	override String operationScope(String classname, boolean isDeclaration){""}

	// only for Java

	def String getJavaFileName(RoomClass rc) {
		return rc.name+".java";
	}

	//-------------------------------------------------------
	// transition chain visitor
		
	def String getExecuteChainCode(ExpandedActorClass ac, TransitionChain tc) {
		return languageGen.getExecuteChain(ac, tc)
	}
}