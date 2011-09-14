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
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class Main {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Aborting: no path to EMF resource provided!");
			return;
		}

		// building uri list
		List<String> uriList = new ArrayList<String>();
		for (String arg : args) {
			if (arg.indexOf("file:") == 0) {
				uriList.add(arg.replace('\\', '/'));
			}
			else {
				uriList.add("file://"+arg.replace('\\', '/'));
			}
		}

		// setting up required models
		org.eclipse.etrice.core.RoomStandaloneSetup.doSetup();
		org.eclipse.etrice.generator.SetupGenerator.doSetup();

		Injector injector = new StandaloneSetup().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);
		main.runGenerator(uriList);
	}

	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	
	@Inject
	private ILogger logger;
	
	@Inject
	private IDiagnostician diagnostician;

	//@Inject
	//private IResourceValidator validator;

	@Inject
	private IGenerator generator;

	@Inject
	private JavaIoFileSystemAccess fileAccess;

	protected void runGenerator(List<String> uriList) {
		logger.logInfo("Starting code generation");
		
		// creating ResourceSet for all room models
		ResourceSet rs = resourceSetProvider.get();

		// building list of all resources for room models
		List<Resource> resourceList = new ArrayList<Resource>();
		for (String uriString : uriList) {
			logger.logInfo("Parsing " + uriString);
			resourceList.add(rs.getResource(URI.createURI(uriString), true));
		}

		// resolving all model proxies
		EcoreUtil.resolveAll(rs);

		// validate all resources
		/*for (Resource resource : resourceList) {
			List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			if (!list.isEmpty()) {
				for (Issue issue : list) {
					System.err.println(issue);
				}
				return;
			}
		}*/
		fileAccess.setOutputPath("src-gen/");

		// check resources for right number and types of room models and build a list of them 
		List<RoomModel> rml = new ArrayList<RoomModel>();
		for (Resource resource : resourceList) {
			List<EObject> contents = resource.getContents();
			if (!contents.isEmpty() && contents.get(0) instanceof RoomModel) {
				rml.add((RoomModel)contents.get(0));
			}
		}
		if (rml.size()>0){
			// create generator model
			GeneratorModelBuilder gmb = new GeneratorModelBuilder(logger, diagnostician);
			Root gmRoot = gmb.createGeneratorModel(rml);
			Resource genResource = rs.createResource(URI.createFileURI("./src-gen-out/tmp.rim"));
			genResource.getContents().add(gmRoot);
			generator.doGenerate(genResource, fileAccess);
		}
			
		logger.logInfo("Code generation finished.");
	}
}
