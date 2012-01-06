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

#ifndef RMESSAGE_H_
#define RMESSAGE_H_

#include "datatypes.h"

typedef struct RMessage{
	struct RMessage* next;
	int16 address;
	int16 evtID;
} RMessage;

void RMessage_init(RMessage* self);

#endif /* RMESSAGE_H_ */
