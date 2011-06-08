/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.ui.behavior.DiagramTypeProvider;
import org.eclipse.etrice.ui.structure.support.AutoUpdateFeature;
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

	public UpdateCommand(Diagram diag, TransactionalEditingDomain domain) {
		super(domain);
		this.diagram = diag;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected void doExecute() {
		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram, DiagramTypeProvider.PROVIDER_ID); //$NON-NLS-1$
		IFeatureProvider featureProvider = dtp.getFeatureProvider();
		
		UpdateContext context = new UpdateContext(diagram);
		AutoUpdateFeature feature = new AutoUpdateFeature(featureProvider);
		feature.update(context);
	}

}
