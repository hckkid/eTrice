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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.generator.builder.GeneratorModelBuilder;
import org.eclipse.etrice.generator.builder.ILogger;
import org.eclipse.etrice.generator.etricegen.IDiagnostician;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.java.setup.StandaloneSetup;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class Main {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println(Main.class.getName()+" - aborting: no arguments!");
			printUsage();
			return;
		}

		// parsing arguments
		String genModelPath = null;
		List<String> uriList = new ArrayList<String>();
		for (int i=0; i<args.length; ++i) {
			if (args[i].equals("-saveGenModel")) {
				if (++i<args.length) {
					genModelPath = convertToURI(args[i]);
				}
			}
			else {
				uriList.add(convertToURI(args[i]));
			}
		}

		// setting up required models
		Injector roomInjector = new org.eclipse.etrice.core.RoomStandaloneSetup().createInjectorAndDoEMFRegistration();
		IResourceValidator validator = roomInjector.getInstance(IResourceValidator.class);
		org.eclipse.etrice.generator.SetupGenerator.doSetup();

		Injector injector = new StandaloneSetup().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);
		main.runGenerator(uriList, genModelPath, validator);
	}

	private static String convertToURI(String uri) {
		if (uri.startsWith("file:")) {
			return uri.replace('\\', '/');
		}
		else {
			return "file://"+uri.replace('\\', '/');
		}
	}
	
	/**
	 * print usage message to stderr
	 */
	private static void printUsage() {
		System.err.println(Main.class.getName()+" [-saveGenModel <genmodel path>] <list of model file paths>");
		System.err.println("      <list of model file paths>        # model file paths may be specified as");
		System.err.println("                                        # e.g. C:\\path\\to\\model\\mymodel.room");
		System.err.println("      -saveGenModel <genmodel path>     # if specified the generator model will be saved to this location");
	}

	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	
	@Inject
	private ILogger logger;
	
	@Inject
	private IDiagnostician diagnostician;

	@Inject
	private IGenerator generator;

	@Inject
	private JavaIoFileSystemAccess fileAccess;

	protected void runGenerator(List<String> uriList, String genModelPath, IResourceValidator validator) {
		ResourceSet rs = resourceSetProvider.get();

		logger.logInfo("-- reading models");
		List<Resource> resourceList = new ArrayList<Resource>();
		for (String uriString : uriList) {
			logger.logInfo("Loading " + uriString);
			resourceList.add(rs.getResource(URI.createURI(uriString), true));
		}

		// resolving all model proxies
		EcoreUtil.resolveAll(rs);

		// validate all resources
		logger.logInfo("-- validating models");
		for (Resource resource : resourceList) {
			List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			if (!list.isEmpty()) {
				for (Issue issue : list) {
					logger.logError(issue.toString(), null);
				}
				return;
			}
		}
		fileAccess.setOutputPath("src-gen/");

		logger.logInfo("-- starting code generation");

		// check resources for right number and types of room models and build a list of them 
		List<RoomModel> rml = new ArrayList<RoomModel>();
		for (Resource resource : resourceList) {
			List<EObject> contents = resource.getContents();
			if (!contents.isEmpty() && contents.get(0) instanceof RoomModel) {
				rml.add((RoomModel)contents.get(0));
			}
		}
		if (rml.isEmpty()) {
			logger.logError("no RoomModels found", null);
		}
		else {
			// create generator model
			GeneratorModelBuilder gmb = new GeneratorModelBuilder(logger, diagnostician);
			Root gmRoot = gmb.createGeneratorModel(rml);
			URI genModelURI = genModelPath!=null? URI.createURI(genModelPath) : URI.createFileURI("tmp.rim");
			Resource genResource = rs.createResource(genModelURI);
			genResource.getContents().add(gmRoot);
			if (genModelPath!=null) {
				try {
					logger.logInfo("-- saving genmodel to "+genModelPath);
					genResource.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					logger.logError(e.getMessage(), null);
				}
			}
			generator.doGenerate(genResource, fileAccess);
		}
			
		logger.logInfo("-- fineshed code generation");
	}
}
