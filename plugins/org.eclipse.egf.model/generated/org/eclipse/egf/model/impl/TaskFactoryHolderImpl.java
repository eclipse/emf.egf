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

import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.TaskFactoryHolder;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Task Factory Holder</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.TaskFactoryHolderImpl#getFactoryClass <em>Factory Class</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.TaskFactoryHolderImpl#getFactory <em>Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskFactoryHolderImpl extends NamedModelElementWithIdImpl implements TaskFactoryHolder {
  /**
   * The default value of the '{@link #getFactoryClass() <em>Factory Class</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getFactoryClass()
   * @generated
   * @ordered
   */
  protected static final String FACTORY_CLASS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFactoryClass() <em>Factory Class</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getFactoryClass()
   * @generated
   * @ordered
   */
  protected String factoryClass = FACTORY_CLASS_EDEFAULT;

  /**
   * The default value of the '{@link #getFactory() <em>Factory</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getFactory()
   * @generated
   * @ordered
   */
  protected static final Object FACTORY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFactory() <em>Factory</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getFactory()
   * @generated
   * @ordered
   */
  protected Object factory = FACTORY_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected TaskFactoryHolderImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.TASK_FACTORY_HOLDER;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getFactoryClass() {
    return factoryClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setFactoryClass(String newFactoryClass) {
    String oldFactoryClass = factoryClass;
    factoryClass = newFactoryClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TASK_FACTORY_HOLDER__FACTORY_CLASS, oldFactoryClass, factoryClass));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Object getFactory() {
    return factory;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setFactory(Object newFactory) {
    Object oldFactory = factory;
    factory = newFactory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TASK_FACTORY_HOLDER__FACTORY, oldFactory, factory));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackage.TASK_FACTORY_HOLDER__FACTORY_CLASS:
        return getFactoryClass();
      case ModelPackage.TASK_FACTORY_HOLDER__FACTORY:
        return getFactory();
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
      case ModelPackage.TASK_FACTORY_HOLDER__FACTORY_CLASS:
        setFactoryClass((String)newValue);
        return;
      case ModelPackage.TASK_FACTORY_HOLDER__FACTORY:
        setFactory(newValue);
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
      case ModelPackage.TASK_FACTORY_HOLDER__FACTORY_CLASS:
        setFactoryClass(FACTORY_CLASS_EDEFAULT);
        return;
      case ModelPackage.TASK_FACTORY_HOLDER__FACTORY:
        setFactory(FACTORY_EDEFAULT);
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
      case ModelPackage.TASK_FACTORY_HOLDER__FACTORY_CLASS:
        return FACTORY_CLASS_EDEFAULT == null ? factoryClass != null : !FACTORY_CLASS_EDEFAULT.equals(factoryClass);
      case ModelPackage.TASK_FACTORY_HOLDER__FACTORY:
        return FACTORY_EDEFAULT == null ? factory != null : !FACTORY_EDEFAULT.equals(factory);
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
    result.append(" (factoryClass: "); //$NON-NLS-1$
    result.append(factoryClass);
    result.append(", factory: "); //$NON-NLS-1$
    result.append(factory);
    result.append(')');
    return result.toString();
  }

} // TaskFactoryHolderImpl
