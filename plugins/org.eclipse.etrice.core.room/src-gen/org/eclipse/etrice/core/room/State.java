/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.State#getEntryCode <em>Entry Code</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.State#getExitCode <em>Exit Code</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.State#getSubgraph <em>Subgraph</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getState()
 * @model
 * @generated
 */
public interface State extends StateGraphNode
{
  /**
   * Returns the value of the '<em><b>Entry Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entry Code</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entry Code</em>' containment reference.
   * @see #setEntryCode(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getState_EntryCode()
   * @model containment="true"
   * @generated
   */
  DetailCode getEntryCode();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.State#getEntryCode <em>Entry Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Entry Code</em>' containment reference.
   * @see #getEntryCode()
   * @generated
   */
  void setEntryCode(DetailCode value);

  /**
   * Returns the value of the '<em><b>Exit Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exit Code</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exit Code</em>' containment reference.
   * @see #setExitCode(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getState_ExitCode()
   * @model containment="true"
   * @generated
   */
  DetailCode getExitCode();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.State#getExitCode <em>Exit Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exit Code</em>' containment reference.
   * @see #getExitCode()
   * @generated
   */
  void setExitCode(DetailCode value);

  /**
   * Returns the value of the '<em><b>Subgraph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subgraph</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subgraph</em>' containment reference.
   * @see #setSubgraph(StateGraph)
   * @see org.eclipse.etrice.core.room.RoomPackage#getState_Subgraph()
   * @model containment="true"
   * @generated
   */
  StateGraph getSubgraph();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.State#getSubgraph <em>Subgraph</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subgraph</em>' containment reference.
   * @see #getSubgraph()
   * @generated
   */
  void setSubgraph(StateGraph value);

} // State
