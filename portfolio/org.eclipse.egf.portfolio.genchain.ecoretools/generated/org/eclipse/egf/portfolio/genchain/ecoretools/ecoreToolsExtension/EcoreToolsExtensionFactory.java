/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsExtensionPackage
 * @generated
 */
public interface EcoreToolsExtensionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcoreToolsExtensionFactory eINSTANCE = org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.impl.EcoreToolsExtensionFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Ecore Tools Generation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecore Tools Generation</em>'.
	 * @generated
	 */
	EcoreToolsGeneration createEcoreToolsGeneration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EcoreToolsExtensionPackage getEcoreToolsExtensionPackage();

} //EcoreToolsExtensionFactory
