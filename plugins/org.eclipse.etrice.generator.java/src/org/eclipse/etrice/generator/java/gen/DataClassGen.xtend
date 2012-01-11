/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.ComplexType
import org.eclipse.etrice.generator.base.ILogger
import org.eclipse.etrice.generator.etricegen.Root
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.etrice.generator.extensions.RoomExtensions
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.TypeHelpers


@Singleton
class DataClassGen {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension JavaExtensions stdExt
	@Inject extension RoomExtensions roomExt
	@Inject extension ProcedureHelpers helpers
	@Inject extension TypeHelpers typeHelpers
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		for (dc: root.usedDataClasses) {
			var path = dc.generationTargetPath+dc.getPath
			var file = dc.getJavaFileName
			logger.logInfo("generating DataClass implementation '"+file+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(file, root.generate(dc))
		}
	}
	
	def generate(Root root, DataClass dc) {'''
		package «dc.getPackage()»;
		
		«var models = root.getReferencedModels(dc)»
		«FOR model : models»import «model.name».*;
		«ENDFOR»
		
		«helpers.UserCode(dc.userCode1)»
		
		
		public class «dc.name»«IF dc.base!=null» extends «dc.base.name»«ENDIF» {
			
			«helpers.UserCode(dc.userCode2)»
			
			«helpers.Attributes(dc.attributes)»
			
			«helpers.AttributeSettersGettersImplementation(dc.attributes, dc.name)»
			
			«helpers.OperationsImplementation(dc.operations, dc.name)»
			
			// default constructor
			public «dc.name»() {
				«dc.attributes.attributeInitialization»
			}
			
			// deep copy
			public «dc.name» deepCopy() {
				«dc.name» copy = new «dc.name»();
				«FOR a : dc.attributes»
					«IF a.type instanceof ComplexType»
						«IF a.size==0»
							copy.«a.name» = «a.name».deepCopy();
						«ELSE»
							for (int i=0;i<«a.size»;i++){
								copy.«a.name»[i] = «a.name»[i].deepCopy();
							}
						«ENDIF»
					«ELSE»
						«IF a.size==0»
							copy.«a.name» = «a.name»;
						«ELSE»
							for (int i=0;i<«a.size»;i++){
								copy.«a.name»[i] = «a.name»[i];
							}
						«ENDIF»
					«ENDIF»
				«ENDFOR»
				return copy;
			}
		};
	'''
	}
}