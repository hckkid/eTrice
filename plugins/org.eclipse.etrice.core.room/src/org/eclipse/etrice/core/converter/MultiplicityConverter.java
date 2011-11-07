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

package org.eclipse.etrice.core.converter;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;


/**
 * @author Henrik Rentz-Reichert
 *
 */
public class MultiplicityConverter extends AbstractLexerBasedConverter<Integer> {

	@Override
	protected String toEscapedString(Integer value) {
		if (value==-1)
			return "[*]";
		return "["+value.toString()+"]";
	}
	
	@Override
	protected void assertValidValue(Integer value) {
		super.assertValidValue(value);
	}
	
	public Integer toValue(String string, INode node) {
		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to integer.", node, null);
		if (string.indexOf("*")>=0)
			return -1;
		try {
			int intValue = Integer.parseInt(string.substring(1, string.length()-1));
			return Integer.valueOf(intValue);
		} catch (NumberFormatException e) {
			throw new ValueConverterException("Couldn't convert '" + string + "' to integer.", node, e);
		}
	}

}
