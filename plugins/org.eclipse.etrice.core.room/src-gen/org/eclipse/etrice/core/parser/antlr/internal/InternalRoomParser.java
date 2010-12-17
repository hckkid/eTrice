package org.eclipse.etrice.core.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.etrice.core.services.RoomGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRoomParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'RoomModel'", "'{'", "'}'", "':'", "'DataClass'", "'extends'", "'Attribute'", "'['", "']'", "'Operation'", "'('", "','", "')'", "'ProtocolClass'", "'usercode1'", "'usercode2'", "'incoming'", "'outgoing'", "'regular'", "'PortClass'", "'conjugate'", "'Message'", "'usercode'", "'handle'", "'semantics'", "'in'", "'->'", "'out'", "'abstract'", "'ActorClass'", "'Interface'", "'Structure'", "'Behavior'", "'conjugated'", "'Port'", "'external'", "'SAP'", "'SPP'", "'ServiceImplementation'", "'of'", "'LogicalSystem'", "'SubSystemRef'", "'SubSystemClass'", "'LogicalThread'", "'.'", "'Binding'", "'and'", "'LayerConnection'", "'satisfied_by'", "'ref'", "'relay_sap'", "'ActorRef'", "'StateMachine'", "'State'", "'entry'", "'exit'", "'subgraph'", "'RefinedState'", "'handler'", "'TransitionPoint'", "'EntryPoint'", "'ExitPoint'", "'ChoicePoint'", "'Transition'", "'initial'", "'action'", "'triggers'", "'or'", "'cond'", "'my'", "'cp'", "'<'", "'|'", "'>'", "'guard'", "'import'", "'*'", "'void'", "'int8'", "'int16'", "'int32'", "'uint8'", "'uint16'", "'uint32'", "'float32'", "'float64'", "'boolean'", "'string'", "'char'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalRoomParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g"; }



     	private RoomGrammarAccess grammarAccess;
     	
        public InternalRoomParser(TokenStream input, IAstFactory factory, RoomGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RoomModel";	
       	}
       	
       	@Override
       	protected RoomGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleRoomModel
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:78:1: entryRuleRoomModel returns [EObject current=null] : iv_ruleRoomModel= ruleRoomModel EOF ;
    public final EObject entryRuleRoomModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoomModel = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:79:2: (iv_ruleRoomModel= ruleRoomModel EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:80:2: iv_ruleRoomModel= ruleRoomModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRoomModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleRoomModel_in_entryRuleRoomModel75);
            iv_ruleRoomModel=ruleRoomModel();
            _fsp--;

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
    // $ANTLR end entryRuleRoomModel


    // $ANTLR start ruleRoomModel
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:87:1: ruleRoomModel returns [EObject current=null] : ( 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_dataClasses_4_0= ruleDataClass ) ) | ( (lv_protocolClasses_5_0= ruleProtocolClass ) ) | ( (lv_actorClasses_6_0= ruleActorClass ) ) | ( (lv_subSystemClasses_7_0= ruleSubSystemClass ) ) | ( (lv_systems_8_0= ruleLogicalSystem ) ) )+ '}' ) ;
    public final EObject ruleRoomModel() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_imports_3_0 = null;

        EObject lv_dataClasses_4_0 = null;

        EObject lv_protocolClasses_5_0 = null;

        EObject lv_actorClasses_6_0 = null;

        EObject lv_subSystemClasses_7_0 = null;

        EObject lv_systems_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:92:6: ( ( 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_dataClasses_4_0= ruleDataClass ) ) | ( (lv_protocolClasses_5_0= ruleProtocolClass ) ) | ( (lv_actorClasses_6_0= ruleActorClass ) ) | ( (lv_subSystemClasses_7_0= ruleSubSystemClass ) ) | ( (lv_systems_8_0= ruleLogicalSystem ) ) )+ '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:93:1: ( 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_dataClasses_4_0= ruleDataClass ) ) | ( (lv_protocolClasses_5_0= ruleProtocolClass ) ) | ( (lv_actorClasses_6_0= ruleActorClass ) ) | ( (lv_subSystemClasses_7_0= ruleSubSystemClass ) ) | ( (lv_systems_8_0= ruleLogicalSystem ) ) )+ '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:93:1: ( 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_dataClasses_4_0= ruleDataClass ) ) | ( (lv_protocolClasses_5_0= ruleProtocolClass ) ) | ( (lv_actorClasses_6_0= ruleActorClass ) ) | ( (lv_subSystemClasses_7_0= ruleSubSystemClass ) ) | ( (lv_systems_8_0= ruleLogicalSystem ) ) )+ '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:93:3: 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_dataClasses_4_0= ruleDataClass ) ) | ( (lv_protocolClasses_5_0= ruleProtocolClass ) ) | ( (lv_actorClasses_6_0= ruleActorClass ) ) | ( (lv_subSystemClasses_7_0= ruleSubSystemClass ) ) | ( (lv_systems_8_0= ruleLogicalSystem ) ) )+ '}'
            {
            match(input,11,FOLLOW_11_in_ruleRoomModel120); 

                    createLeafNode(grammarAccess.getRoomModelAccess().getRoomModelKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:97:1: ( (lv_name_1_0= ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:98:1: (lv_name_1_0= ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:98:1: (lv_name_1_0= ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:99:3: lv_name_1_0= ruleFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getNameFQNParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRoomModel141);
            lv_name_1_0=ruleFQN();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"FQN", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleRoomModel151); 

                    createLeafNode(grammarAccess.getRoomModelAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:125:1: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==86) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:126:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:126:1: (lv_imports_3_0= ruleImport )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:127:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getImportsImportParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleRoomModel172);
            	    lv_imports_3_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"imports",
            	    	        		lv_imports_3_0, 
            	    	        		"Import", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:149:3: ( ( (lv_dataClasses_4_0= ruleDataClass ) ) | ( (lv_protocolClasses_5_0= ruleProtocolClass ) ) | ( (lv_actorClasses_6_0= ruleActorClass ) ) | ( (lv_subSystemClasses_7_0= ruleSubSystemClass ) ) | ( (lv_systems_8_0= ruleLogicalSystem ) ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=6;
                switch ( input.LA(1) ) {
                case 15:
                    {
                    alt2=1;
                    }
                    break;
                case 24:
                    {
                    alt2=2;
                    }
                    break;
                case 39:
                case 40:
                    {
                    alt2=3;
                    }
                    break;
                case 53:
                    {
                    alt2=4;
                    }
                    break;
                case 51:
                    {
                    alt2=5;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:149:4: ( (lv_dataClasses_4_0= ruleDataClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:149:4: ( (lv_dataClasses_4_0= ruleDataClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:150:1: (lv_dataClasses_4_0= ruleDataClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:150:1: (lv_dataClasses_4_0= ruleDataClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:151:3: lv_dataClasses_4_0= ruleDataClass
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getDataClassesDataClassParserRuleCall_4_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleDataClass_in_ruleRoomModel195);
            	    lv_dataClasses_4_0=ruleDataClass();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"dataClasses",
            	    	        		lv_dataClasses_4_0, 
            	    	        		"DataClass", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:174:6: ( (lv_protocolClasses_5_0= ruleProtocolClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:174:6: ( (lv_protocolClasses_5_0= ruleProtocolClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:175:1: (lv_protocolClasses_5_0= ruleProtocolClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:175:1: (lv_protocolClasses_5_0= ruleProtocolClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:176:3: lv_protocolClasses_5_0= ruleProtocolClass
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getProtocolClassesProtocolClassParserRuleCall_4_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleProtocolClass_in_ruleRoomModel222);
            	    lv_protocolClasses_5_0=ruleProtocolClass();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"protocolClasses",
            	    	        		lv_protocolClasses_5_0, 
            	    	        		"ProtocolClass", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:199:6: ( (lv_actorClasses_6_0= ruleActorClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:199:6: ( (lv_actorClasses_6_0= ruleActorClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:200:1: (lv_actorClasses_6_0= ruleActorClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:200:1: (lv_actorClasses_6_0= ruleActorClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:201:3: lv_actorClasses_6_0= ruleActorClass
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getActorClassesActorClassParserRuleCall_4_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorClass_in_ruleRoomModel249);
            	    lv_actorClasses_6_0=ruleActorClass();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"actorClasses",
            	    	        		lv_actorClasses_6_0, 
            	    	        		"ActorClass", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:224:6: ( (lv_subSystemClasses_7_0= ruleSubSystemClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:224:6: ( (lv_subSystemClasses_7_0= ruleSubSystemClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:225:1: (lv_subSystemClasses_7_0= ruleSubSystemClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:225:1: (lv_subSystemClasses_7_0= ruleSubSystemClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:226:3: lv_subSystemClasses_7_0= ruleSubSystemClass
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getSubSystemClassesSubSystemClassParserRuleCall_4_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubSystemClass_in_ruleRoomModel276);
            	    lv_subSystemClasses_7_0=ruleSubSystemClass();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"subSystemClasses",
            	    	        		lv_subSystemClasses_7_0, 
            	    	        		"SubSystemClass", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:249:6: ( (lv_systems_8_0= ruleLogicalSystem ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:249:6: ( (lv_systems_8_0= ruleLogicalSystem ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:250:1: (lv_systems_8_0= ruleLogicalSystem )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:250:1: (lv_systems_8_0= ruleLogicalSystem )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:251:3: lv_systems_8_0= ruleLogicalSystem
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getSystemsLogicalSystemParserRuleCall_4_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLogicalSystem_in_ruleRoomModel303);
            	    lv_systems_8_0=ruleLogicalSystem();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"systems",
            	    	        		lv_systems_8_0, 
            	    	        		"LogicalSystem", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            match(input,13,FOLLOW_13_in_ruleRoomModel315); 

                    createLeafNode(grammarAccess.getRoomModelAccess().getRightCurlyBracketKeyword_5(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRoomModel


    // $ANTLR start entryRuleStructureClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:287:1: entryRuleStructureClass returns [EObject current=null] : iv_ruleStructureClass= ruleStructureClass EOF ;
    public final EObject entryRuleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructureClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:288:2: (iv_ruleStructureClass= ruleStructureClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:289:2: iv_ruleStructureClass= ruleStructureClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStructureClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleStructureClass_in_entryRuleStructureClass353);
            iv_ruleStructureClass=ruleStructureClass();
            _fsp--;

             current =iv_ruleStructureClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStructureClass363); 

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
    // $ANTLR end entryRuleStructureClass


    // $ANTLR start ruleStructureClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:296:1: ruleStructureClass returns [EObject current=null] : (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) ;
    public final EObject ruleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorContainerClass_0 = null;

        EObject this_LogicalSystem_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:301:6: ( (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:302:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:302:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=39 && LA3_0<=40)||LA3_0==53) ) {
                alt3=1;
            }
            else if ( (LA3_0==51) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("302:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:303:5: this_ActorContainerClass_0= ruleActorContainerClass
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStructureClassAccess().getActorContainerClassParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleActorContainerClass_in_ruleStructureClass410);
                    this_ActorContainerClass_0=ruleActorContainerClass();
                    _fsp--;

                     
                            current = this_ActorContainerClass_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:313:5: this_LogicalSystem_1= ruleLogicalSystem
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStructureClassAccess().getLogicalSystemParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLogicalSystem_in_ruleStructureClass437);
                    this_LogicalSystem_1=ruleLogicalSystem();
                    _fsp--;

                     
                            current = this_LogicalSystem_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStructureClass


    // $ANTLR start entryRuleActorContainerClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:329:1: entryRuleActorContainerClass returns [EObject current=null] : iv_ruleActorContainerClass= ruleActorContainerClass EOF ;
    public final EObject entryRuleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorContainerClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:330:2: (iv_ruleActorContainerClass= ruleActorContainerClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:331:2: iv_ruleActorContainerClass= ruleActorContainerClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActorContainerClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleActorContainerClass_in_entryRuleActorContainerClass472);
            iv_ruleActorContainerClass=ruleActorContainerClass();
            _fsp--;

             current =iv_ruleActorContainerClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorContainerClass482); 

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
    // $ANTLR end entryRuleActorContainerClass


    // $ANTLR start ruleActorContainerClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:338:1: ruleActorContainerClass returns [EObject current=null] : (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) ;
    public final EObject ruleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorClass_0 = null;

        EObject this_SubSystemClass_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:343:6: ( (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:344:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:344:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=39 && LA4_0<=40)) ) {
                alt4=1;
            }
            else if ( (LA4_0==53) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("344:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:345:5: this_ActorClass_0= ruleActorClass
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getActorContainerClassAccess().getActorClassParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleActorClass_in_ruleActorContainerClass529);
                    this_ActorClass_0=ruleActorClass();
                    _fsp--;

                     
                            current = this_ActorClass_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:355:5: this_SubSystemClass_1= ruleSubSystemClass
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getActorContainerClassAccess().getSubSystemClassParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSubSystemClass_in_ruleActorContainerClass556);
                    this_SubSystemClass_1=ruleSubSystemClass();
                    _fsp--;

                     
                            current = this_SubSystemClass_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleActorContainerClass


    // $ANTLR start entryRuleTypedID
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:371:1: entryRuleTypedID returns [EObject current=null] : iv_ruleTypedID= ruleTypedID EOF ;
    public final EObject entryRuleTypedID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedID = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:372:2: (iv_ruleTypedID= ruleTypedID EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:373:2: iv_ruleTypedID= ruleTypedID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypedIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypedID_in_entryRuleTypedID591);
            iv_ruleTypedID=ruleTypedID();
            _fsp--;

             current =iv_ruleTypedID; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypedID601); 

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
    // $ANTLR end entryRuleTypedID


    // $ANTLR start ruleTypedID
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:380:1: ruleTypedID returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleTypedID() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_type_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:385:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleType ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:386:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleType ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:386:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleType ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:386:2: ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleType ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:386:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:387:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:387:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:388:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypedID643); 

            			createLeafNode(grammarAccess.getTypedIDAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypedIDRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,14,FOLLOW_14_in_ruleTypedID658); 

                    createLeafNode(grammarAccess.getTypedIDAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:414:1: ( (lv_type_2_0= ruleType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:415:1: (lv_type_2_0= ruleType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:415:1: (lv_type_2_0= ruleType )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:416:3: lv_type_2_0= ruleType
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTypedIDAccess().getTypeTypeParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleTypedID679);
            lv_type_2_0=ruleType();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypedIDRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_2_0, 
            	        		"Type", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTypedID


    // $ANTLR start entryRuleFreeTypedID
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:446:1: entryRuleFreeTypedID returns [EObject current=null] : iv_ruleFreeTypedID= ruleFreeTypedID EOF ;
    public final EObject entryRuleFreeTypedID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreeTypedID = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:447:2: (iv_ruleFreeTypedID= ruleFreeTypedID EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:448:2: iv_ruleFreeTypedID= ruleFreeTypedID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFreeTypedIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleFreeTypedID_in_entryRuleFreeTypedID715);
            iv_ruleFreeTypedID=ruleFreeTypedID();
            _fsp--;

             current =iv_ruleFreeTypedID; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFreeTypedID725); 

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
    // $ANTLR end entryRuleFreeTypedID


    // $ANTLR start ruleFreeTypedID
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:455:1: ruleFreeTypedID returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleFreeType ) ) ) ;
    public final EObject ruleFreeTypedID() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_type_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:460:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleFreeType ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:461:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleFreeType ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:461:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleFreeType ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:461:2: ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleFreeType ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:461:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:462:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:462:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:463:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFreeTypedID767); 

            			createLeafNode(grammarAccess.getFreeTypedIDAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFreeTypedIDRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,14,FOLLOW_14_in_ruleFreeTypedID782); 

                    createLeafNode(grammarAccess.getFreeTypedIDAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:489:1: ( (lv_type_2_0= ruleFreeType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:490:1: (lv_type_2_0= ruleFreeType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:490:1: (lv_type_2_0= ruleFreeType )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:491:3: lv_type_2_0= ruleFreeType
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFreeTypedIDAccess().getTypeFreeTypeParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFreeType_in_ruleFreeTypedID803);
            lv_type_2_0=ruleFreeType();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFreeTypedIDRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_2_0, 
            	        		"FreeType", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFreeTypedID


    // $ANTLR start entryRuleType
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:521:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:522:2: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:523:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType839);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType849); 

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
    // $ANTLR end entryRuleType


    // $ANTLR start ruleType
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:530:1: ruleType returns [EObject current=null] : ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( ( ruleFQN ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_prim_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:535:6: ( ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:536:1: ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:536:1: ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( ( ruleFQN ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=88 && LA5_0<=99)) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("536:1: ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( ( ruleFQN ) ) )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:536:2: ( (lv_prim_0_0= rulePrimitiveType ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:536:2: ( (lv_prim_0_0= rulePrimitiveType ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:537:1: (lv_prim_0_0= rulePrimitiveType )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:537:1: (lv_prim_0_0= rulePrimitiveType )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:538:3: lv_prim_0_0= rulePrimitiveType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTypeAccess().getPrimPrimitiveTypeEnumRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimitiveType_in_ruleType895);
                    lv_prim_0_0=rulePrimitiveType();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"prim",
                    	        		lv_prim_0_0, 
                    	        		"PrimitiveType", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:561:6: ( ( ruleFQN ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:561:6: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:562:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:562:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:563:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTypeAccess().getTypeDataClassCrossReference_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleType924);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleType


    // $ANTLR start entryRuleFreeType
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:585:1: entryRuleFreeType returns [EObject current=null] : iv_ruleFreeType= ruleFreeType EOF ;
    public final EObject entryRuleFreeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreeType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:586:2: (iv_ruleFreeType= ruleFreeType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:587:2: iv_ruleFreeType= ruleFreeType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFreeTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleFreeType_in_entryRuleFreeType960);
            iv_ruleFreeType=ruleFreeType();
            _fsp--;

             current =iv_ruleFreeType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFreeType970); 

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
    // $ANTLR end entryRuleFreeType


    // $ANTLR start ruleFreeType
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:594:1: ruleFreeType returns [EObject current=null] : ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( (lv_type_1_0= RULE_ID ) ) ) ;
    public final EObject ruleFreeType() throws RecognitionException {
        EObject current = null;

        Token lv_type_1_0=null;
        Enumerator lv_prim_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:599:6: ( ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( (lv_type_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:600:1: ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( (lv_type_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:600:1: ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( (lv_type_1_0= RULE_ID ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=88 && LA6_0<=99)) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("600:1: ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( (lv_type_1_0= RULE_ID ) ) )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:600:2: ( (lv_prim_0_0= rulePrimitiveType ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:600:2: ( (lv_prim_0_0= rulePrimitiveType ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:601:1: (lv_prim_0_0= rulePrimitiveType )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:601:1: (lv_prim_0_0= rulePrimitiveType )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:602:3: lv_prim_0_0= rulePrimitiveType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFreeTypeAccess().getPrimPrimitiveTypeEnumRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimitiveType_in_ruleFreeType1016);
                    lv_prim_0_0=rulePrimitiveType();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFreeTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"prim",
                    	        		lv_prim_0_0, 
                    	        		"PrimitiveType", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:625:6: ( (lv_type_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:625:6: ( (lv_type_1_0= RULE_ID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:626:1: (lv_type_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:626:1: (lv_type_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:627:3: lv_type_1_0= RULE_ID
                    {
                    lv_type_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFreeType1039); 

                    			createLeafNode(grammarAccess.getFreeTypeAccess().getTypeIDTerminalRuleCall_1_0(), "type"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFreeTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFreeType


    // $ANTLR start entryRuleDataClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:657:1: entryRuleDataClass returns [EObject current=null] : iv_ruleDataClass= ruleDataClass EOF ;
    public final EObject entryRuleDataClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:658:2: (iv_ruleDataClass= ruleDataClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:659:2: iv_ruleDataClass= ruleDataClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataClass_in_entryRuleDataClass1080);
            iv_ruleDataClass=ruleDataClass();
            _fsp--;

             current =iv_ruleDataClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataClass1090); 

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
    // $ANTLR end entryRuleDataClass


    // $ANTLR start ruleDataClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:666:1: ruleDataClass returns [EObject current=null] : ( 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( (lv_imports_5_0= ruleImport ) )* ( (lv_attributes_6_0= ruleAttribute ) )+ ( (lv_operations_7_0= ruleOperation ) )* '}' ) ;
    public final EObject ruleDataClass() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_imports_5_0 = null;

        EObject lv_attributes_6_0 = null;

        EObject lv_operations_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:671:6: ( ( 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( (lv_imports_5_0= ruleImport ) )* ( (lv_attributes_6_0= ruleAttribute ) )+ ( (lv_operations_7_0= ruleOperation ) )* '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:672:1: ( 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( (lv_imports_5_0= ruleImport ) )* ( (lv_attributes_6_0= ruleAttribute ) )+ ( (lv_operations_7_0= ruleOperation ) )* '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:672:1: ( 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( (lv_imports_5_0= ruleImport ) )* ( (lv_attributes_6_0= ruleAttribute ) )+ ( (lv_operations_7_0= ruleOperation ) )* '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:672:3: 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( (lv_imports_5_0= ruleImport ) )* ( (lv_attributes_6_0= ruleAttribute ) )+ ( (lv_operations_7_0= ruleOperation ) )* '}'
            {
            match(input,15,FOLLOW_15_in_ruleDataClass1125); 

                    createLeafNode(grammarAccess.getDataClassAccess().getDataClassKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:676:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:677:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:677:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:678:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataClass1142); 

            			createLeafNode(grammarAccess.getDataClassAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDataClassRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:700:2: ( 'extends' ( ( ruleFQN ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:700:4: 'extends' ( ( ruleFQN ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleDataClass1158); 

                            createLeafNode(grammarAccess.getDataClassAccess().getExtendsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:704:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:705:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:705:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:706:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getDataClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDataClassAccess().getBaseDataClassCrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleDataClass1181);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleDataClass1193); 

                    createLeafNode(grammarAccess.getDataClassAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:724:1: ( (lv_imports_5_0= ruleImport ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==86) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:725:1: (lv_imports_5_0= ruleImport )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:725:1: (lv_imports_5_0= ruleImport )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:726:3: lv_imports_5_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getDataClassAccess().getImportsImportParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleDataClass1214);
            	    lv_imports_5_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getDataClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"imports",
            	    	        		lv_imports_5_0, 
            	    	        		"Import", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:748:3: ( (lv_attributes_6_0= ruleAttribute ) )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==17) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:749:1: (lv_attributes_6_0= ruleAttribute )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:749:1: (lv_attributes_6_0= ruleAttribute )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:750:3: lv_attributes_6_0= ruleAttribute
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getDataClassAccess().getAttributesAttributeParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttribute_in_ruleDataClass1236);
            	    lv_attributes_6_0=ruleAttribute();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getDataClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"attributes",
            	    	        		lv_attributes_6_0, 
            	    	        		"Attribute", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:772:3: ( (lv_operations_7_0= ruleOperation ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:773:1: (lv_operations_7_0= ruleOperation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:773:1: (lv_operations_7_0= ruleOperation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:774:3: lv_operations_7_0= ruleOperation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getDataClassAccess().getOperationsOperationParserRuleCall_6_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleOperation_in_ruleDataClass1258);
            	    lv_operations_7_0=ruleOperation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getDataClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"operations",
            	    	        		lv_operations_7_0, 
            	    	        		"Operation", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleDataClass1269); 

                    createLeafNode(grammarAccess.getDataClassAccess().getRightCurlyBracketKeyword_7(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDataClass


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:808:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:809:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:810:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute1305);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute1315); 

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
    // $ANTLR end entryRuleAttribute


    // $ANTLR start ruleAttribute
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:817:1: ruleAttribute returns [EObject current=null] : ( 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( '[' ( (lv_size_3_0= RULE_INT ) ) ']' )? ':' ( (lv_type_6_0= ruleType ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_size_3_0=null;
        EObject lv_type_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:822:6: ( ( 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( '[' ( (lv_size_3_0= RULE_INT ) ) ']' )? ':' ( (lv_type_6_0= ruleType ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:823:1: ( 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( '[' ( (lv_size_3_0= RULE_INT ) ) ']' )? ':' ( (lv_type_6_0= ruleType ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:823:1: ( 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( '[' ( (lv_size_3_0= RULE_INT ) ) ']' )? ':' ( (lv_type_6_0= ruleType ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:823:3: 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( '[' ( (lv_size_3_0= RULE_INT ) ) ']' )? ':' ( (lv_type_6_0= ruleType ) )
            {
            match(input,17,FOLLOW_17_in_ruleAttribute1350); 

                    createLeafNode(grammarAccess.getAttributeAccess().getAttributeKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:827:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:828:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:828:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:829:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute1367); 

            			createLeafNode(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:851:2: ( '[' ( (lv_size_3_0= RULE_INT ) ) ']' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:851:4: '[' ( (lv_size_3_0= RULE_INT ) ) ']'
                    {
                    match(input,18,FOLLOW_18_in_ruleAttribute1383); 

                            createLeafNode(grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:855:1: ( (lv_size_3_0= RULE_INT ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:856:1: (lv_size_3_0= RULE_INT )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:856:1: (lv_size_3_0= RULE_INT )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:857:3: lv_size_3_0= RULE_INT
                    {
                    lv_size_3_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAttribute1400); 

                    			createLeafNode(grammarAccess.getAttributeAccess().getSizeINTTerminalRuleCall_2_1_0(), "size"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"size",
                    	        		lv_size_3_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,19,FOLLOW_19_in_ruleAttribute1415); 

                            createLeafNode(grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            match(input,14,FOLLOW_14_in_ruleAttribute1427); 

                    createLeafNode(grammarAccess.getAttributeAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:887:1: ( (lv_type_6_0= ruleType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:888:1: (lv_type_6_0= ruleType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:888:1: (lv_type_6_0= ruleType )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:889:3: lv_type_6_0= ruleType
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAttributeAccess().getTypeTypeParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleAttribute1448);
            lv_type_6_0=ruleType();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_6_0, 
            	        		"Type", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRuleOperation
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:919:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:920:2: (iv_ruleOperation= ruleOperation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:921:2: iv_ruleOperation= ruleOperation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperation_in_entryRuleOperation1484);
            iv_ruleOperation=ruleOperation();
            _fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperation1494); 

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
    // $ANTLR end entryRuleOperation


    // $ANTLR start ruleOperation
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:928:1: ruleOperation returns [EObject current=null] : ( 'Operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )* )? ')' ( ':' ( (lv_returntype_8_0= ruleFreeType ) ) )? ( (lv_detailCode_9_0= ruleDetailCode ) ) ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_returntype_8_0 = null;

        EObject lv_detailCode_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:933:6: ( ( 'Operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )* )? ')' ( ':' ( (lv_returntype_8_0= ruleFreeType ) ) )? ( (lv_detailCode_9_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:934:1: ( 'Operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )* )? ')' ( ':' ( (lv_returntype_8_0= ruleFreeType ) ) )? ( (lv_detailCode_9_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:934:1: ( 'Operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )* )? ')' ( ':' ( (lv_returntype_8_0= ruleFreeType ) ) )? ( (lv_detailCode_9_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:934:3: 'Operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )* )? ')' ( ':' ( (lv_returntype_8_0= ruleFreeType ) ) )? ( (lv_detailCode_9_0= ruleDetailCode ) )
            {
            match(input,20,FOLLOW_20_in_ruleOperation1529); 

                    createLeafNode(grammarAccess.getOperationAccess().getOperationKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:938:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:939:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:939:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:940:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperation1546); 

            			createLeafNode(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,21,FOLLOW_21_in_ruleOperation1561); 

                    createLeafNode(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:966:1: ( ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:966:2: ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )*
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:966:2: ( (lv_arguments_3_0= ruleFreeTypedID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:967:1: (lv_arguments_3_0= ruleFreeTypedID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:967:1: (lv_arguments_3_0= ruleFreeTypedID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:968:3: lv_arguments_3_0= ruleFreeTypedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getArgumentsFreeTypedIDParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFreeTypedID_in_ruleOperation1583);
                    lv_arguments_3_0=ruleFreeTypedID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"arguments",
                    	        		lv_arguments_3_0, 
                    	        		"FreeTypedID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:990:2: ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==22) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:990:4: ',' ( (lv_arguments_5_0= ruleFreeTypedID ) )
                    	    {
                    	    match(input,22,FOLLOW_22_in_ruleOperation1594); 

                    	            createLeafNode(grammarAccess.getOperationAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:994:1: ( (lv_arguments_5_0= ruleFreeTypedID ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:995:1: (lv_arguments_5_0= ruleFreeTypedID )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:995:1: (lv_arguments_5_0= ruleFreeTypedID )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:996:3: lv_arguments_5_0= ruleFreeTypedID
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getArgumentsFreeTypedIDParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFreeTypedID_in_ruleOperation1615);
                    	    lv_arguments_5_0=ruleFreeTypedID();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"arguments",
                    	    	        		lv_arguments_5_0, 
                    	    	        		"FreeTypedID", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,23,FOLLOW_23_in_ruleOperation1629); 

                    createLeafNode(grammarAccess.getOperationAccess().getRightParenthesisKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1022:1: ( ':' ( (lv_returntype_8_0= ruleFreeType ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==14) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1022:3: ':' ( (lv_returntype_8_0= ruleFreeType ) )
                    {
                    match(input,14,FOLLOW_14_in_ruleOperation1640); 

                            createLeafNode(grammarAccess.getOperationAccess().getColonKeyword_5_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1026:1: ( (lv_returntype_8_0= ruleFreeType ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1027:1: (lv_returntype_8_0= ruleFreeType )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1027:1: (lv_returntype_8_0= ruleFreeType )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1028:3: lv_returntype_8_0= ruleFreeType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getReturntypeFreeTypeParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFreeType_in_ruleOperation1661);
                    lv_returntype_8_0=ruleFreeType();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"returntype",
                    	        		lv_returntype_8_0, 
                    	        		"FreeType", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1050:4: ( (lv_detailCode_9_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1051:1: (lv_detailCode_9_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1051:1: (lv_detailCode_9_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1052:3: lv_detailCode_9_0= ruleDetailCode
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getDetailCodeDetailCodeParserRuleCall_6_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleOperation1684);
            lv_detailCode_9_0=ruleDetailCode();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"detailCode",
            	        		lv_detailCode_9_0, 
            	        		"DetailCode", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOperation


    // $ANTLR start entryRuleProtocolClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1082:1: entryRuleProtocolClass returns [EObject current=null] : iv_ruleProtocolClass= ruleProtocolClass EOF ;
    public final EObject entryRuleProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1083:2: (iv_ruleProtocolClass= ruleProtocolClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1084:2: iv_ruleProtocolClass= ruleProtocolClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getProtocolClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleProtocolClass_in_entryRuleProtocolClass1720);
            iv_ruleProtocolClass=ruleProtocolClass();
            _fsp--;

             current =iv_ruleProtocolClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolClass1730); 

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
    // $ANTLR end entryRuleProtocolClass


    // $ANTLR start ruleProtocolClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1091:1: ruleProtocolClass returns [EObject current=null] : ( 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? 'incoming' '{' ( (lv_incomingMessages_11_0= ruleMessage ) )* '}' 'outgoing' '{' ( (lv_outgoingMessages_15_0= ruleMessage ) )* '}' ( 'regular' 'PortClass' ( (lv_regular_19_0= rulePortClass ) ) )? ( 'conjugate' 'PortClass' ( (lv_conjugate_22_0= rulePortClass ) ) )? ( (lv_semantics_23_0= ruleProtocolSemantics ) )? '}' ) ;
    public final EObject ruleProtocolClass() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_userCode1_6_0 = null;

        EObject lv_userCode2_8_0 = null;

        EObject lv_incomingMessages_11_0 = null;

        EObject lv_outgoingMessages_15_0 = null;

        EObject lv_regular_19_0 = null;

        EObject lv_conjugate_22_0 = null;

        EObject lv_semantics_23_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1096:6: ( ( 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? 'incoming' '{' ( (lv_incomingMessages_11_0= ruleMessage ) )* '}' 'outgoing' '{' ( (lv_outgoingMessages_15_0= ruleMessage ) )* '}' ( 'regular' 'PortClass' ( (lv_regular_19_0= rulePortClass ) ) )? ( 'conjugate' 'PortClass' ( (lv_conjugate_22_0= rulePortClass ) ) )? ( (lv_semantics_23_0= ruleProtocolSemantics ) )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1097:1: ( 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? 'incoming' '{' ( (lv_incomingMessages_11_0= ruleMessage ) )* '}' 'outgoing' '{' ( (lv_outgoingMessages_15_0= ruleMessage ) )* '}' ( 'regular' 'PortClass' ( (lv_regular_19_0= rulePortClass ) ) )? ( 'conjugate' 'PortClass' ( (lv_conjugate_22_0= rulePortClass ) ) )? ( (lv_semantics_23_0= ruleProtocolSemantics ) )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1097:1: ( 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? 'incoming' '{' ( (lv_incomingMessages_11_0= ruleMessage ) )* '}' 'outgoing' '{' ( (lv_outgoingMessages_15_0= ruleMessage ) )* '}' ( 'regular' 'PortClass' ( (lv_regular_19_0= rulePortClass ) ) )? ( 'conjugate' 'PortClass' ( (lv_conjugate_22_0= rulePortClass ) ) )? ( (lv_semantics_23_0= ruleProtocolSemantics ) )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1097:3: 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? 'incoming' '{' ( (lv_incomingMessages_11_0= ruleMessage ) )* '}' 'outgoing' '{' ( (lv_outgoingMessages_15_0= ruleMessage ) )* '}' ( 'regular' 'PortClass' ( (lv_regular_19_0= rulePortClass ) ) )? ( 'conjugate' 'PortClass' ( (lv_conjugate_22_0= rulePortClass ) ) )? ( (lv_semantics_23_0= ruleProtocolSemantics ) )? '}'
            {
            match(input,24,FOLLOW_24_in_ruleProtocolClass1765); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getProtocolClassKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1101:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1102:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1102:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1103:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProtocolClass1782); 

            			createLeafNode(grammarAccess.getProtocolClassAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1125:2: ( 'extends' ( ( ruleFQN ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==16) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1125:4: 'extends' ( ( ruleFQN ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleProtocolClass1798); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getExtendsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1129:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1130:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1130:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1131:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getBaseProtocolClassCrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleProtocolClass1821);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleProtocolClass1833); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1149:1: ( 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1149:3: 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) )
                    {
                    match(input,25,FOLLOW_25_in_ruleProtocolClass1844); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getUsercode1Keyword_4_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1153:1: ( (lv_userCode1_6_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1154:1: (lv_userCode1_6_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1154:1: (lv_userCode1_6_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1155:3: lv_userCode1_6_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode1DetailCodeParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleProtocolClass1865);
                    lv_userCode1_6_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"userCode1",
                    	        		lv_userCode1_6_0, 
                    	        		"DetailCode", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1177:4: ( 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1177:6: 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) )
                    {
                    match(input,26,FOLLOW_26_in_ruleProtocolClass1878); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getUsercode2Keyword_5_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1181:1: ( (lv_userCode2_8_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1182:1: (lv_userCode2_8_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1182:1: (lv_userCode2_8_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1183:3: lv_userCode2_8_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode2DetailCodeParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleProtocolClass1899);
                    lv_userCode2_8_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"userCode2",
                    	        		lv_userCode2_8_0, 
                    	        		"DetailCode", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_ruleProtocolClass1911); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getIncomingKeyword_6(), null); 
                
            match(input,12,FOLLOW_12_in_ruleProtocolClass1921); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_7(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1213:1: ( (lv_incomingMessages_11_0= ruleMessage ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==32) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1214:1: (lv_incomingMessages_11_0= ruleMessage )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1214:1: (lv_incomingMessages_11_0= ruleMessage )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1215:3: lv_incomingMessages_11_0= ruleMessage
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getIncomingMessagesMessageParserRuleCall_8_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessage_in_ruleProtocolClass1942);
            	    lv_incomingMessages_11_0=ruleMessage();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"incomingMessages",
            	    	        		lv_incomingMessages_11_0, 
            	    	        		"Message", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleProtocolClass1953); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_9(), null); 
                
            match(input,28,FOLLOW_28_in_ruleProtocolClass1963); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getOutgoingKeyword_10(), null); 
                
            match(input,12,FOLLOW_12_in_ruleProtocolClass1973); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_11(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1249:1: ( (lv_outgoingMessages_15_0= ruleMessage ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==32) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1250:1: (lv_outgoingMessages_15_0= ruleMessage )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1250:1: (lv_outgoingMessages_15_0= ruleMessage )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1251:3: lv_outgoingMessages_15_0= ruleMessage
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getOutgoingMessagesMessageParserRuleCall_12_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessage_in_ruleProtocolClass1994);
            	    lv_outgoingMessages_15_0=ruleMessage();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"outgoingMessages",
            	    	        		lv_outgoingMessages_15_0, 
            	    	        		"Message", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleProtocolClass2005); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_13(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1277:1: ( 'regular' 'PortClass' ( (lv_regular_19_0= rulePortClass ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1277:3: 'regular' 'PortClass' ( (lv_regular_19_0= rulePortClass ) )
                    {
                    match(input,29,FOLLOW_29_in_ruleProtocolClass2016); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getRegularKeyword_14_0(), null); 
                        
                    match(input,30,FOLLOW_30_in_ruleProtocolClass2026); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getPortClassKeyword_14_1(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1285:1: ( (lv_regular_19_0= rulePortClass ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1286:1: (lv_regular_19_0= rulePortClass )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1286:1: (lv_regular_19_0= rulePortClass )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1287:3: lv_regular_19_0= rulePortClass
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getRegularPortClassParserRuleCall_14_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePortClass_in_ruleProtocolClass2047);
                    lv_regular_19_0=rulePortClass();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"regular",
                    	        		lv_regular_19_0, 
                    	        		"PortClass", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1309:4: ( 'conjugate' 'PortClass' ( (lv_conjugate_22_0= rulePortClass ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1309:6: 'conjugate' 'PortClass' ( (lv_conjugate_22_0= rulePortClass ) )
                    {
                    match(input,31,FOLLOW_31_in_ruleProtocolClass2060); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getConjugateKeyword_15_0(), null); 
                        
                    match(input,30,FOLLOW_30_in_ruleProtocolClass2070); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getPortClassKeyword_15_1(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1317:1: ( (lv_conjugate_22_0= rulePortClass ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1318:1: (lv_conjugate_22_0= rulePortClass )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1318:1: (lv_conjugate_22_0= rulePortClass )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1319:3: lv_conjugate_22_0= rulePortClass
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getConjugatePortClassParserRuleCall_15_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePortClass_in_ruleProtocolClass2091);
                    lv_conjugate_22_0=rulePortClass();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"conjugate",
                    	        		lv_conjugate_22_0, 
                    	        		"PortClass", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1341:4: ( (lv_semantics_23_0= ruleProtocolSemantics ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==35) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1342:1: (lv_semantics_23_0= ruleProtocolSemantics )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1342:1: (lv_semantics_23_0= ruleProtocolSemantics )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1343:3: lv_semantics_23_0= ruleProtocolSemantics
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getSemanticsProtocolSemanticsParserRuleCall_16_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleProtocolSemantics_in_ruleProtocolClass2114);
                    lv_semantics_23_0=ruleProtocolSemantics();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"semantics",
                    	        		lv_semantics_23_0, 
                    	        		"ProtocolSemantics", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleProtocolClass2125); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_17(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleProtocolClass


    // $ANTLR start entryRuleMessage
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1377:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1378:2: (iv_ruleMessage= ruleMessage EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1379:2: iv_ruleMessage= ruleMessage EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMessageRule(), currentNode); 
            pushFollow(FOLLOW_ruleMessage_in_entryRuleMessage2161);
            iv_ruleMessage=ruleMessage();
            _fsp--;

             current =iv_ruleMessage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessage2171); 

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
    // $ANTLR end entryRuleMessage


    // $ANTLR start ruleMessage
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1386:1: ruleMessage returns [EObject current=null] : ( 'Message' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )* )? ')' ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1391:6: ( ( 'Message' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )* )? ')' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1392:1: ( 'Message' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )* )? ')' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1392:1: ( 'Message' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )* )? ')' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1392:3: 'Message' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )* )? ')'
            {
            match(input,32,FOLLOW_32_in_ruleMessage2206); 

                    createLeafNode(grammarAccess.getMessageAccess().getMessageKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1396:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1397:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1397:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1398:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessage2223); 

            			createLeafNode(grammarAccess.getMessageAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMessageRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,21,FOLLOW_21_in_ruleMessage2238); 

                    createLeafNode(grammarAccess.getMessageAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1424:1: ( ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1424:2: ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )*
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1424:2: ( (lv_arguments_3_0= ruleTypedID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1425:1: (lv_arguments_3_0= ruleTypedID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1425:1: (lv_arguments_3_0= ruleTypedID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1426:3: lv_arguments_3_0= ruleTypedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMessageAccess().getArgumentsTypedIDParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypedID_in_ruleMessage2260);
                    lv_arguments_3_0=ruleTypedID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMessageRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"arguments",
                    	        		lv_arguments_3_0, 
                    	        		"TypedID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1448:2: ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==22) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1448:4: ',' ( (lv_arguments_5_0= ruleTypedID ) )
                    	    {
                    	    match(input,22,FOLLOW_22_in_ruleMessage2271); 

                    	            createLeafNode(grammarAccess.getMessageAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1452:1: ( (lv_arguments_5_0= ruleTypedID ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1453:1: (lv_arguments_5_0= ruleTypedID )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1453:1: (lv_arguments_5_0= ruleTypedID )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1454:3: lv_arguments_5_0= ruleTypedID
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMessageAccess().getArgumentsTypedIDParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTypedID_in_ruleMessage2292);
                    	    lv_arguments_5_0=ruleTypedID();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMessageRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"arguments",
                    	    	        		lv_arguments_5_0, 
                    	    	        		"TypedID", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,23,FOLLOW_23_in_ruleMessage2306); 

                    createLeafNode(grammarAccess.getMessageAccess().getRightParenthesisKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMessage


    // $ANTLR start entryRulePortClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1488:1: entryRulePortClass returns [EObject current=null] : iv_rulePortClass= rulePortClass EOF ;
    public final EObject entryRulePortClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1489:2: (iv_rulePortClass= rulePortClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1490:2: iv_rulePortClass= rulePortClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPortClassRule(), currentNode); 
            pushFollow(FOLLOW_rulePortClass_in_entryRulePortClass2342);
            iv_rulePortClass=rulePortClass();
            _fsp--;

             current =iv_rulePortClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortClass2352); 

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
    // $ANTLR end entryRulePortClass


    // $ANTLR start rulePortClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1497:1: rulePortClass returns [EObject current=null] : ( '{' ( 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= ruleOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ '}' ) ;
    public final EObject rulePortClass() throws RecognitionException {
        EObject current = null;

        EObject lv_userCode_2_0 = null;

        EObject lv_attributes_3_0 = null;

        EObject lv_operations_4_0 = null;

        EObject lv_msgHandlers_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1502:6: ( ( '{' ( 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= ruleOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1503:1: ( '{' ( 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= ruleOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1503:1: ( '{' ( 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= ruleOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1503:3: '{' ( 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= ruleOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ '}'
            {
            match(input,12,FOLLOW_12_in_rulePortClass2387); 

                    createLeafNode(grammarAccess.getPortClassAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1507:1: ( 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1507:3: 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) )
                    {
                    match(input,33,FOLLOW_33_in_rulePortClass2398); 

                            createLeafNode(grammarAccess.getPortClassAccess().getUsercodeKeyword_1_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1511:1: ( (lv_userCode_2_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1512:1: (lv_userCode_2_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1512:1: (lv_userCode_2_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1513:3: lv_userCode_2_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPortClassAccess().getUserCodeDetailCodeParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_rulePortClass2419);
                    lv_userCode_2_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPortClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"userCode",
                    	        		lv_userCode_2_0, 
                    	        		"DetailCode", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1535:4: ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= ruleOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=4;
                switch ( input.LA(1) ) {
                case 17:
                    {
                    alt26=1;
                    }
                    break;
                case 20:
                    {
                    alt26=2;
                    }
                    break;
                case 34:
                    {
                    alt26=3;
                    }
                    break;

                }

                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1535:5: ( (lv_attributes_3_0= ruleAttribute ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1535:5: ( (lv_attributes_3_0= ruleAttribute ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1536:1: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1536:1: (lv_attributes_3_0= ruleAttribute )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1537:3: lv_attributes_3_0= ruleAttribute
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getPortClassAccess().getAttributesAttributeParserRuleCall_2_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttribute_in_rulePortClass2443);
            	    lv_attributes_3_0=ruleAttribute();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getPortClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"attributes",
            	    	        		lv_attributes_3_0, 
            	    	        		"Attribute", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1560:6: ( (lv_operations_4_0= ruleOperation ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1560:6: ( (lv_operations_4_0= ruleOperation ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1561:1: (lv_operations_4_0= ruleOperation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1561:1: (lv_operations_4_0= ruleOperation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1562:3: lv_operations_4_0= ruleOperation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getPortClassAccess().getOperationsOperationParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleOperation_in_rulePortClass2470);
            	    lv_operations_4_0=ruleOperation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getPortClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"operations",
            	    	        		lv_operations_4_0, 
            	    	        		"Operation", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1585:6: ( (lv_msgHandlers_5_0= ruleMessageHandler ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1585:6: ( (lv_msgHandlers_5_0= ruleMessageHandler ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1586:1: (lv_msgHandlers_5_0= ruleMessageHandler )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1586:1: (lv_msgHandlers_5_0= ruleMessageHandler )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1587:3: lv_msgHandlers_5_0= ruleMessageHandler
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getPortClassAccess().getMsgHandlersMessageHandlerParserRuleCall_2_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessageHandler_in_rulePortClass2497);
            	    lv_msgHandlers_5_0=ruleMessageHandler();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getPortClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"msgHandlers",
            	    	        		lv_msgHandlers_5_0, 
            	    	        		"MessageHandler", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            match(input,13,FOLLOW_13_in_rulePortClass2509); 

                    createLeafNode(grammarAccess.getPortClassAccess().getRightCurlyBracketKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePortClass


    // $ANTLR start entryRuleMessageHandler
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1621:1: entryRuleMessageHandler returns [EObject current=null] : iv_ruleMessageHandler= ruleMessageHandler EOF ;
    public final EObject entryRuleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageHandler = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1622:2: (iv_ruleMessageHandler= ruleMessageHandler EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1623:2: iv_ruleMessageHandler= ruleMessageHandler EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMessageHandlerRule(), currentNode); 
            pushFollow(FOLLOW_ruleMessageHandler_in_entryRuleMessageHandler2545);
            iv_ruleMessageHandler=ruleMessageHandler();
            _fsp--;

             current =iv_ruleMessageHandler; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessageHandler2555); 

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
    // $ANTLR end entryRuleMessageHandler


    // $ANTLR start ruleMessageHandler
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1630:1: ruleMessageHandler returns [EObject current=null] : ( 'handle' ( ( RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) ) ;
    public final EObject ruleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject lv_detailCode_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1635:6: ( ( 'handle' ( ( RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1636:1: ( 'handle' ( ( RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1636:1: ( 'handle' ( ( RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1636:3: 'handle' ( ( RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) )
            {
            match(input,34,FOLLOW_34_in_ruleMessageHandler2590); 

                    createLeafNode(grammarAccess.getMessageHandlerAccess().getHandleKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1640:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1641:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1641:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1642:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getMessageHandlerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageHandler2608); 

            		createLeafNode(grammarAccess.getMessageHandlerAccess().getMsgMessageCrossReference_1_0(), "msg"); 
            	

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1654:2: ( (lv_detailCode_2_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1655:1: (lv_detailCode_2_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1655:1: (lv_detailCode_2_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1656:3: lv_detailCode_2_0= ruleDetailCode
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMessageHandlerAccess().getDetailCodeDetailCodeParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleMessageHandler2629);
            lv_detailCode_2_0=ruleDetailCode();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMessageHandlerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"detailCode",
            	        		lv_detailCode_2_0, 
            	        		"DetailCode", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMessageHandler


    // $ANTLR start entryRuleProtocolSemantics
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1686:1: entryRuleProtocolSemantics returns [EObject current=null] : iv_ruleProtocolSemantics= ruleProtocolSemantics EOF ;
    public final EObject entryRuleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSemantics = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1687:2: (iv_ruleProtocolSemantics= ruleProtocolSemantics EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1688:2: iv_ruleProtocolSemantics= ruleProtocolSemantics EOF
            {
             currentNode = createCompositeNode(grammarAccess.getProtocolSemanticsRule(), currentNode); 
            pushFollow(FOLLOW_ruleProtocolSemantics_in_entryRuleProtocolSemantics2665);
            iv_ruleProtocolSemantics=ruleProtocolSemantics();
            _fsp--;

             current =iv_ruleProtocolSemantics; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolSemantics2675); 

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
    // $ANTLR end entryRuleProtocolSemantics


    // $ANTLR start ruleProtocolSemantics
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1695:1: ruleProtocolSemantics returns [EObject current=null] : ( 'semantics' '{' ( (lv_rules_2_0= ruleSemanticsRule ) )+ '}' ) ;
    public final EObject ruleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        EObject lv_rules_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1700:6: ( ( 'semantics' '{' ( (lv_rules_2_0= ruleSemanticsRule ) )+ '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1701:1: ( 'semantics' '{' ( (lv_rules_2_0= ruleSemanticsRule ) )+ '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1701:1: ( 'semantics' '{' ( (lv_rules_2_0= ruleSemanticsRule ) )+ '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1701:3: 'semantics' '{' ( (lv_rules_2_0= ruleSemanticsRule ) )+ '}'
            {
            match(input,35,FOLLOW_35_in_ruleProtocolSemantics2710); 

                    createLeafNode(grammarAccess.getProtocolSemanticsAccess().getSemanticsKeyword_0(), null); 
                
            match(input,12,FOLLOW_12_in_ruleProtocolSemantics2720); 

                    createLeafNode(grammarAccess.getProtocolSemanticsAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1709:1: ( (lv_rules_2_0= ruleSemanticsRule ) )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==36||LA27_0==38) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1710:1: (lv_rules_2_0= ruleSemanticsRule )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1710:1: (lv_rules_2_0= ruleSemanticsRule )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1711:3: lv_rules_2_0= ruleSemanticsRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getProtocolSemanticsAccess().getRulesSemanticsRuleParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleProtocolSemantics2741);
            	    lv_rules_2_0=ruleSemanticsRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getProtocolSemanticsRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"rules",
            	    	        		lv_rules_2_0, 
            	    	        		"SemanticsRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            match(input,13,FOLLOW_13_in_ruleProtocolSemantics2752); 

                    createLeafNode(grammarAccess.getProtocolSemanticsAccess().getRightCurlyBracketKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleProtocolSemantics


    // $ANTLR start entryRuleSemanticsRule
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1745:1: entryRuleSemanticsRule returns [EObject current=null] : iv_ruleSemanticsRule= ruleSemanticsRule EOF ;
    public final EObject entryRuleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsRule = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1746:2: (iv_ruleSemanticsRule= ruleSemanticsRule EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1747:2: iv_ruleSemanticsRule= ruleSemanticsRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSemanticsRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleSemanticsRule_in_entryRuleSemanticsRule2788);
            iv_ruleSemanticsRule=ruleSemanticsRule();
            _fsp--;

             current =iv_ruleSemanticsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSemanticsRule2798); 

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
    // $ANTLR end entryRuleSemanticsRule


    // $ANTLR start ruleSemanticsRule
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1754:1: ruleSemanticsRule returns [EObject current=null] : (this_SemanticsInRule_0= ruleSemanticsInRule | this_SemanticsOutRule_1= ruleSemanticsOutRule ) ;
    public final EObject ruleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject this_SemanticsInRule_0 = null;

        EObject this_SemanticsOutRule_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1759:6: ( (this_SemanticsInRule_0= ruleSemanticsInRule | this_SemanticsOutRule_1= ruleSemanticsOutRule ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1760:1: (this_SemanticsInRule_0= ruleSemanticsInRule | this_SemanticsOutRule_1= ruleSemanticsOutRule )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1760:1: (this_SemanticsInRule_0= ruleSemanticsInRule | this_SemanticsOutRule_1= ruleSemanticsOutRule )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==36) ) {
                alt28=1;
            }
            else if ( (LA28_0==38) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1760:1: (this_SemanticsInRule_0= ruleSemanticsInRule | this_SemanticsOutRule_1= ruleSemanticsOutRule )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1761:5: this_SemanticsInRule_0= ruleSemanticsInRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSemanticsRuleAccess().getSemanticsInRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSemanticsInRule_in_ruleSemanticsRule2845);
                    this_SemanticsInRule_0=ruleSemanticsInRule();
                    _fsp--;

                     
                            current = this_SemanticsInRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1771:5: this_SemanticsOutRule_1= ruleSemanticsOutRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSemanticsRuleAccess().getSemanticsOutRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSemanticsOutRule_in_ruleSemanticsRule2872);
                    this_SemanticsOutRule_1=ruleSemanticsOutRule();
                    _fsp--;

                     
                            current = this_SemanticsOutRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSemanticsRule


    // $ANTLR start entryRuleSemanticsInRule
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1787:1: entryRuleSemanticsInRule returns [EObject current=null] : iv_ruleSemanticsInRule= ruleSemanticsInRule EOF ;
    public final EObject entryRuleSemanticsInRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsInRule = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1788:2: (iv_ruleSemanticsInRule= ruleSemanticsInRule EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1789:2: iv_ruleSemanticsInRule= ruleSemanticsInRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSemanticsInRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleSemanticsInRule_in_entryRuleSemanticsInRule2907);
            iv_ruleSemanticsInRule=ruleSemanticsInRule();
            _fsp--;

             current =iv_ruleSemanticsInRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSemanticsInRule2917); 

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
    // $ANTLR end entryRuleSemanticsInRule


    // $ANTLR start ruleSemanticsInRule
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1796:1: ruleSemanticsInRule returns [EObject current=null] : ( 'in' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' ) ;
    public final EObject ruleSemanticsInRule() throws RecognitionException {
        EObject current = null;

        EObject lv_followUps_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1801:6: ( ( 'in' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1802:1: ( 'in' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1802:1: ( 'in' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1802:3: 'in' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}'
            {
            match(input,36,FOLLOW_36_in_ruleSemanticsInRule2952); 

                    createLeafNode(grammarAccess.getSemanticsInRuleAccess().getInKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1806:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1807:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1807:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1808:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSemanticsInRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSemanticsInRule2970); 

            		createLeafNode(grammarAccess.getSemanticsInRuleAccess().getMsgMessageCrossReference_1_0(), "msg"); 
            	

            }


            }

            match(input,37,FOLLOW_37_in_ruleSemanticsInRule2980); 

                    createLeafNode(grammarAccess.getSemanticsInRuleAccess().getHyphenMinusGreaterThanSignKeyword_2(), null); 
                
            match(input,12,FOLLOW_12_in_ruleSemanticsInRule2990); 

                    createLeafNode(grammarAccess.getSemanticsInRuleAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1828:1: ( (lv_followUps_4_0= ruleSemanticsRule ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==36||LA29_0==38) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1829:1: (lv_followUps_4_0= ruleSemanticsRule )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1829:1: (lv_followUps_4_0= ruleSemanticsRule )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1830:3: lv_followUps_4_0= ruleSemanticsRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSemanticsInRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleSemanticsInRule3011);
            	    lv_followUps_4_0=ruleSemanticsRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSemanticsInRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"followUps",
            	    	        		lv_followUps_4_0, 
            	    	        		"SemanticsRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleSemanticsInRule3022); 

                    createLeafNode(grammarAccess.getSemanticsInRuleAccess().getRightCurlyBracketKeyword_5(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSemanticsInRule


    // $ANTLR start entryRuleSemanticsOutRule
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1864:1: entryRuleSemanticsOutRule returns [EObject current=null] : iv_ruleSemanticsOutRule= ruleSemanticsOutRule EOF ;
    public final EObject entryRuleSemanticsOutRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsOutRule = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1865:2: (iv_ruleSemanticsOutRule= ruleSemanticsOutRule EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1866:2: iv_ruleSemanticsOutRule= ruleSemanticsOutRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSemanticsOutRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleSemanticsOutRule_in_entryRuleSemanticsOutRule3058);
            iv_ruleSemanticsOutRule=ruleSemanticsOutRule();
            _fsp--;

             current =iv_ruleSemanticsOutRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSemanticsOutRule3068); 

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
    // $ANTLR end entryRuleSemanticsOutRule


    // $ANTLR start ruleSemanticsOutRule
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1873:1: ruleSemanticsOutRule returns [EObject current=null] : ( 'out' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' ) ;
    public final EObject ruleSemanticsOutRule() throws RecognitionException {
        EObject current = null;

        EObject lv_followUps_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1878:6: ( ( 'out' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1879:1: ( 'out' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1879:1: ( 'out' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1879:3: 'out' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}'
            {
            match(input,38,FOLLOW_38_in_ruleSemanticsOutRule3103); 

                    createLeafNode(grammarAccess.getSemanticsOutRuleAccess().getOutKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1883:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1884:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1884:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1885:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSemanticsOutRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSemanticsOutRule3121); 

            		createLeafNode(grammarAccess.getSemanticsOutRuleAccess().getMsgMessageCrossReference_1_0(), "msg"); 
            	

            }


            }

            match(input,37,FOLLOW_37_in_ruleSemanticsOutRule3131); 

                    createLeafNode(grammarAccess.getSemanticsOutRuleAccess().getHyphenMinusGreaterThanSignKeyword_2(), null); 
                
            match(input,12,FOLLOW_12_in_ruleSemanticsOutRule3141); 

                    createLeafNode(grammarAccess.getSemanticsOutRuleAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1905:1: ( (lv_followUps_4_0= ruleSemanticsRule ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==36||LA30_0==38) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1906:1: (lv_followUps_4_0= ruleSemanticsRule )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1906:1: (lv_followUps_4_0= ruleSemanticsRule )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1907:3: lv_followUps_4_0= ruleSemanticsRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSemanticsOutRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleSemanticsOutRule3162);
            	    lv_followUps_4_0=ruleSemanticsRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSemanticsOutRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"followUps",
            	    	        		lv_followUps_4_0, 
            	    	        		"SemanticsRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleSemanticsOutRule3173); 

                    createLeafNode(grammarAccess.getSemanticsOutRuleAccess().getRightCurlyBracketKeyword_5(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSemanticsOutRule


    // $ANTLR start entryRuleActorClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1941:1: entryRuleActorClass returns [EObject current=null] : iv_ruleActorClass= ruleActorClass EOF ;
    public final EObject entryRuleActorClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1942:2: (iv_ruleActorClass= ruleActorClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1943:2: iv_ruleActorClass= ruleActorClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActorClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleActorClass_in_entryRuleActorClass3209);
            iv_ruleActorClass=ruleActorClass();
            _fsp--;

             current =iv_ruleActorClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorClass3219); 

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
    // $ANTLR end entryRuleActorClass


    // $ANTLR start ruleActorClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1950:1: ruleActorClass returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'Interface' '{' ( (lv_ifPorts_8_0= rulePort ) )* ( (lv_ifSPPs_9_0= ruleSPPRef ) )* '}' )? ( 'Structure' '{' ( 'usercode1' ( (lv_userCode1_14_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_16_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_17_0= rulePort ) ) | ( (lv_extPorts_18_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_19_0= ruleServiceImplementation ) )* ( (lv_strSAPs_20_0= ruleSAPRef ) )* ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_actorRefs_22_0= ruleActorRef ) )* ( (lv_bindings_23_0= ruleBinding ) )* ( (lv_connections_24_0= ruleLayerConnection ) )* '}' )? ( 'Behavior' '{' ( (lv_operations_28_0= ruleOperation ) )* ( (lv_stateMachine_29_0= ruleStateMachine ) )? '}' )? '}' ) ;
    public final EObject ruleActorClass() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token lv_name_2_0=null;
        EObject lv_ifPorts_8_0 = null;

        EObject lv_ifSPPs_9_0 = null;

        EObject lv_userCode1_14_0 = null;

        EObject lv_userCode2_16_0 = null;

        EObject lv_intPorts_17_0 = null;

        EObject lv_extPorts_18_0 = null;

        EObject lv_serviceImplementations_19_0 = null;

        EObject lv_strSAPs_20_0 = null;

        EObject lv_attributes_21_0 = null;

        EObject lv_actorRefs_22_0 = null;

        EObject lv_bindings_23_0 = null;

        EObject lv_connections_24_0 = null;

        EObject lv_operations_28_0 = null;

        EObject lv_stateMachine_29_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1955:6: ( ( ( (lv_abstract_0_0= 'abstract' ) )? 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'Interface' '{' ( (lv_ifPorts_8_0= rulePort ) )* ( (lv_ifSPPs_9_0= ruleSPPRef ) )* '}' )? ( 'Structure' '{' ( 'usercode1' ( (lv_userCode1_14_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_16_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_17_0= rulePort ) ) | ( (lv_extPorts_18_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_19_0= ruleServiceImplementation ) )* ( (lv_strSAPs_20_0= ruleSAPRef ) )* ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_actorRefs_22_0= ruleActorRef ) )* ( (lv_bindings_23_0= ruleBinding ) )* ( (lv_connections_24_0= ruleLayerConnection ) )* '}' )? ( 'Behavior' '{' ( (lv_operations_28_0= ruleOperation ) )* ( (lv_stateMachine_29_0= ruleStateMachine ) )? '}' )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1956:1: ( ( (lv_abstract_0_0= 'abstract' ) )? 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'Interface' '{' ( (lv_ifPorts_8_0= rulePort ) )* ( (lv_ifSPPs_9_0= ruleSPPRef ) )* '}' )? ( 'Structure' '{' ( 'usercode1' ( (lv_userCode1_14_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_16_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_17_0= rulePort ) ) | ( (lv_extPorts_18_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_19_0= ruleServiceImplementation ) )* ( (lv_strSAPs_20_0= ruleSAPRef ) )* ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_actorRefs_22_0= ruleActorRef ) )* ( (lv_bindings_23_0= ruleBinding ) )* ( (lv_connections_24_0= ruleLayerConnection ) )* '}' )? ( 'Behavior' '{' ( (lv_operations_28_0= ruleOperation ) )* ( (lv_stateMachine_29_0= ruleStateMachine ) )? '}' )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1956:1: ( ( (lv_abstract_0_0= 'abstract' ) )? 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'Interface' '{' ( (lv_ifPorts_8_0= rulePort ) )* ( (lv_ifSPPs_9_0= ruleSPPRef ) )* '}' )? ( 'Structure' '{' ( 'usercode1' ( (lv_userCode1_14_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_16_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_17_0= rulePort ) ) | ( (lv_extPorts_18_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_19_0= ruleServiceImplementation ) )* ( (lv_strSAPs_20_0= ruleSAPRef ) )* ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_actorRefs_22_0= ruleActorRef ) )* ( (lv_bindings_23_0= ruleBinding ) )* ( (lv_connections_24_0= ruleLayerConnection ) )* '}' )? ( 'Behavior' '{' ( (lv_operations_28_0= ruleOperation ) )* ( (lv_stateMachine_29_0= ruleStateMachine ) )? '}' )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1956:2: ( (lv_abstract_0_0= 'abstract' ) )? 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'Interface' '{' ( (lv_ifPorts_8_0= rulePort ) )* ( (lv_ifSPPs_9_0= ruleSPPRef ) )* '}' )? ( 'Structure' '{' ( 'usercode1' ( (lv_userCode1_14_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_16_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_17_0= rulePort ) ) | ( (lv_extPorts_18_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_19_0= ruleServiceImplementation ) )* ( (lv_strSAPs_20_0= ruleSAPRef ) )* ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_actorRefs_22_0= ruleActorRef ) )* ( (lv_bindings_23_0= ruleBinding ) )* ( (lv_connections_24_0= ruleLayerConnection ) )* '}' )? ( 'Behavior' '{' ( (lv_operations_28_0= ruleOperation ) )* ( (lv_stateMachine_29_0= ruleStateMachine ) )? '}' )? '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1956:2: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==39) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1957:1: (lv_abstract_0_0= 'abstract' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1957:1: (lv_abstract_0_0= 'abstract' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1958:3: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)input.LT(1);
                    match(input,39,FOLLOW_39_in_ruleActorClass3262); 

                            createLeafNode(grammarAccess.getActorClassAccess().getAbstractAbstractKeyword_0_0(), "abstract"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "abstract", true, "abstract", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,40,FOLLOW_40_in_ruleActorClass3286); 

                    createLeafNode(grammarAccess.getActorClassAccess().getActorClassKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1981:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1982:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1982:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1983:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorClass3303); 

            			createLeafNode(grammarAccess.getActorClassAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2005:2: ( 'extends' ( ( ruleFQN ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==16) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2005:4: 'extends' ( ( ruleFQN ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleActorClass3319); 

                            createLeafNode(grammarAccess.getActorClassAccess().getExtendsKeyword_3_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2009:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2010:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2010:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2011:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getBaseActorClassCrossReference_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleActorClass3342);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleActorClass3354); 

                    createLeafNode(grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2029:1: ( 'Interface' '{' ( (lv_ifPorts_8_0= rulePort ) )* ( (lv_ifSPPs_9_0= ruleSPPRef ) )* '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==41) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2029:3: 'Interface' '{' ( (lv_ifPorts_8_0= rulePort ) )* ( (lv_ifSPPs_9_0= ruleSPPRef ) )* '}'
                    {
                    match(input,41,FOLLOW_41_in_ruleActorClass3365); 

                            createLeafNode(grammarAccess.getActorClassAccess().getInterfaceKeyword_5_0(), null); 
                        
                    match(input,12,FOLLOW_12_in_ruleActorClass3375); 

                            createLeafNode(grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_5_1(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2037:1: ( (lv_ifPorts_8_0= rulePort ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( ((LA33_0>=44 && LA33_0<=45)) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2038:1: (lv_ifPorts_8_0= rulePort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2038:1: (lv_ifPorts_8_0= rulePort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2039:3: lv_ifPorts_8_0= rulePort
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getIfPortsPortParserRuleCall_5_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePort_in_ruleActorClass3396);
                    	    lv_ifPorts_8_0=rulePort();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"ifPorts",
                    	    	        		lv_ifPorts_8_0, 
                    	    	        		"Port", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2061:3: ( (lv_ifSPPs_9_0= ruleSPPRef ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==48) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2062:1: (lv_ifSPPs_9_0= ruleSPPRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2062:1: (lv_ifSPPs_9_0= ruleSPPRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2063:3: lv_ifSPPs_9_0= ruleSPPRef
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getIfSPPsSPPRefParserRuleCall_5_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSPPRef_in_ruleActorClass3418);
                    	    lv_ifSPPs_9_0=ruleSPPRef();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"ifSPPs",
                    	    	        		lv_ifSPPs_9_0, 
                    	    	        		"SPPRef", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    match(input,13,FOLLOW_13_in_ruleActorClass3429); 

                            createLeafNode(grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_5_4(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2089:3: ( 'Structure' '{' ( 'usercode1' ( (lv_userCode1_14_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_16_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_17_0= rulePort ) ) | ( (lv_extPorts_18_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_19_0= ruleServiceImplementation ) )* ( (lv_strSAPs_20_0= ruleSAPRef ) )* ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_actorRefs_22_0= ruleActorRef ) )* ( (lv_bindings_23_0= ruleBinding ) )* ( (lv_connections_24_0= ruleLayerConnection ) )* '}' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==42) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2089:5: 'Structure' '{' ( 'usercode1' ( (lv_userCode1_14_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_16_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_17_0= rulePort ) ) | ( (lv_extPorts_18_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_19_0= ruleServiceImplementation ) )* ( (lv_strSAPs_20_0= ruleSAPRef ) )* ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_actorRefs_22_0= ruleActorRef ) )* ( (lv_bindings_23_0= ruleBinding ) )* ( (lv_connections_24_0= ruleLayerConnection ) )* '}'
                    {
                    match(input,42,FOLLOW_42_in_ruleActorClass3442); 

                            createLeafNode(grammarAccess.getActorClassAccess().getStructureKeyword_6_0(), null); 
                        
                    match(input,12,FOLLOW_12_in_ruleActorClass3452); 

                            createLeafNode(grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_6_1(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2097:1: ( 'usercode1' ( (lv_userCode1_14_0= ruleDetailCode ) ) )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==25) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2097:3: 'usercode1' ( (lv_userCode1_14_0= ruleDetailCode ) )
                            {
                            match(input,25,FOLLOW_25_in_ruleActorClass3463); 

                                    createLeafNode(grammarAccess.getActorClassAccess().getUsercode1Keyword_6_2_0(), null); 
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2101:1: ( (lv_userCode1_14_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2102:1: (lv_userCode1_14_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2102:1: (lv_userCode1_14_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2103:3: lv_userCode1_14_0= ruleDetailCode
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getUserCode1DetailCodeParserRuleCall_6_2_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleActorClass3484);
                            lv_userCode1_14_0=ruleDetailCode();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"userCode1",
                            	        		lv_userCode1_14_0, 
                            	        		"DetailCode", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2125:4: ( 'usercode2' ( (lv_userCode2_16_0= ruleDetailCode ) ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==26) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2125:6: 'usercode2' ( (lv_userCode2_16_0= ruleDetailCode ) )
                            {
                            match(input,26,FOLLOW_26_in_ruleActorClass3497); 

                                    createLeafNode(grammarAccess.getActorClassAccess().getUsercode2Keyword_6_3_0(), null); 
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2129:1: ( (lv_userCode2_16_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2130:1: (lv_userCode2_16_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2130:1: (lv_userCode2_16_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2131:3: lv_userCode2_16_0= ruleDetailCode
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getUserCode2DetailCodeParserRuleCall_6_3_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleActorClass3518);
                            lv_userCode2_16_0=ruleDetailCode();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"userCode2",
                            	        		lv_userCode2_16_0, 
                            	        		"DetailCode", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2153:4: ( ( (lv_intPorts_17_0= rulePort ) ) | ( (lv_extPorts_18_0= ruleExternalPort ) ) )*
                    loop38:
                    do {
                        int alt38=3;
                        int LA38_0 = input.LA(1);

                        if ( ((LA38_0>=44 && LA38_0<=45)) ) {
                            alt38=1;
                        }
                        else if ( (LA38_0==46) ) {
                            alt38=2;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2153:5: ( (lv_intPorts_17_0= rulePort ) )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2153:5: ( (lv_intPorts_17_0= rulePort ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2154:1: (lv_intPorts_17_0= rulePort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2154:1: (lv_intPorts_17_0= rulePort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2155:3: lv_intPorts_17_0= rulePort
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getIntPortsPortParserRuleCall_6_4_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePort_in_ruleActorClass3542);
                    	    lv_intPorts_17_0=rulePort();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"intPorts",
                    	    	        		lv_intPorts_17_0, 
                    	    	        		"Port", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2178:6: ( (lv_extPorts_18_0= ruleExternalPort ) )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2178:6: ( (lv_extPorts_18_0= ruleExternalPort ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2179:1: (lv_extPorts_18_0= ruleExternalPort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2179:1: (lv_extPorts_18_0= ruleExternalPort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2180:3: lv_extPorts_18_0= ruleExternalPort
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getExtPortsExternalPortParserRuleCall_6_4_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExternalPort_in_ruleActorClass3569);
                    	    lv_extPorts_18_0=ruleExternalPort();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"extPorts",
                    	    	        		lv_extPorts_18_0, 
                    	    	        		"ExternalPort", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2202:4: ( (lv_serviceImplementations_19_0= ruleServiceImplementation ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==49) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2203:1: (lv_serviceImplementations_19_0= ruleServiceImplementation )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2203:1: (lv_serviceImplementations_19_0= ruleServiceImplementation )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2204:3: lv_serviceImplementations_19_0= ruleServiceImplementation
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getServiceImplementationsServiceImplementationParserRuleCall_6_5_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleServiceImplementation_in_ruleActorClass3592);
                    	    lv_serviceImplementations_19_0=ruleServiceImplementation();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"serviceImplementations",
                    	    	        		lv_serviceImplementations_19_0, 
                    	    	        		"ServiceImplementation", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2226:3: ( (lv_strSAPs_20_0= ruleSAPRef ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==47) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2227:1: (lv_strSAPs_20_0= ruleSAPRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2227:1: (lv_strSAPs_20_0= ruleSAPRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2228:3: lv_strSAPs_20_0= ruleSAPRef
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getStrSAPsSAPRefParserRuleCall_6_6_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSAPRef_in_ruleActorClass3614);
                    	    lv_strSAPs_20_0=ruleSAPRef();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"strSAPs",
                    	    	        		lv_strSAPs_20_0, 
                    	    	        		"SAPRef", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2250:3: ( (lv_attributes_21_0= ruleAttribute ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==17) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2251:1: (lv_attributes_21_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2251:1: (lv_attributes_21_0= ruleAttribute )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2252:3: lv_attributes_21_0= ruleAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getAttributesAttributeParserRuleCall_6_7_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleActorClass3636);
                    	    lv_attributes_21_0=ruleAttribute();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_21_0, 
                    	    	        		"Attribute", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2274:3: ( (lv_actorRefs_22_0= ruleActorRef ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==62) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2275:1: (lv_actorRefs_22_0= ruleActorRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2275:1: (lv_actorRefs_22_0= ruleActorRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2276:3: lv_actorRefs_22_0= ruleActorRef
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getActorRefsActorRefParserRuleCall_6_8_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleActorRef_in_ruleActorClass3658);
                    	    lv_actorRefs_22_0=ruleActorRef();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"actorRefs",
                    	    	        		lv_actorRefs_22_0, 
                    	    	        		"ActorRef", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2298:3: ( (lv_bindings_23_0= ruleBinding ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==56) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2299:1: (lv_bindings_23_0= ruleBinding )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2299:1: (lv_bindings_23_0= ruleBinding )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2300:3: lv_bindings_23_0= ruleBinding
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getBindingsBindingParserRuleCall_6_9_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBinding_in_ruleActorClass3680);
                    	    lv_bindings_23_0=ruleBinding();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"bindings",
                    	    	        		lv_bindings_23_0, 
                    	    	        		"Binding", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2322:3: ( (lv_connections_24_0= ruleLayerConnection ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==58) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2323:1: (lv_connections_24_0= ruleLayerConnection )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2323:1: (lv_connections_24_0= ruleLayerConnection )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2324:3: lv_connections_24_0= ruleLayerConnection
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getConnectionsLayerConnectionParserRuleCall_6_10_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleActorClass3702);
                    	    lv_connections_24_0=ruleLayerConnection();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"connections",
                    	    	        		lv_connections_24_0, 
                    	    	        		"LayerConnection", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);

                    match(input,13,FOLLOW_13_in_ruleActorClass3713); 

                            createLeafNode(grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_6_11(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2350:3: ( 'Behavior' '{' ( (lv_operations_28_0= ruleOperation ) )* ( (lv_stateMachine_29_0= ruleStateMachine ) )? '}' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==43) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2350:5: 'Behavior' '{' ( (lv_operations_28_0= ruleOperation ) )* ( (lv_stateMachine_29_0= ruleStateMachine ) )? '}'
                    {
                    match(input,43,FOLLOW_43_in_ruleActorClass3726); 

                            createLeafNode(grammarAccess.getActorClassAccess().getBehaviorKeyword_7_0(), null); 
                        
                    match(input,12,FOLLOW_12_in_ruleActorClass3736); 

                            createLeafNode(grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_7_1(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2358:1: ( (lv_operations_28_0= ruleOperation ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==20) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2359:1: (lv_operations_28_0= ruleOperation )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2359:1: (lv_operations_28_0= ruleOperation )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2360:3: lv_operations_28_0= ruleOperation
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getOperationsOperationParserRuleCall_7_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleOperation_in_ruleActorClass3757);
                    	    lv_operations_28_0=ruleOperation();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operations",
                    	    	        		lv_operations_28_0, 
                    	    	        		"Operation", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2382:3: ( (lv_stateMachine_29_0= ruleStateMachine ) )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==63) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2383:1: (lv_stateMachine_29_0= ruleStateMachine )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2383:1: (lv_stateMachine_29_0= ruleStateMachine )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2384:3: lv_stateMachine_29_0= ruleStateMachine
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getStateMachineStateMachineParserRuleCall_7_3_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleStateMachine_in_ruleActorClass3779);
                            lv_stateMachine_29_0=ruleStateMachine();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"stateMachine",
                            	        		lv_stateMachine_29_0, 
                            	        		"StateMachine", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }

                    match(input,13,FOLLOW_13_in_ruleActorClass3790); 

                            createLeafNode(grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_7_4(), null); 
                        

                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleActorClass3802); 

                    createLeafNode(grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_8(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleActorClass


    // $ANTLR start entryRulePort
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2424:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2425:2: (iv_rulePort= rulePort EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2426:2: iv_rulePort= rulePort EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPortRule(), currentNode); 
            pushFollow(FOLLOW_rulePort_in_entryRulePort3840);
            iv_rulePort=rulePort();
            _fsp--;

             current =iv_rulePort; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePort3850); 

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
    // $ANTLR end entryRulePort


    // $ANTLR start rulePort
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2433:1: rulePort returns [EObject current=null] : ( ( (lv_conjugated_0_0= 'conjugated' ) )? 'Port' ( (lv_name_2_0= RULE_ID ) ) ( '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']' )? ':' ( ( ruleFQN ) ) ) ;
    public final EObject rulePort() throws RecognitionException {
        EObject current = null;

        Token lv_conjugated_0_0=null;
        Token lv_name_2_0=null;
        Token lv_multiplicity_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2438:6: ( ( ( (lv_conjugated_0_0= 'conjugated' ) )? 'Port' ( (lv_name_2_0= RULE_ID ) ) ( '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']' )? ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2439:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? 'Port' ( (lv_name_2_0= RULE_ID ) ) ( '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']' )? ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2439:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? 'Port' ( (lv_name_2_0= RULE_ID ) ) ( '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']' )? ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2439:2: ( (lv_conjugated_0_0= 'conjugated' ) )? 'Port' ( (lv_name_2_0= RULE_ID ) ) ( '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']' )? ':' ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2439:2: ( (lv_conjugated_0_0= 'conjugated' ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==44) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2440:1: (lv_conjugated_0_0= 'conjugated' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2440:1: (lv_conjugated_0_0= 'conjugated' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2441:3: lv_conjugated_0_0= 'conjugated'
                    {
                    lv_conjugated_0_0=(Token)input.LT(1);
                    match(input,44,FOLLOW_44_in_rulePort3893); 

                            createLeafNode(grammarAccess.getPortAccess().getConjugatedConjugatedKeyword_0_0(), "conjugated"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPortRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "conjugated", true, "conjugated", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,45,FOLLOW_45_in_rulePort3917); 

                    createLeafNode(grammarAccess.getPortAccess().getPortKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2464:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2465:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2465:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2466:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePort3934); 

            			createLeafNode(grammarAccess.getPortAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPortRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2488:2: ( '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==18) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2488:4: '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']'
                    {
                    match(input,18,FOLLOW_18_in_rulePort3950); 

                            createLeafNode(grammarAccess.getPortAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2492:1: ( (lv_multiplicity_4_0= RULE_INT ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2493:1: (lv_multiplicity_4_0= RULE_INT )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2493:1: (lv_multiplicity_4_0= RULE_INT )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2494:3: lv_multiplicity_4_0= RULE_INT
                    {
                    lv_multiplicity_4_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePort3967); 

                    			createLeafNode(grammarAccess.getPortAccess().getMultiplicityINTTerminalRuleCall_3_1_0(), "multiplicity"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPortRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"multiplicity",
                    	        		lv_multiplicity_4_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,19,FOLLOW_19_in_rulePort3982); 

                            createLeafNode(grammarAccess.getPortAccess().getRightSquareBracketKeyword_3_2(), null); 
                        

                    }
                    break;

            }

            match(input,14,FOLLOW_14_in_rulePort3994); 

                    createLeafNode(grammarAccess.getPortAccess().getColonKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2524:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2525:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2525:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2526:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getPortRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getPortAccess().getProtocolProtocolClassCrossReference_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_rulePort4017);
            ruleFQN();
            _fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePort


    // $ANTLR start entryRuleExternalPort
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2548:1: entryRuleExternalPort returns [EObject current=null] : iv_ruleExternalPort= ruleExternalPort EOF ;
    public final EObject entryRuleExternalPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalPort = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2549:2: (iv_ruleExternalPort= ruleExternalPort EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2550:2: iv_ruleExternalPort= ruleExternalPort EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExternalPortRule(), currentNode); 
            pushFollow(FOLLOW_ruleExternalPort_in_entryRuleExternalPort4053);
            iv_ruleExternalPort=ruleExternalPort();
            _fsp--;

             current =iv_ruleExternalPort; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalPort4063); 

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
    // $ANTLR end entryRuleExternalPort


    // $ANTLR start ruleExternalPort
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2557:1: ruleExternalPort returns [EObject current=null] : ( 'external' 'Port' ( ( RULE_ID ) ) ) ;
    public final EObject ruleExternalPort() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2562:6: ( ( 'external' 'Port' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2563:1: ( 'external' 'Port' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2563:1: ( 'external' 'Port' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2563:3: 'external' 'Port' ( ( RULE_ID ) )
            {
            match(input,46,FOLLOW_46_in_ruleExternalPort4098); 

                    createLeafNode(grammarAccess.getExternalPortAccess().getExternalKeyword_0(), null); 
                
            match(input,45,FOLLOW_45_in_ruleExternalPort4108); 

                    createLeafNode(grammarAccess.getExternalPortAccess().getPortKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2571:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2572:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2572:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2573:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getExternalPortRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalPort4126); 

            		createLeafNode(grammarAccess.getExternalPortAccess().getIfportPortCrossReference_2_0(), "ifport"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleExternalPort


    // $ANTLR start entryRuleSAPRef
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2593:1: entryRuleSAPRef returns [EObject current=null] : iv_ruleSAPRef= ruleSAPRef EOF ;
    public final EObject entryRuleSAPRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2594:2: (iv_ruleSAPRef= ruleSAPRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2595:2: iv_ruleSAPRef= ruleSAPRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSAPRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleSAPRef_in_entryRuleSAPRef4162);
            iv_ruleSAPRef=ruleSAPRef();
            _fsp--;

             current =iv_ruleSAPRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSAPRef4172); 

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
    // $ANTLR end entryRuleSAPRef


    // $ANTLR start ruleSAPRef
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2602:1: ruleSAPRef returns [EObject current=null] : ( 'SAP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSAPRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2607:6: ( ( 'SAP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2608:1: ( 'SAP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2608:1: ( 'SAP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2608:3: 'SAP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) )
            {
            match(input,47,FOLLOW_47_in_ruleSAPRef4207); 

                    createLeafNode(grammarAccess.getSAPRefAccess().getSAPKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2612:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2613:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2613:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2614:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSAPRef4224); 

            			createLeafNode(grammarAccess.getSAPRefAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSAPRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,14,FOLLOW_14_in_ruleSAPRef4239); 

                    createLeafNode(grammarAccess.getSAPRefAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2640:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2641:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2641:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2642:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSAPRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getSAPRefAccess().getProtocolProtocolClassCrossReference_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSAPRef4262);
            ruleFQN();
            _fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSAPRef


    // $ANTLR start entryRuleSPPRef
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2664:1: entryRuleSPPRef returns [EObject current=null] : iv_ruleSPPRef= ruleSPPRef EOF ;
    public final EObject entryRuleSPPRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2665:2: (iv_ruleSPPRef= ruleSPPRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2666:2: iv_ruleSPPRef= ruleSPPRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSPPRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleSPPRef_in_entryRuleSPPRef4298);
            iv_ruleSPPRef=ruleSPPRef();
            _fsp--;

             current =iv_ruleSPPRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSPPRef4308); 

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
    // $ANTLR end entryRuleSPPRef


    // $ANTLR start ruleSPPRef
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2673:1: ruleSPPRef returns [EObject current=null] : ( 'SPP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSPPRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2678:6: ( ( 'SPP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2679:1: ( 'SPP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2679:1: ( 'SPP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2679:3: 'SPP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) )
            {
            match(input,48,FOLLOW_48_in_ruleSPPRef4343); 

                    createLeafNode(grammarAccess.getSPPRefAccess().getSPPKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2683:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2684:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2684:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2685:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPRef4360); 

            			createLeafNode(grammarAccess.getSPPRefAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSPPRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,14,FOLLOW_14_in_ruleSPPRef4375); 

                    createLeafNode(grammarAccess.getSPPRefAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2711:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2712:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2712:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2713:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSPPRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getSPPRefAccess().getProtocolProtocolClassCrossReference_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSPPRef4398);
            ruleFQN();
            _fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSPPRef


    // $ANTLR start entryRuleServiceImplementation
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2735:1: entryRuleServiceImplementation returns [EObject current=null] : iv_ruleServiceImplementation= ruleServiceImplementation EOF ;
    public final EObject entryRuleServiceImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceImplementation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2736:2: (iv_ruleServiceImplementation= ruleServiceImplementation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2737:2: iv_ruleServiceImplementation= ruleServiceImplementation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getServiceImplementationRule(), currentNode); 
            pushFollow(FOLLOW_ruleServiceImplementation_in_entryRuleServiceImplementation4434);
            iv_ruleServiceImplementation=ruleServiceImplementation();
            _fsp--;

             current =iv_ruleServiceImplementation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleServiceImplementation4444); 

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
    // $ANTLR end entryRuleServiceImplementation


    // $ANTLR start ruleServiceImplementation
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2744:1: ruleServiceImplementation returns [EObject current=null] : ( 'ServiceImplementation' 'of' ( ( RULE_ID ) ) ) ;
    public final EObject ruleServiceImplementation() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2749:6: ( ( 'ServiceImplementation' 'of' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2750:1: ( 'ServiceImplementation' 'of' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2750:1: ( 'ServiceImplementation' 'of' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2750:3: 'ServiceImplementation' 'of' ( ( RULE_ID ) )
            {
            match(input,49,FOLLOW_49_in_ruleServiceImplementation4479); 

                    createLeafNode(grammarAccess.getServiceImplementationAccess().getServiceImplementationKeyword_0(), null); 
                
            match(input,50,FOLLOW_50_in_ruleServiceImplementation4489); 

                    createLeafNode(grammarAccess.getServiceImplementationAccess().getOfKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2758:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2759:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2759:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2760:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getServiceImplementationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleServiceImplementation4507); 

            		createLeafNode(grammarAccess.getServiceImplementationAccess().getSppSPPRefCrossReference_2_0(), "spp"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleServiceImplementation


    // $ANTLR start entryRuleLogicalSystem
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2780:1: entryRuleLogicalSystem returns [EObject current=null] : iv_ruleLogicalSystem= ruleLogicalSystem EOF ;
    public final EObject entryRuleLogicalSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalSystem = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2781:2: (iv_ruleLogicalSystem= ruleLogicalSystem EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2782:2: iv_ruleLogicalSystem= ruleLogicalSystem EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalSystemRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalSystem_in_entryRuleLogicalSystem4543);
            iv_ruleLogicalSystem=ruleLogicalSystem();
            _fsp--;

             current =iv_ruleLogicalSystem; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalSystem4553); 

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
    // $ANTLR end entryRuleLogicalSystem


    // $ANTLR start ruleLogicalSystem
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2789:1: ruleLogicalSystem returns [EObject current=null] : ( 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_subSystems_3_0= ruleSubSystemRef ) )+ ( (lv_bindings_4_0= ruleBinding ) )* ( (lv_connections_5_0= ruleLayerConnection ) )* '}' ) ;
    public final EObject ruleLogicalSystem() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_subSystems_3_0 = null;

        EObject lv_bindings_4_0 = null;

        EObject lv_connections_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2794:6: ( ( 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_subSystems_3_0= ruleSubSystemRef ) )+ ( (lv_bindings_4_0= ruleBinding ) )* ( (lv_connections_5_0= ruleLayerConnection ) )* '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2795:1: ( 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_subSystems_3_0= ruleSubSystemRef ) )+ ( (lv_bindings_4_0= ruleBinding ) )* ( (lv_connections_5_0= ruleLayerConnection ) )* '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2795:1: ( 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_subSystems_3_0= ruleSubSystemRef ) )+ ( (lv_bindings_4_0= ruleBinding ) )* ( (lv_connections_5_0= ruleLayerConnection ) )* '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2795:3: 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_subSystems_3_0= ruleSubSystemRef ) )+ ( (lv_bindings_4_0= ruleBinding ) )* ( (lv_connections_5_0= ruleLayerConnection ) )* '}'
            {
            match(input,51,FOLLOW_51_in_ruleLogicalSystem4588); 

                    createLeafNode(grammarAccess.getLogicalSystemAccess().getLogicalSystemKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2799:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2800:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2800:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2801:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLogicalSystem4605); 

            			createLeafNode(grammarAccess.getLogicalSystemAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLogicalSystemRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleLogicalSystem4620); 

                    createLeafNode(grammarAccess.getLogicalSystemAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2827:1: ( (lv_subSystems_3_0= ruleSubSystemRef ) )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==52) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2828:1: (lv_subSystems_3_0= ruleSubSystemRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2828:1: (lv_subSystems_3_0= ruleSubSystemRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2829:3: lv_subSystems_3_0= ruleSubSystemRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalSystemAccess().getSubSystemsSubSystemRefParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubSystemRef_in_ruleLogicalSystem4641);
            	    lv_subSystems_3_0=ruleSubSystemRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLogicalSystemRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"subSystems",
            	    	        		lv_subSystems_3_0, 
            	    	        		"SubSystemRef", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2851:3: ( (lv_bindings_4_0= ruleBinding ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==56) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2852:1: (lv_bindings_4_0= ruleBinding )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2852:1: (lv_bindings_4_0= ruleBinding )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2853:3: lv_bindings_4_0= ruleBinding
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalSystemAccess().getBindingsBindingParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleBinding_in_ruleLogicalSystem4663);
            	    lv_bindings_4_0=ruleBinding();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLogicalSystemRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"bindings",
            	    	        		lv_bindings_4_0, 
            	    	        		"Binding", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2875:3: ( (lv_connections_5_0= ruleLayerConnection ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==58) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2876:1: (lv_connections_5_0= ruleLayerConnection )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2876:1: (lv_connections_5_0= ruleLayerConnection )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2877:3: lv_connections_5_0= ruleLayerConnection
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalSystemAccess().getConnectionsLayerConnectionParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleLogicalSystem4685);
            	    lv_connections_5_0=ruleLayerConnection();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLogicalSystemRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"connections",
            	    	        		lv_connections_5_0, 
            	    	        		"LayerConnection", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleLogicalSystem4696); 

                    createLeafNode(grammarAccess.getLogicalSystemAccess().getRightCurlyBracketKeyword_6(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLogicalSystem


    // $ANTLR start entryRuleSubSystemRef
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2913:1: entryRuleSubSystemRef returns [EObject current=null] : iv_ruleSubSystemRef= ruleSubSystemRef EOF ;
    public final EObject entryRuleSubSystemRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2914:2: (iv_ruleSubSystemRef= ruleSubSystemRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2915:2: iv_ruleSubSystemRef= ruleSubSystemRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubSystemRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubSystemRef_in_entryRuleSubSystemRef4734);
            iv_ruleSubSystemRef=ruleSubSystemRef();
            _fsp--;

             current =iv_ruleSubSystemRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemRef4744); 

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
    // $ANTLR end entryRuleSubSystemRef


    // $ANTLR start ruleSubSystemRef
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2922:1: ruleSubSystemRef returns [EObject current=null] : ( 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSubSystemRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2927:6: ( ( 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2928:1: ( 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2928:1: ( 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2928:3: 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) )
            {
            match(input,52,FOLLOW_52_in_ruleSubSystemRef4779); 

                    createLeafNode(grammarAccess.getSubSystemRefAccess().getSubSystemRefKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2932:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2933:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2933:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2934:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemRef4796); 

            			createLeafNode(grammarAccess.getSubSystemRefAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubSystemRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,14,FOLLOW_14_in_ruleSubSystemRef4811); 

                    createLeafNode(grammarAccess.getSubSystemRefAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2960:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2961:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2961:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2962:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubSystemRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getSubSystemRefAccess().getTypeSubSystemClassCrossReference_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSubSystemRef4834);
            ruleFQN();
            _fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSubSystemRef


    // $ANTLR start entryRuleSubSystemClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2984:1: entryRuleSubSystemClass returns [EObject current=null] : iv_ruleSubSystemClass= ruleSubSystemClass EOF ;
    public final EObject entryRuleSubSystemClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2985:2: (iv_ruleSubSystemClass= ruleSubSystemClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2986:2: iv_ruleSubSystemClass= ruleSubSystemClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubSystemClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubSystemClass_in_entryRuleSubSystemClass4870);
            iv_ruleSubSystemClass=ruleSubSystemClass();
            _fsp--;

             current =iv_ruleSubSystemClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemClass4880); 

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
    // $ANTLR end entryRuleSubSystemClass


    // $ANTLR start ruleSubSystemClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2993:1: ruleSubSystemClass returns [EObject current=null] : ( 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_relayPorts_3_0= rulePort ) )* ( (lv_ifSPPs_4_0= ruleSPPRef ) )* ( (lv_actorRefs_5_0= ruleActorRef ) )+ ( (lv_bindings_6_0= ruleBinding ) )* ( (lv_connections_7_0= ruleLayerConnection ) )* ( (lv_threads_8_0= ruleLogicalThread ) )* '}' ) ;
    public final EObject ruleSubSystemClass() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_relayPorts_3_0 = null;

        EObject lv_ifSPPs_4_0 = null;

        EObject lv_actorRefs_5_0 = null;

        EObject lv_bindings_6_0 = null;

        EObject lv_connections_7_0 = null;

        EObject lv_threads_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2998:6: ( ( 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_relayPorts_3_0= rulePort ) )* ( (lv_ifSPPs_4_0= ruleSPPRef ) )* ( (lv_actorRefs_5_0= ruleActorRef ) )+ ( (lv_bindings_6_0= ruleBinding ) )* ( (lv_connections_7_0= ruleLayerConnection ) )* ( (lv_threads_8_0= ruleLogicalThread ) )* '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2999:1: ( 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_relayPorts_3_0= rulePort ) )* ( (lv_ifSPPs_4_0= ruleSPPRef ) )* ( (lv_actorRefs_5_0= ruleActorRef ) )+ ( (lv_bindings_6_0= ruleBinding ) )* ( (lv_connections_7_0= ruleLayerConnection ) )* ( (lv_threads_8_0= ruleLogicalThread ) )* '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2999:1: ( 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_relayPorts_3_0= rulePort ) )* ( (lv_ifSPPs_4_0= ruleSPPRef ) )* ( (lv_actorRefs_5_0= ruleActorRef ) )+ ( (lv_bindings_6_0= ruleBinding ) )* ( (lv_connections_7_0= ruleLayerConnection ) )* ( (lv_threads_8_0= ruleLogicalThread ) )* '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2999:3: 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_relayPorts_3_0= rulePort ) )* ( (lv_ifSPPs_4_0= ruleSPPRef ) )* ( (lv_actorRefs_5_0= ruleActorRef ) )+ ( (lv_bindings_6_0= ruleBinding ) )* ( (lv_connections_7_0= ruleLayerConnection ) )* ( (lv_threads_8_0= ruleLogicalThread ) )* '}'
            {
            match(input,53,FOLLOW_53_in_ruleSubSystemClass4915); 

                    createLeafNode(grammarAccess.getSubSystemClassAccess().getSubSystemClassKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3003:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3004:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3004:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3005:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemClass4932); 

            			createLeafNode(grammarAccess.getSubSystemClassAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleSubSystemClass4947); 

                    createLeafNode(grammarAccess.getSubSystemClassAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3031:1: ( (lv_relayPorts_3_0= rulePort ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( ((LA54_0>=44 && LA54_0<=45)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3032:1: (lv_relayPorts_3_0= rulePort )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3032:1: (lv_relayPorts_3_0= rulePort )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3033:3: lv_relayPorts_3_0= rulePort
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getRelayPortsPortParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_rulePort_in_ruleSubSystemClass4968);
            	    lv_relayPorts_3_0=rulePort();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"relayPorts",
            	    	        		lv_relayPorts_3_0, 
            	    	        		"Port", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3055:3: ( (lv_ifSPPs_4_0= ruleSPPRef ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==48) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3056:1: (lv_ifSPPs_4_0= ruleSPPRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3056:1: (lv_ifSPPs_4_0= ruleSPPRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3057:3: lv_ifSPPs_4_0= ruleSPPRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getIfSPPsSPPRefParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSPPRef_in_ruleSubSystemClass4990);
            	    lv_ifSPPs_4_0=ruleSPPRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"ifSPPs",
            	    	        		lv_ifSPPs_4_0, 
            	    	        		"SPPRef", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3079:3: ( (lv_actorRefs_5_0= ruleActorRef ) )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==62) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3080:1: (lv_actorRefs_5_0= ruleActorRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3080:1: (lv_actorRefs_5_0= ruleActorRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3081:3: lv_actorRefs_5_0= ruleActorRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getActorRefsActorRefParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorRef_in_ruleSubSystemClass5012);
            	    lv_actorRefs_5_0=ruleActorRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"actorRefs",
            	    	        		lv_actorRefs_5_0, 
            	    	        		"ActorRef", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt56 >= 1 ) break loop56;
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3103:3: ( (lv_bindings_6_0= ruleBinding ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==56) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3104:1: (lv_bindings_6_0= ruleBinding )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3104:1: (lv_bindings_6_0= ruleBinding )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3105:3: lv_bindings_6_0= ruleBinding
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getBindingsBindingParserRuleCall_6_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleBinding_in_ruleSubSystemClass5034);
            	    lv_bindings_6_0=ruleBinding();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"bindings",
            	    	        		lv_bindings_6_0, 
            	    	        		"Binding", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3127:3: ( (lv_connections_7_0= ruleLayerConnection ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==58) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3128:1: (lv_connections_7_0= ruleLayerConnection )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3128:1: (lv_connections_7_0= ruleLayerConnection )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3129:3: lv_connections_7_0= ruleLayerConnection
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getConnectionsLayerConnectionParserRuleCall_7_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleSubSystemClass5056);
            	    lv_connections_7_0=ruleLayerConnection();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"connections",
            	    	        		lv_connections_7_0, 
            	    	        		"LayerConnection", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3151:3: ( (lv_threads_8_0= ruleLogicalThread ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==54) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3152:1: (lv_threads_8_0= ruleLogicalThread )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3152:1: (lv_threads_8_0= ruleLogicalThread )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3153:3: lv_threads_8_0= ruleLogicalThread
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getThreadsLogicalThreadParserRuleCall_8_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLogicalThread_in_ruleSubSystemClass5078);
            	    lv_threads_8_0=ruleLogicalThread();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"threads",
            	    	        		lv_threads_8_0, 
            	    	        		"LogicalThread", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleSubSystemClass5089); 

                    createLeafNode(grammarAccess.getSubSystemClassAccess().getRightCurlyBracketKeyword_9(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSubSystemClass


    // $ANTLR start entryRuleLogicalThread
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3187:1: entryRuleLogicalThread returns [EObject current=null] : iv_ruleLogicalThread= ruleLogicalThread EOF ;
    public final EObject entryRuleLogicalThread() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalThread = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3188:2: (iv_ruleLogicalThread= ruleLogicalThread EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3189:2: iv_ruleLogicalThread= ruleLogicalThread EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalThreadRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalThread_in_entryRuleLogicalThread5125);
            iv_ruleLogicalThread=ruleLogicalThread();
            _fsp--;

             current =iv_ruleLogicalThread; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalThread5135); 

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
    // $ANTLR end entryRuleLogicalThread


    // $ANTLR start ruleLogicalThread
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3196:1: ruleLogicalThread returns [EObject current=null] : ( 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_instances_3_0= ruleActorInstancePath ) ) ( ',' ( (lv_instances_5_0= ruleActorInstancePath ) ) )* '}' ) ;
    public final EObject ruleLogicalThread() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_instances_3_0 = null;

        EObject lv_instances_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3201:6: ( ( 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_instances_3_0= ruleActorInstancePath ) ) ( ',' ( (lv_instances_5_0= ruleActorInstancePath ) ) )* '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3202:1: ( 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_instances_3_0= ruleActorInstancePath ) ) ( ',' ( (lv_instances_5_0= ruleActorInstancePath ) ) )* '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3202:1: ( 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_instances_3_0= ruleActorInstancePath ) ) ( ',' ( (lv_instances_5_0= ruleActorInstancePath ) ) )* '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3202:3: 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_instances_3_0= ruleActorInstancePath ) ) ( ',' ( (lv_instances_5_0= ruleActorInstancePath ) ) )* '}'
            {
            match(input,54,FOLLOW_54_in_ruleLogicalThread5170); 

                    createLeafNode(grammarAccess.getLogicalThreadAccess().getLogicalThreadKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3206:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3207:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3207:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3208:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLogicalThread5187); 

            			createLeafNode(grammarAccess.getLogicalThreadAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLogicalThreadRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleLogicalThread5202); 

                    createLeafNode(grammarAccess.getLogicalThreadAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3234:1: ( (lv_instances_3_0= ruleActorInstancePath ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3235:1: (lv_instances_3_0= ruleActorInstancePath )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3235:1: (lv_instances_3_0= ruleActorInstancePath )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3236:3: lv_instances_3_0= ruleActorInstancePath
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLogicalThreadAccess().getInstancesActorInstancePathParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleActorInstancePath_in_ruleLogicalThread5223);
            lv_instances_3_0=ruleActorInstancePath();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLogicalThreadRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"instances",
            	        		lv_instances_3_0, 
            	        		"ActorInstancePath", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3258:2: ( ',' ( (lv_instances_5_0= ruleActorInstancePath ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==22) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3258:4: ',' ( (lv_instances_5_0= ruleActorInstancePath ) )
            	    {
            	    match(input,22,FOLLOW_22_in_ruleLogicalThread5234); 

            	            createLeafNode(grammarAccess.getLogicalThreadAccess().getCommaKeyword_4_0(), null); 
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3262:1: ( (lv_instances_5_0= ruleActorInstancePath ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3263:1: (lv_instances_5_0= ruleActorInstancePath )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3263:1: (lv_instances_5_0= ruleActorInstancePath )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3264:3: lv_instances_5_0= ruleActorInstancePath
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalThreadAccess().getInstancesActorInstancePathParserRuleCall_4_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorInstancePath_in_ruleLogicalThread5255);
            	    lv_instances_5_0=ruleActorInstancePath();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLogicalThreadRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"instances",
            	    	        		lv_instances_5_0, 
            	    	        		"ActorInstancePath", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleLogicalThread5267); 

                    createLeafNode(grammarAccess.getLogicalThreadAccess().getRightCurlyBracketKeyword_5(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLogicalThread


    // $ANTLR start entryRuleActorInstancePath
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3298:1: entryRuleActorInstancePath returns [EObject current=null] : iv_ruleActorInstancePath= ruleActorInstancePath EOF ;
    public final EObject entryRuleActorInstancePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstancePath = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3299:2: (iv_ruleActorInstancePath= ruleActorInstancePath EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3300:2: iv_ruleActorInstancePath= ruleActorInstancePath EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActorInstancePathRule(), currentNode); 
            pushFollow(FOLLOW_ruleActorInstancePath_in_entryRuleActorInstancePath5303);
            iv_ruleActorInstancePath=ruleActorInstancePath();
            _fsp--;

             current =iv_ruleActorInstancePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorInstancePath5313); 

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
    // $ANTLR end entryRuleActorInstancePath


    // $ANTLR start ruleActorInstancePath
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3307:1: ruleActorInstancePath returns [EObject current=null] : ( ( (lv_segments_0_0= RULE_ID ) ) ( '.' ( (lv_segments_2_0= RULE_ID ) ) )* ) ;
    public final EObject ruleActorInstancePath() throws RecognitionException {
        EObject current = null;

        Token lv_segments_0_0=null;
        Token lv_segments_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3312:6: ( ( ( (lv_segments_0_0= RULE_ID ) ) ( '.' ( (lv_segments_2_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3313:1: ( ( (lv_segments_0_0= RULE_ID ) ) ( '.' ( (lv_segments_2_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3313:1: ( ( (lv_segments_0_0= RULE_ID ) ) ( '.' ( (lv_segments_2_0= RULE_ID ) ) )* )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3313:2: ( (lv_segments_0_0= RULE_ID ) ) ( '.' ( (lv_segments_2_0= RULE_ID ) ) )*
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3313:2: ( (lv_segments_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3314:1: (lv_segments_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3314:1: (lv_segments_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3315:3: lv_segments_0_0= RULE_ID
            {
            lv_segments_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorInstancePath5355); 

            			createLeafNode(grammarAccess.getActorInstancePathAccess().getSegmentsIDTerminalRuleCall_0_0(), "segments"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getActorInstancePathRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"segments",
            	        		lv_segments_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3337:2: ( '.' ( (lv_segments_2_0= RULE_ID ) ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==55) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3337:4: '.' ( (lv_segments_2_0= RULE_ID ) )
            	    {
            	    match(input,55,FOLLOW_55_in_ruleActorInstancePath5371); 

            	            createLeafNode(grammarAccess.getActorInstancePathAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3341:1: ( (lv_segments_2_0= RULE_ID ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3342:1: (lv_segments_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3342:1: (lv_segments_2_0= RULE_ID )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3343:3: lv_segments_2_0= RULE_ID
            	    {
            	    lv_segments_2_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorInstancePath5388); 

            	    			createLeafNode(grammarAccess.getActorInstancePathAccess().getSegmentsIDTerminalRuleCall_1_1_0(), "segments"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getActorInstancePathRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"segments",
            	    	        		lv_segments_2_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleActorInstancePath


    // $ANTLR start entryRuleBinding
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3373:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3374:2: (iv_ruleBinding= ruleBinding EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3375:2: iv_ruleBinding= ruleBinding EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBindingRule(), currentNode); 
            pushFollow(FOLLOW_ruleBinding_in_entryRuleBinding5431);
            iv_ruleBinding=ruleBinding();
            _fsp--;

             current =iv_ruleBinding; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBinding5441); 

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
    // $ANTLR end entryRuleBinding


    // $ANTLR start ruleBinding
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3382:1: ruleBinding returns [EObject current=null] : ( 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        EObject lv_endpoint1_1_0 = null;

        EObject lv_endpoint2_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3387:6: ( ( 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3388:1: ( 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3388:1: ( 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3388:3: 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            {
            match(input,56,FOLLOW_56_in_ruleBinding5476); 

                    createLeafNode(grammarAccess.getBindingAccess().getBindingKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3392:1: ( (lv_endpoint1_1_0= ruleBindingEndPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3393:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3393:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3394:3: lv_endpoint1_1_0= ruleBindingEndPoint
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBindingAccess().getEndpoint1BindingEndPointParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBindingEndPoint_in_ruleBinding5497);
            lv_endpoint1_1_0=ruleBindingEndPoint();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBindingRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"endpoint1",
            	        		lv_endpoint1_1_0, 
            	        		"BindingEndPoint", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,57,FOLLOW_57_in_ruleBinding5507); 

                    createLeafNode(grammarAccess.getBindingAccess().getAndKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3420:1: ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3421:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3421:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3422:3: lv_endpoint2_3_0= ruleBindingEndPoint
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBindingAccess().getEndpoint2BindingEndPointParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBindingEndPoint_in_ruleBinding5528);
            lv_endpoint2_3_0=ruleBindingEndPoint();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBindingRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"endpoint2",
            	        		lv_endpoint2_3_0, 
            	        		"BindingEndPoint", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBinding


    // $ANTLR start entryRuleBindingEndPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3452:1: entryRuleBindingEndPoint returns [EObject current=null] : iv_ruleBindingEndPoint= ruleBindingEndPoint EOF ;
    public final EObject entryRuleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingEndPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3453:2: (iv_ruleBindingEndPoint= ruleBindingEndPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3454:2: iv_ruleBindingEndPoint= ruleBindingEndPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBindingEndPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleBindingEndPoint_in_entryRuleBindingEndPoint5564);
            iv_ruleBindingEndPoint=ruleBindingEndPoint();
            _fsp--;

             current =iv_ruleBindingEndPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBindingEndPoint5574); 

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
    // $ANTLR end entryRuleBindingEndPoint


    // $ANTLR start ruleBindingEndPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3461:1: ruleBindingEndPoint returns [EObject current=null] : ( ( ( ( RULE_ID ) ) '.' )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleBindingEndPoint() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3466:6: ( ( ( ( ( RULE_ID ) ) '.' )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3467:1: ( ( ( ( RULE_ID ) ) '.' )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3467:1: ( ( ( ( RULE_ID ) ) '.' )? ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3467:2: ( ( ( RULE_ID ) ) '.' )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3467:2: ( ( ( RULE_ID ) ) '.' )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_ID) ) {
                int LA62_1 = input.LA(2);

                if ( (LA62_1==55) ) {
                    alt62=1;
                }
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3467:3: ( ( RULE_ID ) ) '.'
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3467:3: ( ( RULE_ID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3468:1: ( RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3468:1: ( RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3469:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getBindingEndPointRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBindingEndPoint5618); 

                    		createLeafNode(grammarAccess.getBindingEndPointAccess().getActorRefActorContainerRefCrossReference_0_0_0(), "actorRef"); 
                    	

                    }


                    }

                    match(input,55,FOLLOW_55_in_ruleBindingEndPoint5628); 

                            createLeafNode(grammarAccess.getBindingEndPointAccess().getFullStopKeyword_0_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3485:3: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3486:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3486:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3487:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBindingEndPointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBindingEndPoint5648); 

            		createLeafNode(grammarAccess.getBindingEndPointAccess().getPortPortCrossReference_1_0(), "port"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBindingEndPoint


    // $ANTLR start entryRuleLayerConnection
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3507:1: entryRuleLayerConnection returns [EObject current=null] : iv_ruleLayerConnection= ruleLayerConnection EOF ;
    public final EObject entryRuleLayerConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerConnection = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3508:2: (iv_ruleLayerConnection= ruleLayerConnection EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3509:2: iv_ruleLayerConnection= ruleLayerConnection EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLayerConnectionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLayerConnection_in_entryRuleLayerConnection5684);
            iv_ruleLayerConnection=ruleLayerConnection();
            _fsp--;

             current =iv_ruleLayerConnection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLayerConnection5694); 

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
    // $ANTLR end entryRuleLayerConnection


    // $ANTLR start ruleLayerConnection
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3516:1: ruleLayerConnection returns [EObject current=null] : ( 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) ;
    public final EObject ruleLayerConnection() throws RecognitionException {
        EObject current = null;

        EObject lv_from_1_0 = null;

        EObject lv_to_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3521:6: ( ( 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3522:1: ( 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3522:1: ( 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3522:3: 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) )
            {
            match(input,58,FOLLOW_58_in_ruleLayerConnection5729); 

                    createLeafNode(grammarAccess.getLayerConnectionAccess().getLayerConnectionKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3526:1: ( (lv_from_1_0= ruleSAPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3527:1: (lv_from_1_0= ruleSAPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3527:1: (lv_from_1_0= ruleSAPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3528:3: lv_from_1_0= ruleSAPoint
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLayerConnectionAccess().getFromSAPointParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSAPoint_in_ruleLayerConnection5750);
            lv_from_1_0=ruleSAPoint();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLayerConnectionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"from",
            	        		lv_from_1_0, 
            	        		"SAPoint", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,59,FOLLOW_59_in_ruleLayerConnection5760); 

                    createLeafNode(grammarAccess.getLayerConnectionAccess().getSatisfied_byKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3554:1: ( (lv_to_3_0= ruleSPPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3555:1: (lv_to_3_0= ruleSPPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3555:1: (lv_to_3_0= ruleSPPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3556:3: lv_to_3_0= ruleSPPoint
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLayerConnectionAccess().getToSPPointParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSPPoint_in_ruleLayerConnection5781);
            lv_to_3_0=ruleSPPoint();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLayerConnectionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"to",
            	        		lv_to_3_0, 
            	        		"SPPoint", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLayerConnection


    // $ANTLR start entryRuleSAPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3586:1: entryRuleSAPoint returns [EObject current=null] : iv_ruleSAPoint= ruleSAPoint EOF ;
    public final EObject entryRuleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3587:2: (iv_ruleSAPoint= ruleSAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3588:2: iv_ruleSAPoint= ruleSAPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSAPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleSAPoint_in_entryRuleSAPoint5817);
            iv_ruleSAPoint=ruleSAPoint();
            _fsp--;

             current =iv_ruleSAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSAPoint5827); 

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
    // $ANTLR end entryRuleSAPoint


    // $ANTLR start ruleSAPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3595:1: ruleSAPoint returns [EObject current=null] : (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) ;
    public final EObject ruleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject this_RefSAPoint_0 = null;

        EObject this_RelaySAPoint_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3600:6: ( (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3601:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3601:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==60) ) {
                alt63=1;
            }
            else if ( (LA63_0==61) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3601:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3602:5: this_RefSAPoint_0= ruleRefSAPoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSAPointAccess().getRefSAPointParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRefSAPoint_in_ruleSAPoint5874);
                    this_RefSAPoint_0=ruleRefSAPoint();
                    _fsp--;

                     
                            current = this_RefSAPoint_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3612:5: this_RelaySAPoint_1= ruleRelaySAPoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSAPointAccess().getRelaySAPointParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRelaySAPoint_in_ruleSAPoint5901);
                    this_RelaySAPoint_1=ruleRelaySAPoint();
                    _fsp--;

                     
                            current = this_RelaySAPoint_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSAPoint


    // $ANTLR start entryRuleRefSAPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3628:1: entryRuleRefSAPoint returns [EObject current=null] : iv_ruleRefSAPoint= ruleRefSAPoint EOF ;
    public final EObject entryRuleRefSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3629:2: (iv_ruleRefSAPoint= ruleRefSAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3630:2: iv_ruleRefSAPoint= ruleRefSAPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRefSAPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleRefSAPoint_in_entryRuleRefSAPoint5936);
            iv_ruleRefSAPoint=ruleRefSAPoint();
            _fsp--;

             current =iv_ruleRefSAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefSAPoint5946); 

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
    // $ANTLR end entryRuleRefSAPoint


    // $ANTLR start ruleRefSAPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3637:1: ruleRefSAPoint returns [EObject current=null] : ( 'ref' ( ( RULE_ID ) ) ) ;
    public final EObject ruleRefSAPoint() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3642:6: ( ( 'ref' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3643:1: ( 'ref' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3643:1: ( 'ref' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3643:3: 'ref' ( ( RULE_ID ) )
            {
            match(input,60,FOLLOW_60_in_ruleRefSAPoint5981); 

                    createLeafNode(grammarAccess.getRefSAPointAccess().getRefKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3647:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3648:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3648:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3649:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRefSAPointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefSAPoint5999); 

            		createLeafNode(grammarAccess.getRefSAPointAccess().getRefActorContainerRefCrossReference_1_0(), "ref"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRefSAPoint


    // $ANTLR start entryRuleRelaySAPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3669:1: entryRuleRelaySAPoint returns [EObject current=null] : iv_ruleRelaySAPoint= ruleRelaySAPoint EOF ;
    public final EObject entryRuleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelaySAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3670:2: (iv_ruleRelaySAPoint= ruleRelaySAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3671:2: iv_ruleRelaySAPoint= ruleRelaySAPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelaySAPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelaySAPoint_in_entryRuleRelaySAPoint6035);
            iv_ruleRelaySAPoint=ruleRelaySAPoint();
            _fsp--;

             current =iv_ruleRelaySAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelaySAPoint6045); 

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
    // $ANTLR end entryRuleRelaySAPoint


    // $ANTLR start ruleRelaySAPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3678:1: ruleRelaySAPoint returns [EObject current=null] : ( 'relay_sap' ( ( RULE_ID ) ) ) ;
    public final EObject ruleRelaySAPoint() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3683:6: ( ( 'relay_sap' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3684:1: ( 'relay_sap' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3684:1: ( 'relay_sap' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3684:3: 'relay_sap' ( ( RULE_ID ) )
            {
            match(input,61,FOLLOW_61_in_ruleRelaySAPoint6080); 

                    createLeafNode(grammarAccess.getRelaySAPointAccess().getRelay_sapKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3688:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3689:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3689:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3690:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRelaySAPointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRelaySAPoint6098); 

            		createLeafNode(grammarAccess.getRelaySAPointAccess().getRelaySPPRefCrossReference_1_0(), "relay"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRelaySAPoint


    // $ANTLR start entryRuleSPPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3710:1: entryRuleSPPoint returns [EObject current=null] : iv_ruleSPPoint= ruleSPPoint EOF ;
    public final EObject entryRuleSPPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3711:2: (iv_ruleSPPoint= ruleSPPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3712:2: iv_ruleSPPoint= ruleSPPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSPPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleSPPoint_in_entryRuleSPPoint6134);
            iv_ruleSPPoint=ruleSPPoint();
            _fsp--;

             current =iv_ruleSPPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSPPoint6144); 

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
    // $ANTLR end entryRuleSPPoint


    // $ANTLR start ruleSPPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3719:1: ruleSPPoint returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ) ;
    public final EObject ruleSPPoint() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3724:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3725:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3725:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3725:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3725:2: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3726:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3726:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3727:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSPPointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPoint6187); 

            		createLeafNode(grammarAccess.getSPPointAccess().getRefActorContainerRefCrossReference_0_0(), "ref"); 
            	

            }


            }

            match(input,55,FOLLOW_55_in_ruleSPPoint6197); 

                    createLeafNode(grammarAccess.getSPPointAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3743:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3744:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3744:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3745:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSPPointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPoint6215); 

            		createLeafNode(grammarAccess.getSPPointAccess().getServiceSPPRefCrossReference_2_0(), "service"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSPPoint


    // $ANTLR start entryRuleActorRef
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3765:1: entryRuleActorRef returns [EObject current=null] : iv_ruleActorRef= ruleActorRef EOF ;
    public final EObject entryRuleActorRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3766:2: (iv_ruleActorRef= ruleActorRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3767:2: iv_ruleActorRef= ruleActorRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActorRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleActorRef_in_entryRuleActorRef6251);
            iv_ruleActorRef=ruleActorRef();
            _fsp--;

             current =iv_ruleActorRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorRef6261); 

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
    // $ANTLR end entryRuleActorRef


    // $ANTLR start ruleActorRef
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3774:1: ruleActorRef returns [EObject current=null] : ( 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleActorRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3779:6: ( ( 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3780:1: ( 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3780:1: ( 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3780:3: 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) )
            {
            match(input,62,FOLLOW_62_in_ruleActorRef6296); 

                    createLeafNode(grammarAccess.getActorRefAccess().getActorRefKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3784:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3785:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3785:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3786:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorRef6313); 

            			createLeafNode(grammarAccess.getActorRefAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getActorRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,14,FOLLOW_14_in_ruleActorRef6328); 

                    createLeafNode(grammarAccess.getActorRefAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3812:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3813:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3813:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3814:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getActorRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getActorRefAccess().getTypeActorClassCrossReference_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleActorRef6351);
            ruleFQN();
            _fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleActorRef


    // $ANTLR start entryRuleStateGraphNode
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3836:1: entryRuleStateGraphNode returns [EObject current=null] : iv_ruleStateGraphNode= ruleStateGraphNode EOF ;
    public final EObject entryRuleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraphNode = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3837:2: (iv_ruleStateGraphNode= ruleStateGraphNode EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3838:2: iv_ruleStateGraphNode= ruleStateGraphNode EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateGraphNodeRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateGraphNode_in_entryRuleStateGraphNode6387);
            iv_ruleStateGraphNode=ruleStateGraphNode();
            _fsp--;

             current =iv_ruleStateGraphNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateGraphNode6397); 

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
    // $ANTLR end entryRuleStateGraphNode


    // $ANTLR start ruleStateGraphNode
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3845:1: ruleStateGraphNode returns [EObject current=null] : (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) ;
    public final EObject ruleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_ChoicePoint_1 = null;

        EObject this_TrPoint_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3850:6: ( (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3851:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3851:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            int alt64=3;
            switch ( input.LA(1) ) {
            case 64:
            case 68:
                {
                alt64=1;
                }
                break;
            case 73:
                {
                alt64=2;
                }
                break;
            case 69:
            case 70:
            case 71:
            case 72:
                {
                alt64=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3851:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3852:5: this_State_0= ruleState
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateGraphNodeAccess().getStateParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleState_in_ruleStateGraphNode6444);
                    this_State_0=ruleState();
                    _fsp--;

                     
                            current = this_State_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3862:5: this_ChoicePoint_1= ruleChoicePoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateGraphNodeAccess().getChoicePointParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateGraphNode6471);
                    this_ChoicePoint_1=ruleChoicePoint();
                    _fsp--;

                     
                            current = this_ChoicePoint_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3872:5: this_TrPoint_2= ruleTrPoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateGraphNodeAccess().getTrPointParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateGraphNode6498);
                    this_TrPoint_2=ruleTrPoint();
                    _fsp--;

                     
                            current = this_TrPoint_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStateGraphNode


    // $ANTLR start entryRuleState
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3890:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3891:2: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3892:2: iv_ruleState= ruleState EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateRule(), currentNode); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState6535);
            iv_ruleState=ruleState();
            _fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState6545); 

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
    // $ANTLR end entryRuleState


    // $ANTLR start ruleState
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3899:1: ruleState returns [EObject current=null] : (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_BaseState_0 = null;

        EObject this_RefinedState_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3904:6: ( (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3905:1: (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3905:1: (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==64) ) {
                alt65=1;
            }
            else if ( (LA65_0==68) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3905:1: (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState )", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3906:5: this_BaseState_0= ruleBaseState
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateAccess().getBaseStateParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBaseState_in_ruleState6592);
                    this_BaseState_0=ruleBaseState();
                    _fsp--;

                     
                            current = this_BaseState_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3916:5: this_RefinedState_1= ruleRefinedState
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateAccess().getRefinedStateParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRefinedState_in_ruleState6619);
                    this_RefinedState_1=ruleRefinedState();
                    _fsp--;

                     
                            current = this_RefinedState_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleState


    // $ANTLR start entryRuleStateGraph
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3932:1: entryRuleStateGraph returns [EObject current=null] : iv_ruleStateGraph= ruleStateGraph EOF ;
    public final EObject entryRuleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraph = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3933:2: (iv_ruleStateGraph= ruleStateGraph EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3934:2: iv_ruleStateGraph= ruleStateGraph EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateGraphRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateGraph_in_entryRuleStateGraph6654);
            iv_ruleStateGraph=ruleStateGraph();
            _fsp--;

             current =iv_ruleStateGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateGraph6664); 

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
    // $ANTLR end entryRuleStateGraph


    // $ANTLR start ruleStateGraph
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3941:1: ruleStateGraph returns [EObject current=null] : ( '{' ( ( (lv_states_1_0= ruleState ) ) | ( (lv_trPoints_2_0= ruleTrPoint ) ) | ( (lv_chPoints_3_0= ruleChoicePoint ) ) | ( (lv_transitions_4_0= ruleTransition ) ) )+ '}' ) ;
    public final EObject ruleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject lv_states_1_0 = null;

        EObject lv_trPoints_2_0 = null;

        EObject lv_chPoints_3_0 = null;

        EObject lv_transitions_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3946:6: ( ( '{' ( ( (lv_states_1_0= ruleState ) ) | ( (lv_trPoints_2_0= ruleTrPoint ) ) | ( (lv_chPoints_3_0= ruleChoicePoint ) ) | ( (lv_transitions_4_0= ruleTransition ) ) )+ '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3947:1: ( '{' ( ( (lv_states_1_0= ruleState ) ) | ( (lv_trPoints_2_0= ruleTrPoint ) ) | ( (lv_chPoints_3_0= ruleChoicePoint ) ) | ( (lv_transitions_4_0= ruleTransition ) ) )+ '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3947:1: ( '{' ( ( (lv_states_1_0= ruleState ) ) | ( (lv_trPoints_2_0= ruleTrPoint ) ) | ( (lv_chPoints_3_0= ruleChoicePoint ) ) | ( (lv_transitions_4_0= ruleTransition ) ) )+ '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3947:3: '{' ( ( (lv_states_1_0= ruleState ) ) | ( (lv_trPoints_2_0= ruleTrPoint ) ) | ( (lv_chPoints_3_0= ruleChoicePoint ) ) | ( (lv_transitions_4_0= ruleTransition ) ) )+ '}'
            {
            match(input,12,FOLLOW_12_in_ruleStateGraph6699); 

                    createLeafNode(grammarAccess.getStateGraphAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3951:1: ( ( (lv_states_1_0= ruleState ) ) | ( (lv_trPoints_2_0= ruleTrPoint ) ) | ( (lv_chPoints_3_0= ruleChoicePoint ) ) | ( (lv_transitions_4_0= ruleTransition ) ) )+
            int cnt66=0;
            loop66:
            do {
                int alt66=5;
                switch ( input.LA(1) ) {
                case 64:
                case 68:
                    {
                    alt66=1;
                    }
                    break;
                case 69:
                case 70:
                case 71:
                case 72:
                    {
                    alt66=2;
                    }
                    break;
                case 73:
                    {
                    alt66=3;
                    }
                    break;
                case 74:
                    {
                    alt66=4;
                    }
                    break;

                }

                switch (alt66) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3951:2: ( (lv_states_1_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3951:2: ( (lv_states_1_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3952:1: (lv_states_1_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3952:1: (lv_states_1_0= ruleState )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3953:3: lv_states_1_0= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateGraphAccess().getStatesStateParserRuleCall_1_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateGraph6721);
            	    lv_states_1_0=ruleState();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateGraphRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"states",
            	    	        		lv_states_1_0, 
            	    	        		"State", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3976:6: ( (lv_trPoints_2_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3976:6: ( (lv_trPoints_2_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3977:1: (lv_trPoints_2_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3977:1: (lv_trPoints_2_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3978:3: lv_trPoints_2_0= ruleTrPoint
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateGraphAccess().getTrPointsTrPointParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateGraph6748);
            	    lv_trPoints_2_0=ruleTrPoint();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateGraphRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"trPoints",
            	    	        		lv_trPoints_2_0, 
            	    	        		"TrPoint", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4001:6: ( (lv_chPoints_3_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4001:6: ( (lv_chPoints_3_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4002:1: (lv_chPoints_3_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4002:1: (lv_chPoints_3_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4003:3: lv_chPoints_3_0= ruleChoicePoint
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateGraphAccess().getChPointsChoicePointParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateGraph6775);
            	    lv_chPoints_3_0=ruleChoicePoint();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateGraphRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"chPoints",
            	    	        		lv_chPoints_3_0, 
            	    	        		"ChoicePoint", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4026:6: ( (lv_transitions_4_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4026:6: ( (lv_transitions_4_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4027:1: (lv_transitions_4_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4027:1: (lv_transitions_4_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4028:3: lv_transitions_4_0= ruleTransition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateGraphAccess().getTransitionsTransitionParserRuleCall_1_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleStateGraph6802);
            	    lv_transitions_4_0=ruleTransition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateGraphRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"transitions",
            	    	        		lv_transitions_4_0, 
            	    	        		"Transition", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt66 >= 1 ) break loop66;
                        EarlyExitException eee =
                            new EarlyExitException(66, input);
                        throw eee;
                }
                cnt66++;
            } while (true);

            match(input,13,FOLLOW_13_in_ruleStateGraph6814); 

                    createLeafNode(grammarAccess.getStateGraphAccess().getRightCurlyBracketKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStateGraph


    // $ANTLR start entryRuleStateMachine
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4062:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4063:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4064:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateMachineRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateMachine_in_entryRuleStateMachine6850);
            iv_ruleStateMachine=ruleStateMachine();
            _fsp--;

             current =iv_ruleStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateMachine6860); 

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
    // $ANTLR end entryRuleStateMachine


    // $ANTLR start ruleStateMachine
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4071:1: ruleStateMachine returns [EObject current=null] : ( 'StateMachine' '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )+ '}' ) ;
    public final EObject ruleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject lv_states_2_0 = null;

        EObject lv_trPoints_3_0 = null;

        EObject lv_chPoints_4_0 = null;

        EObject lv_transitions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4076:6: ( ( 'StateMachine' '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )+ '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4077:1: ( 'StateMachine' '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )+ '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4077:1: ( 'StateMachine' '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )+ '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4077:3: 'StateMachine' '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )+ '}'
            {
            match(input,63,FOLLOW_63_in_ruleStateMachine6895); 

                    createLeafNode(grammarAccess.getStateMachineAccess().getStateMachineKeyword_0(), null); 
                
            match(input,12,FOLLOW_12_in_ruleStateMachine6905); 

                    createLeafNode(grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4085:1: ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )+
            int cnt67=0;
            loop67:
            do {
                int alt67=5;
                switch ( input.LA(1) ) {
                case 64:
                case 68:
                    {
                    alt67=1;
                    }
                    break;
                case 69:
                case 70:
                case 71:
                case 72:
                    {
                    alt67=2;
                    }
                    break;
                case 73:
                    {
                    alt67=3;
                    }
                    break;
                case 74:
                    {
                    alt67=4;
                    }
                    break;

                }

                switch (alt67) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4085:2: ( (lv_states_2_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4085:2: ( (lv_states_2_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4086:1: (lv_states_2_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4086:1: (lv_states_2_0= ruleState )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4087:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_2_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateMachine6927);
            	    lv_states_2_0=ruleState();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateMachineRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"states",
            	    	        		lv_states_2_0, 
            	    	        		"State", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4110:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4110:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4111:1: (lv_trPoints_3_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4111:1: (lv_trPoints_3_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4112:3: lv_trPoints_3_0= ruleTrPoint
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getTrPointsTrPointParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateMachine6954);
            	    lv_trPoints_3_0=ruleTrPoint();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateMachineRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"trPoints",
            	    	        		lv_trPoints_3_0, 
            	    	        		"TrPoint", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4135:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4135:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4136:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4136:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4137:3: lv_chPoints_4_0= ruleChoicePoint
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getChPointsChoicePointParserRuleCall_2_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateMachine6981);
            	    lv_chPoints_4_0=ruleChoicePoint();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateMachineRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"chPoints",
            	    	        		lv_chPoints_4_0, 
            	    	        		"ChoicePoint", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4160:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4160:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4161:1: (lv_transitions_5_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4161:1: (lv_transitions_5_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4162:3: lv_transitions_5_0= ruleTransition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_2_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleStateMachine7008);
            	    lv_transitions_5_0=ruleTransition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateMachineRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"transitions",
            	    	        		lv_transitions_5_0, 
            	    	        		"Transition", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt67 >= 1 ) break loop67;
                        EarlyExitException eee =
                            new EarlyExitException(67, input);
                        throw eee;
                }
                cnt67++;
            } while (true);

            match(input,13,FOLLOW_13_in_ruleStateMachine7020); 

                    createLeafNode(grammarAccess.getStateMachineAccess().getRightCurlyBracketKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStateMachine


    // $ANTLR start entryRuleBaseState
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4196:1: entryRuleBaseState returns [EObject current=null] : iv_ruleBaseState= ruleBaseState EOF ;
    public final EObject entryRuleBaseState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4197:2: (iv_ruleBaseState= ruleBaseState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4198:2: iv_ruleBaseState= ruleBaseState EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBaseStateRule(), currentNode); 
            pushFollow(FOLLOW_ruleBaseState_in_entryRuleBaseState7056);
            iv_ruleBaseState=ruleBaseState();
            _fsp--;

             current =iv_ruleBaseState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBaseState7066); 

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
    // $ANTLR end entryRuleBaseState


    // $ANTLR start ruleBaseState
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4205:1: ruleBaseState returns [EObject current=null] : ( 'State' ( (lv_name_1_0= RULE_ID ) ) '{' ( 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) ) )? '}' ) ;
    public final EObject ruleBaseState() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_entryCode_4_0 = null;

        EObject lv_exitCode_6_0 = null;

        EObject lv_subgraph_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4210:6: ( ( 'State' ( (lv_name_1_0= RULE_ID ) ) '{' ( 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) ) )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4211:1: ( 'State' ( (lv_name_1_0= RULE_ID ) ) '{' ( 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) ) )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4211:1: ( 'State' ( (lv_name_1_0= RULE_ID ) ) '{' ( 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) ) )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4211:3: 'State' ( (lv_name_1_0= RULE_ID ) ) '{' ( 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) ) )? '}'
            {
            match(input,64,FOLLOW_64_in_ruleBaseState7101); 

                    createLeafNode(grammarAccess.getBaseStateAccess().getStateKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4215:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4216:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4216:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4217:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBaseState7118); 

            			createLeafNode(grammarAccess.getBaseStateAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBaseStateRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleBaseState7133); 

                    createLeafNode(grammarAccess.getBaseStateAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4243:1: ( 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==65) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4243:3: 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) )
                    {
                    match(input,65,FOLLOW_65_in_ruleBaseState7144); 

                            createLeafNode(grammarAccess.getBaseStateAccess().getEntryKeyword_3_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4247:1: ( (lv_entryCode_4_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4248:1: (lv_entryCode_4_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4248:1: (lv_entryCode_4_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4249:3: lv_entryCode_4_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBaseStateAccess().getEntryCodeDetailCodeParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleBaseState7165);
                    lv_entryCode_4_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBaseStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"entryCode",
                    	        		lv_entryCode_4_0, 
                    	        		"DetailCode", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4271:4: ( 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==66) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4271:6: 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) )
                    {
                    match(input,66,FOLLOW_66_in_ruleBaseState7178); 

                            createLeafNode(grammarAccess.getBaseStateAccess().getExitKeyword_4_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4275:1: ( (lv_exitCode_6_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4276:1: (lv_exitCode_6_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4276:1: (lv_exitCode_6_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4277:3: lv_exitCode_6_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBaseStateAccess().getExitCodeDetailCodeParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleBaseState7199);
                    lv_exitCode_6_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBaseStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exitCode",
                    	        		lv_exitCode_6_0, 
                    	        		"DetailCode", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4299:4: ( 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==67) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4299:6: 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) )
                    {
                    match(input,67,FOLLOW_67_in_ruleBaseState7212); 

                            createLeafNode(grammarAccess.getBaseStateAccess().getSubgraphKeyword_5_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4303:1: ( (lv_subgraph_8_0= ruleStateGraph ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4304:1: (lv_subgraph_8_0= ruleStateGraph )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4304:1: (lv_subgraph_8_0= ruleStateGraph )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4305:3: lv_subgraph_8_0= ruleStateGraph
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBaseStateAccess().getSubgraphStateGraphParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleStateGraph_in_ruleBaseState7233);
                    lv_subgraph_8_0=ruleStateGraph();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBaseStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"subgraph",
                    	        		lv_subgraph_8_0, 
                    	        		"StateGraph", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleBaseState7245); 

                    createLeafNode(grammarAccess.getBaseStateAccess().getRightCurlyBracketKeyword_6(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBaseState


    // $ANTLR start entryRuleRefinedState
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4339:1: entryRuleRefinedState returns [EObject current=null] : iv_ruleRefinedState= ruleRefinedState EOF ;
    public final EObject entryRuleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4340:2: (iv_ruleRefinedState= ruleRefinedState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4341:2: iv_ruleRefinedState= ruleRefinedState EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRefinedStateRule(), currentNode); 
            pushFollow(FOLLOW_ruleRefinedState_in_entryRuleRefinedState7281);
            iv_ruleRefinedState=ruleRefinedState();
            _fsp--;

             current =iv_ruleRefinedState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefinedState7291); 

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
    // $ANTLR end entryRuleRefinedState


    // $ANTLR start ruleRefinedState
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4348:1: ruleRefinedState returns [EObject current=null] : ( 'RefinedState' ( ( ruleFQN ) ) '{' ( 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) ) )? '}' ) ;
    public final EObject ruleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject lv_entryCode_4_0 = null;

        EObject lv_exitCode_6_0 = null;

        EObject lv_subgraph_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4353:6: ( ( 'RefinedState' ( ( ruleFQN ) ) '{' ( 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) ) )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4354:1: ( 'RefinedState' ( ( ruleFQN ) ) '{' ( 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) ) )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4354:1: ( 'RefinedState' ( ( ruleFQN ) ) '{' ( 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) ) )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4354:3: 'RefinedState' ( ( ruleFQN ) ) '{' ( 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) ) )? '}'
            {
            match(input,68,FOLLOW_68_in_ruleRefinedState7326); 

                    createLeafNode(grammarAccess.getRefinedStateAccess().getRefinedStateKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4358:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4359:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4359:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4360:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRefinedStateRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getRefinedStateAccess().getBaseBaseStateCrossReference_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRefinedState7349);
            ruleFQN();
            _fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleRefinedState7359); 

                    createLeafNode(grammarAccess.getRefinedStateAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4378:1: ( 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==65) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4378:3: 'entry' ( (lv_entryCode_4_0= ruleDetailCode ) )
                    {
                    match(input,65,FOLLOW_65_in_ruleRefinedState7370); 

                            createLeafNode(grammarAccess.getRefinedStateAccess().getEntryKeyword_3_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4382:1: ( (lv_entryCode_4_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4383:1: (lv_entryCode_4_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4383:1: (lv_entryCode_4_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4384:3: lv_entryCode_4_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRefinedStateAccess().getEntryCodeDetailCodeParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState7391);
                    lv_entryCode_4_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRefinedStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"entryCode",
                    	        		lv_entryCode_4_0, 
                    	        		"DetailCode", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4406:4: ( 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==66) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4406:6: 'exit' ( (lv_exitCode_6_0= ruleDetailCode ) )
                    {
                    match(input,66,FOLLOW_66_in_ruleRefinedState7404); 

                            createLeafNode(grammarAccess.getRefinedStateAccess().getExitKeyword_4_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4410:1: ( (lv_exitCode_6_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4411:1: (lv_exitCode_6_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4411:1: (lv_exitCode_6_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4412:3: lv_exitCode_6_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRefinedStateAccess().getExitCodeDetailCodeParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState7425);
                    lv_exitCode_6_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRefinedStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exitCode",
                    	        		lv_exitCode_6_0, 
                    	        		"DetailCode", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4434:4: ( 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==67) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4434:6: 'subgraph' ( (lv_subgraph_8_0= ruleStateGraph ) )
                    {
                    match(input,67,FOLLOW_67_in_ruleRefinedState7438); 

                            createLeafNode(grammarAccess.getRefinedStateAccess().getSubgraphKeyword_5_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4438:1: ( (lv_subgraph_8_0= ruleStateGraph ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4439:1: (lv_subgraph_8_0= ruleStateGraph )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4439:1: (lv_subgraph_8_0= ruleStateGraph )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4440:3: lv_subgraph_8_0= ruleStateGraph
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRefinedStateAccess().getSubgraphStateGraphParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleStateGraph_in_ruleRefinedState7459);
                    lv_subgraph_8_0=ruleStateGraph();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRefinedStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"subgraph",
                    	        		lv_subgraph_8_0, 
                    	        		"StateGraph", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleRefinedState7471); 

                    createLeafNode(grammarAccess.getRefinedStateAccess().getRightCurlyBracketKeyword_6(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRefinedState


    // $ANTLR start entryRuleDetailCode
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4474:1: entryRuleDetailCode returns [EObject current=null] : iv_ruleDetailCode= ruleDetailCode EOF ;
    public final EObject entryRuleDetailCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailCode = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4475:2: (iv_ruleDetailCode= ruleDetailCode EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4476:2: iv_ruleDetailCode= ruleDetailCode EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDetailCodeRule(), currentNode); 
            pushFollow(FOLLOW_ruleDetailCode_in_entryRuleDetailCode7507);
            iv_ruleDetailCode=ruleDetailCode();
            _fsp--;

             current =iv_ruleDetailCode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDetailCode7517); 

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
    // $ANTLR end entryRuleDetailCode


    // $ANTLR start ruleDetailCode
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4483:1: ruleDetailCode returns [EObject current=null] : ( '{' ( (lv_commands_1_0= RULE_STRING ) )+ '}' ) ;
    public final EObject ruleDetailCode() throws RecognitionException {
        EObject current = null;

        Token lv_commands_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4488:6: ( ( '{' ( (lv_commands_1_0= RULE_STRING ) )+ '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4489:1: ( '{' ( (lv_commands_1_0= RULE_STRING ) )+ '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4489:1: ( '{' ( (lv_commands_1_0= RULE_STRING ) )+ '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4489:3: '{' ( (lv_commands_1_0= RULE_STRING ) )+ '}'
            {
            match(input,12,FOLLOW_12_in_ruleDetailCode7552); 

                    createLeafNode(grammarAccess.getDetailCodeAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4493:1: ( (lv_commands_1_0= RULE_STRING ) )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==RULE_STRING) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4494:1: (lv_commands_1_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4494:1: (lv_commands_1_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4495:3: lv_commands_1_0= RULE_STRING
            	    {
            	    lv_commands_1_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDetailCode7569); 

            	    			createLeafNode(grammarAccess.getDetailCodeAccess().getCommandsSTRINGTerminalRuleCall_1_0(), "commands"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getDetailCodeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"commands",
            	    	        		lv_commands_1_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt74 >= 1 ) break loop74;
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
            } while (true);

            match(input,13,FOLLOW_13_in_ruleDetailCode7585); 

                    createLeafNode(grammarAccess.getDetailCodeAccess().getRightCurlyBracketKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDetailCode


    // $ANTLR start entryRuleTrPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4529:1: entryRuleTrPoint returns [EObject current=null] : iv_ruleTrPoint= ruleTrPoint EOF ;
    public final EObject entryRuleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4530:2: (iv_ruleTrPoint= ruleTrPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4531:2: iv_ruleTrPoint= ruleTrPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTrPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleTrPoint_in_entryRuleTrPoint7621);
            iv_ruleTrPoint=ruleTrPoint();
            _fsp--;

             current =iv_ruleTrPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPoint7631); 

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
    // $ANTLR end entryRuleTrPoint


    // $ANTLR start ruleTrPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4538:1: ruleTrPoint returns [EObject current=null] : (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) ;
    public final EObject ruleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionPoint_0 = null;

        EObject this_EntryPoint_1 = null;

        EObject this_ExitPoint_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4543:6: ( (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4544:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4544:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            int alt75=3;
            switch ( input.LA(1) ) {
            case 69:
            case 70:
                {
                alt75=1;
                }
                break;
            case 71:
                {
                alt75=2;
                }
                break;
            case 72:
                {
                alt75=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4544:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )", 75, 0, input);

                throw nvae;
            }

            switch (alt75) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4545:5: this_TransitionPoint_0= ruleTransitionPoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTrPointAccess().getTransitionPointParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTransitionPoint_in_ruleTrPoint7678);
                    this_TransitionPoint_0=ruleTransitionPoint();
                    _fsp--;

                     
                            current = this_TransitionPoint_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4555:5: this_EntryPoint_1= ruleEntryPoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTrPointAccess().getEntryPointParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntryPoint_in_ruleTrPoint7705);
                    this_EntryPoint_1=ruleEntryPoint();
                    _fsp--;

                     
                            current = this_EntryPoint_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4565:5: this_ExitPoint_2= ruleExitPoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTrPointAccess().getExitPointParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExitPoint_in_ruleTrPoint7732);
                    this_ExitPoint_2=ruleExitPoint();
                    _fsp--;

                     
                            current = this_ExitPoint_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTrPoint


    // $ANTLR start entryRuleTransitionPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4581:1: entryRuleTransitionPoint returns [EObject current=null] : iv_ruleTransitionPoint= ruleTransitionPoint EOF ;
    public final EObject entryRuleTransitionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4582:2: (iv_ruleTransitionPoint= ruleTransitionPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4583:2: iv_ruleTransitionPoint= ruleTransitionPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransitionPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint7767);
            iv_ruleTransitionPoint=ruleTransitionPoint();
            _fsp--;

             current =iv_ruleTransitionPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionPoint7777); 

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
    // $ANTLR end entryRuleTransitionPoint


    // $ANTLR start ruleTransitionPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4590:1: ruleTransitionPoint returns [EObject current=null] : ( ( (lv_handler_0_0= 'handler' ) )? 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTransitionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_handler_0_0=null;
        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4595:6: ( ( ( (lv_handler_0_0= 'handler' ) )? 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4596:1: ( ( (lv_handler_0_0= 'handler' ) )? 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4596:1: ( ( (lv_handler_0_0= 'handler' ) )? 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4596:2: ( (lv_handler_0_0= 'handler' ) )? 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4596:2: ( (lv_handler_0_0= 'handler' ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==69) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4597:1: (lv_handler_0_0= 'handler' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4597:1: (lv_handler_0_0= 'handler' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4598:3: lv_handler_0_0= 'handler'
                    {
                    lv_handler_0_0=(Token)input.LT(1);
                    match(input,69,FOLLOW_69_in_ruleTransitionPoint7820); 

                            createLeafNode(grammarAccess.getTransitionPointAccess().getHandlerHandlerKeyword_0_0(), "handler"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransitionPointRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "handler", true, "handler", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,70,FOLLOW_70_in_ruleTransitionPoint7844); 

                    createLeafNode(grammarAccess.getTransitionPointAccess().getTransitionPointKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4621:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4622:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4622:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4623:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransitionPoint7861); 

            			createLeafNode(grammarAccess.getTransitionPointAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTransitionPointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTransitionPoint


    // $ANTLR start entryRuleEntryPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4653:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4654:2: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4655:2: iv_ruleEntryPoint= ruleEntryPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntryPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint7902);
            iv_ruleEntryPoint=ruleEntryPoint();
            _fsp--;

             current =iv_ruleEntryPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryPoint7912); 

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
    // $ANTLR end entryRuleEntryPoint


    // $ANTLR start ruleEntryPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4662:1: ruleEntryPoint returns [EObject current=null] : ( 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4667:6: ( ( 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4668:1: ( 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4668:1: ( 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4668:3: 'EntryPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,71,FOLLOW_71_in_ruleEntryPoint7947); 

                    createLeafNode(grammarAccess.getEntryPointAccess().getEntryPointKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4672:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4673:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4673:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4674:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntryPoint7964); 

            			createLeafNode(grammarAccess.getEntryPointAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntryPointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEntryPoint


    // $ANTLR start entryRuleExitPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4704:1: entryRuleExitPoint returns [EObject current=null] : iv_ruleExitPoint= ruleExitPoint EOF ;
    public final EObject entryRuleExitPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4705:2: (iv_ruleExitPoint= ruleExitPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4706:2: iv_ruleExitPoint= ruleExitPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExitPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleExitPoint_in_entryRuleExitPoint8005);
            iv_ruleExitPoint=ruleExitPoint();
            _fsp--;

             current =iv_ruleExitPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitPoint8015); 

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
    // $ANTLR end entryRuleExitPoint


    // $ANTLR start ruleExitPoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4713:1: ruleExitPoint returns [EObject current=null] : ( 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitPoint() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4718:6: ( ( 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4719:1: ( 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4719:1: ( 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4719:3: 'ExitPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,72,FOLLOW_72_in_ruleExitPoint8050); 

                    createLeafNode(grammarAccess.getExitPointAccess().getExitPointKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4723:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4724:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4724:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4725:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitPoint8067); 

            			createLeafNode(grammarAccess.getExitPointAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExitPointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleExitPoint


    // $ANTLR start entryRuleChoicePoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4755:1: entryRuleChoicePoint returns [EObject current=null] : iv_ruleChoicePoint= ruleChoicePoint EOF ;
    public final EObject entryRuleChoicePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicePoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4756:2: (iv_ruleChoicePoint= ruleChoicePoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4757:2: iv_ruleChoicePoint= ruleChoicePoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChoicePointRule(), currentNode); 
            pushFollow(FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint8108);
            iv_ruleChoicePoint=ruleChoicePoint();
            _fsp--;

             current =iv_ruleChoicePoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicePoint8118); 

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
    // $ANTLR end entryRuleChoicePoint


    // $ANTLR start ruleChoicePoint
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4764:1: ruleChoicePoint returns [EObject current=null] : ( 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleChoicePoint() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4769:6: ( ( 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4770:1: ( 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4770:1: ( 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4770:3: 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,73,FOLLOW_73_in_ruleChoicePoint8153); 

                    createLeafNode(grammarAccess.getChoicePointAccess().getChoicePointKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4774:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4775:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4775:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4776:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicePoint8170); 

            			createLeafNode(grammarAccess.getChoicePointAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getChoicePointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleChoicePoint


    // $ANTLR start entryRuleTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4806:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4807:2: (iv_ruleTransition= ruleTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4808:2: iv_ruleTransition= ruleTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition8211);
            iv_ruleTransition=ruleTransition();
            _fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition8221); 

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
    // $ANTLR end entryRuleTransition


    // $ANTLR start ruleTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4815:1: ruleTransition returns [EObject current=null] : (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_InitialTransition_0 = null;

        EObject this_NonInitialTransition_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4820:6: ( (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4821:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4821:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==74) ) {
                int LA77_1 = input.LA(2);

                if ( (LA77_1==RULE_ID) ) {
                    int LA77_2 = input.LA(3);

                    if ( (LA77_2==14) ) {
                        int LA77_3 = input.LA(4);

                        if ( (LA77_3==75) ) {
                            alt77=1;
                        }
                        else if ( (LA77_3==RULE_ID||(LA77_3>=80 && LA77_3<=81)) ) {
                            alt77=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("4821:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )", 77, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("4821:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )", 77, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA77_1==14) ) {
                    int LA77_3 = input.LA(3);

                    if ( (LA77_3==75) ) {
                        alt77=1;
                    }
                    else if ( (LA77_3==RULE_ID||(LA77_3>=80 && LA77_3<=81)) ) {
                        alt77=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("4821:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )", 77, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("4821:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )", 77, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4821:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4822:5: this_InitialTransition_0= ruleInitialTransition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getInitialTransitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInitialTransition_in_ruleTransition8268);
                    this_InitialTransition_0=ruleInitialTransition();
                    _fsp--;

                     
                            current = this_InitialTransition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4832:5: this_NonInitialTransition_1= ruleNonInitialTransition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getNonInitialTransitionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNonInitialTransition_in_ruleTransition8295);
                    this_NonInitialTransition_1=ruleNonInitialTransition();
                    _fsp--;

                     
                            current = this_NonInitialTransition_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTransition


    // $ANTLR start entryRuleNonInitialTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4848:1: entryRuleNonInitialTransition returns [EObject current=null] : iv_ruleNonInitialTransition= ruleNonInitialTransition EOF ;
    public final EObject entryRuleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4849:2: (iv_ruleNonInitialTransition= ruleNonInitialTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4850:2: iv_ruleNonInitialTransition= ruleNonInitialTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNonInitialTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition8330);
            iv_ruleNonInitialTransition=ruleNonInitialTransition();
            _fsp--;

             current =iv_ruleNonInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonInitialTransition8340); 

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
    // $ANTLR end entryRuleNonInitialTransition


    // $ANTLR start ruleNonInitialTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4857:1: ruleNonInitialTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) ;
    public final EObject ruleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_ContinuationTransition_1 = null;

        EObject this_CPBranchTransition_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4862:6: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            int alt78=3;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==74) ) {
                int LA78_1 = input.LA(2);

                if ( (LA78_1==RULE_ID) ) {
                    int LA78_2 = input.LA(3);

                    if ( (LA78_2==14) ) {
                        switch ( input.LA(4) ) {
                        case RULE_ID:
                            {
                            int LA78_4 = input.LA(5);

                            if ( (LA78_4==50) ) {
                                int LA78_7 = input.LA(6);

                                if ( (LA78_7==RULE_ID) ) {
                                    int LA78_11 = input.LA(7);

                                    if ( (LA78_11==37) ) {
                                        switch ( input.LA(8) ) {
                                        case RULE_ID:
                                            {
                                            int LA78_12 = input.LA(9);

                                            if ( (LA78_12==50) ) {
                                                int LA78_15 = input.LA(10);

                                                if ( (LA78_15==RULE_ID) ) {
                                                    int LA78_19 = input.LA(11);

                                                    if ( (LA78_19==12) ) {
                                                        switch ( input.LA(12) ) {
                                                        case 77:
                                                            {
                                                            alt78=1;
                                                            }
                                                            break;
                                                        case 79:
                                                            {
                                                            alt78=3;
                                                            }
                                                            break;
                                                        case 13:
                                                        case 76:
                                                            {
                                                            alt78=2;
                                                            }
                                                            break;
                                                        default:
                                                            NoViableAltException nvae =
                                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                            throw nvae;
                                                        }

                                                    }
                                                    else {
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 19, input);

                                                        throw nvae;
                                                    }
                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 15, input);

                                                    throw nvae;
                                                }
                                            }
                                            else if ( (LA78_12==12) ) {
                                                switch ( input.LA(10) ) {
                                                case 77:
                                                    {
                                                    alt78=1;
                                                    }
                                                    break;
                                                case 79:
                                                    {
                                                    alt78=3;
                                                    }
                                                    break;
                                                case 13:
                                                case 76:
                                                    {
                                                    alt78=2;
                                                    }
                                                    break;
                                                default:
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                    throw nvae;
                                                }

                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 12, input);

                                                throw nvae;
                                            }
                                            }
                                            break;
                                        case 80:
                                            {
                                            int LA78_13 = input.LA(9);

                                            if ( (LA78_13==RULE_ID) ) {
                                                int LA78_17 = input.LA(10);

                                                if ( (LA78_17==12) ) {
                                                    switch ( input.LA(11) ) {
                                                    case 77:
                                                        {
                                                        alt78=1;
                                                        }
                                                        break;
                                                    case 79:
                                                        {
                                                        alt78=3;
                                                        }
                                                        break;
                                                    case 13:
                                                    case 76:
                                                        {
                                                        alt78=2;
                                                        }
                                                        break;
                                                    default:
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                        throw nvae;
                                                    }

                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 17, input);

                                                    throw nvae;
                                                }
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 13, input);

                                                throw nvae;
                                            }
                                            }
                                            break;
                                        case 81:
                                            {
                                            int LA78_14 = input.LA(9);

                                            if ( (LA78_14==RULE_ID) ) {
                                                int LA78_18 = input.LA(10);

                                                if ( (LA78_18==12) ) {
                                                    switch ( input.LA(11) ) {
                                                    case 77:
                                                        {
                                                        alt78=1;
                                                        }
                                                        break;
                                                    case 79:
                                                        {
                                                        alt78=3;
                                                        }
                                                        break;
                                                    case 13:
                                                    case 76:
                                                        {
                                                        alt78=2;
                                                        }
                                                        break;
                                                    default:
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                        throw nvae;
                                                    }

                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 18, input);

                                                    throw nvae;
                                                }
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 14, input);

                                                throw nvae;
                                            }
                                            }
                                            break;
                                        default:
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 8, input);

                                            throw nvae;
                                        }

                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 11, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 7, input);

                                    throw nvae;
                                }
                            }
                            else if ( (LA78_4==37) ) {
                                switch ( input.LA(6) ) {
                                case RULE_ID:
                                    {
                                    int LA78_12 = input.LA(7);

                                    if ( (LA78_12==50) ) {
                                        int LA78_15 = input.LA(8);

                                        if ( (LA78_15==RULE_ID) ) {
                                            int LA78_19 = input.LA(9);

                                            if ( (LA78_19==12) ) {
                                                switch ( input.LA(10) ) {
                                                case 77:
                                                    {
                                                    alt78=1;
                                                    }
                                                    break;
                                                case 79:
                                                    {
                                                    alt78=3;
                                                    }
                                                    break;
                                                case 13:
                                                case 76:
                                                    {
                                                    alt78=2;
                                                    }
                                                    break;
                                                default:
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                    throw nvae;
                                                }

                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 19, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 15, input);

                                            throw nvae;
                                        }
                                    }
                                    else if ( (LA78_12==12) ) {
                                        switch ( input.LA(8) ) {
                                        case 77:
                                            {
                                            alt78=1;
                                            }
                                            break;
                                        case 79:
                                            {
                                            alt78=3;
                                            }
                                            break;
                                        case 13:
                                        case 76:
                                            {
                                            alt78=2;
                                            }
                                            break;
                                        default:
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                            throw nvae;
                                        }

                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 12, input);

                                        throw nvae;
                                    }
                                    }
                                    break;
                                case 80:
                                    {
                                    int LA78_13 = input.LA(7);

                                    if ( (LA78_13==RULE_ID) ) {
                                        int LA78_17 = input.LA(8);

                                        if ( (LA78_17==12) ) {
                                            switch ( input.LA(9) ) {
                                            case 77:
                                                {
                                                alt78=1;
                                                }
                                                break;
                                            case 79:
                                                {
                                                alt78=3;
                                                }
                                                break;
                                            case 13:
                                            case 76:
                                                {
                                                alt78=2;
                                                }
                                                break;
                                            default:
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                throw nvae;
                                            }

                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 17, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 13, input);

                                        throw nvae;
                                    }
                                    }
                                    break;
                                case 81:
                                    {
                                    int LA78_14 = input.LA(7);

                                    if ( (LA78_14==RULE_ID) ) {
                                        int LA78_18 = input.LA(8);

                                        if ( (LA78_18==12) ) {
                                            switch ( input.LA(9) ) {
                                            case 77:
                                                {
                                                alt78=1;
                                                }
                                                break;
                                            case 79:
                                                {
                                                alt78=3;
                                                }
                                                break;
                                            case 13:
                                            case 76:
                                                {
                                                alt78=2;
                                                }
                                                break;
                                            default:
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                throw nvae;
                                            }

                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 18, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 14, input);

                                        throw nvae;
                                    }
                                    }
                                    break;
                                default:
                                    NoViableAltException nvae =
                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 8, input);

                                    throw nvae;
                                }

                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 80:
                            {
                            int LA78_5 = input.LA(5);

                            if ( (LA78_5==RULE_ID) ) {
                                int LA78_9 = input.LA(6);

                                if ( (LA78_9==37) ) {
                                    switch ( input.LA(7) ) {
                                    case RULE_ID:
                                        {
                                        int LA78_12 = input.LA(8);

                                        if ( (LA78_12==50) ) {
                                            int LA78_15 = input.LA(9);

                                            if ( (LA78_15==RULE_ID) ) {
                                                int LA78_19 = input.LA(10);

                                                if ( (LA78_19==12) ) {
                                                    switch ( input.LA(11) ) {
                                                    case 77:
                                                        {
                                                        alt78=1;
                                                        }
                                                        break;
                                                    case 79:
                                                        {
                                                        alt78=3;
                                                        }
                                                        break;
                                                    case 13:
                                                    case 76:
                                                        {
                                                        alt78=2;
                                                        }
                                                        break;
                                                    default:
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                        throw nvae;
                                                    }

                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 19, input);

                                                    throw nvae;
                                                }
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 15, input);

                                                throw nvae;
                                            }
                                        }
                                        else if ( (LA78_12==12) ) {
                                            switch ( input.LA(9) ) {
                                            case 77:
                                                {
                                                alt78=1;
                                                }
                                                break;
                                            case 79:
                                                {
                                                alt78=3;
                                                }
                                                break;
                                            case 13:
                                            case 76:
                                                {
                                                alt78=2;
                                                }
                                                break;
                                            default:
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                throw nvae;
                                            }

                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 12, input);

                                            throw nvae;
                                        }
                                        }
                                        break;
                                    case 80:
                                        {
                                        int LA78_13 = input.LA(8);

                                        if ( (LA78_13==RULE_ID) ) {
                                            int LA78_17 = input.LA(9);

                                            if ( (LA78_17==12) ) {
                                                switch ( input.LA(10) ) {
                                                case 77:
                                                    {
                                                    alt78=1;
                                                    }
                                                    break;
                                                case 79:
                                                    {
                                                    alt78=3;
                                                    }
                                                    break;
                                                case 13:
                                                case 76:
                                                    {
                                                    alt78=2;
                                                    }
                                                    break;
                                                default:
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                    throw nvae;
                                                }

                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 17, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 13, input);

                                            throw nvae;
                                        }
                                        }
                                        break;
                                    case 81:
                                        {
                                        int LA78_14 = input.LA(8);

                                        if ( (LA78_14==RULE_ID) ) {
                                            int LA78_18 = input.LA(9);

                                            if ( (LA78_18==12) ) {
                                                switch ( input.LA(10) ) {
                                                case 77:
                                                    {
                                                    alt78=1;
                                                    }
                                                    break;
                                                case 79:
                                                    {
                                                    alt78=3;
                                                    }
                                                    break;
                                                case 13:
                                                case 76:
                                                    {
                                                    alt78=2;
                                                    }
                                                    break;
                                                default:
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                    throw nvae;
                                                }

                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 18, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 14, input);

                                            throw nvae;
                                        }
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 8, input);

                                        throw nvae;
                                    }

                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 9, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 81:
                            {
                            int LA78_6 = input.LA(5);

                            if ( (LA78_6==RULE_ID) ) {
                                int LA78_10 = input.LA(6);

                                if ( (LA78_10==37) ) {
                                    switch ( input.LA(7) ) {
                                    case RULE_ID:
                                        {
                                        int LA78_12 = input.LA(8);

                                        if ( (LA78_12==50) ) {
                                            int LA78_15 = input.LA(9);

                                            if ( (LA78_15==RULE_ID) ) {
                                                int LA78_19 = input.LA(10);

                                                if ( (LA78_19==12) ) {
                                                    switch ( input.LA(11) ) {
                                                    case 77:
                                                        {
                                                        alt78=1;
                                                        }
                                                        break;
                                                    case 79:
                                                        {
                                                        alt78=3;
                                                        }
                                                        break;
                                                    case 13:
                                                    case 76:
                                                        {
                                                        alt78=2;
                                                        }
                                                        break;
                                                    default:
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                        throw nvae;
                                                    }

                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 19, input);

                                                    throw nvae;
                                                }
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 15, input);

                                                throw nvae;
                                            }
                                        }
                                        else if ( (LA78_12==12) ) {
                                            switch ( input.LA(9) ) {
                                            case 77:
                                                {
                                                alt78=1;
                                                }
                                                break;
                                            case 79:
                                                {
                                                alt78=3;
                                                }
                                                break;
                                            case 13:
                                            case 76:
                                                {
                                                alt78=2;
                                                }
                                                break;
                                            default:
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                throw nvae;
                                            }

                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 12, input);

                                            throw nvae;
                                        }
                                        }
                                        break;
                                    case 80:
                                        {
                                        int LA78_13 = input.LA(8);

                                        if ( (LA78_13==RULE_ID) ) {
                                            int LA78_17 = input.LA(9);

                                            if ( (LA78_17==12) ) {
                                                switch ( input.LA(10) ) {
                                                case 77:
                                                    {
                                                    alt78=1;
                                                    }
                                                    break;
                                                case 79:
                                                    {
                                                    alt78=3;
                                                    }
                                                    break;
                                                case 13:
                                                case 76:
                                                    {
                                                    alt78=2;
                                                    }
                                                    break;
                                                default:
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                    throw nvae;
                                                }

                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 17, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 13, input);

                                            throw nvae;
                                        }
                                        }
                                        break;
                                    case 81:
                                        {
                                        int LA78_14 = input.LA(8);

                                        if ( (LA78_14==RULE_ID) ) {
                                            int LA78_18 = input.LA(9);

                                            if ( (LA78_18==12) ) {
                                                switch ( input.LA(10) ) {
                                                case 77:
                                                    {
                                                    alt78=1;
                                                    }
                                                    break;
                                                case 79:
                                                    {
                                                    alt78=3;
                                                    }
                                                    break;
                                                case 13:
                                                case 76:
                                                    {
                                                    alt78=2;
                                                    }
                                                    break;
                                                default:
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                    throw nvae;
                                                }

                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 18, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 14, input);

                                            throw nvae;
                                        }
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 8, input);

                                        throw nvae;
                                    }

                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 10, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA78_1==14) ) {
                    switch ( input.LA(3) ) {
                    case RULE_ID:
                        {
                        int LA78_4 = input.LA(4);

                        if ( (LA78_4==50) ) {
                            int LA78_7 = input.LA(5);

                            if ( (LA78_7==RULE_ID) ) {
                                int LA78_11 = input.LA(6);

                                if ( (LA78_11==37) ) {
                                    switch ( input.LA(7) ) {
                                    case RULE_ID:
                                        {
                                        int LA78_12 = input.LA(8);

                                        if ( (LA78_12==50) ) {
                                            int LA78_15 = input.LA(9);

                                            if ( (LA78_15==RULE_ID) ) {
                                                int LA78_19 = input.LA(10);

                                                if ( (LA78_19==12) ) {
                                                    switch ( input.LA(11) ) {
                                                    case 77:
                                                        {
                                                        alt78=1;
                                                        }
                                                        break;
                                                    case 79:
                                                        {
                                                        alt78=3;
                                                        }
                                                        break;
                                                    case 13:
                                                    case 76:
                                                        {
                                                        alt78=2;
                                                        }
                                                        break;
                                                    default:
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                        throw nvae;
                                                    }

                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 19, input);

                                                    throw nvae;
                                                }
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 15, input);

                                                throw nvae;
                                            }
                                        }
                                        else if ( (LA78_12==12) ) {
                                            switch ( input.LA(9) ) {
                                            case 77:
                                                {
                                                alt78=1;
                                                }
                                                break;
                                            case 79:
                                                {
                                                alt78=3;
                                                }
                                                break;
                                            case 13:
                                            case 76:
                                                {
                                                alt78=2;
                                                }
                                                break;
                                            default:
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                throw nvae;
                                            }

                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 12, input);

                                            throw nvae;
                                        }
                                        }
                                        break;
                                    case 80:
                                        {
                                        int LA78_13 = input.LA(8);

                                        if ( (LA78_13==RULE_ID) ) {
                                            int LA78_17 = input.LA(9);

                                            if ( (LA78_17==12) ) {
                                                switch ( input.LA(10) ) {
                                                case 77:
                                                    {
                                                    alt78=1;
                                                    }
                                                    break;
                                                case 79:
                                                    {
                                                    alt78=3;
                                                    }
                                                    break;
                                                case 13:
                                                case 76:
                                                    {
                                                    alt78=2;
                                                    }
                                                    break;
                                                default:
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                    throw nvae;
                                                }

                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 17, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 13, input);

                                            throw nvae;
                                        }
                                        }
                                        break;
                                    case 81:
                                        {
                                        int LA78_14 = input.LA(8);

                                        if ( (LA78_14==RULE_ID) ) {
                                            int LA78_18 = input.LA(9);

                                            if ( (LA78_18==12) ) {
                                                switch ( input.LA(10) ) {
                                                case 77:
                                                    {
                                                    alt78=1;
                                                    }
                                                    break;
                                                case 79:
                                                    {
                                                    alt78=3;
                                                    }
                                                    break;
                                                case 13:
                                                case 76:
                                                    {
                                                    alt78=2;
                                                    }
                                                    break;
                                                default:
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                    throw nvae;
                                                }

                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 18, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 14, input);

                                            throw nvae;
                                        }
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 8, input);

                                        throw nvae;
                                    }

                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 11, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 7, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA78_4==37) ) {
                            switch ( input.LA(5) ) {
                            case RULE_ID:
                                {
                                int LA78_12 = input.LA(6);

                                if ( (LA78_12==50) ) {
                                    int LA78_15 = input.LA(7);

                                    if ( (LA78_15==RULE_ID) ) {
                                        int LA78_19 = input.LA(8);

                                        if ( (LA78_19==12) ) {
                                            switch ( input.LA(9) ) {
                                            case 77:
                                                {
                                                alt78=1;
                                                }
                                                break;
                                            case 79:
                                                {
                                                alt78=3;
                                                }
                                                break;
                                            case 13:
                                            case 76:
                                                {
                                                alt78=2;
                                                }
                                                break;
                                            default:
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                throw nvae;
                                            }

                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 19, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 15, input);

                                        throw nvae;
                                    }
                                }
                                else if ( (LA78_12==12) ) {
                                    switch ( input.LA(7) ) {
                                    case 77:
                                        {
                                        alt78=1;
                                        }
                                        break;
                                    case 79:
                                        {
                                        alt78=3;
                                        }
                                        break;
                                    case 13:
                                    case 76:
                                        {
                                        alt78=2;
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                        throw nvae;
                                    }

                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 12, input);

                                    throw nvae;
                                }
                                }
                                break;
                            case 80:
                                {
                                int LA78_13 = input.LA(6);

                                if ( (LA78_13==RULE_ID) ) {
                                    int LA78_17 = input.LA(7);

                                    if ( (LA78_17==12) ) {
                                        switch ( input.LA(8) ) {
                                        case 77:
                                            {
                                            alt78=1;
                                            }
                                            break;
                                        case 79:
                                            {
                                            alt78=3;
                                            }
                                            break;
                                        case 13:
                                        case 76:
                                            {
                                            alt78=2;
                                            }
                                            break;
                                        default:
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                            throw nvae;
                                        }

                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 17, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 13, input);

                                    throw nvae;
                                }
                                }
                                break;
                            case 81:
                                {
                                int LA78_14 = input.LA(6);

                                if ( (LA78_14==RULE_ID) ) {
                                    int LA78_18 = input.LA(7);

                                    if ( (LA78_18==12) ) {
                                        switch ( input.LA(8) ) {
                                        case 77:
                                            {
                                            alt78=1;
                                            }
                                            break;
                                        case 79:
                                            {
                                            alt78=3;
                                            }
                                            break;
                                        case 13:
                                        case 76:
                                            {
                                            alt78=2;
                                            }
                                            break;
                                        default:
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                            throw nvae;
                                        }

                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 18, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 14, input);

                                    throw nvae;
                                }
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 8, input);

                                throw nvae;
                            }

                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 80:
                        {
                        int LA78_5 = input.LA(4);

                        if ( (LA78_5==RULE_ID) ) {
                            int LA78_9 = input.LA(5);

                            if ( (LA78_9==37) ) {
                                switch ( input.LA(6) ) {
                                case RULE_ID:
                                    {
                                    int LA78_12 = input.LA(7);

                                    if ( (LA78_12==50) ) {
                                        int LA78_15 = input.LA(8);

                                        if ( (LA78_15==RULE_ID) ) {
                                            int LA78_19 = input.LA(9);

                                            if ( (LA78_19==12) ) {
                                                switch ( input.LA(10) ) {
                                                case 77:
                                                    {
                                                    alt78=1;
                                                    }
                                                    break;
                                                case 79:
                                                    {
                                                    alt78=3;
                                                    }
                                                    break;
                                                case 13:
                                                case 76:
                                                    {
                                                    alt78=2;
                                                    }
                                                    break;
                                                default:
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                    throw nvae;
                                                }

                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 19, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 15, input);

                                            throw nvae;
                                        }
                                    }
                                    else if ( (LA78_12==12) ) {
                                        switch ( input.LA(8) ) {
                                        case 77:
                                            {
                                            alt78=1;
                                            }
                                            break;
                                        case 79:
                                            {
                                            alt78=3;
                                            }
                                            break;
                                        case 13:
                                        case 76:
                                            {
                                            alt78=2;
                                            }
                                            break;
                                        default:
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                            throw nvae;
                                        }

                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 12, input);

                                        throw nvae;
                                    }
                                    }
                                    break;
                                case 80:
                                    {
                                    int LA78_13 = input.LA(7);

                                    if ( (LA78_13==RULE_ID) ) {
                                        int LA78_17 = input.LA(8);

                                        if ( (LA78_17==12) ) {
                                            switch ( input.LA(9) ) {
                                            case 77:
                                                {
                                                alt78=1;
                                                }
                                                break;
                                            case 79:
                                                {
                                                alt78=3;
                                                }
                                                break;
                                            case 13:
                                            case 76:
                                                {
                                                alt78=2;
                                                }
                                                break;
                                            default:
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                throw nvae;
                                            }

                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 17, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 13, input);

                                        throw nvae;
                                    }
                                    }
                                    break;
                                case 81:
                                    {
                                    int LA78_14 = input.LA(7);

                                    if ( (LA78_14==RULE_ID) ) {
                                        int LA78_18 = input.LA(8);

                                        if ( (LA78_18==12) ) {
                                            switch ( input.LA(9) ) {
                                            case 77:
                                                {
                                                alt78=1;
                                                }
                                                break;
                                            case 79:
                                                {
                                                alt78=3;
                                                }
                                                break;
                                            case 13:
                                            case 76:
                                                {
                                                alt78=2;
                                                }
                                                break;
                                            default:
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                throw nvae;
                                            }

                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 18, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 14, input);

                                        throw nvae;
                                    }
                                    }
                                    break;
                                default:
                                    NoViableAltException nvae =
                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 8, input);

                                    throw nvae;
                                }

                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 9, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 5, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 81:
                        {
                        int LA78_6 = input.LA(4);

                        if ( (LA78_6==RULE_ID) ) {
                            int LA78_10 = input.LA(5);

                            if ( (LA78_10==37) ) {
                                switch ( input.LA(6) ) {
                                case RULE_ID:
                                    {
                                    int LA78_12 = input.LA(7);

                                    if ( (LA78_12==50) ) {
                                        int LA78_15 = input.LA(8);

                                        if ( (LA78_15==RULE_ID) ) {
                                            int LA78_19 = input.LA(9);

                                            if ( (LA78_19==12) ) {
                                                switch ( input.LA(10) ) {
                                                case 77:
                                                    {
                                                    alt78=1;
                                                    }
                                                    break;
                                                case 79:
                                                    {
                                                    alt78=3;
                                                    }
                                                    break;
                                                case 13:
                                                case 76:
                                                    {
                                                    alt78=2;
                                                    }
                                                    break;
                                                default:
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                    throw nvae;
                                                }

                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 19, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 15, input);

                                            throw nvae;
                                        }
                                    }
                                    else if ( (LA78_12==12) ) {
                                        switch ( input.LA(8) ) {
                                        case 77:
                                            {
                                            alt78=1;
                                            }
                                            break;
                                        case 79:
                                            {
                                            alt78=3;
                                            }
                                            break;
                                        case 13:
                                        case 76:
                                            {
                                            alt78=2;
                                            }
                                            break;
                                        default:
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                            throw nvae;
                                        }

                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 12, input);

                                        throw nvae;
                                    }
                                    }
                                    break;
                                case 80:
                                    {
                                    int LA78_13 = input.LA(7);

                                    if ( (LA78_13==RULE_ID) ) {
                                        int LA78_17 = input.LA(8);

                                        if ( (LA78_17==12) ) {
                                            switch ( input.LA(9) ) {
                                            case 77:
                                                {
                                                alt78=1;
                                                }
                                                break;
                                            case 79:
                                                {
                                                alt78=3;
                                                }
                                                break;
                                            case 13:
                                            case 76:
                                                {
                                                alt78=2;
                                                }
                                                break;
                                            default:
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                throw nvae;
                                            }

                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 17, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 13, input);

                                        throw nvae;
                                    }
                                    }
                                    break;
                                case 81:
                                    {
                                    int LA78_14 = input.LA(7);

                                    if ( (LA78_14==RULE_ID) ) {
                                        int LA78_18 = input.LA(8);

                                        if ( (LA78_18==12) ) {
                                            switch ( input.LA(9) ) {
                                            case 77:
                                                {
                                                alt78=1;
                                                }
                                                break;
                                            case 79:
                                                {
                                                alt78=3;
                                                }
                                                break;
                                            case 13:
                                            case 76:
                                                {
                                                alt78=2;
                                                }
                                                break;
                                            default:
                                                NoViableAltException nvae =
                                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 16, input);

                                                throw nvae;
                                            }

                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 18, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 14, input);

                                        throw nvae;
                                    }
                                    }
                                    break;
                                default:
                                    NoViableAltException nvae =
                                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 8, input);

                                    throw nvae;
                                }

                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 10, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 6, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 3, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4863:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4864:5: this_TriggeredTransition_0= ruleTriggeredTransition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNonInitialTransitionAccess().getTriggeredTransitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTriggeredTransition_in_ruleNonInitialTransition8387);
                    this_TriggeredTransition_0=ruleTriggeredTransition();
                    _fsp--;

                     
                            current = this_TriggeredTransition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4874:5: this_ContinuationTransition_1= ruleContinuationTransition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNonInitialTransitionAccess().getContinuationTransitionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition8414);
                    this_ContinuationTransition_1=ruleContinuationTransition();
                    _fsp--;

                     
                            current = this_ContinuationTransition_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4884:5: this_CPBranchTransition_2= ruleCPBranchTransition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNonInitialTransitionAccess().getCPBranchTransitionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition8441);
                    this_CPBranchTransition_2=ruleCPBranchTransition();
                    _fsp--;

                     
                            current = this_CPBranchTransition_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNonInitialTransition


    // $ANTLR start entryRuleInitialTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4900:1: entryRuleInitialTransition returns [EObject current=null] : iv_ruleInitialTransition= ruleInitialTransition EOF ;
    public final EObject entryRuleInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4901:2: (iv_ruleInitialTransition= ruleInitialTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4902:2: iv_ruleInitialTransition= ruleInitialTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInitialTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition8476);
            iv_ruleInitialTransition=ruleInitialTransition();
            _fsp--;

             current =iv_ruleInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInitialTransition8486); 

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
    // $ANTLR end entryRuleInitialTransition


    // $ANTLR start ruleInitialTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4909:1: ruleInitialTransition returns [EObject current=null] : ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' 'initial' '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' ( 'action' ( (lv_action_8_0= ruleDetailCode ) ) )? '}' ) ;
    public final EObject ruleInitialTransition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_to_5_0 = null;

        EObject lv_action_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4914:6: ( ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' 'initial' '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' ( 'action' ( (lv_action_8_0= ruleDetailCode ) ) )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4915:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' 'initial' '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' ( 'action' ( (lv_action_8_0= ruleDetailCode ) ) )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4915:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' 'initial' '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' ( 'action' ( (lv_action_8_0= ruleDetailCode ) ) )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4915:3: 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' 'initial' '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' ( 'action' ( (lv_action_8_0= ruleDetailCode ) ) )? '}'
            {
            match(input,74,FOLLOW_74_in_ruleInitialTransition8521); 

                    createLeafNode(grammarAccess.getInitialTransitionAccess().getTransitionKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4919:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_ID) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4920:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4920:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4921:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInitialTransition8538); 

                    			createLeafNode(grammarAccess.getInitialTransitionAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getInitialTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,14,FOLLOW_14_in_ruleInitialTransition8554); 

                    createLeafNode(grammarAccess.getInitialTransitionAccess().getColonKeyword_2(), null); 
                
            match(input,75,FOLLOW_75_in_ruleInitialTransition8564); 

                    createLeafNode(grammarAccess.getInitialTransitionAccess().getInitialKeyword_3(), null); 
                
            match(input,37,FOLLOW_37_in_ruleInitialTransition8574); 

                    createLeafNode(grammarAccess.getInitialTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4955:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4956:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4956:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4957:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getInitialTransitionAccess().getToTransitionTerminalParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition8595);
            lv_to_5_0=ruleTransitionTerminal();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getInitialTransitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"to",
            	        		lv_to_5_0, 
            	        		"TransitionTerminal", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleInitialTransition8605); 

                    createLeafNode(grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_6(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4983:1: ( 'action' ( (lv_action_8_0= ruleDetailCode ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==76) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4983:3: 'action' ( (lv_action_8_0= ruleDetailCode ) )
                    {
                    match(input,76,FOLLOW_76_in_ruleInitialTransition8616); 

                            createLeafNode(grammarAccess.getInitialTransitionAccess().getActionKeyword_7_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4987:1: ( (lv_action_8_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4988:1: (lv_action_8_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4988:1: (lv_action_8_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4989:3: lv_action_8_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInitialTransitionAccess().getActionDetailCodeParserRuleCall_7_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleInitialTransition8637);
                    lv_action_8_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getInitialTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"action",
                    	        		lv_action_8_0, 
                    	        		"DetailCode", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleInitialTransition8649); 

                    createLeafNode(grammarAccess.getInitialTransitionAccess().getRightCurlyBracketKeyword_8(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleInitialTransition


    // $ANTLR start entryRuleContinuationTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5023:1: entryRuleContinuationTransition returns [EObject current=null] : iv_ruleContinuationTransition= ruleContinuationTransition EOF ;
    public final EObject entryRuleContinuationTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuationTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5024:2: (iv_ruleContinuationTransition= ruleContinuationTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5025:2: iv_ruleContinuationTransition= ruleContinuationTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getContinuationTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition8685);
            iv_ruleContinuationTransition=ruleContinuationTransition();
            _fsp--;

             current =iv_ruleContinuationTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContinuationTransition8695); 

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
    // $ANTLR end entryRuleContinuationTransition


    // $ANTLR start ruleContinuationTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5032:1: ruleContinuationTransition returns [EObject current=null] : ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' ( 'action' ( (lv_action_8_0= ruleDetailCode ) ) )? '}' ) ;
    public final EObject ruleContinuationTransition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_action_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5037:6: ( ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' ( 'action' ( (lv_action_8_0= ruleDetailCode ) ) )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5038:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' ( 'action' ( (lv_action_8_0= ruleDetailCode ) ) )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5038:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' ( 'action' ( (lv_action_8_0= ruleDetailCode ) ) )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5038:3: 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' ( 'action' ( (lv_action_8_0= ruleDetailCode ) ) )? '}'
            {
            match(input,74,FOLLOW_74_in_ruleContinuationTransition8730); 

                    createLeafNode(grammarAccess.getContinuationTransitionAccess().getTransitionKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5042:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_ID) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5043:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5043:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5044:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContinuationTransition8747); 

                    			createLeafNode(grammarAccess.getContinuationTransitionAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getContinuationTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,14,FOLLOW_14_in_ruleContinuationTransition8763); 

                    createLeafNode(grammarAccess.getContinuationTransitionAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5070:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5071:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5071:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5072:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getContinuationTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition8784);
            lv_from_3_0=ruleTransitionTerminal();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getContinuationTransitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"from",
            	        		lv_from_3_0, 
            	        		"TransitionTerminal", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,37,FOLLOW_37_in_ruleContinuationTransition8794); 

                    createLeafNode(grammarAccess.getContinuationTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5098:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5099:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5099:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5100:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getContinuationTransitionAccess().getToTransitionTerminalParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition8815);
            lv_to_5_0=ruleTransitionTerminal();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getContinuationTransitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"to",
            	        		lv_to_5_0, 
            	        		"TransitionTerminal", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleContinuationTransition8825); 

                    createLeafNode(grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_6(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5126:1: ( 'action' ( (lv_action_8_0= ruleDetailCode ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==76) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5126:3: 'action' ( (lv_action_8_0= ruleDetailCode ) )
                    {
                    match(input,76,FOLLOW_76_in_ruleContinuationTransition8836); 

                            createLeafNode(grammarAccess.getContinuationTransitionAccess().getActionKeyword_7_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5130:1: ( (lv_action_8_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5131:1: (lv_action_8_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5131:1: (lv_action_8_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5132:3: lv_action_8_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getContinuationTransitionAccess().getActionDetailCodeParserRuleCall_7_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleContinuationTransition8857);
                    lv_action_8_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getContinuationTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"action",
                    	        		lv_action_8_0, 
                    	        		"DetailCode", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleContinuationTransition8869); 

                    createLeafNode(grammarAccess.getContinuationTransitionAccess().getRightCurlyBracketKeyword_8(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleContinuationTransition


    // $ANTLR start entryRuleTriggeredTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5166:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5167:2: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5168:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTriggeredTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition8905);
            iv_ruleTriggeredTransition=ruleTriggeredTransition();
            _fsp--;

             current =iv_ruleTriggeredTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggeredTransition8915); 

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
    // $ANTLR end entryRuleTriggeredTransition


    // $ANTLR start ruleTriggeredTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5175:1: ruleTriggeredTransition returns [EObject current=null] : ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' 'triggers' '{' ( (lv_triggers_9_0= ruleTrigger ) ) ( 'or' ( (lv_triggers_11_0= ruleTrigger ) ) )* '}' ( 'action' ( (lv_action_14_0= ruleDetailCode ) ) )? '}' ) ;
    public final EObject ruleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_triggers_9_0 = null;

        EObject lv_triggers_11_0 = null;

        EObject lv_action_14_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5180:6: ( ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' 'triggers' '{' ( (lv_triggers_9_0= ruleTrigger ) ) ( 'or' ( (lv_triggers_11_0= ruleTrigger ) ) )* '}' ( 'action' ( (lv_action_14_0= ruleDetailCode ) ) )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5181:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' 'triggers' '{' ( (lv_triggers_9_0= ruleTrigger ) ) ( 'or' ( (lv_triggers_11_0= ruleTrigger ) ) )* '}' ( 'action' ( (lv_action_14_0= ruleDetailCode ) ) )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5181:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' 'triggers' '{' ( (lv_triggers_9_0= ruleTrigger ) ) ( 'or' ( (lv_triggers_11_0= ruleTrigger ) ) )* '}' ( 'action' ( (lv_action_14_0= ruleDetailCode ) ) )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5181:3: 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' 'triggers' '{' ( (lv_triggers_9_0= ruleTrigger ) ) ( 'or' ( (lv_triggers_11_0= ruleTrigger ) ) )* '}' ( 'action' ( (lv_action_14_0= ruleDetailCode ) ) )? '}'
            {
            match(input,74,FOLLOW_74_in_ruleTriggeredTransition8950); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getTransitionKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5185:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_ID) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5186:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5186:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5187:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggeredTransition8967); 

                    			createLeafNode(grammarAccess.getTriggeredTransitionAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTriggeredTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,14,FOLLOW_14_in_ruleTriggeredTransition8983); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5213:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5214:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5214:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5215:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTriggeredTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition9004);
            lv_from_3_0=ruleTransitionTerminal();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTriggeredTransitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"from",
            	        		lv_from_3_0, 
            	        		"TransitionTerminal", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,37,FOLLOW_37_in_ruleTriggeredTransition9014); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5241:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5242:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5242:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5243:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTriggeredTransitionAccess().getToTransitionTerminalParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition9035);
            lv_to_5_0=ruleTransitionTerminal();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTriggeredTransitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"to",
            	        		lv_to_5_0, 
            	        		"TransitionTerminal", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleTriggeredTransition9045); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_6(), null); 
                
            match(input,77,FOLLOW_77_in_ruleTriggeredTransition9055); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getTriggersKeyword_7(), null); 
                
            match(input,12,FOLLOW_12_in_ruleTriggeredTransition9065); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_8(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5277:1: ( (lv_triggers_9_0= ruleTrigger ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5278:1: (lv_triggers_9_0= ruleTrigger )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5278:1: (lv_triggers_9_0= ruleTrigger )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5279:3: lv_triggers_9_0= ruleTrigger
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_9_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition9086);
            lv_triggers_9_0=ruleTrigger();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTriggeredTransitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"triggers",
            	        		lv_triggers_9_0, 
            	        		"Trigger", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5301:2: ( 'or' ( (lv_triggers_11_0= ruleTrigger ) ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==78) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5301:4: 'or' ( (lv_triggers_11_0= ruleTrigger ) )
            	    {
            	    match(input,78,FOLLOW_78_in_ruleTriggeredTransition9097); 

            	            createLeafNode(grammarAccess.getTriggeredTransitionAccess().getOrKeyword_10_0(), null); 
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5305:1: ( (lv_triggers_11_0= ruleTrigger ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5306:1: (lv_triggers_11_0= ruleTrigger )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5306:1: (lv_triggers_11_0= ruleTrigger )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5307:3: lv_triggers_11_0= ruleTrigger
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_10_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition9118);
            	    lv_triggers_11_0=ruleTrigger();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTriggeredTransitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"triggers",
            	    	        		lv_triggers_11_0, 
            	    	        		"Trigger", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleTriggeredTransition9130); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_11(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5333:1: ( 'action' ( (lv_action_14_0= ruleDetailCode ) ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==76) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5333:3: 'action' ( (lv_action_14_0= ruleDetailCode ) )
                    {
                    match(input,76,FOLLOW_76_in_ruleTriggeredTransition9141); 

                            createLeafNode(grammarAccess.getTriggeredTransitionAccess().getActionKeyword_12_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5337:1: ( (lv_action_14_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5338:1: (lv_action_14_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5338:1: (lv_action_14_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5339:3: lv_action_14_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTriggeredTransitionAccess().getActionDetailCodeParserRuleCall_12_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleTriggeredTransition9162);
                    lv_action_14_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTriggeredTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"action",
                    	        		lv_action_14_0, 
                    	        		"DetailCode", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleTriggeredTransition9174); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_13(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTriggeredTransition


    // $ANTLR start entryRuleCPBranchTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5373:1: entryRuleCPBranchTransition returns [EObject current=null] : iv_ruleCPBranchTransition= ruleCPBranchTransition EOF ;
    public final EObject entryRuleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCPBranchTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5374:2: (iv_ruleCPBranchTransition= ruleCPBranchTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5375:2: iv_ruleCPBranchTransition= ruleCPBranchTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCPBranchTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition9210);
            iv_ruleCPBranchTransition=ruleCPBranchTransition();
            _fsp--;

             current =iv_ruleCPBranchTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCPBranchTransition9220); 

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
    // $ANTLR end entryRuleCPBranchTransition


    // $ANTLR start ruleCPBranchTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5382:1: ruleCPBranchTransition returns [EObject current=null] : ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' 'cond' ( (lv_condition_8_0= ruleDetailCode ) ) ( 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? '}' ) ;
    public final EObject ruleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_condition_8_0 = null;

        EObject lv_action_10_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5387:6: ( ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' 'cond' ( (lv_condition_8_0= ruleDetailCode ) ) ( 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5388:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' 'cond' ( (lv_condition_8_0= ruleDetailCode ) ) ( 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5388:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' 'cond' ( (lv_condition_8_0= ruleDetailCode ) ) ( 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5388:3: 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) '{' 'cond' ( (lv_condition_8_0= ruleDetailCode ) ) ( 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? '}'
            {
            match(input,74,FOLLOW_74_in_ruleCPBranchTransition9255); 

                    createLeafNode(grammarAccess.getCPBranchTransitionAccess().getTransitionKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5392:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_ID) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5393:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5393:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5394:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCPBranchTransition9272); 

                    			createLeafNode(grammarAccess.getCPBranchTransitionAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCPBranchTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,14,FOLLOW_14_in_ruleCPBranchTransition9288); 

                    createLeafNode(grammarAccess.getCPBranchTransitionAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5420:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5421:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5421:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5422:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCPBranchTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition9309);
            lv_from_3_0=ruleTransitionTerminal();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCPBranchTransitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"from",
            	        		lv_from_3_0, 
            	        		"TransitionTerminal", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,37,FOLLOW_37_in_ruleCPBranchTransition9319); 

                    createLeafNode(grammarAccess.getCPBranchTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5448:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5449:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5449:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5450:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCPBranchTransitionAccess().getToTransitionTerminalParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition9340);
            lv_to_5_0=ruleTransitionTerminal();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCPBranchTransitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"to",
            	        		lv_to_5_0, 
            	        		"TransitionTerminal", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleCPBranchTransition9350); 

                    createLeafNode(grammarAccess.getCPBranchTransitionAccess().getLeftCurlyBracketKeyword_6(), null); 
                
            match(input,79,FOLLOW_79_in_ruleCPBranchTransition9360); 

                    createLeafNode(grammarAccess.getCPBranchTransitionAccess().getCondKeyword_7(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5480:1: ( (lv_condition_8_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5481:1: (lv_condition_8_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5481:1: (lv_condition_8_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5482:3: lv_condition_8_0= ruleDetailCode
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCPBranchTransitionAccess().getConditionDetailCodeParserRuleCall_8_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition9381);
            lv_condition_8_0=ruleDetailCode();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCPBranchTransitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"condition",
            	        		lv_condition_8_0, 
            	        		"DetailCode", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5504:2: ( 'action' ( (lv_action_10_0= ruleDetailCode ) ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==76) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5504:4: 'action' ( (lv_action_10_0= ruleDetailCode ) )
                    {
                    match(input,76,FOLLOW_76_in_ruleCPBranchTransition9392); 

                            createLeafNode(grammarAccess.getCPBranchTransitionAccess().getActionKeyword_9_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5508:1: ( (lv_action_10_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5509:1: (lv_action_10_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5509:1: (lv_action_10_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5510:3: lv_action_10_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCPBranchTransitionAccess().getActionDetailCodeParserRuleCall_9_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition9413);
                    lv_action_10_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCPBranchTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"action",
                    	        		lv_action_10_0, 
                    	        		"DetailCode", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleCPBranchTransition9425); 

                    createLeafNode(grammarAccess.getCPBranchTransitionAccess().getRightCurlyBracketKeyword_10(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleCPBranchTransition


    // $ANTLR start entryRuleTransitionTerminal
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5544:1: entryRuleTransitionTerminal returns [EObject current=null] : iv_ruleTransitionTerminal= ruleTransitionTerminal EOF ;
    public final EObject entryRuleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5545:2: (iv_ruleTransitionTerminal= ruleTransitionTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5546:2: iv_ruleTransitionTerminal= ruleTransitionTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransitionTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal9461);
            iv_ruleTransitionTerminal=ruleTransitionTerminal();
            _fsp--;

             current =iv_ruleTransitionTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionTerminal9471); 

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
    // $ANTLR end entryRuleTransitionTerminal


    // $ANTLR start ruleTransitionTerminal
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5553:1: ruleTransitionTerminal returns [EObject current=null] : (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) ;
    public final EObject ruleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_StateTerminal_0 = null;

        EObject this_TrPointTerminal_1 = null;

        EObject this_SubStateTrPointTerminal_2 = null;

        EObject this_ChoicepointTerminal_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5558:6: ( (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5559:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5559:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            int alt88=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA88_1 = input.LA(2);

                if ( (LA88_1==50) ) {
                    alt88=3;
                }
                else if ( (LA88_1==EOF||LA88_1==12||LA88_1==37) ) {
                    alt88=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("5559:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )", 88, 1, input);

                    throw nvae;
                }
                }
                break;
            case 80:
                {
                alt88=2;
                }
                break;
            case 81:
                {
                alt88=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("5559:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5560:5: this_StateTerminal_0= ruleStateTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionTerminalAccess().getStateTerminalParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal9518);
                    this_StateTerminal_0=ruleStateTerminal();
                    _fsp--;

                     
                            current = this_StateTerminal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5570:5: this_TrPointTerminal_1= ruleTrPointTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionTerminalAccess().getTrPointTerminalParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal9545);
                    this_TrPointTerminal_1=ruleTrPointTerminal();
                    _fsp--;

                     
                            current = this_TrPointTerminal_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5580:5: this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionTerminalAccess().getSubStateTrPointTerminalParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal9572);
                    this_SubStateTrPointTerminal_2=ruleSubStateTrPointTerminal();
                    _fsp--;

                     
                            current = this_SubStateTrPointTerminal_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5590:5: this_ChoicepointTerminal_3= ruleChoicepointTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionTerminalAccess().getChoicepointTerminalParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal9599);
                    this_ChoicepointTerminal_3=ruleChoicepointTerminal();
                    _fsp--;

                     
                            current = this_ChoicepointTerminal_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTransitionTerminal


    // $ANTLR start entryRuleStateTerminal
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5606:1: entryRuleStateTerminal returns [EObject current=null] : iv_ruleStateTerminal= ruleStateTerminal EOF ;
    public final EObject entryRuleStateTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5607:2: (iv_ruleStateTerminal= ruleStateTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5608:2: iv_ruleStateTerminal= ruleStateTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal9634);
            iv_ruleStateTerminal=ruleStateTerminal();
            _fsp--;

             current =iv_ruleStateTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateTerminal9644); 

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
    // $ANTLR end entryRuleStateTerminal


    // $ANTLR start ruleStateTerminal
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5615:1: ruleStateTerminal returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleStateTerminal() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5620:6: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5621:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5621:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5622:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5622:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5623:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStateTerminalRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStateTerminal9686); 

            		createLeafNode(grammarAccess.getStateTerminalAccess().getStateBaseStateCrossReference_0(), "state"); 
            	

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStateTerminal


    // $ANTLR start entryRuleTrPointTerminal
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5643:1: entryRuleTrPointTerminal returns [EObject current=null] : iv_ruleTrPointTerminal= ruleTrPointTerminal EOF ;
    public final EObject entryRuleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5644:2: (iv_ruleTrPointTerminal= ruleTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5645:2: iv_ruleTrPointTerminal= ruleTrPointTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTrPointTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal9721);
            iv_ruleTrPointTerminal=ruleTrPointTerminal();
            _fsp--;

             current =iv_ruleTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPointTerminal9731); 

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
    // $ANTLR end entryRuleTrPointTerminal


    // $ANTLR start ruleTrPointTerminal
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5652:1: ruleTrPointTerminal returns [EObject current=null] : ( 'my' ( ( RULE_ID ) ) ) ;
    public final EObject ruleTrPointTerminal() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5657:6: ( ( 'my' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5658:1: ( 'my' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5658:1: ( 'my' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5658:3: 'my' ( ( RULE_ID ) )
            {
            match(input,80,FOLLOW_80_in_ruleTrPointTerminal9766); 

                    createLeafNode(grammarAccess.getTrPointTerminalAccess().getMyKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5662:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5663:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5663:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5664:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTrPointTerminalRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTrPointTerminal9784); 

            		createLeafNode(grammarAccess.getTrPointTerminalAccess().getTrPointTrPointCrossReference_1_0(), "trPoint"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTrPointTerminal


    // $ANTLR start entryRuleSubStateTrPointTerminal
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5684:1: entryRuleSubStateTrPointTerminal returns [EObject current=null] : iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF ;
    public final EObject entryRuleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStateTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5685:2: (iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5686:2: iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubStateTrPointTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal9820);
            iv_ruleSubStateTrPointTerminal=ruleSubStateTrPointTerminal();
            _fsp--;

             current =iv_ruleSubStateTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal9830); 

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
    // $ANTLR end entryRuleSubStateTrPointTerminal


    // $ANTLR start ruleSubStateTrPointTerminal
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5693:1: ruleSubStateTrPointTerminal returns [EObject current=null] : ( ( ( RULE_ID ) ) 'of' ( ( RULE_ID ) ) ) ;
    public final EObject ruleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5698:6: ( ( ( ( RULE_ID ) ) 'of' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5699:1: ( ( ( RULE_ID ) ) 'of' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5699:1: ( ( ( RULE_ID ) ) 'of' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5699:2: ( ( RULE_ID ) ) 'of' ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5699:2: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5700:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5700:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5701:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubStateTrPointTerminalRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal9873); 

            		createLeafNode(grammarAccess.getSubStateTrPointTerminalAccess().getTrPointTrPointCrossReference_0_0(), "trPoint"); 
            	

            }


            }

            match(input,50,FOLLOW_50_in_ruleSubStateTrPointTerminal9883); 

                    createLeafNode(grammarAccess.getSubStateTrPointTerminalAccess().getOfKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5717:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5718:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5718:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5719:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubStateTrPointTerminalRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal9901); 

            		createLeafNode(grammarAccess.getSubStateTrPointTerminalAccess().getStateBaseStateCrossReference_2_0(), "state"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSubStateTrPointTerminal


    // $ANTLR start entryRuleChoicepointTerminal
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5739:1: entryRuleChoicepointTerminal returns [EObject current=null] : iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF ;
    public final EObject entryRuleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicepointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5740:2: (iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5741:2: iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChoicepointTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal9937);
            iv_ruleChoicepointTerminal=ruleChoicepointTerminal();
            _fsp--;

             current =iv_ruleChoicepointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicepointTerminal9947); 

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
    // $ANTLR end entryRuleChoicepointTerminal


    // $ANTLR start ruleChoicepointTerminal
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5748:1: ruleChoicepointTerminal returns [EObject current=null] : ( 'cp' ( ( RULE_ID ) ) ) ;
    public final EObject ruleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5753:6: ( ( 'cp' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5754:1: ( 'cp' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5754:1: ( 'cp' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5754:3: 'cp' ( ( RULE_ID ) )
            {
            match(input,81,FOLLOW_81_in_ruleChoicepointTerminal9982); 

                    createLeafNode(grammarAccess.getChoicepointTerminalAccess().getCpKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5758:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5759:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5759:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5760:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getChoicepointTerminalRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicepointTerminal10000); 

            		createLeafNode(grammarAccess.getChoicepointTerminalAccess().getCpChoicePointCrossReference_1_0(), "cp"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleChoicepointTerminal


    // $ANTLR start entryRuleTrigger
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5780:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5781:2: (iv_ruleTrigger= ruleTrigger EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5782:2: iv_ruleTrigger= ruleTrigger EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTriggerRule(), currentNode); 
            pushFollow(FOLLOW_ruleTrigger_in_entryRuleTrigger10036);
            iv_ruleTrigger=ruleTrigger();
            _fsp--;

             current =iv_ruleTrigger; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrigger10046); 

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
    // $ANTLR end entryRuleTrigger


    // $ANTLR start ruleTrigger
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5789:1: ruleTrigger returns [EObject current=null] : ( '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) ( '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? '>' ) ;
    public final EObject ruleTrigger() throws RecognitionException {
        EObject current = null;

        EObject lv_msgFromIfPairs_1_0 = null;

        EObject lv_msgFromIfPairs_3_0 = null;

        EObject lv_guard_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5794:6: ( ( '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) ( '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? '>' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5795:1: ( '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) ( '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? '>' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5795:1: ( '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) ( '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? '>' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5795:3: '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) ( '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? '>'
            {
            match(input,82,FOLLOW_82_in_ruleTrigger10081); 

                    createLeafNode(grammarAccess.getTriggerAccess().getLessThanSignKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5799:1: ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5800:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5800:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5801:3: lv_msgFromIfPairs_1_0= ruleMessageFromIf
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger10102);
            lv_msgFromIfPairs_1_0=ruleMessageFromIf();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTriggerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"msgFromIfPairs",
            	        		lv_msgFromIfPairs_1_0, 
            	        		"MessageFromIf", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5823:2: ( '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==83) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5823:4: '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    {
            	    match(input,83,FOLLOW_83_in_ruleTrigger10113); 

            	            createLeafNode(grammarAccess.getTriggerAccess().getVerticalLineKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5827:1: ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5828:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5828:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5829:3: lv_msgFromIfPairs_3_0= ruleMessageFromIf
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger10134);
            	    lv_msgFromIfPairs_3_0=ruleMessageFromIf();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTriggerRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"msgFromIfPairs",
            	    	        		lv_msgFromIfPairs_3_0, 
            	    	        		"MessageFromIf", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5851:4: ( (lv_guard_4_0= ruleGuard ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==85) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5852:1: (lv_guard_4_0= ruleGuard )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5852:1: (lv_guard_4_0= ruleGuard )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5853:3: lv_guard_4_0= ruleGuard
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTriggerAccess().getGuardGuardParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGuard_in_ruleTrigger10157);
                    lv_guard_4_0=ruleGuard();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTriggerRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"guard",
                    	        		lv_guard_4_0, 
                    	        		"Guard", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,84,FOLLOW_84_in_ruleTrigger10168); 

                    createLeafNode(grammarAccess.getTriggerAccess().getGreaterThanSignKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTrigger


    // $ANTLR start entryRuleMessageFromIf
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5887:1: entryRuleMessageFromIf returns [EObject current=null] : iv_ruleMessageFromIf= ruleMessageFromIf EOF ;
    public final EObject entryRuleMessageFromIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageFromIf = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5888:2: (iv_ruleMessageFromIf= ruleMessageFromIf EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5889:2: iv_ruleMessageFromIf= ruleMessageFromIf EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMessageFromIfRule(), currentNode); 
            pushFollow(FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf10204);
            iv_ruleMessageFromIf=ruleMessageFromIf();
            _fsp--;

             current =iv_ruleMessageFromIf; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessageFromIf10214); 

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
    // $ANTLR end entryRuleMessageFromIf


    // $ANTLR start ruleMessageFromIf
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5896:1: ruleMessageFromIf returns [EObject current=null] : ( ( ( RULE_ID ) ) ':' ( ( RULE_ID ) ) ) ;
    public final EObject ruleMessageFromIf() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5901:6: ( ( ( ( RULE_ID ) ) ':' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5902:1: ( ( ( RULE_ID ) ) ':' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5902:1: ( ( ( RULE_ID ) ) ':' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5902:2: ( ( RULE_ID ) ) ':' ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5902:2: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5903:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5903:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5904:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getMessageFromIfRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf10257); 

            		createLeafNode(grammarAccess.getMessageFromIfAccess().getMessageMessageCrossReference_0_0(), "message"); 
            	

            }


            }

            match(input,14,FOLLOW_14_in_ruleMessageFromIf10267); 

                    createLeafNode(grammarAccess.getMessageFromIfAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5920:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5921:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5921:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5922:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getMessageFromIfRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf10285); 

            		createLeafNode(grammarAccess.getMessageFromIfAccess().getFromInterfaceItemCrossReference_2_0(), "from"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMessageFromIf


    // $ANTLR start entryRuleGuard
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5942:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5943:2: (iv_ruleGuard= ruleGuard EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5944:2: iv_ruleGuard= ruleGuard EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGuardRule(), currentNode); 
            pushFollow(FOLLOW_ruleGuard_in_entryRuleGuard10321);
            iv_ruleGuard=ruleGuard();
            _fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuard10331); 

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
    // $ANTLR end entryRuleGuard


    // $ANTLR start ruleGuard
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5951:1: ruleGuard returns [EObject current=null] : ( 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        EObject lv_guard_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5956:6: ( ( 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5957:1: ( 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5957:1: ( 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5957:3: 'guard' ( (lv_guard_1_0= ruleDetailCode ) )
            {
            match(input,85,FOLLOW_85_in_ruleGuard10366); 

                    createLeafNode(grammarAccess.getGuardAccess().getGuardKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5961:1: ( (lv_guard_1_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5962:1: (lv_guard_1_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5962:1: (lv_guard_1_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5963:3: lv_guard_1_0= ruleDetailCode
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getGuardAccess().getGuardDetailCodeParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleGuard10387);
            lv_guard_1_0=ruleDetailCode();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getGuardRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"guard",
            	        		lv_guard_1_0, 
            	        		"DetailCode", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGuard


    // $ANTLR start entryRuleImport
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5993:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5994:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5995:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport10423);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport10433); 

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
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6002:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6007:6: ( ( 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6008:1: ( 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6008:1: ( 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6008:3: 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            {
            match(input,86,FOLLOW_86_in_ruleImport10468); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6012:1: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6013:1: (lv_importedNamespace_1_0= ruleImportedFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6013:1: (lv_importedNamespace_1_0= ruleImportedFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6014:3: lv_importedNamespace_1_0= ruleImportedFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleImportedFQN_in_ruleImport10489);
            lv_importedNamespace_1_0=ruleImportedFQN();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"importedNamespace",
            	        		lv_importedNamespace_1_0, 
            	        		"ImportedFQN", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleImportedFQN
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6044:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6045:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6046:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportedFQNRule(), currentNode); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN10526);
            iv_ruleImportedFQN=ruleImportedFQN();
            _fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN10537); 

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
    // $ANTLR end entryRuleImportedFQN


    // $ANTLR start ruleImportedFQN
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6053:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6058:6: ( (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6059:1: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6059:1: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6060:5: this_FQN_0= ruleFQN (kw= '.' kw= '*' )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN10584);
            this_FQN_0=ruleFQN();
            _fsp--;


            		current.merge(this_FQN_0);
                
             
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6070:1: (kw= '.' kw= '*' )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==55) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6071:2: kw= '.' kw= '*'
                    {
                    kw=(Token)input.LT(1);
                    match(input,55,FOLLOW_55_in_ruleImportedFQN10603); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getImportedFQNAccess().getFullStopKeyword_1_0(), null); 
                        
                    kw=(Token)input.LT(1);
                    match(input,87,FOLLOW_87_in_ruleImportedFQN10616); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getImportedFQNAccess().getAsteriskKeyword_1_1(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleImportedFQN


    // $ANTLR start entryRuleFQN
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6090:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6091:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6092:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN10659);
            iv_ruleFQN=ruleFQN();
            _fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN10670); 

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
    // $ANTLR end entryRuleFQN


    // $ANTLR start ruleFQN
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6099:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6104:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6105:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6105:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6105:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN10710); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6112:1: (kw= '.' this_ID_2= RULE_ID )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==55) ) {
                    int LA92_2 = input.LA(2);

                    if ( (LA92_2==RULE_ID) ) {
                        alt92=1;
                    }


                }


                switch (alt92) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6113:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,55,FOLLOW_55_in_ruleFQN10729); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN10744); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFQN


    // $ANTLR start rulePrimitiveType
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6133:1: rulePrimitiveType returns [Enumerator current=null] : ( ( 'void' ) | ( 'int8' ) | ( 'int16' ) | ( 'int32' ) | ( 'uint8' ) | ( 'uint16' ) | ( 'uint32' ) | ( 'float32' ) | ( 'float64' ) | ( 'boolean' ) | ( 'string' ) | ( 'char' ) ) ;
    public final Enumerator rulePrimitiveType() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6137:6: ( ( ( 'void' ) | ( 'int8' ) | ( 'int16' ) | ( 'int32' ) | ( 'uint8' ) | ( 'uint16' ) | ( 'uint32' ) | ( 'float32' ) | ( 'float64' ) | ( 'boolean' ) | ( 'string' ) | ( 'char' ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6138:1: ( ( 'void' ) | ( 'int8' ) | ( 'int16' ) | ( 'int32' ) | ( 'uint8' ) | ( 'uint16' ) | ( 'uint32' ) | ( 'float32' ) | ( 'float64' ) | ( 'boolean' ) | ( 'string' ) | ( 'char' ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6138:1: ( ( 'void' ) | ( 'int8' ) | ( 'int16' ) | ( 'int32' ) | ( 'uint8' ) | ( 'uint16' ) | ( 'uint32' ) | ( 'float32' ) | ( 'float64' ) | ( 'boolean' ) | ( 'string' ) | ( 'char' ) )
            int alt93=12;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt93=1;
                }
                break;
            case 89:
                {
                alt93=2;
                }
                break;
            case 90:
                {
                alt93=3;
                }
                break;
            case 91:
                {
                alt93=4;
                }
                break;
            case 92:
                {
                alt93=5;
                }
                break;
            case 93:
                {
                alt93=6;
                }
                break;
            case 94:
                {
                alt93=7;
                }
                break;
            case 95:
                {
                alt93=8;
                }
                break;
            case 96:
                {
                alt93=9;
                }
                break;
            case 97:
                {
                alt93=10;
                }
                break;
            case 98:
                {
                alt93=11;
                }
                break;
            case 99:
                {
                alt93=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6138:1: ( ( 'void' ) | ( 'int8' ) | ( 'int16' ) | ( 'int32' ) | ( 'uint8' ) | ( 'uint16' ) | ( 'uint32' ) | ( 'float32' ) | ( 'float64' ) | ( 'boolean' ) | ( 'string' ) | ( 'char' ) )", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6138:2: ( 'void' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6138:2: ( 'void' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6138:4: 'void'
                    {
                    match(input,88,FOLLOW_88_in_rulePrimitiveType10803); 

                            current = grammarAccess.getPrimitiveTypeAccess().getVoidEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getVoidEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6144:6: ( 'int8' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6144:6: ( 'int8' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6144:8: 'int8'
                    {
                    match(input,89,FOLLOW_89_in_rulePrimitiveType10818); 

                            current = grammarAccess.getPrimitiveTypeAccess().getInt8EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getInt8EnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6150:6: ( 'int16' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6150:6: ( 'int16' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6150:8: 'int16'
                    {
                    match(input,90,FOLLOW_90_in_rulePrimitiveType10833); 

                            current = grammarAccess.getPrimitiveTypeAccess().getInt16EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getInt16EnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6156:6: ( 'int32' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6156:6: ( 'int32' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6156:8: 'int32'
                    {
                    match(input,91,FOLLOW_91_in_rulePrimitiveType10848); 

                            current = grammarAccess.getPrimitiveTypeAccess().getInt32EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getInt32EnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6162:6: ( 'uint8' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6162:6: ( 'uint8' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6162:8: 'uint8'
                    {
                    match(input,92,FOLLOW_92_in_rulePrimitiveType10863); 

                            current = grammarAccess.getPrimitiveTypeAccess().getUint8EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getUint8EnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6168:6: ( 'uint16' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6168:6: ( 'uint16' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6168:8: 'uint16'
                    {
                    match(input,93,FOLLOW_93_in_rulePrimitiveType10878); 

                            current = grammarAccess.getPrimitiveTypeAccess().getUint16EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getUint16EnumLiteralDeclaration_5(), null); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6174:6: ( 'uint32' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6174:6: ( 'uint32' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6174:8: 'uint32'
                    {
                    match(input,94,FOLLOW_94_in_rulePrimitiveType10893); 

                            current = grammarAccess.getPrimitiveTypeAccess().getUint32EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getUint32EnumLiteralDeclaration_6(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6180:6: ( 'float32' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6180:6: ( 'float32' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6180:8: 'float32'
                    {
                    match(input,95,FOLLOW_95_in_rulePrimitiveType10908); 

                            current = grammarAccess.getPrimitiveTypeAccess().getFloat32EnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getFloat32EnumLiteralDeclaration_7(), null); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6186:6: ( 'float64' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6186:6: ( 'float64' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6186:8: 'float64'
                    {
                    match(input,96,FOLLOW_96_in_rulePrimitiveType10923); 

                            current = grammarAccess.getPrimitiveTypeAccess().getFloat64EnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getFloat64EnumLiteralDeclaration_8(), null); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6192:6: ( 'boolean' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6192:6: ( 'boolean' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6192:8: 'boolean'
                    {
                    match(input,97,FOLLOW_97_in_rulePrimitiveType10938); 

                            current = grammarAccess.getPrimitiveTypeAccess().getBooleanEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getBooleanEnumLiteralDeclaration_9(), null); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6198:6: ( 'string' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6198:6: ( 'string' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6198:8: 'string'
                    {
                    match(input,98,FOLLOW_98_in_rulePrimitiveType10953); 

                            current = grammarAccess.getPrimitiveTypeAccess().getStringEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getStringEnumLiteralDeclaration_10(), null); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6204:6: ( 'char' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6204:6: ( 'char' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6204:8: 'char'
                    {
                    match(input,99,FOLLOW_99_in_rulePrimitiveType10968); 

                            current = grammarAccess.getPrimitiveTypeAccess().getCharEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getCharEnumLiteralDeclaration_11(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePrimitiveType


 

    public static final BitSet FOLLOW_ruleRoomModel_in_entryRuleRoomModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoomModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRoomModel120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRoomModel141 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRoomModel151 = new BitSet(new long[]{0x0028018001008000L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleRoomModel172 = new BitSet(new long[]{0x0028018001008000L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleDataClass_in_ruleRoomModel195 = new BitSet(new long[]{0x002801800100A000L});
    public static final BitSet FOLLOW_ruleProtocolClass_in_ruleRoomModel222 = new BitSet(new long[]{0x002801800100A000L});
    public static final BitSet FOLLOW_ruleActorClass_in_ruleRoomModel249 = new BitSet(new long[]{0x002801800100A000L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_ruleRoomModel276 = new BitSet(new long[]{0x002801800100A000L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_ruleRoomModel303 = new BitSet(new long[]{0x002801800100A000L});
    public static final BitSet FOLLOW_13_in_ruleRoomModel315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructureClass_in_entryRuleStructureClass353 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStructureClass363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorContainerClass_in_ruleStructureClass410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_ruleStructureClass437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorContainerClass_in_entryRuleActorContainerClass472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorContainerClass482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClass_in_ruleActorContainerClass529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_ruleActorContainerClass556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedID_in_entryRuleTypedID591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedID601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypedID643 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTypedID658 = new BitSet(new long[]{0x0000000000000010L,0x0000000FFF000000L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypedID679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFreeTypedID_in_entryRuleFreeTypedID715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFreeTypedID725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFreeTypedID767 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleFreeTypedID782 = new BitSet(new long[]{0x0000000000000010L,0x0000000FFF000000L});
    public static final BitSet FOLLOW_ruleFreeType_in_ruleFreeTypedID803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleType895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleType924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFreeType_in_entryRuleFreeType960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFreeType970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleFreeType1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFreeType1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataClass_in_entryRuleDataClass1080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataClass1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDataClass1125 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataClass1142 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_16_in_ruleDataClass1158 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleDataClass1181 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDataClass1193 = new BitSet(new long[]{0x0000000000020000L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleDataClass1214 = new BitSet(new long[]{0x0000000000020000L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleDataClass1236 = new BitSet(new long[]{0x0000000000122000L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleDataClass1258 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_13_in_ruleDataClass1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1305 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleAttribute1350 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1367 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_18_in_ruleAttribute1383 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAttribute1400 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAttribute1415 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAttribute1427 = new BitSet(new long[]{0x0000000000000010L,0x0000000FFF000000L});
    public static final BitSet FOLLOW_ruleType_in_ruleAttribute1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation1484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOperation1529 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperation1546 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleOperation1561 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_ruleFreeTypedID_in_ruleOperation1583 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleOperation1594 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFreeTypedID_in_ruleOperation1615 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_ruleOperation1629 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_14_in_ruleOperation1640 = new BitSet(new long[]{0x0000000000000010L,0x0000000FFF000000L});
    public static final BitSet FOLLOW_ruleFreeType_in_ruleOperation1661 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleOperation1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolClass_in_entryRuleProtocolClass1720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProtocolClass1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleProtocolClass1765 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProtocolClass1782 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_16_in_ruleProtocolClass1798 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleProtocolClass1821 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleProtocolClass1833 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_25_in_ruleProtocolClass1844 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleProtocolClass1865 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleProtocolClass1878 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleProtocolClass1899 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleProtocolClass1911 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleProtocolClass1921 = new BitSet(new long[]{0x0000000100002000L});
    public static final BitSet FOLLOW_ruleMessage_in_ruleProtocolClass1942 = new BitSet(new long[]{0x0000000100002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass1953 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleProtocolClass1963 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleProtocolClass1973 = new BitSet(new long[]{0x0000000100002000L});
    public static final BitSet FOLLOW_ruleMessage_in_ruleProtocolClass1994 = new BitSet(new long[]{0x0000000100002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass2005 = new BitSet(new long[]{0x00000008A0002000L});
    public static final BitSet FOLLOW_29_in_ruleProtocolClass2016 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleProtocolClass2026 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rulePortClass_in_ruleProtocolClass2047 = new BitSet(new long[]{0x0000000880002000L});
    public static final BitSet FOLLOW_31_in_ruleProtocolClass2060 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleProtocolClass2070 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rulePortClass_in_ruleProtocolClass2091 = new BitSet(new long[]{0x0000000800002000L});
    public static final BitSet FOLLOW_ruleProtocolSemantics_in_ruleProtocolClass2114 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessage_in_entryRuleMessage2161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessage2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleMessage2206 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessage2223 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleMessage2238 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_ruleTypedID_in_ruleMessage2260 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleMessage2271 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypedID_in_ruleMessage2292 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_ruleMessage2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClass_in_entryRulePortClass2342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortClass2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePortClass2387 = new BitSet(new long[]{0x0000000600120000L});
    public static final BitSet FOLLOW_33_in_rulePortClass2398 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_rulePortClass2419 = new BitSet(new long[]{0x0000000400120000L});
    public static final BitSet FOLLOW_ruleAttribute_in_rulePortClass2443 = new BitSet(new long[]{0x0000000400122000L});
    public static final BitSet FOLLOW_ruleOperation_in_rulePortClass2470 = new BitSet(new long[]{0x0000000400122000L});
    public static final BitSet FOLLOW_ruleMessageHandler_in_rulePortClass2497 = new BitSet(new long[]{0x0000000400122000L});
    public static final BitSet FOLLOW_13_in_rulePortClass2509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessageHandler_in_entryRuleMessageHandler2545 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageHandler2555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleMessageHandler2590 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageHandler2608 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleMessageHandler2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolSemantics_in_entryRuleProtocolSemantics2665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProtocolSemantics2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleProtocolSemantics2710 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleProtocolSemantics2720 = new BitSet(new long[]{0x0000005000000000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleProtocolSemantics2741 = new BitSet(new long[]{0x0000005000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolSemantics2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_entryRuleSemanticsRule2788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSemanticsRule2798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsInRule_in_ruleSemanticsRule2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsOutRule_in_ruleSemanticsRule2872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsInRule_in_entryRuleSemanticsInRule2907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSemanticsInRule2917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleSemanticsInRule2952 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSemanticsInRule2970 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleSemanticsInRule2980 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSemanticsInRule2990 = new BitSet(new long[]{0x0000005000002000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleSemanticsInRule3011 = new BitSet(new long[]{0x0000005000002000L});
    public static final BitSet FOLLOW_13_in_ruleSemanticsInRule3022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsOutRule_in_entryRuleSemanticsOutRule3058 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSemanticsOutRule3068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleSemanticsOutRule3103 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSemanticsOutRule3121 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleSemanticsOutRule3131 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSemanticsOutRule3141 = new BitSet(new long[]{0x0000005000002000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleSemanticsOutRule3162 = new BitSet(new long[]{0x0000005000002000L});
    public static final BitSet FOLLOW_13_in_ruleSemanticsOutRule3173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClass_in_entryRuleActorClass3209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorClass3219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleActorClass3262 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleActorClass3286 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorClass3303 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_16_in_ruleActorClass3319 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorClass3342 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorClass3354 = new BitSet(new long[]{0x00000E0000002000L});
    public static final BitSet FOLLOW_41_in_ruleActorClass3365 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorClass3375 = new BitSet(new long[]{0x0001300000002000L});
    public static final BitSet FOLLOW_rulePort_in_ruleActorClass3396 = new BitSet(new long[]{0x0001300000002000L});
    public static final BitSet FOLLOW_ruleSPPRef_in_ruleActorClass3418 = new BitSet(new long[]{0x0001000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass3429 = new BitSet(new long[]{0x00000C0000002000L});
    public static final BitSet FOLLOW_42_in_ruleActorClass3442 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorClass3452 = new BitSet(new long[]{0x4502F00006022000L});
    public static final BitSet FOLLOW_25_in_ruleActorClass3463 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleActorClass3484 = new BitSet(new long[]{0x4502F00004022000L});
    public static final BitSet FOLLOW_26_in_ruleActorClass3497 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleActorClass3518 = new BitSet(new long[]{0x4502F00000022000L});
    public static final BitSet FOLLOW_rulePort_in_ruleActorClass3542 = new BitSet(new long[]{0x4502F00000022000L});
    public static final BitSet FOLLOW_ruleExternalPort_in_ruleActorClass3569 = new BitSet(new long[]{0x4502F00000022000L});
    public static final BitSet FOLLOW_ruleServiceImplementation_in_ruleActorClass3592 = new BitSet(new long[]{0x4502800000022000L});
    public static final BitSet FOLLOW_ruleSAPRef_in_ruleActorClass3614 = new BitSet(new long[]{0x4500800000022000L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleActorClass3636 = new BitSet(new long[]{0x4500000000022000L});
    public static final BitSet FOLLOW_ruleActorRef_in_ruleActorClass3658 = new BitSet(new long[]{0x4500000000002000L});
    public static final BitSet FOLLOW_ruleBinding_in_ruleActorClass3680 = new BitSet(new long[]{0x0500000000002000L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleActorClass3702 = new BitSet(new long[]{0x0400000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass3713 = new BitSet(new long[]{0x0000080000002000L});
    public static final BitSet FOLLOW_43_in_ruleActorClass3726 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorClass3736 = new BitSet(new long[]{0x8000000000102000L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleActorClass3757 = new BitSet(new long[]{0x8000000000102000L});
    public static final BitSet FOLLOW_ruleStateMachine_in_ruleActorClass3779 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass3790 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass3802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePort_in_entryRulePort3840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePort3850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rulePort3893 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_rulePort3917 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePort3934 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_18_in_rulePort3950 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePort3967 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePort3982 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePort3994 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePort4017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalPort_in_entryRuleExternalPort4053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalPort4063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleExternalPort4098 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleExternalPort4108 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalPort4126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSAPRef_in_entryRuleSAPRef4162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSAPRef4172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleSAPRef4207 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSAPRef4224 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSAPRef4239 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSAPRef4262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSPPRef_in_entryRuleSPPRef4298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSPPRef4308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleSPPRef4343 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPRef4360 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSPPRef4375 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSPPRef4398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleServiceImplementation_in_entryRuleServiceImplementation4434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleServiceImplementation4444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleServiceImplementation4479 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleServiceImplementation4489 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleServiceImplementation4507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_entryRuleLogicalSystem4543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalSystem4553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleLogicalSystem4588 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLogicalSystem4605 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLogicalSystem4620 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleSubSystemRef_in_ruleLogicalSystem4641 = new BitSet(new long[]{0x0510000000002000L});
    public static final BitSet FOLLOW_ruleBinding_in_ruleLogicalSystem4663 = new BitSet(new long[]{0x0500000000002000L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleLogicalSystem4685 = new BitSet(new long[]{0x0400000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLogicalSystem4696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemRef_in_entryRuleSubSystemRef4734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemRef4744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleSubSystemRef4779 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemRef4796 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSubSystemRef4811 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSubSystemRef4834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_entryRuleSubSystemClass4870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemClass4880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleSubSystemClass4915 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemClass4932 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSubSystemClass4947 = new BitSet(new long[]{0x4001300000000000L});
    public static final BitSet FOLLOW_rulePort_in_ruleSubSystemClass4968 = new BitSet(new long[]{0x4001300000000000L});
    public static final BitSet FOLLOW_ruleSPPRef_in_ruleSubSystemClass4990 = new BitSet(new long[]{0x4001000000000000L});
    public static final BitSet FOLLOW_ruleActorRef_in_ruleSubSystemClass5012 = new BitSet(new long[]{0x4540000000002000L});
    public static final BitSet FOLLOW_ruleBinding_in_ruleSubSystemClass5034 = new BitSet(new long[]{0x0540000000002000L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleSubSystemClass5056 = new BitSet(new long[]{0x0440000000002000L});
    public static final BitSet FOLLOW_ruleLogicalThread_in_ruleSubSystemClass5078 = new BitSet(new long[]{0x0040000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSubSystemClass5089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalThread_in_entryRuleLogicalThread5125 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalThread5135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleLogicalThread5170 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLogicalThread5187 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLogicalThread5202 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_ruleLogicalThread5223 = new BitSet(new long[]{0x0000000000402000L});
    public static final BitSet FOLLOW_22_in_ruleLogicalThread5234 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_ruleLogicalThread5255 = new BitSet(new long[]{0x0000000000402000L});
    public static final BitSet FOLLOW_13_in_ruleLogicalThread5267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_entryRuleActorInstancePath5303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorInstancePath5313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorInstancePath5355 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleActorInstancePath5371 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorInstancePath5388 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleBinding_in_entryRuleBinding5431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBinding5441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleBinding5476 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_ruleBinding5497 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleBinding5507 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_ruleBinding5528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_entryRuleBindingEndPoint5564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBindingEndPoint5574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBindingEndPoint5618 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleBindingEndPoint5628 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBindingEndPoint5648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_entryRuleLayerConnection5684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLayerConnection5694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleLayerConnection5729 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_ruleSAPoint_in_ruleLayerConnection5750 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleLayerConnection5760 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSPPoint_in_ruleLayerConnection5781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSAPoint_in_entryRuleSAPoint5817 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSAPoint5827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefSAPoint_in_ruleSAPoint5874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelaySAPoint_in_ruleSAPoint5901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefSAPoint_in_entryRuleRefSAPoint5936 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefSAPoint5946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleRefSAPoint5981 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefSAPoint5999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelaySAPoint_in_entryRuleRelaySAPoint6035 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelaySAPoint6045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleRelaySAPoint6080 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRelaySAPoint6098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSPPoint_in_entryRuleSPPoint6134 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSPPoint6144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPoint6187 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleSPPoint6197 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPoint6215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorRef_in_entryRuleActorRef6251 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorRef6261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleActorRef6296 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorRef6313 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleActorRef6328 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorRef6351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateGraphNode_in_entryRuleStateGraphNode6387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateGraphNode6397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateGraphNode6444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateGraphNode6471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateGraphNode6498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState6535 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState6545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBaseState_in_ruleState6592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedState_in_ruleState6619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateGraph_in_entryRuleStateGraph6654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateGraph6664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleStateGraph6699 = new BitSet(new long[]{0x0000000000000000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateGraph6721 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateGraph6748 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateGraph6775 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateGraph6802 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_13_in_ruleStateGraph6814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_entryRuleStateMachine6850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateMachine6860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleStateMachine6895 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleStateMachine6905 = new BitSet(new long[]{0x0000000000000000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateMachine6927 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateMachine6954 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateMachine6981 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateMachine7008 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_13_in_ruleStateMachine7020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBaseState_in_entryRuleBaseState7056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBaseState7066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleBaseState7101 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBaseState7118 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleBaseState7133 = new BitSet(new long[]{0x0000000000002000L,0x000000000000000EL});
    public static final BitSet FOLLOW_65_in_ruleBaseState7144 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleBaseState7165 = new BitSet(new long[]{0x0000000000002000L,0x000000000000000CL});
    public static final BitSet FOLLOW_66_in_ruleBaseState7178 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleBaseState7199 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_ruleBaseState7212 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleStateGraph_in_ruleBaseState7233 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleBaseState7245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedState_in_entryRuleRefinedState7281 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefinedState7291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleRefinedState7326 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRefinedState7349 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRefinedState7359 = new BitSet(new long[]{0x0000000000002000L,0x000000000000000EL});
    public static final BitSet FOLLOW_65_in_ruleRefinedState7370 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState7391 = new BitSet(new long[]{0x0000000000002000L,0x000000000000000CL});
    public static final BitSet FOLLOW_66_in_ruleRefinedState7404 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState7425 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_ruleRefinedState7438 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleStateGraph_in_ruleRefinedState7459 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRefinedState7471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDetailCode_in_entryRuleDetailCode7507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDetailCode7517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleDetailCode7552 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDetailCode7569 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_13_in_ruleDetailCode7585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPoint_in_entryRuleTrPoint7621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPoint7631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_ruleTrPoint7678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_ruleTrPoint7705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_ruleTrPoint7732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint7767 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionPoint7777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleTransitionPoint7820 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleTransitionPoint7844 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransitionPoint7861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint7902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryPoint7912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleEntryPoint7947 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntryPoint7964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_entryRuleExitPoint8005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitPoint8015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleExitPoint8050 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitPoint8067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint8108 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicePoint8118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleChoicePoint8153 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicePoint8170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition8211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition8221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_ruleTransition8268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_ruleTransition8295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition8330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonInitialTransition8340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_ruleNonInitialTransition8387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition8414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition8441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition8476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInitialTransition8486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleInitialTransition8521 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInitialTransition8538 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleInitialTransition8554 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleInitialTransition8564 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleInitialTransition8574 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition8595 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleInitialTransition8605 = new BitSet(new long[]{0x0000000000002000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleInitialTransition8616 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleInitialTransition8637 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleInitialTransition8649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition8685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContinuationTransition8695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleContinuationTransition8730 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContinuationTransition8747 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleContinuationTransition8763 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition8784 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleContinuationTransition8794 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition8815 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleContinuationTransition8825 = new BitSet(new long[]{0x0000000000002000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleContinuationTransition8836 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleContinuationTransition8857 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleContinuationTransition8869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition8905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggeredTransition8915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleTriggeredTransition8950 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggeredTransition8967 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTriggeredTransition8983 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition9004 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleTriggeredTransition9014 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition9035 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleTriggeredTransition9045 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ruleTriggeredTransition9055 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleTriggeredTransition9065 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition9086 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleTriggeredTransition9097 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition9118 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_13_in_ruleTriggeredTransition9130 = new BitSet(new long[]{0x0000000000002000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleTriggeredTransition9141 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleTriggeredTransition9162 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTriggeredTransition9174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition9210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCPBranchTransition9220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleCPBranchTransition9255 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCPBranchTransition9272 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCPBranchTransition9288 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition9309 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleCPBranchTransition9319 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition9340 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleCPBranchTransition9350 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleCPBranchTransition9360 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition9381 = new BitSet(new long[]{0x0000000000002000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleCPBranchTransition9392 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition9413 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleCPBranchTransition9425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal9461 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionTerminal9471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal9518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal9545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal9572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal9599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal9634 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateTerminal9644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStateTerminal9686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal9721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPointTerminal9731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleTrPointTerminal9766 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTrPointTerminal9784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal9820 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal9830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal9873 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleSubStateTrPointTerminal9883 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal9901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal9937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicepointTerminal9947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleChoicepointTerminal9982 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicepointTerminal10000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrigger_in_entryRuleTrigger10036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrigger10046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleTrigger10081 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger10102 = new BitSet(new long[]{0x0000000000000000L,0x0000000000380000L});
    public static final BitSet FOLLOW_83_in_ruleTrigger10113 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger10134 = new BitSet(new long[]{0x0000000000000000L,0x0000000000380000L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleTrigger10157 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_ruleTrigger10168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf10204 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageFromIf10214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf10257 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleMessageFromIf10267 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf10285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard10321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard10331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleGuard10366 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuard10387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport10423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport10433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleImport10468 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_ruleImport10489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN10526 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN10537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN10584 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleImportedFQN10603 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_ruleImportedFQN10616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN10659 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN10670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN10710 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleFQN10729 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN10744 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_88_in_rulePrimitiveType10803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_rulePrimitiveType10818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_rulePrimitiveType10833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_rulePrimitiveType10848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_rulePrimitiveType10863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_rulePrimitiveType10878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_rulePrimitiveType10893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_rulePrimitiveType10908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_rulePrimitiveType10923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_rulePrimitiveType10938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_rulePrimitiveType10953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_rulePrimitiveType10968 = new BitSet(new long[]{0x0000000000000002L});

}