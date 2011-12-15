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

package org.eclipse.etrice.generator.java.gen;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.BasicType;
import org.eclipse.etrice.core.room.Type;
import org.eclipse.etrice.core.room.FreeType;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.etricegen.Root;

import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class Validator {

	@Inject
	private ILogger logger;

	public boolean validate(Root genModel) {
		int errorCount = 0;
		for (RoomModel mdl : genModel.getUsedRoomModels()) {
			TreeIterator<EObject> it = mdl.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				if (obj instanceof BasicType) {
					if (!checkValidType((BasicType) obj))
						errorCount++;
				}
			}
		}
		
		if (errorCount>0) {
			logger.logError("Java generator detected "+errorCount+" error(s) - terminating", null);
			return false;
		}
		
		return true;
	}

	/**
	 * @param type
	 * @return true if type is a valid Java type
	 */
	private boolean checkValidType(BasicType type) {
		boolean isPrimitive = (type instanceof Type)? ((Type)type).getType()==null : ((FreeType)type).getType()==null;
		if (isPrimitive) {
			switch (type.getPrim()) {
			case UINT8:
			case UINT16:
			case UINT32:
				RoomClass roomClass = RoomNameProvider.getModelClass(type);
				String location = RoomNameProvider.getClassLocation(roomClass);
				String where = getWhere(type);
				logger.logError("Java doesn't support unsigned types ("+where+" of "+location+")", null);
				return false;
			}
		}
		return true;
	}
	
	private String getWhere(BasicType type) {
		EObject obj = type;
		while (obj!=null) {
			if (obj instanceof Attribute) {
				Attribute att = (Attribute) obj;
				return "Attribute "+att.getName();
			}
			else if (obj instanceof Operation) {
				Operation op = (Operation) obj;
				return "Operation "+op.getName();
			}
			else if (obj instanceof Message) {
				Message msg = (Message) obj;
				return "Message "+msg.getName();
			}
			obj = obj.eContainer();
		}
		return "unknown";
	}
}
