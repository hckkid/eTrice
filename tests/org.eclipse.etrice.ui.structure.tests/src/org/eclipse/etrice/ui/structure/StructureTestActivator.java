package org.eclipse.etrice.ui.structure;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class StructureTestActivator extends Plugin implements BundleActivator {

	private static StructureTestActivator instance = null;
	
	public static StructureTestActivator getInstance() {
		return instance;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		instance = this;
	}

}
