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

import java.util.Collection;

import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FactoryComponentContractContainer;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Factory Component Contract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.FactoryComponentContractImpl#getInvocationContexts <em>Invocation Contexts</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.FactoryComponentContractImpl#getActivityContractContainer <em>Activity Contract Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FactoryComponentContractImpl extends ActivityContractImpl implements FactoryComponentContract {
  /**
   * The cached value of the '{@link #getInvocationContexts() <em>Invocation Contexts</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvocationContexts()
   * @generated
   * @ordered
   */
  protected EList<InvocationContext> invocationContexts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FactoryComponentContractImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.FACTORY_COMPONENT_CONTRACT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InvocationContext> getInvocationContexts() {
    if (invocationContexts == null) {
      invocationContexts = new EObjectWithInverseEList<InvocationContext>(InvocationContext.class, this, FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTEXTS, FcorePackage.INVOCATION_CONTEXT__FACTORY_COMPONENT_EXPOSED_CONTRACT);
    }
    return invocationContexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public FactoryComponent getActivity() {
    if (getActivityContractContainer() != null) {
      return getActivityContractContainer().getActivity();
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FactoryComponentContractContainer getActivityContractContainer() {
    if (eContainerFeatureID() != FcorePackage.FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER)
      return null;
    return (FactoryComponentContractContainer) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetActivityContractContainer(FactoryComponentContractContainer newActivityContractContainer, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newActivityContractContainer, FcorePackage.FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivityContractContainer(FactoryComponentContractContainer newActivityContractContainer) {
    if (newActivityContractContainer != eInternalContainer() || (eContainerFeatureID() != FcorePackage.FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER && newActivityContractContainer != null)) {
      if (EcoreUtil.isAncestor(this, newActivityContractContainer))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newActivityContractContainer != null)
        msgs = ((InternalEObject) newActivityContractContainer).eInverseAdd(this, FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS, FactoryComponentContractContainer.class, msgs);
      msgs = basicSetActivityContractContainer(newActivityContractContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER, newActivityContractContainer, newActivityContractContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @SuppressWarnings("unchecked")
  @Override
  public EList<FactoryComponentContract> getActivityContracts() {
    EList<FactoryComponentContract> contracts = new UniqueEList<FactoryComponentContract>();
    if (getActivityContractContainer() != null) {
      return getActivityContractContainer().getActivityContracts();
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public EList<ActivityContract> getActivityContracts(Type<?> innerType) {
    EList<ActivityContract> contracts = new UniqueEList<ActivityContract>();
    if (getActivityContractContainer() != null) {
      return getActivityContractContainer().getActivityContracts(innerType);
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public EList<ActivityContract> getActivityContracts(ContractMode mode) {
    EList<ActivityContract> contracts = new UniqueEList<ActivityContract>();
    if (getActivityContractContainer() != null) {
      return getActivityContractContainer().getActivityContracts(mode);
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public EList<ActivityContract> getActivityContracts(Type<?> innerType, ContractMode mode) {
    EList<ActivityContract> contracts = new UniqueEList<ActivityContract>();
    if (getActivityContractContainer() != null) {
      return getActivityContractContainer().getActivityContracts(innerType, mode);
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTEXTS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getInvocationContexts()).basicAdd(otherEnd, msgs);
    case FcorePackage.FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetActivityContractContainer((FactoryComponentContractContainer) otherEnd, msgs);
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
    case FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTEXTS:
      return ((InternalEList<?>) getInvocationContexts()).basicRemove(otherEnd, msgs);
    case FcorePackage.FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      return basicSetActivityContractContainer(null, msgs);
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
    case FcorePackage.FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      return eInternalContainer().eInverseRemove(this, FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER__ACTIVITY_CONTRACTS, FactoryComponentContractContainer.class, msgs);
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
    case FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTEXTS:
      return getInvocationContexts();
    case FcorePackage.FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      return getActivityContractContainer();
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
    case FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTEXTS:
      getInvocationContexts().clear();
      getInvocationContexts().addAll((Collection<? extends InvocationContext>) newValue);
      return;
    case FcorePackage.FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      setActivityContractContainer((FactoryComponentContractContainer) newValue);
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
    case FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTEXTS:
      getInvocationContexts().clear();
      return;
    case FcorePackage.FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      setActivityContractContainer((FactoryComponentContractContainer) null);
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
    case FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTEXTS:
      return invocationContexts != null && !invocationContexts.isEmpty();
    case FcorePackage.FACTORY_COMPONENT_CONTRACT__ACTIVITY_CONTRACT_CONTAINER:
      return getActivityContractContainer() != null;
    }
    return super.eIsSet(featureID);
  }

} // FactoryComponentContractImpl
