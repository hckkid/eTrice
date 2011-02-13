/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.generator.etricegen.impl;


import java.util.HashMap;

import org.eclipse.etrice.core.room.ActorInstancePath;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.etricegen.Counter;
import org.eclipse.etrice.generator.etricegen.ETriceGenPackage;
import org.eclipse.etrice.generator.etricegen.InstanceBase;
import org.eclipse.etrice.generator.etricegen.SubSystemInstance;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub LogicalSystem Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.SubSystemInstanceImpl#getSubSystemClass <em>Sub System Class</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.SubSystemInstanceImpl#getObjCounter <em>Obj Counter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubSystemInstanceImpl extends StructureInstanceImpl implements SubSystemInstance {
	/**
	 * The cached value of the '{@link #getSubSystemClass() <em>Sub System Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSystemClass()
	 * @generated
	 * @ordered
	 */
	protected SubSystemClass subSystemClass;

	/**
	 * The cached value of the '{@link #getObjCounter() <em>Obj Counter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjCounter()
	 * @generated
	 * @ordered
	 */
	protected Counter objCounter;

	private HashMap<String, Integer> inst2thread = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubSystemInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.SUB_SYSTEM_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubSystemClass getSubSystemClass() {
		if (subSystemClass != null && subSystemClass.eIsProxy()) {
			InternalEObject oldSubSystemClass = (InternalEObject)subSystemClass;
			subSystemClass = (SubSystemClass)eResolveProxy(oldSubSystemClass);
			if (subSystemClass != oldSubSystemClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.SUB_SYSTEM_INSTANCE__SUB_SYSTEM_CLASS, oldSubSystemClass, subSystemClass));
			}
		}
		return subSystemClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubSystemClass basicGetSubSystemClass() {
		return subSystemClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubSystemClass(SubSystemClass newSubSystemClass) {
		SubSystemClass oldSubSystemClass = subSystemClass;
		subSystemClass = newSubSystemClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.SUB_SYSTEM_INSTANCE__SUB_SYSTEM_CLASS, oldSubSystemClass, subSystemClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Counter getObjCounter() {
		return objCounter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObjCounter(Counter newObjCounter, NotificationChain msgs) {
		Counter oldObjCounter = objCounter;
		objCounter = newObjCounter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ETriceGenPackage.SUB_SYSTEM_INSTANCE__OBJ_COUNTER, oldObjCounter, newObjCounter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjCounter(Counter newObjCounter) {
		if (newObjCounter != objCounter) {
			NotificationChain msgs = null;
			if (objCounter != null)
				msgs = ((InternalEObject)objCounter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ETriceGenPackage.SUB_SYSTEM_INSTANCE__OBJ_COUNTER, null, msgs);
			if (newObjCounter != null)
				msgs = ((InternalEObject)newObjCounter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ETriceGenPackage.SUB_SYSTEM_INSTANCE__OBJ_COUNTER, null, msgs);
			msgs = basicSetObjCounter(newObjCounter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.SUB_SYSTEM_INSTANCE__OBJ_COUNTER, newObjCounter, newObjCounter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getThreadId(InstanceBase instance) {
		if (instance==null)
			return -1;
		
		if (inst2thread==null) {
			inst2thread = new HashMap<String, Integer>();
			
			// create mapping
			int tid = 1;
			for (LogicalThread ls : getSubSystemClass().getThreads()) {
				for (ActorInstancePath inst : ls.getInstances()) {
					String path = getPath();
					for (String seg : inst.getSegments()) {
						path += InstanceBase.pathDelim+seg;
					}
					inst2thread.put(path, tid);
				}
				tid++;
			}
		}
		
		// if mapping exists use that
		Integer tid = inst2thread.get(instance.getPath());
		if (tid!=null)
			return tid;
		
		// use own thread id
		return getThreadId();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ETriceGenPackage.SUB_SYSTEM_INSTANCE__OBJ_COUNTER:
				return basicSetObjCounter(null, msgs);
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
			case ETriceGenPackage.SUB_SYSTEM_INSTANCE__SUB_SYSTEM_CLASS:
				if (resolve) return getSubSystemClass();
				return basicGetSubSystemClass();
			case ETriceGenPackage.SUB_SYSTEM_INSTANCE__OBJ_COUNTER:
				return getObjCounter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ETriceGenPackage.SUB_SYSTEM_INSTANCE__SUB_SYSTEM_CLASS:
				setSubSystemClass((SubSystemClass)newValue);
				return;
			case ETriceGenPackage.SUB_SYSTEM_INSTANCE__OBJ_COUNTER:
				setObjCounter((Counter)newValue);
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
			case ETriceGenPackage.SUB_SYSTEM_INSTANCE__SUB_SYSTEM_CLASS:
				setSubSystemClass((SubSystemClass)null);
				return;
			case ETriceGenPackage.SUB_SYSTEM_INSTANCE__OBJ_COUNTER:
				setObjCounter((Counter)null);
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
			case ETriceGenPackage.SUB_SYSTEM_INSTANCE__SUB_SYSTEM_CLASS:
				return subSystemClass != null;
			case ETriceGenPackage.SUB_SYSTEM_INSTANCE__OBJ_COUNTER:
				return objCounter != null;
		}
		return super.eIsSet(featureID);
	}

} //SubSystemInstanceImpl
