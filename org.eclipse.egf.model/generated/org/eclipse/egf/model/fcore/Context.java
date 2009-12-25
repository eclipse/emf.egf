/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.fcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.Context#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Context#getValues <em>Values</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Context#getConnectors <em>Connectors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getContext()
 * @model
 * @generated
 */
public interface Context extends ModelElement {
    /**
     * Returns the value of the '<em><b>Invocation</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.Invocation#getContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Invocation</em>' container reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Invocation</em>' container reference.
     * @see #setInvocation(Invocation)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getContext_Invocation()
     * @see org.eclipse.egf.model.fcore.Invocation#getContext
     * @model opposite="context" resolveProxies="false" transient="false"
     * @generated
     */
    Invocation getInvocation();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.Context#getInvocation <em>Invocation</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Invocation</em>' container reference.
     * @see #getInvocation()
     * @generated
     */
    void setInvocation(Invocation value);

    /**
     * Returns the value of the '<em><b>Values</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.model.fcore.ContextValue}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Values</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Values</em>' containment reference list.
     * @see org.eclipse.egf.model.fcore.FcorePackage#getContext_Values()
     * @model containment="true"
     * @generated
     */
    EList<ContextValue> getValues();

    /**
     * Returns the value of the '<em><b>Connectors</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.model.fcore.ContractConnector}.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.ContractConnector#getContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connectors</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connectors</em>' containment reference list.
     * @see org.eclipse.egf.model.fcore.FcorePackage#getContext_Connectors()
     * @see org.eclipse.egf.model.fcore.ContractConnector#getContext
     * @model opposite="context" containment="true"
     * @generated
     */
    EList<ContractConnector> getConnectors();

} // Context
