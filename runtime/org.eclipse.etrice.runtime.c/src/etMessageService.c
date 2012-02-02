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


#include "etMessageService.h"


#include "etLogger.h"
#include "etMSCLogger.h"

void etMessageService_init(etMessageService* self, etUInt8* buffer, etUInt16 maxBlocks, etUInt16 blockSize){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "init")
	self->messageBuffer.buffer = buffer;
	self->messageBuffer.maxBlocks = maxBlocks;
	self->messageBuffer.blockSize = blockSize;
	etMessageQueue_init(&self->messagePool);
	etMessageQueue_init(&self->messageQueue);

	etMessageService_initMessagePool(self);
	ET_MSC_LOGGER_SYNC_EXIT
}

/*
 * initialize message pool with block buffer
 * all blocks are added to pool
 */
void etMessageService_initMessagePool(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "initMessagePool")
	etInt16 i;

	for (i=0; i<self->messageBuffer.maxBlocks; i++){
		etMessage* block = (etMessage*) &self->messageBuffer.buffer[i*self->messageBuffer.blockSize];
		etMessageQueue_push(&self->messagePool, block);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMessageService_pushMessage(etMessageService* self, etMessage* msg){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "pushMessage")
	etMessageQueue_push(&self->messageQueue, msg);
	ET_MSC_LOGGER_SYNC_EXIT
}

etMessage* etMessageService_popMessage(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "popMessage")
	etMessage* msg = etMessageQueue_pop(&self->messageQueue);
	ET_MSC_LOGGER_SYNC_EXIT
	return msg;
}


etMessage* etMessageService_getMessageBuffer(etMessageService* self, etUInt16 size){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "getMessageBuffer")
	if (size<=self->messageBuffer.blockSize){
		if (self->messagePool.size>0){
			etMessage* msg = etMessageQueue_pop(&self->messagePool);
			ET_MSC_LOGGER_SYNC_EXIT
			return msg;
		}
	}
	ET_MSC_LOGGER_SYNC_EXIT
	return NULL;
}

void etMessageService_returnMessageBuffer(etMessageService* self, etMessage* buffer){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "returnMessageBuffer")
	etMessageQueue_push(&self->messagePool, buffer);
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMessageService_deliverAllMessages(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "deliverAllMessages")
	while (self->messageQueue.size > 0){
		etMessage* msg = etMessageService_popMessage(self);
		etLogger_logInfoF("Message ID=%d, Address=%d", msg->evtID, msg->address);
		etMessageService_returnMessageBuffer(self, msg);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMessageService_execute(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "execute")
	etMessageService_deliverAllMessages(self);
	ET_MSC_LOGGER_SYNC_EXIT
}

