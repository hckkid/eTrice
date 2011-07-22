/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.StateMachine#isDataDriven <em>Data Driven</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getStateMachine()
 * @model
 * @generated
 */
public interface StateMachine extends StateGraph
{
  /**
   * Returns the value of the '<em><b>Data Driven</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Driven</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Driven</em>' attribute.
   * @see #setDataDriven(boolean)
   * @see org.eclipse.etrice.core.room.RoomPackage#getStateMachine_DataDriven()
   * @model
   * @generated
   */
  boolean isDataDriven();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.StateMachine#isDataDriven <em>Data Driven</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Driven</em>' attribute.
   * @see #isDataDriven()
   * @generated
   */
  void setDataDriven(boolean value);

} // StateMachine
