/**
 * @author generated by eTrice
 *
 * Source File of SubSystemClass SubSys
 * 
 */

#include "SubSys.h"

/* include instances for all classes */
#include "SubSys_Inst.h"

#include "etLogger.h"
#include "etMSCLogger.h"


/* data for SubSysten SubSys */
typedef struct SubSys {
	char *name;
} SubSys;

static SubSys SubSysInst = {"SubSys"};

void SubSys_initActorInstances(void);

void SubSys_init(void){
	ET_MSC_LOGGER_SYNC_ENTRY("SubSys", "init")
	etLogger_logInfoF("%s_init", SubSysInst.name);
	
	/* initialization of all message services */
	etMessageService_init(&msgService_Thread1, msgBuffer_Thread1, MESSAGE_POOL_MAX, MESSAGE_BLOCK_SIZE);
	
	/* init all actors */
	SubSys_initActorInstances();
	
	ET_MSC_LOGGER_SYNC_EXIT
}

void SubSys_start(void){
	ET_MSC_LOGGER_SYNC_ENTRY("SubSys", "start")
	etLogger_logInfoF("%s_start", SubSysInst.name);
	ET_MSC_LOGGER_SYNC_EXIT
}

void SubSys_run(void){
	ET_MSC_LOGGER_SYNC_ENTRY("SubSys", "run")
	int32 i;
	for (i=0; i<100; i++){
		etLogger_logInfoF("%s Scheduler tick %d", SubSysInst.name, i);
		etMessageService_execute(&msgService_Thread1);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void SubSys_stop(void){
	ET_MSC_LOGGER_SYNC_ENTRY("SubSys", "stop")
	etLogger_logInfoF("%s_stop", SubSysInst.name);
	ET_MSC_LOGGER_SYNC_EXIT
}

void SubSys_destroy(void){
	ET_MSC_LOGGER_SYNC_ENTRY("SubSys", "destroy")
	etLogger_logInfoF("%s_destroy", SubSysInst.name);
	ET_MSC_LOGGER_SYNC_EXIT
}

void SubSys_initActorInstances(void){
	ET_MSC_LOGGER_SYNC_ENTRY("SubSys", "initActorInstances")
	ReceiverManual_init(&_SubSys_Receiver);
	SenderManual_init(&_SubSys_Sender);
	ET_MSC_LOGGER_SYNC_EXIT
}

