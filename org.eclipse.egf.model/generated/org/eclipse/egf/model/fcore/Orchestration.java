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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Orchestration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.Orchestration#getFactoryComponent <em>Factory Component</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.Orchestration#getSteps <em>Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestration()
 * @model abstract="true"
 * @generated
 */
public interface Orchestration extends ModelElement {
    /**
     * Returns the value of the '<em><b>Factory Component</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.FactoryComponent#getOrchestration <em>Orchestration</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Factory Component</em>' container reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Factory Component</em>' container reference.
     * @see #setFactoryComponent(FactoryComponent)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestration_FactoryComponent()
     * @see org.eclipse.egf.model.fcore.FactoryComponent#getOrchestration
     * @model opposite="orchestration" resolveProxies="false" required="true" transient="false"
     * @generated
     */
    FactoryComponent getFactoryComponent();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.Orchestration#getFactoryComponent <em>Factory Component</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Factory Component</em>' container reference.
     * @see #getFactoryComponent()
     * @generated
     */
    void setFactoryComponent(FactoryComponent value);

    /**
     * Returns the value of the '<em><b>Steps</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Steps</em>' attribute.
     * @see org.eclipse.egf.model.fcore.FcorePackage#getOrchestration_Steps()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    int getSteps();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model exceptions="org.eclipse.egf.model.fcore.InvocationException" productionContextDataType="org.eclipse.egf.model.fcore.IProductionContext" monitorDataType="org.eclipse.egf.model.fcore.IProgressMonitor"
     * @generated
     */
    void invoke(IProductionContext productionContext, IProgressMonitor monitor) throws InvocationException;

} // Orchestration
