/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.ftask;

import org.eclipse.egf.model.fcore.Activity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.ftask.Task#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ftask.Task#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ftask.Task#getSuperTask <em>Super Task</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ftask.FtaskPackage#getTask()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='LoadableImplementation ValidImplementation'"
 * @generated
 */
public interface Task extends Activity {

  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see #setKind(String)
   * @see org.eclipse.egf.model.ftask.FtaskPackage#getTask_Kind()
   * @model
   * @generated
   */
  String getKind();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ftask.Task#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see #getKind()
   * @generated
   */
  void setKind(String value);

  /**
   * Returns the value of the '<em><b>Implementation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Implementation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Implementation</em>' attribute.
   * @see #setImplementation(String)
   * @see org.eclipse.egf.model.ftask.FtaskPackage#getTask_Implementation()
   * @model
   * @generated
   */
  String getImplementation();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ftask.Task#getImplementation <em>Implementation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Implementation</em>' attribute.
   * @see #getImplementation()
   * @generated
   */
  void setImplementation(String value);

  /**
   * Returns the value of the '<em><b>Super Task</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Task</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Task</em>' reference.
   * @see #setSuperTask(Task)
   * @see org.eclipse.egf.model.ftask.FtaskPackage#getTask_SuperTask()
   * @model
   * @generated
   */
  Task getSuperTask();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ftask.Task#getSuperTask <em>Super Task</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Task</em>' reference.
   * @see #getSuperTask()
   * @generated
   */
  void setSuperTask(Task value);

} // Task
