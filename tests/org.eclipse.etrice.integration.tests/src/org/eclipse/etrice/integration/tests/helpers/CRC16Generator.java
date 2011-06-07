/*******************************************************************************
 * Copyright (c) 2010 tieto deutschland gmbh (http://www.tieto.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Jung (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.integration.tests.helpers;

public class CRC16Generator {
	
	private int crc;
	
	public CRC16Generator(){
		crc = 0;
	}
	
	public int getCrc(){
		return crc;
	}
	
	public void update(int val) {
		/* calculates 16-bit CRC of given data */
		/* based on the polynomial x^16+x^15+x^2+1 */
		 int c,i;
		 
		  c=val;
		  for(i=0;i<16;i++) {
		   if(((crc ^ c) & 1)==1) crc=(crc>>1)^0xA001;
		   else crc>>=1;
		   c>>=1;		  
		}
	}
}
