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

#include "RMessageQueue.h"

void RMessageQueue_init(RMessageQueue* self){
	self->first = NULL;
	self->last = NULL;
	self->highWaterMark = 0;
	self->size = 0;
}


void RMessageQueue_push(RMessageQueue* self, RMessage* msg){
	// TODO: optimize queue for concurrent push / pop
	if (self->first == NULL) {
		/*no message in queue*/
		self->first = self->last = msg;
	}
	else {
		/*at least one message in queue*/
		self->last->next = msg;
		self->last = msg;
	}
	msg->next = NULL; /*TODO: optimization: this line could be removed if we assume that all messages are initialized*/

	if (++self->size > self->highWaterMark)
		self->highWaterMark++;
}

RMessage* RMessageQueue_pop(RMessageQueue* self){
	RMessage* pop_msg = self->first;
	if(self->first == NULL){
		/*no message in queue*/
		return NULL;
	}
	if (self->first->next==NULL){
		/*only one message in queue*/
		self->first = self->last = NULL;
	}
	else {
		/*more than one message in queue -> set first to nex message*/
		self->first = self->first->next;
	}

	pop_msg->next=NULL;
	self->size--;

	return pop_msg;
}

int16 RMessageQueue_getSize(RMessageQueue* self) {
	return self->size;
}

RMessage* RMessageQueue_getFirst(RMessageQueue* self){
	return self->first;
}

RMessage* RMessageQueue_getLast(RMessageQueue* self){
	return self->last;
}

boool RMessageQueue_isNotEmpty(RMessageQueue* self){
	return self->last != NULL;
}

int16 RMessageQueue_getHightWaterMark(RMessageQueue* self) {
	return self->highWaterMark;
}
