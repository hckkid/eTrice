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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:87:1: ruleRoomModel returns [EObject current=null] : ( 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_dataClasses_5_0= ruleDataClass ) ) | ( (lv_protocolClasses_6_0= ruleProtocolClass ) ) | ( (lv_actorClasses_7_0= ruleActorClass ) ) | ( (lv_subSystemClasses_8_0= ruleSubSystemClass ) ) | ( (lv_systems_9_0= ruleLogicalSystem ) ) )+ '}' ) ;
    public final EObject ruleRoomModel() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_docu_2_0 = null;

        EObject lv_imports_4_0 = null;

        EObject lv_dataClasses_5_0 = null;

        EObject lv_protocolClasses_6_0 = null;

        EObject lv_actorClasses_7_0 = null;

        EObject lv_subSystemClasses_8_0 = null;

        EObject lv_systems_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:92:6: ( ( 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_dataClasses_5_0= ruleDataClass ) ) | ( (lv_protocolClasses_6_0= ruleProtocolClass ) ) | ( (lv_actorClasses_7_0= ruleActorClass ) ) | ( (lv_subSystemClasses_8_0= ruleSubSystemClass ) ) | ( (lv_systems_9_0= ruleLogicalSystem ) ) )+ '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:93:1: ( 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_dataClasses_5_0= ruleDataClass ) ) | ( (lv_protocolClasses_6_0= ruleProtocolClass ) ) | ( (lv_actorClasses_7_0= ruleActorClass ) ) | ( (lv_subSystemClasses_8_0= ruleSubSystemClass ) ) | ( (lv_systems_9_0= ruleLogicalSystem ) ) )+ '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:93:1: ( 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_dataClasses_5_0= ruleDataClass ) ) | ( (lv_protocolClasses_6_0= ruleProtocolClass ) ) | ( (lv_actorClasses_7_0= ruleActorClass ) ) | ( (lv_subSystemClasses_8_0= ruleSubSystemClass ) ) | ( (lv_systems_9_0= ruleLogicalSystem ) ) )+ '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:93:3: 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_dataClasses_5_0= ruleDataClass ) ) | ( (lv_protocolClasses_6_0= ruleProtocolClass ) ) | ( (lv_actorClasses_7_0= ruleActorClass ) ) | ( (lv_subSystemClasses_8_0= ruleSubSystemClass ) ) | ( (lv_systems_9_0= ruleLogicalSystem ) ) )+ '}'
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:121:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==18) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:122:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:122:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:123:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getDocuDocumentationParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleRoomModel162);
                    lv_docu_2_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_2_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleRoomModel173); 

                    createLeafNode(grammarAccess.getRoomModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:149:1: ( (lv_imports_4_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==86) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:150:1: (lv_imports_4_0= ruleImport )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:150:1: (lv_imports_4_0= ruleImport )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:151:3: lv_imports_4_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getImportsImportParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleRoomModel194);
            	    lv_imports_4_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"imports",
            	    	        		lv_imports_4_0, 
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
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:173:3: ( ( (lv_dataClasses_5_0= ruleDataClass ) ) | ( (lv_protocolClasses_6_0= ruleProtocolClass ) ) | ( (lv_actorClasses_7_0= ruleActorClass ) ) | ( (lv_subSystemClasses_8_0= ruleSubSystemClass ) ) | ( (lv_systems_9_0= ruleLogicalSystem ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=6;
                switch ( input.LA(1) ) {
                case 15:
                    {
                    alt3=1;
                    }
                    break;
                case 24:
                    {
                    alt3=2;
                    }
                    break;
                case 39:
                case 40:
                    {
                    alt3=3;
                    }
                    break;
                case 53:
                    {
                    alt3=4;
                    }
                    break;
                case 51:
                    {
                    alt3=5;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:173:4: ( (lv_dataClasses_5_0= ruleDataClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:173:4: ( (lv_dataClasses_5_0= ruleDataClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:174:1: (lv_dataClasses_5_0= ruleDataClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:174:1: (lv_dataClasses_5_0= ruleDataClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:175:3: lv_dataClasses_5_0= ruleDataClass
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getDataClassesDataClassParserRuleCall_5_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleDataClass_in_ruleRoomModel217);
            	    lv_dataClasses_5_0=ruleDataClass();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"dataClasses",
            	    	        		lv_dataClasses_5_0, 
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:198:6: ( (lv_protocolClasses_6_0= ruleProtocolClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:198:6: ( (lv_protocolClasses_6_0= ruleProtocolClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:199:1: (lv_protocolClasses_6_0= ruleProtocolClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:199:1: (lv_protocolClasses_6_0= ruleProtocolClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:200:3: lv_protocolClasses_6_0= ruleProtocolClass
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getProtocolClassesProtocolClassParserRuleCall_5_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleProtocolClass_in_ruleRoomModel244);
            	    lv_protocolClasses_6_0=ruleProtocolClass();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"protocolClasses",
            	    	        		lv_protocolClasses_6_0, 
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:223:6: ( (lv_actorClasses_7_0= ruleActorClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:223:6: ( (lv_actorClasses_7_0= ruleActorClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:224:1: (lv_actorClasses_7_0= ruleActorClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:224:1: (lv_actorClasses_7_0= ruleActorClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:225:3: lv_actorClasses_7_0= ruleActorClass
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getActorClassesActorClassParserRuleCall_5_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorClass_in_ruleRoomModel271);
            	    lv_actorClasses_7_0=ruleActorClass();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"actorClasses",
            	    	        		lv_actorClasses_7_0, 
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:248:6: ( (lv_subSystemClasses_8_0= ruleSubSystemClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:248:6: ( (lv_subSystemClasses_8_0= ruleSubSystemClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:249:1: (lv_subSystemClasses_8_0= ruleSubSystemClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:249:1: (lv_subSystemClasses_8_0= ruleSubSystemClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:250:3: lv_subSystemClasses_8_0= ruleSubSystemClass
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getSubSystemClassesSubSystemClassParserRuleCall_5_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubSystemClass_in_ruleRoomModel298);
            	    lv_subSystemClasses_8_0=ruleSubSystemClass();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"subSystemClasses",
            	    	        		lv_subSystemClasses_8_0, 
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:273:6: ( (lv_systems_9_0= ruleLogicalSystem ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:273:6: ( (lv_systems_9_0= ruleLogicalSystem ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:274:1: (lv_systems_9_0= ruleLogicalSystem )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:274:1: (lv_systems_9_0= ruleLogicalSystem )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:275:3: lv_systems_9_0= ruleLogicalSystem
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRoomModelAccess().getSystemsLogicalSystemParserRuleCall_5_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLogicalSystem_in_ruleRoomModel325);
            	    lv_systems_9_0=ruleLogicalSystem();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRoomModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"systems",
            	    	        		lv_systems_9_0, 
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
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            match(input,13,FOLLOW_13_in_ruleRoomModel337); 

                    createLeafNode(grammarAccess.getRoomModelAccess().getRightCurlyBracketKeyword_6(), null); 
                

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:311:1: entryRuleStructureClass returns [EObject current=null] : iv_ruleStructureClass= ruleStructureClass EOF ;
    public final EObject entryRuleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructureClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:312:2: (iv_ruleStructureClass= ruleStructureClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:313:2: iv_ruleStructureClass= ruleStructureClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStructureClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleStructureClass_in_entryRuleStructureClass375);
            iv_ruleStructureClass=ruleStructureClass();
            _fsp--;

             current =iv_ruleStructureClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStructureClass385); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:320:1: ruleStructureClass returns [EObject current=null] : (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) ;
    public final EObject ruleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorContainerClass_0 = null;

        EObject this_LogicalSystem_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:325:6: ( (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:326:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:326:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=39 && LA4_0<=40)||LA4_0==53) ) {
                alt4=1;
            }
            else if ( (LA4_0==51) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("326:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:327:5: this_ActorContainerClass_0= ruleActorContainerClass
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStructureClassAccess().getActorContainerClassParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleActorContainerClass_in_ruleStructureClass432);
                    this_ActorContainerClass_0=ruleActorContainerClass();
                    _fsp--;

                     
                            current = this_ActorContainerClass_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:337:5: this_LogicalSystem_1= ruleLogicalSystem
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStructureClassAccess().getLogicalSystemParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLogicalSystem_in_ruleStructureClass459);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:353:1: entryRuleActorContainerClass returns [EObject current=null] : iv_ruleActorContainerClass= ruleActorContainerClass EOF ;
    public final EObject entryRuleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorContainerClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:354:2: (iv_ruleActorContainerClass= ruleActorContainerClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:355:2: iv_ruleActorContainerClass= ruleActorContainerClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActorContainerClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleActorContainerClass_in_entryRuleActorContainerClass494);
            iv_ruleActorContainerClass=ruleActorContainerClass();
            _fsp--;

             current =iv_ruleActorContainerClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorContainerClass504); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:362:1: ruleActorContainerClass returns [EObject current=null] : (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) ;
    public final EObject ruleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorClass_0 = null;

        EObject this_SubSystemClass_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:367:6: ( (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:368:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:368:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=39 && LA5_0<=40)) ) {
                alt5=1;
            }
            else if ( (LA5_0==53) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("368:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:369:5: this_ActorClass_0= ruleActorClass
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getActorContainerClassAccess().getActorClassParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleActorClass_in_ruleActorContainerClass551);
                    this_ActorClass_0=ruleActorClass();
                    _fsp--;

                     
                            current = this_ActorClass_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:379:5: this_SubSystemClass_1= ruleSubSystemClass
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getActorContainerClassAccess().getSubSystemClassParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSubSystemClass_in_ruleActorContainerClass578);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:395:1: entryRuleTypedID returns [EObject current=null] : iv_ruleTypedID= ruleTypedID EOF ;
    public final EObject entryRuleTypedID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedID = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:396:2: (iv_ruleTypedID= ruleTypedID EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:397:2: iv_ruleTypedID= ruleTypedID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypedIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypedID_in_entryRuleTypedID613);
            iv_ruleTypedID=ruleTypedID();
            _fsp--;

             current =iv_ruleTypedID; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypedID623); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:404:1: ruleTypedID returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleTypedID() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_type_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:409:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleType ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:410:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleType ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:410:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleType ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:410:2: ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleType ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:410:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:411:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:411:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:412:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypedID665); 

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

            match(input,14,FOLLOW_14_in_ruleTypedID680); 

                    createLeafNode(grammarAccess.getTypedIDAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:438:1: ( (lv_type_2_0= ruleType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:439:1: (lv_type_2_0= ruleType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:439:1: (lv_type_2_0= ruleType )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:440:3: lv_type_2_0= ruleType
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTypedIDAccess().getTypeTypeParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleTypedID701);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:470:1: entryRuleFreeTypedID returns [EObject current=null] : iv_ruleFreeTypedID= ruleFreeTypedID EOF ;
    public final EObject entryRuleFreeTypedID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreeTypedID = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:471:2: (iv_ruleFreeTypedID= ruleFreeTypedID EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:472:2: iv_ruleFreeTypedID= ruleFreeTypedID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFreeTypedIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleFreeTypedID_in_entryRuleFreeTypedID737);
            iv_ruleFreeTypedID=ruleFreeTypedID();
            _fsp--;

             current =iv_ruleFreeTypedID; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFreeTypedID747); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:479:1: ruleFreeTypedID returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleFreeType ) ) ) ;
    public final EObject ruleFreeTypedID() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_type_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:484:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleFreeType ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:485:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleFreeType ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:485:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleFreeType ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:485:2: ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleFreeType ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:485:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:486:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:486:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:487:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFreeTypedID789); 

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

            match(input,14,FOLLOW_14_in_ruleFreeTypedID804); 

                    createLeafNode(grammarAccess.getFreeTypedIDAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:513:1: ( (lv_type_2_0= ruleFreeType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:514:1: (lv_type_2_0= ruleFreeType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:514:1: (lv_type_2_0= ruleFreeType )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:515:3: lv_type_2_0= ruleFreeType
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFreeTypedIDAccess().getTypeFreeTypeParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFreeType_in_ruleFreeTypedID825);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:545:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:546:2: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:547:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType861);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType871); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:554:1: ruleType returns [EObject current=null] : ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( ( ruleFQN ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_prim_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:559:6: ( ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:560:1: ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:560:1: ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( ( ruleFQN ) ) )
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
                    new NoViableAltException("560:1: ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( ( ruleFQN ) ) )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:560:2: ( (lv_prim_0_0= rulePrimitiveType ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:560:2: ( (lv_prim_0_0= rulePrimitiveType ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:561:1: (lv_prim_0_0= rulePrimitiveType )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:561:1: (lv_prim_0_0= rulePrimitiveType )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:562:3: lv_prim_0_0= rulePrimitiveType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTypeAccess().getPrimPrimitiveTypeEnumRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimitiveType_in_ruleType917);
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
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:585:6: ( ( ruleFQN ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:585:6: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:586:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:586:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:587:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTypeAccess().getTypeDataClassCrossReference_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleType946);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:609:1: entryRuleFreeType returns [EObject current=null] : iv_ruleFreeType= ruleFreeType EOF ;
    public final EObject entryRuleFreeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreeType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:610:2: (iv_ruleFreeType= ruleFreeType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:611:2: iv_ruleFreeType= ruleFreeType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFreeTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleFreeType_in_entryRuleFreeType982);
            iv_ruleFreeType=ruleFreeType();
            _fsp--;

             current =iv_ruleFreeType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFreeType992); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:618:1: ruleFreeType returns [EObject current=null] : ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( (lv_type_1_0= RULE_ID ) ) ) ;
    public final EObject ruleFreeType() throws RecognitionException {
        EObject current = null;

        Token lv_type_1_0=null;
        Enumerator lv_prim_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:623:6: ( ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( (lv_type_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:624:1: ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( (lv_type_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:624:1: ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( (lv_type_1_0= RULE_ID ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=88 && LA7_0<=99)) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("624:1: ( ( (lv_prim_0_0= rulePrimitiveType ) ) | ( (lv_type_1_0= RULE_ID ) ) )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:624:2: ( (lv_prim_0_0= rulePrimitiveType ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:624:2: ( (lv_prim_0_0= rulePrimitiveType ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:625:1: (lv_prim_0_0= rulePrimitiveType )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:625:1: (lv_prim_0_0= rulePrimitiveType )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:626:3: lv_prim_0_0= rulePrimitiveType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFreeTypeAccess().getPrimPrimitiveTypeEnumRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimitiveType_in_ruleFreeType1038);
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
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:649:6: ( (lv_type_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:649:6: ( (lv_type_1_0= RULE_ID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:650:1: (lv_type_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:650:1: (lv_type_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:651:3: lv_type_1_0= RULE_ID
                    {
                    lv_type_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFreeType1061); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:681:1: entryRuleDataClass returns [EObject current=null] : iv_ruleDataClass= ruleDataClass EOF ;
    public final EObject entryRuleDataClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:682:2: (iv_ruleDataClass= ruleDataClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:683:2: iv_ruleDataClass= ruleDataClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataClass_in_entryRuleDataClass1102);
            iv_ruleDataClass=ruleDataClass();
            _fsp--;

             current =iv_ruleDataClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataClass1112); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:690:1: ruleDataClass returns [EObject current=null] : ( 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( (lv_imports_6_0= ruleImport ) )* ( (lv_attributes_7_0= ruleAttribute ) )+ ( (lv_operations_8_0= ruleOperation ) )* '}' ) ;
    public final EObject ruleDataClass() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;

        EObject lv_imports_6_0 = null;

        EObject lv_attributes_7_0 = null;

        EObject lv_operations_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:695:6: ( ( 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( (lv_imports_6_0= ruleImport ) )* ( (lv_attributes_7_0= ruleAttribute ) )+ ( (lv_operations_8_0= ruleOperation ) )* '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:696:1: ( 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( (lv_imports_6_0= ruleImport ) )* ( (lv_attributes_7_0= ruleAttribute ) )+ ( (lv_operations_8_0= ruleOperation ) )* '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:696:1: ( 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( (lv_imports_6_0= ruleImport ) )* ( (lv_attributes_7_0= ruleAttribute ) )+ ( (lv_operations_8_0= ruleOperation ) )* '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:696:3: 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( (lv_imports_6_0= ruleImport ) )* ( (lv_attributes_7_0= ruleAttribute ) )+ ( (lv_operations_8_0= ruleOperation ) )* '}'
            {
            match(input,15,FOLLOW_15_in_ruleDataClass1147); 

                    createLeafNode(grammarAccess.getDataClassAccess().getDataClassKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:700:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:701:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:701:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:702:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataClass1164); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:724:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:725:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:725:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:726:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDataClassAccess().getDocuDocumentationParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleDataClass1190);
                    lv_docu_2_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getDataClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_2_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:748:3: ( 'extends' ( ( ruleFQN ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:748:5: 'extends' ( ( ruleFQN ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleDataClass1202); 

                            createLeafNode(grammarAccess.getDataClassAccess().getExtendsKeyword_3_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:752:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:753:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:753:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:754:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getDataClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDataClassAccess().getBaseDataClassCrossReference_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleDataClass1225);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleDataClass1237); 

                    createLeafNode(grammarAccess.getDataClassAccess().getLeftCurlyBracketKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:772:1: ( (lv_imports_6_0= ruleImport ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==86) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:773:1: (lv_imports_6_0= ruleImport )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:773:1: (lv_imports_6_0= ruleImport )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:774:3: lv_imports_6_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getDataClassAccess().getImportsImportParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleDataClass1258);
            	    lv_imports_6_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getDataClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"imports",
            	    	        		lv_imports_6_0, 
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
            	    break loop10;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:796:3: ( (lv_attributes_7_0= ruleAttribute ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==17) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:797:1: (lv_attributes_7_0= ruleAttribute )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:797:1: (lv_attributes_7_0= ruleAttribute )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:798:3: lv_attributes_7_0= ruleAttribute
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getDataClassAccess().getAttributesAttributeParserRuleCall_6_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttribute_in_ruleDataClass1280);
            	    lv_attributes_7_0=ruleAttribute();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getDataClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"attributes",
            	    	        		lv_attributes_7_0, 
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:820:3: ( (lv_operations_8_0= ruleOperation ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==20) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:821:1: (lv_operations_8_0= ruleOperation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:821:1: (lv_operations_8_0= ruleOperation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:822:3: lv_operations_8_0= ruleOperation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getDataClassAccess().getOperationsOperationParserRuleCall_7_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleOperation_in_ruleDataClass1302);
            	    lv_operations_8_0=ruleOperation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getDataClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"operations",
            	    	        		lv_operations_8_0, 
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
            	    break loop12;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleDataClass1313); 

                    createLeafNode(grammarAccess.getDataClassAccess().getRightCurlyBracketKeyword_8(), null); 
                

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:856:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:857:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:858:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute1349);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute1359); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:865:1: ruleAttribute returns [EObject current=null] : ( 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( '[' ( (lv_size_3_0= RULE_INT ) ) ']' )? ':' ( (lv_type_6_0= ruleType ) ) ( (lv_docu_7_0= ruleDocumentation ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_size_3_0=null;
        EObject lv_type_6_0 = null;

        EObject lv_docu_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:870:6: ( ( 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( '[' ( (lv_size_3_0= RULE_INT ) ) ']' )? ':' ( (lv_type_6_0= ruleType ) ) ( (lv_docu_7_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:871:1: ( 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( '[' ( (lv_size_3_0= RULE_INT ) ) ']' )? ':' ( (lv_type_6_0= ruleType ) ) ( (lv_docu_7_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:871:1: ( 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( '[' ( (lv_size_3_0= RULE_INT ) ) ']' )? ':' ( (lv_type_6_0= ruleType ) ) ( (lv_docu_7_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:871:3: 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( '[' ( (lv_size_3_0= RULE_INT ) ) ']' )? ':' ( (lv_type_6_0= ruleType ) ) ( (lv_docu_7_0= ruleDocumentation ) )?
            {
            match(input,17,FOLLOW_17_in_ruleAttribute1394); 

                    createLeafNode(grammarAccess.getAttributeAccess().getAttributeKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:875:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:876:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:876:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:877:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute1411); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:899:2: ( '[' ( (lv_size_3_0= RULE_INT ) ) ']' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==18) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:899:4: '[' ( (lv_size_3_0= RULE_INT ) ) ']'
                    {
                    match(input,18,FOLLOW_18_in_ruleAttribute1427); 

                            createLeafNode(grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:903:1: ( (lv_size_3_0= RULE_INT ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:904:1: (lv_size_3_0= RULE_INT )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:904:1: (lv_size_3_0= RULE_INT )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:905:3: lv_size_3_0= RULE_INT
                    {
                    lv_size_3_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAttribute1444); 

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

                    match(input,19,FOLLOW_19_in_ruleAttribute1459); 

                            createLeafNode(grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            match(input,14,FOLLOW_14_in_ruleAttribute1471); 

                    createLeafNode(grammarAccess.getAttributeAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:935:1: ( (lv_type_6_0= ruleType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:936:1: (lv_type_6_0= ruleType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:936:1: (lv_type_6_0= ruleType )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:937:3: lv_type_6_0= ruleType
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAttributeAccess().getTypeTypeParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleAttribute1492);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:959:2: ( (lv_docu_7_0= ruleDocumentation ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:960:1: (lv_docu_7_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:960:1: (lv_docu_7_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:961:3: lv_docu_7_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getAttributeAccess().getDocuDocumentationParserRuleCall_5_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleAttribute1513);
                    lv_docu_7_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_7_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


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
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRuleOperation
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:991:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:992:2: (iv_ruleOperation= ruleOperation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:993:2: iv_ruleOperation= ruleOperation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperation_in_entryRuleOperation1550);
            iv_ruleOperation=ruleOperation();
            _fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperation1560); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1000:1: ruleOperation returns [EObject current=null] : ( 'Operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )* )? ')' ( ':' ( (lv_returntype_8_0= ruleFreeType ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ( (lv_detailCode_10_0= ruleDetailCode ) ) ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_returntype_8_0 = null;

        EObject lv_docu_9_0 = null;

        EObject lv_detailCode_10_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1005:6: ( ( 'Operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )* )? ')' ( ':' ( (lv_returntype_8_0= ruleFreeType ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ( (lv_detailCode_10_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1006:1: ( 'Operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )* )? ')' ( ':' ( (lv_returntype_8_0= ruleFreeType ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ( (lv_detailCode_10_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1006:1: ( 'Operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )* )? ')' ( ':' ( (lv_returntype_8_0= ruleFreeType ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ( (lv_detailCode_10_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1006:3: 'Operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )* )? ')' ( ':' ( (lv_returntype_8_0= ruleFreeType ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ( (lv_detailCode_10_0= ruleDetailCode ) )
            {
            match(input,20,FOLLOW_20_in_ruleOperation1595); 

                    createLeafNode(grammarAccess.getOperationAccess().getOperationKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1010:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1011:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1011:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1012:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperation1612); 

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

            match(input,21,FOLLOW_21_in_ruleOperation1627); 

                    createLeafNode(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1038:1: ( ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1038:2: ( (lv_arguments_3_0= ruleFreeTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )*
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1038:2: ( (lv_arguments_3_0= ruleFreeTypedID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1039:1: (lv_arguments_3_0= ruleFreeTypedID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1039:1: (lv_arguments_3_0= ruleFreeTypedID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1040:3: lv_arguments_3_0= ruleFreeTypedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getArgumentsFreeTypedIDParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFreeTypedID_in_ruleOperation1649);
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1062:2: ( ',' ( (lv_arguments_5_0= ruleFreeTypedID ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==22) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1062:4: ',' ( (lv_arguments_5_0= ruleFreeTypedID ) )
                    	    {
                    	    match(input,22,FOLLOW_22_in_ruleOperation1660); 

                    	            createLeafNode(grammarAccess.getOperationAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1066:1: ( (lv_arguments_5_0= ruleFreeTypedID ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1067:1: (lv_arguments_5_0= ruleFreeTypedID )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1067:1: (lv_arguments_5_0= ruleFreeTypedID )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1068:3: lv_arguments_5_0= ruleFreeTypedID
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getArgumentsFreeTypedIDParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFreeTypedID_in_ruleOperation1681);
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
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,23,FOLLOW_23_in_ruleOperation1695); 

                    createLeafNode(grammarAccess.getOperationAccess().getRightParenthesisKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1094:1: ( ':' ( (lv_returntype_8_0= ruleFreeType ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1094:3: ':' ( (lv_returntype_8_0= ruleFreeType ) )
                    {
                    match(input,14,FOLLOW_14_in_ruleOperation1706); 

                            createLeafNode(grammarAccess.getOperationAccess().getColonKeyword_5_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1098:1: ( (lv_returntype_8_0= ruleFreeType ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1099:1: (lv_returntype_8_0= ruleFreeType )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1099:1: (lv_returntype_8_0= ruleFreeType )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1100:3: lv_returntype_8_0= ruleFreeType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getReturntypeFreeTypeParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFreeType_in_ruleOperation1727);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1122:4: ( (lv_docu_9_0= ruleDocumentation ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==18) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1123:1: (lv_docu_9_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1123:1: (lv_docu_9_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1124:3: lv_docu_9_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getDocuDocumentationParserRuleCall_6_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleOperation1750);
                    lv_docu_9_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_9_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1146:3: ( (lv_detailCode_10_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1147:1: (lv_detailCode_10_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1147:1: (lv_detailCode_10_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1148:3: lv_detailCode_10_0= ruleDetailCode
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getDetailCodeDetailCodeParserRuleCall_7_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleOperation1772);
            lv_detailCode_10_0=ruleDetailCode();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"detailCode",
            	        		lv_detailCode_10_0, 
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1178:1: entryRuleProtocolClass returns [EObject current=null] : iv_ruleProtocolClass= ruleProtocolClass EOF ;
    public final EObject entryRuleProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1179:2: (iv_ruleProtocolClass= ruleProtocolClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1180:2: iv_ruleProtocolClass= ruleProtocolClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getProtocolClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleProtocolClass_in_entryRuleProtocolClass1808);
            iv_ruleProtocolClass=ruleProtocolClass();
            _fsp--;

             current =iv_ruleProtocolClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolClass1818); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1187:1: ruleProtocolClass returns [EObject current=null] : ( 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? 'incoming' '{' ( (lv_incomingMessages_12_0= ruleMessage ) )* '}' 'outgoing' '{' ( (lv_outgoingMessages_16_0= ruleMessage ) )* '}' ( 'regular' 'PortClass' ( (lv_regular_20_0= rulePortClass ) ) )? ( 'conjugate' 'PortClass' ( (lv_conjugate_23_0= rulePortClass ) ) )? ( (lv_semantics_24_0= ruleProtocolSemantics ) )? '}' ) ;
    public final EObject ruleProtocolClass() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;

        EObject lv_userCode1_7_0 = null;

        EObject lv_userCode2_9_0 = null;

        EObject lv_incomingMessages_12_0 = null;

        EObject lv_outgoingMessages_16_0 = null;

        EObject lv_regular_20_0 = null;

        EObject lv_conjugate_23_0 = null;

        EObject lv_semantics_24_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1192:6: ( ( 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? 'incoming' '{' ( (lv_incomingMessages_12_0= ruleMessage ) )* '}' 'outgoing' '{' ( (lv_outgoingMessages_16_0= ruleMessage ) )* '}' ( 'regular' 'PortClass' ( (lv_regular_20_0= rulePortClass ) ) )? ( 'conjugate' 'PortClass' ( (lv_conjugate_23_0= rulePortClass ) ) )? ( (lv_semantics_24_0= ruleProtocolSemantics ) )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1193:1: ( 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? 'incoming' '{' ( (lv_incomingMessages_12_0= ruleMessage ) )* '}' 'outgoing' '{' ( (lv_outgoingMessages_16_0= ruleMessage ) )* '}' ( 'regular' 'PortClass' ( (lv_regular_20_0= rulePortClass ) ) )? ( 'conjugate' 'PortClass' ( (lv_conjugate_23_0= rulePortClass ) ) )? ( (lv_semantics_24_0= ruleProtocolSemantics ) )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1193:1: ( 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? 'incoming' '{' ( (lv_incomingMessages_12_0= ruleMessage ) )* '}' 'outgoing' '{' ( (lv_outgoingMessages_16_0= ruleMessage ) )* '}' ( 'regular' 'PortClass' ( (lv_regular_20_0= rulePortClass ) ) )? ( 'conjugate' 'PortClass' ( (lv_conjugate_23_0= rulePortClass ) ) )? ( (lv_semantics_24_0= ruleProtocolSemantics ) )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1193:3: 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? 'incoming' '{' ( (lv_incomingMessages_12_0= ruleMessage ) )* '}' 'outgoing' '{' ( (lv_outgoingMessages_16_0= ruleMessage ) )* '}' ( 'regular' 'PortClass' ( (lv_regular_20_0= rulePortClass ) ) )? ( 'conjugate' 'PortClass' ( (lv_conjugate_23_0= rulePortClass ) ) )? ( (lv_semantics_24_0= ruleProtocolSemantics ) )? '}'
            {
            match(input,24,FOLLOW_24_in_ruleProtocolClass1853); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getProtocolClassKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1197:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1198:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1198:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1199:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProtocolClass1870); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1221:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==18) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1222:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1222:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1223:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getDocuDocumentationParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleProtocolClass1896);
                    lv_docu_2_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_2_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1245:3: ( 'extends' ( ( ruleFQN ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==16) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1245:5: 'extends' ( ( ruleFQN ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleProtocolClass1908); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getExtendsKeyword_3_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1249:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1250:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1250:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1251:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getBaseProtocolClassCrossReference_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleProtocolClass1931);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleProtocolClass1943); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1269:1: ( 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==25) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1269:3: 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) )
                    {
                    match(input,25,FOLLOW_25_in_ruleProtocolClass1954); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getUsercode1Keyword_5_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1273:1: ( (lv_userCode1_7_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1274:1: (lv_userCode1_7_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1274:1: (lv_userCode1_7_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1275:3: lv_userCode1_7_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode1DetailCodeParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleProtocolClass1975);
                    lv_userCode1_7_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"userCode1",
                    	        		lv_userCode1_7_0, 
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1297:4: ( 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==26) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1297:6: 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) )
                    {
                    match(input,26,FOLLOW_26_in_ruleProtocolClass1988); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getUsercode2Keyword_6_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1301:1: ( (lv_userCode2_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1302:1: (lv_userCode2_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1302:1: (lv_userCode2_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1303:3: lv_userCode2_9_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode2DetailCodeParserRuleCall_6_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleProtocolClass2009);
                    lv_userCode2_9_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"userCode2",
                    	        		lv_userCode2_9_0, 
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

            match(input,27,FOLLOW_27_in_ruleProtocolClass2021); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getIncomingKeyword_7(), null); 
                
            match(input,12,FOLLOW_12_in_ruleProtocolClass2031); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_8(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1333:1: ( (lv_incomingMessages_12_0= ruleMessage ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==32) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1334:1: (lv_incomingMessages_12_0= ruleMessage )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1334:1: (lv_incomingMessages_12_0= ruleMessage )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1335:3: lv_incomingMessages_12_0= ruleMessage
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getIncomingMessagesMessageParserRuleCall_9_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessage_in_ruleProtocolClass2052);
            	    lv_incomingMessages_12_0=ruleMessage();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"incomingMessages",
            	    	        		lv_incomingMessages_12_0, 
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
            	    break loop23;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleProtocolClass2063); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_10(), null); 
                
            match(input,28,FOLLOW_28_in_ruleProtocolClass2073); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getOutgoingKeyword_11(), null); 
                
            match(input,12,FOLLOW_12_in_ruleProtocolClass2083); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_12(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1369:1: ( (lv_outgoingMessages_16_0= ruleMessage ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==32) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1370:1: (lv_outgoingMessages_16_0= ruleMessage )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1370:1: (lv_outgoingMessages_16_0= ruleMessage )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1371:3: lv_outgoingMessages_16_0= ruleMessage
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getOutgoingMessagesMessageParserRuleCall_13_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessage_in_ruleProtocolClass2104);
            	    lv_outgoingMessages_16_0=ruleMessage();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"outgoingMessages",
            	    	        		lv_outgoingMessages_16_0, 
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
            	    break loop24;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleProtocolClass2115); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_14(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1397:1: ( 'regular' 'PortClass' ( (lv_regular_20_0= rulePortClass ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==29) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1397:3: 'regular' 'PortClass' ( (lv_regular_20_0= rulePortClass ) )
                    {
                    match(input,29,FOLLOW_29_in_ruleProtocolClass2126); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getRegularKeyword_15_0(), null); 
                        
                    match(input,30,FOLLOW_30_in_ruleProtocolClass2136); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getPortClassKeyword_15_1(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1405:1: ( (lv_regular_20_0= rulePortClass ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1406:1: (lv_regular_20_0= rulePortClass )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1406:1: (lv_regular_20_0= rulePortClass )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1407:3: lv_regular_20_0= rulePortClass
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getRegularPortClassParserRuleCall_15_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePortClass_in_ruleProtocolClass2157);
                    lv_regular_20_0=rulePortClass();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"regular",
                    	        		lv_regular_20_0, 
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1429:4: ( 'conjugate' 'PortClass' ( (lv_conjugate_23_0= rulePortClass ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==31) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1429:6: 'conjugate' 'PortClass' ( (lv_conjugate_23_0= rulePortClass ) )
                    {
                    match(input,31,FOLLOW_31_in_ruleProtocolClass2170); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getConjugateKeyword_16_0(), null); 
                        
                    match(input,30,FOLLOW_30_in_ruleProtocolClass2180); 

                            createLeafNode(grammarAccess.getProtocolClassAccess().getPortClassKeyword_16_1(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1437:1: ( (lv_conjugate_23_0= rulePortClass ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1438:1: (lv_conjugate_23_0= rulePortClass )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1438:1: (lv_conjugate_23_0= rulePortClass )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1439:3: lv_conjugate_23_0= rulePortClass
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getConjugatePortClassParserRuleCall_16_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePortClass_in_ruleProtocolClass2201);
                    lv_conjugate_23_0=rulePortClass();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"conjugate",
                    	        		lv_conjugate_23_0, 
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1461:4: ( (lv_semantics_24_0= ruleProtocolSemantics ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==35) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1462:1: (lv_semantics_24_0= ruleProtocolSemantics )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1462:1: (lv_semantics_24_0= ruleProtocolSemantics )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1463:3: lv_semantics_24_0= ruleProtocolSemantics
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getProtocolClassAccess().getSemanticsProtocolSemanticsParserRuleCall_17_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleProtocolSemantics_in_ruleProtocolClass2224);
                    lv_semantics_24_0=ruleProtocolSemantics();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getProtocolClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"semantics",
                    	        		lv_semantics_24_0, 
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

            match(input,13,FOLLOW_13_in_ruleProtocolClass2235); 

                    createLeafNode(grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_18(), null); 
                

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1497:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1498:2: (iv_ruleMessage= ruleMessage EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1499:2: iv_ruleMessage= ruleMessage EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMessageRule(), currentNode); 
            pushFollow(FOLLOW_ruleMessage_in_entryRuleMessage2271);
            iv_ruleMessage=ruleMessage();
            _fsp--;

             current =iv_ruleMessage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessage2281); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1506:1: ruleMessage returns [EObject current=null] : ( 'Message' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )* )? ')' ( (lv_docu_7_0= ruleDocumentation ) )? ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_docu_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1511:6: ( ( 'Message' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )* )? ')' ( (lv_docu_7_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1512:1: ( 'Message' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )* )? ')' ( (lv_docu_7_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1512:1: ( 'Message' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )* )? ')' ( (lv_docu_7_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1512:3: 'Message' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )* )? ')' ( (lv_docu_7_0= ruleDocumentation ) )?
            {
            match(input,32,FOLLOW_32_in_ruleMessage2316); 

                    createLeafNode(grammarAccess.getMessageAccess().getMessageKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1516:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1517:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1517:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1518:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessage2333); 

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

            match(input,21,FOLLOW_21_in_ruleMessage2348); 

                    createLeafNode(grammarAccess.getMessageAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1544:1: ( ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1544:2: ( (lv_arguments_3_0= ruleTypedID ) ) ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )*
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1544:2: ( (lv_arguments_3_0= ruleTypedID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1545:1: (lv_arguments_3_0= ruleTypedID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1545:1: (lv_arguments_3_0= ruleTypedID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1546:3: lv_arguments_3_0= ruleTypedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMessageAccess().getArgumentsTypedIDParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypedID_in_ruleMessage2370);
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1568:2: ( ',' ( (lv_arguments_5_0= ruleTypedID ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==22) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1568:4: ',' ( (lv_arguments_5_0= ruleTypedID ) )
                    	    {
                    	    match(input,22,FOLLOW_22_in_ruleMessage2381); 

                    	            createLeafNode(grammarAccess.getMessageAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1572:1: ( (lv_arguments_5_0= ruleTypedID ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1573:1: (lv_arguments_5_0= ruleTypedID )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1573:1: (lv_arguments_5_0= ruleTypedID )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1574:3: lv_arguments_5_0= ruleTypedID
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMessageAccess().getArgumentsTypedIDParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTypedID_in_ruleMessage2402);
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
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,23,FOLLOW_23_in_ruleMessage2416); 

                    createLeafNode(grammarAccess.getMessageAccess().getRightParenthesisKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1600:1: ( (lv_docu_7_0= ruleDocumentation ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==18) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1601:1: (lv_docu_7_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1601:1: (lv_docu_7_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1602:3: lv_docu_7_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMessageAccess().getDocuDocumentationParserRuleCall_5_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleMessage2437);
                    lv_docu_7_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMessageRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_7_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


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
    // $ANTLR end ruleMessage


    // $ANTLR start entryRulePortClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1632:1: entryRulePortClass returns [EObject current=null] : iv_rulePortClass= rulePortClass EOF ;
    public final EObject entryRulePortClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1633:2: (iv_rulePortClass= rulePortClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1634:2: iv_rulePortClass= rulePortClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPortClassRule(), currentNode); 
            pushFollow(FOLLOW_rulePortClass_in_entryRulePortClass2474);
            iv_rulePortClass=rulePortClass();
            _fsp--;

             current =iv_rulePortClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortClass2484); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1641:1: rulePortClass returns [EObject current=null] : ( '{' ( 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= ruleOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ '}' ) ;
    public final EObject rulePortClass() throws RecognitionException {
        EObject current = null;

        EObject lv_userCode_2_0 = null;

        EObject lv_attributes_3_0 = null;

        EObject lv_operations_4_0 = null;

        EObject lv_msgHandlers_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1646:6: ( ( '{' ( 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= ruleOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1647:1: ( '{' ( 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= ruleOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1647:1: ( '{' ( 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= ruleOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1647:3: '{' ( 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= ruleOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ '}'
            {
            match(input,12,FOLLOW_12_in_rulePortClass2519); 

                    createLeafNode(grammarAccess.getPortClassAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1651:1: ( 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1651:3: 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) )
                    {
                    match(input,33,FOLLOW_33_in_rulePortClass2530); 

                            createLeafNode(grammarAccess.getPortClassAccess().getUsercodeKeyword_1_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1655:1: ( (lv_userCode_2_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1656:1: (lv_userCode_2_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1656:1: (lv_userCode_2_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1657:3: lv_userCode_2_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPortClassAccess().getUserCodeDetailCodeParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_rulePortClass2551);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1679:4: ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= ruleOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+
            int cnt32=0;
            loop32:
            do {
                int alt32=4;
                switch ( input.LA(1) ) {
                case 17:
                    {
                    alt32=1;
                    }
                    break;
                case 20:
                    {
                    alt32=2;
                    }
                    break;
                case 34:
                    {
                    alt32=3;
                    }
                    break;

                }

                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1679:5: ( (lv_attributes_3_0= ruleAttribute ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1679:5: ( (lv_attributes_3_0= ruleAttribute ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1680:1: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1680:1: (lv_attributes_3_0= ruleAttribute )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1681:3: lv_attributes_3_0= ruleAttribute
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getPortClassAccess().getAttributesAttributeParserRuleCall_2_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttribute_in_rulePortClass2575);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1704:6: ( (lv_operations_4_0= ruleOperation ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1704:6: ( (lv_operations_4_0= ruleOperation ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1705:1: (lv_operations_4_0= ruleOperation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1705:1: (lv_operations_4_0= ruleOperation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1706:3: lv_operations_4_0= ruleOperation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getPortClassAccess().getOperationsOperationParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleOperation_in_rulePortClass2602);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1729:6: ( (lv_msgHandlers_5_0= ruleMessageHandler ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1729:6: ( (lv_msgHandlers_5_0= ruleMessageHandler ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1730:1: (lv_msgHandlers_5_0= ruleMessageHandler )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1730:1: (lv_msgHandlers_5_0= ruleMessageHandler )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1731:3: lv_msgHandlers_5_0= ruleMessageHandler
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getPortClassAccess().getMsgHandlersMessageHandlerParserRuleCall_2_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessageHandler_in_rulePortClass2629);
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
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            match(input,13,FOLLOW_13_in_rulePortClass2641); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1765:1: entryRuleMessageHandler returns [EObject current=null] : iv_ruleMessageHandler= ruleMessageHandler EOF ;
    public final EObject entryRuleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageHandler = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1766:2: (iv_ruleMessageHandler= ruleMessageHandler EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1767:2: iv_ruleMessageHandler= ruleMessageHandler EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMessageHandlerRule(), currentNode); 
            pushFollow(FOLLOW_ruleMessageHandler_in_entryRuleMessageHandler2677);
            iv_ruleMessageHandler=ruleMessageHandler();
            _fsp--;

             current =iv_ruleMessageHandler; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessageHandler2687); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1774:1: ruleMessageHandler returns [EObject current=null] : ( 'handle' ( ( RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) ) ;
    public final EObject ruleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject lv_detailCode_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1779:6: ( ( 'handle' ( ( RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1780:1: ( 'handle' ( ( RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1780:1: ( 'handle' ( ( RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1780:3: 'handle' ( ( RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) )
            {
            match(input,34,FOLLOW_34_in_ruleMessageHandler2722); 

                    createLeafNode(grammarAccess.getMessageHandlerAccess().getHandleKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1784:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1785:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1785:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1786:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getMessageHandlerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageHandler2740); 

            		createLeafNode(grammarAccess.getMessageHandlerAccess().getMsgMessageCrossReference_1_0(), "msg"); 
            	

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1798:2: ( (lv_detailCode_2_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1799:1: (lv_detailCode_2_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1799:1: (lv_detailCode_2_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1800:3: lv_detailCode_2_0= ruleDetailCode
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMessageHandlerAccess().getDetailCodeDetailCodeParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleMessageHandler2761);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1830:1: entryRuleProtocolSemantics returns [EObject current=null] : iv_ruleProtocolSemantics= ruleProtocolSemantics EOF ;
    public final EObject entryRuleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSemantics = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1831:2: (iv_ruleProtocolSemantics= ruleProtocolSemantics EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1832:2: iv_ruleProtocolSemantics= ruleProtocolSemantics EOF
            {
             currentNode = createCompositeNode(grammarAccess.getProtocolSemanticsRule(), currentNode); 
            pushFollow(FOLLOW_ruleProtocolSemantics_in_entryRuleProtocolSemantics2797);
            iv_ruleProtocolSemantics=ruleProtocolSemantics();
            _fsp--;

             current =iv_ruleProtocolSemantics; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolSemantics2807); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1839:1: ruleProtocolSemantics returns [EObject current=null] : ( 'semantics' '{' ( (lv_rules_2_0= ruleSemanticsRule ) )+ '}' ) ;
    public final EObject ruleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        EObject lv_rules_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1844:6: ( ( 'semantics' '{' ( (lv_rules_2_0= ruleSemanticsRule ) )+ '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1845:1: ( 'semantics' '{' ( (lv_rules_2_0= ruleSemanticsRule ) )+ '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1845:1: ( 'semantics' '{' ( (lv_rules_2_0= ruleSemanticsRule ) )+ '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1845:3: 'semantics' '{' ( (lv_rules_2_0= ruleSemanticsRule ) )+ '}'
            {
            match(input,35,FOLLOW_35_in_ruleProtocolSemantics2842); 

                    createLeafNode(grammarAccess.getProtocolSemanticsAccess().getSemanticsKeyword_0(), null); 
                
            match(input,12,FOLLOW_12_in_ruleProtocolSemantics2852); 

                    createLeafNode(grammarAccess.getProtocolSemanticsAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1853:1: ( (lv_rules_2_0= ruleSemanticsRule ) )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==36||LA33_0==38) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1854:1: (lv_rules_2_0= ruleSemanticsRule )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1854:1: (lv_rules_2_0= ruleSemanticsRule )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1855:3: lv_rules_2_0= ruleSemanticsRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getProtocolSemanticsAccess().getRulesSemanticsRuleParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleProtocolSemantics2873);
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
            	    if ( cnt33 >= 1 ) break loop33;
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);

            match(input,13,FOLLOW_13_in_ruleProtocolSemantics2884); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1889:1: entryRuleSemanticsRule returns [EObject current=null] : iv_ruleSemanticsRule= ruleSemanticsRule EOF ;
    public final EObject entryRuleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsRule = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1890:2: (iv_ruleSemanticsRule= ruleSemanticsRule EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1891:2: iv_ruleSemanticsRule= ruleSemanticsRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSemanticsRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleSemanticsRule_in_entryRuleSemanticsRule2920);
            iv_ruleSemanticsRule=ruleSemanticsRule();
            _fsp--;

             current =iv_ruleSemanticsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSemanticsRule2930); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1898:1: ruleSemanticsRule returns [EObject current=null] : (this_SemanticsInRule_0= ruleSemanticsInRule | this_SemanticsOutRule_1= ruleSemanticsOutRule ) ;
    public final EObject ruleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject this_SemanticsInRule_0 = null;

        EObject this_SemanticsOutRule_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1903:6: ( (this_SemanticsInRule_0= ruleSemanticsInRule | this_SemanticsOutRule_1= ruleSemanticsOutRule ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1904:1: (this_SemanticsInRule_0= ruleSemanticsInRule | this_SemanticsOutRule_1= ruleSemanticsOutRule )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1904:1: (this_SemanticsInRule_0= ruleSemanticsInRule | this_SemanticsOutRule_1= ruleSemanticsOutRule )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==36) ) {
                alt34=1;
            }
            else if ( (LA34_0==38) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1904:1: (this_SemanticsInRule_0= ruleSemanticsInRule | this_SemanticsOutRule_1= ruleSemanticsOutRule )", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1905:5: this_SemanticsInRule_0= ruleSemanticsInRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSemanticsRuleAccess().getSemanticsInRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSemanticsInRule_in_ruleSemanticsRule2977);
                    this_SemanticsInRule_0=ruleSemanticsInRule();
                    _fsp--;

                     
                            current = this_SemanticsInRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1915:5: this_SemanticsOutRule_1= ruleSemanticsOutRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSemanticsRuleAccess().getSemanticsOutRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSemanticsOutRule_in_ruleSemanticsRule3004);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1931:1: entryRuleSemanticsInRule returns [EObject current=null] : iv_ruleSemanticsInRule= ruleSemanticsInRule EOF ;
    public final EObject entryRuleSemanticsInRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsInRule = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1932:2: (iv_ruleSemanticsInRule= ruleSemanticsInRule EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1933:2: iv_ruleSemanticsInRule= ruleSemanticsInRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSemanticsInRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleSemanticsInRule_in_entryRuleSemanticsInRule3039);
            iv_ruleSemanticsInRule=ruleSemanticsInRule();
            _fsp--;

             current =iv_ruleSemanticsInRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSemanticsInRule3049); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1940:1: ruleSemanticsInRule returns [EObject current=null] : ( 'in' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' ) ;
    public final EObject ruleSemanticsInRule() throws RecognitionException {
        EObject current = null;

        EObject lv_followUps_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1945:6: ( ( 'in' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1946:1: ( 'in' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1946:1: ( 'in' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1946:3: 'in' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}'
            {
            match(input,36,FOLLOW_36_in_ruleSemanticsInRule3084); 

                    createLeafNode(grammarAccess.getSemanticsInRuleAccess().getInKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1950:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1951:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1951:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1952:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSemanticsInRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSemanticsInRule3102); 

            		createLeafNode(grammarAccess.getSemanticsInRuleAccess().getMsgMessageCrossReference_1_0(), "msg"); 
            	

            }


            }

            match(input,37,FOLLOW_37_in_ruleSemanticsInRule3112); 

                    createLeafNode(grammarAccess.getSemanticsInRuleAccess().getHyphenMinusGreaterThanSignKeyword_2(), null); 
                
            match(input,12,FOLLOW_12_in_ruleSemanticsInRule3122); 

                    createLeafNode(grammarAccess.getSemanticsInRuleAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1972:1: ( (lv_followUps_4_0= ruleSemanticsRule ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==36||LA35_0==38) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1973:1: (lv_followUps_4_0= ruleSemanticsRule )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1973:1: (lv_followUps_4_0= ruleSemanticsRule )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1974:3: lv_followUps_4_0= ruleSemanticsRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSemanticsInRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleSemanticsInRule3143);
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
            	    break loop35;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleSemanticsInRule3154); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2008:1: entryRuleSemanticsOutRule returns [EObject current=null] : iv_ruleSemanticsOutRule= ruleSemanticsOutRule EOF ;
    public final EObject entryRuleSemanticsOutRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsOutRule = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2009:2: (iv_ruleSemanticsOutRule= ruleSemanticsOutRule EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2010:2: iv_ruleSemanticsOutRule= ruleSemanticsOutRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSemanticsOutRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleSemanticsOutRule_in_entryRuleSemanticsOutRule3190);
            iv_ruleSemanticsOutRule=ruleSemanticsOutRule();
            _fsp--;

             current =iv_ruleSemanticsOutRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSemanticsOutRule3200); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2017:1: ruleSemanticsOutRule returns [EObject current=null] : ( 'out' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' ) ;
    public final EObject ruleSemanticsOutRule() throws RecognitionException {
        EObject current = null;

        EObject lv_followUps_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2022:6: ( ( 'out' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2023:1: ( 'out' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2023:1: ( 'out' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2023:3: 'out' ( ( RULE_ID ) ) '->' '{' ( (lv_followUps_4_0= ruleSemanticsRule ) )* '}'
            {
            match(input,38,FOLLOW_38_in_ruleSemanticsOutRule3235); 

                    createLeafNode(grammarAccess.getSemanticsOutRuleAccess().getOutKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2027:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2028:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2028:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2029:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSemanticsOutRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSemanticsOutRule3253); 

            		createLeafNode(grammarAccess.getSemanticsOutRuleAccess().getMsgMessageCrossReference_1_0(), "msg"); 
            	

            }


            }

            match(input,37,FOLLOW_37_in_ruleSemanticsOutRule3263); 

                    createLeafNode(grammarAccess.getSemanticsOutRuleAccess().getHyphenMinusGreaterThanSignKeyword_2(), null); 
                
            match(input,12,FOLLOW_12_in_ruleSemanticsOutRule3273); 

                    createLeafNode(grammarAccess.getSemanticsOutRuleAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2049:1: ( (lv_followUps_4_0= ruleSemanticsRule ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==36||LA36_0==38) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2050:1: (lv_followUps_4_0= ruleSemanticsRule )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2050:1: (lv_followUps_4_0= ruleSemanticsRule )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2051:3: lv_followUps_4_0= ruleSemanticsRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSemanticsOutRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleSemanticsOutRule3294);
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
            	    break loop36;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleSemanticsOutRule3305); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2085:1: entryRuleActorClass returns [EObject current=null] : iv_ruleActorClass= ruleActorClass EOF ;
    public final EObject entryRuleActorClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2086:2: (iv_ruleActorClass= ruleActorClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2087:2: iv_ruleActorClass= ruleActorClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActorClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleActorClass_in_entryRuleActorClass3341);
            iv_ruleActorClass=ruleActorClass();
            _fsp--;

             current =iv_ruleActorClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorClass3351); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2094:1: ruleActorClass returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'Interface' '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* '}' )? ( 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? '{' ( 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_19_0= rulePort ) ) | ( (lv_extPorts_20_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_21_0= ruleServiceImplementation ) )* ( (lv_strSAPs_22_0= ruleSAPRef ) )* ( (lv_attributes_23_0= ruleAttribute ) )* ( (lv_actorRefs_24_0= ruleActorRef ) )* ( (lv_bindings_25_0= ruleBinding ) )* ( (lv_connections_26_0= ruleLayerConnection ) )* '}' )? ( 'Behavior' ( (lv_behaviorDocu_29_0= ruleDocumentation ) )? '{' ( (lv_operations_31_0= ruleOperation ) )* ( (lv_stateMachine_32_0= ruleStateMachine ) )? '}' )? '}' ) ;
    public final EObject ruleActorClass() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token lv_name_2_0=null;
        EObject lv_docu_3_0 = null;

        EObject lv_ifPorts_9_0 = null;

        EObject lv_ifSPPs_10_0 = null;

        EObject lv_structureDocu_13_0 = null;

        EObject lv_userCode1_16_0 = null;

        EObject lv_userCode2_18_0 = null;

        EObject lv_intPorts_19_0 = null;

        EObject lv_extPorts_20_0 = null;

        EObject lv_serviceImplementations_21_0 = null;

        EObject lv_strSAPs_22_0 = null;

        EObject lv_attributes_23_0 = null;

        EObject lv_actorRefs_24_0 = null;

        EObject lv_bindings_25_0 = null;

        EObject lv_connections_26_0 = null;

        EObject lv_behaviorDocu_29_0 = null;

        EObject lv_operations_31_0 = null;

        EObject lv_stateMachine_32_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2099:6: ( ( ( (lv_abstract_0_0= 'abstract' ) )? 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'Interface' '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* '}' )? ( 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? '{' ( 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_19_0= rulePort ) ) | ( (lv_extPorts_20_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_21_0= ruleServiceImplementation ) )* ( (lv_strSAPs_22_0= ruleSAPRef ) )* ( (lv_attributes_23_0= ruleAttribute ) )* ( (lv_actorRefs_24_0= ruleActorRef ) )* ( (lv_bindings_25_0= ruleBinding ) )* ( (lv_connections_26_0= ruleLayerConnection ) )* '}' )? ( 'Behavior' ( (lv_behaviorDocu_29_0= ruleDocumentation ) )? '{' ( (lv_operations_31_0= ruleOperation ) )* ( (lv_stateMachine_32_0= ruleStateMachine ) )? '}' )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2100:1: ( ( (lv_abstract_0_0= 'abstract' ) )? 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'Interface' '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* '}' )? ( 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? '{' ( 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_19_0= rulePort ) ) | ( (lv_extPorts_20_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_21_0= ruleServiceImplementation ) )* ( (lv_strSAPs_22_0= ruleSAPRef ) )* ( (lv_attributes_23_0= ruleAttribute ) )* ( (lv_actorRefs_24_0= ruleActorRef ) )* ( (lv_bindings_25_0= ruleBinding ) )* ( (lv_connections_26_0= ruleLayerConnection ) )* '}' )? ( 'Behavior' ( (lv_behaviorDocu_29_0= ruleDocumentation ) )? '{' ( (lv_operations_31_0= ruleOperation ) )* ( (lv_stateMachine_32_0= ruleStateMachine ) )? '}' )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2100:1: ( ( (lv_abstract_0_0= 'abstract' ) )? 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'Interface' '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* '}' )? ( 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? '{' ( 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_19_0= rulePort ) ) | ( (lv_extPorts_20_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_21_0= ruleServiceImplementation ) )* ( (lv_strSAPs_22_0= ruleSAPRef ) )* ( (lv_attributes_23_0= ruleAttribute ) )* ( (lv_actorRefs_24_0= ruleActorRef ) )* ( (lv_bindings_25_0= ruleBinding ) )* ( (lv_connections_26_0= ruleLayerConnection ) )* '}' )? ( 'Behavior' ( (lv_behaviorDocu_29_0= ruleDocumentation ) )? '{' ( (lv_operations_31_0= ruleOperation ) )* ( (lv_stateMachine_32_0= ruleStateMachine ) )? '}' )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2100:2: ( (lv_abstract_0_0= 'abstract' ) )? 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? ( 'extends' ( ( ruleFQN ) ) )? '{' ( 'Interface' '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* '}' )? ( 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? '{' ( 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_19_0= rulePort ) ) | ( (lv_extPorts_20_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_21_0= ruleServiceImplementation ) )* ( (lv_strSAPs_22_0= ruleSAPRef ) )* ( (lv_attributes_23_0= ruleAttribute ) )* ( (lv_actorRefs_24_0= ruleActorRef ) )* ( (lv_bindings_25_0= ruleBinding ) )* ( (lv_connections_26_0= ruleLayerConnection ) )* '}' )? ( 'Behavior' ( (lv_behaviorDocu_29_0= ruleDocumentation ) )? '{' ( (lv_operations_31_0= ruleOperation ) )* ( (lv_stateMachine_32_0= ruleStateMachine ) )? '}' )? '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2100:2: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==39) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2101:1: (lv_abstract_0_0= 'abstract' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2101:1: (lv_abstract_0_0= 'abstract' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2102:3: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)input.LT(1);
                    match(input,39,FOLLOW_39_in_ruleActorClass3394); 

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

            match(input,40,FOLLOW_40_in_ruleActorClass3418); 

                    createLeafNode(grammarAccess.getActorClassAccess().getActorClassKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2125:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2126:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2126:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2127:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorClass3435); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2149:2: ( (lv_docu_3_0= ruleDocumentation ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==18) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2150:1: (lv_docu_3_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2150:1: (lv_docu_3_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2151:3: lv_docu_3_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getDocuDocumentationParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleActorClass3461);
                    lv_docu_3_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_3_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2173:3: ( 'extends' ( ( ruleFQN ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==16) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2173:5: 'extends' ( ( ruleFQN ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleActorClass3473); 

                            createLeafNode(grammarAccess.getActorClassAccess().getExtendsKeyword_4_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2177:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2178:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2178:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2179:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getBaseActorClassCrossReference_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleActorClass3496);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleActorClass3508); 

                    createLeafNode(grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_5(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2197:1: ( 'Interface' '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* '}' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==41) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2197:3: 'Interface' '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* '}'
                    {
                    match(input,41,FOLLOW_41_in_ruleActorClass3519); 

                            createLeafNode(grammarAccess.getActorClassAccess().getInterfaceKeyword_6_0(), null); 
                        
                    match(input,12,FOLLOW_12_in_ruleActorClass3529); 

                            createLeafNode(grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_6_1(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2205:1: ( (lv_ifPorts_9_0= rulePort ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( ((LA40_0>=44 && LA40_0<=45)) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2206:1: (lv_ifPorts_9_0= rulePort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2206:1: (lv_ifPorts_9_0= rulePort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2207:3: lv_ifPorts_9_0= rulePort
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getIfPortsPortParserRuleCall_6_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePort_in_ruleActorClass3550);
                    	    lv_ifPorts_9_0=rulePort();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"ifPorts",
                    	    	        		lv_ifPorts_9_0, 
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
                    	    break loop40;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2229:3: ( (lv_ifSPPs_10_0= ruleSPPRef ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==48) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2230:1: (lv_ifSPPs_10_0= ruleSPPRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2230:1: (lv_ifSPPs_10_0= ruleSPPRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2231:3: lv_ifSPPs_10_0= ruleSPPRef
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getIfSPPsSPPRefParserRuleCall_6_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSPPRef_in_ruleActorClass3572);
                    	    lv_ifSPPs_10_0=ruleSPPRef();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"ifSPPs",
                    	    	        		lv_ifSPPs_10_0, 
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
                    	    break loop41;
                        }
                    } while (true);

                    match(input,13,FOLLOW_13_in_ruleActorClass3583); 

                            createLeafNode(grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_6_4(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2257:3: ( 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? '{' ( 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_19_0= rulePort ) ) | ( (lv_extPorts_20_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_21_0= ruleServiceImplementation ) )* ( (lv_strSAPs_22_0= ruleSAPRef ) )* ( (lv_attributes_23_0= ruleAttribute ) )* ( (lv_actorRefs_24_0= ruleActorRef ) )* ( (lv_bindings_25_0= ruleBinding ) )* ( (lv_connections_26_0= ruleLayerConnection ) )* '}' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==42) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2257:5: 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? '{' ( 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_19_0= rulePort ) ) | ( (lv_extPorts_20_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_21_0= ruleServiceImplementation ) )* ( (lv_strSAPs_22_0= ruleSAPRef ) )* ( (lv_attributes_23_0= ruleAttribute ) )* ( (lv_actorRefs_24_0= ruleActorRef ) )* ( (lv_bindings_25_0= ruleBinding ) )* ( (lv_connections_26_0= ruleLayerConnection ) )* '}'
                    {
                    match(input,42,FOLLOW_42_in_ruleActorClass3596); 

                            createLeafNode(grammarAccess.getActorClassAccess().getStructureKeyword_7_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2261:1: ( (lv_structureDocu_13_0= ruleDocumentation ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==18) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2262:1: (lv_structureDocu_13_0= ruleDocumentation )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2262:1: (lv_structureDocu_13_0= ruleDocumentation )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2263:3: lv_structureDocu_13_0= ruleDocumentation
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getStructureDocuDocumentationParserRuleCall_7_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDocumentation_in_ruleActorClass3617);
                            lv_structureDocu_13_0=ruleDocumentation();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"structureDocu",
                            	        		lv_structureDocu_13_0, 
                            	        		"Documentation", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }

                    match(input,12,FOLLOW_12_in_ruleActorClass3628); 

                            createLeafNode(grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_7_2(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2289:1: ( 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==25) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2289:3: 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) )
                            {
                            match(input,25,FOLLOW_25_in_ruleActorClass3639); 

                                    createLeafNode(grammarAccess.getActorClassAccess().getUsercode1Keyword_7_3_0(), null); 
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2293:1: ( (lv_userCode1_16_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2294:1: (lv_userCode1_16_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2294:1: (lv_userCode1_16_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2295:3: lv_userCode1_16_0= ruleDetailCode
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getUserCode1DetailCodeParserRuleCall_7_3_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleActorClass3660);
                            lv_userCode1_16_0=ruleDetailCode();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"userCode1",
                            	        		lv_userCode1_16_0, 
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2317:4: ( 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==26) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2317:6: 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) )
                            {
                            match(input,26,FOLLOW_26_in_ruleActorClass3673); 

                                    createLeafNode(grammarAccess.getActorClassAccess().getUsercode2Keyword_7_4_0(), null); 
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2321:1: ( (lv_userCode2_18_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2322:1: (lv_userCode2_18_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2322:1: (lv_userCode2_18_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2323:3: lv_userCode2_18_0= ruleDetailCode
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getUserCode2DetailCodeParserRuleCall_7_4_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleActorClass3694);
                            lv_userCode2_18_0=ruleDetailCode();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"userCode2",
                            	        		lv_userCode2_18_0, 
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2345:4: ( ( (lv_intPorts_19_0= rulePort ) ) | ( (lv_extPorts_20_0= ruleExternalPort ) ) )*
                    loop46:
                    do {
                        int alt46=3;
                        int LA46_0 = input.LA(1);

                        if ( ((LA46_0>=44 && LA46_0<=45)) ) {
                            alt46=1;
                        }
                        else if ( (LA46_0==46) ) {
                            alt46=2;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2345:5: ( (lv_intPorts_19_0= rulePort ) )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2345:5: ( (lv_intPorts_19_0= rulePort ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2346:1: (lv_intPorts_19_0= rulePort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2346:1: (lv_intPorts_19_0= rulePort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2347:3: lv_intPorts_19_0= rulePort
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getIntPortsPortParserRuleCall_7_5_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePort_in_ruleActorClass3718);
                    	    lv_intPorts_19_0=rulePort();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"intPorts",
                    	    	        		lv_intPorts_19_0, 
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
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2370:6: ( (lv_extPorts_20_0= ruleExternalPort ) )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2370:6: ( (lv_extPorts_20_0= ruleExternalPort ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2371:1: (lv_extPorts_20_0= ruleExternalPort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2371:1: (lv_extPorts_20_0= ruleExternalPort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2372:3: lv_extPorts_20_0= ruleExternalPort
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getExtPortsExternalPortParserRuleCall_7_5_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExternalPort_in_ruleActorClass3745);
                    	    lv_extPorts_20_0=ruleExternalPort();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"extPorts",
                    	    	        		lv_extPorts_20_0, 
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
                    	    break loop46;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2394:4: ( (lv_serviceImplementations_21_0= ruleServiceImplementation ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==49) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2395:1: (lv_serviceImplementations_21_0= ruleServiceImplementation )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2395:1: (lv_serviceImplementations_21_0= ruleServiceImplementation )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2396:3: lv_serviceImplementations_21_0= ruleServiceImplementation
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getServiceImplementationsServiceImplementationParserRuleCall_7_6_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleServiceImplementation_in_ruleActorClass3768);
                    	    lv_serviceImplementations_21_0=ruleServiceImplementation();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"serviceImplementations",
                    	    	        		lv_serviceImplementations_21_0, 
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
                    	    break loop47;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2418:3: ( (lv_strSAPs_22_0= ruleSAPRef ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==47) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2419:1: (lv_strSAPs_22_0= ruleSAPRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2419:1: (lv_strSAPs_22_0= ruleSAPRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2420:3: lv_strSAPs_22_0= ruleSAPRef
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getStrSAPsSAPRefParserRuleCall_7_7_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSAPRef_in_ruleActorClass3790);
                    	    lv_strSAPs_22_0=ruleSAPRef();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"strSAPs",
                    	    	        		lv_strSAPs_22_0, 
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
                    	    break loop48;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2442:3: ( (lv_attributes_23_0= ruleAttribute ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==17) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2443:1: (lv_attributes_23_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2443:1: (lv_attributes_23_0= ruleAttribute )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2444:3: lv_attributes_23_0= ruleAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getAttributesAttributeParserRuleCall_7_8_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleActorClass3812);
                    	    lv_attributes_23_0=ruleAttribute();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_23_0, 
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
                    	    break loop49;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2466:3: ( (lv_actorRefs_24_0= ruleActorRef ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==62) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2467:1: (lv_actorRefs_24_0= ruleActorRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2467:1: (lv_actorRefs_24_0= ruleActorRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2468:3: lv_actorRefs_24_0= ruleActorRef
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getActorRefsActorRefParserRuleCall_7_9_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleActorRef_in_ruleActorClass3834);
                    	    lv_actorRefs_24_0=ruleActorRef();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"actorRefs",
                    	    	        		lv_actorRefs_24_0, 
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
                    	    break loop50;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2490:3: ( (lv_bindings_25_0= ruleBinding ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==56) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2491:1: (lv_bindings_25_0= ruleBinding )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2491:1: (lv_bindings_25_0= ruleBinding )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2492:3: lv_bindings_25_0= ruleBinding
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getBindingsBindingParserRuleCall_7_10_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBinding_in_ruleActorClass3856);
                    	    lv_bindings_25_0=ruleBinding();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"bindings",
                    	    	        		lv_bindings_25_0, 
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
                    	    break loop51;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2514:3: ( (lv_connections_26_0= ruleLayerConnection ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==58) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2515:1: (lv_connections_26_0= ruleLayerConnection )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2515:1: (lv_connections_26_0= ruleLayerConnection )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2516:3: lv_connections_26_0= ruleLayerConnection
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getConnectionsLayerConnectionParserRuleCall_7_11_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleActorClass3878);
                    	    lv_connections_26_0=ruleLayerConnection();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"connections",
                    	    	        		lv_connections_26_0, 
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
                    	    break loop52;
                        }
                    } while (true);

                    match(input,13,FOLLOW_13_in_ruleActorClass3889); 

                            createLeafNode(grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_7_12(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2542:3: ( 'Behavior' ( (lv_behaviorDocu_29_0= ruleDocumentation ) )? '{' ( (lv_operations_31_0= ruleOperation ) )* ( (lv_stateMachine_32_0= ruleStateMachine ) )? '}' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==43) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2542:5: 'Behavior' ( (lv_behaviorDocu_29_0= ruleDocumentation ) )? '{' ( (lv_operations_31_0= ruleOperation ) )* ( (lv_stateMachine_32_0= ruleStateMachine ) )? '}'
                    {
                    match(input,43,FOLLOW_43_in_ruleActorClass3902); 

                            createLeafNode(grammarAccess.getActorClassAccess().getBehaviorKeyword_8_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2546:1: ( (lv_behaviorDocu_29_0= ruleDocumentation ) )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==18) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2547:1: (lv_behaviorDocu_29_0= ruleDocumentation )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2547:1: (lv_behaviorDocu_29_0= ruleDocumentation )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2548:3: lv_behaviorDocu_29_0= ruleDocumentation
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getBehaviorDocuDocumentationParserRuleCall_8_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDocumentation_in_ruleActorClass3923);
                            lv_behaviorDocu_29_0=ruleDocumentation();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"behaviorDocu",
                            	        		lv_behaviorDocu_29_0, 
                            	        		"Documentation", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }

                    match(input,12,FOLLOW_12_in_ruleActorClass3934); 

                            createLeafNode(grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_8_2(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2574:1: ( (lv_operations_31_0= ruleOperation ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==20) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2575:1: (lv_operations_31_0= ruleOperation )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2575:1: (lv_operations_31_0= ruleOperation )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2576:3: lv_operations_31_0= ruleOperation
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getOperationsOperationParserRuleCall_8_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleOperation_in_ruleActorClass3955);
                    	    lv_operations_31_0=ruleOperation();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operations",
                    	    	        		lv_operations_31_0, 
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
                    	    break loop55;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2598:3: ( (lv_stateMachine_32_0= ruleStateMachine ) )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==63) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2599:1: (lv_stateMachine_32_0= ruleStateMachine )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2599:1: (lv_stateMachine_32_0= ruleStateMachine )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2600:3: lv_stateMachine_32_0= ruleStateMachine
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getActorClassAccess().getStateMachineStateMachineParserRuleCall_8_4_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleStateMachine_in_ruleActorClass3977);
                            lv_stateMachine_32_0=ruleStateMachine();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getActorClassRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"stateMachine",
                            	        		lv_stateMachine_32_0, 
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

                    match(input,13,FOLLOW_13_in_ruleActorClass3988); 

                            createLeafNode(grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_8_5(), null); 
                        

                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleActorClass4000); 

                    createLeafNode(grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_9(), null); 
                

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2640:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2641:2: (iv_rulePort= rulePort EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2642:2: iv_rulePort= rulePort EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPortRule(), currentNode); 
            pushFollow(FOLLOW_rulePort_in_entryRulePort4038);
            iv_rulePort=rulePort();
            _fsp--;

             current =iv_rulePort; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePort4048); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2649:1: rulePort returns [EObject current=null] : ( ( (lv_conjugated_0_0= 'conjugated' ) )? 'Port' ( (lv_name_2_0= RULE_ID ) ) ( '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']' )? ':' ( ( ruleFQN ) ) ( (lv_docu_8_0= ruleDocumentation ) )? ) ;
    public final EObject rulePort() throws RecognitionException {
        EObject current = null;

        Token lv_conjugated_0_0=null;
        Token lv_name_2_0=null;
        Token lv_multiplicity_4_0=null;
        EObject lv_docu_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2654:6: ( ( ( (lv_conjugated_0_0= 'conjugated' ) )? 'Port' ( (lv_name_2_0= RULE_ID ) ) ( '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']' )? ':' ( ( ruleFQN ) ) ( (lv_docu_8_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2655:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? 'Port' ( (lv_name_2_0= RULE_ID ) ) ( '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']' )? ':' ( ( ruleFQN ) ) ( (lv_docu_8_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2655:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? 'Port' ( (lv_name_2_0= RULE_ID ) ) ( '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']' )? ':' ( ( ruleFQN ) ) ( (lv_docu_8_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2655:2: ( (lv_conjugated_0_0= 'conjugated' ) )? 'Port' ( (lv_name_2_0= RULE_ID ) ) ( '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']' )? ':' ( ( ruleFQN ) ) ( (lv_docu_8_0= ruleDocumentation ) )?
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2655:2: ( (lv_conjugated_0_0= 'conjugated' ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==44) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2656:1: (lv_conjugated_0_0= 'conjugated' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2656:1: (lv_conjugated_0_0= 'conjugated' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2657:3: lv_conjugated_0_0= 'conjugated'
                    {
                    lv_conjugated_0_0=(Token)input.LT(1);
                    match(input,44,FOLLOW_44_in_rulePort4091); 

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

            match(input,45,FOLLOW_45_in_rulePort4115); 

                    createLeafNode(grammarAccess.getPortAccess().getPortKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2680:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2681:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2681:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2682:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePort4132); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2704:2: ( '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==18) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2704:4: '[' ( (lv_multiplicity_4_0= RULE_INT ) ) ']'
                    {
                    match(input,18,FOLLOW_18_in_rulePort4148); 

                            createLeafNode(grammarAccess.getPortAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2708:1: ( (lv_multiplicity_4_0= RULE_INT ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2709:1: (lv_multiplicity_4_0= RULE_INT )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2709:1: (lv_multiplicity_4_0= RULE_INT )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2710:3: lv_multiplicity_4_0= RULE_INT
                    {
                    lv_multiplicity_4_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePort4165); 

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

                    match(input,19,FOLLOW_19_in_rulePort4180); 

                            createLeafNode(grammarAccess.getPortAccess().getRightSquareBracketKeyword_3_2(), null); 
                        

                    }
                    break;

            }

            match(input,14,FOLLOW_14_in_rulePort4192); 

                    createLeafNode(grammarAccess.getPortAccess().getColonKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2740:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2741:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2741:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2742:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getPortRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getPortAccess().getProtocolProtocolClassCrossReference_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_rulePort4215);
            ruleFQN();
            _fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2756:2: ( (lv_docu_8_0= ruleDocumentation ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==18) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2757:1: (lv_docu_8_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2757:1: (lv_docu_8_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2758:3: lv_docu_8_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPortAccess().getDocuDocumentationParserRuleCall_6_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_rulePort4236);
                    lv_docu_8_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPortRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_8_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


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
    // $ANTLR end rulePort


    // $ANTLR start entryRuleExternalPort
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2788:1: entryRuleExternalPort returns [EObject current=null] : iv_ruleExternalPort= ruleExternalPort EOF ;
    public final EObject entryRuleExternalPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalPort = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2789:2: (iv_ruleExternalPort= ruleExternalPort EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2790:2: iv_ruleExternalPort= ruleExternalPort EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExternalPortRule(), currentNode); 
            pushFollow(FOLLOW_ruleExternalPort_in_entryRuleExternalPort4273);
            iv_ruleExternalPort=ruleExternalPort();
            _fsp--;

             current =iv_ruleExternalPort; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalPort4283); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2797:1: ruleExternalPort returns [EObject current=null] : ( 'external' 'Port' ( ( RULE_ID ) ) ) ;
    public final EObject ruleExternalPort() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2802:6: ( ( 'external' 'Port' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2803:1: ( 'external' 'Port' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2803:1: ( 'external' 'Port' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2803:3: 'external' 'Port' ( ( RULE_ID ) )
            {
            match(input,46,FOLLOW_46_in_ruleExternalPort4318); 

                    createLeafNode(grammarAccess.getExternalPortAccess().getExternalKeyword_0(), null); 
                
            match(input,45,FOLLOW_45_in_ruleExternalPort4328); 

                    createLeafNode(grammarAccess.getExternalPortAccess().getPortKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2811:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2812:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2812:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2813:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getExternalPortRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalPort4346); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2833:1: entryRuleSAPRef returns [EObject current=null] : iv_ruleSAPRef= ruleSAPRef EOF ;
    public final EObject entryRuleSAPRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2834:2: (iv_ruleSAPRef= ruleSAPRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2835:2: iv_ruleSAPRef= ruleSAPRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSAPRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleSAPRef_in_entryRuleSAPRef4382);
            iv_ruleSAPRef=ruleSAPRef();
            _fsp--;

             current =iv_ruleSAPRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSAPRef4392); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2842:1: ruleSAPRef returns [EObject current=null] : ( 'SAP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSAPRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2847:6: ( ( 'SAP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2848:1: ( 'SAP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2848:1: ( 'SAP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2848:3: 'SAP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) )
            {
            match(input,47,FOLLOW_47_in_ruleSAPRef4427); 

                    createLeafNode(grammarAccess.getSAPRefAccess().getSAPKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2852:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2853:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2853:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2854:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSAPRef4444); 

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

            match(input,14,FOLLOW_14_in_ruleSAPRef4459); 

                    createLeafNode(grammarAccess.getSAPRefAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2880:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2881:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2881:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2882:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSAPRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getSAPRefAccess().getProtocolProtocolClassCrossReference_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSAPRef4482);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2904:1: entryRuleSPPRef returns [EObject current=null] : iv_ruleSPPRef= ruleSPPRef EOF ;
    public final EObject entryRuleSPPRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2905:2: (iv_ruleSPPRef= ruleSPPRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2906:2: iv_ruleSPPRef= ruleSPPRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSPPRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleSPPRef_in_entryRuleSPPRef4518);
            iv_ruleSPPRef=ruleSPPRef();
            _fsp--;

             current =iv_ruleSPPRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSPPRef4528); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2913:1: ruleSPPRef returns [EObject current=null] : ( 'SPP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSPPRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2918:6: ( ( 'SPP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2919:1: ( 'SPP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2919:1: ( 'SPP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2919:3: 'SPP' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) )
            {
            match(input,48,FOLLOW_48_in_ruleSPPRef4563); 

                    createLeafNode(grammarAccess.getSPPRefAccess().getSPPKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2923:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2924:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2924:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2925:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPRef4580); 

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

            match(input,14,FOLLOW_14_in_ruleSPPRef4595); 

                    createLeafNode(grammarAccess.getSPPRefAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2951:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2952:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2952:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2953:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSPPRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getSPPRefAccess().getProtocolProtocolClassCrossReference_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSPPRef4618);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2975:1: entryRuleServiceImplementation returns [EObject current=null] : iv_ruleServiceImplementation= ruleServiceImplementation EOF ;
    public final EObject entryRuleServiceImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceImplementation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2976:2: (iv_ruleServiceImplementation= ruleServiceImplementation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2977:2: iv_ruleServiceImplementation= ruleServiceImplementation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getServiceImplementationRule(), currentNode); 
            pushFollow(FOLLOW_ruleServiceImplementation_in_entryRuleServiceImplementation4654);
            iv_ruleServiceImplementation=ruleServiceImplementation();
            _fsp--;

             current =iv_ruleServiceImplementation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleServiceImplementation4664); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2984:1: ruleServiceImplementation returns [EObject current=null] : ( 'ServiceImplementation' 'of' ( ( RULE_ID ) ) ) ;
    public final EObject ruleServiceImplementation() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2989:6: ( ( 'ServiceImplementation' 'of' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2990:1: ( 'ServiceImplementation' 'of' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2990:1: ( 'ServiceImplementation' 'of' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2990:3: 'ServiceImplementation' 'of' ( ( RULE_ID ) )
            {
            match(input,49,FOLLOW_49_in_ruleServiceImplementation4699); 

                    createLeafNode(grammarAccess.getServiceImplementationAccess().getServiceImplementationKeyword_0(), null); 
                
            match(input,50,FOLLOW_50_in_ruleServiceImplementation4709); 

                    createLeafNode(grammarAccess.getServiceImplementationAccess().getOfKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2998:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2999:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2999:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3000:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getServiceImplementationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleServiceImplementation4727); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3020:1: entryRuleLogicalSystem returns [EObject current=null] : iv_ruleLogicalSystem= ruleLogicalSystem EOF ;
    public final EObject entryRuleLogicalSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalSystem = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3021:2: (iv_ruleLogicalSystem= ruleLogicalSystem EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3022:2: iv_ruleLogicalSystem= ruleLogicalSystem EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalSystemRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalSystem_in_entryRuleLogicalSystem4763);
            iv_ruleLogicalSystem=ruleLogicalSystem();
            _fsp--;

             current =iv_ruleLogicalSystem; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalSystem4773); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3029:1: ruleLogicalSystem returns [EObject current=null] : ( 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )+ ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* '}' ) ;
    public final EObject ruleLogicalSystem() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;

        EObject lv_subSystems_4_0 = null;

        EObject lv_bindings_5_0 = null;

        EObject lv_connections_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3034:6: ( ( 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )+ ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3035:1: ( 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )+ ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3035:1: ( 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )+ ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3035:3: 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )+ ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* '}'
            {
            match(input,51,FOLLOW_51_in_ruleLogicalSystem4808); 

                    createLeafNode(grammarAccess.getLogicalSystemAccess().getLogicalSystemKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3039:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3040:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3040:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3041:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLogicalSystem4825); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3063:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==18) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3064:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3064:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3065:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getLogicalSystemAccess().getDocuDocumentationParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleLogicalSystem4851);
                    lv_docu_2_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getLogicalSystemRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_2_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleLogicalSystem4862); 

                    createLeafNode(grammarAccess.getLogicalSystemAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3091:1: ( (lv_subSystems_4_0= ruleSubSystemRef ) )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==52) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3092:1: (lv_subSystems_4_0= ruleSubSystemRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3092:1: (lv_subSystems_4_0= ruleSubSystemRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3093:3: lv_subSystems_4_0= ruleSubSystemRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalSystemAccess().getSubSystemsSubSystemRefParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubSystemRef_in_ruleLogicalSystem4883);
            	    lv_subSystems_4_0=ruleSubSystemRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLogicalSystemRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"subSystems",
            	    	        		lv_subSystems_4_0, 
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
            	    if ( cnt62 >= 1 ) break loop62;
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3115:3: ( (lv_bindings_5_0= ruleBinding ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==56) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3116:1: (lv_bindings_5_0= ruleBinding )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3116:1: (lv_bindings_5_0= ruleBinding )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3117:3: lv_bindings_5_0= ruleBinding
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalSystemAccess().getBindingsBindingParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleBinding_in_ruleLogicalSystem4905);
            	    lv_bindings_5_0=ruleBinding();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLogicalSystemRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"bindings",
            	    	        		lv_bindings_5_0, 
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
            	    break loop63;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3139:3: ( (lv_connections_6_0= ruleLayerConnection ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==58) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3140:1: (lv_connections_6_0= ruleLayerConnection )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3140:1: (lv_connections_6_0= ruleLayerConnection )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3141:3: lv_connections_6_0= ruleLayerConnection
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalSystemAccess().getConnectionsLayerConnectionParserRuleCall_6_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleLogicalSystem4927);
            	    lv_connections_6_0=ruleLayerConnection();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLogicalSystemRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"connections",
            	    	        		lv_connections_6_0, 
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
            	    break loop64;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleLogicalSystem4938); 

                    createLeafNode(grammarAccess.getLogicalSystemAccess().getRightCurlyBracketKeyword_7(), null); 
                

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3177:1: entryRuleSubSystemRef returns [EObject current=null] : iv_ruleSubSystemRef= ruleSubSystemRef EOF ;
    public final EObject entryRuleSubSystemRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3178:2: (iv_ruleSubSystemRef= ruleSubSystemRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3179:2: iv_ruleSubSystemRef= ruleSubSystemRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubSystemRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubSystemRef_in_entryRuleSubSystemRef4976);
            iv_ruleSubSystemRef=ruleSubSystemRef();
            _fsp--;

             current =iv_ruleSubSystemRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemRef4986); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3186:1: ruleSubSystemRef returns [EObject current=null] : ( 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSubSystemRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_docu_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3191:6: ( ( 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3192:1: ( 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3192:1: ( 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3192:3: 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            match(input,52,FOLLOW_52_in_ruleSubSystemRef5021); 

                    createLeafNode(grammarAccess.getSubSystemRefAccess().getSubSystemRefKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3196:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3197:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3197:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3198:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemRef5038); 

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

            match(input,14,FOLLOW_14_in_ruleSubSystemRef5053); 

                    createLeafNode(grammarAccess.getSubSystemRefAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3224:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3225:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3225:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3226:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubSystemRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getSubSystemRefAccess().getTypeSubSystemClassCrossReference_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSubSystemRef5076);
            ruleFQN();
            _fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3240:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==18) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3241:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3241:1: (lv_docu_4_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3242:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSubSystemRefAccess().getDocuDocumentationParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleSubSystemRef5097);
                    lv_docu_4_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSubSystemRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_4_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


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
    // $ANTLR end ruleSubSystemRef


    // $ANTLR start entryRuleSubSystemClass
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3272:1: entryRuleSubSystemClass returns [EObject current=null] : iv_ruleSubSystemClass= ruleSubSystemClass EOF ;
    public final EObject entryRuleSubSystemClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3273:2: (iv_ruleSubSystemClass= ruleSubSystemClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3274:2: iv_ruleSubSystemClass= ruleSubSystemClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubSystemClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubSystemClass_in_entryRuleSubSystemClass5134);
            iv_ruleSubSystemClass=ruleSubSystemClass();
            _fsp--;

             current =iv_ruleSubSystemClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemClass5144); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3281:1: ruleSubSystemClass returns [EObject current=null] : ( 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? ( (lv_relayPorts_8_0= rulePort ) )* ( (lv_ifSPPs_9_0= ruleSPPRef ) )* ( (lv_actorRefs_10_0= ruleActorRef ) )+ ( (lv_bindings_11_0= ruleBinding ) )* ( (lv_connections_12_0= ruleLayerConnection ) )* ( (lv_threads_13_0= ruleLogicalThread ) )* '}' ) ;
    public final EObject ruleSubSystemClass() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;

        EObject lv_userCode1_5_0 = null;

        EObject lv_userCode2_7_0 = null;

        EObject lv_relayPorts_8_0 = null;

        EObject lv_ifSPPs_9_0 = null;

        EObject lv_actorRefs_10_0 = null;

        EObject lv_bindings_11_0 = null;

        EObject lv_connections_12_0 = null;

        EObject lv_threads_13_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3286:6: ( ( 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? ( (lv_relayPorts_8_0= rulePort ) )* ( (lv_ifSPPs_9_0= ruleSPPRef ) )* ( (lv_actorRefs_10_0= ruleActorRef ) )+ ( (lv_bindings_11_0= ruleBinding ) )* ( (lv_connections_12_0= ruleLayerConnection ) )* ( (lv_threads_13_0= ruleLogicalThread ) )* '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3287:1: ( 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? ( (lv_relayPorts_8_0= rulePort ) )* ( (lv_ifSPPs_9_0= ruleSPPRef ) )* ( (lv_actorRefs_10_0= ruleActorRef ) )+ ( (lv_bindings_11_0= ruleBinding ) )* ( (lv_connections_12_0= ruleLayerConnection ) )* ( (lv_threads_13_0= ruleLogicalThread ) )* '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3287:1: ( 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? ( (lv_relayPorts_8_0= rulePort ) )* ( (lv_ifSPPs_9_0= ruleSPPRef ) )* ( (lv_actorRefs_10_0= ruleActorRef ) )+ ( (lv_bindings_11_0= ruleBinding ) )* ( (lv_connections_12_0= ruleLayerConnection ) )* ( (lv_threads_13_0= ruleLogicalThread ) )* '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3287:3: 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? ( 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? ( (lv_relayPorts_8_0= rulePort ) )* ( (lv_ifSPPs_9_0= ruleSPPRef ) )* ( (lv_actorRefs_10_0= ruleActorRef ) )+ ( (lv_bindings_11_0= ruleBinding ) )* ( (lv_connections_12_0= ruleLayerConnection ) )* ( (lv_threads_13_0= ruleLogicalThread ) )* '}'
            {
            match(input,53,FOLLOW_53_in_ruleSubSystemClass5179); 

                    createLeafNode(grammarAccess.getSubSystemClassAccess().getSubSystemClassKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3291:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3292:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3292:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3293:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemClass5196); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3315:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==18) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3316:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3316:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3317:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getDocuDocumentationParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleSubSystemClass5222);
                    lv_docu_2_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_2_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleSubSystemClass5233); 

                    createLeafNode(grammarAccess.getSubSystemClassAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3343:1: ( 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==25) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3343:3: 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) )
                    {
                    match(input,25,FOLLOW_25_in_ruleSubSystemClass5244); 

                            createLeafNode(grammarAccess.getSubSystemClassAccess().getUsercode1Keyword_4_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3347:1: ( (lv_userCode1_5_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3348:1: (lv_userCode1_5_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3348:1: (lv_userCode1_5_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3349:3: lv_userCode1_5_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode1DetailCodeParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleSubSystemClass5265);
                    lv_userCode1_5_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"userCode1",
                    	        		lv_userCode1_5_0, 
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3371:4: ( 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==26) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3371:6: 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) )
                    {
                    match(input,26,FOLLOW_26_in_ruleSubSystemClass5278); 

                            createLeafNode(grammarAccess.getSubSystemClassAccess().getUsercode2Keyword_5_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3375:1: ( (lv_userCode2_7_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3376:1: (lv_userCode2_7_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3376:1: (lv_userCode2_7_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3377:3: lv_userCode2_7_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode2DetailCodeParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleSubSystemClass5299);
                    lv_userCode2_7_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"userCode2",
                    	        		lv_userCode2_7_0, 
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3399:4: ( (lv_relayPorts_8_0= rulePort ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( ((LA69_0>=44 && LA69_0<=45)) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3400:1: (lv_relayPorts_8_0= rulePort )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3400:1: (lv_relayPorts_8_0= rulePort )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3401:3: lv_relayPorts_8_0= rulePort
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getRelayPortsPortParserRuleCall_6_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_rulePort_in_ruleSubSystemClass5322);
            	    lv_relayPorts_8_0=rulePort();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"relayPorts",
            	    	        		lv_relayPorts_8_0, 
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
            	    break loop69;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3423:3: ( (lv_ifSPPs_9_0= ruleSPPRef ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==48) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3424:1: (lv_ifSPPs_9_0= ruleSPPRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3424:1: (lv_ifSPPs_9_0= ruleSPPRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3425:3: lv_ifSPPs_9_0= ruleSPPRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getIfSPPsSPPRefParserRuleCall_7_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSPPRef_in_ruleSubSystemClass5344);
            	    lv_ifSPPs_9_0=ruleSPPRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
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
            	    break loop70;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3447:3: ( (lv_actorRefs_10_0= ruleActorRef ) )+
            int cnt71=0;
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==62) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3448:1: (lv_actorRefs_10_0= ruleActorRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3448:1: (lv_actorRefs_10_0= ruleActorRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3449:3: lv_actorRefs_10_0= ruleActorRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getActorRefsActorRefParserRuleCall_8_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorRef_in_ruleSubSystemClass5366);
            	    lv_actorRefs_10_0=ruleActorRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"actorRefs",
            	    	        		lv_actorRefs_10_0, 
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
            	    if ( cnt71 >= 1 ) break loop71;
                        EarlyExitException eee =
                            new EarlyExitException(71, input);
                        throw eee;
                }
                cnt71++;
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3471:3: ( (lv_bindings_11_0= ruleBinding ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==56) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3472:1: (lv_bindings_11_0= ruleBinding )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3472:1: (lv_bindings_11_0= ruleBinding )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3473:3: lv_bindings_11_0= ruleBinding
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getBindingsBindingParserRuleCall_9_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleBinding_in_ruleSubSystemClass5388);
            	    lv_bindings_11_0=ruleBinding();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"bindings",
            	    	        		lv_bindings_11_0, 
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
            	    break loop72;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3495:3: ( (lv_connections_12_0= ruleLayerConnection ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==58) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3496:1: (lv_connections_12_0= ruleLayerConnection )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3496:1: (lv_connections_12_0= ruleLayerConnection )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3497:3: lv_connections_12_0= ruleLayerConnection
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getConnectionsLayerConnectionParserRuleCall_10_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleSubSystemClass5410);
            	    lv_connections_12_0=ruleLayerConnection();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"connections",
            	    	        		lv_connections_12_0, 
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
            	    break loop73;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3519:3: ( (lv_threads_13_0= ruleLogicalThread ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==54) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3520:1: (lv_threads_13_0= ruleLogicalThread )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3520:1: (lv_threads_13_0= ruleLogicalThread )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3521:3: lv_threads_13_0= ruleLogicalThread
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSubSystemClassAccess().getThreadsLogicalThreadParserRuleCall_11_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLogicalThread_in_ruleSubSystemClass5432);
            	    lv_threads_13_0=ruleLogicalThread();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSubSystemClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"threads",
            	    	        		lv_threads_13_0, 
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
            	    break loop74;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleSubSystemClass5443); 

                    createLeafNode(grammarAccess.getSubSystemClassAccess().getRightCurlyBracketKeyword_12(), null); 
                

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3555:1: entryRuleLogicalThread returns [EObject current=null] : iv_ruleLogicalThread= ruleLogicalThread EOF ;
    public final EObject entryRuleLogicalThread() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalThread = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3556:2: (iv_ruleLogicalThread= ruleLogicalThread EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3557:2: iv_ruleLogicalThread= ruleLogicalThread EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalThreadRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalThread_in_entryRuleLogicalThread5479);
            iv_ruleLogicalThread=ruleLogicalThread();
            _fsp--;

             current =iv_ruleLogicalThread; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalThread5489); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3564:1: ruleLogicalThread returns [EObject current=null] : ( 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_instances_3_0= ruleActorInstancePath ) ) ( ',' ( (lv_instances_5_0= ruleActorInstancePath ) ) )* '}' ) ;
    public final EObject ruleLogicalThread() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_instances_3_0 = null;

        EObject lv_instances_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3569:6: ( ( 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_instances_3_0= ruleActorInstancePath ) ) ( ',' ( (lv_instances_5_0= ruleActorInstancePath ) ) )* '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3570:1: ( 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_instances_3_0= ruleActorInstancePath ) ) ( ',' ( (lv_instances_5_0= ruleActorInstancePath ) ) )* '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3570:1: ( 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_instances_3_0= ruleActorInstancePath ) ) ( ',' ( (lv_instances_5_0= ruleActorInstancePath ) ) )* '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3570:3: 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_instances_3_0= ruleActorInstancePath ) ) ( ',' ( (lv_instances_5_0= ruleActorInstancePath ) ) )* '}'
            {
            match(input,54,FOLLOW_54_in_ruleLogicalThread5524); 

                    createLeafNode(grammarAccess.getLogicalThreadAccess().getLogicalThreadKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3574:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3575:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3575:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3576:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLogicalThread5541); 

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

            match(input,12,FOLLOW_12_in_ruleLogicalThread5556); 

                    createLeafNode(grammarAccess.getLogicalThreadAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3602:1: ( (lv_instances_3_0= ruleActorInstancePath ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3603:1: (lv_instances_3_0= ruleActorInstancePath )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3603:1: (lv_instances_3_0= ruleActorInstancePath )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3604:3: lv_instances_3_0= ruleActorInstancePath
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLogicalThreadAccess().getInstancesActorInstancePathParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleActorInstancePath_in_ruleLogicalThread5577);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3626:2: ( ',' ( (lv_instances_5_0= ruleActorInstancePath ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==22) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3626:4: ',' ( (lv_instances_5_0= ruleActorInstancePath ) )
            	    {
            	    match(input,22,FOLLOW_22_in_ruleLogicalThread5588); 

            	            createLeafNode(grammarAccess.getLogicalThreadAccess().getCommaKeyword_4_0(), null); 
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3630:1: ( (lv_instances_5_0= ruleActorInstancePath ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3631:1: (lv_instances_5_0= ruleActorInstancePath )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3631:1: (lv_instances_5_0= ruleActorInstancePath )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3632:3: lv_instances_5_0= ruleActorInstancePath
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalThreadAccess().getInstancesActorInstancePathParserRuleCall_4_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorInstancePath_in_ruleLogicalThread5609);
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
            	    break loop75;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleLogicalThread5621); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3666:1: entryRuleActorInstancePath returns [EObject current=null] : iv_ruleActorInstancePath= ruleActorInstancePath EOF ;
    public final EObject entryRuleActorInstancePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstancePath = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3667:2: (iv_ruleActorInstancePath= ruleActorInstancePath EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3668:2: iv_ruleActorInstancePath= ruleActorInstancePath EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActorInstancePathRule(), currentNode); 
            pushFollow(FOLLOW_ruleActorInstancePath_in_entryRuleActorInstancePath5657);
            iv_ruleActorInstancePath=ruleActorInstancePath();
            _fsp--;

             current =iv_ruleActorInstancePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorInstancePath5667); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3675:1: ruleActorInstancePath returns [EObject current=null] : ( ( (lv_segments_0_0= RULE_ID ) ) ( '.' ( (lv_segments_2_0= RULE_ID ) ) )* ) ;
    public final EObject ruleActorInstancePath() throws RecognitionException {
        EObject current = null;

        Token lv_segments_0_0=null;
        Token lv_segments_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3680:6: ( ( ( (lv_segments_0_0= RULE_ID ) ) ( '.' ( (lv_segments_2_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3681:1: ( ( (lv_segments_0_0= RULE_ID ) ) ( '.' ( (lv_segments_2_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3681:1: ( ( (lv_segments_0_0= RULE_ID ) ) ( '.' ( (lv_segments_2_0= RULE_ID ) ) )* )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3681:2: ( (lv_segments_0_0= RULE_ID ) ) ( '.' ( (lv_segments_2_0= RULE_ID ) ) )*
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3681:2: ( (lv_segments_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3682:1: (lv_segments_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3682:1: (lv_segments_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3683:3: lv_segments_0_0= RULE_ID
            {
            lv_segments_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorInstancePath5709); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3705:2: ( '.' ( (lv_segments_2_0= RULE_ID ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==55) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3705:4: '.' ( (lv_segments_2_0= RULE_ID ) )
            	    {
            	    match(input,55,FOLLOW_55_in_ruleActorInstancePath5725); 

            	            createLeafNode(grammarAccess.getActorInstancePathAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3709:1: ( (lv_segments_2_0= RULE_ID ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3710:1: (lv_segments_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3710:1: (lv_segments_2_0= RULE_ID )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3711:3: lv_segments_2_0= RULE_ID
            	    {
            	    lv_segments_2_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorInstancePath5742); 

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
            	    break loop76;
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3741:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3742:2: (iv_ruleBinding= ruleBinding EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3743:2: iv_ruleBinding= ruleBinding EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBindingRule(), currentNode); 
            pushFollow(FOLLOW_ruleBinding_in_entryRuleBinding5785);
            iv_ruleBinding=ruleBinding();
            _fsp--;

             current =iv_ruleBinding; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBinding5795); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3750:1: ruleBinding returns [EObject current=null] : ( 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        EObject lv_endpoint1_1_0 = null;

        EObject lv_endpoint2_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3755:6: ( ( 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3756:1: ( 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3756:1: ( 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3756:3: 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            {
            match(input,56,FOLLOW_56_in_ruleBinding5830); 

                    createLeafNode(grammarAccess.getBindingAccess().getBindingKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3760:1: ( (lv_endpoint1_1_0= ruleBindingEndPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3761:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3761:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3762:3: lv_endpoint1_1_0= ruleBindingEndPoint
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBindingAccess().getEndpoint1BindingEndPointParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBindingEndPoint_in_ruleBinding5851);
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

            match(input,57,FOLLOW_57_in_ruleBinding5861); 

                    createLeafNode(grammarAccess.getBindingAccess().getAndKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3788:1: ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3789:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3789:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3790:3: lv_endpoint2_3_0= ruleBindingEndPoint
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBindingAccess().getEndpoint2BindingEndPointParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBindingEndPoint_in_ruleBinding5882);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3820:1: entryRuleBindingEndPoint returns [EObject current=null] : iv_ruleBindingEndPoint= ruleBindingEndPoint EOF ;
    public final EObject entryRuleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingEndPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3821:2: (iv_ruleBindingEndPoint= ruleBindingEndPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3822:2: iv_ruleBindingEndPoint= ruleBindingEndPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBindingEndPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleBindingEndPoint_in_entryRuleBindingEndPoint5918);
            iv_ruleBindingEndPoint=ruleBindingEndPoint();
            _fsp--;

             current =iv_ruleBindingEndPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBindingEndPoint5928); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3829:1: ruleBindingEndPoint returns [EObject current=null] : ( ( ( ( RULE_ID ) ) '.' )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleBindingEndPoint() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3834:6: ( ( ( ( ( RULE_ID ) ) '.' )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3835:1: ( ( ( ( RULE_ID ) ) '.' )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3835:1: ( ( ( ( RULE_ID ) ) '.' )? ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3835:2: ( ( ( RULE_ID ) ) '.' )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3835:2: ( ( ( RULE_ID ) ) '.' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_ID) ) {
                int LA77_1 = input.LA(2);

                if ( (LA77_1==55) ) {
                    alt77=1;
                }
            }
            switch (alt77) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3835:3: ( ( RULE_ID ) ) '.'
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3835:3: ( ( RULE_ID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3836:1: ( RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3836:1: ( RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3837:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getBindingEndPointRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBindingEndPoint5972); 

                    		createLeafNode(grammarAccess.getBindingEndPointAccess().getActorRefActorContainerRefCrossReference_0_0_0(), "actorRef"); 
                    	

                    }


                    }

                    match(input,55,FOLLOW_55_in_ruleBindingEndPoint5982); 

                            createLeafNode(grammarAccess.getBindingEndPointAccess().getFullStopKeyword_0_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3853:3: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3854:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3854:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3855:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBindingEndPointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBindingEndPoint6002); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3875:1: entryRuleLayerConnection returns [EObject current=null] : iv_ruleLayerConnection= ruleLayerConnection EOF ;
    public final EObject entryRuleLayerConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerConnection = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3876:2: (iv_ruleLayerConnection= ruleLayerConnection EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3877:2: iv_ruleLayerConnection= ruleLayerConnection EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLayerConnectionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLayerConnection_in_entryRuleLayerConnection6038);
            iv_ruleLayerConnection=ruleLayerConnection();
            _fsp--;

             current =iv_ruleLayerConnection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLayerConnection6048); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3884:1: ruleLayerConnection returns [EObject current=null] : ( 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) ;
    public final EObject ruleLayerConnection() throws RecognitionException {
        EObject current = null;

        EObject lv_from_1_0 = null;

        EObject lv_to_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3889:6: ( ( 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3890:1: ( 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3890:1: ( 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3890:3: 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) )
            {
            match(input,58,FOLLOW_58_in_ruleLayerConnection6083); 

                    createLeafNode(grammarAccess.getLayerConnectionAccess().getLayerConnectionKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3894:1: ( (lv_from_1_0= ruleSAPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3895:1: (lv_from_1_0= ruleSAPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3895:1: (lv_from_1_0= ruleSAPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3896:3: lv_from_1_0= ruleSAPoint
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLayerConnectionAccess().getFromSAPointParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSAPoint_in_ruleLayerConnection6104);
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

            match(input,59,FOLLOW_59_in_ruleLayerConnection6114); 

                    createLeafNode(grammarAccess.getLayerConnectionAccess().getSatisfied_byKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3922:1: ( (lv_to_3_0= ruleSPPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3923:1: (lv_to_3_0= ruleSPPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3923:1: (lv_to_3_0= ruleSPPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3924:3: lv_to_3_0= ruleSPPoint
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLayerConnectionAccess().getToSPPointParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSPPoint_in_ruleLayerConnection6135);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3954:1: entryRuleSAPoint returns [EObject current=null] : iv_ruleSAPoint= ruleSAPoint EOF ;
    public final EObject entryRuleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3955:2: (iv_ruleSAPoint= ruleSAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3956:2: iv_ruleSAPoint= ruleSAPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSAPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleSAPoint_in_entryRuleSAPoint6171);
            iv_ruleSAPoint=ruleSAPoint();
            _fsp--;

             current =iv_ruleSAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSAPoint6181); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3963:1: ruleSAPoint returns [EObject current=null] : (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) ;
    public final EObject ruleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject this_RefSAPoint_0 = null;

        EObject this_RelaySAPoint_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3968:6: ( (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3969:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3969:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==60) ) {
                alt78=1;
            }
            else if ( (LA78_0==61) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3969:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3970:5: this_RefSAPoint_0= ruleRefSAPoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSAPointAccess().getRefSAPointParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRefSAPoint_in_ruleSAPoint6228);
                    this_RefSAPoint_0=ruleRefSAPoint();
                    _fsp--;

                     
                            current = this_RefSAPoint_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3980:5: this_RelaySAPoint_1= ruleRelaySAPoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSAPointAccess().getRelaySAPointParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRelaySAPoint_in_ruleSAPoint6255);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3996:1: entryRuleRefSAPoint returns [EObject current=null] : iv_ruleRefSAPoint= ruleRefSAPoint EOF ;
    public final EObject entryRuleRefSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3997:2: (iv_ruleRefSAPoint= ruleRefSAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3998:2: iv_ruleRefSAPoint= ruleRefSAPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRefSAPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleRefSAPoint_in_entryRuleRefSAPoint6290);
            iv_ruleRefSAPoint=ruleRefSAPoint();
            _fsp--;

             current =iv_ruleRefSAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefSAPoint6300); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4005:1: ruleRefSAPoint returns [EObject current=null] : ( 'ref' ( ( RULE_ID ) ) ) ;
    public final EObject ruleRefSAPoint() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4010:6: ( ( 'ref' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4011:1: ( 'ref' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4011:1: ( 'ref' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4011:3: 'ref' ( ( RULE_ID ) )
            {
            match(input,60,FOLLOW_60_in_ruleRefSAPoint6335); 

                    createLeafNode(grammarAccess.getRefSAPointAccess().getRefKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4015:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4016:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4016:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4017:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRefSAPointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefSAPoint6353); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4037:1: entryRuleRelaySAPoint returns [EObject current=null] : iv_ruleRelaySAPoint= ruleRelaySAPoint EOF ;
    public final EObject entryRuleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelaySAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4038:2: (iv_ruleRelaySAPoint= ruleRelaySAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4039:2: iv_ruleRelaySAPoint= ruleRelaySAPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelaySAPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelaySAPoint_in_entryRuleRelaySAPoint6389);
            iv_ruleRelaySAPoint=ruleRelaySAPoint();
            _fsp--;

             current =iv_ruleRelaySAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelaySAPoint6399); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4046:1: ruleRelaySAPoint returns [EObject current=null] : ( 'relay_sap' ( ( RULE_ID ) ) ) ;
    public final EObject ruleRelaySAPoint() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4051:6: ( ( 'relay_sap' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4052:1: ( 'relay_sap' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4052:1: ( 'relay_sap' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4052:3: 'relay_sap' ( ( RULE_ID ) )
            {
            match(input,61,FOLLOW_61_in_ruleRelaySAPoint6434); 

                    createLeafNode(grammarAccess.getRelaySAPointAccess().getRelay_sapKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4056:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4057:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4057:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4058:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRelaySAPointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRelaySAPoint6452); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4078:1: entryRuleSPPoint returns [EObject current=null] : iv_ruleSPPoint= ruleSPPoint EOF ;
    public final EObject entryRuleSPPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4079:2: (iv_ruleSPPoint= ruleSPPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4080:2: iv_ruleSPPoint= ruleSPPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSPPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleSPPoint_in_entryRuleSPPoint6488);
            iv_ruleSPPoint=ruleSPPoint();
            _fsp--;

             current =iv_ruleSPPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSPPoint6498); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4087:1: ruleSPPoint returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ) ;
    public final EObject ruleSPPoint() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4092:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4093:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4093:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4093:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4093:2: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4094:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4094:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4095:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSPPointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPoint6541); 

            		createLeafNode(grammarAccess.getSPPointAccess().getRefActorContainerRefCrossReference_0_0(), "ref"); 
            	

            }


            }

            match(input,55,FOLLOW_55_in_ruleSPPoint6551); 

                    createLeafNode(grammarAccess.getSPPointAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4111:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4112:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4112:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4113:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSPPointRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPoint6569); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4133:1: entryRuleActorRef returns [EObject current=null] : iv_ruleActorRef= ruleActorRef EOF ;
    public final EObject entryRuleActorRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4134:2: (iv_ruleActorRef= ruleActorRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4135:2: iv_ruleActorRef= ruleActorRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActorRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleActorRef_in_entryRuleActorRef6605);
            iv_ruleActorRef=ruleActorRef();
            _fsp--;

             current =iv_ruleActorRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorRef6615); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4142:1: ruleActorRef returns [EObject current=null] : ( 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleActorRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_docu_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4147:6: ( ( 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4148:1: ( 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4148:1: ( 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4148:3: 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            match(input,62,FOLLOW_62_in_ruleActorRef6650); 

                    createLeafNode(grammarAccess.getActorRefAccess().getActorRefKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4152:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4153:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4153:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4154:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorRef6667); 

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

            match(input,14,FOLLOW_14_in_ruleActorRef6682); 

                    createLeafNode(grammarAccess.getActorRefAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4180:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4181:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4181:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4182:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getActorRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getActorRefAccess().getTypeActorClassCrossReference_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleActorRef6705);
            ruleFQN();
            _fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4196:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==18) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4197:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4197:1: (lv_docu_4_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4198:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getActorRefAccess().getDocuDocumentationParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleActorRef6726);
                    lv_docu_4_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getActorRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_4_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


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
    // $ANTLR end ruleActorRef


    // $ANTLR start entryRuleStateGraphNode
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4228:1: entryRuleStateGraphNode returns [EObject current=null] : iv_ruleStateGraphNode= ruleStateGraphNode EOF ;
    public final EObject entryRuleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraphNode = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4229:2: (iv_ruleStateGraphNode= ruleStateGraphNode EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4230:2: iv_ruleStateGraphNode= ruleStateGraphNode EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateGraphNodeRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateGraphNode_in_entryRuleStateGraphNode6763);
            iv_ruleStateGraphNode=ruleStateGraphNode();
            _fsp--;

             current =iv_ruleStateGraphNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateGraphNode6773); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4237:1: ruleStateGraphNode returns [EObject current=null] : (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) ;
    public final EObject ruleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_ChoicePoint_1 = null;

        EObject this_TrPoint_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4242:6: ( (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4243:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4243:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            int alt80=3;
            switch ( input.LA(1) ) {
            case 64:
            case 68:
                {
                alt80=1;
                }
                break;
            case 73:
                {
                alt80=2;
                }
                break;
            case 69:
            case 70:
            case 71:
            case 72:
                {
                alt80=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4243:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4244:5: this_State_0= ruleState
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateGraphNodeAccess().getStateParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleState_in_ruleStateGraphNode6820);
                    this_State_0=ruleState();
                    _fsp--;

                     
                            current = this_State_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4254:5: this_ChoicePoint_1= ruleChoicePoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateGraphNodeAccess().getChoicePointParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateGraphNode6847);
                    this_ChoicePoint_1=ruleChoicePoint();
                    _fsp--;

                     
                            current = this_ChoicePoint_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4264:5: this_TrPoint_2= ruleTrPoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateGraphNodeAccess().getTrPointParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateGraphNode6874);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4282:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4283:2: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4284:2: iv_ruleState= ruleState EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateRule(), currentNode); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState6911);
            iv_ruleState=ruleState();
            _fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState6921); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4291:1: ruleState returns [EObject current=null] : (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_BaseState_0 = null;

        EObject this_RefinedState_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4296:6: ( (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4297:1: (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4297:1: (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==64) ) {
                alt81=1;
            }
            else if ( (LA81_0==68) ) {
                alt81=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4297:1: (this_BaseState_0= ruleBaseState | this_RefinedState_1= ruleRefinedState )", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4298:5: this_BaseState_0= ruleBaseState
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateAccess().getBaseStateParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBaseState_in_ruleState6968);
                    this_BaseState_0=ruleBaseState();
                    _fsp--;

                     
                            current = this_BaseState_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4308:5: this_RefinedState_1= ruleRefinedState
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateAccess().getRefinedStateParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRefinedState_in_ruleState6995);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4324:1: entryRuleStateGraph returns [EObject current=null] : iv_ruleStateGraph= ruleStateGraph EOF ;
    public final EObject entryRuleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraph = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4325:2: (iv_ruleStateGraph= ruleStateGraph EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4326:2: iv_ruleStateGraph= ruleStateGraph EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateGraphRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateGraph_in_entryRuleStateGraph7030);
            iv_ruleStateGraph=ruleStateGraph();
            _fsp--;

             current =iv_ruleStateGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateGraph7040); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4333:1: ruleStateGraph returns [EObject current=null] : ( '{' ( ( (lv_states_1_0= ruleState ) ) | ( (lv_trPoints_2_0= ruleTrPoint ) ) | ( (lv_chPoints_3_0= ruleChoicePoint ) ) | ( (lv_transitions_4_0= ruleTransition ) ) )+ '}' ) ;
    public final EObject ruleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject lv_states_1_0 = null;

        EObject lv_trPoints_2_0 = null;

        EObject lv_chPoints_3_0 = null;

        EObject lv_transitions_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4338:6: ( ( '{' ( ( (lv_states_1_0= ruleState ) ) | ( (lv_trPoints_2_0= ruleTrPoint ) ) | ( (lv_chPoints_3_0= ruleChoicePoint ) ) | ( (lv_transitions_4_0= ruleTransition ) ) )+ '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4339:1: ( '{' ( ( (lv_states_1_0= ruleState ) ) | ( (lv_trPoints_2_0= ruleTrPoint ) ) | ( (lv_chPoints_3_0= ruleChoicePoint ) ) | ( (lv_transitions_4_0= ruleTransition ) ) )+ '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4339:1: ( '{' ( ( (lv_states_1_0= ruleState ) ) | ( (lv_trPoints_2_0= ruleTrPoint ) ) | ( (lv_chPoints_3_0= ruleChoicePoint ) ) | ( (lv_transitions_4_0= ruleTransition ) ) )+ '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4339:3: '{' ( ( (lv_states_1_0= ruleState ) ) | ( (lv_trPoints_2_0= ruleTrPoint ) ) | ( (lv_chPoints_3_0= ruleChoicePoint ) ) | ( (lv_transitions_4_0= ruleTransition ) ) )+ '}'
            {
            match(input,12,FOLLOW_12_in_ruleStateGraph7075); 

                    createLeafNode(grammarAccess.getStateGraphAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4343:1: ( ( (lv_states_1_0= ruleState ) ) | ( (lv_trPoints_2_0= ruleTrPoint ) ) | ( (lv_chPoints_3_0= ruleChoicePoint ) ) | ( (lv_transitions_4_0= ruleTransition ) ) )+
            int cnt82=0;
            loop82:
            do {
                int alt82=5;
                switch ( input.LA(1) ) {
                case 64:
                case 68:
                    {
                    alt82=1;
                    }
                    break;
                case 69:
                case 70:
                case 71:
                case 72:
                    {
                    alt82=2;
                    }
                    break;
                case 73:
                    {
                    alt82=3;
                    }
                    break;
                case 74:
                    {
                    alt82=4;
                    }
                    break;

                }

                switch (alt82) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4343:2: ( (lv_states_1_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4343:2: ( (lv_states_1_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4344:1: (lv_states_1_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4344:1: (lv_states_1_0= ruleState )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4345:3: lv_states_1_0= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateGraphAccess().getStatesStateParserRuleCall_1_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateGraph7097);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4368:6: ( (lv_trPoints_2_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4368:6: ( (lv_trPoints_2_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4369:1: (lv_trPoints_2_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4369:1: (lv_trPoints_2_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4370:3: lv_trPoints_2_0= ruleTrPoint
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateGraphAccess().getTrPointsTrPointParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateGraph7124);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4393:6: ( (lv_chPoints_3_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4393:6: ( (lv_chPoints_3_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4394:1: (lv_chPoints_3_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4394:1: (lv_chPoints_3_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4395:3: lv_chPoints_3_0= ruleChoicePoint
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateGraphAccess().getChPointsChoicePointParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateGraph7151);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4418:6: ( (lv_transitions_4_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4418:6: ( (lv_transitions_4_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4419:1: (lv_transitions_4_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4419:1: (lv_transitions_4_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4420:3: lv_transitions_4_0= ruleTransition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateGraphAccess().getTransitionsTransitionParserRuleCall_1_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleStateGraph7178);
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
            	    if ( cnt82 >= 1 ) break loop82;
                        EarlyExitException eee =
                            new EarlyExitException(82, input);
                        throw eee;
                }
                cnt82++;
            } while (true);

            match(input,13,FOLLOW_13_in_ruleStateGraph7190); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4454:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4455:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4456:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateMachineRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateMachine_in_entryRuleStateMachine7226);
            iv_ruleStateMachine=ruleStateMachine();
            _fsp--;

             current =iv_ruleStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateMachine7236); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4463:1: ruleStateMachine returns [EObject current=null] : ( 'StateMachine' '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )+ '}' ) ;
    public final EObject ruleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject lv_states_2_0 = null;

        EObject lv_trPoints_3_0 = null;

        EObject lv_chPoints_4_0 = null;

        EObject lv_transitions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4468:6: ( ( 'StateMachine' '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )+ '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4469:1: ( 'StateMachine' '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )+ '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4469:1: ( 'StateMachine' '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )+ '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4469:3: 'StateMachine' '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )+ '}'
            {
            match(input,63,FOLLOW_63_in_ruleStateMachine7271); 

                    createLeafNode(grammarAccess.getStateMachineAccess().getStateMachineKeyword_0(), null); 
                
            match(input,12,FOLLOW_12_in_ruleStateMachine7281); 

                    createLeafNode(grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4477:1: ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )+
            int cnt83=0;
            loop83:
            do {
                int alt83=5;
                switch ( input.LA(1) ) {
                case 64:
                case 68:
                    {
                    alt83=1;
                    }
                    break;
                case 69:
                case 70:
                case 71:
                case 72:
                    {
                    alt83=2;
                    }
                    break;
                case 73:
                    {
                    alt83=3;
                    }
                    break;
                case 74:
                    {
                    alt83=4;
                    }
                    break;

                }

                switch (alt83) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4477:2: ( (lv_states_2_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4477:2: ( (lv_states_2_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4478:1: (lv_states_2_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4478:1: (lv_states_2_0= ruleState )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4479:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_2_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateMachine7303);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4502:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4502:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4503:1: (lv_trPoints_3_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4503:1: (lv_trPoints_3_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4504:3: lv_trPoints_3_0= ruleTrPoint
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getTrPointsTrPointParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateMachine7330);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4527:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4527:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4528:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4528:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4529:3: lv_chPoints_4_0= ruleChoicePoint
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getChPointsChoicePointParserRuleCall_2_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateMachine7357);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4552:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4552:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4553:1: (lv_transitions_5_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4553:1: (lv_transitions_5_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4554:3: lv_transitions_5_0= ruleTransition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_2_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleStateMachine7384);
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
            	    if ( cnt83 >= 1 ) break loop83;
                        EarlyExitException eee =
                            new EarlyExitException(83, input);
                        throw eee;
                }
                cnt83++;
            } while (true);

            match(input,13,FOLLOW_13_in_ruleStateMachine7396); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4588:1: entryRuleBaseState returns [EObject current=null] : iv_ruleBaseState= ruleBaseState EOF ;
    public final EObject entryRuleBaseState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4589:2: (iv_ruleBaseState= ruleBaseState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4590:2: iv_ruleBaseState= ruleBaseState EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBaseStateRule(), currentNode); 
            pushFollow(FOLLOW_ruleBaseState_in_entryRuleBaseState7432);
            iv_ruleBaseState=ruleBaseState();
            _fsp--;

             current =iv_ruleBaseState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBaseState7442); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4597:1: ruleBaseState returns [EObject current=null] : ( 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( '{' ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )? '}' )? ) ;
    public final EObject ruleBaseState() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;

        EObject lv_entryCode_5_0 = null;

        EObject lv_exitCode_7_0 = null;

        EObject lv_subgraph_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4602:6: ( ( 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( '{' ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )? '}' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4603:1: ( 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( '{' ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )? '}' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4603:1: ( 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( '{' ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )? '}' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4603:3: 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ( '{' ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )? '}' )?
            {
            match(input,64,FOLLOW_64_in_ruleBaseState7477); 

                    createLeafNode(grammarAccess.getBaseStateAccess().getStateKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4607:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4608:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4608:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4609:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBaseState7494); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4631:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==18) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4632:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4632:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4633:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBaseStateAccess().getDocuDocumentationParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleBaseState7520);
                    lv_docu_2_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBaseStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_2_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4655:3: ( '{' ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )? '}' )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==12) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4655:5: '{' ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )? '}'
                    {
                    match(input,12,FOLLOW_12_in_ruleBaseState7532); 

                            createLeafNode(grammarAccess.getBaseStateAccess().getLeftCurlyBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4659:1: ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==65) ) {
                        alt85=1;
                    }
                    switch (alt85) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4659:3: 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                            {
                            match(input,65,FOLLOW_65_in_ruleBaseState7543); 

                                    createLeafNode(grammarAccess.getBaseStateAccess().getEntryKeyword_3_1_0(), null); 
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4663:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4664:1: (lv_entryCode_5_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4664:1: (lv_entryCode_5_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4665:3: lv_entryCode_5_0= ruleDetailCode
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getBaseStateAccess().getEntryCodeDetailCodeParserRuleCall_3_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleBaseState7564);
                            lv_entryCode_5_0=ruleDetailCode();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getBaseStateRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"entryCode",
                            	        		lv_entryCode_5_0, 
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4687:4: ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==66) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4687:6: 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                            {
                            match(input,66,FOLLOW_66_in_ruleBaseState7577); 

                                    createLeafNode(grammarAccess.getBaseStateAccess().getExitKeyword_3_2_0(), null); 
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4691:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4692:1: (lv_exitCode_7_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4692:1: (lv_exitCode_7_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4693:3: lv_exitCode_7_0= ruleDetailCode
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getBaseStateAccess().getExitCodeDetailCodeParserRuleCall_3_2_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleBaseState7598);
                            lv_exitCode_7_0=ruleDetailCode();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getBaseStateRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"exitCode",
                            	        		lv_exitCode_7_0, 
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4715:4: ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==67) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4715:6: 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) )
                            {
                            match(input,67,FOLLOW_67_in_ruleBaseState7611); 

                                    createLeafNode(grammarAccess.getBaseStateAccess().getSubgraphKeyword_3_3_0(), null); 
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4719:1: ( (lv_subgraph_9_0= ruleStateGraph ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4720:1: (lv_subgraph_9_0= ruleStateGraph )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4720:1: (lv_subgraph_9_0= ruleStateGraph )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4721:3: lv_subgraph_9_0= ruleStateGraph
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getBaseStateAccess().getSubgraphStateGraphParserRuleCall_3_3_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleStateGraph_in_ruleBaseState7632);
                            lv_subgraph_9_0=ruleStateGraph();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getBaseStateRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"subgraph",
                            	        		lv_subgraph_9_0, 
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

                    match(input,13,FOLLOW_13_in_ruleBaseState7644); 

                            createLeafNode(grammarAccess.getBaseStateAccess().getRightCurlyBracketKeyword_3_4(), null); 
                        

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
    // $ANTLR end ruleBaseState


    // $ANTLR start entryRuleRefinedState
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4755:1: entryRuleRefinedState returns [EObject current=null] : iv_ruleRefinedState= ruleRefinedState EOF ;
    public final EObject entryRuleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4756:2: (iv_ruleRefinedState= ruleRefinedState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4757:2: iv_ruleRefinedState= ruleRefinedState EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRefinedStateRule(), currentNode); 
            pushFollow(FOLLOW_ruleRefinedState_in_entryRuleRefinedState7682);
            iv_ruleRefinedState=ruleRefinedState();
            _fsp--;

             current =iv_ruleRefinedState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefinedState7692); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4764:1: ruleRefinedState returns [EObject current=null] : ( 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )? '}' ) ;
    public final EObject ruleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject lv_docu_2_0 = null;

        EObject lv_entryCode_5_0 = null;

        EObject lv_exitCode_7_0 = null;

        EObject lv_subgraph_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4769:6: ( ( 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4770:1: ( 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4770:1: ( 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4770:3: 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? '{' ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )? '}'
            {
            match(input,68,FOLLOW_68_in_ruleRefinedState7727); 

                    createLeafNode(grammarAccess.getRefinedStateAccess().getRefinedStateKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4774:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4775:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4775:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4776:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRefinedStateRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getRefinedStateAccess().getBaseBaseStateCrossReference_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRefinedState7750);
            ruleFQN();
            _fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4790:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==18) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4791:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4791:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4792:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRefinedStateAccess().getDocuDocumentationParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleRefinedState7771);
                    lv_docu_2_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRefinedStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_2_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleRefinedState7782); 

                    createLeafNode(grammarAccess.getRefinedStateAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4818:1: ( 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==65) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4818:3: 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                    {
                    match(input,65,FOLLOW_65_in_ruleRefinedState7793); 

                            createLeafNode(grammarAccess.getRefinedStateAccess().getEntryKeyword_4_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4822:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4823:1: (lv_entryCode_5_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4823:1: (lv_entryCode_5_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4824:3: lv_entryCode_5_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRefinedStateAccess().getEntryCodeDetailCodeParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState7814);
                    lv_entryCode_5_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRefinedStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"entryCode",
                    	        		lv_entryCode_5_0, 
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4846:4: ( 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==66) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4846:6: 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                    {
                    match(input,66,FOLLOW_66_in_ruleRefinedState7827); 

                            createLeafNode(grammarAccess.getRefinedStateAccess().getExitKeyword_5_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4850:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4851:1: (lv_exitCode_7_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4851:1: (lv_exitCode_7_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4852:3: lv_exitCode_7_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRefinedStateAccess().getExitCodeDetailCodeParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState7848);
                    lv_exitCode_7_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRefinedStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exitCode",
                    	        		lv_exitCode_7_0, 
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4874:4: ( 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==67) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4874:6: 'subgraph' ( (lv_subgraph_9_0= ruleStateGraph ) )
                    {
                    match(input,67,FOLLOW_67_in_ruleRefinedState7861); 

                            createLeafNode(grammarAccess.getRefinedStateAccess().getSubgraphKeyword_6_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4878:1: ( (lv_subgraph_9_0= ruleStateGraph ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4879:1: (lv_subgraph_9_0= ruleStateGraph )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4879:1: (lv_subgraph_9_0= ruleStateGraph )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4880:3: lv_subgraph_9_0= ruleStateGraph
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRefinedStateAccess().getSubgraphStateGraphParserRuleCall_6_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleStateGraph_in_ruleRefinedState7882);
                    lv_subgraph_9_0=ruleStateGraph();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRefinedStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"subgraph",
                    	        		lv_subgraph_9_0, 
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

            match(input,13,FOLLOW_13_in_ruleRefinedState7894); 

                    createLeafNode(grammarAccess.getRefinedStateAccess().getRightCurlyBracketKeyword_7(), null); 
                

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4914:1: entryRuleDetailCode returns [EObject current=null] : iv_ruleDetailCode= ruleDetailCode EOF ;
    public final EObject entryRuleDetailCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailCode = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4915:2: (iv_ruleDetailCode= ruleDetailCode EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4916:2: iv_ruleDetailCode= ruleDetailCode EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDetailCodeRule(), currentNode); 
            pushFollow(FOLLOW_ruleDetailCode_in_entryRuleDetailCode7930);
            iv_ruleDetailCode=ruleDetailCode();
            _fsp--;

             current =iv_ruleDetailCode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDetailCode7940); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4923:1: ruleDetailCode returns [EObject current=null] : ( '{' ( (lv_commands_1_0= RULE_STRING ) )+ '}' ) ;
    public final EObject ruleDetailCode() throws RecognitionException {
        EObject current = null;

        Token lv_commands_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4928:6: ( ( '{' ( (lv_commands_1_0= RULE_STRING ) )+ '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4929:1: ( '{' ( (lv_commands_1_0= RULE_STRING ) )+ '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4929:1: ( '{' ( (lv_commands_1_0= RULE_STRING ) )+ '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4929:3: '{' ( (lv_commands_1_0= RULE_STRING ) )+ '}'
            {
            match(input,12,FOLLOW_12_in_ruleDetailCode7975); 

                    createLeafNode(grammarAccess.getDetailCodeAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4933:1: ( (lv_commands_1_0= RULE_STRING ) )+
            int cnt93=0;
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==RULE_STRING) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4934:1: (lv_commands_1_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4934:1: (lv_commands_1_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4935:3: lv_commands_1_0= RULE_STRING
            	    {
            	    lv_commands_1_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDetailCode7992); 

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
            	    if ( cnt93 >= 1 ) break loop93;
                        EarlyExitException eee =
                            new EarlyExitException(93, input);
                        throw eee;
                }
                cnt93++;
            } while (true);

            match(input,13,FOLLOW_13_in_ruleDetailCode8008); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4969:1: entryRuleTrPoint returns [EObject current=null] : iv_ruleTrPoint= ruleTrPoint EOF ;
    public final EObject entryRuleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4970:2: (iv_ruleTrPoint= ruleTrPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4971:2: iv_ruleTrPoint= ruleTrPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTrPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleTrPoint_in_entryRuleTrPoint8044);
            iv_ruleTrPoint=ruleTrPoint();
            _fsp--;

             current =iv_ruleTrPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPoint8054); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4978:1: ruleTrPoint returns [EObject current=null] : (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) ;
    public final EObject ruleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionPoint_0 = null;

        EObject this_EntryPoint_1 = null;

        EObject this_ExitPoint_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4983:6: ( (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4984:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4984:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            int alt94=3;
            switch ( input.LA(1) ) {
            case 69:
            case 70:
                {
                alt94=1;
                }
                break;
            case 71:
                {
                alt94=2;
                }
                break;
            case 72:
                {
                alt94=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4984:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4985:5: this_TransitionPoint_0= ruleTransitionPoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTrPointAccess().getTransitionPointParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTransitionPoint_in_ruleTrPoint8101);
                    this_TransitionPoint_0=ruleTransitionPoint();
                    _fsp--;

                     
                            current = this_TransitionPoint_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4995:5: this_EntryPoint_1= ruleEntryPoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTrPointAccess().getEntryPointParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntryPoint_in_ruleTrPoint8128);
                    this_EntryPoint_1=ruleEntryPoint();
                    _fsp--;

                     
                            current = this_EntryPoint_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5005:5: this_ExitPoint_2= ruleExitPoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTrPointAccess().getExitPointParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExitPoint_in_ruleTrPoint8155);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5021:1: entryRuleTransitionPoint returns [EObject current=null] : iv_ruleTransitionPoint= ruleTransitionPoint EOF ;
    public final EObject entryRuleTransitionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5022:2: (iv_ruleTransitionPoint= ruleTransitionPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5023:2: iv_ruleTransitionPoint= ruleTransitionPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransitionPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint8190);
            iv_ruleTransitionPoint=ruleTransitionPoint();
            _fsp--;

             current =iv_ruleTransitionPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionPoint8200); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5030:1: ruleTransitionPoint returns [EObject current=null] : ( ( (lv_handler_0_0= 'handler' ) )? 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTransitionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_handler_0_0=null;
        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5035:6: ( ( ( (lv_handler_0_0= 'handler' ) )? 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5036:1: ( ( (lv_handler_0_0= 'handler' ) )? 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5036:1: ( ( (lv_handler_0_0= 'handler' ) )? 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5036:2: ( (lv_handler_0_0= 'handler' ) )? 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5036:2: ( (lv_handler_0_0= 'handler' ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==69) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5037:1: (lv_handler_0_0= 'handler' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5037:1: (lv_handler_0_0= 'handler' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5038:3: lv_handler_0_0= 'handler'
                    {
                    lv_handler_0_0=(Token)input.LT(1);
                    match(input,69,FOLLOW_69_in_ruleTransitionPoint8243); 

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

            match(input,70,FOLLOW_70_in_ruleTransitionPoint8267); 

                    createLeafNode(grammarAccess.getTransitionPointAccess().getTransitionPointKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5061:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5062:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5062:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5063:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransitionPoint8284); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5093:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5094:2: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5095:2: iv_ruleEntryPoint= ruleEntryPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntryPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint8325);
            iv_ruleEntryPoint=ruleEntryPoint();
            _fsp--;

             current =iv_ruleEntryPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryPoint8335); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5102:1: ruleEntryPoint returns [EObject current=null] : ( 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5107:6: ( ( 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5108:1: ( 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5108:1: ( 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5108:3: 'EntryPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,71,FOLLOW_71_in_ruleEntryPoint8370); 

                    createLeafNode(grammarAccess.getEntryPointAccess().getEntryPointKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5112:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5113:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5113:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5114:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntryPoint8387); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5144:1: entryRuleExitPoint returns [EObject current=null] : iv_ruleExitPoint= ruleExitPoint EOF ;
    public final EObject entryRuleExitPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5145:2: (iv_ruleExitPoint= ruleExitPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5146:2: iv_ruleExitPoint= ruleExitPoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExitPointRule(), currentNode); 
            pushFollow(FOLLOW_ruleExitPoint_in_entryRuleExitPoint8428);
            iv_ruleExitPoint=ruleExitPoint();
            _fsp--;

             current =iv_ruleExitPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitPoint8438); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5153:1: ruleExitPoint returns [EObject current=null] : ( 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitPoint() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5158:6: ( ( 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5159:1: ( 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5159:1: ( 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5159:3: 'ExitPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,72,FOLLOW_72_in_ruleExitPoint8473); 

                    createLeafNode(grammarAccess.getExitPointAccess().getExitPointKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5163:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5164:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5164:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5165:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitPoint8490); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5195:1: entryRuleChoicePoint returns [EObject current=null] : iv_ruleChoicePoint= ruleChoicePoint EOF ;
    public final EObject entryRuleChoicePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicePoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5196:2: (iv_ruleChoicePoint= ruleChoicePoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5197:2: iv_ruleChoicePoint= ruleChoicePoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChoicePointRule(), currentNode); 
            pushFollow(FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint8531);
            iv_ruleChoicePoint=ruleChoicePoint();
            _fsp--;

             current =iv_ruleChoicePoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicePoint8541); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5204:1: ruleChoicePoint returns [EObject current=null] : ( 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) ;
    public final EObject ruleChoicePoint() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5209:6: ( ( 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5210:1: ( 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5210:1: ( 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5210:3: 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )?
            {
            match(input,73,FOLLOW_73_in_ruleChoicePoint8576); 

                    createLeafNode(grammarAccess.getChoicePointAccess().getChoicePointKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5214:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5215:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5215:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5216:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicePoint8593); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5238:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==18) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5239:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5239:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5240:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getChoicePointAccess().getDocuDocumentationParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleChoicePoint8619);
                    lv_docu_2_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getChoicePointRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_2_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


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
    // $ANTLR end ruleChoicePoint


    // $ANTLR start entryRuleTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5270:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5271:2: (iv_ruleTransition= ruleTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5272:2: iv_ruleTransition= ruleTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition8656);
            iv_ruleTransition=ruleTransition();
            _fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition8666); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5279:1: ruleTransition returns [EObject current=null] : (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_InitialTransition_0 = null;

        EObject this_NonInitialTransition_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5284:6: ( (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5285:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5285:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==74) ) {
                int LA97_1 = input.LA(2);

                if ( (LA97_1==RULE_ID) ) {
                    int LA97_2 = input.LA(3);

                    if ( (LA97_2==14) ) {
                        int LA97_3 = input.LA(4);

                        if ( (LA97_3==75) ) {
                            alt97=1;
                        }
                        else if ( (LA97_3==RULE_ID||(LA97_3>=80 && LA97_3<=81)) ) {
                            alt97=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("5285:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )", 97, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("5285:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )", 97, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA97_1==14) ) {
                    int LA97_3 = input.LA(3);

                    if ( (LA97_3==75) ) {
                        alt97=1;
                    }
                    else if ( (LA97_3==RULE_ID||(LA97_3>=80 && LA97_3<=81)) ) {
                        alt97=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("5285:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )", 97, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("5285:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )", 97, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("5285:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5286:5: this_InitialTransition_0= ruleInitialTransition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getInitialTransitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInitialTransition_in_ruleTransition8713);
                    this_InitialTransition_0=ruleInitialTransition();
                    _fsp--;

                     
                            current = this_InitialTransition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5296:5: this_NonInitialTransition_1= ruleNonInitialTransition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getNonInitialTransitionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNonInitialTransition_in_ruleTransition8740);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5312:1: entryRuleNonInitialTransition returns [EObject current=null] : iv_ruleNonInitialTransition= ruleNonInitialTransition EOF ;
    public final EObject entryRuleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5313:2: (iv_ruleNonInitialTransition= ruleNonInitialTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5314:2: iv_ruleNonInitialTransition= ruleNonInitialTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNonInitialTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition8775);
            iv_ruleNonInitialTransition=ruleNonInitialTransition();
            _fsp--;

             current =iv_ruleNonInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonInitialTransition8785); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5321:1: ruleNonInitialTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) ;
    public final EObject ruleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_ContinuationTransition_1 = null;

        EObject this_CPBranchTransition_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5326:6: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5327:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5327:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            int alt98=3;
            alt98 = dfa98.predict(input);
            switch (alt98) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5328:5: this_TriggeredTransition_0= ruleTriggeredTransition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNonInitialTransitionAccess().getTriggeredTransitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTriggeredTransition_in_ruleNonInitialTransition8832);
                    this_TriggeredTransition_0=ruleTriggeredTransition();
                    _fsp--;

                     
                            current = this_TriggeredTransition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5338:5: this_ContinuationTransition_1= ruleContinuationTransition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNonInitialTransitionAccess().getContinuationTransitionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition8859);
                    this_ContinuationTransition_1=ruleContinuationTransition();
                    _fsp--;

                     
                            current = this_ContinuationTransition_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5348:5: this_CPBranchTransition_2= ruleCPBranchTransition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNonInitialTransitionAccess().getCPBranchTransitionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition8886);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5364:1: entryRuleInitialTransition returns [EObject current=null] : iv_ruleInitialTransition= ruleInitialTransition EOF ;
    public final EObject entryRuleInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5365:2: (iv_ruleInitialTransition= ruleInitialTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5366:2: iv_ruleInitialTransition= ruleInitialTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInitialTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition8921);
            iv_ruleInitialTransition=ruleInitialTransition();
            _fsp--;

             current =iv_ruleInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInitialTransition8931); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5373:1: ruleInitialTransition returns [EObject current=null] : ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' 'initial' '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? '}' ) ;
    public final EObject ruleInitialTransition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_action_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5378:6: ( ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' 'initial' '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5379:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' 'initial' '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5379:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' 'initial' '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5379:3: 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' 'initial' '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? '}'
            {
            match(input,74,FOLLOW_74_in_ruleInitialTransition8966); 

                    createLeafNode(grammarAccess.getInitialTransitionAccess().getTransitionKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5383:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==RULE_ID) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5384:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5384:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5385:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInitialTransition8983); 

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

            match(input,14,FOLLOW_14_in_ruleInitialTransition8999); 

                    createLeafNode(grammarAccess.getInitialTransitionAccess().getColonKeyword_2(), null); 
                
            match(input,75,FOLLOW_75_in_ruleInitialTransition9009); 

                    createLeafNode(grammarAccess.getInitialTransitionAccess().getInitialKeyword_3(), null); 
                
            match(input,37,FOLLOW_37_in_ruleInitialTransition9019); 

                    createLeafNode(grammarAccess.getInitialTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5419:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5420:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5420:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5421:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getInitialTransitionAccess().getToTransitionTerminalParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition9040);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5443:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==18) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5444:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5444:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5445:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInitialTransitionAccess().getDocuDocumentationParserRuleCall_6_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleInitialTransition9061);
                    lv_docu_6_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getInitialTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_6_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleInitialTransition9072); 

                    createLeafNode(grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5471:1: ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==76) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5471:3: 'action' ( (lv_action_9_0= ruleDetailCode ) )
                    {
                    match(input,76,FOLLOW_76_in_ruleInitialTransition9083); 

                            createLeafNode(grammarAccess.getInitialTransitionAccess().getActionKeyword_8_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5475:1: ( (lv_action_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5476:1: (lv_action_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5476:1: (lv_action_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5477:3: lv_action_9_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInitialTransitionAccess().getActionDetailCodeParserRuleCall_8_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleInitialTransition9104);
                    lv_action_9_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getInitialTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"action",
                    	        		lv_action_9_0, 
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

            match(input,13,FOLLOW_13_in_ruleInitialTransition9116); 

                    createLeafNode(grammarAccess.getInitialTransitionAccess().getRightCurlyBracketKeyword_9(), null); 
                

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5511:1: entryRuleContinuationTransition returns [EObject current=null] : iv_ruleContinuationTransition= ruleContinuationTransition EOF ;
    public final EObject entryRuleContinuationTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuationTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5512:2: (iv_ruleContinuationTransition= ruleContinuationTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5513:2: iv_ruleContinuationTransition= ruleContinuationTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getContinuationTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition9152);
            iv_ruleContinuationTransition=ruleContinuationTransition();
            _fsp--;

             current =iv_ruleContinuationTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContinuationTransition9162); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5520:1: ruleContinuationTransition returns [EObject current=null] : ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ( '{' ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? '}' )? ) ;
    public final EObject ruleContinuationTransition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_action_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5525:6: ( ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ( '{' ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? '}' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5526:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ( '{' ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? '}' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5526:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ( '{' ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? '}' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5526:3: 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ( '{' ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? '}' )?
            {
            match(input,74,FOLLOW_74_in_ruleContinuationTransition9197); 

                    createLeafNode(grammarAccess.getContinuationTransitionAccess().getTransitionKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5530:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==RULE_ID) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5531:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5531:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5532:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContinuationTransition9214); 

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

            match(input,14,FOLLOW_14_in_ruleContinuationTransition9230); 

                    createLeafNode(grammarAccess.getContinuationTransitionAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5558:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5559:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5559:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5560:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getContinuationTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition9251);
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

            match(input,37,FOLLOW_37_in_ruleContinuationTransition9261); 

                    createLeafNode(grammarAccess.getContinuationTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5586:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5587:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5587:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5588:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getContinuationTransitionAccess().getToTransitionTerminalParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition9282);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5610:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==18) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5611:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5611:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5612:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getContinuationTransitionAccess().getDocuDocumentationParserRuleCall_6_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleContinuationTransition9303);
                    lv_docu_6_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getContinuationTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_6_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5634:3: ( '{' ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? '}' )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==12) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5634:5: '{' ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? '}'
                    {
                    match(input,12,FOLLOW_12_in_ruleContinuationTransition9315); 

                            createLeafNode(grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5638:1: ( 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( (LA104_0==76) ) {
                        alt104=1;
                    }
                    switch (alt104) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5638:3: 'action' ( (lv_action_9_0= ruleDetailCode ) )
                            {
                            match(input,76,FOLLOW_76_in_ruleContinuationTransition9326); 

                                    createLeafNode(grammarAccess.getContinuationTransitionAccess().getActionKeyword_7_1_0(), null); 
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5642:1: ( (lv_action_9_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5643:1: (lv_action_9_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5643:1: (lv_action_9_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5644:3: lv_action_9_0= ruleDetailCode
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getContinuationTransitionAccess().getActionDetailCodeParserRuleCall_7_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleContinuationTransition9347);
                            lv_action_9_0=ruleDetailCode();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getContinuationTransitionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"action",
                            	        		lv_action_9_0, 
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

                    match(input,13,FOLLOW_13_in_ruleContinuationTransition9359); 

                            createLeafNode(grammarAccess.getContinuationTransitionAccess().getRightCurlyBracketKeyword_7_2(), null); 
                        

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
    // $ANTLR end ruleContinuationTransition


    // $ANTLR start entryRuleTriggeredTransition
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5678:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5679:2: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5680:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTriggeredTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition9397);
            iv_ruleTriggeredTransition=ruleTriggeredTransition();
            _fsp--;

             current =iv_ruleTriggeredTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggeredTransition9407); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5687:1: ruleTriggeredTransition returns [EObject current=null] : ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' 'triggers' '{' ( (lv_triggers_10_0= ruleTrigger ) ) ( 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* '}' ( 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? '}' ) ;
    public final EObject ruleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_triggers_10_0 = null;

        EObject lv_triggers_12_0 = null;

        EObject lv_action_15_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5692:6: ( ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' 'triggers' '{' ( (lv_triggers_10_0= ruleTrigger ) ) ( 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* '}' ( 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5693:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' 'triggers' '{' ( (lv_triggers_10_0= ruleTrigger ) ) ( 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* '}' ( 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5693:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' 'triggers' '{' ( (lv_triggers_10_0= ruleTrigger ) ) ( 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* '}' ( 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5693:3: 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' 'triggers' '{' ( (lv_triggers_10_0= ruleTrigger ) ) ( 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* '}' ( 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? '}'
            {
            match(input,74,FOLLOW_74_in_ruleTriggeredTransition9442); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getTransitionKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5697:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==RULE_ID) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5698:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5698:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5699:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggeredTransition9459); 

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

            match(input,14,FOLLOW_14_in_ruleTriggeredTransition9475); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5725:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5726:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5726:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5727:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTriggeredTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition9496);
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

            match(input,37,FOLLOW_37_in_ruleTriggeredTransition9506); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5753:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5754:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5754:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5755:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTriggeredTransitionAccess().getToTransitionTerminalParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition9527);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5777:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==18) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5778:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5778:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5779:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTriggeredTransitionAccess().getDocuDocumentationParserRuleCall_6_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleTriggeredTransition9548);
                    lv_docu_6_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTriggeredTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_6_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleTriggeredTransition9559); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_7(), null); 
                
            match(input,77,FOLLOW_77_in_ruleTriggeredTransition9569); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getTriggersKeyword_8(), null); 
                
            match(input,12,FOLLOW_12_in_ruleTriggeredTransition9579); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_9(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5813:1: ( (lv_triggers_10_0= ruleTrigger ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5814:1: (lv_triggers_10_0= ruleTrigger )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5814:1: (lv_triggers_10_0= ruleTrigger )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5815:3: lv_triggers_10_0= ruleTrigger
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_10_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition9600);
            lv_triggers_10_0=ruleTrigger();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTriggeredTransitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"triggers",
            	        		lv_triggers_10_0, 
            	        		"Trigger", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5837:2: ( 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==78) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5837:4: 'or' ( (lv_triggers_12_0= ruleTrigger ) )
            	    {
            	    match(input,78,FOLLOW_78_in_ruleTriggeredTransition9611); 

            	            createLeafNode(grammarAccess.getTriggeredTransitionAccess().getOrKeyword_11_0(), null); 
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5841:1: ( (lv_triggers_12_0= ruleTrigger ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5842:1: (lv_triggers_12_0= ruleTrigger )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5842:1: (lv_triggers_12_0= ruleTrigger )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5843:3: lv_triggers_12_0= ruleTrigger
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_11_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition9632);
            	    lv_triggers_12_0=ruleTrigger();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTriggeredTransitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"triggers",
            	    	        		lv_triggers_12_0, 
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
            	    break loop108;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleTriggeredTransition9644); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_12(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5869:1: ( 'action' ( (lv_action_15_0= ruleDetailCode ) ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==76) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5869:3: 'action' ( (lv_action_15_0= ruleDetailCode ) )
                    {
                    match(input,76,FOLLOW_76_in_ruleTriggeredTransition9655); 

                            createLeafNode(grammarAccess.getTriggeredTransitionAccess().getActionKeyword_13_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5873:1: ( (lv_action_15_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5874:1: (lv_action_15_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5874:1: (lv_action_15_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5875:3: lv_action_15_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTriggeredTransitionAccess().getActionDetailCodeParserRuleCall_13_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleTriggeredTransition9676);
                    lv_action_15_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTriggeredTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"action",
                    	        		lv_action_15_0, 
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

            match(input,13,FOLLOW_13_in_ruleTriggeredTransition9688); 

                    createLeafNode(grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_14(), null); 
                

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5909:1: entryRuleCPBranchTransition returns [EObject current=null] : iv_ruleCPBranchTransition= ruleCPBranchTransition EOF ;
    public final EObject entryRuleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCPBranchTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5910:2: (iv_ruleCPBranchTransition= ruleCPBranchTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5911:2: iv_ruleCPBranchTransition= ruleCPBranchTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCPBranchTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition9724);
            iv_ruleCPBranchTransition=ruleCPBranchTransition();
            _fsp--;

             current =iv_ruleCPBranchTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCPBranchTransition9734); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5918:1: ruleCPBranchTransition returns [EObject current=null] : ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) ( 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? '}' ) ;
    public final EObject ruleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_condition_9_0 = null;

        EObject lv_action_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5923:6: ( ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) ( 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5924:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) ( 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5924:1: ( 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) ( 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5924:3: 'Transition' ( (lv_name_1_0= RULE_ID ) )? ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? '{' 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) ( 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? '}'
            {
            match(input,74,FOLLOW_74_in_ruleCPBranchTransition9769); 

                    createLeafNode(grammarAccess.getCPBranchTransitionAccess().getTransitionKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5928:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==RULE_ID) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5929:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5929:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5930:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCPBranchTransition9786); 

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

            match(input,14,FOLLOW_14_in_ruleCPBranchTransition9802); 

                    createLeafNode(grammarAccess.getCPBranchTransitionAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5956:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5957:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5957:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5958:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCPBranchTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition9823);
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

            match(input,37,FOLLOW_37_in_ruleCPBranchTransition9833); 

                    createLeafNode(grammarAccess.getCPBranchTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5984:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5985:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5985:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5986:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCPBranchTransitionAccess().getToTransitionTerminalParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition9854);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6008:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==18) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6009:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6009:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6010:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCPBranchTransitionAccess().getDocuDocumentationParserRuleCall_6_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleCPBranchTransition9875);
                    lv_docu_6_0=ruleDocumentation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCPBranchTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"docu",
                    	        		lv_docu_6_0, 
                    	        		"Documentation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleCPBranchTransition9886); 

                    createLeafNode(grammarAccess.getCPBranchTransitionAccess().getLeftCurlyBracketKeyword_7(), null); 
                
            match(input,79,FOLLOW_79_in_ruleCPBranchTransition9896); 

                    createLeafNode(grammarAccess.getCPBranchTransitionAccess().getCondKeyword_8(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6040:1: ( (lv_condition_9_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6041:1: (lv_condition_9_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6041:1: (lv_condition_9_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6042:3: lv_condition_9_0= ruleDetailCode
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCPBranchTransitionAccess().getConditionDetailCodeParserRuleCall_9_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition9917);
            lv_condition_9_0=ruleDetailCode();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCPBranchTransitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"condition",
            	        		lv_condition_9_0, 
            	        		"DetailCode", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6064:2: ( 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==76) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6064:4: 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    match(input,76,FOLLOW_76_in_ruleCPBranchTransition9928); 

                            createLeafNode(grammarAccess.getCPBranchTransitionAccess().getActionKeyword_10_0(), null); 
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6068:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6069:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6069:1: (lv_action_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6070:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCPBranchTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition9949);
                    lv_action_11_0=ruleDetailCode();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCPBranchTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"action",
                    	        		lv_action_11_0, 
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

            match(input,13,FOLLOW_13_in_ruleCPBranchTransition9961); 

                    createLeafNode(grammarAccess.getCPBranchTransitionAccess().getRightCurlyBracketKeyword_11(), null); 
                

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6104:1: entryRuleTransitionTerminal returns [EObject current=null] : iv_ruleTransitionTerminal= ruleTransitionTerminal EOF ;
    public final EObject entryRuleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6105:2: (iv_ruleTransitionTerminal= ruleTransitionTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6106:2: iv_ruleTransitionTerminal= ruleTransitionTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransitionTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal9997);
            iv_ruleTransitionTerminal=ruleTransitionTerminal();
            _fsp--;

             current =iv_ruleTransitionTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionTerminal10007); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6113:1: ruleTransitionTerminal returns [EObject current=null] : (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) ;
    public final EObject ruleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_StateTerminal_0 = null;

        EObject this_TrPointTerminal_1 = null;

        EObject this_SubStateTrPointTerminal_2 = null;

        EObject this_ChoicepointTerminal_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6118:6: ( (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6119:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6119:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            int alt113=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA113_1 = input.LA(2);

                if ( (LA113_1==50) ) {
                    alt113=3;
                }
                else if ( (LA113_1==EOF||(LA113_1>=12 && LA113_1<=13)||LA113_1==18||LA113_1==37||LA113_1==64||(LA113_1>=68 && LA113_1<=74)) ) {
                    alt113=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("6119:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )", 113, 1, input);

                    throw nvae;
                }
                }
                break;
            case 80:
                {
                alt113=2;
                }
                break;
            case 81:
                {
                alt113=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6119:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )", 113, 0, input);

                throw nvae;
            }

            switch (alt113) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6120:5: this_StateTerminal_0= ruleStateTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionTerminalAccess().getStateTerminalParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal10054);
                    this_StateTerminal_0=ruleStateTerminal();
                    _fsp--;

                     
                            current = this_StateTerminal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6130:5: this_TrPointTerminal_1= ruleTrPointTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionTerminalAccess().getTrPointTerminalParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal10081);
                    this_TrPointTerminal_1=ruleTrPointTerminal();
                    _fsp--;

                     
                            current = this_TrPointTerminal_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6140:5: this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionTerminalAccess().getSubStateTrPointTerminalParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal10108);
                    this_SubStateTrPointTerminal_2=ruleSubStateTrPointTerminal();
                    _fsp--;

                     
                            current = this_SubStateTrPointTerminal_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6150:5: this_ChoicepointTerminal_3= ruleChoicepointTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionTerminalAccess().getChoicepointTerminalParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal10135);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6166:1: entryRuleStateTerminal returns [EObject current=null] : iv_ruleStateTerminal= ruleStateTerminal EOF ;
    public final EObject entryRuleStateTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6167:2: (iv_ruleStateTerminal= ruleStateTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6168:2: iv_ruleStateTerminal= ruleStateTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal10170);
            iv_ruleStateTerminal=ruleStateTerminal();
            _fsp--;

             current =iv_ruleStateTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateTerminal10180); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6175:1: ruleStateTerminal returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleStateTerminal() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6180:6: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6181:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6181:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6182:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6182:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6183:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStateTerminalRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStateTerminal10222); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6203:1: entryRuleTrPointTerminal returns [EObject current=null] : iv_ruleTrPointTerminal= ruleTrPointTerminal EOF ;
    public final EObject entryRuleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6204:2: (iv_ruleTrPointTerminal= ruleTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6205:2: iv_ruleTrPointTerminal= ruleTrPointTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTrPointTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal10257);
            iv_ruleTrPointTerminal=ruleTrPointTerminal();
            _fsp--;

             current =iv_ruleTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPointTerminal10267); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6212:1: ruleTrPointTerminal returns [EObject current=null] : ( 'my' ( ( RULE_ID ) ) ) ;
    public final EObject ruleTrPointTerminal() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6217:6: ( ( 'my' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6218:1: ( 'my' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6218:1: ( 'my' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6218:3: 'my' ( ( RULE_ID ) )
            {
            match(input,80,FOLLOW_80_in_ruleTrPointTerminal10302); 

                    createLeafNode(grammarAccess.getTrPointTerminalAccess().getMyKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6222:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6223:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6223:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6224:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTrPointTerminalRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTrPointTerminal10320); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6244:1: entryRuleSubStateTrPointTerminal returns [EObject current=null] : iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF ;
    public final EObject entryRuleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStateTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6245:2: (iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6246:2: iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubStateTrPointTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal10356);
            iv_ruleSubStateTrPointTerminal=ruleSubStateTrPointTerminal();
            _fsp--;

             current =iv_ruleSubStateTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal10366); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6253:1: ruleSubStateTrPointTerminal returns [EObject current=null] : ( ( ( RULE_ID ) ) 'of' ( ( RULE_ID ) ) ) ;
    public final EObject ruleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6258:6: ( ( ( ( RULE_ID ) ) 'of' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6259:1: ( ( ( RULE_ID ) ) 'of' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6259:1: ( ( ( RULE_ID ) ) 'of' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6259:2: ( ( RULE_ID ) ) 'of' ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6259:2: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6260:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6260:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6261:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubStateTrPointTerminalRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal10409); 

            		createLeafNode(grammarAccess.getSubStateTrPointTerminalAccess().getTrPointTrPointCrossReference_0_0(), "trPoint"); 
            	

            }


            }

            match(input,50,FOLLOW_50_in_ruleSubStateTrPointTerminal10419); 

                    createLeafNode(grammarAccess.getSubStateTrPointTerminalAccess().getOfKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6277:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6278:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6278:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6279:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubStateTrPointTerminalRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal10437); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6299:1: entryRuleChoicepointTerminal returns [EObject current=null] : iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF ;
    public final EObject entryRuleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicepointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6300:2: (iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6301:2: iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChoicepointTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal10473);
            iv_ruleChoicepointTerminal=ruleChoicepointTerminal();
            _fsp--;

             current =iv_ruleChoicepointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicepointTerminal10483); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6308:1: ruleChoicepointTerminal returns [EObject current=null] : ( 'cp' ( ( RULE_ID ) ) ) ;
    public final EObject ruleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6313:6: ( ( 'cp' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6314:1: ( 'cp' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6314:1: ( 'cp' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6314:3: 'cp' ( ( RULE_ID ) )
            {
            match(input,81,FOLLOW_81_in_ruleChoicepointTerminal10518); 

                    createLeafNode(grammarAccess.getChoicepointTerminalAccess().getCpKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6318:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6319:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6319:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6320:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getChoicepointTerminalRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicepointTerminal10536); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6340:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6341:2: (iv_ruleTrigger= ruleTrigger EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6342:2: iv_ruleTrigger= ruleTrigger EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTriggerRule(), currentNode); 
            pushFollow(FOLLOW_ruleTrigger_in_entryRuleTrigger10572);
            iv_ruleTrigger=ruleTrigger();
            _fsp--;

             current =iv_ruleTrigger; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrigger10582); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6349:1: ruleTrigger returns [EObject current=null] : ( '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) ( '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? '>' ) ;
    public final EObject ruleTrigger() throws RecognitionException {
        EObject current = null;

        EObject lv_msgFromIfPairs_1_0 = null;

        EObject lv_msgFromIfPairs_3_0 = null;

        EObject lv_guard_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6354:6: ( ( '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) ( '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? '>' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6355:1: ( '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) ( '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? '>' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6355:1: ( '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) ( '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? '>' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6355:3: '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) ( '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? '>'
            {
            match(input,82,FOLLOW_82_in_ruleTrigger10617); 

                    createLeafNode(grammarAccess.getTriggerAccess().getLessThanSignKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6359:1: ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6360:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6360:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6361:3: lv_msgFromIfPairs_1_0= ruleMessageFromIf
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger10638);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6383:2: ( '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==83) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6383:4: '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    {
            	    match(input,83,FOLLOW_83_in_ruleTrigger10649); 

            	            createLeafNode(grammarAccess.getTriggerAccess().getVerticalLineKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6387:1: ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6388:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6388:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6389:3: lv_msgFromIfPairs_3_0= ruleMessageFromIf
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger10670);
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
            	    break loop114;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6411:4: ( (lv_guard_4_0= ruleGuard ) )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==85) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6412:1: (lv_guard_4_0= ruleGuard )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6412:1: (lv_guard_4_0= ruleGuard )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6413:3: lv_guard_4_0= ruleGuard
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTriggerAccess().getGuardGuardParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGuard_in_ruleTrigger10693);
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

            match(input,84,FOLLOW_84_in_ruleTrigger10704); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6447:1: entryRuleMessageFromIf returns [EObject current=null] : iv_ruleMessageFromIf= ruleMessageFromIf EOF ;
    public final EObject entryRuleMessageFromIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageFromIf = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6448:2: (iv_ruleMessageFromIf= ruleMessageFromIf EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6449:2: iv_ruleMessageFromIf= ruleMessageFromIf EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMessageFromIfRule(), currentNode); 
            pushFollow(FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf10740);
            iv_ruleMessageFromIf=ruleMessageFromIf();
            _fsp--;

             current =iv_ruleMessageFromIf; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessageFromIf10750); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6456:1: ruleMessageFromIf returns [EObject current=null] : ( ( ( RULE_ID ) ) ':' ( ( RULE_ID ) ) ) ;
    public final EObject ruleMessageFromIf() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6461:6: ( ( ( ( RULE_ID ) ) ':' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6462:1: ( ( ( RULE_ID ) ) ':' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6462:1: ( ( ( RULE_ID ) ) ':' ( ( RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6462:2: ( ( RULE_ID ) ) ':' ( ( RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6462:2: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6463:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6463:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6464:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getMessageFromIfRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf10793); 

            		createLeafNode(grammarAccess.getMessageFromIfAccess().getMessageMessageCrossReference_0_0(), "message"); 
            	

            }


            }

            match(input,14,FOLLOW_14_in_ruleMessageFromIf10803); 

                    createLeafNode(grammarAccess.getMessageFromIfAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6480:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6481:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6481:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6482:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getMessageFromIfRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf10821); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6502:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6503:2: (iv_ruleGuard= ruleGuard EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6504:2: iv_ruleGuard= ruleGuard EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGuardRule(), currentNode); 
            pushFollow(FOLLOW_ruleGuard_in_entryRuleGuard10857);
            iv_ruleGuard=ruleGuard();
            _fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuard10867); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6511:1: ruleGuard returns [EObject current=null] : ( 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        EObject lv_guard_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6516:6: ( ( 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6517:1: ( 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6517:1: ( 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6517:3: 'guard' ( (lv_guard_1_0= ruleDetailCode ) )
            {
            match(input,85,FOLLOW_85_in_ruleGuard10902); 

                    createLeafNode(grammarAccess.getGuardAccess().getGuardKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6521:1: ( (lv_guard_1_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6522:1: (lv_guard_1_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6522:1: (lv_guard_1_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6523:3: lv_guard_1_0= ruleDetailCode
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getGuardAccess().getGuardDetailCodeParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleGuard10923);
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


    // $ANTLR start entryRuleDocumentation
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6553:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6554:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6555:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDocumentationRule(), currentNode); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation10959);
            iv_ruleDocumentation=ruleDocumentation();
            _fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation10969); 

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
    // $ANTLR end entryRuleDocumentation


    // $ANTLR start ruleDocumentation
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6562:1: ruleDocumentation returns [EObject current=null] : ( '[' ( (lv_text_1_0= RULE_STRING ) )+ ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token lv_text_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6567:6: ( ( '[' ( (lv_text_1_0= RULE_STRING ) )+ ']' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6568:1: ( '[' ( (lv_text_1_0= RULE_STRING ) )+ ']' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6568:1: ( '[' ( (lv_text_1_0= RULE_STRING ) )+ ']' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6568:3: '[' ( (lv_text_1_0= RULE_STRING ) )+ ']'
            {
            match(input,18,FOLLOW_18_in_ruleDocumentation11004); 

                    createLeafNode(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6572:1: ( (lv_text_1_0= RULE_STRING ) )+
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6573:1: (lv_text_1_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6573:1: (lv_text_1_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6574:3: lv_text_1_0= RULE_STRING
            	    {
            	    lv_text_1_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDocumentation11021); 

            	    			createLeafNode(grammarAccess.getDocumentationAccess().getTextSTRINGTerminalRuleCall_1_0(), "text"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getDocumentationRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"text",
            	    	        		lv_text_1_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

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

            match(input,19,FOLLOW_19_in_ruleDocumentation11037); 

                    createLeafNode(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_2(), null); 
                

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
    // $ANTLR end ruleDocumentation


    // $ANTLR start entryRuleImport
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6608:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6609:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6610:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport11073);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport11083); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6617:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6622:6: ( ( 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6623:1: ( 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6623:1: ( 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6623:3: 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            {
            match(input,86,FOLLOW_86_in_ruleImport11118); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6627:1: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6628:1: (lv_importedNamespace_1_0= ruleImportedFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6628:1: (lv_importedNamespace_1_0= ruleImportedFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6629:3: lv_importedNamespace_1_0= ruleImportedFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleImportedFQN_in_ruleImport11139);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6659:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6660:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6661:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportedFQNRule(), currentNode); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN11176);
            iv_ruleImportedFQN=ruleImportedFQN();
            _fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN11187); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6668:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6673:6: ( (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6674:1: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6674:1: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6675:5: this_FQN_0= ruleFQN (kw= '.' kw= '*' )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN11234);
            this_FQN_0=ruleFQN();
            _fsp--;


            		current.merge(this_FQN_0);
                
             
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6685:1: (kw= '.' kw= '*' )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==55) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6686:2: kw= '.' kw= '*'
                    {
                    kw=(Token)input.LT(1);
                    match(input,55,FOLLOW_55_in_ruleImportedFQN11253); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getImportedFQNAccess().getFullStopKeyword_1_0(), null); 
                        
                    kw=(Token)input.LT(1);
                    match(input,87,FOLLOW_87_in_ruleImportedFQN11266); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6705:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6706:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6707:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN11309);
            iv_ruleFQN=ruleFQN();
            _fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN11320); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6714:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6719:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6720:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6720:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6720:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN11360); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6727:1: (kw= '.' this_ID_2= RULE_ID )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==55) ) {
                    int LA118_2 = input.LA(2);

                    if ( (LA118_2==RULE_ID) ) {
                        alt118=1;
                    }


                }


                switch (alt118) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6728:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,55,FOLLOW_55_in_ruleFQN11379); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN11394); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop118;
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6748:1: rulePrimitiveType returns [Enumerator current=null] : ( ( 'void' ) | ( 'int8' ) | ( 'int16' ) | ( 'int32' ) | ( 'uint8' ) | ( 'uint16' ) | ( 'uint32' ) | ( 'float32' ) | ( 'float64' ) | ( 'boolean' ) | ( 'string' ) | ( 'char' ) ) ;
    public final Enumerator rulePrimitiveType() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6752:6: ( ( ( 'void' ) | ( 'int8' ) | ( 'int16' ) | ( 'int32' ) | ( 'uint8' ) | ( 'uint16' ) | ( 'uint32' ) | ( 'float32' ) | ( 'float64' ) | ( 'boolean' ) | ( 'string' ) | ( 'char' ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6753:1: ( ( 'void' ) | ( 'int8' ) | ( 'int16' ) | ( 'int32' ) | ( 'uint8' ) | ( 'uint16' ) | ( 'uint32' ) | ( 'float32' ) | ( 'float64' ) | ( 'boolean' ) | ( 'string' ) | ( 'char' ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6753:1: ( ( 'void' ) | ( 'int8' ) | ( 'int16' ) | ( 'int32' ) | ( 'uint8' ) | ( 'uint16' ) | ( 'uint32' ) | ( 'float32' ) | ( 'float64' ) | ( 'boolean' ) | ( 'string' ) | ( 'char' ) )
            int alt119=12;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt119=1;
                }
                break;
            case 89:
                {
                alt119=2;
                }
                break;
            case 90:
                {
                alt119=3;
                }
                break;
            case 91:
                {
                alt119=4;
                }
                break;
            case 92:
                {
                alt119=5;
                }
                break;
            case 93:
                {
                alt119=6;
                }
                break;
            case 94:
                {
                alt119=7;
                }
                break;
            case 95:
                {
                alt119=8;
                }
                break;
            case 96:
                {
                alt119=9;
                }
                break;
            case 97:
                {
                alt119=10;
                }
                break;
            case 98:
                {
                alt119=11;
                }
                break;
            case 99:
                {
                alt119=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6753:1: ( ( 'void' ) | ( 'int8' ) | ( 'int16' ) | ( 'int32' ) | ( 'uint8' ) | ( 'uint16' ) | ( 'uint32' ) | ( 'float32' ) | ( 'float64' ) | ( 'boolean' ) | ( 'string' ) | ( 'char' ) )", 119, 0, input);

                throw nvae;
            }

            switch (alt119) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6753:2: ( 'void' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6753:2: ( 'void' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6753:4: 'void'
                    {
                    match(input,88,FOLLOW_88_in_rulePrimitiveType11453); 

                            current = grammarAccess.getPrimitiveTypeAccess().getVoidEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getVoidEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6759:6: ( 'int8' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6759:6: ( 'int8' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6759:8: 'int8'
                    {
                    match(input,89,FOLLOW_89_in_rulePrimitiveType11468); 

                            current = grammarAccess.getPrimitiveTypeAccess().getInt8EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getInt8EnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6765:6: ( 'int16' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6765:6: ( 'int16' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6765:8: 'int16'
                    {
                    match(input,90,FOLLOW_90_in_rulePrimitiveType11483); 

                            current = grammarAccess.getPrimitiveTypeAccess().getInt16EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getInt16EnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6771:6: ( 'int32' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6771:6: ( 'int32' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6771:8: 'int32'
                    {
                    match(input,91,FOLLOW_91_in_rulePrimitiveType11498); 

                            current = grammarAccess.getPrimitiveTypeAccess().getInt32EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getInt32EnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6777:6: ( 'uint8' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6777:6: ( 'uint8' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6777:8: 'uint8'
                    {
                    match(input,92,FOLLOW_92_in_rulePrimitiveType11513); 

                            current = grammarAccess.getPrimitiveTypeAccess().getUint8EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getUint8EnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6783:6: ( 'uint16' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6783:6: ( 'uint16' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6783:8: 'uint16'
                    {
                    match(input,93,FOLLOW_93_in_rulePrimitiveType11528); 

                            current = grammarAccess.getPrimitiveTypeAccess().getUint16EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getUint16EnumLiteralDeclaration_5(), null); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6789:6: ( 'uint32' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6789:6: ( 'uint32' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6789:8: 'uint32'
                    {
                    match(input,94,FOLLOW_94_in_rulePrimitiveType11543); 

                            current = grammarAccess.getPrimitiveTypeAccess().getUint32EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getUint32EnumLiteralDeclaration_6(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6795:6: ( 'float32' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6795:6: ( 'float32' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6795:8: 'float32'
                    {
                    match(input,95,FOLLOW_95_in_rulePrimitiveType11558); 

                            current = grammarAccess.getPrimitiveTypeAccess().getFloat32EnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getFloat32EnumLiteralDeclaration_7(), null); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6801:6: ( 'float64' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6801:6: ( 'float64' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6801:8: 'float64'
                    {
                    match(input,96,FOLLOW_96_in_rulePrimitiveType11573); 

                            current = grammarAccess.getPrimitiveTypeAccess().getFloat64EnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getFloat64EnumLiteralDeclaration_8(), null); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6807:6: ( 'boolean' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6807:6: ( 'boolean' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6807:8: 'boolean'
                    {
                    match(input,97,FOLLOW_97_in_rulePrimitiveType11588); 

                            current = grammarAccess.getPrimitiveTypeAccess().getBooleanEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getBooleanEnumLiteralDeclaration_9(), null); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6813:6: ( 'string' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6813:6: ( 'string' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6813:8: 'string'
                    {
                    match(input,98,FOLLOW_98_in_rulePrimitiveType11603); 

                            current = grammarAccess.getPrimitiveTypeAccess().getStringEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getStringEnumLiteralDeclaration_10(), null); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6819:6: ( 'char' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6819:6: ( 'char' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6819:8: 'char'
                    {
                    match(input,99,FOLLOW_99_in_rulePrimitiveType11618); 

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


    protected DFA98 dfa98 = new DFA98(this);
    static final String DFA98_eotS =
        "\32\uffff";
    static final String DFA98_eofS =
        "\14\uffff\1\22\6\uffff\3\22\3\uffff\1\22";
    static final String DFA98_minS =
        "\1\112\1\4\1\16\1\4\1\45\4\4\3\45\1\14\3\4\1\6\1\15\1\uffff\3\14"+
        "\1\6\2\uffff\1\14";
    static final String DFA98_maxS =
        "\1\112\2\16\1\121\1\62\3\4\1\121\3\45\1\112\3\4\1\6\1\117\1\uffff"+
        "\3\112\1\23\2\uffff\1\112";
    static final String DFA98_acceptS =
        "\22\uffff\1\2\4\uffff\1\3\1\1\1\uffff";
    static final String DFA98_specialS =
        "\32\uffff}>";
    static final String[] DFA98_transitionS = {
            "\1\1",
            "\1\2\11\uffff\1\3",
            "\1\3",
            "\1\4\113\uffff\1\5\1\6",
            "\1\10\14\uffff\1\7",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14\113\uffff\1\15\1\16",
            "\1\10",
            "\1\10",
            "\1\10",
            "\1\21\1\22\4\uffff\1\20\37\uffff\1\17\15\uffff\1\22\3\uffff"+
            "\7\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\22\76\uffff\1\22\1\30\1\uffff\1\27",
            "",
            "\1\21\1\22\4\uffff\1\20\55\uffff\1\22\3\uffff\7\22",
            "\1\21\1\22\4\uffff\1\20\55\uffff\1\22\3\uffff\7\22",
            "\1\21\1\22\4\uffff\1\20\55\uffff\1\22\3\uffff\7\22",
            "\1\26\14\uffff\1\31",
            "",
            "",
            "\1\21\1\22\62\uffff\1\22\3\uffff\7\22"
    };

    static final short[] DFA98_eot = DFA.unpackEncodedString(DFA98_eotS);
    static final short[] DFA98_eof = DFA.unpackEncodedString(DFA98_eofS);
    static final char[] DFA98_min = DFA.unpackEncodedStringToUnsignedChars(DFA98_minS);
    static final char[] DFA98_max = DFA.unpackEncodedStringToUnsignedChars(DFA98_maxS);
    static final short[] DFA98_accept = DFA.unpackEncodedString(DFA98_acceptS);
    static final short[] DFA98_special = DFA.unpackEncodedString(DFA98_specialS);
    static final short[][] DFA98_transition;

    static {
        int numStates = DFA98_transitionS.length;
        DFA98_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA98_transition[i] = DFA.unpackEncodedString(DFA98_transitionS[i]);
        }
    }

    class DFA98 extends DFA {

        public DFA98(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 98;
            this.eot = DFA98_eot;
            this.eof = DFA98_eof;
            this.min = DFA98_min;
            this.max = DFA98_max;
            this.accept = DFA98_accept;
            this.special = DFA98_special;
            this.transition = DFA98_transition;
        }
        public String getDescription() {
            return "5327:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )";
        }
    }
 

    public static final BitSet FOLLOW_ruleRoomModel_in_entryRuleRoomModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoomModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRoomModel120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRoomModel141 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRoomModel162 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRoomModel173 = new BitSet(new long[]{0x0028018001008000L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleRoomModel194 = new BitSet(new long[]{0x0028018001008000L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleDataClass_in_ruleRoomModel217 = new BitSet(new long[]{0x002801800100A000L});
    public static final BitSet FOLLOW_ruleProtocolClass_in_ruleRoomModel244 = new BitSet(new long[]{0x002801800100A000L});
    public static final BitSet FOLLOW_ruleActorClass_in_ruleRoomModel271 = new BitSet(new long[]{0x002801800100A000L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_ruleRoomModel298 = new BitSet(new long[]{0x002801800100A000L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_ruleRoomModel325 = new BitSet(new long[]{0x002801800100A000L});
    public static final BitSet FOLLOW_13_in_ruleRoomModel337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructureClass_in_entryRuleStructureClass375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStructureClass385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorContainerClass_in_ruleStructureClass432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_ruleStructureClass459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorContainerClass_in_entryRuleActorContainerClass494 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorContainerClass504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClass_in_ruleActorContainerClass551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_ruleActorContainerClass578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedID_in_entryRuleTypedID613 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedID623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypedID665 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTypedID680 = new BitSet(new long[]{0x0000000000000010L,0x0000000FFF000000L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypedID701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFreeTypedID_in_entryRuleFreeTypedID737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFreeTypedID747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFreeTypedID789 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleFreeTypedID804 = new BitSet(new long[]{0x0000000000000010L,0x0000000FFF000000L});
    public static final BitSet FOLLOW_ruleFreeType_in_ruleFreeTypedID825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType861 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleType917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleType946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFreeType_in_entryRuleFreeType982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFreeType992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleFreeType1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFreeType1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataClass_in_entryRuleDataClass1102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataClass1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDataClass1147 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataClass1164 = new BitSet(new long[]{0x0000000000051000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleDataClass1190 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_16_in_ruleDataClass1202 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleDataClass1225 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDataClass1237 = new BitSet(new long[]{0x0000000000020000L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleDataClass1258 = new BitSet(new long[]{0x0000000000020000L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleDataClass1280 = new BitSet(new long[]{0x0000000000122000L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleDataClass1302 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_13_in_ruleDataClass1313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1349 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleAttribute1394 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1411 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_18_in_ruleAttribute1427 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAttribute1444 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAttribute1459 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAttribute1471 = new BitSet(new long[]{0x0000000000000010L,0x0000000FFF000000L});
    public static final BitSet FOLLOW_ruleType_in_ruleAttribute1492 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleAttribute1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation1550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOperation1595 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperation1612 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleOperation1627 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_ruleFreeTypedID_in_ruleOperation1649 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleOperation1660 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFreeTypedID_in_ruleOperation1681 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_ruleOperation1695 = new BitSet(new long[]{0x0000000000045000L});
    public static final BitSet FOLLOW_14_in_ruleOperation1706 = new BitSet(new long[]{0x0000000000000010L,0x0000000FFF000000L});
    public static final BitSet FOLLOW_ruleFreeType_in_ruleOperation1727 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleOperation1750 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleOperation1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolClass_in_entryRuleProtocolClass1808 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProtocolClass1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleProtocolClass1853 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProtocolClass1870 = new BitSet(new long[]{0x0000000000051000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleProtocolClass1896 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_16_in_ruleProtocolClass1908 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleProtocolClass1931 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleProtocolClass1943 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_25_in_ruleProtocolClass1954 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleProtocolClass1975 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleProtocolClass1988 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleProtocolClass2009 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleProtocolClass2021 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleProtocolClass2031 = new BitSet(new long[]{0x0000000100002000L});
    public static final BitSet FOLLOW_ruleMessage_in_ruleProtocolClass2052 = new BitSet(new long[]{0x0000000100002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass2063 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleProtocolClass2073 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleProtocolClass2083 = new BitSet(new long[]{0x0000000100002000L});
    public static final BitSet FOLLOW_ruleMessage_in_ruleProtocolClass2104 = new BitSet(new long[]{0x0000000100002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass2115 = new BitSet(new long[]{0x00000008A0002000L});
    public static final BitSet FOLLOW_29_in_ruleProtocolClass2126 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleProtocolClass2136 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rulePortClass_in_ruleProtocolClass2157 = new BitSet(new long[]{0x0000000880002000L});
    public static final BitSet FOLLOW_31_in_ruleProtocolClass2170 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleProtocolClass2180 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rulePortClass_in_ruleProtocolClass2201 = new BitSet(new long[]{0x0000000800002000L});
    public static final BitSet FOLLOW_ruleProtocolSemantics_in_ruleProtocolClass2224 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass2235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessage_in_entryRuleMessage2271 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessage2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleMessage2316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessage2333 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleMessage2348 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_ruleTypedID_in_ruleMessage2370 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleMessage2381 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypedID_in_ruleMessage2402 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_ruleMessage2416 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleMessage2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClass_in_entryRulePortClass2474 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortClass2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePortClass2519 = new BitSet(new long[]{0x0000000600120000L});
    public static final BitSet FOLLOW_33_in_rulePortClass2530 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_rulePortClass2551 = new BitSet(new long[]{0x0000000400120000L});
    public static final BitSet FOLLOW_ruleAttribute_in_rulePortClass2575 = new BitSet(new long[]{0x0000000400122000L});
    public static final BitSet FOLLOW_ruleOperation_in_rulePortClass2602 = new BitSet(new long[]{0x0000000400122000L});
    public static final BitSet FOLLOW_ruleMessageHandler_in_rulePortClass2629 = new BitSet(new long[]{0x0000000400122000L});
    public static final BitSet FOLLOW_13_in_rulePortClass2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessageHandler_in_entryRuleMessageHandler2677 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageHandler2687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleMessageHandler2722 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageHandler2740 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleMessageHandler2761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolSemantics_in_entryRuleProtocolSemantics2797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProtocolSemantics2807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleProtocolSemantics2842 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleProtocolSemantics2852 = new BitSet(new long[]{0x0000005000000000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleProtocolSemantics2873 = new BitSet(new long[]{0x0000005000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolSemantics2884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_entryRuleSemanticsRule2920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSemanticsRule2930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsInRule_in_ruleSemanticsRule2977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsOutRule_in_ruleSemanticsRule3004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsInRule_in_entryRuleSemanticsInRule3039 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSemanticsInRule3049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleSemanticsInRule3084 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSemanticsInRule3102 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleSemanticsInRule3112 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSemanticsInRule3122 = new BitSet(new long[]{0x0000005000002000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleSemanticsInRule3143 = new BitSet(new long[]{0x0000005000002000L});
    public static final BitSet FOLLOW_13_in_ruleSemanticsInRule3154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsOutRule_in_entryRuleSemanticsOutRule3190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSemanticsOutRule3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleSemanticsOutRule3235 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSemanticsOutRule3253 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleSemanticsOutRule3263 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSemanticsOutRule3273 = new BitSet(new long[]{0x0000005000002000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleSemanticsOutRule3294 = new BitSet(new long[]{0x0000005000002000L});
    public static final BitSet FOLLOW_13_in_ruleSemanticsOutRule3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClass_in_entryRuleActorClass3341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorClass3351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleActorClass3394 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleActorClass3418 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorClass3435 = new BitSet(new long[]{0x0000000000051000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorClass3461 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_16_in_ruleActorClass3473 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorClass3496 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorClass3508 = new BitSet(new long[]{0x00000E0000002000L});
    public static final BitSet FOLLOW_41_in_ruleActorClass3519 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorClass3529 = new BitSet(new long[]{0x0001300000002000L});
    public static final BitSet FOLLOW_rulePort_in_ruleActorClass3550 = new BitSet(new long[]{0x0001300000002000L});
    public static final BitSet FOLLOW_ruleSPPRef_in_ruleActorClass3572 = new BitSet(new long[]{0x0001000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass3583 = new BitSet(new long[]{0x00000C0000002000L});
    public static final BitSet FOLLOW_42_in_ruleActorClass3596 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorClass3617 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorClass3628 = new BitSet(new long[]{0x4502F00006022000L});
    public static final BitSet FOLLOW_25_in_ruleActorClass3639 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleActorClass3660 = new BitSet(new long[]{0x4502F00004022000L});
    public static final BitSet FOLLOW_26_in_ruleActorClass3673 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleActorClass3694 = new BitSet(new long[]{0x4502F00000022000L});
    public static final BitSet FOLLOW_rulePort_in_ruleActorClass3718 = new BitSet(new long[]{0x4502F00000022000L});
    public static final BitSet FOLLOW_ruleExternalPort_in_ruleActorClass3745 = new BitSet(new long[]{0x4502F00000022000L});
    public static final BitSet FOLLOW_ruleServiceImplementation_in_ruleActorClass3768 = new BitSet(new long[]{0x4502800000022000L});
    public static final BitSet FOLLOW_ruleSAPRef_in_ruleActorClass3790 = new BitSet(new long[]{0x4500800000022000L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleActorClass3812 = new BitSet(new long[]{0x4500000000022000L});
    public static final BitSet FOLLOW_ruleActorRef_in_ruleActorClass3834 = new BitSet(new long[]{0x4500000000002000L});
    public static final BitSet FOLLOW_ruleBinding_in_ruleActorClass3856 = new BitSet(new long[]{0x0500000000002000L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleActorClass3878 = new BitSet(new long[]{0x0400000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass3889 = new BitSet(new long[]{0x0000080000002000L});
    public static final BitSet FOLLOW_43_in_ruleActorClass3902 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorClass3923 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorClass3934 = new BitSet(new long[]{0x8000000000102000L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleActorClass3955 = new BitSet(new long[]{0x8000000000102000L});
    public static final BitSet FOLLOW_ruleStateMachine_in_ruleActorClass3977 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass3988 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass4000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePort_in_entryRulePort4038 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePort4048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rulePort4091 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_rulePort4115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePort4132 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_18_in_rulePort4148 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePort4165 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePort4180 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePort4192 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePort4215 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rulePort4236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalPort_in_entryRuleExternalPort4273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalPort4283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleExternalPort4318 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleExternalPort4328 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalPort4346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSAPRef_in_entryRuleSAPRef4382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSAPRef4392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleSAPRef4427 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSAPRef4444 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSAPRef4459 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSAPRef4482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSPPRef_in_entryRuleSPPRef4518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSPPRef4528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleSPPRef4563 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPRef4580 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSPPRef4595 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSPPRef4618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleServiceImplementation_in_entryRuleServiceImplementation4654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleServiceImplementation4664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleServiceImplementation4699 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleServiceImplementation4709 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleServiceImplementation4727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_entryRuleLogicalSystem4763 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalSystem4773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleLogicalSystem4808 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLogicalSystem4825 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleLogicalSystem4851 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLogicalSystem4862 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleSubSystemRef_in_ruleLogicalSystem4883 = new BitSet(new long[]{0x0510000000002000L});
    public static final BitSet FOLLOW_ruleBinding_in_ruleLogicalSystem4905 = new BitSet(new long[]{0x0500000000002000L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleLogicalSystem4927 = new BitSet(new long[]{0x0400000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLogicalSystem4938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemRef_in_entryRuleSubSystemRef4976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemRef4986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleSubSystemRef5021 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemRef5038 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSubSystemRef5053 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSubSystemRef5076 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleSubSystemRef5097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_entryRuleSubSystemClass5134 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemClass5144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleSubSystemClass5179 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemClass5196 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleSubSystemClass5222 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSubSystemClass5233 = new BitSet(new long[]{0x4001300006000000L});
    public static final BitSet FOLLOW_25_in_ruleSubSystemClass5244 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSubSystemClass5265 = new BitSet(new long[]{0x4001300004000000L});
    public static final BitSet FOLLOW_26_in_ruleSubSystemClass5278 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSubSystemClass5299 = new BitSet(new long[]{0x4001300000000000L});
    public static final BitSet FOLLOW_rulePort_in_ruleSubSystemClass5322 = new BitSet(new long[]{0x4001300000000000L});
    public static final BitSet FOLLOW_ruleSPPRef_in_ruleSubSystemClass5344 = new BitSet(new long[]{0x4001000000000000L});
    public static final BitSet FOLLOW_ruleActorRef_in_ruleSubSystemClass5366 = new BitSet(new long[]{0x4540000000002000L});
    public static final BitSet FOLLOW_ruleBinding_in_ruleSubSystemClass5388 = new BitSet(new long[]{0x0540000000002000L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleSubSystemClass5410 = new BitSet(new long[]{0x0440000000002000L});
    public static final BitSet FOLLOW_ruleLogicalThread_in_ruleSubSystemClass5432 = new BitSet(new long[]{0x0040000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSubSystemClass5443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalThread_in_entryRuleLogicalThread5479 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalThread5489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleLogicalThread5524 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLogicalThread5541 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLogicalThread5556 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_ruleLogicalThread5577 = new BitSet(new long[]{0x0000000000402000L});
    public static final BitSet FOLLOW_22_in_ruleLogicalThread5588 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_ruleLogicalThread5609 = new BitSet(new long[]{0x0000000000402000L});
    public static final BitSet FOLLOW_13_in_ruleLogicalThread5621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_entryRuleActorInstancePath5657 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorInstancePath5667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorInstancePath5709 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleActorInstancePath5725 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorInstancePath5742 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleBinding_in_entryRuleBinding5785 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBinding5795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleBinding5830 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_ruleBinding5851 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleBinding5861 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_ruleBinding5882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_entryRuleBindingEndPoint5918 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBindingEndPoint5928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBindingEndPoint5972 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleBindingEndPoint5982 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBindingEndPoint6002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_entryRuleLayerConnection6038 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLayerConnection6048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleLayerConnection6083 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_ruleSAPoint_in_ruleLayerConnection6104 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleLayerConnection6114 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSPPoint_in_ruleLayerConnection6135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSAPoint_in_entryRuleSAPoint6171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSAPoint6181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefSAPoint_in_ruleSAPoint6228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelaySAPoint_in_ruleSAPoint6255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefSAPoint_in_entryRuleRefSAPoint6290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefSAPoint6300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleRefSAPoint6335 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefSAPoint6353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelaySAPoint_in_entryRuleRelaySAPoint6389 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelaySAPoint6399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleRelaySAPoint6434 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRelaySAPoint6452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSPPoint_in_entryRuleSPPoint6488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSPPoint6498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPoint6541 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleSPPoint6551 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPoint6569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorRef_in_entryRuleActorRef6605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorRef6615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleActorRef6650 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorRef6667 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleActorRef6682 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorRef6705 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorRef6726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateGraphNode_in_entryRuleStateGraphNode6763 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateGraphNode6773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateGraphNode6820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateGraphNode6847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateGraphNode6874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState6911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState6921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBaseState_in_ruleState6968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedState_in_ruleState6995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateGraph_in_entryRuleStateGraph7030 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateGraph7040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleStateGraph7075 = new BitSet(new long[]{0x0000000000000000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateGraph7097 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateGraph7124 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateGraph7151 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateGraph7178 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_13_in_ruleStateGraph7190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_entryRuleStateMachine7226 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateMachine7236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleStateMachine7271 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleStateMachine7281 = new BitSet(new long[]{0x0000000000000000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateMachine7303 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateMachine7330 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateMachine7357 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateMachine7384 = new BitSet(new long[]{0x0000000000002000L,0x00000000000007F1L});
    public static final BitSet FOLLOW_13_in_ruleStateMachine7396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBaseState_in_entryRuleBaseState7432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBaseState7442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleBaseState7477 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBaseState7494 = new BitSet(new long[]{0x0000000000041002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleBaseState7520 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleBaseState7532 = new BitSet(new long[]{0x0000000000002000L,0x000000000000000EL});
    public static final BitSet FOLLOW_65_in_ruleBaseState7543 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleBaseState7564 = new BitSet(new long[]{0x0000000000002000L,0x000000000000000CL});
    public static final BitSet FOLLOW_66_in_ruleBaseState7577 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleBaseState7598 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_ruleBaseState7611 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleStateGraph_in_ruleBaseState7632 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleBaseState7644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedState_in_entryRuleRefinedState7682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefinedState7692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleRefinedState7727 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRefinedState7750 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRefinedState7771 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRefinedState7782 = new BitSet(new long[]{0x0000000000002000L,0x000000000000000EL});
    public static final BitSet FOLLOW_65_in_ruleRefinedState7793 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState7814 = new BitSet(new long[]{0x0000000000002000L,0x000000000000000CL});
    public static final BitSet FOLLOW_66_in_ruleRefinedState7827 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState7848 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_ruleRefinedState7861 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleStateGraph_in_ruleRefinedState7882 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRefinedState7894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDetailCode_in_entryRuleDetailCode7930 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDetailCode7940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleDetailCode7975 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDetailCode7992 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_13_in_ruleDetailCode8008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPoint_in_entryRuleTrPoint8044 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPoint8054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_ruleTrPoint8101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_ruleTrPoint8128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_ruleTrPoint8155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint8190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionPoint8200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleTransitionPoint8243 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleTransitionPoint8267 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransitionPoint8284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint8325 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryPoint8335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleEntryPoint8370 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntryPoint8387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_entryRuleExitPoint8428 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitPoint8438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleExitPoint8473 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitPoint8490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint8531 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicePoint8541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleChoicePoint8576 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicePoint8593 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleChoicePoint8619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition8656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition8666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_ruleTransition8713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_ruleTransition8740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition8775 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonInitialTransition8785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_ruleNonInitialTransition8832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition8859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition8886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition8921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInitialTransition8931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleInitialTransition8966 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInitialTransition8983 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleInitialTransition8999 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleInitialTransition9009 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleInitialTransition9019 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition9040 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleInitialTransition9061 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleInitialTransition9072 = new BitSet(new long[]{0x0000000000002000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleInitialTransition9083 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleInitialTransition9104 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleInitialTransition9116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition9152 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContinuationTransition9162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleContinuationTransition9197 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContinuationTransition9214 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleContinuationTransition9230 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition9251 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleContinuationTransition9261 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition9282 = new BitSet(new long[]{0x0000000000041002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleContinuationTransition9303 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleContinuationTransition9315 = new BitSet(new long[]{0x0000000000002000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleContinuationTransition9326 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleContinuationTransition9347 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleContinuationTransition9359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition9397 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggeredTransition9407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleTriggeredTransition9442 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggeredTransition9459 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTriggeredTransition9475 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition9496 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleTriggeredTransition9506 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition9527 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleTriggeredTransition9548 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleTriggeredTransition9559 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ruleTriggeredTransition9569 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleTriggeredTransition9579 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition9600 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleTriggeredTransition9611 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition9632 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_13_in_ruleTriggeredTransition9644 = new BitSet(new long[]{0x0000000000002000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleTriggeredTransition9655 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleTriggeredTransition9676 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTriggeredTransition9688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition9724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCPBranchTransition9734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleCPBranchTransition9769 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCPBranchTransition9786 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCPBranchTransition9802 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition9823 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleCPBranchTransition9833 = new BitSet(new long[]{0x0000000000000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition9854 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleCPBranchTransition9875 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleCPBranchTransition9886 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleCPBranchTransition9896 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition9917 = new BitSet(new long[]{0x0000000000002000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleCPBranchTransition9928 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition9949 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleCPBranchTransition9961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal9997 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionTerminal10007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal10054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal10081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal10108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal10135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal10170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateTerminal10180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStateTerminal10222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal10257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPointTerminal10267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleTrPointTerminal10302 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTrPointTerminal10320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal10356 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal10366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal10409 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleSubStateTrPointTerminal10419 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal10437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal10473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicepointTerminal10483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleChoicepointTerminal10518 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicepointTerminal10536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrigger_in_entryRuleTrigger10572 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrigger10582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleTrigger10617 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger10638 = new BitSet(new long[]{0x0000000000000000L,0x0000000000380000L});
    public static final BitSet FOLLOW_83_in_ruleTrigger10649 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger10670 = new BitSet(new long[]{0x0000000000000000L,0x0000000000380000L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleTrigger10693 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_ruleTrigger10704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf10740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageFromIf10750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf10793 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleMessageFromIf10803 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf10821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard10857 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard10867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleGuard10902 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuard10923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation10959 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation10969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleDocumentation11004 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDocumentation11021 = new BitSet(new long[]{0x0000000000080040L});
    public static final BitSet FOLLOW_19_in_ruleDocumentation11037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport11073 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport11083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleImport11118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_ruleImport11139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN11176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN11187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN11234 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleImportedFQN11253 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_ruleImportedFQN11266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN11309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN11320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN11360 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleFQN11379 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN11394 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_88_in_rulePrimitiveType11453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_rulePrimitiveType11468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_rulePrimitiveType11483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_rulePrimitiveType11498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_rulePrimitiveType11513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_rulePrimitiveType11528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_rulePrimitiveType11543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_rulePrimitiveType11558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_rulePrimitiveType11573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_rulePrimitiveType11588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_rulePrimitiveType11603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_rulePrimitiveType11618 = new BitSet(new long[]{0x0000000000000002L});

}