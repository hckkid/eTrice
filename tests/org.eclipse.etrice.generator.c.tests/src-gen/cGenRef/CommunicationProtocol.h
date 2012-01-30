#ifndef _CommunicationProtocol_H_
#define _CommunicationProtocol_H_

#include "etDatatypes.h"


#include "DataClass1.h"

typedef struct {


} CommunicationProtocol;

/* message IDs */
enum {
	CommunicationProtocol_MSG_MIN = 0, 
	/* IDs for outgoing messages */
	CommunicationProtocol_OUT_receivedData = 1,
	/* IDs for incoming messages */
	CommunicationProtocol_IN_sendData = 2,
	CommunicationProtocol_IN_sendData2 = 3,
	/* error if msgID >= MSG_MAX */
	CommunicationProtocol_MSG_MAX = 4
};

/*--------------------- port classes */

typedef struct etPort CommunicationProtocolPort;

void CommunicationProtocolPort_MyOperation1(CommunicationProtocolPort* self, int a, int b);
int CommunicationProtocolPort_MyOperation2(CommunicationProtocolPort* self);



typedef struct etPort CommunicationProtocolConjPort;

void CommunicationProtocolConjPort_MyOperation1(CommunicationProtocolConjPort* self, int a, int b);
int CommunicationProtocolConjPort_MyOperation2(CommunicationProtocolConjPort* self);



/*--------------------- debug helpers */

/* get message string for message id */
const char* CommunicationProtocol_getMessageString(int msg_id);



#endif /* _CommunicationProtocol_H_ */

