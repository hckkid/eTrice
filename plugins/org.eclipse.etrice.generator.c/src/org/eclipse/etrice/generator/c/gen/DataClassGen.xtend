/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (changed for C code generator)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.c.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.generator.base.ILogger
import org.eclipse.etrice.generator.etricegen.Root
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.etrice.generator.extensions.RoomExtensions
import org.eclipse.etrice.generator.generic.ProcedureHelpers


@Singleton
class DataClassGen {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension CExtensions stdExt
	@Inject extension RoomExtensions roomExt
	@Inject extension ProcedureHelpers helpers
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		for (dc: root.usedDataClasses) {
			var path = dc.generationTargetPath+dc.getPath

			// header file
			var headerFile = dc.getCHeaderFileName
			logger.logInfo("generating DataClass header '"+headerFile+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(headerFile, root.generateHeaderFile(dc))
			
			// header file
			var sourceFile = dc.getCSourceFileName
			logger.logInfo("generating DataClass source '"+headerFile+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(sourceFile, root.generateSourceFile(dc))
			
		}
	}
	
	def generateHeaderFile(Root root, DataClass dc) {'''
		#ifndef _«dc.name»_H_
		#define _«dc.name»_H_
		
		#include "../../src/datatypes.h"

		/* TODO: includes only for used DataClasses, also for other models */
		«FOR dataClass : root.getReferencedDataClasses(dc)»«IF dataClass.name != dc.name»#include "«dataClass.name».h"«ENDIF»
		«ENDFOR»
		
		«helpers.UserCode(dc.userCode1)»
				
		typedef struct {
		
			«helpers.UserCode(dc.userCode2)»

			«helpers.Attributes(dc.attributes)»
			
		} «dc.name»«IF dc.base!=null» /* extends -> inheritance not implemented yet */ «dc.base.name»«ENDIF»;
		
		// TODO: do we need setters and getters for C and C++ ?
		
		«helpers.OperationsDeclaration(dc.operations, dc.name)»
		
		// deep copy
		void «dc.name»_deepCopy(«dc.name»* source, «dc.name»* target);
		
		#endif /* _«dc.name»_H_ */
		
		'''
	}
	
	def generateSourceFile(Root root, DataClass dc) {'''
		#include "«dc.getCHeaderFileName»"
		
		#include <string.h>
		
		«helpers.UserCode(dc.userCode3)»
		
		// TODO: do we need setters and getters for C and C++ ?
		
		«helpers.OperationsImplementation(dc.operations, dc.name)»
		
		// deep copy
		void «dc.name»_deepCopy(«dc.name»* source, «dc.name»* target) {
			memcpy(target, source, sizeof(«dc.name»));
		}
		
		
	'''}
	
	
}