/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "model"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/egf/1.0.0/FactoryComponent"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "egf.factorycomponent"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  ModelPackage eINSTANCE = org.eclipse.egf.model.impl.ModelPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.NamedModelElementWithIdImpl <em>Named Model Element With Id</em>}' class.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see org.eclipse.egf.model.impl.NamedModelElementWithIdImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getNamedModelElementWithId()
   * @generated
   */
  int NAMED_MODEL_ELEMENT_WITH_ID = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_MODEL_ELEMENT_WITH_ID__ID = 0;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_MODEL_ELEMENT_WITH_ID__NAME = 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION = 3;

  /**
   * The number of structural features of the '<em>Named Model Element With Id</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.FactoryComponentImpl <em>Factory Component</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.egf.model.impl.FactoryComponentImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getFactoryComponent()
   * @generated
   */
  int FACTORY_COMPONENT = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__DOMAIN = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Specification</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__SPECIFICATION = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Factory</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__FACTORY = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Factory Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.DomainImpl <em>Domain</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.egf.model.impl.DomainImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getDomain()
   * @generated
   */
  int DOMAIN = 4;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.SpecificationImpl <em>Specification</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @see org.eclipse.egf.model.impl.SpecificationImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getSpecification()
   * @generated
   */
  int SPECIFICATION = 5;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.AbstractViewpointImpl <em>Abstract Viewpoint</em>}' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see org.eclipse.egf.model.impl.AbstractViewpointImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getAbstractViewpoint()
   * @generated
   */
  int ABSTRACT_VIEWPOINT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.ContractImpl <em>Contract</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.egf.model.impl.ContractImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getContract()
   * @generated
   */
  int CONTRACT = 7;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.ContractElementImpl <em>Contract Element</em>}' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see org.eclipse.egf.model.impl.ContractElementImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getContractElement()
   * @generated
   */
  int CONTRACT_ELEMENT = 8;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.ContractElementReferenceImpl <em>Contract Element Reference</em>}' class.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see org.eclipse.egf.model.impl.ContractElementReferenceImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getContractElementReference()
   * @generated
   */
  int CONTRACT_ELEMENT_REFERENCE = 9;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.egf.model.impl.TypeImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getType()
   * @generated
   */
  int TYPE = 10;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.PatternViewpointImpl <em>Pattern Viewpoint</em>}' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see org.eclipse.egf.model.impl.PatternViewpointImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getPatternViewpoint()
   * @generated
   */
  int PATTERN_VIEWPOINT = 11;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.AbstractPatternElementImpl <em>Abstract Pattern Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.impl.AbstractPatternElementImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getAbstractPatternElement()
   * @generated
   */
  int ABSTRACT_PATTERN_ELEMENT = 12;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.PatternLibraryImpl <em>Pattern Library</em>}' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see org.eclipse.egf.model.impl.PatternLibraryImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getPatternLibrary()
   * @generated
   */
  int PATTERN_LIBRARY = 13;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.PatternModelImpl <em>Pattern Model</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @see org.eclipse.egf.model.impl.PatternModelImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getPatternModel()
   * @generated
   */
  int PATTERN_MODEL = 14;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.FactoryImpl <em>Factory</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.egf.model.impl.FactoryImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getFactory()
   * @generated
   */
  int FACTORY = 15;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.AbstractFactoryComponentFactoryImpl <em>Abstract Factory Component Factory</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.impl.AbstractFactoryComponentFactoryImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getAbstractFactoryComponentFactory()
   * @generated
   */
  int ABSTRACT_FACTORY_COMPONENT_FACTORY = 16;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_FACTORY_COMPONENT_FACTORY__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_FACTORY_COMPONENT_FACTORY__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_FACTORY_COMPONENT_FACTORY__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_FACTORY_COMPONENT_FACTORY__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Context Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT_ID = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Abstract Factory Component Factory</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_FACTORY_COMPONENT_FACTORY_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.ProductionPlanImpl <em>Production Plan</em>}' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see org.eclipse.egf.model.impl.ProductionPlanImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getProductionPlan()
   * @generated
   */
  int PRODUCTION_PLAN = 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.ContextImpl <em>Context</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.egf.model.impl.ContextImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getContext()
   * @generated
   */
  int CONTEXT = 17;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.ContextElementImpl <em>Context Element</em>}' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see org.eclipse.egf.model.impl.ContextElementImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getContextElement()
   * @generated
   */
  int CONTEXT_ELEMENT = 18;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.FactoryComponentInvocationImpl <em>Factory Component Invocation</em>}' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see org.eclipse.egf.model.impl.FactoryComponentInvocationImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getFactoryComponentInvocation()
   * @generated
   */
  int FACTORY_COMPONENT_INVOCATION = 3;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__ID = ABSTRACT_FACTORY_COMPONENT_FACTORY__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__JAVA_IDENTIFIER = ABSTRACT_FACTORY_COMPONENT_FACTORY__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__NAME = ABSTRACT_FACTORY_COMPONENT_FACTORY__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__DESCRIPTION = ABSTRACT_FACTORY_COMPONENT_FACTORY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__CONTEXT = ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT;

  /**
   * The feature id for the '<em><b>Context Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__CONTEXT_ID = ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT_ID;

  /**
   * The feature id for the '<em><b>Factory Component Invocations</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS = ABSTRACT_FACTORY_COMPONENT_FACTORY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Factory Component Invocation Ids</b></em>' attribute list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATION_IDS = ABSTRACT_FACTORY_COMPONENT_FACTORY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Production Plan</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_FEATURE_COUNT = ABSTRACT_FACTORY_COMPONENT_FACTORY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__ID = ABSTRACT_FACTORY_COMPONENT_FACTORY__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__JAVA_IDENTIFIER = ABSTRACT_FACTORY_COMPONENT_FACTORY__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__NAME = ABSTRACT_FACTORY_COMPONENT_FACTORY__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__DESCRIPTION = ABSTRACT_FACTORY_COMPONENT_FACTORY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__CONTEXT = ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT;

  /**
   * The feature id for the '<em><b>Context Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__CONTEXT_ID = ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT_ID;

  /**
   * The feature id for the '<em><b>Task Factory Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__TASK_FACTORY_ID = ABSTRACT_FACTORY_COMPONENT_FACTORY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Factory Component Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT_ID = ABSTRACT_FACTORY_COMPONENT_FACTORY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Task Factory</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__TASK_FACTORY = ABSTRACT_FACTORY_COMPONENT_FACTORY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Factory Component Invocation</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION_FEATURE_COUNT = ABSTRACT_FACTORY_COMPONENT_FACTORY_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__PATH = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Domain</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Viewpoints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__VIEWPOINTS = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Viewpoint Ids</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__VIEWPOINT_IDS = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Specification</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_VIEWPOINT__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_VIEWPOINT__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_VIEWPOINT__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_VIEWPOINT__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Abstract Viewpoint</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_VIEWPOINT_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__ID = ABSTRACT_VIEWPOINT__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__JAVA_IDENTIFIER = ABSTRACT_VIEWPOINT__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__NAME = ABSTRACT_VIEWPOINT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__DESCRIPTION = ABSTRACT_VIEWPOINT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Contract Elements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__CONTRACT_ELEMENTS = ABSTRACT_VIEWPOINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Contract</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_FEATURE_COUNT = ABSTRACT_VIEWPOINT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Contract Element References</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__CONTRACT_ELEMENT_REFERENCES = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Factory Component Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__FACTORY_COMPONENT_ID = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Contract Reference Ids</b></em>' attribute list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__CONTRACT_REFERENCE_IDS = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Contract Type</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__CONTRACT_TYPE = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Mandatory</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__MANDATORY = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Contract Element</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT_REFERENCE__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT_REFERENCE__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT_REFERENCE__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT_REFERENCE__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Referenced Contract Element Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_ID = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Referenced Contract Element Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_NAME = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Referenced Factory Component Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT_REFERENCE__REFERENCED_FACTORY_COMPONENT_ID = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Referenced Contract Element</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Contract Element Reference</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT_REFERENCE_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Type Holder Class Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__TYPE_HOLDER_CLASS_NAME = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type Holder</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__TYPE_HOLDER = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_VIEWPOINT__ID = ABSTRACT_VIEWPOINT__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_VIEWPOINT__JAVA_IDENTIFIER = ABSTRACT_VIEWPOINT__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_VIEWPOINT__NAME = ABSTRACT_VIEWPOINT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_VIEWPOINT__DESCRIPTION = ABSTRACT_VIEWPOINT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_VIEWPOINT__LIBRARIES = ABSTRACT_VIEWPOINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Pattern Viewpoint</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_VIEWPOINT_FEATURE_COUNT = ABSTRACT_VIEWPOINT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_PATTERN_ELEMENT__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_PATTERN_ELEMENT__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_PATTERN_ELEMENT__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_PATTERN_ELEMENT__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Abstract Pattern Element</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_PATTERN_ELEMENT_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_LIBRARY__ID = ABSTRACT_PATTERN_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_LIBRARY__JAVA_IDENTIFIER = ABSTRACT_PATTERN_ELEMENT__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_LIBRARY__NAME = ABSTRACT_PATTERN_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_LIBRARY__DESCRIPTION = ABSTRACT_PATTERN_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Pattern Elements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_LIBRARY__PATTERN_ELEMENTS = ABSTRACT_PATTERN_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Production Orchestration</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_LIBRARY__PRODUCTION_ORCHESTRATION = ABSTRACT_PATTERN_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Runtime Orchestration</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_LIBRARY__RUNTIME_ORCHESTRATION = ABSTRACT_PATTERN_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Pattern Library</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_LIBRARY_FEATURE_COUNT = ABSTRACT_PATTERN_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__ID = ABSTRACT_PATTERN_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__JAVA_IDENTIFIER = ABSTRACT_PATTERN_ELEMENT__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__NAME = ABSTRACT_PATTERN_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__DESCRIPTION = ABSTRACT_PATTERN_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__PATH = ABSTRACT_PATTERN_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Pattern Model</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL_FEATURE_COUNT = ABSTRACT_PATTERN_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Production Plan</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY__PRODUCTION_PLAN = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Production Plan Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY__PRODUCTION_PLAN_ID = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Factory</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Context Elements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__CONTEXT_ELEMENTS = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Context</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ELEMENT__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ELEMENT__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ELEMENT__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ELEMENT__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Contract Element Reference</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ELEMENT__VALUE = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Readable Value</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ELEMENT__READABLE_VALUE = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ELEMENT__KEY = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Contract Reference Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ELEMENT__CONTRACT_REFERENCE_ID = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Context Type</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ELEMENT__CONTEXT_TYPE = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Plugin Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ELEMENT__PLUGIN_ID = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Context Element</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_ELEMENT_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.TaskFactoryHolderImpl <em>Task Factory Holder</em>}' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see org.eclipse.egf.model.impl.TaskFactoryHolderImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getTaskFactoryHolder()
   * @generated
   */
  int TASK_FACTORY_HOLDER = 19;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_FACTORY_HOLDER__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_FACTORY_HOLDER__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_FACTORY_HOLDER__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_FACTORY_HOLDER__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Factory Class</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_FACTORY_HOLDER__FACTORY_CLASS = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Factory</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_FACTORY_HOLDER__FACTORY = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Task Factory Holder</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_FACTORY_HOLDER_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.MappingViewpointImpl <em>Mapping Viewpoint</em>}' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see org.eclipse.egf.model.impl.MappingViewpointImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getMappingViewpoint()
   * @generated
   */
  int MAPPING_VIEWPOINT = 20;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_VIEWPOINT__ID = ABSTRACT_VIEWPOINT__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_VIEWPOINT__JAVA_IDENTIFIER = ABSTRACT_VIEWPOINT__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_VIEWPOINT__NAME = ABSTRACT_VIEWPOINT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_VIEWPOINT__DESCRIPTION = ABSTRACT_VIEWPOINT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_VIEWPOINT__MAPPINGS = ABSTRACT_VIEWPOINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Mapping Viewpoint</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_VIEWPOINT_FEATURE_COUNT = ABSTRACT_VIEWPOINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.impl.MappingModelImpl <em>Mapping Model</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @see org.eclipse.egf.model.impl.MappingModelImpl
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getMappingModel()
   * @generated
   */
  int MAPPING_MODEL = 21;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_MODEL__ID = NAMED_MODEL_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Java Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_MODEL__JAVA_IDENTIFIER = NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_MODEL__NAME = NAMED_MODEL_ELEMENT_WITH_ID__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_MODEL__DESCRIPTION = NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_MODEL__PATH = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_MODEL__SOURCE = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_MODEL__TARGET = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Mapping Model</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_MODEL_FEATURE_COUNT = NAMED_MODEL_ELEMENT_WITH_ID_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.ViewpointType <em>Viewpoint Type</em>}' enum.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.egf.model.ViewpointType
   * @see org.eclipse.egf.model.impl.ModelPackageImpl#getViewpointType()
   * @generated
   */
  int VIEWPOINT_TYPE = 22;

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.NamedModelElementWithId <em>Named Model Element With Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Model Element With Id</em>'.
   * @see org.eclipse.egf.model.NamedModelElementWithId
   * @generated
   */
  EClass getNamedModelElementWithId();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.NamedModelElementWithId#getId <em>Id</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.egf.model.NamedModelElementWithId#getId()
   * @see #getNamedModelElementWithId()
   * @generated
   */
  EAttribute getNamedModelElementWithId_Id();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.NamedModelElementWithId#getJavaIdentifier <em>Java Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Java Identifier</em>'.
   * @see org.eclipse.egf.model.NamedModelElementWithId#getJavaIdentifier()
   * @see #getNamedModelElementWithId()
   * @generated
   */
  EAttribute getNamedModelElementWithId_JavaIdentifier();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.NamedModelElementWithId#getName <em>Name</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.egf.model.NamedModelElementWithId#getName()
   * @see #getNamedModelElementWithId()
   * @generated
   */
  EAttribute getNamedModelElementWithId_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.NamedModelElementWithId#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.eclipse.egf.model.NamedModelElementWithId#getDescription()
   * @see #getNamedModelElementWithId()
   * @generated
   */
  EAttribute getNamedModelElementWithId_Description();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.FactoryComponent <em>Factory Component</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Factory Component</em>'.
   * @see org.eclipse.egf.model.FactoryComponent
   * @generated
   */
  EClass getFactoryComponent();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.FactoryComponent#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the containment reference '<em>Domain</em>'.
   * @see org.eclipse.egf.model.FactoryComponent#getDomain()
   * @see #getFactoryComponent()
   * @generated
   */
  EReference getFactoryComponent_Domain();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.FactoryComponent#getSpecification <em>Specification</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Specification</em>'.
   * @see org.eclipse.egf.model.FactoryComponent#getSpecification()
   * @see #getFactoryComponent()
   * @generated
   */
  EReference getFactoryComponent_Specification();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.FactoryComponent#getFactory <em>Factory</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the containment reference '<em>Factory</em>'.
   * @see org.eclipse.egf.model.FactoryComponent#getFactory()
   * @see #getFactoryComponent()
   * @generated
   */
  EReference getFactoryComponent_Factory();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain</em>'.
   * @see org.eclipse.egf.model.Domain
   * @generated
   */
  EClass getDomain();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.Domain#getPath <em>Path</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Path</em>'.
   * @see org.eclipse.egf.model.Domain#getPath()
   * @see #getDomain()
   * @generated
   */
  EAttribute getDomain_Path();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.Specification <em>Specification</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Specification</em>'.
   * @see org.eclipse.egf.model.Specification
   * @generated
   */
  EClass getSpecification();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.Specification#getViewpoints <em>Viewpoints</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Viewpoints</em>'.
   * @see org.eclipse.egf.model.Specification#getViewpoints()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Viewpoints();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.Specification#getViewpointIds <em>Viewpoint Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Viewpoint Ids</em>'.
   * @see org.eclipse.egf.model.Specification#getViewpointIds()
   * @see #getSpecification()
   * @generated
   */
  EAttribute getSpecification_ViewpointIds();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.AbstractViewpoint <em>Abstract Viewpoint</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @return the meta object for class '<em>Abstract Viewpoint</em>'.
   * @see org.eclipse.egf.model.AbstractViewpoint
   * @generated
   */
  EClass getAbstractViewpoint();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.Contract <em>Contract</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Contract</em>'.
   * @see org.eclipse.egf.model.Contract
   * @generated
   */
  EClass getContract();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.Contract#getContractElements <em>Contract Elements</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contract Elements</em>'.
   * @see org.eclipse.egf.model.Contract#getContractElements()
   * @see #getContract()
   * @generated
   */
  EReference getContract_ContractElements();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.ContractElement <em>Contract Element</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Contract Element</em>'.
   * @see org.eclipse.egf.model.ContractElement
   * @generated
   */
  EClass getContractElement();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.ContractElement#getContractElementReferences <em>Contract Element References</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contract Element References</em>'.
   * @see org.eclipse.egf.model.ContractElement#getContractElementReferences()
   * @see #getContractElement()
   * @generated
   */
  EReference getContractElement_ContractElementReferences();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.ContractElement#getFactoryComponentId <em>Factory Component Id</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the attribute '<em>Factory Component Id</em>'.
   * @see org.eclipse.egf.model.ContractElement#getFactoryComponentId()
   * @see #getContractElement()
   * @generated
   */
  EAttribute getContractElement_FactoryComponentId();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.egf.model.ContractElement#getContractReferenceIds <em>Contract Reference Ids</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Contract Reference Ids</em>'.
   * @see org.eclipse.egf.model.ContractElement#getContractReferenceIds()
   * @see #getContractElement()
   * @generated
   */
  EAttribute getContractElement_ContractReferenceIds();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.ContractElement#getContractType <em>Contract Type</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Contract Type</em>'.
   * @see org.eclipse.egf.model.ContractElement#getContractType()
   * @see #getContractElement()
   * @generated
   */
  EReference getContractElement_ContractType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.ContractElement#isMandatory <em>Mandatory</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the attribute '<em>Mandatory</em>'.
   * @see org.eclipse.egf.model.ContractElement#isMandatory()
   * @see #getContractElement()
   * @generated
   */
  EAttribute getContractElement_Mandatory();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.ContractElementReference <em>Contract Element Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contract Element Reference</em>'.
   * @see org.eclipse.egf.model.ContractElementReference
   * @generated
   */
  EClass getContractElementReference();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.ContractElementReference#getReferencedContractElementId <em>Referenced Contract Element Id</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Referenced Contract Element Id</em>'.
   * @see org.eclipse.egf.model.ContractElementReference#getReferencedContractElementId()
   * @see #getContractElementReference()
   * @generated
   */
  EAttribute getContractElementReference_ReferencedContractElementId();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.ContractElementReference#getReferencedContractElementName <em>Referenced Contract Element Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Referenced Contract Element Name</em>'.
   * @see org.eclipse.egf.model.ContractElementReference#getReferencedContractElementName()
   * @see #getContractElementReference()
   * @generated
   */
  EAttribute getContractElementReference_ReferencedContractElementName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.ContractElementReference#getReferencedFactoryComponentId <em>Referenced FactoryComponent Id</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Referenced FactoryComponent Id</em>'.
   * @see org.eclipse.egf.model.ContractElementReference#getReferencedFactoryComponentId()
   * @see #getContractElementReference()
   * @generated
   */
  EAttribute getContractElementReference_ReferencedFactoryComponentId();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.ContractElementReference#getReferencedContractElement <em>Referenced Contract Element</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Referenced Contract Element</em>'.
   * @see org.eclipse.egf.model.ContractElementReference#getReferencedContractElement()
   * @see #getContractElementReference()
   * @generated
   */
  EReference getContractElementReference_ReferencedContractElement();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.Type <em>Type</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see org.eclipse.egf.model.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.Type#getTypeHolderClassName <em>Type Holder Class Name</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Holder Class Name</em>'.
   * @see org.eclipse.egf.model.Type#getTypeHolderClassName()
   * @see #getType()
   * @generated
   */
  EAttribute getType_TypeHolderClassName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.Type#getTypeHolder <em>Type Holder</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the attribute '<em>Type Holder</em>'.
   * @see org.eclipse.egf.model.Type#getTypeHolder()
   * @see #getType()
   * @generated
   */
  EAttribute getType_TypeHolder();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.PatternViewpoint <em>Pattern Viewpoint</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @return the meta object for class '<em>Pattern Viewpoint</em>'.
   * @see org.eclipse.egf.model.PatternViewpoint
   * @generated
   */
  EClass getPatternViewpoint();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.PatternViewpoint#getLibraries <em>Libraries</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Libraries</em>'.
   * @see org.eclipse.egf.model.PatternViewpoint#getLibraries()
   * @see #getPatternViewpoint()
   * @generated
   */
  EReference getPatternViewpoint_Libraries();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.AbstractPatternElement <em>Abstract Pattern Element</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for class '<em>Abstract Pattern Element</em>'.
   * @see org.eclipse.egf.model.AbstractPatternElement
   * @generated
   */
  EClass getAbstractPatternElement();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.PatternLibrary <em>Pattern Library</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern Library</em>'.
   * @see org.eclipse.egf.model.PatternLibrary
   * @generated
   */
  EClass getPatternLibrary();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.PatternLibrary#getPatternElements <em>Pattern Elements</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pattern Elements</em>'.
   * @see org.eclipse.egf.model.PatternLibrary#getPatternElements()
   * @see #getPatternLibrary()
   * @generated
   */
  EReference getPatternLibrary_PatternElements();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.PatternLibrary#getProductionOrchestration <em>Production Orchestration</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Production Orchestration</em>'.
   * @see org.eclipse.egf.model.PatternLibrary#getProductionOrchestration()
   * @see #getPatternLibrary()
   * @generated
   */
  EAttribute getPatternLibrary_ProductionOrchestration();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.PatternLibrary#getRuntimeOrchestration <em>Runtime Orchestration</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Runtime Orchestration</em>'.
   * @see org.eclipse.egf.model.PatternLibrary#getRuntimeOrchestration()
   * @see #getPatternLibrary()
   * @generated
   */
  EAttribute getPatternLibrary_RuntimeOrchestration();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.PatternModel <em>Pattern Model</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern Model</em>'.
   * @see org.eclipse.egf.model.PatternModel
   * @generated
   */
  EClass getPatternModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.PatternModel#getPath <em>Path</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Path</em>'.
   * @see org.eclipse.egf.model.PatternModel#getPath()
   * @see #getPatternModel()
   * @generated
   */
  EAttribute getPatternModel_Path();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.Factory <em>Factory</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Factory</em>'.
   * @see org.eclipse.egf.model.Factory
   * @generated
   */
  EClass getFactory();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.Factory#getProductionPlan <em>Production Plan</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Production Plan</em>'.
   * @see org.eclipse.egf.model.Factory#getProductionPlan()
   * @see #getFactory()
   * @generated
   */
  EReference getFactory_ProductionPlan();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.Factory#getProductionPlanId <em>Production Plan Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Production Plan Id</em>'.
   * @see org.eclipse.egf.model.Factory#getProductionPlanId()
   * @see #getFactory()
   * @generated
   */
  EAttribute getFactory_ProductionPlanId();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.AbstractFactoryComponentFactory <em>Abstract Factory Component Factory</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for class '<em>Abstract Factory Component Factory</em>'.
   * @see org.eclipse.egf.model.AbstractFactoryComponentFactory
   * @generated
   */
  EClass getAbstractFactoryComponentFactory();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.AbstractFactoryComponentFactory#getContext <em>Context</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Context</em>'.
   * @see org.eclipse.egf.model.AbstractFactoryComponentFactory#getContext()
   * @see #getAbstractFactoryComponentFactory()
   * @generated
   */
  EReference getAbstractFactoryComponentFactory_Context();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.AbstractFactoryComponentFactory#getContextId <em>Context Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Context Id</em>'.
   * @see org.eclipse.egf.model.AbstractFactoryComponentFactory#getContextId()
   * @see #getAbstractFactoryComponentFactory()
   * @generated
   */
  EAttribute getAbstractFactoryComponentFactory_ContextId();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.ProductionPlan <em>Production Plan</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Production Plan</em>'.
   * @see org.eclipse.egf.model.ProductionPlan
   * @generated
   */
  EClass getProductionPlan();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.ProductionPlan#getFactoryComponentInvocations <em>Factory Component Invocations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Factory Component Invocations</em>'.
   * @see org.eclipse.egf.model.ProductionPlan#getFactoryComponentInvocations()
   * @see #getProductionPlan()
   * @generated
   */
  EReference getProductionPlan_FactoryComponentInvocations();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.egf.model.ProductionPlan#getFactoryComponentInvocationIds <em>Factory Component Invocation Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Factory Component Invocation Ids</em>'.
   * @see org.eclipse.egf.model.ProductionPlan#getFactoryComponentInvocationIds()
   * @see #getProductionPlan()
   * @generated
   */
  EAttribute getProductionPlan_FactoryComponentInvocationIds();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.Context <em>Context</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Context</em>'.
   * @see org.eclipse.egf.model.Context
   * @generated
   */
  EClass getContext();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.Context#getContextElements <em>Context Elements</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Context Elements</em>'.
   * @see org.eclipse.egf.model.Context#getContextElements()
   * @see #getContext()
   * @generated
   */
  EReference getContext_ContextElements();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.ContextElement <em>Context Element</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Context Element</em>'.
   * @see org.eclipse.egf.model.ContextElement
   * @generated
   */
  EClass getContextElement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.ContextElement#getContractElementReference <em>Contract Element Reference</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Contract Element Reference</em>'.
   * @see org.eclipse.egf.model.ContextElement#getContractElementReference()
   * @see #getContextElement()
   * @generated
   */
  EReference getContextElement_ContractElementReference();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.ContextElement#getValue <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.ContextElement#getValue()
   * @see #getContextElement()
   * @generated
   */
  EAttribute getContextElement_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.ContextElement#getReadableValue <em>Readable Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Readable Value</em>'.
   * @see org.eclipse.egf.model.ContextElement#getReadableValue()
   * @see #getContextElement()
   * @generated
   */
  EAttribute getContextElement_ReadableValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.ContextElement#getKey <em>Key</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see org.eclipse.egf.model.ContextElement#getKey()
   * @see #getContextElement()
   * @generated
   */
  EAttribute getContextElement_Key();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.ContextElement#getContractReferenceId <em>Contract Reference Id</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Contract Reference Id</em>'.
   * @see org.eclipse.egf.model.ContextElement#getContractReferenceId()
   * @see #getContextElement()
   * @generated
   */
  EAttribute getContextElement_ContractReferenceId();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.ContextElement#getContextType <em>Context Type</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Context Type</em>'.
   * @see org.eclipse.egf.model.ContextElement#getContextType()
   * @see #getContextElement()
   * @generated
   */
  EReference getContextElement_ContextType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.ContextElement#getPluginId <em>Plugin Id</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the attribute '<em>Plugin Id</em>'.
   * @see org.eclipse.egf.model.ContextElement#getPluginId()
   * @see #getContextElement()
   * @generated
   */
  EAttribute getContextElement_PluginId();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.FactoryComponentInvocation <em>Factory Component Invocation</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for class '<em>Factory Component Invocation</em>'.
   * @see org.eclipse.egf.model.FactoryComponentInvocation
   * @generated
   */
  EClass getFactoryComponentInvocation();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.FactoryComponentInvocation#getTaskFactoryId <em>Task Factory Id</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Task Factory Id</em>'.
   * @see org.eclipse.egf.model.FactoryComponentInvocation#getTaskFactoryId()
   * @see #getFactoryComponentInvocation()
   * @generated
   */
  EAttribute getFactoryComponentInvocation_TaskFactoryId();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.FactoryComponentInvocation#getFactoryComponentId <em>Factory Component Id</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the attribute '<em>Factory Component Id</em>'.
   * @see org.eclipse.egf.model.FactoryComponentInvocation#getFactoryComponentId()
   * @see #getFactoryComponentInvocation()
   * @generated
   */
  EAttribute getFactoryComponentInvocation_FactoryComponentId();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.FactoryComponentInvocation#getTaskFactory <em>Task Factory</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Task Factory</em>'.
   * @see org.eclipse.egf.model.FactoryComponentInvocation#getTaskFactory()
   * @see #getFactoryComponentInvocation()
   * @generated
   */
  EReference getFactoryComponentInvocation_TaskFactory();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.TaskFactoryHolder <em>Task Factory Holder</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @return the meta object for class '<em>Task Factory Holder</em>'.
   * @see org.eclipse.egf.model.TaskFactoryHolder
   * @generated
   */
  EClass getTaskFactoryHolder();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.TaskFactoryHolder#getFactoryClass <em>Factory Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Factory Class</em>'.
   * @see org.eclipse.egf.model.TaskFactoryHolder#getFactoryClass()
   * @see #getTaskFactoryHolder()
   * @generated
   */
  EAttribute getTaskFactoryHolder_FactoryClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.TaskFactoryHolder#getFactory <em>Factory</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the attribute '<em>Factory</em>'.
   * @see org.eclipse.egf.model.TaskFactoryHolder#getFactory()
   * @see #getTaskFactoryHolder()
   * @generated
   */
  EAttribute getTaskFactoryHolder_Factory();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.MappingViewpoint <em>Mapping Viewpoint</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @return the meta object for class '<em>Mapping Viewpoint</em>'.
   * @see org.eclipse.egf.model.MappingViewpoint
   * @generated
   */
  EClass getMappingViewpoint();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.MappingViewpoint#getMappings <em>Mappings</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mappings</em>'.
   * @see org.eclipse.egf.model.MappingViewpoint#getMappings()
   * @see #getMappingViewpoint()
   * @generated
   */
  EReference getMappingViewpoint_Mappings();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.MappingModel <em>Mapping Model</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Mapping Model</em>'.
   * @see org.eclipse.egf.model.MappingModel
   * @generated
   */
  EClass getMappingModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.MappingModel#getPath <em>Path</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Path</em>'.
   * @see org.eclipse.egf.model.MappingModel#getPath()
   * @see #getMappingModel()
   * @generated
   */
  EAttribute getMappingModel_Path();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.MappingModel#getSource <em>Source</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @return the meta object for the attribute '<em>Source</em>'.
   * @see org.eclipse.egf.model.MappingModel#getSource()
   * @see #getMappingModel()
   * @generated
   */
  EAttribute getMappingModel_Source();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.MappingModel#getTarget <em>Target</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @return the meta object for the attribute '<em>Target</em>'.
   * @see org.eclipse.egf.model.MappingModel#getTarget()
   * @see #getMappingModel()
   * @generated
   */
  EAttribute getMappingModel_Target();

  /**
   * Returns the meta object for enum '{@link org.eclipse.egf.model.ViewpointType <em>Viewpoint Type</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for enum '<em>Viewpoint Type</em>'.
   * @see org.eclipse.egf.model.ViewpointType
   * @generated
   */
  EEnum getViewpointType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ModelFactory getModelFactory();

  /**
   * <!-- begin-user-doc --> Defines literals for the meta objects that represent
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
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.NamedModelElementWithIdImpl <em>Named Model Element With Id</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.egf.model.impl.NamedModelElementWithIdImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getNamedModelElementWithId()
     * @generated
     */
    EClass NAMED_MODEL_ELEMENT_WITH_ID = eINSTANCE.getNamedModelElementWithId();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_MODEL_ELEMENT_WITH_ID__ID = eINSTANCE.getNamedModelElementWithId_Id();

    /**
     * The meta object literal for the '<em><b>Java Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER = eINSTANCE.getNamedModelElementWithId_JavaIdentifier();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_MODEL_ELEMENT_WITH_ID__NAME = eINSTANCE.getNamedModelElementWithId_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION = eINSTANCE.getNamedModelElementWithId_Description();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.FactoryComponentImpl <em>Factory Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.impl.FactoryComponentImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getFactoryComponent()
     * @generated
     */
    EClass FACTORY_COMPONENT = eINSTANCE.getFactoryComponent();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT__DOMAIN = eINSTANCE.getFactoryComponent_Domain();

    /**
     * The meta object literal for the '<em><b>Specification</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT__SPECIFICATION = eINSTANCE.getFactoryComponent_Specification();

    /**
     * The meta object literal for the '<em><b>Factory</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT__FACTORY = eINSTANCE.getFactoryComponent_Factory();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.DomainImpl <em>Domain</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.egf.model.impl.DomainImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getDomain()
     * @generated
     */
    EClass DOMAIN = eINSTANCE.getDomain();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOMAIN__PATH = eINSTANCE.getDomain_Path();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.SpecificationImpl <em>Specification</em>}' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see org.eclipse.egf.model.impl.SpecificationImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getSpecification()
     * @generated
     */
    EClass SPECIFICATION = eINSTANCE.getSpecification();

    /**
     * The meta object literal for the '<em><b>Viewpoints</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__VIEWPOINTS = eINSTANCE.getSpecification_Viewpoints();

    /**
     * The meta object literal for the '<em><b>Viewpoint Ids</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPECIFICATION__VIEWPOINT_IDS = eINSTANCE.getSpecification_ViewpointIds();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.AbstractViewpointImpl <em>Abstract Viewpoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.impl.AbstractViewpointImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getAbstractViewpoint()
     * @generated
     */
    EClass ABSTRACT_VIEWPOINT = eINSTANCE.getAbstractViewpoint();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.ContractImpl <em>Contract</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.egf.model.impl.ContractImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getContract()
     * @generated
     */
    EClass CONTRACT = eINSTANCE.getContract();

    /**
     * The meta object literal for the '<em><b>Contract Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT__CONTRACT_ELEMENTS = eINSTANCE.getContract_ContractElements();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.ContractElementImpl <em>Contract Element</em>}' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see org.eclipse.egf.model.impl.ContractElementImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getContractElement()
     * @generated
     */
    EClass CONTRACT_ELEMENT = eINSTANCE.getContractElement();

    /**
     * The meta object literal for the '<em><b>Contract Element References</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference CONTRACT_ELEMENT__CONTRACT_ELEMENT_REFERENCES = eINSTANCE.getContractElement_ContractElementReferences();

    /**
     * The meta object literal for the '<em><b>Factory Component Id</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACT_ELEMENT__FACTORY_COMPONENT_ID = eINSTANCE.getContractElement_FactoryComponentId();

    /**
     * The meta object literal for the '<em><b>Contract Reference Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACT_ELEMENT__CONTRACT_REFERENCE_IDS = eINSTANCE.getContractElement_ContractReferenceIds();

    /**
     * The meta object literal for the '<em><b>Contract Type</b></em>' containment reference feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT_ELEMENT__CONTRACT_TYPE = eINSTANCE.getContractElement_ContractType();

    /**
     * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACT_ELEMENT__MANDATORY = eINSTANCE.getContractElement_Mandatory();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.ContractElementReferenceImpl <em>Contract Element Reference</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.egf.model.impl.ContractElementReferenceImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getContractElementReference()
     * @generated
     */
    EClass CONTRACT_ELEMENT_REFERENCE = eINSTANCE.getContractElementReference();

    /**
     * The meta object literal for the '<em><b>Referenced Contract Element Id</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_ID = eINSTANCE.getContractElementReference_ReferencedContractElementId();

    /**
     * The meta object literal for the '<em><b>Referenced Contract Element Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_NAME = eINSTANCE.getContractElementReference_ReferencedContractElementName();

    /**
     * The meta object literal for the '<em><b>Referenced Factory Component Id</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACT_ELEMENT_REFERENCE__REFERENCED_FACTORY_COMPONENT_ID = eINSTANCE.getContractElementReference_ReferencedFactoryComponentId();

    /**
     * The meta object literal for the '<em><b>Referenced Contract Element</b></em>' reference feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT = eINSTANCE.getContractElementReference_ReferencedContractElement();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.egf.model.impl.TypeImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Type Holder Class Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__TYPE_HOLDER_CLASS_NAME = eINSTANCE.getType_TypeHolderClassName();

    /**
     * The meta object literal for the '<em><b>Type Holder</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__TYPE_HOLDER = eINSTANCE.getType_TypeHolder();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.PatternViewpointImpl <em>Pattern Viewpoint</em>}' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see org.eclipse.egf.model.impl.PatternViewpointImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getPatternViewpoint()
     * @generated
     */
    EClass PATTERN_VIEWPOINT = eINSTANCE.getPatternViewpoint();

    /**
     * The meta object literal for the '<em><b>Libraries</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_VIEWPOINT__LIBRARIES = eINSTANCE.getPatternViewpoint_Libraries();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.AbstractPatternElementImpl <em>Abstract Pattern Element</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.egf.model.impl.AbstractPatternElementImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getAbstractPatternElement()
     * @generated
     */
    EClass ABSTRACT_PATTERN_ELEMENT = eINSTANCE.getAbstractPatternElement();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.PatternLibraryImpl <em>Pattern Library</em>}' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see org.eclipse.egf.model.impl.PatternLibraryImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getPatternLibrary()
     * @generated
     */
    EClass PATTERN_LIBRARY = eINSTANCE.getPatternLibrary();

    /**
     * The meta object literal for the '<em><b>Pattern Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_LIBRARY__PATTERN_ELEMENTS = eINSTANCE.getPatternLibrary_PatternElements();

    /**
     * The meta object literal for the '<em><b>Production Orchestration</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN_LIBRARY__PRODUCTION_ORCHESTRATION = eINSTANCE.getPatternLibrary_ProductionOrchestration();

    /**
     * The meta object literal for the '<em><b>Runtime Orchestration</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN_LIBRARY__RUNTIME_ORCHESTRATION = eINSTANCE.getPatternLibrary_RuntimeOrchestration();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.PatternModelImpl <em>Pattern Model</em>}' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see org.eclipse.egf.model.impl.PatternModelImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getPatternModel()
     * @generated
     */
    EClass PATTERN_MODEL = eINSTANCE.getPatternModel();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN_MODEL__PATH = eINSTANCE.getPatternModel_Path();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.FactoryImpl <em>Factory</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.egf.model.impl.FactoryImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getFactory()
     * @generated
     */
    EClass FACTORY = eINSTANCE.getFactory();

    /**
     * The meta object literal for the '<em><b>Production Plan</b></em>' containment reference feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY__PRODUCTION_PLAN = eINSTANCE.getFactory_ProductionPlan();

    /**
     * The meta object literal for the '<em><b>Production Plan Id</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute FACTORY__PRODUCTION_PLAN_ID = eINSTANCE.getFactory_ProductionPlanId();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.AbstractFactoryComponentFactoryImpl <em>Abstract Factory Component Factory</em>}' class.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see org.eclipse.egf.model.impl.AbstractFactoryComponentFactoryImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getAbstractFactoryComponentFactory()
     * @generated
     */
    EClass ABSTRACT_FACTORY_COMPONENT_FACTORY = eINSTANCE.getAbstractFactoryComponentFactory();

    /**
     * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT = eINSTANCE.getAbstractFactoryComponentFactory_Context();

    /**
     * The meta object literal for the '<em><b>Context Id</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT_ID = eINSTANCE.getAbstractFactoryComponentFactory_ContextId();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.ProductionPlanImpl <em>Production Plan</em>}' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see org.eclipse.egf.model.impl.ProductionPlanImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getProductionPlan()
     * @generated
     */
    EClass PRODUCTION_PLAN = eINSTANCE.getProductionPlan();

    /**
     * The meta object literal for the '<em><b>Factory Component Invocations</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS = eINSTANCE.getProductionPlan_FactoryComponentInvocations();

    /**
     * The meta object literal for the '<em><b>Factory Component Invocation Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATION_IDS = eINSTANCE.getProductionPlan_FactoryComponentInvocationIds();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.ContextImpl <em>Context</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.egf.model.impl.ContextImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getContext()
     * @generated
     */
    EClass CONTEXT = eINSTANCE.getContext();

    /**
     * The meta object literal for the '<em><b>Context Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT__CONTEXT_ELEMENTS = eINSTANCE.getContext_ContextElements();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.ContextElementImpl <em>Context Element</em>}' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see org.eclipse.egf.model.impl.ContextElementImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getContextElement()
     * @generated
     */
    EClass CONTEXT_ELEMENT = eINSTANCE.getContextElement();

    /**
     * The meta object literal for the '<em><b>Contract Element Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE = eINSTANCE.getContextElement_ContractElementReference();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTEXT_ELEMENT__VALUE = eINSTANCE.getContextElement_Value();

    /**
     * The meta object literal for the '<em><b>Readable Value</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTEXT_ELEMENT__READABLE_VALUE = eINSTANCE.getContextElement_ReadableValue();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTEXT_ELEMENT__KEY = eINSTANCE.getContextElement_Key();

    /**
     * The meta object literal for the '<em><b>Contract Reference Id</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTEXT_ELEMENT__CONTRACT_REFERENCE_ID = eINSTANCE.getContextElement_ContractReferenceId();

    /**
     * The meta object literal for the '<em><b>Context Type</b></em>' containment reference feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_ELEMENT__CONTEXT_TYPE = eINSTANCE.getContextElement_ContextType();

    /**
     * The meta object literal for the '<em><b>Plugin Id</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTEXT_ELEMENT__PLUGIN_ID = eINSTANCE.getContextElement_PluginId();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.FactoryComponentInvocationImpl <em>Factory Component Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.impl.FactoryComponentInvocationImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getFactoryComponentInvocation()
     * @generated
     */
    EClass FACTORY_COMPONENT_INVOCATION = eINSTANCE.getFactoryComponentInvocation();

    /**
     * The meta object literal for the '<em><b>Task Factory Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FACTORY_COMPONENT_INVOCATION__TASK_FACTORY_ID = eINSTANCE.getFactoryComponentInvocation_TaskFactoryId();

    /**
     * The meta object literal for the '<em><b>Factory Component Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT_ID = eINSTANCE.getFactoryComponentInvocation_FactoryComponentId();

    /**
     * The meta object literal for the '<em><b>Task Factory</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT_INVOCATION__TASK_FACTORY = eINSTANCE.getFactoryComponentInvocation_TaskFactory();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.TaskFactoryHolderImpl <em>Task Factory Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.impl.TaskFactoryHolderImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getTaskFactoryHolder()
     * @generated
     */
    EClass TASK_FACTORY_HOLDER = eINSTANCE.getTaskFactoryHolder();

    /**
     * The meta object literal for the '<em><b>Factory Class</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute TASK_FACTORY_HOLDER__FACTORY_CLASS = eINSTANCE.getTaskFactoryHolder_FactoryClass();

    /**
     * The meta object literal for the '<em><b>Factory</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute TASK_FACTORY_HOLDER__FACTORY = eINSTANCE.getTaskFactoryHolder_Factory();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.MappingViewpointImpl <em>Mapping Viewpoint</em>}' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see org.eclipse.egf.model.impl.MappingViewpointImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getMappingViewpoint()
     * @generated
     */
    EClass MAPPING_VIEWPOINT = eINSTANCE.getMappingViewpoint();

    /**
     * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference MAPPING_VIEWPOINT__MAPPINGS = eINSTANCE.getMappingViewpoint_Mappings();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.impl.MappingModelImpl <em>Mapping Model</em>}' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see org.eclipse.egf.model.impl.MappingModelImpl
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getMappingModel()
     * @generated
     */
    EClass MAPPING_MODEL = eINSTANCE.getMappingModel();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAPPING_MODEL__PATH = eINSTANCE.getMappingModel_Path();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAPPING_MODEL__SOURCE = eINSTANCE.getMappingModel_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAPPING_MODEL__TARGET = eINSTANCE.getMappingModel_Target();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.ViewpointType <em>Viewpoint Type</em>}' enum.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.egf.model.ViewpointType
     * @see org.eclipse.egf.model.impl.ModelPackageImpl#getViewpointType()
     * @generated
     */
    EEnum VIEWPOINT_TYPE = eINSTANCE.getViewpointType();

  }

} // ModelPackage
