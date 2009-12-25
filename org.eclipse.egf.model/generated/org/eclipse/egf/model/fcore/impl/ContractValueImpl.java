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
package org.eclipse.egf.model.fcore.impl;

import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractValue;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contract Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.egf.model.fcore.impl.ContractValueImpl#getContract
 * <em>Contract</em>}</li>
 * <li>{@link org.eclipse.egf.model.fcore.impl.ContractValueImpl#getValue <em>
 * Value</em>}</li>
 * <li>{@link org.eclipse.egf.model.fcore.impl.ContractValueImpl#getPluginId
 * <em>Plugin Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ContractValueImpl extends ContextValueImpl implements ContractValue {
  /**
   * The cached value of the '{@link #getContract() <em>Contract</em>}'
   * reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getContract()
   * @generated
   * @ordered
   */
  protected Contract contract;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getPluginId() <em>Plugin Id</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getPluginId()
   * @generated
   * @ordered
   */
  protected static final String PLUGIN_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPluginId() <em>Plugin Id</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getPluginId()
   * @generated
   * @ordered
   */
  protected String pluginId = PLUGIN_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected ContractValueImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.CONTRACT_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public Contract getContract() {
    if (contract != null && contract.eIsProxy()) {
      InternalEObject oldContract = (InternalEObject) contract;
      contract = (Contract) eResolveProxy(oldContract);
      if (contract != oldContract) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FcorePackage.CONTRACT_VALUE__CONTRACT, oldContract, contract));
      }
    }
    return contract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public Contract basicGetContract() {
    return contract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setContract(Contract newContract) {
    Contract oldContract = contract;
    contract = newContract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.CONTRACT_VALUE__CONTRACT, oldContract, contract));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setValue(String newValue) {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.CONTRACT_VALUE__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getPluginId() {
    return pluginId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setPluginId(String newPluginId) {
    String oldPluginId = pluginId;
    pluginId = newPluginId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.CONTRACT_VALUE__PLUGIN_ID, oldPluginId, pluginId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FcorePackage.CONTRACT_VALUE__CONTRACT:
      if (resolve)
        return getContract();
      return basicGetContract();
    case FcorePackage.CONTRACT_VALUE__VALUE:
      return getValue();
    case FcorePackage.CONTRACT_VALUE__PLUGIN_ID:
      return getPluginId();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FcorePackage.CONTRACT_VALUE__CONTRACT:
      setContract((Contract) newValue);
      return;
    case FcorePackage.CONTRACT_VALUE__VALUE:
      setValue((String) newValue);
      return;
    case FcorePackage.CONTRACT_VALUE__PLUGIN_ID:
      setPluginId((String) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case FcorePackage.CONTRACT_VALUE__CONTRACT:
      setContract((Contract) null);
      return;
    case FcorePackage.CONTRACT_VALUE__VALUE:
      setValue(VALUE_EDEFAULT);
      return;
    case FcorePackage.CONTRACT_VALUE__PLUGIN_ID:
      setPluginId(PLUGIN_ID_EDEFAULT);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FcorePackage.CONTRACT_VALUE__CONTRACT:
      return contract != null;
    case FcorePackage.CONTRACT_VALUE__VALUE:
      return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
    case FcorePackage.CONTRACT_VALUE__PLUGIN_ID:
      return PLUGIN_ID_EDEFAULT == null ? pluginId != null : !PLUGIN_ID_EDEFAULT.equals(pluginId);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (value: "); //$NON-NLS-1$
    result.append(value);
    result.append(", pluginId: "); //$NON-NLS-1$
    result.append(pluginId);
    result.append(')');
    return result.toString();
  }

} // ContractValueImpl
