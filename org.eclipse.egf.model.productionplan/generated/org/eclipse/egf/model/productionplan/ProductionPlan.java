/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.productionplan;

import org.eclipse.egf.model.factorycomponent.Orchestration;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Production Plan</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.productionplan.ProductionPlan#getProductionPlanInvocations <em>Production Plan Invocations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.productionplan.ProductionPlanPackage#getProductionPlan()
 * @model
 * @generated
 */
public interface ProductionPlan extends Orchestration {
  /**
   * Returns the value of the '<em><b>Production Plan Invocations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.productionplan.ProductionPlanInvocation}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.productionplan.ProductionPlanInvocation#getProductionPlan <em>Production Plan</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Production Plan Invocations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Production Plan Invocations</em>' containment reference list.
   * @see org.eclipse.egf.model.productionplan.ProductionPlanPackage#getProductionPlan_ProductionPlanInvocations()
   * @see org.eclipse.egf.model.productionplan.ProductionPlanInvocation#getProductionPlan
   * @model opposite="productionPlan" containment="true"
   * @generated
   */
  EList<ProductionPlanInvocation> getProductionPlanInvocations();

} // ProductionPlan
