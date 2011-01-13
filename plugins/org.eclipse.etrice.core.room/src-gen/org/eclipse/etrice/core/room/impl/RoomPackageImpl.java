/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorInstancePath;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.BaseState;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.CPBranchTransition;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.ChoicepointTerminal;
import org.eclipse.etrice.core.room.ContinuationTransition;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.EntryPoint;
import org.eclipse.etrice.core.room.ExitPoint;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.FreeType;
import org.eclipse.etrice.core.room.FreeTypedID;
import org.eclipse.etrice.core.room.Guard;
import org.eclipse.etrice.core.room.Import;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.NonInitialTransition;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.ProtocolSemantics;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SAPoint;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.SemanticsInRule;
import org.eclipse.etrice.core.room.SemanticsOutRule;
import org.eclipse.etrice.core.room.SemanticsRule;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StateGraphNode;
import org.eclipse.etrice.core.room.StateTerminal;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubStateTrPointTerminal;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.TrPointTerminal;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionPoint;
import org.eclipse.etrice.core.room.TransitionTerminal;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.Type;
import org.eclipse.etrice.core.room.TypedID;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RoomPackageImpl extends EPackageImpl implements RoomPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roomModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roomClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structureClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actorContainerClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typedIDEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass freeTypedIDEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass freeTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass protocolClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass messageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass messageHandlerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass protocolSemanticsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass semanticsRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass semanticsInRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass semanticsOutRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actorClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass interfaceItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass externalPortEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sapRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sppRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass serviceImplementationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass logicalSystemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actorContainerRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subSystemRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subSystemClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass logicalThreadEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actorInstancePathEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bindingEndPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass layerConnectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass saPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass refSAPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relaySAPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass spPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actorRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateGraphNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateGraphItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateGraphEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass baseStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass refinedStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass detailCodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entryPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exitPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass choicePointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonInitialTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initialTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass continuationTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass triggeredTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cpBranchTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionTerminalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateTerminalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trPointTerminalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subStateTrPointTerminalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass choicepointTerminalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass triggerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass messageFromIfEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass guardEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum primitiveTypeEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.etrice.core.room.RoomPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private RoomPackageImpl()
  {
    super(eNS_URI, RoomFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link RoomPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static RoomPackage init()
  {
    if (isInited) return (RoomPackage)EPackage.Registry.INSTANCE.getEPackage(RoomPackage.eNS_URI);

    // Obtain or create and register package
    RoomPackageImpl theRoomPackage = (RoomPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RoomPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RoomPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theRoomPackage.createPackageContents();

    // Initialize created meta-data
    theRoomPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theRoomPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(RoomPackage.eNS_URI, theRoomPackage);
    return theRoomPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoomModel()
  {
    return roomModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRoomModel_Name()
  {
    return (EAttribute)roomModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_Imports()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_DataClasses()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_ProtocolClasses()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_ActorClasses()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_SubSystemClasses()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_Systems()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoomClass()
  {
    return roomClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRoomClass_Name()
  {
    return (EAttribute)roomClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructureClass()
  {
    return structureClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructureClass_Bindings()
  {
    return (EReference)structureClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructureClass_Connections()
  {
    return (EReference)structureClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActorContainerClass()
  {
    return actorContainerClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorContainerClass_IfSPPs()
  {
    return (EReference)actorContainerClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorContainerClass_ActorRefs()
  {
    return (EReference)actorContainerClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypedID()
  {
    return typedIDEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypedID_Name()
  {
    return (EAttribute)typedIDEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypedID_Type()
  {
    return (EReference)typedIDEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFreeTypedID()
  {
    return freeTypedIDEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFreeTypedID_Name()
  {
    return (EAttribute)freeTypedIDEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFreeTypedID_Type()
  {
    return (EReference)freeTypedIDEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType()
  {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getType_Prim()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getType_Type()
  {
    return (EReference)typeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFreeType()
  {
    return freeTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFreeType_Prim()
  {
    return (EAttribute)freeTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFreeType_Type()
  {
    return (EAttribute)freeTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataClass()
  {
    return dataClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataClass_Base()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataClass_Imports()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataClass_Attributes()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataClass_Operations()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttribute()
  {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute_Name()
  {
    return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute_Size()
  {
    return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute_Type()
  {
    return (EReference)attributeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperation()
  {
    return operationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOperation_Name()
  {
    return (EAttribute)operationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperation_Arguments()
  {
    return (EReference)operationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperation_Returntype()
  {
    return (EReference)operationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperation_DetailCode()
  {
    return (EReference)operationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProtocolClass()
  {
    return protocolClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_Base()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_UserCode1()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_UserCode2()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_IncomingMessages()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_OutgoingMessages()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_Regular()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_Conjugate()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_Semantics()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMessage()
  {
    return messageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMessage_Name()
  {
    return (EAttribute)messageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessage_Arguments()
  {
    return (EReference)messageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPortClass()
  {
    return portClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPortClass_UserCode()
  {
    return (EReference)portClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPortClass_Attributes()
  {
    return (EReference)portClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPortClass_Operations()
  {
    return (EReference)portClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPortClass_MsgHandlers()
  {
    return (EReference)portClassEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMessageHandler()
  {
    return messageHandlerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessageHandler_Msg()
  {
    return (EReference)messageHandlerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessageHandler_DetailCode()
  {
    return (EReference)messageHandlerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProtocolSemantics()
  {
    return protocolSemanticsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolSemantics_Rules()
  {
    return (EReference)protocolSemanticsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSemanticsRule()
  {
    return semanticsRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSemanticsRule_Msg()
  {
    return (EReference)semanticsRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSemanticsRule_FollowUps()
  {
    return (EReference)semanticsRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSemanticsInRule()
  {
    return semanticsInRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSemanticsOutRule()
  {
    return semanticsOutRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActorClass()
  {
    return actorClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActorClass_Abstract()
  {
    return (EAttribute)actorClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_Base()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_IfPorts()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_UserCode1()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_UserCode2()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_IntPorts()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_ExtPorts()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_ServiceImplementations()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_StrSAPs()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_Attributes()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_Operations()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_StateMachine()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInterfaceItem()
  {
    return interfaceItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInterfaceItem_Name()
  {
    return (EAttribute)interfaceItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterfaceItem_Protocol()
  {
    return (EReference)interfaceItemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPort()
  {
    return portEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPort_Conjugated()
  {
    return (EAttribute)portEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPort_Multiplicity()
  {
    return (EAttribute)portEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExternalPort()
  {
    return externalPortEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExternalPort_Ifport()
  {
    return (EReference)externalPortEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSAPRef()
  {
    return sapRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSPPRef()
  {
    return sppRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServiceImplementation()
  {
    return serviceImplementationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getServiceImplementation_Spp()
  {
    return (EReference)serviceImplementationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalSystem()
  {
    return logicalSystemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalSystem_SubSystems()
  {
    return (EReference)logicalSystemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActorContainerRef()
  {
    return actorContainerRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActorContainerRef_Name()
  {
    return (EAttribute)actorContainerRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubSystemRef()
  {
    return subSystemRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubSystemRef_Type()
  {
    return (EReference)subSystemRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubSystemClass()
  {
    return subSystemClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubSystemClass_RelayPorts()
  {
    return (EReference)subSystemClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubSystemClass_Threads()
  {
    return (EReference)subSystemClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalThread()
  {
    return logicalThreadEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLogicalThread_Name()
  {
    return (EAttribute)logicalThreadEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalThread_Instances()
  {
    return (EReference)logicalThreadEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActorInstancePath()
  {
    return actorInstancePathEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActorInstancePath_Segments()
  {
    return (EAttribute)actorInstancePathEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinding()
  {
    return bindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinding_Endpoint1()
  {
    return (EReference)bindingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinding_Endpoint2()
  {
    return (EReference)bindingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBindingEndPoint()
  {
    return bindingEndPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBindingEndPoint_ActorRef()
  {
    return (EReference)bindingEndPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBindingEndPoint_Port()
  {
    return (EReference)bindingEndPointEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLayerConnection()
  {
    return layerConnectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLayerConnection_From()
  {
    return (EReference)layerConnectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLayerConnection_To()
  {
    return (EReference)layerConnectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSAPoint()
  {
    return saPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRefSAPoint()
  {
    return refSAPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRefSAPoint_Ref()
  {
    return (EReference)refSAPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelaySAPoint()
  {
    return relaySAPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelaySAPoint_Relay()
  {
    return (EReference)relaySAPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSPPoint()
  {
    return spPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSPPoint_Ref()
  {
    return (EReference)spPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSPPoint_Service()
  {
    return (EReference)spPointEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActorRef()
  {
    return actorRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorRef_Type()
  {
    return (EReference)actorRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateGraphNode()
  {
    return stateGraphNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateGraphItem()
  {
    return stateGraphItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getState()
  {
    return stateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_EntryCode()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_ExitCode()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_Subgraph()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateGraph()
  {
    return stateGraphEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateGraph_States()
  {
    return (EReference)stateGraphEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateGraph_TrPoints()
  {
    return (EReference)stateGraphEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateGraph_ChPoints()
  {
    return (EReference)stateGraphEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateGraph_Transitions()
  {
    return (EReference)stateGraphEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBaseState()
  {
    return baseStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBaseState_Name()
  {
    return (EAttribute)baseStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRefinedState()
  {
    return refinedStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRefinedState_Base()
  {
    return (EReference)refinedStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDetailCode()
  {
    return detailCodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDetailCode_Commands()
  {
    return (EAttribute)detailCodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrPoint()
  {
    return trPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrPoint_Name()
  {
    return (EAttribute)trPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionPoint()
  {
    return transitionPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransitionPoint_Handler()
  {
    return (EAttribute)transitionPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntryPoint()
  {
    return entryPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExitPoint()
  {
    return exitPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChoicePoint()
  {
    return choicePointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChoicePoint_Name()
  {
    return (EAttribute)choicePointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransition()
  {
    return transitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransition_Name()
  {
    return (EAttribute)transitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransition_To()
  {
    return (EReference)transitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransition_Action()
  {
    return (EReference)transitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNonInitialTransition()
  {
    return nonInitialTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonInitialTransition_From()
  {
    return (EReference)nonInitialTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInitialTransition()
  {
    return initialTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContinuationTransition()
  {
    return continuationTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTriggeredTransition()
  {
    return triggeredTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTriggeredTransition_Triggers()
  {
    return (EReference)triggeredTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCPBranchTransition()
  {
    return cpBranchTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCPBranchTransition_Condition()
  {
    return (EReference)cpBranchTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionTerminal()
  {
    return transitionTerminalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateTerminal()
  {
    return stateTerminalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateTerminal_State()
  {
    return (EReference)stateTerminalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrPointTerminal()
  {
    return trPointTerminalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrPointTerminal_TrPoint()
  {
    return (EReference)trPointTerminalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubStateTrPointTerminal()
  {
    return subStateTrPointTerminalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubStateTrPointTerminal_TrPoint()
  {
    return (EReference)subStateTrPointTerminalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubStateTrPointTerminal_State()
  {
    return (EReference)subStateTrPointTerminalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChoicepointTerminal()
  {
    return choicepointTerminalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getChoicepointTerminal_Cp()
  {
    return (EReference)choicepointTerminalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrigger()
  {
    return triggerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrigger_MsgFromIfPairs()
  {
    return (EReference)triggerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrigger_Guard()
  {
    return (EReference)triggerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMessageFromIf()
  {
    return messageFromIfEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessageFromIf_Message()
  {
    return (EReference)messageFromIfEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessageFromIf_From()
  {
    return (EReference)messageFromIfEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGuard()
  {
    return guardEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGuard_Guard()
  {
    return (EReference)guardEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportedNamespace()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getPrimitiveType()
  {
    return primitiveTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoomFactory getRoomFactory()
  {
    return (RoomFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    roomModelEClass = createEClass(ROOM_MODEL);
    createEAttribute(roomModelEClass, ROOM_MODEL__NAME);
    createEReference(roomModelEClass, ROOM_MODEL__IMPORTS);
    createEReference(roomModelEClass, ROOM_MODEL__DATA_CLASSES);
    createEReference(roomModelEClass, ROOM_MODEL__PROTOCOL_CLASSES);
    createEReference(roomModelEClass, ROOM_MODEL__ACTOR_CLASSES);
    createEReference(roomModelEClass, ROOM_MODEL__SUB_SYSTEM_CLASSES);
    createEReference(roomModelEClass, ROOM_MODEL__SYSTEMS);

    roomClassEClass = createEClass(ROOM_CLASS);
    createEAttribute(roomClassEClass, ROOM_CLASS__NAME);

    structureClassEClass = createEClass(STRUCTURE_CLASS);
    createEReference(structureClassEClass, STRUCTURE_CLASS__BINDINGS);
    createEReference(structureClassEClass, STRUCTURE_CLASS__CONNECTIONS);

    actorContainerClassEClass = createEClass(ACTOR_CONTAINER_CLASS);
    createEReference(actorContainerClassEClass, ACTOR_CONTAINER_CLASS__IF_SP_PS);
    createEReference(actorContainerClassEClass, ACTOR_CONTAINER_CLASS__ACTOR_REFS);

    typedIDEClass = createEClass(TYPED_ID);
    createEAttribute(typedIDEClass, TYPED_ID__NAME);
    createEReference(typedIDEClass, TYPED_ID__TYPE);

    freeTypedIDEClass = createEClass(FREE_TYPED_ID);
    createEAttribute(freeTypedIDEClass, FREE_TYPED_ID__NAME);
    createEReference(freeTypedIDEClass, FREE_TYPED_ID__TYPE);

    typeEClass = createEClass(TYPE);
    createEAttribute(typeEClass, TYPE__PRIM);
    createEReference(typeEClass, TYPE__TYPE);

    freeTypeEClass = createEClass(FREE_TYPE);
    createEAttribute(freeTypeEClass, FREE_TYPE__PRIM);
    createEAttribute(freeTypeEClass, FREE_TYPE__TYPE);

    dataClassEClass = createEClass(DATA_CLASS);
    createEReference(dataClassEClass, DATA_CLASS__BASE);
    createEReference(dataClassEClass, DATA_CLASS__IMPORTS);
    createEReference(dataClassEClass, DATA_CLASS__ATTRIBUTES);
    createEReference(dataClassEClass, DATA_CLASS__OPERATIONS);

    attributeEClass = createEClass(ATTRIBUTE);
    createEAttribute(attributeEClass, ATTRIBUTE__NAME);
    createEAttribute(attributeEClass, ATTRIBUTE__SIZE);
    createEReference(attributeEClass, ATTRIBUTE__TYPE);

    operationEClass = createEClass(OPERATION);
    createEAttribute(operationEClass, OPERATION__NAME);
    createEReference(operationEClass, OPERATION__ARGUMENTS);
    createEReference(operationEClass, OPERATION__RETURNTYPE);
    createEReference(operationEClass, OPERATION__DETAIL_CODE);

    protocolClassEClass = createEClass(PROTOCOL_CLASS);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__BASE);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__USER_CODE1);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__USER_CODE2);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__INCOMING_MESSAGES);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__OUTGOING_MESSAGES);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__REGULAR);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__CONJUGATE);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__SEMANTICS);

    messageEClass = createEClass(MESSAGE);
    createEAttribute(messageEClass, MESSAGE__NAME);
    createEReference(messageEClass, MESSAGE__ARGUMENTS);

    portClassEClass = createEClass(PORT_CLASS);
    createEReference(portClassEClass, PORT_CLASS__USER_CODE);
    createEReference(portClassEClass, PORT_CLASS__ATTRIBUTES);
    createEReference(portClassEClass, PORT_CLASS__OPERATIONS);
    createEReference(portClassEClass, PORT_CLASS__MSG_HANDLERS);

    messageHandlerEClass = createEClass(MESSAGE_HANDLER);
    createEReference(messageHandlerEClass, MESSAGE_HANDLER__MSG);
    createEReference(messageHandlerEClass, MESSAGE_HANDLER__DETAIL_CODE);

    protocolSemanticsEClass = createEClass(PROTOCOL_SEMANTICS);
    createEReference(protocolSemanticsEClass, PROTOCOL_SEMANTICS__RULES);

    semanticsRuleEClass = createEClass(SEMANTICS_RULE);
    createEReference(semanticsRuleEClass, SEMANTICS_RULE__MSG);
    createEReference(semanticsRuleEClass, SEMANTICS_RULE__FOLLOW_UPS);

    semanticsInRuleEClass = createEClass(SEMANTICS_IN_RULE);

    semanticsOutRuleEClass = createEClass(SEMANTICS_OUT_RULE);

    actorClassEClass = createEClass(ACTOR_CLASS);
    createEAttribute(actorClassEClass, ACTOR_CLASS__ABSTRACT);
    createEReference(actorClassEClass, ACTOR_CLASS__BASE);
    createEReference(actorClassEClass, ACTOR_CLASS__IF_PORTS);
    createEReference(actorClassEClass, ACTOR_CLASS__USER_CODE1);
    createEReference(actorClassEClass, ACTOR_CLASS__USER_CODE2);
    createEReference(actorClassEClass, ACTOR_CLASS__INT_PORTS);
    createEReference(actorClassEClass, ACTOR_CLASS__EXT_PORTS);
    createEReference(actorClassEClass, ACTOR_CLASS__SERVICE_IMPLEMENTATIONS);
    createEReference(actorClassEClass, ACTOR_CLASS__STR_SA_PS);
    createEReference(actorClassEClass, ACTOR_CLASS__ATTRIBUTES);
    createEReference(actorClassEClass, ACTOR_CLASS__OPERATIONS);
    createEReference(actorClassEClass, ACTOR_CLASS__STATE_MACHINE);

    interfaceItemEClass = createEClass(INTERFACE_ITEM);
    createEAttribute(interfaceItemEClass, INTERFACE_ITEM__NAME);
    createEReference(interfaceItemEClass, INTERFACE_ITEM__PROTOCOL);

    portEClass = createEClass(PORT);
    createEAttribute(portEClass, PORT__CONJUGATED);
    createEAttribute(portEClass, PORT__MULTIPLICITY);

    externalPortEClass = createEClass(EXTERNAL_PORT);
    createEReference(externalPortEClass, EXTERNAL_PORT__IFPORT);

    sapRefEClass = createEClass(SAP_REF);

    sppRefEClass = createEClass(SPP_REF);

    serviceImplementationEClass = createEClass(SERVICE_IMPLEMENTATION);
    createEReference(serviceImplementationEClass, SERVICE_IMPLEMENTATION__SPP);

    logicalSystemEClass = createEClass(LOGICAL_SYSTEM);
    createEReference(logicalSystemEClass, LOGICAL_SYSTEM__SUB_SYSTEMS);

    actorContainerRefEClass = createEClass(ACTOR_CONTAINER_REF);
    createEAttribute(actorContainerRefEClass, ACTOR_CONTAINER_REF__NAME);

    subSystemRefEClass = createEClass(SUB_SYSTEM_REF);
    createEReference(subSystemRefEClass, SUB_SYSTEM_REF__TYPE);

    subSystemClassEClass = createEClass(SUB_SYSTEM_CLASS);
    createEReference(subSystemClassEClass, SUB_SYSTEM_CLASS__RELAY_PORTS);
    createEReference(subSystemClassEClass, SUB_SYSTEM_CLASS__THREADS);

    logicalThreadEClass = createEClass(LOGICAL_THREAD);
    createEAttribute(logicalThreadEClass, LOGICAL_THREAD__NAME);
    createEReference(logicalThreadEClass, LOGICAL_THREAD__INSTANCES);

    actorInstancePathEClass = createEClass(ACTOR_INSTANCE_PATH);
    createEAttribute(actorInstancePathEClass, ACTOR_INSTANCE_PATH__SEGMENTS);

    bindingEClass = createEClass(BINDING);
    createEReference(bindingEClass, BINDING__ENDPOINT1);
    createEReference(bindingEClass, BINDING__ENDPOINT2);

    bindingEndPointEClass = createEClass(BINDING_END_POINT);
    createEReference(bindingEndPointEClass, BINDING_END_POINT__ACTOR_REF);
    createEReference(bindingEndPointEClass, BINDING_END_POINT__PORT);

    layerConnectionEClass = createEClass(LAYER_CONNECTION);
    createEReference(layerConnectionEClass, LAYER_CONNECTION__FROM);
    createEReference(layerConnectionEClass, LAYER_CONNECTION__TO);

    saPointEClass = createEClass(SA_POINT);

    refSAPointEClass = createEClass(REF_SA_POINT);
    createEReference(refSAPointEClass, REF_SA_POINT__REF);

    relaySAPointEClass = createEClass(RELAY_SA_POINT);
    createEReference(relaySAPointEClass, RELAY_SA_POINT__RELAY);

    spPointEClass = createEClass(SP_POINT);
    createEReference(spPointEClass, SP_POINT__REF);
    createEReference(spPointEClass, SP_POINT__SERVICE);

    actorRefEClass = createEClass(ACTOR_REF);
    createEReference(actorRefEClass, ACTOR_REF__TYPE);

    stateGraphNodeEClass = createEClass(STATE_GRAPH_NODE);

    stateGraphItemEClass = createEClass(STATE_GRAPH_ITEM);

    stateEClass = createEClass(STATE);
    createEReference(stateEClass, STATE__ENTRY_CODE);
    createEReference(stateEClass, STATE__EXIT_CODE);
    createEReference(stateEClass, STATE__SUBGRAPH);

    stateGraphEClass = createEClass(STATE_GRAPH);
    createEReference(stateGraphEClass, STATE_GRAPH__STATES);
    createEReference(stateGraphEClass, STATE_GRAPH__TR_POINTS);
    createEReference(stateGraphEClass, STATE_GRAPH__CH_POINTS);
    createEReference(stateGraphEClass, STATE_GRAPH__TRANSITIONS);

    baseStateEClass = createEClass(BASE_STATE);
    createEAttribute(baseStateEClass, BASE_STATE__NAME);

    refinedStateEClass = createEClass(REFINED_STATE);
    createEReference(refinedStateEClass, REFINED_STATE__BASE);

    detailCodeEClass = createEClass(DETAIL_CODE);
    createEAttribute(detailCodeEClass, DETAIL_CODE__COMMANDS);

    trPointEClass = createEClass(TR_POINT);
    createEAttribute(trPointEClass, TR_POINT__NAME);

    transitionPointEClass = createEClass(TRANSITION_POINT);
    createEAttribute(transitionPointEClass, TRANSITION_POINT__HANDLER);

    entryPointEClass = createEClass(ENTRY_POINT);

    exitPointEClass = createEClass(EXIT_POINT);

    choicePointEClass = createEClass(CHOICE_POINT);
    createEAttribute(choicePointEClass, CHOICE_POINT__NAME);

    transitionEClass = createEClass(TRANSITION);
    createEAttribute(transitionEClass, TRANSITION__NAME);
    createEReference(transitionEClass, TRANSITION__TO);
    createEReference(transitionEClass, TRANSITION__ACTION);

    nonInitialTransitionEClass = createEClass(NON_INITIAL_TRANSITION);
    createEReference(nonInitialTransitionEClass, NON_INITIAL_TRANSITION__FROM);

    initialTransitionEClass = createEClass(INITIAL_TRANSITION);

    continuationTransitionEClass = createEClass(CONTINUATION_TRANSITION);

    triggeredTransitionEClass = createEClass(TRIGGERED_TRANSITION);
    createEReference(triggeredTransitionEClass, TRIGGERED_TRANSITION__TRIGGERS);

    cpBranchTransitionEClass = createEClass(CP_BRANCH_TRANSITION);
    createEReference(cpBranchTransitionEClass, CP_BRANCH_TRANSITION__CONDITION);

    transitionTerminalEClass = createEClass(TRANSITION_TERMINAL);

    stateTerminalEClass = createEClass(STATE_TERMINAL);
    createEReference(stateTerminalEClass, STATE_TERMINAL__STATE);

    trPointTerminalEClass = createEClass(TR_POINT_TERMINAL);
    createEReference(trPointTerminalEClass, TR_POINT_TERMINAL__TR_POINT);

    subStateTrPointTerminalEClass = createEClass(SUB_STATE_TR_POINT_TERMINAL);
    createEReference(subStateTrPointTerminalEClass, SUB_STATE_TR_POINT_TERMINAL__TR_POINT);
    createEReference(subStateTrPointTerminalEClass, SUB_STATE_TR_POINT_TERMINAL__STATE);

    choicepointTerminalEClass = createEClass(CHOICEPOINT_TERMINAL);
    createEReference(choicepointTerminalEClass, CHOICEPOINT_TERMINAL__CP);

    triggerEClass = createEClass(TRIGGER);
    createEReference(triggerEClass, TRIGGER__MSG_FROM_IF_PAIRS);
    createEReference(triggerEClass, TRIGGER__GUARD);

    messageFromIfEClass = createEClass(MESSAGE_FROM_IF);
    createEReference(messageFromIfEClass, MESSAGE_FROM_IF__MESSAGE);
    createEReference(messageFromIfEClass, MESSAGE_FROM_IF__FROM);

    guardEClass = createEClass(GUARD);
    createEReference(guardEClass, GUARD__GUARD);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORTED_NAMESPACE);

    // Create enums
    primitiveTypeEEnum = createEEnum(PRIMITIVE_TYPE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    structureClassEClass.getESuperTypes().add(this.getRoomClass());
    actorContainerClassEClass.getESuperTypes().add(this.getStructureClass());
    dataClassEClass.getESuperTypes().add(this.getRoomClass());
    protocolClassEClass.getESuperTypes().add(this.getRoomClass());
    semanticsInRuleEClass.getESuperTypes().add(this.getSemanticsRule());
    semanticsOutRuleEClass.getESuperTypes().add(this.getSemanticsRule());
    actorClassEClass.getESuperTypes().add(this.getActorContainerClass());
    portEClass.getESuperTypes().add(this.getInterfaceItem());
    sapRefEClass.getESuperTypes().add(this.getInterfaceItem());
    sppRefEClass.getESuperTypes().add(this.getInterfaceItem());
    logicalSystemEClass.getESuperTypes().add(this.getStructureClass());
    subSystemRefEClass.getESuperTypes().add(this.getActorContainerRef());
    subSystemClassEClass.getESuperTypes().add(this.getActorContainerClass());
    refSAPointEClass.getESuperTypes().add(this.getSAPoint());
    relaySAPointEClass.getESuperTypes().add(this.getSAPoint());
    actorRefEClass.getESuperTypes().add(this.getActorContainerRef());
    stateGraphNodeEClass.getESuperTypes().add(this.getStateGraphItem());
    stateEClass.getESuperTypes().add(this.getStateGraphNode());
    baseStateEClass.getESuperTypes().add(this.getState());
    refinedStateEClass.getESuperTypes().add(this.getState());
    trPointEClass.getESuperTypes().add(this.getStateGraphNode());
    transitionPointEClass.getESuperTypes().add(this.getTrPoint());
    entryPointEClass.getESuperTypes().add(this.getTrPoint());
    exitPointEClass.getESuperTypes().add(this.getTrPoint());
    choicePointEClass.getESuperTypes().add(this.getStateGraphNode());
    transitionEClass.getESuperTypes().add(this.getStateGraphItem());
    nonInitialTransitionEClass.getESuperTypes().add(this.getTransition());
    initialTransitionEClass.getESuperTypes().add(this.getTransition());
    continuationTransitionEClass.getESuperTypes().add(this.getNonInitialTransition());
    triggeredTransitionEClass.getESuperTypes().add(this.getNonInitialTransition());
    cpBranchTransitionEClass.getESuperTypes().add(this.getNonInitialTransition());
    stateTerminalEClass.getESuperTypes().add(this.getTransitionTerminal());
    trPointTerminalEClass.getESuperTypes().add(this.getTransitionTerminal());
    subStateTrPointTerminalEClass.getESuperTypes().add(this.getTransitionTerminal());
    choicepointTerminalEClass.getESuperTypes().add(this.getTransitionTerminal());

    // Initialize classes and features; add operations and parameters
    initEClass(roomModelEClass, RoomModel.class, "RoomModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRoomModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_Imports(), this.getImport(), null, "imports", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_DataClasses(), this.getDataClass(), null, "dataClasses", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_ProtocolClasses(), this.getProtocolClass(), null, "protocolClasses", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_ActorClasses(), this.getActorClass(), null, "actorClasses", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_SubSystemClasses(), this.getSubSystemClass(), null, "subSystemClasses", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_Systems(), this.getLogicalSystem(), null, "systems", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roomClassEClass, RoomClass.class, "RoomClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRoomClass_Name(), ecorePackage.getEString(), "name", null, 0, 1, RoomClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(structureClassEClass, StructureClass.class, "StructureClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStructureClass_Bindings(), this.getBinding(), null, "bindings", null, 0, -1, StructureClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStructureClass_Connections(), this.getLayerConnection(), null, "connections", null, 0, -1, StructureClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actorContainerClassEClass, ActorContainerClass.class, "ActorContainerClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActorContainerClass_IfSPPs(), this.getSPPRef(), null, "ifSPPs", null, 0, -1, ActorContainerClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorContainerClass_ActorRefs(), this.getActorRef(), null, "actorRefs", null, 0, -1, ActorContainerClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typedIDEClass, TypedID.class, "TypedID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypedID_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypedID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypedID_Type(), this.getType(), null, "type", null, 0, 1, TypedID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(freeTypedIDEClass, FreeTypedID.class, "FreeTypedID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFreeTypedID_Name(), ecorePackage.getEString(), "name", null, 0, 1, FreeTypedID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFreeTypedID_Type(), this.getFreeType(), null, "type", null, 0, 1, FreeTypedID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getType_Prim(), this.getPrimitiveType(), "prim", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getType_Type(), this.getDataClass(), null, "type", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(freeTypeEClass, FreeType.class, "FreeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFreeType_Prim(), this.getPrimitiveType(), "prim", null, 0, 1, FreeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFreeType_Type(), ecorePackage.getEString(), "type", null, 0, 1, FreeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataClassEClass, DataClass.class, "DataClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDataClass_Base(), this.getDataClass(), null, "base", null, 0, 1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_Imports(), this.getImport(), null, "imports", null, 0, -1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_Operations(), this.getOperation(), null, "operations", null, 0, -1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttribute_Size(), ecorePackage.getEInt(), "size", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttribute_Type(), this.getType(), null, "type", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOperation_Name(), ecorePackage.getEString(), "name", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperation_Arguments(), this.getFreeTypedID(), null, "arguments", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperation_Returntype(), this.getFreeType(), null, "returntype", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperation_DetailCode(), this.getDetailCode(), null, "detailCode", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(protocolClassEClass, ProtocolClass.class, "ProtocolClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProtocolClass_Base(), this.getProtocolClass(), null, "base", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_UserCode1(), this.getDetailCode(), null, "userCode1", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_UserCode2(), this.getDetailCode(), null, "userCode2", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_IncomingMessages(), this.getMessage(), null, "incomingMessages", null, 0, -1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_OutgoingMessages(), this.getMessage(), null, "outgoingMessages", null, 0, -1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_Regular(), this.getPortClass(), null, "regular", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_Conjugate(), this.getPortClass(), null, "conjugate", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_Semantics(), this.getProtocolSemantics(), null, "semantics", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(messageEClass, Message.class, "Message", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMessage_Name(), ecorePackage.getEString(), "name", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessage_Arguments(), this.getTypedID(), null, "arguments", null, 0, -1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(portClassEClass, PortClass.class, "PortClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPortClass_UserCode(), this.getDetailCode(), null, "userCode", null, 0, 1, PortClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPortClass_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, PortClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPortClass_Operations(), this.getOperation(), null, "operations", null, 0, -1, PortClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPortClass_MsgHandlers(), this.getMessageHandler(), null, "msgHandlers", null, 0, -1, PortClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(messageHandlerEClass, MessageHandler.class, "MessageHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMessageHandler_Msg(), this.getMessage(), null, "msg", null, 0, 1, MessageHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessageHandler_DetailCode(), this.getDetailCode(), null, "detailCode", null, 0, 1, MessageHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(protocolSemanticsEClass, ProtocolSemantics.class, "ProtocolSemantics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProtocolSemantics_Rules(), this.getSemanticsRule(), null, "rules", null, 0, -1, ProtocolSemantics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(semanticsRuleEClass, SemanticsRule.class, "SemanticsRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSemanticsRule_Msg(), this.getMessage(), null, "msg", null, 0, 1, SemanticsRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSemanticsRule_FollowUps(), this.getSemanticsRule(), null, "followUps", null, 0, -1, SemanticsRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(semanticsInRuleEClass, SemanticsInRule.class, "SemanticsInRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(semanticsOutRuleEClass, SemanticsOutRule.class, "SemanticsOutRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(actorClassEClass, ActorClass.class, "ActorClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getActorClass_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_Base(), this.getActorClass(), null, "base", null, 0, 1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_IfPorts(), this.getPort(), null, "ifPorts", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_UserCode1(), this.getDetailCode(), null, "userCode1", null, 0, 1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_UserCode2(), this.getDetailCode(), null, "userCode2", null, 0, 1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_IntPorts(), this.getPort(), null, "intPorts", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_ExtPorts(), this.getExternalPort(), null, "extPorts", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_ServiceImplementations(), this.getServiceImplementation(), null, "serviceImplementations", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_StrSAPs(), this.getSAPRef(), null, "strSAPs", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_Operations(), this.getOperation(), null, "operations", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_StateMachine(), this.getStateGraph(), null, "stateMachine", null, 0, 1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(interfaceItemEClass, InterfaceItem.class, "InterfaceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInterfaceItem_Name(), ecorePackage.getEString(), "name", null, 0, 1, InterfaceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInterfaceItem_Protocol(), this.getProtocolClass(), null, "protocol", null, 0, 1, InterfaceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(portEClass, Port.class, "Port", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPort_Conjugated(), ecorePackage.getEBoolean(), "conjugated", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPort_Multiplicity(), ecorePackage.getEInt(), "multiplicity", "1", 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(externalPortEClass, ExternalPort.class, "ExternalPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExternalPort_Ifport(), this.getPort(), null, "ifport", null, 0, 1, ExternalPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sapRefEClass, SAPRef.class, "SAPRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(sppRefEClass, SPPRef.class, "SPPRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(serviceImplementationEClass, ServiceImplementation.class, "ServiceImplementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getServiceImplementation_Spp(), this.getSPPRef(), null, "spp", null, 0, 1, ServiceImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalSystemEClass, LogicalSystem.class, "LogicalSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalSystem_SubSystems(), this.getSubSystemRef(), null, "subSystems", null, 0, -1, LogicalSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actorContainerRefEClass, ActorContainerRef.class, "ActorContainerRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getActorContainerRef_Name(), ecorePackage.getEString(), "name", null, 0, 1, ActorContainerRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subSystemRefEClass, SubSystemRef.class, "SubSystemRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSubSystemRef_Type(), this.getSubSystemClass(), null, "type", null, 0, 1, SubSystemRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subSystemClassEClass, SubSystemClass.class, "SubSystemClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSubSystemClass_RelayPorts(), this.getPort(), null, "relayPorts", null, 0, -1, SubSystemClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubSystemClass_Threads(), this.getLogicalThread(), null, "threads", null, 0, -1, SubSystemClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalThreadEClass, LogicalThread.class, "LogicalThread", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLogicalThread_Name(), ecorePackage.getEString(), "name", null, 0, 1, LogicalThread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLogicalThread_Instances(), this.getActorInstancePath(), null, "instances", null, 0, -1, LogicalThread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actorInstancePathEClass, ActorInstancePath.class, "ActorInstancePath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getActorInstancePath_Segments(), ecorePackage.getEString(), "segments", null, 0, -1, ActorInstancePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bindingEClass, Binding.class, "Binding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinding_Endpoint1(), this.getBindingEndPoint(), null, "endpoint1", null, 0, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinding_Endpoint2(), this.getBindingEndPoint(), null, "endpoint2", null, 0, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bindingEndPointEClass, BindingEndPoint.class, "BindingEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBindingEndPoint_ActorRef(), this.getActorContainerRef(), null, "actorRef", null, 0, 1, BindingEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBindingEndPoint_Port(), this.getPort(), null, "port", null, 0, 1, BindingEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(layerConnectionEClass, LayerConnection.class, "LayerConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLayerConnection_From(), this.getSAPoint(), null, "from", null, 0, 1, LayerConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLayerConnection_To(), this.getSPPoint(), null, "to", null, 0, 1, LayerConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(saPointEClass, SAPoint.class, "SAPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(refSAPointEClass, RefSAPoint.class, "RefSAPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRefSAPoint_Ref(), this.getActorContainerRef(), null, "ref", null, 0, 1, RefSAPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relaySAPointEClass, RelaySAPoint.class, "RelaySAPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRelaySAPoint_Relay(), this.getSPPRef(), null, "relay", null, 0, 1, RelaySAPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(spPointEClass, SPPoint.class, "SPPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSPPoint_Ref(), this.getActorContainerRef(), null, "ref", null, 0, 1, SPPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSPPoint_Service(), this.getSPPRef(), null, "service", null, 0, 1, SPPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actorRefEClass, ActorRef.class, "ActorRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActorRef_Type(), this.getActorClass(), null, "type", null, 0, 1, ActorRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateGraphNodeEClass, StateGraphNode.class, "StateGraphNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stateGraphItemEClass, StateGraphItem.class, "StateGraphItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getState_EntryCode(), this.getDetailCode(), null, "entryCode", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_ExitCode(), this.getDetailCode(), null, "exitCode", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_Subgraph(), this.getStateGraph(), null, "subgraph", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(stateEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(stateGraphEClass, StateGraph.class, "StateGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStateGraph_States(), this.getState(), null, "states", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateGraph_TrPoints(), this.getTrPoint(), null, "trPoints", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateGraph_ChPoints(), this.getChoicePoint(), null, "chPoints", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateGraph_Transitions(), this.getTransition(), null, "transitions", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(baseStateEClass, BaseState.class, "BaseState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBaseState_Name(), ecorePackage.getEString(), "name", null, 0, 1, BaseState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(refinedStateEClass, RefinedState.class, "RefinedState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRefinedState_Base(), this.getBaseState(), null, "base", null, 0, 1, RefinedState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(detailCodeEClass, DetailCode.class, "DetailCode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDetailCode_Commands(), ecorePackage.getEString(), "commands", null, 0, -1, DetailCode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trPointEClass, TrPoint.class, "TrPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTrPoint_Name(), ecorePackage.getEString(), "name", null, 0, 1, TrPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionPointEClass, TransitionPoint.class, "TransitionPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransitionPoint_Handler(), ecorePackage.getEBoolean(), "handler", null, 0, 1, TransitionPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(entryPointEClass, EntryPoint.class, "EntryPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(exitPointEClass, ExitPoint.class, "ExitPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(choicePointEClass, ChoicePoint.class, "ChoicePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getChoicePoint_Name(), ecorePackage.getEString(), "name", null, 0, 1, ChoicePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransition_Name(), ecorePackage.getEString(), "name", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransition_To(), this.getTransitionTerminal(), null, "to", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransition_Action(), this.getDetailCode(), null, "action", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nonInitialTransitionEClass, NonInitialTransition.class, "NonInitialTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNonInitialTransition_From(), this.getTransitionTerminal(), null, "from", null, 0, 1, NonInitialTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(initialTransitionEClass, InitialTransition.class, "InitialTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(continuationTransitionEClass, ContinuationTransition.class, "ContinuationTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(triggeredTransitionEClass, TriggeredTransition.class, "TriggeredTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTriggeredTransition_Triggers(), this.getTrigger(), null, "triggers", null, 0, -1, TriggeredTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(cpBranchTransitionEClass, CPBranchTransition.class, "CPBranchTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCPBranchTransition_Condition(), this.getDetailCode(), null, "condition", null, 0, 1, CPBranchTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionTerminalEClass, TransitionTerminal.class, "TransitionTerminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stateTerminalEClass, StateTerminal.class, "StateTerminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStateTerminal_State(), this.getBaseState(), null, "state", null, 0, 1, StateTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trPointTerminalEClass, TrPointTerminal.class, "TrPointTerminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTrPointTerminal_TrPoint(), this.getTrPoint(), null, "trPoint", null, 0, 1, TrPointTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subStateTrPointTerminalEClass, SubStateTrPointTerminal.class, "SubStateTrPointTerminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSubStateTrPointTerminal_TrPoint(), this.getTrPoint(), null, "trPoint", null, 0, 1, SubStateTrPointTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubStateTrPointTerminal_State(), this.getBaseState(), null, "state", null, 0, 1, SubStateTrPointTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(choicepointTerminalEClass, ChoicepointTerminal.class, "ChoicepointTerminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getChoicepointTerminal_Cp(), this.getChoicePoint(), null, "cp", null, 0, 1, ChoicepointTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(triggerEClass, Trigger.class, "Trigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTrigger_MsgFromIfPairs(), this.getMessageFromIf(), null, "msgFromIfPairs", null, 0, -1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTrigger_Guard(), this.getGuard(), null, "guard", null, 0, 1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(messageFromIfEClass, MessageFromIf.class, "MessageFromIf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMessageFromIf_Message(), this.getMessage(), null, "message", null, 0, 1, MessageFromIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessageFromIf_From(), this.getInterfaceItem(), null, "from", null, 0, 1, MessageFromIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(guardEClass, Guard.class, "Guard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGuard_Guard(), this.getDetailCode(), null, "guard", null, 0, 1, Guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(primitiveTypeEEnum, PrimitiveType.class, "PrimitiveType");
    addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.VOID);
    addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.INT8);
    addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.INT16);
    addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.INT32);
    addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.UINT8);
    addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.UINT16);
    addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.UINT32);
    addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.FLOAT32);
    addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.FLOAT64);
    addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.BOOLEAN);
    addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.STRING);
    addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.CHAR);

    // Create resource
    createResource(eNS_URI);
  }

} //RoomPackageImpl
