/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.impl;

import org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoExtensionPackage;
import org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.impl.EcoreElementImpl;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Cdo Generation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.impl.CdoGenerationImpl#getCdoSuffix <em>Cdo Suffix</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.impl.CdoGenerationImpl#getFeatureDelegation <em>Feature Delegation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CdoGenerationImpl extends EcoreElementImpl implements CdoGeneration {
	/**
	 * The default value of the '{@link #getCdoSuffix() <em>Cdo Suffix</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCdoSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String CDO_SUFFIX_EDEFAULT = "cdo";

	/**
	 * The cached value of the '{@link #getCdoSuffix() <em>Cdo Suffix</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCdoSuffix()
	 * @generated
	 * @ordered
	 */
	protected String cdoSuffix = CDO_SUFFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeatureDelegation() <em>Feature Delegation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFeatureDelegation()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_DELEGATION_EDEFAULT = "Dynamic";

	/**
	 * The cached value of the '{@link #getFeatureDelegation() <em>Feature Delegation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFeatureDelegation()
	 * @generated
	 * @ordered
	 */
	protected String featureDelegation = FEATURE_DELEGATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CdoGenerationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CdoExtensionPackage.Literals.CDO_GENERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCdoSuffix() {
		return cdoSuffix;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCdoSuffix(String newCdoSuffix) {
		String oldCdoSuffix = cdoSuffix;
		cdoSuffix = newCdoSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CdoExtensionPackage.CDO_GENERATION__CDO_SUFFIX, oldCdoSuffix, cdoSuffix));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureDelegation() {
		return featureDelegation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureDelegation(String newFeatureDelegation) {
		String oldFeatureDelegation = featureDelegation;
		featureDelegation = newFeatureDelegation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CdoExtensionPackage.CDO_GENERATION__FEATURE_DELEGATION, oldFeatureDelegation, featureDelegation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated Not
	 */
	public EList<String> getPluginNames(EList<EObject> domains) {
		BasicEList<String> result = new BasicEList<String>();
		for (EObject domain : domains) {
			if (domain instanceof GenModel) {
				GenModel genModel = (GenModel) domain;
				for (String foreign : genModel.getForeignModel()) {
					if (foreign.endsWith(modelPath)) {
						result.add(genModel.getModelPluginID() + "." + cdoSuffix);
						return result;
					}
				}
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CdoExtensionPackage.CDO_GENERATION__CDO_SUFFIX:
				return getCdoSuffix();
			case CdoExtensionPackage.CDO_GENERATION__FEATURE_DELEGATION:
				return getFeatureDelegation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CdoExtensionPackage.CDO_GENERATION__CDO_SUFFIX:
				setCdoSuffix((String)newValue);
				return;
			case CdoExtensionPackage.CDO_GENERATION__FEATURE_DELEGATION:
				setFeatureDelegation((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CdoExtensionPackage.CDO_GENERATION__CDO_SUFFIX:
				setCdoSuffix(CDO_SUFFIX_EDEFAULT);
				return;
			case CdoExtensionPackage.CDO_GENERATION__FEATURE_DELEGATION:
				setFeatureDelegation(FEATURE_DELEGATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CdoExtensionPackage.CDO_GENERATION__CDO_SUFFIX:
				return CDO_SUFFIX_EDEFAULT == null ? cdoSuffix != null : !CDO_SUFFIX_EDEFAULT.equals(cdoSuffix);
			case CdoExtensionPackage.CDO_GENERATION__FEATURE_DELEGATION:
				return FEATURE_DELEGATION_EDEFAULT == null ? featureDelegation != null : !FEATURE_DELEGATION_EDEFAULT.equals(featureDelegation);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (cdoSuffix: ");
		result.append(cdoSuffix);
		result.append(", featureDelegation: ");
		result.append(featureDelegation);
		result.append(')');
		return result.toString();
	}

} // CdoGenerationImpl
