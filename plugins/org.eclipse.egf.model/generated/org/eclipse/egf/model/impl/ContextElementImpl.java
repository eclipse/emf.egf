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

import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.Type;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Context Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.ContextElementImpl#getContractElementReference <em>Contract Element Reference</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ContextElementImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ContextElementImpl#getReadableValue <em>Readable Value</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ContextElementImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ContextElementImpl#getContractReferenceId <em>Contract Reference Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ContextElementImpl#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.ContextElementImpl#getPluginId <em>Plugin Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextElementImpl extends NamedModelElementWithIdImpl implements ContextElement {
  /**
   * The cached value of the '{@link #getContractElementReference() <em>Contract Element Reference</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @see #getContractElementReference()
   * @generated
   * @ordered
   */
  protected ContractElementReference contractElementReference;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final Object VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected Object value = VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getReadableValue() <em>Readable Value</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getReadableValue()
   * @generated
   * @ordered
   */
  protected static final String READABLE_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReadableValue() <em>Readable Value</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getReadableValue()
   * @generated
   * @ordered
   */
  protected String readableValue = READABLE_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getKey()
   * @generated
   * @ordered
   */
  protected static final String KEY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getKey()
   * @generated
   * @ordered
   */
  protected String key = KEY_EDEFAULT;

  /**
   * The default value of the '{@link #getContractReferenceId() <em>Contract Reference Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getContractReferenceId()
   * @generated
   * @ordered
   */
  protected static final String CONTRACT_REFERENCE_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getContractReferenceId() <em>Contract Reference Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getContractReferenceId()
   * @generated
   * @ordered
   */
  protected String contractReferenceId = CONTRACT_REFERENCE_ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getContextType() <em>Context Type</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getContextType()
   * @generated
   * @ordered
   */
  protected Type contextType;

  /**
   * The default value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getPluginId()
   * @generated
   * @ordered
   */
  protected static final String PLUGIN_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getPluginId()
   * @generated
   * @ordered
   */
  protected String pluginId = PLUGIN_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ContextElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.CONTEXT_ELEMENT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public ContractElementReference getContractElementReference() {
    // Load the contract element reference if needed.
    loadContractElementReference();
    if (contractElementReference != null && contractElementReference.eIsProxy()) {
      InternalEObject oldContractElementReference = (InternalEObject) contractElementReference;
      contractElementReference = (ContractElementReference) eResolveProxy(oldContractElementReference);
      if (contractElementReference != oldContractElementReference) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE, oldContractElementReference,
              contractElementReference));
      }
    }
    return contractElementReference;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContractElementReference(ContractElementReference newContractElementReference, NotificationChain msgs) {
    ContractElementReference oldContractElementReference = contractElementReference;
    contractElementReference = newContractElementReference;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE, oldContractElementReference, newContractElementReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public ContractElementReference basicGetContractElementReference() {
    // Load the contract element reference if needed.
    loadContractElementReference();
    return contractElementReference;
  }

  /**
   * Load the contract element reference from the extension registry.
   * @generated NOT
   */
  private void loadContractElementReference() {
    if (null == contractElementReference) {
      if (null != contractReferenceId) {
        FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(this);
        // If the fc container is retrieved, try loading contract element reference.
        if (null != fcContainer) {
          setContractElementReference(getFactoryComponentLoadingHelper().loadContractElementReference(contractReferenceId, fcContainer.getId()));
        }
      }
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setContractElementReference(ContractElementReference newContractElementReference) {
    if (newContractElementReference != contractElementReference) {
      NotificationChain msgs = null;
      if (contractElementReference != null)
        msgs = ((InternalEObject)contractElementReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE, null, msgs);
      if (newContractElementReference != null)
        msgs = ((InternalEObject)newContractElementReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE, null, msgs);
      msgs = basicSetContractElementReference(newContractElementReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE, newContractElementReference, newContractElementReference));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Object getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setValue(Object newValue) {
    Object oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_ELEMENT__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getReadableValue() {
    return readableValue;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setReadableValue(String newReadableValue) {
    String oldReadableValue = readableValue;
    readableValue = newReadableValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_ELEMENT__READABLE_VALUE, oldReadableValue, readableValue));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getKey() {
    return key;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setKey(String newKey) {
    String oldKey = key;
    key = newKey;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_ELEMENT__KEY, oldKey, key));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getContractReferenceId() {
    return contractReferenceId;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setContractReferenceId(String newContractReferenceId) {
    String oldContractReferenceId = contractReferenceId;
    contractReferenceId = newContractReferenceId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_ELEMENT__CONTRACT_REFERENCE_ID, oldContractReferenceId, contractReferenceId));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Type getContextType() {
    return contextType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContextType(Type newContextType, NotificationChain msgs) {
    Type oldContextType = contextType;
    contextType = newContextType;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_ELEMENT__CONTEXT_TYPE, oldContextType, newContextType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setContextType(Type newContextType) {
    if (newContextType != contextType) {
      NotificationChain msgs = null;
      if (contextType != null)
        msgs = ((InternalEObject)contextType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CONTEXT_ELEMENT__CONTEXT_TYPE, null, msgs);
      if (newContextType != null)
        msgs = ((InternalEObject)newContextType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CONTEXT_ELEMENT__CONTEXT_TYPE, null, msgs);
      msgs = basicSetContextType(newContextType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_ELEMENT__CONTEXT_TYPE, newContextType, newContextType));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getPluginId() {
    return pluginId;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setPluginId(String newPluginId) {
    String oldPluginId = pluginId;
    pluginId = newPluginId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXT_ELEMENT__PLUGIN_ID, oldPluginId, pluginId));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelPackage.CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE:
        return basicSetContractElementReference(null, msgs);
      case ModelPackage.CONTEXT_ELEMENT__CONTEXT_TYPE:
        return basicSetContextType(null, msgs);
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
      case ModelPackage.CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE:
        return getContractElementReference();
      case ModelPackage.CONTEXT_ELEMENT__VALUE:
        return getValue();
      case ModelPackage.CONTEXT_ELEMENT__READABLE_VALUE:
        return getReadableValue();
      case ModelPackage.CONTEXT_ELEMENT__KEY:
        return getKey();
      case ModelPackage.CONTEXT_ELEMENT__CONTRACT_REFERENCE_ID:
        return getContractReferenceId();
      case ModelPackage.CONTEXT_ELEMENT__CONTEXT_TYPE:
        return getContextType();
      case ModelPackage.CONTEXT_ELEMENT__PLUGIN_ID:
        return getPluginId();
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
      case ModelPackage.CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE:
        setContractElementReference((ContractElementReference)newValue);
        return;
      case ModelPackage.CONTEXT_ELEMENT__VALUE:
        setValue(newValue);
        return;
      case ModelPackage.CONTEXT_ELEMENT__READABLE_VALUE:
        setReadableValue((String)newValue);
        return;
      case ModelPackage.CONTEXT_ELEMENT__KEY:
        setKey((String)newValue);
        return;
      case ModelPackage.CONTEXT_ELEMENT__CONTRACT_REFERENCE_ID:
        setContractReferenceId((String)newValue);
        return;
      case ModelPackage.CONTEXT_ELEMENT__CONTEXT_TYPE:
        setContextType((Type)newValue);
        return;
      case ModelPackage.CONTEXT_ELEMENT__PLUGIN_ID:
        setPluginId((String)newValue);
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
      case ModelPackage.CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE:
        setContractElementReference((ContractElementReference)null);
        return;
      case ModelPackage.CONTEXT_ELEMENT__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case ModelPackage.CONTEXT_ELEMENT__READABLE_VALUE:
        setReadableValue(READABLE_VALUE_EDEFAULT);
        return;
      case ModelPackage.CONTEXT_ELEMENT__KEY:
        setKey(KEY_EDEFAULT);
        return;
      case ModelPackage.CONTEXT_ELEMENT__CONTRACT_REFERENCE_ID:
        setContractReferenceId(CONTRACT_REFERENCE_ID_EDEFAULT);
        return;
      case ModelPackage.CONTEXT_ELEMENT__CONTEXT_TYPE:
        setContextType((Type)null);
        return;
      case ModelPackage.CONTEXT_ELEMENT__PLUGIN_ID:
        setPluginId(PLUGIN_ID_EDEFAULT);
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
      case ModelPackage.CONTEXT_ELEMENT__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case ModelPackage.CONTEXT_ELEMENT__READABLE_VALUE:
        return READABLE_VALUE_EDEFAULT == null ? readableValue != null : !READABLE_VALUE_EDEFAULT.equals(readableValue);
      case ModelPackage.CONTEXT_ELEMENT__KEY:
        return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
        // Due to our own persistence mechanism, eIsSet for ModelPackage.CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE feature is based on
        // ModelPackage.CONTEXT_ELEMENT__CONTRACT_REFERENCE_ID.
      case ModelPackage.CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE:
      case ModelPackage.CONTEXT_ELEMENT__CONTRACT_REFERENCE_ID:
        return CONTRACT_REFERENCE_ID_EDEFAULT == null ? contractReferenceId != null : !CONTRACT_REFERENCE_ID_EDEFAULT.equals(contractReferenceId);
      case ModelPackage.CONTEXT_ELEMENT__CONTEXT_TYPE:
        return contextType != null;
      case ModelPackage.CONTEXT_ELEMENT__PLUGIN_ID:
        return PLUGIN_ID_EDEFAULT == null ? pluginId != null : !PLUGIN_ID_EDEFAULT.equals(pluginId);
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
    result.append(" (value: "); //$NON-NLS-1$
    result.append(value);
    result.append(", readableValue: "); //$NON-NLS-1$
    result.append(readableValue);
    result.append(", key: "); //$NON-NLS-1$
    result.append(key);
    result.append(", contractReferenceId: "); //$NON-NLS-1$
    result.append(contractReferenceId);
    result.append(", pluginId: "); //$NON-NLS-1$
    result.append(pluginId);
    result.append(')');
    return result.toString();
  }

} // ContextElementImpl
