/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.VarDecl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.VarDecl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.VarDecl#isRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getVarDecl()
 * @model
 * @generated
 */
public interface VarDecl extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getVarDecl_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.VarDecl#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(DataType)
   * @see org.eclipse.etrice.core.room.RoomPackage#getVarDecl_Type()
   * @model
   * @generated
   */
  DataType getType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.VarDecl#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(DataType value);

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
   * @see org.eclipse.etrice.core.room.RoomPackage#getVarDecl_Ref()
   * @model
   * @generated
   */
  boolean isRef();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.VarDecl#isRef <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' attribute.
   * @see #isRef()
   * @generated
   */
  void setRef(boolean value);

} // VarDecl
