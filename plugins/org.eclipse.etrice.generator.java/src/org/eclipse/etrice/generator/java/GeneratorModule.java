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

package org.eclipse.etrice.generator.java;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.etrice.generator.builder.ILogger;
import org.eclipse.etrice.generator.etricegen.IDiagnostician;
import org.eclipse.etrice.generator.java.gen.MainGen;
import org.eclipse.xtext.generator.IGenerator;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class GeneratorModule implements Module {

//	@Override
	public void configure(Binder binder) {
		binder.bind(IGenerator.class).to(MainGen.class);
		binder.bind(ResourceSet.class).to(ResourceSetImpl.class);

		binder.bind(Logger.class).in(Singleton.class);
		binder.bind(ILogger.class).to(Logger.class);
		
		binder.bind(Diagnostician.class).in(Singleton.class);
		binder.bind(IDiagnostician.class).to(Diagnostician.class);
	}

}
