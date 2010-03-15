/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fcore.OrchestrationParameterContainer;
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
 * An implementation of the model object '<em><b>Orchestration Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationParameterImpl#getOrchestrationParameterContainer <em>Orchestration Parameter Container</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationParameterImpl#getInvocationContracts <em>Invocation Contracts</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.impl.OrchestrationParameterImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrchestrationParameterImpl extends NamedModelElementImpl implements OrchestrationParameter {
  /**
   * The cached value of the '{@link #getInvocationContracts() <em>Invocation Contracts</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvocationContracts()
   * @generated
   * @ordered
   */
  protected EList<InvocationContract> invocationContracts;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OrchestrationParameterImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FcorePackage.Literals.ORCHESTRATION_PARAMETER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrchestrationParameterContainer getOrchestrationParameterContainer() {
    if (eContainerFeatureID() != FcorePackage.ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER)
      return null;
    return (OrchestrationParameterContainer) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOrchestrationParameterContainer(OrchestrationParameterContainer newOrchestrationParameterContainer, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newOrchestrationParameterContainer, FcorePackage.ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrchestrationParameterContainer(OrchestrationParameterContainer newOrchestrationParameterContainer) {
    if (newOrchestrationParameterContainer != eInternalContainer() || (eContainerFeatureID() != FcorePackage.ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER && newOrchestrationParameterContainer != null)) {
      if (EcoreUtil.isAncestor(this, newOrchestrationParameterContainer))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOrchestrationParameterContainer != null)
        msgs = ((InternalEObject) newOrchestrationParameterContainer).eInverseAdd(this, FcorePackage.ORCHESTRATION_PARAMETER_CONTAINER__ORCHESTRATION_PARAMETERS, OrchestrationParameterContainer.class, msgs);
      msgs = basicSetOrchestrationParameterContainer(newOrchestrationParameterContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER, newOrchestrationParameterContainer, newOrchestrationParameterContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InvocationContract> getInvocationContracts() {
    if (invocationContracts == null) {
      invocationContracts = new EObjectWithInverseEList<InvocationContract>(InvocationContract.class, this, FcorePackage.ORCHESTRATION_PARAMETER__INVOCATION_CONTRACTS, FcorePackage.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER);
    }
    return invocationContracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(Type newType, NotificationChain msgs) {
    Type oldType = type;
    type = newType;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FcorePackage.ORCHESTRATION_PARAMETER__TYPE, oldType, newType);
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
  public void setType(Type newType) {
    if (newType != type) {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject) type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FcorePackage.ORCHESTRATION_PARAMETER__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject) newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FcorePackage.ORCHESTRATION_PARAMETER__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FcorePackage.ORCHESTRATION_PARAMETER__TYPE, newType, newType));
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
  public Orchestration getOrchestration() {
    if (getOrchestrationParameterContainer() != null) {
      return getOrchestrationParameterContainer().getOrchestration();
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
    case FcorePackage.ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetOrchestrationParameterContainer((OrchestrationParameterContainer) otherEnd, msgs);
    case FcorePackage.ORCHESTRATION_PARAMETER__INVOCATION_CONTRACTS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getInvocationContracts()).basicAdd(otherEnd, msgs);
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
    case FcorePackage.ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER:
      return basicSetOrchestrationParameterContainer(null, msgs);
    case FcorePackage.ORCHESTRATION_PARAMETER__INVOCATION_CONTRACTS:
      return ((InternalEList<?>) getInvocationContracts()).basicRemove(otherEnd, msgs);
    case FcorePackage.ORCHESTRATION_PARAMETER__TYPE:
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
    case FcorePackage.ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER:
      return eInternalContainer().eInverseRemove(this, FcorePackage.ORCHESTRATION_PARAMETER_CONTAINER__ORCHESTRATION_PARAMETERS, OrchestrationParameterContainer.class, msgs);
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
    case FcorePackage.ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER:
      return getOrchestrationParameterContainer();
    case FcorePackage.ORCHESTRATION_PARAMETER__INVOCATION_CONTRACTS:
      return getInvocationContracts();
    case FcorePackage.ORCHESTRATION_PARAMETER__TYPE:
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
    case FcorePackage.ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER:
      setOrchestrationParameterContainer((OrchestrationParameterContainer) newValue);
      return;
    case FcorePackage.ORCHESTRATION_PARAMETER__INVOCATION_CONTRACTS:
      getInvocationContracts().clear();
      getInvocationContracts().addAll((Collection<? extends InvocationContract>) newValue);
      return;
    case FcorePackage.ORCHESTRATION_PARAMETER__TYPE:
      setType((Type) newValue);
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
    case FcorePackage.ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER:
      setOrchestrationParameterContainer((OrchestrationParameterContainer) null);
      return;
    case FcorePackage.ORCHESTRATION_PARAMETER__INVOCATION_CONTRACTS:
      getInvocationContracts().clear();
      return;
    case FcorePackage.ORCHESTRATION_PARAMETER__TYPE:
      setType((Type) null);
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
    case FcorePackage.ORCHESTRATION_PARAMETER__ORCHESTRATION_PARAMETER_CONTAINER:
      return getOrchestrationParameterContainer() != null;
    case FcorePackage.ORCHESTRATION_PARAMETER__INVOCATION_CONTRACTS:
      return invocationContracts != null && !invocationContracts.isEmpty();
    case FcorePackage.ORCHESTRATION_PARAMETER__TYPE:
      return type != null;
    }
    return super.eIsSet(featureID);
  }

} // OrchestrationParameterImpl
