package org.eclipse.etrice.integration.HandlerTest;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;

import room.basic.service.timing.*;

import room.basic.service.timing.PTimeout.*;
import org.eclipse.etrice.integration.HandlerTest.TestProtocol.*;



public class Tester extends ActorClassBase {

	
	//--------------------- ports
	protected TestProtocolConjPort TestPort1 = null;
	//--------------------- saps
	protected PTimeoutConjPort timer = null;
	//--------------------- services

	//--------------------- interface item IDs
	protected static final int IFITEM_TestPort1 = 1;
	protected static final int IFITEM_timer = 2;
	
	//--------------------- attributes
	//--------------------- operations

	//--------------------- construction
	public Tester(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("Tester");
		
		// initialize attributes

		// own ports
		TestPort1 = new TestProtocolConjPort(this, "TestPort1", IFITEM_TestPort1, 0, port_addr[IFITEM_TestPort1][0], peer_addr[IFITEM_TestPort1][0]); 
		// own saps
		timer = new PTimeoutConjPort(this, "timer", IFITEM_timer, 0, port_addr[IFITEM_timer][0], peer_addr[IFITEM_timer][0]); 
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
	protected static final int STATE_state0 = 2;
		protected static final String stateStrings[] = {"<no state>","<top>","state0"
			};
	
	// history
	// TODOHRR: history defined in ActorClassBase, init in constructor
	//		history = new int[5];
	//		for (int i = 0; i < history.length; i++) {
	//			history[i] = NO_STATE;
	//		}
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE};
	
	// transition chains
	protected static final int CHAIN_TRANS_INITIAL_TO__state0 = 1;
	
	// triggers for FSM
	
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
				case STATE_state0:
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
		int chain = CHAIN_TRANS_INITIAL_TO__state0;
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
				case STATE_state0:
					history[STATE_TOP] = STATE_state0;
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
			case CHAIN_TRANS_INITIAL_TO__state0:
			{
				action_TRANS_INITIAL_TO__state0();
				return STATE_state0;
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
				case STATE_state0:
					// in leaf state: return state id
					return STATE_state0;
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
	protected void action_TRANS_INITIAL_TO__state0() {
		TestPort1.msg1(2);
		System.out.println("msg1(2) sent ");
		TestPort1.msg1(3);
		System.out.println("msg1(3) sent ");
		TestPort1.msg1(7);
		System.out.println("msg1(7) sent ");
		TestPort1.msg1(4);
		System.out.println("msg1(4) sent ");
		TestPort1.msg1(5);
		System.out.println("msg1(5) sent ");
		TestPort1.msg1(7);
		System.out.println("msg1(7) sent ");
		TestPort1.msg2(5);
		System.out.println("msg2(5) sent ");
		TestPort1.msg2(6);
		System.out.println("msg2(6) sent ");
		
		
		
		TestPort1.msg1(5);
		System.out.println("msg1(5) sent ");
		TestPort1.msg3();
		System.out.println("msg3() sent ");
		TestPort1.msg4();
		System.out.println("msg4() sent ");
		TestPort1.msg1(8);
		System.out.println("msg1(8) sent ");
		TestPort1.msg6(12);
		System.out.println("msg6(12) sent ");
	}
		 
	//******************************************
	// END of generated code for FSM
	//******************************************
};
