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

import org.eclipse.egf.model.fcore.Context;
import org.eclipse.egf.model.fcore.ContextContainer;
import org.eclipse.egf.model.fcore.ContractConnector;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ContextContainerImpl#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ContextContainerImpl#getContexts <em>Contexts</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.ContextContainerImpl#getConnectors <em>Connectors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextContainerImpl extends ModelElementImpl implements ContextContainer {
  /**
   * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContexts()
   * @generated
   * @ordered
   */
  protected EList<Context> contexts;

  /**
   * The cached value of the '{@link #getConnectors() <em>Connectors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnectors()
   * @generated
   * @ordered
   */
  protected EList<ContractConnector> connectors;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContextContainerImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.CONTEXT_CONTAINER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Invocation getInvocation() {
    if (eContainerFeatureID() != FcorePackage.CONTEXT_CONTAINER__INVOCATION)
      return null;
    return (Invocation) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInvocation(Invocation newInvocation, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newInvocation, FcorePackage.CONTEXT_CONTAINER__INVOCATION, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInvocation(Invocation newInvocation) {
    if (newInvocation != eInternalContainer() || (eContainerFeatureID() != FcorePackage.CONTEXT_CONTAINER__INVOCATION && newInvocation != null)) {
      if (EcoreUtil.isAncestor(this, newInvocation))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newInvocation != null)
        msgs = ((InternalEObject) newInvocation).eInverseAdd(this, FcorePackage.INVOCATION__CONTEXT, Invocation.class, msgs);
      msgs = basicSetInvocation(newInvocation, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.CONTEXT_CONTAINER__INVOCATION, newInvocation, newInvocation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Context> getContexts() {
    if (contexts == null) {
      contexts = new EObjectContainmentEList<Context>(Context.class, this, FcorePackage.CONTEXT_CONTAINER__CONTEXTS);
    }
    return contexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ContractConnector> getConnectors() {
    if (connectors == null) {
      connectors = new EObjectContainmentWithInverseEList<ContractConnector>(ContractConnector.class, this, FcorePackage.CONTEXT_CONTAINER__CONNECTORS, FcorePackage.CONTRACT_CONNECTOR__CONTEXT);
    }
    return connectors;
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
    case FcorePackage.CONTEXT_CONTAINER__INVOCATION:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetInvocation((Invocation) otherEnd, msgs);
    case FcorePackage.CONTEXT_CONTAINER__CONNECTORS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getConnectors()).basicAdd(otherEnd, msgs);
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
    case FcorePackage.CONTEXT_CONTAINER__INVOCATION:
      return basicSetInvocation(null, msgs);
    case FcorePackage.CONTEXT_CONTAINER__CONTEXTS:
      return ((InternalEList<?>) getContexts()).basicRemove(otherEnd, msgs);
    case FcorePackage.CONTEXT_CONTAINER__CONNECTORS:
      return ((InternalEList<?>) getConnectors()).basicRemove(otherEnd, msgs);
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
    case FcorePackage.CONTEXT_CONTAINER__INVOCATION:
      return eInternalContainer().eInverseRemove(this, FcorePackage.INVOCATION__CONTEXT, Invocation.class, msgs);
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
    case FcorePackage.CONTEXT_CONTAINER__INVOCATION:
      return getInvocation();
    case FcorePackage.CONTEXT_CONTAINER__CONTEXTS:
      return getContexts();
    case FcorePackage.CONTEXT_CONTAINER__CONNECTORS:
      return getConnectors();
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
    case FcorePackage.CONTEXT_CONTAINER__INVOCATION:
      setInvocation((Invocation) newValue);
      return;
    case FcorePackage.CONTEXT_CONTAINER__CONTEXTS:
      getContexts().clear();
      getContexts().addAll((Collection<? extends Context>) newValue);
      return;
    case FcorePackage.CONTEXT_CONTAINER__CONNECTORS:
      getConnectors().clear();
      getConnectors().addAll((Collection<? extends ContractConnector>) newValue);
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
    case FcorePackage.CONTEXT_CONTAINER__INVOCATION:
      setInvocation((Invocation) null);
      return;
    case FcorePackage.CONTEXT_CONTAINER__CONTEXTS:
      getContexts().clear();
      return;
    case FcorePackage.CONTEXT_CONTAINER__CONNECTORS:
      getConnectors().clear();
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
    case FcorePackage.CONTEXT_CONTAINER__INVOCATION:
      return getInvocation() != null;
    case FcorePackage.CONTEXT_CONTAINER__CONTEXTS:
      return contexts != null && !contexts.isEmpty();
    case FcorePackage.CONTEXT_CONTAINER__CONNECTORS:
      return connectors != null && !connectors.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ContextContainerImpl
