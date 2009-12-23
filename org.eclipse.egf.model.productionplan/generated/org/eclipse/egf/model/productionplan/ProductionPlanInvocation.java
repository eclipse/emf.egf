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

import org.eclipse.egf.model.factorycomponent.Invocation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.productionplan.ProductionPlanInvocation#getProductionPlan <em>Production Plan</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.productionplan.ProductionPlanPackage#getProductionPlanInvocation()
 * @model abstract="true"
 * @generated
 */
public interface ProductionPlanInvocation extends Invocation {

  /**
   * Returns the value of the '<em><b>Production Plan</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.productionplan.ProductionPlan#getProductionPlanInvocations <em>Production Plan Invocations</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Production Plan</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Production Plan</em>' container reference.
   * @see #setProductionPlan(ProductionPlan)
   * @see org.eclipse.egf.model.productionplan.ProductionPlanPackage#getProductionPlanInvocation_ProductionPlan()
   * @see org.eclipse.egf.model.productionplan.ProductionPlan#getProductionPlanInvocations
   * @model opposite="productionPlanInvocations" resolveProxies="false" required="true" transient="false"
   * @generated
   */
  ProductionPlan getProductionPlan();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.productionplan.ProductionPlanInvocation#getProductionPlan <em>Production Plan</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Production Plan</em>' container reference.
   * @see #getProductionPlan()
   * @generated
   */
  void setProductionPlan(ProductionPlan value);
} // ProductionPlanInvocation
