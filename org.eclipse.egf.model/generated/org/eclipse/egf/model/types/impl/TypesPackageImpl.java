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
package org.eclipse.egf.model.types.impl;

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.types.BooleanType;
import org.eclipse.egf.model.types.GeneratorAdapterFactoryType;
import org.eclipse.egf.model.types.IntegerType;
import org.eclipse.egf.model.types.StringType;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesPackageImpl extends EPackageImpl implements TypesPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass generatorAdapterFactoryTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType eGeneratorAdapterFactoryEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.egf.model.types.TypesPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TypesPackageImpl() {
    super(eNS_URI, TypesFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link TypesPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TypesPackage init() {
    if (isInited)
      return (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

    // Obtain or create and register package
    TypesPackageImpl theTypesPackage = (TypesPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TypesPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    FcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theTypesPackage.createPackageContents();

    // Initialize created meta-data
    theTypesPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTypesPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, theTypesPackage);
    return theTypesPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanType() {
    return booleanTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBooleanType_Value() {
    return (EAttribute) booleanTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringType() {
    return stringTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringType_Value() {
    return (EAttribute) stringTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntegerType() {
    return integerTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIntegerType_Value() {
    return (EAttribute) integerTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGeneratorAdapterFactoryType() {
    return generatorAdapterFactoryTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getEGeneratorAdapterFactory() {
    return eGeneratorAdapterFactoryEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypesFactory getTypesFactory() {
    return (TypesFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated)
      return;
    isCreated = true;

    // Create classes and their features
    booleanTypeEClass = createEClass(BOOLEAN_TYPE);
    createEAttribute(booleanTypeEClass, BOOLEAN_TYPE__VALUE);

    integerTypeEClass = createEClass(INTEGER_TYPE);
    createEAttribute(integerTypeEClass, INTEGER_TYPE__VALUE);

    stringTypeEClass = createEClass(STRING_TYPE);
    createEAttribute(stringTypeEClass, STRING_TYPE__VALUE);

    generatorAdapterFactoryTypeEClass = createEClass(GENERATOR_ADAPTER_FACTORY_TYPE);

    // Create data types
    eGeneratorAdapterFactoryEDataType = createEDataType(EGENERATOR_ADAPTER_FACTORY);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized)
      return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    FcorePackage theFcorePackage = (FcorePackage) EPackage.Registry.INSTANCE.getEPackage(FcorePackage.eNS_URI);
    EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    EGenericType g1 = createEGenericType(theFcorePackage.getTypeObject());
    EGenericType g2 = createEGenericType(ecorePackage.getEBooleanObject());
    g1.getETypeArguments().add(g2);
    booleanTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(theFcorePackage.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEIntegerObject());
    g1.getETypeArguments().add(g2);
    integerTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(theFcorePackage.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEString());
    g1.getETypeArguments().add(g2);
    stringTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(theFcorePackage.getTypeClass());
    g2 = createEGenericType(this.getEGeneratorAdapterFactory());
    g1.getETypeArguments().add(g2);
    generatorAdapterFactoryTypeEClass.getEGenericSuperTypes().add(g1);

    // Initialize classes and features; add operations and parameters
    initEClass(booleanTypeEClass, BooleanType.class, "BooleanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getBooleanType_Value(), theEcorePackage.getEBooleanObject(), "value", null, 0, 1, BooleanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    EOperation op = addEOperation(booleanTypeEClass, null, "getType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEBooleanObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(integerTypeEClass, IntegerType.class, "IntegerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getIntegerType_Value(), theEcorePackage.getEIntegerObject(), "value", null, 0, 1, IntegerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(integerTypeEClass, null, "getType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEIntegerObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(stringTypeEClass, StringType.class, "StringType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getStringType_Value(), theEcorePackage.getEString(), "value", null, 0, 1, StringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(stringTypeEClass, null, "getType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEString());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(generatorAdapterFactoryTypeEClass, GeneratorAdapterFactoryType.class, "GeneratorAdapterFactoryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    op = addEOperation(generatorAdapterFactoryTypeEClass, null, "getType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(this.getEGeneratorAdapterFactory());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    // Initialize data types
    initEDataType(eGeneratorAdapterFactoryEDataType, GeneratorAdapterFactory.class, "EGeneratorAdapterFactory", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    // Create resource
    createResource(eNS_URI);
  }

} // TypesPackageImpl
