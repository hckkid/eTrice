/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (refactoring, adapted for other target languages)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.generic

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DetailCode
import org.eclipse.etrice.core.room.Operation

@Singleton
class ProcedureHelpers {

	@Inject extension ILanguageExtension languageExt
	@Inject extension TypeHelpers

	def UserCode(DetailCode dc) {'''
		«IF dc!=null»
			//--------------------- begin user code
			«FOR command : dc.commands»	«command»
			«ENDFOR»
			//--------------------- end user code
		«ENDIF»
	'''
	}
	
	// Attributes 
	def Attributes(List<Attribute> attribs) {'''
		//--------------------- attributes
		«FOR attribute : attribs»
			«IF attribute.size==0»
				«languageExt.accessLevelProtected()»«attribute.type.name» «attribute.name»«IF attribute.defaultValueLiteral==null» = «attribute.type.defaultValue»«ELSE» = «attribute.defaultValueLiteral»«ENDIF»;
			«ELSE»
				«languageExt.accessLevelProtected()»«attribute.type.name»[] «attribute.name»«IF attribute.defaultValueLiteral==null» = «attribute.type.defaultValue»[«attribute.size»];«ELSE» = «attribute.defaultValueLiteral»;«ENDIF»
			«ENDIF» 
		«ENDFOR»
	'''
	}

	def attributeInitialization(List<Attribute> attribs) {
		'''
			// initialize attributes
			«FOR a : attribs»
				«IF a.defaultValueLiteral!=null»
					«IF a.size==0»
						«a.name» = «a.defaultValueLiteral»;
					«ELSE»
						for (int i=0;i<«a.size»;i++){
							«a.name»[i] = «a.defaultValueLiteral»
						}
					«ENDIF»
				«ELSE»
					«IF a.size==0»
						«a.name» = «a.type.defaultValue»;
					«ELSE»
						for (int i=0;i<«a.size»;i++){
							«a.name»[i] = «a.type.defaultValue»
						}
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		'''
	}
	
	// Attribute setters & getters
	def AttributeSettersGettersDeclaration(List<Attribute> attribs, String classname) {'''
		//--------------------- attribute setters and getters
		«FOR attribute : attribs»
			«SetterHeader(attribute, classname)»;
			«GetterHeader(attribute, classname)»;
		«ENDFOR»
	'''
	}
	
	def AttributeSettersGettersImplementation(List<Attribute> attribs, String classname) {'''
		//--------------------- attribute setters and getters
		«FOR attribute : attribs»«SetterHeader(attribute, classname)» {
			 «languageExt.memberAccess()»«attribute.name» = «attribute.name»;
		}
		«GetterHeader(attribute, classname)» {
			return «languageExt.memberAccess()»«attribute.name»;
		}«ENDFOR»
	'''
	}
	
	def private SetterHeader(Attribute attribute, String classname){'''
		«languageExt.accessLevelPublic()»void set«attribute.name.toFirstUpper()» («languageExt.selfPointer(classname, 1)»«attribute.type.name»«IF attribute.size!=0»[]«ENDIF» «attribute.name»)'''
	}
	def private GetterHeader(Attribute attribute, String classname){'''
		«languageExt.accessLevelPublic()»«attribute.type.name»«IF attribute.size!=0»[]«ENDIF» get«attribute.name.toFirstUpper()» («languageExt.selfPointer(classname, 0)»)'''
	}

	
	// Operations
	def OperationsDeclaration(List<Operation> operations, String classname) {'''
		//--------------------- operations
		«FOR operation : operations»«OperationHeader(operation, classname, true)»;
		«ENDFOR»
		'''
	}

	def OperationsImplementation(List<Operation> operations, String classname) {'''
		//--------------------- operations
		«FOR operation : operations»«OperationHeader(operation, classname, false)»{
		«FOR command : operation.detailCode.commands»	«command»
			«ENDFOR»
		}
		«ENDFOR»
		'''
	}
	
	def private OperationHeader(Operation operation, String classname, boolean isDeclaration) {'''
		«languageExt.accessLevelPublic()»«IF operation.returntype==null»void«ELSE»«operation.returntype.name»«ENDIF» «languageExt.operationScope(classname, isDeclaration)»«operation.name» («languageExt.selfPointer(classname, operation.arguments.size)»«FOR argument : operation.arguments SEPARATOR ", "»«argument.type.name» «argument.name»«ENDFOR»)'''
	}
	
}