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
package org.eclipse.egf.model.jetpattern.impl;

import org.eclipse.egf.model.factorycomponent.FactoryComponentPackage;

import org.eclipse.egf.model.jetpattern.JetNature;
import org.eclipse.egf.model.jetpattern.JetPatternFactory;
import org.eclipse.egf.model.jetpattern.JetPatternPackage;
import org.eclipse.egf.model.jetpattern.JetRunner;

import org.eclipse.egf.model.pattern.PatternPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JetPatternPackageImpl extends EPackageImpl implements JetPatternPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass jetNatureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass jetRunnerEClass = null;

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
     * @see org.eclipse.egf.model.jetpattern.JetPatternPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private JetPatternPackageImpl() {
        super(eNS_URI, JetPatternFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link JetPatternPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static JetPatternPackage init() {
        if (isInited)
            return (JetPatternPackage) EPackage.Registry.INSTANCE.getEPackage(JetPatternPackage.eNS_URI);

        // Obtain or create and register package
        JetPatternPackageImpl theJetPatternPackage = (JetPatternPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JetPatternPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JetPatternPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        PatternPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theJetPatternPackage.createPackageContents();

        // Initialize created meta-data
        theJetPatternPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theJetPatternPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(JetPatternPackage.eNS_URI, theJetPatternPackage);
        return theJetPatternPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJetNature() {
        return jetNatureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJetRunner() {
        return jetRunnerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JetPatternFactory getJetPatternFactory() {
        return (JetPatternFactory) getEFactoryInstance();
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
        jetNatureEClass = createEClass(JET_NATURE);

        jetRunnerEClass = createEClass(JET_RUNNER);
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
        jetNatureEClass.getESuperTypes().add(thePatternPackage.getPatternNature());
        jetRunnerEClass.getESuperTypes().add(thePatternPackage.getPatternRunner());

        // Initialize classes and features; add operations and parameters
        initEClass(jetNatureEClass, JetNature.class, "JetNature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(jetRunnerEClass, JetRunner.class, "JetRunner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        // Create resource
        createResource(eNS_URI);
    }

} //JetPatternPackageImpl
