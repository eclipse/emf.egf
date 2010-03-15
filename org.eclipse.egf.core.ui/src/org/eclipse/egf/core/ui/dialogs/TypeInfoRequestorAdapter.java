/**
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 */
package org.eclipse.egf.core.ui.dialogs;

import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.ui.dialogs.ITypeInfoRequestor;

public class TypeInfoRequestorAdapter implements ITypeInfoRequestor {

  private IType _type;

  public void setMatch(IType type) {
    _type = type;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jdt.ui.dialogs.ITypeInfoRequestor#getEnclosingName()
   */
  public String getEnclosingName() {
    return Signature.getQualifier(_type.getTypeQualifiedName('.'));
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jdt.ui.dialogs.ITypeInfoRequestor#getModifiers()
   */
  public int getModifiers() {
    try {
      return _type.getFlags();
    } catch (JavaModelException jme) {
      EGFCoreUIPlugin.getDefault().logError(jme);
    }
    return -1;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jdt.ui.dialogs.ITypeInfoRequestor#getPackageName()
   */
  public String getPackageName() {
    return _type.getPackageFragment().getElementName();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jdt.ui.dialogs.ITypeInfoRequestor#getTypeName()
   */
  public String getTypeName() {
    return _type.getElementName();
  }

}
