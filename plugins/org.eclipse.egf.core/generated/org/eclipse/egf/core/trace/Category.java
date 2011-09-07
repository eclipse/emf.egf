/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.core.trace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.core.trace.Category#getFilters <em>Filters</em>}</li>
 *   <li>{@link org.eclipse.egf.core.trace.Category#isActive <em>Active</em>}</li>
 *   <li>{@link org.eclipse.egf.core.trace.Category#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.core.trace.TracePackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends EObject {
    /**
     * Returns the value of the '<em><b>Filters</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.core.trace.Filter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Filters</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Filters</em>' containment reference list.
     * @see org.eclipse.egf.core.trace.TracePackage#getCategory_Filters()
     * @model containment="true"
     * @generated
     */
    EList<Filter> getFilters();

    /**
     * Returns the value of the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Active</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Active</em>' attribute.
     * @see #setActive(boolean)
     * @see org.eclipse.egf.core.trace.TracePackage#getCategory_Active()
     * @model
     * @generated
     */
    boolean isActive();

    /**
     * Sets the value of the '{@link org.eclipse.egf.core.trace.Category#isActive <em>Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Active</em>' attribute.
     * @see #isActive()
     * @generated
     */
    void setActive(boolean value);

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
     * @see org.eclipse.egf.core.trace.TracePackage#getCategory_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.eclipse.egf.core.trace.Category#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // Category
