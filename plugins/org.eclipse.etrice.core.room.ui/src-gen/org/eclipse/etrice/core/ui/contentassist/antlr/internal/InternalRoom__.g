lexer grammar InternalRoom;
@header {
package org.eclipse.etrice.core.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'void' ;
T12 : 'int8' ;
T13 : 'int16' ;
T14 : 'int32' ;
T15 : 'uint8' ;
T16 : 'uint16' ;
T17 : 'uint32' ;
T18 : 'float32' ;
T19 : 'float64' ;
T20 : 'boolean' ;
T21 : 'string' ;
T22 : 'char' ;
T23 : 'RoomModel' ;
T24 : '{' ;
T25 : '}' ;
T26 : ':' ;
T27 : 'DataClass' ;
T28 : 'extends' ;
T29 : 'Attribute' ;
T30 : '[' ;
T31 : ']' ;
T32 : 'Operation' ;
T33 : '(' ;
T34 : ')' ;
T35 : ',' ;
T36 : 'ProtocolClass' ;
T37 : 'incoming' ;
T38 : 'outgoing' ;
T39 : 'usercode1' ;
T40 : 'usercode2' ;
T41 : 'regular' ;
T42 : 'PortClass' ;
T43 : 'conjugate' ;
T44 : 'Message' ;
T45 : 'usercode' ;
T46 : 'handle' ;
T47 : 'semantics' ;
T48 : 'in' ;
T49 : '->' ;
T50 : 'out' ;
T51 : 'ActorClass' ;
T52 : 'Interface' ;
T53 : 'Structure' ;
T54 : 'Behavior' ;
T55 : 'Port' ;
T56 : 'external' ;
T57 : 'SAP' ;
T58 : 'SPP' ;
T59 : 'ServiceImplementation' ;
T60 : 'of' ;
T61 : 'LogicalSystem' ;
T62 : 'SubSystemRef' ;
T63 : 'SubSystemClass' ;
T64 : 'LogicalThread' ;
T65 : '.' ;
T66 : 'Binding' ;
T67 : 'and' ;
T68 : 'LayerConnection' ;
T69 : 'satisfied_by' ;
T70 : 'ref' ;
T71 : 'relay_sap' ;
T72 : 'ActorRef' ;
T73 : 'StateMachine' ;
T74 : 'State' ;
T75 : 'entry' ;
T76 : 'exit' ;
T77 : 'subgraph' ;
T78 : 'RefinedState' ;
T79 : 'TransitionPoint' ;
T80 : 'EntryPoint' ;
T81 : 'ExitPoint' ;
T82 : 'ChoicePoint' ;
T83 : 'Transition' ;
T84 : 'initial' ;
T85 : 'action' ;
T86 : 'triggers' ;
T87 : 'or' ;
T88 : 'cond' ;
T89 : 'my' ;
T90 : 'cp' ;
T91 : '<' ;
T92 : '>' ;
T93 : '|' ;
T94 : 'guard' ;
T95 : 'import' ;
T96 : '*' ;
T97 : 'abstract' ;
T98 : 'conjugated' ;
T99 : 'handler' ;

// $ANTLR src "../org.eclipse.etrice.core.room.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalRoom.g" 17561
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.etrice.core.room.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalRoom.g" 17563
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.etrice.core.room.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalRoom.g" 17565
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.etrice.core.room.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalRoom.g" 17567
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.etrice.core.room.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalRoom.g" 17569
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.etrice.core.room.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalRoom.g" 17571
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.etrice.core.room.ui/src-gen/org/eclipse/etrice/core/ui/contentassist/antlr/internal/InternalRoom.g" 17573
RULE_ANY_OTHER : .;


