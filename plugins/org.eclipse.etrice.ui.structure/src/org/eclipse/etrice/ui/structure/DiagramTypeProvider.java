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

package org.eclipse.etrice.ui.structure;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Inject;

public class DiagramTypeProvider extends AbstractDiagramTypeProvider {

	private IToolBehaviorProvider[] toolBehaviorProviders;
	private ProviderDispatcher dispatcher;
	
	@Inject
	private IScopeProvider scopeProvider;

	public DiagramTypeProvider() {
		super();
        
//		Injector injector = RoomStandaloneSetup.doSetup();
//        injector.injectMembers(this);

        dispatcher = new ProviderDispatcher(this);
		setFeatureProvider(dispatcher.getFeatureProvider());
	}

	@Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders =
                new IToolBehaviorProvider[] {
            		dispatcher.getToolBehaviorProvider() };
        }
        return toolBehaviorProviders;
    }

	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}
}
