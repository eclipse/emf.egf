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

import org.eclipse.egf.model.AbstractFactoryComponentFactory;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.AbstractViewpoint;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.Factory;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.MappingViewpoint;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.PatternViewpoint;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.Specification;
import org.eclipse.egf.model.TaskFactoryHolder;
import org.eclipse.egf.model.Type;
import org.eclipse.egf.model.ViewpointType;
import org.eclipse.egf.model.util.ModelValidator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass namedModelElementWithIdEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass factoryComponentEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass domainEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass specificationEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractViewpointEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass contractEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass contractElementEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass contractElementReferenceEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass patternViewpointEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractPatternElementEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass patternLibraryEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass patternModelEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass factoryEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractFactoryComponentFactoryEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass productionPlanEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass contextEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass contextElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass factoryComponentInvocationEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass taskFactoryHolderEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass mappingViewpointEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass mappingModelEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EEnum viewpointTypeEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.egf.model.ModelPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ModelPackageImpl() {
    super(eNS_URI, ModelFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ModelPackage init() {
    if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

    // Obtain or create and register package
    ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theModelPackage.createPackageContents();

    // Initialize created meta-data
    theModelPackage.initializePackageContents();

    // Register package validator
    EValidator.Registry.INSTANCE.put
      (theModelPackage, 
       new EValidator.Descriptor() {
         public EValidator getEValidator() {
           return ModelValidator.INSTANCE;
         }
       });

    // Mark meta-data to indicate it can't be changed
    theModelPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
    return theModelPackage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedModelElementWithId() {
    return namedModelElementWithIdEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedModelElementWithId_Id() {
    return (EAttribute)namedModelElementWithIdEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedModelElementWithId_JavaIdentifier() {
    return (EAttribute)namedModelElementWithIdEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedModelElementWithId_Name() {
    return (EAttribute)namedModelElementWithIdEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedModelElementWithId_Description() {
    return (EAttribute)namedModelElementWithIdEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getFactoryComponent() {
    return factoryComponentEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryComponent_Domain() {
    return (EReference)factoryComponentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryComponent_Specification() {
    return (EReference)factoryComponentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryComponent_Factory() {
    return (EReference)factoryComponentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getDomain() {
    return domainEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDomain_Path() {
    return (EAttribute)domainEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpecification() {
    return specificationEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecification_Viewpoints() {
    return (EReference)specificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecification_ViewpointIds() {
    return (EAttribute)specificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractViewpoint() {
    return abstractViewpointEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getContract() {
    return contractEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getContract_ContractElements() {
    return (EReference)contractEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getContractElement() {
    return contractElementEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractElement_ContractElementReferences() {
    return (EReference)contractElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractElement_FactoryComponentId() {
    return (EAttribute)contractElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractElement_ContractReferenceIds() {
    return (EAttribute)contractElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractElement_ContractType() {
    return (EReference)contractElementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractElement_Mandatory() {
    return (EAttribute)contractElementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getContractElementReference() {
    return contractElementReferenceEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractElementReference_ReferencedContractElementId() {
    return (EAttribute)contractElementReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractElementReference_ReferencedContractElementName() {
    return (EAttribute)contractElementReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractElementReference_ReferencedFactoryComponentId() {
    return (EAttribute)contractElementReferenceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractElementReference_ReferencedContractElement() {
    return (EReference)contractElementReferenceEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getType() {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getType_TypeHolderClassName() {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getType_TypeHolder() {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getPatternViewpoint() {
    return patternViewpointEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getPatternViewpoint_Libraries() {
    return (EReference)patternViewpointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractPatternElement() {
    return abstractPatternElementEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getPatternLibrary() {
    return patternLibraryEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getPatternLibrary_PatternElements() {
    return (EReference)patternLibraryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPatternLibrary_ProductionOrchestration() {
    return (EAttribute)patternLibraryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPatternLibrary_RuntimeOrchestration() {
    return (EAttribute)patternLibraryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getPatternModel() {
    return patternModelEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPatternModel_Path() {
    return (EAttribute)patternModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getFactory() {
    return factoryEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactory_ProductionPlan() {
    return (EReference)factoryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFactory_ProductionPlanId() {
    return (EAttribute)factoryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractFactoryComponentFactory() {
    return abstractFactoryComponentFactoryEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractFactoryComponentFactory_Context() {
    return (EReference)abstractFactoryComponentFactoryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractFactoryComponentFactory_ContextId() {
    return (EAttribute)abstractFactoryComponentFactoryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getProductionPlan() {
    return productionPlanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProductionPlan_FactoryComponentInvocations() {
    return (EReference)productionPlanEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProductionPlan_FactoryComponentInvocationIds() {
    return (EAttribute)productionPlanEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getContext() {
    return contextEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getContext_ContextElements() {
    return (EReference)contextEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getContextElement() {
    return contextElementEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getContextElement_ContractElementReference() {
    return (EReference)contextElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContextElement_Value() {
    return (EAttribute)contextElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContextElement_ReadableValue() {
    return (EAttribute)contextElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContextElement_Key() {
    return (EAttribute)contextElementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContextElement_ContractReferenceId() {
    return (EAttribute)contextElementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getContextElement_ContextType() {
    return (EReference)contextElementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContextElement_PluginId() {
    return (EAttribute)contextElementEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getFactoryComponentInvocation() {
    return factoryComponentInvocationEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFactoryComponentInvocation_TaskFactoryId() {
    return (EAttribute)factoryComponentInvocationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFactoryComponentInvocation_FactoryComponentId() {
    return (EAttribute)factoryComponentInvocationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryComponentInvocation_TaskFactory() {
    return (EReference)factoryComponentInvocationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getTaskFactoryHolder() {
    return taskFactoryHolderEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTaskFactoryHolder_FactoryClass() {
    return (EAttribute)taskFactoryHolderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTaskFactoryHolder_Factory() {
    return (EAttribute)taskFactoryHolderEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getMappingViewpoint() {
    return mappingViewpointEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getMappingViewpoint_Mappings() {
    return (EReference)mappingViewpointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getMappingModel() {
    return mappingModelEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMappingModel_Path() {
    return (EAttribute)mappingModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMappingModel_Source() {
    return (EAttribute)mappingModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMappingModel_Target() {
    return (EAttribute)mappingModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EEnum getViewpointType() {
    return viewpointTypeEEnum;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ModelFactory getModelFactory() {
    return (ModelFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    namedModelElementWithIdEClass = createEClass(NAMED_MODEL_ELEMENT_WITH_ID);
    createEAttribute(namedModelElementWithIdEClass, NAMED_MODEL_ELEMENT_WITH_ID__ID);
    createEAttribute(namedModelElementWithIdEClass, NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER);
    createEAttribute(namedModelElementWithIdEClass, NAMED_MODEL_ELEMENT_WITH_ID__NAME);
    createEAttribute(namedModelElementWithIdEClass, NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION);

    factoryComponentEClass = createEClass(FACTORY_COMPONENT);
    createEReference(factoryComponentEClass, FACTORY_COMPONENT__DOMAIN);
    createEReference(factoryComponentEClass, FACTORY_COMPONENT__SPECIFICATION);
    createEReference(factoryComponentEClass, FACTORY_COMPONENT__FACTORY);

    productionPlanEClass = createEClass(PRODUCTION_PLAN);
    createEReference(productionPlanEClass, PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS);
    createEAttribute(productionPlanEClass, PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATION_IDS);

    factoryComponentInvocationEClass = createEClass(FACTORY_COMPONENT_INVOCATION);
    createEAttribute(factoryComponentInvocationEClass, FACTORY_COMPONENT_INVOCATION__TASK_FACTORY_ID);
    createEAttribute(factoryComponentInvocationEClass, FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT_ID);
    createEReference(factoryComponentInvocationEClass, FACTORY_COMPONENT_INVOCATION__TASK_FACTORY);

    domainEClass = createEClass(DOMAIN);
    createEAttribute(domainEClass, DOMAIN__PATH);

    specificationEClass = createEClass(SPECIFICATION);
    createEReference(specificationEClass, SPECIFICATION__VIEWPOINTS);
    createEAttribute(specificationEClass, SPECIFICATION__VIEWPOINT_IDS);

    abstractViewpointEClass = createEClass(ABSTRACT_VIEWPOINT);

    contractEClass = createEClass(CONTRACT);
    createEReference(contractEClass, CONTRACT__CONTRACT_ELEMENTS);

    contractElementEClass = createEClass(CONTRACT_ELEMENT);
    createEReference(contractElementEClass, CONTRACT_ELEMENT__CONTRACT_ELEMENT_REFERENCES);
    createEAttribute(contractElementEClass, CONTRACT_ELEMENT__FACTORY_COMPONENT_ID);
    createEAttribute(contractElementEClass, CONTRACT_ELEMENT__CONTRACT_REFERENCE_IDS);
    createEReference(contractElementEClass, CONTRACT_ELEMENT__CONTRACT_TYPE);
    createEAttribute(contractElementEClass, CONTRACT_ELEMENT__MANDATORY);

    contractElementReferenceEClass = createEClass(CONTRACT_ELEMENT_REFERENCE);
    createEAttribute(contractElementReferenceEClass, CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_ID);
    createEAttribute(contractElementReferenceEClass, CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_NAME);
    createEAttribute(contractElementReferenceEClass, CONTRACT_ELEMENT_REFERENCE__REFERENCED_FACTORY_COMPONENT_ID);
    createEReference(contractElementReferenceEClass, CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT);

    typeEClass = createEClass(TYPE);
    createEAttribute(typeEClass, TYPE__TYPE_HOLDER_CLASS_NAME);
    createEAttribute(typeEClass, TYPE__TYPE_HOLDER);

    patternViewpointEClass = createEClass(PATTERN_VIEWPOINT);
    createEReference(patternViewpointEClass, PATTERN_VIEWPOINT__LIBRARIES);

    abstractPatternElementEClass = createEClass(ABSTRACT_PATTERN_ELEMENT);

    patternLibraryEClass = createEClass(PATTERN_LIBRARY);
    createEReference(patternLibraryEClass, PATTERN_LIBRARY__PATTERN_ELEMENTS);
    createEAttribute(patternLibraryEClass, PATTERN_LIBRARY__PRODUCTION_ORCHESTRATION);
    createEAttribute(patternLibraryEClass, PATTERN_LIBRARY__RUNTIME_ORCHESTRATION);

    patternModelEClass = createEClass(PATTERN_MODEL);
    createEAttribute(patternModelEClass, PATTERN_MODEL__PATH);

    factoryEClass = createEClass(FACTORY);
    createEReference(factoryEClass, FACTORY__PRODUCTION_PLAN);
    createEAttribute(factoryEClass, FACTORY__PRODUCTION_PLAN_ID);

    abstractFactoryComponentFactoryEClass = createEClass(ABSTRACT_FACTORY_COMPONENT_FACTORY);
    createEReference(abstractFactoryComponentFactoryEClass, ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT);
    createEAttribute(abstractFactoryComponentFactoryEClass, ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT_ID);

    contextEClass = createEClass(CONTEXT);
    createEReference(contextEClass, CONTEXT__CONTEXT_ELEMENTS);

    contextElementEClass = createEClass(CONTEXT_ELEMENT);
    createEReference(contextElementEClass, CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE);
    createEAttribute(contextElementEClass, CONTEXT_ELEMENT__VALUE);
    createEAttribute(contextElementEClass, CONTEXT_ELEMENT__READABLE_VALUE);
    createEAttribute(contextElementEClass, CONTEXT_ELEMENT__KEY);
    createEAttribute(contextElementEClass, CONTEXT_ELEMENT__CONTRACT_REFERENCE_ID);
    createEReference(contextElementEClass, CONTEXT_ELEMENT__CONTEXT_TYPE);
    createEAttribute(contextElementEClass, CONTEXT_ELEMENT__PLUGIN_ID);

    taskFactoryHolderEClass = createEClass(TASK_FACTORY_HOLDER);
    createEAttribute(taskFactoryHolderEClass, TASK_FACTORY_HOLDER__FACTORY_CLASS);
    createEAttribute(taskFactoryHolderEClass, TASK_FACTORY_HOLDER__FACTORY);

    mappingViewpointEClass = createEClass(MAPPING_VIEWPOINT);
    createEReference(mappingViewpointEClass, MAPPING_VIEWPOINT__MAPPINGS);

    mappingModelEClass = createEClass(MAPPING_MODEL);
    createEAttribute(mappingModelEClass, MAPPING_MODEL__PATH);
    createEAttribute(mappingModelEClass, MAPPING_MODEL__SOURCE);
    createEAttribute(mappingModelEClass, MAPPING_MODEL__TARGET);

    // Create enums
    viewpointTypeEEnum = createEEnum(VIEWPOINT_TYPE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any invocation but its first. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    factoryComponentEClass.getESuperTypes().add(this.getNamedModelElementWithId());
    productionPlanEClass.getESuperTypes().add(this.getAbstractFactoryComponentFactory());
    factoryComponentInvocationEClass.getESuperTypes().add(this.getAbstractFactoryComponentFactory());
    domainEClass.getESuperTypes().add(this.getNamedModelElementWithId());
    specificationEClass.getESuperTypes().add(this.getNamedModelElementWithId());
    abstractViewpointEClass.getESuperTypes().add(this.getNamedModelElementWithId());
    contractEClass.getESuperTypes().add(this.getAbstractViewpoint());
    contractElementEClass.getESuperTypes().add(this.getNamedModelElementWithId());
    contractElementReferenceEClass.getESuperTypes().add(this.getNamedModelElementWithId());
    typeEClass.getESuperTypes().add(this.getNamedModelElementWithId());
    patternViewpointEClass.getESuperTypes().add(this.getAbstractViewpoint());
    abstractPatternElementEClass.getESuperTypes().add(this.getNamedModelElementWithId());
    patternLibraryEClass.getESuperTypes().add(this.getAbstractPatternElement());
    patternModelEClass.getESuperTypes().add(this.getAbstractPatternElement());
    factoryEClass.getESuperTypes().add(this.getNamedModelElementWithId());
    abstractFactoryComponentFactoryEClass.getESuperTypes().add(this.getNamedModelElementWithId());
    contextEClass.getESuperTypes().add(this.getNamedModelElementWithId());
    contextElementEClass.getESuperTypes().add(this.getNamedModelElementWithId());
    taskFactoryHolderEClass.getESuperTypes().add(this.getNamedModelElementWithId());
    mappingViewpointEClass.getESuperTypes().add(this.getAbstractViewpoint());
    mappingModelEClass.getESuperTypes().add(this.getNamedModelElementWithId());

    // Initialize classes and features; add operations and parameters
    initEClass(namedModelElementWithIdEClass, NamedModelElementWithId.class, "NamedModelElementWithId", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getNamedModelElementWithId_Id(), ecorePackage.getEString(), "id", null, 1, 1, NamedModelElementWithId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getNamedModelElementWithId_JavaIdentifier(), ecorePackage.getEString(), "javaIdentifier", null, 0, 1, NamedModelElementWithId.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getNamedModelElementWithId_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedModelElementWithId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getNamedModelElementWithId_Description(), ecorePackage.getEString(), "description", null, 0, 1, NamedModelElementWithId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(factoryComponentEClass, FactoryComponent.class, "FactoryComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getFactoryComponent_Domain(), this.getDomain(), null, "domain", null, 0, 1, FactoryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getFactoryComponent_Specification(), this.getSpecification(), null, "specification", null, 1, 1, FactoryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getFactoryComponent_Factory(), this.getFactory(), null, "factory", null, 1, 1, FactoryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(productionPlanEClass, ProductionPlan.class, "ProductionPlan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getProductionPlan_FactoryComponentInvocations(), this.getFactoryComponentInvocation(), null, "factoryComponentInvocations", null, 0, -1, ProductionPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getProductionPlan_FactoryComponentInvocationIds(), ecorePackage.getEString(), "factoryComponentInvocationIds", null, 0, -1, ProductionPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(factoryComponentInvocationEClass, FactoryComponentInvocation.class, "FactoryComponentInvocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getFactoryComponentInvocation_TaskFactoryId(), ecorePackage.getEString(), "taskFactoryId", null, 0, 1, FactoryComponentInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getFactoryComponentInvocation_FactoryComponentId(), ecorePackage.getEString(), "factoryComponentId", null, 1, 1, FactoryComponentInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getFactoryComponentInvocation_TaskFactory(), this.getTaskFactoryHolder(), null, "taskFactory", null, 0, 1, FactoryComponentInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(domainEClass, Domain.class, "Domain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getDomain_Path(), ecorePackage.getEString(), "path", null, 0, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(specificationEClass, Specification.class, "Specification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getSpecification_Viewpoints(), this.getAbstractViewpoint(), null, "viewpoints", null, 0, -1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    EGenericType g1 = createEGenericType(ecorePackage.getEMap());
    EGenericType g2 = createEGenericType(this.getViewpointType());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(ecorePackage.getEEList());
    g1.getETypeArguments().add(g2);
    EGenericType g3 = createEGenericType(ecorePackage.getEString());
    g2.getETypeArguments().add(g3);
    initEAttribute(getSpecification_ViewpointIds(), g1, "viewpointIds", null, 0, 1, Specification.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(abstractViewpointEClass, AbstractViewpoint.class, "AbstractViewpoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(contractEClass, Contract.class, "Contract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getContract_ContractElements(), this.getContractElement(), null, "contractElements", null, 0, -1, Contract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(contractElementEClass, ContractElement.class, "ContractElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getContractElement_ContractElementReferences(), this.getContractElementReference(), null, "contractElementReferences", null, 0, -1, ContractElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getContractElement_FactoryComponentId(), ecorePackage.getEString(), "factoryComponentId", null, 1, 1, ContractElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getContractElement_ContractReferenceIds(), ecorePackage.getEString(), "contractReferenceIds", null, 0, -1, ContractElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getContractElement_ContractType(), this.getType(), null, "contractType", null, 1, 1, ContractElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getContractElement_Mandatory(), ecorePackage.getEBoolean(), "mandatory", "true", 1, 1, ContractElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

    initEClass(contractElementReferenceEClass, ContractElementReference.class, "ContractElementReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getContractElementReference_ReferencedContractElementId(), ecorePackage.getEString(), "referencedContractElementId", null, 1, 1, ContractElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getContractElementReference_ReferencedContractElementName(), ecorePackage.getEString(), "referencedContractElementName", null, 0, 1, ContractElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getContractElementReference_ReferencedFactoryComponentId(), ecorePackage.getEString(), "referencedFactoryComponentId", null, 1, 1, ContractElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getContractElementReference_ReferencedContractElement(), this.getContractElement(), null, "referencedContractElement", null, 0, 1, ContractElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getType_TypeHolderClassName(), ecorePackage.getEString(), "typeHolderClassName", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getType_TypeHolder(), ecorePackage.getEJavaObject(), "typeHolder", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(patternViewpointEClass, PatternViewpoint.class, "PatternViewpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getPatternViewpoint_Libraries(), this.getPatternLibrary(), null, "libraries", null, 0, -1, PatternViewpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(abstractPatternElementEClass, AbstractPatternElement.class, "AbstractPatternElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(patternLibraryEClass, PatternLibrary.class, "PatternLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getPatternLibrary_PatternElements(), this.getAbstractPatternElement(), null, "patternElements", null, 0, -1, PatternLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getPatternLibrary_ProductionOrchestration(), ecorePackage.getEString(), "productionOrchestration", null, 0, 1, PatternLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getPatternLibrary_RuntimeOrchestration(), ecorePackage.getEString(), "runtimeOrchestration", null, 0, 1, PatternLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(patternModelEClass, PatternModel.class, "PatternModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getPatternModel_Path(), ecorePackage.getEString(), "path", null, 1, 1, PatternModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(factoryEClass, Factory.class, "Factory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getFactory_ProductionPlan(), this.getProductionPlan(), null, "productionPlan", null, 1, 1, Factory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getFactory_ProductionPlanId(), ecorePackage.getEString(), "productionPlanId", null, 1, 1, Factory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(abstractFactoryComponentFactoryEClass, AbstractFactoryComponentFactory.class, "AbstractFactoryComponentFactory", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getAbstractFactoryComponentFactory_Context(), this.getContext(), null, "context", null, 0, 1, AbstractFactoryComponentFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getAbstractFactoryComponentFactory_ContextId(), ecorePackage.getEString(), "contextId", null, 0, 1, AbstractFactoryComponentFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getContext_ContextElements(), this.getContextElement(), null, "contextElements", null, 1, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(contextElementEClass, ContextElement.class, "ContextElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getContextElement_ContractElementReference(), this.getContractElementReference(), null, "contractElementReference", null, 0, 1, ContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getContextElement_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, ContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getContextElement_ReadableValue(), ecorePackage.getEString(), "readableValue", null, 1, 1, ContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getContextElement_Key(), ecorePackage.getEString(), "key", null, 0, 1, ContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getContextElement_ContractReferenceId(), ecorePackage.getEString(), "contractReferenceId", null, 0, 1, ContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getContextElement_ContextType(), this.getType(), null, "contextType", null, 0, 1, ContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getContextElement_PluginId(), ecorePackage.getEString(), "pluginId", null, 0, 1, ContextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(taskFactoryHolderEClass, TaskFactoryHolder.class, "TaskFactoryHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTaskFactoryHolder_FactoryClass(), ecorePackage.getEString(), "factoryClass", null, 1, 1, TaskFactoryHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getTaskFactoryHolder_Factory(), ecorePackage.getEJavaObject(), "factory", null, 0, 1, TaskFactoryHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(mappingViewpointEClass, MappingViewpoint.class, "MappingViewpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getMappingViewpoint_Mappings(), this.getMappingModel(), null, "mappings", null, 0, -1, MappingViewpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(mappingModelEClass, MappingModel.class, "MappingModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getMappingModel_Path(), ecorePackage.getEString(), "path", null, 1, 1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getMappingModel_Source(), ecorePackage.getEString(), "source", null, 1, 1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getMappingModel_Target(), ecorePackage.getEString(), "target", null, 1, 1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    // Initialize enums and add enum literals
    initEEnum(viewpointTypeEEnum, ViewpointType.class, "ViewpointType"); //$NON-NLS-1$
    addEEnumLiteral(viewpointTypeEEnum, ViewpointType.CONTRACT);
    addEEnumLiteral(viewpointTypeEEnum, ViewpointType.PATTERN);
    addEEnumLiteral(viewpointTypeEEnum, ViewpointType.MAPPING);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http://www.eclipse.org/emf/2002/Ecore
    createEcoreAnnotations();
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void createEcoreAnnotations() {
    String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$		
    addAnnotation
      (namedModelElementWithIdEClass, 
       source, 
       new String[] {
       "constraints", "overall" //$NON-NLS-1$ //$NON-NLS-2$
       });			
  }

} // ModelPackageImpl
