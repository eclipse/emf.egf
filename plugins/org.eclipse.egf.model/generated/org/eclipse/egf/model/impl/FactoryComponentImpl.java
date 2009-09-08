/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.model.impl;

import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.Factory;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.Specification;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>FactoryComponent</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.FactoryComponentImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.FactoryComponentImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.FactoryComponentImpl#getFactory <em>Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FactoryComponentImpl extends NamedModelElementWithIdImpl implements FactoryComponent {
  /**
   * The cached value of the '{@link #getDomain() <em>Domain</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getDomain()
   * @generated
   * @ordered
   */
  protected Domain domain;

  /**
   * The cached value of the '{@link #getSpecification() <em>Specification</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getSpecification()
   * @generated
   * @ordered
   */
  protected Specification specification;

  /**
   * The cached value of the '{@link #getFactory() <em>Factory</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getFactory()
   * @generated
   * @ordered
   */
  protected Factory factory;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected FactoryComponentImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.FACTORY_COMPONENT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Domain getDomain() {
    return domain;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDomain(Domain newDomain, NotificationChain msgs) {
    Domain oldDomain = domain;
    domain = newDomain;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.FACTORY_COMPONENT__DOMAIN, oldDomain, newDomain);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setDomain(Domain newDomain) {
    if (newDomain != domain) {
      NotificationChain msgs = null;
      if (domain != null)
        msgs = ((InternalEObject)domain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.FACTORY_COMPONENT__DOMAIN, null, msgs);
      if (newDomain != null)
        msgs = ((InternalEObject)newDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.FACTORY_COMPONENT__DOMAIN, null, msgs);
      msgs = basicSetDomain(newDomain, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FACTORY_COMPONENT__DOMAIN, newDomain, newDomain));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Specification getSpecification() {
    return specification;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSpecification(Specification newSpecification, NotificationChain msgs) {
    Specification oldSpecification = specification;
    specification = newSpecification;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.FACTORY_COMPONENT__SPECIFICATION, oldSpecification, newSpecification);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setSpecification(Specification newSpecification) {
    if (newSpecification != specification) {
      NotificationChain msgs = null;
      if (specification != null)
        msgs = ((InternalEObject)specification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.FACTORY_COMPONENT__SPECIFICATION, null, msgs);
      if (newSpecification != null)
        msgs = ((InternalEObject)newSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.FACTORY_COMPONENT__SPECIFICATION, null, msgs);
      msgs = basicSetSpecification(newSpecification, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FACTORY_COMPONENT__SPECIFICATION, newSpecification, newSpecification));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Factory getFactory() {
    return factory;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFactory(Factory newFactory, NotificationChain msgs) {
    Factory oldFactory = factory;
    factory = newFactory;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.FACTORY_COMPONENT__FACTORY, oldFactory, newFactory);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setFactory(Factory newFactory) {
    if (newFactory != factory) {
      NotificationChain msgs = null;
      if (factory != null)
        msgs = ((InternalEObject)factory).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.FACTORY_COMPONENT__FACTORY, null, msgs);
      if (newFactory != null)
        msgs = ((InternalEObject)newFactory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.FACTORY_COMPONENT__FACTORY, null, msgs);
      msgs = basicSetFactory(newFactory, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FACTORY_COMPONENT__FACTORY, newFactory, newFactory));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelPackage.FACTORY_COMPONENT__DOMAIN:
        return basicSetDomain(null, msgs);
      case ModelPackage.FACTORY_COMPONENT__SPECIFICATION:
        return basicSetSpecification(null, msgs);
      case ModelPackage.FACTORY_COMPONENT__FACTORY:
        return basicSetFactory(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackage.FACTORY_COMPONENT__DOMAIN:
        return getDomain();
      case ModelPackage.FACTORY_COMPONENT__SPECIFICATION:
        return getSpecification();
      case ModelPackage.FACTORY_COMPONENT__FACTORY:
        return getFactory();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelPackage.FACTORY_COMPONENT__DOMAIN:
        setDomain((Domain)newValue);
        return;
      case ModelPackage.FACTORY_COMPONENT__SPECIFICATION:
        setSpecification((Specification)newValue);
        return;
      case ModelPackage.FACTORY_COMPONENT__FACTORY:
        setFactory((Factory)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case ModelPackage.FACTORY_COMPONENT__DOMAIN:
        setDomain((Domain)null);
        return;
      case ModelPackage.FACTORY_COMPONENT__SPECIFICATION:
        setSpecification((Specification)null);
        return;
      case ModelPackage.FACTORY_COMPONENT__FACTORY:
        setFactory((Factory)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ModelPackage.FACTORY_COMPONENT__DOMAIN:
        return domain != null;
      case ModelPackage.FACTORY_COMPONENT__SPECIFICATION:
        return specification != null;
      case ModelPackage.FACTORY_COMPONENT__FACTORY:
        return factory != null;
    }
    return super.eIsSet(featureID);
  }

} // FactoryComponentImpl
