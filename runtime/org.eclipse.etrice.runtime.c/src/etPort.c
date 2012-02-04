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
	(self->receiveMessageFunc)(self->myActor, self->localId, msg);
	ET_MSC_LOGGER_SYNC_EXIT
}

