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


package org.eclipse.etrice.core.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorInstancePath;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.xtext.validation.Check;

 

public class RoomJavaValidator extends AbstractRoomJavaValidator {

	@Check
	public void checkTypeNameStartsWithCapital(RoomClass type) {
		if (!Character.isUpperCase(type.getName().charAt(0))) {
			warning("Name should start with a capital", RoomPackage.ROOM_CLASS__NAME);
		}
	}

	@Check
	public void checkActorRefIsNotCircular(ActorRef ar) {
		if (ar.eContainer() instanceof ActorClass) {
			ActorClass ac = (ActorClass) ar.eContainer();
			
			if (ValidationUtil.isReferencing(ar.getType(), ac)) {
				error("Actor reference is circular", RoomPackage.ACTOR_REF__TYPE);
			}
		}
	}

	@Check
	public void checkBaseClassesNotCircular(DataClass dc) {
		if (dc==null)
			return;
		
		DataClass base = dc.getBase();
		if (base!=null && ValidationUtil.isBaseOf(dc, base))
			error("Base classes are circular", RoomPackage.ACTOR_CLASS__BASE);
	}

	@Check
	public void checkBaseClassesNotCircular(ProtocolClass pc) {
		if (pc==null)
			return;
		
		ProtocolClass base = pc.getBase();
		if (base!=null && ValidationUtil.isBaseOf(pc, base))
			error("Base classes are circular", RoomPackage.ACTOR_CLASS__BASE);
	}

	@Check
	public void checkBaseClassesNotCircular(ActorClass ac) {
		if (ac==null)
			return;
		
		ActorClass base = ac.getBase();
		if (base!=null && ValidationUtil.isBaseOf(ac, base))
			error("Base classes are circular", RoomPackage.ACTOR_CLASS__BASE);
	}
	
	private SubSystemClass getSubSystemClass(EObject obj) {
		EObject ctx = obj.eContainer();
		while (!(ctx instanceof SubSystemClass) && ctx.eContainer()!=null)
			ctx = ctx.eContainer();
		if (ctx instanceof SubSystemClass)
			return (SubSystemClass) ctx;
		
		return null;
	}
	
	@Check
	public void checkInstancePath(ActorInstancePath ai) {
		ActorContainerClass acc = getSubSystemClass(ai);
		for (String seg : ai.getSegments()) {
			boolean found = false;
			for (ActorRef ar : acc.getActorRefs()) {
				if (ar.getName().equals(seg)) {
					acc = ar.getType();
					found = true;
					break;
				}
			}
			if (!found)
				error("wrong actor instance path (segment number "+ai.getSegments().indexOf(seg)+")", RoomPackage.ACTOR_INSTANCE_PATH__SEGMENTS);
		}
	}
	
	@Check
	public void checkPortCompatibility(Binding bind) {
		if (!ValidationUtil.isValid(bind))
			error(ValidationUtil.getErrorMessage(), RoomPackage.BINDING);
	}
	
	@Check
	public void checkServiceCompatibility(LayerConnection conn) {
		if (!ValidationUtil.isValid(conn))
			error(ValidationUtil.getErrorMessage(), RoomPackage.LAYER_CONNECTION);
	}
	
	@Check
	public void checkTrPoint(TrPoint tp) {
		if (!ValidationUtil.isValid(tp))
			error(ValidationUtil.getErrorMessage(), RoomPackage.TR_POINT);
	}
}
