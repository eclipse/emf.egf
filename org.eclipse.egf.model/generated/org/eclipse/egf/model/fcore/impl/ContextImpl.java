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

import org.eclipse.egf.model.fcore.Context;
import org.eclipse.egf.model.fcore.ContextContainer;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ContextImpl#getContextContainer <em>Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ContextImpl#getContract <em>Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ContextImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextImpl extends ModelElementImpl implements Context {
  /**
   * The cached value of the '{@link #getContract() <em>Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContract()
   * @generated
   * @ordered
   */
  protected Contract contract;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type<?> type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContextImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.CONTEXT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextContainer getContextContainer() {
    if (eContainerFeatureID() != FcorePackage.CONTEXT__CONTEXT_CONTAINER)
      return null;
    return (ContextContainer) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContextContainer(ContextContainer newContextContainer, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newContextContainer, FcorePackage.CONTEXT__CONTEXT_CONTAINER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContextContainer(ContextContainer newContextContainer) {
    if (newContextContainer != eInternalContainer() || (eContainerFeatureID() != FcorePackage.CONTEXT__CONTEXT_CONTAINER && newContextContainer != null)) {
      if (EcoreUtil.isAncestor(this, newContextContainer))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newContextContainer != null)
        msgs = ((InternalEObject) newContextContainer).eInverseAdd(this, FcorePackage.CONTEXT_CONTAINER__CONTEXTS, ContextContainer.class, msgs);
      msgs = basicSetContextContainer(newContextContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.CONTEXT__CONTEXT_CONTAINER, newContextContainer, newContextContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public Contract getContract() {
    if (contract != null && contract.eIsProxy()) {
      InternalEObject oldContract = (InternalEObject) contract;
      contract = (Contract) eResolveProxy(oldContract);
      if (contract != oldContract) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FcorePackage.CONTEXT__CONTRACT, oldContract, contract));
      }
    }
    return contract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contract basicGetContract() {
    return contract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContract(Contract newContract) {
    Contract oldContract = contract;
    contract = newContract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.CONTEXT__CONTRACT, oldContract, contract));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type<?> getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(Type<?> newType, NotificationChain msgs) {
    Type<?> oldType = type;
    type = newType;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.CONTEXT__TYPE, oldType, newType);
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
  public void setType(Type<?> newType) {
    if (newType != type) {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject) type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FcorePackage.CONTEXT__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject) newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FcorePackage.CONTEXT__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.CONTEXT__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FcorePackage.CONTEXT__CONTEXT_CONTAINER:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetContextContainer((ContextContainer) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FcorePackage.CONTEXT__CONTEXT_CONTAINER:
      return basicSetContextContainer(null, msgs);
    case FcorePackage.CONTEXT__TYPE:
      return basicSetType(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
    case FcorePackage.CONTEXT__CONTEXT_CONTAINER:
      return eInternalContainer().eInverseRemove(this, FcorePackage.CONTEXT_CONTAINER__CONTEXTS, ContextContainer.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FcorePackage.CONTEXT__CONTEXT_CONTAINER:
      return getContextContainer();
    case FcorePackage.CONTEXT__CONTRACT:
      if (resolve)
        return getContract();
      return basicGetContract();
    case FcorePackage.CONTEXT__TYPE:
      return getType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FcorePackage.CONTEXT__CONTEXT_CONTAINER:
      setContextContainer((ContextContainer) newValue);
      return;
    case FcorePackage.CONTEXT__CONTRACT:
      setContract((Contract) newValue);
      return;
    case FcorePackage.CONTEXT__TYPE:
      setType((Type<?>) newValue);
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
    case FcorePackage.CONTEXT__CONTEXT_CONTAINER:
      setContextContainer((ContextContainer) null);
      return;
    case FcorePackage.CONTEXT__CONTRACT:
      setContract((Contract) null);
      return;
    case FcorePackage.CONTEXT__TYPE:
      setType((Type<?>) null);
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
    case FcorePackage.CONTEXT__CONTEXT_CONTAINER:
      return getContextContainer() != null;
    case FcorePackage.CONTEXT__CONTRACT:
      return contract != null;
    case FcorePackage.CONTEXT__TYPE:
      return type != null;
    }
    return super.eIsSet(featureID);
  }

} // ContextImpl
