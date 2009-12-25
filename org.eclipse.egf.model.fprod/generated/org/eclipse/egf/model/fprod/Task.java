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

import org.eclipse.egf.model.fcore.Activity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fprod.Task#getActivityContractContainer <em>Activity Contract Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fprod.Task#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fprod.FprodPackage#getTask()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='LoadableValue ValidValue'"
 * @generated
 */
public interface Task extends Activity {
  /**
   * Returns the value of the '<em><b>Activity Contract Container</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fprod.TaskContractContainer#getActivity <em>Activity</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity Contract Container</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity Contract Container</em>' containment reference.
   * @see #setActivityContractContainer(TaskContractContainer)
   * @see org.eclipse.egf.model.fprod.FprodPackage#getTask_ActivityContractContainer()
   * @see org.eclipse.egf.model.fprod.TaskContractContainer#getActivity
   * @model opposite="activity" containment="true"
   * @generated
   */
  TaskContractContainer getActivityContractContainer();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fprod.Task#getActivityContractContainer <em>Activity Contract Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity Contract Container</em>' containment reference.
   * @see #getActivityContractContainer()
   * @generated
   */
  void setActivityContractContainer(TaskContractContainer value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.eclipse.egf.model.fprod.FprodPackage#getTask_Value()
   * @model required="true"
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.fprod.Task#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // Task
