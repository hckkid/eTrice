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

#ifndef _ETMESSAGESERVICE_H_
#define _ETMESSAGESERVICE_H_

#include <stddef.h>
#include "etDatatypes.h"
#include "messaging/etMessageQueue.h"
#include "messaging/etMessageReceiver.h"

typedef struct etBuffer{
	etUInt8 *buffer;
	etUInt16 maxBlocks;
	etUInt16 blockSize;
} etBuffer;

typedef struct etMessageService {
	etMessageQueue messageQueue;
	etMessageQueue messagePool;
	etBuffer messageBuffer;
	etDispatcherReceiveMessage msgDispatcher;
} etMessageService;

void etMessageService_init(etMessageService* self, etUInt8* buffer, etUInt16 maxBlocks, etUInt16 blockSize, etDispatcherReceiveMessage msgDispatcher);

void etMessageService_initMessagePool(etMessageService* self);

void etMessageService_pushMessage(etMessageService* self, etMessage* msg);
etMessage* etMessageService_popMessage(etMessageService* self);

etMessage* etMessageService_getMessageBuffer(etMessageService* self, etUInt16 size);
void etMessageService_returnMessageBuffer(etMessageService* self, etMessage* buffer);

void etMessageService_execute(etMessageService* self);

/* functions for debug and service information  */
etInt16 etMessageService_getMessagePoolLowWaterMark(etMessageService* self);


#endif /* RMESSAGESERVICE_H_ */
