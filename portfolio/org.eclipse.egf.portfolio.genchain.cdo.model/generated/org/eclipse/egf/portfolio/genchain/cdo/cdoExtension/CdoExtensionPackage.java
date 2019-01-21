/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.portfolio.genchain.cdo.cdoExtension;

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
 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoExtensionFactory
 * @model kind="package"
 * @generated
 */
public interface CdoExtensionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cdoExtension";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/egf/genchain/extension/cdo/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cdoExtension";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CdoExtensionPackage eINSTANCE = org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.impl.CdoExtensionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.impl.CdoGenerationImpl <em>Cdo Generation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.impl.CdoGenerationImpl
	 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.impl.CdoExtensionPackageImpl#getCdoGeneration()
	 * @generated
	 */
	int CDO_GENERATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDO_GENERATION__NAME = GenerationChainPackage.ECORE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDO_GENERATION__CONTAINER = GenerationChainPackage.ECORE_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Model Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDO_GENERATION__MODEL_PATH = GenerationChainPackage.ECORE_ELEMENT__MODEL_PATH;

	/**
	 * The feature id for the '<em><b>Cdo Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDO_GENERATION__CDO_SUFFIX = GenerationChainPackage.ECORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Feature Delegation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDO_GENERATION__FEATURE_DELEGATION = GenerationChainPackage.ECORE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cdo Generation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDO_GENERATION_FEATURE_COUNT = GenerationChainPackage.ECORE_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration <em>Cdo Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cdo Generation</em>'.
	 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration
	 * @generated
	 */
	EClass getCdoGeneration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration#getCdoSuffix <em>Cdo Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cdo Suffix</em>'.
	 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration#getCdoSuffix()
	 * @see #getCdoGeneration()
	 * @generated
	 */
	EAttribute getCdoGeneration_CdoSuffix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration#getFeatureDelegation <em>Feature Delegation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Delegation</em>'.
	 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration#getFeatureDelegation()
	 * @see #getCdoGeneration()
	 * @generated
	 */
	EAttribute getCdoGeneration_FeatureDelegation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CdoExtensionFactory getCdoExtensionFactory();

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
		 * The meta object literal for the '{@link org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.impl.CdoGenerationImpl <em>Cdo Generation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.impl.CdoGenerationImpl
		 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.impl.CdoExtensionPackageImpl#getCdoGeneration()
		 * @generated
		 */
		EClass CDO_GENERATION = eINSTANCE.getCdoGeneration();

		/**
		 * The meta object literal for the '<em><b>Cdo Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CDO_GENERATION__CDO_SUFFIX = eINSTANCE.getCdoGeneration_CdoSuffix();

		/**
		 * The meta object literal for the '<em><b>Feature Delegation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CDO_GENERATION__FEATURE_DELEGATION = eINSTANCE.getCdoGeneration_FeatureDelegation();

	}

} //CdoExtensionPackage
