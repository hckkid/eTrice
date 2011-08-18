/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.Type#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.Type#getExt <em>Ext</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getType()
 * @model
 * @generated
 */
public interface Type extends BasicType
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(DataClass)
   * @see org.eclipse.etrice.core.room.RoomPackage#getType_Type()
   * @model
   * @generated
   */
  DataClass getType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Type#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(DataClass value);

  /**
   * Returns the value of the '<em><b>Ext</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ext</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ext</em>' attribute.
   * @see #setExt(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getType_Ext()
   * @model
   * @generated
   */
  String getExt();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Type#getExt <em>Ext</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ext</em>' attribute.
   * @see #getExt()
   * @generated
   */
  void setExt(String value);

} // Type
