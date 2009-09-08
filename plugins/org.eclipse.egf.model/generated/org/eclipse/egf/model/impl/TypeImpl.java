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

import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.Type;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.TypeImpl#getTypeHolderClassName <em>Type Holder Class Name</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.TypeImpl#getTypeHolder <em>Type Holder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeImpl extends NamedModelElementWithIdImpl implements Type {
  /**
   * The default value of the '{@link #getTypeHolderClassName() <em>Type Holder Class Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getTypeHolderClassName()
   * @generated
   * @ordered
   */
  protected static final String TYPE_HOLDER_CLASS_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeHolderClassName() <em>Type Holder Class Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getTypeHolderClassName()
   * @generated
   * @ordered
   */
  protected String typeHolderClassName = TYPE_HOLDER_CLASS_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getTypeHolder() <em>Type Holder</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getTypeHolder()
   * @generated
   * @ordered
   */
  protected static final Object TYPE_HOLDER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeHolder() <em>Type Holder</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getTypeHolder()
   * @generated
   * @ordered
   */
  protected Object typeHolder = TYPE_HOLDER_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected TypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.TYPE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getTypeHolderClassName() {
    return typeHolderClassName;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setTypeHolderClassName(String newTypeHolderClassName) {
    String oldTypeHolderClassName = typeHolderClassName;
    typeHolderClassName = newTypeHolderClassName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TYPE__TYPE_HOLDER_CLASS_NAME, oldTypeHolderClassName, typeHolderClassName));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Object getTypeHolder() {
    return typeHolder;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setTypeHolder(Object newTypeHolder) {
    Object oldTypeHolder = typeHolder;
    typeHolder = newTypeHolder;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TYPE__TYPE_HOLDER, oldTypeHolder, typeHolder));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackage.TYPE__TYPE_HOLDER_CLASS_NAME:
        return getTypeHolderClassName();
      case ModelPackage.TYPE__TYPE_HOLDER:
        return getTypeHolder();
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
      case ModelPackage.TYPE__TYPE_HOLDER_CLASS_NAME:
        setTypeHolderClassName((String)newValue);
        return;
      case ModelPackage.TYPE__TYPE_HOLDER:
        setTypeHolder(newValue);
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
      case ModelPackage.TYPE__TYPE_HOLDER_CLASS_NAME:
        setTypeHolderClassName(TYPE_HOLDER_CLASS_NAME_EDEFAULT);
        return;
      case ModelPackage.TYPE__TYPE_HOLDER:
        setTypeHolder(TYPE_HOLDER_EDEFAULT);
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
      case ModelPackage.TYPE__TYPE_HOLDER_CLASS_NAME:
        return TYPE_HOLDER_CLASS_NAME_EDEFAULT == null ? typeHolderClassName != null : !TYPE_HOLDER_CLASS_NAME_EDEFAULT.equals(typeHolderClassName);
      case ModelPackage.TYPE__TYPE_HOLDER:
        return TYPE_HOLDER_EDEFAULT == null ? typeHolder != null : !TYPE_HOLDER_EDEFAULT.equals(typeHolder);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (typeHolderClassName: "); //$NON-NLS-1$
    result.append(typeHolderClassName);
    result.append(", typeHolder: "); //$NON-NLS-1$
    result.append(typeHolder);
    result.append(')');
    return result.toString();
  }

} // TypeImpl
