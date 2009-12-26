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
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.InvocationContextContainer;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationImpl#getOrchestration <em>Orchestration</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationImpl#getInvocationContextContainer <em>Invocation Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationImpl#getActivity <em>Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InvocationImpl<T extends Activity> extends ModelElementImpl implements Invocation<T> {
  /**
   * The cached value of the '{@link #getInvocationContextContainer() <em>Invocation Context Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvocationContextContainer()
   * @generated
   * @ordered
   */
  protected InvocationContextContainer invocationContextContainer;

  /**
   * The cached value of the '{@link #getActivity() <em>Activity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivity()
   * @generated
   * @ordered
   */
  protected T activity;

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
  public Orchestration getOrchestration() {
    if (eContainerFeatureID() != FcorePackage.INVOCATION__ORCHESTRATION)
      return null;
    return (Orchestration) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOrchestration(Orchestration newOrchestration, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newOrchestration, FcorePackage.INVOCATION__ORCHESTRATION, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrchestration(Orchestration newOrchestration) {
    if (newOrchestration != eInternalContainer() || (eContainerFeatureID() != FcorePackage.INVOCATION__ORCHESTRATION && newOrchestration != null)) {
      if (EcoreUtil.isAncestor(this, newOrchestration))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOrchestration != null)
        msgs = ((InternalEObject) newOrchestration).eInverseAdd(this, FcorePackage.ORCHESTRATION__INVOCATIONS, Orchestration.class, msgs);
      msgs = basicSetOrchestration(newOrchestration, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION__ORCHESTRATION, newOrchestration, newOrchestration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContextContainer getInvocationContextContainer() {
    return invocationContextContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInvocationContextContainer(InvocationContextContainer newInvocationContextContainer, NotificationChain msgs) {
    InvocationContextContainer oldInvocationContextContainer = invocationContextContainer;
    invocationContextContainer = newInvocationContextContainer;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION__INVOCATION_CONTEXT_CONTAINER, oldInvocationContextContainer, newInvocationContextContainer);
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
  public void setInvocationContextContainer(InvocationContextContainer newInvocationContextContainer) {
    if (newInvocationContextContainer != invocationContextContainer) {
      NotificationChain msgs = null;
      if (invocationContextContainer != null)
        msgs = ((InternalEObject) invocationContextContainer).eInverseRemove(this, FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION, InvocationContextContainer.class, msgs);
      if (newInvocationContextContainer != null)
        msgs = ((InternalEObject) newInvocationContextContainer).eInverseAdd(this, FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION, InvocationContextContainer.class, msgs);
      msgs = basicSetInvocationContextContainer(newInvocationContextContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION__INVOCATION_CONTEXT_CONTAINER, newInvocationContextContainer, newInvocationContextContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public T getActivity() {
    if (activity != null && activity.eIsProxy()) {
      InternalEObject oldActivity = (InternalEObject) activity;
      activity = (T) eResolveProxy(oldActivity);
      if (activity != oldActivity) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FcorePackage.INVOCATION__ACTIVITY, oldActivity, activity));
      }
    }
    return activity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public T basicGetActivity() {
    return activity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivity(T newActivity) {
    T oldActivity = activity;
    activity = newActivity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION__ACTIVITY, oldActivity, activity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public FactoryComponent getFactoryComponent() {
    if (getOrchestration() != null) {
      return getOrchestration().getFactoryComponent();
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<ActivityContract> getInvocationActivityContracts() {
    EList<ActivityContract> contracts = new UniqueEList<ActivityContract>();
    if (getInvocationContextContainer() != null && getInvocationContextContainer().getInvocationContexts() != null) {
      for (InvocationContext invocationContext : getInvocationContextContainer().getInvocationContexts()) {
        if (invocationContext.getActivityContract() != null) {
          contracts.add(invocationContext.getActivityContract());
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
  public EList<ActivityContract> getInvocationActivityContracts(Type<?> type) {
    EList<ActivityContract> contracts = new UniqueEList<ActivityContract>();
    if (type != null) {
      for (ActivityContract contract : getInvocationActivityContracts()) {
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
  public EList<ActivityContract> getInvocationActivityContracts(ContractMode mode) {
    EList<ActivityContract> contracts = new UniqueEList<ActivityContract>();
    if (mode != null) {
      for (ActivityContract contract : getInvocationActivityContracts()) {
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
  public EList<ActivityContract> getInvocationActivityContracts(Type<?> type, ContractMode mode) {
    EList<ActivityContract> contracts = new UniqueEList<ActivityContract>();
    for (ActivityContract contract : getInvocationActivityContracts(type)) {
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
  public EList<InvocationContext> getInvocationContexts() {
    EList<InvocationContext> invocationContexts = new UniqueEList<InvocationContext>();
    if (getInvocationContextContainer() != null && getInvocationContextContainer().getInvocationContexts() != null) {
      invocationContexts.addAll(getInvocationContextContainer().getInvocationContexts());
    }
    return invocationContexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @SuppressWarnings("unchecked")
  public EList<InvocationContext> getInvocationContexts(Type innerType) {
    EList<InvocationContext> invocationContexts = new UniqueEList<InvocationContext>();
    if (innerType != null) {
      for (InvocationContext innerInvocationContext : getInvocationContexts()) {
        if (innerInvocationContext.getActivityContract() != null && innerInvocationContext.getActivityContract().getType() != null && ClassHelper.asSubClass(innerType.getType(), innerInvocationContext.getActivityContract().getType().getType())) {
          invocationContexts.add(innerInvocationContext);
        }
      }
    }
    return invocationContexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<InvocationContext> getInvocationContexts(ContractMode mode) {
    EList<InvocationContext> invocationContexts = new UniqueEList<InvocationContext>();
    if (mode != null) {
      for (InvocationContext innerInvocationContext : getInvocationContexts()) {
        if (mode == ContractMode.IN && (innerInvocationContext.getMode() == ContractMode.IN || innerInvocationContext.getMode() == ContractMode.IN_OUT)) {
          invocationContexts.add(innerInvocationContext);
        } else if (mode == ContractMode.OUT && (innerInvocationContext.getMode() == ContractMode.OUT || innerInvocationContext.getMode() == ContractMode.IN_OUT)) {
          invocationContexts.add(innerInvocationContext);
        } else if (mode == ContractMode.IN_OUT) {
          invocationContexts.add(innerInvocationContext);
        }
      }
    }
    return invocationContexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @SuppressWarnings("unchecked")
  public EList<InvocationContext> getInvocationContexts(Type type, ContractMode mode) {
    EList<InvocationContext> invocationContexts = new UniqueEList<InvocationContext>();
    for (InvocationContext innerInvocationContext : getInvocationContexts(type)) {
      if (mode == ContractMode.IN && (innerInvocationContext.getMode() == ContractMode.IN || innerInvocationContext.getMode() == ContractMode.IN_OUT)) {
        invocationContexts.add(innerInvocationContext);
      } else if (mode == ContractMode.OUT && (innerInvocationContext.getMode() == ContractMode.OUT || innerInvocationContext.getMode() == ContractMode.IN_OUT)) {
        invocationContexts.add(innerInvocationContext);
      } else if (mode == ContractMode.IN_OUT) {
        invocationContexts.add(innerInvocationContext);
      }
    }
    return invocationContexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FcorePackage.INVOCATION__ORCHESTRATION:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetOrchestration((Orchestration) otherEnd, msgs);
    case FcorePackage.INVOCATION__INVOCATION_CONTEXT_CONTAINER:
      if (invocationContextContainer != null)
        msgs = ((InternalEObject) invocationContextContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FcorePackage.INVOCATION__INVOCATION_CONTEXT_CONTAINER, null, msgs);
      return basicSetInvocationContextContainer((InvocationContextContainer) otherEnd, msgs);
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
    case FcorePackage.INVOCATION__ORCHESTRATION:
      return basicSetOrchestration(null, msgs);
    case FcorePackage.INVOCATION__INVOCATION_CONTEXT_CONTAINER:
      return basicSetInvocationContextContainer(null, msgs);
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
    case FcorePackage.INVOCATION__ORCHESTRATION:
      return eInternalContainer().eInverseRemove(this, FcorePackage.ORCHESTRATION__INVOCATIONS, Orchestration.class, msgs);
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
    case FcorePackage.INVOCATION__ORCHESTRATION:
      return getOrchestration();
    case FcorePackage.INVOCATION__INVOCATION_CONTEXT_CONTAINER:
      return getInvocationContextContainer();
    case FcorePackage.INVOCATION__ACTIVITY:
      if (resolve)
        return getActivity();
      return basicGetActivity();
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
    case FcorePackage.INVOCATION__ORCHESTRATION:
      setOrchestration((Orchestration) newValue);
      return;
    case FcorePackage.INVOCATION__INVOCATION_CONTEXT_CONTAINER:
      setInvocationContextContainer((InvocationContextContainer) newValue);
      return;
    case FcorePackage.INVOCATION__ACTIVITY:
      setActivity((T) newValue);
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
    case FcorePackage.INVOCATION__ORCHESTRATION:
      setOrchestration((Orchestration) null);
      return;
    case FcorePackage.INVOCATION__INVOCATION_CONTEXT_CONTAINER:
      setInvocationContextContainer((InvocationContextContainer) null);
      return;
    case FcorePackage.INVOCATION__ACTIVITY:
      setActivity((T) null);
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
    case FcorePackage.INVOCATION__ORCHESTRATION:
      return getOrchestration() != null;
    case FcorePackage.INVOCATION__INVOCATION_CONTEXT_CONTAINER:
      return invocationContextContainer != null;
    case FcorePackage.INVOCATION__ACTIVITY:
      return activity != null;
    }
    return super.eIsSet(featureID);
  }

} // InvocationImpl
