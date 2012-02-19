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



#ifndef _ETMESSAGERECEIVER_H_
#define _ETMESSAGERECEIVER_H_

#include "etMessage.h"

typedef void (*etActorReceiveMessage)(void* self, etInt16 localId, const etMessage*  msg);
typedef void (*etDispatcherReceiveMessage)(const etMessage* msg);

#endif /* _ETMESSAGERECEIVER_H_ */
