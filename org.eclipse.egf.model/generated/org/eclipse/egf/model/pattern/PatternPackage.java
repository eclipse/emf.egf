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
   * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternUnitImpl <em>Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.pattern.impl.PatternUnitImpl
   * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternUnit()
   * @generated
   */
  int PATTERN_UNIT = 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_UNIT__ID = FactoryComponentPackage.MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_UNIT__NAME = FactoryComponentPackage.MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_UNIT__DESCRIPTION = FactoryComponentPackage.MODEL_ELEMENT__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_UNIT_FEATURE_COUNT = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.pattern.impl.PatternElementImpl
   * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternElement()
   * @generated
   */
  int PATTERN_ELEMENT = 7;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_ELEMENT__ID = PATTERN_UNIT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_ELEMENT__NAME = PATTERN_UNIT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_ELEMENT__DESCRIPTION = PATTERN_UNIT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_ELEMENT__CONTAINER = PATTERN_UNIT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_ELEMENT_FEATURE_COUNT = PATTERN_UNIT_FEATURE_COUNT + 1;

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
   * The feature id for the '<em><b>Header Method</b></em>' containment reference.
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
   * The feature id for the '<em><b>Footer Method</b></em>' containment reference.
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
   * The feature id for the '<em><b>Orchestration</b></em>' reference list.
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
   * The number of structural features of the '<em>Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_FEATURE_COUNT = PATTERN_ELEMENT_FEATURE_COUNT + 7;

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
  int PATTERN_METHOD__ID = PATTERN_UNIT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_METHOD__NAME = PATTERN_UNIT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_METHOD__DESCRIPTION = PATTERN_UNIT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_METHOD__PATTERN = PATTERN_UNIT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Pattern File Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_METHOD__PATTERN_FILE_PATH = PATTERN_UNIT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Method</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_METHOD_FEATURE_COUNT = PATTERN_UNIT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.pattern.impl.PatternParameterImpl
   * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternParameter()
   * @generated
   */
  int PATTERN_PARAMETER = 3;

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
   * The feature id for the '<em><b>Type</b></em>' reference.
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
   * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternRunnerImpl <em>Runner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.pattern.impl.PatternRunnerImpl
   * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternRunner()
   * @generated
   */
  int PATTERN_RUNNER = 4;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_RUNNER__ID = FactoryComponentPackage.MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_RUNNER__NAME = FactoryComponentPackage.MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_RUNNER__DESCRIPTION = FactoryComponentPackage.MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_RUNNER__PATTERN = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Runner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_RUNNER_FEATURE_COUNT = FactoryComponentPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternSuperMethodImpl <em>Super Method</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.pattern.impl.PatternSuperMethodImpl
   * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternSuperMethod()
   * @generated
   */
  int PATTERN_SUPER_METHOD = 5;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_SUPER_METHOD__ID = PATTERN_UNIT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_SUPER_METHOD__NAME = PATTERN_UNIT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_SUPER_METHOD__DESCRIPTION = PATTERN_UNIT__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Super Method</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_SUPER_METHOD_FEATURE_COUNT = PATTERN_UNIT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.pattern.impl.PatternLibraryImpl <em>Library</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.pattern.impl.PatternLibraryImpl
   * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternLibrary()
   * @generated
   */
  int PATTERN_LIBRARY = 6;

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
  int PATTERN_VIEWPOINT = 8;

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
  int PATTERN_NATURE = 9;

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
   * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.Pattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern</em>'.
   * @see org.eclipse.egf.model.pattern.Pattern
   * @generated
   */
  EClass getPattern();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.pattern.Pattern#getHeaderMethod <em>Header Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Header Method</em>'.
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
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.pattern.Pattern#getFooterMethod <em>Footer Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Footer Method</em>'.
   * @see org.eclipse.egf.model.pattern.Pattern#getFooterMethod()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_FooterMethod();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.egf.model.pattern.Pattern#getOrchestration <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Orchestration</em>'.
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
   * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method</em>'.
   * @see org.eclipse.egf.model.pattern.PatternMethod
   * @generated
   */
  EClass getPatternMethod();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.pattern.PatternMethod#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Pattern</em>'.
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
   * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit</em>'.
   * @see org.eclipse.egf.model.pattern.PatternUnit
   * @generated
   */
  EClass getPatternUnit();

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
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.pattern.PatternParameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.egf.model.pattern.PatternParameter#getType()
   * @see #getPatternParameter()
   * @generated
   */
  EReference getPatternParameter_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternRunner <em>Runner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Runner</em>'.
   * @see org.eclipse.egf.model.pattern.PatternRunner
   * @generated
   */
  EClass getPatternRunner();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.pattern.PatternRunner#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Pattern</em>'.
   * @see org.eclipse.egf.model.pattern.PatternRunner#getPattern()
   * @see #getPatternRunner()
   * @generated
   */
  EReference getPatternRunner_Pattern();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.pattern.PatternSuperMethod <em>Super Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Super Method</em>'.
   * @see org.eclipse.egf.model.pattern.PatternSuperMethod
   * @generated
   */
  EClass getPatternSuperMethod();

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
     * The meta object literal for the '<em><b>Header Method</b></em>' containment reference feature.
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
     * The meta object literal for the '<em><b>Footer Method</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__FOOTER_METHOD = eINSTANCE.getPattern_FooterMethod();

    /**
     * The meta object literal for the '<em><b>Orchestration</b></em>' reference list feature.
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
     * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternMethodImpl <em>Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternMethodImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternMethod()
     * @generated
     */
    EClass PATTERN_METHOD = eINSTANCE.getPatternMethod();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' reference feature.
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
     * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternUnitImpl <em>Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternUnitImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternUnit()
     * @generated
     */
    EClass PATTERN_UNIT = eINSTANCE.getPatternUnit();

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
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_PARAMETER__TYPE = eINSTANCE.getPatternParameter_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternRunnerImpl <em>Runner</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternRunnerImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternRunner()
     * @generated
     */
    EClass PATTERN_RUNNER = eINSTANCE.getPatternRunner();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_RUNNER__PATTERN = eINSTANCE.getPatternRunner_Pattern();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.pattern.impl.PatternSuperMethodImpl <em>Super Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.pattern.impl.PatternSuperMethodImpl
     * @see org.eclipse.egf.model.pattern.impl.PatternPackageImpl#getPatternSuperMethod()
     * @generated
     */
    EClass PATTERN_SUPER_METHOD = eINSTANCE.getPatternSuperMethod();

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

  }

} //PatternPackage
