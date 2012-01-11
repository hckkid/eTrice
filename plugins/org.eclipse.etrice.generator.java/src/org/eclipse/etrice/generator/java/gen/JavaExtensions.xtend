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
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.etricegen.TransitionChain
import org.eclipse.etrice.generator.generic.LanguageGenerator
import org.eclipse.etrice.generator.generic.ILanguageExtension


@Singleton
class JavaExtensions implements ILanguageExtension {

	@Inject LanguageGenerator languageGen
	

	override String getTypedDataDefinition(Message m) {
		return languageGen.getTypedData(m)
	}


	def String getJavaFileName(RoomClass rc) {rc.name+".java"}
	
	override String accessLevelPrivate() {"private "}
	override String accessLevelProtected() {"protected "}
	override String accessLevelPublic() {"public "}
	
	override String memberAccess() {"this."} 	 
	override String selfPointer(String classname, int argumentCount) {""}
	
	override String operationScope(String classname, boolean isDeclaration) {""}
	
	override String outMessageId(String classname, String messagename) {"OUT_"+messagename}
	override String inMessageId(String classname, String messagename) {"IN_"+messagename}

	//-------------------------------------------------------
	// transition chain visitor
		
	def String getExecuteChainCode(ExpandedActorClass ac, TransitionChain tc) {
		return languageGen.getExecuteChain(ac, tc)
	}
}