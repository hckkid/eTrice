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

#ifndef RMESSAGESERVICE_H_
#define RMESSAGESERVICE_H_

#include <stddef.h>
#include "datatypes.h"
#include "RMessageQueue.h"


typedef struct RBuffer{
	uint8 *buffer;
	uint16 maxBlocks;
	uint16 blockSize;
} RBuffer;

typedef struct RMessageService {
	RMessageQueue messageQueue;
	RMessageQueue messagePool;
	RBuffer messageBuffer;
} RMessageService;

void RMessageService_init(RMessageService* self, uint8* buffer, uint16 maxBlocks, uint16 blockSize);

void RMessageService_initMessagePool(RMessageService* self);

void RMessageService_pushMessage(RMessageService* self, RMessage* msg);
RMessage* RMessageService_popMessage(RMessageService* self);


RMessage* RMessageService_getMessageBuffer(RMessageService* self, int16 size);
void RMessageService_returnMessageBuffer(RMessageService* self, RMessage* buffer);

#endif /* RMESSAGESERVICE_H_ */
