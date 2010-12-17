package org.eclipse.etrice.generator.etricegen;

import org.eclipse.emf.ecore.EObject;

public interface IDiagnostician {

	void warning(String msg, EObject source);
	void warning(String msg, EObject source, int feature);
	void error(String msg, EObject source);
	void error(String msg, EObject source, int feature);
	
	boolean isFailed();
}
