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

import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.internal.data.ModelElement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Named Model Element With Id</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.NamedModelElementWithIdImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.NamedModelElementWithIdImpl#getJavaIdentifier <em>Java Identifier</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.NamedModelElementWithIdImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.NamedModelElementWithIdImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NamedModelElementWithIdImpl extends ModelElement implements NamedModelElementWithId {
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getJavaIdentifier() <em>Java Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaIdentifier()
   * @generated
   * @ordered
   */
  protected static final String JAVA_IDENTIFIER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getJavaIdentifier() <em>Java Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaIdentifier()
   * @generated
   * @ordered
   */
  protected String javaIdentifier = JAVA_IDENTIFIER_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected NamedModelElementWithIdImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public String getId() {
    // Lazy creation of the business id.
    if (id == null) {
      id = generateId();
    }
    return id;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setId(String newId) {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String getJavaIdentifier() {
    // Lazy creation of the java identifier.
    if (javaIdentifier == null) {
      javaIdentifier = StringHelper.replaceNonWordCharactersWithUnderscore(getId());
    }
    return javaIdentifier;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getDescription() {
    return description;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription) {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__ID:
        return getId();
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER:
        return getJavaIdentifier();
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__NAME:
        return getName();
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION:
        return getDescription();
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
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__ID:
        setId((String)newValue);
        return;
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__NAME:
        setName((String)newValue);
        return;
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION:
        setDescription((String)newValue);
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
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__ID:
        setId(ID_EDEFAULT);
        return;
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
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
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER:
        return JAVA_IDENTIFIER_EDEFAULT == null ? javaIdentifier != null : !JAVA_IDENTIFIER_EDEFAULT.equals(javaIdentifier);
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
    result.append(" (id: "); //$NON-NLS-1$
    result.append(id);
    result.append(", javaIdentifier: "); //$NON-NLS-1$
    result.append(javaIdentifier);
    result.append(", name: "); //$NON-NLS-1$
    result.append(name);
    result.append(", description: "); //$NON-NLS-1$
    result.append(description);
    result.append(')');
    return result.toString();
  }

} // NamedModelElementWithIdImpl
