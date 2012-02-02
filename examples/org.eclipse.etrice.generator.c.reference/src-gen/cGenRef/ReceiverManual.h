#ifndef _ReceiverManual_H_
#define _ReceiverManual_H_

#include "etDatatypes.h"

//package cGenRef;




#include "CommunicationProtocol.h"



public class ReceiverManual extends ActorClassBase {

	
	//--------------------- ports
	protected CommunicationProtocolPort dataIn = null;
	//--------------------- saps
	//--------------------- services

	//--------------------- interface item IDs
	protected static final int IFITEM_dataIn = 1;
	
	//--------------------- attributes
	//--------------------- operations

	//--------------------- construction
	public ReceiverManual(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("ReceiverManual");
		
		// initialize attributes

		// own ports
		dataIn = new CommunicationProtocolPort(this, "dataIn", IFITEM_dataIn, 0, port_addr[IFITEM_dataIn][0], peer_addr[IFITEM_dataIn][0]); 
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

#endif /* _ReceiverManual_H_ */

