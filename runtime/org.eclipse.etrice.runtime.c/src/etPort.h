/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/



#ifndef _ETPORT_H_
#define _ETPORT_H_


#include "etMessage.h"
#include "etMessageReceiver.h"
#include "etMessageService.h"

typedef struct {
	void* myActor;
	etActorReceiveMessage receiveMessageFunc;
	etMessageService* msgService;
	etAddressId peerAddress;
	etAddressId localId;

	#ifdef etDEBUG
	etAddressId address;
	/* thread ID from msg service: msgService->threadId */
	#endif
} etPort;

void etPort_receive(const etPort* self, const etMessage* msg);




#endif /* _ETPORT_H_ */
