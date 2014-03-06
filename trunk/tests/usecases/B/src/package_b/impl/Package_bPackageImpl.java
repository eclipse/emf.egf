/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package package_b.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import package_a.Package_aPackage;

import package_b.Package_bFactory;
import package_b.Package_bPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Package_bPackageImpl extends EPackageImpl implements Package_bPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass bEClass = null;

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
     * @see package_b.Package_bPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private Package_bPackageImpl() {
        super(eNS_URI, Package_bFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link Package_bPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static Package_bPackage init() {
        if (isInited) return (Package_bPackage)EPackage.Registry.INSTANCE.getEPackage(Package_bPackage.eNS_URI);

        // Obtain or create and register package
        Package_bPackageImpl thePackage_bPackage = (Package_bPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Package_bPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Package_bPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        Package_aPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        thePackage_bPackage.createPackageContents();

        // Initialize created meta-data
        thePackage_bPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        thePackage_bPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(Package_bPackage.eNS_URI, thePackage_bPackage);
        return thePackage_bPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getB() {
        return bEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Package_bFactory getPackage_bFactory() {
        return (Package_bFactory)getEFactoryInstance();
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
        bEClass = createEClass(B);
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
        Package_aPackage thePackage_aPackage = (Package_aPackage)EPackage.Registry.INSTANCE.getEPackage(Package_aPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        bEClass.getESuperTypes().add(thePackage_aPackage.getA());

        // Initialize classes and features; add operations and parameters
        initEClass(bEClass, package_b.B.class, "B", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //Package_bPackageImpl
