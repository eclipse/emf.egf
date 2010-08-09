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
package org.eclipse.egf.portfolio.genchain.generationChain.impl;

import org.eclipse.egf.portfolio.genchain.generationChain.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenerationChainFactoryImpl extends EFactoryImpl implements GenerationChainFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static GenerationChainFactory init() {
        try {
            GenerationChainFactory theGenerationChainFactory = (GenerationChainFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/generationChain");
            if (theGenerationChainFactory != null) {
                return theGenerationChainFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new GenerationChainFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenerationChainFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case GenerationChainPackage.GENERATION_CHAIN:
            return createGenerationChain();
        case GenerationChainPackage.EMF_GENERATION:
            return createEmfGeneration();
        case GenerationChainPackage.DOCUMENTATION_GENERATION:
            return createDocumentationGeneration();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenerationChain createGenerationChain() {
        GenerationChainImpl generationChain = new GenerationChainImpl();
        return generationChain;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EmfGeneration createEmfGeneration() {
        EmfGenerationImpl emfGeneration = new EmfGenerationImpl();
        return emfGeneration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocumentationGeneration createDocumentationGeneration() {
        DocumentationGenerationImpl documentationGeneration = new DocumentationGenerationImpl();
        return documentationGeneration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenerationChainPackage getGenerationChainPackage() {
        return (GenerationChainPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static GenerationChainPackage getPackage() {
        return GenerationChainPackage.eINSTANCE;
    }

} //GenerationChainFactoryImpl
