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

package org.eclipse.etrice.core.naming;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAPoint;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.util.RoomSwitch;
import org.eclipse.xtext.resource.IFragmentProvider;


public class RoomFragmentProvider implements IFragmentProvider {

	private class PathProvider extends RoomSwitch<String> {

		@Override
		public String caseRoomClass(RoomClass rc) {
			return rc.getName();
		}
		
		@Override
		public String casePort(Port port) {
			return doSwitch(port.eContainer())+SEP+port.getName();
		}
		
		@Override
		public String caseSPPRef(SPPRef spp) {
			return doSwitch(spp.eContainer())+SEP+spp.getName();
		}
		
		@Override
		public String caseActorContainerRef(ActorContainerRef acr) {
			return doSwitch(acr.eContainer())+SEP+acr.getName();
		}
		
		@Override
		public String caseBinding(Binding bi) {
			return doSwitch(bi.eContainer())+SEP
			+caseBindingEndPoint(bi.getEndpoint1())+BIND_SEP
			+caseBindingEndPoint(bi.getEndpoint2());
		}
		
		@Override
		public String caseBindingEndPoint(BindingEndPoint ep) {
			String loc = ep.getActorRef()==null? LOCAL:ep.getActorRef().getName();
			return ep.getPort().getName()+EP_SEP+loc;
		}
		
		@Override
		public String caseLayerConnection(LayerConnection bi) {
			return doSwitch(bi.eContainer())+SEP
			+caseSAPoint(bi.getFrom())+CONN_SEP
			+caseSPPoint(bi.getTo());
		}
		
		@Override
		public String caseSAPoint(SAPoint sapt) {
			if (sapt instanceof RefSAPoint)
				return ((RefSAPoint) sapt).getRef().getName();
			else if (sapt instanceof RelaySAPoint)
				return ((RelaySAPoint) sapt).getRelay().getName();
			
			assert(false): "unexpectd sub type";
			return null;
		}
		
		@Override
		public String caseSPPoint(SPPoint sppt) {
			return sppt.getRef().getName()+EP_SEP+sppt.getService().getName();
		}
	}
	
	private static final char SEP = '$';
	private static final char BIND_SEP = '-';
	private static final char CONN_SEP = '-';
	private static final char EP_SEP = '!';
	private static final String LOCAL = ".";
	private static final char TYPE_SEP = ':';

	private PathProvider pathProvider = new PathProvider();
	
	@Override
	public String getFragment(EObject obj, Fallback fallback) {
		String path = pathProvider.doSwitch(obj);
		if (path!=null)
			return obj.eClass().getName()+TYPE_SEP+path;
		
		return fallback.getFragment(obj);
	}

	@Override
	public EObject getEObject(Resource resource, String fragment,
			Fallback fallback) {

		RoomModel model = (RoomModel) resource.getContents().get(0);
		EObject result = getEObject(model, fragment);
		if (result!=null)
			return result;
		
		return fallback.getEObject(fragment);
	}

