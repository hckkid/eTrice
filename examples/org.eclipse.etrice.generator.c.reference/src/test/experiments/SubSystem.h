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



#ifndef _SUBSYSTEM_H_
#define _SUBSYSTEM_H_

void SubSystem_init(void); // lifecycle init
void SubSystem_start(void); // lifecycle start

void SubSystem_Scheduler(void);

void SubSystem_stop(void); // lifecycle stop
void SubSystem_destroy(void); // lifecycle destroy


#endif /* _SUBSYSTEM_H_ */
