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
package org.eclipse.egf.portfolio.genchain.cdo.cdoExtension;

import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.egf.portfolio.genchain.generationChain.PluginProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cdo Generation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration#getCdoSuffix <em>Cdo Suffix</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration#getFeatureDelegation <em>Feature Delegation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoExtensionPackage#getCdoGeneration()
 * @model
 * @generated
 */
public interface CdoGeneration extends EcoreElement, PluginProvider {
	/**
	 * Returns the value of the '<em><b>Cdo Suffix</b></em>' attribute.
	 * The default value is <code>"cdo"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cdo Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cdo Suffix</em>' attribute.
	 * @see #setCdoSuffix(String)
	 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoExtensionPackage#getCdoGeneration_CdoSuffix()
	 * @model default="cdo"
	 * @generated
	 */
	String getCdoSuffix();

	/**
	 * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration#getCdoSuffix <em>Cdo Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cdo Suffix</em>' attribute.
	 * @see #getCdoSuffix()
	 * @generated
	 */
	void setCdoSuffix(String value);

	/**
	 * Returns the value of the '<em><b>Feature Delegation</b></em>' attribute.
	 * The default value is <code>"Dynamic"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Delegation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Delegation</em>' attribute.
	 * @see #setFeatureDelegation(String)
	 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoExtensionPackage#getCdoGeneration_FeatureDelegation()
	 * @model default="Dynamic"
	 * @generated
	 */
	String getFeatureDelegation();

	/**
	 * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration#getFeatureDelegation <em>Feature Delegation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Delegation</em>' attribute.
	 * @see #getFeatureDelegation()
	 * @generated
	 */
	void setFeatureDelegation(String value);

} // CdoGeneration
