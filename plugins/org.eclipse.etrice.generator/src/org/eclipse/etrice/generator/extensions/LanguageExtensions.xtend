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
 * CHANGES:
 * 	- moved generator independent functionality from generator.java (Thomas Schuetz)
 * 
 *******************************************************************************/

 /*
	collection of convenience functions for code generation
*/

package org.eclipse.etrice.generator.extensions

import com.google.inject.Singleton
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.RoomClass


@Singleton
class LanguageExtensions extends RoomExtensions {
	
	//-------------------------------------------------------
	// packages and pathes
	
	def String getPackage(RoomClass rc) {
		return (rc.eContainer as RoomModel).name
	}
	
	def String getPathFromPackage(String packageName) {
		return packageName.replaceAll("\\.", "/") + "/"
	}
	
	def String getPath(RoomClass rc) {
		getPathFromPackage(getPackage(rc))
	}
	
}
