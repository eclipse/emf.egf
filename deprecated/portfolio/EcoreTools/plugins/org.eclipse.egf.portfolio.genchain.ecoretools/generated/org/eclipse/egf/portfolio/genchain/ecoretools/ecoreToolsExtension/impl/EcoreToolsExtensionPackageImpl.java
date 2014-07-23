/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.impl;

import org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsExtensionFactory;
import org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsExtensionPackage;
import org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;
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
public class EcoreToolsExtensionPackageImpl extends EPackageImpl implements
		EcoreToolsExtensionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecoreToolsGenerationEClass = null;

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
	 * @see org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsExtensionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EcoreToolsExtensionPackageImpl() {
		super(eNS_URI, EcoreToolsExtensionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EcoreToolsExtensionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EcoreToolsExtensionPackage init() {
		if (isInited)
			return (EcoreToolsExtensionPackage) EPackage.Registry.INSTANCE
					.getEPackage(EcoreToolsExtensionPackage.eNS_URI);

		// Obtain or create and register package
		EcoreToolsExtensionPackageImpl theEcoreToolsExtensionPackage = (EcoreToolsExtensionPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof EcoreToolsExtensionPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI)
				: new EcoreToolsExtensionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		GenerationChainPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEcoreToolsExtensionPackage.createPackageContents();

		// Initialize created meta-data
		theEcoreToolsExtensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEcoreToolsExtensionPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EcoreToolsExtensionPackage.eNS_URI,
				theEcoreToolsExtensionPackage);
		return theEcoreToolsExtensionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEcoreToolsGeneration() {
		return ecoreToolsGenerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcoreToolsGeneration_FileName() {
		return (EAttribute) ecoreToolsGenerationEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreToolsExtensionFactory getEcoreToolsExtensionFactory() {
		return (EcoreToolsExtensionFactory) getEFactoryInstance();
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
		ecoreToolsGenerationEClass = createEClass(ECORE_TOOLS_GENERATION);
		createEAttribute(ecoreToolsGenerationEClass,
				ECORE_TOOLS_GENERATION__FILE_NAME);
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
		GenerationChainPackage theGenerationChainPackage = (GenerationChainPackage) EPackage.Registry.INSTANCE
				.getEPackage(GenerationChainPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ecoreToolsGenerationEClass.getESuperTypes().add(
				theGenerationChainPackage.getEcoreElement());

		// Initialize classes and features; add operations and parameters
		initEClass(
				ecoreToolsGenerationEClass,
				EcoreToolsGeneration.class,
				"EcoreToolsGeneration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getEcoreToolsGeneration_FileName(),
				theEcorePackage.getEString(),
				"fileName", null, 0, 1, EcoreToolsGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.thalesgroup.com/mde/2010/extension
		createExtensionAnnotations();
		// http://www.thalesgroup.com/mde/mdsofa/dsl/2007/dslfactory
		createDslfactoryAnnotations();
		// http://www.thalesgroup.com/mde/ecore/documentation
		createDocumentationAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.thalesgroup.com/mde/2010/extension</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtensionAnnotations() {
		String source = "http://www.thalesgroup.com/mde/2010/extension"; //$NON-NLS-1$		
		addAnnotation(this, source, new String[] {
				"extensibleProviderFactory", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"childCreationExtenders", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"useUUIDs", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"useIDAttributes", "false" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

	/**
	 * Initializes the annotations for <b>http://www.thalesgroup.com/mde/mdsofa/dsl/2007/dslfactory</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDslfactoryAnnotations() {
		String source = "http://www.thalesgroup.com/mde/mdsofa/dsl/2007/dslfactory"; //$NON-NLS-1$			
		addAnnotation(this, source, new String[] {
				"extensibleProviderFactory", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"childCreationExtenders", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"useUUIDs", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"useIDAttributes", "false" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

	/**
	 * Initializes the annotations for <b>http://www.thalesgroup.com/mde/ecore/documentation</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDocumentationAnnotations() {
		String source = "http://www.thalesgroup.com/mde/ecore/documentation"; //$NON-NLS-1$				
		addAnnotation(this, source, new String[] { "description", null, //$NON-NLS-1$
				"usage guideline", null, //$NON-NLS-1$
				"used in levels", null, //$NON-NLS-1$
				"usage examples", null, //$NON-NLS-1$
				"constraints", null //$NON-NLS-1$
				});
	}

} //EcoreToolsExtensionPackageImpl
