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

import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.InvocationContextConnector;
import org.eclipse.egf.model.fcore.InvocationContextContainer;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation Context Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContextContainerImpl#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContextContainerImpl#getInvocationContexts <em>Invocation Contexts</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.InvocationContextContainerImpl#getInvocationContextConnectors <em>Invocation Context Connectors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvocationContextContainerImpl extends ModelElementImpl implements InvocationContextContainer {
  /**
   * The cached value of the '{@link #getInvocationContexts() <em>Invocation Contexts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvocationContexts()
   * @generated
   * @ordered
   */
  protected EList<InvocationContext> invocationContexts;

  /**
   * The cached value of the '{@link #getInvocationContextConnectors() <em>Invocation Context Connectors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvocationContextConnectors()
   * @generated
   * @ordered
   */
  protected EList<InvocationContextConnector> invocationContextConnectors;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InvocationContextContainerImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.INVOCATION_CONTEXT_CONTAINER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Invocation<?> getInvocation() {
    if (eContainerFeatureID() != FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION)
      return null;
    return (Invocation<?>) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInvocation(Invocation<?> newInvocation, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newInvocation, FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInvocation(Invocation<?> newInvocation) {
    if (newInvocation != eInternalContainer() || (eContainerFeatureID() != FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION && newInvocation != null)) {
      if (EcoreUtil.isAncestor(this, newInvocation))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newInvocation != null)
        msgs = ((InternalEObject) newInvocation).eInverseAdd(this, FcorePackage.INVOCATION__INVOCATION_CONTEXT_CONTAINER, Invocation.class, msgs);
      msgs = basicSetInvocation(newInvocation, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION, newInvocation, newInvocation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InvocationContext> getInvocationContexts() {
    if (invocationContexts == null) {
      invocationContexts = new EObjectContainmentWithInverseEList<InvocationContext>(InvocationContext.class, this, FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXTS, FcorePackage.INVOCATION_CONTEXT__INVOCATION_CONTEXT_CONTAINER);
    }
    return invocationContexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InvocationContextConnector> getInvocationContextConnectors() {
    if (invocationContextConnectors == null) {
      invocationContextConnectors = new EObjectContainmentWithInverseEList<InvocationContextConnector>(InvocationContextConnector.class, this, FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXT_CONNECTORS, FcorePackage.INVOCATION_CONTEXT_CONNECTOR__INVOCATION_CONTEXT_CONTAINER);
    }
    return invocationContextConnectors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public FactoryComponent getFactoryComponent() {
    if (getInvocation() != null) {
      return getInvocation().getFactoryComponent();
    }
    return null;
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
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetInvocation((Invocation<?>) otherEnd, msgs);
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXTS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getInvocationContexts()).basicAdd(otherEnd, msgs);
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXT_CONNECTORS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getInvocationContextConnectors()).basicAdd(otherEnd, msgs);
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
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION:
      return basicSetInvocation(null, msgs);
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXTS:
      return ((InternalEList<?>) getInvocationContexts()).basicRemove(otherEnd, msgs);
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXT_CONNECTORS:
      return ((InternalEList<?>) getInvocationContextConnectors()).basicRemove(otherEnd, msgs);
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
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION:
      return eInternalContainer().eInverseRemove(this, FcorePackage.INVOCATION__INVOCATION_CONTEXT_CONTAINER, Invocation.class, msgs);
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
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION:
      return getInvocation();
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXTS:
      return getInvocationContexts();
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXT_CONNECTORS:
      return getInvocationContextConnectors();
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
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION:
      setInvocation((Invocation<?>) newValue);
      return;
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXTS:
      getInvocationContexts().clear();
      getInvocationContexts().addAll((Collection<? extends InvocationContext>) newValue);
      return;
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXT_CONNECTORS:
      getInvocationContextConnectors().clear();
      getInvocationContextConnectors().addAll((Collection<? extends InvocationContextConnector>) newValue);
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
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION:
      setInvocation((Invocation<?>) null);
      return;
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXTS:
      getInvocationContexts().clear();
      return;
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXT_CONNECTORS:
      getInvocationContextConnectors().clear();
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
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION:
      return getInvocation() != null;
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXTS:
      return invocationContexts != null && !invocationContexts.isEmpty();
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER__INVOCATION_CONTEXT_CONNECTORS:
      return invocationContextConnectors != null && !invocationContextConnectors.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // InvocationContextContainerImpl
