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
package org.eclipse.egf.model.productionplan.impl;

import org.eclipse.egf.model.productionplan.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProductionplanFactoryImpl extends EFactoryImpl implements ProductionplanFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ProductionplanFactory init() {
    try {
      ProductionplanFactory theProductionplanFactory = (ProductionplanFactory) EPackage.Registry.INSTANCE
          .getEFactory("http://www.eclipse.org/egf/1.0.0/productionplan"); //$NON-NLS-1$ 
      if (theProductionplanFactory != null) {
        return theProductionplanFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ProductionplanFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProductionplanFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case ProductionplanPackage.PRODUCTION_PLAN:
      return createProductionPlan();
    case ProductionplanPackage.FACTORY_COMPONENT_INVOCATION:
      return createFactoryComponentInvocation();
    case ProductionplanPackage.TASK_INVOCATION:
      return createTaskInvocation();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProductionPlan createProductionPlan() {
    ProductionPlanImpl productionPlan = new ProductionPlanImpl();
    return productionPlan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponentInvocation createFactoryComponentInvocation() {
    FactoryComponentInvocationImpl factoryComponentInvocation = new FactoryComponentInvocationImpl();
    return factoryComponentInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaskInvocation createTaskInvocation() {
    TaskInvocationImpl taskInvocation = new TaskInvocationImpl();
    return taskInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProductionplanPackage getProductionplanPackage() {
    return (ProductionplanPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ProductionplanPackage getPackage() {
    return ProductionplanPackage.eINSTANCE;
  }

} //ProductionplanFactoryImpl
