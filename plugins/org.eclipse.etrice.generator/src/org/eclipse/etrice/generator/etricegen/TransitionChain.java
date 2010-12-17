/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.generator.etricegen;

import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.Transition;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Chain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.TransitionChain#getTransition <em>Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.etricegen.ETriceGenPackage#getTransitionChain()
 * @model
 * @generated
 */
public interface TransitionChain extends EObject {
	/**
	 * Returns the value of the '<em><b>Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition</em>' reference.
	 * @see #setTransition(Transition)
	 * @see org.eclipse.etrice.generator.etricegen.ETriceGenPackage#getTransitionChain_Transition()
	 * @model
	 * @generated
	 */
	Transition getTransition();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.generator.etricegen.TransitionChain#getTransition <em>Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition</em>' reference.
	 * @see #getTransition()
	 * @generated
	 */
	void setTransition(Transition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	State getStateContext();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isHandler();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model tcvType="org.eclipse.etrice.generator.etricegen.ITransitionChainVisitor"
	 * @generated
	 */
	String genExecuteChain(ITransitionChainVisitor tcv);

} // TransitionChain
