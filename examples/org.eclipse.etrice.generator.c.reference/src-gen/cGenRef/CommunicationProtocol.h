#ifndef _CommunicationProtocol_H_
#define _CommunicationProtocol_H_

#include "datatypes.h"



#include "CommunicationProtocol.h"

typedef struct {


} CommunicationProtocol;

/* message IDs */
enum {
	MSG_CommunicationProtocol_MIN = 0, 
	/* IDs for outgoing messages */
	OUT_CommunicationProtocol_receivedData = 1,
	/* IDs for incoming messages */
	IN_CommunicationProtocol_sendData = 2,
	IN_CommunicationProtocol_sendData2 = 3,
	/* error if msgID >= MSG_MAX */
	MSG_CommunicationProtocol_MAX = 4
};


/* message names as strings for debugging (generate MSC) */
/* TODO: make this optional or different for smaller footprint */
static char CommunicationProtocol_messageStrings[][] = {"MIN", "receivedData","sendData", "sendData2", "MAX"};

char* CommunicationProtocol_getMessageString(int msg_id) {
	if (msg_id<MSG_CommunicationProtocol_MIN || msg_id>MSG_CommunicationProtocol_MAX+1){
		/* id out of range */
		return "Message ID out of range";
	}
	else{
		return CommunicationProtocol_messageStrings[msg_id];
	}
}




#endif /* _CommunicationProtocol_H_ */

