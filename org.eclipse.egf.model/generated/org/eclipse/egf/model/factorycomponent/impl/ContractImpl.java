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
package org.eclipse.egf.model.factorycomponent.impl;

import org.eclipse.egf.model.factorycomponent.Contract;
import org.eclipse.egf.model.factorycomponent.ContractMode;
import org.eclipse.egf.model.factorycomponent.ContractValue;
import org.eclipse.egf.model.factorycomponent.FactoryComponentPackage;

import org.eclipse.egf.model.types.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.ContractImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.ContractImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.ContractImpl#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContractImpl extends ModelElementImpl implements Contract {
  /**
   * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMode()
   * @generated
   * @ordered
   */
  protected static final ContractMode MODE_EDEFAULT = ContractMode.IN;

  /**
   * The offset of the flags representing the value of the '{@link #getMode() <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected static final int MODE_EFLAG_OFFSET = 0;

  /**
   * The flags representing the default value of the '{@link #getMode() <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected static final int MODE_EFLAG_DEFAULT = MODE_EDEFAULT.ordinal() << MODE_EFLAG_OFFSET;

  /**
   * The array of enumeration values for '{@link ContractMode Contract Mode}'
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  private static final ContractMode[] MODE_EFLAG_VALUES = ContractMode.values();

  /**
   * The flag representing the value of the '{@link #getMode() <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMode()
   * @generated
   * @ordered
   */
  protected static final int MODE_EFLAG = 1 << MODE_EFLAG_OFFSET;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type type;

  /**
   * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultValue()
   * @generated
   * @ordered
   */
  protected ContractValue defaultValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContractImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FactoryComponentPackage.Literals.CONTRACT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContractMode getMode() {
    return MODE_EFLAG_VALUES[(eFlags & MODE_EFLAG) >>> MODE_EFLAG_OFFSET];
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMode(ContractMode newMode) {
    ContractMode oldMode = MODE_EFLAG_VALUES[(eFlags & MODE_EFLAG) >>> MODE_EFLAG_OFFSET];
    if (newMode == null)
      newMode = MODE_EDEFAULT;
    eFlags = eFlags & ~MODE_EFLAG | newMode.ordinal() << MODE_EFLAG_OFFSET;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FactoryComponentPackage.CONTRACT__MODE, oldMode, newMode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getType() {
    if (type != null && type.eIsProxy()) {
      InternalEObject oldType = (InternalEObject) type;
      type = (Type) eResolveProxy(oldType);
      if (type != oldType) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FactoryComponentPackage.CONTRACT__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type basicGetType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(Type newType) {
    Type oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FactoryComponentPackage.CONTRACT__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContractValue getDefaultValue() {
    return defaultValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDefaultValue(ContractValue newDefaultValue, NotificationChain msgs) {
    ContractValue oldDefaultValue = defaultValue;
    defaultValue = newDefaultValue;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FactoryComponentPackage.CONTRACT__DEFAULT_VALUE,
          oldDefaultValue, newDefaultValue);
      if (msgs == null)
        msgs = notification;
      else
        msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultValue(ContractValue newDefaultValue) {
    if (newDefaultValue != defaultValue) {
      NotificationChain msgs = null;
      if (defaultValue != null)
        msgs = ((InternalEObject) defaultValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
            - FactoryComponentPackage.CONTRACT__DEFAULT_VALUE, null, msgs);
      if (newDefaultValue != null)
        msgs = ((InternalEObject) newDefaultValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
            - FactoryComponentPackage.CONTRACT__DEFAULT_VALUE, null, msgs);
      msgs = basicSetDefaultValue(newDefaultValue, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FactoryComponentPackage.CONTRACT__DEFAULT_VALUE, newDefaultValue,
          newDefaultValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FactoryComponentPackage.CONTRACT__DEFAULT_VALUE:
      return basicSetDefaultValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FactoryComponentPackage.CONTRACT__MODE:
      return getMode();
    case FactoryComponentPackage.CONTRACT__TYPE:
      if (resolve)
        return getType();
      return basicGetType();
    case FactoryComponentPackage.CONTRACT__DEFAULT_VALUE:
      return getDefaultValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FactoryComponentPackage.CONTRACT__MODE:
      setMode((ContractMode) newValue);
      return;
    case FactoryComponentPackage.CONTRACT__TYPE:
      setType((Type) newValue);
      return;
    case FactoryComponentPackage.CONTRACT__DEFAULT_VALUE:
      setDefaultValue((ContractValue) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case FactoryComponentPackage.CONTRACT__MODE:
      setMode(MODE_EDEFAULT);
      return;
    case FactoryComponentPackage.CONTRACT__TYPE:
      setType((Type) null);
      return;
    case FactoryComponentPackage.CONTRACT__DEFAULT_VALUE:
      setDefaultValue((ContractValue) null);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FactoryComponentPackage.CONTRACT__MODE:
      return (eFlags & MODE_EFLAG) != MODE_EFLAG_DEFAULT;
    case FactoryComponentPackage.CONTRACT__TYPE:
      return type != null;
    case FactoryComponentPackage.CONTRACT__DEFAULT_VALUE:
      return defaultValue != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (mode: "); //$NON-NLS-1$
    result.append(MODE_EFLAG_VALUES[(eFlags & MODE_EFLAG) >>> MODE_EFLAG_OFFSET]);
    result.append(')');
    return result.toString();
  }

} //ContractImpl
