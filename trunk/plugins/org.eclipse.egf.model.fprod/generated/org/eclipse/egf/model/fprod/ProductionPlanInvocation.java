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
package org.eclipse.egf.model.fprod;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Production Plan Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fprod.ProductionPlanInvocation#getProductionPlan <em>Production Plan</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fprod.FprodPackage#getProductionPlanInvocation()
 * @model
 * @generated
 */
public interface ProductionPlanInvocation extends Invocation {

    /**
     * Returns the value of the '<em><b>Production Plan</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fprod.ProductionPlan#getInvocations <em>Invocations</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Production Plan</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Production Plan</em>' container reference.
     * @see #setProductionPlan(ProductionPlan)
     * @see org.eclipse.egf.model.fprod.FprodPackage#getProductionPlanInvocation_ProductionPlan()
     * @see org.eclipse.egf.model.fprod.ProductionPlan#getInvocations
     * @model opposite="invocations" resolveProxies="false" required="true" transient="false"
     * @generated
     */
    ProductionPlan getProductionPlan();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fprod.ProductionPlanInvocation#getProductionPlan <em>Production Plan</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Production Plan</em>' container reference.
     * @see #getProductionPlan()
     * @generated
     */
    void setProductionPlan(ProductionPlan value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" many="false"
     * @generated
     */
    EList<Activity> getActivities();

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
     * @model kind="operation" required="true"
     * @generated
     */
    FactoryComponent getFactoryComponent();
} // ProductionPlanInvocation
