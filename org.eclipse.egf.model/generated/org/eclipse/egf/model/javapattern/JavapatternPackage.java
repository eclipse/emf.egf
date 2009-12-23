/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.javapattern;

import org.eclipse.egf.model.pattern.PatternPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.javapattern.JavapatternFactory
 * @model kind="package"
 * @generated
 */
public interface JavapatternPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "javapattern"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/egf/1.0.0/javapattern"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "javapattern"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavapatternPackage eINSTANCE = org.eclipse.egf.model.javapattern.impl.JavapatternPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.egf.model.javapattern.impl.JavaNatureImpl <em>Java Nature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.egf.model.javapattern.impl.JavaNatureImpl
	 * @see org.eclipse.egf.model.javapattern.impl.JavapatternPackageImpl#getJavaNature()
	 * @generated
	 */
	int JAVA_NATURE = 0;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE__ID = PatternPackage.PATTERN_NATURE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE__NAME = PatternPackage.PATTERN_NATURE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE__DESCRIPTION = PatternPackage.PATTERN_NATURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE__CLASS_NAME = PatternPackage.PATTERN_NATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Nature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE_FEATURE_COUNT = PatternPackage.PATTERN_NATURE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.egf.model.javapattern.impl.JavaRunnerImpl <em>Java Runner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.egf.model.javapattern.impl.JavaRunnerImpl
	 * @see org.eclipse.egf.model.javapattern.impl.JavapatternPackageImpl#getJavaRunner()
	 * @generated
	 */
	int JAVA_RUNNER = 1;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_RUNNER__ID = PatternPackage.PATTERN_RUNNER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_RUNNER__NAME = PatternPackage.PATTERN_RUNNER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_RUNNER__DESCRIPTION = PatternPackage.PATTERN_RUNNER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_RUNNER__PATTERN = PatternPackage.PATTERN_RUNNER__PATTERN;

	/**
	 * The number of structural features of the '<em>Java Runner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_RUNNER_FEATURE_COUNT = PatternPackage.PATTERN_RUNNER_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.egf.model.javapattern.JavaNature <em>Java Nature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Nature</em>'.
	 * @see org.eclipse.egf.model.javapattern.JavaNature
	 * @generated
	 */
	EClass getJavaNature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.egf.model.javapattern.JavaNature#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.eclipse.egf.model.javapattern.JavaNature#getClassName()
	 * @see #getJavaNature()
	 * @generated
	 */
	EAttribute getJavaNature_ClassName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.egf.model.javapattern.JavaRunner <em>Java Runner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Runner</em>'.
	 * @see org.eclipse.egf.model.javapattern.JavaRunner
	 * @generated
	 */
	EClass getJavaRunner();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JavapatternFactory getJavapatternFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.egf.model.javapattern.impl.JavaNatureImpl <em>Java Nature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.egf.model.javapattern.impl.JavaNatureImpl
		 * @see org.eclipse.egf.model.javapattern.impl.JavapatternPackageImpl#getJavaNature()
		 * @generated
		 */
		EClass JAVA_NATURE = eINSTANCE.getJavaNature();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_NATURE__CLASS_NAME = eINSTANCE.getJavaNature_ClassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.egf.model.javapattern.impl.JavaRunnerImpl <em>Java Runner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.egf.model.javapattern.impl.JavaRunnerImpl
		 * @see org.eclipse.egf.model.javapattern.impl.JavapatternPackageImpl#getJavaRunner()
		 * @generated
		 */
		EClass JAVA_RUNNER = eINSTANCE.getJavaRunner();

	}

} //JavapatternPackage
