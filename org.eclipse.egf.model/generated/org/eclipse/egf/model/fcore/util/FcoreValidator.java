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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.EGFModelsPlugin;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Context;
import org.eclipse.egf.model.fcore.ContextContainer;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractConnector;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.Type;
import org.eclipse.egf.model.fcore.TypeClass;
import org.eclipse.egf.model.fcore.TypeObject;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
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
    case FcorePackage.FACTORY_COMPONENT:
      return validateFactoryComponent((FactoryComponent) value, diagnostics, context);
    case FcorePackage.VIEWPOINT_CONTAINER:
      return validateViewpointContainer((ViewpointContainer) value, diagnostics, context);
    case FcorePackage.VIEWPOINT:
      return validateViewpoint((Viewpoint) value, diagnostics, context);
    case FcorePackage.ORCHESTRATION:
      return validateOrchestration((Orchestration) value, diagnostics, context);
    case FcorePackage.INVOCATION:
      return validateInvocation((Invocation) value, diagnostics, context);
    case FcorePackage.TYPE:
      return validateType((Type<?>) value, diagnostics, context);
    case FcorePackage.TYPE_OBJECT:
      return validateTypeObject((TypeObject<?>) value, diagnostics, context);
    case FcorePackage.TYPE_CLASS:
      return validateTypeClass((TypeClass<?>) value, diagnostics, context);
    case FcorePackage.CONTRACT_CONTAINER:
      return validateContractContainer((ContractContainer) value, diagnostics, context);
    case FcorePackage.CONTRACT:
      return validateContract((Contract) value, diagnostics, context);
    case FcorePackage.CONTRACT_CONNECTOR:
      return validateContractConnector((ContractConnector) value, diagnostics, context);
    case FcorePackage.CONTEXT_CONTAINER:
      return validateContextContainer((ContextContainer) value, diagnostics, context);
    case FcorePackage.CONTEXT:
      return validateContext((Context) value, diagnostics, context);
    case FcorePackage.CONTRACT_MODE:
      return validateContractMode((ContractMode) value, diagnostics, context);
    case FcorePackage.IPRODUCTION_CONTEXT:
      return validateIProductionContext((IProductionContext) value, diagnostics, context);
    case FcorePackage.INVOCATION_EXCEPTION:
      return validateInvocationException((InvocationException) value, diagnostics, context);
    case FcorePackage.IPROGRESS_MONITOR:
      return validateIProgressMonitor((IProgressMonitor) value, diagnostics, context);
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
  public boolean validateFactoryComponent(FactoryComponent factoryComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(factoryComponent, diagnostics, context);
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
  public boolean validateInvocation(Invocation invocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(invocation, diagnostics, context);
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
    return validate_EveryDefaultConstraint(typeObject, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateTypeClass(TypeClass<?> typeClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(typeClass, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateContextContainer(ContextContainer contextContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(contextContainer, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateContext(Context context, DiagnosticChain diagnostics, Map<Object, Object> theContext) {
    return validate_EveryDefaultConstraint(context, diagnostics, theContext);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateContractContainer(ContractContainer contractContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(contractContainer, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateContract(Contract contract, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryDefaultConstraint(contract, diagnostics, context);
    if (result || diagnostics != null) {
      // Contract 'name' is mandatory in this context
      EAttribute name = FcorePackage.Literals.MODEL_ELEMENT__NAME;
      if (contract.getName() == null || contract.getName().trim().length() == 0) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, EOBJECT__EVERY_MULTIPCITY_CONFORMS, "_UI_RequiredFeatureMustBeSet_diagnostic", //$NON-NLS-1$
            new Object[] { getFeatureLabel(name, context), getObjectLabel(contract, context) }, new Object[] { contract, name }, context));
      }
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateContractConnector(ContractConnector contractConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(contractConnector, diagnostics, context);
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
  public boolean validateIProductionContext(IProductionContext iProductionContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateInvocationException(InvocationException invocationException, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateIProgressMonitor(IProgressMonitor iProgressMonitor, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
