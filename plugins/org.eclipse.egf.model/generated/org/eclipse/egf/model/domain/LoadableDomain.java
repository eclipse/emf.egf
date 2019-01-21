/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.domain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loadable Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.LoadableDomain#isLoaded <em>Loaded</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.domain.DomainPackage#getLoadableDomain()
 * @model abstract="true"
 * @generated
 */
public interface LoadableDomain extends Domain {

    /**
     * Returns the value of the '<em><b>Loaded</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Loaded</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Loaded</em>' attribute.
     * @see #setLoaded(boolean)
     * @see org.eclipse.egf.model.domain.DomainPackage#getLoadableDomain_Loaded()
     * @model transient="true"
     * @generated
     */
    boolean isLoaded();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.domain.LoadableDomain#isLoaded <em>Loaded</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Loaded</em>' attribute.
     * @see #isLoaded()
     * @generated
     */
    void setLoaded(boolean value);

} // LoadableDomain
