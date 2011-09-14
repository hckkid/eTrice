/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author hrentz
 *
 */
public class SetupGenerator {

	public static void doSetup() {
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/etrice/generator")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/etrice/generator",
					org.eclipse.etrice.generator.etricegen.ETriceGenPackage.eINSTANCE);
		}
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("rim",
				new org.eclipse.etrice.generator.etricegen.util.ETriceGenResourceFactoryImpl());
	}
}
