/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.room.BasicType;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.BasicTypeImpl#getPrim <em>Prim</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.BasicTypeImpl#isRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicTypeImpl extends MinimalEObjectImpl.Container implements BasicType
{
  /**
   * The default value of the '{@link #getPrim() <em>Prim</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrim()
   * @generated
   * @ordered
   */
  protected static final PrimitiveType PRIM_EDEFAULT = PrimitiveType.VOID;

  /**
   * The cached value of the '{@link #getPrim() <em>Prim</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrim()
   * @generated
   * @ordered
   */
  protected PrimitiveType prim = PRIM_EDEFAULT;

  /**
   * The default value of the '{@link #isRef() <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRef()
   * @generated
   * @ordered
   */
  protected static final boolean REF_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRef() <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRef()
   * @generated
   * @ordered
   */
  protected boolean ref = REF_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BasicTypeImpl()
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
    return RoomPackage.Literals.BASIC_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveType getPrim()
  {
    return prim;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrim(PrimitiveType newPrim)
  {
    PrimitiveType oldPrim = prim;
    prim = newPrim == null ? PRIM_EDEFAULT : newPrim;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.BASIC_TYPE__PRIM, oldPrim, prim));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(boolean newRef)
  {
    boolean oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.BASIC_TYPE__REF, oldRef, ref));
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
      case RoomPackage.BASIC_TYPE__PRIM:
        return getPrim();
      case RoomPackage.BASIC_TYPE__REF:
        return isRef();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RoomPackage.BASIC_TYPE__PRIM:
        setPrim((PrimitiveType)newValue);
        return;
      case RoomPackage.BASIC_TYPE__REF:
        setRef((Boolean)newValue);
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
      case RoomPackage.BASIC_TYPE__PRIM:
        setPrim(PRIM_EDEFAULT);
        return;
      case RoomPackage.BASIC_TYPE__REF:
        setRef(REF_EDEFAULT);
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
      case RoomPackage.BASIC_TYPE__PRIM:
        return prim != PRIM_EDEFAULT;
      case RoomPackage.BASIC_TYPE__REF:
        return ref != REF_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (prim: ");
    result.append(prim);
    result.append(", ref: ");
    result.append(ref);
    result.append(')');
    return result.toString();
  }

} //BasicTypeImpl
