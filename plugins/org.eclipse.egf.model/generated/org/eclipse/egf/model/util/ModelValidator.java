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
package org.eclipse.egf.model.util;

import java.util.Map;

import org.eclipse.egf.model.*;
import org.eclipse.emf.common.util.Diagnostic;
import org.apache.log4j.Logger;

import org.eclipse.core.runtime.IConfigurationElement;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.model.AbstractFactoryComponentFactory;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.AbstractViewpoint;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.Factory;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.MappingViewpoint;
import org.eclipse.egf.model.ModelActivator;
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
import org.eclipse.egf.model.validation.IDelegatedValidator;


/**
 * <!-- begin-user-doc --> 
 * The <b>Validator</b> for the model. 
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.ModelPackage
 * @generated
 */
public class ModelValidator extends EObjectValidator {

  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(ModelValidator.class.getPackage().getName());

  /**
   * Extension point "delegatedValidator" short id.
   */
  private static final String EXTENSION_POINT_SHORT_ID_DELEGATED_VALIDATOR = "delegatedValidator"; //$NON-NLS-1$

  /**
   * The cached model package
   * <!-- begin-user-doc --> 
   * <!-- end-user-doc -->
   * @generated
   */
  public static final ModelValidator INSTANCE = new ModelValidator();

  /**
   * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.emf.common.util.Diagnostic#getSource()
   * @see org.eclipse.emf.common.util.Diagnostic#getCode()
   * @generated
   */
  public static final String DIAGNOSTIC_SOURCE = "org.eclipse.egf.model"; //$NON-NLS-1$

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants.
   * <!-- begin-user-doc --> 
   * <!-- end-user-doc -->
   * @generated
   */
  private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
   * <!-- begin-user-doc --> 
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ModelValidator() {
    super();
  }

