/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.egf.example.type.extension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.example.type.extension.ExtensionPackage
 * @generated
 */
public interface ExtensionFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ExtensionFactory eINSTANCE = org.eclipse.egf.example.type.extension.impl.ExtensionFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Extended Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Extended Type</em>'.
     * @generated
     */
    ExtendedType createExtendedType();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ExtensionPackage getExtensionPackage();

} //ExtensionFactory
