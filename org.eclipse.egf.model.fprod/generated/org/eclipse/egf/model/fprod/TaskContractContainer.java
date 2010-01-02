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
package org.eclipse.egf.model.fprod;

import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ActivityContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Contract Container</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.egf.model.fprod.TaskContractContainer#getActivity <em>Activity</em>}</li>
 * <li>{@link org.eclipse.egf.model.fprod.TaskContractContainer#getActivityContracts <em>Activity
 * Contracts</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.egf.model.fprod.FprodPackage#getTaskContractContainer()
 * @model
 * @generated
 */
public interface TaskContractContainer extends ActivityContractContainer {
  /**
   * Returns the value of the '<em><b>Activity</b></em>' container reference.
   * It is bidirectional and its opposite is '
   * {@link org.eclipse.egf.model.fprod.Task#getActivityContractContainer <em>Activity Contract
   * Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Activity</em>' container reference.
   * @see #setActivity(Task)
   * @see org.eclipse.egf.model.fprod.FprodPackage#getTaskContractContainer_Activity()
   * @see org.eclipse.egf.model.fprod.Task#getActivityContractContainer
   * @model opposite="activityContractContainer" required="true" transient="false"
   * @generated
   */
  Task getActivity();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fprod.TaskContractContainer#getActivity
   * <em>Activity</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Activity</em>' container reference.
   * @see #getActivity()
   * @generated
   */
  void setActivity(Task value);

  /**
   * Returns the value of the '<em><b>Activity Contracts</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fprod.TaskContract}.
   * It is bidirectional and its opposite is '
   * {@link org.eclipse.egf.model.fprod.TaskContract#getActivityContractContainer <em>Activity
   * Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity Contracts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Activity Contracts</em>' containment reference list.
   * @see org.eclipse.egf.model.fprod.FprodPackage#getTaskContractContainer_ActivityContracts()
   * @see org.eclipse.egf.model.fprod.TaskContract#getActivityContractContainer
   * @model opposite="activityContractContainer" containment="true" required="true"
   * @generated
   */
  @SuppressWarnings("unchecked")
  EList<TaskContract> getActivityContracts();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @model
   * @generated
   */
  EList<ActivityContract> getActivityContracts(Type<?> type);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @model
   * @generated
   */
  EList<ActivityContract> getActivityContracts(ContractMode mode);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @model
   * @generated
   */
  EList<ActivityContract> getActivityContracts(Type<?> type, ContractMode mode);

} // TaskContractContainer
