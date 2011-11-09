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

package org.eclipse.etrice.generator.base;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.generator.etricegen.IDiagnostician;

import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class Diagnostician implements IDiagnostician {

	private boolean validationFailed = false;

	@Inject
	private ILineOutputLogger logger;
	
	public void warning(String msg, EObject source, EStructuralFeature feature) {
		logger.logInfo("Validation warning: " + getMsgTxt(msg, source, feature));
	}

	public void warning(String msg, EObject source, EStructuralFeature feature, int idx) {
		logger.logInfo("Validation warning: " + getMsgTxt(msg, source, feature) + " at index "+idx);
	}

	public void error(String msg, EObject source, EStructuralFeature feature) {
		validationFailed = true;
		logger.logInfo("Validation error: " + getMsgTxt(msg, source, feature));
	}

	public void error(String msg, EObject source, EStructuralFeature feature, int idx) {
		validationFailed = true;
		logger.logInfo("Validation error: " + getMsgTxt(msg, source, feature) + " at index "+idx);
	}

	public boolean isFailed() {
		return validationFailed;
	}

	private String getMsgTxt(String msg, EObject source, EStructuralFeature feature) {
		return msg + " " + (source==null? "":source.toString()) + " "
						+ (feature==null?"":feature.toString());
	}

}
