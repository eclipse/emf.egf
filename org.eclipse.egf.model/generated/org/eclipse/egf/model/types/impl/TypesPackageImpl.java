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

import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.egf.model.fcore.FcorePackage;
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
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.egf.model.types.util.TypesValidator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
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
  private EClass typeObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeCollectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeMapEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bigDecimalTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bigIntegerTypeEClass = null;

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
  private EClass byteTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass characterTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dateTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass doubleTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass floatTypeEClass = null;

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
  private EClass longTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shortTypeEClass = null;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType collectionEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType listEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType setEDataType = null;

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

    // Register package validator
    EValidator.Registry.INSTANCE.put(theTypesPackage, new EValidator.Descriptor() {
      public EValidator getEValidator() {
        return TypesValidator.INSTANCE;
      }
    });

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
  public EClass getTypeObject() {
    return typeObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeClass() {
    return typeClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeClass_Value() {
    return (EAttribute) typeClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeCollection() {
    return typeCollectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeList() {
    return typeListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeSet() {
    return typeSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeMap() {
    return typeMapEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBigDecimalType() {
    return bigDecimalTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBigDecimalType_Value() {
    return (EAttribute) bigDecimalTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBigIntegerType() {
    return bigIntegerTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBigIntegerType_Value() {
    return (EAttribute) bigIntegerTypeEClass.getEStructuralFeatures().get(0);
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
  public EClass getByteType() {
    return byteTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getByteType_Value() {
    return (EAttribute) byteTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCharacterType() {
    return characterTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCharacterType_Value() {
    return (EAttribute) characterTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDateType() {
    return dateTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDateType_Value() {
    return (EAttribute) dateTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDoubleType() {
    return doubleTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDoubleType_Value() {
    return (EAttribute) doubleTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFloatType() {
    return floatTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFloatType_Value() {
    return (EAttribute) floatTypeEClass.getEStructuralFeatures().get(0);
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
  public EClass getLongType() {
    return longTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLongType_Value() {
    return (EAttribute) longTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShortType() {
    return shortTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShortType_Value() {
    return (EAttribute) shortTypeEClass.getEStructuralFeatures().get(0);
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
  public EDataType getCollection() {
    return collectionEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getList() {
    return listEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getSet() {
    return setEDataType;
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
    typeObjectEClass = createEClass(TYPE_OBJECT);

    typeClassEClass = createEClass(TYPE_CLASS);
    createEAttribute(typeClassEClass, TYPE_CLASS__VALUE);

    typeCollectionEClass = createEClass(TYPE_COLLECTION);

    typeListEClass = createEClass(TYPE_LIST);

    typeSetEClass = createEClass(TYPE_SET);

    typeMapEClass = createEClass(TYPE_MAP);

    bigDecimalTypeEClass = createEClass(BIG_DECIMAL_TYPE);
    createEAttribute(bigDecimalTypeEClass, BIG_DECIMAL_TYPE__VALUE);

    bigIntegerTypeEClass = createEClass(BIG_INTEGER_TYPE);
    createEAttribute(bigIntegerTypeEClass, BIG_INTEGER_TYPE__VALUE);

    booleanTypeEClass = createEClass(BOOLEAN_TYPE);
    createEAttribute(booleanTypeEClass, BOOLEAN_TYPE__VALUE);

    byteTypeEClass = createEClass(BYTE_TYPE);
    createEAttribute(byteTypeEClass, BYTE_TYPE__VALUE);

    characterTypeEClass = createEClass(CHARACTER_TYPE);
    createEAttribute(characterTypeEClass, CHARACTER_TYPE__VALUE);

    dateTypeEClass = createEClass(DATE_TYPE);
    createEAttribute(dateTypeEClass, DATE_TYPE__VALUE);

    doubleTypeEClass = createEClass(DOUBLE_TYPE);
    createEAttribute(doubleTypeEClass, DOUBLE_TYPE__VALUE);

    floatTypeEClass = createEClass(FLOAT_TYPE);
    createEAttribute(floatTypeEClass, FLOAT_TYPE__VALUE);

    integerTypeEClass = createEClass(INTEGER_TYPE);
    createEAttribute(integerTypeEClass, INTEGER_TYPE__VALUE);

    longTypeEClass = createEClass(LONG_TYPE);
    createEAttribute(longTypeEClass, LONG_TYPE__VALUE);

    shortTypeEClass = createEClass(SHORT_TYPE);
    createEAttribute(shortTypeEClass, SHORT_TYPE__VALUE);

    stringTypeEClass = createEClass(STRING_TYPE);
    createEAttribute(stringTypeEClass, STRING_TYPE__VALUE);

    generatorAdapterFactoryTypeEClass = createEClass(GENERATOR_ADAPTER_FACTORY_TYPE);

    // Create data types
    eGeneratorAdapterFactoryEDataType = createEDataType(EGENERATOR_ADAPTER_FACTORY);
    collectionEDataType = createEDataType(COLLECTION);
    listEDataType = createEDataType(LIST);
    setEDataType = createEDataType(SET);
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
    EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    FcorePackage theFcorePackage = (FcorePackage) EPackage.Registry.INSTANCE.getEPackage(FcorePackage.eNS_URI);

    // Create type parameters
    ETypeParameter typeObjectEClass_T = addETypeParameter(typeObjectEClass, "T"); //$NON-NLS-1$
    ETypeParameter typeClassEClass_T = addETypeParameter(typeClassEClass, "T"); //$NON-NLS-1$
    addETypeParameter(collectionEDataType, "E"); //$NON-NLS-1$
    addETypeParameter(listEDataType, "E"); //$NON-NLS-1$
    addETypeParameter(setEDataType, "E"); //$NON-NLS-1$

    // Set bounds for type parameters
    EGenericType g1 = createEGenericType(theEcorePackage.getEJavaObject());
    typeObjectEClass_T.getEBounds().add(g1);
    g1 = createEGenericType(theEcorePackage.getEJavaObject());
    typeClassEClass_T.getEBounds().add(g1);

    // Add supertypes to classes
    g1 = createEGenericType(theFcorePackage.getType());
    EGenericType g2 = createEGenericType(typeObjectEClass_T);
    g1.getETypeArguments().add(g2);
    typeObjectEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(theFcorePackage.getType());
    g2 = createEGenericType(typeClassEClass_T);
    g1.getETypeArguments().add(g2);
    typeClassEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeClass());
    g2 = createEGenericType(this.getCollection());
    g1.getETypeArguments().add(g2);
    typeCollectionEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeClass());
    g2 = createEGenericType(this.getList());
    g1.getETypeArguments().add(g2);
    typeListEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeClass());
    g2 = createEGenericType(this.getSet());
    g1.getETypeArguments().add(g2);
    typeSetEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeClass());
    g2 = createEGenericType(theEcorePackage.getEMap());
    g1.getETypeArguments().add(g2);
    typeMapEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEBigDecimal());
    g1.getETypeArguments().add(g2);
    bigDecimalTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEBigInteger());
    g1.getETypeArguments().add(g2);
    bigIntegerTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(ecorePackage.getEBooleanObject());
    g1.getETypeArguments().add(g2);
    booleanTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEByteObject());
    g1.getETypeArguments().add(g2);
    byteTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getECharacterObject());
    g1.getETypeArguments().add(g2);
    characterTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEDate());
    g1.getETypeArguments().add(g2);
    dateTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEDoubleObject());
    g1.getETypeArguments().add(g2);
    doubleTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEFloatObject());
    g1.getETypeArguments().add(g2);
    floatTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEIntegerObject());
    g1.getETypeArguments().add(g2);
    integerTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getELongObject());
    g1.getETypeArguments().add(g2);
    longTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEShortObject());
    g1.getETypeArguments().add(g2);
    shortTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEString());
    g1.getETypeArguments().add(g2);
    stringTypeEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeClass());
    g2 = createEGenericType(this.getEGeneratorAdapterFactory());
    g1.getETypeArguments().add(g2);
    generatorAdapterFactoryTypeEClass.getEGenericSuperTypes().add(g1);

    // Initialize classes and features; add operations and parameters
    initEClass(typeObjectEClass, TypeObject.class, "TypeObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(typeClassEClass, TypeClass.class, "TypeClass", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeClass_Value(), theEcorePackage.getEString(), "value", null, 0, 1, TypeClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(typeCollectionEClass, TypeCollection.class, "TypeCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    EOperation op = addEOperation(typeCollectionEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(this.getCollection());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeListEClass, TypeList.class, "TypeList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    op = addEOperation(typeListEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(this.getList());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeSetEClass, TypeSet.class, "TypeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    op = addEOperation(typeSetEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(this.getSet());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeMapEClass, TypeMap.class, "TypeMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    op = addEOperation(typeMapEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEMap());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(bigDecimalTypeEClass, BigDecimalType.class, "BigDecimalType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getBigDecimalType_Value(), theEcorePackage.getEBigDecimal(), "value", null, 0, 1, BigDecimalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(bigDecimalTypeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEBigDecimal());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(bigIntegerTypeEClass, BigIntegerType.class, "BigIntegerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getBigIntegerType_Value(), theEcorePackage.getEBigInteger(), "value", null, 0, 1, BigIntegerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(bigIntegerTypeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEBigInteger());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(booleanTypeEClass, BooleanType.class, "BooleanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getBooleanType_Value(), theEcorePackage.getEBooleanObject(), "value", null, 0, 1, BooleanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(booleanTypeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEBooleanObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(byteTypeEClass, ByteType.class, "ByteType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getByteType_Value(), theEcorePackage.getEByteObject(), "value", null, 0, 1, ByteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(byteTypeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEByteObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(characterTypeEClass, CharacterType.class, "CharacterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getCharacterType_Value(), theEcorePackage.getECharacterObject(), "value", null, 0, 1, CharacterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(characterTypeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getECharacterObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(dateTypeEClass, DateType.class, "DateType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getDateType_Value(), theEcorePackage.getEDate(), "value", null, 0, 1, DateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(dateTypeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEDate());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(doubleTypeEClass, DoubleType.class, "DoubleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getDoubleType_Value(), theEcorePackage.getEDoubleObject(), "value", null, 0, 1, DoubleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(doubleTypeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEDoubleObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(floatTypeEClass, FloatType.class, "FloatType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getFloatType_Value(), theEcorePackage.getEFloatObject(), "value", null, 0, 1, FloatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(floatTypeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEFloatObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(integerTypeEClass, IntegerType.class, "IntegerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getIntegerType_Value(), theEcorePackage.getEIntegerObject(), "value", null, 0, 1, IntegerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(integerTypeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEIntegerObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(longTypeEClass, LongType.class, "LongType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getLongType_Value(), theEcorePackage.getELongObject(), "value", null, 0, 1, LongType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(longTypeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getELongObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(shortTypeEClass, ShortType.class, "ShortType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getShortType_Value(), theEcorePackage.getEShortObject(), "value", null, 0, 1, ShortType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(shortTypeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEShortObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(stringTypeEClass, StringType.class, "StringType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getStringType_Value(), theEcorePackage.getEString(), "value", null, 0, 1, StringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(stringTypeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEString());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(generatorAdapterFactoryTypeEClass, GeneratorAdapterFactoryType.class, "GeneratorAdapterFactoryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    op = addEOperation(generatorAdapterFactoryTypeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(this.getEGeneratorAdapterFactory());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    // Initialize data types
    initEDataType(eGeneratorAdapterFactoryEDataType, GeneratorAdapterFactory.class, "EGeneratorAdapterFactory", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEDataType(collectionEDataType, Collection.class, "Collection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEDataType(listEDataType, List.class, "List", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEDataType(setEDataType, Set.class, "Set", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http://www.eclipse.org/emf/2002/Ecore
    createEcoreAnnotations();
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createEcoreAnnotations() {
    String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$		
    addAnnotation(typeObjectEClass, source, new String[] { "constraints", "LoadableValue ValidValue" //$NON-NLS-1$ //$NON-NLS-2$
    });
    addAnnotation(typeClassEClass, source, new String[] { "constraints", "LoadableValue ValidValue" //$NON-NLS-1$ //$NON-NLS-2$
    });
  }

} // TypesPackageImpl
