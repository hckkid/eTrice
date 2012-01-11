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

#ifndef _RMESSAGEQUEUE_H_
#define _RMESSAGEQUEUE_H_

#include "RMessage.h"
#include <stddef.h>

typedef struct RMessageQueue {
	RMessage* first;
	RMessage* last;
	int16 highWaterMark;
	int16 size;

} RMessageQueue;

void RMessageQueue_init(RMessageQueue* self);

void RMessageQueue_push(RMessageQueue* self, RMessage* msg);

RMessage* RMessageQueue_pop(RMessageQueue* self);

int16 RMessageQueue_getSize(RMessageQueue* self);

RMessage* RMessageQueue_getFirst(RMessageQueue* self);

RMessage* RMessageQueue_getLast(RMessageQueue* self);

boool RMessageQueue_isNotEmpty(RMessageQueue* self);

int16 RMessageQueue_getHightWaterMark(RMessageQueue* self);



#endif /* _RMESSAGEQUEUE_H_ */
