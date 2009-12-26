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
package org.eclipse.egf.model.fcore.util;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.model.EGFModelsPlugin;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ActivityContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FactoryComponentContractContainer;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.InvocationContextConnector;
import org.eclipse.egf.model.fcore.InvocationContextContainer;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationContext;
import org.eclipse.egf.model.fcore.OrchestrationContextContainer;
import org.eclipse.egf.model.fcore.Type;
import org.eclipse.egf.model.fcore.TypeClass;
import org.eclipse.egf.model.fcore.TypeObject;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.egf.model.helper.ValidationHelper;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.emf.validation.service.ITraversalStrategy.Recursive;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.egf.model.fcore.FcorePackage
 * @generated
 */
public class FcoreValidator extends EObjectValidator {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public static final FcoreValidator INSTANCE = new FcoreValidator();

  /**
   * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of
   * diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.common.util.Diagnostic#getSource()
   * @see org.eclipse.emf.common.util.Diagnostic#getCode()
   * @generated
   */
  public static final String DIAGNOSTIC_SOURCE = "org.eclipse.egf.model.fcore"; //$NON-NLS-1$

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written
   * constants.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written
   * constants in a derived class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

  /**
   * Model Validation Service interface for batch validation of EMF elements.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  private final IBatchValidator batchValidator;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public FcoreValidator() {
    super();
    batchValidator = (IBatchValidator) ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
    batchValidator.setTraversalStrategy(new Recursive());
    batchValidator.setIncludeLiveConstraints(true);
    batchValidator.setReportSuccesses(false);
  }

  /**
   * Returns the package of this validator switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EPackage getEPackage() {
    return FcorePackage.eINSTANCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
    IStatus status = Status.OK_STATUS;
    // do whatever the basic EcoreValidator does
    super.validate(eClass, eObject, diagnostics, context);
    // no point in validating if we can't report results
    if (diagnostics != null) {
      // if EMF Mode Validation Service already covered the sub-tree,
      // which it does for efficient computation and error reporting,
      // then don't repeat (the Diagnostician does the recursion
      // externally). If there is no context map, then we can't
      // help it
      if (hasProcessed(eObject, context) == false) {
        status = batchValidator.validate(eObject, new NullProgressMonitor());
        processed(eObject, context, status);
        appendDiagnostics(status, diagnostics);
      }
    }
    return status.isOK();
  }

  /**
   * Calls <code>validateXXX</code> for the corresponding classifier of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
    switch (classifierID) {
    case FcorePackage.MODEL_ELEMENT:
      return validateModelElement((ModelElement) value, diagnostics, context);
    case FcorePackage.ACTIVITY:
      return validateActivity((Activity) value, diagnostics, context);
    case FcorePackage.ACTIVITY_CONTRACT:
      return validateActivityContract((ActivityContract) value, diagnostics, context);
    case FcorePackage.ACTIVITY_CONTRACT_CONTAINER:
      return validateActivityContractContainer((ActivityContractContainer) value, diagnostics, context);
    case FcorePackage.FACTORY_COMPONENT:
      return validateFactoryComponent((FactoryComponent) value, diagnostics, context);
    case FcorePackage.FACTORY_COMPONENT_CONTRACT:
      return validateFactoryComponentContract((FactoryComponentContract) value, diagnostics, context);
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER:
      return validateFactoryComponentContractContainer((FactoryComponentContractContainer) value, diagnostics, context);
    case FcorePackage.VIEWPOINT_CONTAINER:
      return validateViewpointContainer((ViewpointContainer) value, diagnostics, context);
    case FcorePackage.VIEWPOINT:
      return validateViewpoint((Viewpoint) value, diagnostics, context);
    case FcorePackage.ORCHESTRATION:
      return validateOrchestration((Orchestration) value, diagnostics, context);
    case FcorePackage.ORCHESTRATION_CONTEXT:
      return validateOrchestrationContext((OrchestrationContext) value, diagnostics, context);
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER:
      return validateOrchestrationContextContainer((OrchestrationContextContainer) value, diagnostics, context);
    case FcorePackage.INVOCATION:
      return validateInvocation((Invocation<?>) value, diagnostics, context);
    case FcorePackage.INVOCATION_CONTEXT:
      return validateInvocationContext((InvocationContext) value, diagnostics, context);
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR:
      return validateInvocationContextConnector((InvocationContextConnector) value, diagnostics, context);
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER:
      return validateInvocationContextContainer((InvocationContextContainer) value, diagnostics, context);
    case FcorePackage.TYPE:
      return validateType((Type<?>) value, diagnostics, context);
    case FcorePackage.TYPE_OBJECT:
      return validateTypeObject((TypeObject<?>) value, diagnostics, context);
    case FcorePackage.TYPE_CLASS:
      return validateTypeClass((TypeClass<?>) value, diagnostics, context);
    case FcorePackage.CONTRACT_MODE:
      return validateContractMode((ContractMode) value, diagnostics, context);
    case FcorePackage.URI:
      return validateURI((URI) value, diagnostics, context);
    default:
      return true;
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateModelElement(ModelElement modelElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(modelElement, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateActivity(Activity activity, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(activity, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateActivityContract(ActivityContract activityContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(activityContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(activityContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(activityContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(activityContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(activityContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(activityContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(activityContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateActivityContract_MandatoryName(activityContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateActivityContract_UniqueName(activityContract, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateActivityContractContainer(ActivityContractContainer activityContractContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(activityContractContainer, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateFactoryComponent(FactoryComponent factoryComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(factoryComponent, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateFactoryComponentContract(FactoryComponentContract factoryComponentContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(factoryComponentContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(factoryComponentContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(factoryComponentContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(factoryComponentContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(factoryComponentContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(factoryComponentContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(factoryComponentContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateActivityContract_MandatoryName(factoryComponentContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateActivityContract_UniqueName(factoryComponentContract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateFactoryComponentContract_OutModeIsRestricted(factoryComponentContract, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateFactoryComponentContractContainer(FactoryComponentContractContainer factoryComponentContractContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(factoryComponentContractContainer, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateViewpointContainer(ViewpointContainer viewpointContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(viewpointContainer, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateViewpoint(Viewpoint viewpoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(viewpoint, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateOrchestration(Orchestration orchestration, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(orchestration, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateOrchestrationContext(OrchestrationContext orchestrationContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(orchestrationContext, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateOrchestrationContextContainer(OrchestrationContextContainer orchestrationContextContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(orchestrationContextContainer, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateInvocation(Invocation<?> invocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(invocation, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateInvocationContext(InvocationContext invocationContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateInvocationContext_MandatoryName(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateInvocationContext_UniqueName(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateInvocationContext_ValidActivityContract(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateInvocationContext_ValidActivityContractType(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateInvocationContext_ValidContext(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateInvocationContext_ValidExposedContract(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateInvocationContext_ValidExposedContractType(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateInvocationContext_MandatoryTypeValue(invocationContext, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateInvocationContext_UselessType(invocationContext, diagnostics, context);
    return result;
  }

  /**
   * Validates the MandatoryName constraint of '<em>Invocation Context</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateInvocationContext_MandatoryName(InvocationContext invocationContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (invocationContext.getName() == null || invocationContext.getName().trim().length() == 0) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "InvocationContext Name is mandatory", getObjectLabel(invocationContext, context) }, //$NON-NLS-1$
            new Object[] { invocationContext }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the UniqueName constraint of '<em>Invocation Context</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateInvocationContext_UniqueName(InvocationContext invocationContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
    // Verify if name is unique in its invocation context container
    if (invocationContext.getName() == null || invocationContext.getInvocation() == null || invocationContext.getActivityContract() == null) {
      return true;
    }
    boolean collapse = false;
    for (InvocationContext innerInvocationContext : invocationContext.getInvocation().getInvocationContexts()) {
      if (innerInvocationContext == invocationContext || innerInvocationContext.getMode() == null) {
        continue;
      }
      // Ignore exclusive conditions
      if ((invocationContext.getMode() == ContractMode.IN && innerInvocationContext.getMode() == ContractMode.OUT) || (invocationContext.getMode() == ContractMode.OUT && innerInvocationContext.getMode() == ContractMode.IN)) {
        continue;
      }
      // Collapse
      if (invocationContext.getName().equals(innerInvocationContext.getName())) {
        collapse = true;
        break;
      }
    }
    if (collapse) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "InvocationContext Name should be unique in its Context Container.", getObjectLabel(invocationContext, context) }, //$NON-NLS-1$
            new Object[] { invocationContext }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the ValidActivityContract constraint of '<em>Invocation Context</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateInvocationContext_ValidActivityContract(InvocationContext invocationContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (invocationContext.getActivityContract() == null || invocationContext.getInvocation() == null || invocationContext.getInvocation().getActivity() == null) {
      return true;
    }
    // Activity contract analysis
    boolean found = false;
    for (ActivityContract activityContract : invocationContext.getInvocation().getActivity().getActivityContracts()) {
      if (activityContract == invocationContext.getActivityContract()) {
        found = true;
        break;
      }
    }
    if (found == false) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "ValidActivityContract", getObjectLabel(invocationContext, context) }, //$NON-NLS-1$
            new Object[] { invocationContext }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the ValidActivityContractType constraint of '<em>Invocation Context</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateInvocationContext_ValidActivityContractType(InvocationContext invocationContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (invocationContext.getActivityContract() == null || invocationContext.getActivityContract().getType() == null || invocationContext.getType() == null) {
      return true;
    }
    if (ClassHelper.asSubClass(invocationContext.getActivityContract().getType().getType(), invocationContext.getType().getType()) == false) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "InvocationContext Type and ActivityContract Type mismatch.", getObjectLabel(invocationContext, context) }, //$NON-NLS-1$
            new Object[] { invocationContext }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the ValidContext constraint of '<em>Invocation Context</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateInvocationContext_ValidContext(InvocationContext invocationContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean mistmatch = false;
    if (invocationContext.getOrchestrationContext() != null && invocationContext.getFactoryComponentExposedContract() != null) {
      if (invocationContext.getMode() == ContractMode.OUT) {
        // Only In or In_Out could be bound in an OrchestrationContext and in an exposed contract
        mistmatch = true;
      } else if (invocationContext.getFactoryComponentExposedContract().getMode() != ContractMode.OUT) {
        // if both assigned only exposed contract in out mode makes sense
        // with In mode in an orchestration context and an Out mode in an exposed contract
        mistmatch = true;
      }
    }
    if (mistmatch) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "InvocationContext should exist in OrchestrationContext or FactoryComponentExposedContract but not both.", getObjectLabel(invocationContext, context) }, //$NON-NLS-1$
            new Object[] { invocationContext }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateInvocationContextConnector(InvocationContextConnector invocationContextConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(invocationContextConnector, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateInvocationContextContainer(InvocationContextContainer invocationContextContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(invocationContextContainer, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateType(Type<?> type, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(type, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateTypeObject(TypeObject<?> typeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(typeObject, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(typeObject, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(typeObject, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(typeObject, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(typeObject, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(typeObject, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(typeObject, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_LoadableValue(typeObject, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_ValidValue(typeObject, diagnostics, context);
    return result;
  }

  /**
   * Validates the LoadableValue constraint of '<em>Type Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateTypeObject_LoadableValue(TypeObject<?> typeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (typeObject.getValue() == null) {
      return true;
    }
    // Loadable Value
    if (ValidationHelper.isLoadableClass(typeObject, typeObject.getValue().getClass().getName(), context) == false) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "Unable to load Value.", getObjectLabel(typeObject, context) }, //$NON-NLS-1$
            new Object[] { typeObject }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the ValidValue constraint of '<em>Type Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateTypeObject_ValidValue(TypeObject<?> typeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (typeObject.getValue() == null) {
      return true;
    }
    // Valid Value
    if (ValidationHelper.isValidClass(typeObject, typeObject.getType(), typeObject.getValue().getClass().getName(), context) == false) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "Value Type mismatch.", getObjectLabel(typeObject, context) }, //$NON-NLS-1$
            new Object[] { typeObject }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateTypeClass(TypeClass<?> typeClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(typeClass, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(typeClass, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(typeClass, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(typeClass, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(typeClass, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(typeClass, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(typeClass, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeClass_LoadableValue(typeClass, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeClass_ValidValue(typeClass, diagnostics, context);
    return result;
  }

  /**
   * Validates the LoadableValue constraint of '<em>Type Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateTypeClass_LoadableValue(TypeClass<?> typeClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
    // Loadable Value
    if (ValidationHelper.isLoadableClass(typeClass, typeClass.getValue(), context) == false) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "Unable to load Value.", getObjectLabel(typeClass, context) }, //$NON-NLS-1$
            new Object[] { typeClass }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the ValidValue constraint of '<em>Type Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateTypeClass_ValidValue(TypeClass<?> typeClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
    // Valid Value
    if (ValidationHelper.isValidClass(typeClass, typeClass.getType(), typeClass.getValue(), context) == false) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "Value Type mismatch.", getObjectLabel(typeClass, context) }, //$NON-NLS-1$
            new Object[] { typeClass }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the ValidExposedContract constraint of '<em>Invocation Context</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateInvocationContext_ValidExposedContract(InvocationContext invocationContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (invocationContext.getFactoryComponentExposedContract() == null || invocationContext.getActivityContract() == null) {
      return true;
    }
    boolean mistmatch = false;
    if (invocationContext.getFactoryComponentExposedContract().getMode() == ContractMode.IN && invocationContext.getActivityContract().getMode() == ContractMode.OUT) {
      mistmatch = true;
    } else if (invocationContext.getFactoryComponentExposedContract().getMode() == ContractMode.OUT && invocationContext.getActivityContract().getMode() == ContractMode.IN) {
      mistmatch = true;
    }
    if (mistmatch) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "FactoryComponentExposedContract and ActivityContract Mode mismatch.", getObjectLabel(invocationContext, context) }, //$NON-NLS-1$
            new Object[] { invocationContext }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the ValidExposedContractType constraint of '<em>Invocation Context</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateInvocationContext_ValidExposedContractType(InvocationContext invocationContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (invocationContext.getFactoryComponentExposedContract() == null || invocationContext.getFactoryComponentExposedContract().getType() == null || invocationContext.getActivityContract() == null || invocationContext.getActivityContract().getType() == null) {
      return true;
    }
    if (ClassHelper.asSubClass(invocationContext.getFactoryComponentExposedContract().getType().getType(), invocationContext.getActivityContract().getType().getType()) == false) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "ExposedContract Type is not a subtype of ActivityContract Type.", getObjectLabel(invocationContext, context) }, //$NON-NLS-1$
            new Object[] { invocationContext }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the MandatoryTypeValue constraint of '<em>Invocation Context</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateInvocationContext_MandatoryTypeValue(InvocationContext invocationContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (invocationContext.getOrchestrationContext() != null || invocationContext.getFactoryComponentExposedContract() != null) {
      return true;
    }
    if (invocationContext.getType() == null || invocationContext.getType().getValue() == null) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "Useless InvocationContext, a Type and a Value are needed to be useful.", getObjectLabel(invocationContext, context) }, //$NON-NLS-1$
            new Object[] { invocationContext }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the UselessType constraint of '<em>Invocation Context</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateInvocationContext_UselessType(InvocationContext invocationContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (invocationContext.getOrchestrationContext() == null && invocationContext.getFactoryComponentExposedContract() == null) {
      return true;
    }
    boolean valid = true;
    if (invocationContext.getMode() == ContractMode.IN_OUT) {
      // Default value for IN_OUT apply either assigned OrchestrationContext (for IN Mode)
      // and FactoryComponentExposedContract (for OUT Mode) but not both
      if (invocationContext.getOrchestrationContext() != null && invocationContext.getFactoryComponentExposedContract() != null && invocationContext.getType() != null) {
        valid = false;
      }
    } else if (invocationContext.getType() != null) {
      valid = false;
    }
    if (valid == false) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "Useless Type. InvocationContext is used in an OrchestrationContext or an ExposedContract.", getObjectLabel(invocationContext, context) }, //$NON-NLS-1$
            new Object[] { invocationContext }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the MandatoryName constraint of '<em>ActivityContract</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateActivityContract_MandatoryName(ActivityContract activityContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (activityContract.getName() == null || activityContract.getName().trim().length() == 0) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "ActivityContract Name is mandatory.", getObjectLabel(activityContract, context) }, //$NON-NLS-1$
            new Object[] { activityContract }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the UniqueName constraint of '<em>ActivityContract</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateActivityContract_UniqueName(ActivityContract activityContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (activityContract.getName() == null) {
      return true;
    }
    // Verify if name is unique in its contract container
    boolean collapse = false;
    for (ActivityContract innerActivityContract : activityContract.getActivityContracts()) {
      // Ignore ourself
      if (innerActivityContract == activityContract) {
        continue;
      }
      // Ignore exclusive conditions
      if ((activityContract.getMode() == ContractMode.IN && innerActivityContract.getMode() == ContractMode.OUT) || (activityContract.getMode() == ContractMode.OUT && innerActivityContract.getMode() == ContractMode.IN)) {
        continue;
      }
      // Collapse
      if (activityContract.getName().equals(innerActivityContract.getName())) {
        collapse = true;
        break;
      }
    }
    if (collapse) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "ActivityContract Name should be unique in its ActivityContractContainer.", getObjectLabel(activityContract, context) }, //$NON-NLS-1$
            new Object[] { activityContract }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the OutModeIsRestricted constraint of '<em>FactoryComponentContract</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateFactoryComponentContract_OutModeIsRestricted(FactoryComponentContract factoryComponentContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (factoryComponentContract.getMode() == ContractMode.IN || factoryComponentContract.getInvocationContexts() == null) {
      return true;
    }
    if (factoryComponentContract.getInvocationContexts().size() > 1) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "Out or In_Out Contract Mode should have only one assigned InvocationContext.", getObjectLabel(factoryComponentContract, context) }, //$NON-NLS-1$
            new Object[] { factoryComponentContract }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateContractMode(ContractMode contractMode, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateURI(URI uri, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * Returns the resource locator that will be used to fetch messages for this validator's
   * diagnostics.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return EGFModelsPlugin.INSTANCE;
  }

  /**
   * If we have a context map, record this object's <code>status</code> in it
   * so that we will know later that we have processed it and its sub-tree.
   * 
   * @param eObject
   *          an element that we have validated
   * @param context
   *          the context (may be <code>null</code>)
   * @param status
   *          the element's validation status
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  private void processed(EObject eObject, Map<Object, Object> context, IStatus status) {
    if (context != null) {
      context.put(eObject, status);
    }
  }

  /**
   * Determines whether we have processed this <code>eObject</code> before,
   * by automatic recursion of the EMF Model Validation Service. This is
   * only possible if we do, indeed, have a context.
   * 
   * @param eObject
   *          an element to be validated (we hope not)
   * @param context
   *          the context (may be <code>null</code>)
   * @return <code>true</code> if the context is not <code>null</code> and
   *         the <code>eObject</code> or one of its containers has already been
   *         validated; <code>false</code>, otherwise
   *         <!-- begin-user-doc -->
   *         <!-- end-user-doc -->
   * @generated
   */
  private boolean hasProcessed(EObject eObject, Map<Object, Object> context) {
    boolean result = false;
    if (context != null) {
      // this is O(NlogN) but there's no helping it
      while (eObject != null) {
        if (context.containsKey(eObject)) {
          result = true;
          eObject = null;
        } else {
          eObject = eObject.eContainer();
        }
      }
    }
    return result;
  }

  /**
   * Converts a status result from the EMF validation service to diagnostics.
   * 
   * @param status
   *          the EMF validation service's status result
   * @param diagnostics
   *          a diagnostic chain to accumulate results on
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  private void appendDiagnostics(IStatus status, DiagnosticChain diagnostics) {
    if (status.isMultiStatus()) {
      IStatus[] children = status.getChildren();
      for (int i = 0; i < children.length; i++) {
        appendDiagnostics(children[i], diagnostics);
      }
    } else if (status instanceof IConstraintStatus) {
      diagnostics.add(new BasicDiagnostic(status.getSeverity(), status.getPlugin(), status.getCode(), status.getMessage(), ((IConstraintStatus) status).getResultLocus().toArray()));
    }
  }
} // FcoreValidator
