/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.model.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Production Plan</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.ProductionPlanImpl#getFactoryComponentInvocations <em>Factory Component Invocations</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ProductionPlanImpl#getFactoryComponentInvocationIds <em>Factory Component Invocation Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProductionPlanImpl extends AbstractFactoryComponentFactoryImpl implements ProductionPlan {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(ProductionPlanImpl.class.getPackage().getName());
  /**
   * The cached value of the '{@link #getFactoryComponentInvocations() <em>Factory Component Invocations</em>}' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getFactoryComponentInvocations()
   * @generated
   * @ordered
   */
  protected EList<FactoryComponentInvocation> factoryComponentInvocations;

  /**
   * The cached value of the '{@link #getFactoryComponentInvocationIds() <em>Factory Component Invocation Ids</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFactoryComponentInvocationIds()
   * @generated
   * @ordered
   */
  protected EList<String> factoryComponentInvocationIds;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ProductionPlanImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.PRODUCTION_PLAN;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public EList<FactoryComponentInvocation> getFactoryComponentInvocations() {
    if (factoryComponentInvocations == null) {
      factoryComponentInvocations =
          new EObjectContainmentEList<FactoryComponentInvocation>(FactoryComponentInvocation.class, this,
              ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS);
      FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(this);
      // Load factory component invocations.
      for (String factoryComponentInvocationId : getFactoryComponentInvocationIds()) {
        FactoryComponentInvocation factoryComponentInvocation =
            getFactoryComponentLoadingHelper().loadFactoryComponentInvocation(factoryComponentInvocationId, fcContainer.getId());
        if (null != factoryComponentInvocation) {
          factoryComponentInvocations.add(factoryComponentInvocation);
        } else {
          StringBuilder loggerMessage = new StringBuilder("ProductionPlanImpl.getFactoryComponentInvocations(..) _ "); //$NON-NLS-1$
          loggerMessage.append("No FactoryComponentInvocation found for id " + factoryComponentInvocationId); //$NON-NLS-1$
          __logger.error(loggerMessage.toString());
        }
      }
    }
    return factoryComponentInvocations;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getFactoryComponentInvocationIds() {
    if (factoryComponentInvocationIds == null) {
      factoryComponentInvocationIds = new EDataTypeUniqueEList<String>(String.class, this, ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATION_IDS);
    }
    return factoryComponentInvocationIds;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS:
        return ((InternalEList<?>)getFactoryComponentInvocations()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS:
        return getFactoryComponentInvocations();
      case ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATION_IDS:
        return getFactoryComponentInvocationIds();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS:
        getFactoryComponentInvocations().clear();
        getFactoryComponentInvocations().addAll((Collection<? extends FactoryComponentInvocation>)newValue);
        return;
      case ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATION_IDS:
        getFactoryComponentInvocationIds().clear();
        getFactoryComponentInvocationIds().addAll((Collection<? extends String>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS:
        getFactoryComponentInvocations().clear();
        return;
      case ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATION_IDS:
        getFactoryComponentInvocationIds().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      // Due to our own persistence mechanism, eIsSet for ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS feature is based on
      // ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATION_IDS.
      case ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS:
      case ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATION_IDS:
        return factoryComponentInvocationIds != null && !factoryComponentInvocationIds.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (factoryComponentInvocationIds: "); //$NON-NLS-1$
    result.append(factoryComponentInvocationIds);
    result.append(')');
    return result.toString();
  }

} // ProductionPlanImpl
