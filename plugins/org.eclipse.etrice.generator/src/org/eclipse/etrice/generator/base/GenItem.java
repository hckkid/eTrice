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


public class GenItem {
	private GenDir parent;
	private String name;
	
	public GenItem(GenDir parent, String name) {
		super();
		this.parent = parent;
		this.name = name;
		
		if (parent!=null)
			parent.getContents().add(this);
	}

	public String getName() {
		return name;
	}
	
	public GenDir getParent() {
		return parent;
	}
	
	public String getPath() {
		if (parent==null)
			return "";
		
		return parent.getPath()+name+"/";
	}
	
	@Override
	public String toString() {
		return getPath();
	}
}