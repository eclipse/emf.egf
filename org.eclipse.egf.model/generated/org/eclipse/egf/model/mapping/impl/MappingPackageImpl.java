/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.mapping.impl;

import org.eclipse.egf.model.domain.DomainPackage;

import org.eclipse.egf.model.factorycomponent.FactoryComponentPackage;

import org.eclipse.egf.model.mapping.Mapping;
import org.eclipse.egf.model.mapping.MappingDomain;
import org.eclipse.egf.model.mapping.MappingFactory;
import org.eclipse.egf.model.mapping.MappingPackage;
import org.eclipse.egf.model.mapping.MappingViewpoint;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingPackageImpl extends EPackageImpl implements MappingPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mappingViewpointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mappingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mappingDomainEClass = null;

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
   * @see org.eclipse.egf.model.mapping.MappingPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MappingPackageImpl() {
    super(eNS_URI, MappingFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link MappingPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static MappingPackage init() {
    if (isInited)
      return (MappingPackage) EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);

    // Obtain or create and register package
    MappingPackageImpl theMappingPackage = (MappingPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE
        .get(eNS_URI)
        : new MappingPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    DomainPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theMappingPackage.createPackageContents();

    // Initialize created meta-data
    theMappingPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMappingPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MappingPackage.eNS_URI, theMappingPackage);
    return theMappingPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMappingViewpoint() {
    return mappingViewpointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMappingViewpoint_Mappings() {
    return (EReference) mappingViewpointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMapping() {
    return mappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMappingDomain() {
    return mappingDomainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMappingDomain_Source() {
    return (EReference) mappingDomainEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMappingDomain_Target() {
    return (EReference) mappingDomainEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MappingFactory getMappingFactory() {
    return (MappingFactory) getEFactoryInstance();
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
    mappingViewpointEClass = createEClass(MAPPING_VIEWPOINT);
    createEReference(mappingViewpointEClass, MAPPING_VIEWPOINT__MAPPINGS);

    mappingEClass = createEClass(MAPPING);

    mappingDomainEClass = createEClass(MAPPING_DOMAIN);
    createEReference(mappingDomainEClass, MAPPING_DOMAIN__SOURCE);
    createEReference(mappingDomainEClass, MAPPING_DOMAIN__TARGET);
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
    FactoryComponentPackage theFactoryComponentPackage = (FactoryComponentPackage) EPackage.Registry.INSTANCE
        .getEPackage(FactoryComponentPackage.eNS_URI);
    DomainPackage theDomainPackage = (DomainPackage) EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    mappingViewpointEClass.getESuperTypes().add(theFactoryComponentPackage.getViewpoint());
    mappingEClass.getESuperTypes().add(theFactoryComponentPackage.getModelElement());
    mappingDomainEClass.getESuperTypes().add(this.getMapping());

    // Initialize classes and features; add operations and parameters
    initEClass(mappingViewpointEClass, MappingViewpoint.class, "MappingViewpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getMappingViewpoint_Mappings(),
        this.getMappingDomain(),
        null,
        "mappings", null, 0, -1, MappingViewpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(mappingEClass, Mapping.class, "Mapping", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(mappingDomainEClass, MappingDomain.class, "MappingDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getMappingDomain_Source(),
        theDomainPackage.getDomain(),
        null,
        "source", null, 1, 1, MappingDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getMappingDomain_Target(),
        theDomainPackage.getDomain(),
        null,
        "target", null, 1, 1, MappingDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    // Create resource
    createResource(eNS_URI);
  }

} //MappingPackageImpl
