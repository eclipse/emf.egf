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
 * A representation of the model object '<em><b>Documentation Generation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration#getPluginName <em>Plugin Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration#getOutputDirectoryPath <em>Output Directory Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getDocumentationGeneration()
 * @model
 * @generated
 */
public interface DocumentationGeneration extends EcoreElement, PluginProvider {
    /**
     * Returns the value of the '<em><b>Plugin Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plugin Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Plugin Name</em>' attribute.
     * @see #setPluginName(String)
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getDocumentationGeneration_PluginName()
     * @model required="true"
     * @generated
     */
    String getPluginName();

    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration#getPluginName <em>Plugin Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Plugin Name</em>' attribute.
     * @see #getPluginName()
     * @generated
     */
    void setPluginName(String value);

    /**
     * Returns the value of the '<em><b>Output Directory Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Directory Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Directory Path</em>' attribute.
     * @see #setOutputDirectoryPath(String)
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getDocumentationGeneration_OutputDirectoryPath()
     * @model required="true"
     * @generated
     */
    String getOutputDirectoryPath();

    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration#getOutputDirectoryPath <em>Output Directory Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Directory Path</em>' attribute.
     * @see #getOutputDirectoryPath()
     * @generated
     */
    void setOutputDirectoryPath(String value);

} // DocumentationGeneration
