/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package package_b;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see package_b.Package_bPackage
 * @generated
 */
public interface Package_bFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    Package_bFactory eINSTANCE = package_b.impl.Package_bFactoryImpl.init();

    /**
     * Returns a new object of class '<em>B</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>B</em>'.
     * @generated
     */
    B createB();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    Package_bPackage getPackage_bPackage();

} //Package_bFactory
