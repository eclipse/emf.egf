/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package package_a;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see package_a.Package_aFactory
 * @model kind="package"
 * @generated
 */
public interface Package_aPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "package_a";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://package_a";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "package_a";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    Package_aPackage eINSTANCE = package_a.impl.Package_aPackageImpl.init();

    /**
     * The meta object id for the '{@link package_a.impl.AImpl <em>A</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see package_a.impl.AImpl
     * @see package_a.impl.Package_aPackageImpl#getA()
     * @generated
     */
    int A = 0;

    /**
     * The number of structural features of the '<em>A</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int A_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link package_a.impl.AContainerImpl <em>AContainer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see package_a.impl.AContainerImpl
     * @see package_a.impl.Package_aPackageImpl#getAContainer()
     * @generated
     */
    int ACONTAINER = 1;

    /**
     * The feature id for the '<em><b>Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACONTAINER__ELEMENTS = A_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>AContainer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACONTAINER_FEATURE_COUNT = A_FEATURE_COUNT + 1;


    /**
     * Returns the meta object for class '{@link package_a.A <em>A</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>A</em>'.
     * @see package_a.A
     * @generated
     */
    EClass getA();

    /**
     * Returns the meta object for class '{@link package_a.AContainer <em>AContainer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>AContainer</em>'.
     * @see package_a.AContainer
     * @generated
     */
    EClass getAContainer();

    /**
     * Returns the meta object for the containment reference list '{@link package_a.AContainer#getElements <em>Elements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Elements</em>'.
     * @see package_a.AContainer#getElements()
     * @see #getAContainer()
     * @generated
     */
    EReference getAContainer_Elements();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    Package_aFactory getPackage_aFactory();

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
         * The meta object literal for the '{@link package_a.impl.AImpl <em>A</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see package_a.impl.AImpl
         * @see package_a.impl.Package_aPackageImpl#getA()
         * @generated
         */
        EClass A = eINSTANCE.getA();

        /**
         * The meta object literal for the '{@link package_a.impl.AContainerImpl <em>AContainer</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see package_a.impl.AContainerImpl
         * @see package_a.impl.Package_aPackageImpl#getAContainer()
         * @generated
         */
        EClass ACONTAINER = eINSTANCE.getAContainer();

        /**
         * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ACONTAINER__ELEMENTS = eINSTANCE.getAContainer_Elements();

    }

} //Package_aPackage
