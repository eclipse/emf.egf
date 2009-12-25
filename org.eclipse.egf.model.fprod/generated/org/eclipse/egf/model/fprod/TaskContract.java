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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fprod.TaskContract#getActivityContractContainer <em>Activity Contract Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fprod.FprodPackage#getTaskContract()
 * @model
 * @generated
 */
public interface TaskContract extends ActivityContract {
  /**
   * Returns the value of the '<em><b>Activity Contract Container</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fprod.TaskContractContainer#getActivityContracts <em>Activity Contracts</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity Contract Container</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity Contract Container</em>' container reference.
   * @see #setActivityContractContainer(TaskContractContainer)
   * @see org.eclipse.egf.model.fprod.FprodPackage#getTaskContract_ActivityContractContainer()
   * @see org.eclipse.egf.model.fprod.TaskContractContainer#getActivityContracts
   * @model opposite="activityContracts" required="true" transient="false"
   * @generated
   */
  TaskContractContainer getActivityContractContainer();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fprod.TaskContract#getActivityContractContainer <em>Activity Contract Container</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity Contract Container</em>' container reference.
   * @see #getActivityContractContainer()
   * @generated
   */
  void setActivityContractContainer(TaskContractContainer value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @model kind="operation" required="true"
   * @generated NOT
   */
  Task getActivity();

} // TaskContract
