/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.ui.dialogs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.corext.util.TypeFilter;
import org.eclipse.jdt.ui.dialogs.ITypeInfoFilterExtension;
import org.eclipse.jdt.ui.dialogs.ITypeInfoRequestor;
import org.eclipse.jdt.ui.dialogs.TypeSelectionExtension;

/**
 * @author Xavier Maysonnave
 * 
 */
public class SubTypeSelectionExtension extends TypeSelectionExtension {

  private IJavaProject _javaProject;

  private List<IType> _subTypes = Collections.emptyList();

  public SubTypeSelectionExtension(IType type) throws CoreException {
    try {
      _javaProject = type.getJavaProject();
      IType[] subTypes = type.newTypeHierarchy(_javaProject, new NullProgressMonitor()).getAllSubtypes(type);
      if (subTypes != null) {
        _subTypes = Arrays.asList(subTypes);
      }
    } catch (Throwable t) {
      throw new CoreException(EGFCoreUIPlugin.getDefault().newStatus(IStatus.ERROR, t.getMessage(), t));
    }
  }

  /**
   * Returns the filter extension or <code>null</code> if
   * no additional filtering is required.
   * 
   * @return the additional filter extension
   */
  @Override
  public ITypeInfoFilterExtension getFilterExtension() {
    return new ITypeInfoFilterExtension() {
      public boolean select(ITypeInfoRequestor typeInfoRequestor) {
        // Ignore non public, interface and abstract classes
        if (Flags.isPublic(typeInfoRequestor.getModifiers()) == false || Flags.isInterface(typeInfoRequestor.getModifiers()) || Flags.isAbstract(typeInfoRequestor.getModifiers())) {
          return false;
        }
        // Retrieve IType
        IType type = null;
        try {
          type = _javaProject.findType(typeInfoRequestor.getPackageName() + "." + typeInfoRequestor.getTypeName()); //$NON-NLS-1$
        } catch (JavaModelException jme) {
          EGFCoreUIPlugin.getDefault().logError(jme);
        }
        if (type == null) {
          return false;
        }
        // Check if this type is filtered
        if (TypeFilter.isFiltered(type)) {
          return false;
        }
        // Check whether or not we are a subtypes of type
        return _subTypes.contains(type);
      }
    };
  }
}