	public static boolean isPort(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getPort().getName());
	}

	public static boolean isSPP(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getSPPRef().getName());
	}

	public static boolean isBinding(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getBinding().getName());
	}

	public static boolean isLayerConnection(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getLayerConnection().getName());
	}

	public static boolean isRef(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		if (uri!=null && uri.fragment()!=null) {
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getActorContainerRef().getName()))
				return true;
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getActorRef().getName()))
				return true;
		}
		return false;
	}

	public static boolean isStructureClass(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		if (uri!=null && uri.fragment()!=null) {
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getActorClass().getName()))
				return true;
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getSubSystemClass().getName()))
				return true;
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getLogicalSystem().getName()))
				return true;
		}
		return false;
	}
	
	private EObject getEObject(RoomModel model, String fragment) {
		int begin = 0;
		int end = fragment.indexOf(TYPE_SEP);
		if (end<0)
			return null;
		String type = fragment.substring(begin, end);

		begin = end+1;
		end = fragment.indexOf(SEP, begin);
		if (end<0)
			end = fragment.length();
		String className = fragment.substring(begin, end);
		
		RoomClass rc = getRoomClass(model, className);
		if (type.equals(RoomPackage.eINSTANCE.getDataClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getProtocolClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getActorClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getSubSystemClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getLogicalSystem().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getPort().getName())) {
			begin = end+1;
			String portName = fragment.substring(begin, fragment.length());
			return getPort(rc, portName);
		}
		else if (type.equals(RoomPackage.eINSTANCE.getSPPRef().getName())) {
			begin = end+1;
			String portName = fragment.substring(begin, fragment.length());
			return getSPP(rc, portName);
		}
		else if (type.equals(RoomPackage.eINSTANCE.getSubSystemRef().getName())
				|| type.equals(RoomPackage.eINSTANCE.getActorRef().getName())) {
			begin = end+1;
			String arcName = fragment.substring(begin, fragment.length());
			return getActorContainerRef(rc, arcName);
		}
		else if (type.equals(RoomPackage.eINSTANCE.getBinding().getName())) {
			begin = end+1;
			String bindName = fragment.substring(begin, fragment.length());
			return getBinding(rc, bindName);
		}
		else if (type.equals(RoomPackage.eINSTANCE.getLayerConnection().getName())) {
			begin = end+1;
			String lcName = fragment.substring(begin, fragment.length());
			return getLayerConnection(rc, lcName);
		}
		
		return null;
	}

	private EObject getBinding(RoomClass rc, String name) {
		int pos = name.indexOf(BIND_SEP);
		if (pos<0)
			return null;
		
		if (rc instanceof StructureClass) {
			String ep1name = name.substring(0, pos);
			String ep2name = name.substring(pos+1, name.length());
			StructureClass sc = (StructureClass) rc;
			BindingEndPoint ep1 = getEndpoint(sc, ep1name);
			BindingEndPoint ep2 = getEndpoint(sc, ep2name);
			for (Binding bi : sc.getBindings()) {
				if (isEP(bi.getEndpoint1(),ep1) && isEP(bi.getEndpoint2(),ep2))
					return bi;
				if (isEP(bi.getEndpoint1(),ep2) && isEP(bi.getEndpoint2(),ep1))
					return bi;
			}
		}
		return null;
	}

	private boolean isEP(BindingEndPoint a, BindingEndPoint b) {
		if (a.getPort().getName().equals(b.getPort().getName())) {
			if (a.getActorRef()==null && b.getActorRef()==null)
				return true;
			if (a.getActorRef()!=null && b.getActorRef()!=null)
				if (a.getActorRef().getName().equals(b.getActorRef().getName()))
					return true;
		}
		return false;
	}
	
	private BindingEndPoint getEndpoint(StructureClass sc, String name) {
		int pos = name.indexOf(EP_SEP);
		if (pos<0)
			return null;
		String portName = name.substring(0, pos);
		String refName = name.substring(pos+1, name.length());
		ActorContainerRef ar = null;
		if (!refName.equals(LOCAL))
			ar = getActorContainerRef(sc, refName);
		if (ar!=null) {
			if (ar instanceof ActorRef)
				sc = ((ActorRef) ar).getType();
			else if (ar instanceof SubSystemRef)
				sc = ((SubSystemRef) ar).getType();
		}
		Port port = getPort(sc, portName);
		BindingEndPoint ep = RoomFactory.eINSTANCE.createBindingEndPoint();
		ep.setPort(port);
		ep.setActorRef(ar);
		return ep;
	}

	private EObject getLayerConnection(RoomClass rc, String name) {
		int pos = name.indexOf(CONN_SEP);
		if (pos<0)
			return null;
		
		if (rc instanceof StructureClass) {
			String saptname = name.substring(0, pos);
			String spptname = name.substring(pos+1, name.length());
			StructureClass sc = (StructureClass) rc;
			SAPoint sapt = getSAPoint(sc, saptname);
			SPPoint sppt = getSPPoint(sc, spptname);
			for (LayerConnection bi : sc.getConnections()) {
				if (isSAPoint(bi.getFrom(),sapt) && isSPPoint(bi.getTo(),sppt))
					return bi;
			}
		}
		return null;
	}

	private SPPoint getSPPoint(StructureClass sc, String name) {
		int pos = name.indexOf(EP_SEP);
		if (pos<0)
			return null;
		String refName = name.substring(0, pos);
		String sppName = name.substring(pos+1, name.length());

		if (sc instanceof ActorContainerClass) {
			for (ActorRef ar : ((ActorContainerClass) sc).getActorRefs()) {
				if (ar.getName().equals(refName)) {
					for (SPPRef spp : ar.getType().getIfSPPs())
						if (spp.getName().equals(sppName)) {
							SPPoint sppt = RoomFactory.eINSTANCE.createSPPoint();
							sppt.setRef(ar);
							sppt.setService(spp);
							return sppt;
						}
				}
			}
		}
		else if (sc instanceof LogicalSystem) {
			for (SubSystemRef ssr : ((LogicalSystem) sc).getSubSystems()) {
				if (ssr.getName().equals(refName)) {
					for (SPPRef spp: ssr.getType().getIfSPPs())
						if (spp.getName().equals(sppName)) {
							SPPoint sppt = RoomFactory.eINSTANCE.createSPPoint();
							sppt.setRef(ssr);
							sppt.setService(spp);
							return sppt;
						}
				}
			}
		}
		
		return null;
	}

	private SAPoint getSAPoint(StructureClass sc, String name) {
		SAPoint sapt = getRelaySAPoint(sc, name);
		if (sapt!=null)
			return sapt;
		return getRefSAPoint(sc, name);
	}

	private SAPoint getRefSAPoint(StructureClass sc, String name) {
		if (sc instanceof ActorContainerClass) {
			for (ActorRef ar : ((ActorContainerClass)sc).getActorRefs()) {
				if (ar.getName().equals(name)) {
					RefSAPoint sapt = RoomFactory.eINSTANCE.createRefSAPoint();
					sapt.setRef(ar);
					return sapt;
				}
			}
		}
		if (sc instanceof LogicalSystem) {
			for (SubSystemRef ssr : ((LogicalSystem) sc).getSubSystems()) {
				if (ssr.getName().equals(name)) {
					RefSAPoint sapt = RoomFactory.eINSTANCE.createRefSAPoint();
					sapt.setRef(ssr);
					return sapt;
				}
			}
		}
		return null;
	}

	private SAPoint getRelaySAPoint(StructureClass sc, String name) {
		if (sc instanceof ActorContainerClass) {
			for (SPPRef spp : ((ActorContainerClass) sc).getIfSPPs()) {
				if (spp.getName().equals(name)) {
					RelaySAPoint sapt = RoomFactory.eINSTANCE.createRelaySAPoint();
					sapt.setRelay(spp);
					return sapt;
				}
			}
		}
		return null;
	}
	
	private boolean isSAPoint(SAPoint a, SAPoint b) {
		if (a instanceof RefSAPoint && b instanceof RefSAPoint) {
			return ((RefSAPoint)a).getRef().getName().equals(((RefSAPoint)b).getRef().getName());
		}
		else if (a instanceof RelaySAPoint && b instanceof RelaySAPoint) {
			return ((RelaySAPoint)a).getRelay().getName().equals(((RelaySAPoint)b).getRelay().getName());
		}
		return false;
	}

	private boolean isSPPoint(SPPoint a, SPPoint b) {
		if (!a.getRef().getName().equals(b.getRef().getName()))
			return false;
		
		if (!a.getService().getName().equals(b.getService().getName()))
			return false;
		
		return true;
	}
	
	private ActorContainerRef getActorContainerRef(RoomClass rc, String name) {
		if (rc instanceof ActorContainerClass) {
			for (ActorRef ar : ((ActorContainerClass) rc).getActorRefs()) {
				if (ar.getName().equals(name))
					return ar;
			}
		}
		else if (rc instanceof LogicalSystem) {
			for (SubSystemRef ssr : ((LogicalSystem) rc).getSubSystems()) {
				if (ssr.getName().equals(name))
					return ssr;
			}
		}
		return null;
	}

	protected Port getPort(RoomClass rc, String name) {
		if (rc instanceof ActorClass) {
			for (Port p : ((ActorClass) rc).getIfPorts()) {
				if (p.getName().equals(name))
					return p;
			}
			for (Port p : ((ActorClass) rc).getIntPorts()) {
				if (p.getName().equals(name))
					return p;
			}
			if (((ActorClass) rc).getBase()!=null)
				return getPort(((ActorClass) rc).getBase(), name);
		}
		else if (rc instanceof SubSystemClass) {
			for (Port p : ((SubSystemClass) rc).getRelayPorts()) {
				if (p.getName().equals(name))
					return p;
			}
		}
		return null;
	}

	protected SPPRef getSPP(RoomClass rc, String name) {
		if (rc instanceof ActorContainerClass) {
			for (SPPRef spp : ((ActorContainerClass) rc).getIfSPPs()) {
				if (spp.getName().equals(name))
					return spp;
			}
			if (rc instanceof ActorClass)
				if (((ActorClass)rc).getBase()!=null)
					return getSPP(((ActorClass)rc).getBase(), name);
		}
		return null;
	}
	
	private RoomClass getRoomClass(RoomModel model, String className) {
		for (DataClass dc : model.getDataClasses()) {
			if (dc.getName().equals(className))
				return dc;
		}
		for (ProtocolClass pc : model.getProtocolClasses()) {
			if (pc.getName().equals(className))
				return pc;
		}
		for (ActorClass ac : model.getActorClasses()) {
			if (ac.getName().equals(className))
				return ac;
		}
		for (SubSystemClass ssc : model.getSubSystemClasses()) {
			if (ssc.getName().equals(className))
				return ssc;
		}
		for (LogicalSystem ls : model.getSystems()) {
			if (ls.getName().equals(className))
				return ls;
		}
		return null;
	}

}
