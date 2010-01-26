/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.pattern;

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.types.TypesPackage;
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
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
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
    int PATTERN_ELEMENT = 4;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ELEMENT__ID = FcorePackage.NAMED_MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ELEMENT__DESCRIPTION = FcorePackage.NAMED_MODEL_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ELEMENT__NAME = FcorePackage.NAMED_MODEL_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ELEMENT__CONTAINER = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_ELEMENT_FEATURE_COUNT = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 1;

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
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__DESCRIPTION = PATTERN_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN__NAME = PATTERN_ELEMENT__NAME;

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
    int PATTERN_METHOD__ID = FcorePackage.NAMED_MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_METHOD__DESCRIPTION = FcorePackage.NAMED_MODEL_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_METHOD__NAME = FcorePackage.NAMED_MODEL_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_METHOD__PATTERN = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Pattern File Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_METHOD__PATTERN_FILE_PATH = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Method</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_METHOD_FEATURE_COUNT = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 2;

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
    int PATTERN_PARAMETER__ID = FcorePackage.NAMED_MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PARAMETER__DESCRIPTION = FcorePackage.NAMED_MODEL_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PARAMETER__NAME = FcorePackage.NAMED_MODEL_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PARAMETER__TYPE = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Query</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PARAMETER__QUERY = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Parameter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PARAMETER_FEATURE_COUNT = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternLibraryImpl <em>Library</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternLibraryImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternLibrary()
     * @generated
     */
    int PATTERN_LIBRARY = 3;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_LIBRARY__ID = PATTERN_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_LIBRARY__DESCRIPTION = PATTERN_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_LIBRARY__NAME = PATTERN_ELEMENT__NAME;

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
     * The feature id for the '<em><b>Filters</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_LIBRARY__FILTERS = PATTERN_ELEMENT_FEATURE_COUNT + 1;

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
    int PATTERN_VIEWPOINT = 5;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VIEWPOINT__ID = FcorePackage.VIEWPOINT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VIEWPOINT__DESCRIPTION = FcorePackage.VIEWPOINT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Viewpoint Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VIEWPOINT__VIEWPOINT_CONTAINER = FcorePackage.VIEWPOINT__VIEWPOINT_CONTAINER;

    /**
     * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VIEWPOINT__LIBRARIES = FcorePackage.VIEWPOINT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Viewpoint</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VIEWPOINT_FEATURE_COUNT = FcorePackage.VIEWPOINT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternNatureImpl <em>Nature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternNatureImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternNature()
     * @generated
     */
    int PATTERN_NATURE = 6;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_NATURE__ID = FcorePackage.NAMED_MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_NATURE__DESCRIPTION = FcorePackage.NAMED_MODEL_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_NATURE__NAME = FcorePackage.NAMED_MODEL_ELEMENT__NAME;

    /**
     * The number of structural features of the '<em>Nature</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_NATURE_FEATURE_COUNT = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 0;

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
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL__ID = FcorePackage.MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL__DESCRIPTION = FcorePackage.MODEL_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL__PATTERN = FcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Call</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL_FEATURE_COUNT = FcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.AbstractPatternCallImpl <em>Abstract Pattern Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.AbstractPatternCallImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getAbstractPatternCall()
     * @generated
     */
    int ABSTRACT_PATTERN_CALL = 13;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PATTERN_CALL__ID = CALL__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PATTERN_CALL__DESCRIPTION = CALL__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PATTERN_CALL__PATTERN = CALL__PATTERN;

    /**
     * The feature id for the '<em><b>Called</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PATTERN_CALL__CALLED = CALL_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Abstract Pattern Call</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PATTERN_CALL_FEATURE_COUNT = CALL_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternCallImpl <em>Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternCallImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternCall()
     * @generated
     */
    int PATTERN_CALL = 7;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_CALL__ID = ABSTRACT_PATTERN_CALL__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_CALL__DESCRIPTION = ABSTRACT_PATTERN_CALL__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_CALL__PATTERN = ABSTRACT_PATTERN_CALL__PATTERN;

    /**
     * The feature id for the '<em><b>Called</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_CALL__CALLED = ABSTRACT_PATTERN_CALL__CALLED;

    /**
     * The feature id for the '<em><b>Parameter Matching</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_CALL__PARAMETER_MATCHING = ABSTRACT_PATTERN_CALL_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Call</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_CALL_FEATURE_COUNT = ABSTRACT_PATTERN_CALL_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.SuperPatternCallImpl <em>Super Pattern Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.SuperPatternCallImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getSuperPatternCall()
     * @generated
     */
    int SUPER_PATTERN_CALL = 8;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUPER_PATTERN_CALL__ID = ABSTRACT_PATTERN_CALL__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUPER_PATTERN_CALL__DESCRIPTION = ABSTRACT_PATTERN_CALL__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUPER_PATTERN_CALL__PATTERN = ABSTRACT_PATTERN_CALL__PATTERN;

    /**
     * The feature id for the '<em><b>Called</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUPER_PATTERN_CALL__CALLED = ABSTRACT_PATTERN_CALL__CALLED;

    /**
     * The number of structural features of the '<em>Super Pattern Call</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUPER_PATTERN_CALL_FEATURE_COUNT = ABSTRACT_PATTERN_CALL_FEATURE_COUNT + 0;

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
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METHOD_CALL__ID = CALL__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METHOD_CALL__DESCRIPTION = CALL__DESCRIPTION;

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
    int PATTERN_VARIABLE__ID = FcorePackage.NAMED_MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VARIABLE__DESCRIPTION = FcorePackage.NAMED_MODEL_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VARIABLE__NAME = FcorePackage.NAMED_MODEL_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VARIABLE__TYPE = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Variable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_VARIABLE_FEATURE_COUNT = FcorePackage.NAMED_MODEL_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternInjectedCallImpl <em>Injected Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternInjectedCallImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternInjectedCall()
     * @generated
     */
    int PATTERN_INJECTED_CALL = 14;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_INJECTED_CALL__ID = ABSTRACT_PATTERN_CALL__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_INJECTED_CALL__DESCRIPTION = ABSTRACT_PATTERN_CALL__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_INJECTED_CALL__PATTERN = ABSTRACT_PATTERN_CALL__PATTERN;

    /**
     * The feature id for the '<em><b>Called</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_INJECTED_CALL__CALLED = ABSTRACT_PATTERN_CALL__CALLED;

    /**
     * The feature id for the '<em><b>Context</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_INJECTED_CALL__CONTEXT = ABSTRACT_PATTERN_CALL_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Injected Call</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_INJECTED_CALL_FEATURE_COUNT = ABSTRACT_PATTERN_CALL_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.QueryImpl <em>Query</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.QueryImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getQuery()
     * @generated
     */
    int QUERY = 15;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY__ID = FcorePackage.MODEL_ELEMENT__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY__DESCRIPTION = FcorePackage.MODEL_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY__PARAMETER = FcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Extension Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY__EXTENSION_ID = FcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Query Context</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY__QUERY_CONTEXT = FcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Query</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_FEATURE_COUNT = FcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.BasicQueryImpl <em>Basic Query</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.BasicQueryImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getBasicQuery()
     * @generated
     */
    int BASIC_QUERY = 16;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_QUERY__ID = QUERY__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_QUERY__DESCRIPTION = QUERY__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_QUERY__PARAMETER = QUERY__PARAMETER;

    /**
     * The feature id for the '<em><b>Extension Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_QUERY__EXTENSION_ID = QUERY__EXTENSION_ID;

    /**
     * The feature id for the '<em><b>Query Context</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_QUERY__QUERY_CONTEXT = QUERY__QUERY_CONTEXT;

    /**
     * The number of structural features of the '<em>Basic Query</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_QUERY_FEATURE_COUNT = QUERY_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.StringQueryImpl <em>String Query</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.StringQueryImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getStringQuery()
     * @generated
     */
    int STRING_QUERY = 17;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_QUERY__ID = QUERY__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_QUERY__DESCRIPTION = QUERY__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_QUERY__PARAMETER = QUERY__PARAMETER;

    /**
     * The feature id for the '<em><b>Extension Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_QUERY__EXTENSION_ID = QUERY__EXTENSION_ID;

    /**
     * The feature id for the '<em><b>Query Context</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_QUERY__QUERY_CONTEXT = QUERY__QUERY_CONTEXT;

    /**
     * The number of structural features of the '<em>String Query</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_QUERY_FEATURE_COUNT = QUERY_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.CustomQueryImpl <em>Custom Query</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.CustomQueryImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getCustomQuery()
     * @generated
     */
    int CUSTOM_QUERY = 18;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_QUERY__ID = QUERY__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_QUERY__DESCRIPTION = QUERY__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_QUERY__PARAMETER = QUERY__PARAMETER;

    /**
     * The feature id for the '<em><b>Extension Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_QUERY__EXTENSION_ID = QUERY__EXTENSION_ID;

    /**
     * The feature id for the '<em><b>Query Context</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_QUERY__QUERY_CONTEXT = QUERY__QUERY_CONTEXT;

    /**
     * The number of structural features of the '<em>Custom Query</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_QUERY_FEATURE_COUNT = QUERY_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.String2PatternListImpl <em>String2 Pattern List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.String2PatternListImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getString2PatternList()
     * @generated
     */
    int STRING2_PATTERN_LIST = 19;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING2_PATTERN_LIST__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING2_PATTERN_LIST__VALUE = 1;

    /**
     * The number of structural features of the '<em>String2 Pattern List</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING2_PATTERN_LIST_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.String2StringImpl <em>String2 String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.String2StringImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getString2String()
     * @generated
     */
    int STRING2_STRING = 20;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING2_STRING__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING2_STRING__VALUE = 1;

    /**
     * The number of structural features of the '<em>String2 String</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING2_STRING_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.TypePatternExecutionReporterImpl <em>Type Pattern Execution Reporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.TypePatternExecutionReporterImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getTypePatternExecutionReporter()
     * @generated
     */
    int TYPE_PATTERN_EXECUTION_REPORTER = 21;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_PATTERN_EXECUTION_REPORTER__ID = TypesPackage.TYPE_ABSTRACT_CLASS__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_PATTERN_EXECUTION_REPORTER__DESCRIPTION = TypesPackage.TYPE_ABSTRACT_CLASS__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_PATTERN_EXECUTION_REPORTER__VALUE = TypesPackage.TYPE_ABSTRACT_CLASS__VALUE;

    /**
     * The number of structural features of the '<em>Type Pattern Execution Reporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_PATTERN_EXECUTION_REPORTER_FEATURE_COUNT = TypesPackage.TYPE_ABSTRACT_CLASS_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.BackCallImpl <em>Back Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.BackCallImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getBackCall()
     * @generated
     */
    int BACK_CALL = 22;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BACK_CALL__ID = CALL__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BACK_CALL__DESCRIPTION = CALL__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BACK_CALL__PATTERN = CALL__PATTERN;

    /**
     * The number of structural features of the '<em>Back Call</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BACK_CALL_FEATURE_COUNT = CALL_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '<em>Context</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.PatternContext
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternContext()
     * @generated
     */
    int PATTERN_CONTEXT = 23;

    /**
     * The meta object id for the '<em>Exception</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.PatternException
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternException()
     * @generated
     */
    int PATTERN_EXCEPTION = 24;

    /**
     * The meta object id for the '<em>EPattern Execution Reporter</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.PatternExecutionReporter
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getEPatternExecutionReporter()
     * @generated
     */
    int EPATTERN_EXECUTION_REPORTER = 25;

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
     * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.pattern.PatternParameter#getQuery <em>Query</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Query</em>'.
     * @see org.eclipse.egf.model.pattern.PatternParameter#getQuery()
     * @see #getPatternParameter()
     * @generated
     */
    EReference getPatternParameter_Query();

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
     * Returns the meta object for the map '{@link org.eclipse.egf.model.pattern.PatternLibrary#getFilters <em>Filters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Filters</em>'.
     * @see org.eclipse.egf.model.pattern.PatternLibrary#getFilters()
     * @see #getPatternLibrary()
     * @generated
     */
    EReference getPatternLibrary_Filters();

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
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.SuperPatternCall <em>Super Pattern Call</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Super Pattern Call</em>'.
     * @see org.eclipse.egf.model.pattern.SuperPatternCall
     * @generated
     */
    EClass getSuperPatternCall();

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
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.pattern.PatternVariable#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.egf.model.pattern.PatternVariable#getType()
     * @see #getPatternVariable()
     * @generated
     */
    EAttribute getPatternVariable_Type();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.AbstractPatternCall <em>Abstract Pattern Call</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Pattern Call</em>'.
     * @see org.eclipse.egf.model.pattern.AbstractPatternCall
     * @generated
     */
    EClass getAbstractPatternCall();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.pattern.AbstractPatternCall#getCalled <em>Called</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Called</em>'.
     * @see org.eclipse.egf.model.pattern.AbstractPatternCall#getCalled()
     * @see #getAbstractPatternCall()
     * @generated
     */
    EReference getAbstractPatternCall_Called();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternInjectedCall <em>Injected Call</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Injected Call</em>'.
     * @see org.eclipse.egf.model.pattern.PatternInjectedCall
     * @generated
     */
    EClass getPatternInjectedCall();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.model.pattern.PatternInjectedCall#getContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Context</em>'.
     * @see org.eclipse.egf.model.pattern.PatternInjectedCall#getContext()
     * @see #getPatternInjectedCall()
     * @generated
     */
    EReference getPatternInjectedCall_Context();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.Query <em>Query</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query</em>'.
     * @see org.eclipse.egf.model.pattern.Query
     * @generated
     */
    EClass getQuery();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.egf.model.pattern.Query#getParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parameter</em>'.
     * @see org.eclipse.egf.model.pattern.Query#getParameter()
     * @see #getQuery()
     * @generated
     */
    EReference getQuery_Parameter();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.model.pattern.Query#getExtensionId <em>Extension Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Extension Id</em>'.
     * @see org.eclipse.egf.model.pattern.Query#getExtensionId()
     * @see #getQuery()
     * @generated
     */
    EAttribute getQuery_ExtensionId();

    /**
     * Returns the meta object for the map '{@link org.eclipse.egf.model.pattern.Query#getQueryContext <em>Query Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Query Context</em>'.
     * @see org.eclipse.egf.model.pattern.Query#getQueryContext()
     * @see #getQuery()
     * @generated
     */
    EReference getQuery_QueryContext();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.BasicQuery <em>Basic Query</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Basic Query</em>'.
     * @see org.eclipse.egf.model.pattern.BasicQuery
     * @generated
     */
    EClass getBasicQuery();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.StringQuery <em>String Query</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>String Query</em>'.
     * @see org.eclipse.egf.model.pattern.StringQuery
     * @generated
     */
    EClass getStringQuery();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.CustomQuery <em>Custom Query</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Custom Query</em>'.
     * @see org.eclipse.egf.model.pattern.CustomQuery
     * @generated
     */
    EClass getCustomQuery();

    /**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>String2 Pattern List</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>String2 Pattern List</em>'.
     * @see java.util.Map.Entry
     * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
     *        valueType="org.eclipse.egf.model.pattern.PatternElement" valueMany="true"
     * @generated
     */
    EClass getString2PatternList();

    /**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getString2PatternList()
     * @generated
     */
    EAttribute getString2PatternList_Key();

    /**
     * Returns the meta object for the reference list '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getString2PatternList()
     * @generated
     */
    EReference getString2PatternList_Value();

    /**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>String2 String</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>String2 String</em>'.
     * @see java.util.Map.Entry
     * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
     *        valueDataType="org.eclipse.emf.ecore.EString" valueRequired="true"
     * @generated
     */
    EClass getString2String();

    /**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getString2String()
     * @generated
     */
    EAttribute getString2String_Key();

    /**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getString2String()
     * @generated
     */
    EAttribute getString2String_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.TypePatternExecutionReporter <em>Type Pattern Execution Reporter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Pattern Execution Reporter</em>'.
     * @see org.eclipse.egf.model.pattern.TypePatternExecutionReporter
     * @generated
     */
    EClass getTypePatternExecutionReporter();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.BackCall <em>Back Call</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Back Call</em>'.
     * @see org.eclipse.egf.model.pattern.BackCall
     * @generated
     */
    EClass getBackCall();

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
     * Returns the meta object for data type '{@link org.eclipse.egf.model.pattern.PatternContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Context</em>'.
     * @see org.eclipse.egf.model.pattern.PatternContext
     * @model instanceClass="org.eclipse.egf.model.pattern.PatternContext"
     * @generated
     */
    EDataType getPatternContext();

    /**
     * Returns the meta object for data type '{@link org.eclipse.egf.model.pattern.PatternException <em>Exception</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Exception</em>'.
     * @see org.eclipse.egf.model.pattern.PatternException
     * @model instanceClass="org.eclipse.egf.model.pattern.PatternException"
     * @generated
     */
    EDataType getPatternException();

    /**
     * Returns the meta object for data type '{@link org.eclipse.egf.model.pattern.PatternExecutionReporter <em>EPattern Execution Reporter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>EPattern Execution Reporter</em>'.
     * @see org.eclipse.egf.model.pattern.PatternExecutionReporter
     * @model instanceClass="org.eclipse.egf.model.pattern.PatternExecutionReporter"
     * @generated
     */
    EDataType getEPatternExecutionReporter();

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
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
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
        @SuppressWarnings("hiding")
        EClass PATTERN = eINSTANCE.getPattern();

        /**
         * The meta object literal for the '<em><b>Header Method</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN__HEADER_METHOD = eINSTANCE.getPattern_HeaderMethod();

        /**
         * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN__METHODS = eINSTANCE.getPattern_Methods();

        /**
         * The meta object literal for the '<em><b>Super Pattern</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN__SUPER_PATTERN = eINSTANCE.getPattern_SuperPattern();

        /**
         * The meta object literal for the '<em><b>Footer Method</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN__FOOTER_METHOD = eINSTANCE.getPattern_FooterMethod();

        /**
         * The meta object literal for the '<em><b>Orchestration</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN__ORCHESTRATION = eINSTANCE.getPattern_Orchestration();

        /**
         * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN__PARAMETERS = eINSTANCE.getPattern_Parameters();

        /**
         * The meta object literal for the '<em><b>Nature</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN__NATURE = eINSTANCE.getPattern_Nature();

        /**
         * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN__VARIABLES = eINSTANCE.getPattern_Variables();

        /**
         * The meta object literal for the '<em><b>Init Method</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN__INIT_METHOD = eINSTANCE.getPattern_InitMethod();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternMethodImpl <em>Method</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternMethodImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternMethod()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass PATTERN_METHOD = eINSTANCE.getPatternMethod();

        /**
         * The meta object literal for the '<em><b>Pattern</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN_METHOD__PATTERN = eINSTANCE.getPatternMethod_Pattern();

        /**
         * The meta object literal for the '<em><b>Pattern File Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute PATTERN_METHOD__PATTERN_FILE_PATH = eINSTANCE.getPatternMethod_PatternFilePath();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternParameterImpl <em>Parameter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternParameterImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternParameter()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass PATTERN_PARAMETER = eINSTANCE.getPatternParameter();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute PATTERN_PARAMETER__TYPE = eINSTANCE.getPatternParameter_Type();

        /**
         * The meta object literal for the '<em><b>Query</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN_PARAMETER__QUERY = eINSTANCE.getPatternParameter_Query();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternLibraryImpl <em>Library</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternLibraryImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternLibrary()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass PATTERN_LIBRARY = eINSTANCE.getPatternLibrary();

        /**
         * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN_LIBRARY__ELEMENTS = eINSTANCE.getPatternLibrary_Elements();

        /**
         * The meta object literal for the '<em><b>Filters</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN_LIBRARY__FILTERS = eINSTANCE.getPatternLibrary_Filters();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternElementImpl <em>Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternElementImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternElement()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass PATTERN_ELEMENT = eINSTANCE.getPatternElement();

        /**
         * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN_ELEMENT__CONTAINER = eINSTANCE.getPatternElement_Container();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternViewpointImpl <em>Viewpoint</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternViewpointImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternViewpoint()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass PATTERN_VIEWPOINT = eINSTANCE.getPatternViewpoint();

        /**
         * The meta object literal for the '<em><b>Libraries</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN_VIEWPOINT__LIBRARIES = eINSTANCE.getPatternViewpoint_Libraries();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternNatureImpl <em>Nature</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternNatureImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternNature()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass PATTERN_NATURE = eINSTANCE.getPatternNature();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternCallImpl <em>Call</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternCallImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternCall()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass PATTERN_CALL = eINSTANCE.getPatternCall();

        /**
         * The meta object literal for the '<em><b>Parameter Matching</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN_CALL__PARAMETER_MATCHING = eINSTANCE.getPatternCall_ParameterMatching();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.SuperPatternCallImpl <em>Super Pattern Call</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.SuperPatternCallImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getSuperPatternCall()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass SUPER_PATTERN_CALL = eINSTANCE.getSuperPatternCall();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.Paramerter2ParameterMapImpl <em>Paramerter2 Parameter Map</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.Paramerter2ParameterMapImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getParamerter2ParameterMap()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass PARAMERTER2_PARAMETER_MAP = eINSTANCE.getParamerter2ParameterMap();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PARAMERTER2_PARAMETER_MAP__KEY = eINSTANCE.getParamerter2ParameterMap_Key();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.CallImpl <em>Call</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.CallImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getCall()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass CALL = eINSTANCE.getCall();

        /**
         * The meta object literal for the '<em><b>Pattern</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference CALL__PATTERN = eINSTANCE.getCall_Pattern();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.MethodCallImpl <em>Method Call</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.MethodCallImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getMethodCall()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass METHOD_CALL = eINSTANCE.getMethodCall();

        /**
         * The meta object literal for the '<em><b>Called</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference METHOD_CALL__CALLED = eINSTANCE.getMethodCall_Called();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternVariableImpl <em>Variable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternVariableImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternVariable()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass PATTERN_VARIABLE = eINSTANCE.getPatternVariable();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute PATTERN_VARIABLE__TYPE = eINSTANCE.getPatternVariable_Type();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.AbstractPatternCallImpl <em>Abstract Pattern Call</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.AbstractPatternCallImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getAbstractPatternCall()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass ABSTRACT_PATTERN_CALL = eINSTANCE.getAbstractPatternCall();

        /**
         * The meta object literal for the '<em><b>Called</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference ABSTRACT_PATTERN_CALL__CALLED = eINSTANCE.getAbstractPatternCall_Called();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternInjectedCallImpl <em>Injected Call</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.PatternInjectedCallImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternInjectedCall()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass PATTERN_INJECTED_CALL = eINSTANCE.getPatternInjectedCall();

        /**
         * The meta object literal for the '<em><b>Context</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PATTERN_INJECTED_CALL__CONTEXT = eINSTANCE.getPatternInjectedCall_Context();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.QueryImpl <em>Query</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.QueryImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getQuery()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass QUERY = eINSTANCE.getQuery();

        /**
         * The meta object literal for the '<em><b>Parameter</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference QUERY__PARAMETER = eINSTANCE.getQuery_Parameter();

        /**
         * The meta object literal for the '<em><b>Extension Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute QUERY__EXTENSION_ID = eINSTANCE.getQuery_ExtensionId();

        /**
         * The meta object literal for the '<em><b>Query Context</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference QUERY__QUERY_CONTEXT = eINSTANCE.getQuery_QueryContext();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.BasicQueryImpl <em>Basic Query</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.BasicQueryImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getBasicQuery()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass BASIC_QUERY = eINSTANCE.getBasicQuery();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.StringQueryImpl <em>String Query</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.StringQueryImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getStringQuery()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass STRING_QUERY = eINSTANCE.getStringQuery();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.CustomQueryImpl <em>Custom Query</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.CustomQueryImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getCustomQuery()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass CUSTOM_QUERY = eINSTANCE.getCustomQuery();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.String2PatternListImpl <em>String2 Pattern List</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.String2PatternListImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getString2PatternList()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass STRING2_PATTERN_LIST = eINSTANCE.getString2PatternList();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute STRING2_PATTERN_LIST__KEY = eINSTANCE.getString2PatternList_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference STRING2_PATTERN_LIST__VALUE = eINSTANCE.getString2PatternList_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.String2StringImpl <em>String2 String</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.String2StringImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getString2String()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass STRING2_STRING = eINSTANCE.getString2String();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute STRING2_STRING__KEY = eINSTANCE.getString2String_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EAttribute STRING2_STRING__VALUE = eINSTANCE.getString2String_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.TypePatternExecutionReporterImpl <em>Type Pattern Execution Reporter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.TypePatternExecutionReporterImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getTypePatternExecutionReporter()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass TYPE_PATTERN_EXECUTION_REPORTER = eINSTANCE.getTypePatternExecutionReporter();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.BackCallImpl <em>Back Call</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.impl.BackCallImpl
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getBackCall()
         * @generated
         */
        @SuppressWarnings("hiding")
        EClass BACK_CALL = eINSTANCE.getBackCall();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("hiding")
        EReference PARAMERTER2_PARAMETER_MAP__VALUE = eINSTANCE.getParamerter2ParameterMap_Value();

        /**
         * The meta object literal for the '<em>Context</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.PatternContext
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternContext()
         * @generated
         */
        @SuppressWarnings("hiding")
        EDataType PATTERN_CONTEXT = eINSTANCE.getPatternContext();

        /**
         * The meta object literal for the '<em>Exception</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.PatternException
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternException()
         * @generated
         */
        @SuppressWarnings("hiding")
        EDataType PATTERN_EXCEPTION = eINSTANCE.getPatternException();

        /**
         * The meta object literal for the '<em>EPattern Execution Reporter</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.model.pattern.PatternExecutionReporter
         * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getEPatternExecutionReporter()
         * @generated
         */
        @SuppressWarnings("hiding")
        EDataType EPATTERN_EXECUTION_REPORTER = eINSTANCE.getEPatternExecutionReporter();

    }

} // PatternPackage
