/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.c.gen;

import java.util.ArrayList;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.generator.base.ITranslationProvider;
import org.eclipse.etrice.generator.extensions.RoomExtensions;

import com.google.inject.Inject;

public class CTranslationProvider implements ITranslationProvider {

	@Inject private RoomExtensions roomExt;
	private ActorClass ac;
	
	@Override
	public void setActorClass(ActorClass ac) {
		this.ac = ac;
	}

	@Override
	public boolean translateMembers() {
		return true;
	}

	@Override
	public String getAttributeText(Attribute att, String orig) {
		return "self->"+att.getName();
	}

	@Override
	public String getOperationText(Operation op, ArrayList<String> args, String orig) {
		StringBuilder result = new StringBuilder();
		result.append(op.getName()+"(self");
		for (String arg : args) {
			result.append(", "+arg);
		}
		result.append(") /* ORIG: "+orig+" */");
		return result.toString();
	}

	@Override
	public String getInterfaceItemMessageText(InterfaceItem item, Message msg, ArrayList<String> args, String orig) {
		String result = orig;
		if (item instanceof Port) {
			Port p = (Port) item;
			if (p.getMultiplicity()==1)
				result = roomExt.getPortClassName(p)+"_"+msg.getName()+"(&self->constData->"+item.getName()+")";
			else
				result = roomExt.getPortClassName(p)+"_"+msg.getName()+"_broadcast(&self->constData->"+item.getName()+")";
			
			result += " /* "+orig+" */";
		}
		return result;
	}

	@Override
	public String getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig) {
		return null;
	}

	@Override
	public boolean translateTags() {
		return false;
	}

	@Override
	public String translateTag(String tag, DetailCode code) {
		return null;
	}

}
