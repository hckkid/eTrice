package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Guard;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.NonInitialTransition;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateMachine;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.generator.etricegen.ActiveTrigger;
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass;
import org.eclipse.etrice.generator.etricegen.TransitionChain;
import org.eclipse.etrice.generator.extensions.RoomExtensions;
import org.eclipse.etrice.generator.extensions.RoomNameProv;
import org.eclipse.etrice.generator.generic.LanguageGenerator;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class StateMachineGen {
  @Inject
  private JavaExtensions stdExt;
  
  @Inject
  private RoomExtensions roomExt;
  
  @Inject
  private TypeHelpers _typeHelpers;
  
  @Inject
  private LanguageGenerator languageGen;
  
  public StringConcatenation genStateMachine(final ExpandedActorClass xpac, final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//******************************************");
    _builder.newLine();
    _builder.append("// START of generated code for FSM");
    _builder.newLine();
    _builder.append("//******************************************");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// State IDs for FSM");
    _builder.newLine();
    int _numberOfInheritedBaseStates = this.roomExt.getNumberOfInheritedBaseStates(ac);
    int offset = _numberOfInheritedBaseStates;
    _builder.newLineIfNotEmpty();
    StateMachine _stateMachine = ac.getStateMachine();
    List<State> _baseStateList = this.roomExt.getBaseStateList(_stateMachine);
    List<State> baseStates = _baseStateList;
    _builder.newLineIfNotEmpty();
    {
      for(final State state : baseStates) {
        _builder.append("protected static final int ");
        String _stateId = this.roomExt.getStateId(state);
        _builder.append(_stateId, "");
        _builder.append(" = ");
        int _indexOf = baseStates.indexOf(state);
        int _operator_plus = IntegerExtensions.operator_plus(((Integer)_indexOf), ((Integer)2));
        int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)_operator_plus), ((Integer)offset));
        _builder.append(_operator_plus_1, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("protected static final String stateStrings[] = {\"<no state>\",\"<top>\",");
    {
      List<State> _allBaseStates = this.roomExt.getAllBaseStates(ac);
      boolean hasAnyElements = false;
      for(final State state_1 : _allBaseStates) {
        if (!hasAnyElements) {
          hasAnyElements = true;
        } else {
          _builder.appendImmediate(",", "	");
        }
        _builder.append("\"");
        String _statePathName = this.roomExt.getStatePathName(state_1);
        _builder.append(_statePathName, "	");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
      }
    }
    _builder.append("};");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// history");
    _builder.newLine();
    _builder.append("// TODOHRR: history defined in ActorClassBase, init in constructor");
    _builder.newLine();
    _builder.append("//\t\thistory = new int[5];");
    _builder.newLine();
    _builder.append("//\t\tfor (int i = 0; i < history.length; i++) {");
    _builder.newLine();
    _builder.append("//\t\t\thistory[i] = NO_STATE;");
    _builder.newLine();
    _builder.append("//\t\t}");
    _builder.newLine();
    _builder.append("protected int history[] = {NO_STATE,NO_STATE");
    {
      List<State> _allBaseStates_1 = this.roomExt.getAllBaseStates(ac);
      for(final State state_2 : _allBaseStates_1) {
        _builder.append(",NO_STATE");
      }
    }
    _builder.append("};");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    EList<TransitionChain> _ownTransitionChains = xpac.getOwnTransitionChains();
    List<TransitionChain> chains = _ownTransitionChains;
    _builder.newLineIfNotEmpty();
    EList<TransitionChain> _transitionChains = xpac.getTransitionChains();
    int _size = _transitionChains.size();
    int _size_1 = chains.size();
    int _operator_minus = IntegerExtensions.operator_minus(((Integer)_size), ((Integer)_size_1));
    int offset_tc = _operator_minus;
    _builder.newLineIfNotEmpty();
    _builder.append("// transition chains");
    _builder.newLine();
    {
      for(final TransitionChain tc : chains) {
        _builder.append("protected static final int ");
        String _chainId = this.roomExt.getChainId(tc);
        _builder.append(_chainId, "");
        _builder.append(" = ");
        int _indexOf_1 = chains.indexOf(tc);
        int _operator_plus_2 = IntegerExtensions.operator_plus(((Integer)_indexOf_1), ((Integer)1));
        int _operator_plus_3 = IntegerExtensions.operator_plus(((Integer)_operator_plus_2), ((Integer)offset_tc));
        _builder.append(_operator_plus_3, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    EList<MessageFromIf> _ownTriggers = xpac.getOwnTriggers();
    EList<MessageFromIf> triggers = _ownTriggers;
    _builder.newLineIfNotEmpty();
    _builder.append("// triggers for FSM");
    _builder.newLine();
    {
      for(final MessageFromIf mif : triggers) {
        _builder.append("protected static final int ");
        String _triggerCodeName = xpac.getTriggerCodeName(mif);
        _builder.append(_triggerCodeName, "");
        _builder.append(" = IFITEM_");
        InterfaceItem _from = mif.getFrom();
        String _name = _from.getName();
        _builder.append(_name, "");
        _builder.append(" + EVT_SHIFT*");
        String _messageID = xpac.getMessageID(mif);
        _builder.append(_messageID, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("// receiveEvent contains the main implementation of the FSM");
    _builder.newLine();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int trigger = ifitem.getLocalId() + EVT_SHIFT*evt;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int chain = NOT_CAUGHT;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int catching_state = NO_STATE;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("boolean is_handler = false;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("boolean skip_entry = false;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (!handleSystemEvent(ifitem, evt, generic_data)) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (state) {");
    _builder.newLine();
    {
      StateMachine _stateMachine_1 = xpac.getStateMachine();
      List<State> _leafStateList = this.roomExt.getLeafStateList(_stateMachine_1);
      for(final State state_3 : _leafStateList) {
        _builder.append("\t\t\t");
        _builder.append("case ");
        String _stateId_1 = this.roomExt.getStateId(state_3);
        _builder.append(_stateId_1, "			");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        EList<ActiveTrigger> _activeTriggers = xpac.getActiveTriggers(state_3);
        EList<ActiveTrigger> atlist = _activeTriggers;
        _builder.newLineIfNotEmpty();
        {
          boolean _isEmpty = atlist.isEmpty();
          boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
          if (_operator_not) {
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("switch(trigger) {");
            _builder.newLine();
            {
              for(final ActiveTrigger at : atlist) {
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("case ");
                String _trigger = at.getTrigger();
                String _triggerCodeName_1 = xpac.getTriggerCodeName(_trigger);
                _builder.append(_triggerCodeName_1, "				");
                _builder.append(":");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("\t");
                boolean _hasGuard = this.roomExt.hasGuard(xpac, at);
                boolean needData = _hasGuard;
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("\t");
                {
                  if (needData) {
                    _builder.append("{ ");
                    Message _msg = at.getMsg();
                    String _typedDataDefinition = this._typeHelpers.getTypedDataDefinition(_msg);
                    _builder.append(_typedDataDefinition, "					");
                  }
                }
                _builder.newLineIfNotEmpty();
                {
                  EList<TriggeredTransition> _transitions = at.getTransitions();
                  boolean hasAnyElements_1 = false;
                  for(final TriggeredTransition tt : _transitions) {
                    if (!hasAnyElements_1) {
                      hasAnyElements_1 = true;
                    } else {
                      _builder.appendImmediate(" else ", "					");
                    }
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    TransitionChain _chain = xpac.getChain(tt);
                    TransitionChain chain = _chain;
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    Transition _transition = chain.getTransition();
                    String _trigger_1 = at.getTrigger();
                    StringConcatenation _guard = this.guard(_transition, _trigger_1, xpac);
                    _builder.append(_guard, "					");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("{");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("chain = ");
                    String _chainId_1 = this.roomExt.getChainId(chain);
                    _builder.append(_chainId_1, "						");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("catching_state = ");
                    String _contextId = this.roomExt.getContextId(chain);
                    _builder.append(_contextId, "						");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    {
                      boolean _isHandler = chain.isHandler();
                      if (_isHandler) {
                        _builder.append("is_handler = true;");
                      }
                    }
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    {
                      boolean _isSkipEntry = chain.isSkipEntry();
                      if (_isSkipEntry) {
                        _builder.append("skip_entry = true;");
                      }
                    }
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("\t");
                {
                  if (needData) {
                    _builder.append("}");
                  }
                }
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("break;");
                _builder.newLine();
              }
            }
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("break;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (chain != NOT_CAUGHT) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("exitTo(state, catching_state, is_handler);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int next = executeTransitionChain(chain, ifitem, generic_data);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("next = enterHistory(next, is_handler, skip_entry);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("setState(next);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("private void setState(int new_state) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (stateStrings[new_state]!=\"Idle\") {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// TODOTS: model switch for activation");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(getInstancePath() + \" -> \" + stateStrings[new_state]);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("this.state = new_state;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("public void executeInitTransition() {");
    _builder.newLine();
    _builder.append("\t");
    StateMachine _stateMachine_2 = xpac.getStateMachine();
    Transition _initTransition = this.roomExt.getInitTransition(_stateMachine_2);
    Transition initt = _initTransition;
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("int chain = ");
    TransitionChain _chain_1 = xpac.getChain(initt);
    String _chainId_2 = this.roomExt.getChainId(_chain_1);
    _builder.append(_chainId_2, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("int next = executeTransitionChain(chain, null, null);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("next = enterHistory(next, false, false);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("setState(next);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* calls exit codes while exiting from the current state to one of its");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* parent states while remembering the history");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param current - the current state");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param to - the final parent state");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("private void exitTo(int current, int to, boolean handler) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("while (current!=to) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (current) {");
    _builder.newLine();
    {
      StateMachine _stateMachine_3 = xpac.getStateMachine();
      List<State> _baseStateList_1 = this.roomExt.getBaseStateList(_stateMachine_3);
      for(final State state_4 : _baseStateList_1) {
        _builder.append("\t\t\t");
        _builder.append("case ");
        String _stateId_2 = this.roomExt.getStateId(state_4);
        _builder.append(_stateId_2, "			");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        {
          boolean _hasExitCode = this.roomExt.hasExitCode(state_4);
          if (_hasExitCode) {
            _builder.append("if (!handler) ");
            String _exitCodeOperationName = RoomNameProv.getExitCodeOperationName(state_4);
            _builder.append(_exitCodeOperationName, "				");
            _builder.append("();");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("history[");
        String _parentStateId = RoomNameProv.getParentStateId(state_4);
        _builder.append(_parentStateId, "				");
        _builder.append("] = ");
        String _stateId_3 = this.roomExt.getStateId(state_4);
        _builder.append(_stateId_3, "				");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("current = ");
        String _parentStateId_1 = RoomNameProv.getParentStateId(state_4);
        _builder.append(_parentStateId_1, "				");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("break;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* calls action, entry and exit codes along a transition chain. The generic data are cast to typed data");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* matching the trigger of this chain. The ID of the final state is returned");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param chain - the chain ID");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param generic_data - the generic data pointer");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @return the ID of the final state");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("private int executeTransitionChain(int chain, InterfaceItemBase ifitem, Object generic_data) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("switch (chain) {");
    _builder.newLine();
    _builder.append("\t\t");
    EList<TransitionChain> _transitionChains_1 = xpac.getTransitionChains();
    EList<TransitionChain> allchains = _transitionChains_1;
    _builder.newLineIfNotEmpty();
    {
      for(final TransitionChain tc_1 : allchains) {
        _builder.append("\t\t");
        _builder.append("case ");
        String _chainId_3 = this.roomExt.getChainId(tc_1);
        _builder.append(_chainId_3, "		");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        String _executeChainCode = this.stdExt.getExecuteChainCode(xpac, tc_1);
        _builder.append(_executeChainCode, "			");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return NO_STATE;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* calls entry codes while entering a state\'s history. The ID of the final leaf state is returned");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param state - the state which is entered");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param handler - entry code is executed if not handler");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @return - the ID of the final leaf state");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("private int enterHistory(int state, boolean handler, boolean skip_entry) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("while (true) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (state) {");
    _builder.newLine();
    {
      StateMachine _stateMachine_4 = xpac.getStateMachine();
      List<State> _baseStateList_2 = this.roomExt.getBaseStateList(_stateMachine_4);
      for(final State state_5 : _baseStateList_2) {
        _builder.append("\t\t\t");
        _builder.append("case ");
        String _stateId_4 = this.roomExt.getStateId(state_5);
        _builder.append(_stateId_4, "			");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        {
          boolean _hasEntryCode = this.roomExt.hasEntryCode(state_5);
          if (_hasEntryCode) {
            _builder.append("if (!(skip_entry || handler)) ");
            String _entryCodeOperationName = RoomNameProv.getEntryCodeOperationName(state_5);
            _builder.append(_entryCodeOperationName, "				");
            _builder.append("();");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          boolean _isLeaf = this.roomExt.isLeaf(state_5);
          if (_isLeaf) {
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("// in leaf state: return state id");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("return ");
            String _stateId_5 = this.roomExt.getStateId(state_5);
            _builder.append(_stateId_5, "				");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("// state has a sub graph");
            _builder.newLine();
            {
              StateGraph _subgraph = state_5.getSubgraph();
              boolean _hasInitTransition = this.roomExt.hasInitTransition(_subgraph);
              if (_hasInitTransition) {
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("// with init transition");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("if (history[");
                String _stateId_6 = this.roomExt.getStateId(state_5);
                _builder.append(_stateId_6, "				");
                _builder.append("]==NO_STATE) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("\t");
                StateGraph _subgraph_1 = state_5.getSubgraph();
                Transition _initTransition_1 = this.roomExt.getInitTransition(_subgraph_1);
                Transition sub_initt = _initTransition_1;
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("state = executeTransitionChain(");
                TransitionChain _chain_2 = xpac.getChain(sub_initt);
                String _chainId_4 = this.roomExt.getChainId(_chain_2);
                _builder.append(_chainId_4, "					");
                _builder.append(", null, null);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("else {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("state = history[");
                String _stateId_7 = this.roomExt.getStateId(state_5);
                _builder.append(_stateId_7, "					");
                _builder.append("];");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              } else {
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("// without init transition");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("state = history[");
                String _stateId_8 = this.roomExt.getStateId(state_5);
                _builder.append(_stateId_8, "				");
                _builder.append("];");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("break;");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.append("case STATE_TOP:");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("state = history[STATE_TOP];");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("skip_entry = false;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//*** Entry and Exit Codes");
    _builder.newLine();
    {
      StateMachine _stateMachine_5 = xpac.getStateMachine();
      List<State> _stateList = this.roomExt.getStateList(_stateMachine_5);
      for(final State state_6 : _stateList) {
        {
          boolean _isOwnObject = xpac.isOwnObject(state_6);
          if (_isOwnObject) {
            {
              boolean _hasEntryCode_1 = this.roomExt.hasEntryCode(state_6);
              if (_hasEntryCode_1) {
                _builder.append("protected void ");
                String _entryCodeOperationName_1 = RoomNameProv.getEntryCodeOperationName(state_6);
                _builder.append(_entryCodeOperationName_1, "");
                _builder.append("() {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                String _entryCode = this.roomExt.getEntryCode(xpac, state_6);
                _builder.append(_entryCode, "	");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
              }
            }
            {
              boolean _hasExitCode_1 = this.roomExt.hasExitCode(state_6);
              if (_hasExitCode_1) {
                _builder.append("protected void ");
                String _exitCodeOperationName_1 = RoomNameProv.getExitCodeOperationName(state_6);
                _builder.append(_exitCodeOperationName_1, "");
                _builder.append("() {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                String _exitCode = this.roomExt.getExitCode(xpac, state_6);
                _builder.append(_exitCode, "	");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("//*** Action Codes");
    _builder.newLine();
    {
      StateMachine _stateMachine_6 = xpac.getStateMachine();
      List<Transition> _transitionList = this.roomExt.getTransitionList(_stateMachine_6);
      for(final Transition tr : _transitionList) {
        {
          boolean _operator_and = false;
          boolean _isOwnObject_1 = xpac.isOwnObject(tr);
          if (!_isOwnObject_1) {
            _operator_and = false;
          } else {
            boolean _hasActionCode = this.roomExt.hasActionCode(tr);
            _operator_and = BooleanExtensions.operator_and(_isOwnObject_1, _hasActionCode);
          }
          if (_operator_and) {
            _builder.append("protected void ");
            String _actionCodeOperationName = RoomNameProv.getActionCodeOperationName(tr);
            _builder.append(_actionCodeOperationName, "");
            _builder.append("(");
            {
              if ((tr instanceof NonInitialTransition)) {
                _builder.append("InterfaceItemBase ifitem");
                String _argumentList = this.languageGen.getArgumentList(xpac, tr);
                _builder.append(_argumentList, "");
              }
            }
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            String _actionCode = this.roomExt.getActionCode(xpac, tr);
            _builder.append(_actionCode, "	");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t ");
    _builder.newLine();
    _builder.append("//******************************************");
    _builder.newLine();
    _builder.append("// END of generated code for FSM");
    _builder.newLine();
    _builder.append("//******************************************");
    _builder.newLine();
    return _builder;
  }
  
  protected StringConcatenation _guard(final TriggeredTransition tt, final String trigger, final ExpandedActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    EList<Trigger> _triggers = tt.getTriggers();
    final Function1<Trigger,Boolean> _function = new Function1<Trigger,Boolean>() {
        public Boolean apply(final Trigger e) {
          boolean _isMatching = ac.isMatching(e, trigger);
          return ((Boolean)_isMatching);
        }
      };
    Trigger _findFirst = IterableExtensions.<Trigger>findFirst(_triggers, _function);
    Trigger tr = _findFirst;
    _builder.newLineIfNotEmpty();
    {
      boolean _hasGuard = this.roomExt.hasGuard(tr);
      if (_hasGuard) {
        _builder.append("if (");
        Guard _guard = tr.getGuard();
        DetailCode _guard_1 = _guard.getGuard();
        String _code = ac.getCode(_guard_1);
        _builder.append(_code, "");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected StringConcatenation _guard(final Transition t, final String trigger, final ExpandedActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* error */");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation guard(final Transition tt, final String trigger, final ExpandedActorClass ac) {
    if (tt instanceof TriggeredTransition) {
      return _guard((TriggeredTransition)tt, trigger, ac);
    } else {
      return _guard(tt, trigger, ac);
    }
  }
}
