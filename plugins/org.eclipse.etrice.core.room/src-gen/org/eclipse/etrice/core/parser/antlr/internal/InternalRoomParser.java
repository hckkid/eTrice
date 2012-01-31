package org.eclipse.etrice.core.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.etrice.core.services.RoomGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRoomParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MULTIPLICITY", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'RoomModel'", "'{'", "'}'", "':'", "'ref'", "'PrimitiveType'", "'->'", "'('", "')'", "'default'", "'ExternalType'", "'DataClass'", "'extends'", "'usercode1'", "'usercode2'", "'usercode3'", "'Attribute'", "'['", "']'", "'='", "'Operation'", "','", "'void'", "'sends'", "'ProtocolClass'", "'incoming'", "'outgoing'", "'regular'", "'PortClass'", "'conjugate'", "'private'", "'Message'", "'usercode'", "'handle'", "'semantics'", "'abstract'", "'ActorClass'", "'Interface'", "'Structure'", "'Behavior'", "'conjugated'", "'Port'", "'external'", "'SAP'", "'SPP'", "'ServiceImplementation'", "'of'", "'LogicalSystem'", "'SubSystemRef'", "'SubSystemClass'", "'LogicalThread'", "'prio'", "'.'", "'Binding'", "'and'", "'LayerConnection'", "'satisfied_by'", "'relay_sap'", "'ActorRef'", "'data_driven'", "'StateMachine'", "'State'", "'entry'", "'exit'", "'do'", "'subgraph'", "'RefinedState'", "'handler'", "'TransitionPoint'", "'EntryPoint'", "'ExitPoint'", "'ChoicePoint'", "'Transition'", "'initial'", "'action'", "'triggers'", "'or'", "'guard'", "'cond'", "'my'", "'cp'", "'<'", "'|'", "'>'", "'@'", "'import'", "'from'", "'model'", "'*'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_MULTIPLICITY=7;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_STRING=5;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalRoomParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRoomParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRoomParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g"; }



     	private RoomGrammarAccess grammarAccess;
     	
        public InternalRoomParser(TokenStream input, RoomGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RoomModel";	
       	}
       	
       	@Override
       	protected RoomGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRoomModel"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:67:1: entryRuleRoomModel returns [EObject current=null] : iv_ruleRoomModel= ruleRoomModel EOF ;
    public final EObject entryRuleRoomModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoomModel = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:68:2: (iv_ruleRoomModel= ruleRoomModel EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:69:2: iv_ruleRoomModel= ruleRoomModel EOF
            {
             newCompositeNode(grammarAccess.getRoomModelRule()); 
            pushFollow(FOLLOW_ruleRoomModel_in_entryRuleRoomModel75);
            iv_ruleRoomModel=ruleRoomModel();

            state._fsp--;

             current =iv_ruleRoomModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoomModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoomModel"


    // $ANTLR start "ruleRoomModel"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:76:1: ruleRoomModel returns [EObject current=null] : (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}' ) ;
    public final EObject ruleRoomModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_docu_2_0 = null;

        EObject lv_imports_4_0 = null;

        EObject lv_primitiveTypes_5_0 = null;

        EObject lv_externalTypes_6_0 = null;

        EObject lv_dataClasses_7_0 = null;

        EObject lv_protocolClasses_8_0 = null;

        EObject lv_actorClasses_9_0 = null;

        EObject lv_subSystemClasses_10_0 = null;

        EObject lv_systems_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:79:28: ( (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:80:1: (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:80:1: (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:80:3: otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleRoomModel122); 

                	newLeafNode(otherlv_0, grammarAccess.getRoomModelAccess().getRoomModelKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:84:1: ( (lv_name_1_0= ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:85:1: (lv_name_1_0= ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:85:1: (lv_name_1_0= ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:86:3: lv_name_1_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getRoomModelAccess().getNameFQNParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRoomModel143);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:102:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==29) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:103:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:103:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:104:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRoomModelAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleRoomModel164);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_2_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleRoomModel177); 

                	newLeafNode(otherlv_3, grammarAccess.getRoomModelAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:124:1: ( (lv_imports_4_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==97) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:125:1: (lv_imports_4_0= ruleImport )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:125:1: (lv_imports_4_0= ruleImport )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:126:3: lv_imports_4_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getImportsImportParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleRoomModel198);
            	    lv_imports_4_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_4_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:142:3: ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )*
            loop3:
            do {
                int alt3=8;
                switch ( input.LA(1) ) {
                case 17:
                    {
                    alt3=1;
                    }
                    break;
                case 22:
                    {
                    alt3=2;
                    }
                    break;
                case 23:
                    {
                    alt3=3;
                    }
                    break;
                case 36:
                    {
                    alt3=4;
                    }
                    break;
                case 47:
                case 48:
                    {
                    alt3=5;
                    }
                    break;
                case 61:
                    {
                    alt3=6;
                    }
                    break;
                case 59:
                    {
                    alt3=7;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:142:4: ( (lv_primitiveTypes_5_0= rulePrimitiveType ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:142:4: ( (lv_primitiveTypes_5_0= rulePrimitiveType ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:143:1: (lv_primitiveTypes_5_0= rulePrimitiveType )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:143:1: (lv_primitiveTypes_5_0= rulePrimitiveType )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:144:3: lv_primitiveTypes_5_0= rulePrimitiveType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getPrimitiveTypesPrimitiveTypeParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePrimitiveType_in_ruleRoomModel221);
            	    lv_primitiveTypes_5_0=rulePrimitiveType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"primitiveTypes",
            	            		lv_primitiveTypes_5_0, 
            	            		"PrimitiveType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:161:6: ( (lv_externalTypes_6_0= ruleExternalType ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:161:6: ( (lv_externalTypes_6_0= ruleExternalType ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:162:1: (lv_externalTypes_6_0= ruleExternalType )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:162:1: (lv_externalTypes_6_0= ruleExternalType )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:163:3: lv_externalTypes_6_0= ruleExternalType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getExternalTypesExternalTypeParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalType_in_ruleRoomModel248);
            	    lv_externalTypes_6_0=ruleExternalType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"externalTypes",
            	            		lv_externalTypes_6_0, 
            	            		"ExternalType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:180:6: ( (lv_dataClasses_7_0= ruleDataClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:180:6: ( (lv_dataClasses_7_0= ruleDataClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:181:1: (lv_dataClasses_7_0= ruleDataClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:181:1: (lv_dataClasses_7_0= ruleDataClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:182:3: lv_dataClasses_7_0= ruleDataClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getDataClassesDataClassParserRuleCall_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDataClass_in_ruleRoomModel275);
            	    lv_dataClasses_7_0=ruleDataClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"dataClasses",
            	            		lv_dataClasses_7_0, 
            	            		"DataClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:199:6: ( (lv_protocolClasses_8_0= ruleProtocolClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:199:6: ( (lv_protocolClasses_8_0= ruleProtocolClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:200:1: (lv_protocolClasses_8_0= ruleProtocolClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:200:1: (lv_protocolClasses_8_0= ruleProtocolClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:201:3: lv_protocolClasses_8_0= ruleProtocolClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getProtocolClassesProtocolClassParserRuleCall_5_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleProtocolClass_in_ruleRoomModel302);
            	    lv_protocolClasses_8_0=ruleProtocolClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"protocolClasses",
            	            		lv_protocolClasses_8_0, 
            	            		"ProtocolClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:218:6: ( (lv_actorClasses_9_0= ruleActorClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:218:6: ( (lv_actorClasses_9_0= ruleActorClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:219:1: (lv_actorClasses_9_0= ruleActorClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:219:1: (lv_actorClasses_9_0= ruleActorClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:220:3: lv_actorClasses_9_0= ruleActorClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getActorClassesActorClassParserRuleCall_5_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorClass_in_ruleRoomModel329);
            	    lv_actorClasses_9_0=ruleActorClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"actorClasses",
            	            		lv_actorClasses_9_0, 
            	            		"ActorClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:237:6: ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:237:6: ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:238:1: (lv_subSystemClasses_10_0= ruleSubSystemClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:238:1: (lv_subSystemClasses_10_0= ruleSubSystemClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:239:3: lv_subSystemClasses_10_0= ruleSubSystemClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getSubSystemClassesSubSystemClassParserRuleCall_5_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubSystemClass_in_ruleRoomModel356);
            	    lv_subSystemClasses_10_0=ruleSubSystemClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subSystemClasses",
            	            		lv_subSystemClasses_10_0, 
            	            		"SubSystemClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:256:6: ( (lv_systems_11_0= ruleLogicalSystem ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:256:6: ( (lv_systems_11_0= ruleLogicalSystem ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:257:1: (lv_systems_11_0= ruleLogicalSystem )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:257:1: (lv_systems_11_0= ruleLogicalSystem )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:258:3: lv_systems_11_0= ruleLogicalSystem
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getSystemsLogicalSystemParserRuleCall_5_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLogicalSystem_in_ruleRoomModel383);
            	    lv_systems_11_0=ruleLogicalSystem();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"systems",
            	            		lv_systems_11_0, 
            	            		"LogicalSystem");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleRoomModel397); 

                	newLeafNode(otherlv_12, grammarAccess.getRoomModelAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRoomModel"


    // $ANTLR start "entryRuleStructureClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:288:1: entryRuleStructureClass returns [EObject current=null] : iv_ruleStructureClass= ruleStructureClass EOF ;
    public final EObject entryRuleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructureClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:289:2: (iv_ruleStructureClass= ruleStructureClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:290:2: iv_ruleStructureClass= ruleStructureClass EOF
            {
             newCompositeNode(grammarAccess.getStructureClassRule()); 
            pushFollow(FOLLOW_ruleStructureClass_in_entryRuleStructureClass435);
            iv_ruleStructureClass=ruleStructureClass();

            state._fsp--;

             current =iv_ruleStructureClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStructureClass445); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructureClass"


    // $ANTLR start "ruleStructureClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:297:1: ruleStructureClass returns [EObject current=null] : (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) ;
    public final EObject ruleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorContainerClass_0 = null;

        EObject this_LogicalSystem_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:300:28: ( (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:301:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:301:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=47 && LA4_0<=48)||LA4_0==61) ) {
                alt4=1;
            }
            else if ( (LA4_0==59) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:302:5: this_ActorContainerClass_0= ruleActorContainerClass
                    {
                     
                            newCompositeNode(grammarAccess.getStructureClassAccess().getActorContainerClassParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleActorContainerClass_in_ruleStructureClass492);
                    this_ActorContainerClass_0=ruleActorContainerClass();

                    state._fsp--;

                     
                            current = this_ActorContainerClass_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:312:5: this_LogicalSystem_1= ruleLogicalSystem
                    {
                     
                            newCompositeNode(grammarAccess.getStructureClassAccess().getLogicalSystemParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleLogicalSystem_in_ruleStructureClass519);
                    this_LogicalSystem_1=ruleLogicalSystem();

                    state._fsp--;

                     
                            current = this_LogicalSystem_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStructureClass"


    // $ANTLR start "entryRuleActorContainerClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:328:1: entryRuleActorContainerClass returns [EObject current=null] : iv_ruleActorContainerClass= ruleActorContainerClass EOF ;
    public final EObject entryRuleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorContainerClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:329:2: (iv_ruleActorContainerClass= ruleActorContainerClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:330:2: iv_ruleActorContainerClass= ruleActorContainerClass EOF
            {
             newCompositeNode(grammarAccess.getActorContainerClassRule()); 
            pushFollow(FOLLOW_ruleActorContainerClass_in_entryRuleActorContainerClass554);
            iv_ruleActorContainerClass=ruleActorContainerClass();

            state._fsp--;

             current =iv_ruleActorContainerClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorContainerClass564); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActorContainerClass"


    // $ANTLR start "ruleActorContainerClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:337:1: ruleActorContainerClass returns [EObject current=null] : (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) ;
    public final EObject ruleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorClass_0 = null;

        EObject this_SubSystemClass_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:340:28: ( (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:341:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:341:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=47 && LA5_0<=48)) ) {
                alt5=1;
            }
            else if ( (LA5_0==61) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:342:5: this_ActorClass_0= ruleActorClass
                    {
                     
                            newCompositeNode(grammarAccess.getActorContainerClassAccess().getActorClassParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleActorClass_in_ruleActorContainerClass611);
                    this_ActorClass_0=ruleActorClass();

                    state._fsp--;

                     
                            current = this_ActorClass_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:352:5: this_SubSystemClass_1= ruleSubSystemClass
                    {
                     
                            newCompositeNode(grammarAccess.getActorContainerClassAccess().getSubSystemClassParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSubSystemClass_in_ruleActorContainerClass638);
                    this_SubSystemClass_1=ruleSubSystemClass();

                    state._fsp--;

                     
                            current = this_SubSystemClass_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActorContainerClass"


    // $ANTLR start "entryRuleVarDecl"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:368:1: entryRuleVarDecl returns [EObject current=null] : iv_ruleVarDecl= ruleVarDecl EOF ;
    public final EObject entryRuleVarDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDecl = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:369:2: (iv_ruleVarDecl= ruleVarDecl EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:370:2: iv_ruleVarDecl= ruleVarDecl EOF
            {
             newCompositeNode(grammarAccess.getVarDeclRule()); 
            pushFollow(FOLLOW_ruleVarDecl_in_entryRuleVarDecl673);
            iv_ruleVarDecl=ruleVarDecl();

            state._fsp--;

             current =iv_ruleVarDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarDecl683); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDecl"


    // $ANTLR start "ruleVarDecl"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:377:1: ruleVarDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ) ;
    public final EObject ruleVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_refType_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:380:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:381:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:381:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:381:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:381:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:382:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:382:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:383:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarDecl725); 

            			newLeafNode(lv_name_0_0, grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVarDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleVarDecl742); 

                	newLeafNode(otherlv_1, grammarAccess.getVarDeclAccess().getColonKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:403:1: ( (lv_refType_2_0= ruleRefableType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:404:1: (lv_refType_2_0= ruleRefableType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:404:1: (lv_refType_2_0= ruleRefableType )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:405:3: lv_refType_2_0= ruleRefableType
            {
             
            	        newCompositeNode(grammarAccess.getVarDeclAccess().getRefTypeRefableTypeParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleRefableType_in_ruleVarDecl763);
            lv_refType_2_0=ruleRefableType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVarDeclRule());
            	        }
                   		set(
                   			current, 
                   			"refType",
                    		lv_refType_2_0, 
                    		"RefableType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarDecl"


    // $ANTLR start "entryRuleRefableType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:429:1: entryRuleRefableType returns [EObject current=null] : iv_ruleRefableType= ruleRefableType EOF ;
    public final EObject entryRuleRefableType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefableType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:430:2: (iv_ruleRefableType= ruleRefableType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:431:2: iv_ruleRefableType= ruleRefableType EOF
            {
             newCompositeNode(grammarAccess.getRefableTypeRule()); 
            pushFollow(FOLLOW_ruleRefableType_in_entryRuleRefableType799);
            iv_ruleRefableType=ruleRefableType();

            state._fsp--;

             current =iv_ruleRefableType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefableType809); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefableType"


    // $ANTLR start "ruleRefableType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:438:1: ruleRefableType returns [EObject current=null] : ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? ) ;
    public final EObject ruleRefableType() throws RecognitionException {
        EObject current = null;

        Token lv_ref_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:441:28: ( ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:442:1: ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:442:1: ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:442:2: ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )?
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:442:2: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:443:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:443:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:444:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefableTypeRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRefableTypeAccess().getTypeDataTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRefableType857);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:457:2: ( (lv_ref_1_0= 'ref' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:458:1: (lv_ref_1_0= 'ref' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:458:1: (lv_ref_1_0= 'ref' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:459:3: lv_ref_1_0= 'ref'
                    {
                    lv_ref_1_0=(Token)match(input,16,FOLLOW_16_in_ruleRefableType875); 

                            newLeafNode(lv_ref_1_0, grammarAccess.getRefableTypeAccess().getRefRefKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRefableTypeRule());
                    	        }
                           		setWithLastConsumed(current, "ref", true, "ref");
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefableType"


    // $ANTLR start "entryRuleDataType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:480:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:481:2: (iv_ruleDataType= ruleDataType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:482:2: iv_ruleDataType= ruleDataType EOF
            {
             newCompositeNode(grammarAccess.getDataTypeRule()); 
            pushFollow(FOLLOW_ruleDataType_in_entryRuleDataType925);
            iv_ruleDataType=ruleDataType();

            state._fsp--;

             current =iv_ruleDataType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataType935); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:489:1: ruleDataType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_ComplexType_1= ruleComplexType ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_ComplexType_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:492:28: ( (this_PrimitiveType_0= rulePrimitiveType | this_ComplexType_1= ruleComplexType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:493:1: (this_PrimitiveType_0= rulePrimitiveType | this_ComplexType_1= ruleComplexType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:493:1: (this_PrimitiveType_0= rulePrimitiveType | this_ComplexType_1= ruleComplexType )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=22 && LA7_0<=23)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:494:5: this_PrimitiveType_0= rulePrimitiveType
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeAccess().getPrimitiveTypeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePrimitiveType_in_ruleDataType982);
                    this_PrimitiveType_0=rulePrimitiveType();

                    state._fsp--;

                     
                            current = this_PrimitiveType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:504:5: this_ComplexType_1= ruleComplexType
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeAccess().getComplexTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleComplexType_in_ruleDataType1009);
                    this_ComplexType_1=ruleComplexType();

                    state._fsp--;

                     
                            current = this_ComplexType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleComplexType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:520:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:521:2: (iv_ruleComplexType= ruleComplexType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:522:2: iv_ruleComplexType= ruleComplexType EOF
            {
             newCompositeNode(grammarAccess.getComplexTypeRule()); 
            pushFollow(FOLLOW_ruleComplexType_in_entryRuleComplexType1044);
            iv_ruleComplexType=ruleComplexType();

            state._fsp--;

             current =iv_ruleComplexType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexType1054); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComplexType"


    // $ANTLR start "ruleComplexType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:529:1: ruleComplexType returns [EObject current=null] : (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataClass_0 = null;

        EObject this_ExternalType_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:532:28: ( (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:533:1: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:533:1: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            else if ( (LA8_0==22) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:534:5: this_DataClass_0= ruleDataClass
                    {
                     
                            newCompositeNode(grammarAccess.getComplexTypeAccess().getDataClassParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDataClass_in_ruleComplexType1101);
                    this_DataClass_0=ruleDataClass();

                    state._fsp--;

                     
                            current = this_DataClass_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:544:5: this_ExternalType_1= ruleExternalType
                    {
                     
                            newCompositeNode(grammarAccess.getComplexTypeAccess().getExternalTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleExternalType_in_ruleComplexType1128);
                    this_ExternalType_1=ruleExternalType();

                    state._fsp--;

                     
                            current = this_ExternalType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComplexType"


    // $ANTLR start "entryRulePrimitiveType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:560:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:561:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:562:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType1163);
            iv_rulePrimitiveType=rulePrimitiveType();

            state._fsp--;

             current =iv_rulePrimitiveType; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveType1173); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:569:1: rulePrimitiveType returns [EObject current=null] : (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) (otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')' )? otherlv_7= 'default' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) ( (lv_docu_9_0= ruleDocumentation ) )? ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_defaultValueLiteral_8_0=null;
        AntlrDatatypeRuleToken lv_targetName_3_0 = null;

        AntlrDatatypeRuleToken lv_castName_5_0 = null;

        EObject lv_docu_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:572:28: ( (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) (otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')' )? otherlv_7= 'default' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) ( (lv_docu_9_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:573:1: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) (otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')' )? otherlv_7= 'default' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) ( (lv_docu_9_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:573:1: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) (otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')' )? otherlv_7= 'default' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) ( (lv_docu_9_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:573:3: otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) (otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')' )? otherlv_7= 'default' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) ( (lv_docu_9_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_rulePrimitiveType1210); 

                	newLeafNode(otherlv_0, grammarAccess.getPrimitiveTypeAccess().getPrimitiveTypeKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:577:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:578:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:578:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:579:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePrimitiveType1227); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPrimitiveTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPrimitiveTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_rulePrimitiveType1244); 

                	newLeafNode(otherlv_2, grammarAccess.getPrimitiveTypeAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:599:1: ( (lv_targetName_3_0= ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:600:1: (lv_targetName_3_0= ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:600:1: (lv_targetName_3_0= ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:601:3: lv_targetName_3_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getTargetNameFQNParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_rulePrimitiveType1265);
            lv_targetName_3_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
            	        }
                   		set(
                   			current, 
                   			"targetName",
                    		lv_targetName_3_0, 
                    		"FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:617:2: (otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:617:4: otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')'
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_19_in_rulePrimitiveType1278); 

                        	newLeafNode(otherlv_4, grammarAccess.getPrimitiveTypeAccess().getLeftParenthesisKeyword_4_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:621:1: ( (lv_castName_5_0= ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:622:1: (lv_castName_5_0= ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:622:1: (lv_castName_5_0= ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:623:3: lv_castName_5_0= ruleFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getCastNameFQNParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_rulePrimitiveType1299);
                    lv_castName_5_0=ruleFQN();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"castName",
                            		lv_castName_5_0, 
                            		"FQN");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,20,FOLLOW_20_in_rulePrimitiveType1311); 

                        	newLeafNode(otherlv_6, grammarAccess.getPrimitiveTypeAccess().getRightParenthesisKeyword_4_2());
                        

                    }
                    break;

            }

            otherlv_7=(Token)match(input,21,FOLLOW_21_in_rulePrimitiveType1325); 

                	newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDefaultKeyword_5());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:647:1: ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:648:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:648:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:649:3: lv_defaultValueLiteral_8_0= RULE_STRING
            {
            lv_defaultValueLiteral_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePrimitiveType1342); 

            			newLeafNode(lv_defaultValueLiteral_8_0, grammarAccess.getPrimitiveTypeAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_6_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPrimitiveTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"defaultValueLiteral",
                    		lv_defaultValueLiteral_8_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:665:2: ( (lv_docu_9_0= ruleDocumentation ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==29) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:666:1: (lv_docu_9_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:666:1: (lv_docu_9_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:667:3: lv_docu_9_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getDocuDocumentationParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_rulePrimitiveType1368);
                    lv_docu_9_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_9_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleExternalType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:691:1: entryRuleExternalType returns [EObject current=null] : iv_ruleExternalType= ruleExternalType EOF ;
    public final EObject entryRuleExternalType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:692:2: (iv_ruleExternalType= ruleExternalType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:693:2: iv_ruleExternalType= ruleExternalType EOF
            {
             newCompositeNode(grammarAccess.getExternalTypeRule()); 
            pushFollow(FOLLOW_ruleExternalType_in_entryRuleExternalType1405);
            iv_ruleExternalType=ruleExternalType();

            state._fsp--;

             current =iv_ruleExternalType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalType1415); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalType"


    // $ANTLR start "ruleExternalType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:700:1: ruleExternalType returns [EObject current=null] : (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleExternalType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_targetName_3_0 = null;

        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:703:28: ( (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:704:1: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:704:1: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:704:3: otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleExternalType1452); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalTypeAccess().getExternalTypeKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:708:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:709:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:709:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:710:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalType1469); 

            			newLeafNode(lv_name_1_0, grammarAccess.getExternalTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExternalTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleExternalType1486); 

                	newLeafNode(otherlv_2, grammarAccess.getExternalTypeAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:730:1: ( (lv_targetName_3_0= ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:731:1: (lv_targetName_3_0= ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:731:1: (lv_targetName_3_0= ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:732:3: lv_targetName_3_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getExternalTypeAccess().getTargetNameFQNParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleExternalType1507);
            lv_targetName_3_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExternalTypeRule());
            	        }
                   		set(
                   			current, 
                   			"targetName",
                    		lv_targetName_3_0, 
                    		"FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:748:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==29) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:749:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:749:1: (lv_docu_4_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:750:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalTypeAccess().getDocuDocumentationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleExternalType1528);
                    lv_docu_4_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExternalTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_4_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalType"


    // $ANTLR start "entryRuleDataClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:774:1: entryRuleDataClass returns [EObject current=null] : iv_ruleDataClass= ruleDataClass EOF ;
    public final EObject entryRuleDataClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:775:2: (iv_ruleDataClass= ruleDataClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:776:2: iv_ruleDataClass= ruleDataClass EOF
            {
             newCompositeNode(grammarAccess.getDataClassRule()); 
            pushFollow(FOLLOW_ruleDataClass_in_entryRuleDataClass1565);
            iv_ruleDataClass=ruleDataClass();

            state._fsp--;

             current =iv_ruleDataClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataClass1575); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataClass"


    // $ANTLR start "ruleDataClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:783:1: ruleDataClass returns [EObject current=null] : (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? ( (lv_attributes_12_0= ruleAttribute ) )+ ( (lv_operations_13_0= ruleStandardOperation ) )* otherlv_14= '}' ) ;
    public final EObject ruleDataClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_14=null;
        EObject lv_docu_2_0 = null;

        EObject lv_userCode1_7_0 = null;

        EObject lv_userCode2_9_0 = null;

        EObject lv_userCode3_11_0 = null;

        EObject lv_attributes_12_0 = null;

        EObject lv_operations_13_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:786:28: ( (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? ( (lv_attributes_12_0= ruleAttribute ) )+ ( (lv_operations_13_0= ruleStandardOperation ) )* otherlv_14= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:787:1: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? ( (lv_attributes_12_0= ruleAttribute ) )+ ( (lv_operations_13_0= ruleStandardOperation ) )* otherlv_14= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:787:1: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? ( (lv_attributes_12_0= ruleAttribute ) )+ ( (lv_operations_13_0= ruleStandardOperation ) )* otherlv_14= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:787:3: otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? ( (lv_attributes_12_0= ruleAttribute ) )+ ( (lv_operations_13_0= ruleStandardOperation ) )* otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleDataClass1612); 

                	newLeafNode(otherlv_0, grammarAccess.getDataClassAccess().getDataClassKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:791:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:792:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:792:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:793:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataClass1629); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDataClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDataClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:809:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==29) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:810:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:810:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:811:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleDataClass1655);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_2_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:827:3: (otherlv_3= 'extends' ( ( ruleFQN ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:827:5: otherlv_3= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleDataClass1669); 

                        	newLeafNode(otherlv_3, grammarAccess.getDataClassAccess().getExtendsKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:831:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:832:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:832:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:833:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataClassRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getBaseDataClassCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleDataClass1692);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleDataClass1706); 

                	newLeafNode(otherlv_5, grammarAccess.getDataClassAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:850:1: (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:850:3: otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) )
                    {
                    otherlv_6=(Token)match(input,25,FOLLOW_25_in_ruleDataClass1719); 

                        	newLeafNode(otherlv_6, grammarAccess.getDataClassAccess().getUsercode1Keyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:854:1: ( (lv_userCode1_7_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:855:1: (lv_userCode1_7_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:855:1: (lv_userCode1_7_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:856:3: lv_userCode1_7_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode1DetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleDataClass1740);
                    lv_userCode1_7_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode1",
                            		lv_userCode1_7_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:872:4: (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==26) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:872:6: otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleDataClass1755); 

                        	newLeafNode(otherlv_8, grammarAccess.getDataClassAccess().getUsercode2Keyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:876:1: ( (lv_userCode2_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:877:1: (lv_userCode2_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:877:1: (lv_userCode2_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:878:3: lv_userCode2_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode2DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleDataClass1776);
                    lv_userCode2_9_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode2",
                            		lv_userCode2_9_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:894:4: (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:894:6: otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,27,FOLLOW_27_in_ruleDataClass1791); 

                        	newLeafNode(otherlv_10, grammarAccess.getDataClassAccess().getUsercode3Keyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:898:1: ( (lv_userCode3_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:899:1: (lv_userCode3_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:899:1: (lv_userCode3_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:900:3: lv_userCode3_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode3DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleDataClass1812);
                    lv_userCode3_11_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode3",
                            		lv_userCode3_11_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:916:4: ( (lv_attributes_12_0= ruleAttribute ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==28) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:917:1: (lv_attributes_12_0= ruleAttribute )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:917:1: (lv_attributes_12_0= ruleAttribute )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:918:3: lv_attributes_12_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getAttributesAttributeParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttribute_in_ruleDataClass1835);
            	    lv_attributes_12_0=ruleAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_12_0, 
            	            		"Attribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:934:3: ( (lv_operations_13_0= ruleStandardOperation ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==32) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:935:1: (lv_operations_13_0= ruleStandardOperation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:935:1: (lv_operations_13_0= ruleStandardOperation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:936:3: lv_operations_13_0= ruleStandardOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getOperationsStandardOperationParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStandardOperation_in_ruleDataClass1857);
            	    lv_operations_13_0=ruleStandardOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"operations",
            	            		lv_operations_13_0, 
            	            		"StandardOperation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_14=(Token)match(input,14,FOLLOW_14_in_ruleDataClass1870); 

                	newLeafNode(otherlv_14, grammarAccess.getDataClassAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataClass"


    // $ANTLR start "entryRuleAttribute"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:964:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:965:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:966:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute1906);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute1916); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:973:1: ruleAttribute returns [EObject current=null] : (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_refType_6_0= ruleRefableType ) ) (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_size_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_defaultValueLiteral_8_0=null;
        EObject lv_refType_6_0 = null;

        EObject lv_docu_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:976:28: ( (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_refType_6_0= ruleRefableType ) ) (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:977:1: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_refType_6_0= ruleRefableType ) ) (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:977:1: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_refType_6_0= ruleRefableType ) ) (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:977:3: otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_refType_6_0= ruleRefableType ) ) (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleAttribute1953); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttributeKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:981:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:982:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:982:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:983:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute1970); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:999:2: (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==29) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:999:4: otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleAttribute1988); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1003:1: ( (lv_size_3_0= RULE_INT ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1004:1: (lv_size_3_0= RULE_INT )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1004:1: (lv_size_3_0= RULE_INT )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1005:3: lv_size_3_0= RULE_INT
                    {
                    lv_size_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAttribute2005); 

                    			newLeafNode(lv_size_3_0, grammarAccess.getAttributeAccess().getSizeINTTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"size",
                            		lv_size_3_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleAttribute2022); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleAttribute2036); 

                	newLeafNode(otherlv_5, grammarAccess.getAttributeAccess().getColonKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1029:1: ( (lv_refType_6_0= ruleRefableType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1030:1: (lv_refType_6_0= ruleRefableType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1030:1: (lv_refType_6_0= ruleRefableType )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1031:3: lv_refType_6_0= ruleRefableType
            {
             
            	        newCompositeNode(grammarAccess.getAttributeAccess().getRefTypeRefableTypeParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleRefableType_in_ruleAttribute2057);
            lv_refType_6_0=ruleRefableType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"refType",
                    		lv_refType_6_0, 
                    		"RefableType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1047:2: (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==31) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1047:4: otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,31,FOLLOW_31_in_ruleAttribute2070); 

                        	newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getEqualsSignKeyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1051:1: ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1052:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1052:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1053:3: lv_defaultValueLiteral_8_0= RULE_STRING
                    {
                    lv_defaultValueLiteral_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAttribute2087); 

                    			newLeafNode(lv_defaultValueLiteral_8_0, grammarAccess.getAttributeAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_5_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"defaultValueLiteral",
                            		lv_defaultValueLiteral_8_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1069:4: ( (lv_docu_9_0= ruleDocumentation ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1070:1: (lv_docu_9_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1070:1: (lv_docu_9_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1071:3: lv_docu_9_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleAttribute2115);
                    lv_docu_9_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_9_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleStandardOperation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1097:1: entryRuleStandardOperation returns [EObject current=null] : iv_ruleStandardOperation= ruleStandardOperation EOF ;
    public final EObject entryRuleStandardOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStandardOperation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1098:2: (iv_ruleStandardOperation= ruleStandardOperation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1099:2: iv_ruleStandardOperation= ruleStandardOperation EOF
            {
             newCompositeNode(grammarAccess.getStandardOperationRule()); 
            pushFollow(FOLLOW_ruleStandardOperation_in_entryRuleStandardOperation2154);
            iv_ruleStandardOperation=ruleStandardOperation();

            state._fsp--;

             current =iv_ruleStandardOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStandardOperation2164); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStandardOperation"


    // $ANTLR start "ruleStandardOperation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1106:1: ruleStandardOperation returns [EObject current=null] : (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) )? ( (lv_docu_10_0= ruleDocumentation ) )? ( (lv_detailCode_11_0= ruleDetailCode ) ) ) ;
    public final EObject ruleStandardOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_returntype_9_0 = null;

        EObject lv_docu_10_0 = null;

        EObject lv_detailCode_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1109:28: ( (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) )? ( (lv_docu_10_0= ruleDocumentation ) )? ( (lv_detailCode_11_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1110:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) )? ( (lv_docu_10_0= ruleDocumentation ) )? ( (lv_detailCode_11_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1110:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) )? ( (lv_docu_10_0= ruleDocumentation ) )? ( (lv_detailCode_11_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1110:3: otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) )? ( (lv_docu_10_0= ruleDocumentation ) )? ( (lv_detailCode_11_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleStandardOperation2201); 

                	newLeafNode(otherlv_0, grammarAccess.getStandardOperationAccess().getOperationKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1114:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1115:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1115:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1116:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStandardOperation2218); 

            			newLeafNode(lv_name_1_0, grammarAccess.getStandardOperationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleStandardOperation2235); 

                	newLeafNode(otherlv_2, grammarAccess.getStandardOperationAccess().getLeftParenthesisKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1136:1: ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1136:2: ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1136:2: ( (lv_arguments_3_0= ruleVarDecl ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1137:1: (lv_arguments_3_0= ruleVarDecl )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1137:1: (lv_arguments_3_0= ruleVarDecl )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1138:3: lv_arguments_3_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getArgumentsVarDeclParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVarDecl_in_ruleStandardOperation2257);
                    lv_arguments_3_0=ruleVarDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                    	        }
                           		add(
                           			current, 
                           			"arguments",
                            		lv_arguments_3_0, 
                            		"VarDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1154:2: (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==33) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1154:4: otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleStandardOperation2270); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getStandardOperationAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1158:1: ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1159:1: (lv_arguments_5_0= ruleVarDecl )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1159:1: (lv_arguments_5_0= ruleVarDecl )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1160:3: lv_arguments_5_0= ruleVarDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getArgumentsVarDeclParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleVarDecl_in_ruleStandardOperation2291);
                    	    lv_arguments_5_0=ruleVarDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"arguments",
                    	            		lv_arguments_5_0, 
                    	            		"VarDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleStandardOperation2307); 

                	newLeafNode(otherlv_6, grammarAccess.getStandardOperationAccess().getRightParenthesisKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1180:1: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==15) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1180:3: otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) )
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleStandardOperation2320); 

                        	newLeafNode(otherlv_7, grammarAccess.getStandardOperationAccess().getColonKeyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1184:1: (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==34) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==RULE_ID) ) {
                        alt24=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1184:3: otherlv_8= 'void'
                            {
                            otherlv_8=(Token)match(input,34,FOLLOW_34_in_ruleStandardOperation2333); 

                                	newLeafNode(otherlv_8, grammarAccess.getStandardOperationAccess().getVoidKeyword_5_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1189:6: ( (lv_returntype_9_0= ruleRefableType ) )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1189:6: ( (lv_returntype_9_0= ruleRefableType ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1190:1: (lv_returntype_9_0= ruleRefableType )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1190:1: (lv_returntype_9_0= ruleRefableType )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1191:3: lv_returntype_9_0= ruleRefableType
                            {
                             
                            	        newCompositeNode(grammarAccess.getStandardOperationAccess().getReturntypeRefableTypeParserRuleCall_5_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleRefableType_in_ruleStandardOperation2360);
                            lv_returntype_9_0=ruleRefableType();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"returntype",
                                    		lv_returntype_9_0, 
                                    		"RefableType");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1207:5: ( (lv_docu_10_0= ruleDocumentation ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==29) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1208:1: (lv_docu_10_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1208:1: (lv_docu_10_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1209:3: lv_docu_10_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleStandardOperation2384);
                    lv_docu_10_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_10_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1225:3: ( (lv_detailCode_11_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1226:1: (lv_detailCode_11_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1226:1: (lv_detailCode_11_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1227:3: lv_detailCode_11_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getStandardOperationAccess().getDetailCodeDetailCodeParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleStandardOperation2406);
            lv_detailCode_11_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_11_0, 
                    		"DetailCode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStandardOperation"


    // $ANTLR start "entryRulePortOperation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1251:1: entryRulePortOperation returns [EObject current=null] : iv_rulePortOperation= rulePortOperation EOF ;
    public final EObject entryRulePortOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortOperation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1252:2: (iv_rulePortOperation= rulePortOperation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1253:2: iv_rulePortOperation= rulePortOperation EOF
            {
             newCompositeNode(grammarAccess.getPortOperationRule()); 
            pushFollow(FOLLOW_rulePortOperation_in_entryRulePortOperation2442);
            iv_rulePortOperation=rulePortOperation();

            state._fsp--;

             current =iv_rulePortOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortOperation2452); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortOperation"


    // $ANTLR start "rulePortOperation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1260:1: rulePortOperation returns [EObject current=null] : (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) ) ;
    public final EObject rulePortOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_returntype_9_0 = null;

        EObject lv_docu_12_0 = null;

        EObject lv_detailCode_13_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1263:28: ( (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1264:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1264:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1264:3: otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_rulePortOperation2489); 

                	newLeafNode(otherlv_0, grammarAccess.getPortOperationAccess().getOperationKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1268:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1269:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1269:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1270:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortOperation2506); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPortOperationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPortOperationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_rulePortOperation2523); 

                	newLeafNode(otherlv_2, grammarAccess.getPortOperationAccess().getLeftParenthesisKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1290:1: ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1290:2: ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1290:2: ( (lv_arguments_3_0= ruleVarDecl ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1291:1: (lv_arguments_3_0= ruleVarDecl )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1291:1: (lv_arguments_3_0= ruleVarDecl )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1292:3: lv_arguments_3_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortOperationAccess().getArgumentsVarDeclParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVarDecl_in_rulePortOperation2545);
                    lv_arguments_3_0=ruleVarDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
                    	        }
                           		add(
                           			current, 
                           			"arguments",
                            		lv_arguments_3_0, 
                            		"VarDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1308:2: (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==33) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1308:4: otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_4=(Token)match(input,33,FOLLOW_33_in_rulePortOperation2558); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getPortOperationAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1312:1: ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1313:1: (lv_arguments_5_0= ruleVarDecl )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1313:1: (lv_arguments_5_0= ruleVarDecl )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1314:3: lv_arguments_5_0= ruleVarDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPortOperationAccess().getArgumentsVarDeclParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleVarDecl_in_rulePortOperation2579);
                    	    lv_arguments_5_0=ruleVarDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"arguments",
                    	            		lv_arguments_5_0, 
                    	            		"VarDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,20,FOLLOW_20_in_rulePortOperation2595); 

                	newLeafNode(otherlv_6, grammarAccess.getPortOperationAccess().getRightParenthesisKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1334:1: ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )?
            int alt30=3;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==15) ) {
                alt30=1;
            }
            else if ( (LA30_0==35) ) {
                alt30=2;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1334:2: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1334:2: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1334:4: otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) )
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_15_in_rulePortOperation2609); 

                        	newLeafNode(otherlv_7, grammarAccess.getPortOperationAccess().getColonKeyword_5_0_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1338:1: (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==34) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==RULE_ID) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1338:3: otherlv_8= 'void'
                            {
                            otherlv_8=(Token)match(input,34,FOLLOW_34_in_rulePortOperation2622); 

                                	newLeafNode(otherlv_8, grammarAccess.getPortOperationAccess().getVoidKeyword_5_0_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1343:6: ( (lv_returntype_9_0= ruleRefableType ) )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1343:6: ( (lv_returntype_9_0= ruleRefableType ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1344:1: (lv_returntype_9_0= ruleRefableType )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1344:1: (lv_returntype_9_0= ruleRefableType )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1345:3: lv_returntype_9_0= ruleRefableType
                            {
                             
                            	        newCompositeNode(grammarAccess.getPortOperationAccess().getReturntypeRefableTypeParserRuleCall_5_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleRefableType_in_rulePortOperation2649);
                            lv_returntype_9_0=ruleRefableType();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"returntype",
                                    		lv_returntype_9_0, 
                                    		"RefableType");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1362:6: (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1362:6: (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1362:8: otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) )
                    {
                    otherlv_10=(Token)match(input,35,FOLLOW_35_in_rulePortOperation2670); 

                        	newLeafNode(otherlv_10, grammarAccess.getPortOperationAccess().getSendsKeyword_5_1_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1366:1: ( (otherlv_11= RULE_ID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1367:1: (otherlv_11= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1367:1: (otherlv_11= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1368:3: otherlv_11= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortOperationRule());
                    	        }
                            
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortOperation2690); 

                    		newLeafNode(otherlv_11, grammarAccess.getPortOperationAccess().getSendsMsgMessageCrossReference_5_1_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1379:5: ( (lv_docu_12_0= ruleDocumentation ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==29) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1380:1: (lv_docu_12_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1380:1: (lv_docu_12_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1381:3: lv_docu_12_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortOperationAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_rulePortOperation2714);
                    lv_docu_12_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_12_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1397:3: ( (lv_detailCode_13_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1398:1: (lv_detailCode_13_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1398:1: (lv_detailCode_13_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1399:3: lv_detailCode_13_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getPortOperationAccess().getDetailCodeDetailCodeParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_rulePortOperation2736);
            lv_detailCode_13_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_13_0, 
                    		"DetailCode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortOperation"


    // $ANTLR start "entryRuleProtocolClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1423:1: entryRuleProtocolClass returns [EObject current=null] : iv_ruleProtocolClass= ruleProtocolClass EOF ;
    public final EObject entryRuleProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1424:2: (iv_ruleProtocolClass= ruleProtocolClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1425:2: iv_ruleProtocolClass= ruleProtocolClass EOF
            {
             newCompositeNode(grammarAccess.getProtocolClassRule()); 
            pushFollow(FOLLOW_ruleProtocolClass_in_entryRuleProtocolClass2772);
            iv_ruleProtocolClass=ruleProtocolClass();

            state._fsp--;

             current =iv_ruleProtocolClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolClass2782); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProtocolClass"


    // $ANTLR start "ruleProtocolClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1432:1: ruleProtocolClass returns [EObject current=null] : (otherlv_0= 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? (otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}' )? (otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}' )? (otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) ) )? (otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) ) )? ( (lv_semantics_26_0= ruleProtocolSemantics ) )? otherlv_27= '}' ) ;
    public final EObject ruleProtocolClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_27=null;
        EObject lv_docu_2_0 = null;

        EObject lv_userCode1_7_0 = null;

        EObject lv_userCode2_9_0 = null;

        EObject lv_userCode3_11_0 = null;

        EObject lv_incomingMessages_14_0 = null;

        EObject lv_outgoingMessages_18_0 = null;

        EObject lv_regular_22_0 = null;

        EObject lv_conjugate_25_0 = null;

        EObject lv_semantics_26_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1435:28: ( (otherlv_0= 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? (otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}' )? (otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}' )? (otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) ) )? (otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) ) )? ( (lv_semantics_26_0= ruleProtocolSemantics ) )? otherlv_27= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1436:1: (otherlv_0= 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? (otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}' )? (otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}' )? (otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) ) )? (otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) ) )? ( (lv_semantics_26_0= ruleProtocolSemantics ) )? otherlv_27= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1436:1: (otherlv_0= 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? (otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}' )? (otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}' )? (otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) ) )? (otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) ) )? ( (lv_semantics_26_0= ruleProtocolSemantics ) )? otherlv_27= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1436:3: otherlv_0= 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? (otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}' )? (otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}' )? (otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) ) )? (otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) ) )? ( (lv_semantics_26_0= ruleProtocolSemantics ) )? otherlv_27= '}'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleProtocolClass2819); 

                	newLeafNode(otherlv_0, grammarAccess.getProtocolClassAccess().getProtocolClassKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1440:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1441:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1441:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1442:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProtocolClass2836); 

            			newLeafNode(lv_name_1_0, grammarAccess.getProtocolClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getProtocolClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1458:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==29) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1459:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1459:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1460:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleProtocolClass2862);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_2_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1476:3: (otherlv_3= 'extends' ( ( ruleFQN ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==24) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1476:5: otherlv_3= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleProtocolClass2876); 

                        	newLeafNode(otherlv_3, grammarAccess.getProtocolClassAccess().getExtendsKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1480:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1481:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1481:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1482:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getProtocolClassRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getBaseProtocolClassCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleProtocolClass2899);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleProtocolClass2913); 

                	newLeafNode(otherlv_5, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1499:1: (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==25) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1499:3: otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) )
                    {
                    otherlv_6=(Token)match(input,25,FOLLOW_25_in_ruleProtocolClass2926); 

                        	newLeafNode(otherlv_6, grammarAccess.getProtocolClassAccess().getUsercode1Keyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1503:1: ( (lv_userCode1_7_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1504:1: (lv_userCode1_7_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1504:1: (lv_userCode1_7_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1505:3: lv_userCode1_7_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode1DetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleProtocolClass2947);
                    lv_userCode1_7_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode1",
                            		lv_userCode1_7_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1521:4: (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==26) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1521:6: otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleProtocolClass2962); 

                        	newLeafNode(otherlv_8, grammarAccess.getProtocolClassAccess().getUsercode2Keyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1525:1: ( (lv_userCode2_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1526:1: (lv_userCode2_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1526:1: (lv_userCode2_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1527:3: lv_userCode2_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode2DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleProtocolClass2983);
                    lv_userCode2_9_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode2",
                            		lv_userCode2_9_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1543:4: (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==27) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1543:6: otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,27,FOLLOW_27_in_ruleProtocolClass2998); 

                        	newLeafNode(otherlv_10, grammarAccess.getProtocolClassAccess().getUsercode3Keyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1547:1: ( (lv_userCode3_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1548:1: (lv_userCode3_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1548:1: (lv_userCode3_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1549:3: lv_userCode3_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode3DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleProtocolClass3019);
                    lv_userCode3_11_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode3",
                            		lv_userCode3_11_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1565:4: (otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==37) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1565:6: otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}'
                    {
                    otherlv_12=(Token)match(input,37,FOLLOW_37_in_ruleProtocolClass3034); 

                        	newLeafNode(otherlv_12, grammarAccess.getProtocolClassAccess().getIncomingKeyword_8_0());
                        
                    otherlv_13=(Token)match(input,13,FOLLOW_13_in_ruleProtocolClass3046); 

                        	newLeafNode(otherlv_13, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_8_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1573:1: ( (lv_incomingMessages_14_0= ruleMessage ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( ((LA37_0>=42 && LA37_0<=43)) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1574:1: (lv_incomingMessages_14_0= ruleMessage )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1574:1: (lv_incomingMessages_14_0= ruleMessage )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1575:3: lv_incomingMessages_14_0= ruleMessage
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getIncomingMessagesMessageParserRuleCall_8_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMessage_in_ruleProtocolClass3067);
                    	    lv_incomingMessages_14_0=ruleMessage();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"incomingMessages",
                    	            		lv_incomingMessages_14_0, 
                    	            		"Message");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,14,FOLLOW_14_in_ruleProtocolClass3080); 

                        	newLeafNode(otherlv_15, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_8_3());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1595:3: (otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==38) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1595:5: otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}'
                    {
                    otherlv_16=(Token)match(input,38,FOLLOW_38_in_ruleProtocolClass3095); 

                        	newLeafNode(otherlv_16, grammarAccess.getProtocolClassAccess().getOutgoingKeyword_9_0());
                        
                    otherlv_17=(Token)match(input,13,FOLLOW_13_in_ruleProtocolClass3107); 

                        	newLeafNode(otherlv_17, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_9_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1603:1: ( (lv_outgoingMessages_18_0= ruleMessage ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( ((LA39_0>=42 && LA39_0<=43)) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1604:1: (lv_outgoingMessages_18_0= ruleMessage )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1604:1: (lv_outgoingMessages_18_0= ruleMessage )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1605:3: lv_outgoingMessages_18_0= ruleMessage
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getOutgoingMessagesMessageParserRuleCall_9_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMessage_in_ruleProtocolClass3128);
                    	    lv_outgoingMessages_18_0=ruleMessage();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"outgoingMessages",
                    	            		lv_outgoingMessages_18_0, 
                    	            		"Message");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);

                    otherlv_19=(Token)match(input,14,FOLLOW_14_in_ruleProtocolClass3141); 

                        	newLeafNode(otherlv_19, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_9_3());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1625:3: (otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==39) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1625:5: otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) )
                    {
                    otherlv_20=(Token)match(input,39,FOLLOW_39_in_ruleProtocolClass3156); 

                        	newLeafNode(otherlv_20, grammarAccess.getProtocolClassAccess().getRegularKeyword_10_0());
                        
                    otherlv_21=(Token)match(input,40,FOLLOW_40_in_ruleProtocolClass3168); 

                        	newLeafNode(otherlv_21, grammarAccess.getProtocolClassAccess().getPortClassKeyword_10_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1633:1: ( (lv_regular_22_0= rulePortClass ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1634:1: (lv_regular_22_0= rulePortClass )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1634:1: (lv_regular_22_0= rulePortClass )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1635:3: lv_regular_22_0= rulePortClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getRegularPortClassParserRuleCall_10_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulePortClass_in_ruleProtocolClass3189);
                    lv_regular_22_0=rulePortClass();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"regular",
                            		lv_regular_22_0, 
                            		"PortClass");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1651:4: (otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==41) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1651:6: otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) )
                    {
                    otherlv_23=(Token)match(input,41,FOLLOW_41_in_ruleProtocolClass3204); 

                        	newLeafNode(otherlv_23, grammarAccess.getProtocolClassAccess().getConjugateKeyword_11_0());
                        
                    otherlv_24=(Token)match(input,40,FOLLOW_40_in_ruleProtocolClass3216); 

                        	newLeafNode(otherlv_24, grammarAccess.getProtocolClassAccess().getPortClassKeyword_11_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1659:1: ( (lv_conjugate_25_0= rulePortClass ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1660:1: (lv_conjugate_25_0= rulePortClass )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1660:1: (lv_conjugate_25_0= rulePortClass )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1661:3: lv_conjugate_25_0= rulePortClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getConjugatePortClassParserRuleCall_11_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulePortClass_in_ruleProtocolClass3237);
                    lv_conjugate_25_0=rulePortClass();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"conjugate",
                            		lv_conjugate_25_0, 
                            		"PortClass");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1677:4: ( (lv_semantics_26_0= ruleProtocolSemantics ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==46) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1678:1: (lv_semantics_26_0= ruleProtocolSemantics )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1678:1: (lv_semantics_26_0= ruleProtocolSemantics )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1679:3: lv_semantics_26_0= ruleProtocolSemantics
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getSemanticsProtocolSemanticsParserRuleCall_12_0()); 
                    	    
                    pushFollow(FOLLOW_ruleProtocolSemantics_in_ruleProtocolClass3260);
                    lv_semantics_26_0=ruleProtocolSemantics();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"semantics",
                            		lv_semantics_26_0, 
                            		"ProtocolSemantics");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_27=(Token)match(input,14,FOLLOW_14_in_ruleProtocolClass3273); 

                	newLeafNode(otherlv_27, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_13());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProtocolClass"


    // $ANTLR start "entryRuleMessage"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1707:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1708:2: (iv_ruleMessage= ruleMessage EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1709:2: iv_ruleMessage= ruleMessage EOF
            {
             newCompositeNode(grammarAccess.getMessageRule()); 
            pushFollow(FOLLOW_ruleMessage_in_entryRuleMessage3309);
            iv_ruleMessage=ruleMessage();

            state._fsp--;

             current =iv_ruleMessage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessage3319); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessage"


    // $ANTLR start "ruleMessage"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1716:1: ruleMessage returns [EObject current=null] : ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        Token lv_priv_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_data_4_0 = null;

        EObject lv_docu_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1719:28: ( ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1720:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1720:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1720:2: ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1720:2: ( (lv_priv_0_0= 'private' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==42) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1721:1: (lv_priv_0_0= 'private' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1721:1: (lv_priv_0_0= 'private' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1722:3: lv_priv_0_0= 'private'
                    {
                    lv_priv_0_0=(Token)match(input,42,FOLLOW_42_in_ruleMessage3362); 

                            newLeafNode(lv_priv_0_0, grammarAccess.getMessageAccess().getPrivPrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMessageRule());
                    	        }
                           		setWithLastConsumed(current, "priv", true, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleMessage3388); 

                	newLeafNode(otherlv_1, grammarAccess.getMessageAccess().getMessageKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1739:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1740:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1740:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1741:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessage3405); 

            			newLeafNode(lv_name_2_0, grammarAccess.getMessageAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleMessage3422); 

                	newLeafNode(otherlv_3, grammarAccess.getMessageAccess().getLeftParenthesisKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1761:1: ( (lv_data_4_0= ruleVarDecl ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1762:1: (lv_data_4_0= ruleVarDecl )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1762:1: (lv_data_4_0= ruleVarDecl )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1763:3: lv_data_4_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getMessageAccess().getDataVarDeclParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVarDecl_in_ruleMessage3443);
                    lv_data_4_0=ruleVarDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMessageRule());
                    	        }
                           		set(
                           			current, 
                           			"data",
                            		lv_data_4_0, 
                            		"VarDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleMessage3456); 

                	newLeafNode(otherlv_5, grammarAccess.getMessageAccess().getRightParenthesisKeyword_5());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1783:1: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==29) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1784:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1784:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1785:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getMessageAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleMessage3477);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMessageRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_6_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessage"


    // $ANTLR start "entryRulePortClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1809:1: entryRulePortClass returns [EObject current=null] : iv_rulePortClass= rulePortClass EOF ;
    public final EObject entryRulePortClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1810:2: (iv_rulePortClass= rulePortClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1811:2: iv_rulePortClass= rulePortClass EOF
            {
             newCompositeNode(grammarAccess.getPortClassRule()); 
            pushFollow(FOLLOW_rulePortClass_in_entryRulePortClass3514);
            iv_rulePortClass=rulePortClass();

            state._fsp--;

             current =iv_rulePortClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortClass3524); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortClass"


    // $ANTLR start "rulePortClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1818:1: rulePortClass returns [EObject current=null] : (otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}' ) ;
    public final EObject rulePortClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_6=null;
        EObject lv_userCode_2_0 = null;

        EObject lv_attributes_3_0 = null;

        EObject lv_operations_4_0 = null;

        EObject lv_msgHandlers_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1821:28: ( (otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1822:1: (otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1822:1: (otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1822:3: otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_rulePortClass3561); 

                	newLeafNode(otherlv_0, grammarAccess.getPortClassAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1826:1: (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==44) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1826:3: otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) )
                    {
                    otherlv_1=(Token)match(input,44,FOLLOW_44_in_rulePortClass3574); 

                        	newLeafNode(otherlv_1, grammarAccess.getPortClassAccess().getUsercodeKeyword_1_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1830:1: ( (lv_userCode_2_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1831:1: (lv_userCode_2_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1831:1: (lv_userCode_2_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1832:3: lv_userCode_2_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortClassAccess().getUserCodeDetailCodeParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_rulePortClass3595);
                    lv_userCode_2_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode",
                            		lv_userCode_2_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1848:4: ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+
            int cnt48=0;
            loop48:
            do {
                int alt48=4;
                switch ( input.LA(1) ) {
                case 28:
                    {
                    alt48=1;
                    }
                    break;
                case 32:
                    {
                    alt48=2;
                    }
                    break;
                case 45:
                    {
                    alt48=3;
                    }
                    break;

                }

                switch (alt48) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1848:5: ( (lv_attributes_3_0= ruleAttribute ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1848:5: ( (lv_attributes_3_0= ruleAttribute ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1849:1: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1849:1: (lv_attributes_3_0= ruleAttribute )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1850:3: lv_attributes_3_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getAttributesAttributeParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttribute_in_rulePortClass3619);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_3_0, 
            	            		"Attribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1867:6: ( (lv_operations_4_0= rulePortOperation ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1867:6: ( (lv_operations_4_0= rulePortOperation ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1868:1: (lv_operations_4_0= rulePortOperation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1868:1: (lv_operations_4_0= rulePortOperation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1869:3: lv_operations_4_0= rulePortOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getOperationsPortOperationParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePortOperation_in_rulePortClass3646);
            	    lv_operations_4_0=rulePortOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"operations",
            	            		lv_operations_4_0, 
            	            		"PortOperation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1886:6: ( (lv_msgHandlers_5_0= ruleMessageHandler ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1886:6: ( (lv_msgHandlers_5_0= ruleMessageHandler ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1887:1: (lv_msgHandlers_5_0= ruleMessageHandler )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1887:1: (lv_msgHandlers_5_0= ruleMessageHandler )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1888:3: lv_msgHandlers_5_0= ruleMessageHandler
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getMsgHandlersMessageHandlerParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessageHandler_in_rulePortClass3673);
            	    lv_msgHandlers_5_0=ruleMessageHandler();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"msgHandlers",
            	            		lv_msgHandlers_5_0, 
            	            		"MessageHandler");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt48 >= 1 ) break loop48;
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_rulePortClass3687); 

                	newLeafNode(otherlv_6, grammarAccess.getPortClassAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortClass"


    // $ANTLR start "entryRuleMessageHandler"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1916:1: entryRuleMessageHandler returns [EObject current=null] : iv_ruleMessageHandler= ruleMessageHandler EOF ;
    public final EObject entryRuleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageHandler = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1917:2: (iv_ruleMessageHandler= ruleMessageHandler EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1918:2: iv_ruleMessageHandler= ruleMessageHandler EOF
            {
             newCompositeNode(grammarAccess.getMessageHandlerRule()); 
            pushFollow(FOLLOW_ruleMessageHandler_in_entryRuleMessageHandler3723);
            iv_ruleMessageHandler=ruleMessageHandler();

            state._fsp--;

             current =iv_ruleMessageHandler; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessageHandler3733); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageHandler"


    // $ANTLR start "ruleMessageHandler"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1925:1: ruleMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' ( (otherlv_1= RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) ) ;
    public final EObject ruleMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_detailCode_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1928:28: ( (otherlv_0= 'handle' ( (otherlv_1= RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1929:1: (otherlv_0= 'handle' ( (otherlv_1= RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1929:1: (otherlv_0= 'handle' ( (otherlv_1= RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1929:3: otherlv_0= 'handle' ( (otherlv_1= RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleMessageHandler3770); 

                	newLeafNode(otherlv_0, grammarAccess.getMessageHandlerAccess().getHandleKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1933:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1934:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1934:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1935:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageHandlerRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageHandler3790); 

            		newLeafNode(otherlv_1, grammarAccess.getMessageHandlerAccess().getMsgMessageCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1946:2: ( (lv_detailCode_2_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1947:1: (lv_detailCode_2_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1947:1: (lv_detailCode_2_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1948:3: lv_detailCode_2_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getMessageHandlerAccess().getDetailCodeDetailCodeParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleMessageHandler3811);
            lv_detailCode_2_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMessageHandlerRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_2_0, 
                    		"DetailCode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessageHandler"


    // $ANTLR start "entryRuleProtocolSemantics"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1972:1: entryRuleProtocolSemantics returns [EObject current=null] : iv_ruleProtocolSemantics= ruleProtocolSemantics EOF ;
    public final EObject entryRuleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSemantics = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1973:2: (iv_ruleProtocolSemantics= ruleProtocolSemantics EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1974:2: iv_ruleProtocolSemantics= ruleProtocolSemantics EOF
            {
             newCompositeNode(grammarAccess.getProtocolSemanticsRule()); 
            pushFollow(FOLLOW_ruleProtocolSemantics_in_entryRuleProtocolSemantics3847);
            iv_ruleProtocolSemantics=ruleProtocolSemantics();

            state._fsp--;

             current =iv_ruleProtocolSemantics; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolSemantics3857); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProtocolSemantics"


    // $ANTLR start "ruleProtocolSemantics"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1981:1: ruleProtocolSemantics returns [EObject current=null] : ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) ;
    public final EObject ruleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_rules_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1984:28: ( ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1985:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1985:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1985:2: () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1985:2: ()
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1986:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getProtocolSemanticsAccess().getProtocolSemanticsAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,46,FOLLOW_46_in_ruleProtocolSemantics3903); 

                	newLeafNode(otherlv_1, grammarAccess.getProtocolSemanticsAccess().getSemanticsKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleProtocolSemantics3915); 

                	newLeafNode(otherlv_2, grammarAccess.getProtocolSemanticsAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1999:1: ( (lv_rules_3_0= ruleSemanticsRule ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_ID) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2000:1: (lv_rules_3_0= ruleSemanticsRule )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2000:1: (lv_rules_3_0= ruleSemanticsRule )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2001:3: lv_rules_3_0= ruleSemanticsRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolSemanticsAccess().getRulesSemanticsRuleParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleProtocolSemantics3936);
            	    lv_rules_3_0=ruleSemanticsRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getProtocolSemanticsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_3_0, 
            	            		"SemanticsRule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleProtocolSemantics3949); 

                	newLeafNode(otherlv_4, grammarAccess.getProtocolSemanticsAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProtocolSemantics"


    // $ANTLR start "entryRuleSemanticsRule"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2029:1: entryRuleSemanticsRule returns [EObject current=null] : iv_ruleSemanticsRule= ruleSemanticsRule EOF ;
    public final EObject entryRuleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsRule = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2030:2: (iv_ruleSemanticsRule= ruleSemanticsRule EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2031:2: iv_ruleSemanticsRule= ruleSemanticsRule EOF
            {
             newCompositeNode(grammarAccess.getSemanticsRuleRule()); 
            pushFollow(FOLLOW_ruleSemanticsRule_in_entryRuleSemanticsRule3985);
            iv_ruleSemanticsRule=ruleSemanticsRule();

            state._fsp--;

             current =iv_ruleSemanticsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSemanticsRule3995); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSemanticsRule"


    // $ANTLR start "ruleSemanticsRule"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2038:1: ruleSemanticsRule returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) ) )? ) ;
    public final EObject ruleSemanticsRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_followUps_2_0 = null;

        EObject lv_followUps_4_0 = null;

        EObject lv_followUps_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2041:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2042:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2042:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2042:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) ) )?
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2042:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2043:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2043:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2044:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSemanticsRuleRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSemanticsRule4040); 

            		newLeafNode(otherlv_0, grammarAccess.getSemanticsRuleAccess().getMsgMessageCrossReference_0_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2055:2: (otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==18) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2055:4: otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) )
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleSemanticsRule4053); 

                        	newLeafNode(otherlv_1, grammarAccess.getSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2059:1: ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) )
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==RULE_ID) ) {
                        alt51=1;
                    }
                    else if ( (LA51_0==19) ) {
                        alt51=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 0, input);

                        throw nvae;
                    }
                    switch (alt51) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2059:2: ( (lv_followUps_2_0= ruleSemanticsRule ) )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2059:2: ( (lv_followUps_2_0= ruleSemanticsRule ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2060:1: (lv_followUps_2_0= ruleSemanticsRule )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2060:1: (lv_followUps_2_0= ruleSemanticsRule )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2061:3: lv_followUps_2_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSemanticsRule_in_ruleSemanticsRule4075);
                            lv_followUps_2_0=ruleSemanticsRule();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSemanticsRuleRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"followUps",
                                    		lv_followUps_2_0, 
                                    		"SemanticsRule");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2078:6: (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2078:6: (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2078:8: otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')'
                            {
                            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleSemanticsRule4094); 

                                	newLeafNode(otherlv_3, grammarAccess.getSemanticsRuleAccess().getLeftParenthesisKeyword_1_1_1_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2082:1: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2083:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2083:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2084:3: lv_followUps_4_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_1_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSemanticsRule_in_ruleSemanticsRule4115);
                            lv_followUps_4_0=ruleSemanticsRule();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSemanticsRuleRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"followUps",
                                    		lv_followUps_4_0, 
                                    		"SemanticsRule");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2100:2: (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+
                            int cnt50=0;
                            loop50:
                            do {
                                int alt50=2;
                                int LA50_0 = input.LA(1);

                                if ( (LA50_0==33) ) {
                                    alt50=1;
                                }


                                switch (alt50) {
                            	case 1 :
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2100:4: otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleSemanticsRule4128); 

                            	        	newLeafNode(otherlv_5, grammarAccess.getSemanticsRuleAccess().getCommaKeyword_1_1_1_2_0());
                            	        
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2104:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2105:1: (lv_followUps_6_0= ruleSemanticsRule )
                            	    {
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2105:1: (lv_followUps_6_0= ruleSemanticsRule )
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2106:3: lv_followUps_6_0= ruleSemanticsRule
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_1_1_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleSemanticsRule4149);
                            	    lv_followUps_6_0=ruleSemanticsRule();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getSemanticsRuleRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"followUps",
                            	            		lv_followUps_6_0, 
                            	            		"SemanticsRule");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt50 >= 1 ) break loop50;
                                        EarlyExitException eee =
                                            new EarlyExitException(50, input);
                                        throw eee;
                                }
                                cnt50++;
                            } while (true);

                            otherlv_7=(Token)match(input,20,FOLLOW_20_in_ruleSemanticsRule4163); 

                                	newLeafNode(otherlv_7, grammarAccess.getSemanticsRuleAccess().getRightParenthesisKeyword_1_1_1_3());
                                

                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSemanticsRule"


    // $ANTLR start "entryRuleActorClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2134:1: entryRuleActorClass returns [EObject current=null] : iv_ruleActorClass= ruleActorClass EOF ;
    public final EObject entryRuleActorClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2135:2: (iv_ruleActorClass= ruleActorClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2136:2: iv_ruleActorClass= ruleActorClass EOF
            {
             newCompositeNode(grammarAccess.getActorClassRule()); 
            pushFollow(FOLLOW_ruleActorClass_in_entryRuleActorClass4203);
            iv_ruleActorClass=ruleActorClass();

            state._fsp--;

             current =iv_ruleActorClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorClass4213); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActorClass"


    // $ANTLR start "ruleActorClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2143:1: ruleActorClass returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' (otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}' )? (otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}' )? (otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}' )? otherlv_37= '}' ) ;
    public final EObject ruleActorClass() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        EObject lv_docu_3_0 = null;

        EObject lv_ifPorts_9_0 = null;

        EObject lv_ifSPPs_10_0 = null;

        EObject lv_structureDocu_13_0 = null;

        EObject lv_userCode1_16_0 = null;

        EObject lv_userCode2_18_0 = null;

        EObject lv_userCode3_20_0 = null;

        EObject lv_intPorts_21_0 = null;

        EObject lv_extPorts_22_0 = null;

        EObject lv_serviceImplementations_23_0 = null;

        EObject lv_strSAPs_24_0 = null;

        EObject lv_attributes_25_0 = null;

        EObject lv_actorRefs_26_0 = null;

        EObject lv_bindings_27_0 = null;

        EObject lv_connections_28_0 = null;

        EObject lv_behaviorDocu_31_0 = null;

        EObject lv_annotations_33_0 = null;

        EObject lv_operations_34_0 = null;

        EObject lv_stateMachine_35_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2146:28: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' (otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}' )? (otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}' )? (otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}' )? otherlv_37= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2147:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' (otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}' )? (otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}' )? (otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}' )? otherlv_37= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2147:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' (otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}' )? (otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}' )? (otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}' )? otherlv_37= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2147:2: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' (otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}' )? (otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}' )? (otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}' )? otherlv_37= '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2147:2: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==47) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2148:1: (lv_abstract_0_0= 'abstract' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2148:1: (lv_abstract_0_0= 'abstract' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2149:3: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,47,FOLLOW_47_in_ruleActorClass4256); 

                            newLeafNode(lv_abstract_0_0, grammarAccess.getActorClassAccess().getAbstractAbstractKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getActorClassRule());
                    	        }
                           		setWithLastConsumed(current, "abstract", true, "abstract");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleActorClass4282); 

                	newLeafNode(otherlv_1, grammarAccess.getActorClassAccess().getActorClassKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2166:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2167:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2167:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2168:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorClass4299); 

            			newLeafNode(lv_name_2_0, grammarAccess.getActorClassAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getActorClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2184:2: ( (lv_docu_3_0= ruleDocumentation ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==29) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2185:1: (lv_docu_3_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2185:1: (lv_docu_3_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2186:3: lv_docu_3_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorClassAccess().getDocuDocumentationParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleActorClass4325);
                    lv_docu_3_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_3_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2202:3: (otherlv_4= 'extends' ( ( ruleFQN ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==24) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2202:5: otherlv_4= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleActorClass4339); 

                        	newLeafNode(otherlv_4, grammarAccess.getActorClassAccess().getExtendsKeyword_4_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2206:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2207:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2207:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2208:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getActorClassRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getActorClassAccess().getBaseActorClassCrossReference_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleActorClass4362);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleActorClass4376); 

                	newLeafNode(otherlv_6, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_5());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2225:1: (otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==49) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2225:3: otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,49,FOLLOW_49_in_ruleActorClass4389); 

                        	newLeafNode(otherlv_7, grammarAccess.getActorClassAccess().getInterfaceKeyword_6_0());
                        
                    otherlv_8=(Token)match(input,13,FOLLOW_13_in_ruleActorClass4401); 

                        	newLeafNode(otherlv_8, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2233:1: ( (lv_ifPorts_9_0= rulePort ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( ((LA56_0>=52 && LA56_0<=53)) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2234:1: (lv_ifPorts_9_0= rulePort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2234:1: (lv_ifPorts_9_0= rulePort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2235:3: lv_ifPorts_9_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getIfPortsPortParserRuleCall_6_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePort_in_ruleActorClass4422);
                    	    lv_ifPorts_9_0=rulePort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ifPorts",
                    	            		lv_ifPorts_9_0, 
                    	            		"Port");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2251:3: ( (lv_ifSPPs_10_0= ruleSPPRef ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==56) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2252:1: (lv_ifSPPs_10_0= ruleSPPRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2252:1: (lv_ifSPPs_10_0= ruleSPPRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2253:3: lv_ifSPPs_10_0= ruleSPPRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getIfSPPsSPPRefParserRuleCall_6_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSPPRef_in_ruleActorClass4444);
                    	    lv_ifSPPs_10_0=ruleSPPRef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ifSPPs",
                    	            		lv_ifSPPs_10_0, 
                    	            		"SPPRef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,14,FOLLOW_14_in_ruleActorClass4457); 

                        	newLeafNode(otherlv_11, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_6_4());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2273:3: (otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==50) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2273:5: otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}'
                    {
                    otherlv_12=(Token)match(input,50,FOLLOW_50_in_ruleActorClass4472); 

                        	newLeafNode(otherlv_12, grammarAccess.getActorClassAccess().getStructureKeyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2277:1: ( (lv_structureDocu_13_0= ruleDocumentation ) )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==29) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2278:1: (lv_structureDocu_13_0= ruleDocumentation )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2278:1: (lv_structureDocu_13_0= ruleDocumentation )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2279:3: lv_structureDocu_13_0= ruleDocumentation
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getStructureDocuDocumentationParserRuleCall_7_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDocumentation_in_ruleActorClass4493);
                            lv_structureDocu_13_0=ruleDocumentation();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"structureDocu",
                                    		lv_structureDocu_13_0, 
                                    		"Documentation");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,13,FOLLOW_13_in_ruleActorClass4506); 

                        	newLeafNode(otherlv_14, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_7_2());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2299:1: (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==25) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2299:3: otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) )
                            {
                            otherlv_15=(Token)match(input,25,FOLLOW_25_in_ruleActorClass4519); 

                                	newLeafNode(otherlv_15, grammarAccess.getActorClassAccess().getUsercode1Keyword_7_3_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2303:1: ( (lv_userCode1_16_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2304:1: (lv_userCode1_16_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2304:1: (lv_userCode1_16_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2305:3: lv_userCode1_16_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode1DetailCodeParserRuleCall_7_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleActorClass4540);
                            lv_userCode1_16_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"userCode1",
                                    		lv_userCode1_16_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2321:4: (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==26) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2321:6: otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) )
                            {
                            otherlv_17=(Token)match(input,26,FOLLOW_26_in_ruleActorClass4555); 

                                	newLeafNode(otherlv_17, grammarAccess.getActorClassAccess().getUsercode2Keyword_7_4_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2325:1: ( (lv_userCode2_18_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2326:1: (lv_userCode2_18_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2326:1: (lv_userCode2_18_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2327:3: lv_userCode2_18_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode2DetailCodeParserRuleCall_7_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleActorClass4576);
                            lv_userCode2_18_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"userCode2",
                                    		lv_userCode2_18_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2343:4: (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==27) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2343:6: otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) )
                            {
                            otherlv_19=(Token)match(input,27,FOLLOW_27_in_ruleActorClass4591); 

                                	newLeafNode(otherlv_19, grammarAccess.getActorClassAccess().getUsercode3Keyword_7_5_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2347:1: ( (lv_userCode3_20_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2348:1: (lv_userCode3_20_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2348:1: (lv_userCode3_20_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2349:3: lv_userCode3_20_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode3DetailCodeParserRuleCall_7_5_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleActorClass4612);
                            lv_userCode3_20_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"userCode3",
                                    		lv_userCode3_20_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2365:4: ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )*
                    loop63:
                    do {
                        int alt63=3;
                        int LA63_0 = input.LA(1);

                        if ( ((LA63_0>=52 && LA63_0<=53)) ) {
                            alt63=1;
                        }
                        else if ( (LA63_0==54) ) {
                            alt63=2;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2365:5: ( (lv_intPorts_21_0= rulePort ) )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2365:5: ( (lv_intPorts_21_0= rulePort ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2366:1: (lv_intPorts_21_0= rulePort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2366:1: (lv_intPorts_21_0= rulePort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2367:3: lv_intPorts_21_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getIntPortsPortParserRuleCall_7_6_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePort_in_ruleActorClass4636);
                    	    lv_intPorts_21_0=rulePort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"intPorts",
                    	            		lv_intPorts_21_0, 
                    	            		"Port");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2384:6: ( (lv_extPorts_22_0= ruleExternalPort ) )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2384:6: ( (lv_extPorts_22_0= ruleExternalPort ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2385:1: (lv_extPorts_22_0= ruleExternalPort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2385:1: (lv_extPorts_22_0= ruleExternalPort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2386:3: lv_extPorts_22_0= ruleExternalPort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getExtPortsExternalPortParserRuleCall_7_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExternalPort_in_ruleActorClass4663);
                    	    lv_extPorts_22_0=ruleExternalPort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"extPorts",
                    	            		lv_extPorts_22_0, 
                    	            		"ExternalPort");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2402:4: ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==57) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2403:1: (lv_serviceImplementations_23_0= ruleServiceImplementation )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2403:1: (lv_serviceImplementations_23_0= ruleServiceImplementation )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2404:3: lv_serviceImplementations_23_0= ruleServiceImplementation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceImplementationsServiceImplementationParserRuleCall_7_7_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleServiceImplementation_in_ruleActorClass4686);
                    	    lv_serviceImplementations_23_0=ruleServiceImplementation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"serviceImplementations",
                    	            		lv_serviceImplementations_23_0, 
                    	            		"ServiceImplementation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2420:3: ( (lv_strSAPs_24_0= ruleSAPRef ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==55) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2421:1: (lv_strSAPs_24_0= ruleSAPRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2421:1: (lv_strSAPs_24_0= ruleSAPRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2422:3: lv_strSAPs_24_0= ruleSAPRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getStrSAPsSAPRefParserRuleCall_7_8_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSAPRef_in_ruleActorClass4708);
                    	    lv_strSAPs_24_0=ruleSAPRef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"strSAPs",
                    	            		lv_strSAPs_24_0, 
                    	            		"SAPRef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2438:3: ( (lv_attributes_25_0= ruleAttribute ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==28) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2439:1: (lv_attributes_25_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2439:1: (lv_attributes_25_0= ruleAttribute )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2440:3: lv_attributes_25_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAttributesAttributeParserRuleCall_7_9_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleActorClass4730);
                    	    lv_attributes_25_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_25_0, 
                    	            		"Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop66;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2456:3: ( (lv_actorRefs_26_0= ruleActorRef ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==70) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2457:1: (lv_actorRefs_26_0= ruleActorRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2457:1: (lv_actorRefs_26_0= ruleActorRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2458:3: lv_actorRefs_26_0= ruleActorRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getActorRefsActorRefParserRuleCall_7_10_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleActorRef_in_ruleActorClass4752);
                    	    lv_actorRefs_26_0=ruleActorRef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"actorRefs",
                    	            		lv_actorRefs_26_0, 
                    	            		"ActorRef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2474:3: ( (lv_bindings_27_0= ruleBinding ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==65) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2475:1: (lv_bindings_27_0= ruleBinding )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2475:1: (lv_bindings_27_0= ruleBinding )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2476:3: lv_bindings_27_0= ruleBinding
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getBindingsBindingParserRuleCall_7_11_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBinding_in_ruleActorClass4774);
                    	    lv_bindings_27_0=ruleBinding();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"bindings",
                    	            		lv_bindings_27_0, 
                    	            		"Binding");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2492:3: ( (lv_connections_28_0= ruleLayerConnection ) )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==67) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2493:1: (lv_connections_28_0= ruleLayerConnection )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2493:1: (lv_connections_28_0= ruleLayerConnection )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2494:3: lv_connections_28_0= ruleLayerConnection
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getConnectionsLayerConnectionParserRuleCall_7_12_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleActorClass4796);
                    	    lv_connections_28_0=ruleLayerConnection();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"connections",
                    	            		lv_connections_28_0, 
                    	            		"LayerConnection");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop69;
                        }
                    } while (true);

                    otherlv_29=(Token)match(input,14,FOLLOW_14_in_ruleActorClass4809); 

                        	newLeafNode(otherlv_29, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_7_13());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2514:3: (otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==51) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2514:5: otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}'
                    {
                    otherlv_30=(Token)match(input,51,FOLLOW_51_in_ruleActorClass4824); 

                        	newLeafNode(otherlv_30, grammarAccess.getActorClassAccess().getBehaviorKeyword_8_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2518:1: ( (lv_behaviorDocu_31_0= ruleDocumentation ) )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==29) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2519:1: (lv_behaviorDocu_31_0= ruleDocumentation )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2519:1: (lv_behaviorDocu_31_0= ruleDocumentation )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2520:3: lv_behaviorDocu_31_0= ruleDocumentation
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getBehaviorDocuDocumentationParserRuleCall_8_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDocumentation_in_ruleActorClass4845);
                            lv_behaviorDocu_31_0=ruleDocumentation();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"behaviorDocu",
                                    		lv_behaviorDocu_31_0, 
                                    		"Documentation");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_32=(Token)match(input,13,FOLLOW_13_in_ruleActorClass4858); 

                        	newLeafNode(otherlv_32, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_8_2());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2540:1: ( (lv_annotations_33_0= ruleAnnotation ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==96) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2541:1: (lv_annotations_33_0= ruleAnnotation )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2541:1: (lv_annotations_33_0= ruleAnnotation )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2542:3: lv_annotations_33_0= ruleAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAnnotationsAnnotationParserRuleCall_8_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAnnotation_in_ruleActorClass4879);
                    	    lv_annotations_33_0=ruleAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"annotations",
                    	            		lv_annotations_33_0, 
                    	            		"Annotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2558:3: ( (lv_operations_34_0= ruleStandardOperation ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==32) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2559:1: (lv_operations_34_0= ruleStandardOperation )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2559:1: (lv_operations_34_0= ruleStandardOperation )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2560:3: lv_operations_34_0= ruleStandardOperation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getOperationsStandardOperationParserRuleCall_8_4_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleStandardOperation_in_ruleActorClass4901);
                    	    lv_operations_34_0=ruleStandardOperation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_34_0, 
                    	            		"StandardOperation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop73;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2576:3: ( (lv_stateMachine_35_0= ruleStateMachine ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( ((LA74_0>=71 && LA74_0<=72)) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2577:1: (lv_stateMachine_35_0= ruleStateMachine )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2577:1: (lv_stateMachine_35_0= ruleStateMachine )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2578:3: lv_stateMachine_35_0= ruleStateMachine
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getStateMachineStateMachineParserRuleCall_8_5_0()); 
                            	    
                            pushFollow(FOLLOW_ruleStateMachine_in_ruleActorClass4923);
                            lv_stateMachine_35_0=ruleStateMachine();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"stateMachine",
                                    		lv_stateMachine_35_0, 
                                    		"StateMachine");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_36=(Token)match(input,14,FOLLOW_14_in_ruleActorClass4936); 

                        	newLeafNode(otherlv_36, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_8_6());
                        

                    }
                    break;

            }

            otherlv_37=(Token)match(input,14,FOLLOW_14_in_ruleActorClass4950); 

                	newLeafNode(otherlv_37, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_9());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActorClass"


    // $ANTLR start "entryRulePort"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2612:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2613:2: (iv_rulePort= rulePort EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2614:2: iv_rulePort= rulePort EOF
            {
             newCompositeNode(grammarAccess.getPortRule()); 
            pushFollow(FOLLOW_rulePort_in_entryRulePort4988);
            iv_rulePort=rulePort();

            state._fsp--;

             current =iv_rulePort; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePort4998); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePort"


    // $ANTLR start "rulePort"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2621:1: rulePort returns [EObject current=null] : ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= RULE_MULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
    public final EObject rulePort() throws RecognitionException {
        EObject current = null;

        Token lv_conjugated_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_multiplicity_3_0=null;
        Token otherlv_4=null;
        EObject lv_docu_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2624:28: ( ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= RULE_MULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2625:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= RULE_MULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2625:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= RULE_MULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2625:2: ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= RULE_MULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2625:2: ( (lv_conjugated_0_0= 'conjugated' ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==52) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2626:1: (lv_conjugated_0_0= 'conjugated' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2626:1: (lv_conjugated_0_0= 'conjugated' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2627:3: lv_conjugated_0_0= 'conjugated'
                    {
                    lv_conjugated_0_0=(Token)match(input,52,FOLLOW_52_in_rulePort5041); 

                            newLeafNode(lv_conjugated_0_0, grammarAccess.getPortAccess().getConjugatedConjugatedKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortRule());
                    	        }
                           		setWithLastConsumed(current, "conjugated", true, "conjugated");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,53,FOLLOW_53_in_rulePort5067); 

                	newLeafNode(otherlv_1, grammarAccess.getPortAccess().getPortKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2644:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2645:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2645:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2646:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePort5084); 

            			newLeafNode(lv_name_2_0, grammarAccess.getPortAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPortRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2662:2: ( (lv_multiplicity_3_0= RULE_MULTIPLICITY ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_MULTIPLICITY) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2663:1: (lv_multiplicity_3_0= RULE_MULTIPLICITY )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2663:1: (lv_multiplicity_3_0= RULE_MULTIPLICITY )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2664:3: lv_multiplicity_3_0= RULE_MULTIPLICITY
                    {
                    lv_multiplicity_3_0=(Token)match(input,RULE_MULTIPLICITY,FOLLOW_RULE_MULTIPLICITY_in_rulePort5106); 

                    			newLeafNode(lv_multiplicity_3_0, grammarAccess.getPortAccess().getMultiplicityMULTIPLICITYTerminalRuleCall_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_3_0, 
                            		"MULTIPLICITY");
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_rulePort5124); 

                	newLeafNode(otherlv_4, grammarAccess.getPortAccess().getColonKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2684:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2685:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2685:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2686:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPortRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPortAccess().getProtocolProtocolClassCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_rulePort5147);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2699:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==29) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2700:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2700:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2701:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_rulePort5168);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_6_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePort"


    // $ANTLR start "entryRuleExternalPort"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2725:1: entryRuleExternalPort returns [EObject current=null] : iv_ruleExternalPort= ruleExternalPort EOF ;
    public final EObject entryRuleExternalPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalPort = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2726:2: (iv_ruleExternalPort= ruleExternalPort EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2727:2: iv_ruleExternalPort= ruleExternalPort EOF
            {
             newCompositeNode(grammarAccess.getExternalPortRule()); 
            pushFollow(FOLLOW_ruleExternalPort_in_entryRuleExternalPort5205);
            iv_ruleExternalPort=ruleExternalPort();

            state._fsp--;

             current =iv_ruleExternalPort; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalPort5215); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalPort"


    // $ANTLR start "ruleExternalPort"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2734:1: ruleExternalPort returns [EObject current=null] : (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleExternalPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2737:28: ( (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2738:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2738:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2738:3: otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_54_in_ruleExternalPort5252); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalPortAccess().getExternalKeyword_0());
                
            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleExternalPort5264); 

                	newLeafNode(otherlv_1, grammarAccess.getExternalPortAccess().getPortKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2746:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2747:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2747:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2748:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getExternalPortRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalPort5284); 

            		newLeafNode(otherlv_2, grammarAccess.getExternalPortAccess().getIfportPortCrossReference_2_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalPort"


    // $ANTLR start "entryRuleSAPRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2767:1: entryRuleSAPRef returns [EObject current=null] : iv_ruleSAPRef= ruleSAPRef EOF ;
    public final EObject entryRuleSAPRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2768:2: (iv_ruleSAPRef= ruleSAPRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2769:2: iv_ruleSAPRef= ruleSAPRef EOF
            {
             newCompositeNode(grammarAccess.getSAPRefRule()); 
            pushFollow(FOLLOW_ruleSAPRef_in_entryRuleSAPRef5320);
            iv_ruleSAPRef=ruleSAPRef();

            state._fsp--;

             current =iv_ruleSAPRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSAPRef5330); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSAPRef"


    // $ANTLR start "ruleSAPRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2776:1: ruleSAPRef returns [EObject current=null] : (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSAPRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2779:28: ( (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2780:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2780:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2780:3: otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_55_in_ruleSAPRef5367); 

                	newLeafNode(otherlv_0, grammarAccess.getSAPRefAccess().getSAPKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2784:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2785:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2785:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2786:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSAPRef5384); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSAPRefAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSAPRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleSAPRef5401); 

                	newLeafNode(otherlv_2, grammarAccess.getSAPRefAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2806:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2807:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2807:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2808:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSAPRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSAPRefAccess().getProtocolProtocolClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSAPRef5424);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSAPRef"


    // $ANTLR start "entryRuleSPPRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2829:1: entryRuleSPPRef returns [EObject current=null] : iv_ruleSPPRef= ruleSPPRef EOF ;
    public final EObject entryRuleSPPRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2830:2: (iv_ruleSPPRef= ruleSPPRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2831:2: iv_ruleSPPRef= ruleSPPRef EOF
            {
             newCompositeNode(grammarAccess.getSPPRefRule()); 
            pushFollow(FOLLOW_ruleSPPRef_in_entryRuleSPPRef5460);
            iv_ruleSPPRef=ruleSPPRef();

            state._fsp--;

             current =iv_ruleSPPRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSPPRef5470); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSPPRef"


    // $ANTLR start "ruleSPPRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2838:1: ruleSPPRef returns [EObject current=null] : (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSPPRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2841:28: ( (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2842:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2842:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2842:3: otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleSPPRef5507); 

                	newLeafNode(otherlv_0, grammarAccess.getSPPRefAccess().getSPPKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2846:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2847:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2847:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2848:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPRef5524); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSPPRefAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleSPPRef5541); 

                	newLeafNode(otherlv_2, grammarAccess.getSPPRefAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2868:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2869:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2869:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2870:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSPPRefAccess().getProtocolProtocolClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSPPRef5564);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSPPRef"


    // $ANTLR start "entryRuleServiceImplementation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2891:1: entryRuleServiceImplementation returns [EObject current=null] : iv_ruleServiceImplementation= ruleServiceImplementation EOF ;
    public final EObject entryRuleServiceImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceImplementation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2892:2: (iv_ruleServiceImplementation= ruleServiceImplementation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2893:2: iv_ruleServiceImplementation= ruleServiceImplementation EOF
            {
             newCompositeNode(grammarAccess.getServiceImplementationRule()); 
            pushFollow(FOLLOW_ruleServiceImplementation_in_entryRuleServiceImplementation5600);
            iv_ruleServiceImplementation=ruleServiceImplementation();

            state._fsp--;

             current =iv_ruleServiceImplementation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleServiceImplementation5610); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceImplementation"


    // $ANTLR start "ruleServiceImplementation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2900:1: ruleServiceImplementation returns [EObject current=null] : (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleServiceImplementation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2903:28: ( (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2904:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2904:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2904:3: otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,57,FOLLOW_57_in_ruleServiceImplementation5647); 

                	newLeafNode(otherlv_0, grammarAccess.getServiceImplementationAccess().getServiceImplementationKeyword_0());
                
            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleServiceImplementation5659); 

                	newLeafNode(otherlv_1, grammarAccess.getServiceImplementationAccess().getOfKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2912:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2913:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2913:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2914:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getServiceImplementationRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleServiceImplementation5679); 

            		newLeafNode(otherlv_2, grammarAccess.getServiceImplementationAccess().getSppSPPRefCrossReference_2_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceImplementation"


    // $ANTLR start "entryRuleLogicalSystem"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2933:1: entryRuleLogicalSystem returns [EObject current=null] : iv_ruleLogicalSystem= ruleLogicalSystem EOF ;
    public final EObject entryRuleLogicalSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalSystem = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2934:2: (iv_ruleLogicalSystem= ruleLogicalSystem EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2935:2: iv_ruleLogicalSystem= ruleLogicalSystem EOF
            {
             newCompositeNode(grammarAccess.getLogicalSystemRule()); 
            pushFollow(FOLLOW_ruleLogicalSystem_in_entryRuleLogicalSystem5715);
            iv_ruleLogicalSystem=ruleLogicalSystem();

            state._fsp--;

             current =iv_ruleLogicalSystem; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalSystem5725); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalSystem"


    // $ANTLR start "ruleLogicalSystem"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2942:1: ruleLogicalSystem returns [EObject current=null] : (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )* ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* otherlv_7= '}' ) ;
    public final EObject ruleLogicalSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_docu_2_0 = null;

        EObject lv_subSystems_4_0 = null;

        EObject lv_bindings_5_0 = null;

        EObject lv_connections_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2945:28: ( (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )* ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* otherlv_7= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2946:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )* ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* otherlv_7= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2946:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )* ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* otherlv_7= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2946:3: otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )* ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleLogicalSystem5762); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalSystemAccess().getLogicalSystemKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2950:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2951:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2951:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2952:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLogicalSystem5779); 

            			newLeafNode(lv_name_1_0, grammarAccess.getLogicalSystemAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLogicalSystemRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2968:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==29) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2969:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2969:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2970:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleLogicalSystem5805);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_2_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleLogicalSystem5818); 

                	newLeafNode(otherlv_3, grammarAccess.getLogicalSystemAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2990:1: ( (lv_subSystems_4_0= ruleSubSystemRef ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==60) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2991:1: (lv_subSystems_4_0= ruleSubSystemRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2991:1: (lv_subSystems_4_0= ruleSubSystemRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2992:3: lv_subSystems_4_0= ruleSubSystemRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getSubSystemsSubSystemRefParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubSystemRef_in_ruleLogicalSystem5839);
            	    lv_subSystems_4_0=ruleSubSystemRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subSystems",
            	            		lv_subSystems_4_0, 
            	            		"SubSystemRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3008:3: ( (lv_bindings_5_0= ruleBinding ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==65) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3009:1: (lv_bindings_5_0= ruleBinding )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3009:1: (lv_bindings_5_0= ruleBinding )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3010:3: lv_bindings_5_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getBindingsBindingParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleBinding_in_ruleLogicalSystem5861);
            	    lv_bindings_5_0=ruleBinding();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bindings",
            	            		lv_bindings_5_0, 
            	            		"Binding");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3026:3: ( (lv_connections_6_0= ruleLayerConnection ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==67) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3027:1: (lv_connections_6_0= ruleLayerConnection )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3027:1: (lv_connections_6_0= ruleLayerConnection )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3028:3: lv_connections_6_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getConnectionsLayerConnectionParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleLogicalSystem5883);
            	    lv_connections_6_0=ruleLayerConnection();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connections",
            	            		lv_connections_6_0, 
            	            		"LayerConnection");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleLogicalSystem5896); 

                	newLeafNode(otherlv_7, grammarAccess.getLogicalSystemAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalSystem"


    // $ANTLR start "entryRuleSubSystemRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3058:1: entryRuleSubSystemRef returns [EObject current=null] : iv_ruleSubSystemRef= ruleSubSystemRef EOF ;
    public final EObject entryRuleSubSystemRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3059:2: (iv_ruleSubSystemRef= ruleSubSystemRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3060:2: iv_ruleSubSystemRef= ruleSubSystemRef EOF
            {
             newCompositeNode(grammarAccess.getSubSystemRefRule()); 
            pushFollow(FOLLOW_ruleSubSystemRef_in_entryRuleSubSystemRef5934);
            iv_ruleSubSystemRef=ruleSubSystemRef();

            state._fsp--;

             current =iv_ruleSubSystemRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemRef5944); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubSystemRef"


    // $ANTLR start "ruleSubSystemRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3067:1: ruleSubSystemRef returns [EObject current=null] : (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSubSystemRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3070:28: ( (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3071:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3071:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3071:3: otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleSubSystemRef5981); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemRefAccess().getSubSystemRefKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3075:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3076:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3076:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3077:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemRef5998); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSubSystemRefAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleSubSystemRef6015); 

                	newLeafNode(otherlv_2, grammarAccess.getSubSystemRefAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3097:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3098:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3098:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3099:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSubSystemRefAccess().getTypeSubSystemClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSubSystemRef6038);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3112:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==29) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3113:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3113:1: (lv_docu_4_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3114:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemRefAccess().getDocuDocumentationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleSubSystemRef6059);
                    lv_docu_4_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemRefRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_4_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubSystemRef"


    // $ANTLR start "entryRuleSubSystemClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3138:1: entryRuleSubSystemClass returns [EObject current=null] : iv_ruleSubSystemClass= ruleSubSystemClass EOF ;
    public final EObject entryRuleSubSystemClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3139:2: (iv_ruleSubSystemClass= ruleSubSystemClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3140:2: iv_ruleSubSystemClass= ruleSubSystemClass EOF
            {
             newCompositeNode(grammarAccess.getSubSystemClassRule()); 
            pushFollow(FOLLOW_ruleSubSystemClass_in_entryRuleSubSystemClass6096);
            iv_ruleSubSystemClass=ruleSubSystemClass();

            state._fsp--;

             current =iv_ruleSubSystemClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemClass6106); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubSystemClass"


    // $ANTLR start "ruleSubSystemClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3147:1: ruleSubSystemClass returns [EObject current=null] : (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? (otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) ) )? ( (lv_relayPorts_10_0= rulePort ) )* ( (lv_ifSPPs_11_0= ruleSPPRef ) )* ( (lv_actorRefs_12_0= ruleActorRef ) )* ( (lv_bindings_13_0= ruleBinding ) )* ( (lv_connections_14_0= ruleLayerConnection ) )* ( (lv_threads_15_0= ruleLogicalThread ) )* otherlv_16= '}' ) ;
    public final EObject ruleSubSystemClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_16=null;
        EObject lv_docu_2_0 = null;

        EObject lv_userCode1_5_0 = null;

        EObject lv_userCode2_7_0 = null;

        EObject lv_userCode3_9_0 = null;

        EObject lv_relayPorts_10_0 = null;

        EObject lv_ifSPPs_11_0 = null;

        EObject lv_actorRefs_12_0 = null;

        EObject lv_bindings_13_0 = null;

        EObject lv_connections_14_0 = null;

        EObject lv_threads_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3150:28: ( (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? (otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) ) )? ( (lv_relayPorts_10_0= rulePort ) )* ( (lv_ifSPPs_11_0= ruleSPPRef ) )* ( (lv_actorRefs_12_0= ruleActorRef ) )* ( (lv_bindings_13_0= ruleBinding ) )* ( (lv_connections_14_0= ruleLayerConnection ) )* ( (lv_threads_15_0= ruleLogicalThread ) )* otherlv_16= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3151:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? (otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) ) )? ( (lv_relayPorts_10_0= rulePort ) )* ( (lv_ifSPPs_11_0= ruleSPPRef ) )* ( (lv_actorRefs_12_0= ruleActorRef ) )* ( (lv_bindings_13_0= ruleBinding ) )* ( (lv_connections_14_0= ruleLayerConnection ) )* ( (lv_threads_15_0= ruleLogicalThread ) )* otherlv_16= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3151:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? (otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) ) )? ( (lv_relayPorts_10_0= rulePort ) )* ( (lv_ifSPPs_11_0= ruleSPPRef ) )* ( (lv_actorRefs_12_0= ruleActorRef ) )* ( (lv_bindings_13_0= ruleBinding ) )* ( (lv_connections_14_0= ruleLayerConnection ) )* ( (lv_threads_15_0= ruleLogicalThread ) )* otherlv_16= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3151:3: otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? (otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) ) )? ( (lv_relayPorts_10_0= rulePort ) )* ( (lv_ifSPPs_11_0= ruleSPPRef ) )* ( (lv_actorRefs_12_0= ruleActorRef ) )* ( (lv_bindings_13_0= ruleBinding ) )* ( (lv_connections_14_0= ruleLayerConnection ) )* ( (lv_threads_15_0= ruleLogicalThread ) )* otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_61_in_ruleSubSystemClass6143); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemClassAccess().getSubSystemClassKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3155:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3156:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3156:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3157:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemClass6160); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSubSystemClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3173:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==29) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3174:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3174:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3175:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleSubSystemClass6186);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_2_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleSubSystemClass6199); 

                	newLeafNode(otherlv_3, grammarAccess.getSubSystemClassAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3195:1: (otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==25) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3195:3: otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) )
                    {
                    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleSubSystemClass6212); 

                        	newLeafNode(otherlv_4, grammarAccess.getSubSystemClassAccess().getUsercode1Keyword_4_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3199:1: ( (lv_userCode1_5_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3200:1: (lv_userCode1_5_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3200:1: (lv_userCode1_5_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3201:3: lv_userCode1_5_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode1DetailCodeParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleSubSystemClass6233);
                    lv_userCode1_5_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode1",
                            		lv_userCode1_5_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3217:4: (otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==26) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3217:6: otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) )
                    {
                    otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleSubSystemClass6248); 

                        	newLeafNode(otherlv_6, grammarAccess.getSubSystemClassAccess().getUsercode2Keyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3221:1: ( (lv_userCode2_7_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3222:1: (lv_userCode2_7_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3222:1: (lv_userCode2_7_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3223:3: lv_userCode2_7_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode2DetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleSubSystemClass6269);
                    lv_userCode2_7_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode2",
                            		lv_userCode2_7_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3239:4: (otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==27) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3239:6: otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,27,FOLLOW_27_in_ruleSubSystemClass6284); 

                        	newLeafNode(otherlv_8, grammarAccess.getSubSystemClassAccess().getUsercode3Keyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3243:1: ( (lv_userCode3_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3244:1: (lv_userCode3_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3244:1: (lv_userCode3_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3245:3: lv_userCode3_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode3DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleSubSystemClass6305);
                    lv_userCode3_9_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode3",
                            		lv_userCode3_9_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3261:4: ( (lv_relayPorts_10_0= rulePort ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( ((LA88_0>=52 && LA88_0<=53)) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3262:1: (lv_relayPorts_10_0= rulePort )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3262:1: (lv_relayPorts_10_0= rulePort )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3263:3: lv_relayPorts_10_0= rulePort
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getRelayPortsPortParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePort_in_ruleSubSystemClass6328);
            	    lv_relayPorts_10_0=rulePort();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"relayPorts",
            	            		lv_relayPorts_10_0, 
            	            		"Port");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3279:3: ( (lv_ifSPPs_11_0= ruleSPPRef ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==56) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3280:1: (lv_ifSPPs_11_0= ruleSPPRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3280:1: (lv_ifSPPs_11_0= ruleSPPRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3281:3: lv_ifSPPs_11_0= ruleSPPRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getIfSPPsSPPRefParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSPPRef_in_ruleSubSystemClass6350);
            	    lv_ifSPPs_11_0=ruleSPPRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ifSPPs",
            	            		lv_ifSPPs_11_0, 
            	            		"SPPRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3297:3: ( (lv_actorRefs_12_0= ruleActorRef ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==70) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3298:1: (lv_actorRefs_12_0= ruleActorRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3298:1: (lv_actorRefs_12_0= ruleActorRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3299:3: lv_actorRefs_12_0= ruleActorRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getActorRefsActorRefParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorRef_in_ruleSubSystemClass6372);
            	    lv_actorRefs_12_0=ruleActorRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"actorRefs",
            	            		lv_actorRefs_12_0, 
            	            		"ActorRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3315:3: ( (lv_bindings_13_0= ruleBinding ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==65) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3316:1: (lv_bindings_13_0= ruleBinding )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3316:1: (lv_bindings_13_0= ruleBinding )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3317:3: lv_bindings_13_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getBindingsBindingParserRuleCall_10_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleBinding_in_ruleSubSystemClass6394);
            	    lv_bindings_13_0=ruleBinding();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bindings",
            	            		lv_bindings_13_0, 
            	            		"Binding");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3333:3: ( (lv_connections_14_0= ruleLayerConnection ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==67) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3334:1: (lv_connections_14_0= ruleLayerConnection )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3334:1: (lv_connections_14_0= ruleLayerConnection )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3335:3: lv_connections_14_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getConnectionsLayerConnectionParserRuleCall_11_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleSubSystemClass6416);
            	    lv_connections_14_0=ruleLayerConnection();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connections",
            	            		lv_connections_14_0, 
            	            		"LayerConnection");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3351:3: ( (lv_threads_15_0= ruleLogicalThread ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==62) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3352:1: (lv_threads_15_0= ruleLogicalThread )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3352:1: (lv_threads_15_0= ruleLogicalThread )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3353:3: lv_threads_15_0= ruleLogicalThread
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getThreadsLogicalThreadParserRuleCall_12_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLogicalThread_in_ruleSubSystemClass6438);
            	    lv_threads_15_0=ruleLogicalThread();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"threads",
            	            		lv_threads_15_0, 
            	            		"LogicalThread");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

            otherlv_16=(Token)match(input,14,FOLLOW_14_in_ruleSubSystemClass6451); 

                	newLeafNode(otherlv_16, grammarAccess.getSubSystemClassAccess().getRightCurlyBracketKeyword_13());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubSystemClass"


    // $ANTLR start "entryRuleLogicalThread"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3381:1: entryRuleLogicalThread returns [EObject current=null] : iv_ruleLogicalThread= ruleLogicalThread EOF ;
    public final EObject entryRuleLogicalThread() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalThread = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3382:2: (iv_ruleLogicalThread= ruleLogicalThread EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3383:2: iv_ruleLogicalThread= ruleLogicalThread EOF
            {
             newCompositeNode(grammarAccess.getLogicalThreadRule()); 
            pushFollow(FOLLOW_ruleLogicalThread_in_entryRuleLogicalThread6487);
            iv_ruleLogicalThread=ruleLogicalThread();

            state._fsp--;

             current =iv_ruleLogicalThread; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalThread6497); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalThread"


    // $ANTLR start "ruleLogicalThread"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3390:1: ruleLogicalThread returns [EObject current=null] : (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}' ) ;
    public final EObject ruleLogicalThread() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_prio_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_instances_6_0 = null;

        EObject lv_instances_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3393:28: ( (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3394:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3394:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3394:3: otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_62_in_ruleLogicalThread6534); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalThreadAccess().getLogicalThreadKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3398:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3399:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3399:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3400:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLogicalThread6551); 

            			newLeafNode(lv_name_1_0, grammarAccess.getLogicalThreadAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLogicalThreadRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,63,FOLLOW_63_in_ruleLogicalThread6568); 

                	newLeafNode(otherlv_2, grammarAccess.getLogicalThreadAccess().getPrioKeyword_2());
                
            otherlv_3=(Token)match(input,31,FOLLOW_31_in_ruleLogicalThread6580); 

                	newLeafNode(otherlv_3, grammarAccess.getLogicalThreadAccess().getEqualsSignKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3424:1: ( (lv_prio_4_0= RULE_INT ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3425:1: (lv_prio_4_0= RULE_INT )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3425:1: (lv_prio_4_0= RULE_INT )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3426:3: lv_prio_4_0= RULE_INT
            {
            lv_prio_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLogicalThread6597); 

            			newLeafNode(lv_prio_4_0, grammarAccess.getLogicalThreadAccess().getPrioINTTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLogicalThreadRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"prio",
                    		lv_prio_4_0, 
                    		"INT");
            	    

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleLogicalThread6614); 

                	newLeafNode(otherlv_5, grammarAccess.getLogicalThreadAccess().getLeftCurlyBracketKeyword_5());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3446:1: ( (lv_instances_6_0= ruleActorInstancePath ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3447:1: (lv_instances_6_0= ruleActorInstancePath )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3447:1: (lv_instances_6_0= ruleActorInstancePath )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3448:3: lv_instances_6_0= ruleActorInstancePath
            {
             
            	        newCompositeNode(grammarAccess.getLogicalThreadAccess().getInstancesActorInstancePathParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleActorInstancePath_in_ruleLogicalThread6635);
            lv_instances_6_0=ruleActorInstancePath();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLogicalThreadRule());
            	        }
                   		add(
                   			current, 
                   			"instances",
                    		lv_instances_6_0, 
                    		"ActorInstancePath");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3464:2: (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==33) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3464:4: otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) )
            	    {
            	    otherlv_7=(Token)match(input,33,FOLLOW_33_in_ruleLogicalThread6648); 

            	        	newLeafNode(otherlv_7, grammarAccess.getLogicalThreadAccess().getCommaKeyword_7_0());
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3468:1: ( (lv_instances_8_0= ruleActorInstancePath ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3469:1: (lv_instances_8_0= ruleActorInstancePath )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3469:1: (lv_instances_8_0= ruleActorInstancePath )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3470:3: lv_instances_8_0= ruleActorInstancePath
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalThreadAccess().getInstancesActorInstancePathParserRuleCall_7_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorInstancePath_in_ruleLogicalThread6669);
            	    lv_instances_8_0=ruleActorInstancePath();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalThreadRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instances",
            	            		lv_instances_8_0, 
            	            		"ActorInstancePath");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);

            otherlv_9=(Token)match(input,14,FOLLOW_14_in_ruleLogicalThread6683); 

                	newLeafNode(otherlv_9, grammarAccess.getLogicalThreadAccess().getRightCurlyBracketKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalThread"


    // $ANTLR start "entryRuleActorInstancePath"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3498:1: entryRuleActorInstancePath returns [EObject current=null] : iv_ruleActorInstancePath= ruleActorInstancePath EOF ;
    public final EObject entryRuleActorInstancePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstancePath = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3499:2: (iv_ruleActorInstancePath= ruleActorInstancePath EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3500:2: iv_ruleActorInstancePath= ruleActorInstancePath EOF
            {
             newCompositeNode(grammarAccess.getActorInstancePathRule()); 
            pushFollow(FOLLOW_ruleActorInstancePath_in_entryRuleActorInstancePath6719);
            iv_ruleActorInstancePath=ruleActorInstancePath();

            state._fsp--;

             current =iv_ruleActorInstancePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorInstancePath6729); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActorInstancePath"


    // $ANTLR start "ruleActorInstancePath"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3507:1: ruleActorInstancePath returns [EObject current=null] : ( ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )* ) ;
    public final EObject ruleActorInstancePath() throws RecognitionException {
        EObject current = null;

        Token lv_segments_0_0=null;
        Token otherlv_1=null;
        Token lv_segments_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3510:28: ( ( ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3511:1: ( ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3511:1: ( ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )* )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3511:2: ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )*
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3511:2: ( (lv_segments_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3512:1: (lv_segments_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3512:1: (lv_segments_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3513:3: lv_segments_0_0= RULE_ID
            {
            lv_segments_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorInstancePath6771); 

            			newLeafNode(lv_segments_0_0, grammarAccess.getActorInstancePathAccess().getSegmentsIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getActorInstancePathRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"segments",
                    		lv_segments_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3529:2: (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==64) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3529:4: otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,64,FOLLOW_64_in_ruleActorInstancePath6789); 

            	        	newLeafNode(otherlv_1, grammarAccess.getActorInstancePathAccess().getFullStopKeyword_1_0());
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3533:1: ( (lv_segments_2_0= RULE_ID ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3534:1: (lv_segments_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3534:1: (lv_segments_2_0= RULE_ID )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3535:3: lv_segments_2_0= RULE_ID
            	    {
            	    lv_segments_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorInstancePath6806); 

            	    			newLeafNode(lv_segments_2_0, grammarAccess.getActorInstancePathAccess().getSegmentsIDTerminalRuleCall_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getActorInstancePathRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"segments",
            	            		lv_segments_2_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActorInstancePath"


    // $ANTLR start "entryRuleBinding"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3559:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3560:2: (iv_ruleBinding= ruleBinding EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3561:2: iv_ruleBinding= ruleBinding EOF
            {
             newCompositeNode(grammarAccess.getBindingRule()); 
            pushFollow(FOLLOW_ruleBinding_in_entryRuleBinding6849);
            iv_ruleBinding=ruleBinding();

            state._fsp--;

             current =iv_ruleBinding; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBinding6859); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinding"


    // $ANTLR start "ruleBinding"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3568:1: ruleBinding returns [EObject current=null] : (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_endpoint1_1_0 = null;

        EObject lv_endpoint2_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3571:28: ( (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3572:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3572:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3572:3: otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            {
            otherlv_0=(Token)match(input,65,FOLLOW_65_in_ruleBinding6896); 

                	newLeafNode(otherlv_0, grammarAccess.getBindingAccess().getBindingKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3576:1: ( (lv_endpoint1_1_0= ruleBindingEndPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3577:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3577:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3578:3: lv_endpoint1_1_0= ruleBindingEndPoint
            {
             
            	        newCompositeNode(grammarAccess.getBindingAccess().getEndpoint1BindingEndPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBindingEndPoint_in_ruleBinding6917);
            lv_endpoint1_1_0=ruleBindingEndPoint();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBindingRule());
            	        }
                   		set(
                   			current, 
                   			"endpoint1",
                    		lv_endpoint1_1_0, 
                    		"BindingEndPoint");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,66,FOLLOW_66_in_ruleBinding6929); 

                	newLeafNode(otherlv_2, grammarAccess.getBindingAccess().getAndKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3598:1: ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3599:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3599:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3600:3: lv_endpoint2_3_0= ruleBindingEndPoint
            {
             
            	        newCompositeNode(grammarAccess.getBindingAccess().getEndpoint2BindingEndPointParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleBindingEndPoint_in_ruleBinding6950);
            lv_endpoint2_3_0=ruleBindingEndPoint();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBindingRule());
            	        }
                   		set(
                   			current, 
                   			"endpoint2",
                    		lv_endpoint2_3_0, 
                    		"BindingEndPoint");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinding"


    // $ANTLR start "entryRuleBindingEndPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3624:1: entryRuleBindingEndPoint returns [EObject current=null] : iv_ruleBindingEndPoint= ruleBindingEndPoint EOF ;
    public final EObject entryRuleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingEndPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3625:2: (iv_ruleBindingEndPoint= ruleBindingEndPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3626:2: iv_ruleBindingEndPoint= ruleBindingEndPoint EOF
            {
             newCompositeNode(grammarAccess.getBindingEndPointRule()); 
            pushFollow(FOLLOW_ruleBindingEndPoint_in_entryRuleBindingEndPoint6986);
            iv_ruleBindingEndPoint=ruleBindingEndPoint();

            state._fsp--;

             current =iv_ruleBindingEndPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBindingEndPoint6996); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBindingEndPoint"


    // $ANTLR start "ruleBindingEndPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3633:1: ruleBindingEndPoint returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3636:28: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3637:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3637:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3637:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3637:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==RULE_ID) ) {
                int LA96_1 = input.LA(2);

                if ( (LA96_1==64) ) {
                    alt96=1;
                }
            }
            switch (alt96) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3637:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3637:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3638:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3638:1: (otherlv_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3639:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBindingEndPointRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBindingEndPoint7042); 

                    		newLeafNode(otherlv_0, grammarAccess.getBindingEndPointAccess().getActorRefActorContainerRefCrossReference_0_0_0()); 
                    	

                    }


                    }

                    otherlv_1=(Token)match(input,64,FOLLOW_64_in_ruleBindingEndPoint7054); 

                        	newLeafNode(otherlv_1, grammarAccess.getBindingEndPointAccess().getFullStopKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3654:3: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3655:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3655:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3656:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBindingEndPointRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBindingEndPoint7076); 

            		newLeafNode(otherlv_2, grammarAccess.getBindingEndPointAccess().getPortPortCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBindingEndPoint"


    // $ANTLR start "entryRuleLayerConnection"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3675:1: entryRuleLayerConnection returns [EObject current=null] : iv_ruleLayerConnection= ruleLayerConnection EOF ;
    public final EObject entryRuleLayerConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerConnection = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3676:2: (iv_ruleLayerConnection= ruleLayerConnection EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3677:2: iv_ruleLayerConnection= ruleLayerConnection EOF
            {
             newCompositeNode(grammarAccess.getLayerConnectionRule()); 
            pushFollow(FOLLOW_ruleLayerConnection_in_entryRuleLayerConnection7112);
            iv_ruleLayerConnection=ruleLayerConnection();

            state._fsp--;

             current =iv_ruleLayerConnection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLayerConnection7122); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLayerConnection"


    // $ANTLR start "ruleLayerConnection"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3684:1: ruleLayerConnection returns [EObject current=null] : (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) ;
    public final EObject ruleLayerConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_from_1_0 = null;

        EObject lv_to_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3687:28: ( (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3688:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3688:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3688:3: otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_67_in_ruleLayerConnection7159); 

                	newLeafNode(otherlv_0, grammarAccess.getLayerConnectionAccess().getLayerConnectionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3692:1: ( (lv_from_1_0= ruleSAPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3693:1: (lv_from_1_0= ruleSAPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3693:1: (lv_from_1_0= ruleSAPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3694:3: lv_from_1_0= ruleSAPoint
            {
             
            	        newCompositeNode(grammarAccess.getLayerConnectionAccess().getFromSAPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSAPoint_in_ruleLayerConnection7180);
            lv_from_1_0=ruleSAPoint();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLayerConnectionRule());
            	        }
                   		set(
                   			current, 
                   			"from",
                    		lv_from_1_0, 
                    		"SAPoint");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_68_in_ruleLayerConnection7192); 

                	newLeafNode(otherlv_2, grammarAccess.getLayerConnectionAccess().getSatisfied_byKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3714:1: ( (lv_to_3_0= ruleSPPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3715:1: (lv_to_3_0= ruleSPPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3715:1: (lv_to_3_0= ruleSPPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3716:3: lv_to_3_0= ruleSPPoint
            {
             
            	        newCompositeNode(grammarAccess.getLayerConnectionAccess().getToSPPointParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleSPPoint_in_ruleLayerConnection7213);
            lv_to_3_0=ruleSPPoint();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLayerConnectionRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_3_0, 
                    		"SPPoint");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLayerConnection"


    // $ANTLR start "entryRuleSAPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3740:1: entryRuleSAPoint returns [EObject current=null] : iv_ruleSAPoint= ruleSAPoint EOF ;
    public final EObject entryRuleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3741:2: (iv_ruleSAPoint= ruleSAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3742:2: iv_ruleSAPoint= ruleSAPoint EOF
            {
             newCompositeNode(grammarAccess.getSAPointRule()); 
            pushFollow(FOLLOW_ruleSAPoint_in_entryRuleSAPoint7249);
            iv_ruleSAPoint=ruleSAPoint();

            state._fsp--;

             current =iv_ruleSAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSAPoint7259); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSAPoint"


    // $ANTLR start "ruleSAPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3749:1: ruleSAPoint returns [EObject current=null] : (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) ;
    public final EObject ruleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject this_RefSAPoint_0 = null;

        EObject this_RelaySAPoint_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3752:28: ( (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3753:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3753:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==16) ) {
                alt97=1;
            }
            else if ( (LA97_0==69) ) {
                alt97=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3754:5: this_RefSAPoint_0= ruleRefSAPoint
                    {
                     
                            newCompositeNode(grammarAccess.getSAPointAccess().getRefSAPointParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRefSAPoint_in_ruleSAPoint7306);
                    this_RefSAPoint_0=ruleRefSAPoint();

                    state._fsp--;

                     
                            current = this_RefSAPoint_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3764:5: this_RelaySAPoint_1= ruleRelaySAPoint
                    {
                     
                            newCompositeNode(grammarAccess.getSAPointAccess().getRelaySAPointParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRelaySAPoint_in_ruleSAPoint7333);
                    this_RelaySAPoint_1=ruleRelaySAPoint();

                    state._fsp--;

                     
                            current = this_RelaySAPoint_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSAPoint"


    // $ANTLR start "entryRuleRefSAPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3780:1: entryRuleRefSAPoint returns [EObject current=null] : iv_ruleRefSAPoint= ruleRefSAPoint EOF ;
    public final EObject entryRuleRefSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3781:2: (iv_ruleRefSAPoint= ruleRefSAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3782:2: iv_ruleRefSAPoint= ruleRefSAPoint EOF
            {
             newCompositeNode(grammarAccess.getRefSAPointRule()); 
            pushFollow(FOLLOW_ruleRefSAPoint_in_entryRuleRefSAPoint7368);
            iv_ruleRefSAPoint=ruleRefSAPoint();

            state._fsp--;

             current =iv_ruleRefSAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefSAPoint7378); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefSAPoint"


    // $ANTLR start "ruleRefSAPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3789:1: ruleRefSAPoint returns [EObject current=null] : (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRefSAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3792:28: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3793:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3793:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3793:3: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleRefSAPoint7415); 

                	newLeafNode(otherlv_0, grammarAccess.getRefSAPointAccess().getRefKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3797:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3798:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3798:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3799:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefSAPointRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefSAPoint7435); 

            		newLeafNode(otherlv_1, grammarAccess.getRefSAPointAccess().getRefActorContainerRefCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefSAPoint"


    // $ANTLR start "entryRuleRelaySAPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3818:1: entryRuleRelaySAPoint returns [EObject current=null] : iv_ruleRelaySAPoint= ruleRelaySAPoint EOF ;
    public final EObject entryRuleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelaySAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3819:2: (iv_ruleRelaySAPoint= ruleRelaySAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3820:2: iv_ruleRelaySAPoint= ruleRelaySAPoint EOF
            {
             newCompositeNode(grammarAccess.getRelaySAPointRule()); 
            pushFollow(FOLLOW_ruleRelaySAPoint_in_entryRuleRelaySAPoint7471);
            iv_ruleRelaySAPoint=ruleRelaySAPoint();

            state._fsp--;

             current =iv_ruleRelaySAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelaySAPoint7481); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelaySAPoint"


    // $ANTLR start "ruleRelaySAPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3827:1: ruleRelaySAPoint returns [EObject current=null] : (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3830:28: ( (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3831:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3831:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3831:3: otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,69,FOLLOW_69_in_ruleRelaySAPoint7518); 

                	newLeafNode(otherlv_0, grammarAccess.getRelaySAPointAccess().getRelay_sapKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3835:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3836:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3836:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3837:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRelaySAPointRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRelaySAPoint7538); 

            		newLeafNode(otherlv_1, grammarAccess.getRelaySAPointAccess().getRelaySPPRefCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelaySAPoint"


    // $ANTLR start "entryRuleSPPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3856:1: entryRuleSPPoint returns [EObject current=null] : iv_ruleSPPoint= ruleSPPoint EOF ;
    public final EObject entryRuleSPPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3857:2: (iv_ruleSPPoint= ruleSPPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3858:2: iv_ruleSPPoint= ruleSPPoint EOF
            {
             newCompositeNode(grammarAccess.getSPPointRule()); 
            pushFollow(FOLLOW_ruleSPPoint_in_entryRuleSPPoint7574);
            iv_ruleSPPoint=ruleSPPoint();

            state._fsp--;

             current =iv_ruleSPPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSPPoint7584); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSPPoint"


    // $ANTLR start "ruleSPPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3865:1: ruleSPPoint returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSPPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3868:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3869:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3869:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3869:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3869:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3870:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3870:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3871:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPointRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPoint7629); 

            		newLeafNode(otherlv_0, grammarAccess.getSPPointAccess().getRefActorContainerRefCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,64,FOLLOW_64_in_ruleSPPoint7641); 

                	newLeafNode(otherlv_1, grammarAccess.getSPPointAccess().getFullStopKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3886:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3887:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3887:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3888:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPointRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPoint7661); 

            		newLeafNode(otherlv_2, grammarAccess.getSPPointAccess().getServiceSPPRefCrossReference_2_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSPPoint"


    // $ANTLR start "entryRuleActorRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3907:1: entryRuleActorRef returns [EObject current=null] : iv_ruleActorRef= ruleActorRef EOF ;
    public final EObject entryRuleActorRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3908:2: (iv_ruleActorRef= ruleActorRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3909:2: iv_ruleActorRef= ruleActorRef EOF
            {
             newCompositeNode(grammarAccess.getActorRefRule()); 
            pushFollow(FOLLOW_ruleActorRef_in_entryRuleActorRef7697);
            iv_ruleActorRef=ruleActorRef();

            state._fsp--;

             current =iv_ruleActorRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorRef7707); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActorRef"


    // $ANTLR start "ruleActorRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3916:1: ruleActorRef returns [EObject current=null] : (otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleActorRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3919:28: ( (otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3920:1: (otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3920:1: (otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3920:3: otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,70,FOLLOW_70_in_ruleActorRef7744); 

                	newLeafNode(otherlv_0, grammarAccess.getActorRefAccess().getActorRefKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3924:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3925:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3925:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3926:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorRef7761); 

            			newLeafNode(lv_name_1_0, grammarAccess.getActorRefAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getActorRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleActorRef7778); 

                	newLeafNode(otherlv_2, grammarAccess.getActorRefAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3946:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3947:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3947:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3948:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getActorRefAccess().getTypeActorClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleActorRef7801);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3961:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==29) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3962:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3962:1: (lv_docu_4_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3963:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorRefAccess().getDocuDocumentationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleActorRef7822);
                    lv_docu_4_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActorRefRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_4_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActorRef"


    // $ANTLR start "entryRuleStateGraphNode"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3987:1: entryRuleStateGraphNode returns [EObject current=null] : iv_ruleStateGraphNode= ruleStateGraphNode EOF ;
    public final EObject entryRuleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraphNode = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3988:2: (iv_ruleStateGraphNode= ruleStateGraphNode EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3989:2: iv_ruleStateGraphNode= ruleStateGraphNode EOF
            {
             newCompositeNode(grammarAccess.getStateGraphNodeRule()); 
            pushFollow(FOLLOW_ruleStateGraphNode_in_entryRuleStateGraphNode7859);
            iv_ruleStateGraphNode=ruleStateGraphNode();

            state._fsp--;

             current =iv_ruleStateGraphNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateGraphNode7869); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateGraphNode"


    // $ANTLR start "ruleStateGraphNode"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3996:1: ruleStateGraphNode returns [EObject current=null] : (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) ;
    public final EObject ruleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_ChoicePoint_1 = null;

        EObject this_TrPoint_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3999:28: ( (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4000:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4000:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            int alt99=3;
            switch ( input.LA(1) ) {
            case 73:
            case 78:
                {
                alt99=1;
                }
                break;
            case 83:
                {
                alt99=2;
                }
                break;
            case 79:
            case 80:
            case 81:
            case 82:
                {
                alt99=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }

            switch (alt99) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4001:5: this_State_0= ruleState
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphNodeAccess().getStateParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleState_in_ruleStateGraphNode7916);
                    this_State_0=ruleState();

                    state._fsp--;

                     
                            current = this_State_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4011:5: this_ChoicePoint_1= ruleChoicePoint
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphNodeAccess().getChoicePointParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateGraphNode7943);
                    this_ChoicePoint_1=ruleChoicePoint();

                    state._fsp--;

                     
                            current = this_ChoicePoint_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4021:5: this_TrPoint_2= ruleTrPoint
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphNodeAccess().getTrPointParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateGraphNode7970);
                    this_TrPoint_2=ruleTrPoint();

                    state._fsp--;

                     
                            current = this_TrPoint_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateGraphNode"


    // $ANTLR start "entryRuleState"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4039:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4040:2: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4041:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState8007);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState8017); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4048:1: ruleState returns [EObject current=null] : (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_BaseState_0 = null;

        EObject this_RefinedState_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4051:28: ( (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4052:1: (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4052:1: (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==73) ) {
                alt100=1;
            }
            else if ( (LA100_0==78) ) {
                alt100=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4053:5: this_BaseState_0= ruleBaseState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getBaseStateParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBaseState_in_ruleState8064);
                    this_BaseState_0=ruleBaseState();

                    state._fsp--;

                     
                            current = this_BaseState_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4063:5: this_RefinedState_1= ruleRefinedState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getRefinedStateParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRefinedState_in_ruleState8091);
                    this_RefinedState_1=ruleRefinedState();

                    state._fsp--;

                     
                            current = this_RefinedState_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleStateGraph"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4079:1: entryRuleStateGraph returns [EObject current=null] : iv_ruleStateGraph= ruleStateGraph EOF ;
    public final EObject entryRuleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraph = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4080:2: (iv_ruleStateGraph= ruleStateGraph EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4081:2: iv_ruleStateGraph= ruleStateGraph EOF
            {
             newCompositeNode(grammarAccess.getStateGraphRule()); 
            pushFollow(FOLLOW_ruleStateGraph_in_entryRuleStateGraph8126);
            iv_ruleStateGraph=ruleStateGraph();

            state._fsp--;

             current =iv_ruleStateGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateGraph8136); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateGraph"


    // $ANTLR start "ruleStateGraph"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4088:1: ruleStateGraph returns [EObject current=null] : (this_PlainStateGraph_0= rulePlainStateGraph | this_StateMachine_1= ruleStateMachine ) ;
    public final EObject ruleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject this_PlainStateGraph_0 = null;

        EObject this_StateMachine_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4091:28: ( (this_PlainStateGraph_0= rulePlainStateGraph | this_StateMachine_1= ruleStateMachine ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4092:1: (this_PlainStateGraph_0= rulePlainStateGraph | this_StateMachine_1= ruleStateMachine )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4092:1: (this_PlainStateGraph_0= rulePlainStateGraph | this_StateMachine_1= ruleStateMachine )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==13) ) {
                alt101=1;
            }
            else if ( ((LA101_0>=71 && LA101_0<=72)) ) {
                alt101=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4093:5: this_PlainStateGraph_0= rulePlainStateGraph
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphAccess().getPlainStateGraphParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePlainStateGraph_in_ruleStateGraph8183);
                    this_PlainStateGraph_0=rulePlainStateGraph();

                    state._fsp--;

                     
                            current = this_PlainStateGraph_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4103:5: this_StateMachine_1= ruleStateMachine
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphAccess().getStateMachineParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleStateMachine_in_ruleStateGraph8210);
                    this_StateMachine_1=ruleStateMachine();

                    state._fsp--;

                     
                            current = this_StateMachine_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateGraph"


    // $ANTLR start "entryRulePlainStateGraph"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4119:1: entryRulePlainStateGraph returns [EObject current=null] : iv_rulePlainStateGraph= rulePlainStateGraph EOF ;
    public final EObject entryRulePlainStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlainStateGraph = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4120:2: (iv_rulePlainStateGraph= rulePlainStateGraph EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4121:2: iv_rulePlainStateGraph= rulePlainStateGraph EOF
            {
             newCompositeNode(grammarAccess.getPlainStateGraphRule()); 
            pushFollow(FOLLOW_rulePlainStateGraph_in_entryRulePlainStateGraph8245);
            iv_rulePlainStateGraph=rulePlainStateGraph();

            state._fsp--;

             current =iv_rulePlainStateGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePlainStateGraph8255); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlainStateGraph"


    // $ANTLR start "rulePlainStateGraph"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4128:1: rulePlainStateGraph returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )* otherlv_6= '}' ) ;
    public final EObject rulePlainStateGraph() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_6=null;
        EObject lv_states_2_0 = null;

        EObject lv_trPoints_3_0 = null;

        EObject lv_chPoints_4_0 = null;

        EObject lv_transitions_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4131:28: ( ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )* otherlv_6= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4132:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )* otherlv_6= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4132:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )* otherlv_6= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4132:2: () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )* otherlv_6= '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4132:2: ()
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4133:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPlainStateGraphAccess().getPlainStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_rulePlainStateGraph8301); 

                	newLeafNode(otherlv_1, grammarAccess.getPlainStateGraphAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4142:1: ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )*
            loop102:
            do {
                int alt102=5;
                switch ( input.LA(1) ) {
                case 73:
                case 78:
                    {
                    alt102=1;
                    }
                    break;
                case 79:
                case 80:
                case 81:
                case 82:
                    {
                    alt102=2;
                    }
                    break;
                case 83:
                    {
                    alt102=3;
                    }
                    break;
                case 84:
                    {
                    alt102=4;
                    }
                    break;

                }

                switch (alt102) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4142:2: ( (lv_states_2_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4142:2: ( (lv_states_2_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4143:1: (lv_states_2_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4143:1: (lv_states_2_0= ruleState )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4144:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPlainStateGraphAccess().getStatesStateParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_rulePlainStateGraph8323);
            	    lv_states_2_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPlainStateGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_2_0, 
            	            		"State");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4161:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4161:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4162:1: (lv_trPoints_3_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4162:1: (lv_trPoints_3_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4163:3: lv_trPoints_3_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPlainStateGraphAccess().getTrPointsTrPointParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_rulePlainStateGraph8350);
            	    lv_trPoints_3_0=ruleTrPoint();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPlainStateGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"trPoints",
            	            		lv_trPoints_3_0, 
            	            		"TrPoint");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4180:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4180:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4181:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4181:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4182:3: lv_chPoints_4_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPlainStateGraphAccess().getChPointsChoicePointParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_rulePlainStateGraph8377);
            	    lv_chPoints_4_0=ruleChoicePoint();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPlainStateGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"chPoints",
            	            		lv_chPoints_4_0, 
            	            		"ChoicePoint");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4199:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4199:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4200:1: (lv_transitions_5_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4200:1: (lv_transitions_5_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4201:3: lv_transitions_5_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPlainStateGraphAccess().getTransitionsTransitionParserRuleCall_2_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_rulePlainStateGraph8404);
            	    lv_transitions_5_0=ruleTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPlainStateGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transitions",
            	            		lv_transitions_5_0, 
            	            		"Transition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop102;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_rulePlainStateGraph8418); 

                	newLeafNode(otherlv_6, grammarAccess.getPlainStateGraphAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlainStateGraph"


    // $ANTLR start "entryRuleStateMachine"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4229:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4230:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4231:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             newCompositeNode(grammarAccess.getStateMachineRule()); 
            pushFollow(FOLLOW_ruleStateMachine_in_entryRuleStateMachine8454);
            iv_ruleStateMachine=ruleStateMachine();

            state._fsp--;

             current =iv_ruleStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateMachine8464); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateMachine"


    // $ANTLR start "ruleStateMachine"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4238:1: ruleStateMachine returns [EObject current=null] : ( () ( (lv_dataDriven_1_0= 'data_driven' ) )? otherlv_2= 'StateMachine' otherlv_3= '{' ( ( (lv_states_4_0= ruleState ) ) | ( (lv_trPoints_5_0= ruleTrPoint ) ) | ( (lv_chPoints_6_0= ruleChoicePoint ) ) | ( (lv_transitions_7_0= ruleTransition ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleStateMachine() throws RecognitionException {
        EObject current = null;

        Token lv_dataDriven_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        EObject lv_states_4_0 = null;

        EObject lv_trPoints_5_0 = null;

        EObject lv_chPoints_6_0 = null;

        EObject lv_transitions_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4241:28: ( ( () ( (lv_dataDriven_1_0= 'data_driven' ) )? otherlv_2= 'StateMachine' otherlv_3= '{' ( ( (lv_states_4_0= ruleState ) ) | ( (lv_trPoints_5_0= ruleTrPoint ) ) | ( (lv_chPoints_6_0= ruleChoicePoint ) ) | ( (lv_transitions_7_0= ruleTransition ) ) )* otherlv_8= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4242:1: ( () ( (lv_dataDriven_1_0= 'data_driven' ) )? otherlv_2= 'StateMachine' otherlv_3= '{' ( ( (lv_states_4_0= ruleState ) ) | ( (lv_trPoints_5_0= ruleTrPoint ) ) | ( (lv_chPoints_6_0= ruleChoicePoint ) ) | ( (lv_transitions_7_0= ruleTransition ) ) )* otherlv_8= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4242:1: ( () ( (lv_dataDriven_1_0= 'data_driven' ) )? otherlv_2= 'StateMachine' otherlv_3= '{' ( ( (lv_states_4_0= ruleState ) ) | ( (lv_trPoints_5_0= ruleTrPoint ) ) | ( (lv_chPoints_6_0= ruleChoicePoint ) ) | ( (lv_transitions_7_0= ruleTransition ) ) )* otherlv_8= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4242:2: () ( (lv_dataDriven_1_0= 'data_driven' ) )? otherlv_2= 'StateMachine' otherlv_3= '{' ( ( (lv_states_4_0= ruleState ) ) | ( (lv_trPoints_5_0= ruleTrPoint ) ) | ( (lv_chPoints_6_0= ruleChoicePoint ) ) | ( (lv_transitions_7_0= ruleTransition ) ) )* otherlv_8= '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4242:2: ()
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4243:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateMachineAccess().getStateMachineAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4248:2: ( (lv_dataDriven_1_0= 'data_driven' ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==71) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4249:1: (lv_dataDriven_1_0= 'data_driven' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4249:1: (lv_dataDriven_1_0= 'data_driven' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4250:3: lv_dataDriven_1_0= 'data_driven'
                    {
                    lv_dataDriven_1_0=(Token)match(input,71,FOLLOW_71_in_ruleStateMachine8516); 

                            newLeafNode(lv_dataDriven_1_0, grammarAccess.getStateMachineAccess().getDataDrivenData_drivenKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStateMachineRule());
                    	        }
                           		setWithLastConsumed(current, "dataDriven", true, "data_driven");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,72,FOLLOW_72_in_ruleStateMachine8542); 

                	newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getStateMachineKeyword_2());
                
            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleStateMachine8554); 

                	newLeafNode(otherlv_3, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4271:1: ( ( (lv_states_4_0= ruleState ) ) | ( (lv_trPoints_5_0= ruleTrPoint ) ) | ( (lv_chPoints_6_0= ruleChoicePoint ) ) | ( (lv_transitions_7_0= ruleTransition ) ) )*
            loop104:
            do {
                int alt104=5;
                switch ( input.LA(1) ) {
                case 73:
                case 78:
                    {
                    alt104=1;
                    }
                    break;
                case 79:
                case 80:
                case 81:
                case 82:
                    {
                    alt104=2;
                    }
                    break;
                case 83:
                    {
                    alt104=3;
                    }
                    break;
                case 84:
                    {
                    alt104=4;
                    }
                    break;

                }

                switch (alt104) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4271:2: ( (lv_states_4_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4271:2: ( (lv_states_4_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4272:1: (lv_states_4_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4272:1: (lv_states_4_0= ruleState )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4273:3: lv_states_4_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_4_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateMachine8576);
            	    lv_states_4_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_4_0, 
            	            		"State");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4290:6: ( (lv_trPoints_5_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4290:6: ( (lv_trPoints_5_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4291:1: (lv_trPoints_5_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4291:1: (lv_trPoints_5_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4292:3: lv_trPoints_5_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTrPointsTrPointParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateMachine8603);
            	    lv_trPoints_5_0=ruleTrPoint();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"trPoints",
            	            		lv_trPoints_5_0, 
            	            		"TrPoint");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4309:6: ( (lv_chPoints_6_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4309:6: ( (lv_chPoints_6_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4310:1: (lv_chPoints_6_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4310:1: (lv_chPoints_6_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4311:3: lv_chPoints_6_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getChPointsChoicePointParserRuleCall_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateMachine8630);
            	    lv_chPoints_6_0=ruleChoicePoint();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"chPoints",
            	            		lv_chPoints_6_0, 
            	            		"ChoicePoint");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4328:6: ( (lv_transitions_7_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4328:6: ( (lv_transitions_7_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4329:1: (lv_transitions_7_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4329:1: (lv_transitions_7_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4330:3: lv_transitions_7_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_4_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleStateMachine8657);
            	    lv_transitions_7_0=ruleTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transitions",
            	            		lv_transitions_7_0, 
            	            		"Transition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop104;
                }
            } while (true);

            otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleStateMachine8671); 

                	newLeafNode(otherlv_8, grammarAccess.getStateMachineAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateMachine"


    // $ANTLR start "entryRuleBaseState"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4358:1: entryRuleBaseState returns [EObject current=null] : iv_ruleBaseState= ruleBaseState EOF ;
    public final EObject entryRuleBaseState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4359:2: (iv_ruleBaseState= ruleBaseState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4360:2: iv_ruleBaseState= ruleBaseState EOF
            {
             newCompositeNode(grammarAccess.getBaseStateRule()); 
            pushFollow(FOLLOW_ruleBaseState_in_entryRuleBaseState8707);
            iv_ruleBaseState=ruleBaseState();

            state._fsp--;

             current =iv_ruleBaseState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBaseState8717); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseState"


    // $ANTLR start "ruleBaseState"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4367:1: ruleBaseState returns [EObject current=null] : (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}' )? ) ;
    public final EObject ruleBaseState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_docu_2_0 = null;

        EObject lv_entryCode_5_0 = null;

        EObject lv_exitCode_7_0 = null;

        EObject lv_doCode_9_0 = null;

        EObject lv_subgraph_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4370:28: ( (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4371:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4371:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4371:3: otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}' )?
            {
            otherlv_0=(Token)match(input,73,FOLLOW_73_in_ruleBaseState8754); 

                	newLeafNode(otherlv_0, grammarAccess.getBaseStateAccess().getStateKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4375:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4376:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4376:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4377:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBaseState8771); 

            			newLeafNode(lv_name_1_0, grammarAccess.getBaseStateAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBaseStateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4393:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==29) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4394:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4394:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4395:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getBaseStateAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleBaseState8797);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBaseStateRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_2_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4411:3: (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}' )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==13) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4411:5: otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleBaseState8811); 

                        	newLeafNode(otherlv_3, grammarAccess.getBaseStateAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4415:1: (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( (LA106_0==74) ) {
                        alt106=1;
                    }
                    switch (alt106) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4415:3: otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                            {
                            otherlv_4=(Token)match(input,74,FOLLOW_74_in_ruleBaseState8824); 

                                	newLeafNode(otherlv_4, grammarAccess.getBaseStateAccess().getEntryKeyword_3_1_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4419:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4420:1: (lv_entryCode_5_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4420:1: (lv_entryCode_5_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4421:3: lv_entryCode_5_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getBaseStateAccess().getEntryCodeDetailCodeParserRuleCall_3_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleBaseState8845);
                            lv_entryCode_5_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBaseStateRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"entryCode",
                                    		lv_entryCode_5_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4437:4: (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( (LA107_0==75) ) {
                        alt107=1;
                    }
                    switch (alt107) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4437:6: otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                            {
                            otherlv_6=(Token)match(input,75,FOLLOW_75_in_ruleBaseState8860); 

                                	newLeafNode(otherlv_6, grammarAccess.getBaseStateAccess().getExitKeyword_3_2_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4441:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4442:1: (lv_exitCode_7_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4442:1: (lv_exitCode_7_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4443:3: lv_exitCode_7_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getBaseStateAccess().getExitCodeDetailCodeParserRuleCall_3_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleBaseState8881);
                            lv_exitCode_7_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBaseStateRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"exitCode",
                                    		lv_exitCode_7_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4459:4: (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )?
                    int alt108=2;
                    int LA108_0 = input.LA(1);

                    if ( (LA108_0==76) ) {
                        alt108=1;
                    }
                    switch (alt108) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4459:6: otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,76,FOLLOW_76_in_ruleBaseState8896); 

                                	newLeafNode(otherlv_8, grammarAccess.getBaseStateAccess().getDoKeyword_3_3_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4463:1: ( (lv_doCode_9_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4464:1: (lv_doCode_9_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4464:1: (lv_doCode_9_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4465:3: lv_doCode_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getBaseStateAccess().getDoCodeDetailCodeParserRuleCall_3_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleBaseState8917);
                            lv_doCode_9_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBaseStateRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"doCode",
                                    		lv_doCode_9_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4481:4: (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )?
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( (LA109_0==77) ) {
                        alt109=1;
                    }
                    switch (alt109) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4481:6: otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) )
                            {
                            otherlv_10=(Token)match(input,77,FOLLOW_77_in_ruleBaseState8932); 

                                	newLeafNode(otherlv_10, grammarAccess.getBaseStateAccess().getSubgraphKeyword_3_4_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4485:1: ( (lv_subgraph_11_0= rulePlainStateGraph ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4486:1: (lv_subgraph_11_0= rulePlainStateGraph )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4486:1: (lv_subgraph_11_0= rulePlainStateGraph )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4487:3: lv_subgraph_11_0= rulePlainStateGraph
                            {
                             
                            	        newCompositeNode(grammarAccess.getBaseStateAccess().getSubgraphPlainStateGraphParserRuleCall_3_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_rulePlainStateGraph_in_ruleBaseState8953);
                            lv_subgraph_11_0=rulePlainStateGraph();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBaseStateRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"subgraph",
                                    		lv_subgraph_11_0, 
                                    		"PlainStateGraph");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleBaseState8967); 

                        	newLeafNode(otherlv_12, grammarAccess.getBaseStateAccess().getRightCurlyBracketKeyword_3_5());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBaseState"


    // $ANTLR start "entryRuleRefinedState"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4515:1: entryRuleRefinedState returns [EObject current=null] : iv_ruleRefinedState= ruleRefinedState EOF ;
    public final EObject entryRuleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4516:2: (iv_ruleRefinedState= ruleRefinedState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4517:2: iv_ruleRefinedState= ruleRefinedState EOF
            {
             newCompositeNode(grammarAccess.getRefinedStateRule()); 
            pushFollow(FOLLOW_ruleRefinedState_in_entryRuleRefinedState9005);
            iv_ruleRefinedState=ruleRefinedState();

            state._fsp--;

             current =iv_ruleRefinedState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefinedState9015); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefinedState"


    // $ANTLR start "ruleRefinedState"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4524:1: ruleRefinedState returns [EObject current=null] : (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' ) ;
    public final EObject ruleRefinedState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_docu_2_0 = null;

        EObject lv_entryCode_5_0 = null;

        EObject lv_exitCode_7_0 = null;

        EObject lv_doCode_9_0 = null;

        EObject lv_subgraph_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4527:28: ( (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4528:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4528:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4528:3: otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_78_in_ruleRefinedState9052); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedStateAccess().getRefinedStateKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4532:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4533:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4533:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4534:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefinedStateRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRefinedStateAccess().getBaseBaseStateCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRefinedState9075);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4547:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==29) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4548:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4548:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4549:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleRefinedState9096);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_2_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleRefinedState9109); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedStateAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4569:1: (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==74) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4569:3: otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                    {
                    otherlv_4=(Token)match(input,74,FOLLOW_74_in_ruleRefinedState9122); 

                        	newLeafNode(otherlv_4, grammarAccess.getRefinedStateAccess().getEntryKeyword_4_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4573:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4574:1: (lv_entryCode_5_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4574:1: (lv_entryCode_5_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4575:3: lv_entryCode_5_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getEntryCodeDetailCodeParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState9143);
                    lv_entryCode_5_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    	        }
                           		set(
                           			current, 
                           			"entryCode",
                            		lv_entryCode_5_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4591:4: (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==75) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4591:6: otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                    {
                    otherlv_6=(Token)match(input,75,FOLLOW_75_in_ruleRefinedState9158); 

                        	newLeafNode(otherlv_6, grammarAccess.getRefinedStateAccess().getExitKeyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4595:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4596:1: (lv_exitCode_7_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4596:1: (lv_exitCode_7_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4597:3: lv_exitCode_7_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getExitCodeDetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState9179);
                    lv_exitCode_7_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    	        }
                           		set(
                           			current, 
                           			"exitCode",
                            		lv_exitCode_7_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4613:4: (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==76) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4613:6: otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,76,FOLLOW_76_in_ruleRefinedState9194); 

                        	newLeafNode(otherlv_8, grammarAccess.getRefinedStateAccess().getDoKeyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4617:1: ( (lv_doCode_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4618:1: (lv_doCode_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4618:1: (lv_doCode_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4619:3: lv_doCode_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getDoCodeDetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState9215);
                    lv_doCode_9_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    	        }
                           		set(
                           			current, 
                           			"doCode",
                            		lv_doCode_9_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4635:4: (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==77) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4635:6: otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) )
                    {
                    otherlv_10=(Token)match(input,77,FOLLOW_77_in_ruleRefinedState9230); 

                        	newLeafNode(otherlv_10, grammarAccess.getRefinedStateAccess().getSubgraphKeyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4639:1: ( (lv_subgraph_11_0= ruleStateGraph ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4640:1: (lv_subgraph_11_0= ruleStateGraph )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4640:1: (lv_subgraph_11_0= ruleStateGraph )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4641:3: lv_subgraph_11_0= ruleStateGraph
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getSubgraphStateGraphParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleStateGraph_in_ruleRefinedState9251);
                    lv_subgraph_11_0=ruleStateGraph();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    	        }
                           		set(
                           			current, 
                           			"subgraph",
                            		lv_subgraph_11_0, 
                            		"StateGraph");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleRefinedState9265); 

                	newLeafNode(otherlv_12, grammarAccess.getRefinedStateAccess().getRightCurlyBracketKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefinedState"


    // $ANTLR start "entryRuleDetailCode"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4669:1: entryRuleDetailCode returns [EObject current=null] : iv_ruleDetailCode= ruleDetailCode EOF ;
    public final EObject entryRuleDetailCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailCode = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4670:2: (iv_ruleDetailCode= ruleDetailCode EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4671:2: iv_ruleDetailCode= ruleDetailCode EOF
            {
             newCompositeNode(grammarAccess.getDetailCodeRule()); 
            pushFollow(FOLLOW_ruleDetailCode_in_entryRuleDetailCode9301);
            iv_ruleDetailCode=ruleDetailCode();

            state._fsp--;

             current =iv_ruleDetailCode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDetailCode9311); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDetailCode"


    // $ANTLR start "ruleDetailCode"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4678:1: ruleDetailCode returns [EObject current=null] : (otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}' ) ;
    public final EObject ruleDetailCode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_commands_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4681:28: ( (otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4682:1: (otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4682:1: (otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4682:3: otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleDetailCode9348); 

                	newLeafNode(otherlv_0, grammarAccess.getDetailCodeAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4686:1: ( (lv_commands_1_0= RULE_STRING ) )+
            int cnt116=0;
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==RULE_STRING) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4687:1: (lv_commands_1_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4687:1: (lv_commands_1_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4688:3: lv_commands_1_0= RULE_STRING
            	    {
            	    lv_commands_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDetailCode9365); 

            	    			newLeafNode(lv_commands_1_0, grammarAccess.getDetailCodeAccess().getCommandsSTRINGTerminalRuleCall_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDetailCodeRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"commands",
            	            		lv_commands_1_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt116 >= 1 ) break loop116;
                        EarlyExitException eee =
                            new EarlyExitException(116, input);
                        throw eee;
                }
                cnt116++;
            } while (true);

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleDetailCode9383); 

                	newLeafNode(otherlv_2, grammarAccess.getDetailCodeAccess().getRightCurlyBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDetailCode"


    // $ANTLR start "entryRuleTrPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4716:1: entryRuleTrPoint returns [EObject current=null] : iv_ruleTrPoint= ruleTrPoint EOF ;
    public final EObject entryRuleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4717:2: (iv_ruleTrPoint= ruleTrPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4718:2: iv_ruleTrPoint= ruleTrPoint EOF
            {
             newCompositeNode(grammarAccess.getTrPointRule()); 
            pushFollow(FOLLOW_ruleTrPoint_in_entryRuleTrPoint9419);
            iv_ruleTrPoint=ruleTrPoint();

            state._fsp--;

             current =iv_ruleTrPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPoint9429); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrPoint"


    // $ANTLR start "ruleTrPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4725:1: ruleTrPoint returns [EObject current=null] : (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) ;
    public final EObject ruleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionPoint_0 = null;

        EObject this_EntryPoint_1 = null;

        EObject this_ExitPoint_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4728:28: ( (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4729:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4729:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            int alt117=3;
            switch ( input.LA(1) ) {
            case 79:
            case 80:
                {
                alt117=1;
                }
                break;
            case 81:
                {
                alt117=2;
                }
                break;
            case 82:
                {
                alt117=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }

            switch (alt117) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4730:5: this_TransitionPoint_0= ruleTransitionPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getTransitionPointParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTransitionPoint_in_ruleTrPoint9476);
                    this_TransitionPoint_0=ruleTransitionPoint();

                    state._fsp--;

                     
                            current = this_TransitionPoint_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4740:5: this_EntryPoint_1= ruleEntryPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getEntryPointParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEntryPoint_in_ruleTrPoint9503);
                    this_EntryPoint_1=ruleEntryPoint();

                    state._fsp--;

                     
                            current = this_EntryPoint_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4750:5: this_ExitPoint_2= ruleExitPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getExitPointParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleExitPoint_in_ruleTrPoint9530);
                    this_ExitPoint_2=ruleExitPoint();

                    state._fsp--;

                     
                            current = this_ExitPoint_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrPoint"


    // $ANTLR start "entryRuleTransitionPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4766:1: entryRuleTransitionPoint returns [EObject current=null] : iv_ruleTransitionPoint= ruleTransitionPoint EOF ;
    public final EObject entryRuleTransitionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4767:2: (iv_ruleTransitionPoint= ruleTransitionPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4768:2: iv_ruleTransitionPoint= ruleTransitionPoint EOF
            {
             newCompositeNode(grammarAccess.getTransitionPointRule()); 
            pushFollow(FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint9565);
            iv_ruleTransitionPoint=ruleTransitionPoint();

            state._fsp--;

             current =iv_ruleTransitionPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionPoint9575); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransitionPoint"


    // $ANTLR start "ruleTransitionPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4775:1: ruleTransitionPoint returns [EObject current=null] : ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTransitionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_handler_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4778:28: ( ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4779:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4779:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4779:2: ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4779:2: ( (lv_handler_0_0= 'handler' ) )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==79) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4780:1: (lv_handler_0_0= 'handler' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4780:1: (lv_handler_0_0= 'handler' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4781:3: lv_handler_0_0= 'handler'
                    {
                    lv_handler_0_0=(Token)match(input,79,FOLLOW_79_in_ruleTransitionPoint9618); 

                            newLeafNode(lv_handler_0_0, grammarAccess.getTransitionPointAccess().getHandlerHandlerKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransitionPointRule());
                    	        }
                           		setWithLastConsumed(current, "handler", true, "handler");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,80,FOLLOW_80_in_ruleTransitionPoint9644); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionPointAccess().getTransitionPointKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4798:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4799:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4799:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4800:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransitionPoint9661); 

            			newLeafNode(lv_name_2_0, grammarAccess.getTransitionPointAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionPointRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransitionPoint"


    // $ANTLR start "entryRuleEntryPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4824:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4825:2: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4826:2: iv_ruleEntryPoint= ruleEntryPoint EOF
            {
             newCompositeNode(grammarAccess.getEntryPointRule()); 
            pushFollow(FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint9702);
            iv_ruleEntryPoint=ruleEntryPoint();

            state._fsp--;

             current =iv_ruleEntryPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryPoint9712); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntryPoint"


    // $ANTLR start "ruleEntryPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4833:1: ruleEntryPoint returns [EObject current=null] : (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4836:28: ( (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4837:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4837:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4837:3: otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,81,FOLLOW_81_in_ruleEntryPoint9749); 

                	newLeafNode(otherlv_0, grammarAccess.getEntryPointAccess().getEntryPointKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4841:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4842:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4842:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4843:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntryPoint9766); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEntryPointAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEntryPointRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntryPoint"


    // $ANTLR start "entryRuleExitPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4867:1: entryRuleExitPoint returns [EObject current=null] : iv_ruleExitPoint= ruleExitPoint EOF ;
    public final EObject entryRuleExitPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4868:2: (iv_ruleExitPoint= ruleExitPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4869:2: iv_ruleExitPoint= ruleExitPoint EOF
            {
             newCompositeNode(grammarAccess.getExitPointRule()); 
            pushFollow(FOLLOW_ruleExitPoint_in_entryRuleExitPoint9807);
            iv_ruleExitPoint=ruleExitPoint();

            state._fsp--;

             current =iv_ruleExitPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitPoint9817); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExitPoint"


    // $ANTLR start "ruleExitPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4876:1: ruleExitPoint returns [EObject current=null] : (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4879:28: ( (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4880:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4880:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4880:3: otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,82,FOLLOW_82_in_ruleExitPoint9854); 

                	newLeafNode(otherlv_0, grammarAccess.getExitPointAccess().getExitPointKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4884:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4885:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4885:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4886:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitPoint9871); 

            			newLeafNode(lv_name_1_0, grammarAccess.getExitPointAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExitPointRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExitPoint"


    // $ANTLR start "entryRuleChoicePoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4910:1: entryRuleChoicePoint returns [EObject current=null] : iv_ruleChoicePoint= ruleChoicePoint EOF ;
    public final EObject entryRuleChoicePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicePoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4911:2: (iv_ruleChoicePoint= ruleChoicePoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4912:2: iv_ruleChoicePoint= ruleChoicePoint EOF
            {
             newCompositeNode(grammarAccess.getChoicePointRule()); 
            pushFollow(FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint9912);
            iv_ruleChoicePoint=ruleChoicePoint();

            state._fsp--;

             current =iv_ruleChoicePoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicePoint9922); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChoicePoint"


    // $ANTLR start "ruleChoicePoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4919:1: ruleChoicePoint returns [EObject current=null] : (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) ;
    public final EObject ruleChoicePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4922:28: ( (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4923:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4923:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4923:3: otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,83,FOLLOW_83_in_ruleChoicePoint9959); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicePointAccess().getChoicePointKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4927:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4928:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4928:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4929:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicePoint9976); 

            			newLeafNode(lv_name_1_0, grammarAccess.getChoicePointAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChoicePointRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4945:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==29) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4946:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4946:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4947:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getChoicePointAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleChoicePoint10002);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getChoicePointRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_2_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChoicePoint"


    // $ANTLR start "entryRuleTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4971:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4972:2: (iv_ruleTransition= ruleTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4973:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition10039);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition10049); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4980:1: ruleTransition returns [EObject current=null] : (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_InitialTransition_0 = null;

        EObject this_NonInitialTransition_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4983:28: ( (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4984:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4984:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==84) ) {
                int LA120_1 = input.LA(2);

                if ( (LA120_1==RULE_ID) ) {
                    int LA120_2 = input.LA(3);

                    if ( (LA120_2==15) ) {
                        int LA120_3 = input.LA(4);

                        if ( (LA120_3==RULE_ID||(LA120_3>=91 && LA120_3<=92)) ) {
                            alt120=2;
                        }
                        else if ( (LA120_3==85) ) {
                            alt120=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 120, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 120, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA120_1==15) ) {
                    int LA120_3 = input.LA(3);

                    if ( (LA120_3==RULE_ID||(LA120_3>=91 && LA120_3<=92)) ) {
                        alt120=2;
                    }
                    else if ( (LA120_3==85) ) {
                        alt120=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 120, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 120, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);

                throw nvae;
            }
            switch (alt120) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4985:5: this_InitialTransition_0= ruleInitialTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionAccess().getInitialTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInitialTransition_in_ruleTransition10096);
                    this_InitialTransition_0=ruleInitialTransition();

                    state._fsp--;

                     
                            current = this_InitialTransition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4995:5: this_NonInitialTransition_1= ruleNonInitialTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionAccess().getNonInitialTransitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNonInitialTransition_in_ruleTransition10123);
                    this_NonInitialTransition_1=ruleNonInitialTransition();

                    state._fsp--;

                     
                            current = this_NonInitialTransition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleNonInitialTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5011:1: entryRuleNonInitialTransition returns [EObject current=null] : iv_ruleNonInitialTransition= ruleNonInitialTransition EOF ;
    public final EObject entryRuleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5012:2: (iv_ruleNonInitialTransition= ruleNonInitialTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5013:2: iv_ruleNonInitialTransition= ruleNonInitialTransition EOF
            {
             newCompositeNode(grammarAccess.getNonInitialTransitionRule()); 
            pushFollow(FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition10158);
            iv_ruleNonInitialTransition=ruleNonInitialTransition();

            state._fsp--;

             current =iv_ruleNonInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonInitialTransition10168); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNonInitialTransition"


    // $ANTLR start "ruleNonInitialTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5020:1: ruleNonInitialTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition | this_ContinuationTransition_2= ruleContinuationTransition | this_CPBranchTransition_3= ruleCPBranchTransition ) ;
    public final EObject ruleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_GuardedTransition_1 = null;

        EObject this_ContinuationTransition_2 = null;

        EObject this_CPBranchTransition_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5023:28: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition | this_ContinuationTransition_2= ruleContinuationTransition | this_CPBranchTransition_3= ruleCPBranchTransition ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5024:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition | this_ContinuationTransition_2= ruleContinuationTransition | this_CPBranchTransition_3= ruleCPBranchTransition )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5024:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition | this_ContinuationTransition_2= ruleContinuationTransition | this_CPBranchTransition_3= ruleCPBranchTransition )
            int alt121=4;
            alt121 = dfa121.predict(input);
            switch (alt121) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5025:5: this_TriggeredTransition_0= ruleTriggeredTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getTriggeredTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTriggeredTransition_in_ruleNonInitialTransition10215);
                    this_TriggeredTransition_0=ruleTriggeredTransition();

                    state._fsp--;

                     
                            current = this_TriggeredTransition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5035:5: this_GuardedTransition_1= ruleGuardedTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getGuardedTransitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleGuardedTransition_in_ruleNonInitialTransition10242);
                    this_GuardedTransition_1=ruleGuardedTransition();

                    state._fsp--;

                     
                            current = this_GuardedTransition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5045:5: this_ContinuationTransition_2= ruleContinuationTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getContinuationTransitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition10269);
                    this_ContinuationTransition_2=ruleContinuationTransition();

                    state._fsp--;

                     
                            current = this_ContinuationTransition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5055:5: this_CPBranchTransition_3= ruleCPBranchTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getCPBranchTransitionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition10296);
                    this_CPBranchTransition_3=ruleCPBranchTransition();

                    state._fsp--;

                     
                            current = this_CPBranchTransition_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNonInitialTransition"


    // $ANTLR start "entryRuleInitialTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5071:1: entryRuleInitialTransition returns [EObject current=null] : iv_ruleInitialTransition= ruleInitialTransition EOF ;
    public final EObject entryRuleInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5072:2: (iv_ruleInitialTransition= ruleInitialTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5073:2: iv_ruleInitialTransition= ruleInitialTransition EOF
            {
             newCompositeNode(grammarAccess.getInitialTransitionRule()); 
            pushFollow(FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition10331);
            iv_ruleInitialTransition=ruleInitialTransition();

            state._fsp--;

             current =iv_ruleInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInitialTransition10341); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitialTransition"


    // $ANTLR start "ruleInitialTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5080:1: ruleInitialTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleInitialTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_action_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5083:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5084:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5084:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5084:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,84,FOLLOW_84_in_ruleInitialTransition10378); 

                	newLeafNode(otherlv_0, grammarAccess.getInitialTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5088:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==RULE_ID) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5089:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5089:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5090:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInitialTransition10395); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getInitialTransitionAccess().getNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInitialTransitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleInitialTransition10413); 

                	newLeafNode(otherlv_2, grammarAccess.getInitialTransitionAccess().getColonKeyword_2());
                
            otherlv_3=(Token)match(input,85,FOLLOW_85_in_ruleInitialTransition10425); 

                	newLeafNode(otherlv_3, grammarAccess.getInitialTransitionAccess().getInitialKeyword_3());
                
            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleInitialTransition10437); 

                	newLeafNode(otherlv_4, grammarAccess.getInitialTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5118:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5119:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5119:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5120:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition10458);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInitialTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_5_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5136:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==29) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5137:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5137:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5138:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleInitialTransition10479);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInitialTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_6_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleInitialTransition10492); 

                	newLeafNode(otherlv_7, grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5158:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==86) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5158:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,86,FOLLOW_86_in_ruleInitialTransition10505); 

                        	newLeafNode(otherlv_8, grammarAccess.getInitialTransitionAccess().getActionKeyword_8_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5162:1: ( (lv_action_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5163:1: (lv_action_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5163:1: (lv_action_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5164:3: lv_action_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getActionDetailCodeParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleInitialTransition10526);
                    lv_action_9_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInitialTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"action",
                            		lv_action_9_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,14,FOLLOW_14_in_ruleInitialTransition10540); 

                	newLeafNode(otherlv_10, grammarAccess.getInitialTransitionAccess().getRightCurlyBracketKeyword_9());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitialTransition"


    // $ANTLR start "entryRuleContinuationTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5192:1: entryRuleContinuationTransition returns [EObject current=null] : iv_ruleContinuationTransition= ruleContinuationTransition EOF ;
    public final EObject entryRuleContinuationTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuationTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5193:2: (iv_ruleContinuationTransition= ruleContinuationTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5194:2: iv_ruleContinuationTransition= ruleContinuationTransition EOF
            {
             newCompositeNode(grammarAccess.getContinuationTransitionRule()); 
            pushFollow(FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition10576);
            iv_ruleContinuationTransition=ruleContinuationTransition();

            state._fsp--;

             current =iv_ruleContinuationTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContinuationTransition10586); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContinuationTransition"


    // $ANTLR start "ruleContinuationTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5201:1: ruleContinuationTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) ;
    public final EObject ruleContinuationTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_action_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5204:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5205:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5205:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5205:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,84,FOLLOW_84_in_ruleContinuationTransition10623); 

                	newLeafNode(otherlv_0, grammarAccess.getContinuationTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5209:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==RULE_ID) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5210:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5210:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5211:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContinuationTransition10640); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getContinuationTransitionAccess().getNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getContinuationTransitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleContinuationTransition10658); 

                	newLeafNode(otherlv_2, grammarAccess.getContinuationTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5231:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5232:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5232:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5233:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition10679);
            lv_from_3_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"from",
                    		lv_from_3_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleContinuationTransition10691); 

                	newLeafNode(otherlv_4, grammarAccess.getContinuationTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5253:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5254:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5254:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5255:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition10712);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_5_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5271:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==29) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5272:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5272:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5273:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleContinuationTransition10733);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_6_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5289:3: (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==13) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5289:5: otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleContinuationTransition10747); 

                        	newLeafNode(otherlv_7, grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5293:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
                    int alt127=2;
                    int LA127_0 = input.LA(1);

                    if ( (LA127_0==86) ) {
                        alt127=1;
                    }
                    switch (alt127) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5293:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,86,FOLLOW_86_in_ruleContinuationTransition10760); 

                                	newLeafNode(otherlv_8, grammarAccess.getContinuationTransitionAccess().getActionKeyword_7_1_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5297:1: ( (lv_action_9_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5298:1: (lv_action_9_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5298:1: (lv_action_9_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5299:3: lv_action_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getActionDetailCodeParserRuleCall_7_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleContinuationTransition10781);
                            lv_action_9_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"action",
                                    		lv_action_9_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_10=(Token)match(input,14,FOLLOW_14_in_ruleContinuationTransition10795); 

                        	newLeafNode(otherlv_10, grammarAccess.getContinuationTransitionAccess().getRightCurlyBracketKeyword_7_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContinuationTransition"


    // $ANTLR start "entryRuleTriggeredTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5327:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5328:2: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5329:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
            {
             newCompositeNode(grammarAccess.getTriggeredTransitionRule()); 
            pushFollow(FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition10833);
            iv_ruleTriggeredTransition=ruleTriggeredTransition();

            state._fsp--;

             current =iv_ruleTriggeredTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggeredTransition10843); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTriggeredTransition"


    // $ANTLR start "ruleTriggeredTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5336:1: ruleTriggeredTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) ;
    public final EObject ruleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_triggers_10_0 = null;

        EObject lv_triggers_12_0 = null;

        EObject lv_action_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5339:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5340:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5340:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5340:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,84,FOLLOW_84_in_ruleTriggeredTransition10880); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggeredTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5344:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==RULE_ID) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5345:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5345:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5346:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggeredTransition10897); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getTriggeredTransitionAccess().getNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTriggeredTransitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleTriggeredTransition10915); 

                	newLeafNode(otherlv_2, grammarAccess.getTriggeredTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5366:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5367:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5367:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5368:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition10936);
            lv_from_3_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"from",
                    		lv_from_3_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleTriggeredTransition10948); 

                	newLeafNode(otherlv_4, grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5388:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5389:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5389:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5390:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition10969);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_5_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5406:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==29) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5407:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5407:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5408:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleTriggeredTransition10990);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_6_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleTriggeredTransition11003); 

                	newLeafNode(otherlv_7, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,87,FOLLOW_87_in_ruleTriggeredTransition11015); 

                	newLeafNode(otherlv_8, grammarAccess.getTriggeredTransitionAccess().getTriggersKeyword_8());
                
            otherlv_9=(Token)match(input,13,FOLLOW_13_in_ruleTriggeredTransition11027); 

                	newLeafNode(otherlv_9, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_9());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5436:1: ( (lv_triggers_10_0= ruleTrigger ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5437:1: (lv_triggers_10_0= ruleTrigger )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5437:1: (lv_triggers_10_0= ruleTrigger )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5438:3: lv_triggers_10_0= ruleTrigger
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition11048);
            lv_triggers_10_0=ruleTrigger();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            	        }
                   		add(
                   			current, 
                   			"triggers",
                    		lv_triggers_10_0, 
                    		"Trigger");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5454:2: (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )*
            loop131:
            do {
                int alt131=2;
                int LA131_0 = input.LA(1);

                if ( (LA131_0==88) ) {
                    alt131=1;
                }


                switch (alt131) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5454:4: otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) )
            	    {
            	    otherlv_11=(Token)match(input,88,FOLLOW_88_in_ruleTriggeredTransition11061); 

            	        	newLeafNode(otherlv_11, grammarAccess.getTriggeredTransitionAccess().getOrKeyword_11_0());
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5458:1: ( (lv_triggers_12_0= ruleTrigger ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5459:1: (lv_triggers_12_0= ruleTrigger )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5459:1: (lv_triggers_12_0= ruleTrigger )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5460:3: lv_triggers_12_0= ruleTrigger
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_11_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition11082);
            	    lv_triggers_12_0=ruleTrigger();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"triggers",
            	            		lv_triggers_12_0, 
            	            		"Trigger");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop131;
                }
            } while (true);

            otherlv_13=(Token)match(input,14,FOLLOW_14_in_ruleTriggeredTransition11096); 

                	newLeafNode(otherlv_13, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_12());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5480:1: (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )?
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==86) ) {
                alt132=1;
            }
            switch (alt132) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5480:3: otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) )
                    {
                    otherlv_14=(Token)match(input,86,FOLLOW_86_in_ruleTriggeredTransition11109); 

                        	newLeafNode(otherlv_14, grammarAccess.getTriggeredTransitionAccess().getActionKeyword_13_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5484:1: ( (lv_action_15_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5485:1: (lv_action_15_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5485:1: (lv_action_15_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5486:3: lv_action_15_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getActionDetailCodeParserRuleCall_13_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleTriggeredTransition11130);
                    lv_action_15_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"action",
                            		lv_action_15_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,14,FOLLOW_14_in_ruleTriggeredTransition11144); 

                	newLeafNode(otherlv_16, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_14());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTriggeredTransition"


    // $ANTLR start "entryRuleGuardedTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5514:1: entryRuleGuardedTransition returns [EObject current=null] : iv_ruleGuardedTransition= ruleGuardedTransition EOF ;
    public final EObject entryRuleGuardedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardedTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5515:2: (iv_ruleGuardedTransition= ruleGuardedTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5516:2: iv_ruleGuardedTransition= ruleGuardedTransition EOF
            {
             newCompositeNode(grammarAccess.getGuardedTransitionRule()); 
            pushFollow(FOLLOW_ruleGuardedTransition_in_entryRuleGuardedTransition11180);
            iv_ruleGuardedTransition=ruleGuardedTransition();

            state._fsp--;

             current =iv_ruleGuardedTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardedTransition11190); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGuardedTransition"


    // $ANTLR start "ruleGuardedTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5523:1: ruleGuardedTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
    public final EObject ruleGuardedTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_guard_9_0 = null;

        EObject lv_action_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5526:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5527:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5527:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5527:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,84,FOLLOW_84_in_ruleGuardedTransition11227); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardedTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5531:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==RULE_ID) ) {
                alt133=1;
            }
            switch (alt133) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5532:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5532:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5533:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGuardedTransition11244); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getGuardedTransitionAccess().getNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGuardedTransitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleGuardedTransition11262); 

                	newLeafNode(otherlv_2, grammarAccess.getGuardedTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5553:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5554:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5554:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5555:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition11283);
            lv_from_3_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"from",
                    		lv_from_3_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleGuardedTransition11295); 

                	newLeafNode(otherlv_4, grammarAccess.getGuardedTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5575:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5576:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5576:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5577:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition11316);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_5_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5593:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==29) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5594:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5594:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5595:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleGuardedTransition11337);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_6_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleGuardedTransition11350); 

                	newLeafNode(otherlv_7, grammarAccess.getGuardedTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,89,FOLLOW_89_in_ruleGuardedTransition11362); 

                	newLeafNode(otherlv_8, grammarAccess.getGuardedTransitionAccess().getGuardKeyword_8());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5619:1: ( (lv_guard_9_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5620:1: (lv_guard_9_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5620:1: (lv_guard_9_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5621:3: lv_guard_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getGuardDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleGuardedTransition11383);
            lv_guard_9_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"guard",
                    		lv_guard_9_0, 
                    		"DetailCode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5637:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==86) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5637:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,86,FOLLOW_86_in_ruleGuardedTransition11396); 

                        	newLeafNode(otherlv_10, grammarAccess.getGuardedTransitionAccess().getActionKeyword_10_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5641:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5642:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5642:1: (lv_action_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5643:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleGuardedTransition11417);
                    lv_action_11_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"action",
                            		lv_action_11_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleGuardedTransition11431); 

                	newLeafNode(otherlv_12, grammarAccess.getGuardedTransitionAccess().getRightCurlyBracketKeyword_11());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGuardedTransition"


    // $ANTLR start "entryRuleCPBranchTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5671:1: entryRuleCPBranchTransition returns [EObject current=null] : iv_ruleCPBranchTransition= ruleCPBranchTransition EOF ;
    public final EObject entryRuleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCPBranchTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5672:2: (iv_ruleCPBranchTransition= ruleCPBranchTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5673:2: iv_ruleCPBranchTransition= ruleCPBranchTransition EOF
            {
             newCompositeNode(grammarAccess.getCPBranchTransitionRule()); 
            pushFollow(FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition11467);
            iv_ruleCPBranchTransition=ruleCPBranchTransition();

            state._fsp--;

             current =iv_ruleCPBranchTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCPBranchTransition11477); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCPBranchTransition"


    // $ANTLR start "ruleCPBranchTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5680:1: ruleCPBranchTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
    public final EObject ruleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_condition_9_0 = null;

        EObject lv_action_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5683:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5684:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5684:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5684:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,84,FOLLOW_84_in_ruleCPBranchTransition11514); 

                	newLeafNode(otherlv_0, grammarAccess.getCPBranchTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5688:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==RULE_ID) ) {
                alt136=1;
            }
            switch (alt136) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5689:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5689:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5690:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCPBranchTransition11531); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getCPBranchTransitionAccess().getNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCPBranchTransitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleCPBranchTransition11549); 

                	newLeafNode(otherlv_2, grammarAccess.getCPBranchTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5710:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5711:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5711:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5712:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition11570);
            lv_from_3_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"from",
                    		lv_from_3_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleCPBranchTransition11582); 

                	newLeafNode(otherlv_4, grammarAccess.getCPBranchTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5732:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5733:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5733:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5734:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition11603);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_5_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5750:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==29) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5751:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5751:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5752:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleCPBranchTransition11624);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_6_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleCPBranchTransition11637); 

                	newLeafNode(otherlv_7, grammarAccess.getCPBranchTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,90,FOLLOW_90_in_ruleCPBranchTransition11649); 

                	newLeafNode(otherlv_8, grammarAccess.getCPBranchTransitionAccess().getCondKeyword_8());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5776:1: ( (lv_condition_9_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5777:1: (lv_condition_9_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5777:1: (lv_condition_9_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5778:3: lv_condition_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getConditionDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition11670);
            lv_condition_9_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_9_0, 
                    		"DetailCode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5794:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==86) ) {
                alt138=1;
            }
            switch (alt138) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5794:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,86,FOLLOW_86_in_ruleCPBranchTransition11683); 

                        	newLeafNode(otherlv_10, grammarAccess.getCPBranchTransitionAccess().getActionKeyword_10_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5798:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5799:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5799:1: (lv_action_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5800:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition11704);
                    lv_action_11_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"action",
                            		lv_action_11_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleCPBranchTransition11718); 

                	newLeafNode(otherlv_12, grammarAccess.getCPBranchTransitionAccess().getRightCurlyBracketKeyword_11());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCPBranchTransition"


    // $ANTLR start "entryRuleTransitionTerminal"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5828:1: entryRuleTransitionTerminal returns [EObject current=null] : iv_ruleTransitionTerminal= ruleTransitionTerminal EOF ;
    public final EObject entryRuleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5829:2: (iv_ruleTransitionTerminal= ruleTransitionTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5830:2: iv_ruleTransitionTerminal= ruleTransitionTerminal EOF
            {
             newCompositeNode(grammarAccess.getTransitionTerminalRule()); 
            pushFollow(FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal11754);
            iv_ruleTransitionTerminal=ruleTransitionTerminal();

            state._fsp--;

             current =iv_ruleTransitionTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionTerminal11764); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransitionTerminal"


    // $ANTLR start "ruleTransitionTerminal"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5837:1: ruleTransitionTerminal returns [EObject current=null] : (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) ;
    public final EObject ruleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_StateTerminal_0 = null;

        EObject this_TrPointTerminal_1 = null;

        EObject this_SubStateTrPointTerminal_2 = null;

        EObject this_ChoicepointTerminal_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5840:28: ( (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5841:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5841:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            int alt139=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA139_1 = input.LA(2);

                if ( (LA139_1==EOF||(LA139_1>=13 && LA139_1<=14)||LA139_1==18||LA139_1==29||LA139_1==73||(LA139_1>=78 && LA139_1<=84)) ) {
                    alt139=1;
                }
                else if ( (LA139_1==58) ) {
                    alt139=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 139, 1, input);

                    throw nvae;
                }
                }
                break;
            case 91:
                {
                alt139=2;
                }
                break;
            case 92:
                {
                alt139=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 139, 0, input);

                throw nvae;
            }

            switch (alt139) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5842:5: this_StateTerminal_0= ruleStateTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getStateTerminalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal11811);
                    this_StateTerminal_0=ruleStateTerminal();

                    state._fsp--;

                     
                            current = this_StateTerminal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5852:5: this_TrPointTerminal_1= ruleTrPointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getTrPointTerminalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal11838);
                    this_TrPointTerminal_1=ruleTrPointTerminal();

                    state._fsp--;

                     
                            current = this_TrPointTerminal_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5862:5: this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getSubStateTrPointTerminalParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal11865);
                    this_SubStateTrPointTerminal_2=ruleSubStateTrPointTerminal();

                    state._fsp--;

                     
                            current = this_SubStateTrPointTerminal_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5872:5: this_ChoicepointTerminal_3= ruleChoicepointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getChoicepointTerminalParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal11892);
                    this_ChoicepointTerminal_3=ruleChoicepointTerminal();

                    state._fsp--;

                     
                            current = this_ChoicepointTerminal_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransitionTerminal"


    // $ANTLR start "entryRuleStateTerminal"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5888:1: entryRuleStateTerminal returns [EObject current=null] : iv_ruleStateTerminal= ruleStateTerminal EOF ;
    public final EObject entryRuleStateTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5889:2: (iv_ruleStateTerminal= ruleStateTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5890:2: iv_ruleStateTerminal= ruleStateTerminal EOF
            {
             newCompositeNode(grammarAccess.getStateTerminalRule()); 
            pushFollow(FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal11927);
            iv_ruleStateTerminal=ruleStateTerminal();

            state._fsp--;

             current =iv_ruleStateTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateTerminal11937); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateTerminal"


    // $ANTLR start "ruleStateTerminal"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5897:1: ruleStateTerminal returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleStateTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5900:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5901:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5901:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5902:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5902:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5903:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStateTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStateTerminal11981); 

            		newLeafNode(otherlv_0, grammarAccess.getStateTerminalAccess().getStateBaseStateCrossReference_0()); 
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateTerminal"


    // $ANTLR start "entryRuleTrPointTerminal"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5922:1: entryRuleTrPointTerminal returns [EObject current=null] : iv_ruleTrPointTerminal= ruleTrPointTerminal EOF ;
    public final EObject entryRuleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5923:2: (iv_ruleTrPointTerminal= ruleTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5924:2: iv_ruleTrPointTerminal= ruleTrPointTerminal EOF
            {
             newCompositeNode(grammarAccess.getTrPointTerminalRule()); 
            pushFollow(FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal12016);
            iv_ruleTrPointTerminal=ruleTrPointTerminal();

            state._fsp--;

             current =iv_ruleTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPointTerminal12026); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrPointTerminal"


    // $ANTLR start "ruleTrPointTerminal"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5931:1: ruleTrPointTerminal returns [EObject current=null] : (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5934:28: ( (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5935:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5935:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5935:3: otherlv_0= 'my' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,91,FOLLOW_91_in_ruleTrPointTerminal12063); 

                	newLeafNode(otherlv_0, grammarAccess.getTrPointTerminalAccess().getMyKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5939:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5940:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5940:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5941:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTrPointTerminalRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTrPointTerminal12083); 

            		newLeafNode(otherlv_1, grammarAccess.getTrPointTerminalAccess().getTrPointTrPointCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrPointTerminal"


    // $ANTLR start "entryRuleSubStateTrPointTerminal"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5960:1: entryRuleSubStateTrPointTerminal returns [EObject current=null] : iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF ;
    public final EObject entryRuleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStateTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5961:2: (iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5962:2: iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF
            {
             newCompositeNode(grammarAccess.getSubStateTrPointTerminalRule()); 
            pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal12119);
            iv_ruleSubStateTrPointTerminal=ruleSubStateTrPointTerminal();

            state._fsp--;

             current =iv_ruleSubStateTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal12129); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubStateTrPointTerminal"


    // $ANTLR start "ruleSubStateTrPointTerminal"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5969:1: ruleSubStateTrPointTerminal returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5972:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5973:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5973:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5973:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5973:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5974:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5974:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5975:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal12174); 

            		newLeafNode(otherlv_0, grammarAccess.getSubStateTrPointTerminalAccess().getTrPointTrPointCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleSubStateTrPointTerminal12186); 

                	newLeafNode(otherlv_1, grammarAccess.getSubStateTrPointTerminalAccess().getOfKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5990:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5991:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5991:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5992:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal12206); 

            		newLeafNode(otherlv_2, grammarAccess.getSubStateTrPointTerminalAccess().getStateBaseStateCrossReference_2_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubStateTrPointTerminal"


    // $ANTLR start "entryRuleChoicepointTerminal"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6011:1: entryRuleChoicepointTerminal returns [EObject current=null] : iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF ;
    public final EObject entryRuleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicepointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6012:2: (iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6013:2: iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF
            {
             newCompositeNode(grammarAccess.getChoicepointTerminalRule()); 
            pushFollow(FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal12242);
            iv_ruleChoicepointTerminal=ruleChoicepointTerminal();

            state._fsp--;

             current =iv_ruleChoicepointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicepointTerminal12252); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChoicepointTerminal"


    // $ANTLR start "ruleChoicepointTerminal"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6020:1: ruleChoicepointTerminal returns [EObject current=null] : (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6023:28: ( (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6024:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6024:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6024:3: otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,92,FOLLOW_92_in_ruleChoicepointTerminal12289); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicepointTerminalAccess().getCpKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6028:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6029:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6029:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6030:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getChoicepointTerminalRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicepointTerminal12309); 

            		newLeafNode(otherlv_1, grammarAccess.getChoicepointTerminalAccess().getCpChoicePointCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChoicepointTerminal"


    // $ANTLR start "entryRuleTrigger"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6049:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6050:2: (iv_ruleTrigger= ruleTrigger EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6051:2: iv_ruleTrigger= ruleTrigger EOF
            {
             newCompositeNode(grammarAccess.getTriggerRule()); 
            pushFollow(FOLLOW_ruleTrigger_in_entryRuleTrigger12345);
            iv_ruleTrigger=ruleTrigger();

            state._fsp--;

             current =iv_ruleTrigger; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrigger12355); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrigger"


    // $ANTLR start "ruleTrigger"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6058:1: ruleTrigger returns [EObject current=null] : (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) ;
    public final EObject ruleTrigger() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_msgFromIfPairs_1_0 = null;

        EObject lv_msgFromIfPairs_3_0 = null;

        EObject lv_guard_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6061:28: ( (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6062:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6062:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6062:3: otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>'
            {
            otherlv_0=(Token)match(input,93,FOLLOW_93_in_ruleTrigger12392); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggerAccess().getLessThanSignKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6066:1: ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6067:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6067:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6068:3: lv_msgFromIfPairs_1_0= ruleMessageFromIf
            {
             
            	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger12413);
            lv_msgFromIfPairs_1_0=ruleMessageFromIf();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTriggerRule());
            	        }
                   		add(
                   			current, 
                   			"msgFromIfPairs",
                    		lv_msgFromIfPairs_1_0, 
                    		"MessageFromIf");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6084:2: (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )*
            loop140:
            do {
                int alt140=2;
                int LA140_0 = input.LA(1);

                if ( (LA140_0==94) ) {
                    alt140=1;
                }


                switch (alt140) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6084:4: otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    {
            	    otherlv_2=(Token)match(input,94,FOLLOW_94_in_ruleTrigger12426); 

            	        	newLeafNode(otherlv_2, grammarAccess.getTriggerAccess().getVerticalLineKeyword_2_0());
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6088:1: ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6089:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6089:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6090:3: lv_msgFromIfPairs_3_0= ruleMessageFromIf
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger12447);
            	    lv_msgFromIfPairs_3_0=ruleMessageFromIf();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTriggerRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"msgFromIfPairs",
            	            		lv_msgFromIfPairs_3_0, 
            	            		"MessageFromIf");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop140;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6106:4: ( (lv_guard_4_0= ruleGuard ) )?
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==89) ) {
                alt141=1;
            }
            switch (alt141) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6107:1: (lv_guard_4_0= ruleGuard )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6107:1: (lv_guard_4_0= ruleGuard )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6108:3: lv_guard_4_0= ruleGuard
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggerAccess().getGuardGuardParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleGuard_in_ruleTrigger12470);
                    lv_guard_4_0=ruleGuard();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTriggerRule());
                    	        }
                           		set(
                           			current, 
                           			"guard",
                            		lv_guard_4_0, 
                            		"Guard");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,95,FOLLOW_95_in_ruleTrigger12483); 

                	newLeafNode(otherlv_5, grammarAccess.getTriggerAccess().getGreaterThanSignKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrigger"


    // $ANTLR start "entryRuleMessageFromIf"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6136:1: entryRuleMessageFromIf returns [EObject current=null] : iv_ruleMessageFromIf= ruleMessageFromIf EOF ;
    public final EObject entryRuleMessageFromIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageFromIf = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6137:2: (iv_ruleMessageFromIf= ruleMessageFromIf EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6138:2: iv_ruleMessageFromIf= ruleMessageFromIf EOF
            {
             newCompositeNode(grammarAccess.getMessageFromIfRule()); 
            pushFollow(FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf12519);
            iv_ruleMessageFromIf=ruleMessageFromIf();

            state._fsp--;

             current =iv_ruleMessageFromIf; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessageFromIf12529); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageFromIf"


    // $ANTLR start "ruleMessageFromIf"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6145:1: ruleMessageFromIf returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMessageFromIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6148:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6149:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6149:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6149:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6149:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6150:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6150:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6151:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageFromIfRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf12574); 

            		newLeafNode(otherlv_0, grammarAccess.getMessageFromIfAccess().getMessageMessageCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleMessageFromIf12586); 

                	newLeafNode(otherlv_1, grammarAccess.getMessageFromIfAccess().getColonKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6166:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6167:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6167:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6168:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageFromIfRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf12606); 

            		newLeafNode(otherlv_2, grammarAccess.getMessageFromIfAccess().getFromInterfaceItemCrossReference_2_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessageFromIf"


    // $ANTLR start "entryRuleGuard"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6187:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6188:2: (iv_ruleGuard= ruleGuard EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6189:2: iv_ruleGuard= ruleGuard EOF
            {
             newCompositeNode(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_ruleGuard_in_entryRuleGuard12642);
            iv_ruleGuard=ruleGuard();

            state._fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuard12652); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGuard"


    // $ANTLR start "ruleGuard"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6196:1: ruleGuard returns [EObject current=null] : (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_guard_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6199:28: ( (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6200:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6200:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6200:3: otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,89,FOLLOW_89_in_ruleGuard12689); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getGuardKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6204:1: ( (lv_guard_1_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6205:1: (lv_guard_1_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6205:1: (lv_guard_1_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6206:3: lv_guard_1_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardAccess().getGuardDetailCodeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleGuard12710);
            lv_guard_1_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGuardRule());
            	        }
                   		set(
                   			current, 
                   			"guard",
                    		lv_guard_1_0, 
                    		"DetailCode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGuard"


    // $ANTLR start "entryRuleDocumentation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6230:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6231:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6232:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             newCompositeNode(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation12746);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation12756); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDocumentation"


    // $ANTLR start "ruleDocumentation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6239:1: ruleDocumentation returns [EObject current=null] : (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_text_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6242:28: ( (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6243:1: (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6243:1: (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6243:3: otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleDocumentation12793); 

                	newLeafNode(otherlv_0, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6247:1: ( (lv_text_1_0= RULE_STRING ) )+
            int cnt142=0;
            loop142:
            do {
                int alt142=2;
                int LA142_0 = input.LA(1);

                if ( (LA142_0==RULE_STRING) ) {
                    alt142=1;
                }


                switch (alt142) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6248:1: (lv_text_1_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6248:1: (lv_text_1_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6249:3: lv_text_1_0= RULE_STRING
            	    {
            	    lv_text_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDocumentation12810); 

            	    			newLeafNode(lv_text_1_0, grammarAccess.getDocumentationAccess().getTextSTRINGTerminalRuleCall_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDocumentationRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"text",
            	            		lv_text_1_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt142 >= 1 ) break loop142;
                        EarlyExitException eee =
                            new EarlyExitException(142, input);
                        throw eee;
                }
                cnt142++;
            } while (true);

            otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleDocumentation12828); 

                	newLeafNode(otherlv_2, grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDocumentation"


    // $ANTLR start "entryRuleAnnotation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6277:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6278:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6279:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FOLLOW_ruleAnnotation_in_entryRuleAnnotation12864);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotation12874); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6286:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_attributes_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6289:28: ( (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6290:1: (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6290:1: (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6290:3: otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,96,FOLLOW_96_in_ruleAnnotation12911); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6294:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6295:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6295:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6296:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotation12928); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAnnotationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6312:2: (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            int alt144=2;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==19) ) {
                alt144=1;
            }
            switch (alt144) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6312:4: otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleAnnotation12946); 

                        	newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6316:1: ( (lv_attributes_3_0= ruleKeyValue ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6317:1: (lv_attributes_3_0= ruleKeyValue )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6317:1: (lv_attributes_3_0= ruleKeyValue )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6318:3: lv_attributes_3_0= ruleKeyValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleKeyValue_in_ruleAnnotation12967);
                    lv_attributes_3_0=ruleKeyValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAnnotationRule());
                    	        }
                           		add(
                           			current, 
                           			"attributes",
                            		lv_attributes_3_0, 
                            		"KeyValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6334:2: (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )*
                    loop143:
                    do {
                        int alt143=2;
                        int LA143_0 = input.LA(1);

                        if ( (LA143_0==33) ) {
                            alt143=1;
                        }


                        switch (alt143) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6334:4: otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleAnnotation12980); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6338:1: ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6339:1: (lv_attributes_5_0= ruleKeyValue )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6339:1: (lv_attributes_5_0= ruleKeyValue )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6340:3: lv_attributes_5_0= ruleKeyValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleKeyValue_in_ruleAnnotation13001);
                    	    lv_attributes_5_0=ruleKeyValue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAnnotationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_5_0, 
                    	            		"KeyValue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop143;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleAnnotation13015); 

                        	newLeafNode(otherlv_6, grammarAccess.getAnnotationAccess().getRightParenthesisKeyword_2_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotation"


    // $ANTLR start "entryRuleKeyValue"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6368:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6369:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6370:2: iv_ruleKeyValue= ruleKeyValue EOF
            {
             newCompositeNode(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_ruleKeyValue_in_entryRuleKeyValue13053);
            iv_ruleKeyValue=ruleKeyValue();

            state._fsp--;

             current =iv_ruleKeyValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValue13063); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyValue"


    // $ANTLR start "ruleKeyValue"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6377:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6380:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6381:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6381:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6381:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6381:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6382:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6382:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6383:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyValue13105); 

            			newLeafNode(lv_key_0_0, grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKeyValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"key",
                    		lv_key_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleKeyValue13122); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6403:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6404:1: (lv_value_2_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6404:1: (lv_value_2_0= RULE_STRING )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6405:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyValue13139); 

            			newLeafNode(lv_value_2_0, grammarAccess.getKeyValueAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKeyValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyValue"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6429:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6430:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6431:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport13180);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport13190); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6438:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6441:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6442:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6442:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6442:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,97,FOLLOW_97_in_ruleImport13227); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6446:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==RULE_ID) ) {
                alt145=1;
            }
            else if ( (LA145_0==99) ) {
                alt145=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 145, 0, input);

                throw nvae;
            }
            switch (alt145) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6446:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6446:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6446:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6446:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6447:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6447:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6448:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleImportedFQN_in_ruleImport13250);
                    lv_importedNamespace_1_0=ruleImportedFQN();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getImportRule());
                    	        }
                           		set(
                           			current, 
                           			"importedNamespace",
                            		lv_importedNamespace_1_0, 
                            		"ImportedFQN");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,98,FOLLOW_98_in_ruleImport13262); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6469:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,99,FOLLOW_99_in_ruleImport13281); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6473:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6474:1: (lv_importURI_4_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6474:1: (lv_importURI_4_0= RULE_STRING )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6475:3: lv_importURI_4_0= RULE_STRING
            {
            lv_importURI_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport13299); 

            			newLeafNode(lv_importURI_4_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"importURI",
                    		lv_importURI_4_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportedFQN"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6499:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6500:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6501:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN13341);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN13352); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportedFQN"


    // $ANTLR start "ruleImportedFQN"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6508:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6511:28: ( (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6512:1: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6512:1: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6513:5: this_FQN_0= ruleFQN (kw= '.' kw= '*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN13399);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6523:1: (kw= '.' kw= '*' )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==64) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6524:2: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleImportedFQN13418); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getImportedFQNAccess().getFullStopKeyword_1_0()); 
                        
                    kw=(Token)match(input,100,FOLLOW_100_in_ruleImportedFQN13431); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getImportedFQNAccess().getAsteriskKeyword_1_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportedFQN"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6543:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6544:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6545:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN13474);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN13485); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6552:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6555:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6556:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6556:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6556:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN13525); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6563:1: (kw= '.' this_ID_2= RULE_ID )*
            loop147:
            do {
                int alt147=2;
                int LA147_0 = input.LA(1);

                if ( (LA147_0==64) ) {
                    int LA147_2 = input.LA(2);

                    if ( (LA147_2==RULE_ID) ) {
                        alt147=1;
                    }


                }


                switch (alt147) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6564:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,64,FOLLOW_64_in_ruleFQN13544); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN13559); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop147;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFQN"

    // Delegated rules


    protected DFA121 dfa121 = new DFA121(this);
    static final String DFA121_eotS =
        "\33\uffff";
    static final String DFA121_eofS =
        "\13\uffff\1\22\7\uffff\3\22\4\uffff\1\22";
    static final String DFA121_minS =
        "\1\124\1\4\1\17\1\4\1\22\4\4\2\22\1\15\2\4\1\22\1\4\1\5\1\16\1"+
        "\uffff\3\15\1\5\3\uffff\1\15";
    static final String DFA121_maxS =
        "\1\124\2\17\1\134\1\72\2\4\1\134\1\4\2\22\1\124\2\4\1\22\1\4\1"+
        "\5\1\132\1\uffff\3\124\1\36\3\uffff\1\124";
    static final String DFA121_acceptS =
        "\22\uffff\1\3\4\uffff\1\2\1\4\1\1\1\uffff";
    static final String DFA121_specialS =
        "\33\uffff}>";
    static final String[] DFA121_transitionS = {
            "\1\1",
            "\1\2\12\uffff\1\3",
            "\1\3",
            "\1\4\126\uffff\1\5\1\6",
            "\1\7\47\uffff\1\10",
            "\1\11",
            "\1\12",
            "\1\13\126\uffff\1\14\1\15",
            "\1\16",
            "\1\7",
            "\1\7",
            "\1\21\1\22\16\uffff\1\20\34\uffff\1\17\16\uffff\1\22\4\uffff"+
            "\7\22",
            "\1\23",
            "\1\24",
            "\1\7",
            "\1\25",
            "\1\26",
            "\1\22\107\uffff\1\22\1\31\1\uffff\1\27\1\30",
            "",
            "\1\21\1\22\16\uffff\1\20\53\uffff\1\22\4\uffff\7\22",
            "\1\21\1\22\16\uffff\1\20\53\uffff\1\22\4\uffff\7\22",
            "\1\21\1\22\16\uffff\1\20\53\uffff\1\22\4\uffff\7\22",
            "\1\26\30\uffff\1\32",
            "",
            "",
            "",
            "\1\21\1\22\72\uffff\1\22\4\uffff\7\22"
    };

    static final short[] DFA121_eot = DFA.unpackEncodedString(DFA121_eotS);
    static final short[] DFA121_eof = DFA.unpackEncodedString(DFA121_eofS);
    static final char[] DFA121_min = DFA.unpackEncodedStringToUnsignedChars(DFA121_minS);
    static final char[] DFA121_max = DFA.unpackEncodedStringToUnsignedChars(DFA121_maxS);
    static final short[] DFA121_accept = DFA.unpackEncodedString(DFA121_acceptS);
    static final short[] DFA121_special = DFA.unpackEncodedString(DFA121_specialS);
    static final short[][] DFA121_transition;

    static {
        int numStates = DFA121_transitionS.length;
        DFA121_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA121_transition[i] = DFA.unpackEncodedString(DFA121_transitionS[i]);
        }
    }

    class DFA121 extends DFA {

        public DFA121(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 121;
            this.eot = DFA121_eot;
            this.eof = DFA121_eof;
            this.min = DFA121_min;
            this.max = DFA121_max;
            this.accept = DFA121_accept;
            this.special = DFA121_special;
            this.transition = DFA121_transition;
        }
        public String getDescription() {
            return "5024:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition | this_ContinuationTransition_2= ruleContinuationTransition | this_CPBranchTransition_3= ruleCPBranchTransition )";
        }
    }
 

    public static final BitSet FOLLOW_ruleRoomModel_in_entryRuleRoomModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoomModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleRoomModel122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRoomModel143 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRoomModel164 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRoomModel177 = new BitSet(new long[]{0x2801801000C24000L,0x0000000200000000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleRoomModel198 = new BitSet(new long[]{0x2801801000C24000L,0x0000000200000000L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleRoomModel221 = new BitSet(new long[]{0x2801801000C24000L});
    public static final BitSet FOLLOW_ruleExternalType_in_ruleRoomModel248 = new BitSet(new long[]{0x2801801000C24000L});
    public static final BitSet FOLLOW_ruleDataClass_in_ruleRoomModel275 = new BitSet(new long[]{0x2801801000C24000L});
    public static final BitSet FOLLOW_ruleProtocolClass_in_ruleRoomModel302 = new BitSet(new long[]{0x2801801000C24000L});
    public static final BitSet FOLLOW_ruleActorClass_in_ruleRoomModel329 = new BitSet(new long[]{0x2801801000C24000L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_ruleRoomModel356 = new BitSet(new long[]{0x2801801000C24000L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_ruleRoomModel383 = new BitSet(new long[]{0x2801801000C24000L});
    public static final BitSet FOLLOW_14_in_ruleRoomModel397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructureClass_in_entryRuleStructureClass435 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStructureClass445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorContainerClass_in_ruleStructureClass492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_ruleStructureClass519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorContainerClass_in_entryRuleActorContainerClass554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorContainerClass564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClass_in_ruleActorContainerClass611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_ruleActorContainerClass638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarDecl_in_entryRuleVarDecl673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarDecl683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarDecl725 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleVarDecl742 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRefableType_in_ruleVarDecl763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefableType_in_entryRuleRefableType799 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefableType809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRefableType857 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleRefableType875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType925 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataType935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleDataType982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexType_in_ruleDataType1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexType_in_entryRuleComplexType1044 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexType1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataClass_in_ruleComplexType1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalType_in_ruleComplexType1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType1163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveType1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rulePrimitiveType1210 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePrimitiveType1227 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePrimitiveType1244 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePrimitiveType1265 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_19_in_rulePrimitiveType1278 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePrimitiveType1299 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_rulePrimitiveType1311 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rulePrimitiveType1325 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePrimitiveType1342 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rulePrimitiveType1368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalType_in_entryRuleExternalType1405 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalType1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleExternalType1452 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalType1469 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleExternalType1486 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleExternalType1507 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleExternalType1528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataClass_in_entryRuleDataClass1565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataClass1575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleDataClass1612 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataClass1629 = new BitSet(new long[]{0x0000000021002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleDataClass1655 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_24_in_ruleDataClass1669 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleDataClass1692 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleDataClass1706 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_25_in_ruleDataClass1719 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleDataClass1740 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_26_in_ruleDataClass1755 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleDataClass1776 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_27_in_ruleDataClass1791 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleDataClass1812 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleDataClass1835 = new BitSet(new long[]{0x000000011E004000L});
    public static final BitSet FOLLOW_ruleStandardOperation_in_ruleDataClass1857 = new BitSet(new long[]{0x0000000100004000L});
    public static final BitSet FOLLOW_14_in_ruleDataClass1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1906 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAttribute1953 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1970 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_29_in_ruleAttribute1988 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAttribute2005 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleAttribute2022 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAttribute2036 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRefableType_in_ruleAttribute2057 = new BitSet(new long[]{0x00000000A0000002L});
    public static final BitSet FOLLOW_31_in_ruleAttribute2070 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute2087 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleAttribute2115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStandardOperation_in_entryRuleStandardOperation2154 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStandardOperation2164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleStandardOperation2201 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStandardOperation2218 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleStandardOperation2235 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_ruleStandardOperation2257 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_33_in_ruleStandardOperation2270 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_ruleStandardOperation2291 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_20_in_ruleStandardOperation2307 = new BitSet(new long[]{0x000000002000A000L});
    public static final BitSet FOLLOW_15_in_ruleStandardOperation2320 = new BitSet(new long[]{0x0000000400000010L});
    public static final BitSet FOLLOW_34_in_ruleStandardOperation2333 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleRefableType_in_ruleStandardOperation2360 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleStandardOperation2384 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleStandardOperation2406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortOperation_in_entryRulePortOperation2442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortOperation2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rulePortOperation2489 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortOperation2506 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePortOperation2523 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_rulePortOperation2545 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_33_in_rulePortOperation2558 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_rulePortOperation2579 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_20_in_rulePortOperation2595 = new BitSet(new long[]{0x000000082000A000L});
    public static final BitSet FOLLOW_15_in_rulePortOperation2609 = new BitSet(new long[]{0x0000000400000010L});
    public static final BitSet FOLLOW_34_in_rulePortOperation2622 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleRefableType_in_rulePortOperation2649 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_35_in_rulePortOperation2670 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortOperation2690 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rulePortOperation2714 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_rulePortOperation2736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolClass_in_entryRuleProtocolClass2772 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProtocolClass2782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleProtocolClass2819 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProtocolClass2836 = new BitSet(new long[]{0x0000000021002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleProtocolClass2862 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_24_in_ruleProtocolClass2876 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleProtocolClass2899 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass2913 = new BitSet(new long[]{0x000042E00E004000L});
    public static final BitSet FOLLOW_25_in_ruleProtocolClass2926 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleProtocolClass2947 = new BitSet(new long[]{0x000042E00C004000L});
    public static final BitSet FOLLOW_26_in_ruleProtocolClass2962 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleProtocolClass2983 = new BitSet(new long[]{0x000042E008004000L});
    public static final BitSet FOLLOW_27_in_ruleProtocolClass2998 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleProtocolClass3019 = new BitSet(new long[]{0x000042E000004000L});
    public static final BitSet FOLLOW_37_in_ruleProtocolClass3034 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass3046 = new BitSet(new long[]{0x00000C0000004000L});
    public static final BitSet FOLLOW_ruleMessage_in_ruleProtocolClass3067 = new BitSet(new long[]{0x00000C0000004000L});
    public static final BitSet FOLLOW_14_in_ruleProtocolClass3080 = new BitSet(new long[]{0x000042C000004000L});
    public static final BitSet FOLLOW_38_in_ruleProtocolClass3095 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass3107 = new BitSet(new long[]{0x00000C0000004000L});
    public static final BitSet FOLLOW_ruleMessage_in_ruleProtocolClass3128 = new BitSet(new long[]{0x00000C0000004000L});
    public static final BitSet FOLLOW_14_in_ruleProtocolClass3141 = new BitSet(new long[]{0x0000428000004000L});
    public static final BitSet FOLLOW_39_in_ruleProtocolClass3156 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleProtocolClass3168 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rulePortClass_in_ruleProtocolClass3189 = new BitSet(new long[]{0x0000420000004000L});
    public static final BitSet FOLLOW_41_in_ruleProtocolClass3204 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleProtocolClass3216 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rulePortClass_in_ruleProtocolClass3237 = new BitSet(new long[]{0x0000400000004000L});
    public static final BitSet FOLLOW_ruleProtocolSemantics_in_ruleProtocolClass3260 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleProtocolClass3273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessage_in_entryRuleMessage3309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessage3319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleMessage3362 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleMessage3388 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessage3405 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleMessage3422 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_ruleMessage3443 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleMessage3456 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleMessage3477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClass_in_entryRulePortClass3514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortClass3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rulePortClass3561 = new BitSet(new long[]{0x000030011E000000L});
    public static final BitSet FOLLOW_44_in_rulePortClass3574 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_rulePortClass3595 = new BitSet(new long[]{0x000030011E000000L});
    public static final BitSet FOLLOW_ruleAttribute_in_rulePortClass3619 = new BitSet(new long[]{0x000030011E004000L});
    public static final BitSet FOLLOW_rulePortOperation_in_rulePortClass3646 = new BitSet(new long[]{0x000030011E004000L});
    public static final BitSet FOLLOW_ruleMessageHandler_in_rulePortClass3673 = new BitSet(new long[]{0x000030011E004000L});
    public static final BitSet FOLLOW_14_in_rulePortClass3687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessageHandler_in_entryRuleMessageHandler3723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageHandler3733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleMessageHandler3770 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageHandler3790 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleMessageHandler3811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolSemantics_in_entryRuleProtocolSemantics3847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProtocolSemantics3857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleProtocolSemantics3903 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolSemantics3915 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleProtocolSemantics3936 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleProtocolSemantics3949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_entryRuleSemanticsRule3985 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSemanticsRule3995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSemanticsRule4040 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleSemanticsRule4053 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleSemanticsRule4075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSemanticsRule4094 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleSemanticsRule4115 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleSemanticsRule4128 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleSemanticsRule4149 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_20_in_ruleSemanticsRule4163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClass_in_entryRuleActorClass4203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorClass4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleActorClass4256 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleActorClass4282 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorClass4299 = new BitSet(new long[]{0x0000000021002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorClass4325 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_24_in_ruleActorClass4339 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorClass4362 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass4376 = new BitSet(new long[]{0x000E000000004000L});
    public static final BitSet FOLLOW_49_in_ruleActorClass4389 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass4401 = new BitSet(new long[]{0x0130000000004000L});
    public static final BitSet FOLLOW_rulePort_in_ruleActorClass4422 = new BitSet(new long[]{0x0130000000004000L});
    public static final BitSet FOLLOW_ruleSPPRef_in_ruleActorClass4444 = new BitSet(new long[]{0x0100000000004000L});
    public static final BitSet FOLLOW_14_in_ruleActorClass4457 = new BitSet(new long[]{0x000C000000004000L});
    public static final BitSet FOLLOW_50_in_ruleActorClass4472 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorClass4493 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass4506 = new BitSet(new long[]{0x02F000001E004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_25_in_ruleActorClass4519 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleActorClass4540 = new BitSet(new long[]{0x02F000001E004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_26_in_ruleActorClass4555 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleActorClass4576 = new BitSet(new long[]{0x02F000001E004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_27_in_ruleActorClass4591 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleActorClass4612 = new BitSet(new long[]{0x02F000001E004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_rulePort_in_ruleActorClass4636 = new BitSet(new long[]{0x02F000001E004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_ruleExternalPort_in_ruleActorClass4663 = new BitSet(new long[]{0x02F000001E004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_ruleServiceImplementation_in_ruleActorClass4686 = new BitSet(new long[]{0x028000001E004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_ruleSAPRef_in_ruleActorClass4708 = new BitSet(new long[]{0x008000001E004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleActorClass4730 = new BitSet(new long[]{0x000000001E004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_ruleActorRef_in_ruleActorClass4752 = new BitSet(new long[]{0x0000000000004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_ruleBinding_in_ruleActorClass4774 = new BitSet(new long[]{0x0000000000004000L,0x000000000000000AL});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleActorClass4796 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000008L});
    public static final BitSet FOLLOW_14_in_ruleActorClass4809 = new BitSet(new long[]{0x0008000000004000L});
    public static final BitSet FOLLOW_51_in_ruleActorClass4824 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorClass4845 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass4858 = new BitSet(new long[]{0x0000000100004000L,0x0000000100000180L});
    public static final BitSet FOLLOW_ruleAnnotation_in_ruleActorClass4879 = new BitSet(new long[]{0x0000000100004000L,0x0000000100000180L});
    public static final BitSet FOLLOW_ruleStandardOperation_in_ruleActorClass4901 = new BitSet(new long[]{0x0000000100004000L,0x0000000000000180L});
    public static final BitSet FOLLOW_ruleStateMachine_in_ruleActorClass4923 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleActorClass4936 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleActorClass4950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePort_in_entryRulePort4988 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePort4998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rulePort5041 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_rulePort5067 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePort5084 = new BitSet(new long[]{0x0000000000008080L});
    public static final BitSet FOLLOW_RULE_MULTIPLICITY_in_rulePort5106 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePort5124 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePort5147 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rulePort5168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalPort_in_entryRuleExternalPort5205 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalPort5215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleExternalPort5252 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleExternalPort5264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalPort5284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSAPRef_in_entryRuleSAPRef5320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSAPRef5330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleSAPRef5367 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSAPRef5384 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSAPRef5401 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSAPRef5424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSPPRef_in_entryRuleSPPRef5460 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSPPRef5470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSPPRef5507 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPRef5524 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSPPRef5541 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSPPRef5564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleServiceImplementation_in_entryRuleServiceImplementation5600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleServiceImplementation5610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleServiceImplementation5647 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleServiceImplementation5659 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleServiceImplementation5679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_entryRuleLogicalSystem5715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalSystem5725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleLogicalSystem5762 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLogicalSystem5779 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleLogicalSystem5805 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLogicalSystem5818 = new BitSet(new long[]{0x1000000000004000L,0x000000000000000AL});
    public static final BitSet FOLLOW_ruleSubSystemRef_in_ruleLogicalSystem5839 = new BitSet(new long[]{0x1000000000004000L,0x000000000000000AL});
    public static final BitSet FOLLOW_ruleBinding_in_ruleLogicalSystem5861 = new BitSet(new long[]{0x0000000000004000L,0x000000000000000AL});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleLogicalSystem5883 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000008L});
    public static final BitSet FOLLOW_14_in_ruleLogicalSystem5896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemRef_in_entryRuleSubSystemRef5934 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemRef5944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleSubSystemRef5981 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemRef5998 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSubSystemRef6015 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSubSystemRef6038 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleSubSystemRef6059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_entryRuleSubSystemClass6096 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemClass6106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleSubSystemClass6143 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemClass6160 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleSubSystemClass6186 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSubSystemClass6199 = new BitSet(new long[]{0x413000000E004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_25_in_ruleSubSystemClass6212 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSubSystemClass6233 = new BitSet(new long[]{0x413000000C004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_26_in_ruleSubSystemClass6248 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSubSystemClass6269 = new BitSet(new long[]{0x4130000008004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_27_in_ruleSubSystemClass6284 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSubSystemClass6305 = new BitSet(new long[]{0x4130000000004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_rulePort_in_ruleSubSystemClass6328 = new BitSet(new long[]{0x4130000000004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_ruleSPPRef_in_ruleSubSystemClass6350 = new BitSet(new long[]{0x4100000000004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_ruleActorRef_in_ruleSubSystemClass6372 = new BitSet(new long[]{0x4000000000004000L,0x000000000000004AL});
    public static final BitSet FOLLOW_ruleBinding_in_ruleSubSystemClass6394 = new BitSet(new long[]{0x4000000000004000L,0x000000000000000AL});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleSubSystemClass6416 = new BitSet(new long[]{0x4000000000004000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleLogicalThread_in_ruleSubSystemClass6438 = new BitSet(new long[]{0x4000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSubSystemClass6451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalThread_in_entryRuleLogicalThread6487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalThread6497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleLogicalThread6534 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLogicalThread6551 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleLogicalThread6568 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleLogicalThread6580 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLogicalThread6597 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLogicalThread6614 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_ruleLogicalThread6635 = new BitSet(new long[]{0x0000000200004000L});
    public static final BitSet FOLLOW_33_in_ruleLogicalThread6648 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_ruleLogicalThread6669 = new BitSet(new long[]{0x0000000200004000L});
    public static final BitSet FOLLOW_14_in_ruleLogicalThread6683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_entryRuleActorInstancePath6719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorInstancePath6729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorInstancePath6771 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleActorInstancePath6789 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorInstancePath6806 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleBinding_in_entryRuleBinding6849 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBinding6859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleBinding6896 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_ruleBinding6917 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleBinding6929 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_ruleBinding6950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_entryRuleBindingEndPoint6986 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBindingEndPoint6996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBindingEndPoint7042 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleBindingEndPoint7054 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBindingEndPoint7076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_entryRuleLayerConnection7112 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLayerConnection7122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleLayerConnection7159 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSAPoint_in_ruleLayerConnection7180 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleLayerConnection7192 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSPPoint_in_ruleLayerConnection7213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSAPoint_in_entryRuleSAPoint7249 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSAPoint7259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefSAPoint_in_ruleSAPoint7306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelaySAPoint_in_ruleSAPoint7333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefSAPoint_in_entryRuleRefSAPoint7368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefSAPoint7378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleRefSAPoint7415 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefSAPoint7435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelaySAPoint_in_entryRuleRelaySAPoint7471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelaySAPoint7481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleRelaySAPoint7518 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRelaySAPoint7538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSPPoint_in_entryRuleSPPoint7574 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSPPoint7584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPoint7629 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleSPPoint7641 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPoint7661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorRef_in_entryRuleActorRef7697 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorRef7707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleActorRef7744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorRef7761 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleActorRef7778 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorRef7801 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorRef7822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateGraphNode_in_entryRuleStateGraphNode7859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateGraphNode7869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateGraphNode7916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateGraphNode7943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateGraphNode7970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState8007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState8017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBaseState_in_ruleState8064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedState_in_ruleState8091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateGraph_in_entryRuleStateGraph8126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateGraph8136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlainStateGraph_in_ruleStateGraph8183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_ruleStateGraph8210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlainStateGraph_in_entryRulePlainStateGraph8245 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlainStateGraph8255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rulePlainStateGraph8301 = new BitSet(new long[]{0x0000000000004000L,0x00000000001FC200L});
    public static final BitSet FOLLOW_ruleState_in_rulePlainStateGraph8323 = new BitSet(new long[]{0x0000000000004000L,0x00000000001FC200L});
    public static final BitSet FOLLOW_ruleTrPoint_in_rulePlainStateGraph8350 = new BitSet(new long[]{0x0000000000004000L,0x00000000001FC200L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_rulePlainStateGraph8377 = new BitSet(new long[]{0x0000000000004000L,0x00000000001FC200L});
    public static final BitSet FOLLOW_ruleTransition_in_rulePlainStateGraph8404 = new BitSet(new long[]{0x0000000000004000L,0x00000000001FC200L});
    public static final BitSet FOLLOW_14_in_rulePlainStateGraph8418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_entryRuleStateMachine8454 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateMachine8464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleStateMachine8516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleStateMachine8542 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleStateMachine8554 = new BitSet(new long[]{0x0000000000004000L,0x00000000001FC200L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateMachine8576 = new BitSet(new long[]{0x0000000000004000L,0x00000000001FC200L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateMachine8603 = new BitSet(new long[]{0x0000000000004000L,0x00000000001FC200L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateMachine8630 = new BitSet(new long[]{0x0000000000004000L,0x00000000001FC200L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateMachine8657 = new BitSet(new long[]{0x0000000000004000L,0x00000000001FC200L});
    public static final BitSet FOLLOW_14_in_ruleStateMachine8671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBaseState_in_entryRuleBaseState8707 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBaseState8717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleBaseState8754 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBaseState8771 = new BitSet(new long[]{0x0000000020002002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleBaseState8797 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleBaseState8811 = new BitSet(new long[]{0x0000000000004000L,0x0000000000003C00L});
    public static final BitSet FOLLOW_74_in_ruleBaseState8824 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleBaseState8845 = new BitSet(new long[]{0x0000000000004000L,0x0000000000003800L});
    public static final BitSet FOLLOW_75_in_ruleBaseState8860 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleBaseState8881 = new BitSet(new long[]{0x0000000000004000L,0x0000000000003000L});
    public static final BitSet FOLLOW_76_in_ruleBaseState8896 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleBaseState8917 = new BitSet(new long[]{0x0000000000004000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ruleBaseState8932 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rulePlainStateGraph_in_ruleBaseState8953 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleBaseState8967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedState_in_entryRuleRefinedState9005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefinedState9015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleRefinedState9052 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRefinedState9075 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRefinedState9096 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRefinedState9109 = new BitSet(new long[]{0x0000000000004000L,0x0000000000003C00L});
    public static final BitSet FOLLOW_74_in_ruleRefinedState9122 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState9143 = new BitSet(new long[]{0x0000000000004000L,0x0000000000003800L});
    public static final BitSet FOLLOW_75_in_ruleRefinedState9158 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState9179 = new BitSet(new long[]{0x0000000000004000L,0x0000000000003000L});
    public static final BitSet FOLLOW_76_in_ruleRefinedState9194 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState9215 = new BitSet(new long[]{0x0000000000004000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ruleRefinedState9230 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000180L});
    public static final BitSet FOLLOW_ruleStateGraph_in_ruleRefinedState9251 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleRefinedState9265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDetailCode_in_entryRuleDetailCode9301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDetailCode9311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleDetailCode9348 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDetailCode9365 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_14_in_ruleDetailCode9383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPoint_in_entryRuleTrPoint9419 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPoint9429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_ruleTrPoint9476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_ruleTrPoint9503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_ruleTrPoint9530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint9565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionPoint9575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleTransitionPoint9618 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_ruleTransitionPoint9644 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransitionPoint9661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint9702 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryPoint9712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleEntryPoint9749 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntryPoint9766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_entryRuleExitPoint9807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitPoint9817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleExitPoint9854 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitPoint9871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint9912 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicePoint9922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleChoicePoint9959 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicePoint9976 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleChoicePoint10002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition10039 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition10049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_ruleTransition10096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_ruleTransition10123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition10158 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonInitialTransition10168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_ruleNonInitialTransition10215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardedTransition_in_ruleNonInitialTransition10242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition10269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition10296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition10331 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInitialTransition10341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleInitialTransition10378 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInitialTransition10395 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleInitialTransition10413 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_ruleInitialTransition10425 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleInitialTransition10437 = new BitSet(new long[]{0x0000000000000010L,0x0000000018000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition10458 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleInitialTransition10479 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleInitialTransition10492 = new BitSet(new long[]{0x0000000000004000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleInitialTransition10505 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleInitialTransition10526 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleInitialTransition10540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition10576 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContinuationTransition10586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleContinuationTransition10623 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContinuationTransition10640 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleContinuationTransition10658 = new BitSet(new long[]{0x0000000000000010L,0x0000000018000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition10679 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleContinuationTransition10691 = new BitSet(new long[]{0x0000000000000010L,0x0000000018000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition10712 = new BitSet(new long[]{0x0000000020002002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleContinuationTransition10733 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleContinuationTransition10747 = new BitSet(new long[]{0x0000000000004000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleContinuationTransition10760 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleContinuationTransition10781 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleContinuationTransition10795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition10833 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggeredTransition10843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleTriggeredTransition10880 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggeredTransition10897 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTriggeredTransition10915 = new BitSet(new long[]{0x0000000000000010L,0x0000000018000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition10936 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTriggeredTransition10948 = new BitSet(new long[]{0x0000000000000010L,0x0000000018000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition10969 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleTriggeredTransition10990 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTriggeredTransition11003 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_ruleTriggeredTransition11015 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTriggeredTransition11027 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition11048 = new BitSet(new long[]{0x0000000000004000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_ruleTriggeredTransition11061 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition11082 = new BitSet(new long[]{0x0000000000004000L,0x0000000001000000L});
    public static final BitSet FOLLOW_14_in_ruleTriggeredTransition11096 = new BitSet(new long[]{0x0000000000004000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleTriggeredTransition11109 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleTriggeredTransition11130 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTriggeredTransition11144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardedTransition_in_entryRuleGuardedTransition11180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardedTransition11190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleGuardedTransition11227 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGuardedTransition11244 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGuardedTransition11262 = new BitSet(new long[]{0x0000000000000010L,0x0000000018000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition11283 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleGuardedTransition11295 = new BitSet(new long[]{0x0000000000000010L,0x0000000018000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition11316 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleGuardedTransition11337 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleGuardedTransition11350 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_ruleGuardedTransition11362 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuardedTransition11383 = new BitSet(new long[]{0x0000000000004000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleGuardedTransition11396 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuardedTransition11417 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleGuardedTransition11431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition11467 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCPBranchTransition11477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleCPBranchTransition11514 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCPBranchTransition11531 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCPBranchTransition11549 = new BitSet(new long[]{0x0000000000000010L,0x0000000018000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition11570 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleCPBranchTransition11582 = new BitSet(new long[]{0x0000000000000010L,0x0000000018000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition11603 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleCPBranchTransition11624 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleCPBranchTransition11637 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ruleCPBranchTransition11649 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition11670 = new BitSet(new long[]{0x0000000000004000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleCPBranchTransition11683 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition11704 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCPBranchTransition11718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal11754 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionTerminal11764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal11811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal11838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal11865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal11892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal11927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateTerminal11937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStateTerminal11981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal12016 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPointTerminal12026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleTrPointTerminal12063 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTrPointTerminal12083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal12119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal12129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal12174 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleSubStateTrPointTerminal12186 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal12206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal12242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicepointTerminal12252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleChoicepointTerminal12289 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicepointTerminal12309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrigger_in_entryRuleTrigger12345 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrigger12355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleTrigger12392 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger12413 = new BitSet(new long[]{0x0000000000000000L,0x00000000C2000000L});
    public static final BitSet FOLLOW_94_in_ruleTrigger12426 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger12447 = new BitSet(new long[]{0x0000000000000000L,0x00000000C2000000L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleTrigger12470 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_ruleTrigger12483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf12519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageFromIf12529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf12574 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleMessageFromIf12586 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf12606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard12642 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard12652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_ruleGuard12689 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuard12710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation12746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation12756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDocumentation12793 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDocumentation12810 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_30_in_ruleDocumentation12828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotation_in_entryRuleAnnotation12864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotation12874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_ruleAnnotation12911 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotation12928 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleAnnotation12946 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleKeyValue_in_ruleAnnotation12967 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_33_in_ruleAnnotation12980 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleKeyValue_in_ruleAnnotation13001 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_20_in_ruleAnnotation13015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_entryRuleKeyValue13053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValue13063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyValue13105 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleKeyValue13122 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyValue13139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport13180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport13190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_ruleImport13227 = new BitSet(new long[]{0x0000000000000010L,0x0000000800000000L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_ruleImport13250 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_ruleImport13262 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_99_in_ruleImport13281 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport13299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN13341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN13352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN13399 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleImportedFQN13418 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_ruleImportedFQN13431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN13474 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN13485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN13525 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleFQN13544 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN13559 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});

}