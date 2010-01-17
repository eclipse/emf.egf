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
package org.eclipse.egf.model.domain.impl;

import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainEPackage;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.TypeDomainEPackage;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.egf.model.domain.util.DomainValidator;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainPackageImpl extends EPackageImpl implements DomainPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass domainViewpointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass domainEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass domainEPackageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeDomainEPackageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass domainURIEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeDomainURIEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
   * package
   * package URI value.
   * <p>
   * Note: the correct way to create the package is via the static factory
   * method {@link #init init()}, which also performs initialization of the
   * package, or returns the registered package, if one already exists. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.egf.model.domain.DomainPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DomainPackageImpl() {
    super(eNS_URI, DomainFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link DomainPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DomainPackage init() {
    if (isInited)
      return (DomainPackage) EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI);

    // Obtain or create and register package
    DomainPackageImpl theDomainPackage = (DomainPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DomainPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    FcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theDomainPackage.createPackageContents();

    // Initialize created meta-data
    theDomainPackage.initializePackageContents();

    // Register package validator
    EValidator.Registry.INSTANCE.put(theDomainPackage, new EValidator.Descriptor() {
      public EValidator getEValidator() {
        return DomainValidator.INSTANCE;
      }
    });

    // Mark meta-data to indicate it can't be changed
    theDomainPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(DomainPackage.eNS_URI, theDomainPackage);
    return theDomainPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDomainViewpoint() {
    return domainViewpointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDomainViewpoint_Domains() {
    return (EReference) domainViewpointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDomain() {
    return domainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDomainEPackage() {
    return domainEPackageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDomainEPackage_EPackage() {
    return (EReference) domainEPackageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeDomainEPackage() {
    return typeDomainEPackageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeDomainEPackage_Domain() {
    return (EReference) typeDomainEPackageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeDomainEPackage_Value() {
    return (EReference) typeDomainEPackageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDomainURI() {
    return domainURIEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDomainURI_Uri() {
    return (EAttribute) domainURIEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeDomainURI() {
    return typeDomainURIEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeDomainURI_Domain() {
    return (EReference) typeDomainURIEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeDomainURI_Value() {
    return (EAttribute) typeDomainURIEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DomainFactory getDomainFactory() {
    return (DomainFactory) getEFactoryInstance();
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
    domainViewpointEClass = createEClass(DOMAIN_VIEWPOINT);
    createEReference(domainViewpointEClass, DOMAIN_VIEWPOINT__DOMAINS);

    domainEClass = createEClass(DOMAIN);

    domainEPackageEClass = createEClass(DOMAIN_EPACKAGE);
    createEReference(domainEPackageEClass, DOMAIN_EPACKAGE__EPACKAGE);

    typeDomainEPackageEClass = createEClass(TYPE_DOMAIN_EPACKAGE);
    createEReference(typeDomainEPackageEClass, TYPE_DOMAIN_EPACKAGE__DOMAIN);
    createEReference(typeDomainEPackageEClass, TYPE_DOMAIN_EPACKAGE__VALUE);

    domainURIEClass = createEClass(DOMAIN_URI);
    createEAttribute(domainURIEClass, DOMAIN_URI__URI);

    typeDomainURIEClass = createEClass(TYPE_DOMAIN_URI);
    createEReference(typeDomainURIEClass, TYPE_DOMAIN_URI__DOMAIN);
    createEAttribute(typeDomainURIEClass, TYPE_DOMAIN_URI__VALUE);
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
    TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    domainViewpointEClass.getESuperTypes().add(theFcorePackage.getViewpoint());
    domainEClass.getESuperTypes().add(theFcorePackage.getModelElement());
    domainEPackageEClass.getESuperTypes().add(this.getDomain());
    typeDomainEPackageEClass.getESuperTypes().add(theTypesPackage.getType());
    domainURIEClass.getESuperTypes().add(this.getDomain());
    typeDomainURIEClass.getESuperTypes().add(theTypesPackage.getType());

    // Initialize classes and features; add operations and parameters
    initEClass(domainViewpointEClass, DomainViewpoint.class, "DomainViewpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getDomainViewpoint_Domains(), this.getDomain(), null, "domains", null, 0, -1, DomainViewpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(domainEClass, Domain.class, "Domain", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(domainEPackageEClass, DomainEPackage.class, "DomainEPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getDomainEPackage_EPackage(), theEcorePackage.getEPackage(), null, "ePackage", null, 1, 1, DomainEPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(typeDomainEPackageEClass, TypeDomainEPackage.class, "TypeDomainEPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getTypeDomainEPackage_Domain(), this.getDomainEPackage(), null, "domain", null, 0, 1, TypeDomainEPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(getTypeDomainEPackage_Value(), theEcorePackage.getEPackage(), null, "value", null, 0, 1, TypeDomainEPackage.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(domainURIEClass, DomainURI.class, "DomainURI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getDomainURI_Uri(), theTypesPackage.getURI(), "uri", null, 1, 1, DomainURI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(typeDomainURIEClass, TypeDomainURI.class, "TypeDomainURI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getTypeDomainURI_Domain(), this.getDomainURI(), null, "domain", null, 0, 1, TypeDomainURI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getTypeDomainURI_Value(), theTypesPackage.getURI(), "value", null, 0, 1, TypeDomainURI.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

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
    addAnnotation(domainEPackageEClass, source, new String[] { "constraints", "ValidPackage" //$NON-NLS-1$ //$NON-NLS-2$
    });
    addAnnotation(domainURIEClass, source, new String[] { "constraints", "ValidURI" //$NON-NLS-1$ //$NON-NLS-2$
    });
  }

} // DomainPackageImpl
