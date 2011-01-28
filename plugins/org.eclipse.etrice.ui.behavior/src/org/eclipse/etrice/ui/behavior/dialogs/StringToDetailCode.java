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

package org.eclipse.etrice.ui.behavior.dialogs;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.RoomFactory;

public class StringToDetailCode extends Converter {

	public StringToDetailCode() {
		super(String.class, DetailCode.class);
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject instanceof String) {
			String code = (String) fromObject;
			if (code.isEmpty())
				return null;
			
			// TODOHRR: make work also for UNIX/Mac line endings
			String[] cmds = code.split("\r\n");
			DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
			for (int i = 0; i < cmds.length; i++) {
				dc.getCommands().add(cmds[i]);
			}
			// trim last command if empty
			if (cmds[cmds.length-1].isEmpty())
				dc.getCommands().remove(cmds.length-1);
			return dc;
		}
		return null;
	}

}
