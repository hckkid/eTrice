/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.BasicType#getPrim <em>Prim</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.BasicType#isRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getBasicType()
 * @model
 * @generated
 */
public interface BasicType extends EObject
{
  /**
   * Returns the value of the '<em><b>Prim</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.etrice.core.room.PrimitiveType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prim</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prim</em>' attribute.
   * @see org.eclipse.etrice.core.room.PrimitiveType
   * @see #setPrim(PrimitiveType)
   * @see org.eclipse.etrice.core.room.RoomPackage#getBasicType_Prim()
   * @model
   * @generated
   */
  PrimitiveType getPrim();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.BasicType#getPrim <em>Prim</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prim</em>' attribute.
   * @see org.eclipse.etrice.core.room.PrimitiveType
   * @see #getPrim()
   * @generated
   */
  void setPrim(PrimitiveType value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' attribute.
   * @see #setRef(boolean)
   * @see org.eclipse.etrice.core.room.RoomPackage#getBasicType_Ref()
   * @model
   * @generated
   */
  boolean isRef();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.BasicType#isRef <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' attribute.
   * @see #isRef()
   * @generated
   */
  void setRef(boolean value);

} // BasicType
