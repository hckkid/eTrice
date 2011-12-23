/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.NonInitialTransition
import org.eclipse.etrice.core.room.Transition
import org.eclipse.etrice.core.room.TriggeredTransition
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.etricegen.TransitionChain
import static extension org.eclipse.etrice.generator.extensions.RoomNameProv.*
import org.eclipse.etrice.generator.extensions.RoomExtensions

@Singleton
class StateMachineGen {
	
	@Inject extension JavaExtensions stdExt
	@Inject extension RoomExtensions roomExt
	@Inject org.eclipse.etrice.generator.generic.LanguageGenerator languageGen

	def genStateMachine(ExpandedActorClass xpac, ActorClass ac) {'''
		//******************************************
		// START of generated code for FSM
		//******************************************
		
		// State IDs for FSM
		«var offset = ac.getNumberOfInheritedBaseStates()»
		«var baseStates = ac.stateMachine.getBaseStateList()»
		«FOR state : baseStates»
			protected static final int «state.getStateId()» = «baseStates.indexOf(state)+2+offset»;
		«ENDFOR»
			protected static final String stateStrings[] = {"<no state>","<top>",«FOR state : ac.getAllBaseStates() SEPARATOR ","»"«state.getStatePathName()»"
		«ENDFOR»};
		
		// history
		// TODOHRR: history defined in ActorClassBase, init in constructor
		//		history = new int[5];
		//		for (int i = 0; i < history.length; i++) {
		//			history[i] = NO_STATE;
		//		}
		protected int history[] = {NO_STATE,NO_STATE«FOR state : ac.getAllBaseStates()»,NO_STATE«ENDFOR»};
		
		«var List<TransitionChain> chains = xpac.getOwnTransitionChains()»
		«var offset_tc = xpac.getTransitionChains().size-chains.size»
		// transition chains
		«FOR tc : chains»
			protected static final int «tc.getChainId()» = «chains.indexOf(tc)+1+offset_tc»;
		«ENDFOR»
		
		«var triggers = xpac.getOwnTriggers()»
		// triggers for FSM
		«FOR mif : triggers»protected static final int «xpac.getTriggerCodeName(mif)» = IFITEM_«mif.from.name» + EVT_SHIFT*«xpac.getMessageID(mif)»;
		«ENDFOR»
		
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
					«FOR state : xpac.stateMachine.getLeafStateList()»
					case «state.getStateId()»:
						«var atlist =  xpac.getActiveTriggers(state)»
						«IF !atlist.isEmpty»
							switch(trigger) {
							«FOR at : atlist»
								case «xpac.getTriggerCodeName(at.trigger)»:
									«var needData = xpac.hasGuard(at)»
									«IF needData»{ «at.msg.getTypedDataDefinition()»«ENDIF»
									«FOR tt : at.transitions SEPARATOR " else "»
										«var chain = xpac.getChain(tt)»
										«guard(chain.transition, at.trigger, xpac)»
										{
											chain = «chain.getChainId()»;
											catching_state = «chain.getContextId()»;
											«IF chain.isHandler()»is_handler = true;«ENDIF»
											«IF chain.skipEntry»skip_entry = true;«ENDIF»
										}
									«ENDFOR»
									«IF needData»}«ENDIF»
								break;
							«ENDFOR»
							}
						«ENDIF»
						break;
					«ENDFOR»
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
			«var initt = xpac.stateMachine.getInitTransition()»
			int chain = «xpac.getChain(initt).getChainId()»;
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
					«FOR state : xpac.stateMachine.getBaseStateList()»
						case «state.getStateId()»:
							«IF state.hasExitCode()»if (!handler) «state.getExitCodeOperationName()»();«ENDIF»
							history[«state.getParentStateId()»] = «state.getStateId()»;
							current = «state.getParentStateId()»;
							break;
					«ENDFOR»
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
				«var allchains = xpac.getTransitionChains()»
				«FOR tc : allchains»
					case «tc.getChainId()»:
					{
						«xpac.getExecuteChainCode(tc)»
					}
				«ENDFOR»
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
					«FOR state : xpac.stateMachine.getBaseStateList()»
					case «state.getStateId()»:
						«IF state.hasEntryCode()»if (!(skip_entry || handler)) «state.getEntryCodeOperationName()»();«ENDIF»
						«IF state.isLeaf()»
							// in leaf state: return state id
							return «state.getStateId()»;
						«ELSE»
							// state has a sub graph
							«IF state.subgraph.hasInitTransition()»
								// with init transition
								if (history[«state.getStateId()»]==NO_STATE) {
									«var sub_initt = state.subgraph.getInitTransition()»
									state = executeTransitionChain(«xpac.getChain(sub_initt).getChainId()», null, null);
								}
								else {
									state = history[«state.getStateId()»];
								}
							«ELSE»
								// without init transition
								state = history[«state.getStateId()»];
							«ENDIF»
							break;
						«ENDIF»
					«ENDFOR»
					case STATE_TOP:
						state = history[STATE_TOP];
						break;
				}
				skip_entry = false;
			}
			//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
		}
		
		//*** Entry and Exit Codes
		«FOR state : xpac.stateMachine.getStateList()»
			«IF xpac.isOwnObject(state)»
				«IF state.hasEntryCode()»
					protected void «state.getEntryCodeOperationName()»() {
						«xpac.getEntryCode(state)»
					}
				«ENDIF»
				«IF state.hasExitCode()»
					protected void «state.getExitCodeOperationName()»() {
						«xpac.getExitCode(state)»
					}
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		
		//*** Action Codes
		«FOR tr : xpac.stateMachine.getTransitionList()»
			«IF xpac.isOwnObject(tr) && tr.hasActionCode()»
				protected void «tr.getActionCodeOperationName()»(«IF tr instanceof NonInitialTransition»InterfaceItemBase ifitem«languageGen.getArgumentList(xpac, tr)»«ENDIF») {
					«xpac.getActionCode(tr)»
				}
			«ENDIF»
		«ENDFOR»
			 
		//******************************************
		// END of generated code for FSM
		//******************************************
	'''}
		
	def dispatch guard(TriggeredTransition tt, String trigger, ExpandedActorClass ac) {'''
		«var tr = tt.triggers.findFirst(e|ac.isMatching(e, trigger))»
		«IF tr.hasGuard()»
			if («ac.getCode(tr.guard.guard)»)
		«ENDIF»
	'''
	}

	def dispatch guard(Transition t, String trigger, ExpandedActorClass ac) {'''
		/* error */
	'''
	}
}
