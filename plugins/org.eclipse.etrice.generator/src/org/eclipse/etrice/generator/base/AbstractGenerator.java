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

package org.eclipse.etrice.generator.base;

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
import org.eclipse.etrice.generator.etricegen.IDiagnostician;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;

/**
 * @author hrentz
 *
 */
public abstract class AbstractGenerator {

	protected static ILineOutput output = new StdLineOutput();

	public static void setOutput(ILineOutput out) {
		if (out!=null)
			output = out;
	}

	/**
	 * creates an instance of the generator and invokes the {@link #runGenerator(String[])} method
	 * @param generatorModule a Guice module from which the {@link Injector} is created
	 * @return
	 */
	protected static void createAndRunGenerator(Module generatorModule, String[] args) {
		Injector injector = Guice.createInjector(generatorModule);
		AbstractGenerator generator = injector.getInstance(AbstractGenerator.class);
		generator.logger.setOutput(output);
		generator.runGenerator(args);
	}

	protected static String convertToURI(String uri) {
		if (uri.startsWith("file:")) {
			return uri.replace('\\', '/');
		}
		else {
			return "file://"+uri.replace('\\', '/');
		}
	}

	@Inject
	protected Provider<ResourceSet> resourceSetProvider;

	@Inject
	protected ILineOutputLogger logger;
	@Inject
	protected IDiagnostician diagnostician;
	
	@Inject
	protected JavaIoFileSystemAccess fileAccess;
	
	protected IResourceValidator validator;

	/**
	 * setup the ROOM core model plug-in and create a validator using injection
	 */
	protected void setupRoomModel() {
		Injector roomInjector = new org.eclipse.etrice.core.RoomStandaloneSetup().createInjectorAndDoEMFRegistration();
		validator = roomInjector.getInstance(IResourceValidator.class);
		org.eclipse.etrice.generator.SetupGenerator.doSetup();
	}

	/**
	 * @param rs the {@link ResourceSet} to which the generator model should be added
	 * @param genModelPath path to store the generator model (not stored if {@code null})
	 * 
	 * @return the {@link Root} object of the generator model (is added to a new Resource also)
	 */
	protected Root createGeneratorModel(ResourceSet rs, String genModelPath) {
		// create a list of ROOM models
		List<RoomModel> rml = new ArrayList<RoomModel>();
		for (Resource resource : rs.getResources()) {
			List<EObject> contents = resource.getContents();
			if (!contents.isEmpty() && contents.get(0) instanceof RoomModel) {
				rml.add((RoomModel)contents.get(0));
			}
		}
		if (rml.isEmpty()) {
			logger.logError("no ROOM models found", null);
			logger.logError("-- terminating", null);
			return null;
		}
		else {
			logger.logInfo("-- creating generator model");
			GeneratorModelBuilder gmb = new GeneratorModelBuilder(logger, diagnostician);
			Root gmRoot = gmb.createGeneratorModel(rml);
			if (diagnostician.isFailed()) {
				logger.logInfo("validation failed during build of generator model");
				logger.logError("-- terminating", null);
				return null;
			}
			URI genModelURI = genModelPath!=null? URI.createURI(genModelPath) : URI.createFileURI("tmp.rim");
			Resource genResource = rs.createResource(genModelURI);
			genResource.getContents().add(gmRoot);
			if (genModelPath!=null) {
				try {
					logger.logInfo("saving genmodel to "+genModelPath);
					genResource.save(Collections.EMPTY_MAP);
				}
				catch (IOException e) {
					logger.logError(e.getMessage(), null);
					logger.logError("-- terminating", null);
					return null;
				}
			}
			return gmRoot;
		}
	}

	/**
	 * validate the models
	 * 
	 * @param rs
	 */
	protected boolean validateModels(ResourceSet rs) {
		logger.logInfo("-- validating models");
		
		int errors = 0;
		int warnings = 0;
		for (Resource resource : rs.getResources()) {
			List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			if (!list.isEmpty()) {
				for (Issue issue : list) {
					if (issue.getSeverity()==Severity.ERROR) {
						++errors;
						logger.logError(issue.toString(), null);
					}
					else {
						++warnings;
						logger.logInfo(issue.toString());
					}
				}
			}
		}
		logger.logInfo("validation finished with "+errors+" errors and "+warnings+" warnings");
		if (errors>0) {
			logger.logError("-- terminating", null);
			return false;
		}
		
		return true;
	}

	/**
	 * load all models into a {@link ResourceSet}
	 * 
	 * @param uriList a list of {@link URI}s as Strings
	 * @param rs the {@link ResourceSet}
	 */
	protected void loadModels(List<String> uriList, ResourceSet rs) {
		logger.logInfo("-- reading models");
		for (String uriString : uriList) {
			logger.logInfo("Loading " + uriString);
			try {
				rs.getResource(URI.createURI(uriString), true);
			}
			catch (RuntimeException e) {
				logger.logError("couldn't load", null);
			}
		}
		
		EcoreUtil.resolveAll(rs);
	}

	/**
	 * abstract method which is finally called by {@link #createAndRunGenerator(Module, String[])}
	 * @param args
	 */
	protected abstract void runGenerator(String[] args);

}
