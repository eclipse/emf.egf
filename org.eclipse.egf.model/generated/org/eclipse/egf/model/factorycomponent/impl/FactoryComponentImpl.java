/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.factorycomponent.impl;

import java.util.Collection;

import org.eclipse.egf.model.factorycomponent.FactoryComponent;
import org.eclipse.egf.model.factorycomponent.FactoryComponentPackage;
import org.eclipse.egf.model.factorycomponent.Orchestration;
import org.eclipse.egf.model.factorycomponent.Viewpoint;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Factory Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.FactoryComponentImpl#getViewpoints <em>Viewpoints</em>}</li>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.FactoryComponentImpl#getOrchestration <em>Orchestration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FactoryComponentImpl extends ActivityImpl implements FactoryComponent {
  /**
   * The cached value of the '{@link #getViewpoints() <em>Viewpoints</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getViewpoints()
   * @generated
   * @ordered
   */
  protected EList<Viewpoint> viewpoints;

  /**
   * The cached value of the '{@link #getOrchestration() <em>Orchestration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrchestration()
   * @generated
   * @ordered
   */
  protected Orchestration orchestration;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FactoryComponentImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FactoryComponentPackage.Literals.FACTORY_COMPONENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Viewpoint> getViewpoints() {
    if (viewpoints == null) {
      viewpoints = new EObjectContainmentEList<Viewpoint>(Viewpoint.class, this, FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINTS);
    }
    return viewpoints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Orchestration getOrchestration() {
    return orchestration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOrchestration(Orchestration newOrchestration, NotificationChain msgs) {
    Orchestration oldOrchestration = orchestration;
    orchestration = newOrchestration;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
          FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION, oldOrchestration, newOrchestration);
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
  public void setOrchestration(Orchestration newOrchestration) {
    if (newOrchestration != orchestration) {
      NotificationChain msgs = null;
      if (orchestration != null)
        msgs = ((InternalEObject) orchestration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
            - FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION, null, msgs);
      if (newOrchestration != null)
        msgs = ((InternalEObject) newOrchestration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
            - FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION, null, msgs);
      msgs = basicSetOrchestration(newOrchestration, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION, newOrchestration,
          newOrchestration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINTS:
      return ((InternalEList<?>) getViewpoints()).basicRemove(otherEnd, msgs);
    case FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION:
      return basicSetOrchestration(null, msgs);
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
    case FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINTS:
      return getViewpoints();
    case FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION:
      return getOrchestration();
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
    case FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINTS:
      getViewpoints().clear();
      getViewpoints().addAll((Collection<? extends Viewpoint>) newValue);
      return;
    case FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION:
      setOrchestration((Orchestration) newValue);
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
    case FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINTS:
      getViewpoints().clear();
      return;
    case FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION:
      setOrchestration((Orchestration) null);
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
    case FactoryComponentPackage.FACTORY_COMPONENT__VIEWPOINTS:
      return viewpoints != null && !viewpoints.isEmpty();
    case FactoryComponentPackage.FACTORY_COMPONENT__ORCHESTRATION:
      return orchestration != null;
    }
    return super.eIsSet(featureID);
  }

} //FactoryComponentImpl
