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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.Type;
import org.eclipse.egf.model.data.helper.ModelHelper;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Contract Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.ContractElementImpl#getContractElementReferences <em>Contract Element References</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ContractElementImpl#getFactoryComponentId <em>Factory Component Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ContractElementImpl#getContractReferenceIds <em>Contract Reference Ids</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ContractElementImpl#getContractType <em>Contract Type</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ContractElementImpl#isMandatory <em>Mandatory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContractElementImpl extends NamedModelElementWithIdImpl implements ContractElement {
  /**
   * The cached value of the '{@link #getContractElementReferences() <em>Contract Element References</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContractElementReferences()
   * @generated
   * @ordered
   */
  protected EList<ContractElementReference> contractElementReferences;

  /**
   * The default value of the '{@link #getFactoryComponentId() <em>Factory Component Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFactoryComponentId()
   * @generated
   * @ordered
   */
  protected static final String FACTORY_COMPONENT_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFactoryComponentId() <em>Factory Component Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFactoryComponentId()
   * @generated
   * @ordered
   */
  protected String factoryComponentId = FACTORY_COMPONENT_ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getContractReferenceIds() <em>Contract Reference Ids</em>}' attribute list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getContractReferenceIds()
   * @generated
   * @ordered
   */
  protected EList<String> contractReferenceIds;

  /**
   * The cached value of the '{@link #getContractType() <em>Contract Type</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getContractType()
   * @generated
   * @ordered
   */
  protected Type contractType;

  /**
   * The default value of the '{@link #isMandatory() <em>Mandatory</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #isMandatory()
   * @generated
   * @ordered
   */
  protected static final boolean MANDATORY_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isMandatory() <em>Mandatory</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #isMandatory()
   * @generated
   * @ordered
   */
  protected boolean mandatory = MANDATORY_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ContractElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.CONTRACT_ELEMENT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public EList<ContractElementReference> getContractElementReferences() {
    if (contractElementReferences == null) {
      contractElementReferences =
          new EObjectResolvingEList<ContractElementReference>(ContractElementReference.class, this, ModelPackage.CONTRACT_ELEMENT__CONTRACT_ELEMENT_REFERENCES);
      // Get the fc container of this element.
      FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(this);
      // If the fc is retrieved, try loading contract element references.
      if (null != fcContainer) {
        String fcContainerId = fcContainer.getId();
        // Load contract element references from the extension registry.
        for (String contractElementReferenceId : getContractReferenceIds()) {
          ContractElementReference element = getFactoryComponentLoadingHelper().loadContractElementReference(contractElementReferenceId, fcContainerId);
          contractElementReferences.add(element);
        }
      }
    }
    return contractElementReferences;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getFactoryComponentId() {
    return factoryComponentId;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setFactoryComponentId(String newFactoryComponentId) {
    String oldFactoryComponentId = factoryComponentId;
    factoryComponentId = newFactoryComponentId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTRACT_ELEMENT__FACTORY_COMPONENT_ID, oldFactoryComponentId, factoryComponentId));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getContractReferenceIds() {
    if (contractReferenceIds == null) {
      contractReferenceIds = new EDataTypeUniqueEList<String>(String.class, this, ModelPackage.CONTRACT_ELEMENT__CONTRACT_REFERENCE_IDS);
    }
    return contractReferenceIds;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Type getContractType() {
    return contractType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContractType(Type newContractType, NotificationChain msgs) {
    Type oldContractType = contractType;
    contractType = newContractType;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CONTRACT_ELEMENT__CONTRACT_TYPE, oldContractType, newContractType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setContractType(Type newContractType) {
    if (newContractType != contractType) {
      NotificationChain msgs = null;
      if (contractType != null)
        msgs = ((InternalEObject)contractType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CONTRACT_ELEMENT__CONTRACT_TYPE, null, msgs);
      if (newContractType != null)
        msgs = ((InternalEObject)newContractType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CONTRACT_ELEMENT__CONTRACT_TYPE, null, msgs);
      msgs = basicSetContractType(newContractType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTRACT_ELEMENT__CONTRACT_TYPE, newContractType, newContractType));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean isMandatory() {
    return mandatory;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setMandatory(boolean newMandatory) {
    boolean oldMandatory = mandatory;
    mandatory = newMandatory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTRACT_ELEMENT__MANDATORY, oldMandatory, mandatory));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_ELEMENT_REFERENCES:
        return ((InternalEList<?>)getContractElementReferences()).basicRemove(otherEnd, msgs);
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_TYPE:
        return basicSetContractType(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_ELEMENT_REFERENCES:
        return getContractElementReferences();
      case ModelPackage.CONTRACT_ELEMENT__FACTORY_COMPONENT_ID:
        return getFactoryComponentId();
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_REFERENCE_IDS:
        return getContractReferenceIds();
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_TYPE:
        return getContractType();
      case ModelPackage.CONTRACT_ELEMENT__MANDATORY:
        return isMandatory();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_ELEMENT_REFERENCES:
        getContractElementReferences().clear();
        getContractElementReferences().addAll((Collection<? extends ContractElementReference>)newValue);
        return;
      case ModelPackage.CONTRACT_ELEMENT__FACTORY_COMPONENT_ID:
        setFactoryComponentId((String)newValue);
        return;
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_REFERENCE_IDS:
        getContractReferenceIds().clear();
        getContractReferenceIds().addAll((Collection<? extends String>)newValue);
        return;
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_TYPE:
        setContractType((Type)newValue);
        return;
      case ModelPackage.CONTRACT_ELEMENT__MANDATORY:
        setMandatory((Boolean)newValue);
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
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_ELEMENT_REFERENCES:
        getContractElementReferences().clear();
        return;
      case ModelPackage.CONTRACT_ELEMENT__FACTORY_COMPONENT_ID:
        setFactoryComponentId(FACTORY_COMPONENT_ID_EDEFAULT);
        return;
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_REFERENCE_IDS:
        getContractReferenceIds().clear();
        return;
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_TYPE:
        setContractType((Type)null);
        return;
      case ModelPackage.CONTRACT_ELEMENT__MANDATORY:
        setMandatory(MANDATORY_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      // Due to our own persistence mechanism, eIsSet for ModelPackage.CONTRACT_ELEMENT__CONTRACT_ELEMENT_REFERENCES feature is based on
      // ModelPackage.CONTRACT_ELEMENT__CONTRACT_REFERENCE_IDS.
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_ELEMENT_REFERENCES:
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_REFERENCE_IDS:
        return contractReferenceIds != null && !contractReferenceIds.isEmpty();
      case ModelPackage.CONTRACT_ELEMENT__FACTORY_COMPONENT_ID:
        return FACTORY_COMPONENT_ID_EDEFAULT == null ? factoryComponentId != null : !FACTORY_COMPONENT_ID_EDEFAULT.equals(factoryComponentId);
      case ModelPackage.CONTRACT_ELEMENT__CONTRACT_TYPE:
        return contractType != null;
      case ModelPackage.CONTRACT_ELEMENT__MANDATORY:
        return mandatory != MANDATORY_EDEFAULT;
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
    result.append(" (factoryComponentId: "); //$NON-NLS-1$
    result.append(factoryComponentId);
    result.append(", contractReferenceIds: "); //$NON-NLS-1$
    result.append(contractReferenceIds);
    result.append(", mandatory: "); //$NON-NLS-1$
    result.append(mandatory);
    result.append(')');
    return result.toString();
  }

} // ContractElementImpl
