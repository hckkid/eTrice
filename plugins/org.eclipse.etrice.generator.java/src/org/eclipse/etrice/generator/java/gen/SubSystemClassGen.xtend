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

class SubSystemClassGen {
	
	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension StdExtensions stdExt
	@Inject extension ProcedureHelpers helpers
	@Inject Logger logger
	
	def doGenerate(Root root) {
		for (ssi: root.subSystemInstances) {
			var path = ssi.subSystemClass.generationTargetPath+ssi.subSystemClass.getPath
			var file = ssi.subSystemClass.fileName
			logger.logInfo("generating SubSystemClass implementation: '"+file+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(file, root.generate(ssi, ssi.subSystemClass))
		}
	}
	
	def generate(Root root, SubSystemInstance comp, SubSystemClass cc) {'''
		package «cc.getPackage()»;
		
		import org.eclipse.etrice.runtime.java.messaging.MessageService;
		import org.eclipse.etrice.runtime.java.messaging.RTServices;
		import org.eclipse.etrice.runtime.java.messaging.Address;
		import org.eclipse.etrice.runtime.java.messaging.IRTObject;
		import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;
		import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
		
		«var models = root.getReferencedModels(cc)»
		«FOR model : models»import «model.name».*;«ENDFOR»
		
		
		«helpers.UserCode(cc.userCode1)»
		
		public class «comp.name» extends SubSystemClassBase{
		
			«helpers.UserCode(cc.userCode2)»
			
			public «comp.name»(IRTObject parent, String name) {
				super(parent, name);
			}
			
			@Override
			public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
			}
			
			@Override	
			public void instantiateMessageServices(){
			
				RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, new Address(0, 0, 0),"MessageService_Main"));
				«FOR thread : cc.threads»
					RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, new Address(0, «cc.threads.indexOf(thread)+1», 0),"MessageService_«thread.name»", «thread.prio»));
				«ENDFOR»
				}
		
			@Override
			public void instantiateActors(){
				// all addresses
				// Addresses for the Subsystem Systemport
				«FOR ai : comp.allContainedInstances»
					Address addr_item_SystemPort_«comp.allContainedInstances.indexOf(ai)» = new Address(0,0,«comp.objCounter.getAndIncrementCount()»);
				«ENDFOR»
				
				«FOR ai : comp.allContainedInstances»
					// actor instance «ai.path» itself => Systemport Address
					// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
					Address addr_item_«ai.path.getPathName()» = new Address(0,«ai.threadId»,«ai.objId»);
					// interface items of «ai.path»
					«FOR pi : ai.orderedIfItemInstances»
						«IF pi instanceof ServiceImplInstance || pi.peers.size>1»
							«FOR peer : pi.peers»
								«var i = pi.peers.indexOf(peer)»
								Address addr_item_«pi.path.getPathName()»_«i» = new Address(0,«pi.threadId»,«pi.objId+i»);
							«ENDFOR»
						«ELSE»
							Address addr_item_«pi.path.getPathName()» = new Address(0,«ai.threadId»,«pi.objId»);
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
		
				// instantiate all actor instances
				instances = new ActorClassBase[«comp.allContainedInstances.size»];
				«FOR ai : comp.allContainedInstances»
					instances[«comp.allContainedInstances.indexOf(ai)»] = new «ai.actorClass.name»(
						«IF ai.eContainer instanceof SubSystemInstance»
							this,
						«ELSE»
							instances[«comp.allContainedInstances.indexOf(ai.eContainer)»],
						«ENDIF»
						"«ai.name»",
						// own interface item addresses
						new Address[][] {{addr_item_«ai.path.getPathName()»}«IF !ai.orderedIfItemInstances.empty»,«ENDIF»
						«FOR pi : ai.orderedIfItemInstances SEPARATOR ","»
							{
								«IF pi instanceof ServiceImplInstance || pi.peers.size>1»
									«FOR peer : pi.peers SEPARATOR ","»
										addr_item_«pi.path.getPathName()»_«pi.peers.indexOf(peer)»
									«ENDFOR»
								«ELSE»
									addr_item_«pi.path.getPathName()»
								«ENDIF»
							}
						«ENDFOR»
						},
						// peer interface item addresses
						new Address[][] {{addr_item_SystemPort_«comp.allContainedInstances.indexOf(ai)»}«IF !ai.orderedIfItemInstances.empty»,«ENDIF»
							«FOR pi : ai.orderedIfItemInstances SEPARATOR ","»
							{
								«IF !(pi instanceof ServiceImplInstance) && pi.peers.isEmpty»
									null
								«ELSE»
									«FOR pp : pi.peers SEPARATOR ","»
										«IF pp instanceof ServiceImplInstance || pp.peers.size>1»
											addr_item_«pp.path.getPathName()»_«pp.peers.indexOf(pi)»
										«ELSE»
											addr_item_«pp.path.getPathName()»
										«ENDIF»
									«ENDFOR»
								«ENDIF»
							}
							«ENDFOR»
						}
					); 
				«ENDFOR»
		
				// create the subsystem system port	
				RTSystemPort = new RTSystemServicesProtocolConjPortRepl(this, "RTSystemPort",
						0, //local ID
						// own addresses
						new Address[]{
							«FOR ai : comp.allContainedInstances SEPARATOR ","»
								addr_item_SystemPort_«comp.allContainedInstances.indexOf(ai)»
							«ENDFOR»
						},
						// peer addresses
						new Address[]{
							«FOR ai : comp.allContainedInstances SEPARATOR ","»
								addr_item_«ai.path.getPathName()»
							«ENDFOR»
						});
						
			}
		};
	'''
	}
	
}