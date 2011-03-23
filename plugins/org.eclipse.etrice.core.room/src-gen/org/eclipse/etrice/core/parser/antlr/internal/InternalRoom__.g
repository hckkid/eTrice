lexer grammar InternalRoom;
@header {
package org.eclipse.etrice.core.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'RoomModel' ;
T12 : '{' ;
T13 : '}' ;
T14 : ':' ;
T15 : 'DataClass' ;
T16 : 'extends' ;
T17 : 'Attribute' ;
T18 : '[' ;
T19 : ']' ;
T20 : 'Operation' ;
T21 : '(' ;
T22 : ',' ;
T23 : ')' ;
T24 : 'ProtocolClass' ;
T25 : 'usercode1' ;
T26 : 'usercode2' ;
T27 : 'incoming' ;
T28 : 'outgoing' ;
T29 : 'regular' ;
T30 : 'PortClass' ;
T31 : 'conjugate' ;
T32 : 'Message' ;
T33 : 'usercode' ;
T34 : 'handle' ;
T35 : 'semantics' ;
T36 : 'in' ;
T37 : '->' ;
T38 : 'out' ;
T39 : 'abstract' ;
T40 : 'ActorClass' ;
T41 : 'Interface' ;
T42 : 'Structure' ;
T43 : 'Behavior' ;
T44 : 'conjugated' ;
T45 : 'Port' ;
T46 : 'external' ;
T47 : 'SAP' ;
T48 : 'SPP' ;
T49 : 'ServiceImplementation' ;
T50 : 'of' ;
T51 : 'LogicalSystem' ;
T52 : 'SubSystemRef' ;
T53 : 'SubSystemClass' ;
T54 : 'LogicalThread' ;
T55 : '.' ;
T56 : 'Binding' ;
T57 : 'and' ;
T58 : 'LayerConnection' ;
T59 : 'satisfied_by' ;
T60 : 'ref' ;
T61 : 'relay_sap' ;
T62 : 'ActorRef' ;
T63 : 'StateMachine' ;
T64 : 'State' ;
T65 : 'entry' ;
T66 : 'exit' ;
T67 : 'subgraph' ;
T68 : 'RefinedState' ;
T69 : 'handler' ;
T70 : 'TransitionPoint' ;
T71 : 'EntryPoint' ;
T72 : 'ExitPoint' ;
T73 : 'ChoicePoint' ;
T74 : 'Transition' ;
T75 : 'initial' ;
T76 : 'action' ;
T77 : 'triggers' ;
T78 : 'or' ;
T79 : 'cond' ;
T80 : 'my' ;
T81 : 'cp' ;
T82 : '<' ;
T83 : '|' ;
T84 : '>' ;
T85 : 'guard' ;
T86 : 'import' ;
T87 : '*' ;
T88 : 'void' ;
T89 : 'int8' ;
T90 : 'int16' ;
T91 : 'int32' ;
T92 : 'uint8' ;
T93 : 'uint16' ;
T94 : 'uint32' ;
T95 : 'float32' ;
T96 : 'float64' ;
T97 : 'boolean' ;
T98 : 'string' ;
T99 : 'char' ;

// $ANTLR src "../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g" 6828
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g" 6830
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g" 6832
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g" 6834
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g" 6836
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g" 6838
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g" 6840
RULE_ANY_OTHER : .;


