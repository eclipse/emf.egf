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
package org.eclipse.egf.model.jetpattern;

import org.eclipse.egf.model.pattern.PatternPackage;
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
 * @see org.eclipse.egf.model.jetpattern.JetPatternFactory
 * @model kind="package"
 * @generated
 */
public interface JetPatternPackage extends EPackage {

    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "jetpattern"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/egf/1.0.0/jetpattern"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "jetpattern"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    JetPatternPackage eINSTANCE = org.eclipse.egf.model.jetpattern.impl.JetPatternPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.jetpattern.impl.JetNatureImpl <em>Jet Nature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.jetpattern.impl.JetNatureImpl
     * @see org.eclipse.egf.model.jetpattern.impl.JetPatternPackageImpl#getJetNature()
     * @generated
     */
    int JET_NATURE = 0;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JET_NATURE__ID = PatternPackage.PATTERN_NATURE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JET_NATURE__DESCRIPTION = PatternPackage.PATTERN_NATURE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JET_NATURE__NAME = PatternPackage.PATTERN_NATURE__NAME;

    /**
     * The number of structural features of the '<em>Jet Nature</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JET_NATURE_FEATURE_COUNT = PatternPackage.PATTERN_NATURE_FEATURE_COUNT + 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.jetpattern.JetNature <em>Jet Nature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Jet Nature</em>'.
     * @see org.eclipse.egf.model.jetpattern.JetNature
     * @generated
     */
    EClass getJetNature();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    JetPatternFactory getJetPatternFactory();

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
         * The meta object literal for the '{@link org.eclipse.egf.model.jetpattern.impl.JetNatureImpl <em>Jet Nature</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.jetpattern.impl.JetNatureImpl
         * @see org.eclipse.egf.model.jetpattern.impl.JetPatternPackageImpl#getJetNature()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass JET_NATURE = eINSTANCE.getJetNature();

    }

} // JetPatternPackage
