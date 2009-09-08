/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.pattern_1240232225442_295.impl;

import org.eclipse.egf.pattern.PatternPackage;

import org.eclipse.egf.pattern.pattern_1240232225442_295.Pattern_1240232225442_295;
import org.eclipse.egf.pattern.pattern_1240232225442_295.Pattern_1240232225442_295Factory;
import org.eclipse.egf.pattern.pattern_1240232225442_295.Pattern_1240232225442_295Package;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class Pattern_1240232225442_295PackageImpl extends EPackageImpl
		implements Pattern_1240232225442_295Package {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass pattern_1240232225442_295EClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.egf.pattern.pattern_1240232225442_295.Pattern_1240232225442_295Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Pattern_1240232225442_295PackageImpl() {
		super(eNS_URI, Pattern_1240232225442_295Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize
	 * {@link Pattern_1240232225442_295Package#eINSTANCE} when that field is
	 * accessed. Clients should not invoke it directly. Instead, they should
	 * simply access that field to obtain the package. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Pattern_1240232225442_295Package init() {
		if (isInited)
			return (Pattern_1240232225442_295Package) EPackage.Registry.INSTANCE
					.getEPackage(Pattern_1240232225442_295Package.eNS_URI);

		// Obtain or create and register package
		Pattern_1240232225442_295PackageImpl thePattern_1240232225442_295Package = (Pattern_1240232225442_295PackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof Pattern_1240232225442_295PackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI)
				: new Pattern_1240232225442_295PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PatternPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePattern_1240232225442_295Package.createPackageContents();

		// Initialize created meta-data
		thePattern_1240232225442_295Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePattern_1240232225442_295Package.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(
				Pattern_1240232225442_295Package.eNS_URI,
				thePattern_1240232225442_295Package);
		return thePattern_1240232225442_295Package;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPattern_1240232225442_295() {
		return pattern_1240232225442_295EClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Pattern_1240232225442_295Factory getPattern_1240232225442_295Factory() {
		return (Pattern_1240232225442_295Factory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to
	 * have no affect on any invocation but its first. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		pattern_1240232225442_295EClass = createEClass(PATTERN_1240232225442_295);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		PatternPackage thePatternPackage = (PatternPackage) EPackage.Registry.INSTANCE
				.getEPackage(PatternPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		pattern_1240232225442_295EClass.getESuperTypes().add(
				thePatternPackage.getPattern());

		// Initialize classes and features; add operations and parameters
		initEClass(
				pattern_1240232225442_295EClass,
				Pattern_1240232225442_295.class,
				"Pattern_1240232225442_295", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		EOperation op = addEOperation(pattern_1240232225442_295EClass,
				ecorePackage.getEString(),
				"generateBody", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEJavaObject(),
				"classLoader_p", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(pattern_1240232225442_295EClass, ecorePackage
				.getEString(),
				"generatePreMatching", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(pattern_1240232225442_295EClass, ecorePackage
				.getEString(),
				"generatePostMatching", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(pattern_1240232225442_295EClass, ecorePackage
				.getEString(), "generateHeader", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(pattern_1240232225442_295EClass, ecorePackage
				.getEString(), "generateFooter", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/egf/1.0.0/Pattern/production
		createProductionAnnotations();
		// http://www.eclipse.org/egf/1.0.0/Pattern
		createPatternAnnotations();
		// http://www.eclipse.org/egf/1.0.0/uid
		createUidAnnotations();
	}

	/**
	 * Initializes the annotations for
	 * <b>http://www.eclipse.org/egf/1.0.0/Pattern/production</b>. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createProductionAnnotations() {
		String source = "http://www.eclipse.org/egf/1.0.0/Pattern/production"; //$NON-NLS-1$		
		addAnnotation(
				pattern_1240232225442_295EClass,
				source,
				new String[] {
						"Path", "model.tests/TestCase/isSetGenFeature.override.javajetinc", //$NON-NLS-1$ //$NON-NLS-2$
						"Compilation", "false", //$NON-NLS-1$ //$NON-NLS-2$
						"BufferModification", "false" //$NON-NLS-1$ //$NON-NLS-2$
				});
	}

	/**
	 * Initializes the annotations for
	 * <b>http://www.eclipse.org/egf/1.0.0/Pattern</b>. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createPatternAnnotations() {
		String source = "http://www.eclipse.org/egf/1.0.0/Pattern"; //$NON-NLS-1$			
		addAnnotation(
				pattern_1240232225442_295EClass.getEOperations().get(1),
				source,
				new String[] {
						"body", "READ(emf.patterns/templates/generated/Pattern.1240232225442.295/generatePreMatching.pt);" //$NON-NLS-1$ //$NON-NLS-2$
				});
		addAnnotation(
				pattern_1240232225442_295EClass.getEOperations().get(2),
				source,
				new String[] {
						"body", "READ(emf.patterns/templates/generated/Pattern.1240232225442.295/generatePostMatching.pt);" //$NON-NLS-1$ //$NON-NLS-2$
				});
		addAnnotation(
				pattern_1240232225442_295EClass.getEOperations().get(3),
				source,
				new String[] {
						"body", "READ(emf.patterns/templates/Pattern.1240232225442.295/PatternMethod.1240232231066.296.pt);" //$NON-NLS-1$ //$NON-NLS-2$
				});
		addAnnotation(
				pattern_1240232225442_295EClass.getEOperations().get(4),
				source,
				new String[] {
						"body", "READ(emf.patterns/templates/Pattern.1240232225442.295/PatternMethod.1240232231066.297.pt);" //$NON-NLS-1$ //$NON-NLS-2$
				});
	}

	/**
	 * Initializes the annotations for
	 * <b>http://www.eclipse.org/egf/1.0.0/uid</b>. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createUidAnnotations() {
		String source = "http://www.eclipse.org/egf/1.0.0/uid"; //$NON-NLS-1$							
		addAnnotation(pattern_1240232225442_295EClass.getEOperations().get(3),
				source, new String[] {
						"body", "PatternMethod.1240232231066.296" //$NON-NLS-1$ //$NON-NLS-2$
				});
		addAnnotation(pattern_1240232225442_295EClass.getEOperations().get(4),
				source, new String[] {
						"body", "PatternMethod.1240232231066.297" //$NON-NLS-1$ //$NON-NLS-2$
				});
	}

} // Pattern_1240232225442_295PackageImpl
