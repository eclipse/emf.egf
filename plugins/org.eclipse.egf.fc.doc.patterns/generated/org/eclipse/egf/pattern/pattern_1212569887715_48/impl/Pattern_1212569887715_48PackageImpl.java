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
package org.eclipse.egf.pattern.pattern_1212569887715_48.impl;

import org.eclipse.egf.model.ModelPackage;

import org.eclipse.egf.pattern.PatternPackage;

import org.eclipse.egf.pattern.pattern_1212569887715_48.HtmlFcDoc;
import org.eclipse.egf.pattern.pattern_1212569887715_48.Pattern_1212569887715_48Factory;
import org.eclipse.egf.pattern.pattern_1212569887715_48.Pattern_1212569887715_48Package;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Pattern_1212569887715_48PackageImpl extends EPackageImpl implements Pattern_1212569887715_48Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass htmlFcDocEClass = null;

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
	 * @see org.eclipse.egf.pattern.pattern_1212569887715_48.Pattern_1212569887715_48Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Pattern_1212569887715_48PackageImpl() {
		super(eNS_URI, Pattern_1212569887715_48Factory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Pattern_1212569887715_48Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Pattern_1212569887715_48Package init() {
		if (isInited) return (Pattern_1212569887715_48Package)EPackage.Registry.INSTANCE.getEPackage(Pattern_1212569887715_48Package.eNS_URI);

		// Obtain or create and register package
		Pattern_1212569887715_48PackageImpl thePattern_1212569887715_48Package = (Pattern_1212569887715_48PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Pattern_1212569887715_48PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Pattern_1212569887715_48PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PatternPackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePattern_1212569887715_48Package.createPackageContents();

		// Initialize created meta-data
		thePattern_1212569887715_48Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePattern_1212569887715_48Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Pattern_1212569887715_48Package.eNS_URI, thePattern_1212569887715_48Package);
		return thePattern_1212569887715_48Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHtmlFcDoc() {
		return htmlFcDocEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern_1212569887715_48Factory getPattern_1212569887715_48Factory() {
		return (Pattern_1212569887715_48Factory)getEFactoryInstance();
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
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		htmlFcDocEClass = createEClass(HTML_FC_DOC);
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
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PatternPackage thePatternPackage = (PatternPackage)EPackage.Registry.INSTANCE.getEPackage(PatternPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		htmlFcDocEClass.getESuperTypes().add(thePatternPackage.getPattern());

		// Initialize classes and features; add operations and parameters
		initEClass(htmlFcDocEClass, HtmlFcDoc.class, "HtmlFcDoc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		EOperation op = addEOperation(htmlFcDocEClass, ecorePackage.getEString(), "generateBody", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEJavaObject(), "classLoader_p", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(htmlFcDocEClass, ecorePackage.getEString(), "generatePreMatching", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(htmlFcDocEClass, ecorePackage.getEString(), "generatePostMatching", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(htmlFcDocEClass, ecorePackage.getEString(), "generateHeader", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(htmlFcDocEClass, ecorePackage.getEString(), "generateFooter", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(htmlFcDocEClass, ecorePackage.getEString(), "generateHtmlHeaderPage", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(htmlFcDocEClass, ecorePackage.getEString(), "generateHtmlEndingPage", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(htmlFcDocEClass, ecorePackage.getEString(), "generateFcDescription", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(htmlFcDocEClass, ecorePackage.getEString(), "generateContractDescription", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(htmlFcDocEClass, ecorePackage.getEString(), "generatePatternDescription", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(htmlFcDocEClass, ecorePackage.getEString(), "generateMappingDescription", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(htmlFcDocEClass, ecorePackage.getEString(), "generateFactoryDescription", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(htmlFcDocEClass, ecorePackage.getEString(), "init", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/egf/1.0.0/Pattern
		createPatternAnnotations();
		// http://www.eclipse.org/egf/1.0.0/uid
		createUidAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/egf/1.0.0/Pattern</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPatternAnnotations() {
		String source = "http://www.eclipse.org/egf/1.0.0/Pattern"; //$NON-NLS-1$		
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "CALL(init);CALL(generateHtmlHeaderPage);CALL(generateFcDescription);CALL(generateContractDescription);CALL(generatePatternDescription);CALL(generateMappingDescription);CALL(generateFactoryDescription);CALL(generateHtmlEndingPage);" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "READ(asset.1212677795454.8/templates/generated/Pattern.1212569887715.48/generatePreMatching.pt);" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "READ(asset.1212677795454.8/templates/generated/Pattern.1212569887715.48/generatePostMatching.pt);" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212569917570.49.pt);" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "body", "READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212569917570.50.pt);" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "body", "READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570146610.55.pt);" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(6), 
		   source, 
		   new String[] {
			 "body", "READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570161763.56.pt);" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(7), 
		   source, 
		   new String[] {
			 "body", "READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570188118.57.pt);" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(8), 
		   source, 
		   new String[] {
			 "body", "READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570199601.58.pt);" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(9), 
		   source, 
		   new String[] {
			 "body", "READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570213692.59.pt);" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(10), 
		   source, 
		   new String[] {
			 "body", "READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570313129.64.pt);" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(11), 
		   source, 
		   new String[] {
			 "body", "READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570335781.65.pt);" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(12), 
		   source, 
		   new String[] {
			 "body", "READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212765036913.16.pt);" //$NON-NLS-1$ //$NON-NLS-2$
		   });	
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/egf/1.0.0/uid</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUidAnnotations() {
		String source = "http://www.eclipse.org/egf/1.0.0/uid"; //$NON-NLS-1$								
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "PatternMethod.1212569917570.49" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "body", "PatternMethod.1212569917570.50" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "body", "PatternMethod.1212570146610.55" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(6), 
		   source, 
		   new String[] {
			 "body", "PatternMethod.1212570161763.56" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(7), 
		   source, 
		   new String[] {
			 "body", "PatternMethod.1212570188118.57" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(8), 
		   source, 
		   new String[] {
			 "body", "PatternMethod.1212570199601.58" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(9), 
		   source, 
		   new String[] {
			 "body", "PatternMethod.1212570213692.59" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(10), 
		   source, 
		   new String[] {
			 "body", "PatternMethod.1212570313129.64" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(11), 
		   source, 
		   new String[] {
			 "body", "PatternMethod.1212570335781.65" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (htmlFcDocEClass.getEOperations().get(12), 
		   source, 
		   new String[] {
			 "body", "PatternMethod.1212765036913.16" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
	}

} //Pattern_1212569887715_48PackageImpl
