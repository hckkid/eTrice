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

package org.eclipse.etrice.generator.base;

import java.util.ArrayList;

import org.eclipse.xtext.generator.JavaIoFileSystemAccess;

/**
 * a {@link JavaIoFileSystemAccess} which is recording the generated files
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class RecordingFileSystemAccess extends JavaIoFileSystemAccess {

	private ArrayList<String> files = new ArrayList<String>();
	
	@Override
	public void generateFile(String fileName, String slot, CharSequence contents) {
		String outlet = getPathes().get(slot);
		if (outlet!=null) {
			String pathName = toSystemFileName(outlet + "/" + fileName);
			files.add(pathName);
		}
		super.generateFile(fileName, slot, contents);
	}
	
	public ArrayList<String> getFiles() {
		return files;
	}
}
