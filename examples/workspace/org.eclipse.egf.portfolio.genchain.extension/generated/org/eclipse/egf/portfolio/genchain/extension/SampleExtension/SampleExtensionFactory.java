/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.portfolio.genchain.extension.SampleExtension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.genchain.extension.SampleExtension.SampleExtensionPackage
 * @generated
 */
public interface SampleExtensionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SampleExtensionFactory eINSTANCE = org.eclipse.egf.portfolio.genchain.extension.SampleExtension.impl.SampleExtensionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sample Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sample Element</em>'.
	 * @generated
	 */
	SampleElement createSampleElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SampleExtensionPackage getSampleExtensionPackage();

} //SampleExtensionFactory
