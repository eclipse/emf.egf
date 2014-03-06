/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.portfolio.genchain.extension.SampleExtension;

import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;

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
 * @see org.eclipse.egf.portfolio.genchain.extension.SampleExtension.SampleExtensionFactory
 * @model kind="package"
 * @generated
 */
public interface SampleExtensionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SampleExtension";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/egf/1.0.0/generationChainSampleExtension";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SampleExtension";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SampleExtensionPackage eINSTANCE = org.eclipse.egf.portfolio.genchain.extension.SampleExtension.impl.SampleExtensionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.egf.portfolio.genchain.extension.SampleExtension.impl.SampleElementImpl <em>Sample Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.egf.portfolio.genchain.extension.SampleExtension.impl.SampleElementImpl
	 * @see org.eclipse.egf.portfolio.genchain.extension.SampleExtension.impl.SampleExtensionPackageImpl#getSampleElement()
	 * @generated
	 */
	int SAMPLE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_ELEMENT__NAME = GenerationChainPackage.ECORE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_ELEMENT__CONTAINER = GenerationChainPackage.ECORE_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Model Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_ELEMENT__MODEL_PATH = GenerationChainPackage.ECORE_ELEMENT__MODEL_PATH;

	/**
	 * The number of structural features of the '<em>Sample Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_ELEMENT_FEATURE_COUNT = GenerationChainPackage.ECORE_ELEMENT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.egf.portfolio.genchain.extension.SampleExtension.SampleElement <em>Sample Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sample Element</em>'.
	 * @see org.eclipse.egf.portfolio.genchain.extension.SampleExtension.SampleElement
	 * @generated
	 */
	EClass getSampleElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SampleExtensionFactory getSampleExtensionFactory();

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
		 * The meta object literal for the '{@link org.eclipse.egf.portfolio.genchain.extension.SampleExtension.impl.SampleElementImpl <em>Sample Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.egf.portfolio.genchain.extension.SampleExtension.impl.SampleElementImpl
		 * @see org.eclipse.egf.portfolio.genchain.extension.SampleExtension.impl.SampleExtensionPackageImpl#getSampleElement()
		 * @generated
		 */
		EClass SAMPLE_ELEMENT = eINSTANCE.getSampleElement();

	}

} //SampleExtensionPackage
