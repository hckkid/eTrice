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
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.generator.base.ILogger
import org.eclipse.etrice.generator.etricegen.Root
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

import org.eclipse.etrice.generator.extensions.RoomExtensions
import org.eclipse.etrice.generator.generic.ProcedureHelpers


@Singleton
class ProtocolClassGen {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension CExtensions stdExt
	@Inject extension RoomExtensions roomExt
	@Inject extension ProcedureHelpers helpers
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		for (pc: root.usedProtocolClasses) {
			var path = pc.generationTargetPath+pc.getPath

			logger.logInfo("generating ProtocolClass header '"+pc.getCHeaderFileName+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(pc.getCHeaderFileName, root.generateHeaderFile(pc))

			logger.logInfo("generating ProtocolClass source '"+pc.getCSourceFileName+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(pc.getCSourceFileName, root.generateSourceFile(pc))

		}
	}

	
	def generateHeaderFile(Root root, ProtocolClass pc) {'''
		#ifndef _«pc.name»_H_
		#define _«pc.name»_H_
		
		#include "datatypes.h"
		
«««		import org.eclipse.etrice.runtime.java.messaging.Address;
«««		import org.eclipse.etrice.runtime.java.messaging.Message;
«««		import org.eclipse.etrice.runtime.java.modelbase.*;
«««		import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
		
		«helpers.UserCode(pc.userCode1)»
		
		«FOR dataClass : root.getReferencedDataClasses(pc)»#include "«dataClass.name».h"
		«ENDFOR»
		
		typedef struct {

			«helpers.UserCode(pc.userCode2)»

		} «pc.name»;

		/* message IDs */
		enum {
			MSG_«pc.name»_MIN = 0, 
			/* IDs for outgoing messages */
			«FOR message : pc.getAllOutgoingMessages()»
				«outMessageId(pc.name, message.name)» = «pc.getAllOutgoingMessages().indexOf(message)+1»,
			«ENDFOR»
			/* IDs for incoming messages */
			«FOR message : pc.getAllIncomingMessages()»
				«inMessageId(pc.name, message.name)» = «pc.getAllIncomingMessages().indexOf(message)+pc.getAllOutgoingMessages().size+1»,
			«ENDFOR»
			/* error if msgID >= MSG_MAX */
			MSG_«pc.name»_MAX = «pc.getAllOutgoingMessages().size + pc.getAllIncomingMessages().size+1»
		};

		/*--------------------- port classes */
		«portClassHeader(pc, false)»
		«portClassHeader(pc, true)»
«««			«portClass(pc, false)»
«««			«portClass(pc, true)»

		/*--------------------- debug helpers */
		
		/* get message string for message id */
		const char* «pc.name»_getMessageString(int msg_id);

		
		
		#endif /* _«pc.name»_H_ */
		
	'''
	}
	
	def generateSourceFile(Root root, ProtocolClass pc) {'''
		#include "«pc.getCHeaderFileName»"
		
		/*--------------------- port classes */
		«portClassSource(pc, false)»
		«portClassSource(pc, true)»
		
		/*--------------------- debug helpers */
		«generateDebugHelpersImplementation(root, pc)»
	'''
	}
	
	
	
	def portClass(ProtocolClass pc, Boolean conj) {'''
		«var name = pc.getPortClassName(conj)»
		«var pclass = pc.getPortClass(conj)»
		
«««		// port class
«««		static public class «name» extends PortBase {
«««			«IF pclass!=null»
«««				«helpers.UserCode(pclass.userCode)»
«««			«ENDIF»
«««			// constructors
«««			public «name»(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
«««				super(actor, name, localId, 0, addr, peerAddress);
«««				DebuggingService.getInstance().addPortInstance(this);
«««			}
«««			public «name»(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
«««				super(actor, name, localId, idx, addr, peerAddress);
«««				DebuggingService.getInstance().addPortInstance(this);
«««			}
«««		
«««			@Override
«««			public void receive(Message m) {
«««					if (!(m instanceof EventMessage))
«««						return;
«««					EventMessage msg = (EventMessage) m;
«««					if (msg.getEvtId() <= 0 || msg.getEvtId() >= MSG_MAX)
«««						System.out.println("unknown");
«««					else {
«««						if (messageStrings[msg.getEvtId()] != "timerTick"){
«««							// TODOTS: model switch for activation
«««							DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);
«««						}
«««						«IF pc.handlesReceive(conj)»
«««						switch (msg.getEvtId()) {
«««							«FOR hdlr : pc.getReceiveHandlers(conj)»
«««								case «hdlr.msg.getCodeName()»:
«««								{
«««									«FOR command : hdlr.detailCode.commands»
«««										«command»
«««									«ENDFOR»
«««								}
«««								break;
«««							«ENDFOR»
«««							default:
«««						«ENDIF»
«««							if (msg instanceof EventWithDataMessage)
«««								getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
«««							else
«««								getActor().receiveEvent(this, msg.getEvtId(), null);
«««						«IF pc.handlesReceive(conj)»
«««						}
«««						«ENDIF»
«««					}
«««			}
«««		
«««			«IF pclass!=null»
«««				«helpers.Attributes(pclass.attributes)»
«««				«helpers.OperationsDeclaration(pclass.operations, name)»
«««			«ENDIF»
«««			
«««			// sent messages
«««			«FOR m : pc.getOutgoing(conj)»
«««				«sendMessage(m, conj)»
«««			«ENDFOR»
«««		}
		
«««		// replicated port class
«««		static public class «name»Repl {
«««			private ArrayList<«name»> ports;
«««			private int replication;
«««		
«««			public «name»Repl(IEventReceiver actor, String name, int localId, Address[] addr,
«««					Address[] peerAddress) {
«««				replication = addr.length;
«««				ports = new ArrayList<«pc.name».«name»>(replication);
«««				for (int i=0; i<replication; ++i) {
«««					ports.add(new «name»(
«««							actor, name+i, localId, i, addr[i], peerAddress[i]));
«««				}
«««			}
«««			
«««			public int getReplication() {
«««				return replication;
«««			}
«««			
«««			public int getIndexOf(InterfaceItemBase ifitem){
«««					return ifitem.getIdx();
«««				}
«««			
«««			public «name» get(int i) {
«««				return ports.get(i);
«««			}
«««			
«««			«IF conj»
«««			// incoming messages
«««			«FOR m : pc.getAllIncomingMessages()»
«««			«messageSignature(m)»{
«««				for (int i=0; i<replication; ++i) {
«««					ports.get(i).«messageCall(m)»;
«««				}
«««			}
«««			«ENDFOR»
«««			«ELSE»
«««			// outgoing messages
«««			«FOR m : pc.getAllOutgoingMessages()»
«««			«messageSignature(m)»{
«««				for (int i=0; i<replication; ++i) {
«««					ports.get(i).«messageCall(m)»;
«««				}
«««			}
«««			«ENDFOR»
«««			«ENDIF»
«««		}
		
	'''
	}

	def portClassHeader(ProtocolClass pc, Boolean conj){
		'''
		
		'''
	}
	
	def portClassSource(ProtocolClass pc, Boolean conj){
		'''
		
		'''
	}
	

	def messageSignature(Message m) {'''
	public void «m.name» («IF m.data!=null»«m.data.type.typeName()» «m.data.name»«ENDIF»)
	'''
	}

	def messageCall(Message m) {'''
	«m.name»(«IF m.data!=null» «m.data.name»«ENDIF»)
	'''}
	
	def sendMessage(Message m, boolean conj) {'''
	«var dir = if (conj) "IN" else "OUT"»
	«var hdlr = m.getSendHandler(conj)»
	«messageSignature(m)»{
		«IF hdlr!=null»
			«FOR command : hdlr.detailCode.commands»	«command»
			«ENDFOR»
		«ELSE»
			if (messageStrings[ «dir»_«m.name»] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[«dir»_«m.name»]);
			}
			if (getPeerAddress()!=null)
			«IF m.data==null»getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), «dir»_«m.name»));
			«ELSE»getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), «dir»_«m.name», «m.data.name»«IF (!m.data.type.ref && m.data.type.type!=null)».deepCopy()«ENDIF»));
			«ENDIF»
		«ENDIF»
	}
	'''
	}
	
	def generateDebugHelpersImplementation(Root root, ProtocolClass pc){'''
		
		/* TODO: make this optional or different for smaller footprint */
		/* message names as strings for debugging (generate MSC) */
		static const char* «pc.name»_messageStrings[] = {"MIN", «FOR m : pc.getAllOutgoingMessages()»"«m.name»",«ENDFOR»«FOR m : pc.getAllIncomingMessages()»"«m.name»", «ENDFOR»"MAX"};

		const char* «pc.name»_getMessageString(int msg_id) {
			if (msg_id<MSG_«pc.name»_MIN || msg_id>MSG_«pc.name»_MAX+1){
				/* id out of range */
				return "Message ID out of range";
			}
			else{
				return «pc.name»_messageStrings[msg_id];
			}
		}
		'''
	}
	
}