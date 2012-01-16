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

void etMessageService_init(etMessageService* self, etUInt8* buffer, etUInt16 maxBlocks, etUInt16 blockSize){
	self->messageBuffer.buffer = buffer;
	self->messageBuffer.maxBlocks = maxBlocks;
	self->messageBuffer.blockSize = blockSize;
	etMessageQueue_init(&self->messagePool);
	etMessageQueue_init(&self->messageQueue);

	etMessageService_initMessagePool(self);
}

/*
 * initialize message pool with block buffer
 * all blocks are added to pool
 */
void etMessageService_initMessagePool(etMessageService* self){
	etInt16 i;

	for (i=0; i<self->messageBuffer.maxBlocks; i++){
		etMessage* block = (etMessage*) &self->messageBuffer.buffer[i*self->messageBuffer.blockSize];
		etMessageQueue_push(&self->messagePool, block);
	}
}

void etMessageService_pushMessage(etMessageService* self, etMessage* msg){
	etMessageQueue_push(&self->messageQueue, msg);

}

etMessage* etMessageService_popMessage(etMessageService* self){
	return etMessageQueue_pop(&self->messageQueue);
}


etMessage* etMessageService_getMessageBuffer(etMessageService* self, etUInt16 size){
	if (size<=self->messageBuffer.blockSize){
		if (self->messagePool.size>0){
			return etMessageQueue_pop(&self->messagePool);
		}
	}
	return NULL;
}

void etMessageService_returnMessageBuffer(etMessageService* self, etMessage* buffer){
	etMessageQueue_push(&self->messagePool, buffer);
}
