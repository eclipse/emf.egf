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
package org.eclipse.egf.pattern.util;

import java.beans.PropertyChangeListener;
import java.util.Map;

import org.eclipse.egf.pattern.*;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreValidator;

import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.pattern.Generator;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.PatternPackage;
import org.eclipse.egf.pattern.validation.PatternDelegatedValidator;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see org.eclipse.egf.pattern.PatternPackage
 * @generated
 */
public class PatternValidator extends EObjectValidator {
  /**
   * The cached model package
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static final PatternValidator INSTANCE = new PatternValidator();

  /**
   * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.emf.common.util.Diagnostic#getSource()
   * @see org.eclipse.emf.common.util.Diagnostic#getCode()
   * @generated
   */
  public static final String DIAGNOSTIC_SOURCE = "org.eclipse.egf.pattern"; //$NON-NLS-1$

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

  /**
   * The cached base package validator.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected EcoreValidator ecoreValidator;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PatternValidator() {
    super();
    ecoreValidator = EcoreValidator.INSTANCE;
  }

  /**
   * Returns the package of this validator switch.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EPackage getEPackage() {
    return PatternPackage.eINSTANCE;
  }

  /**
   * Calls <code>validateXXX</code> for the corresponding classifier of the model.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
    switch (classifierID) {
      case PatternPackage.GENERATOR:
        return validateGenerator((Generator)value, diagnostics, context);
      case PatternPackage.PATTERN:
        return validatePattern((Pattern)value, diagnostics, context);
      case PatternPackage.PPROPERTY_CHANGE_LISTENER:
        return validatePPropertyChangeListener((PropertyChangeListener)value, diagnostics, context);
      default:
        return true;
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateGenerator(Generator generator, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(generator, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validatePattern(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_WellFormedInstanceTypeName(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_UniqueTypeParameterNames(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= ecoreValidator.validateEClass_InterfaceIsAbstract(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= ecoreValidator.validateEClass_AtMostOneID(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueFeatureNames(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueOperationSignatures(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= ecoreValidator.validateEClass_NoCircularSuperTypes(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= ecoreValidator.validateEClass_WellFormedMapEntryClass(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= ecoreValidator.validateEClass_ConsistentSuperTypes(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= ecoreValidator.validateEClass_DisjointFeatureAndOperationSignatures(pattern, diagnostics, context);
    if (result || diagnostics != null) result &= validatePattern_overall(pattern, diagnostics, context);
    return result;
  }

  /**
   * Validates the overall constraint of '<em>Pattern</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean validatePattern_overall(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
    PatternDelegatedValidator validator = new PatternDelegatedValidator(pattern);
    String patternName = pattern.getName();
    // Check collision with parent name.
    if (validator.parentNameCollision()) {
      if (diagnostics != null) {
        diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, StringHelper.formatMessage(
            Messages.PatternValidator_NameCollisionWithParentOne, new Object[] { patternName }), new Object[] { pattern }));
      }
      return false;
    }
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validatePPropertyChangeListener(PropertyChangeListener pPropertyChangeListener, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
} // PatternValidator
