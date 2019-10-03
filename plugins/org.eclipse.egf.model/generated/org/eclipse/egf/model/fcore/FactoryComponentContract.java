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
package org.eclipse.egf.model.fcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Factory Component Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.FactoryComponentContract#getInvocationContracts <em>Invocation Contracts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getFactoryComponentContract()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UselessFactoryComponentContract OutModeIsRestricted'"
 * @generated
 */
public interface FactoryComponentContract extends Contract {

    /**
     * Returns the value of the '<em><b>Invocation Contracts</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.egf.model.fcore.InvocationContract}.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.InvocationContract#getFactoryComponentContract <em>Factory Component Contract</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Invocation Contracts</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Invocation Contracts</em>' reference list.
     * @see org.eclipse.egf.model.fcore.FcorePackage#getFactoryComponentContract_InvocationContracts()
     * @see org.eclipse.egf.model.fcore.InvocationContract#getFactoryComponentContract
     * @model opposite="factoryComponentContract" resolveProxies="false"
     * @generated
     */
    EList<InvocationContract> getInvocationContracts();

} // FactoryComponentContract
