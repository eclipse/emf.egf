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

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.ftask.FtaskFactory
 * @model kind="package"
 * @generated
 */
public interface FtaskPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "ftask"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/egf/1.0.0/ftask"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "ftask"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FtaskPackage eINSTANCE = org.eclipse.egf.model.ftask.impl.FtaskPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.ftask.impl.TaskImpl <em>Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.ftask.impl.TaskImpl
   * @see org.eclipse.egf.model.ftask.impl.FtaskPackageImpl#getTask()
   * @generated
   */
  int TASK = 0;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__ID = FcorePackage.ACTIVITY__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__DESCRIPTION = FcorePackage.ACTIVITY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__NAME = FcorePackage.ACTIVITY__NAME;

  /**
   * The feature id for the '<em><b>Contract Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__CONTRACT_CONTAINER = FcorePackage.ACTIVITY__CONTRACT_CONTAINER;

  /**
   * The number of structural features of the '<em>Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_FEATURE_COUNT = FcorePackage.ACTIVITY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.ftask.impl.TaskJavaImpl <em>Task Java</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.ftask.impl.TaskJavaImpl
   * @see org.eclipse.egf.model.ftask.impl.FtaskPackageImpl#getTaskJava()
   * @generated
   */
  int TASK_JAVA = 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_JAVA__ID = TASK__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_JAVA__DESCRIPTION = TASK__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_JAVA__NAME = TASK__NAME;

  /**
   * The feature id for the '<em><b>Contract Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_JAVA__CONTRACT_CONTAINER = TASK__CONTRACT_CONTAINER;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_JAVA__VALUE = TASK_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Task Java</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_JAVA_FEATURE_COUNT = TASK_FEATURE_COUNT + 1;

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.ftask.Task <em>Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Task</em>'.
   * @see org.eclipse.egf.model.ftask.Task
   * @generated
   */
  EClass getTask();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.ftask.TaskJava <em>Task Java</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Task Java</em>'.
   * @see org.eclipse.egf.model.ftask.TaskJava
   * @generated
   */
  EClass getTaskJava();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.ftask.TaskJava#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.ftask.TaskJava#getValue()
   * @see #getTaskJava()
   * @generated
   */
  EAttribute getTaskJava_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FtaskFactory getFtaskFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.ftask.impl.TaskImpl <em>Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.ftask.impl.TaskImpl
     * @see org.eclipse.egf.model.ftask.impl.FtaskPackageImpl#getTask()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass TASK = eINSTANCE.getTask();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.ftask.impl.TaskJavaImpl <em>Task Java</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.ftask.impl.TaskJavaImpl
     * @see org.eclipse.egf.model.ftask.impl.FtaskPackageImpl#getTaskJava()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass TASK_JAVA = eINSTANCE.getTaskJava();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EAttribute TASK_JAVA__VALUE = eINSTANCE.getTaskJava_Value();

  }

} // FtaskPackage
