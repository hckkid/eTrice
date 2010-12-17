/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.generator.etricegen.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.generator.etricegen.ActorInstance;
import org.eclipse.etrice.generator.etricegen.ETriceGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.ActorInstanceImpl#getActorClass <em>Actor Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorInstanceImpl extends StructureInstanceImpl implements ActorInstance {
	/**
	 * The cached value of the '{@link #getActorClass() <em>Actor Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActorClass()
	 * @generated
	 * @ordered
	 */
	protected ActorClass actorClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.ACTOR_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorClass getActorClass() {
		if (actorClass != null && actorClass.eIsProxy()) {
			InternalEObject oldActorClass = (InternalEObject)actorClass;
			actorClass = (ActorClass)eResolveProxy(oldActorClass);
			if (actorClass != oldActorClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.ACTOR_INSTANCE__ACTOR_CLASS, oldActorClass, actorClass));
			}
		}
		return actorClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorClass basicGetActorClass() {
		return actorClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActorClass(ActorClass newActorClass) {
		ActorClass oldActorClass = actorClass;
		actorClass = newActorClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.ACTOR_INSTANCE__ACTOR_CLASS, oldActorClass, actorClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.ACTOR_INSTANCE__ACTOR_CLASS:
				if (resolve) return getActorClass();
				return basicGetActorClass();
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
			case ETriceGenPackage.ACTOR_INSTANCE__ACTOR_CLASS:
				setActorClass((ActorClass)newValue);
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
			case ETriceGenPackage.ACTOR_INSTANCE__ACTOR_CLASS:
				setActorClass((ActorClass)null);
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
			case ETriceGenPackage.ACTOR_INSTANCE__ACTOR_CLASS:
				return actorClass != null;
		}
		return super.eIsSet(featureID);
	}

} //ActorInstanceImpl
