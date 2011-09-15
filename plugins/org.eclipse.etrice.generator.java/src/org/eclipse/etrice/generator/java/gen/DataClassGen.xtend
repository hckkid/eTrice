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

import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import com.google.inject.Inject

import static extension org.eclipse.xtext.xtend2.lib.ResourceExtensions.*
import static extension org.eclipse.xtext.xtend2.lib.*

import org.eclipse.etrice.core.room.*
import org.eclipse.etrice.generator.etricegen.*
import org.eclipse.etrice.generator.java.setup.Logger

class DataClassGen {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension StdExtensions stdExt
	@Inject extension ProcedureHelpers helpers
	@Inject Logger logger
	
	def doGenerate(Root root) {
		for (dc: root.usedDataClasses) {
			var path = dc.generationTargetPath+dc.getPath
			var file = dc.getFileName
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
		
		«IF dc.imports.size>0»
		// user imports
		«FOR imp : dc.imports»import «imp.importedNamespace».*;
		«ENDFOR»«ENDIF»
		
		public class «dc.name»«IF dc.base!=null» extends «dc.base.name»«ENDIF» {
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
}