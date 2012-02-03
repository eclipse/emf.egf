/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    All rights reserved. This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v1.0
 *    which accompanies this distribution, and is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *   
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildcore.util;

import java.util.List;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.*;

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
 * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage
 * @generated
 */
public class BuildcoreSwitch<T> {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static BuildcorePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuildcoreSwitch() {
        if (modelPackage == null) {
            modelPackage = BuildcorePackage.eINSTANCE;
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
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
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
            case BuildcorePackage.ITEM: {
                Item item = (Item)theEObject;
                T result = caseItem(item);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildcorePackage.ITEM_PROPERTIES: {
                ItemProperties itemProperties = (ItemProperties)theEObject;
                T result = caseItemProperties(itemProperties);
                if (result == null) result = caseItem(itemProperties);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildcorePackage.KEY_VALUE: {
                KeyValue keyValue = (KeyValue)theEObject;
                T result = caseKeyValue(keyValue);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildcorePackage.PROPERTY: {
                Property property = (Property)theEObject;
                T result = caseProperty(property);
                if (result == null) result = caseKeyValue(property);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildcorePackage.CHAIN: {
                Chain chain = (Chain)theEObject;
                T result = caseChain(chain);
                if (result == null) result = caseItemProperties(chain);
                if (result == null) result = caseItem(chain);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildcorePackage.ABSTRACT_STEP_CONTAINER: {
                AbstractStepContainer abstractStepContainer = (AbstractStepContainer)theEObject;
                T result = caseAbstractStepContainer(abstractStepContainer);
                if (result == null) result = caseItemProperties(abstractStepContainer);
                if (result == null) result = caseItem(abstractStepContainer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildcorePackage.STEP: {
                Step step = (Step)theEObject;
                T result = caseStep(step);
                if (result == null) result = caseItem(step);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildcorePackage.JOB: {
                Job job = (Job)theEObject;
                T result = caseJob(job);
                if (result == null) result = caseAbstractStepContainer(job);
                if (result == null) result = caseItemProperties(job);
                if (result == null) result = caseItem(job);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildcorePackage.STEP_CONTAINER: {
                StepContainer stepContainer = (StepContainer)theEObject;
                T result = caseStepContainer(stepContainer);
                if (result == null) result = caseAbstractStepContainer(stepContainer);
                if (result == null) result = caseStep(stepContainer);
                if (result == null) result = caseItemProperties(stepContainer);
                if (result == null) result = caseItem(stepContainer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildcorePackage.SCM: {
                SCM scm = (SCM)theEObject;
                T result = caseSCM(scm);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildcorePackage.TRIGGER: {
                Trigger trigger = (Trigger)theEObject;
                T result = caseTrigger(trigger);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItem(Item object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item Properties</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item Properties</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemProperties(ItemProperties object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Key Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Key Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKeyValue(KeyValue object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Chain</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Chain</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseChain(Chain object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Step Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Step Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractStepContainer(AbstractStepContainer object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Job</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Job</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJob(Job object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStep(Step object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Step Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Step Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStepContainer(StepContainer object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>SCM</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>SCM</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSCM(SCM object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProperty(Property object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Trigger</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Trigger</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTrigger(Trigger object) {
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

} //BuildcoreSwitch
