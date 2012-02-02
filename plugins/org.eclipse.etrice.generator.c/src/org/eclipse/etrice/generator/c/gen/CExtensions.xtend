/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (changed for C code generator)
 * 
 *******************************************************************************/

/*
	collection of convenience functions for code generation
*/


package org.eclipse.etrice.generator.c.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.etricegen.TransitionChain
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.generator.generic.LanguageGenerator



@Singleton
class CExtensions implements ILanguageExtension {

	@Inject LanguageGenerator languageGen
	

	override String getTypedDataDefinition(Message m) {
		return languageGen.getTypedData(m)
	}

	// in C no access levels can be defined
	override String accessLevelPrivate(){""}
	override String accessLevelProtected(){""}
	override String accessLevelPublic(){""}
	
	override String memberAccess(){"self->"}
	override String selfPointer(String classname, int argumentCount){
		if (argumentCount>0){
			classname+"* self, "
		}
		else {
			classname+"* self"
		}
	}

	override String operationScope(String classname, boolean isDeclaration){classname+"_"}

	/* TODO: unify OUT and in an add for loop (also for Java) */
	override String outMessageId(String classname, String messagename){
		return classname+"_OUT_"+messagename;
	}
	
	override String inMessageId(String classname, String messagename){
		return classname+"_IN_"+messagename;
	}




	//****  C-Specific
	/* TODO: move specific code elsewhere */	
	// used
	def String getCHeaderFileName(RoomClass rc) {
		return rc.name+".h";
	}

	// used
	def String getCSourceFileName(RoomClass rc) {
		return rc.name+".c";
	}

	def String getInstSourceFileName(RoomClass rc) {
		return rc.name+"_Inst.h";
	}

	def getIncludeGuardString(String filename){
		'''_«filename.toUpperCase»_H_'''
	}

	def generateIncludeGuardBegin(String filename){'''
		#ifndef «filename.getIncludeGuardString»
		#define «filename.getIncludeGuardString»
		'''
	}

	def generateIncludeGuardEnd(String filename){'''
		#endif /* «filename.getIncludeGuardString» */
		'''
	}

	//-------------------------------------------------------
	// transition chain visitor
		
	def String getExecuteChainCode(ExpandedActorClass ac, TransitionChain tc) {
		return languageGen.getExecuteChain(ac, tc)
	}
}