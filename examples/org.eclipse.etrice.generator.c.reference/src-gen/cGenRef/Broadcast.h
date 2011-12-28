#ifndef _Broadcast_H_
#define _Broadcast_H_

#include "datatypes.h"

package cGenRef;




#include "CommunicationProtocol.h"



public class Broadcast extends ActorClassBase {

	
	//--------------------- ports
	protected CommunicationProtocolPort dataIn = null;
	protected CommunicationProtocolConjPortRepl dataOut = null;
	//--------------------- saps
	//--------------------- services

	//--------------------- interface item IDs
	protected static final int IFITEM_dataIn = 1;
	protected static final int IFITEM_dataOut = 2;
	
	//--------------------- attributes
	//--------------------- operations

	//--------------------- construction
	public Broadcast(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("Broadcast");
		
		// initialize attributes

		// own ports
		dataIn = new CommunicationProtocolPort(this, "dataIn", IFITEM_dataIn, 0, port_addr[IFITEM_dataIn][0], peer_addr[IFITEM_dataIn][0]); 
		dataOut = new CommunicationProtocolConjPortRepl(this, "dataOut", IFITEM_dataOut, port_addr[IFITEM_dataOut], peer_addr[IFITEM_dataOut]); 
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

	//******************************************
	// START of generated code for FSM
	//******************************************
	
	// State IDs for FSM
	protected static final int STATE_Idle = 2;
	protected static final int STATE_Sending = 3;
	protected static final int STATE_Sending_WaitingForReceived = 4;
	protected static final int STATE_Sending_ReceivedOne = 5;
	protected static final int STATE_Sending_ReceivedTheOther = 6;
	protected static final int STATE_ReceivedBoth = 7;
		protected static final String stateStrings[] = {"<no state>","<top>","Idle",
			"Sending",
			"Sending_WaitingForReceived",
			"Sending_ReceivedOne",
			"Sending_ReceivedTheOther",
			"ReceivedBoth"
			};
	
	// history
	// TODOHRR: history defined in ActorClassBase, init in constructor
	//		history = new int[5];
	//		for (int i = 0; i < history.length; i++) {
	//			history[i] = NO_STATE;
	//		}
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	// transition chains
	protected static final int CHAIN_Sending_TRANS_ReceivedOne_TO_tp1_BY_receivedDatadataOut = 1;
	protected static final int CHAIN_Sending_TRANS_ReceivedTheOther_TO_tp1_BY_receivedDatadataOut = 2;
	protected static final int CHAIN_Sending_TRANS_WaitingForReceived_TO_ReceivedOne_BY_receivedDatadataOut = 3;
	protected static final int CHAIN_Sending_TRANS_WaitingForReceived_TO_ReceivedTheOther_BY_receivedDatadataOut = 4;
	protected static final int CHAIN_TRANS_INITIAL_TO__Idle = 5;
	protected static final int CHAIN_TRANS_Idle_TO_Sending_tp0_BY_sendDatadataIn = 6;
	
	// triggers for FSM
	protected static final int TRIG_dataIn__sendData = IFITEM_dataIn + EVT_SHIFT*CommunicationProtocol.IN_sendData;
	protected static final int TRIG_dataOut__receivedData = IFITEM_dataOut + EVT_SHIFT*CommunicationProtocol.OUT_receivedData;
	
	// receiveEvent contains the main implementation of the FSM
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {
		int trigger = ifitem.getLocalId() + EVT_SHIFT*evt;
		int chain = NOT_CAUGHT;
		int catching_state = NO_STATE;
		boolean is_handler = false;
		boolean skip_entry = false;
		
		if (!handleSystemEvent(ifitem, evt, generic_data)) {
			switch (state) {
				case STATE_Idle:
					switch(trigger) {
					case TRIG_dataIn__sendData:
						{
							chain = CHAIN_TRANS_Idle_TO_Sending_tp0_BY_sendDatadataIn;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_Sending_WaitingForReceived:
					switch(trigger) {
					case TRIG_dataOut__receivedData:
						{ 
						if (true
						)
						{
							chain = CHAIN_Sending_TRANS_WaitingForReceived_TO_ReceivedOne_BY_receivedDatadataOut;
							catching_state = STATE_Sending;
						} else 
						if (false
						)
						{
							chain = CHAIN_Sending_TRANS_WaitingForReceived_TO_ReceivedTheOther_BY_receivedDatadataOut;
							catching_state = STATE_Sending;
						}
						}
					break;
					}
					break;
				case STATE_Sending_ReceivedOne:
					switch(trigger) {
					case TRIG_dataOut__receivedData:
						{ 
						if (true
						)
						{
							chain = CHAIN_Sending_TRANS_ReceivedOne_TO_tp1_BY_receivedDatadataOut;
							catching_state = STATE_Sending;
						}
						}
					break;
					}
					break;
				case STATE_Sending_ReceivedTheOther:
					switch(trigger) {
					case TRIG_dataOut__receivedData:
						{ 
						if (false
						)
						{
							chain = CHAIN_Sending_TRANS_ReceivedTheOther_TO_tp1_BY_receivedDatadataOut;
							catching_state = STATE_Sending;
						}
						}
					break;
					}
					break;
				case STATE_ReceivedBoth:
					break;
			}
		}
		if (chain != NOT_CAUGHT) {
			exitTo(state, catching_state, is_handler);
			int next = executeTransitionChain(chain, ifitem, generic_data);
			next = enterHistory(next, is_handler, skip_entry);
			setState(next);
		}
	}
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			// TODOTS: model switch for activation
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	@Override
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__Idle;
		int next = executeTransitionChain(chain, null, null);
		next = enterHistory(next, false, false);
		setState(next);
	}
	
	/**
	 * calls exit codes while exiting from the current state to one of its
	 * parent states while remembering the history
	 * @param current - the current state
	 * @param to - the final parent state
	 * @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)
	 */
	private void exitTo(int current, int to, boolean handler) {
		while (current!=to) {
			switch (current) {
				case STATE_Idle:
					history[STATE_TOP] = STATE_Idle;
					current = STATE_TOP;
					break;
				case STATE_Sending:
					history[STATE_TOP] = STATE_Sending;
					current = STATE_TOP;
					break;
				case STATE_Sending_WaitingForReceived:
					history[STATE_Sending] = STATE_Sending_WaitingForReceived;
					current = STATE_Sending;
					break;
				case STATE_Sending_ReceivedOne:
					history[STATE_Sending] = STATE_Sending_ReceivedOne;
					current = STATE_Sending;
					break;
				case STATE_Sending_ReceivedTheOther:
					history[STATE_Sending] = STATE_Sending_ReceivedTheOther;
					current = STATE_Sending;
					break;
				case STATE_ReceivedBoth:
					history[STATE_TOP] = STATE_ReceivedBoth;
					current = STATE_TOP;
					break;
			}
		}
	}
	/**
	 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
	 * matching the trigger of this chain. The ID of the final state is returned
	 * @param chain - the chain ID
	 * @param generic_data - the generic data pointer
	 * @return the ID of the final state
	 */
	private int executeTransitionChain(int chain, InterfaceItemBase ifitem, Object generic_data) {
		switch (chain) {
			case CHAIN_TRANS_INITIAL_TO__Idle:
			{
				return STATE_Idle;
			}
			case CHAIN_TRANS_Idle_TO_Sending_tp0_BY_sendDatadataIn:
			{
				int data = (Integer) generic_data;
				action_TRANS_Idle_TO_Sending_tp0_BY_sendDatadataIn(ifitem, data);
				return STATE_Sending_WaitingForReceived;
			}
			case CHAIN_Sending_TRANS_WaitingForReceived_TO_ReceivedOne_BY_receivedDatadataOut:
			{
				return STATE_Sending_ReceivedOne;
			}
			case CHAIN_Sending_TRANS_WaitingForReceived_TO_ReceivedTheOther_BY_receivedDatadataOut:
			{
				return STATE_Sending_ReceivedTheOther;
			}
			case CHAIN_Sending_TRANS_ReceivedOne_TO_tp1_BY_receivedDatadataOut:
			{
				action_TRANS_Sending_tp1_TO_ReceivedBoth(ifitem);
				return STATE_ReceivedBoth;
			}
			case CHAIN_Sending_TRANS_ReceivedTheOther_TO_tp1_BY_receivedDatadataOut:
			{
				action_TRANS_Sending_tp1_TO_ReceivedBoth(ifitem);
				return STATE_ReceivedBoth;
			}
		}
		return NO_STATE;
	}
	/**
	 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
	 * @param state - the state which is entered
	 * @param handler - entry code is executed if not handler
	 * @return - the ID of the final leaf state
	 */
	private int enterHistory(int state, boolean handler, boolean skip_entry) {
		while (true) {
			switch (state) {
				case STATE_Idle:
					// in leaf state: return state id
					return STATE_Idle;
				case STATE_Sending:
					// state has a sub graph
					// without init transition
					state = history[STATE_Sending];
					break;
				case STATE_Sending_WaitingForReceived:
					// in leaf state: return state id
					return STATE_Sending_WaitingForReceived;
				case STATE_Sending_ReceivedOne:
					// in leaf state: return state id
					return STATE_Sending_ReceivedOne;
				case STATE_Sending_ReceivedTheOther:
					// in leaf state: return state id
					return STATE_Sending_ReceivedTheOther;
				case STATE_ReceivedBoth:
					// in leaf state: return state id
					return STATE_ReceivedBoth;
				case STATE_TOP:
					state = history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	//*** Entry and Exit Codes
	
	//*** Action Codes
	protected void action_TRANS_Idle_TO_Sending_tp0_BY_sendDatadataIn(InterfaceItemBase ifitem, int data) {
		//dataOut.get(0).sendData(data);
		//dataOut.get(1).sendData(data);
		dataOut.sendData(data);
	}
	protected void action_TRANS_Sending_tp1_TO_ReceivedBoth(InterfaceItemBase ifitem) {
		dataIn.receivedData();
	}
		 
	//******************************************
	// END of generated code for FSM
	//******************************************
};

#endif /* _Broadcast_H_ */

