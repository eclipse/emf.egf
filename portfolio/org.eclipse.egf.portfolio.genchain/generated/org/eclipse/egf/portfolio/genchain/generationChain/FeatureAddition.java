/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.portfolio.genchain.generationChain;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Addition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.FeatureAddition#getAdditions <em>Additions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getFeatureAddition()
 * @model
 * @generated
 */
public interface FeatureAddition extends GenerationElement {
    /**
     * Returns the value of the '<em><b>Additions</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Additions</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Additions</em>' attribute list.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getFeatureAddition_Additions()
     * @model
     * @generated
     */
    EList<String> getAdditions();

} // FeatureAddition
