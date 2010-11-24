/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package package_a;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see package_a.Package_aPackage
 * @generated
 */
public interface Package_aFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    Package_aFactory eINSTANCE = package_a.impl.Package_aFactoryImpl.init();

    /**
     * Returns a new object of class '<em>A</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>A</em>'.
     * @generated
     */
    A createA();

    /**
     * Returns a new object of class '<em>AContainer</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>AContainer</em>'.
     * @generated
     */
    AContainer createAContainer();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    Package_aPackage getPackage_aPackage();

} //Package_aFactory
