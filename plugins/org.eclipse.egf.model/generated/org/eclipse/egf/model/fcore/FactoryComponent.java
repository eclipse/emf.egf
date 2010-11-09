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
package org.eclipse.egf.model.fcore;

import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Factory Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.FactoryComponent#getViewpointContainer <em>Viewpoint Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.FactoryComponent#getOrchestration <em>Orchestration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getFactoryComponent()
 * @model
 * @generated
 */
public interface FactoryComponent extends Activity {

    /**
     * Returns the value of the '<em><b>Viewpoint Container</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.ViewpointContainer#getFactoryComponent <em>Factory Component</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Viewpoint Container</em>' containment reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Viewpoint Container</em>' containment reference.
     * @see #setViewpointContainer(ViewpointContainer)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getFactoryComponent_ViewpointContainer()
     * @see org.eclipse.egf.model.fcore.ViewpointContainer#getFactoryComponent
     * @model opposite="factoryComponent" containment="true"
     * @generated
     */
    ViewpointContainer getViewpointContainer();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.FactoryComponent#getViewpointContainer <em>Viewpoint Container</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Viewpoint Container</em>' containment reference.
     * @see #getViewpointContainer()
     * @generated
     */
    void setViewpointContainer(ViewpointContainer value);

    /**
     * Returns the value of the '<em><b>Orchestration</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fcore.Orchestration#getFactoryComponent <em>Factory Component</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Orchestration</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Orchestration</em>' containment reference.
     * @see #setOrchestration(Orchestration)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getFactoryComponent_Orchestration()
     * @see org.eclipse.egf.model.fcore.Orchestration#getFactoryComponent
     * @model opposite="factoryComponent" containment="true"
     * @generated
     */
    Orchestration getOrchestration();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.FactoryComponent#getOrchestration <em>Orchestration</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Orchestration</em>' containment reference.
     * @see #getOrchestration()
     * @generated
     */
    void setOrchestration(Orchestration value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" many="false"
     * @generated
     */
    EList<Resource> getResources();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    EList<InvocationContract> getInvocationContracts();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    EList<InvocationContract> getInvocationContracts(Type type);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    EList<InvocationContract> getInvocationContracts(ContractMode mode);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    EList<InvocationContract> getInvocationContracts(Type type, ContractMode mode);

} // FactoryComponent
