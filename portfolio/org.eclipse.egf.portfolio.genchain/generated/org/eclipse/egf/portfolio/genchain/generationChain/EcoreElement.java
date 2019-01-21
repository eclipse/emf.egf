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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ecore Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement#getModelPath <em>Model Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getEcoreElement()
 * @model abstract="true"
 * @generated
 */
public interface EcoreElement extends GenerationElement {
    /**
     * Returns the value of the '<em><b>Model Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Model Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Model Path</em>' attribute.
     * @see #setModelPath(String)
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getEcoreElement_ModelPath()
     * @model required="true"
     * @generated
     */
    String getModelPath();

    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement#getModelPath <em>Model Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Model Path</em>' attribute.
     * @see #getModelPath()
     * @generated
     */
    void setModelPath(String value);

} // EcoreElement
