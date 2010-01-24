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

import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationImpl#getInvocationContractContainer <em>Invocation Contract Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationImpl#getInvokedActivity <em>Invoked Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InvocationImpl extends ModelElementImpl implements Invocation {
  /**
   * The cached value of the '{@link #getInvocationContractContainer() <em>Invocation Contract Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvocationContractContainer()
   * @generated
   * @ordered
   */
  protected InvocationContractContainer invocationContractContainer;

  /**
   * The cached value of the '{@link #getInvokedActivity() <em>Invoked Activity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvokedActivity()
   * @generated
   * @ordered
   */
  protected Activity invokedActivity;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InvocationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.INVOCATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContractContainer getInvocationContractContainer() {
    return invocationContractContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInvocationContractContainer(InvocationContractContainer newInvocationContractContainer, NotificationChain msgs) {
    InvocationContractContainer oldInvocationContractContainer = invocationContractContainer;
    invocationContractContainer = newInvocationContractContainer;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION__INVOCATION_CONTRACT_CONTAINER, oldInvocationContractContainer, newInvocationContractContainer);
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
  public void setInvocationContractContainer(InvocationContractContainer newInvocationContractContainer) {
    if (newInvocationContractContainer != invocationContractContainer) {
      NotificationChain msgs = null;
      if (invocationContractContainer != null)
        msgs = ((InternalEObject) invocationContractContainer).eInverseRemove(this, FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION, InvocationContractContainer.class, msgs);
      if (newInvocationContractContainer != null)
        msgs = ((InternalEObject) newInvocationContractContainer).eInverseAdd(this, FcorePackage.INVOCATION_CONTRACT_CONTAINER__INVOCATION, InvocationContractContainer.class, msgs);
      msgs = basicSetInvocationContractContainer(newInvocationContractContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION__INVOCATION_CONTRACT_CONTAINER, newInvocationContractContainer, newInvocationContractContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activity getInvokedActivity() {
    if (invokedActivity != null && invokedActivity.eIsProxy()) {
      InternalEObject oldInvokedActivity = (InternalEObject) invokedActivity;
      invokedActivity = (Activity) eResolveProxy(oldInvokedActivity);
      if (invokedActivity != oldInvokedActivity) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FcorePackage.INVOCATION__INVOKED_ACTIVITY, oldInvokedActivity, invokedActivity));
      }
    }
    return invokedActivity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activity basicGetInvokedActivity() {
    return invokedActivity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInvokedActivity(Activity newInvokedActivity) {
    Activity oldInvokedActivity = invokedActivity;
    invokedActivity = newInvokedActivity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION__INVOKED_ACTIVITY, oldInvokedActivity, invokedActivity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponent getFactoryComponent() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<Contract> getInvokedContracts() {
    EList<Contract> contracts = new UniqueEList<Contract>();
    if (getInvocationContractContainer() != null && getInvocationContractContainer().getInvocationContracts() != null) {
      for (InvocationContract invocationContract : getInvocationContractContainer().getInvocationContracts()) {
        if (invocationContract.getInvokedContract() != null) {
          contracts.add(invocationContract.getInvokedContract());
        }
      }
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<Contract> getInvokedContracts(Type type) {
    EList<Contract> contracts = new UniqueEList<Contract>();
    if (type != null) {
      for (Contract contract : getInvokedContracts()) {
        if (contract.getType() != null && ClassHelper.asSubClass(type.getType(), contract.getType().getType())) {
          contracts.add(contract);
        }
      }
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<Contract> getInvokedContracts(ContractMode mode) {
    EList<Contract> contracts = new UniqueEList<Contract>();
    if (mode != null) {
      for (Contract contract : getInvokedContracts()) {
        if (mode == ContractMode.IN && (contract.getMode() == ContractMode.IN || contract.getMode() == ContractMode.IN_OUT)) {
          contracts.add(contract);
        } else if (mode == ContractMode.OUT && (contract.getMode() == ContractMode.OUT || contract.getMode() == ContractMode.IN_OUT)) {
          contracts.add(contract);
        } else if (mode == ContractMode.IN_OUT) {
          contracts.add(contract);
        }
      }
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<Contract> getInvokedContracts(Type type, ContractMode mode) {
    EList<Contract> contracts = new UniqueEList<Contract>();
    for (Contract contract : getInvokedContracts(type)) {
      if (mode == ContractMode.IN && (contract.getMode() == ContractMode.IN || contract.getMode() == ContractMode.IN_OUT)) {
        contracts.add(contract);
      } else if (mode == ContractMode.OUT && (contract.getMode() == ContractMode.OUT || contract.getMode() == ContractMode.IN_OUT)) {
        contracts.add(contract);
      } else if (mode == ContractMode.IN_OUT) {
        contracts.add(contract);
      }
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<InvocationContract> getInvocationContracts() {
    EList<InvocationContract> invocationContracts = new UniqueEList<InvocationContract>();
    if (getInvocationContractContainer() != null && getInvocationContractContainer().getInvocationContracts() != null) {
      invocationContracts.addAll(getInvocationContractContainer().getInvocationContracts());
    }
    return invocationContracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<InvocationContract> getInvocationContracts(Type innerType) {
    EList<InvocationContract> invocationContracts = new UniqueEList<InvocationContract>();
    if (innerType != null) {
      for (InvocationContract innerInvocationContract : getInvocationContracts()) {
        // Nothing to analyse
        if (innerInvocationContract.getInvokedContract() == null || innerInvocationContract.getInvokedContract().getType() == null) {
          continue;
        }
        // Local type definition if available
        Type type = innerInvocationContract.getType();
        if (type == null) {
          // Otherwise invoked contract type
          type = innerInvocationContract.getInvokedContract().getType();
        }
        if (ClassHelper.asSubClass(innerType.getType(), type.getType())) {
          invocationContracts.add(innerInvocationContract);
        }
      }
    }
    return invocationContracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<InvocationContract> getInvocationContracts(ContractMode mode) {
    EList<InvocationContract> invocationContracts = new UniqueEList<InvocationContract>();
    if (mode != null) {
      for (InvocationContract innerInvocationContract : getInvocationContracts()) {
        if (mode == ContractMode.IN && (innerInvocationContract.getInvokedMode() == ContractMode.IN || innerInvocationContract.getInvokedMode() == ContractMode.IN_OUT)) {
          invocationContracts.add(innerInvocationContract);
        } else if (mode == ContractMode.OUT && (innerInvocationContract.getInvokedMode() == ContractMode.OUT || innerInvocationContract.getInvokedMode() == ContractMode.IN_OUT)) {
          invocationContracts.add(innerInvocationContract);
        } else if (mode == ContractMode.IN_OUT) {
          invocationContracts.add(innerInvocationContract);
        }
      }
    }
    return invocationContracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<InvocationContract> getInvocationContracts(Type type, ContractMode mode) {
    EList<InvocationContract> invocationContracts = new UniqueEList<InvocationContract>();
    for (InvocationContract innerInvocationContract : getInvocationContracts(type)) {
      if (mode == ContractMode.IN && (innerInvocationContract.getInvokedMode() == ContractMode.IN || innerInvocationContract.getInvokedMode() == ContractMode.IN_OUT)) {
        invocationContracts.add(innerInvocationContract);
      } else if (mode == ContractMode.OUT && (innerInvocationContract.getInvokedMode() == ContractMode.OUT || innerInvocationContract.getInvokedMode() == ContractMode.IN_OUT)) {
        invocationContracts.add(innerInvocationContract);
      } else if (mode == ContractMode.IN_OUT) {
        invocationContracts.add(innerInvocationContract);
      }
    }
    return invocationContracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FcorePackage.INVOCATION__INVOCATION_CONTRACT_CONTAINER:
      if (invocationContractContainer != null)
        msgs = ((InternalEObject) invocationContractContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FcorePackage.INVOCATION__INVOCATION_CONTRACT_CONTAINER, null, msgs);
      return basicSetInvocationContractContainer((InvocationContractContainer) otherEnd, msgs);
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
    case FcorePackage.INVOCATION__INVOCATION_CONTRACT_CONTAINER:
      return basicSetInvocationContractContainer(null, msgs);
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
    case FcorePackage.INVOCATION__INVOCATION_CONTRACT_CONTAINER:
      return getInvocationContractContainer();
    case FcorePackage.INVOCATION__INVOKED_ACTIVITY:
      if (resolve)
        return getInvokedActivity();
      return basicGetInvokedActivity();
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
    case FcorePackage.INVOCATION__INVOCATION_CONTRACT_CONTAINER:
      setInvocationContractContainer((InvocationContractContainer) newValue);
      return;
    case FcorePackage.INVOCATION__INVOKED_ACTIVITY:
      setInvokedActivity((Activity) newValue);
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
    case FcorePackage.INVOCATION__INVOCATION_CONTRACT_CONTAINER:
      setInvocationContractContainer((InvocationContractContainer) null);
      return;
    case FcorePackage.INVOCATION__INVOKED_ACTIVITY:
      setInvokedActivity((Activity) null);
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
    case FcorePackage.INVOCATION__INVOCATION_CONTRACT_CONTAINER:
      return invocationContractContainer != null;
    case FcorePackage.INVOCATION__INVOKED_ACTIVITY:
      return invokedActivity != null;
    }
    return super.eIsSet(featureID);
  }

} // InvocationImpl
