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
package org.eclipse.egf.model.factorycomponent;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.egf.model.factorycomponent.FactoryComponentFactory
 * @model kind="package"
 * @generated
 */
public interface FactoryComponentPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "factorycomponent"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/egf/1.0.0/factorycomponent"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "factorycomponent"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FactoryComponentPackage eINSTANCE = org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.impl.ModelElementImpl <em>Model Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.impl.ModelElementImpl
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getModelElement()
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
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__NAME = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__DESCRIPTION = 2;

  /**
   * The number of structural features of the '<em>Model Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.impl.ActivityImpl <em>Activity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.impl.ActivityImpl
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getActivity()
   * @generated
   */
  int ACTIVITY = 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Contract Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY__CONTRACT_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Activity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.impl.TaskImpl <em>Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.impl.TaskImpl
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getTask()
   * @generated
   */
  int TASK = 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__ID = ACTIVITY__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__NAME = ACTIVITY__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__DESCRIPTION = ACTIVITY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Contract Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__CONTRACT_CONTAINER = ACTIVITY__CONTRACT_CONTAINER;

  /**
   * The feature id for the '<em><b>Task Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__TASK_ID = ACTIVITY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_FEATURE_COUNT = ACTIVITY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.impl.FactoryComponentImpl <em>Factory Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentImpl
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getFactoryComponent()
   * @generated
   */
  int FACTORY_COMPONENT = 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__ID = ACTIVITY__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__NAME = ACTIVITY__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__DESCRIPTION = ACTIVITY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Contract Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__CONTRACT_CONTAINER = ACTIVITY__CONTRACT_CONTAINER;

  /**
   * The feature id for the '<em><b>Viewpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__VIEWPOINTS = ACTIVITY_FEATURE_COUNT + 0;

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
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.impl.ViewpointImpl <em>Viewpoint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.impl.ViewpointImpl
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getViewpoint()
   * @generated
   */
  int VIEWPOINT = 4;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Viewpoint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.impl.OrchestrationImpl <em>Orchestration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.impl.OrchestrationImpl
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getOrchestration()
   * @generated
   */
  int ORCHESTRATION = 5;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Orchestration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.impl.InvocationImpl <em>Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.impl.InvocationImpl
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getInvocation()
   * @generated
   */
  int INVOCATION = 6;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__CONTEXT = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.impl.ContextImpl <em>Context</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.impl.ContextImpl
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContext()
   * @generated
   */
  int CONTEXT = 7;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Invocation</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__INVOCATION = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__VALUES = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__CONNECTORS = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.impl.ContractContainerImpl <em>Contract Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.impl.ContractContainerImpl
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContractContainer()
   * @generated
   */
  int CONTRACT_CONTAINER = 8;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONTAINER__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONTAINER__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONTAINER__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Contracts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONTAINER__CONTRACTS = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Contract Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONTAINER_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.impl.ContractImpl <em>Contract</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.impl.ContractImpl
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContract()
   * @generated
   */
  int CONTRACT = 9;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__MODE = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__TYPE = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Default Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__DEFAULT_VALUE = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Contract</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.impl.ContextValueImpl <em>Context Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.impl.ContextValueImpl
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContextValue()
   * @generated
   */
  int CONTEXT_VALUE = 10;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_VALUE__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_VALUE__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_VALUE__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Context Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_VALUE_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.impl.ContractValueImpl <em>Contract Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.impl.ContractValueImpl
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContractValue()
   * @generated
   */
  int CONTRACT_VALUE = 11;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_VALUE__ID = CONTEXT_VALUE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_VALUE__NAME = CONTEXT_VALUE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_VALUE__DESCRIPTION = CONTEXT_VALUE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Contract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_VALUE__CONTRACT = CONTEXT_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_VALUE__VALUE = CONTEXT_VALUE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Plugin Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_VALUE__PLUGIN_ID = CONTEXT_VALUE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Contract Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_VALUE_FEATURE_COUNT = CONTEXT_VALUE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.impl.ContractConnectorImpl <em>Contract Connector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.impl.ContractConnectorImpl
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContractConnector()
   * @generated
   */
  int CONTRACT_CONNECTOR = 12;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONNECTOR__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONNECTOR__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONNECTOR__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Context</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONNECTOR__CONTEXT = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONNECTOR__SOURCE = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONNECTOR__TARGET = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Contract Connector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_CONNECTOR_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.factorycomponent.ContractMode <em>Contract Mode</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.factorycomponent.ContractMode
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContractMode()
   * @generated
   */
  int CONTRACT_MODE = 13;

  /**
   * The meta object id for the '<em>Invocation Exception</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.RuntimeException
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getInvocationException()
   * @generated
   */
  int INVOCATION_EXCEPTION = 14;

  /**
   * The meta object id for the '<em>URI</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.common.util.URI
   * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getURI()
   * @generated
   */
  int URI = 15;

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.factorycomponent.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Element</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ModelElement
   * @generated
   */
  EClass getModelElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.factorycomponent.ModelElement#getID <em>ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>ID</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ModelElement#getID()
   * @see #getModelElement()
   * @generated
   */
  EAttribute getModelElement_ID();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.factorycomponent.ModelElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ModelElement#getName()
   * @see #getModelElement()
   * @generated
   */
  EAttribute getModelElement_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.factorycomponent.ModelElement#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ModelElement#getDescription()
   * @see #getModelElement()
   * @generated
   */
  EAttribute getModelElement_Description();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.factorycomponent.Activity <em>Activity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Activity</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Activity
   * @generated
   */
  EClass getActivity();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.factorycomponent.Activity#getContractContainer <em>Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Contract Container</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Activity#getContractContainer()
   * @see #getActivity()
   * @generated
   */
  EReference getActivity_ContractContainer();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.factorycomponent.Task <em>Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Task</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Task
   * @generated
   */
  EClass getTask();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.factorycomponent.Task#getTaskId <em>Task Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Task Id</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Task#getTaskId()
   * @see #getTask()
   * @generated
   */
  EAttribute getTask_TaskId();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.factorycomponent.FactoryComponent <em>Factory Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Factory Component</em>'.
   * @see org.eclipse.egf.model.factorycomponent.FactoryComponent
   * @generated
   */
  EClass getFactoryComponent();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.factorycomponent.FactoryComponent#getViewpoints <em>Viewpoints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Viewpoints</em>'.
   * @see org.eclipse.egf.model.factorycomponent.FactoryComponent#getViewpoints()
   * @see #getFactoryComponent()
   * @generated
   */
  EReference getFactoryComponent_Viewpoints();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.factorycomponent.FactoryComponent#getOrchestration <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Orchestration</em>'.
   * @see org.eclipse.egf.model.factorycomponent.FactoryComponent#getOrchestration()
   * @see #getFactoryComponent()
   * @generated
   */
  EReference getFactoryComponent_Orchestration();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.factorycomponent.Viewpoint <em>Viewpoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Viewpoint</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Viewpoint
   * @generated
   */
  EClass getViewpoint();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.factorycomponent.Orchestration <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Orchestration</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Orchestration
   * @generated
   */
  EClass getOrchestration();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.factorycomponent.Invocation <em>Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invocation</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Invocation
   * @generated
   */
  EClass getInvocation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.factorycomponent.Invocation#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Context</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Invocation#getContext()
   * @see #getInvocation()
   * @generated
   */
  EReference getInvocation_Context();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.factorycomponent.Context <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Context
   * @generated
   */
  EClass getContext();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.factorycomponent.Context#getInvocation <em>Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Invocation</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Context#getInvocation()
   * @see #getContext()
   * @generated
   */
  EReference getContext_Invocation();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.factorycomponent.Context#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Context#getValues()
   * @see #getContext()
   * @generated
   */
  EReference getContext_Values();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.factorycomponent.Context#getConnectors <em>Connectors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Connectors</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Context#getConnectors()
   * @see #getContext()
   * @generated
   */
  EReference getContext_Connectors();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.factorycomponent.ContractContainer <em>Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contract Container</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ContractContainer
   * @generated
   */
  EClass getContractContainer();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.factorycomponent.ContractContainer#getContracts <em>Contracts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contracts</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ContractContainer#getContracts()
   * @see #getContractContainer()
   * @generated
   */
  EReference getContractContainer_Contracts();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.factorycomponent.Contract <em>Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contract</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Contract
   * @generated
   */
  EClass getContract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.factorycomponent.Contract#getMode <em>Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mode</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Contract#getMode()
   * @see #getContract()
   * @generated
   */
  EAttribute getContract_Mode();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.factorycomponent.Contract#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Contract#getType()
   * @see #getContract()
   * @generated
   */
  EReference getContract_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.factorycomponent.Contract#getDefaultValue <em>Default Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Default Value</em>'.
   * @see org.eclipse.egf.model.factorycomponent.Contract#getDefaultValue()
   * @see #getContract()
   * @generated
   */
  EReference getContract_DefaultValue();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.factorycomponent.ContextValue <em>Context Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context Value</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ContextValue
   * @generated
   */
  EClass getContextValue();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.factorycomponent.ContractValue <em>Contract Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contract Value</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ContractValue
   * @generated
   */
  EClass getContractValue();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.factorycomponent.ContractValue#getContract <em>Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Contract</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ContractValue#getContract()
   * @see #getContractValue()
   * @generated
   */
  EReference getContractValue_Contract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.factorycomponent.ContractValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ContractValue#getValue()
   * @see #getContractValue()
   * @generated
   */
  EAttribute getContractValue_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.factorycomponent.ContractValue#getPluginId <em>Plugin Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Plugin Id</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ContractValue#getPluginId()
   * @see #getContractValue()
   * @generated
   */
  EAttribute getContractValue_PluginId();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.factorycomponent.ContractConnector <em>Contract Connector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contract Connector</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ContractConnector
   * @generated
   */
  EClass getContractConnector();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.factorycomponent.ContractConnector#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Context</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ContractConnector#getContext()
   * @see #getContractConnector()
   * @generated
   */
  EReference getContractConnector_Context();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.factorycomponent.ContractConnector#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ContractConnector#getSource()
   * @see #getContractConnector()
   * @generated
   */
  EReference getContractConnector_Source();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.factorycomponent.ContractConnector#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ContractConnector#getTarget()
   * @see #getContractConnector()
   * @generated
   */
  EReference getContractConnector_Target();

  /**
   * Returns the meta object for enum '{@link org.eclipse.egf.model.factorycomponent.ContractMode <em>Contract Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Contract Mode</em>'.
   * @see org.eclipse.egf.model.factorycomponent.ContractMode
   * @generated
   */
  EEnum getContractMode();

  /**
   * Returns the meta object for data type '{@link java.lang.RuntimeException <em>Invocation Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Invocation Exception</em>'.
   * @see java.lang.RuntimeException
   * @model instanceClass="java.lang.RuntimeException"
   * @generated
   */
  EDataType getInvocationException();

  /**
   * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>URI</em>'.
   * @see org.eclipse.emf.common.util.URI
   * @model instanceClass="org.eclipse.emf.common.util.URI"
   * @generated
   */
  EDataType getURI();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FactoryComponentFactory getFactoryComponentFactory();

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
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.impl.ModelElementImpl <em>Model Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.impl.ModelElementImpl
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getModelElement()
     * @generated
     */
    EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

    /**
     * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_ELEMENT__ID = eINSTANCE.getModelElement_ID();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_ELEMENT__NAME = eINSTANCE.getModelElement_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_ELEMENT__DESCRIPTION = eINSTANCE.getModelElement_Description();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.impl.ActivityImpl <em>Activity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.impl.ActivityImpl
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getActivity()
     * @generated
     */
    EClass ACTIVITY = eINSTANCE.getActivity();

    /**
     * The meta object literal for the '<em><b>Contract Container</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTIVITY__CONTRACT_CONTAINER = eINSTANCE.getActivity_ContractContainer();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.impl.TaskImpl <em>Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.impl.TaskImpl
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getTask()
     * @generated
     */
    EClass TASK = eINSTANCE.getTask();

    /**
     * The meta object literal for the '<em><b>Task Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TASK__TASK_ID = eINSTANCE.getTask_TaskId();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.impl.FactoryComponentImpl <em>Factory Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentImpl
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getFactoryComponent()
     * @generated
     */
    EClass FACTORY_COMPONENT = eINSTANCE.getFactoryComponent();

    /**
     * The meta object literal for the '<em><b>Viewpoints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT__VIEWPOINTS = eINSTANCE.getFactoryComponent_Viewpoints();

    /**
     * The meta object literal for the '<em><b>Orchestration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT__ORCHESTRATION = eINSTANCE.getFactoryComponent_Orchestration();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.impl.ViewpointImpl <em>Viewpoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.impl.ViewpointImpl
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getViewpoint()
     * @generated
     */
    EClass VIEWPOINT = eINSTANCE.getViewpoint();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.impl.OrchestrationImpl <em>Orchestration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.impl.OrchestrationImpl
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getOrchestration()
     * @generated
     */
    EClass ORCHESTRATION = eINSTANCE.getOrchestration();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.impl.InvocationImpl <em>Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.impl.InvocationImpl
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getInvocation()
     * @generated
     */
    EClass INVOCATION = eINSTANCE.getInvocation();

    /**
     * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION__CONTEXT = eINSTANCE.getInvocation_Context();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.impl.ContextImpl <em>Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.impl.ContextImpl
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContext()
     * @generated
     */
    EClass CONTEXT = eINSTANCE.getContext();

    /**
     * The meta object literal for the '<em><b>Invocation</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT__INVOCATION = eINSTANCE.getContext_Invocation();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT__VALUES = eINSTANCE.getContext_Values();

    /**
     * The meta object literal for the '<em><b>Connectors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT__CONNECTORS = eINSTANCE.getContext_Connectors();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.impl.ContractContainerImpl <em>Contract Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.impl.ContractContainerImpl
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContractContainer()
     * @generated
     */
    EClass CONTRACT_CONTAINER = eINSTANCE.getContractContainer();

    /**
     * The meta object literal for the '<em><b>Contracts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT_CONTAINER__CONTRACTS = eINSTANCE.getContractContainer_Contracts();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.impl.ContractImpl <em>Contract</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.impl.ContractImpl
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContract()
     * @generated
     */
    EClass CONTRACT = eINSTANCE.getContract();

    /**
     * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACT__MODE = eINSTANCE.getContract_Mode();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT__TYPE = eINSTANCE.getContract_Type();

    /**
     * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT__DEFAULT_VALUE = eINSTANCE.getContract_DefaultValue();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.impl.ContextValueImpl <em>Context Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.impl.ContextValueImpl
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContextValue()
     * @generated
     */
    EClass CONTEXT_VALUE = eINSTANCE.getContextValue();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.impl.ContractValueImpl <em>Contract Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.impl.ContractValueImpl
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContractValue()
     * @generated
     */
    EClass CONTRACT_VALUE = eINSTANCE.getContractValue();

    /**
     * The meta object literal for the '<em><b>Contract</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT_VALUE__CONTRACT = eINSTANCE.getContractValue_Contract();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACT_VALUE__VALUE = eINSTANCE.getContractValue_Value();

    /**
     * The meta object literal for the '<em><b>Plugin Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACT_VALUE__PLUGIN_ID = eINSTANCE.getContractValue_PluginId();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.impl.ContractConnectorImpl <em>Contract Connector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.impl.ContractConnectorImpl
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContractConnector()
     * @generated
     */
    EClass CONTRACT_CONNECTOR = eINSTANCE.getContractConnector();

    /**
     * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT_CONNECTOR__CONTEXT = eINSTANCE.getContractConnector_Context();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT_CONNECTOR__SOURCE = eINSTANCE.getContractConnector_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT_CONNECTOR__TARGET = eINSTANCE.getContractConnector_Target();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.factorycomponent.ContractMode <em>Contract Mode</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.factorycomponent.ContractMode
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getContractMode()
     * @generated
     */
    EEnum CONTRACT_MODE = eINSTANCE.getContractMode();

    /**
     * The meta object literal for the '<em>Invocation Exception</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.RuntimeException
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getInvocationException()
     * @generated
     */
    EDataType INVOCATION_EXCEPTION = eINSTANCE.getInvocationException();

    /**
     * The meta object literal for the '<em>URI</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.URI
     * @see org.eclipse.egf.model.factorycomponent.impl.FactoryComponentPackageImpl#getURI()
     * @generated
     */
    EDataType URI = eINSTANCE.getURI();

  }

} //FactoryComponentPackage
