/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.pattern.util;

import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.model.pattern.AbstractPatternCall;
import org.eclipse.egf.model.pattern.BackCall;
import org.eclipse.egf.model.pattern.BasicQuery;
import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.CustomQuery;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.model.pattern.StringQuery;
import org.eclipse.egf.model.pattern.SuperCall;
import org.eclipse.egf.model.pattern.TypePatternCallBackHandler;
import org.eclipse.egf.model.pattern.TypePatternDomainVisitor;
import org.eclipse.egf.model.pattern.TypePatternExecutionReporter;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.egf.model.types.TypeElement;
import org.eclipse.egf.model.types.TypeList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke
 * the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.pattern.PatternPackage
 * @generated
 */
public class PatternSwitch<T> {

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static PatternPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PatternSwitch() {
        if (modelPackage == null) {
            modelPackage = PatternPackage.eINSTANCE;
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
    @SuppressWarnings("all")
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
        case PatternPackage.PATTERN_NATURE: {
            PatternNature patternNature = (PatternNature) theEObject;
            T result = casePatternNature(patternNature);
            if (result == null)
                result = caseNamedModelElement(patternNature);
            if (result == null)
                result = caseModelElement(patternNature);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_ELEMENT: {
            PatternElement patternElement = (PatternElement) theEObject;
            T result = casePatternElement(patternElement);
            if (result == null)
                result = caseNamedModelElement(patternElement);
            if (result == null)
                result = caseModelElement(patternElement);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_LIBRARY: {
            PatternLibrary patternLibrary = (PatternLibrary) theEObject;
            T result = casePatternLibrary(patternLibrary);
            if (result == null)
                result = casePatternElement(patternLibrary);
            if (result == null)
                result = caseNamedModelElement(patternLibrary);
            if (result == null)
                result = caseModelElement(patternLibrary);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN: {
            Pattern pattern = (Pattern) theEObject;
            T result = casePattern(pattern);
            if (result == null)
                result = casePatternElement(pattern);
            if (result == null)
                result = caseNamedModelElement(pattern);
            if (result == null)
                result = caseModelElement(pattern);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_METHOD: {
            PatternMethod patternMethod = (PatternMethod) theEObject;
            T result = casePatternMethod(patternMethod);
            if (result == null)
                result = caseNamedModelElement(patternMethod);
            if (result == null)
                result = caseModelElement(patternMethod);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_PARAMETER: {
            PatternParameter patternParameter = (PatternParameter) theEObject;
            T result = casePatternParameter(patternParameter);
            if (result == null)
                result = caseNamedModelElement(patternParameter);
            if (result == null)
                result = caseInjectedContext(patternParameter);
            if (result == null)
                result = caseModelElement(patternParameter);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_VIEWPOINT: {
            PatternViewpoint patternViewpoint = (PatternViewpoint) theEObject;
            T result = casePatternViewpoint(patternViewpoint);
            if (result == null)
                result = caseViewpoint(patternViewpoint);
            if (result == null)
                result = caseModelElement(patternViewpoint);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_CALL: {
            PatternCall patternCall = (PatternCall) theEObject;
            T result = casePatternCall(patternCall);
            if (result == null)
                result = caseAbstractPatternCall(patternCall);
            if (result == null)
                result = caseCall(patternCall);
            if (result == null)
                result = caseModelElement(patternCall);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.SUPER_CALL: {
            SuperCall superCall = (SuperCall) theEObject;
            T result = caseSuperCall(superCall);
            if (result == null)
                result = caseCall(superCall);
            if (result == null)
                result = caseModelElement(superCall);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PARAMERTER2_PARAMETER_MAP: {
            @SuppressWarnings("unchecked")
            Map.Entry<InjectedContext, InjectedContext> paramerter2ParameterMap = (Map.Entry<InjectedContext, InjectedContext>) theEObject;
            T result = caseParamerter2ParameterMap(paramerter2ParameterMap);
            if (result == null)
                result = caseModelElement((ModelElement) paramerter2ParameterMap);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.CALL: {
            Call call = (Call) theEObject;
            T result = caseCall(call);
            if (result == null)
                result = caseModelElement(call);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.METHOD_CALL: {
            MethodCall methodCall = (MethodCall) theEObject;
            T result = caseMethodCall(methodCall);
            if (result == null)
                result = caseCall(methodCall);
            if (result == null)
                result = caseModelElement(methodCall);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_VARIABLE: {
            PatternVariable patternVariable = (PatternVariable) theEObject;
            T result = casePatternVariable(patternVariable);
            if (result == null)
                result = caseNamedModelElement(patternVariable);
            if (result == null)
                result = caseInjectedContext(patternVariable);
            if (result == null)
                result = caseModelElement(patternVariable);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.ABSTRACT_PATTERN_CALL: {
            AbstractPatternCall abstractPatternCall = (AbstractPatternCall) theEObject;
            T result = caseAbstractPatternCall(abstractPatternCall);
            if (result == null)
                result = caseCall(abstractPatternCall);
            if (result == null)
                result = caseModelElement(abstractPatternCall);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_INJECTED_CALL: {
            PatternInjectedCall patternInjectedCall = (PatternInjectedCall) theEObject;
            T result = casePatternInjectedCall(patternInjectedCall);
            if (result == null)
                result = caseAbstractPatternCall(patternInjectedCall);
            if (result == null)
                result = caseCall(patternInjectedCall);
            if (result == null)
                result = caseModelElement(patternInjectedCall);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.QUERY: {
            Query query = (Query) theEObject;
            T result = caseQuery(query);
            if (result == null)
                result = caseModelElement(query);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.BASIC_QUERY: {
            BasicQuery basicQuery = (BasicQuery) theEObject;
            T result = caseBasicQuery(basicQuery);
            if (result == null)
                result = caseQuery(basicQuery);
            if (result == null)
                result = caseModelElement(basicQuery);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.STRING_QUERY: {
            StringQuery stringQuery = (StringQuery) theEObject;
            T result = caseStringQuery(stringQuery);
            if (result == null)
                result = caseQuery(stringQuery);
            if (result == null)
                result = caseModelElement(stringQuery);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.CUSTOM_QUERY: {
            CustomQuery customQuery = (CustomQuery) theEObject;
            T result = caseCustomQuery(customQuery);
            if (result == null)
                result = caseQuery(customQuery);
            if (result == null)
                result = caseModelElement(customQuery);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.STRING2_PATTERN_LIST: {
            @SuppressWarnings("unchecked")
            Map.Entry<String, EList<PatternElement>> string2PatternList = (Map.Entry<String, EList<PatternElement>>) theEObject;
            T result = caseString2PatternList(string2PatternList);
            if (result == null)
                result = caseModelElement((ModelElement) string2PatternList);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.STRING2_STRING: {
            @SuppressWarnings("unchecked")
            Map.Entry<String, String> string2String = (Map.Entry<String, String>) theEObject;
            T result = caseString2String(string2String);
            if (result == null)
                result = caseModelElement((ModelElement) string2String);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.BACK_CALL: {
            BackCall backCall = (BackCall) theEObject;
            T result = caseBackCall(backCall);
            if (result == null)
                result = caseCall(backCall);
            if (result == null)
                result = caseModelElement(backCall);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.INJECTED_CONTEXT: {
            InjectedContext injectedContext = (InjectedContext) theEObject;
            T result = caseInjectedContext(injectedContext);
            if (result == null)
                result = caseModelElement(injectedContext);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.SUBSTITUTION: {
            Substitution substitution = (Substitution) theEObject;
            T result = caseSubstitution(substitution);
            if (result == null)
                result = caseNamedModelElement(substitution);
            if (result == null)
                result = caseModelElement(substitution);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.TYPE_PATTERN_EXECUTION_REPORTER: {
            TypePatternExecutionReporter typePatternExecutionReporter = (TypePatternExecutionReporter) theEObject;
            T result = caseTypePatternExecutionReporter(typePatternExecutionReporter);
            if (result == null)
                result = caseTypeAbstractClass(typePatternExecutionReporter);
            if (result == null)
                result = caseType(typePatternExecutionReporter);
            if (result == null)
                result = caseTypeElement(typePatternExecutionReporter);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.TYPE_PATTERN_CALL_BACK_HANDLER: {
            TypePatternCallBackHandler typePatternCallBackHandler = (TypePatternCallBackHandler) theEObject;
            T result = caseTypePatternCallBackHandler(typePatternCallBackHandler);
            if (result == null)
                result = caseTypeAbstractClass(typePatternCallBackHandler);
            if (result == null)
                result = caseType(typePatternCallBackHandler);
            if (result == null)
                result = caseTypeElement(typePatternCallBackHandler);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.TYPE_PATTERN_DOMAIN_VISITOR: {
            TypePatternDomainVisitor typePatternDomainVisitor = (TypePatternDomainVisitor) theEObject;
            T result = caseTypePatternDomainVisitor(typePatternDomainVisitor);
            if (result == null)
                result = caseTypeAbstractClass(typePatternDomainVisitor);
            if (result == null)
                result = caseType(typePatternDomainVisitor);
            if (result == null)
                result = caseTypeElement(typePatternDomainVisitor);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.TYPE_PATTERN_LIST: {
            TypePatternList typePatternList = (TypePatternList) theEObject;
            T result = caseTypePatternList(typePatternList);
            if (result == null)
                result = caseType(typePatternList);
            if (result == null)
                result = caseTypeElement(typePatternList);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.TYPE_PATTERN_SUBSTITUTION: {
            TypePatternSubstitution typePatternSubstitution = (TypePatternSubstitution) theEObject;
            T result = caseTypePatternSubstitution(typePatternSubstitution);
            if (result == null)
                result = caseType(typePatternSubstitution);
            if (result == null)
                result = caseTypeElement(typePatternSubstitution);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.TYPE_PATTERN_OUTPUT_PROCESSOR: {
            TypePatternOutputProcessor typePatternOutputProcessor = (TypePatternOutputProcessor) theEObject;
            T result = caseTypePatternOutputProcessor(typePatternOutputProcessor);
            if (result == null)
                result = caseTypeList(typePatternOutputProcessor);
            if (result == null)
                result = caseTypeAbstractClass(typePatternOutputProcessor);
            if (result == null)
                result = caseType(typePatternOutputProcessor);
            if (result == null)
                result = caseTypeElement(typePatternOutputProcessor);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Pattern</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Pattern</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePattern(Pattern object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Method</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Method</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternMethod(PatternMethod object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternParameter(PatternParameter object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Library</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Library</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternLibrary(PatternLibrary object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternElement(PatternElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternViewpoint(PatternViewpoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Nature</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Nature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternNature(PatternNature object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Call</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternCall(PatternCall object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Super Call</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Super Call</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSuperCall(SuperCall object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Paramerter2 Parameter Map</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Paramerter2 Parameter Map</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParamerter2ParameterMap(Map.Entry<InjectedContext, InjectedContext> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Call</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCall(Call object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Method Call</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Method Call</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMethodCall(MethodCall object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternVariable(PatternVariable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Pattern Call</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Pattern Call</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractPatternCall(AbstractPatternCall object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Injected Call</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Injected Call</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternInjectedCall(PatternInjectedCall object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Query</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Query</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseQuery(Query object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Basic Query</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Basic Query</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBasicQuery(BasicQuery object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>String Query</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>String Query</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStringQuery(StringQuery object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Custom Query</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Custom Query</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCustomQuery(CustomQuery object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>String2 Pattern List</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>String2 Pattern List</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseString2PatternList(Map.Entry<String, EList<PatternElement>> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>String2 String</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>String2 String</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseString2String(Map.Entry<String, String> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Pattern Execution Reporter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Pattern Execution Reporter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypePatternExecutionReporter(TypePatternExecutionReporter object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Back Call</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Back Call</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBackCall(BackCall object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Pattern Call Back Handler</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Pattern Call Back Handler</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypePatternCallBackHandler(TypePatternCallBackHandler object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Pattern Domain Visitor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Pattern Domain Visitor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypePatternDomainVisitor(TypePatternDomainVisitor object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Pattern List</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Pattern List</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypePatternList(TypePatternList object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Injected Context</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Injected Context</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInjectedContext(InjectedContext object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Pattern Substitution</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Pattern Substitution</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypePatternSubstitution(TypePatternSubstitution object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Pattern Output Processor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Pattern Output Processor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypePatternOutputProcessor(TypePatternOutputProcessor object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Substitution</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Substitution</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSubstitution(Substitution object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModelElement(ModelElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Model Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Model Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedModelElement(NamedModelElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseViewpoint(Viewpoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeElement(TypeElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseType(Type object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Abstract Class</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Abstract Class</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeAbstractClass(TypeAbstractClass object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type List</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type List</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeList(TypeList object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the
     * last
     * case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object) {
        return null;
    }

} // PatternSwitch
