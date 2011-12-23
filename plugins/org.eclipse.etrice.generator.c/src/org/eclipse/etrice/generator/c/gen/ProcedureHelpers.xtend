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

package org.eclipse.etrice.generator.c.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DetailCode
import org.eclipse.etrice.core.room.Operation

@Singleton
class ProcedureHelpers {

	@Inject extension CExtensions stdExt

	def ActorClassPortIF(ActorClass ac) {'''
		«IF ac.extPorts.size > 0»implements«ENDIF»
		«FOR ep : ac.extPorts»public «ep.ifport.protocol.name»«IF ep.ifport.conjugated==true»Conj«ENDIF»Port «ep.ifport.name» = null; 
		«ENDFOR»
	'''
	}
	
	def UserCode(DetailCode dc) {'''
		«IF dc!=null»
		//--------------------- begin user code
			«FOR command : dc.commands»	«command»
			«ENDFOR»//--------------------- end user code
		«ENDIF»
	'''
	}
	
	def Attributes(List<Attribute> attribs) {'''
		//--------------------- attributes
		«FOR attribute : attribs»«IF attribute.size==0»protected «IF attribute.type.ext != null»«attribute.type.ext»«ELSE»«attribute.type.typeName()»«ENDIF» «attribute.name»;«ELSE»protected «attribute.type.typeName()»[] «attribute.name»«IF attribute.defaultValueLiteral==null» =new «attribute.type.typeName()»[«attribute.size»];«ELSE» = «attribute.defaultValueLiteral»;«ENDIF»
		«ENDIF» 
		«ENDFOR»
	'''
	}

	def AttributeSettersGetters(List<Attribute> attribs) {'''
		//--------------------- attribute setters and getters
		«FOR attribute : attribs»public void set«attribute.name.toFirstUpper()» («IF attribute.type.ext != null» «attribute.type.ext»«ELSE»«attribute.type.typeName()»«ENDIF»«IF attribute.size!=0»[]«ENDIF» «attribute.name») {
			 this.«attribute.name» = «attribute.name»;
		}
		public «IF attribute.type.ext != null» «attribute.type.ext»«ELSE»«attribute.type.typeName()»«ENDIF»«IF attribute.size!=0»[]«ENDIF» get«attribute.name.toFirstUpper()» () {
			return «attribute.name»;
		}«ENDFOR»
	'''
	}

	def Operations(List<Operation> operations) {'''
		//--------------------- operations
		«FOR operation : operations»public «IF operation.returntype==null»void«ELSE»«operation.returntype.freeTypeName()»«ENDIF» «operation.name» («FOR argument : operation.arguments SEPARATOR ", "»«argument.type.freeTypeName()» «argument.name»«ENDFOR»){
			«FOR command : operation.detailCode.commands»	«command»
			«ENDFOR»
		}«ENDFOR»
		'''
	}
	
}