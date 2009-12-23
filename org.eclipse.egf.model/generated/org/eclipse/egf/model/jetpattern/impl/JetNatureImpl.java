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
package org.eclipse.egf.model.jetpattern.impl;

import org.eclipse.egf.model.jetpattern.JetNature;
import org.eclipse.egf.model.jetpattern.JetpatternPackage;

import org.eclipse.egf.model.pattern.impl.PatternNatureImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jet Nature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.jetpattern.impl.JetNatureImpl#isCompileTemplate <em>Compile Template</em>}</li>
 *   <li>{@link org.eclipse.egf.model.jetpattern.impl.JetNatureImpl#getTemplateFilePath <em>Template File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JetNatureImpl extends PatternNatureImpl implements JetNature {
  /**
   * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected int eFlags = 0;

  /**
   * The default value of the '{@link #isCompileTemplate() <em>Compile Template</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCompileTemplate()
   * @generated
   * @ordered
   */
  protected static final boolean COMPILE_TEMPLATE_EDEFAULT = false;

  /**
   * The flag representing the value of the '{@link #isCompileTemplate() <em>Compile Template</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCompileTemplate()
   * @generated
   * @ordered
   */
  protected static final int COMPILE_TEMPLATE_EFLAG = 1 << 0;

  /**
   * The default value of the '{@link #getTemplateFilePath() <em>Template File Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateFilePath()
   * @generated
   * @ordered
   */
  protected static final URI TEMPLATE_FILE_PATH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTemplateFilePath() <em>Template File Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateFilePath()
   * @generated
   * @ordered
   */
  protected URI templateFilePath = TEMPLATE_FILE_PATH_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JetNatureImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return JetpatternPackage.Literals.JET_NATURE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCompileTemplate() {
    return (eFlags & COMPILE_TEMPLATE_EFLAG) != 0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCompileTemplate(boolean newCompileTemplate) {
    boolean oldCompileTemplate = (eFlags & COMPILE_TEMPLATE_EFLAG) != 0;
    if (newCompileTemplate)
      eFlags |= COMPILE_TEMPLATE_EFLAG;
    else
      eFlags &= ~COMPILE_TEMPLATE_EFLAG;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JetpatternPackage.JET_NATURE__COMPILE_TEMPLATE, oldCompileTemplate,
          newCompileTemplate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public URI getTemplateFilePath() {
    return templateFilePath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTemplateFilePath(URI newTemplateFilePath) {
    URI oldTemplateFilePath = templateFilePath;
    templateFilePath = newTemplateFilePath;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JetpatternPackage.JET_NATURE__TEMPLATE_FILE_PATH, oldTemplateFilePath,
          templateFilePath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case JetpatternPackage.JET_NATURE__COMPILE_TEMPLATE:
      return isCompileTemplate();
    case JetpatternPackage.JET_NATURE__TEMPLATE_FILE_PATH:
      return getTemplateFilePath();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case JetpatternPackage.JET_NATURE__COMPILE_TEMPLATE:
      setCompileTemplate((Boolean) newValue);
      return;
    case JetpatternPackage.JET_NATURE__TEMPLATE_FILE_PATH:
      setTemplateFilePath((URI) newValue);
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
    case JetpatternPackage.JET_NATURE__COMPILE_TEMPLATE:
      setCompileTemplate(COMPILE_TEMPLATE_EDEFAULT);
      return;
    case JetpatternPackage.JET_NATURE__TEMPLATE_FILE_PATH:
      setTemplateFilePath(TEMPLATE_FILE_PATH_EDEFAULT);
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
    case JetpatternPackage.JET_NATURE__COMPILE_TEMPLATE:
      return ((eFlags & COMPILE_TEMPLATE_EFLAG) != 0) != COMPILE_TEMPLATE_EDEFAULT;
    case JetpatternPackage.JET_NATURE__TEMPLATE_FILE_PATH:
      return TEMPLATE_FILE_PATH_EDEFAULT == null ? templateFilePath != null : !TEMPLATE_FILE_PATH_EDEFAULT.equals(templateFilePath);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (compileTemplate: "); //$NON-NLS-1$
    result.append((eFlags & COMPILE_TEMPLATE_EFLAG) != 0);
    result.append(", templateFilePath: "); //$NON-NLS-1$
    result.append(templateFilePath);
    result.append(')');
    return result.toString();
  }

} //JetNatureImpl
