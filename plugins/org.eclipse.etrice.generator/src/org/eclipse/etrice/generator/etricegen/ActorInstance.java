/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.generator.etricegen;

import org.eclipse.etrice.core.room.ActorClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.ActorInstance#getActorClass <em>Actor Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.etricegen.ETriceGenPackage#getActorInstance()
 * @model
 * @generated
 */
public interface ActorInstance extends StructureInstance {
	/**
	 * Returns the value of the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor Class</em>' reference.
	 * @see #setActorClass(ActorClass)
	 * @see org.eclipse.etrice.generator.etricegen.ETriceGenPackage#getActorInstance_ActorClass()
	 * @model
	 * @generated
	 */
	ActorClass getActorClass();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.generator.etricegen.ActorInstance#getActorClass <em>Actor Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor Class</em>' reference.
	 * @see #getActorClass()
	 * @generated
	 */
	void setActorClass(ActorClass value);

} // ActorInstance
