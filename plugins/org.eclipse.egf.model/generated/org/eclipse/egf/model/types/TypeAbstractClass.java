/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.types;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Abstract Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.types.TypeAbstractClass#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.eclipse.egf.model.types.TypeAbstractClass#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.types.TypesPackage#getTypeAbstractClass()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='LoadableType ValidValue ValidInstance'"
 * @generated
 */
public interface TypeAbstractClass extends Type {

    /**
     * Returns the value of the '<em><b>Instance</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instance</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instance</em>' attribute.
     * @see #setInstance(Object)
     * @see org.eclipse.egf.model.types.TypesPackage#getTypeAbstractClass_Instance()
     * @model transient="true"
     * @generated
     */
    Object getInstance();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.types.TypeAbstractClass#getInstance <em>Instance</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Instance</em>' attribute.
     * @see #getInstance()
     * @generated
     */
    void setInstance(Object value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see org.eclipse.egf.model.types.TypesPackage#getTypeAbstractClass_Value()
     * @model
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.types.TypeAbstractClass#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

} // TypeAbstractClass
