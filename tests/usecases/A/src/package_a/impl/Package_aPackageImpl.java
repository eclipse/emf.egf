/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package package_a.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import package_a.AContainer;
import package_a.Package_aFactory;
import package_a.Package_aPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Package_aPackageImpl extends EPackageImpl implements Package_aPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass aEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass aContainerEClass = null;

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
     * @see package_a.Package_aPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private Package_aPackageImpl() {
        super(eNS_URI, Package_aFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link Package_aPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static Package_aPackage init() {
        if (isInited) return (Package_aPackage)EPackage.Registry.INSTANCE.getEPackage(Package_aPackage.eNS_URI);

        // Obtain or create and register package
        Package_aPackageImpl thePackage_aPackage = (Package_aPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Package_aPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Package_aPackageImpl());

        isInited = true;

        // Create package meta-data objects
        thePackage_aPackage.createPackageContents();

        // Initialize created meta-data
        thePackage_aPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        thePackage_aPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(Package_aPackage.eNS_URI, thePackage_aPackage);
        return thePackage_aPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getA() {
        return aEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAContainer() {
        return aContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAContainer_Elements() {
        return (EReference)aContainerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Package_aFactory getPackage_aFactory() {
        return (Package_aFactory)getEFactoryInstance();
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
        aEClass = createEClass(A);

        aContainerEClass = createEClass(ACONTAINER);
        createEReference(aContainerEClass, ACONTAINER__ELEMENTS);
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

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        aContainerEClass.getESuperTypes().add(this.getA());

        // Initialize classes and features; add operations and parameters
        initEClass(aEClass, package_a.A.class, "A", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(aContainerEClass, AContainer.class, "AContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAContainer_Elements(), this.getA(), null, "elements", null, 0, -1, AContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //Package_aPackageImpl
