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

#include "debugging/etLogger.h"

typedef struct SubSystem {
	char *name;
} SubSystem;

static SubSystem SubSystemInst = {"SubSystem"};

void SubSystem_init(void){
	etLogger_logInfoF("%s_init", SubSystemInst.name);
}

void SubSystem_start(void){
	etLogger_logInfoF("%s_start", SubSystemInst.name);
}

void SubSystem_Scheduler(void){
	int32 i;
	for (i=0; i<100; i++){
		etLogger_logInfoF("%s Scheduler tick %d", SubSystemInst.name, i);
	}
}

void SubSystem_stop(void){
	etLogger_logInfoF("%s_stop", SubSystemInst.name);
}

void SubSystem_destroy(void){
	etLogger_logInfoF("%s_destroy", SubSystemInst.name);
}

