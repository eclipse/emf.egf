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
package org.eclipse.egf.model.pattern.impl;

import java.util.Map;

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.AbstractPatternCall;
import org.eclipse.egf.model.pattern.BackCall;
import org.eclipse.egf.model.pattern.BasicQuery;
import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.CustomQuery;
import org.eclipse.egf.model.pattern.InjectedContext;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternFactory;
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
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.model.pattern.SuperCall;
import org.eclipse.egf.model.pattern.TypePatternCallBackHandler;
import org.eclipse.egf.model.pattern.TypePatternDomainVisitor;
import org.eclipse.egf.model.pattern.TypePatternExecutionReporter;
import org.eclipse.egf.model.pattern.TypePatternList;
import org.eclipse.egf.model.pattern.TypePatternOutputProcessor;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.egf.model.pattern.util.PatternValidator;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class PatternPackageImpl extends EPackageImpl implements PatternPackage {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass patternEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass patternMethodEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass patternParameterEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass patternLibraryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass patternElementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass patternViewpointEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass patternNatureEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass patternCallEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass superCallEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass paramerter2ParameterMapEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass callEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass methodCallEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass patternVariableEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractPatternCallEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass patternInjectedCallEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass queryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass basicQueryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass stringQueryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass customQueryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass string2PatternListEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass string2StringEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typePatternExecutionReporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass backCallEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typePatternCallBackHandlerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typePatternDomainVisitorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typePatternListEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass injectedContextEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typePatternSubstitutionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typePatternOutputProcessorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass substitutionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EDataType patternContextEDataType = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EDataType patternExceptionEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.egf.model.pattern.PatternPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private PatternPackageImpl() {
        super(eNS_URI, PatternFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * 
     * <p>
     * This method is used to initialize {@link PatternPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static PatternPackage init() {
        if (isInited)
            return (PatternPackage) EPackage.Registry.INSTANCE.getEPackage(PatternPackage.eNS_URI);

        // Obtain or create and register package
        PatternPackageImpl thePatternPackage = (PatternPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PatternPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PatternPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        FcorePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        thePatternPackage.createPackageContents();

        // Initialize created meta-data
        thePatternPackage.initializePackageContents();

        // Register package validator
        EValidator.Registry.INSTANCE.put(thePatternPackage, new EValidator.Descriptor() {
            public EValidator getEValidator() {
                return PatternValidator.INSTANCE;
            }
        });

        // Mark meta-data to indicate it can't be changed
        thePatternPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(PatternPackage.eNS_URI, thePatternPackage);
        return thePatternPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getPattern() {
        return patternEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPattern_HeaderMethod() {
        return (EReference) patternEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPattern_Methods() {
        return (EReference) patternEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPattern_SuperPattern() {
        return (EReference) patternEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPattern_FooterMethod() {
        return (EReference) patternEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPattern_Orchestration() {
        return (EReference) patternEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPattern_Parameters() {
        return (EReference) patternEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPattern_Nature() {
        return (EReference) patternEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPattern_Container() {
        return (EReference) patternEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPattern_Variables() {
        return (EReference) patternEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPattern_InitMethod() {
        return (EReference) patternEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPattern_ConditionMethod() {
        return (EReference) patternEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getPatternMethod() {
        return patternMethodEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPatternMethod_Pattern() {
        return (EReference) patternMethodEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPatternMethod_PatternFilePath() {
        return (EAttribute) patternMethodEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getPatternParameter() {
        return patternParameterEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPatternParameter_Type() {
        return (EAttribute) patternParameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPatternParameter_Query() {
        return (EReference) patternParameterEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getPatternLibrary() {
        return patternLibraryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPatternLibrary_PatternViewpoint() {
        return (EReference) patternLibraryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPatternLibrary_Elements() {
        return (EReference) patternLibraryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPatternLibrary_Filters() {
        return (EReference) patternLibraryEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getPatternElement() {
        return patternElementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getPatternViewpoint() {
        return patternViewpointEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPatternViewpoint_Libraries() {
        return (EReference) patternViewpointEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getPatternNature() {
        return patternNatureEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getPatternCall() {
        return patternCallEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPatternCall_ParameterMatching() {
        return (EReference) patternCallEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSuperCall() {
        return superCallEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getParamerter2ParameterMap() {
        return paramerter2ParameterMapEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getParamerter2ParameterMap_Key() {
        return (EReference) paramerter2ParameterMapEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getCall() {
        return callEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getCall_Pattern() {
        return (EReference) callEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getMethodCall() {
        return methodCallEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getMethodCall_Called() {
        return (EReference) methodCallEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getPatternVariable() {
        return patternVariableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPatternVariable_Type() {
        return (EAttribute) patternVariableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getAbstractPatternCall() {
        return abstractPatternCallEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractPatternCall_Called() {
        return (EReference) abstractPatternCallEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getPatternInjectedCall() {
        return patternInjectedCallEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getPatternInjectedCall_Context() {
        return (EReference) patternInjectedCallEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getQuery() {
        return queryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getQuery_Parameter() {
        return (EReference) queryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getQuery_ExtensionId() {
        return (EAttribute) queryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getQuery_QueryContext() {
        return (EReference) queryEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getBasicQuery() {
        return basicQueryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getStringQuery() {
        return stringQueryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getCustomQuery() {
        return customQueryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getString2PatternList() {
        return string2PatternListEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getString2PatternList_Key() {
        return (EAttribute) string2PatternListEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getString2PatternList_Value() {
        return (EReference) string2PatternListEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getString2String() {
        return string2StringEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getString2String_Key() {
        return (EAttribute) string2StringEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getString2String_Value() {
        return (EAttribute) string2StringEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypePatternExecutionReporter() {
        return typePatternExecutionReporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBackCall() {
        return backCallEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypePatternCallBackHandler() {
        return typePatternCallBackHandlerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypePatternDomainVisitor() {
        return typePatternDomainVisitorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypePatternList() {
        return typePatternListEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTypePatternList_Elements() {
        return (EReference) typePatternListEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInjectedContext() {
        return injectedContextEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypePatternSubstitution() {
        return typePatternSubstitutionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTypePatternSubstitution_Substitutions() {
        return (EReference) typePatternSubstitutionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypePatternOutputProcessor() {
        return typePatternOutputProcessorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSubstitution() {
        return substitutionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSubstitution_ReplacedElement() {
        return (EReference) substitutionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSubstitution_Replacement() {
        return (EReference) substitutionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getParamerter2ParameterMap_Value() {
        return (EReference) paramerter2ParameterMapEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EDataType getPatternContext() {
        return patternContextEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EDataType getPatternException() {
        return patternExceptionEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public PatternFactory getPatternFactory() {
        return (PatternFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        patternNatureEClass = createEClass(PATTERN_NATURE);

        patternElementEClass = createEClass(PATTERN_ELEMENT);

        patternLibraryEClass = createEClass(PATTERN_LIBRARY);
        createEReference(patternLibraryEClass, PATTERN_LIBRARY__PATTERN_VIEWPOINT);
        createEReference(patternLibraryEClass, PATTERN_LIBRARY__ELEMENTS);
        createEReference(patternLibraryEClass, PATTERN_LIBRARY__FILTERS);

        patternEClass = createEClass(PATTERN);
        createEReference(patternEClass, PATTERN__NATURE);
        createEReference(patternEClass, PATTERN__CONTAINER);
        createEReference(patternEClass, PATTERN__SUPER_PATTERN);
        createEReference(patternEClass, PATTERN__HEADER_METHOD);
        createEReference(patternEClass, PATTERN__CONDITION_METHOD);
        createEReference(patternEClass, PATTERN__INIT_METHOD);
        createEReference(patternEClass, PATTERN__FOOTER_METHOD);
        createEReference(patternEClass, PATTERN__METHODS);
        createEReference(patternEClass, PATTERN__PARAMETERS);
        createEReference(patternEClass, PATTERN__VARIABLES);
        createEReference(patternEClass, PATTERN__ORCHESTRATION);

        patternMethodEClass = createEClass(PATTERN_METHOD);
        createEReference(patternMethodEClass, PATTERN_METHOD__PATTERN);
        createEAttribute(patternMethodEClass, PATTERN_METHOD__PATTERN_FILE_PATH);

        patternParameterEClass = createEClass(PATTERN_PARAMETER);
        createEAttribute(patternParameterEClass, PATTERN_PARAMETER__TYPE);
        createEReference(patternParameterEClass, PATTERN_PARAMETER__QUERY);

        patternViewpointEClass = createEClass(PATTERN_VIEWPOINT);
        createEReference(patternViewpointEClass, PATTERN_VIEWPOINT__LIBRARIES);

        patternCallEClass = createEClass(PATTERN_CALL);
        createEReference(patternCallEClass, PATTERN_CALL__PARAMETER_MATCHING);

        superCallEClass = createEClass(SUPER_CALL);

        paramerter2ParameterMapEClass = createEClass(PARAMERTER2_PARAMETER_MAP);
        createEReference(paramerter2ParameterMapEClass, PARAMERTER2_PARAMETER_MAP__VALUE);
        createEReference(paramerter2ParameterMapEClass, PARAMERTER2_PARAMETER_MAP__KEY);

        callEClass = createEClass(CALL);
        createEReference(callEClass, CALL__PATTERN);

        methodCallEClass = createEClass(METHOD_CALL);
        createEReference(methodCallEClass, METHOD_CALL__CALLED);

        patternVariableEClass = createEClass(PATTERN_VARIABLE);
        createEAttribute(patternVariableEClass, PATTERN_VARIABLE__TYPE);

        abstractPatternCallEClass = createEClass(ABSTRACT_PATTERN_CALL);
        createEReference(abstractPatternCallEClass, ABSTRACT_PATTERN_CALL__CALLED);

        patternInjectedCallEClass = createEClass(PATTERN_INJECTED_CALL);
        createEReference(patternInjectedCallEClass, PATTERN_INJECTED_CALL__CONTEXT);

        queryEClass = createEClass(QUERY);
        createEReference(queryEClass, QUERY__PARAMETER);
        createEAttribute(queryEClass, QUERY__EXTENSION_ID);
        createEReference(queryEClass, QUERY__QUERY_CONTEXT);

        basicQueryEClass = createEClass(BASIC_QUERY);

        stringQueryEClass = createEClass(STRING_QUERY);

        customQueryEClass = createEClass(CUSTOM_QUERY);

        string2PatternListEClass = createEClass(STRING2_PATTERN_LIST);
        createEAttribute(string2PatternListEClass, STRING2_PATTERN_LIST__KEY);
        createEReference(string2PatternListEClass, STRING2_PATTERN_LIST__VALUE);

        string2StringEClass = createEClass(STRING2_STRING);
        createEAttribute(string2StringEClass, STRING2_STRING__KEY);
        createEAttribute(string2StringEClass, STRING2_STRING__VALUE);

        backCallEClass = createEClass(BACK_CALL);

        injectedContextEClass = createEClass(INJECTED_CONTEXT);

        substitutionEClass = createEClass(SUBSTITUTION);
        createEReference(substitutionEClass, SUBSTITUTION__REPLACED_ELEMENT);
        createEReference(substitutionEClass, SUBSTITUTION__REPLACEMENT);

        typePatternExecutionReporterEClass = createEClass(TYPE_PATTERN_EXECUTION_REPORTER);

        typePatternCallBackHandlerEClass = createEClass(TYPE_PATTERN_CALL_BACK_HANDLER);

        typePatternDomainVisitorEClass = createEClass(TYPE_PATTERN_DOMAIN_VISITOR);

        typePatternListEClass = createEClass(TYPE_PATTERN_LIST);
        createEReference(typePatternListEClass, TYPE_PATTERN_LIST__ELEMENTS);

        typePatternSubstitutionEClass = createEClass(TYPE_PATTERN_SUBSTITUTION);
        createEReference(typePatternSubstitutionEClass, TYPE_PATTERN_SUBSTITUTION__SUBSTITUTIONS);

        typePatternOutputProcessorEClass = createEClass(TYPE_PATTERN_OUTPUT_PROCESSOR);

        // Create data types
        patternContextEDataType = createEDataType(PATTERN_CONTEXT);
        patternExceptionEDataType = createEDataType(PATTERN_EXCEPTION);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        FcorePackage theFcorePackage = (FcorePackage) EPackage.Registry.INSTANCE.getEPackage(FcorePackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
        TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        patternNatureEClass.getESuperTypes().add(theFcorePackage.getNamedModelElement());
        patternElementEClass.getESuperTypes().add(theFcorePackage.getNamedModelElement());
        patternLibraryEClass.getESuperTypes().add(this.getPatternElement());
        patternEClass.getESuperTypes().add(this.getPatternElement());
        patternMethodEClass.getESuperTypes().add(theFcorePackage.getNamedModelElement());
        patternParameterEClass.getESuperTypes().add(theFcorePackage.getNamedModelElement());
        patternParameterEClass.getESuperTypes().add(this.getInjectedContext());
        patternViewpointEClass.getESuperTypes().add(theFcorePackage.getViewpoint());
        patternCallEClass.getESuperTypes().add(this.getAbstractPatternCall());
        superCallEClass.getESuperTypes().add(this.getCall());
        paramerter2ParameterMapEClass.getESuperTypes().add(theFcorePackage.getModelElement());
        callEClass.getESuperTypes().add(theFcorePackage.getModelElement());
        methodCallEClass.getESuperTypes().add(this.getCall());
        patternVariableEClass.getESuperTypes().add(theFcorePackage.getNamedModelElement());
        patternVariableEClass.getESuperTypes().add(this.getInjectedContext());
        abstractPatternCallEClass.getESuperTypes().add(this.getCall());
        patternInjectedCallEClass.getESuperTypes().add(this.getAbstractPatternCall());
        queryEClass.getESuperTypes().add(theFcorePackage.getModelElement());
        basicQueryEClass.getESuperTypes().add(this.getQuery());
        stringQueryEClass.getESuperTypes().add(this.getQuery());
        customQueryEClass.getESuperTypes().add(this.getQuery());
        string2PatternListEClass.getESuperTypes().add(theFcorePackage.getModelElement());
        string2StringEClass.getESuperTypes().add(theFcorePackage.getModelElement());
        backCallEClass.getESuperTypes().add(this.getCall());
        injectedContextEClass.getESuperTypes().add(theFcorePackage.getModelElement());
        substitutionEClass.getESuperTypes().add(theFcorePackage.getNamedModelElement());
        typePatternExecutionReporterEClass.getESuperTypes().add(theTypesPackage.getTypeAbstractClass());
        typePatternCallBackHandlerEClass.getESuperTypes().add(theTypesPackage.getTypeAbstractClass());
        typePatternDomainVisitorEClass.getESuperTypes().add(theTypesPackage.getTypeAbstractClass());
        typePatternListEClass.getESuperTypes().add(theTypesPackage.getType());
        typePatternSubstitutionEClass.getESuperTypes().add(theTypesPackage.getType());
        typePatternOutputProcessorEClass.getESuperTypes().add(theTypesPackage.getTypeList());

        // Initialize classes and features; add operations and parameters
        initEClass(patternNatureEClass, PatternNature.class, "PatternNature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(patternElementEClass, PatternElement.class, "PatternElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(patternLibraryEClass, PatternLibrary.class, "PatternLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getPatternLibrary_PatternViewpoint(), this.getPatternViewpoint(), this.getPatternViewpoint_Libraries(), "patternViewpoint", null, 0, 1, PatternLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPatternLibrary_Elements(), this.getPattern(), this.getPattern_Container(), "elements", null, 0, -1, PatternLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPatternLibrary_Filters(), this.getString2PatternList(), null, "filters", null, 0, -1, PatternLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getPattern_Nature(), this.getPatternNature(), null, "nature", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPattern_Container(), this.getPatternLibrary(), this.getPatternLibrary_Elements(), "container", null, 0, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPattern_SuperPattern(), this.getPattern(), null, "superPattern", null, 0, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPattern_HeaderMethod(), this.getPatternMethod(), null, "headerMethod", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPattern_ConditionMethod(), this.getPatternMethod(), null, "conditionMethod", null, 0, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPattern_InitMethod(), this.getPatternMethod(), null, "initMethod", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPattern_FooterMethod(), this.getPatternMethod(), null, "footerMethod", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPattern_Methods(), this.getPatternMethod(), this.getPatternMethod_Pattern(), "methods", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPattern_Parameters(), this.getPatternParameter(), null, "parameters", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPattern_Variables(), this.getPatternVariable(), null, "variables", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPattern_Orchestration(), this.getCall(), this.getCall_Pattern(), "orchestration", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        addEOperation(patternEClass, this.getPatternParameter(), "getAllParameters", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        addEOperation(patternEClass, this.getPatternVariable(), "getAllVariables", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        addEOperation(patternEClass, this.getPatternMethod(), "getAllMethods", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        EOperation op = addEOperation(patternEClass, this.getPatternMethod(), "getMethod", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(patternEClass, this.getPatternParameter(), "getParameter", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(patternMethodEClass, PatternMethod.class, "PatternMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getPatternMethod_Pattern(), this.getPattern(), this.getPattern_Methods(), "pattern", null, 1, 1, PatternMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getPatternMethod_PatternFilePath(), theTypesPackage.getURI(), "patternFilePath", null, 1, 1, PatternMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(patternParameterEClass, PatternParameter.class, "PatternParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getPatternParameter_Type(), ecorePackage.getEString(), "type", null, 1, 1, PatternParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPatternParameter_Query(), this.getQuery(), this.getQuery_Parameter(), "query", null, 0, 1, PatternParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(patternViewpointEClass, PatternViewpoint.class, "PatternViewpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getPatternViewpoint_Libraries(), this.getPatternLibrary(), this.getPatternLibrary_PatternViewpoint(), "libraries", null, 0, -1, PatternViewpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(patternCallEClass, PatternCall.class, "PatternCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getPatternCall_ParameterMatching(), this.getParamerter2ParameterMap(), null, "parameterMatching", null, 0, -1, PatternCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(superCallEClass, SuperCall.class, "SuperCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(paramerter2ParameterMapEClass, Map.Entry.class, "Paramerter2ParameterMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getParamerter2ParameterMap_Value(), this.getInjectedContext(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getParamerter2ParameterMap_Key(), this.getInjectedContext(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(callEClass, Call.class, "Call", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getCall_Pattern(), this.getPattern(), this.getPattern_Orchestration(), "pattern", null, 1, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(methodCallEClass, MethodCall.class, "MethodCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMethodCall_Called(), this.getPatternMethod(), null, "called", null, 1, 1, MethodCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(patternVariableEClass, PatternVariable.class, "PatternVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getPatternVariable_Type(), ecorePackage.getEString(), "type", null, 1, 1, PatternVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(abstractPatternCallEClass, AbstractPatternCall.class, "AbstractPatternCall", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getAbstractPatternCall_Called(), this.getPattern(), null, "called", null, 1, 1, AbstractPatternCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(patternInjectedCallEClass, PatternInjectedCall.class, "PatternInjectedCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getPatternInjectedCall_Context(), this.getInjectedContext(), null, "context", null, 1, 1, PatternInjectedCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(queryEClass, Query.class, "Query", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getQuery_Parameter(), this.getPatternParameter(), this.getPatternParameter_Query(), "parameter", null, 1, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getQuery_ExtensionId(), theEcorePackage.getEString(), "extensionId", null, 1, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getQuery_QueryContext(), this.getString2String(), null, "queryContext", null, 0, -1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(basicQueryEClass, BasicQuery.class, "BasicQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(stringQueryEClass, StringQuery.class, "StringQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(customQueryEClass, CustomQuery.class, "CustomQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(string2PatternListEClass, Map.Entry.class, "String2PatternList", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getString2PatternList_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getString2PatternList_Value(), this.getPatternElement(), null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(string2StringEClass, Map.Entry.class, "String2String", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getString2String_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getString2String_Value(), ecorePackage.getEString(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(backCallEClass, BackCall.class, "BackCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(injectedContextEClass, InjectedContext.class, "InjectedContext", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        addEOperation(injectedContextEClass, theEcorePackage.getEString(), "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        addEOperation(injectedContextEClass, ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        addEOperation(injectedContextEClass, this.getPattern(), "getPattern", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(substitutionEClass, Substitution.class, "Substitution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getSubstitution_ReplacedElement(), this.getPattern(), null, "replacedElement", null, 0, 1, Substitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSubstitution_Replacement(), this.getPattern(), null, "replacement", null, 0, -1, Substitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typePatternExecutionReporterEClass, TypePatternExecutionReporter.class, "TypePatternExecutionReporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        op = addEOperation(typePatternExecutionReporterEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        ETypeParameter t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        EGenericType g1 = createEGenericType(theEcorePackage.getEJavaObject());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        EGenericType g2 = createEGenericType(t1);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(typePatternCallBackHandlerEClass, TypePatternCallBackHandler.class, "TypePatternCallBackHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        op = addEOperation(typePatternCallBackHandlerEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEJavaObject());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        g2 = createEGenericType(t1);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(typePatternDomainVisitorEClass, TypePatternDomainVisitor.class, "TypePatternDomainVisitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        op = addEOperation(typePatternDomainVisitorEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEJavaObject());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        g2 = createEGenericType(t1);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(typePatternListEClass, TypePatternList.class, "TypePatternList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTypePatternList_Elements(), this.getPatternElement(), null, "elements", null, 0, -1, TypePatternList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(typePatternListEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEJavaObject());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        g2 = createEGenericType(t1);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(typePatternSubstitutionEClass, TypePatternSubstitution.class, "TypePatternSubstitution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTypePatternSubstitution_Substitutions(), this.getSubstitution(), null, "substitutions", null, 0, -1, TypePatternSubstitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(typePatternSubstitutionEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEJavaObject());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        g2 = createEGenericType(t1);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(typePatternOutputProcessorEClass, TypePatternOutputProcessor.class, "TypePatternOutputProcessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        op = addEOperation(typePatternOutputProcessorEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEJavaObject());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        g2 = createEGenericType(t1);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        // Initialize data types
        initEDataType(patternContextEDataType, PatternContext.class, "PatternContext", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEDataType(patternExceptionEDataType, PatternException.class, "PatternException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.eclipse.org/emf/2002/Ecore
        createEcoreAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createEcoreAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$		
        addAnnotation(patternNatureEClass, source, new String[] { "constraints", "MandatoryName" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(patternElementEClass, source, new String[] { "constraints", "MandatoryName" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(patternEClass, source, new String[] { "constraints", "UniqueName HeaderMethod FooterMethod" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(patternMethodEClass, source, new String[] { "constraints", "MandatoryName ValidURI ValidPatternFilePath" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(patternParameterEClass, source, new String[] { "constraints", "MandatoryName" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(patternVariableEClass, source, new String[] { "constraints", "MandatoryName" //$NON-NLS-1$ //$NON-NLS-2$
        });
    }

} // PatternPackageImpl
