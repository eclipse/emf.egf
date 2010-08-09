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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generation Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getGenerationElement()
 * @model abstract="true"
 * @generated
 */
public interface GenerationElement extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getGenerationElement_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain#getElements <em>Elements</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Container</em>' container reference.
     * @see #setContainer(GenerationChain)
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getGenerationElement_Container()
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain#getElements
     * @model opposite="elements" transient="false"
     * @generated
     */
    GenerationChain getContainer();

    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement#getContainer <em>Container</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Container</em>' container reference.
     * @see #getContainer()
     * @generated
     */
    void setContainer(GenerationChain value);

} // GenerationElement
