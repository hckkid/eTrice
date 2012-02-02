#ifndef _SenderManual_H_
#define _SenderManual_H_

#include "etDatatypes.h"

//package cGenRef;



#include "DataClass1.h"

#include "CommunicationProtocol.h"



public class SenderManual extends ActorClassBase {

	
	//--------------------- ports
	protected CommunicationProtocolConjPort dataOut = null;
	//--------------------- saps
	//--------------------- services

	//--------------------- interface item IDs
	protected static final int IFITEM_dataOut = 1;
	
	//--------------------- attributes
	int32 attribute1;
	DataClass1 attribute2;
	//--------------------- operations
	void SenderManual_operation1(SenderManual* self, int32 argument1, DataClass1 argument2);

	//--------------------- construction
	public SenderManual(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("SenderManual");
		
		// initialize attributes
		attribute1 = 0;
		attribute2 = new DataClass1();

		// own ports
		dataOut = new CommunicationProtocolConjPort(this, "dataOut", IFITEM_dataOut, 0, port_addr[IFITEM_dataOut][0], peer_addr[IFITEM_dataOut][0]); 
		// own saps
		// own service implementations
	}
	

	//--------------------- lifecycle functions
	public void init(){
		initUser();
	}

	public void start(){
		startUser();
	}

	public void stop(){
		stopUser();
	}
	
	public void destroy(){
		destroyUser();
	}	

	//--------------------- no state machine
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
	handleSystemEvent(ifitem, evt, data);
	}
	
	@Override
	public void executeInitTransition(){
	}
};

#endif /* _SenderManual_H_ */

