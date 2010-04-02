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
package org.eclipse.egf.model.types.impl;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.helper.JavaHelper;
import org.eclipse.egf.model.EGFModelPlugin;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TypeClassImpl extends TypeAbstractClassImpl implements TypeClass {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeClassImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TypesPackage.Literals.TYPE_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  @SuppressWarnings("unchecked")
  public Class<?> getType() {
    if (getValue() != null && getValue().trim().length() != 0) {
      try {
        return Class.forName(getValue().trim());
      } catch (Throwable t) {
        IJavaProject javaProject = EMFHelper.getJavaProject(eResource());
        if (javaProject == null) {
          EGFModelPlugin.getPlugin().logError(t);
          return null;
        }
        try {
          JavaHelper.getProjectClassLoader(javaProject).loadClass(getValue().trim());
        } catch (Throwable w) {
          EGFModelPlugin.getPlugin().logError(w);
        } finally {
          try {
            javaProject.close();
          } catch (JavaModelException jme) {
            EGFModelPlugin.getPlugin().logError(jme);
          }
        }
      }
    }
    return null;
  }

} // TypeClassImpl
