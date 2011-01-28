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

public class DetailCodeToString extends Converter {

	public DetailCodeToString() {
		super(DetailCode.class, String.class);
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject instanceof DetailCode) {
			String result = "";
			for (String cmd : ((DetailCode) fromObject).getCommands()) {
				result += cmd+"\n";
			}
			return result;
		}
		return null;
	}
}
