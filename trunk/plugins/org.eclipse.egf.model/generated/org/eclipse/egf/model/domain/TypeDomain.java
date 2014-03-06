/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.domain;

import org.eclipse.egf.model.types.TypeObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.TypeDomain#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.egf.model.domain.TypeDomain#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.domain.DomainPackage#getTypeDomain()
 * @model
 * @generated
 */
public interface TypeDomain extends TypeObject {

    /**
     * Returns the value of the '<em><b>Domain</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Domain</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Domain</em>' reference.
     * @see #setDomain(Domain)
     * @see org.eclipse.egf.model.domain.DomainPackage#getTypeDomain_Domain()
     * @model
     * @generated
     */
    Domain getDomain();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.domain.TypeDomain#getDomain <em>Domain</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Domain</em>' reference.
     * @see #getDomain()
     * @generated
     */
    void setDomain(Domain value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' reference.
     * @see #setValue(Domain)
     * @see org.eclipse.egf.model.domain.DomainPackage#getTypeDomain_Value()
     * @model
     * @generated
     */
    Domain getValue();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.domain.TypeDomain#getValue <em>Value</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' reference.
     * @see #getValue()
     * @generated
     */
    void setValue(Domain value);

} // TypeDomain
