/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.generator.etricegen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Counter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.Counter#getCounter <em>Counter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.etricegen.ETriceGenPackage#getCounter()
 * @model
 * @generated
 */
public interface Counter extends EObject {
	/**
	 * Returns the value of the '<em><b>Counter</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Counter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Counter</em>' attribute.
	 * @see #setCounter(int)
	 * @see org.eclipse.etrice.generator.etricegen.ETriceGenPackage#getCounter_Counter()
	 * @model default="0"
	 * @generated
	 */
	int getCounter();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.generator.etricegen.Counter#getCounter <em>Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Counter</em>' attribute.
	 * @see #getCounter()
	 * @generated
	 */
	void setCounter(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getAndIncrementCount(1);'"
	 * @generated
	 */
	int getAndIncrementCount();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='int count = getCounter();\r\nsetCounter(count+n);\r\nreturn count;'"
	 * @generated
	 */
	int getAndIncrementCount(int n);

} // Counter
