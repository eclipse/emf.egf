/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.portfolio.genchain.extension.SampleExtension.impl;

import org.eclipse.egf.portfolio.genchain.extension.SampleExtension.SampleElement;
import org.eclipse.egf.portfolio.genchain.extension.SampleExtension.SampleExtensionFactory;
import org.eclipse.egf.portfolio.genchain.extension.SampleExtension.SampleExtensionPackage;

import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SampleExtensionPackageImpl extends EPackageImpl implements SampleExtensionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sampleElementEClass = null;

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
	 * @see org.eclipse.egf.portfolio.genchain.extension.SampleExtension.SampleExtensionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SampleExtensionPackageImpl() {
		super(eNS_URI, SampleExtensionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SampleExtensionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SampleExtensionPackage init() {
		if (isInited) return (SampleExtensionPackage)EPackage.Registry.INSTANCE.getEPackage(SampleExtensionPackage.eNS_URI);

		// Obtain or create and register package
		SampleExtensionPackageImpl theSampleExtensionPackage = (SampleExtensionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SampleExtensionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SampleExtensionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GenerationChainPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSampleExtensionPackage.createPackageContents();

		// Initialize created meta-data
		theSampleExtensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSampleExtensionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SampleExtensionPackage.eNS_URI, theSampleExtensionPackage);
		return theSampleExtensionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSampleElement() {
		return sampleElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SampleExtensionFactory getSampleExtensionFactory() {
		return (SampleExtensionFactory)getEFactoryInstance();
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
		sampleElementEClass = createEClass(SAMPLE_ELEMENT);
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
		GenerationChainPackage theGenerationChainPackage = (GenerationChainPackage)EPackage.Registry.INSTANCE.getEPackage(GenerationChainPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sampleElementEClass.getESuperTypes().add(theGenerationChainPackage.getEcoreElement());

		// Initialize classes and features; add operations and parameters
		initEClass(sampleElementEClass, SampleElement.class, "SampleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SampleExtensionPackageImpl
