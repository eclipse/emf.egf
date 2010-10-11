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
import org.eclipse.emf.ecore.EReference;

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
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__KIND = FcorePackage.ACTIVITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Super Task</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__SUPER_TASK = FcorePackage.ACTIVITY_FEATURE_COUNT + 1;

    /**
    	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
    	 * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
    	 * @generated
    	 * @ordered
    	 */
    int TASK__IMPLEMENTATION = FcorePackage.ACTIVITY_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Task</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_FEATURE_COUNT = FcorePackage.ACTIVITY_FEATURE_COUNT + 3;

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
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.ftask.Task#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see org.eclipse.egf.model.ftask.Task#getKind()
     * @see #getTask()
     * @generated
     */
    EAttribute getTask_Kind();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.ftask.Task#getImplementation <em>Implementation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Implementation</em>'.
     * @see org.eclipse.egf.model.ftask.Task#getImplementation()
     * @see #getTask()
     * @generated
     */
    EAttribute getTask_Implementation();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.ftask.Task#getSuperTask <em>Super Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Super Task</em>'.
     * @see org.eclipse.egf.model.ftask.Task#getSuperTask()
     * @see #getTask()
     * @generated
     */
    EReference getTask_SuperTask();

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
        	 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
        	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
        	 * @generated
        	 */
        @SuppressWarnings("hiding")
        EAttribute TASK__KIND = eINSTANCE.getTask_Kind();

        /**
        	 * The meta object literal for the '<em><b>Implementation</b></em>' attribute feature.
        	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
        	 * @generated
        	 */
        @SuppressWarnings("hiding")
        EAttribute TASK__IMPLEMENTATION = eINSTANCE.getTask_Implementation();

        /**
        	 * The meta object literal for the '<em><b>Super Task</b></em>' reference feature.
        	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
        	 * @generated
        	 */
        @SuppressWarnings("hiding")
        EReference TASK__SUPER_TASK = eINSTANCE.getTask_SuperTask();

    }

} // FtaskPackage
