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
import org.eclipse.emf.ecore.EDataType;
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
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ActivityImpl <em>Activity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ActivityImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getActivity()
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
   * The number of structural features of the '<em>Activity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ActivityContractImpl <em>Activity Contract</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ActivityContractImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getActivityContract()
   * @generated
   */
  int ACTIVITY_CONTRACT = 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_CONTRACT__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_CONTRACT__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_CONTRACT__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Mandatory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_CONTRACT__MANDATORY = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_CONTRACT__MODE = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_CONTRACT__TYPE = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Activity Contract</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_CONTRACT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ActivityContractContainerImpl <em>Activity Contract Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ActivityContractContainerImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getActivityContractContainer()
   * @generated
   */
  int ACTIVITY_CONTRACT_CONTAINER = 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_CONTRACT_CONTAINER__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_CONTRACT_CONTAINER__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_CONTRACT_CONTAINER__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Activity Contract Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_CONTRACT_CONTAINER_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

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
   * The feature id for the '<em><b>Activity Contract Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__ACTIVITY_CONTRACT_CONTAINER = ACTIVITY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Viewpoint Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__VIEWPOINT_CONTAINER = ACTIVITY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Orchestration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT__ORCHESTRATION = ACTIVITY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Factory Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_FEATURE_COUNT = ACTIVITY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.FactoryComponentContractImpl <em>Factory Component Contract</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.FactoryComponentContractImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getFactoryComponentContract()
   * @generated
   */
  int FACTORY_COMPONENT_CONTRACT = 5;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__ID = ACTIVITY_CONTRACT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__NAME = ACTIVITY_CONTRACT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__DESCRIPTION = ACTIVITY_CONTRACT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Mandatory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__MANDATORY = ACTIVITY_CONTRACT__MANDATORY;

  /**
   * The feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__MODE = ACTIVITY_CONTRACT__MODE;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__TYPE = ACTIVITY_CONTRACT__TYPE;

  /**
   * The feature id for the '<em><b>Invocation Contexts</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTEXTS = ACTIVITY_CONTRACT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Activity Contract Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER = ACTIVITY_CONTRACT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Factory Component Contract</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT_FEATURE_COUNT = ACTIVITY_CONTRACT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.FactoryComponentContractContainerImpl <em>Factory Component Contract Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.FactoryComponentContractContainerImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getFactoryComponentContractContainer()
   * @generated
   */
  int FACTORY_COMPONENT_CONTRACT_CONTAINER = 6;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT_CONTAINER__ID = ACTIVITY_CONTRACT_CONTAINER__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT_CONTAINER__NAME = ACTIVITY_CONTRACT_CONTAINER__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT_CONTAINER__DESCRIPTION = ACTIVITY_CONTRACT_CONTAINER__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Activity</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY = ACTIVITY_CONTRACT_CONTAINER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Activity Contracts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS = ACTIVITY_CONTRACT_CONTAINER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Factory Component Contract Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_CONTRACT_CONTAINER_FEATURE_COUNT = ACTIVITY_CONTRACT_CONTAINER_FEATURE_COUNT + 2;

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
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.OrchestrationContextImpl <em>Orchestration Context</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.OrchestrationContextImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getOrchestrationContext()
   * @generated
   */
  int ORCHESTRATION_CONTEXT = 10;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.OrchestrationContextContainerImpl <em>Orchestration Context Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.OrchestrationContextContainerImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getOrchestrationContextContainer()
   * @generated
   */
  int ORCHESTRATION_CONTEXT_CONTAINER = 11;

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
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.InvocationContextImpl <em>Invocation Context</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.InvocationContextImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocationContext()
   * @generated
   */
  int INVOCATION_CONTEXT = 13;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.InvocationContextConnectorImpl <em>Invocation Context Connector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.InvocationContextConnectorImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocationContextConnector()
   * @generated
   */
  int INVOCATION_CONTEXT_CONNECTOR = 14;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.InvocationContextContainerImpl <em>Invocation Context Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.InvocationContextContainerImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocationContextContainer()
   * @generated
   */
  int INVOCATION_CONTEXT_CONTAINER = 15;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.TypeImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getType()
   * @generated
   */
  int TYPE = 16;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.TypeObjectImpl <em>Type Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.TypeObjectImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getTypeObject()
   * @generated
   */
  int TYPE_OBJECT = 17;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.TypeClassImpl <em>Type Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.TypeClassImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getTypeClass()
   * @generated
   */
  int TYPE_CLASS = 18;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT_CONTAINER__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT_CONTAINER__NAME = MODEL_ELEMENT__NAME;

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
   * The feature id for the '<em><b>Viewerpoint Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEWPOINT__VIEWERPOINT_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 0;

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
   * The feature id for the '<em><b>Factory Component</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION__FACTORY_COMPONENT = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Orchestration Context Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Invocations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION__INVOCATIONS = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Orchestration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_CONTEXT__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_CONTEXT__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_CONTEXT__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Orchestration Context Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Invocation Contexts</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_CONTEXT__INVOCATION_CONTEXTS = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_CONTEXT__TYPE = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Orchestration Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_CONTEXT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_CONTEXT_CONTAINER__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_CONTEXT_CONTAINER__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_CONTEXT_CONTAINER__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Orchestration</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Orchestration Contexts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION_CONTEXTS = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Orchestration Context Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_CONTEXT_CONTAINER_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

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
   * The feature id for the '<em><b>Orchestration</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__ORCHESTRATION = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Invocation Context Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__INVOCATION_CONTEXT_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Activity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__ACTIVITY = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Invocation Context Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Factory Component Exposed Contract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT__FACTORY_COMPONENT_EXPOSED_CONTRACT = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Orchestration Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT__ORCHESTRATION_CONTEXT = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Activity Contract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT__ACTIVITY_CONTRACT = MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT__TYPE = MODEL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT__MODE = MODEL_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Invocation Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONNECTOR__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONNECTOR__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONNECTOR__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Invocation Context Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source Invocation Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONNECTOR__SOURCE_INVOCATION_CONTEXT = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target Invocation Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONNECTOR__TARGET_INVOCATION_CONTEXT = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Invocation Context Connector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONNECTOR_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONTAINER__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONTAINER__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONTAINER__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Invocation</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONTAINER__INVOCATION = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Invocation Contexts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXTS = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Invocation Context Connectors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXT_CONNECTORS = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Invocation Context Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_CONTEXT_CONTAINER_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_OBJECT__ID = TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_OBJECT__NAME = TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_OBJECT__DESCRIPTION = TYPE__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Type Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_OBJECT_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CLASS__ID = TYPE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CLASS__NAME = TYPE__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CLASS__DESCRIPTION = TYPE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CLASS__VALUE = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CLASS_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.ContractMode <em>Contract Mode</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.ContractMode
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContractMode()
   * @generated
   */
  int CONTRACT_MODE = 19;

  /**
   * The meta object id for the '<em>URI</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.common.util.URI
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getURI()
   * @generated
   */
  int URI = 20;

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
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.fcore.ModelElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.egf.model.fcore.ModelElement#getName()
   * @see #getModelElement()
   * @generated
   */
  EAttribute getModelElement_Name();

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
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.Activity <em>Activity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Activity</em>'.
   * @see org.eclipse.egf.model.fcore.Activity
   * @generated
   */
  EClass getActivity();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.ActivityContract <em>Activity Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Activity Contract</em>'.
   * @see org.eclipse.egf.model.fcore.ActivityContract
   * @generated
   */
  EClass getActivityContract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.fcore.ActivityContract#isMandatory <em>Mandatory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mandatory</em>'.
   * @see org.eclipse.egf.model.fcore.ActivityContract#isMandatory()
   * @see #getActivityContract()
   * @generated
   */
  EAttribute getActivityContract_Mandatory();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.fcore.ActivityContract#getMode <em>Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mode</em>'.
   * @see org.eclipse.egf.model.fcore.ActivityContract#getMode()
   * @see #getActivityContract()
   * @generated
   */
  EAttribute getActivityContract_Mode();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.ActivityContract#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.egf.model.fcore.ActivityContract#getType()
   * @see #getActivityContract()
   * @generated
   */
  EReference getActivityContract_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.ActivityContractContainer <em>Activity Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Activity Contract Container</em>'.
   * @see org.eclipse.egf.model.fcore.ActivityContractContainer
   * @generated
   */
  EClass getActivityContractContainer();

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
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.FactoryComponent#getActivityContractContainer <em>Activity Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Activity Contract Container</em>'.
   * @see org.eclipse.egf.model.fcore.FactoryComponent#getActivityContractContainer()
   * @see #getFactoryComponent()
   * @generated
   */
  EReference getFactoryComponent_ActivityContractContainer();

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
   * Returns the meta object for the reference list '{@link org.eclipse.egf.model.fcore.FactoryComponentContract#getInvocationContexts <em>Invocation Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Invocation Contexts</em>'.
   * @see org.eclipse.egf.model.fcore.FactoryComponentContract#getInvocationContexts()
   * @see #getFactoryComponentContract()
   * @generated
   */
  EReference getFactoryComponentContract_InvocationContexts();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.FactoryComponentContract#getActivityContractContainer <em>Activity Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Activity Contract Container</em>'.
   * @see org.eclipse.egf.model.fcore.FactoryComponentContract#getActivityContractContainer()
   * @see #getFactoryComponentContract()
   * @generated
   */
  EReference getFactoryComponentContract_ActivityContractContainer();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.FactoryComponentContractContainer <em>Factory Component Contract Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Factory Component Contract Container</em>'.
   * @see org.eclipse.egf.model.fcore.FactoryComponentContractContainer
   * @generated
   */
  EClass getFactoryComponentContractContainer();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.FactoryComponentContractContainer#getActivity <em>Activity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Activity</em>'.
   * @see org.eclipse.egf.model.fcore.FactoryComponentContractContainer#getActivity()
   * @see #getFactoryComponentContractContainer()
   * @generated
   */
  EReference getFactoryComponentContractContainer_Activity();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.fcore.FactoryComponentContractContainer#getActivityContracts <em>Activity Contracts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Activity Contracts</em>'.
   * @see org.eclipse.egf.model.fcore.FactoryComponentContractContainer#getActivityContracts()
   * @see #getFactoryComponentContractContainer()
   * @generated
   */
  EReference getFactoryComponentContractContainer_ActivityContracts();

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
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.Viewpoint#getViewerpointContainer <em>Viewerpoint Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Viewerpoint Container</em>'.
   * @see org.eclipse.egf.model.fcore.Viewpoint#getViewerpointContainer()
   * @see #getViewpoint()
   * @generated
   */
  EReference getViewpoint_ViewerpointContainer();

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
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.fcore.Orchestration#getInvocations <em>Invocations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Invocations</em>'.
   * @see org.eclipse.egf.model.fcore.Orchestration#getInvocations()
   * @see #getOrchestration()
   * @generated
   */
  EReference getOrchestration_Invocations();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.Orchestration#getOrchestrationContextContainer <em>Orchestration Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Orchestration Context Container</em>'.
   * @see org.eclipse.egf.model.fcore.Orchestration#getOrchestrationContextContainer()
   * @see #getOrchestration()
   * @generated
   */
  EReference getOrchestration_OrchestrationContextContainer();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.OrchestrationContext <em>Orchestration Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Orchestration Context</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationContext
   * @generated
   */
  EClass getOrchestrationContext();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.OrchestrationContext#getOrchestrationContextContainer <em>Orchestration Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Orchestration Context Container</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationContext#getOrchestrationContextContainer()
   * @see #getOrchestrationContext()
   * @generated
   */
  EReference getOrchestrationContext_OrchestrationContextContainer();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.egf.model.fcore.OrchestrationContext#getInvocationContexts <em>Invocation Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Invocation Contexts</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationContext#getInvocationContexts()
   * @see #getOrchestrationContext()
   * @generated
   */
  EReference getOrchestrationContext_InvocationContexts();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.OrchestrationContext#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationContext#getType()
   * @see #getOrchestrationContext()
   * @generated
   */
  EReference getOrchestrationContext_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.OrchestrationContextContainer <em>Orchestration Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Orchestration Context Container</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationContextContainer
   * @generated
   */
  EClass getOrchestrationContextContainer();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.OrchestrationContextContainer#getOrchestration <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Orchestration</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationContextContainer#getOrchestration()
   * @see #getOrchestrationContextContainer()
   * @generated
   */
  EReference getOrchestrationContextContainer_Orchestration();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.fcore.OrchestrationContextContainer#getOrchestrationContexts <em>Orchestration Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Orchestration Contexts</em>'.
   * @see org.eclipse.egf.model.fcore.OrchestrationContextContainer#getOrchestrationContexts()
   * @see #getOrchestrationContextContainer()
   * @generated
   */
  EReference getOrchestrationContextContainer_OrchestrationContexts();

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
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.Invocation#getOrchestration <em>Orchestration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Orchestration</em>'.
   * @see org.eclipse.egf.model.fcore.Invocation#getOrchestration()
   * @see #getInvocation()
   * @generated
   */
  EReference getInvocation_Orchestration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.Invocation#getInvocationContextContainer <em>Invocation Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Invocation Context Container</em>'.
   * @see org.eclipse.egf.model.fcore.Invocation#getInvocationContextContainer()
   * @see #getInvocation()
   * @generated
   */
  EReference getInvocation_InvocationContextContainer();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.Invocation#getActivity <em>Activity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Activity</em>'.
   * @see org.eclipse.egf.model.fcore.Invocation#getActivity()
   * @see #getInvocation()
   * @generated
   */
  EReference getInvocation_Activity();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.InvocationContext <em>Invocation Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invocation Context</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContext
   * @generated
   */
  EClass getInvocationContext();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.InvocationContext#getInvocationContextContainer <em>Invocation Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Invocation Context Container</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContext#getInvocationContextContainer()
   * @see #getInvocationContext()
   * @generated
   */
  EReference getInvocationContext_InvocationContextContainer();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.InvocationContext#getFactoryComponentExposedContract <em>Factory Component Exposed Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Factory Component Exposed Contract</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContext#getFactoryComponentExposedContract()
   * @see #getInvocationContext()
   * @generated
   */
  EReference getInvocationContext_FactoryComponentExposedContract();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.InvocationContext#getOrchestrationContext <em>Orchestration Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Orchestration Context</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContext#getOrchestrationContext()
   * @see #getInvocationContext()
   * @generated
   */
  EReference getInvocationContext_OrchestrationContext();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.InvocationContext#getActivityContract <em>Activity Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Activity Contract</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContext#getActivityContract()
   * @see #getInvocationContext()
   * @generated
   */
  EReference getInvocationContext_ActivityContract();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.InvocationContext#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContext#getType()
   * @see #getInvocationContext()
   * @generated
   */
  EReference getInvocationContext_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.fcore.InvocationContext#getMode <em>Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mode</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContext#getMode()
   * @see #getInvocationContext()
   * @generated
   */
  EAttribute getInvocationContext_Mode();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.InvocationContextConnector <em>Invocation Context Connector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invocation Context Connector</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContextConnector
   * @generated
   */
  EClass getInvocationContextConnector();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.InvocationContextConnector#getInvocationContextContainer <em>Invocation Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Invocation Context Container</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContextConnector#getInvocationContextContainer()
   * @see #getInvocationContextConnector()
   * @generated
   */
  EReference getInvocationContextConnector_InvocationContextContainer();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.InvocationContextConnector#getSourceInvocationContext <em>Source Invocation Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source Invocation Context</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContextConnector#getSourceInvocationContext()
   * @see #getInvocationContextConnector()
   * @generated
   */
  EReference getInvocationContextConnector_SourceInvocationContext();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.InvocationContextConnector#getTargetInvocationContext <em>Target Invocation Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Invocation Context</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContextConnector#getTargetInvocationContext()
   * @see #getInvocationContextConnector()
   * @generated
   */
  EReference getInvocationContextConnector_TargetInvocationContext();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.InvocationContextContainer <em>Invocation Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invocation Context Container</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContextContainer
   * @generated
   */
  EClass getInvocationContextContainer();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocation <em>Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Invocation</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocation()
   * @see #getInvocationContextContainer()
   * @generated
   */
  EReference getInvocationContextContainer_Invocation();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocationContexts <em>Invocation Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Invocation Contexts</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocationContexts()
   * @see #getInvocationContextContainer()
   * @generated
   */
  EReference getInvocationContextContainer_InvocationContexts();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocationContextConnectors <em>Invocation Context Connectors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Invocation Context Connectors</em>'.
   * @see org.eclipse.egf.model.fcore.InvocationContextContainer#getInvocationContextConnectors()
   * @see #getInvocationContextContainer()
   * @generated
   */
  EReference getInvocationContextContainer_InvocationContextConnectors();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see org.eclipse.egf.model.fcore.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.TypeObject <em>Type Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Object</em>'.
   * @see org.eclipse.egf.model.fcore.TypeObject
   * @generated
   */
  EClass getTypeObject();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.TypeClass <em>Type Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Class</em>'.
   * @see org.eclipse.egf.model.fcore.TypeClass
   * @generated
   */
  EClass getTypeClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.egf.model.fcore.TypeClass#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.egf.model.fcore.TypeClass#getValue()
   * @see #getTypeClass()
   * @generated
   */
  EAttribute getTypeClass_Value();

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
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ActivityImpl <em>Activity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ActivityImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getActivity()
     * @generated
     */
    EClass ACTIVITY = eINSTANCE.getActivity();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ActivityContractImpl <em>Activity Contract</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ActivityContractImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getActivityContract()
     * @generated
     */
    EClass ACTIVITY_CONTRACT = eINSTANCE.getActivityContract();

    /**
     * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTIVITY_CONTRACT__MANDATORY = eINSTANCE.getActivityContract_Mandatory();

    /**
     * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTIVITY_CONTRACT__MODE = eINSTANCE.getActivityContract_Mode();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTIVITY_CONTRACT__TYPE = eINSTANCE.getActivityContract_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ActivityContractContainerImpl <em>Activity Contract Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ActivityContractContainerImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getActivityContractContainer()
     * @generated
     */
    EClass ACTIVITY_CONTRACT_CONTAINER = eINSTANCE.getActivityContractContainer();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.FactoryComponentImpl <em>Factory Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.FactoryComponentImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getFactoryComponent()
     * @generated
     */
    EClass FACTORY_COMPONENT = eINSTANCE.getFactoryComponent();

    /**
     * The meta object literal for the '<em><b>Viewpoint Container</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT__VIEWPOINT_CONTAINER = eINSTANCE.getFactoryComponent_ViewpointContainer();

    /**
     * The meta object literal for the '<em><b>Orchestration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT__ORCHESTRATION = eINSTANCE.getFactoryComponent_Orchestration();

    /**
     * The meta object literal for the '<em><b>Activity Contract Container</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT__ACTIVITY_CONTRACT_CONTAINER = eINSTANCE.getFactoryComponent_ActivityContractContainer();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.FactoryComponentContractImpl <em>Factory Component Contract</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.FactoryComponentContractImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getFactoryComponentContract()
     * @generated
     */
    EClass FACTORY_COMPONENT_CONTRACT = eINSTANCE.getFactoryComponentContract();

    /**
     * The meta object literal for the '<em><b>Invocation Contexts</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTEXTS = eINSTANCE.getFactoryComponentContract_InvocationContexts();

    /**
     * The meta object literal for the '<em><b>Activity Contract Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER = eINSTANCE.getFactoryComponentContract_ActivityContractContainer();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.FactoryComponentContractContainerImpl <em>Factory Component Contract Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.FactoryComponentContractContainerImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getFactoryComponentContractContainer()
     * @generated
     */
    EClass FACTORY_COMPONENT_CONTRACT_CONTAINER = eINSTANCE.getFactoryComponentContractContainer();

    /**
     * The meta object literal for the '<em><b>Activity</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY = eINSTANCE.getFactoryComponentContractContainer_Activity();

    /**
     * The meta object literal for the '<em><b>Activity Contracts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS = eINSTANCE.getFactoryComponentContractContainer_ActivityContracts();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ViewpointContainerImpl <em>Viewpoint Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ViewpointContainerImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getViewpointContainer()
     * @generated
     */
    EClass VIEWPOINT_CONTAINER = eINSTANCE.getViewpointContainer();

    /**
     * The meta object literal for the '<em><b>Factory Component</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VIEWPOINT_CONTAINER__FACTORY_COMPONENT = eINSTANCE.getViewpointContainer_FactoryComponent();

    /**
     * The meta object literal for the '<em><b>Viewpoints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VIEWPOINT_CONTAINER__VIEWPOINTS = eINSTANCE.getViewpointContainer_Viewpoints();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ViewpointImpl <em>Viewpoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ViewpointImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getViewpoint()
     * @generated
     */
    EClass VIEWPOINT = eINSTANCE.getViewpoint();

    /**
     * The meta object literal for the '<em><b>Viewerpoint Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VIEWPOINT__VIEWERPOINT_CONTAINER = eINSTANCE.getViewpoint_ViewerpointContainer();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.OrchestrationImpl <em>Orchestration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.OrchestrationImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getOrchestration()
     * @generated
     */
    EClass ORCHESTRATION = eINSTANCE.getOrchestration();

    /**
     * The meta object literal for the '<em><b>Factory Component</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ORCHESTRATION__FACTORY_COMPONENT = eINSTANCE.getOrchestration_FactoryComponent();

    /**
     * The meta object literal for the '<em><b>Invocations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ORCHESTRATION__INVOCATIONS = eINSTANCE.getOrchestration_Invocations();

    /**
     * The meta object literal for the '<em><b>Orchestration Context Container</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER = eINSTANCE.getOrchestration_OrchestrationContextContainer();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.OrchestrationContextImpl <em>Orchestration Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.OrchestrationContextImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getOrchestrationContext()
     * @generated
     */
    EClass ORCHESTRATION_CONTEXT = eINSTANCE.getOrchestrationContext();

    /**
     * The meta object literal for the '<em><b>Orchestration Context Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER = eINSTANCE.getOrchestrationContext_OrchestrationContextContainer();

    /**
     * The meta object literal for the '<em><b>Invocation Contexts</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ORCHESTRATION_CONTEXT__INVOCATION_CONTEXTS = eINSTANCE.getOrchestrationContext_InvocationContexts();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ORCHESTRATION_CONTEXT__TYPE = eINSTANCE.getOrchestrationContext_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.OrchestrationContextContainerImpl <em>Orchestration Context Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.OrchestrationContextContainerImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getOrchestrationContextContainer()
     * @generated
     */
    EClass ORCHESTRATION_CONTEXT_CONTAINER = eINSTANCE.getOrchestrationContextContainer();

    /**
     * The meta object literal for the '<em><b>Orchestration</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION = eINSTANCE.getOrchestrationContextContainer_Orchestration();

    /**
     * The meta object literal for the '<em><b>Orchestration Contexts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION_CONTEXTS = eINSTANCE.getOrchestrationContextContainer_OrchestrationContexts();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.InvocationImpl <em>Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.InvocationImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocation()
     * @generated
     */
    EClass INVOCATION = eINSTANCE.getInvocation();

    /**
     * The meta object literal for the '<em><b>Orchestration</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION__ORCHESTRATION = eINSTANCE.getInvocation_Orchestration();

    /**
     * The meta object literal for the '<em><b>Invocation Context Container</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION__INVOCATION_CONTEXT_CONTAINER = eINSTANCE.getInvocation_InvocationContextContainer();

    /**
     * The meta object literal for the '<em><b>Activity</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION__ACTIVITY = eINSTANCE.getInvocation_Activity();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.InvocationContextImpl <em>Invocation Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.InvocationContextImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocationContext()
     * @generated
     */
    EClass INVOCATION_CONTEXT = eINSTANCE.getInvocationContext();

    /**
     * The meta object literal for the '<em><b>Invocation Context Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER = eINSTANCE.getInvocationContext_InvocationContextContainer();

    /**
     * The meta object literal for the '<em><b>Factory Component Exposed Contract</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION_CONTEXT__FACTORY_COMPONENT_EXPOSED_CONTRACT = eINSTANCE.getInvocationContext_FactoryComponentExposedContract();

    /**
     * The meta object literal for the '<em><b>Orchestration Context</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION_CONTEXT__ORCHESTRATION_CONTEXT = eINSTANCE.getInvocationContext_OrchestrationContext();

    /**
     * The meta object literal for the '<em><b>Activity Contract</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION_CONTEXT__ACTIVITY_CONTRACT = eINSTANCE.getInvocationContext_ActivityContract();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION_CONTEXT__TYPE = eINSTANCE.getInvocationContext_Type();

    /**
     * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INVOCATION_CONTEXT__MODE = eINSTANCE.getInvocationContext_Mode();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.InvocationContextConnectorImpl <em>Invocation Context Connector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.InvocationContextConnectorImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocationContextConnector()
     * @generated
     */
    EClass INVOCATION_CONTEXT_CONNECTOR = eINSTANCE.getInvocationContextConnector();

    /**
     * The meta object literal for the '<em><b>Invocation Context Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER = eINSTANCE.getInvocationContextConnector_InvocationContextContainer();

    /**
     * The meta object literal for the '<em><b>Source Invocation Context</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION_CONTEXT_CONNECTOR__SOURCE_INVOCATION_CONTEXT = eINSTANCE.getInvocationContextConnector_SourceInvocationContext();

    /**
     * The meta object literal for the '<em><b>Target Invocation Context</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION_CONTEXT_CONNECTOR__TARGET_INVOCATION_CONTEXT = eINSTANCE.getInvocationContextConnector_TargetInvocationContext();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.InvocationContextContainerImpl <em>Invocation Context Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.InvocationContextContainerImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocationContextContainer()
     * @generated
     */
    EClass INVOCATION_CONTEXT_CONTAINER = eINSTANCE.getInvocationContextContainer();

    /**
     * The meta object literal for the '<em><b>Invocation</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION_CONTEXT_CONTAINER__INVOCATION = eINSTANCE.getInvocationContextContainer_Invocation();

    /**
     * The meta object literal for the '<em><b>Invocation Contexts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXTS = eINSTANCE.getInvocationContextContainer_InvocationContexts();

    /**
     * The meta object literal for the '<em><b>Invocation Context Connectors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXT_CONNECTORS = eINSTANCE.getInvocationContextContainer_InvocationContextConnectors();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.TypeImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.TypeObjectImpl <em>Type Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.TypeObjectImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getTypeObject()
     * @generated
     */
    EClass TYPE_OBJECT = eINSTANCE.getTypeObject();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.TypeClassImpl <em>Type Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.TypeClassImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getTypeClass()
     * @generated
     */
    EClass TYPE_CLASS = eINSTANCE.getTypeClass();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_CLASS__VALUE = eINSTANCE.getTypeClass_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.ContractMode <em>Contract Mode</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.ContractMode
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContractMode()
     * @generated
     */
    EEnum CONTRACT_MODE = eINSTANCE.getContractMode();

    /**
     * The meta object literal for the '<em>URI</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.URI
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getURI()
     * @generated
     */
    EDataType URI = eINSTANCE.getURI();

  }

} // FcorePackage
