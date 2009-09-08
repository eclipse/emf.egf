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
package org.eclipse.egf.model.impl;

import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Contract Element Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.ContractElementReferenceImpl#getReferencedContractElementId <em>Referenced Contract Element Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ContractElementReferenceImpl#getReferencedContractElementName <em>Referenced Contract Element Name</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ContractElementReferenceImpl#getReferencedFactoryComponentId <em>Referenced Factory Component Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ContractElementReferenceImpl#getReferencedContractElement <em>Referenced Contract Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContractElementReferenceImpl extends NamedModelElementWithIdImpl implements ContractElementReference {
  /**
   * The default value of the '{@link #getReferencedContractElementId() <em>Referenced Contract Element Id</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getReferencedContractElementId()
   * @generated
   * @ordered
   */
  protected static final String REFERENCED_CONTRACT_ELEMENT_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReferencedContractElementId() <em>Referenced Contract Element Id</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getReferencedContractElementId()
   * @generated
   * @ordered
   */
  protected String referencedContractElementId = REFERENCED_CONTRACT_ELEMENT_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getReferencedContractElementName() <em>Referenced Contract Element Name</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getReferencedContractElementName()
   * @generated
   * @ordered
   */
  protected static final String REFERENCED_CONTRACT_ELEMENT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReferencedContractElementName() <em>Referenced Contract Element Name</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getReferencedContractElementName()
   * @generated
   * @ordered
   */
  protected String referencedContractElementName = REFERENCED_CONTRACT_ELEMENT_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getReferencedFactoryComponentId() <em>Referenced Factory Component Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getReferencedFactoryComponentId()
   * @generated
   * @ordered
   */
  protected static final String REFERENCED_FACTORY_COMPONENT_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReferencedFactoryComponentId() <em>Referenced Factory Component Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getReferencedFactoryComponentId()
   * @generated
   * @ordered
   */
  protected String referencedFactoryComponentId = REFERENCED_FACTORY_COMPONENT_ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getReferencedContractElement() <em>Referenced Contract Element</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @see #getReferencedContractElement()
   * @generated
   * @ordered
   */
  protected ContractElement referencedContractElement;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ContractElementReferenceImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.CONTRACT_ELEMENT_REFERENCE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getReferencedContractElementId() {
    return referencedContractElementId;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setReferencedContractElementId(String newReferencedContractElementId) {
    String oldReferencedContractElementId = referencedContractElementId;
    referencedContractElementId = newReferencedContractElementId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_ID, oldReferencedContractElementId, referencedContractElementId));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getReferencedContractElementName() {
    return referencedContractElementName;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setReferencedContractElementName(String newReferencedContractElementName) {
    String oldReferencedContractElementName = referencedContractElementName;
    referencedContractElementName = newReferencedContractElementName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_NAME, oldReferencedContractElementName, referencedContractElementName));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getReferencedFactoryComponentId() {
    return referencedFactoryComponentId;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setReferencedFactoryComponentId(String newReferencedFactoryComponentId) {
    String oldReferencedFactoryComponentId = referencedFactoryComponentId;
    referencedFactoryComponentId = newReferencedFactoryComponentId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_FACTORY_COMPONENT_ID, oldReferencedFactoryComponentId, referencedFactoryComponentId));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ContractElement getReferencedContractElement() {
    if (referencedContractElement != null && referencedContractElement.eIsProxy()) {
      InternalEObject oldReferencedContractElement = (InternalEObject)referencedContractElement;
      referencedContractElement = (ContractElement)eResolveProxy(oldReferencedContractElement);
      if (referencedContractElement != oldReferencedContractElement) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT, oldReferencedContractElement, referencedContractElement));
      }
    }
    return referencedContractElement;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ContractElement basicGetReferencedContractElement() {
    return referencedContractElement;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setReferencedContractElement(ContractElement newReferencedContractElement) {
    ContractElement oldReferencedContractElement = referencedContractElement;
    referencedContractElement = newReferencedContractElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT, oldReferencedContractElement, referencedContractElement));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_ID:
        return getReferencedContractElementId();
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_NAME:
        return getReferencedContractElementName();
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_FACTORY_COMPONENT_ID:
        return getReferencedFactoryComponentId();
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT:
        if (resolve) return getReferencedContractElement();
        return basicGetReferencedContractElement();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_ID:
        setReferencedContractElementId((String)newValue);
        return;
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_NAME:
        setReferencedContractElementName((String)newValue);
        return;
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_FACTORY_COMPONENT_ID:
        setReferencedFactoryComponentId((String)newValue);
        return;
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT:
        setReferencedContractElement((ContractElement)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_ID:
        setReferencedContractElementId(REFERENCED_CONTRACT_ELEMENT_ID_EDEFAULT);
        return;
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_NAME:
        setReferencedContractElementName(REFERENCED_CONTRACT_ELEMENT_NAME_EDEFAULT);
        return;
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_FACTORY_COMPONENT_ID:
        setReferencedFactoryComponentId(REFERENCED_FACTORY_COMPONENT_ID_EDEFAULT);
        return;
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT:
        setReferencedContractElement((ContractElement)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_ID:
        return REFERENCED_CONTRACT_ELEMENT_ID_EDEFAULT == null ? referencedContractElementId != null : !REFERENCED_CONTRACT_ELEMENT_ID_EDEFAULT.equals(referencedContractElementId);
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT_NAME:
        return REFERENCED_CONTRACT_ELEMENT_NAME_EDEFAULT == null ? referencedContractElementName != null : !REFERENCED_CONTRACT_ELEMENT_NAME_EDEFAULT.equals(referencedContractElementName);
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_FACTORY_COMPONENT_ID:
        return REFERENCED_FACTORY_COMPONENT_ID_EDEFAULT == null ? referencedFactoryComponentId != null : !REFERENCED_FACTORY_COMPONENT_ID_EDEFAULT.equals(referencedFactoryComponentId);
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE__REFERENCED_CONTRACT_ELEMENT:
        return referencedContractElement != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (referencedContractElementId: "); //$NON-NLS-1$
    result.append(referencedContractElementId);
    result.append(", referencedContractElementName: "); //$NON-NLS-1$
    result.append(referencedContractElementName);
    result.append(", referencedFactoryComponentId: "); //$NON-NLS-1$
    result.append(referencedFactoryComponentId);
    result.append(')');
    return result.toString();
  }

} // ContractElementReferenceImpl
