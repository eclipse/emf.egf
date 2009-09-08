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
package org.eclipse.egf.model.impl;

import org.eclipse.egf.model.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static ModelFactory init() {
    try {
      ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/FactoryComponent"); //$NON-NLS-1$ 
      if (theModelFactory != null) {
        return theModelFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ModelFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ModelFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case ModelPackage.FACTORY_COMPONENT: return createFactoryComponent();
      case ModelPackage.PRODUCTION_PLAN: return createProductionPlan();
      case ModelPackage.FACTORY_COMPONENT_INVOCATION: return createFactoryComponentInvocation();
      case ModelPackage.DOMAIN: return createDomain();
      case ModelPackage.SPECIFICATION: return createSpecification();
      case ModelPackage.CONTRACT: return createContract();
      case ModelPackage.CONTRACT_ELEMENT: return createContractElement();
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE: return createContractElementReference();
      case ModelPackage.TYPE: return createType();
      case ModelPackage.PATTERN_VIEWPOINT: return createPatternViewpoint();
      case ModelPackage.PATTERN_LIBRARY: return createPatternLibrary();
      case ModelPackage.PATTERN_MODEL: return createPatternModel();
      case ModelPackage.FACTORY: return createFactory();
      case ModelPackage.CONTEXT: return createContext();
      case ModelPackage.CONTEXT_ELEMENT: return createContextElement();
      case ModelPackage.TASK_FACTORY_HOLDER: return createTaskFactoryHolder();
      case ModelPackage.MAPPING_VIEWPOINT: return createMappingViewpoint();
      case ModelPackage.MAPPING_MODEL: return createMappingModel();
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
      case ModelPackage.VIEWPOINT_TYPE:
        return createViewpointTypeFromString(eDataType, initialValue);
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
      case ModelPackage.VIEWPOINT_TYPE:
        return convertViewpointTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
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
  public Domain createDomain() {
    DomainImpl domain = new DomainImpl();
    return domain;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Specification createSpecification() {
    SpecificationImpl specification = new SpecificationImpl();
    return specification;
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
  public ContractElement createContractElement() {
    ContractElementImpl contractElement = new ContractElementImpl();
    return contractElement;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ContractElementReference createContractElementReference() {
    ContractElementReferenceImpl contractElementReference = new ContractElementReferenceImpl();
    return contractElementReference;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Type createType() {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PatternViewpoint createPatternViewpoint() {
    PatternViewpointImpl patternViewpoint = new PatternViewpointImpl();
    return patternViewpoint;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PatternLibrary createPatternLibrary() {
    PatternLibraryImpl patternLibrary = new PatternLibraryImpl();
    return patternLibrary;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PatternModel createPatternModel() {
    PatternModelImpl patternModel = new PatternModelImpl();
    return patternModel;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Factory createFactory() {
    FactoryImpl factory = new FactoryImpl();
    return factory;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ProductionPlan createProductionPlan() {
    ProductionPlanImpl productionPlan = new ProductionPlanImpl();
    return productionPlan;
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
  public ContextElement createContextElement() {
    ContextElementImpl contextElement = new ContextElementImpl();
    return contextElement;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponentInvocation createFactoryComponentInvocation() {
    FactoryComponentInvocationImpl factoryComponentInvocation = new FactoryComponentInvocationImpl();
    return factoryComponentInvocation;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public TaskFactoryHolder createTaskFactoryHolder() {
    TaskFactoryHolderImpl taskFactoryHolder = new TaskFactoryHolderImpl();
    return taskFactoryHolder;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public MappingViewpoint createMappingViewpoint() {
    MappingViewpointImpl mappingViewpoint = new MappingViewpointImpl();
    return mappingViewpoint;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public MappingModel createMappingModel() {
    MappingModelImpl mappingModel = new MappingModelImpl();
    return mappingModel;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ViewpointType createViewpointTypeFromString(EDataType eDataType, String initialValue) {
    ViewpointType result = ViewpointType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertViewpointTypeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ModelPackage getModelPackage() {
    return (ModelPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ModelPackage getPackage() {
    return ModelPackage.eINSTANCE;
  }

} // ModelFactoryImpl
