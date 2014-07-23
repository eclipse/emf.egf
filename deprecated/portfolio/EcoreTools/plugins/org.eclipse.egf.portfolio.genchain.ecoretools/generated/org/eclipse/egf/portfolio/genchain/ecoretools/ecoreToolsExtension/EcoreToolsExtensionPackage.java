/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension;

import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsExtensionFactory
 * @model kind="package"
 *        annotation="http://www.thalesgroup.com/mde/2010/extension extensibleProviderFactory='true' childCreationExtenders='true' useUUIDs='true' useIDAttributes='false'"
 *        annotation="http://www.thalesgroup.com/mde/mdsofa/dsl/2007/dslfactory extensibleProviderFactory='true' childCreationExtenders='true' useUUIDs='true' useIDAttributes='false'"
 *        annotation="http://www.thalesgroup.com/mde/ecore/documentation description='null' usage\040guideline='null' used\040in\040levels='null' usage\040examples='null' constraints='null'"
 * @generated
 */
public interface EcoreToolsExtensionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ecoreToolsExtension"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/egf/1.0.0/generationChainEcoreToolsExtension"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ecoreToolsExtension"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcoreToolsExtensionPackage eINSTANCE = org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.impl.EcoreToolsExtensionPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.impl.EcoreToolsGenerationImpl <em>Ecore Tools Generation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.impl.EcoreToolsGenerationImpl
	 * @see org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.impl.EcoreToolsExtensionPackageImpl#getEcoreToolsGeneration()
	 * @generated
	 */
	int ECORE_TOOLS_GENERATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_TOOLS_GENERATION__NAME = GenerationChainPackage.ECORE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_TOOLS_GENERATION__CONTAINER = GenerationChainPackage.ECORE_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Model Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_TOOLS_GENERATION__MODEL_PATH = GenerationChainPackage.ECORE_ELEMENT__MODEL_PATH;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_TOOLS_GENERATION__FILE_NAME = GenerationChainPackage.ECORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecore Tools Generation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_TOOLS_GENERATION_FEATURE_COUNT = GenerationChainPackage.ECORE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsGeneration <em>Ecore Tools Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecore Tools Generation</em>'.
	 * @see org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsGeneration
	 * @generated
	 */
	EClass getEcoreToolsGeneration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsGeneration#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsGeneration#getFileName()
	 * @see #getEcoreToolsGeneration()
	 * @generated
	 */
	EAttribute getEcoreToolsGeneration_FileName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EcoreToolsExtensionFactory getEcoreToolsExtensionFactory();

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
		 * The meta object literal for the '{@link org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.impl.EcoreToolsGenerationImpl <em>Ecore Tools Generation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.impl.EcoreToolsGenerationImpl
		 * @see org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.impl.EcoreToolsExtensionPackageImpl#getEcoreToolsGeneration()
		 * @generated
		 */
		EClass ECORE_TOOLS_GENERATION = eINSTANCE.getEcoreToolsGeneration();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORE_TOOLS_GENERATION__FILE_NAME = eINSTANCE
				.getEcoreToolsGeneration_FileName();

	}

} //EcoreToolsExtensionPackage
