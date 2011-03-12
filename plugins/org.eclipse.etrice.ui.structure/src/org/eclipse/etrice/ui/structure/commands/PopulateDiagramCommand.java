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

package org.eclipse.etrice.ui.structure.commands;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.ui.structure.support.ActorContainerRefSupport;
import org.eclipse.etrice.ui.structure.support.StructureClassSupport;
import org.eclipse.etrice.ui.structure.support.SupportUtil;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.services.GraphitiUi;

public class PopulateDiagramCommand extends RecordingCommand {

	private StructureClass sc;
	private Diagram diagram;

	public PopulateDiagramCommand(Diagram diag, StructureClass sc, TransactionalEditingDomain domain) {
		super(domain);
		this.diagram = diag;
		this.sc = sc;
	}

	@Override
	protected void doExecute() {
		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram, "org.eclipse.etrice.ui.structure.diagramTypeProvider"); //$NON-NLS-1$
		IFeatureProvider featureProvider = dtp.getFeatureProvider();
		
		AddContext addContext = new AddContext();
		addContext.setNewObject(sc);
		addContext.setTargetContainer(diagram);
		addContext.setX(StructureClassSupport.MARGIN);
		addContext.setY(StructureClassSupport.MARGIN);

		final HashMap<String, Anchor> ifitem2anchor = new HashMap<String, Anchor>();
		
		IAddFeature addFeature = featureProvider.getAddFeature(addContext);
		if (addFeature!=null && addFeature.canAdd(addContext)) {
			ContainerShape acShape = (ContainerShape) addFeature.add(addContext);

			int width = acShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0).getWidth();
			
			addInterfaceItems(acShape, width, featureProvider, ifitem2anchor);
			
			// actor container references
			if (sc instanceof ActorContainerClass) {
				ActorContainerClass acc = (ActorContainerClass) sc;
				
	        	EList<? extends ActorContainerRef> actorRefs = acc.getActorRefs();
				addRefItems(actorRefs, acShape, width, featureProvider, ifitem2anchor);
			}
			else if (sc instanceof LogicalSystem) {
				LogicalSystem sys = (LogicalSystem) sc;
				
	        	EList<? extends ActorContainerRef> subSystems = sys.getSubSystems();
				addRefItems(subSystems, acShape, width, featureProvider, ifitem2anchor);
			}

			// layer connections
			for (LayerConnection lc : sc.getConnections()) {
				SupportUtil.addLayerConnection(lc, featureProvider, ifitem2anchor);
			}
			
			// base class items
			if (sc instanceof ActorClass) {
				ActorClass base = ((ActorClass) sc).getBase();
				
				// add inherited ports and refs and bindings (and preserve layout)
				if (base!=null)
					StructureClassSupport.addInheritedItems(base, acShape, ifitem2anchor, featureProvider);
			}
			
			// bindings
			for (Binding bind : sc.getBindings()) {
				SupportUtil.addBinding(bind, featureProvider, ifitem2anchor);
			}
		}
		
	}

	protected void addInterfaceItems(ContainerShape acShape, int width,
			IFeatureProvider featureProvider,
			final HashMap<String, Anchor> port2anchor) {
		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			
			// interface spps and ports
			int n = ac.getIfPorts().size() + ac.getIfSPPs().size();
			int delta = width/(n+1);
			int pos = delta;
			for (SPPRef spp : ac.getIfSPPs()) {
				SupportUtil.addInterfaceItem(spp, acShape, pos+StructureClassSupport.MARGIN, featureProvider, port2anchor);
				pos += delta;
			}
			for (Port port : ac.getIfPorts()) {
				SupportUtil.addInterfaceItem(port, acShape, pos+StructureClassSupport.MARGIN, featureProvider, port2anchor);
				pos += delta;
			}
			
			// internal ports
			n = ac.getIntPorts().size();
			delta = width/(n+1);
			pos = delta;
			addPorts(ac.getIntPorts(), acShape, width, featureProvider, port2anchor);
		}
		else if (sc instanceof SubSystemClass) {
			SubSystemClass ssc = (SubSystemClass) sc;
			
			// interface spps and ports
			int n = ssc.getRelayPorts().size() + ssc.getIfSPPs().size();
			int delta = width/(n+1);
			int pos = delta;
			for (SPPRef spp : ssc.getIfSPPs()) {
				SupportUtil.addInterfaceItem(spp, acShape, pos+StructureClassSupport.MARGIN, featureProvider, port2anchor);
				pos += delta;
			}
			for (Port port : ssc.getRelayPorts()) {
				SupportUtil.addInterfaceItem(port, acShape, pos+StructureClassSupport.MARGIN, featureProvider, port2anchor);
				pos += delta;
			}
		}
	}

	protected void addRefItems(EList<? extends ActorContainerRef> actorRefs,
			ContainerShape acShape, int width,
			IFeatureProvider featureProvider, final HashMap<String, Anchor> port2anchor) {
		int ncols = width/ActorContainerRefSupport.DEFAULT_SIZE_X;
		int nrows = actorRefs.size()/ncols;
		int gap = (width-(ncols*ActorContainerRefSupport.DEFAULT_SIZE_X))/(ncols+1);
		int delta = gap+ActorContainerRefSupport.DEFAULT_SIZE_X;
		int x0 = gap+ActorContainerRefSupport.DEFAULT_SIZE_X/2;
		int y0 = ActorContainerRefSupport.DEFAULT_SIZE_Y*3/2;
		int i = 0;
		for (ActorContainerRef ar : actorRefs) {
			int row = i/ncols;
			int col = i%ncols;
			if (row>=nrows) {
				int nc = actorRefs.size()%ncols;
				gap = (width-(nc*ActorContainerRefSupport.DEFAULT_SIZE_X))/(nc+1);
				delta = gap+ActorContainerRefSupport.DEFAULT_SIZE_X;
				x0 = gap+ActorContainerRefSupport.DEFAULT_SIZE_X/2;
			}
			int x = x0+delta*col;
			int y = y0+(ActorContainerRefSupport.MARGIN+ActorContainerRefSupport.DEFAULT_SIZE_Y)*row;
			SupportUtil.addRefItem(ar, acShape, x+StructureClassSupport.MARGIN, y+StructureClassSupport.MARGIN, featureProvider, port2anchor);
			++i;
		}
	}

	protected void addPorts(EList<Port> ifPorts, ContainerShape acShape,
			int width, IFeatureProvider featureProvider, final HashMap<String, Anchor> port2anchor) {
		int n = ifPorts.size();
		int delta = width/(n+1);
		int pos = delta;
		for (Port port : ifPorts) {
			SupportUtil.addInterfaceItem(port, acShape, pos+StructureClassSupport.MARGIN, featureProvider, port2anchor);
			pos += delta;
		}
	}
	
}
