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
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.FactoryComponentImpl <em>Factory Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.FactoryComponentImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getFactoryComponent()
   * @generated
   */
  int FACTORY_COMPONENT = 2;

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
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ViewpointContainerImpl <em>Viewpoint Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ViewpointContainerImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getViewpointContainer()
   * @generated
   */
  int VIEWPOINT_CONTAINER = 3;

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
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ViewpointImpl <em>Viewpoint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ViewpointImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getViewpoint()
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
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.OrchestrationImpl <em>Orchestration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.OrchestrationImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getOrchestration()
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
   * The feature id for the '<em><b>Factory Component</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION__FACTORY_COMPONENT = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Invocations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION__INVOCATIONS = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Orchestration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORCHESTRATION_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.InvocationImpl <em>Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.InvocationImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getInvocation()
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
   * The feature id for the '<em><b>Orchestration</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__ORCHESTRATION = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Context Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__CONTEXT_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 1;

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
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.TypeImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getType()
   * @generated
   */
  int TYPE = 7;

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
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.TypeObjectImpl <em>Type Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.TypeObjectImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getTypeObject()
   * @generated
   */
  int TYPE_OBJECT = 8;

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
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.TypeClassImpl <em>Type Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.TypeClassImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getTypeClass()
   * @generated
   */
  int TYPE_CLASS = 9;

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
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ContextContainerImpl <em>Context Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ContextContainerImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContextContainer()
   * @generated
   */
  int CONTEXT_CONTAINER = 13;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ContextImpl <em>Context</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ContextImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContext()
   * @generated
   */
  int CONTEXT = 14;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ContractContainerImpl <em>Contract Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ContractContainerImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContractContainer()
   * @generated
   */
  int CONTRACT_CONTAINER = 10;

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
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ContractImpl <em>Contract</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ContractImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContract()
   * @generated
   */
  int CONTRACT = 11;

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
   * The feature id for the '<em><b>Contract Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__CONTRACT_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Mandatory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__MANDATORY = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__MODE = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__TYPE = MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Contract</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.fcore.impl.ContractConnectorImpl <em>Contract Connector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.fcore.impl.ContractConnectorImpl
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContractConnector()
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
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_CONTAINER__ID = MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_CONTAINER__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_CONTAINER__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Invocation</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_CONTAINER__INVOCATION = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_CONTAINER__CONTEXTS = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_CONTAINER__CONNECTORS = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Context Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_CONTAINER_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

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
   * The feature id for the '<em><b>Context Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__CONTEXT_CONTAINER = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Contract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__CONTRACT = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__TYPE = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

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
   * The meta object id for the '<em>URI</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.common.util.URI
   * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getURI()
   * @generated
   */
  int URI = 16;

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
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.Invocation#getContextContainer <em>Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Context Container</em>'.
   * @see org.eclipse.egf.model.fcore.Invocation#getContextContainer()
   * @see #getInvocation()
   * @generated
   */
  EReference getInvocation_ContextContainer();

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
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.ContextContainer <em>Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context Container</em>'.
   * @see org.eclipse.egf.model.fcore.ContextContainer
   * @generated
   */
  EClass getContextContainer();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.ContextContainer#getInvocation <em>Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Invocation</em>'.
   * @see org.eclipse.egf.model.fcore.ContextContainer#getInvocation()
   * @see #getContextContainer()
   * @generated
   */
  EReference getContextContainer_Invocation();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.fcore.ContextContainer#getContexts <em>Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contexts</em>'.
   * @see org.eclipse.egf.model.fcore.ContextContainer#getContexts()
   * @see #getContextContainer()
   * @generated
   */
  EReference getContextContainer_Contexts();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.fcore.ContextContainer#getConnectors <em>Connectors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Connectors</em>'.
   * @see org.eclipse.egf.model.fcore.ContextContainer#getConnectors()
   * @see #getContextContainer()
   * @generated
   */
  EReference getContextContainer_Connectors();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.Context <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context</em>'.
   * @see org.eclipse.egf.model.fcore.Context
   * @generated
   */
  EClass getContext();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.Context#getContextContainer <em>Context Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Context Container</em>'.
   * @see org.eclipse.egf.model.fcore.Context#getContextContainer()
   * @see #getContext()
   * @generated
   */
  EReference getContext_ContextContainer();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.Context#getContract <em>Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Contract</em>'.
   * @see org.eclipse.egf.model.fcore.Context#getContract()
   * @see #getContext()
   * @generated
   */
  EReference getContext_Contract();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.egf.model.fcore.Context#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.egf.model.fcore.Context#getType()
   * @see #getContext()
   * @generated
   */
  EReference getContext_Type();

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
   * Returns the meta object for class '{@link org.eclipse.egf.model.fcore.ContractConnector <em>Contract Connector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contract Connector</em>'.
   * @see org.eclipse.egf.model.fcore.ContractConnector
   * @generated
   */
  EClass getContractConnector();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.egf.model.fcore.ContractConnector#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Context</em>'.
   * @see org.eclipse.egf.model.fcore.ContractConnector#getContext()
   * @see #getContractConnector()
   * @generated
   */
  EReference getContractConnector_Context();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.ContractConnector#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see org.eclipse.egf.model.fcore.ContractConnector#getSource()
   * @see #getContractConnector()
   * @generated
   */
  EReference getContractConnector_Source();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.fcore.ContractConnector#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.eclipse.egf.model.fcore.ContractConnector#getTarget()
   * @see #getContractConnector()
   * @generated
   */
  EReference getContractConnector_Target();

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
     * The meta object literal for the '<em><b>Contract Container</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTIVITY__CONTRACT_CONTAINER = eINSTANCE.getActivity_ContractContainer();

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
     * The meta object literal for the '<em><b>Context Container</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION__CONTEXT_CONTAINER = eINSTANCE.getInvocation_ContextContainer();

    /**
     * The meta object literal for the '<em><b>Activity</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION__ACTIVITY = eINSTANCE.getInvocation_Activity();

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
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ContextContainerImpl <em>Context Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ContextContainerImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContextContainer()
     * @generated
     */
    EClass CONTEXT_CONTAINER = eINSTANCE.getContextContainer();

    /**
     * The meta object literal for the '<em><b>Invocation</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_CONTAINER__INVOCATION = eINSTANCE.getContextContainer_Invocation();

    /**
     * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_CONTAINER__CONTEXTS = eINSTANCE.getContextContainer_Contexts();

    /**
     * The meta object literal for the '<em><b>Connectors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_CONTAINER__CONNECTORS = eINSTANCE.getContextContainer_Connectors();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ContextImpl <em>Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ContextImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContext()
     * @generated
     */
    EClass CONTEXT = eINSTANCE.getContext();

    /**
     * The meta object literal for the '<em><b>Context Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT__CONTEXT_CONTAINER = eINSTANCE.getContext_ContextContainer();

    /**
     * The meta object literal for the '<em><b>Contract</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT__CONTRACT = eINSTANCE.getContext_Contract();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT__TYPE = eINSTANCE.getContext_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ContractContainerImpl <em>Contract Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ContractContainerImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContractContainer()
     * @generated
     */
    EClass CONTRACT_CONTAINER = eINSTANCE.getContractContainer();

    /**
     * The meta object literal for the '<em><b>Activity</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT_CONTAINER__ACTIVITY = eINSTANCE.getContractContainer_Activity();

    /**
     * The meta object literal for the '<em><b>Contracts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT_CONTAINER__CONTRACTS = eINSTANCE.getContractContainer_Contracts();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ContractImpl <em>Contract</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ContractImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContract()
     * @generated
     */
    EClass CONTRACT = eINSTANCE.getContract();

    /**
     * The meta object literal for the '<em><b>Contract Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT__CONTRACT_CONTAINER = eINSTANCE.getContract_ContractContainer();

    /**
     * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACT__MANDATORY = eINSTANCE.getContract_Mandatory();

    /**
     * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACT__MODE = eINSTANCE.getContract_Mode();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT__TYPE = eINSTANCE.getContract_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.fcore.impl.ContractConnectorImpl <em>Contract Connector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.fcore.impl.ContractConnectorImpl
     * @see org.eclipse.egf.model.fcore.impl.FcorePackageImpl#getContractConnector()
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
