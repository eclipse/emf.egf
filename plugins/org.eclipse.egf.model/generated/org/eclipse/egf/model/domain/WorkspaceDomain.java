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
 * A representation of the model object '<em><b>Workspace Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.WorkspaceDomain#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.domain.DomainPackage#getWorkspaceDomain()
 * @model
 * @generated
 */
public interface WorkspaceDomain extends LoadableDomain {

    /**
     * Returns the value of the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Path</em>' attribute.
     * @see #setPath(String)
     * @see org.eclipse.egf.model.domain.DomainPackage#getWorkspaceDomain_Path()
     * @model required="true"
     * @generated
     */
    String getPath();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.domain.WorkspaceDomain#getPath <em>Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Path</em>' attribute.
     * @see #getPath()
     * @generated
     */
    void setPath(String value);

} // WorkspaceDomain
