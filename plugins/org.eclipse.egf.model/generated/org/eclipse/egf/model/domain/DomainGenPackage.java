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

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.DomainGenPackage#getGenPackage <em>Gen Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.domain.DomainPackage#getDomainGenPackage()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidGenPackage'"
 * @generated
 */
public interface DomainGenPackage extends Domain {

    /**
     * Returns the value of the '<em><b>Gen Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gen Package</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Gen Package</em>' reference.
     * @see #setGenPackage(GenPackage)
     * @see org.eclipse.egf.model.domain.DomainPackage#getDomainGenPackage_GenPackage()
     * @model required="true"
     * @generated
     */
    GenPackage getGenPackage();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.domain.DomainGenPackage#getGenPackage <em>Gen Package</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Gen Package</em>' reference.
     * @see #getGenPackage()
     * @generated
     */
    void setGenPackage(GenPackage value);

} // DomainGenPackage
