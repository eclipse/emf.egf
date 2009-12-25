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
package org.eclipse.egf.model.fcore.impl;

import org.eclipse.egf.model.fcore.*;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FactoryComponentContractContainer;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.InvocationContextConnector;
import org.eclipse.egf.model.fcore.InvocationContextContainer;
import org.eclipse.egf.model.fcore.OrchestrationContext;
import org.eclipse.egf.model.fcore.OrchestrationContextContainer;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FcoreFactoryImpl extends EFactoryImpl implements FcoreFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FcoreFactory init() {
    try {
      FcoreFactory theFcoreFactory = (FcoreFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/fcore"); //$NON-NLS-1$ 
      if (theFcoreFactory != null) {
        return theFcoreFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new FcoreFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FcoreFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case FcorePackage.FACTORY_COMPONENT:
      return createFactoryComponent();
    case FcorePackage.FACTORY_COMPONENT_CONTRACT:
      return createFactoryComponentContract();
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER:
      return createFactoryComponentContractContainer();
    case FcorePackage.VIEWPOINT_CONTAINER:
      return createViewpointContainer();
    case FcorePackage.ORCHESTRATION_CONTEXT:
      return createOrchestrationContext();
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER:
      return createOrchestrationContextContainer();
    case FcorePackage.INVOCATION_CONTEXT:
      return createInvocationContext();
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR:
      return createInvocationContextConnector();
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER:
      return createInvocationContextContainer();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
    case FcorePackage.CONTRACT_MODE:
      return createContractModeFromString(eDataType, initialValue);
    case FcorePackage.URI:
      return createURIFromString(eDataType, initialValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
    case FcorePackage.CONTRACT_MODE:
      return convertContractModeToString(eDataType, instanceValue);
    case FcorePackage.URI:
      return convertURIToString(eDataType, instanceValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponent createFactoryComponent() {
    FactoryComponentImpl factoryComponent = new FactoryComponentImpl();
    return factoryComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponentContract createFactoryComponentContract() {
    FactoryComponentContractImpl factoryComponentContract = new FactoryComponentContractImpl();
    return factoryComponentContract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponentContractContainer createFactoryComponentContractContainer() {
    FactoryComponentContractContainerImpl factoryComponentContractContainer = new FactoryComponentContractContainerImpl();
    return factoryComponentContractContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ViewpointContainer createViewpointContainer() {
    ViewpointContainerImpl viewpointContainer = new ViewpointContainerImpl();
    return viewpointContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrchestrationContext createOrchestrationContext() {
    OrchestrationContextImpl orchestrationContext = new OrchestrationContextImpl();
    return orchestrationContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrchestrationContextContainer createOrchestrationContextContainer() {
    OrchestrationContextContainerImpl orchestrationContextContainer = new OrchestrationContextContainerImpl();
    return orchestrationContextContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContext createInvocationContext() {
    InvocationContextImpl invocationContext = new InvocationContextImpl();
    return invocationContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContextConnector createInvocationContextConnector() {
    InvocationContextConnectorImpl invocationContextConnector = new InvocationContextConnectorImpl();
    return invocationContextConnector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContextContainer createInvocationContextContainer() {
    InvocationContextContainerImpl invocationContextContainer = new InvocationContextContainerImpl();
    return invocationContextContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContractMode createContractModeFromString(EDataType eDataType, String initialValue) {
    ContractMode result = ContractMode.get(initialValue);
    if (result == null)
      throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertContractModeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public URI createURIFromString(EDataType eDataType, String initialValue) {
    return URI.createURI(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertURIToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Class<?> createClazzFromString(EDataType eDataType, String initialValue) {
    return (Class<?>) super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FcorePackage getFcorePackage() {
    return (FcorePackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static FcorePackage getPackage() {
    return FcorePackage.eINSTANCE;
  }

} // FcoreFactoryImpl
