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
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.TaskFactoryHolder;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>FactoryComponent Configuration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.FactoryComponentInvocationImpl#getTaskFactoryId <em>Task Factory Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.FactoryComponentInvocationImpl#getFactoryComponentId <em>Factory Component Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.FactoryComponentInvocationImpl#getTaskFactory <em>Task Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FactoryComponentInvocationImpl extends AbstractFactoryComponentFactoryImpl implements FactoryComponentInvocation {
  /**
   * The default value of the '{@link #getTaskFactoryId() <em>Task Factory Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getTaskFactoryId()
   * @generated
   * @ordered
   */
  protected static final String TASK_FACTORY_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTaskFactoryId() <em>Task Factory Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getTaskFactoryId()
   * @generated
   * @ordered
   */
  protected String taskFactoryId = TASK_FACTORY_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getFactoryComponentId() <em>Factory Component Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFactoryComponentId()
   * @generated
   * @ordered
   */
  protected static final String FACTORY_COMPONENT_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFactoryComponentId() <em>Factory Component Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFactoryComponentId()
   * @generated
   * @ordered
   */
  protected String factoryComponentId = FACTORY_COMPONENT_ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getTaskFactory() <em>Task Factory</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getTaskFactory()
   * @generated
   * @ordered
   */
  protected TaskFactoryHolder taskFactory;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected FactoryComponentInvocationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.FACTORY_COMPONENT_INVOCATION;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getTaskFactoryId() {
    return taskFactoryId;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setTaskFactoryId(String newTaskFactoryId) {
    String oldTaskFactoryId = taskFactoryId;
    taskFactoryId = newTaskFactoryId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY_ID, oldTaskFactoryId, taskFactoryId));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getFactoryComponentId() {
    return factoryComponentId;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setFactoryComponentId(String newFactoryComponentId) {
    String oldFactoryComponentId = factoryComponentId;
    factoryComponentId = newFactoryComponentId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT_ID, oldFactoryComponentId, factoryComponentId));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public TaskFactoryHolder getTaskFactory() {
    // Load the task factory if needed.
    loadTaskFactory();
    if (taskFactory != null && taskFactory.eIsProxy()) {
      InternalEObject oldTaskFactory = (InternalEObject) taskFactory;
      taskFactory = (TaskFactoryHolder) eResolveProxy(oldTaskFactory);
      if (taskFactory != oldTaskFactory) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY, oldTaskFactory, taskFactory));
      }
    }
    return taskFactory;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTaskFactory(TaskFactoryHolder newTaskFactory, NotificationChain msgs) {
    TaskFactoryHolder oldTaskFactory = taskFactory;
    taskFactory = newTaskFactory;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY, oldTaskFactory, newTaskFactory);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public TaskFactoryHolder basicGetTaskFactory() {
    // Load the task factory if needed.
    loadTaskFactory();
    return taskFactory;
  }

  /**
   * Load the task factory from the extension registry.
   * @generated NOT
   */
  private void loadTaskFactory() {
    // If null, try loading the task factory from the extension registry.
    if (null == taskFactory) {
      FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(this);
      // If the task factory id & the fc container are not null, try loading related factory.
      if ((null != taskFactoryId) && (null != fcContainer)) {
        setTaskFactory(getFactoryComponentLoadingHelper().loadTaskFactory(taskFactoryId, fcContainer.getId()));
      }
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setTaskFactory(TaskFactoryHolder newTaskFactory) {
    if (newTaskFactory != taskFactory) {
      NotificationChain msgs = null;
      if (taskFactory != null)
        msgs = ((InternalEObject)taskFactory).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY, null, msgs);
      if (newTaskFactory != null)
        msgs = ((InternalEObject)newTaskFactory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY, null, msgs);
      msgs = basicSetTaskFactory(newTaskFactory, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY, newTaskFactory, newTaskFactory));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY:
        return basicSetTaskFactory(null, msgs);
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
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY_ID:
        return getTaskFactoryId();
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT_ID:
        return getFactoryComponentId();
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY:
        return getTaskFactory();
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
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY_ID:
        setTaskFactoryId((String)newValue);
        return;
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT_ID:
        setFactoryComponentId((String)newValue);
        return;
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY:
        setTaskFactory((TaskFactoryHolder)newValue);
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
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY_ID:
        setTaskFactoryId(TASK_FACTORY_ID_EDEFAULT);
        return;
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT_ID:
        setFactoryComponentId(FACTORY_COMPONENT_ID_EDEFAULT);
        return;
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY:
        setTaskFactory((TaskFactoryHolder)null);
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
      // Due to our own persistence mechanism, eIsSet for ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY feature is based on
      // ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY_ID.
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY:
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY_ID:
        return TASK_FACTORY_ID_EDEFAULT == null ? taskFactoryId != null : !TASK_FACTORY_ID_EDEFAULT.equals(taskFactoryId);
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT_ID:
        return FACTORY_COMPONENT_ID_EDEFAULT == null ? factoryComponentId != null : !FACTORY_COMPONENT_ID_EDEFAULT.equals(factoryComponentId);
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
    result.append(" (taskFactoryId: "); //$NON-NLS-1$
    result.append(taskFactoryId);
    result.append(", factoryComponentId: "); //$NON-NLS-1$
    result.append(factoryComponentId);
    result.append(')');
    return result.toString();
  }

} // FactoryComponentInvocationImpl
