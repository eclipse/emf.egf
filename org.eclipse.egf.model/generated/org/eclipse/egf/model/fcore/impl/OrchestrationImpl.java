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
import org.eclipse.egf.model.fcore.Orchestration;
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
 * An implementation of the model object '<em><b>Orchestration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationImpl#getFactoryComponent <em>Factory Component</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationImpl#getInvocations <em>Invocations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OrchestrationImpl extends ModelElementImpl implements Orchestration {
  /**
   * The cached value of the '{@link #getInvocations() <em>Invocations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvocations()
   * @generated
   * @ordered
   */
  protected EList<Invocation<?>> invocations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OrchestrationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.ORCHESTRATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponent getFactoryComponent() {
    if (eContainerFeatureID() != FcorePackage.ORCHESTRATION__FACTORY_COMPONENT)
      return null;
    return (FactoryComponent) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFactoryComponent(FactoryComponent newFactoryComponent, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newFactoryComponent, FcorePackage.ORCHESTRATION__FACTORY_COMPONENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFactoryComponent(FactoryComponent newFactoryComponent) {
    if (newFactoryComponent != eInternalContainer() || (eContainerFeatureID() != FcorePackage.ORCHESTRATION__FACTORY_COMPONENT && newFactoryComponent != null)) {
      if (EcoreUtil.isAncestor(this, newFactoryComponent))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newFactoryComponent != null)
        msgs = ((InternalEObject) newFactoryComponent).eInverseAdd(this, FcorePackage.FACTORY_COMPONENT__ORCHESTRATION, FactoryComponent.class, msgs);
      msgs = basicSetFactoryComponent(newFactoryComponent, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.ORCHESTRATION__FACTORY_COMPONENT, newFactoryComponent, newFactoryComponent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Invocation<?>> getInvocations() {
    if (invocations == null) {
      invocations = new EObjectContainmentWithInverseEList<Invocation<?>>(Invocation.class, this, FcorePackage.ORCHESTRATION__INVOCATIONS, FcorePackage.INVOCATION__ORCHESTRATION);
    }
    return invocations;
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
    case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetFactoryComponent((FactoryComponent) otherEnd, msgs);
    case FcorePackage.ORCHESTRATION__INVOCATIONS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getInvocations()).basicAdd(otherEnd, msgs);
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
    case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
      return basicSetFactoryComponent(null, msgs);
    case FcorePackage.ORCHESTRATION__INVOCATIONS:
      return ((InternalEList<?>) getInvocations()).basicRemove(otherEnd, msgs);
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
    case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
      return eInternalContainer().eInverseRemove(this, FcorePackage.FACTORY_COMPONENT__ORCHESTRATION, FactoryComponent.class, msgs);
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
    case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
      return getFactoryComponent();
    case FcorePackage.ORCHESTRATION__INVOCATIONS:
      return getInvocations();
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
    case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
      setFactoryComponent((FactoryComponent) newValue);
      return;
    case FcorePackage.ORCHESTRATION__INVOCATIONS:
      getInvocations().clear();
      getInvocations().addAll((Collection<? extends Invocation<?>>) newValue);
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
    case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
      setFactoryComponent((FactoryComponent) null);
      return;
    case FcorePackage.ORCHESTRATION__INVOCATIONS:
      getInvocations().clear();
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
    case FcorePackage.ORCHESTRATION__FACTORY_COMPONENT:
      return getFactoryComponent() != null;
    case FcorePackage.ORCHESTRATION__INVOCATIONS:
      return invocations != null && !invocations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // OrchestrationImpl
