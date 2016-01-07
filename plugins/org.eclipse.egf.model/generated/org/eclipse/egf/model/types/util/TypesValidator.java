/**
 * 
O * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.model.EGFModelPlugin;
import org.eclipse.egf.model.helper.ValidationHelper;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.egf.model.types.TypeBigDecimal;
import org.eclipse.egf.model.types.TypeBigInteger;
import org.eclipse.egf.model.types.TypeBoolean;
import org.eclipse.egf.model.types.TypeByte;
import org.eclipse.egf.model.types.TypeCharacter;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypeCollection;
import org.eclipse.egf.model.types.TypeDate;
import org.eclipse.egf.model.types.TypeDouble;
import org.eclipse.egf.model.types.TypeElement;
import org.eclipse.egf.model.types.TypeFloat;
import org.eclipse.egf.model.types.TypeInteger;
import org.eclipse.egf.model.types.TypeList;
import org.eclipse.egf.model.types.TypeLong;
import org.eclipse.egf.model.types.TypeMap;
import org.eclipse.egf.model.types.TypeObject;
import org.eclipse.egf.model.types.TypeSet;
import org.eclipse.egf.model.types.TypeShort;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypeURI;
import org.eclipse.egf.model.types.TypesException;
import org.eclipse.egf.model.types.TypesPackage;
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
import org.eclipse.emf.validation.service.ITraversalStrategy.Recursive;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.types.TypesPackage
 * @generated
 */
public class TypesValidator extends EObjectValidator {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("hiding")
	public static final TypesValidator INSTANCE = new TypesValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	@SuppressWarnings("hiding")
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.egf.model.types"; //$NON-NLS-1$

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
	 * Model Validation Service interface for batch validation of EMF elements.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final IBatchValidator batchValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return TypesPackage.eINSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
			//    which it does for efficient computation and error reporting,
			//    then don't repeat (the Diagnostician does the recursion
			//    externally).  If there is no context map, then we can't
			//    help it
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
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
		case TypesPackage.TYPE_ELEMENT:
			return validateTypeElement((TypeElement) value, diagnostics, context);
		case TypesPackage.TYPE:
			return validateType((Type) value, diagnostics, context);
		case TypesPackage.TYPE_OBJECT:
			return validateTypeObject((TypeObject) value, diagnostics, context);
		case TypesPackage.TYPE_ABSTRACT_CLASS:
			return validateTypeAbstractClass((TypeAbstractClass) value, diagnostics, context);
		case TypesPackage.TYPE_CLASS:
			return validateTypeClass((TypeClass) value, diagnostics, context);
		case TypesPackage.TYPE_COLLECTION:
			return validateTypeCollection((TypeCollection) value, diagnostics, context);
		case TypesPackage.TYPE_LIST:
			return validateTypeList((TypeList) value, diagnostics, context);
		case TypesPackage.TYPE_SET:
			return validateTypeSet((TypeSet) value, diagnostics, context);
		case TypesPackage.TYPE_MAP:
			return validateTypeMap((TypeMap) value, diagnostics, context);
		case TypesPackage.TYPE_BIG_DECIMAL:
			return validateTypeBigDecimal((TypeBigDecimal) value, diagnostics, context);
		case TypesPackage.TYPE_BIG_INTEGER:
			return validateTypeBigInteger((TypeBigInteger) value, diagnostics, context);
		case TypesPackage.TYPE_BOOLEAN:
			return validateTypeBoolean((TypeBoolean) value, diagnostics, context);
		case TypesPackage.TYPE_BYTE:
			return validateTypeByte((TypeByte) value, diagnostics, context);
		case TypesPackage.TYPE_CHARACTER:
			return validateTypeCharacter((TypeCharacter) value, diagnostics, context);
		case TypesPackage.TYPE_DATE:
			return validateTypeDate((TypeDate) value, diagnostics, context);
		case TypesPackage.TYPE_DOUBLE:
			return validateTypeDouble((TypeDouble) value, diagnostics, context);
		case TypesPackage.TYPE_FLOAT:
			return validateTypeFloat((TypeFloat) value, diagnostics, context);
		case TypesPackage.TYPE_INTEGER:
			return validateTypeInteger((TypeInteger) value, diagnostics, context);
		case TypesPackage.TYPE_LONG:
			return validateTypeLong((TypeLong) value, diagnostics, context);
		case TypesPackage.TYPE_SHORT:
			return validateTypeShort((TypeShort) value, diagnostics, context);
		case TypesPackage.TYPE_STRING:
			return validateTypeString((TypeString) value, diagnostics, context);
		case TypesPackage.TYPE_URI:
			return validateTypeURI((TypeURI) value, diagnostics, context);
		case TypesPackage.SET:
			return validateSet((Set<?>) value, diagnostics, context);
		case TypesPackage.LIST:
			return validateList((List<?>) value, diagnostics, context);
		case TypesPackage.COLLECTION:
			return validateCollection((Collection<?>) value, diagnostics, context);
		case TypesPackage.URI:
			return validateURI((URI) value, diagnostics, context);
		case TypesPackage.TYPES_EXCEPTION:
			return validateTypesException((TypesException) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeElement(TypeElement typeElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(typeElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType(Type type, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(type, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeObject(TypeObject typeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeObject, diagnostics, context))
			return false;
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
			result &= validateTypeObject_ValidValue(typeObject, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ValidValue constraint of '<em>Type Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateTypeObject_ValidValue(TypeObject typeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (typeObject.getValue() == null || context == null || context.get(IEGFModelConstants.VALIDATE_TYPES) == Boolean.FALSE) {
			return true;
		}
		// Valid Value
		if (ValidationHelper.isValidClass(typeObject, typeObject.getType(), typeObject.getValue().getClass().getName(), context) == false) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
						new Object[] { "ValidValue", getObjectLabel(typeObject, context), NLS.bind("Type mismatch ''{0}'' with ''{1}''", typeObject.getType().getClass().getName(), typeObject.getValue().getClass().getName()) }, //$NON-NLS-1$ //$NON-NLS-2$
						new Object[] { typeObject }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeAbstractClass(TypeAbstractClass typeAbstractClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeAbstractClass, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeAbstractClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeAbstractClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeAbstractClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeAbstractClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeAbstractClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeAbstractClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeAbstractClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeAbstractClass_LoadableType(typeAbstractClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeAbstractClass_ValidValue(typeAbstractClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeAbstractClass_ValidInstance(typeAbstractClass, diagnostics, context);
		return result;
	}

	/**
	 * Validates the LoadableType constraint of '<em>Type Abstract Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateTypeAbstractClass_LoadableType(TypeAbstractClass typeAbstractClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (typeAbstractClass.getValue() == null) {
			return true;
		}
		// Loadable Value
		if (ValidationHelper.isLoadableClass(typeAbstractClass, typeAbstractClass.getValue(), context) == false) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
						new Object[] { "LoadableType", getObjectLabel(typeAbstractClass, context), NLS.bind("Unable to load Value ''{0}''", typeAbstractClass.getValue()) }, //$NON-NLS-1$ //$NON-NLS-2$
						new Object[] { typeAbstractClass }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the ValidValue constraint of '<em>Type Abstract Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateTypeAbstractClass_ValidValue(TypeAbstractClass typeAbstractClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (typeAbstractClass.getValue() == null || context == null || context.get(IEGFModelConstants.VALIDATE_TYPES) == Boolean.FALSE) {
			return true;
		}
		// Type and value are the same
		if (typeAbstractClass instanceof TypeClass) {
			return true;
		}
		// Valid Value
		if (ValidationHelper.isValidClass(typeAbstractClass, typeAbstractClass.getType(), typeAbstractClass.getValue(), context) == false) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
						new Object[] { "ValidValue", getObjectLabel(typeAbstractClass, context), NLS.bind("Type and Value mismatch ''{0}'' with ''{1}''", typeAbstractClass.getType().getName(), typeAbstractClass.getValue()) }, //$NON-NLS-1$ //$NON-NLS-2$
						new Object[] { typeAbstractClass }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the ValidInstance constraint of '<em>Type Abstract Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateTypeAbstractClass_ValidInstance(TypeAbstractClass typeAbstractClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (typeAbstractClass.getInstance() == null || typeAbstractClass.getValue() == null) {
			return true;
		}
		// Valid Instance
		if (ClassHelper.isSubClass(typeAbstractClass.getInstance().getClass(), typeAbstractClass.getType()) == false) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
						new Object[] { "ValidInstance", getObjectLabel(typeAbstractClass, context), NLS.bind("Type and Instance mismatch ''{0}'' with ''{1}''", typeAbstractClass.getType().getName(), typeAbstractClass.getInstance().getClass().getName()) }, //$NON-NLS-1$ //$NON-NLS-2$
						new Object[] { typeAbstractClass }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeCollection(TypeCollection typeCollection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeCollection, diagnostics, context))
			return false;
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
			result &= validateTypeAbstractClass_LoadableType(typeCollection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeAbstractClass_ValidValue(typeCollection, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeAbstractClass_ValidInstance(typeCollection, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeList(TypeList typeList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeList, diagnostics, context))
			return false;
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
			result &= validateTypeAbstractClass_LoadableType(typeList, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeAbstractClass_ValidValue(typeList, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeAbstractClass_ValidInstance(typeList, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeSet(TypeSet typeSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeSet, diagnostics, context))
			return false;
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
			result &= validateTypeAbstractClass_LoadableType(typeSet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeAbstractClass_ValidValue(typeSet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeAbstractClass_ValidInstance(typeSet, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeClass(TypeClass typeClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeClass, diagnostics, context))
			return false;
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
			result &= validateTypeAbstractClass_LoadableType(typeClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeAbstractClass_ValidValue(typeClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeAbstractClass_ValidInstance(typeClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeClass_MandatoryValue(typeClass, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MandatoryValue constraint of '<em>Type Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateTypeClass_MandatoryValue(TypeClass typeClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (typeClass.getValue() == null || typeClass.getValue().trim().length() == 0) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
						new Object[] { "MandatoryValue", getObjectLabel(typeClass, context), "The attribute value is mandatory" }, //$NON-NLS-1$ //$NON-NLS-2$
						new Object[] { typeClass }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeMap(TypeMap typeMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeMap, diagnostics, context))
			return false;
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
			result &= validateTypeAbstractClass_LoadableType(typeMap, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeAbstractClass_ValidValue(typeMap, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeAbstractClass_ValidInstance(typeMap, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeBigDecimal(TypeBigDecimal typeBigDecimal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeBigDecimal, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeBigDecimal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeBigDecimal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeBigDecimal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeBigDecimal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeBigDecimal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeBigDecimal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeBigDecimal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeObject_ValidValue(typeBigDecimal, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeBigInteger(TypeBigInteger typeBigInteger, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeBigInteger, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeBigInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeBigInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeBigInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeBigInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeBigInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeBigInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeBigInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeObject_ValidValue(typeBigInteger, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeBoolean(TypeBoolean typeBoolean, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeBoolean, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeObject_ValidValue(typeBoolean, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeByte(TypeByte typeByte, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeByte, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeByte, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeByte, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeByte, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeByte, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeByte, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeByte, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeByte, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeObject_ValidValue(typeByte, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeCharacter(TypeCharacter typeCharacter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeCharacter, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeCharacter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeCharacter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeCharacter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeCharacter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeCharacter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeCharacter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeCharacter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeObject_ValidValue(typeCharacter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeDate(TypeDate typeDate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeDate, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeDate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeDate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeDate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeDate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeDate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeDate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeDate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeObject_ValidValue(typeDate, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeDouble(TypeDouble typeDouble, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeDouble, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeDouble, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeDouble, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeDouble, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeDouble, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeDouble, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeDouble, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeDouble, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeObject_ValidValue(typeDouble, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeFloat(TypeFloat typeFloat, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeFloat, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeFloat, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeFloat, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeFloat, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeFloat, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeFloat, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeFloat, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeFloat, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeObject_ValidValue(typeFloat, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeInteger(TypeInteger typeInteger, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeInteger, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeObject_ValidValue(typeInteger, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeLong(TypeLong typeLong, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeLong, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeLong, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeLong, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeLong, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeLong, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeLong, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeLong, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeLong, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeObject_ValidValue(typeLong, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeShort(TypeShort typeShort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeShort, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeShort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeShort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeShort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeShort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeShort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeShort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeShort, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeObject_ValidValue(typeShort, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeString(TypeString typeString, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeString, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeObject_ValidValue(typeString, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeURI(TypeURI typeURI, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeURI, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeURI, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeURI, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeURI, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeURI, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeURI, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeURI, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeURI, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeObject_ValidValue(typeURI, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTypeURI_ValidURI(typeURI, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ValidURI constraint of '<em>Type URI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateTypeURI_ValidURI(TypeURI typeURI, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (typeURI.getValue() == null) {
			return true;
		}
		URI uri = typeURI.getValue();
		boolean valid = true;
		InputStream inputStream = null;
		// Try to open an InputStream
		try {
			inputStream = EGFPlatformPlugin.getPlatformURIConverter().createInputStream(uri);
		} catch (IOException exception) {
			valid = false;
		}
		// Safe close
		FileHelper.safeClose(inputStream);
		// Check
		if (valid == false) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
						new Object[] { "ValidURI", getObjectLabel(typeURI, context), NLS.bind("Unable to load URI ''{0}''", uri) }, //$NON-NLS-1$ //$NON-NLS-2$
						new Object[] { typeURI }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateURI(URI uri, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypesException(TypesException typesException, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollection(Collection<?> collection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateList(List<?> list, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSet(Set<?> set, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
		return EGFModelPlugin.INSTANCE;
	}

	/**
	 * If we have a context map, record this object's <code>status</code> in it
	 * so that we will know later that we have processed it and its sub-tree.
	 * 
	 * @param eObject an element that we have validated
	 * @param context the context (may be <code>null</code>)
	 * @param status the element's validation status
	 *            <!-- begin-user-doc -->
	 *            <!-- end-user-doc -->
	 * @generated
	 */
	private void processed(EObject eObject, Map<Object, Object> context, IStatus status) {
		if (context != null) {
			context.put(eObject, status);
		}
	}

	/**
	 * Determines whether we have processed this <code>eObject</code> before,
	 * by automatic recursion of the EMF Model Validation Service.  This is
	 * only possible if we do, indeed, have a context.
	 * 
	 * @param eObject an element to be validated (we hope not)
	 * @param context the context (may be <code>null</code>)
	 * @return <code>true</code> if the context is not <code>null</code> and
	 *     the <code>eObject</code> or one of its containers has already been
	 *     validated;  <code>false</code>, otherwise
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
	 * @param status the EMF validation service's status result
	 * @param diagnostics a diagnostic chain to accumulate results on
	 *            <!-- begin-user-doc -->
	 *            <!-- end-user-doc -->
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
