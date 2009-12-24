/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.pattern;

import org.eclipse.egf.model.factorycomponent.FactoryComponentPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.pattern.PatternFactory
 * @model kind="package"
 * @generated
 */
public interface PatternPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "pattern"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/egf/1.0.0/pattern"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "pattern"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    PatternPackage eINSTANCE = org.eclipse.egf.model.pattern.impl.PatternPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternElementImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternElement()
     * @generated
     */
    int PATTERN_ELEMENT = 5;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ELEMENT__ID = FactoryComponentPackage.MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ELEMENT__NAME = FactoryComponentPackage.MODEL_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ELEMENT__DESCRIPTION = FactoryComponentPackage.MODEL_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ELEMENT__CONTAINER = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ELEMENT_FEATURE_COUNT = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternImpl <em>Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPattern()
     * @generated
     */
    int PATTERN = 0;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__ID = PATTERN_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__NAME = PATTERN_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__DESCRIPTION = PATTERN_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__CONTAINER = PATTERN_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Header Method</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__HEADER_METHOD = PATTERN_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Methods</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__METHODS = PATTERN_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Footer Method</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__FOOTER_METHOD = PATTERN_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Super Pattern</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__SUPER_PATTERN = PATTERN_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Orchestration</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__ORCHESTRATION = PATTERN_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__PARAMETERS = PATTERN_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Nature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__NATURE = PATTERN_ELEMENT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Variables</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__VARIABLES = PATTERN_ELEMENT_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Init Method</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__INIT_METHOD = PATTERN_ELEMENT_FEATURE_COUNT + 8;

    /**
     * The number of structural features of the '<em>Pattern</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_FEATURE_COUNT = PATTERN_ELEMENT_FEATURE_COUNT + 9;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternMethodImpl <em>Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternMethodImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternMethod()
     * @generated
     */
    int PATTERN_METHOD = 1;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_METHOD__ID = FactoryComponentPackage.MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_METHOD__NAME = FactoryComponentPackage.MODEL_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_METHOD__DESCRIPTION = FactoryComponentPackage.MODEL_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_METHOD__PATTERN = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Pattern File Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_METHOD__PATTERN_FILE_PATH = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Method</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_METHOD_FEATURE_COUNT = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternParameterImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternParameter()
     * @generated
     */
    int PATTERN_PARAMETER = 2;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PARAMETER__ID = FactoryComponentPackage.MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PARAMETER__NAME = FactoryComponentPackage.MODEL_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PARAMETER__DESCRIPTION = FactoryComponentPackage.MODEL_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PARAMETER__TYPE = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Parameter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PARAMETER_FEATURE_COUNT = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternEngineImpl <em>Engine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternEngineImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternEngine()
     * @generated
     */
    int PATTERN_ENGINE = 3;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ENGINE__ID = FactoryComponentPackage.MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ENGINE__NAME = FactoryComponentPackage.MODEL_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ENGINE__DESCRIPTION = FactoryComponentPackage.MODEL_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ENGINE__PATTERN = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Engine</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ENGINE_FEATURE_COUNT = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternLibraryImpl <em>Library</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternLibraryImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternLibrary()
     * @generated
     */
    int PATTERN_LIBRARY = 4;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_LIBRARY__ID = PATTERN_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_LIBRARY__NAME = PATTERN_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_LIBRARY__DESCRIPTION = PATTERN_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_LIBRARY__CONTAINER = PATTERN_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_LIBRARY__ELEMENTS = PATTERN_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Runtime Orchestration</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_LIBRARY__RUNTIME_ORCHESTRATION = PATTERN_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Library</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_LIBRARY_FEATURE_COUNT = PATTERN_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternViewpointImpl <em>Viewpoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternViewpointImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternViewpoint()
     * @generated
     */
    int PATTERN_VIEWPOINT = 6;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VIEWPOINT__ID = FactoryComponentPackage.VIEWPOINT__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VIEWPOINT__NAME = FactoryComponentPackage.VIEWPOINT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VIEWPOINT__DESCRIPTION = FactoryComponentPackage.VIEWPOINT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Viewerpoint Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VIEWPOINT__VIEWERPOINT_CONTAINER = FactoryComponentPackage.VIEWPOINT__VIEWERPOINT_CONTAINER;

    /**
     * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VIEWPOINT__LIBRARIES = FactoryComponentPackage.VIEWPOINT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Viewpoint</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VIEWPOINT_FEATURE_COUNT = FactoryComponentPackage.VIEWPOINT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternNatureImpl <em>Nature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternNatureImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternNature()
     * @generated
     */
    int PATTERN_NATURE = 7;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_NATURE__ID = FactoryComponentPackage.MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_NATURE__NAME = FactoryComponentPackage.MODEL_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_NATURE__DESCRIPTION = FactoryComponentPackage.MODEL_ELEMENT__DESCRIPTION;

    /**
     * The number of structural features of the '<em>Nature</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_NATURE_FEATURE_COUNT = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.CallImpl <em>Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.CallImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getCall()
     * @generated
     */
    int CALL = 10;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL__PATTERN = 0;

    /**
     * The number of structural features of the '<em>Call</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternCallImpl <em>Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternCallImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternCall()
     * @generated
     */
    int PATTERN_CALL = 8;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_CALL__PATTERN = CALL__PATTERN;

    /**
     * The feature id for the '<em><b>Parameter Matching</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_CALL__PARAMETER_MATCHING = CALL_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Called</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_CALL__CALLED = CALL_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Call</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_CALL_FEATURE_COUNT = CALL_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.Paramerter2ParameterMapImpl <em>Paramerter2 Parameter Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.Paramerter2ParameterMapImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getParamerter2ParameterMap()
     * @generated
     */
    int PARAMERTER2_PARAMETER_MAP = 9;

    /**
     * The feature id for the '<em><b>Value</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMERTER2_PARAMETER_MAP__VALUE = 0;

    /**
     * The feature id for the '<em><b>Key</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMERTER2_PARAMETER_MAP__KEY = 1;

    /**
     * The number of structural features of the '<em>Paramerter2 Parameter Map</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMERTER2_PARAMETER_MAP_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.MethodCallImpl <em>Method Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.MethodCallImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getMethodCall()
     * @generated
     */
    int METHOD_CALL = 11;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METHOD_CALL__PATTERN = CALL__PATTERN;

    /**
     * The feature id for the '<em><b>Called</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METHOD_CALL__CALLED = CALL_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Method Call</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METHOD_CALL_FEATURE_COUNT = CALL_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternVariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternVariableImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternVariable()
     * @generated
     */
    int PATTERN_VARIABLE = 12;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VARIABLE__ID = FactoryComponentPackage.MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VARIABLE__NAME = FactoryComponentPackage.MODEL_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VARIABLE__DESCRIPTION = FactoryComponentPackage.MODEL_ELEMENT__DESCRIPTION;

    /**
     * The number of structural features of the '<em>Variable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VARIABLE_FEATURE_COUNT = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '<em>Context</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.PatternContext
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternContext()
     * @generated
     */
    int PATTERN_CONTEXT = 13;

    /**
     * The meta object id for the '<em>Exception</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.PatternException
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternException()
     * @generated
     */
    int PATTERN_EXCEPTION = 14;

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.Pattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Pattern</em>'.
     * @see org.eclipse.egf.model.pattern.Pattern
     * @generated
     */
    EClass getPattern();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.pattern.Pattern#getHeaderMethod <em>Header Method</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Header Method</em>'.
     * @see org.eclipse.egf.model.pattern.Pattern#getHeaderMethod()
     * @see #getPattern()
     * @generated
     */
    EReference getPattern_HeaderMethod();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.pattern.Pattern#getMethods <em>Methods</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Methods</em>'.
     * @see org.eclipse.egf.model.pattern.Pattern#getMethods()
     * @see #getPattern()
     * @generated
     */
    EReference getPattern_Methods();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.pattern.Pattern#getSuperPattern <em>Super Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Super Pattern</em>'.
     * @see org.eclipse.egf.model.pattern.Pattern#getSuperPattern()
     * @see #getPattern()
     * @generated
     */
    EReference getPattern_SuperPattern();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.pattern.Pattern#getFooterMethod <em>Footer Method</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Footer Method</em>'.
     * @see org.eclipse.egf.model.pattern.Pattern#getFooterMethod()
     * @see #getPattern()
     * @generated
     */
    EReference getPattern_FooterMethod();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.pattern.Pattern#getOrchestration <em>Orchestration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Orchestration</em>'.
     * @see org.eclipse.egf.model.pattern.Pattern#getOrchestration()
     * @see #getPattern()
     * @generated
     */
    EReference getPattern_Orchestration();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.pattern.Pattern#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parameters</em>'.
     * @see org.eclipse.egf.model.pattern.Pattern#getParameters()
     * @see #getPattern()
     * @generated
     */
    EReference getPattern_Parameters();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.pattern.Pattern#getNature <em>Nature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Nature</em>'.
     * @see org.eclipse.egf.model.pattern.Pattern#getNature()
     * @see #getPattern()
     * @generated
     */
    EReference getPattern_Nature();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.pattern.Pattern#getVariables <em>Variables</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Variables</em>'.
     * @see org.eclipse.egf.model.pattern.Pattern#getVariables()
     * @see #getPattern()
     * @generated
     */
    EReference getPattern_Variables();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.pattern.Pattern#getInitMethod <em>Init Method</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Init Method</em>'.
     * @see org.eclipse.egf.model.pattern.Pattern#getInitMethod()
     * @see #getPattern()
     * @generated
     */
    EReference getPattern_InitMethod();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternMethod <em>Method</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Method</em>'.
     * @see org.eclipse.egf.model.pattern.PatternMethod
     * @generated
     */
    EClass getPatternMethod();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.egf.model.pattern.PatternMethod#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Pattern</em>'.
     * @see org.eclipse.egf.model.pattern.PatternMethod#getPattern()
     * @see #getPatternMethod()
     * @generated
     */
    EReference getPatternMethod_Pattern();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.pattern.PatternMethod#getPatternFilePath <em>Pattern File Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pattern File Path</em>'.
     * @see org.eclipse.egf.model.pattern.PatternMethod#getPatternFilePath()
     * @see #getPatternMethod()
     * @generated
     */
    EAttribute getPatternMethod_PatternFilePath();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Parameter</em>'.
     * @see org.eclipse.egf.model.pattern.PatternParameter
     * @generated
     */
    EClass getPatternParameter();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.pattern.PatternParameter#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.egf.model.pattern.PatternParameter#getType()
     * @see #getPatternParameter()
     * @generated
     */
    EAttribute getPatternParameter_Type();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternEngine <em>Engine</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Engine</em>'.
     * @see org.eclipse.egf.model.pattern.PatternEngine
     * @generated
     */
    EClass getPatternEngine();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.pattern.PatternEngine#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Pattern</em>'.
     * @see org.eclipse.egf.model.pattern.PatternEngine#getPattern()
     * @see #getPatternEngine()
     * @generated
     */
    EReference getPatternEngine_Pattern();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternLibrary <em>Library</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Library</em>'.
     * @see org.eclipse.egf.model.pattern.PatternLibrary
     * @generated
     */
    EClass getPatternLibrary();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.pattern.PatternLibrary#getElements <em>Elements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Elements</em>'.
     * @see org.eclipse.egf.model.pattern.PatternLibrary#getElements()
     * @see #getPatternLibrary()
     * @generated
     */
    EReference getPatternLibrary_Elements();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.egf.model.pattern.PatternLibrary#getRuntimeOrchestration <em>Runtime Orchestration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Runtime Orchestration</em>'.
     * @see org.eclipse.egf.model.pattern.PatternLibrary#getRuntimeOrchestration()
     * @see #getPatternLibrary()
     * @generated
     */
    EReference getPatternLibrary_RuntimeOrchestration();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternElement <em>Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Element</em>'.
     * @see org.eclipse.egf.model.pattern.PatternElement
     * @generated
     */
    EClass getPatternElement();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.egf.model.pattern.PatternElement#getContainer <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Container</em>'.
     * @see org.eclipse.egf.model.pattern.PatternElement#getContainer()
     * @see #getPatternElement()
     * @generated
     */
    EReference getPatternElement_Container();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternViewpoint <em>Viewpoint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Viewpoint</em>'.
     * @see org.eclipse.egf.model.pattern.PatternViewpoint
     * @generated
     */
    EClass getPatternViewpoint();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.pattern.PatternViewpoint#getLibraries <em>Libraries</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Libraries</em>'.
     * @see org.eclipse.egf.model.pattern.PatternViewpoint#getLibraries()
     * @see #getPatternViewpoint()
     * @generated
     */
    EReference getPatternViewpoint_Libraries();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternNature <em>Nature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Nature</em>'.
     * @see org.eclipse.egf.model.pattern.PatternNature
     * @generated
     */
    EClass getPatternNature();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternCall <em>Call</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Call</em>'.
     * @see org.eclipse.egf.model.pattern.PatternCall
     * @generated
     */
    EClass getPatternCall();

    /**
     * Returns the meta object for the map '{@link org.eclipse.egf.model.pattern.PatternCall#getParameterMatching <em>Parameter Matching</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Parameter Matching</em>'.
     * @see org.eclipse.egf.model.pattern.PatternCall#getParameterMatching()
     * @see #getPatternCall()
     * @generated
     */
    EReference getPatternCall_ParameterMatching();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.pattern.PatternCall#getCalled <em>Called</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Called</em>'.
     * @see org.eclipse.egf.model.pattern.PatternCall#getCalled()
     * @see #getPatternCall()
     * @generated
     */
    EReference getPatternCall_Called();

    /**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>Paramerter2 Parameter Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Paramerter2 Parameter Map</em>'.
     * @see java.util.Map.Entry
     * @model features="value key" 
     *        valueType="org.eclipse.egf.model.pattern.PatternParameter"
     *        keyType="org.eclipse.egf.model.pattern.PatternParameter" keyResolveProxies="false"
     * @generated
     */
    EClass getParamerter2ParameterMap();

    /**
     * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getParamerter2ParameterMap()
     * @generated
     */
    EReference getParamerter2ParameterMap_Key();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.Call <em>Call</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Call</em>'.
     * @see org.eclipse.egf.model.pattern.Call
     * @generated
     */
    EClass getCall();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.egf.model.pattern.Call#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Pattern</em>'.
     * @see org.eclipse.egf.model.pattern.Call#getPattern()
     * @see #getCall()
     * @generated
     */
    EReference getCall_Pattern();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.MethodCall <em>Method Call</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Method Call</em>'.
     * @see org.eclipse.egf.model.pattern.MethodCall
     * @generated
     */
    EClass getMethodCall();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.pattern.MethodCall#getCalled <em>Called</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Called</em>'.
     * @see org.eclipse.egf.model.pattern.MethodCall#getCalled()
     * @see #getMethodCall()
     * @generated
     */
    EReference getMethodCall_Called();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternVariable <em>Variable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variable</em>'.
     * @see org.eclipse.egf.model.pattern.PatternVariable
     * @generated
     */
    EClass getPatternVariable();

    /**
     * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getParamerter2ParameterMap()
     * @generated
     */
    EReference getParamerter2ParameterMap_Value();

    /**
     * Returns the meta object for data type '{@link org.eclipse.egf.model.PatternContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Context</em>'.
     * @see org.eclipse.egf.model.PatternContext
     * @model instanceClass="org.eclipse.egf.model.PatternContext"
     * @generated
     */
    EDataType getPatternContext();

    /**
     * Returns the meta object for data type '{@link org.eclipse.egf.model.PatternException <em>Exception</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Exception</em>'.
     * @see org.eclipse.egf.model.PatternException
     * @model instanceClass="org.eclipse.egf.model.PatternException"
     * @generated
     */
    EDataType getPatternException();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    PatternFactory getPatternFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternImpl <em>Pattern</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPattern()
         * @generated
         */
        EClass PATTERN = eINSTANCE.getPattern();

        /**
         * The meta object literal for the '<em><b>Header Method</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN__HEADER_METHOD = eINSTANCE.getPattern_HeaderMethod();

        /**
         * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN__METHODS = eINSTANCE.getPattern_Methods();

        /**
         * The meta object literal for the '<em><b>Super Pattern</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN__SUPER_PATTERN = eINSTANCE.getPattern_SuperPattern();

        /**
         * The meta object literal for the '<em><b>Footer Method</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN__FOOTER_METHOD = eINSTANCE.getPattern_FooterMethod();

        /**
         * The meta object literal for the '<em><b>Orchestration</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN__ORCHESTRATION = eINSTANCE.getPattern_Orchestration();

        /**
         * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN__PARAMETERS = eINSTANCE.getPattern_Parameters();

        /**
         * The meta object literal for the '<em><b>Nature</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN__NATURE = eINSTANCE.getPattern_Nature();

        /**
         * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN__VARIABLES = eINSTANCE.getPattern_Variables();

        /**
         * The meta object literal for the '<em><b>Init Method</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN__INIT_METHOD = eINSTANCE.getPattern_InitMethod();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternMethodImpl <em>Method</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternMethodImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternMethod()
         * @generated
         */
        EClass PATTERN_METHOD = eINSTANCE.getPatternMethod();

        /**
         * The meta object literal for the '<em><b>Pattern</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN_METHOD__PATTERN = eINSTANCE.getPatternMethod_Pattern();

        /**
         * The meta object literal for the '<em><b>Pattern File Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PATTERN_METHOD__PATTERN_FILE_PATH = eINSTANCE.getPatternMethod_PatternFilePath();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternParameterImpl <em>Parameter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternParameterImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternParameter()
         * @generated
         */
        EClass PATTERN_PARAMETER = eINSTANCE.getPatternParameter();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PATTERN_PARAMETER__TYPE = eINSTANCE.getPatternParameter_Type();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternEngineImpl <em>Engine</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternEngineImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternEngine()
         * @generated
         */
        EClass PATTERN_ENGINE = eINSTANCE.getPatternEngine();

        /**
         * The meta object literal for the '<em><b>Pattern</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN_ENGINE__PATTERN = eINSTANCE.getPatternEngine_Pattern();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternLibraryImpl <em>Library</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternLibraryImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternLibrary()
         * @generated
         */
        EClass PATTERN_LIBRARY = eINSTANCE.getPatternLibrary();

        /**
         * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN_LIBRARY__ELEMENTS = eINSTANCE.getPatternLibrary_Elements();

        /**
         * The meta object literal for the '<em><b>Runtime Orchestration</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN_LIBRARY__RUNTIME_ORCHESTRATION = eINSTANCE.getPatternLibrary_RuntimeOrchestration();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternElementImpl <em>Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternElementImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternElement()
         * @generated
         */
        EClass PATTERN_ELEMENT = eINSTANCE.getPatternElement();

        /**
         * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN_ELEMENT__CONTAINER = eINSTANCE.getPatternElement_Container();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternViewpointImpl <em>Viewpoint</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternViewpointImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternViewpoint()
         * @generated
         */
        EClass PATTERN_VIEWPOINT = eINSTANCE.getPatternViewpoint();

        /**
         * The meta object literal for the '<em><b>Libraries</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN_VIEWPOINT__LIBRARIES = eINSTANCE.getPatternViewpoint_Libraries();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternNatureImpl <em>Nature</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternNatureImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternNature()
         * @generated
         */
        EClass PATTERN_NATURE = eINSTANCE.getPatternNature();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternCallImpl <em>Call</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternCallImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternCall()
         * @generated
         */
        EClass PATTERN_CALL = eINSTANCE.getPatternCall();

        /**
         * The meta object literal for the '<em><b>Parameter Matching</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN_CALL__PARAMETER_MATCHING = eINSTANCE.getPatternCall_ParameterMatching();

        /**
         * The meta object literal for the '<em><b>Called</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN_CALL__CALLED = eINSTANCE.getPatternCall_Called();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.Paramerter2ParameterMapImpl <em>Paramerter2 Parameter Map</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.Paramerter2ParameterMapImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getParamerter2ParameterMap()
         * @generated
         */
        EClass PARAMERTER2_PARAMETER_MAP = eINSTANCE.getParamerter2ParameterMap();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PARAMERTER2_PARAMETER_MAP__KEY = eINSTANCE.getParamerter2ParameterMap_Key();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.CallImpl <em>Call</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.CallImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getCall()
         * @generated
         */
        EClass CALL = eINSTANCE.getCall();

        /**
         * The meta object literal for the '<em><b>Pattern</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CALL__PATTERN = eINSTANCE.getCall_Pattern();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.MethodCallImpl <em>Method Call</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.MethodCallImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getMethodCall()
         * @generated
         */
        EClass METHOD_CALL = eINSTANCE.getMethodCall();

        /**
         * The meta object literal for the '<em><b>Called</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference METHOD_CALL__CALLED = eINSTANCE.getMethodCall_Called();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternVariableImpl <em>Variable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternVariableImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternVariable()
         * @generated
         */
        EClass PATTERN_VARIABLE = eINSTANCE.getPatternVariable();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PARAMERTER2_PARAMETER_MAP__VALUE = eINSTANCE.getParamerter2ParameterMap_Value();

        /**
         * The meta object literal for the '<em>Context</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.PatternContext
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternContext()
         * @generated
         */
        EDataType PATTERN_CONTEXT = eINSTANCE.getPatternContext();

        /**
         * The meta object literal for the '<em>Exception</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.PatternException
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternException()
         * @generated
         */
        EDataType PATTERN_EXCEPTION = eINSTANCE.getPatternException();

    }

} //PatternPackage
