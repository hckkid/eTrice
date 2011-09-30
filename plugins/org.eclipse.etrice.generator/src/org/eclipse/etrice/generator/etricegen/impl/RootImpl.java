/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.generator.etricegen.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.FreeTypedID;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.TypedID;
import org.eclipse.etrice.generator.base.FileSystemHelpers;
import org.eclipse.etrice.generator.etricegen.ActorInstance;
import org.eclipse.etrice.generator.etricegen.ETriceGenPackage;
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.etricegen.SubSystemInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.RootImpl#isLibrary <em>Library</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.RootImpl#getSubSystemInstances <em>Sub System Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.RootImpl#getModels <em>Models</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.RootImpl#getXpActorClasses <em>Xp Actor Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.RootImpl#getUsedDataClasses <em>Used Data Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.RootImpl#getUsedProtocolClasses <em>Used Protocol Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.RootImpl#getUsedActorClasses <em>Used Actor Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.RootImpl#getUsedRoomModels <em>Used Room Models</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.RootImpl#getMainPathSubSystemClasses <em>Main Path Sub System Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootImpl extends EObjectImpl implements Root {
	
	private class RoomClassComparator implements Comparator<RoomClass> {

		@Override
		public int compare(RoomClass o1, RoomClass o2) {
			return o1.getName().compareTo(o2.getName());
		}

	}

	private class RoomModelComparator implements Comparator<RoomModel> {

		@Override
		public int compare(RoomModel o1, RoomModel o2) {
			return o1.getName().compareTo(o2.getName());
		}

	}

	/**
	 * The default value of the '{@link #isLibrary() <em>Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLibrary()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LIBRARY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getSubSystemInstances() <em>Sub System Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSystemInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<SubSystemInstance> subSystemInstances;

	/**
	 * The cached value of the '{@link #getModels() <em>Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModels()
	 * @generated
	 * @ordered
	 */
	protected EList<RoomModel> models;

	/**
	 * The cached value of the '{@link #getXpActorClasses() <em>Xp Actor Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpActorClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpandedActorClass> xpActorClasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubSystemInstance> getSubSystemInstances() {
		if (subSystemInstances == null) {
			subSystemInstances = new EObjectContainmentEList<SubSystemInstance>(SubSystemInstance.class, this, ETriceGenPackage.ROOT__SUB_SYSTEM_INSTANCES);
		}
		return subSystemInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoomModel> getModels() {
		if (models == null) {
			models = new EObjectResolvingEList<RoomModel>(RoomModel.class, this, ETriceGenPackage.ROOT__MODELS);
		}
		return models;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpandedActorClass> getXpActorClasses() {
		if (xpActorClasses == null) {
			xpActorClasses = new EObjectContainmentEList<ExpandedActorClass>(ExpandedActorClass.class, this, ETriceGenPackage.ROOT__XP_ACTOR_CLASSES);
		}
		return xpActorClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<DataClass> getUsedDataClasses() {
		if (usedDataClasses==null) {
			computeUsedClasses();
		}
		return usedDataClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ProtocolClass> getUsedProtocolClasses() {
		if (usedProtocolClasses==null) {
			computeUsedClasses();
		}
		return usedProtocolClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ActorClass> getUsedActorClasses() {
		if (usedActorClasses==null) {
			computeUsedClasses();
		}
		return usedActorClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<RoomModel> getUsedRoomModels() {
		if (usedRoomModels==null) {
			computeUsedClasses();
		}
		return usedRoomModels;
	}
	
	private BasicEList<SubSystemClass> mainPathSubSystemClasses = null;
	
	private class CollectMainPathSubSystems implements IModelVisitor {
		@Override
		public boolean visit(RoomModel mdl) {
			mainPathSubSystemClasses.addAll(mdl.getSubSystemClasses());
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<SubSystemClass> getMainPathSubSystemClasses() {
		if (mainPathSubSystemClasses==null) {
			mainPathSubSystemClasses = new BasicEList<SubSystemClass>();
			CollectMainPathSubSystems collector = new CollectMainPathSubSystems();
			traverseModelsOnMainPath(collector);
		}
		
		return mainPathSubSystemClasses;
	}

	private interface IModelVisitor {
		public boolean visit(RoomModel mdl);
	}

	private void traverseModelsOnMainPath(IModelVisitor visitor) {
		if (!getModels().isEmpty()) {
			// determine the path of the main model
			RoomModel main = getModels().get(0);
			URI mainPath = FileSystemHelpers.getProjectURI(main);
			
			for (RoomModel mdl : getModels()) {
				URI currPath = FileSystemHelpers.getProjectURI(mdl);
				if ((mainPath==null && currPath==null) || (mainPath!=null && mainPath.equals(currPath))) {
					if (!visitor.visit(mdl))
						break;
				}
			}
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isLibrary() {
		return getMainPathSubSystemClasses().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<RoomModel> getReferencedModels(RoomClass cls) {

		if (cls instanceof ExpandedActorClass)
			cls = ((ExpandedActorClass)cls).getActorClass();
		
		HashSet<DataClass> dataClasses = new HashSet<DataClass>();
		HashSet<ProtocolClass> protocolClasses = new HashSet<ProtocolClass>();
		HashSet<ActorClass> actorClasses = new HashSet<ActorClass>();
		HashSet<RoomModel> models = new HashSet<RoomModel>();
		
		if (cls instanceof DataClass) {
			dataClasses.add((DataClass) cls);
		}
		else if (cls instanceof ProtocolClass) {
			protocolClasses.add((ProtocolClass) cls);
		}
		else if (cls instanceof ActorClass) {
			actorClasses.add((ActorClass) cls);
		}
		else if (cls instanceof SubSystemClass) {
			SubSystemClass cc = (SubSystemClass) cls;
			for (ActorRef ar : cc.getActorRefs()) {
				recursivelyAddReferencedClasses(ar.getType(), actorClasses);
			}
		}

		getReferencedClassesAndModels(dataClasses, protocolClasses,
				actorClasses, models);

		// remove own model
		models.remove(cls.eContainer());
		
		BasicEList<RoomModel> result = new BasicEList<RoomModel>(models);
		Comparator<RoomModel> comp = new RoomModelComparator();
		Collections.sort(result, comp);
		return result;
	}

	private void recursivelyAddReferencedClasses(ActorClass ac, HashSet<ActorClass> actorClasses) {
		actorClasses.add(ac);
		
		for (ActorRef ar : ac.getActorRefs()) {
			recursivelyAddReferencedClasses(ar.getType(), actorClasses);
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ProtocolClass> getReferencedProtocols(ActorClass cls) {

		if (cls instanceof ExpandedActorClass)
			cls = ((ExpandedActorClass)cls).getActorClass();

		HashSet<DataClass> dataClasses = new HashSet<DataClass>();
		HashSet<ProtocolClass> protocolClasses = new HashSet<ProtocolClass>();
		HashSet<ActorClass> actorClasses = new HashSet<ActorClass>();
		HashSet<RoomModel> models = new HashSet<RoomModel>();

		actorClasses.add(cls);

		getReferencedClassesAndModels(dataClasses, protocolClasses,
				actorClasses, models);
		
		BasicEList<ProtocolClass> result = new BasicEList<ProtocolClass>(protocolClasses);
		Comparator<RoomClass> comp = new RoomClassComparator();
		Collections.sort(result, comp);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ETriceGenPackage.ROOT__SUB_SYSTEM_INSTANCES:
				return ((InternalEList<?>)getSubSystemInstances()).basicRemove(otherEnd, msgs);
			case ETriceGenPackage.ROOT__XP_ACTOR_CLASSES:
				return ((InternalEList<?>)getXpActorClasses()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.ROOT__LIBRARY:
				return isLibrary();
			case ETriceGenPackage.ROOT__SUB_SYSTEM_INSTANCES:
				return getSubSystemInstances();
			case ETriceGenPackage.ROOT__MODELS:
				return getModels();
			case ETriceGenPackage.ROOT__XP_ACTOR_CLASSES:
				return getXpActorClasses();
			case ETriceGenPackage.ROOT__USED_DATA_CLASSES:
				return getUsedDataClasses();
			case ETriceGenPackage.ROOT__USED_PROTOCOL_CLASSES:
				return getUsedProtocolClasses();
			case ETriceGenPackage.ROOT__USED_ACTOR_CLASSES:
				return getUsedActorClasses();
			case ETriceGenPackage.ROOT__USED_ROOM_MODELS:
				return getUsedRoomModels();
			case ETriceGenPackage.ROOT__MAIN_PATH_SUB_SYSTEM_CLASSES:
				return getMainPathSubSystemClasses();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ETriceGenPackage.ROOT__SUB_SYSTEM_INSTANCES:
				getSubSystemInstances().clear();
				getSubSystemInstances().addAll((Collection<? extends SubSystemInstance>)newValue);
				return;
			case ETriceGenPackage.ROOT__MODELS:
				getModels().clear();
				getModels().addAll((Collection<? extends RoomModel>)newValue);
				return;
			case ETriceGenPackage.ROOT__XP_ACTOR_CLASSES:
				getXpActorClasses().clear();
				getXpActorClasses().addAll((Collection<? extends ExpandedActorClass>)newValue);
				return;
			case ETriceGenPackage.ROOT__USED_DATA_CLASSES:
				getUsedDataClasses().clear();
				getUsedDataClasses().addAll((Collection<? extends DataClass>)newValue);
				return;
			case ETriceGenPackage.ROOT__USED_PROTOCOL_CLASSES:
				getUsedProtocolClasses().clear();
				getUsedProtocolClasses().addAll((Collection<? extends ProtocolClass>)newValue);
				return;
			case ETriceGenPackage.ROOT__USED_ACTOR_CLASSES:
				getUsedActorClasses().clear();
				getUsedActorClasses().addAll((Collection<? extends ActorClass>)newValue);
				return;
			case ETriceGenPackage.ROOT__USED_ROOM_MODELS:
				getUsedRoomModels().clear();
				getUsedRoomModels().addAll((Collection<? extends RoomModel>)newValue);
				return;
			case ETriceGenPackage.ROOT__MAIN_PATH_SUB_SYSTEM_CLASSES:
				getMainPathSubSystemClasses().clear();
				getMainPathSubSystemClasses().addAll((Collection<? extends SubSystemClass>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ETriceGenPackage.ROOT__SUB_SYSTEM_INSTANCES:
				getSubSystemInstances().clear();
				return;
			case ETriceGenPackage.ROOT__MODELS:
				getModels().clear();
				return;
			case ETriceGenPackage.ROOT__XP_ACTOR_CLASSES:
				getXpActorClasses().clear();
				return;
			case ETriceGenPackage.ROOT__USED_DATA_CLASSES:
				getUsedDataClasses().clear();
				return;
			case ETriceGenPackage.ROOT__USED_PROTOCOL_CLASSES:
				getUsedProtocolClasses().clear();
				return;
			case ETriceGenPackage.ROOT__USED_ACTOR_CLASSES:
				getUsedActorClasses().clear();
				return;
			case ETriceGenPackage.ROOT__USED_ROOM_MODELS:
				getUsedRoomModels().clear();
				return;
			case ETriceGenPackage.ROOT__MAIN_PATH_SUB_SYSTEM_CLASSES:
				getMainPathSubSystemClasses().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ETriceGenPackage.ROOT__LIBRARY:
				return isLibrary() != LIBRARY_EDEFAULT;
			case ETriceGenPackage.ROOT__SUB_SYSTEM_INSTANCES:
				return subSystemInstances != null && !subSystemInstances.isEmpty();
			case ETriceGenPackage.ROOT__MODELS:
				return models != null && !models.isEmpty();
			case ETriceGenPackage.ROOT__XP_ACTOR_CLASSES:
				return xpActorClasses != null && !xpActorClasses.isEmpty();
			case ETriceGenPackage.ROOT__USED_DATA_CLASSES:
				return !getUsedDataClasses().isEmpty();
			case ETriceGenPackage.ROOT__USED_PROTOCOL_CLASSES:
				return !getUsedProtocolClasses().isEmpty();
			case ETriceGenPackage.ROOT__USED_ACTOR_CLASSES:
				return !getUsedActorClasses().isEmpty();
			case ETriceGenPackage.ROOT__USED_ROOM_MODELS:
				return !getUsedRoomModels().isEmpty();
			case ETriceGenPackage.ROOT__MAIN_PATH_SUB_SYSTEM_CLASSES:
				return !getMainPathSubSystemClasses().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	private HashMap<String, DataClass> name2dc = new HashMap<String, DataClass>();
	
	private BasicEList<DataClass> usedDataClasses = null;
	private BasicEList<ProtocolClass> usedProtocolClasses = null;
	private BasicEList<ActorClass> usedActorClasses = null;
	private BasicEList<RoomModel> usedRoomModels = null;
	
	private class CollectMainPathClasses implements IModelVisitor {

		@Override
		public boolean visit(RoomModel mdl) {
			usedDataClasses.addAll(mdl.getDataClasses());
			usedProtocolClasses.addAll(mdl.getProtocolClasses());
			usedActorClasses.addAll(mdl.getActorClasses());
			usedRoomModels.add(mdl);
			return true;
		}
		
	}
	
	private void computeUsedClasses() {
		if (isLibrary()) {
			usedDataClasses = new BasicEList<DataClass>();
			usedProtocolClasses = new BasicEList<ProtocolClass>();
			usedActorClasses = new BasicEList<ActorClass>();
			usedRoomModels = new BasicEList<RoomModel>();

			traverseModelsOnMainPath(new CollectMainPathClasses());
		}
		else {
			for (RoomModel mdl : getModels()) {
				for (DataClass dc : mdl.getDataClasses()) {
					name2dc.put(dc.getName(), dc);
				}
			}
			
			// first we collect actor classes
			HashSet<ActorClass> actorClasses = new HashSet<ActorClass>();
			for (SubSystemInstance ci : getSubSystemInstances()) {
				TreeIterator<EObject> it = ci.eAllContents();
				while (it.hasNext()) {
					EObject obj = it.next();
					if (obj instanceof ActorInstance) {
						ActorClass ac = ((ActorInstance)obj).getActorClass();
						actorClasses.add(ac);
					}
				}
			}
			
			HashSet<DataClass> dataClasses = new HashSet<DataClass>();
			HashSet<ProtocolClass> protocolClasses = new HashSet<ProtocolClass>();
			HashSet<RoomModel> models = new HashSet<RoomModel>();
			
			getReferencedClassesAndModels(dataClasses, protocolClasses,
					actorClasses, models);
			
			usedDataClasses = new BasicEList<DataClass>(dataClasses);
			usedProtocolClasses = new BasicEList<ProtocolClass>(protocolClasses);
			usedActorClasses = new BasicEList<ActorClass>(actorClasses);
			usedRoomModels = new BasicEList<RoomModel>(models);
		}
	}

	private void getReferencedClassesAndModels(HashSet<DataClass> dataClasses,
			HashSet<ProtocolClass> protocolClasses,
			HashSet<ActorClass> actorClasses, HashSet<RoomModel> models) {
		// add actor base classes
		LinkedList<ActorClass> tmpAc = new LinkedList<ActorClass>(actorClasses);
		for (ActorClass ac : tmpAc) {
			while (ac.getBase()!=null) {
				ac = ac.getBase();
				actorClasses.add(ac);
			}
		}
		
		// determine data and protocol classes used by actor classes
		for (ActorClass ac : actorClasses) {
			getInterfaceItemProtocolClasses(protocolClasses, ac.getIfPorts());
			// ExtPorts are in the interface and thus already covered
			getInterfaceItemProtocolClasses(protocolClasses, ac.getIntPorts());
			getInterfaceItemProtocolClasses(protocolClasses, ac.getStrSAPs());
			for (ServiceImplementation ispp : ac.getServiceImplementations()) {
				protocolClasses.add(ispp.getSpp().getProtocol());
			}
			getInterfaceItemProtocolClasses(protocolClasses, ac.getIfSPPs());
			getAttributeDataClasses(dataClasses, ac.getAttributes());
			getOperationDataClasses(dataClasses, ac.getOperations());
		}
		
		// add protocol base classes
		LinkedList<ProtocolClass> tmpPc = new LinkedList<ProtocolClass>(protocolClasses);
		for (ProtocolClass pc : tmpPc) {
			while (pc.getBase()!=null) {
				pc = pc.getBase();
				protocolClasses.add(pc);
			}
		}
		
		// add data classes used by protocols
		for (ProtocolClass pc : protocolClasses) {
			for (Message m : pc.getIncomingMessages()) {
				getTypedIdDataClasses(dataClasses, m.getData());
			}
			for (Message m : pc.getOutgoingMessages()) {
				getTypedIdDataClasses(dataClasses, m.getData());
			}
		}
		
		// add data class base classes and data class attribute and operation classes
		boolean repeat = true;
		do {
			LinkedList<DataClass> tmpDc = new LinkedList<DataClass>(dataClasses);
			for (DataClass dc : tmpDc) {
				getAttributeDataClasses(dataClasses, dc.getAttributes());
				getOperationDataClasses(dataClasses, dc.getOperations());
				while (dc.getBase()!=null) {
					dc = dc.getBase();
					dataClasses.add(dc);
				}
			}
			
			if (tmpDc.size()==dataClasses.size())
				// nothing changed
				repeat = false;
		}
		while (repeat);
		
		// finally compute used models
		for (DataClass dc : dataClasses) {
			models.add((RoomModel) dc.eContainer());
		}
		for (ProtocolClass pc : protocolClasses) {
			models.add((RoomModel) pc.eContainer());
		}
		for (ActorClass ac : actorClasses) {
			models.add((RoomModel) ac.eContainer());
		}
	}

	private void getInterfaceItemProtocolClasses(
			HashSet<ProtocolClass> protocolClasses, EList<? extends InterfaceItem> items) {
		for (InterfaceItem ii : items) {
			protocolClasses.add(ii.getProtocol());
		}
	}

	private void getOperationDataClasses(HashSet<DataClass> dataClasses,
			EList<Operation> operations) {
		for (Operation op : operations) {
			if (op.getReturntype()!=null) {
				DataClass dc = name2dc.get(op.getReturntype());
				if (dc!=null)
					dataClasses.add(dc);
			}
			getFreeTypedIdDataClasses(dataClasses, op.getArguments());
		}
	}

	private void getTypedIdDataClasses(HashSet<DataClass> dataClasses, TypedID data) {
		if (data!=null) {
			if (data.getType().getType()!=null)
				dataClasses.add(data.getType().getType());
		}
	}

	private void getFreeTypedIdDataClasses(HashSet<DataClass> dataClasses,
			EList<FreeTypedID> arguments) {
		for (FreeTypedID tid : arguments) {
			DataClass dc = name2dc.get(tid.getType());
			if (dc!=null)
				dataClasses.add(dc);
		}
	}

	private void getAttributeDataClasses(HashSet<DataClass> dataClasses,
			EList<Attribute> attributes) {
		for (Attribute attr : attributes) {
			if (attr.getType().getType()!=null)
				dataClasses.add(attr.getType().getType());
		}
	}

} //RootImpl
