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
 * A representation of the model object '<em><b>Generation Chain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain#getFactoryComponentName <em>Factory Component Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getGenerationChain()
 * @model
 * @generated
 */
public interface GenerationChain extends GenerationElement {
    /**
     * Returns the value of the '<em><b>Factory Component Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Factory Component Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Factory Component Name</em>' attribute.
     * @see #setFactoryComponentName(String)
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getGenerationChain_FactoryComponentName()
     * @model
     * @generated
     */
    String getFactoryComponentName();

    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain#getFactoryComponentName <em>Factory Component Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Factory Component Name</em>' attribute.
     * @see #getFactoryComponentName()
     * @generated
     */
    void setFactoryComponentName(String value);

    /**
     * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement}.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement#getContainer <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Elements</em>' containment reference list.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getGenerationChain_Elements()
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement#getContainer
     * @model opposite="container" containment="true"
     * @generated
     */
    EList<GenerationElement> getElements();

} // GenerationChain
