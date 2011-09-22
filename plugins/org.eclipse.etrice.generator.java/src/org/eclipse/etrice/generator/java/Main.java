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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.java.gen.InstanceDiagramGen;
import org.eclipse.etrice.generator.java.setup.GeneratorModule;
import org.eclipse.xtext.generator.IGenerator;

import com.google.inject.Inject;

public class Main extends AbstractGenerator {
	
	/**
	 * print usage message to stderr
	 */
	private static void printUsage() {
		output.println(Main.class.getName()+" [-saveGenModel <genmodel path>] [-genInstDiag] <list of model file paths>");
		output.println("      <list of model file paths>        # model file paths may be specified as");
		output.println("                                        # e.g. C:\\path\\to\\model\\mymodel.room");
		output.println("      -saveGenModel <genmodel path>     # if specified the generator model will be saved to this location");
		output.println("      -genInstDiag                      # if specified an instance diagram is created for each subsystem");
	}

	public static void main(String[] args) {
		createAndRunGenerator(new GeneratorModule(), args);
	}

	@Inject
	private IGenerator mainGenerator;

	@Inject
	protected InstanceDiagramGen instanceDiagramGenerator;
	
	public void runGenerator(String[] args) {
		if (args.length == 0) {
			logger.logError(Main.class.getName()+" - aborting: no arguments!", null);
			printUsage();
			return;
		}

		// parsing arguments
		String genModelPath = null;
		List<String> uriList = new ArrayList<String>();
		boolean genInstDiag = false;
		for (int i=0; i<args.length; ++i) {
			if (args[i].equals("-saveGenModel")) {
				if (++i<args.length) {
					genModelPath = convertToURI(args[i]+"/genmodel.egm");
				}
			}
			else if (args[i].equals("-genInstDiag")) {
				genInstDiag = true;
			}
			else {
				uriList.add(convertToURI(args[i]));
			}
		}

		setupRoomModel();

		runGenerator(uriList, genModelPath, genInstDiag);
	}

	protected boolean runGenerator(List<String> uriList, String genModelPath, boolean genInstDiag) {
		ResourceSet rs = resourceSetProvider.get();

		loadModels(uriList, rs);

		if (!validateModels(rs))
			return false;

		Root genModel = createGeneratorModel(rs, genModelPath);
		if (genModel==null)
			return false;
		
		logger.logInfo("-- starting code generation");
		fileAccess.setOutputPath("src-gen/");
		mainGenerator.doGenerate(genModel.eResource(), fileAccess);
		if (genInstDiag) {
			instanceDiagramGenerator.doGenerate(genModel);
		}
		logger.logInfo("-- finished code generation");
		
		return true;
	}
}
