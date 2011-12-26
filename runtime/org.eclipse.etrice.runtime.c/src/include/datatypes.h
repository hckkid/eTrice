/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#ifndef _DATATYPES_H_
#define _DATATYPES_H_

/* unsigned integer datatypes */
typedef unsigned char uint8;
typedef unsigned short int uint16;
typedef unsigned long uint32;

/* signed integer datatypes */
typedef char int8;
typedef short int int16;
typedef long int32;

/* float datatypes */
typedef float float32;
typedef double float64;

/* boolean datatypes and values */
typedef char boool;  /* TODO: bool, Bool, Boolean, and boolean are already defined in some platforms*/
#ifndef TRUE
	#define TRUE 1
#endif
#ifndef FALSE
	#define FALSE 0
#endif


#endif /* _DATATYPES_H_ */
