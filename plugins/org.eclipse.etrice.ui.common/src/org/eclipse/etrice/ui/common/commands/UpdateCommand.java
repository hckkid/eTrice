/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.common.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.ui.common.support.AutoUpdateFeature;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.services.GraphitiUi;

/**
 * @author Henrik Rentz-Reichert - initial contribution and API
 *
 */
public class UpdateCommand extends RecordingCommand {

	private Diagram diagram;
	private AutoUpdateFeature feature;

	public UpdateCommand(Diagram diag, TransactionalEditingDomain domain, String providerID) {
		super(domain);
		this.diagram = diag;

		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram, providerID); //$NON-NLS-1$
		IFeatureProvider featureProvider = dtp.getFeatureProvider();
		
		feature = new AutoUpdateFeature(featureProvider);
	}

	public boolean updateNeeded() {
		UpdateContext context = new UpdateContext(diagram);
		return feature.updateNeeded(context).toBoolean();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected void doExecute() {
		UpdateContext context = new UpdateContext(diagram);
		feature.update(context);
	}

}
