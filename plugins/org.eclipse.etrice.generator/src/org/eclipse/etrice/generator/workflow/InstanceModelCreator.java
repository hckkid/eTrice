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
 *******************************************************************************/

package org.eclipse.etrice.generator.workflow;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.generator.builder.InstanceModelBuilder;
import org.eclipse.etrice.generator.builder.ValidationException;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.etricegen.util.ETriceGenResourceImpl;

public class InstanceModelCreator extends WorkflowComponentWithTwoSlots {

	private XtendStdlibLogger logger;
	private InstanceModelBuilder builder;
	private boolean debug = false;
	private boolean save = false;
	private String uri = "tmp.rim";
	private WorkflowDiagnostician diagnostician;
	
	public boolean isSave() {
		return save;
	}

	public void setSave(boolean save) {
		this.save = save;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	@Override
	public void invoke(IWorkflowContext ctx) {
		logger = new XtendStdlibLogger();
		diagnostician = new WorkflowDiagnostician(logger);
		if (debug)
			logger.setVerbose(true);
		builder = new InstanceModelBuilder(logger, diagnostician);
		
		List<RoomModel> models = getRoomModels(ctx);
	    
	    if (models.size()>0) {
    		Root root = builder.createInstanceModel(models);
    		
    		List<Root> result = new LinkedList<Root>();
    		result.add(root);
    		ctx.put(getOutSlot(), result);
    		
    		if (save)
    			saveResult(root);
	    }
	    else {
	    	logger.logError("InstanceModelCreator: Could not find a RoomModel in input slot "+getInSlot()+".", null);
	    }
	    
	    if (logger.getErrorCount()>0)
	    	throw new ValidationException("Erros detected.");
	}

	private List<RoomModel> getRoomModels(IWorkflowContext ctx) {
		Object object = ctx.get(getInSlot());
		@SuppressWarnings("unchecked")
		List<RoomModel> models = (List<RoomModel>) object;
		return models;
	}

	private void saveResult(Root root) {
	    URI uri = URI.createFileURI(this.uri);
	    Resource resource = new ETriceGenResourceImpl(uri);
	    resource.getContents().add(root);
	    try {
	      resource.save(null);
	    } catch (IOException e) {
	      throw new WrappedException(e);
	    }
	}
}
