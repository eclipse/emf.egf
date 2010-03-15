/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.ftask.util;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.EGFFtaskPlugin;
import org.eclipse.egf.model.fcore.util.FcoreValidator;
import org.eclipse.egf.model.ftask.FtaskPackage;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.ftask.TaskJava;
import org.eclipse.egf.model.helper.ValidationHelper;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.emf.validation.service.ITraversalStrategy.Recursive;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.egf.model.ftask.FtaskPackage
 * @generated
 */
public class FtaskValidator extends EObjectValidator {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("hiding")
  public static final FtaskValidator INSTANCE = new FtaskValidator();

  /**
   * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.common.util.Diagnostic#getSource()
   * @see org.eclipse.emf.common.util.Diagnostic#getCode()
   * @generated
   */
  @SuppressWarnings("hiding")
  public static final String DIAGNOSTIC_SOURCE = "org.eclipse.egf.model.ftask"; //$NON-NLS-1$

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
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
   * The cached base package validator.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected FcoreValidator fcoreValidator;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public FtaskValidator() {
    super();
    fcoreValidator = FcoreValidator.INSTANCE;
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
    return FtaskPackage.eINSTANCE;
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
    case FtaskPackage.TASK:
      return validateTask((Task) value, diagnostics, context);
    case FtaskPackage.TASK_JAVA:
      return validateTaskJava((TaskJava) value, diagnostics, context);
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
  public boolean validateTask(Task task, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= fcoreValidator.validateActivity_MandatoryName(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= fcoreValidator.validateActivity_ActivityCycle(task, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateTaskJava(TaskJava taskJava, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(taskJava, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(taskJava, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(taskJava, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(taskJava, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(taskJava, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(taskJava, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(taskJava, diagnostics, context);
    if (result || diagnostics != null)
      result &= fcoreValidator.validateActivity_MandatoryName(taskJava, diagnostics, context);
    if (result || diagnostics != null)
      result &= fcoreValidator.validateActivity_ActivityCycle(taskJava, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTaskJava_LoadableValue(taskJava, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTaskJava_ValidValue(taskJava, diagnostics, context);
    return result;
  }

  /**
   * Validates the LoadableValue constraint of '<em>TaskJava</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateTaskJava_LoadableValue(TaskJava taskJava, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (taskJava.getValue() == null) {
      return true;
    }
    // Loadable Value
    if (ValidationHelper.isLoadableClass(taskJava, taskJava.getValue(), context) == false) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "LoadableValue", getObjectLabel(taskJava, context), NLS.bind("Unable to load ''{0}''", taskJava.getValue()) }, //$NON-NLS-1$ //$NON-NLS-2$
            new Object[] { taskJava }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Validates the ValidValue constraint of '<em>TaskJava</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateTaskJava_ValidValue(TaskJava taskJava, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (taskJava.getValue() == null) {
      return true;
    }
    // Valid Value
    if (ValidationHelper.isValidClass(taskJava, ITaskProduction.class, taskJava.getValue(), context) == false) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "ValidValue", getObjectLabel(taskJava, context), NLS.bind("Type mismatch ''{0}'' with ''{1}''", ITaskProduction.class.getName(), taskJava.getValue()) }, //$NON-NLS-1$ //$NON-NLS-2$
            new Object[] { taskJava }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return EGFFtaskPlugin.INSTANCE;
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
} // FtaskValidator
