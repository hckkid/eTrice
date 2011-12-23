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
		TODO: includes for C-Headers instead of Java imports
		
		«var models = root.getReferencedModels(dc)»
		«FOR model : models»//import «model.name».*;
		«ENDFOR»
		
		«helpers.UserCode(dc.userCode1)»
				
		
		typedef struct «dc.name»«IF dc.base!=null» /* extends -> inheritance not implemented yet */ «dc.base.name»«ENDIF»  {
		
		«helpers.UserCode(dc.userCode2)»
		
			«helpers.Attributes(dc.attributes)»
			«helpers.AttributeSettersGetters(dc.attributes)»
			«helpers.Operations(dc.operations)»
		
			// default constructor
			public «dc.name»() {
				«FOR a : dc.attributes»
					«IF a.defaultValueLiteral!=null»
						«IF a.size==0»«a.name» = «a.defaultValueLiteral»;«ENDIF»
					«ELSEIF a.type.type!=null»
						«a.name» = new «a.type.type.name»();
					«ENDIF»
				«ENDFOR»
			}
			
			// deep copy
			public «dc.name» deepCopy() {
				«dc.name» copy = new «dc.name»();
				«FOR a : dc.attributes»
					«IF a.type.type!=null»
						copy.«a.name» = «a.name».deepCopy();
					«ELSE»
						«IF a.size==0»copy.«a.name» = «a.name»;«ELSE»for (int i=0;i<«a.size»;i++){copy.«a.name»[i]=«a.name»[i];}«ENDIF»
					«ENDIF»
				«ENDFOR»
				return copy;
			}
		};
		'''
	}
	
	def generateSourceFile(Root root, DataClass dc) {'''
		#include "«dc.getCHeaderFileName»";
		
		
		«helpers.UserCode(dc.userCode3)»
		
		// TODO
	'''}
	
	
}