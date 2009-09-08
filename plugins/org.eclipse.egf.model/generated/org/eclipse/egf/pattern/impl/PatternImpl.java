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
package org.eclipse.egf.pattern.impl;

import java.beans.PropertyChangeListener;
import java.util.Collection;

import org.eclipse.egf.common.helper.PatternHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.PatternPackage;
import org.eclipse.egf.pattern.relations.CallParameter;
import org.eclipse.egf.pattern.relations.ParameterRelation;
import org.eclipse.egf.pattern.relations.ReferenceRelation;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Pattern</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.pattern.impl.PatternImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.egf.pattern.impl.PatternImpl#getShortId <em>Short Id</em>}</li>
 *   <li>{@link org.eclipse.egf.pattern.impl.PatternImpl#getLogicalName <em>Logical Name</em>}</li>
 *   <li>{@link org.eclipse.egf.pattern.impl.PatternImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.egf.pattern.impl.PatternImpl#getRelations <em>Relations</em>}</li>
 *   <li>{@link org.eclipse.egf.pattern.impl.PatternImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.egf.pattern.impl.PatternImpl#getCallParameters <em>Call Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternImpl extends EClassImpl implements Pattern {
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
   * The default value of the '{@link #getShortId() <em>Short Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortId()
   * @generated
   * @ordered
   */
  protected static final String SHORT_ID_EDEFAULT = null;

  /**
   * The default value of the '{@link #getLogicalName() <em>Logical Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogicalName()
   * @generated
   * @ordered
   */
  protected static final String LOGICAL_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLogicalName() <em>Logical Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogicalName()
   * @generated
   * @ordered
   */
  protected String logicalName = LOGICAL_NAME_EDEFAULT;

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
   * The cached value of the '{@link #getRelations() <em>Relations</em>}' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getRelations()
   * @generated
   * @ordered
   */
  protected EList<ReferenceRelation> relations;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<ParameterRelation> parameters;

  /**
   * The cached value of the '{@link #getCallParameters() <em>Call Parameters</em>}' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getCallParameters()
   * @generated
   * @ordered
   */
  protected EList<CallParameter> callParameters;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected PatternImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PatternPackage.Literals.PATTERN;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getId() {
    return id;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId) {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String getShortId() {
    Couple<String, String> couple = PatternHelper.deresolveId(getId());
    if (couple != null) {
      return couple.getValue();
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLogicalName() {
    return logicalName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLogicalName(String newLogicalName) {
    String oldLogicalName = logicalName;
    logicalName = newLogicalName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__LOGICAL_NAME, oldLogicalName, logicalName));
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
      eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<ReferenceRelation> getRelations() {
    if (relations == null) {
      relations = new EObjectContainmentEList<ReferenceRelation>(ReferenceRelation.class, this, PatternPackage.PATTERN__RELATIONS);
    }
    return relations;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterRelation> getParameters() {
    if (parameters == null) {
      parameters = new EObjectContainmentEList<ParameterRelation>(ParameterRelation.class, this, PatternPackage.PATTERN__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<CallParameter> getCallParameters() {
    if (callParameters == null) {
      callParameters = new EObjectContainmentEList<CallParameter>(CallParameter.class, this, PatternPackage.PATTERN__CALL_PARAMETERS);
    }
    return callParameters;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String produce(Object classLoader_p) {
    StringBuilder stringBuilder = new StringBuilder(generateHeader());
    stringBuilder.append(generate(classLoader_p));
    stringBuilder.append(generateFooter());
    return stringBuilder.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String generate(Object classLoader_p) {
    StringBuilder stringBuilder = new StringBuilder(generatePreMatching());
    stringBuilder.append(generateBody(classLoader_p));
    stringBuilder.append(generatePostMatching());
    return stringBuilder.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void addPropertyChangeListener(String propertyName_p, PropertyChangeListener listener_p) {
    // Avoid the JFace data-binding not very nice error message.
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void removePropertyChangeListener(String propertyName_p, PropertyChangeListener listener_p) {
    // Avoid the JFace data-binding not very nice error message.
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String generateBody(Object classLoader_p) {
    return org.eclipse.egf.common.constant.ICommonConstants.EMPTY_STRING;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String generateHeader() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String generateFooter() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String generatePreMatching() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String generatePostMatching() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case PatternPackage.PATTERN__RELATIONS:
        return ((InternalEList<?>)getRelations()).basicRemove(otherEnd, msgs);
      case PatternPackage.PATTERN__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case PatternPackage.PATTERN__CALL_PARAMETERS:
        return ((InternalEList<?>)getCallParameters()).basicRemove(otherEnd, msgs);
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
      case PatternPackage.PATTERN__ID:
        return getId();
      case PatternPackage.PATTERN__SHORT_ID:
        return getShortId();
      case PatternPackage.PATTERN__LOGICAL_NAME:
        return getLogicalName();
      case PatternPackage.PATTERN__DESCRIPTION:
        return getDescription();
      case PatternPackage.PATTERN__RELATIONS:
        return getRelations();
      case PatternPackage.PATTERN__PARAMETERS:
        return getParameters();
      case PatternPackage.PATTERN__CALL_PARAMETERS:
        return getCallParameters();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case PatternPackage.PATTERN__ID:
        setId((String)newValue);
        return;
      case PatternPackage.PATTERN__LOGICAL_NAME:
        setLogicalName((String)newValue);
        return;
      case PatternPackage.PATTERN__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case PatternPackage.PATTERN__RELATIONS:
        getRelations().clear();
        getRelations().addAll((Collection<? extends ReferenceRelation>)newValue);
        return;
      case PatternPackage.PATTERN__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends ParameterRelation>)newValue);
        return;
      case PatternPackage.PATTERN__CALL_PARAMETERS:
        getCallParameters().clear();
        getCallParameters().addAll((Collection<? extends CallParameter>)newValue);
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
      case PatternPackage.PATTERN__ID:
        setId(ID_EDEFAULT);
        return;
      case PatternPackage.PATTERN__LOGICAL_NAME:
        setLogicalName(LOGICAL_NAME_EDEFAULT);
        return;
      case PatternPackage.PATTERN__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case PatternPackage.PATTERN__RELATIONS:
        getRelations().clear();
        return;
      case PatternPackage.PATTERN__PARAMETERS:
        getParameters().clear();
        return;
      case PatternPackage.PATTERN__CALL_PARAMETERS:
        getCallParameters().clear();
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
      case PatternPackage.PATTERN__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case PatternPackage.PATTERN__SHORT_ID:
        return SHORT_ID_EDEFAULT == null ? getShortId() != null : !SHORT_ID_EDEFAULT.equals(getShortId());
      case PatternPackage.PATTERN__LOGICAL_NAME:
        return LOGICAL_NAME_EDEFAULT == null ? logicalName != null : !LOGICAL_NAME_EDEFAULT.equals(logicalName);
      case PatternPackage.PATTERN__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case PatternPackage.PATTERN__RELATIONS:
        return relations != null && !relations.isEmpty();
      case PatternPackage.PATTERN__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case PatternPackage.PATTERN__CALL_PARAMETERS:
        return callParameters != null && !callParameters.isEmpty();
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
    result.append(", logicalName: "); //$NON-NLS-1$
    result.append(logicalName);
    result.append(", description: "); //$NON-NLS-1$
    result.append(description);
    result.append(')');
    return result.toString();
  }

} // PatternImpl
