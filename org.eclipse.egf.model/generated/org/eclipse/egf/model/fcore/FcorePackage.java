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
package org.eclipse.egf.model.fcore;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.egf.model.fcore.FcoreFactory
 * @model kind="package"
 * @generated
 */
public interface FcorePackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "fcore"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/egf/1.0.0/fcore"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "fcore"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FcorePackage eINSTANCE = org.eclipse.egf.model.fcore.impl.FcorePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ModelElementImpl <em>Model Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ModelElementImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getModelElement()
   * @generated
   */
  int MODEL_ELEMENT = 0;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__ID = 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__DESCRIPTION = 1;

  /**
   * The number of structural features of the '<em>Model Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.NamedModelElementImpl <em>Named Model Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.NamedModelElementImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getNamedModelElement()
   * @generated
   */
  int NAMED_MODEL_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_MODEL_ELEMENT__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_MODEL_ELEMENT__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_MODEL_ELEMENT__NAME = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Named Model Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_MODEL_ELEMENT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ActivityImpl <em>Activity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ActivityImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getActivity()
   * @generated
   */
  int ACTIVITY = 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY__ID = NAMED_MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY__DESCRIPTION = NAMED_MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY__NAME = NAMED_MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Contract Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY__CONTRACT_CONTAINER = NAMED_MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Activity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_FEATURE_COUNT = NAMED_MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ContractImpl <em>Contract</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ContractImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContract()
   * @generated
   */
  int CONTRACT = 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__ID = NAMED_MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__DESCRIPTION = NAMED_MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__NAME = NAMED_MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Contract Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__CONTRACT_CONTAINER = NAMED_MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Mandatory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__MANDATORY = NAMED_MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__MODE = NAMED_MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__TYPE = NAMED_MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Contract</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_FEATURE_COUNT = NAMED_MODEL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.FactoryComponentImpl <em>Factory Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.FactoryComponentImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getFactoryComponent()
   * @generated
   */
  int FACTORY_COMPONENT = 4;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__ID = ACTIVITY__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__DESCRIPTION = ACTIVITY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__NAME = ACTIVITY__NAME;

  /**
   * The feature id for the '<em><b>Contract Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__CONTRACT_CONTAINER = ACTIVITY__CONTRACT_CONTAINER;

  /**
   * The feature id for the '<em><b>Viewpoint Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__VIEWPOINT_CONTAINER = ACTIVITY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Orchestration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__ORCHESTRATION = ACTIVITY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Factory Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_FEATURE_COUNT = ACTIVITY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ContractContainerImpl <em>Contract Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ContractContainerImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContractContainer()
   * @generated
   */
  int CONTRACT_CONTAINER = 5;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONTAINER__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONTAINER__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Activity</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONTAINER__ACTIVITY = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Contracts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONTAINER__CONTRACTS = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Contract Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONTAINER_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.FactoryComponentContractImpl <em>Factory Component Contract</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.FactoryComponentContractImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getFactoryComponentContract()
   * @generated
   */
  int FACTORY_COMPONENT_CONTRACT = 6;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__ID = CONTRACT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__DESCRIPTION = CONTRACT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__NAME = CONTRACT__NAME;

  /**
   * The feature id for the '<em><b>Contract Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__CONTRACT_CONTAINER = CONTRACT__CONTRACT_CONTAINER;

  /**
   * The feature id for the '<em><b>Mandatory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__MANDATORY = CONTRACT__MANDATORY;

  /**
   * The feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__MODE = CONTRACT__MODE;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__TYPE = CONTRACT__TYPE;

  /**
   * The feature id for the '<em><b>Invocation Contracts</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS = CONTRACT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Factory Component Contract</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT_FEATURE_COUNT = CONTRACT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ViewpointContainerImpl <em>Viewpoint Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ViewpointContainerImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getViewpointContainer()
   * @generated
   */
  int VIEWPOINT_CONTAINER = 7;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ViewpointImpl <em>Viewpoint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ViewpointImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getViewpoint()
   * @generated
   */
  int VIEWPOINT = 8;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.OrchestrationImpl <em>Orchestration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.OrchestrationImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getOrchestration()
   * @generated
   */
  int ORCHESTRATION = 9;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.InvocationImpl <em>Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.InvocationImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocation()
   * @generated
   */
  int INVOCATION = 12;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT_CONTAINER__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT_CONTAINER__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Factory Component</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT_CONTAINER__FACTORY_COMPONENT = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Viewpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT_CONTAINER__VIEWPOINTS = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Viewpoint Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT_CONTAINER_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Viewpoint Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT__VIEWPOINT_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Viewpoint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Factory Component</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION__FACTORY_COMPONENT = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Orchestration Parameter Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Orchestration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.OrchestrationParameterContainerImpl <em>Orchestration Parameter Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.OrchestrationParameterContainerImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getOrchestrationParameterContainer()
   * @generated
   */
  int ORCHESTRATION_PARAMETER_CONTAINER = 10;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_PARAMETER_CONTAINER__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_PARAMETER_CONTAINER__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Orchestration</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_PARAMETER_CONTAINER__ORCHESTRATION = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Orchestration Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_PARAMETER_CONTAINER__ORCHESTRATION_PARAMETERS = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Orchestration Parameter Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_PARAMETER_CONTAINER_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.OrchestrationParameterImpl <em>Orchestration Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.OrchestrationParameterImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getOrchestrationParameter()
   * @generated
   */
  int ORCHESTRATION_PARAMETER = 11;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_PARAMETER__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_PARAMETER__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Orchestration Parameter Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Invocation Contracts</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_PARAMETER__INVOCATION_CONTRACTS = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_PARAMETER__TYPE = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Orchestration Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_PARAMETER_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Invocation Contract Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__INVOCATION_CONTRACT_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Invoked Activity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__INVOKED_ACTIVITY = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.InvocationContractContainerImpl <em>Invocation Contract Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.InvocationContractContainerImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocationContractContainer()
   * @generated
   */
  int INVOCATION_CONTRACT_CONTAINER = 13;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT_CONTAINER__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT_CONTAINER__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Invocation</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT_CONTAINER__INVOCATION = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Invocation Contracts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT_CONTAINER__INVOCATION_CONTRACTS = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Invocation Contract Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT_CONTAINER_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.InvocationContractImpl <em>Invocation Contract</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.InvocationContractImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocationContract()
   * @generated
   */
  int INVOCATION_CONTRACT = 14;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Invocation Contract Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Factory Component Contract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Orchestration Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Source Invocation Contract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT = MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Target Invocation Contract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT = MODEL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Invoked Contract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT__INVOKED_CONTRACT = MODEL_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Invoked Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT__INVOKED_MODE = MODEL_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT__TYPE = MODEL_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Invocation Contract</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTRACT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.ContractMode <em>Contract Mode</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.ContractMode
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContractMode()
   * @generated
   */
  int CONTRACT_MODE = 15;

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Element</em>'.
   * @see org.eclipse.egf.model.fcore.ModelElement
   * @generated
   */
  EClass getModelElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.fcore.ModelElement#getID <em>ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>ID</em>'.
   * @see org.eclipse.egf.model.fcore.ModelElement#getID()
   * @see #getModelElement()
   * @generated
   */
  EAttribute getModelElement_ID();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.fcore.ModelElement#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.eclipse.egf.model.fcore.ModelElement#getDescription()
   * @see #getModelElement()
   * @generated
   */
  EAttribute getModelElement_Description();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.NamedModelElement <em>Named Model Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Model Element</em>'.
   * @see org.eclipse.egf.model.fcore.NamedModelElement
   * @generated
   */
  EClass getNamedModelElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.fcore.NamedModelElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.egf.model.fcore.NamedModelElement#getName()
   * @see #getNamedModelElement()
   * @generated
   */
  EAttribute getNamedModelElement_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.Activity <em>Activity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Activity</em>'.
   * @see org.eclipse.egf.model.fcore.Activity
   * @generated
   */
  EClass getActivity();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.Activity#getContractContainer <em>Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Contract Container</em>'.
   * @see org.eclipse.egf.model.fcore.Activity#getContractContainer()
   * @see #getActivity()
   * @generated
   */
  EReference getActivity_ContractContainer();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.Contract <em>Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contract</em>'.
   * @see org.eclipse.egf.model.fcore.Contract
   * @generated
   */
  EClass getContract();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.Contract#getContractContainer <em>Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Contract Container</em>'.
   * @see org.eclipse.egf.model.fcore.Contract#getContractContainer()
   * @see #getContract()
   * @generated
   */
  EReference getContract_ContractContainer();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.fcore.Contract#isMandatory <em>Mandatory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mandatory</em>'.
   * @see org.eclipse.egf.model.fcore.Contract#isMandatory()
   * @see #getContract()
   * @generated
   */
  EAttribute getContract_Mandatory();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.fcore.Contract#getMode <em>Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mode</em>'.
   * @see org.eclipse.egf.model.fcore.Contract#getMode()
   * @see #getContract()
   * @generated
   */
  EAttribute getContract_Mode();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.Contract#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.egf.model.fcore.Contract#getType()
   * @see #getContract()
   * @generated
   */
  EReference getContract_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.FactoryComponent <em>Factory Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Factory Component</em>'.
   * @see org.eclipse.egf.model.fcore.FactoryComponent
   * @generated
   */
  EClass getFactoryComponent();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.FactoryComponent#getViewpointContainer <em>Viewpoint Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Viewpoint Container</em>'.
   * @see org.eclipse.egf.model.fcore.FactoryComponent#getViewpointContainer()
   * @see #getFactoryComponent()
   * @generated
   */
  EReference getFactoryComponent_ViewpointContainer();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.FactoryComponent#getOrchestration <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Orchestration</em>'.
   * @see org.eclipse.egf.model.fcore.FactoryComponent#getOrchestration()
   * @see #getFactoryComponent()
   * @generated
   */
  EReference getFactoryComponent_Orchestration();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.ContractContainer <em>Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contract Container</em>'.
   * @see org.eclipse.egf.model.fcore.ContractContainer
   * @generated
   */
  EClass getContractContainer();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.ContractContainer#getActivity <em>Activity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Activity</em>'.
   * @see org.eclipse.egf.model.fcore.ContractContainer#getActivity()
   * @see #getContractContainer()
   * @generated
   */
  EReference getContractContainer_Activity();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.fcore.ContractContainer#getContracts <em>Contracts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contracts</em>'.
   * @see org.eclipse.egf.model.fcore.ContractContainer#getContracts()
   * @see #getContractContainer()
   * @generated
   */
  EReference getContractContainer_Contracts();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.FactoryComponentContract <em>Factory Component Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Factory Component Contract</em>'.
   * @see org.eclipse.egf.model.fcore.FactoryComponentContract
   * @generated
   */
  EClass getFactoryComponentContract();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.egf.model.fcore.FactoryComponentContract#getInvocationContracts <em>Invocation Contracts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Invocation Contracts</em>'.
   * @see org.eclipse.egf.model.fcore.FactoryComponentContract#getInvocationContracts()
   * @see #getFactoryComponentContract()
   * @generated
   */
  EReference getFactoryComponentContract_InvocationContracts();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.ViewpointContainer <em>Viewpoint Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Viewpoint Container</em>'.
   * @see org.eclipse.egf.model.fcore.ViewpointContainer
   * @generated
   */
  EClass getViewpointContainer();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.ViewpointContainer#getFactoryComponent <em>Factory Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Factory Component</em>'.
   * @see org.eclipse.egf.model.fcore.ViewpointContainer#getFactoryComponent()
   * @see #getViewpointContainer()
   * @generated
   */
  EReference getViewpointContainer_FactoryComponent();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.fcore.ViewpointContainer#getViewpoints <em>Viewpoints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Viewpoints</em>'.
   * @see org.eclipse.egf.model.fcore.ViewpointContainer#getViewpoints()
   * @see #getViewpointContainer()
   * @generated
   */
  EReference getViewpointContainer_Viewpoints();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.Viewpoint <em>Viewpoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Viewpoint</em>'.
   * @see org.eclipse.egf.model.fcore.Viewpoint
   * @generated
   */
  EClass getViewpoint();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.Viewpoint#getViewpointContainer <em>Viewpoint Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Viewpoint Container</em>'.
   * @see org.eclipse.egf.model.fcore.Viewpoint#getViewpointContainer()
   * @see #getViewpoint()
   * @generated
   */
  EReference getViewpoint_ViewpointContainer();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.Orchestration <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Orchestration</em>'.
   * @see org.eclipse.egf.model.fcore.Orchestration
   * @generated
   */
  EClass getOrchestration();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.Orchestration#getFactoryComponent <em>Factory Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Factory Component</em>'.
   * @see org.eclipse.egf.model.fcore.Orchestration#getFactoryComponent()
   * @see #getOrchestration()
   * @generated
   */
  EReference getOrchestration_FactoryComponent();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.Orchestration#getOrchestrationParameterContainer <em>Orchestration Parameter Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Orchestration Parameter Container</em>'.
   * @see org.eclipse.egf.model.fcore.Orchestration#getOrchestrationParameterContainer()
   * @see #getOrchestration()
   * @generated
   */
  EReference getOrchestration_OrchestrationParameterContainer();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.OrchestrationParameterContainer <em>Orchestration Parameter Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Orchestration Parameter Container</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationParameterContainer
   * @generated
   */
  EClass getOrchestrationParameterContainer();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.OrchestrationParameterContainer#getOrchestration <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Orchestration</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationParameterContainer#getOrchestration()
   * @see #getOrchestrationParameterContainer()
   * @generated
   */
  EReference getOrchestrationParameterContainer_Orchestration();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.fcore.OrchestrationParameterContainer#getOrchestrationParameters <em>Orchestration Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Orchestration Parameters</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationParameterContainer#getOrchestrationParameters()
   * @see #getOrchestrationParameterContainer()
   * @generated
   */
  EReference getOrchestrationParameterContainer_OrchestrationParameters();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.OrchestrationParameter <em>Orchestration Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Orchestration Parameter</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationParameter
   * @generated
   */
  EClass getOrchestrationParameter();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.OrchestrationParameter#getOrchestrationParameterContainer <em>Orchestration Parameter Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Orchestration Parameter Container</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationParameter#getOrchestrationParameterContainer()
   * @see #getOrchestrationParameter()
   * @generated
   */
  EReference getOrchestrationParameter_OrchestrationParameterContainer();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.egf.model.fcore.OrchestrationParameter#getInvocationContracts <em>Invocation Contracts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Invocation Contracts</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationParameter#getInvocationContracts()
   * @see #getOrchestrationParameter()
   * @generated
   */
  EReference getOrchestrationParameter_InvocationContracts();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.OrchestrationParameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationParameter#getType()
   * @see #getOrchestrationParameter()
   * @generated
   */
  EReference getOrchestrationParameter_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.Invocation <em>Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invocation</em>'.
   * @see org.eclipse.egf.model.fcore.Invocation
   * @generated
   */
  EClass getInvocation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.Invocation#getInvocationContractContainer <em>Invocation Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Invocation Contract Container</em>'.
   * @see org.eclipse.egf.model.fcore.Invocation#getInvocationContractContainer()
   * @see #getInvocation()
   * @generated
   */
  EReference getInvocation_InvocationContractContainer();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.Invocation#getInvokedActivity <em>Invoked Activity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Invoked Activity</em>'.
   * @see org.eclipse.egf.model.fcore.Invocation#getInvokedActivity()
   * @see #getInvocation()
   * @generated
   */
  EReference getInvocation_InvokedActivity();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.InvocationContractContainer <em>Invocation Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invocation Contract Container</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContractContainer
   * @generated
   */
  EClass getInvocationContractContainer();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.InvocationContractContainer#getInvocation <em>Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Invocation</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContractContainer#getInvocation()
   * @see #getInvocationContractContainer()
   * @generated
   */
  EReference getInvocationContractContainer_Invocation();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.fcore.InvocationContractContainer#getInvocationContracts <em>Invocation Contracts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Invocation Contracts</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContractContainer#getInvocationContracts()
   * @see #getInvocationContractContainer()
   * @generated
   */
  EReference getInvocationContractContainer_InvocationContracts();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.InvocationContract <em>Invocation Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invocation Contract</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContract
   * @generated
   */
  EClass getInvocationContract();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.InvocationContract#getInvocationContractContainer <em>Invocation Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Invocation Contract Container</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContract#getInvocationContractContainer()
   * @see #getInvocationContract()
   * @generated
   */
  EReference getInvocationContract_InvocationContractContainer();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.InvocationContract#getFactoryComponentContract <em>Factory Component Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Factory Component Contract</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContract#getFactoryComponentContract()
   * @see #getInvocationContract()
   * @generated
   */
  EReference getInvocationContract_FactoryComponentContract();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.InvocationContract#getOrchestrationParameter <em>Orchestration Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Orchestration Parameter</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContract#getOrchestrationParameter()
   * @see #getInvocationContract()
   * @generated
   */
  EReference getInvocationContract_OrchestrationParameter();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.InvocationContract#getSourceInvocationContract <em>Source Invocation Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source Invocation Contract</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContract#getSourceInvocationContract()
   * @see #getInvocationContract()
   * @generated
   */
  EReference getInvocationContract_SourceInvocationContract();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.InvocationContract#getTargetInvocationContract <em>Target Invocation Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Invocation Contract</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContract#getTargetInvocationContract()
   * @see #getInvocationContract()
   * @generated
   */
  EReference getInvocationContract_TargetInvocationContract();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.InvocationContract#getInvokedContract <em>Invoked Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Invoked Contract</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContract#getInvokedContract()
   * @see #getInvocationContract()
   * @generated
   */
  EReference getInvocationContract_InvokedContract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.fcore.InvocationContract#getInvokedMode <em>Invoked Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Invoked Mode</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContract#getInvokedMode()
   * @see #getInvocationContract()
   * @generated
   */
  EAttribute getInvocationContract_InvokedMode();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.InvocationContract#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContract#getType()
   * @see #getInvocationContract()
   * @generated
   */
  EReference getInvocationContract_Type();

  /**
   * Returns the meta object for enum '{@link org.eclipse.egf.model.fcore.ContractMode <em>Contract Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Contract Mode</em>'.
   * @see org.eclipse.egf.model.fcore.ContractMode
   * @generated
   */
  EEnum getContractMode();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FcoreFactory getFcoreFactory();

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
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ModelElementImpl <em>Model Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ModelElementImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getModelElement()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

    /**
     * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EAttribute MODEL_ELEMENT__ID = eINSTANCE.getModelElement_ID();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EAttribute MODEL_ELEMENT__DESCRIPTION = eINSTANCE.getModelElement_Description();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.NamedModelElementImpl <em>Named Model Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.NamedModelElementImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getNamedModelElement()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass NAMED_MODEL_ELEMENT = eINSTANCE.getNamedModelElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EAttribute NAMED_MODEL_ELEMENT__NAME = eINSTANCE.getNamedModelElement_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ActivityImpl <em>Activity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ActivityImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getActivity()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass ACTIVITY = eINSTANCE.getActivity();

    /**
     * The meta object literal for the '<em><b>Contract Container</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference ACTIVITY__CONTRACT_CONTAINER = eINSTANCE.getActivity_ContractContainer();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ContractImpl <em>Contract</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ContractImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContract()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass CONTRACT = eINSTANCE.getContract();

    /**
     * The meta object literal for the '<em><b>Contract Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference CONTRACT__CONTRACT_CONTAINER = eINSTANCE.getContract_ContractContainer();

    /**
     * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EAttribute CONTRACT__MANDATORY = eINSTANCE.getContract_Mandatory();

    /**
     * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EAttribute CONTRACT__MODE = eINSTANCE.getContract_Mode();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference CONTRACT__TYPE = eINSTANCE.getContract_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.FactoryComponentImpl <em>Factory Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.FactoryComponentImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getFactoryComponent()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass FACTORY_COMPONENT = eINSTANCE.getFactoryComponent();

    /**
     * The meta object literal for the '<em><b>Viewpoint Container</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference FACTORY_COMPONENT__VIEWPOINT_CONTAINER = eINSTANCE.getFactoryComponent_ViewpointContainer();

    /**
     * The meta object literal for the '<em><b>Orchestration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference FACTORY_COMPONENT__ORCHESTRATION = eINSTANCE.getFactoryComponent_Orchestration();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ContractContainerImpl <em>Contract Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ContractContainerImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContractContainer()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass CONTRACT_CONTAINER = eINSTANCE.getContractContainer();

    /**
     * The meta object literal for the '<em><b>Activity</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference CONTRACT_CONTAINER__ACTIVITY = eINSTANCE.getContractContainer_Activity();

    /**
     * The meta object literal for the '<em><b>Contracts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference CONTRACT_CONTAINER__CONTRACTS = eINSTANCE.getContractContainer_Contracts();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.FactoryComponentContractImpl <em>Factory Component Contract</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.FactoryComponentContractImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getFactoryComponentContract()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass FACTORY_COMPONENT_CONTRACT = eINSTANCE.getFactoryComponentContract();

    /**
     * The meta object literal for the '<em><b>Invocation Contracts</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS = eINSTANCE.getFactoryComponentContract_InvocationContracts();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ViewpointContainerImpl <em>Viewpoint Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ViewpointContainerImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getViewpointContainer()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass VIEWPOINT_CONTAINER = eINSTANCE.getViewpointContainer();

    /**
     * The meta object literal for the '<em><b>Factory Component</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference VIEWPOINT_CONTAINER__FACTORY_COMPONENT = eINSTANCE.getViewpointContainer_FactoryComponent();

    /**
     * The meta object literal for the '<em><b>Viewpoints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference VIEWPOINT_CONTAINER__VIEWPOINTS = eINSTANCE.getViewpointContainer_Viewpoints();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ViewpointImpl <em>Viewpoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ViewpointImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getViewpoint()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass VIEWPOINT = eINSTANCE.getViewpoint();

    /**
     * The meta object literal for the '<em><b>Viewpoint Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference VIEWPOINT__VIEWPOINT_CONTAINER = eINSTANCE.getViewpoint_ViewpointContainer();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.OrchestrationImpl <em>Orchestration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.OrchestrationImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getOrchestration()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass ORCHESTRATION = eINSTANCE.getOrchestration();

    /**
     * The meta object literal for the '<em><b>Factory Component</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference ORCHESTRATION__FACTORY_COMPONENT = eINSTANCE.getOrchestration_FactoryComponent();

    /**
     * The meta object literal for the '<em><b>Orchestration Parameter Container</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER = eINSTANCE.getOrchestration_OrchestrationParameterContainer();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.OrchestrationParameterContainerImpl <em>Orchestration Parameter Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.OrchestrationParameterContainerImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getOrchestrationParameterContainer()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass ORCHESTRATION_PARAMETER_CONTAINER = eINSTANCE.getOrchestrationParameterContainer();

    /**
     * The meta object literal for the '<em><b>Orchestration</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference ORCHESTRATION_PARAMETER_CONTAINER__ORCHESTRATION = eINSTANCE.getOrchestrationParameterContainer_Orchestration();

    /**
     * The meta object literal for the '<em><b>Orchestration Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference ORCHESTRATION_PARAMETER_CONTAINER__ORCHESTRATION_PARAMETERS = eINSTANCE.getOrchestrationParameterContainer_OrchestrationParameters();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.OrchestrationParameterImpl <em>Orchestration Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.OrchestrationParameterImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getOrchestrationParameter()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass ORCHESTRATION_PARAMETER = eINSTANCE.getOrchestrationParameter();

    /**
     * The meta object literal for the '<em><b>Orchestration Parameter Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER = eINSTANCE.getOrchestrationParameter_OrchestrationParameterContainer();

    /**
     * The meta object literal for the '<em><b>Invocation Contracts</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference ORCHESTRATION_PARAMETER__INVOCATION_CONTRACTS = eINSTANCE.getOrchestrationParameter_InvocationContracts();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference ORCHESTRATION_PARAMETER__TYPE = eINSTANCE.getOrchestrationParameter_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.InvocationImpl <em>Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.InvocationImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocation()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass INVOCATION = eINSTANCE.getInvocation();

    /**
     * The meta object literal for the '<em><b>Invocation Contract Container</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference INVOCATION__INVOCATION_CONTRACT_CONTAINER = eINSTANCE.getInvocation_InvocationContractContainer();

    /**
     * The meta object literal for the '<em><b>Invoked Activity</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference INVOCATION__INVOKED_ACTIVITY = eINSTANCE.getInvocation_InvokedActivity();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.InvocationContractContainerImpl <em>Invocation Contract Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.InvocationContractContainerImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocationContractContainer()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass INVOCATION_CONTRACT_CONTAINER = eINSTANCE.getInvocationContractContainer();

    /**
     * The meta object literal for the '<em><b>Invocation</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference INVOCATION_CONTRACT_CONTAINER__INVOCATION = eINSTANCE.getInvocationContractContainer_Invocation();

    /**
     * The meta object literal for the '<em><b>Invocation Contracts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference INVOCATION_CONTRACT_CONTAINER__INVOCATION_CONTRACTS = eINSTANCE.getInvocationContractContainer_InvocationContracts();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.InvocationContractImpl <em>Invocation Contract</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.InvocationContractImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocationContract()
     * @generated
     */
    @SuppressWarnings("hiding")
    EClass INVOCATION_CONTRACT = eINSTANCE.getInvocationContract();

    /**
     * The meta object literal for the '<em><b>Invocation Contract Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference INVOCATION_CONTRACT__INVOCATION_CONTRACT_CONTAINER = eINSTANCE.getInvocationContract_InvocationContractContainer();

    /**
     * The meta object literal for the '<em><b>Factory Component Contract</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT = eINSTANCE.getInvocationContract_FactoryComponentContract();

    /**
     * The meta object literal for the '<em><b>Orchestration Parameter</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER = eINSTANCE.getInvocationContract_OrchestrationParameter();

    /**
     * The meta object literal for the '<em><b>Source Invocation Contract</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT = eINSTANCE.getInvocationContract_SourceInvocationContract();

    /**
     * The meta object literal for the '<em><b>Target Invocation Contract</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT = eINSTANCE.getInvocationContract_TargetInvocationContract();

    /**
     * The meta object literal for the '<em><b>Invoked Contract</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference INVOCATION_CONTRACT__INVOKED_CONTRACT = eINSTANCE.getInvocationContract_InvokedContract();

    /**
     * The meta object literal for the '<em><b>Invoked Mode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EAttribute INVOCATION_CONTRACT__INVOKED_MODE = eINSTANCE.getInvocationContract_InvokedMode();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    EReference INVOCATION_CONTRACT__TYPE = eINSTANCE.getInvocationContract_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.ContractMode <em>Contract Mode</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.ContractMode
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContractMode()
     * @generated
     */
    @SuppressWarnings("hiding")
    EEnum CONTRACT_MODE = eINSTANCE.getContractMode();

  }

} // FcorePackage
