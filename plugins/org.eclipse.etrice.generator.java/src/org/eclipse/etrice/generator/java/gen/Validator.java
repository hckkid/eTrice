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
import org.eclipse.etrice.core.room.RoomModel;
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
				//EObject obj = it.next();
				
				// currently unused
			}
		}
		
		if (errorCount>0) {
			logger.logError("Java generator detected "+errorCount+" error(s) - terminating", null);
			return false;
		}
		
		return true;
	}
}
