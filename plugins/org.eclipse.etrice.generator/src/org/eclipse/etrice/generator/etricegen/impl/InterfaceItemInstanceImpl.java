/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.generator.etricegen.impl;


import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.etrice.generator.etricegen.ETriceGenPackage;
import org.eclipse.etrice.generator.etricegen.InterfaceItemInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Item Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.InterfaceItemInstanceImpl#getPeers <em>Peers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceItemInstanceImpl extends InstanceBaseImpl implements InterfaceItemInstance {
	/**
	 * The cached value of the '{@link #getPeers() <em>Peers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeers()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceItemInstance> peers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceItemInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.INTERFACE_ITEM_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InterfaceItemInstance> getPeers() {
		if (peers == null) {
			peers = new EObjectResolvingEList<InterfaceItemInstance>(InterfaceItemInstance.class, this, ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS);
		}
		return peers;
	}

	public int getNObjIDs() {
		int n = getPeers().size();
		if (n==0)
			n = 1;
		return n;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS:
				return getPeers();
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
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS:
				getPeers().clear();
				getPeers().addAll((Collection<? extends InterfaceItemInstance>)newValue);
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
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS:
				getPeers().clear();
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
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS:
				return peers != null && !peers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InterfaceItemInstanceImpl
