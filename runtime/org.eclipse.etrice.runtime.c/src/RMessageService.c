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


#include "RMessageService.h"

void RMessageService_init(RMessageService* self, uint8* buffer, uint16 maxBlocks, uint16 blockSize){
	self->messageBuffer.buffer = buffer;
	self->messageBuffer.maxBlocks = maxBlocks;
	self->messageBuffer.blockSize = blockSize;
	RMessageQueue_init(&self->messagePool);
	RMessageQueue_init(&self->messageQueue);

	RMessageService_initMessagePool(self);
}

/*
 * initialize message pool with block buffer
 * all blocks are added to pool
 */
void RMessageService_initMessagePool(RMessageService* self){
	int i;

	for (i=0; i<self->messageBuffer.maxBlocks; i++){
		RMessage* block = (RMessage*) &self->messageBuffer.buffer[i*self->messageBuffer.blockSize];
		RMessageQueue_push(&self->messagePool, block);
	}
}

void RMessageService_pushMessage(RMessageService* self, RMessage* msg){
	RMessageQueue_push(&self->messageQueue, msg);

}

RMessage* RMessageService_popMessage(RMessageService* self){
	return RMessageQueue_pop(&self->messageQueue);
}


RMessage* RMessageService_getMessageBuffer(RMessageService* self, int16 size){
	if (size<=self->messageBuffer.blockSize){
		if (self->messagePool.size>0){
			return RMessageQueue_pop(&self->messagePool);
		}
	}
	return NULL;
}

void RMessageService_returnMessageBuffer(RMessageService* self, RMessage* buffer){
	RMessageQueue_push(&self->messagePool, buffer);
}
