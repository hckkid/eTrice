/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.generator.etricegen;

import org.eclipse.etrice.core.room.SubSystemClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.SubSystemInstance#getSubSystemClass <em>Sub System Class</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.SubSystemInstance#getObjCounter <em>Obj Counter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.etricegen.ETriceGenPackage#getSubSystemInstance()
 * @model
 * @generated
 */
public interface SubSystemInstance extends StructureInstance {
	/**
	 * Returns the value of the '<em><b>Sub System Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub System Class</em>' reference.
	 * @see #setSubSystemClass(SubSystemClass)
	 * @see org.eclipse.etrice.generator.etricegen.ETriceGenPackage#getSubSystemInstance_SubSystemClass()
	 * @model
	 * @generated
	 */
	SubSystemClass getSubSystemClass();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.generator.etricegen.SubSystemInstance#getSubSystemClass <em>Sub System Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub System Class</em>' reference.
	 * @see #getSubSystemClass()
	 * @generated
	 */
	void setSubSystemClass(SubSystemClass value);

	/**
	 * Returns the value of the '<em><b>Obj Counter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obj Counter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj Counter</em>' containment reference.
	 * @see #setObjCounter(Counter)
	 * @see org.eclipse.etrice.generator.etricegen.ETriceGenPackage#getSubSystemInstance_ObjCounter()
	 * @model containment="true"
	 * @generated
	 */
	Counter getObjCounter();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.generator.etricegen.SubSystemInstance#getObjCounter <em>Obj Counter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj Counter</em>' containment reference.
	 * @see #getObjCounter()
	 * @generated
	 */
	void setObjCounter(Counter value);

} // ComponentInstance
