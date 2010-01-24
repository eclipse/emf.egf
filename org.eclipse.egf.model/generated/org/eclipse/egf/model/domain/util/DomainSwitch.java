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
package org.eclipse.egf.model.domain.util;

import java.util.List;

import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainEPackage;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.TypeDomainEPackage;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeElement;
import org.eclipse.egf.model.types.TypeObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke
 * the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.egf.model.domain.DomainPackage
 * @generated
 */
public class DomainSwitch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected static DomainPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public DomainSwitch() {
    if (modelPackage == null) {
      modelPackage = DomainPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it
   * yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject) {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it
   * yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @SuppressWarnings("all")
  protected T doSwitch(EClass theEClass, EObject theEObject) {
    if (theEClass.eContainer() == modelPackage) {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    } else {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it
   * yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
    case DomainPackage.DOMAIN_VIEWPOINT: {
      DomainViewpoint domainViewpoint = (DomainViewpoint) theEObject;
      T result = caseDomainViewpoint(domainViewpoint);
      if (result == null)
        result = caseViewpoint(domainViewpoint);
      if (result == null)
        result = caseModelElement(domainViewpoint);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case DomainPackage.DOMAIN: {
      Domain domain = (Domain) theEObject;
      T result = caseDomain(domain);
      if (result == null)
        result = caseModelElement(domain);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case DomainPackage.DOMAIN_EPACKAGE: {
      DomainEPackage domainEPackage = (DomainEPackage) theEObject;
      T result = caseDomainEPackage(domainEPackage);
      if (result == null)
        result = caseDomain(domainEPackage);
      if (result == null)
        result = caseModelElement(domainEPackage);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case DomainPackage.TYPE_DOMAIN_EPACKAGE: {
      TypeDomainEPackage typeDomainEPackage = (TypeDomainEPackage) theEObject;
      T result = caseTypeDomainEPackage(typeDomainEPackage);
      if (result == null)
        result = caseTypeObject(typeDomainEPackage);
      if (result == null)
        result = caseType(typeDomainEPackage);
      if (result == null)
        result = caseTypeElement(typeDomainEPackage);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case DomainPackage.DOMAIN_URI: {
      DomainURI domainURI = (DomainURI) theEObject;
      T result = caseDomainURI(domainURI);
      if (result == null)
        result = caseDomain(domainURI);
      if (result == null)
        result = caseModelElement(domainURI);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case DomainPackage.TYPE_DOMAIN_URI: {
      TypeDomainURI typeDomainURI = (TypeDomainURI) theEObject;
      T result = caseTypeDomainURI(typeDomainURI);
      if (result == null)
        result = caseTypeObject(typeDomainURI);
      if (result == null)
        result = caseType(typeDomainURI);
      if (result == null)
        result = caseTypeElement(typeDomainURI);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomainViewpoint(DomainViewpoint object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomain(Domain object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EPackage</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EPackage</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomainEPackage(DomainEPackage object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Domain
   * EPackage</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Domain
   *         EPackage</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeDomainEPackage(TypeDomainEPackage object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>URI</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>URI</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomainURI(DomainURI object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Domain URI</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Domain URI</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeDomainURI(TypeDomainURI object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelElement(ModelElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseViewpoint(Viewpoint object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeElement(TypeElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeObject(TypeObject object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last
   * case anyway.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object) {
    return null;
  }

} // DomainSwitch