  /**
   * Returns the package of this validator switch.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EPackage getEPackage() {
    return ModelPackage.eINSTANCE;
  }

  /**
   * Calls <code>validateXXX</code> for the corresponding classifier of the model.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
    switch (classifierID) {
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID:
        return validateNamedModelElementWithId((NamedModelElementWithId)value, diagnostics, context);
      case ModelPackage.FACTORY_COMPONENT:
        return validateFactoryComponent((FactoryComponent)value, diagnostics, context);
      case ModelPackage.PRODUCTION_PLAN:
        return validateProductionPlan((ProductionPlan)value, diagnostics, context);
      case ModelPackage.FACTORY_COMPONENT_INVOCATION:
        return validateFactoryComponentInvocation((FactoryComponentInvocation)value, diagnostics, context);
      case ModelPackage.DOMAIN:
        return validateDomain((Domain)value, diagnostics, context);
      case ModelPackage.SPECIFICATION:
        return validateSpecification((Specification)value, diagnostics, context);
      case ModelPackage.ABSTRACT_VIEWPOINT:
        return validateAbstractViewpoint((AbstractViewpoint)value, diagnostics, context);
      case ModelPackage.CONTRACT:
        return validateContract((Contract)value, diagnostics, context);
      case ModelPackage.CONTRACT_ELEMENT:
        return validateContractElement((ContractElement)value, diagnostics, context);
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE:
        return validateContractElementReference((ContractElementReference)value, diagnostics, context);
      case ModelPackage.TYPE:
        return validateType((Type)value, diagnostics, context);
      case ModelPackage.PATTERN_VIEWPOINT:
        return validatePatternViewpoint((PatternViewpoint)value, diagnostics, context);
      case ModelPackage.ABSTRACT_PATTERN_ELEMENT:
        return validateAbstractPatternElement((AbstractPatternElement)value, diagnostics, context);
      case ModelPackage.PATTERN_LIBRARY:
        return validatePatternLibrary((PatternLibrary)value, diagnostics, context);
      case ModelPackage.PATTERN_MODEL:
        return validatePatternModel((PatternModel)value, diagnostics, context);
      case ModelPackage.FACTORY:
        return validateFactory((Factory)value, diagnostics, context);
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY:
        return validateAbstractFactoryComponentFactory((AbstractFactoryComponentFactory)value, diagnostics, context);
      case ModelPackage.CONTEXT:
        return validateContext((Context)value, diagnostics, context);
      case ModelPackage.CONTEXT_ELEMENT:
        return validateContextElement((ContextElement)value, diagnostics, context);
      case ModelPackage.TASK_FACTORY_HOLDER:
        return validateTaskFactoryHolder((TaskFactoryHolder)value, diagnostics, context);
      case ModelPackage.MAPPING_VIEWPOINT:
        return validateMappingViewpoint((MappingViewpoint)value, diagnostics, context);
      case ModelPackage.MAPPING_MODEL:
        return validateMappingModel((MappingModel)value, diagnostics, context);
      case ModelPackage.VIEWPOINT_TYPE:
        return validateViewpointType((ViewpointType)value, diagnostics, context);
      default:
        return true;
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateNamedModelElementWithId(
    NamedModelElementWithId namedModelElementWithId,
    DiagnosticChain diagnostics,
    Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(namedModelElementWithId, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(namedModelElementWithId, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(namedModelElementWithId, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(namedModelElementWithId, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(namedModelElementWithId, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(namedModelElementWithId, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(namedModelElementWithId, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(namedModelElementWithId, diagnostics, context);
    return result;
  }

  /**
   * Validates the overall constraint of '<em>Named Model Element With Id</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean validateNamedModelElementWithId_overall(
    NamedModelElementWithId namedModelElementWithId,
    DiagnosticChain diagnostics,
    Map<Object, Object> context) {
    boolean valid = true;
    // Delegated validator used to check business rules.
    // Must be allocating at each call for re-entrance issue.
    // Indeed, the delegated model element validator can call diagnostician.validate that invokes this method again.
    IDelegatedValidator delegatedValidator = getDelegatedValidator();
    if (null != delegatedValidator) {
      valid = delegatedValidator.validate(namedModelElementWithId, diagnostics, context);
    } else {
      StringBuilder loggerMessage = new StringBuilder("ModelValidator.validateNamedModelElementWithId_overall(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Delegated validator implementor not found."); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString());
    }
    return valid;
  }

  /**
   * Get the delegated validator.
   * @return
   */
  private IDelegatedValidator getDelegatedValidator() {
    IDelegatedValidator delegatedValidator = null;
    // Get extensions abiding to user helper extension point.
    IConfigurationElement[] configurationElements = ExtensionPointHelper.getConfigurationElements(
      ModelActivator.getDefault().getPluginID(),
      EXTENSION_POINT_SHORT_ID_DELEGATED_VALIDATOR);
    if ((null != configurationElements) && (configurationElements.length > 0)) {
      // There should be one implementation only !
      // So take the first one, as expected.
      Object instantiatedClass = ExtensionPointHelper.createInstance(configurationElements[0], ExtensionPointHelper.ATT_CLASS);
      // Make sure this is the correct resulting type.
      if (instantiatedClass instanceof IDelegatedValidator) {
        delegatedValidator = (IDelegatedValidator) instantiatedClass;
      }
    }
    return delegatedValidator;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateFactoryComponent(FactoryComponent factoryComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(factoryComponent, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(factoryComponent, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(factoryComponent, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(factoryComponent, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(factoryComponent, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(factoryComponent, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(factoryComponent, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(factoryComponent, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateDomain(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(domain, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(domain, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(domain, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(domain, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(domain, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(domain, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(domain, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(domain, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSpecification(Specification specification, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(specification, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(specification, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(specification, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(specification, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(specification, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(specification, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(specification, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(specification, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAbstractViewpoint(AbstractViewpoint abstractViewpoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(abstractViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(abstractViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(abstractViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(abstractViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(abstractViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(abstractViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(abstractViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(abstractViewpoint, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContract(Contract contract, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(contract, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(contract, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(contract, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(contract, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(contract, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(contract, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(contract, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(contract, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContractElement(ContractElement contractElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(contractElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(contractElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(contractElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(contractElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(contractElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(contractElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(contractElement, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(contractElement, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContractElementReference(
    ContractElementReference contractElementReference,
    DiagnosticChain diagnostics,
    Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(contractElementReference, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(contractElementReference, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(contractElementReference, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(contractElementReference, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(contractElementReference, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(contractElementReference, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(contractElementReference, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(contractElementReference, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateType(Type type, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(type, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(type, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(type, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(type, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(type, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(type, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(type, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(type, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validatePatternViewpoint(PatternViewpoint patternViewpoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(patternViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(patternViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(patternViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(patternViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(patternViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(patternViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(patternViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(patternViewpoint, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAbstractPatternElement(
    AbstractPatternElement abstractPatternElement,
    DiagnosticChain diagnostics,
    Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(abstractPatternElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(abstractPatternElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(abstractPatternElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(abstractPatternElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(abstractPatternElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(abstractPatternElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(abstractPatternElement, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(abstractPatternElement, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validatePatternLibrary(PatternLibrary patternLibrary, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(patternLibrary, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(patternLibrary, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(patternLibrary, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(patternLibrary, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(patternLibrary, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(patternLibrary, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(patternLibrary, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(patternLibrary, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validatePatternModel(PatternModel patternModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(patternModel, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(patternModel, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(patternModel, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(patternModel, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(patternModel, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(patternModel, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(patternModel, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(patternModel, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateFactory(Factory factory, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(factory, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(factory, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(factory, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(factory, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(factory, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(factory, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(factory, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(factory, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAbstractFactoryComponentFactory(
    AbstractFactoryComponentFactory abstractFactoryComponentFactory,
    DiagnosticChain diagnostics,
    Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(abstractFactoryComponentFactory, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(abstractFactoryComponentFactory, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(abstractFactoryComponentFactory, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(abstractFactoryComponentFactory, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(abstractFactoryComponentFactory, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(abstractFactoryComponentFactory, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(abstractFactoryComponentFactory, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(abstractFactoryComponentFactory, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateProductionPlan(ProductionPlan productionPlan, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(productionPlan, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(productionPlan, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(productionPlan, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(productionPlan, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(productionPlan, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(productionPlan, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(productionPlan, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(productionPlan, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateFactoryComponentInvocation(FactoryComponentInvocation factoryComponentInvocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(factoryComponentInvocation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(factoryComponentInvocation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(factoryComponentInvocation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(factoryComponentInvocation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(factoryComponentInvocation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(factoryComponentInvocation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(factoryComponentInvocation, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(factoryComponentInvocation, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContext(Context context, DiagnosticChain diagnostics, Map<Object, Object> theContext) {
    boolean result = validate_EveryMultiplicityConforms(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validate_UniqueID(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(context, diagnostics, theContext);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContextElement(ContextElement contextElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(contextElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(contextElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(contextElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(contextElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(contextElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(contextElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(contextElement, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(contextElement, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateTaskFactoryHolder(TaskFactoryHolder taskFactoryHolder, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(taskFactoryHolder, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(taskFactoryHolder, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(taskFactoryHolder, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(taskFactoryHolder, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(taskFactoryHolder, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(taskFactoryHolder, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(taskFactoryHolder, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(taskFactoryHolder, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateMappingViewpoint(MappingViewpoint mappingViewpoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(mappingViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(mappingViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingViewpoint, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(mappingViewpoint, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateMappingModel(MappingModel mappingModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(mappingModel, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingModel, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingModel, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingModel, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(mappingModel, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingModel, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingModel, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedModelElementWithId_overall(mappingModel, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateViewpointType(ViewpointType viewpointType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    // TODO
    // Specialize this to return a resource locator for messages specific to this validator.
    // Ensure that you remove @generated or mark it @generated NOT
    return super.getResourceLocator();
  }

} // ModelValidator
