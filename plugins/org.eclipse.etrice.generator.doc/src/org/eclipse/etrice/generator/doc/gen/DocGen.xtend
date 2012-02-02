/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Jung, Thomas Schuetz (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.doc.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.Documentation
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.generator.base.ILogger
import org.eclipse.etrice.generator.base.IRoomGenerator
import org.eclipse.etrice.generator.etricegen.Root
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.etrice.generator.extensions.RoomExtensions

@Singleton
class DocGen implements IRoomGenerator {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension RoomExtensions roomExt
	@Inject ILogger logger
	
	override doGenerate(Root root) {
		for (model: root.models) {
			var path = model.docGenerationTargetPath
			var file = model.name+".tex"
			logger.logInfo("generating LaTeX documentation: '"+file+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(file, root.generateModelDoc(model))
		}
	}
	
	def generateModelDoc(Root root, RoomModel model) {'''
		\documentationclass[titlepage]{article}
		«model.name»
		«root.generateAllActorClassDocs(model)»
		\end{document}
	'''
	}

	def generateAllActorClassDocs(Root root, RoomModel model) {'''
		«FOR ac : model.actorClasses»
			«root.generateActorClassDoc(ac)»
		«ENDFOR»			
		'''
	}

	def generateActorClassDoc(Root root, ActorClass ac) {'''
		\subsection{«ac.name»}
		«root.irgendwas(ac)»
		«ac.docu.generateDocText»
		«ac.name»
	'''
	}
	
	def generateDocText(Documentation doc){'''
		«IF doc!=null»
		Documentation: «doc.text.join(" ///// ")»
		«ENDIF»		
		'''
	}
	
	def irgendwas(Root root, ActorClass ac){
		return ac.name + ".bla"
	}
	
}