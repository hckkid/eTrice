/*
 * RunRuntimeTestcases.c
 *
 *  Created on: 12.01.2012
 *      Author: tschuetz
 */



#include "RunCRuntimeTestcases.h"

#include "TestEtMessage.h"
#include "TestEtMessageQueue.h"
#include "TestEtMessageService.h"

void RunCRuntimeTestcases(void){
	TestEtMessage_runSuite();
	TestEtMessageQueue_runSuite();
	TestEtMessageService_runSuite();
}

