/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.domain;

import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.Domain#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.egf.model.domain.Domain#getHelperImplementation <em>Helper Implementation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.domain.DomainPackage#getDomain()
 * @model abstract="true"
 * @generated
 */
public interface Domain extends NamedModelElement {

    /**
     * Returns the value of the '<em><b>Content</b></em>' attribute list.
     * The list contents are of type {@link java.lang.Object}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Content</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Content</em>' attribute list.
     * @see org.eclipse.egf.model.domain.DomainPackage#getDomain_Content()
     * @model transient="true"
     * @generated
     */
    EList<Object> getContent();

    /**
     * Returns the value of the '<em><b>Helper Implementation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Helper Implementation</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Helper Implementation</em>' attribute.
     * @see #setHelperImplementation(String)
     * @see org.eclipse.egf.model.domain.DomainPackage#getDomain_HelperImplementation()
     * @model required="true"
     * @generated
     */
    String getHelperImplementation();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.domain.Domain#getHelperImplementation <em>Helper Implementation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Helper Implementation</em>' attribute.
     * @see #getHelperImplementation()
     * @generated
     */
    void setHelperImplementation(String value);

} // Domain
