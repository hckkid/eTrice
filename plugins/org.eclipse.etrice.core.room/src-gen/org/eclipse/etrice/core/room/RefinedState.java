/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Refined State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.RefinedState#getBase <em>Base</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getRefinedState()
 * @model
 * @generated
 */
public interface RefinedState extends State
{
  /**
   * Returns the value of the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' reference.
   * @see #setBase(BaseState)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRefinedState_Base()
   * @model
   * @generated
   */
  BaseState getBase();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RefinedState#getBase <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' reference.
   * @see #getBase()
   * @generated
   */
  void setBase(BaseState value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getBase()==null? \"\":getBase().getName();'"
   * @generated
   */
  String getName();

} // RefinedState
