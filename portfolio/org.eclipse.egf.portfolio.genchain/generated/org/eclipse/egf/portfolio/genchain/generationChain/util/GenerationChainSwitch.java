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
package org.eclipse.egf.portfolio.genchain.generationChain.util;

import java.util.List;

import org.eclipse.egf.portfolio.genchain.generationChain.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage
 * @generated
 */
public class GenerationChainSwitch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static GenerationChainPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenerationChainSwitch() {
        if (modelPackage == null) {
            modelPackage = GenerationChainPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        } else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case GenerationChainPackage.GENERATION_ELEMENT: {
            GenerationElement generationElement = (GenerationElement) theEObject;
            T result = caseGenerationElement(generationElement);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case GenerationChainPackage.GENERATION_CHAIN: {
            GenerationChain generationChain = (GenerationChain) theEObject;
            T result = caseGenerationChain(generationChain);
            if (result == null)
                result = caseGenerationElement(generationChain);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case GenerationChainPackage.EMF_GENERATION: {
            EmfGeneration emfGeneration = (EmfGeneration) theEObject;
            T result = caseEmfGeneration(emfGeneration);
            if (result == null)
                result = caseEcoreElement(emfGeneration);
            if (result == null)
                result = casePluginProvider(emfGeneration);
            if (result == null)
                result = caseGenerationElement(emfGeneration);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case GenerationChainPackage.DOCUMENTATION_GENERATION: {
            DocumentationGeneration documentationGeneration = (DocumentationGeneration) theEObject;
            T result = caseDocumentationGeneration(documentationGeneration);
            if (result == null)
                result = caseEcoreElement(documentationGeneration);
            if (result == null)
                result = casePluginProvider(documentationGeneration);
            if (result == null)
                result = caseGenerationElement(documentationGeneration);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case GenerationChainPackage.ECORE_ELEMENT: {
            EcoreElement ecoreElement = (EcoreElement) theEObject;
            T result = caseEcoreElement(ecoreElement);
            if (result == null)
                result = caseGenerationElement(ecoreElement);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case GenerationChainPackage.PLUGIN_PROVIDER: {
            PluginProvider pluginProvider = (PluginProvider) theEObject;
            T result = casePluginProvider(pluginProvider);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case GenerationChainPackage.PLUGIN_ADDITION: {
            PluginAddition pluginAddition = (PluginAddition) theEObject;
            T result = casePluginAddition(pluginAddition);
            if (result == null)
                result = caseGenerationElement(pluginAddition);
            if (result == null)
                result = casePluginProvider(pluginAddition);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Generation Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Generation Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGenerationElement(GenerationElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Generation Chain</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Generation Chain</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGenerationChain(GenerationChain object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Emf Generation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Emf Generation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEmfGeneration(EmfGeneration object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Documentation Generation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Documentation Generation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentationGeneration(DocumentationGeneration object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ecore Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ecore Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEcoreElement(EcoreElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Plugin Provider</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Plugin Provider</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePluginProvider(PluginProvider object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Plugin Addition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Plugin Addition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePluginAddition(PluginAddition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object) {
        return null;
    }

} //GenerationChainSwitch
