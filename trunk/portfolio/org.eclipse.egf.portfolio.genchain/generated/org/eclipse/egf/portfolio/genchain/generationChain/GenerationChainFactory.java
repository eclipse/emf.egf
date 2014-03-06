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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage
 * @generated
 */
public interface GenerationChainFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    GenerationChainFactory eINSTANCE = org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Generation Chain</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Generation Chain</em>'.
     * @generated
     */
    GenerationChain createGenerationChain();

    /**
     * Returns a new object of class '<em>Emf Generation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Emf Generation</em>'.
     * @generated
     */
    EmfGeneration createEmfGeneration();

    /**
     * Returns a new object of class '<em>Documentation Generation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Documentation Generation</em>'.
     * @generated
     */
    DocumentationGeneration createDocumentationGeneration();

    /**
     * Returns a new object of class '<em>Plugin Addition</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Plugin Addition</em>'.
     * @generated
     */
    PluginAddition createPluginAddition();

    /**
     * Returns a new object of class '<em>Feature Addition</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Feature Addition</em>'.
     * @generated
     */
    FeatureAddition createFeatureAddition();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    GenerationChainPackage getGenerationChainPackage();

} //GenerationChainFactory
