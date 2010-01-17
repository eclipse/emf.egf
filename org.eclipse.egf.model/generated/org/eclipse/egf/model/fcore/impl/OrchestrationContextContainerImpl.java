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
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationContext;
import org.eclipse.egf.model.fcore.OrchestrationContextContainer;

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
 * An implementation of the model object '<em><b>Orchestration Context Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationContextContainerImpl#getOrchestration <em>Orchestration</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationContextContainerImpl#getOrchestrationContexts <em>Orchestration Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrchestrationContextContainerImpl extends ModelElementImpl implements OrchestrationContextContainer {
  /**
   * The cached value of the '{@link #getOrchestrationContexts() <em>Orchestration Contexts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrchestrationContexts()
   * @generated
   * @ordered
   */
  protected EList<OrchestrationContext> orchestrationContexts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OrchestrationContextContainerImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.ORCHESTRATION_CONTEXT_CONTAINER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Orchestration getOrchestration() {
    if (eContainerFeatureID() != FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION)
      return null;
    return (Orchestration) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOrchestration(Orchestration newOrchestration, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newOrchestration, FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrchestration(Orchestration newOrchestration) {
    if (newOrchestration != eInternalContainer() || (eContainerFeatureID() != FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION && newOrchestration != null)) {
      if (EcoreUtil.isAncestor(this, newOrchestration))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOrchestration != null)
        msgs = ((InternalEObject) newOrchestration).eInverseAdd(this, FcorePackage.ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER, Orchestration.class, msgs);
      msgs = basicSetOrchestration(newOrchestration, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION, newOrchestration, newOrchestration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OrchestrationContext> getOrchestrationContexts() {
    if (orchestrationContexts == null) {
      orchestrationContexts = new EObjectContainmentWithInverseEList<OrchestrationContext>(OrchestrationContext.class, this, FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION_CONTEXTS, FcorePackage.ORCHESTRATION_CONTEXT__ORCHESTRATION_CONTEXT_CONTAINER);
    }
    return orchestrationContexts;
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
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetOrchestration((Orchestration) otherEnd, msgs);
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION_CONTEXTS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getOrchestrationContexts()).basicAdd(otherEnd, msgs);
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
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION:
      return basicSetOrchestration(null, msgs);
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION_CONTEXTS:
      return ((InternalEList<?>) getOrchestrationContexts()).basicRemove(otherEnd, msgs);
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
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION:
      return eInternalContainer().eInverseRemove(this, FcorePackage.ORCHESTRATION__ORCHESTRATION_CONTEXT_CONTAINER, Orchestration.class, msgs);
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
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION:
      return getOrchestration();
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION_CONTEXTS:
      return getOrchestrationContexts();
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
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION:
      setOrchestration((Orchestration) newValue);
      return;
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION_CONTEXTS:
      getOrchestrationContexts().clear();
      getOrchestrationContexts().addAll((Collection<? extends OrchestrationContext>) newValue);
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
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION:
      setOrchestration((Orchestration) null);
      return;
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION_CONTEXTS:
      getOrchestrationContexts().clear();
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
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION:
      return getOrchestration() != null;
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER__ORCHESTRATION_CONTEXTS:
      return orchestrationContexts != null && !orchestrationContexts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //OrchestrationContextContainerImpl
