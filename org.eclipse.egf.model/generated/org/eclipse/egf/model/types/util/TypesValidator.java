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
package org.eclipse.egf.model.types.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.EGFModelsPlugin;
import org.eclipse.egf.model.helper.ValidationHelper;
import org.eclipse.egf.model.types.BigDecimalType;
import org.eclipse.egf.model.types.BigIntegerType;
import org.eclipse.egf.model.types.BooleanType;
import org.eclipse.egf.model.types.ByteType;
import org.eclipse.egf.model.types.CharacterType;
import org.eclipse.egf.model.types.DateType;
import org.eclipse.egf.model.types.DoubleType;
import org.eclipse.egf.model.types.FloatType;
import org.eclipse.egf.model.types.GeneratorAdapterFactoryType;
import org.eclipse.egf.model.types.IntegerType;
import org.eclipse.egf.model.types.LongType;
import org.eclipse.egf.model.types.ShortType;
import org.eclipse.egf.model.types.StringType;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypeCollection;
import org.eclipse.egf.model.types.TypeList;
import org.eclipse.egf.model.types.TypeMap;
import org.eclipse.egf.model.types.TypeObject;
import org.eclipse.egf.model.types.TypeSet;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
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

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.egf.model.types.TypesPackage
 * @generated
 */
public class TypesValidator extends EObjectValidator {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public static final TypesValidator INSTANCE = new TypesValidator();

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
  public static final String DIAGNOSTIC_SOURCE = "org.eclipse.egf.model.types"; //$NON-NLS-1$

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
  public TypesValidator() {
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
    return TypesPackage.eINSTANCE;
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
    case TypesPackage.TYPE_OBJECT:
      return validateTypeObject((TypeObject<?>) value, diagnostics, context);
    case TypesPackage.TYPE_CLASS:
      return validateTypeClass((TypeClass<?>) value, diagnostics, context);
    case TypesPackage.TYPE_COLLECTION:
      return validateTypeCollection((TypeCollection) value, diagnostics, context);
    case TypesPackage.TYPE_LIST:
      return validateTypeList((TypeList) value, diagnostics, context);
    case TypesPackage.TYPE_SET:
      return validateTypeSet((TypeSet) value, diagnostics, context);
    case TypesPackage.TYPE_MAP:
      return validateTypeMap((TypeMap) value, diagnostics, context);
    case TypesPackage.BIG_DECIMAL_TYPE:
      return validateBigDecimalType((BigDecimalType) value, diagnostics, context);
    case TypesPackage.BIG_INTEGER_TYPE:
      return validateBigIntegerType((BigIntegerType) value, diagnostics, context);
    case TypesPackage.BOOLEAN_TYPE:
      return validateBooleanType((BooleanType) value, diagnostics, context);
    case TypesPackage.BYTE_TYPE:
      return validateByteType((ByteType) value, diagnostics, context);
    case TypesPackage.CHARACTER_TYPE:
      return validateCharacterType((CharacterType) value, diagnostics, context);
    case TypesPackage.DATE_TYPE:
      return validateDateType((DateType) value, diagnostics, context);
    case TypesPackage.DOUBLE_TYPE:
      return validateDoubleType((DoubleType) value, diagnostics, context);
    case TypesPackage.FLOAT_TYPE:
      return validateFloatType((FloatType) value, diagnostics, context);
    case TypesPackage.INTEGER_TYPE:
      return validateIntegerType((IntegerType) value, diagnostics, context);
    case TypesPackage.LONG_TYPE:
      return validateLongType((LongType) value, diagnostics, context);
    case TypesPackage.SHORT_TYPE:
      return validateShortType((ShortType) value, diagnostics, context);
    case TypesPackage.STRING_TYPE:
      return validateStringType((StringType) value, diagnostics, context);
    case TypesPackage.GENERATOR_ADAPTER_FACTORY_TYPE:
      return validateGeneratorAdapterFactoryType((GeneratorAdapterFactoryType) value, diagnostics, context);
    case TypesPackage.EGENERATOR_ADAPTER_FACTORY:
      return validateEGeneratorAdapterFactory((GeneratorAdapterFactory) value, diagnostics, context);
    case TypesPackage.COLLECTION:
      return validateCollection((Collection<?>) value, diagnostics, context);
    case TypesPackage.LIST:
      return validateList((List<?>) value, diagnostics, context);
    case TypesPackage.SET:
      return validateSet((Set<?>) value, diagnostics, context);
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateTypeCollection(TypeCollection typeCollection, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(typeCollection, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(typeCollection, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(typeCollection, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(typeCollection, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(typeCollection, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(typeCollection, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(typeCollection, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeClass_LoadableValue(typeCollection, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeClass_ValidValue(typeCollection, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateTypeList(TypeList typeList, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(typeList, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(typeList, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(typeList, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(typeList, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(typeList, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(typeList, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(typeList, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeClass_LoadableValue(typeList, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeClass_ValidValue(typeList, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateTypeSet(TypeSet typeSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(typeSet, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(typeSet, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(typeSet, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(typeSet, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(typeSet, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(typeSet, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(typeSet, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeClass_LoadableValue(typeSet, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeClass_ValidValue(typeSet, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateTypeMap(TypeMap typeMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(typeMap, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(typeMap, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(typeMap, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(typeMap, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(typeMap, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(typeMap, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(typeMap, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeClass_LoadableValue(typeMap, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeClass_ValidValue(typeMap, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateBigDecimalType(BigDecimalType bigDecimalType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(bigDecimalType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(bigDecimalType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(bigDecimalType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(bigDecimalType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(bigDecimalType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(bigDecimalType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(bigDecimalType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_LoadableValue(bigDecimalType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_ValidValue(bigDecimalType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateBigIntegerType(BigIntegerType bigIntegerType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(bigIntegerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(bigIntegerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(bigIntegerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(bigIntegerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(bigIntegerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(bigIntegerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(bigIntegerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_LoadableValue(bigIntegerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_ValidValue(bigIntegerType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateBooleanType(BooleanType booleanType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(booleanType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(booleanType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(booleanType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(booleanType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(booleanType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(booleanType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(booleanType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_LoadableValue(booleanType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_ValidValue(booleanType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateByteType(ByteType byteType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(byteType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(byteType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(byteType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(byteType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(byteType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(byteType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(byteType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_LoadableValue(byteType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_ValidValue(byteType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateCharacterType(CharacterType characterType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(characterType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(characterType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(characterType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(characterType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(characterType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(characterType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(characterType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_LoadableValue(characterType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_ValidValue(characterType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateDateType(DateType dateType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(dateType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(dateType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(dateType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(dateType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(dateType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(dateType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(dateType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_LoadableValue(dateType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_ValidValue(dateType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateDoubleType(DoubleType doubleType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(doubleType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(doubleType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(doubleType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(doubleType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(doubleType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(doubleType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(doubleType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_LoadableValue(doubleType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_ValidValue(doubleType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateFloatType(FloatType floatType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(floatType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(floatType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(floatType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(floatType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(floatType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(floatType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(floatType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_LoadableValue(floatType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_ValidValue(floatType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateIntegerType(IntegerType integerType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(integerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(integerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(integerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(integerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(integerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(integerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(integerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_LoadableValue(integerType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_ValidValue(integerType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateLongType(LongType longType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(longType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(longType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(longType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(longType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(longType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(longType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(longType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_LoadableValue(longType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_ValidValue(longType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateShortType(ShortType shortType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(shortType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(shortType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(shortType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(shortType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(shortType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(shortType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(shortType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_LoadableValue(shortType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_ValidValue(shortType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateStringType(StringType stringType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(stringType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(stringType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(stringType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(stringType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(stringType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(stringType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(stringType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_LoadableValue(stringType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeObject_ValidValue(stringType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateGeneratorAdapterFactoryType(GeneratorAdapterFactoryType generatorAdapterFactoryType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(generatorAdapterFactoryType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(generatorAdapterFactoryType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(generatorAdapterFactoryType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(generatorAdapterFactoryType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(generatorAdapterFactoryType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(generatorAdapterFactoryType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(generatorAdapterFactoryType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeClass_LoadableValue(generatorAdapterFactoryType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateTypeClass_ValidValue(generatorAdapterFactoryType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEGeneratorAdapterFactory(GeneratorAdapterFactory eGeneratorAdapterFactory, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateCollection(Collection<?> collection, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateList(List<?> list, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateSet(Set<?> set, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
} // TypesValidator
