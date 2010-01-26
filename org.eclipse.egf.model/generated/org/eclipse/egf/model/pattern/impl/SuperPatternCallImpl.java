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
package org.eclipse.egf.model.pattern.impl;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.SuperPatternCall;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Super Pattern Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SuperPatternCallImpl extends AbstractPatternCallImpl implements SuperPatternCall {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SuperPatternCallImpl() {
    super();
  }

  @Override
  public Pattern getCalled() {
    if (getPattern().getSuperPattern() == null)
      throw new IllegalStateException();
    return getPattern().getSuperPattern();
  }

  @Override
  public void setCalled(Pattern newCalled) {

    throw new IllegalStateException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PatternPackage.Literals.SUPER_PATTERN_CALL;
  }

} // SuperPatternCallImpl
