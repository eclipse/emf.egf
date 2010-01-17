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

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationContext;
import org.eclipse.egf.model.fcore.OrchestrationContextContainer;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Orchestration Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationContextImpl#getOrchestrationContextContainer <em>Orchestration Context Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationContextImpl#getInvocationContexts <em>Invocation Contexts</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationContextImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrchestrationContextImpl extends ModelElementImpl implements OrchestrationContext {
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
  protected OrchestrationContextImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.ORCHESTRATION_CONTEXT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrchestrationContextContainer getOrchestrationContextContainer() {
    if (eContainerFeatureID() != FcorePackage.ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER)
      return null;
    return (OrchestrationContextContainer) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOrchestrationContextContainer(OrchestrationContextContainer newOrchestrationContextContainer, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newOrchestrationContextContainer, FcorePackage.ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrchestrationContextContainer(OrchestrationContextContainer newOrchestrationContextContainer) {
    if (newOrchestrationContextContainer != eInternalContainer() || (eContainerFeatureID() != FcorePackage.ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER && newOrchestrationContextContainer != null)) {
      if (EcoreUtil.isAncestor(this, newOrchestrationContextContainer))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOrchestrationContextContainer != null)
        msgs = ((InternalEObject) newOrchestrationContextContainer).eInverseAdd(this, FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION_CONTEXTS, OrchestrationContextContainer.class, msgs);
      msgs = basicSetOrchestrationContextContainer(newOrchestrationContextContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER, newOrchestrationContextContainer, newOrchestrationContextContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InvocationContext> getInvocationContexts() {
    if (invocationContexts == null) {
      invocationContexts = new EObjectWithInverseEList<InvocationContext>(InvocationContext.class, this, FcorePackage.ORCHESTRATION_CONTEXT__INVOCATION_CONTEXTS, FcorePackage.INVOCATION_CONTEXT__ORCHESTRATION_CONTEXT);
    }
    return invocationContexts;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.ORCHESTRATION_CONTEXT__TYPE, oldType, newType);
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
        msgs = ((InternalEObject) type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FcorePackage.ORCHESTRATION_CONTEXT__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject) newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FcorePackage.ORCHESTRATION_CONTEXT__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.ORCHESTRATION_CONTEXT__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Orchestration getOrchestration() {
    if (getOrchestrationContextContainer() != null) {
      return getOrchestrationContextContainer().getOrchestration();
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
    case FcorePackage.ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetOrchestrationContextContainer((OrchestrationContextContainer) otherEnd, msgs);
    case FcorePackage.ORCHESTRATION_CONTEXT__INVOCATION_CONTEXTS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getInvocationContexts()).basicAdd(otherEnd, msgs);
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
    case FcorePackage.ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER:
      return basicSetOrchestrationContextContainer(null, msgs);
    case FcorePackage.ORCHESTRATION_CONTEXT__INVOCATION_CONTEXTS:
      return ((InternalEList<?>) getInvocationContexts()).basicRemove(otherEnd, msgs);
    case FcorePackage.ORCHESTRATION_CONTEXT__TYPE:
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
    case FcorePackage.ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER:
      return eInternalContainer().eInverseRemove(this, FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION_CONTEXTS, OrchestrationContextContainer.class, msgs);
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
    case FcorePackage.ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER:
      return getOrchestrationContextContainer();
    case FcorePackage.ORCHESTRATION_CONTEXT__INVOCATION_CONTEXTS:
      return getInvocationContexts();
    case FcorePackage.ORCHESTRATION_CONTEXT__TYPE:
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
    case FcorePackage.ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER:
      setOrchestrationContextContainer((OrchestrationContextContainer) newValue);
      return;
    case FcorePackage.ORCHESTRATION_CONTEXT__INVOCATION_CONTEXTS:
      getInvocationContexts().clear();
      getInvocationContexts().addAll((Collection<? extends InvocationContext>) newValue);
      return;
    case FcorePackage.ORCHESTRATION_CONTEXT__TYPE:
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
    case FcorePackage.ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER:
      setOrchestrationContextContainer((OrchestrationContextContainer) null);
      return;
    case FcorePackage.ORCHESTRATION_CONTEXT__INVOCATION_CONTEXTS:
      getInvocationContexts().clear();
      return;
    case FcorePackage.ORCHESTRATION_CONTEXT__TYPE:
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
    case FcorePackage.ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER:
      return getOrchestrationContextContainer() != null;
    case FcorePackage.ORCHESTRATION_CONTEXT__INVOCATION_CONTEXTS:
      return invocationContexts != null && !invocationContexts.isEmpty();
    case FcorePackage.ORCHESTRATION_CONTEXT__TYPE:
      return type != null;
    }
    return super.eIsSet(featureID);
  }

} // OrchestrationContextImpl
