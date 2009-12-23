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
package org.eclipse.egf.model.javapattern.impl;

import org.eclipse.egf.model.javapattern.JavaNature;
import org.eclipse.egf.model.javapattern.JavaPatternFactory;
import org.eclipse.egf.model.javapattern.JavaPatternPackage;
import org.eclipse.egf.model.javapattern.JavaRunner;

import org.eclipse.egf.model.pattern.PatternPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaPatternPackageImpl extends EPackageImpl implements JavaPatternPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass javaNatureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass javaRunnerEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.egf.model.javapattern.JavaPatternPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private JavaPatternPackageImpl() {
        super(eNS_URI, JavaPatternFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link JavaPatternPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static JavaPatternPackage init() {
        if (isInited)
            return (JavaPatternPackage) EPackage.Registry.INSTANCE.getEPackage(JavaPatternPackage.eNS_URI);

        // Obtain or create and register package
        JavaPatternPackageImpl theJavaPatternPackage = (JavaPatternPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JavaPatternPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JavaPatternPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        PatternPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theJavaPatternPackage.createPackageContents();

        // Initialize created meta-data
        theJavaPatternPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theJavaPatternPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(JavaPatternPackage.eNS_URI, theJavaPatternPackage);
        return theJavaPatternPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJavaNature() {
        return javaNatureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getJavaNature_ClassName() {
        return (EAttribute) javaNatureEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJavaRunner() {
        return javaRunnerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JavaPatternFactory getJavaPatternFactory() {
        return (JavaPatternFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        javaNatureEClass = createEClass(JAVA_NATURE);
        createEAttribute(javaNatureEClass, JAVA_NATURE__CLASS_NAME);

        javaRunnerEClass = createEClass(JAVA_RUNNER);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        PatternPackage thePatternPackage = (PatternPackage) EPackage.Registry.INSTANCE.getEPackage(PatternPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        javaNatureEClass.getESuperTypes().add(thePatternPackage.getPatternNature());
        javaRunnerEClass.getESuperTypes().add(thePatternPackage.getPatternRunner());

        // Initialize classes and features; add operations and parameters
        initEClass(javaNatureEClass, JavaNature.class, "JavaNature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getJavaNature_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, JavaNature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(javaRunnerEClass, JavaRunner.class, "JavaRunner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        // Create resource
        createResource(eNS_URI);
    }

} //JavaPatternPackageImpl
