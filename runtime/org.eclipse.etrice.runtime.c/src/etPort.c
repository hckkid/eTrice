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

#include "etPort.h"

#include "etMSCLogger.h"

void etPort_receive(const etPort* self, const etMessage* msg) {
	ET_MSC_LOGGER_SYNC_ENTRY("etPort", "receive")
	if (self->receiveMessageFunc!=NULL)
		(self->receiveMessageFunc)(self->myActor, (void*)self, msg);
	ET_MSC_LOGGER_SYNC_EXIT
}


void etPort_sendMessage(const etPort* self, etInt16 evtId) {
	etMessage* msg = etMessageService_getMessageBuffer(self->msgService, sizeof(etMessage));
	msg->address = self->peerAddress;
	msg->evtID = evtId;
	etMessageService_pushMessage(self->msgService, msg);
}
