/*
* generated by Xtext
*/
package org.eclipse.etrice.core.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.eclipse.etrice.core.services.RoomGrammarAccess;

public class RoomParser extends AbstractContentAssistParser {
	
	@Inject
	private RoomGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.eclipse.etrice.core.ui.contentassist.antlr.internal.InternalRoomParser createParser() {
		org.eclipse.etrice.core.ui.contentassist.antlr.internal.InternalRoomParser result = new org.eclipse.etrice.core.ui.contentassist.antlr.internal.InternalRoomParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getRoomModelAccess().getAlternatives_5(), "rule__RoomModel__Alternatives_5");
					put(grammarAccess.getRoomClassAccess().getAlternatives(), "rule__RoomClass__Alternatives");
					put(grammarAccess.getStructureClassAccess().getAlternatives(), "rule__StructureClass__Alternatives");
					put(grammarAccess.getActorContainerClassAccess().getAlternatives(), "rule__ActorContainerClass__Alternatives");
					put(grammarAccess.getTypeAccess().getAlternatives(), "rule__Type__Alternatives");
					put(grammarAccess.getFreeTypeAccess().getAlternatives(), "rule__FreeType__Alternatives");
					put(grammarAccess.getPortClassAccess().getAlternatives_2(), "rule__PortClass__Alternatives_2");
					put(grammarAccess.getSemanticsRuleAccess().getAlternatives(), "rule__SemanticsRule__Alternatives");
					put(grammarAccess.getActorClassAccess().getAlternatives_7_5(), "rule__ActorClass__Alternatives_7_5");
					put(grammarAccess.getInterfaceItemAccess().getAlternatives(), "rule__InterfaceItem__Alternatives");
					put(grammarAccess.getActorContainerRefAccess().getAlternatives(), "rule__ActorContainerRef__Alternatives");
					put(grammarAccess.getSAPointAccess().getAlternatives(), "rule__SAPoint__Alternatives");
					put(grammarAccess.getStateGraphNodeAccess().getAlternatives(), "rule__StateGraphNode__Alternatives");
					put(grammarAccess.getStateGraphItemAccess().getAlternatives(), "rule__StateGraphItem__Alternatives");
					put(grammarAccess.getStateAccess().getAlternatives(), "rule__State__Alternatives");
					put(grammarAccess.getStateGraphAccess().getAlternatives_1(), "rule__StateGraph__Alternatives_1");
					put(grammarAccess.getStateMachineAccess().getAlternatives_2(), "rule__StateMachine__Alternatives_2");
					put(grammarAccess.getTrPointAccess().getAlternatives(), "rule__TrPoint__Alternatives");
					put(grammarAccess.getTransitionAccess().getAlternatives(), "rule__Transition__Alternatives");
					put(grammarAccess.getNonInitialTransitionAccess().getAlternatives(), "rule__NonInitialTransition__Alternatives");
					put(grammarAccess.getTransitionTerminalAccess().getAlternatives(), "rule__TransitionTerminal__Alternatives");
					put(grammarAccess.getPrimitiveTypeAccess().getAlternatives(), "rule__PrimitiveType__Alternatives");
					put(grammarAccess.getRoomModelAccess().getGroup(), "rule__RoomModel__Group__0");
					put(grammarAccess.getTypedIDAccess().getGroup(), "rule__TypedID__Group__0");
					put(grammarAccess.getFreeTypedIDAccess().getGroup(), "rule__FreeTypedID__Group__0");
					put(grammarAccess.getDataClassAccess().getGroup(), "rule__DataClass__Group__0");
					put(grammarAccess.getDataClassAccess().getGroup_3(), "rule__DataClass__Group_3__0");
					put(grammarAccess.getAttributeAccess().getGroup(), "rule__Attribute__Group__0");
					put(grammarAccess.getAttributeAccess().getGroup_2(), "rule__Attribute__Group_2__0");
					put(grammarAccess.getOperationAccess().getGroup(), "rule__Operation__Group__0");
					put(grammarAccess.getOperationAccess().getGroup_3(), "rule__Operation__Group_3__0");
					put(grammarAccess.getOperationAccess().getGroup_3_1(), "rule__Operation__Group_3_1__0");
					put(grammarAccess.getOperationAccess().getGroup_5(), "rule__Operation__Group_5__0");
					put(grammarAccess.getProtocolClassAccess().getGroup(), "rule__ProtocolClass__Group__0");
					put(grammarAccess.getProtocolClassAccess().getGroup_3(), "rule__ProtocolClass__Group_3__0");
					put(grammarAccess.getProtocolClassAccess().getGroup_5(), "rule__ProtocolClass__Group_5__0");
					put(grammarAccess.getProtocolClassAccess().getGroup_6(), "rule__ProtocolClass__Group_6__0");
					put(grammarAccess.getProtocolClassAccess().getGroup_15(), "rule__ProtocolClass__Group_15__0");
					put(grammarAccess.getProtocolClassAccess().getGroup_16(), "rule__ProtocolClass__Group_16__0");
					put(grammarAccess.getMessageAccess().getGroup(), "rule__Message__Group__0");
					put(grammarAccess.getMessageAccess().getGroup_3(), "rule__Message__Group_3__0");
					put(grammarAccess.getMessageAccess().getGroup_3_1(), "rule__Message__Group_3_1__0");
					put(grammarAccess.getPortClassAccess().getGroup(), "rule__PortClass__Group__0");
					put(grammarAccess.getPortClassAccess().getGroup_1(), "rule__PortClass__Group_1__0");
					put(grammarAccess.getMessageHandlerAccess().getGroup(), "rule__MessageHandler__Group__0");
					put(grammarAccess.getProtocolSemanticsAccess().getGroup(), "rule__ProtocolSemantics__Group__0");
					put(grammarAccess.getSemanticsInRuleAccess().getGroup(), "rule__SemanticsInRule__Group__0");
					put(grammarAccess.getSemanticsOutRuleAccess().getGroup(), "rule__SemanticsOutRule__Group__0");
					put(grammarAccess.getActorClassAccess().getGroup(), "rule__ActorClass__Group__0");
					put(grammarAccess.getActorClassAccess().getGroup_4(), "rule__ActorClass__Group_4__0");
					put(grammarAccess.getActorClassAccess().getGroup_6(), "rule__ActorClass__Group_6__0");
					put(grammarAccess.getActorClassAccess().getGroup_7(), "rule__ActorClass__Group_7__0");
					put(grammarAccess.getActorClassAccess().getGroup_7_3(), "rule__ActorClass__Group_7_3__0");
					put(grammarAccess.getActorClassAccess().getGroup_7_4(), "rule__ActorClass__Group_7_4__0");
					put(grammarAccess.getActorClassAccess().getGroup_8(), "rule__ActorClass__Group_8__0");
					put(grammarAccess.getPortAccess().getGroup(), "rule__Port__Group__0");
					put(grammarAccess.getPortAccess().getGroup_3(), "rule__Port__Group_3__0");
					put(grammarAccess.getExternalPortAccess().getGroup(), "rule__ExternalPort__Group__0");
					put(grammarAccess.getSAPRefAccess().getGroup(), "rule__SAPRef__Group__0");
					put(grammarAccess.getSPPRefAccess().getGroup(), "rule__SPPRef__Group__0");
					put(grammarAccess.getServiceImplementationAccess().getGroup(), "rule__ServiceImplementation__Group__0");
					put(grammarAccess.getLogicalSystemAccess().getGroup(), "rule__LogicalSystem__Group__0");
					put(grammarAccess.getSubSystemRefAccess().getGroup(), "rule__SubSystemRef__Group__0");
					put(grammarAccess.getSubSystemClassAccess().getGroup(), "rule__SubSystemClass__Group__0");
					put(grammarAccess.getLogicalThreadAccess().getGroup(), "rule__LogicalThread__Group__0");
					put(grammarAccess.getLogicalThreadAccess().getGroup_4(), "rule__LogicalThread__Group_4__0");
					put(grammarAccess.getActorInstancePathAccess().getGroup(), "rule__ActorInstancePath__Group__0");
					put(grammarAccess.getActorInstancePathAccess().getGroup_1(), "rule__ActorInstancePath__Group_1__0");
					put(grammarAccess.getBindingAccess().getGroup(), "rule__Binding__Group__0");
					put(grammarAccess.getBindingEndPointAccess().getGroup(), "rule__BindingEndPoint__Group__0");
					put(grammarAccess.getBindingEndPointAccess().getGroup_0(), "rule__BindingEndPoint__Group_0__0");
					put(grammarAccess.getLayerConnectionAccess().getGroup(), "rule__LayerConnection__Group__0");
					put(grammarAccess.getRefSAPointAccess().getGroup(), "rule__RefSAPoint__Group__0");
					put(grammarAccess.getRelaySAPointAccess().getGroup(), "rule__RelaySAPoint__Group__0");
					put(grammarAccess.getSPPointAccess().getGroup(), "rule__SPPoint__Group__0");
					put(grammarAccess.getActorRefAccess().getGroup(), "rule__ActorRef__Group__0");
					put(grammarAccess.getStateGraphAccess().getGroup(), "rule__StateGraph__Group__0");
					put(grammarAccess.getStateMachineAccess().getGroup(), "rule__StateMachine__Group__0");
					put(grammarAccess.getBaseStateAccess().getGroup(), "rule__BaseState__Group__0");
					put(grammarAccess.getBaseStateAccess().getGroup_3(), "rule__BaseState__Group_3__0");
					put(grammarAccess.getBaseStateAccess().getGroup_3_1(), "rule__BaseState__Group_3_1__0");
					put(grammarAccess.getBaseStateAccess().getGroup_3_2(), "rule__BaseState__Group_3_2__0");
					put(grammarAccess.getBaseStateAccess().getGroup_3_3(), "rule__BaseState__Group_3_3__0");
					put(grammarAccess.getRefinedStateAccess().getGroup(), "rule__RefinedState__Group__0");
					put(grammarAccess.getRefinedStateAccess().getGroup_4(), "rule__RefinedState__Group_4__0");
					put(grammarAccess.getRefinedStateAccess().getGroup_5(), "rule__RefinedState__Group_5__0");
					put(grammarAccess.getRefinedStateAccess().getGroup_6(), "rule__RefinedState__Group_6__0");
					put(grammarAccess.getDetailCodeAccess().getGroup(), "rule__DetailCode__Group__0");
					put(grammarAccess.getTransitionPointAccess().getGroup(), "rule__TransitionPoint__Group__0");
					put(grammarAccess.getEntryPointAccess().getGroup(), "rule__EntryPoint__Group__0");
					put(grammarAccess.getExitPointAccess().getGroup(), "rule__ExitPoint__Group__0");
					put(grammarAccess.getChoicePointAccess().getGroup(), "rule__ChoicePoint__Group__0");
					put(grammarAccess.getInitialTransitionAccess().getGroup(), "rule__InitialTransition__Group__0");
					put(grammarAccess.getInitialTransitionAccess().getGroup_8(), "rule__InitialTransition__Group_8__0");
					put(grammarAccess.getContinuationTransitionAccess().getGroup(), "rule__ContinuationTransition__Group__0");
					put(grammarAccess.getContinuationTransitionAccess().getGroup_7(), "rule__ContinuationTransition__Group_7__0");
					put(grammarAccess.getContinuationTransitionAccess().getGroup_7_1(), "rule__ContinuationTransition__Group_7_1__0");
					put(grammarAccess.getTriggeredTransitionAccess().getGroup(), "rule__TriggeredTransition__Group__0");
					put(grammarAccess.getTriggeredTransitionAccess().getGroup_11(), "rule__TriggeredTransition__Group_11__0");
					put(grammarAccess.getTriggeredTransitionAccess().getGroup_13(), "rule__TriggeredTransition__Group_13__0");
					put(grammarAccess.getCPBranchTransitionAccess().getGroup(), "rule__CPBranchTransition__Group__0");
					put(grammarAccess.getCPBranchTransitionAccess().getGroup_10(), "rule__CPBranchTransition__Group_10__0");
					put(grammarAccess.getTrPointTerminalAccess().getGroup(), "rule__TrPointTerminal__Group__0");
					put(grammarAccess.getSubStateTrPointTerminalAccess().getGroup(), "rule__SubStateTrPointTerminal__Group__0");
					put(grammarAccess.getChoicepointTerminalAccess().getGroup(), "rule__ChoicepointTerminal__Group__0");
					put(grammarAccess.getTriggerAccess().getGroup(), "rule__Trigger__Group__0");
					put(grammarAccess.getTriggerAccess().getGroup_2(), "rule__Trigger__Group_2__0");
					put(grammarAccess.getMessageFromIfAccess().getGroup(), "rule__MessageFromIf__Group__0");
					put(grammarAccess.getGuardAccess().getGroup(), "rule__Guard__Group__0");
					put(grammarAccess.getDocumentationAccess().getGroup(), "rule__Documentation__Group__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getImportedFQNAccess().getGroup(), "rule__ImportedFQN__Group__0");
					put(grammarAccess.getImportedFQNAccess().getGroup_1(), "rule__ImportedFQN__Group_1__0");
					put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
					put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
					put(grammarAccess.getRoomModelAccess().getNameAssignment_1(), "rule__RoomModel__NameAssignment_1");
					put(grammarAccess.getRoomModelAccess().getDocuAssignment_2(), "rule__RoomModel__DocuAssignment_2");
					put(grammarAccess.getRoomModelAccess().getImportsAssignment_4(), "rule__RoomModel__ImportsAssignment_4");
					put(grammarAccess.getRoomModelAccess().getDataClassesAssignment_5_0(), "rule__RoomModel__DataClassesAssignment_5_0");
					put(grammarAccess.getRoomModelAccess().getProtocolClassesAssignment_5_1(), "rule__RoomModel__ProtocolClassesAssignment_5_1");
					put(grammarAccess.getRoomModelAccess().getActorClassesAssignment_5_2(), "rule__RoomModel__ActorClassesAssignment_5_2");
					put(grammarAccess.getRoomModelAccess().getSubSystemClassesAssignment_5_3(), "rule__RoomModel__SubSystemClassesAssignment_5_3");
					put(grammarAccess.getRoomModelAccess().getSystemsAssignment_5_4(), "rule__RoomModel__SystemsAssignment_5_4");
					put(grammarAccess.getTypedIDAccess().getNameAssignment_0(), "rule__TypedID__NameAssignment_0");
					put(grammarAccess.getTypedIDAccess().getTypeAssignment_2(), "rule__TypedID__TypeAssignment_2");
					put(grammarAccess.getFreeTypedIDAccess().getNameAssignment_0(), "rule__FreeTypedID__NameAssignment_0");
					put(grammarAccess.getFreeTypedIDAccess().getTypeAssignment_2(), "rule__FreeTypedID__TypeAssignment_2");
					put(grammarAccess.getTypeAccess().getPrimAssignment_0(), "rule__Type__PrimAssignment_0");
					put(grammarAccess.getTypeAccess().getTypeAssignment_1(), "rule__Type__TypeAssignment_1");
					put(grammarAccess.getFreeTypeAccess().getPrimAssignment_0(), "rule__FreeType__PrimAssignment_0");
					put(grammarAccess.getFreeTypeAccess().getTypeAssignment_1(), "rule__FreeType__TypeAssignment_1");
					put(grammarAccess.getDataClassAccess().getNameAssignment_1(), "rule__DataClass__NameAssignment_1");
					put(grammarAccess.getDataClassAccess().getDocuAssignment_2(), "rule__DataClass__DocuAssignment_2");
					put(grammarAccess.getDataClassAccess().getBaseAssignment_3_1(), "rule__DataClass__BaseAssignment_3_1");
					put(grammarAccess.getDataClassAccess().getImportsAssignment_5(), "rule__DataClass__ImportsAssignment_5");
					put(grammarAccess.getDataClassAccess().getAttributesAssignment_6(), "rule__DataClass__AttributesAssignment_6");
					put(grammarAccess.getDataClassAccess().getOperationsAssignment_7(), "rule__DataClass__OperationsAssignment_7");
					put(grammarAccess.getAttributeAccess().getNameAssignment_1(), "rule__Attribute__NameAssignment_1");
					put(grammarAccess.getAttributeAccess().getSizeAssignment_2_1(), "rule__Attribute__SizeAssignment_2_1");
					put(grammarAccess.getAttributeAccess().getTypeAssignment_4(), "rule__Attribute__TypeAssignment_4");
					put(grammarAccess.getAttributeAccess().getDocuAssignment_5(), "rule__Attribute__DocuAssignment_5");
					put(grammarAccess.getOperationAccess().getNameAssignment_1(), "rule__Operation__NameAssignment_1");
					put(grammarAccess.getOperationAccess().getArgumentsAssignment_3_0(), "rule__Operation__ArgumentsAssignment_3_0");
					put(grammarAccess.getOperationAccess().getArgumentsAssignment_3_1_1(), "rule__Operation__ArgumentsAssignment_3_1_1");
					put(grammarAccess.getOperationAccess().getReturntypeAssignment_5_1(), "rule__Operation__ReturntypeAssignment_5_1");
					put(grammarAccess.getOperationAccess().getDocuAssignment_6(), "rule__Operation__DocuAssignment_6");
					put(grammarAccess.getOperationAccess().getDetailCodeAssignment_7(), "rule__Operation__DetailCodeAssignment_7");
					put(grammarAccess.getProtocolClassAccess().getNameAssignment_1(), "rule__ProtocolClass__NameAssignment_1");
					put(grammarAccess.getProtocolClassAccess().getDocuAssignment_2(), "rule__ProtocolClass__DocuAssignment_2");
					put(grammarAccess.getProtocolClassAccess().getBaseAssignment_3_1(), "rule__ProtocolClass__BaseAssignment_3_1");
					put(grammarAccess.getProtocolClassAccess().getUserCode1Assignment_5_1(), "rule__ProtocolClass__UserCode1Assignment_5_1");
					put(grammarAccess.getProtocolClassAccess().getUserCode2Assignment_6_1(), "rule__ProtocolClass__UserCode2Assignment_6_1");
					put(grammarAccess.getProtocolClassAccess().getIncomingMessagesAssignment_9(), "rule__ProtocolClass__IncomingMessagesAssignment_9");
					put(grammarAccess.getProtocolClassAccess().getOutgoingMessagesAssignment_13(), "rule__ProtocolClass__OutgoingMessagesAssignment_13");
					put(grammarAccess.getProtocolClassAccess().getRegularAssignment_15_2(), "rule__ProtocolClass__RegularAssignment_15_2");
					put(grammarAccess.getProtocolClassAccess().getConjugateAssignment_16_2(), "rule__ProtocolClass__ConjugateAssignment_16_2");
					put(grammarAccess.getProtocolClassAccess().getSemanticsAssignment_17(), "rule__ProtocolClass__SemanticsAssignment_17");
					put(grammarAccess.getMessageAccess().getNameAssignment_1(), "rule__Message__NameAssignment_1");
					put(grammarAccess.getMessageAccess().getArgumentsAssignment_3_0(), "rule__Message__ArgumentsAssignment_3_0");
					put(grammarAccess.getMessageAccess().getArgumentsAssignment_3_1_1(), "rule__Message__ArgumentsAssignment_3_1_1");
					put(grammarAccess.getMessageAccess().getDocuAssignment_5(), "rule__Message__DocuAssignment_5");
					put(grammarAccess.getPortClassAccess().getUserCodeAssignment_1_1(), "rule__PortClass__UserCodeAssignment_1_1");
					put(grammarAccess.getPortClassAccess().getAttributesAssignment_2_0(), "rule__PortClass__AttributesAssignment_2_0");
					put(grammarAccess.getPortClassAccess().getOperationsAssignment_2_1(), "rule__PortClass__OperationsAssignment_2_1");
					put(grammarAccess.getPortClassAccess().getMsgHandlersAssignment_2_2(), "rule__PortClass__MsgHandlersAssignment_2_2");
					put(grammarAccess.getMessageHandlerAccess().getMsgAssignment_1(), "rule__MessageHandler__MsgAssignment_1");
					put(grammarAccess.getMessageHandlerAccess().getDetailCodeAssignment_2(), "rule__MessageHandler__DetailCodeAssignment_2");
					put(grammarAccess.getProtocolSemanticsAccess().getRulesAssignment_2(), "rule__ProtocolSemantics__RulesAssignment_2");
					put(grammarAccess.getSemanticsInRuleAccess().getMsgAssignment_1(), "rule__SemanticsInRule__MsgAssignment_1");
					put(grammarAccess.getSemanticsInRuleAccess().getFollowUpsAssignment_4(), "rule__SemanticsInRule__FollowUpsAssignment_4");
					put(grammarAccess.getSemanticsOutRuleAccess().getMsgAssignment_1(), "rule__SemanticsOutRule__MsgAssignment_1");
					put(grammarAccess.getSemanticsOutRuleAccess().getFollowUpsAssignment_4(), "rule__SemanticsOutRule__FollowUpsAssignment_4");
					put(grammarAccess.getActorClassAccess().getAbstractAssignment_0(), "rule__ActorClass__AbstractAssignment_0");
					put(grammarAccess.getActorClassAccess().getNameAssignment_2(), "rule__ActorClass__NameAssignment_2");
					put(grammarAccess.getActorClassAccess().getDocuAssignment_3(), "rule__ActorClass__DocuAssignment_3");
					put(grammarAccess.getActorClassAccess().getBaseAssignment_4_1(), "rule__ActorClass__BaseAssignment_4_1");
					put(grammarAccess.getActorClassAccess().getIfPortsAssignment_6_2(), "rule__ActorClass__IfPortsAssignment_6_2");
					put(grammarAccess.getActorClassAccess().getIfSPPsAssignment_6_3(), "rule__ActorClass__IfSPPsAssignment_6_3");
					put(grammarAccess.getActorClassAccess().getStructureDocuAssignment_7_1(), "rule__ActorClass__StructureDocuAssignment_7_1");
					put(grammarAccess.getActorClassAccess().getUserCode1Assignment_7_3_1(), "rule__ActorClass__UserCode1Assignment_7_3_1");
					put(grammarAccess.getActorClassAccess().getUserCode2Assignment_7_4_1(), "rule__ActorClass__UserCode2Assignment_7_4_1");
					put(grammarAccess.getActorClassAccess().getIntPortsAssignment_7_5_0(), "rule__ActorClass__IntPortsAssignment_7_5_0");
					put(grammarAccess.getActorClassAccess().getExtPortsAssignment_7_5_1(), "rule__ActorClass__ExtPortsAssignment_7_5_1");
					put(grammarAccess.getActorClassAccess().getServiceImplementationsAssignment_7_6(), "rule__ActorClass__ServiceImplementationsAssignment_7_6");
					put(grammarAccess.getActorClassAccess().getStrSAPsAssignment_7_7(), "rule__ActorClass__StrSAPsAssignment_7_7");
					put(grammarAccess.getActorClassAccess().getAttributesAssignment_7_8(), "rule__ActorClass__AttributesAssignment_7_8");
					put(grammarAccess.getActorClassAccess().getActorRefsAssignment_7_9(), "rule__ActorClass__ActorRefsAssignment_7_9");
					put(grammarAccess.getActorClassAccess().getBindingsAssignment_7_10(), "rule__ActorClass__BindingsAssignment_7_10");
					put(grammarAccess.getActorClassAccess().getConnectionsAssignment_7_11(), "rule__ActorClass__ConnectionsAssignment_7_11");
					put(grammarAccess.getActorClassAccess().getBehaviorDocuAssignment_8_1(), "rule__ActorClass__BehaviorDocuAssignment_8_1");
					put(grammarAccess.getActorClassAccess().getOperationsAssignment_8_3(), "rule__ActorClass__OperationsAssignment_8_3");
					put(grammarAccess.getActorClassAccess().getStateMachineAssignment_8_4(), "rule__ActorClass__StateMachineAssignment_8_4");
					put(grammarAccess.getPortAccess().getConjugatedAssignment_0(), "rule__Port__ConjugatedAssignment_0");
					put(grammarAccess.getPortAccess().getNameAssignment_2(), "rule__Port__NameAssignment_2");
					put(grammarAccess.getPortAccess().getMultiplicityAssignment_3_1(), "rule__Port__MultiplicityAssignment_3_1");
					put(grammarAccess.getPortAccess().getProtocolAssignment_5(), "rule__Port__ProtocolAssignment_5");
					put(grammarAccess.getPortAccess().getDocuAssignment_6(), "rule__Port__DocuAssignment_6");
					put(grammarAccess.getExternalPortAccess().getIfportAssignment_2(), "rule__ExternalPort__IfportAssignment_2");
					put(grammarAccess.getSAPRefAccess().getNameAssignment_1(), "rule__SAPRef__NameAssignment_1");
					put(grammarAccess.getSAPRefAccess().getProtocolAssignment_3(), "rule__SAPRef__ProtocolAssignment_3");
					put(grammarAccess.getSPPRefAccess().getNameAssignment_1(), "rule__SPPRef__NameAssignment_1");
					put(grammarAccess.getSPPRefAccess().getProtocolAssignment_3(), "rule__SPPRef__ProtocolAssignment_3");
					put(grammarAccess.getServiceImplementationAccess().getSppAssignment_2(), "rule__ServiceImplementation__SppAssignment_2");
					put(grammarAccess.getLogicalSystemAccess().getNameAssignment_1(), "rule__LogicalSystem__NameAssignment_1");
					put(grammarAccess.getLogicalSystemAccess().getDocuAssignment_2(), "rule__LogicalSystem__DocuAssignment_2");
					put(grammarAccess.getLogicalSystemAccess().getSubSystemsAssignment_4(), "rule__LogicalSystem__SubSystemsAssignment_4");
					put(grammarAccess.getLogicalSystemAccess().getBindingsAssignment_5(), "rule__LogicalSystem__BindingsAssignment_5");
					put(grammarAccess.getLogicalSystemAccess().getConnectionsAssignment_6(), "rule__LogicalSystem__ConnectionsAssignment_6");
					put(grammarAccess.getSubSystemRefAccess().getNameAssignment_1(), "rule__SubSystemRef__NameAssignment_1");
					put(grammarAccess.getSubSystemRefAccess().getTypeAssignment_3(), "rule__SubSystemRef__TypeAssignment_3");
					put(grammarAccess.getSubSystemRefAccess().getDocuAssignment_4(), "rule__SubSystemRef__DocuAssignment_4");
					put(grammarAccess.getSubSystemClassAccess().getNameAssignment_1(), "rule__SubSystemClass__NameAssignment_1");
					put(grammarAccess.getSubSystemClassAccess().getDocuAssignment_2(), "rule__SubSystemClass__DocuAssignment_2");
					put(grammarAccess.getSubSystemClassAccess().getRelayPortsAssignment_4(), "rule__SubSystemClass__RelayPortsAssignment_4");
					put(grammarAccess.getSubSystemClassAccess().getIfSPPsAssignment_5(), "rule__SubSystemClass__IfSPPsAssignment_5");
					put(grammarAccess.getSubSystemClassAccess().getActorRefsAssignment_6(), "rule__SubSystemClass__ActorRefsAssignment_6");
					put(grammarAccess.getSubSystemClassAccess().getBindingsAssignment_7(), "rule__SubSystemClass__BindingsAssignment_7");
					put(grammarAccess.getSubSystemClassAccess().getConnectionsAssignment_8(), "rule__SubSystemClass__ConnectionsAssignment_8");
					put(grammarAccess.getSubSystemClassAccess().getThreadsAssignment_9(), "rule__SubSystemClass__ThreadsAssignment_9");
					put(grammarAccess.getLogicalThreadAccess().getNameAssignment_1(), "rule__LogicalThread__NameAssignment_1");
					put(grammarAccess.getLogicalThreadAccess().getInstancesAssignment_3(), "rule__LogicalThread__InstancesAssignment_3");
					put(grammarAccess.getLogicalThreadAccess().getInstancesAssignment_4_1(), "rule__LogicalThread__InstancesAssignment_4_1");
					put(grammarAccess.getActorInstancePathAccess().getSegmentsAssignment_0(), "rule__ActorInstancePath__SegmentsAssignment_0");
					put(grammarAccess.getActorInstancePathAccess().getSegmentsAssignment_1_1(), "rule__ActorInstancePath__SegmentsAssignment_1_1");
					put(grammarAccess.getBindingAccess().getEndpoint1Assignment_1(), "rule__Binding__Endpoint1Assignment_1");
					put(grammarAccess.getBindingAccess().getEndpoint2Assignment_3(), "rule__Binding__Endpoint2Assignment_3");
					put(grammarAccess.getBindingEndPointAccess().getActorRefAssignment_0_0(), "rule__BindingEndPoint__ActorRefAssignment_0_0");
					put(grammarAccess.getBindingEndPointAccess().getPortAssignment_1(), "rule__BindingEndPoint__PortAssignment_1");
					put(grammarAccess.getLayerConnectionAccess().getFromAssignment_1(), "rule__LayerConnection__FromAssignment_1");
					put(grammarAccess.getLayerConnectionAccess().getToAssignment_3(), "rule__LayerConnection__ToAssignment_3");
					put(grammarAccess.getRefSAPointAccess().getRefAssignment_1(), "rule__RefSAPoint__RefAssignment_1");
					put(grammarAccess.getRelaySAPointAccess().getRelayAssignment_1(), "rule__RelaySAPoint__RelayAssignment_1");
					put(grammarAccess.getSPPointAccess().getRefAssignment_0(), "rule__SPPoint__RefAssignment_0");
					put(grammarAccess.getSPPointAccess().getServiceAssignment_2(), "rule__SPPoint__ServiceAssignment_2");
					put(grammarAccess.getActorRefAccess().getNameAssignment_1(), "rule__ActorRef__NameAssignment_1");
					put(grammarAccess.getActorRefAccess().getTypeAssignment_3(), "rule__ActorRef__TypeAssignment_3");
					put(grammarAccess.getActorRefAccess().getDocuAssignment_4(), "rule__ActorRef__DocuAssignment_4");
					put(grammarAccess.getStateGraphAccess().getStatesAssignment_1_0(), "rule__StateGraph__StatesAssignment_1_0");
					put(grammarAccess.getStateGraphAccess().getTrPointsAssignment_1_1(), "rule__StateGraph__TrPointsAssignment_1_1");
					put(grammarAccess.getStateGraphAccess().getChPointsAssignment_1_2(), "rule__StateGraph__ChPointsAssignment_1_2");
					put(grammarAccess.getStateGraphAccess().getTransitionsAssignment_1_3(), "rule__StateGraph__TransitionsAssignment_1_3");
					put(grammarAccess.getStateMachineAccess().getStatesAssignment_2_0(), "rule__StateMachine__StatesAssignment_2_0");
					put(grammarAccess.getStateMachineAccess().getTrPointsAssignment_2_1(), "rule__StateMachine__TrPointsAssignment_2_1");
					put(grammarAccess.getStateMachineAccess().getChPointsAssignment_2_2(), "rule__StateMachine__ChPointsAssignment_2_2");
					put(grammarAccess.getStateMachineAccess().getTransitionsAssignment_2_3(), "rule__StateMachine__TransitionsAssignment_2_3");
					put(grammarAccess.getBaseStateAccess().getNameAssignment_1(), "rule__BaseState__NameAssignment_1");
					put(grammarAccess.getBaseStateAccess().getDocuAssignment_2(), "rule__BaseState__DocuAssignment_2");
					put(grammarAccess.getBaseStateAccess().getEntryCodeAssignment_3_1_1(), "rule__BaseState__EntryCodeAssignment_3_1_1");
					put(grammarAccess.getBaseStateAccess().getExitCodeAssignment_3_2_1(), "rule__BaseState__ExitCodeAssignment_3_2_1");
					put(grammarAccess.getBaseStateAccess().getSubgraphAssignment_3_3_1(), "rule__BaseState__SubgraphAssignment_3_3_1");
					put(grammarAccess.getRefinedStateAccess().getBaseAssignment_1(), "rule__RefinedState__BaseAssignment_1");
					put(grammarAccess.getRefinedStateAccess().getDocuAssignment_2(), "rule__RefinedState__DocuAssignment_2");
					put(grammarAccess.getRefinedStateAccess().getEntryCodeAssignment_4_1(), "rule__RefinedState__EntryCodeAssignment_4_1");
					put(grammarAccess.getRefinedStateAccess().getExitCodeAssignment_5_1(), "rule__RefinedState__ExitCodeAssignment_5_1");
					put(grammarAccess.getRefinedStateAccess().getSubgraphAssignment_6_1(), "rule__RefinedState__SubgraphAssignment_6_1");
					put(grammarAccess.getDetailCodeAccess().getCommandsAssignment_1(), "rule__DetailCode__CommandsAssignment_1");
					put(grammarAccess.getTransitionPointAccess().getHandlerAssignment_0(), "rule__TransitionPoint__HandlerAssignment_0");
					put(grammarAccess.getTransitionPointAccess().getNameAssignment_2(), "rule__TransitionPoint__NameAssignment_2");
					put(grammarAccess.getEntryPointAccess().getNameAssignment_1(), "rule__EntryPoint__NameAssignment_1");
					put(grammarAccess.getExitPointAccess().getNameAssignment_1(), "rule__ExitPoint__NameAssignment_1");
					put(grammarAccess.getChoicePointAccess().getNameAssignment_1(), "rule__ChoicePoint__NameAssignment_1");
					put(grammarAccess.getChoicePointAccess().getDocuAssignment_2(), "rule__ChoicePoint__DocuAssignment_2");
					put(grammarAccess.getInitialTransitionAccess().getNameAssignment_1(), "rule__InitialTransition__NameAssignment_1");
					put(grammarAccess.getInitialTransitionAccess().getToAssignment_5(), "rule__InitialTransition__ToAssignment_5");
					put(grammarAccess.getInitialTransitionAccess().getDocuAssignment_6(), "rule__InitialTransition__DocuAssignment_6");
					put(grammarAccess.getInitialTransitionAccess().getActionAssignment_8_1(), "rule__InitialTransition__ActionAssignment_8_1");
					put(grammarAccess.getContinuationTransitionAccess().getNameAssignment_1(), "rule__ContinuationTransition__NameAssignment_1");
					put(grammarAccess.getContinuationTransitionAccess().getFromAssignment_3(), "rule__ContinuationTransition__FromAssignment_3");
					put(grammarAccess.getContinuationTransitionAccess().getToAssignment_5(), "rule__ContinuationTransition__ToAssignment_5");
					put(grammarAccess.getContinuationTransitionAccess().getDocuAssignment_6(), "rule__ContinuationTransition__DocuAssignment_6");
					put(grammarAccess.getContinuationTransitionAccess().getActionAssignment_7_1_1(), "rule__ContinuationTransition__ActionAssignment_7_1_1");
					put(grammarAccess.getTriggeredTransitionAccess().getNameAssignment_1(), "rule__TriggeredTransition__NameAssignment_1");
					put(grammarAccess.getTriggeredTransitionAccess().getFromAssignment_3(), "rule__TriggeredTransition__FromAssignment_3");
					put(grammarAccess.getTriggeredTransitionAccess().getToAssignment_5(), "rule__TriggeredTransition__ToAssignment_5");
					put(grammarAccess.getTriggeredTransitionAccess().getDocuAssignment_6(), "rule__TriggeredTransition__DocuAssignment_6");
					put(grammarAccess.getTriggeredTransitionAccess().getTriggersAssignment_10(), "rule__TriggeredTransition__TriggersAssignment_10");
					put(grammarAccess.getTriggeredTransitionAccess().getTriggersAssignment_11_1(), "rule__TriggeredTransition__TriggersAssignment_11_1");
					put(grammarAccess.getTriggeredTransitionAccess().getActionAssignment_13_1(), "rule__TriggeredTransition__ActionAssignment_13_1");
					put(grammarAccess.getCPBranchTransitionAccess().getNameAssignment_1(), "rule__CPBranchTransition__NameAssignment_1");
					put(grammarAccess.getCPBranchTransitionAccess().getFromAssignment_3(), "rule__CPBranchTransition__FromAssignment_3");
					put(grammarAccess.getCPBranchTransitionAccess().getToAssignment_5(), "rule__CPBranchTransition__ToAssignment_5");
					put(grammarAccess.getCPBranchTransitionAccess().getDocuAssignment_6(), "rule__CPBranchTransition__DocuAssignment_6");
					put(grammarAccess.getCPBranchTransitionAccess().getConditionAssignment_9(), "rule__CPBranchTransition__ConditionAssignment_9");
					put(grammarAccess.getCPBranchTransitionAccess().getActionAssignment_10_1(), "rule__CPBranchTransition__ActionAssignment_10_1");
					put(grammarAccess.getStateTerminalAccess().getStateAssignment(), "rule__StateTerminal__StateAssignment");
					put(grammarAccess.getTrPointTerminalAccess().getTrPointAssignment_1(), "rule__TrPointTerminal__TrPointAssignment_1");
					put(grammarAccess.getSubStateTrPointTerminalAccess().getTrPointAssignment_0(), "rule__SubStateTrPointTerminal__TrPointAssignment_0");
					put(grammarAccess.getSubStateTrPointTerminalAccess().getStateAssignment_2(), "rule__SubStateTrPointTerminal__StateAssignment_2");
					put(grammarAccess.getChoicepointTerminalAccess().getCpAssignment_1(), "rule__ChoicepointTerminal__CpAssignment_1");
					put(grammarAccess.getTriggerAccess().getMsgFromIfPairsAssignment_1(), "rule__Trigger__MsgFromIfPairsAssignment_1");
					put(grammarAccess.getTriggerAccess().getMsgFromIfPairsAssignment_2_1(), "rule__Trigger__MsgFromIfPairsAssignment_2_1");
					put(grammarAccess.getTriggerAccess().getGuardAssignment_3(), "rule__Trigger__GuardAssignment_3");
					put(grammarAccess.getMessageFromIfAccess().getMessageAssignment_0(), "rule__MessageFromIf__MessageAssignment_0");
					put(grammarAccess.getMessageFromIfAccess().getFromAssignment_2(), "rule__MessageFromIf__FromAssignment_2");
					put(grammarAccess.getGuardAccess().getGuardAssignment_1(), "rule__Guard__GuardAssignment_1");
					put(grammarAccess.getDocumentationAccess().getTextAssignment_1(), "rule__Documentation__TextAssignment_1");
					put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1(), "rule__Import__ImportedNamespaceAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipse.etrice.core.ui.contentassist.antlr.internal.InternalRoomParser typedParser = (org.eclipse.etrice.core.ui.contentassist.antlr.internal.InternalRoomParser) parser;
			typedParser.entryRuleRoomModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public RoomGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(RoomGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
