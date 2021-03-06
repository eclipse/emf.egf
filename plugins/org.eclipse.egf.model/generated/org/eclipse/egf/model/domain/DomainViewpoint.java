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
package org.eclipse.egf.model.domain;

import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Viewpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.DomainViewpoint#getDomains <em>Domains</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.domain.DomainPackage#getDomainViewpoint()
 * @model
 * @generated
 */
public interface DomainViewpoint extends Viewpoint {

    /**
     * Returns the value of the '<em><b>Domains</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.model.domain.Domain}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Domains</em>' reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Domains</em>' containment reference list.
     * @see org.eclipse.egf.model.domain.DomainPackage#getDomainViewpoint_Domains()
     * @model containment="true"
     * @generated
     */
    EList<Domain> getDomains();

} // DomainViewpoint
