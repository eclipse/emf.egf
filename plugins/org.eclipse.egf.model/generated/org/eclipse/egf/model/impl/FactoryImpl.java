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

import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.Factory;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Factory</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.FactoryImpl#getProductionPlan <em>Production Plan</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.FactoryImpl#getProductionPlanId <em>Production Plan Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FactoryImpl extends NamedModelElementWithIdImpl implements Factory {
  /**
   * The cached value of the '{@link #getProductionPlan() <em>Production Plan</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getProductionPlan()
   * @generated
   * @ordered
   */
  protected ProductionPlan productionPlan;

  /**
   * The default value of the '{@link #getProductionPlanId() <em>Production Plan Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getProductionPlanId()
   * @generated
   * @ordered
   */
  protected static final String PRODUCTION_PLAN_ID_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getProductionPlanId() <em>Production Plan Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getProductionPlanId()
   * @generated
   * @ordered
   */
  protected String productionPlanId = PRODUCTION_PLAN_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected FactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.FACTORY;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public ProductionPlan getProductionPlan() {
    // If null, try loading the production plan from the extension registry.
    if (null == productionPlan) {
      if (null != productionPlanId) {
        FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(this);
        setProductionPlan(getFactoryComponentLoadingHelper().loadProductionPlan(productionPlanId, fcContainer.getId()));
      }
    }
    return productionPlan;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProductionPlan(ProductionPlan newProductionPlan, NotificationChain msgs) {
    ProductionPlan oldProductionPlan = productionPlan;
    productionPlan = newProductionPlan;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.FACTORY__PRODUCTION_PLAN, oldProductionPlan, newProductionPlan);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setProductionPlan(ProductionPlan newProductionPlan) {
    if (newProductionPlan != productionPlan) {
      NotificationChain msgs = null;
      if (productionPlan != null)
        msgs = ((InternalEObject)productionPlan).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.FACTORY__PRODUCTION_PLAN, null, msgs);
      if (newProductionPlan != null)
        msgs = ((InternalEObject)newProductionPlan).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.FACTORY__PRODUCTION_PLAN, null, msgs);
      msgs = basicSetProductionPlan(newProductionPlan, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FACTORY__PRODUCTION_PLAN, newProductionPlan, newProductionPlan));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getProductionPlanId() {
    return productionPlanId;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setProductionPlanId(String newProductionPlanId) {
    String oldProductionPlanId = productionPlanId;
    productionPlanId = newProductionPlanId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FACTORY__PRODUCTION_PLAN_ID, oldProductionPlanId, productionPlanId));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelPackage.FACTORY__PRODUCTION_PLAN:
        return basicSetProductionPlan(null, msgs);
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
      case ModelPackage.FACTORY__PRODUCTION_PLAN:
        return getProductionPlan();
      case ModelPackage.FACTORY__PRODUCTION_PLAN_ID:
        return getProductionPlanId();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelPackage.FACTORY__PRODUCTION_PLAN:
        setProductionPlan((ProductionPlan)newValue);
        return;
      case ModelPackage.FACTORY__PRODUCTION_PLAN_ID:
        setProductionPlanId((String)newValue);
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
      case ModelPackage.FACTORY__PRODUCTION_PLAN:
        setProductionPlan((ProductionPlan)null);
        return;
      case ModelPackage.FACTORY__PRODUCTION_PLAN_ID:
        setProductionPlanId(PRODUCTION_PLAN_ID_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ModelPackage.FACTORY__PRODUCTION_PLAN:
        return productionPlan != null;
      case ModelPackage.FACTORY__PRODUCTION_PLAN_ID:
        return PRODUCTION_PLAN_ID_EDEFAULT == null ? productionPlanId != null : !PRODUCTION_PLAN_ID_EDEFAULT.equals(productionPlanId);
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
    result.append(" (productionPlanId: "); //$NON-NLS-1$
    result.append(productionPlanId);
    result.append(')');
    return result.toString();
  }

} // FactoryImpl
