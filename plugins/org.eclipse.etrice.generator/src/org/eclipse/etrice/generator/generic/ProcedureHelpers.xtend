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

	@Inject 
	extension ILanguageExtension languageExt

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
			«IF attribute.size==0»«languageExt.accessLevelProtected()»«IF attribute.type.ext != null»«attribute.type.ext»«ELSE»«attribute.type.typeName()»«ENDIF» «attribute.name»;
			«ELSE»«languageExt.accessLevelProtected()»«attribute.type.typeName()»[] «attribute.name»«IF attribute.defaultValueLiteral==null» =new «attribute.type.typeName()»[«attribute.size»];«ELSE» = «attribute.defaultValueLiteral»;«ENDIF»
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
		«languageExt.accessLevelPublic()»void set«attribute.name.toFirstUpper()» («languageExt.selfPointer(classname, 1)»«IF attribute.type.ext != null» «attribute.type.ext»«ELSE»«attribute.type.typeName()»«ENDIF»«IF attribute.size!=0»[]«ENDIF» «attribute.name»)'''
	}
	def private GetterHeader(Attribute attribute, String classname){'''
		«languageExt.accessLevelPublic()»«IF attribute.type.ext != null» «attribute.type.ext»«ELSE»«attribute.type.typeName()»«ENDIF»«IF attribute.size!=0»[]«ENDIF» get«attribute.name.toFirstUpper()» («languageExt.selfPointer(classname, 0)»)'''
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
		}«ENDFOR»
		'''
	}
	
	def private OperationHeader(Operation operation, String classname, boolean isDeclaration) {'''
		«languageExt.accessLevelProtected()»«IF operation.returntype==null»void«ELSE»«operation.returntype.freeTypeName()»«ENDIF» «languageExt.operationScope(classname, isDeclaration)»«operation.name» («languageExt.selfPointer(classname, operation.arguments.size)»«FOR argument : operation.arguments SEPARATOR ", "»«argument.type.freeTypeName()» «argument.name»«ENDFOR»)'''
	}
	
}