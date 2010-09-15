/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.portfolio.genchain.generationChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Emf Generation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateModel <em>Generate Model</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateEdit <em>Generate Edit</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateEditor <em>Generate Editor</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#getPluginName <em>Plugin Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#getBasePackage <em>Base Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getEmfGeneration()
 * @model
 * @generated
 */
public interface EmfGeneration extends EcoreElement, PluginProvider {
    /**
     * Returns the value of the '<em><b>Generate Model</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Generate Model</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Generate Model</em>' attribute.
     * @see #setGenerateModel(boolean)
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getEmfGeneration_GenerateModel()
     * @model
     * @generated
     */
    boolean isGenerateModel();

    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateModel <em>Generate Model</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Generate Model</em>' attribute.
     * @see #isGenerateModel()
     * @generated
     */
    void setGenerateModel(boolean value);

    /**
     * Returns the value of the '<em><b>Generate Edit</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Generate Edit</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Generate Edit</em>' attribute.
     * @see #setGenerateEdit(boolean)
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getEmfGeneration_GenerateEdit()
     * @model
     * @generated
     */
    boolean isGenerateEdit();

    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateEdit <em>Generate Edit</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Generate Edit</em>' attribute.
     * @see #isGenerateEdit()
     * @generated
     */
    void setGenerateEdit(boolean value);

    /**
     * Returns the value of the '<em><b>Generate Editor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Generate Editor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Generate Editor</em>' attribute.
     * @see #setGenerateEditor(boolean)
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getEmfGeneration_GenerateEditor()
     * @model
     * @generated
     */
    boolean isGenerateEditor();

    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateEditor <em>Generate Editor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Generate Editor</em>' attribute.
     * @see #isGenerateEditor()
     * @generated
     */
    void setGenerateEditor(boolean value);

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
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getEmfGeneration_PluginName()
     * @model required="true"
     * @generated
     */
    String getPluginName();

    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#getPluginName <em>Plugin Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Plugin Name</em>' attribute.
     * @see #getPluginName()
     * @generated
     */
    void setPluginName(String value);

    /**
     * Returns the value of the '<em><b>Base Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Base Package</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Base Package</em>' attribute.
     * @see #setBasePackage(String)
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getEmfGeneration_BasePackage()
     * @model required="true"
     * @generated
     */
    String getBasePackage();

    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#getBasePackage <em>Base Package</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Package</em>' attribute.
     * @see #getBasePackage()
     * @generated
     */
    void setBasePackage(String value);

} // EmfGeneration
