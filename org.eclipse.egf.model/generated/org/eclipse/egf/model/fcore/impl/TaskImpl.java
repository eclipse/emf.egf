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
package org.eclipse.egf.model.fcore.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.core.production.EGFCoreProductionPlugin;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.EGFModelsPlugin;
import org.eclipse.egf.model.InvocationException;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Task;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.egf.model.fcore.impl.TaskImpl#getTaskId <em>Task
 * Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TaskImpl extends ActivityImpl implements Task {
  /**
   * The default value of the '{@link #getTaskId() <em>Task Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getTaskId()
   * @generated
   * @ordered
   */
  protected static final String TASK_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTaskId() <em>Task Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getTaskId()
   * @generated
   * @ordered
   */
  protected String taskId = TASK_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected TaskImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getTaskId() {
    return taskId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setTaskId(String newTaskId) {
    String oldTaskId = taskId;
    taskId = newTaskId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.TASK__TASK_ID, oldTaskId, taskId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public void invoke(IProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    Assert.isNotNull(productionContext);
    try {
      EGFCoreProductionPlugin.getProductionTaskInvocationFactory().createProductionTaskInvocation(EGFModelsPlugin.getModelProductionContextFactory().createModelProductionContext(productionContext, this), getTaskId()).invoke(monitor);
      if (monitor.isCanceled()) {
        throw new OperationCanceledException();
      }
    } catch (CoreException ce) {
      throw new InvocationException(ce);
    } catch (InvocationTargetException ite) {
      throw new InvocationException(ite);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public int getSteps() {
    return 1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FcorePackage.TASK__TASK_ID:
      return getTaskId();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FcorePackage.TASK__TASK_ID:
      setTaskId((String) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case FcorePackage.TASK__TASK_ID:
      setTaskId(TASK_ID_EDEFAULT);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FcorePackage.TASK__TASK_ID:
      return TASK_ID_EDEFAULT == null ? taskId != null : !TASK_ID_EDEFAULT.equals(taskId);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (taskId: "); //$NON-NLS-1$
    result.append(taskId);
    result.append(')');
    return result.toString();
  }

} // TaskImpl
