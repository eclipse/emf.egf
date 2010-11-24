/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package package_b;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import package_a.Package_aPackage;

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
 * @see package_b.Package_bFactory
 * @model kind="package"
 * @generated
 */
public interface Package_bPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "package_b";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://package_b";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "package_b";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    Package_bPackage eINSTANCE = package_b.impl.Package_bPackageImpl.init();

    /**
     * The meta object id for the '{@link package_b.impl.BImpl <em>B</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see package_b.impl.BImpl
     * @see package_b.impl.Package_bPackageImpl#getB()
     * @generated
     */
    int B = 0;

    /**
     * The number of structural features of the '<em>B</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int B_FEATURE_COUNT = Package_aPackage.A_FEATURE_COUNT + 0;


    /**
     * Returns the meta object for class '{@link package_b.B <em>B</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>B</em>'.
     * @see package_b.B
     * @generated
     */
    EClass getB();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    Package_bFactory getPackage_bFactory();

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
         * The meta object literal for the '{@link package_b.impl.BImpl <em>B</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see package_b.impl.BImpl
         * @see package_b.impl.Package_bPackageImpl#getB()
         * @generated
         */
        EClass B = eINSTANCE.getB();

    }

} //Package_bPackage
