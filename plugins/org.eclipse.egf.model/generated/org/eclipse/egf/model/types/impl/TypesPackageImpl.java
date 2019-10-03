/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.types.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

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
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.egf.model.types.util.TypesValidator;
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
    private EClass typeElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeEClass = null;

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
    private EClass typeAbstractClassEClass = null;

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
    private EClass typeClassEClass = null;

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
    private EClass typeBigDecimalEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeBigIntegerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeBooleanEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeByteEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeCharacterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeDateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeDoubleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeFloatEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeIntegerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeLongEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeShortEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeStringEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeURIEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType uriEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType typesExceptionEDataType = null;

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
        EcorePackage.eINSTANCE.eClass();

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
    public EClass getTypeElement() {
        return typeElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeElement_ID() {
        return (EAttribute) typeElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeElement_Description() {
        return (EAttribute) typeElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getType() {
        return typeEClass;
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
    public EClass getTypeAbstractClass() {
        return typeAbstractClassEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeAbstractClass_Instance() {
        return (EAttribute) typeAbstractClassEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeAbstractClass_Value() {
        return (EAttribute) typeAbstractClassEClass.getEStructuralFeatures().get(1);
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
    public EClass getTypeClass() {
        return typeClassEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeClass_Type() {
        return (EAttribute) typeClassEClass.getEStructuralFeatures().get(0);
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
    public EClass getTypeBigDecimal() {
        return typeBigDecimalEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeBigDecimal_Value() {
        return (EAttribute) typeBigDecimalEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeBigInteger() {
        return typeBigIntegerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeBigInteger_Value() {
        return (EAttribute) typeBigIntegerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeBoolean() {
        return typeBooleanEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeBoolean_Value() {
        return (EAttribute) typeBooleanEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeByte() {
        return typeByteEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeByte_Value() {
        return (EAttribute) typeByteEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeCharacter() {
        return typeCharacterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeCharacter_Value() {
        return (EAttribute) typeCharacterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeDate() {
        return typeDateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeDate_Value() {
        return (EAttribute) typeDateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeDouble() {
        return typeDoubleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeDouble_Value() {
        return (EAttribute) typeDoubleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeFloat() {
        return typeFloatEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeFloat_Value() {
        return (EAttribute) typeFloatEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeInteger() {
        return typeIntegerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeInteger_Value() {
        return (EAttribute) typeIntegerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeLong() {
        return typeLongEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeLong_Value() {
        return (EAttribute) typeLongEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeShort() {
        return typeShortEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeShort_Value() {
        return (EAttribute) typeShortEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeString() {
        return typeStringEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeString_Value() {
        return (EAttribute) typeStringEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeURI() {
        return typeURIEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeURI_Value() {
        return (EAttribute) typeURIEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getURI() {
        return uriEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getTypesException() {
        return typesExceptionEDataType;
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
        typeElementEClass = createEClass(TYPE_ELEMENT);
        createEAttribute(typeElementEClass, TYPE_ELEMENT__ID);
        createEAttribute(typeElementEClass, TYPE_ELEMENT__DESCRIPTION);

        typeEClass = createEClass(TYPE);

        typeObjectEClass = createEClass(TYPE_OBJECT);

        typeAbstractClassEClass = createEClass(TYPE_ABSTRACT_CLASS);
        createEAttribute(typeAbstractClassEClass, TYPE_ABSTRACT_CLASS__INSTANCE);
        createEAttribute(typeAbstractClassEClass, TYPE_ABSTRACT_CLASS__VALUE);

        typeClassEClass = createEClass(TYPE_CLASS);
        createEAttribute(typeClassEClass, TYPE_CLASS__TYPE);

        typeCollectionEClass = createEClass(TYPE_COLLECTION);

        typeListEClass = createEClass(TYPE_LIST);

        typeSetEClass = createEClass(TYPE_SET);

        typeMapEClass = createEClass(TYPE_MAP);

        typeBigDecimalEClass = createEClass(TYPE_BIG_DECIMAL);
        createEAttribute(typeBigDecimalEClass, TYPE_BIG_DECIMAL__VALUE);

        typeBigIntegerEClass = createEClass(TYPE_BIG_INTEGER);
        createEAttribute(typeBigIntegerEClass, TYPE_BIG_INTEGER__VALUE);

        typeBooleanEClass = createEClass(TYPE_BOOLEAN);
        createEAttribute(typeBooleanEClass, TYPE_BOOLEAN__VALUE);

        typeByteEClass = createEClass(TYPE_BYTE);
        createEAttribute(typeByteEClass, TYPE_BYTE__VALUE);

        typeCharacterEClass = createEClass(TYPE_CHARACTER);
        createEAttribute(typeCharacterEClass, TYPE_CHARACTER__VALUE);

        typeDateEClass = createEClass(TYPE_DATE);
        createEAttribute(typeDateEClass, TYPE_DATE__VALUE);

        typeDoubleEClass = createEClass(TYPE_DOUBLE);
        createEAttribute(typeDoubleEClass, TYPE_DOUBLE__VALUE);

        typeFloatEClass = createEClass(TYPE_FLOAT);
        createEAttribute(typeFloatEClass, TYPE_FLOAT__VALUE);

        typeIntegerEClass = createEClass(TYPE_INTEGER);
        createEAttribute(typeIntegerEClass, TYPE_INTEGER__VALUE);

        typeLongEClass = createEClass(TYPE_LONG);
        createEAttribute(typeLongEClass, TYPE_LONG__VALUE);

        typeShortEClass = createEClass(TYPE_SHORT);
        createEAttribute(typeShortEClass, TYPE_SHORT__VALUE);

        typeStringEClass = createEClass(TYPE_STRING);
        createEAttribute(typeStringEClass, TYPE_STRING__VALUE);

        typeURIEClass = createEClass(TYPE_URI);
        createEAttribute(typeURIEClass, TYPE_URI__VALUE);

        // Create data types
        setEDataType = createEDataType(SET);
        listEDataType = createEDataType(LIST);
        collectionEDataType = createEDataType(COLLECTION);
        uriEDataType = createEDataType(URI);
        typesExceptionEDataType = createEDataType(TYPES_EXCEPTION);
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

        // Create type parameters
        addETypeParameter(setEDataType, "E"); //$NON-NLS-1$
        addETypeParameter(listEDataType, "E"); //$NON-NLS-1$
        addETypeParameter(collectionEDataType, "E"); //$NON-NLS-1$

        // Set bounds for type parameters

        // Add supertypes to classes
        typeEClass.getESuperTypes().add(this.getTypeElement());
        typeObjectEClass.getESuperTypes().add(this.getType());
        typeAbstractClassEClass.getESuperTypes().add(this.getType());
        typeClassEClass.getESuperTypes().add(this.getTypeAbstractClass());
        typeCollectionEClass.getESuperTypes().add(this.getTypeAbstractClass());
        typeListEClass.getESuperTypes().add(this.getTypeAbstractClass());
        typeSetEClass.getESuperTypes().add(this.getTypeAbstractClass());
        typeMapEClass.getESuperTypes().add(this.getTypeAbstractClass());
        typeBigDecimalEClass.getESuperTypes().add(this.getTypeObject());
        typeBigIntegerEClass.getESuperTypes().add(this.getTypeObject());
        typeBooleanEClass.getESuperTypes().add(this.getTypeObject());
        typeByteEClass.getESuperTypes().add(this.getTypeObject());
        typeCharacterEClass.getESuperTypes().add(this.getTypeObject());
        typeDateEClass.getESuperTypes().add(this.getTypeObject());
        typeDoubleEClass.getESuperTypes().add(this.getTypeObject());
        typeFloatEClass.getESuperTypes().add(this.getTypeObject());
        typeIntegerEClass.getESuperTypes().add(this.getTypeObject());
        typeLongEClass.getESuperTypes().add(this.getTypeObject());
        typeShortEClass.getESuperTypes().add(this.getTypeObject());
        typeStringEClass.getESuperTypes().add(this.getTypeObject());
        typeURIEClass.getESuperTypes().add(this.getTypeObject());

        // Initialize classes and features; add operations and parameters
        initEClass(typeElementEClass, TypeElement.class, "TypeElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeElement_ID(), theEcorePackage.getEString(), "iD", null, 0, 1, TypeElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getTypeElement_Description(), theEcorePackage.getEString(), "description", null, 0, 1, TypeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        EOperation op = addEOperation(typeEClass, theEcorePackage.getEBoolean(), "isCompatible", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(typeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        ETypeParameter t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        EGenericType g1 = createEGenericType(theEcorePackage.getEJavaObject());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        EGenericType g2 = createEGenericType(t1);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        addEOperation(typeEClass, theEcorePackage.getEJavaObject(), "getValue", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeObjectEClass, TypeObject.class, "TypeObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        op = addEOperation(typeObjectEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEJavaObject());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        g2 = createEGenericType(t1);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(typeAbstractClassEClass, TypeAbstractClass.class, "TypeAbstractClass", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeAbstractClass_Instance(), theEcorePackage.getEJavaObject(), "instance", null, 0, 1, TypeAbstractClass.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getTypeAbstractClass_Value(), theEcorePackage.getEString(), "value", null, 0, 1, TypeAbstractClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeClassEClass, TypeClass.class, "TypeClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        initEAttribute(getTypeClass_Type(), g1, "type", null, 0, 1, TypeClass.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeCollectionEClass, TypeCollection.class, "TypeCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        op = addEOperation(typeCollectionEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEJavaObject());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        g2 = createEGenericType(t1);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(typeListEClass, TypeList.class, "TypeList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        op = addEOperation(typeListEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEJavaObject());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        g2 = createEGenericType(t1);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(typeSetEClass, TypeSet.class, "TypeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        op = addEOperation(typeSetEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEJavaObject());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        g2 = createEGenericType(t1);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(typeMapEClass, TypeMap.class, "TypeMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        op = addEOperation(typeMapEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        g1 = createEGenericType(theEcorePackage.getEJavaObject());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(theEcorePackage.getEJavaClass());
        g2 = createEGenericType(t1);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(typeBigDecimalEClass, TypeBigDecimal.class, "TypeBigDecimal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeBigDecimal_Value(), theEcorePackage.getEBigDecimal(), "value", null, 0, 1, TypeBigDecimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeBigIntegerEClass, TypeBigInteger.class, "TypeBigInteger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeBigInteger_Value(), theEcorePackage.getEBigInteger(), "value", null, 0, 1, TypeBigInteger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeBooleanEClass, TypeBoolean.class, "TypeBoolean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeBoolean_Value(), theEcorePackage.getEBooleanObject(), "value", null, 0, 1, TypeBoolean.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeByteEClass, TypeByte.class, "TypeByte", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeByte_Value(), theEcorePackage.getEByteObject(), "value", null, 0, 1, TypeByte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeCharacterEClass, TypeCharacter.class, "TypeCharacter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeCharacter_Value(), theEcorePackage.getECharacterObject(), "value", null, 0, 1, TypeCharacter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeDateEClass, TypeDate.class, "TypeDate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeDate_Value(), theEcorePackage.getEDate(), "value", null, 0, 1, TypeDate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeDoubleEClass, TypeDouble.class, "TypeDouble", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeDouble_Value(), theEcorePackage.getEDoubleObject(), "value", null, 0, 1, TypeDouble.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeFloatEClass, TypeFloat.class, "TypeFloat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeFloat_Value(), theEcorePackage.getEFloatObject(), "value", null, 0, 1, TypeFloat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeIntegerEClass, TypeInteger.class, "TypeInteger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeInteger_Value(), theEcorePackage.getEIntegerObject(), "value", null, 0, 1, TypeInteger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeLongEClass, TypeLong.class, "TypeLong", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeLong_Value(), theEcorePackage.getELongObject(), "value", null, 0, 1, TypeLong.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeShortEClass, TypeShort.class, "TypeShort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeShort_Value(), theEcorePackage.getEShortObject(), "value", null, 0, 1, TypeShort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeStringEClass, TypeString.class, "TypeString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeString_Value(), theEcorePackage.getEString(), "value", null, 0, 1, TypeString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeURIEClass, TypeURI.class, "TypeURI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeURI_Value(), this.getURI(), "value", null, 0, 1, TypeURI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        // Initialize data types
        initEDataType(setEDataType, Set.class, "Set", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEDataType(listEDataType, List.class, "List", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEDataType(collectionEDataType, Collection.class, "Collection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEDataType(typesExceptionEDataType, TypesException.class, "TypesException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

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
        addAnnotation(typeObjectEClass, source, new String[] {
                "constraints", "ValidValue" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(typeAbstractClassEClass, source, new String[] {
                "constraints", "LoadableType ValidValue ValidInstance" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(typeClassEClass, source, new String[] {
                "constraints", "MandatoryValue" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(typeURIEClass, source, new String[] {
                "constraints", "ValidURI" //$NON-NLS-1$ //$NON-NLS-2$
        });
    }

} // TypesPackageImpl
