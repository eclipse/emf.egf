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
package org.eclipse.egf.model.factorycomponent.impl;

import org.eclipse.egf.model.factorycomponent.*;
import org.eclipse.egf.model.factorycomponent.Context;
import org.eclipse.egf.model.factorycomponent.Contract;
import org.eclipse.egf.model.factorycomponent.ContractConnector;
import org.eclipse.egf.model.factorycomponent.ContractContainer;
import org.eclipse.egf.model.factorycomponent.ContractMode;
import org.eclipse.egf.model.factorycomponent.ContractValue;
import org.eclipse.egf.model.factorycomponent.FactoryComponent;
import org.eclipse.egf.model.factorycomponent.FactoryComponentFactory;
import org.eclipse.egf.model.factorycomponent.FactoryComponentPackage;
import org.eclipse.egf.model.factorycomponent.Task;
import org.eclipse.egf.model.factorycomponent.ViewpointContainer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class FactoryComponentFactoryImpl extends EFactoryImpl implements FactoryComponentFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  public static FactoryComponentFactory init() {
    try {
      FactoryComponentFactory theFactoryComponentFactory = (FactoryComponentFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/factorycomponent"); //$NON-NLS-1$ 
      if (theFactoryComponentFactory != null) {
        return theFactoryComponentFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new FactoryComponentFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  public FactoryComponentFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case FactoryComponentPackage.TASK:
      return createTask();
    case FactoryComponentPackage.FACTORY_COMPONENT:
      return createFactoryComponent();
    case FactoryComponentPackage.VIEWPOINT_CONTAINER:
      return createViewpointContainer();
    case FactoryComponentPackage.CONTEXT:
      return createContext();
    case FactoryComponentPackage.CONTRACT_CONTAINER:
      return createContractContainer();
    case FactoryComponentPackage.CONTRACT:
      return createContract();
    case FactoryComponentPackage.CONTRACT_VALUE:
      return createContractValue();
    case FactoryComponentPackage.CONTRACT_CONNECTOR:
      return createContractConnector();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
    case FactoryComponentPackage.CONTRACT_MODE:
      return createContractModeFromString(eDataType, initialValue);
    case FactoryComponentPackage.INVOCATION_EXCEPTION:
      return createInvocationExceptionFromString(eDataType, initialValue);
    case FactoryComponentPackage.URI:
      return createURIFromString(eDataType, initialValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
    case FactoryComponentPackage.CONTRACT_MODE:
      return convertContractModeToString(eDataType, instanceValue);
    case FactoryComponentPackage.INVOCATION_EXCEPTION:
      return convertInvocationExceptionToString(eDataType, instanceValue);
    case FactoryComponentPackage.URI:
      return convertURIToString(eDataType, instanceValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Task createTask() {
    TaskImpl task = new TaskImpl();
    return task;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponent createFactoryComponent() {
    FactoryComponentImpl factoryComponent = new FactoryComponentImpl();
    return factoryComponent;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ViewpointContainer createViewpointContainer() {
    ViewpointContainerImpl viewpointContainer = new ViewpointContainerImpl();
    return viewpointContainer;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Context createContext() {
    ContextImpl context = new ContextImpl();
    return context;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ContractContainer createContractContainer() {
    ContractContainerImpl contractContainer = new ContractContainerImpl();
    return contractContainer;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Contract createContract() {
    ContractImpl contract = new ContractImpl();
    return contract;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ContractValue createContractValue() {
    ContractValueImpl contractValue = new ContractValueImpl();
    return contractValue;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ContractConnector createContractConnector() {
    ContractConnectorImpl contractConnector = new ContractConnectorImpl();
    return contractConnector;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ContractMode createContractModeFromString(EDataType eDataType, String initialValue) {
    ContractMode result = ContractMode.get(initialValue);
    if (result == null)
      throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertContractModeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public RuntimeException createInvocationExceptionFromString(EDataType eDataType, String initialValue) {
    return (RuntimeException) super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertInvocationExceptionToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public URI createURIFromString(EDataType eDataType, String initialValue) {
    return URI.createURI(initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertURIToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponentPackage getFactoryComponentPackage() {
    return (FactoryComponentPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static FactoryComponentPackage getPackage() {
    return FactoryComponentPackage.eINSTANCE;
  }

} // FactoryComponentFactoryImpl
