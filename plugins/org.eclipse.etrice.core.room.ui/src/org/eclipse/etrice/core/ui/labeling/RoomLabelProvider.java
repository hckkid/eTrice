/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.BaseState;
import org.eclipse.etrice.core.room.Import;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.FreeType;
import org.eclipse.etrice.core.room.FreeTypedID;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.Type;
import org.eclipse.etrice.core.room.TypedID;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class RoomLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public RoomLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// custom images for ROOM classes
	
	String image(RoomModel rm) {
		return "RoomModel.gif";
	}
	
	String image(Import im) {
		return "RoomModelImport.gif";
	}
	
	String image(DataClass dc) {
		return "DataClass.gif";
	}

	String image(ProtocolClass pc) {
		return "ProtocolClass.gif";
	}

	String image(ActorClass ac) {
		return "ActorClass.gif";
	}

	String image(SubSystemClass cc) {
		return "SubSystemClass.gif";
	}

	String image(LogicalSystem sys) {
		return "LogicalSystem.gif";
	}

	String image(SAPRef sap) {
		return "SAP.gif";
	}

	String image(SPPRef spp) {
		return "SPP.gif";
	}

	String image(ActorRef ar) {
		return "ActorRef.gif";
	}

	String image(SubSystemRef ar) {
		return "SubSystemRef.gif";
	}

	String image(BaseState state) {
		return "State.gif";
	}

	String image(RefinedState state) {
		return "RefinedState.gif";
	}

	String image(ServiceImplementation svc) {
		return "ServiceImpl.gif";
	}

	String image(Message state) {
		return "Message.gif";
	}

	String image(Operation op) {
		return "Operation.gif";
	}
	
	String image(Port p) {
		ActorClass ac = (ActorClass) p.eContainer();
		boolean relay = true;
		if (ac.getIntPorts().contains(p)) {
			relay = false;
		}
		else {
			for (ExternalPort ep : ac.getExtPorts()) {
				if (ep.getIfport()==p) {
					relay = false;
					break;
				}
			}
		}
		if (relay)
			if (p.isConjugated())
				if (p.getMultiplicity()>1)
					return "ConjReplRelayPort.gif";
				else
					return "ConjRelayPort.gif";
			else
				if (p.getMultiplicity()>1)
					return "ReplRelayPort.gif";
				else
					return "RelayPort.gif";
		else
			if (p.isConjugated())
				if (p.getMultiplicity()>1)
					return "ConjReplPort.gif";
				else
					return "ConjPort.gif";
			else
				if (p.getMultiplicity()>1)
					return "ReplPort.gif";
				else
					return "Port.gif";
	}
	
	// custom labels
	
	String text(Import im) {
		return "import "+im.getImportedNamespace();
	}
	
	String text(DataClass dc) {
		String base = dc.getBase()!=null? " extends "+dc.getBase().getName():"";
		return dc.getName()+base;
	}
	
	String text(ProtocolClass pc) {
		String base = pc.getBase()!=null? " extends "+pc.getBase().getName():"";
		return pc.getName()+base;
	}
	
	String text(ActorClass ac) {
		String base = ac.getBase()!=null? " extends "+ac.getBase().getName():"";
		return ac.getName()+base;
	}
	
	String text(Port p) {
		String location = null;
		ActorClass ac = (ActorClass) p.eContainer();
		if (ac.getIntPorts().contains(p))
			location = "internal";
		else {
			for (ExternalPort ep : ac.getExtPorts()) {
				if (ep.getIfport()==p) {
					location = "external";
					break;
				}
			}
		}
		if (location==null)
			location = "relay";
		String conjugated = p.isConjugated()?"conjugated ":"";
		String multiplicity = p.getMultiplicity()>1? ("["+p.getMultiplicity()+"]"):"";
		String protocol = p.getProtocol()!=null? (" : "+p.getProtocol().getName()):"";
		return conjugated+" "+location+" Port "+p.getName()+multiplicity+protocol;
	}
	
	String text(ExternalPort ep) {
		return text(ep.getIfport());
	}
	
	String text(SAPRef sap) {
		String protocol = sap.getProtocol()!=null? (" : "+sap.getProtocol().getName()):"";
		return "SAP "+sap.getName()+protocol;
	}
	
	String text(SPPRef spp) {
		String protocol = spp.getProtocol()!=null? (" : "+spp.getProtocol().getName()):"";
		return "SPP "+spp.getName()+protocol;
	}
	
	String text(ServiceImplementation svc) {
		if (svc.getSpp()==null)
			return "Implementation";
		
		String protocol = svc.getSpp().getProtocol()!=null? (" : "+svc.getSpp().getProtocol().getName()):"";
		return "Implementation of "+svc.getSpp().getName()+protocol;
	}
	
	String text(ActorRef ref) {
		String cls = ref.getType()!=null? (" : "+ref.getType().getName()):"";
		return "ref "+ref.getName()+cls;
	}
	
	String text(SubSystemRef ref) {
		String cls = ref.getType()!=null? (" : "+ref.getType().getName()):"";
		return "ref "+ref.getName()+cls;
	}
	
	private String getName(Type tp) {
		if (tp.getType()!=null)
			return tp.getType().getName();
		else if (tp.getPrim()!=null)
			return tp.getPrim().getName();
		else
			return "?";
	}
	
	private String getName(FreeType tp) {
		if (tp.getType()!=null)
			return tp.getType();
		else if (tp.getPrim()!=null)
			return tp.getPrim().getName();
		else
			return "?";
	}
	
	String text(Attribute attr) {
		String type = attr.getType()!=null? (" : "+getName(attr.getType())):"";
		return "Attr "+attr.getName()+type;
	}
	
	String text(Operation op) {
		String rt = op.getReturntype()!=null? ": "+getName(op.getReturntype()):"";
		String signature = "";
		for (FreeTypedID arg : op.getArguments()) {
			if (signature.isEmpty())
				signature = arg.getName()+": "+getName(arg.getType());
			else
				signature += ", "+arg.getName()+": "+getName(arg.getType());
		}
		signature = "("+signature+")";
		return op.getName()+signature+rt;
	}
	
	String text(Message m) {
		String signature = "";
		for (TypedID arg : m.getArguments()) {
			if (signature.isEmpty())
				signature = arg.getName()+":"+getName(arg.getType());
			else
				signature += ","+arg.getName()+":"+getName(arg.getType());
		}
		signature = "("+signature+")";
		return m.getName()+signature;
	}
	
	String text(BaseState s) {
		return s.getName();
	}
	
	String text(RefinedState rs) {
		if (rs.getBase()!=null)
			return text(rs.getBase());
		
		return "";
	}
/*
	//Labels and icons can be computed like this:
	
	String text(MyModel ele) {
	  return "my "+ele.getName();
	}
	 
    String image(MyModel ele) {
      return "MyModel.gif";
    }
*/
}
