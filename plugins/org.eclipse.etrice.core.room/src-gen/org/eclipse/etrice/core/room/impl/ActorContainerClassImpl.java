/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SPPRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Container Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorContainerClassImpl#getIfSPPs <em>If SP Ps</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorContainerClassImpl#getActorRefs <em>Actor Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorContainerClassImpl extends StructureClassImpl implements ActorContainerClass
{
  /**
   * The cached value of the '{@link #getIfSPPs() <em>If SP Ps</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIfSPPs()
   * @generated
   * @ordered
   */
  protected EList<SPPRef> ifSPPs;

  /**
   * The cached value of the '{@link #getActorRefs() <em>Actor Refs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActorRefs()
   * @generated
   * @ordered
   */
  protected EList<ActorRef> actorRefs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActorContainerClassImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return RoomPackage.Literals.ACTOR_CONTAINER_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SPPRef> getIfSPPs()
  {
    if (ifSPPs == null)
    {
      ifSPPs = new EObjectContainmentEList<SPPRef>(SPPRef.class, this, RoomPackage.ACTOR_CONTAINER_CLASS__IF_SP_PS);
    }
    return ifSPPs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ActorRef> getActorRefs()
  {
    if (actorRefs == null)
    {
      actorRefs = new EObjectContainmentEList<ActorRef>(ActorRef.class, this, RoomPackage.ACTOR_CONTAINER_CLASS__ACTOR_REFS);
    }
    return actorRefs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_CONTAINER_CLASS__IF_SP_PS:
        return ((InternalEList<?>)getIfSPPs()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CONTAINER_CLASS__ACTOR_REFS:
        return ((InternalEList<?>)getActorRefs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_CONTAINER_CLASS__IF_SP_PS:
        return getIfSPPs();
      case RoomPackage.ACTOR_CONTAINER_CLASS__ACTOR_REFS:
        return getActorRefs();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_CONTAINER_CLASS__IF_SP_PS:
        getIfSPPs().clear();
        getIfSPPs().addAll((Collection<? extends SPPRef>)newValue);
        return;
      case RoomPackage.ACTOR_CONTAINER_CLASS__ACTOR_REFS:
        getActorRefs().clear();
        getActorRefs().addAll((Collection<? extends ActorRef>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_CONTAINER_CLASS__IF_SP_PS:
        getIfSPPs().clear();
        return;
      case RoomPackage.ACTOR_CONTAINER_CLASS__ACTOR_REFS:
        getActorRefs().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_CONTAINER_CLASS__IF_SP_PS:
        return ifSPPs != null && !ifSPPs.isEmpty();
      case RoomPackage.ACTOR_CONTAINER_CLASS__ACTOR_REFS:
        return actorRefs != null && !actorRefs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ActorContainerClassImpl
