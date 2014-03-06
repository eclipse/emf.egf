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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcoreToolsExtensionFactoryImpl extends EFactoryImpl implements
		EcoreToolsExtensionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EcoreToolsExtensionFactory init() {
		try {
			EcoreToolsExtensionFactory theEcoreToolsExtensionFactory = (EcoreToolsExtensionFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.eclipse.org/egf/1.0.0/generationChainEcoreToolsExtension"); //$NON-NLS-1$ 
			if (theEcoreToolsExtensionFactory != null) {
				return theEcoreToolsExtensionFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EcoreToolsExtensionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreToolsExtensionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case EcoreToolsExtensionPackage.ECORE_TOOLS_GENERATION:
			return createEcoreToolsGeneration();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreToolsGeneration createEcoreToolsGeneration() {
		EcoreToolsGenerationImpl ecoreToolsGeneration = new EcoreToolsGenerationImpl();
		return ecoreToolsGeneration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreToolsExtensionPackage getEcoreToolsExtensionPackage() {
		return (EcoreToolsExtensionPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EcoreToolsExtensionPackage getPackage() {
		return EcoreToolsExtensionPackage.eINSTANCE;
	}

} //EcoreToolsExtensionFactoryImpl
